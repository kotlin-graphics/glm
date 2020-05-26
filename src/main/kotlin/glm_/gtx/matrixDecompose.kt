package glm_.gtx

import glm_.ext.equal
import glm_.glm.detail
import glm_.glm.epsilonF
import glm_.glm.equal
import glm_.mat4x4.Mat4
import glm_.quat.Quat
import glm_.vec3.Vec3
import glm_.vec4.Vec4
import kotlin.math.sqrt

interface gtxMatrixDecompose {

    /** Decomposes a model matrix to translations, rotation and scale components    */
    fun decompose(modelMatrix: Mat4, scale: Vec3, orientation: Quat, translation: Vec3, skew: Vec3, perspective: Vec4): Boolean {

        val localMatrix = Mat4(modelMatrix)

        // Normalize the matrix.
        if (localMatrix[3, 3].equal(0f, Float.MIN_VALUE)) return false

        for (i in 0..3)
            for (j in 0..3)
                localMatrix[i, j] /= localMatrix[3, 3]

        /*  perspectiveMatrix is used to solve for perspective, but it also provides an easy way to test for singularity
            of the upper 3x3 component.         */
        val perspectiveMatrix = Mat4(localMatrix)

        for (i in 0..2)
            perspectiveMatrix[i, 3] = 0f
        perspectiveMatrix[3, 3] = 1f

        // TODO: Fixme!
        if (equal(perspectiveMatrix.det, 0f, epsilonF)) return false

        // First, isolate perspective.  This is the messiest.
        if (localMatrix[0, 3].equal(0f, Float.MIN_VALUE) || localMatrix[1, 3].equal(0f, Float.MIN_VALUE) || localMatrix[2, 3].equal(0f, Float.MIN_VALUE)) {
            // rightHandSide is the right hand side of the equation.
            val rightHandSide = Vec4(localMatrix[0, 3], localMatrix[1, 3], localMatrix[2, 3], localMatrix[3, 3])

            /*  Solve the equation by inverting PerspectiveMatrix and multiplying rightHandSide by the inverse.
                (This is the easiest way, not necessarily the best.) */
            val inversePerspectiveMatrix = perspectiveMatrix.inverse()  //   inverse(PerspectiveMatrix, inversePerspectiveMatrix);
            val transposedInversePerspectiveMatrix = inversePerspectiveMatrix.transpose()//   transposeMatrix4(inversePerspectiveMatrix, transposedInversePerspectiveMatrix);

            perspective put (transposedInversePerspectiveMatrix * rightHandSide)
            //  v4MulPointByMatrix(rightHandSide, transposedInversePerspectiveMatrix, perspectivePoint);

            // Clear the perspective partition
            localMatrix[0, 3] = 0f
            localMatrix[1, 3] = 0f
            localMatrix[2, 3] = 0f
            localMatrix[3, 3] = 1f
        } else    // No perspective.
            perspective.put(0f, 0f, 0f, 1f)

        // Next take care of translation (easy).
        translation put localMatrix[3]
        localMatrix[3].put(0f, 0f, 0f, localMatrix[3].w)

        val row = Array(3, { Vec3() })

        // Now get scale and shear.
        for (i in 0..2)
            for (j in 0..2)
                row[i][j] = localMatrix[i, j]

        // Compute X scale factor and normalize first row.
        scale.x = row.get(0).length() // v3Length(Row[0]);

        row[0] = detail.scale(row[0], 1f)

        // Compute XY shear factor and make 2nd row orthogonal to 1st.
        skew.z = row[0] dot row[1]
        row[1] = detail.combine(row[1], row[0], 1f, -skew.z)

        // Now, compute Y scale and normalize 2nd row.
        scale.y = row[1].length()
        row[1] = detail.scale(row[1], 1f)
        skew.z /= scale.y

        // Compute XZ and YZ shears, orthogonalize 3rd row.
        skew.y = row[0] dot row[2]
        row[2] = detail.combine(row[2], row[0], 1f, -skew.y)
        skew.x = row[1] dot row[2]
        row[2] = detail.combine(row[2], row[1], 1f, -skew.x)

        // Next, get Z scale and normalize 3rd row.
        scale.z = row[2].length()
        row[2] = detail.scale(row[2], 1f)
        skew.y /= scale.z
        skew.x /= scale.z

        /*  At this point, the matrix (in rows[]) is orthonormal.
            Check for a coordinate system flip.  If the determinant is -1, then negate the matrix and the scaling factors.  */
        val pdum3 = row[1] cross row[2] // v3Cross(row[1], row[2], pdum3);
        if (row[0] dot pdum3 < 0)
            for (i in 0..2) {
                scale[i] *= -1
                row[i] timesAssign -1
            }

        // Now, get the rotations out, as described in the gem.

        /*  FIXME - Add the ability to return either quaternions (which are easier to recompose with) or
            Euler angles (rx, ry, rz), which are easier for authors to deal with. The latter will only be useful when
            we fix https://bugs.webkit.org/show_bug.cgi?id=23799, so I will leave the Euler angle code here for now. */

        // ret.rotateY = asin(-Row[0][2]);
        // if (cos(ret.rotateY) != 0) {
        //     ret.rotateX = atan2(Row[1][2], Row[2][2]);
        //     ret.rotateZ = atan2(Row[0][1], Row[0][0]);
        // } else {
        //     ret.rotateX = atan2(-Row[2][0], Row[1][1]);
        //     ret.rotateZ = 0;
        // }

//        int i, j, k = 0
        val trace = row[0].x + row[1].y + row[2].z
        if (trace > 0f) {
            var root = sqrt(trace + 1f)
            orientation.w = 0.5f * root
            root = 0.5f / root
            orientation.x = root * (row[1].z - row[2].y)
            orientation.y = root * (row[2].x - row[0].z)
            orientation.z = root * (row[0].y - row[1].x)
        } // End if > 0
        else {
            val next = IntArray(3, { it })
            var i = 0
            if (row[1].y > row[0].x) i = 1
            if (row[2].z > row[i][i]) i = 2
            val j = next[i]
            val k = next[j]

            var root = sqrt(row[i][i] - row[j][j] - row[k][k] + 1f)

            orientation[i] = 0.5f * root
            root = 0.5f / root
            orientation[j] = root * (row[i][j] + row[j][i])
            orientation[k] = root * (row[i][k] + row[k][i])
            orientation.w = root * (row[j][k] - row[k][j])
        } // End if <= 0

        return true
    }
}

interface detail_matrixDecompose {

    /** Make a linear combination of two vectors and return the result.
     *  result = (a * ascl) + (b * bscl)    */
    fun combine(a: Vec3, b: Vec3, ascl: Float, bscl: Float) = a * ascl + b * bscl

    fun scale(v: Vec3, desiredLength: Float) = v * desiredLength / v.length()
}