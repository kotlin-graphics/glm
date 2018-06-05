package glm_.gtx

import glm_.mat3x3.Mat3
import glm_.mat4x4.Mat4
import glm_.vec4.operators.times
import glm_.vec3.operators.times


/*  Suggestions:
    - Move helper functions flipUD and flipLR to another file: They may be helpful in more general circumstances.
    - Implement other types of matrix factorisation, such as: QL and LQ, L(D)U, eigendecompositions, etc...*/
interface gtxMatrixFactorization {

    // Mat4 ------------------------------------------------------------------------------------------------------------

    /** Flips the matrix rows up and down.
     *  From GLM_GTX_matrix_factorisation extension. */
    fun flipUD(`in`: Mat4): Mat4 {
        var tin = `in`.transpose()
        tin = flipLR(tin)
        val out = tin.transpose()

        return out
    }
    /** Flips the matrix columns right and left.
     *  From GLM_GTX_matrix_factorisation extension. */
    fun flipLR(`in`: Mat4): Mat4 {
        val out = Mat4()
        for (i in 0..3)
            out[i] = `in`[(4 - i) - 1]
        return out
    }

    /** Performs QR factorisation of a matrix.
     *  Returns 2 matrices, q and r, such that the columns of q are orthonormal and span the same subspace than those of the input matrix,
     *  r is an upper triangular matrix, and q*r=in.
     *  Given an n-by-m input matrix, q has dimensions min(n,m)-by-m, and r has dimensions n-by-min(n,m).
     *  From GLM_GTX_matrix_factorisation extension. */
    fun qrDecompose(q: Mat4, r: Mat4, `in`: Mat4) {

        /*  Uses modified Gram-Schmidt method
            Source: https://en.wikipedia.org/wiki/Gram–Schmidt_process
            And https://en.wikipedia.org/wiki/QR_decomposition

            For all the linearly independs columns of the input...
            (there can be no more linearly independents columns than there are rows.) */
        for (i in 0..3) {
            //Copy in Q the input's i-th column.
            for (j in 0..3)
                q[i, j] = `in`[i, j]

            /*  j = [0,i[
                Make that column orthogonal to all the previous ones by substracting to it the non-orthogonal projection
                of all the previous columns.
                Also: Fill the zero elements of R */
            for (j in 0 until i) {
                q[i] minusAssign ((q[i] dot q[j]) * q[j])
                r[j][i] = 0
            }

            //Now, Q i-th column is orthogonal to all the previous columns. Normalize it.
            q[i].normalizeAssign()

            /*  j = [i,C[
                Finally, compute the corresponding coefficients of R by computing the projection of the resulting column
                on the other columns of the input.             */
            for (j in i..3)
                r[j][i] = `in`[j] dot q[i]
        }
    }
    /** Performs RQ factorisation of a matrix.
     *  Returns 2 matrices, r and q, such that r is an upper triangular matrix, the rows of q are orthonormal and
     *  span the same subspace than those of the input matrix, and r*q=in.
     *  Note that in the context of RQ factorisation, the diagonal is seen as starting in the lower-right corner of the matrix,
     *  instead of the usual upper-left.
     *  Given an n-by-m input matrix, r has dimensions min(n,m)-by-m, and q has dimensions n-by-min(n,m).
     *  From GLM_GTX_matrix_factorisation extension. */
    fun rqDecompose(r: Mat4, q: Mat4, `in`: Mat4) {

        /*  From https://en.wikipedia.org/wiki/QR_decomposition:
            The RQ decomposition transforms a matrix A into the product of an upper triangular matrix R (also known as right-triangular) 
            and an orthogonal matrix Q. The only difference from QR decomposition is the order of these matrices.
            QR decomposition is Gram–Schmidt orthogonalization of columns of A, started from the first column.
            RQ decomposition is Gram–Schmidt orthogonalization of rows of A, started from the last row. */
        
        var tin = `in`.transpose()
        tin = flipLR(tin)

        var tr = Mat4()
        var tq = Mat4()
        qrDecompose(tq, tr, tin)

        tr = flipLR(tr)
        tr.transpose(r)
        r put flipLR(r)

        tq = flipLR(tq)
        tq.transpose(q)
    }

    // Mat3 ------------------------------------------------------------------------------------------------------------

    /** Flips the matrix rows up and down.
     *  From GLM_GTX_matrix_factorisation extension. */
    fun flipUD(`in`: Mat3): Mat3 {
        var tin = `in`.transpose()
        tin = flipLR(tin)
        val out = tin.transpose()

        return out
    }
    /** Flips the matrix columns right and left.
     *  From GLM_GTX_matrix_factorisation extension. */
    fun flipLR(`in`: Mat3): Mat3 {
        val out = Mat3()
        for (i in 0..2)
            out[i] = `in`[(3 - i) - 1]
        return out
    }

    /** Performs QR factorisation of a matrix.
     *  Returns 2 matrices, q and r, such that the columns of q are orthonormal and span the same subspace than those of the input matrix,
     *  r is an upper triangular matrix, and q*r=in.
     *  Given an n-by-m input matrix, q has dimensions min(n,m)-by-m, and r has dimensions n-by-min(n,m).
     *  From GLM_GTX_matrix_factorisation extension. */
    fun qrDecompose(q: Mat3, r: Mat3, `in`: Mat3) {

        /*  Uses modified Gram-Schmidt method
            Source: https://en.wikipedia.org/wiki/Gram–Schmidt_process
            And https://en.wikipedia.org/wiki/QR_decomposition

            For all the linearly independs columns of the input...
            (there can be no more linearly independents columns than there are rows.) */
        for (i in 0..2) {
            //Copy in Q the input's i-th column.
            for (j in 0..2)
                q[i, j] = `in`[i, j]

            /*  j = [0,i[
                Make that column orthogonal to all the previous ones by substracting to it the non-orthogonal projection
                of all the previous columns.
                Also: Fill the zero elements of R */
            for (j in 0 until i) {
                q[i] minusAssign ((q[i] dot q[j]) * q[j])
                r[j][i] = 0
            }

            //Now, Q i-th column is orthogonal to all the previous columns. Normalize it.
            q[i].normalizeAssign()

            /*  j = [i,C[
                Finally, compute the corresponding coefficients of R by computing the projection of the resulting column
                on the other columns of the input.             */
            for (j in i..2)
                r[j][i] = `in`[j] dot q[i]
        }
    }
    /** Performs RQ factorisation of a matrix.
     *  Returns 2 matrices, r and q, such that r is an upper triangular matrix, the rows of q are orthonormal and
     *  span the same subspace than those of the input matrix, and r*q=in.
     *  Note that in the context of RQ factorisation, the diagonal is seen as starting in the lower-right corner of the matrix,
     *  instead of the usual upper-left.
     *  Given an n-by-m input matrix, r has dimensions min(n,m)-by-m, and q has dimensions n-by-min(n,m).
     *  From GLM_GTX_matrix_factorisation extension. */
    fun rqDecompose(r: Mat3, q: Mat3, `in`: Mat3) {

        /*  From https://en.wikipedia.org/wiki/QR_decomposition:
            The RQ decomposition transforms a matrix A into the product of an upper triangular matrix R (also known as right-triangular)
            and an orthogonal matrix Q. The only difference from QR decomposition is the order of these matrices.
            QR decomposition is Gram–Schmidt orthogonalization of columns of A, started from the first column.
            RQ decomposition is Gram–Schmidt orthogonalization of rows of A, started from the last row. */

        var tin = `in`.transpose()
        tin = flipLR(tin)

        var tr = Mat3()
        var tq = Mat3()
        qrDecompose(tq, tr, tin)

        tr = flipLR(tr)
        tr.transpose(r)
        r put flipLR(r)

        tq = flipLR(tq)
        tq.transpose(q)
    }
}