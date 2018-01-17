//package glm_.gtx
//
//import glm_.glm
//import glm_.glm.epsilonEqual
//import glm_.glm.epsilonF
//import glm_.mat4x4.Mat4
//import glm_.quat.Quat
//import glm_.vec3.Vec3
//import glm_.vec4.Vec4
//
//interface matrixDecompose {
//
//    /** Decomposes a model matrix to translations, rotation and scale components    */
//    fun decompose(modelMatrix: Mat4, scale: Vec3, orientation: Quat, translation: Vec3, skew: Vec3, perspective: Vec4): Boolean {
//
//        val localMatrix = Mat4(modelMatrix)
//
//        // Normalize the matrix.
//        if (localMatrix[3, 3] epsilonEqual 0f) return false
//
//        for (i in 0..3)
//            for (j in 0..3)
//                localMatrix[i, j] /= localMatrix[3, 3]
//
//        /*  perspectiveMatrix is used to solve for perspective, but it also provides an easy way to test for singularity
//            of the upper 3x3 component.         */
//        val perspectiveMatrix = Mat4(localMatrix)
//
//        for (i in 0..2)
//            perspectiveMatrix[i, 3] = 0f
//        perspectiveMatrix[3, 3] = 1f
//
//        // TODO: Fixme!
//        if (epsilonEqual(perspectiveMatrix.det, 0f, epsilonF)) return false
//
//        // First, isolate perspective.  This is the messiest.
//        if (localMatrix[0, 3] epsilonEqual 0f || localMatrix[1, 3] epsilonEqual 0f || localMatrix[2, 3] epsilonEqual 0f) {
//            // rightHandSide is the right hand side of the equation.
//            val rightHandSide = Vec4(localMatrix[0, 3], localMatrix[1, 3], localMatrix[2, 3], localMatrix[3, 3])
//
//            /*  Solve the equation by inverting PerspectiveMatrix and multiplying rightHandSide by the inverse.
//                (This is the easiest way, not necessarily the best.) */
//            val inversePerspectiveMatrix = perspectiveMatrix.inverse()  //   inverse(PerspectiveMatrix, inversePerspectiveMatrix);
//            val transposedInversePerspectiveMatrix = inversePerspectiveMatrix.transpose()//   transposeMatrix4(inversePerspectiveMatrix, transposedInversePerspectiveMatrix);
//
//            perspective put (transposedInversePerspectiveMatrix * rightHandSide)
//            //  v4MulPointByMatrix(rightHandSide, transposedInversePerspectiveMatrix, perspectivePoint);
//
//            // Clear the perspective partition
//            localMatrix[0, 3] = 0f
//            localMatrix[1, 3] = 0f
//            localMatrix[2, 3] = 0f
//            localMatrix[3, 3] = 1f
//        } else    // No perspective.
//            perspective.put(0f, 0f, 0f, 1f)
//
//        // Next take care of translation (easy).
//        translation put localMatrix[3]
//        localMatrix[3].put(0f, 0f, 0f, localMatrix[3].w)
//
//        val row = Array(3, { Vec3() })
////        Pdum3
//
//        // Now get scale and shear.
//        for (i in 0..2)
//            for (j in 0..2)
//                row[i][j] = localMatrix[i, j]
//
//        // Compute X scale factor and normalize first row.
//        scale.x = row.get(0).length // v3Length(Row[0]);
//
//        row[0] = detail::scale(Row[0], static_cast<T>(1))
//
//        // Compute XY shear factor and make 2nd row orthogonal to 1st.
//        Skew.z = dot(Row[0], Row[1])
//        Row[1] = detail::combine(Row[1], Row[0], static_cast<T>(1), -Skew.z)
//
//        // Now, compute Y scale and normalize 2nd row.
//        Scale.y = length(Row[1])
//        Row[1] = detail::scale(Row[1], static_cast<T>(1))
//        Skew.z /= Scale.y
//
//        // Compute XZ and YZ shears, orthogonalize 3rd row.
//        Skew.y = glm::dot(Row[0], Row[2])
//        Row[2] = detail::combine(Row[2], Row[0], static_cast<T>(1), -Skew.y)
//        Skew.x = glm::dot(Row[1], Row[2])
//        Row[2] = detail::combine(Row[2], Row[1], static_cast<T>(1), -Skew.x)
//
//        // Next, get Z scale and normalize 3rd row.
//        Scale.z = length(Row[2])
//        Row[2] = detail::scale(Row[2], static_cast<T>(1))
//        Skew.y /= Scale.z
//        Skew.x /= Scale.z
//
//        // At this point, the matrix (in rows[]) is orthonormal.
//        // Check for a coordinate system flip.  If the determinant
//        // is -1, then negate the matrix and the scaling factors.
//        Pdum3 = cross(Row[1], Row[2]) // v3Cross(row[1], row[2], Pdum3);
//        if (dot(Row[0], Pdum3) < 0) {
//            for (length_t i = 0; i < 3; i++)
//            {
//                Scale[i] *= static_cast<T>(-1)
//                Row[i] *= static_cast<T>(-1)
//            }
//        }
//
//        // Now, get the rotations out, as described in the gem.
//
//        // FIXME - Add the ability to return either quaternions (which are
//        // easier to recompose with) or Euler angles (rx, ry, rz), which
//        // are easier for authors to deal with. The latter will only be useful
//        // when we fix https://bugs.webkit.org/show_bug.cgi?id=23799, so I
//        // will leave the Euler angle code here for now.
//
//        // ret.rotateY = asin(-Row[0][2]);
//        // if (cos(ret.rotateY) != 0) {
//        //     ret.rotateX = atan2(Row[1][2], Row[2][2]);
//        //     ret.rotateZ = atan2(Row[0][1], Row[0][0]);
//        // } else {
//        //     ret.rotateX = atan2(-Row[2][0], Row[1][1]);
//        //     ret.rotateZ = 0;
//        // }
//
//        int i, j, k = 0
//        float root, trace = Row[0].x+Row[1].y+Row[2].z
//        if (trace > static_cast<T>(0)) {
//            root = sqrt(trace + static_cast<T>(1.0))
//            Orientation.w = static_cast<T>(0.5) * root
//            root = static_cast<T>(0.5) / root
//            Orientation.x = root * (Row[1].z - Row[2].y)
//            Orientation.y = root * (Row[2].x - Row[0].z)
//            Orientation.z = root * (Row[0].y - Row[1].x)
//        } // End if > 0
//        else {
//            static int Next[3] = { 1, 2, 0 }
//            i = 0
//            if (Row[1].y > Row[0].x) i = 1
//            if (Row[2].z > Row[i][i]) i = 2
//            j = Next[i]
//            k = Next[j]
//
//            root = sqrt(Row[i][i] - Row[j][j] - Row[k][k] + static_cast<T>(1.0))
//
//            Orientation[i] = static_cast<T>(0.5) * root
//            root = static_cast<T>(0.5) / root
//            Orientation[j] = root * (Row[i][j] + Row[j][i])
//            Orientation[k] = root * (Row[i][k] + Row[k][i])
//            Orientation.w = root * (Row[j][k] - Row[k][j])
//        } // End if <= 0
//
//        return true
//    }
//}