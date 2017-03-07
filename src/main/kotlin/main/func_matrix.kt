package main

import mat.Mat2x2
import mat.Mat3x3
import mat.Mat4x4
import vec._2.Vec2
import vec._3.Vec3
import vec._4.Vec4

/**
 * Created by GBarbieri on 15.12.2016.
 */

interface func_matrix {


    fun transpose(m: Mat2x2, res: Mat2x2 = Mat2x2()): Mat2x2 {

        val v00 = m[0][0]
        val v01 = m[1][0]

        val v10 = m[0][1]
        val v11 = m[1][1]

        res[0][0] = v00
        res[0][1] = v01

        res[1][0] = v10
        res[1][1] = v11

        return res
    }

    fun transpose(m: Mat3x3, res: Mat3x3 = Mat3x3()): Mat3x3 {

        val v00 = m[0][0]
        val v01 = m[1][0]
        val v02 = m[2][0]

        val v10 = m[0][1]
        val v11 = m[1][1]
        val v12 = m[2][1]

        val v20 = m[0][2]
        val v21 = m[1][2]
        val v22 = m[2][2]

        res[0][0] = v00
        res[0][1] = v01
        res[0][2] = v02

        res[1][0] = v10
        res[1][1] = v11
        res[1][2] = v12

        res[2][0] = v20
        res[2][1] = v21
        res[2][2] = v22

        return res
    }

    fun transpose(m: Mat4x4, res: Mat4x4 = Mat4x4()): Mat4x4 {

        val v00 = m[0][0]
        val v01 = m[1][0]
        val v02 = m[2][0]
        val v03 = m[3][0]

        val v10 = m[0][1]
        val v11 = m[1][1]
        val v12 = m[2][1]
        val v13 = m[3][1]

        val v20 = m[0][2]
        val v21 = m[1][2]
        val v22 = m[2][2]
        val v23 = m[3][2]

        val v30 = m[0][3]
        val v31 = m[1][3]
        val v32 = m[2][3]
        val v33 = m[3][3]

        res[0][0] = v00
        res[0][1] = v01
        res[0][2] = v02
        res[0][3] = v03

        res[1][0] = v10
        res[1][1] = v11
        res[1][2] = v12
        res[1][3] = v13

        res[2][0] = v20
        res[2][1] = v21
        res[2][2] = v22
        res[2][3] = v23

        res[3][0] = v30
        res[3][1] = v31
        res[3][2] = v32
        res[3][3] = v33

        return res
    }


    fun determinant(m: Mat2x2) = m[0][0] * m[1][1] - m[1][0] * m[0][1]

    fun determinant(m: Mat3x3) = m[0][0] * (m[1][1] * m[2][2] - m[2][1] * m[1][2]) -
            m[1][0] * (m[0][1] * m[2][2] - m[2][1] * m[0][2]) +
            m[2][0] * (m[0][1] * m[1][2] - m[1][1] * m[0][2])

    fun determinant(m: Mat4x4): Float {

        val sf00 = m[2][2] * m[3][3] - m[3][2] * m[2][3]
        val sf01 = m[2][1] * m[3][3] - m[3][1] * m[2][3]
        val sf02 = m[2][1] * m[3][2] - m[3][1] * m[2][2]
        val sf03 = m[2][0] * m[3][3] - m[3][0] * m[2][3]
        val sf04 = m[2][0] * m[3][2] - m[3][0] * m[2][2]
        val sf05 = m[2][0] * m[3][1] - m[3][0] * m[2][1]

        val dcX = +(m[1][1] * sf00 - m[1][2] * sf01 + m[1][3] * sf02)
        val dcY = -(m[1][0] * sf00 - m[1][2] * sf03 + m[1][3] * sf04)
        val dcZ = +(m[1][0] * sf01 - m[1][1] * sf03 + m[1][3] * sf05)
        val dcW = -(m[1][0] * sf02 - m[1][1] * sf04 + m[1][2] * sf05)

        return m[0][0] * dcX + m[0][1] * dcY + m[0][2] * dcZ + m[0][3] * dcW
    }


    fun inverse(m: Mat2x2, res: Mat2x2 = Mat2x2()): Mat2x2 {

        val oneOverDet = 1 / m.det()

        res[0][0] = +m[1][1] * oneOverDet
        res[0][1] = -m[0][1] * oneOverDet
        res[1][0] = -m[1][0] * oneOverDet
        res[1][1] = +m[0][0] * oneOverDet

        return res
    }

    fun inverse(m: Mat3x3, res: Mat3x3 = Mat3x3()): Mat3x3 {

        val oneOverDet = 1 / m.det()

        m[0][0] = +(m[1][1] * m[2][2] - m[2][1] * m[1][2]) * oneOverDet
        m[1][0] = -(m[1][0] * m[2][2] - m[2][0] * m[1][2]) * oneOverDet
        m[2][0] = +(m[1][0] * m[2][1] - m[2][0] * m[1][1]) * oneOverDet
        m[0][1] = -(m[0][1] * m[2][2] - m[2][1] * m[0][2]) * oneOverDet
        m[1][1] = +(m[0][0] * m[2][2] - m[2][0] * m[0][2]) * oneOverDet
        m[2][1] = -(m[0][0] * m[2][1] - m[2][0] * m[0][1]) * oneOverDet
        m[0][2] = +(m[0][1] * m[1][2] - m[1][1] * m[0][2]) * oneOverDet
        m[1][2] = -(m[0][0] * m[1][2] - m[1][0] * m[0][2]) * oneOverDet
        m[2][2] = +(m[0][0] * m[1][1] - m[1][0] * m[0][1]) * oneOverDet

        return res
    }

    fun inverse(m: Mat4x4, res: Mat4x4 = Mat4x4()): Mat4x4 {

        val c00 = m[2][2] * m[3][3] - m[3][2] * m[2][3]
        val c02 = m[1][2] * m[3][3] - m[3][2] * m[1][3]
        val c03 = m[1][2] * m[2][3] - m[2][2] * m[1][3]

        val c04 = m[2][1] * m[3][3] - m[3][1] * m[2][3]
        val c06 = m[1][1] * m[3][3] - m[3][1] * m[1][3]
        val c07 = m[1][1] * m[2][3] - m[2][1] * m[1][3]

        val c08 = m[2][1] * m[3][2] - m[3][1] * m[2][2]
        val c10 = m[1][1] * m[3][2] - m[3][1] * m[1][2]
        val c11 = m[1][1] * m[2][2] - m[2][1] * m[1][2]

        val c12 = m[2][0] * m[3][3] - m[3][0] * m[2][3]
        val c14 = m[1][0] * m[3][3] - m[3][0] * m[1][3]
        val c15 = m[1][0] * m[2][3] - m[2][0] * m[1][3]

        val c16 = m[2][0] * m[3][2] - m[3][0] * m[2][2]
        val c18 = m[1][0] * m[3][2] - m[3][0] * m[1][2]
        val c19 = m[1][0] * m[2][2] - m[2][0] * m[1][2]

        val c20 = m[2][0] * m[3][1] - m[3][0] * m[2][1]
        val c22 = m[1][0] * m[3][1] - m[3][0] * m[1][1]
        val c23 = m[1][0] * m[2][1] - m[2][0] * m[1][1]

        val i00 = +(m[1][1] * c00 - m[1][2] * c04 + m[1][3] * c08)
        val i01 = -(m[0][1] * c00 - m[0][2] * c04 + m[0][3] * c08)
        val i02 = +(m[0][1] * c02 - m[0][2] * c06 + m[0][3] * c10)
        val i03 = -(m[0][1] * c03 - m[0][2] * c07 + m[0][3] * c11)

        val i10 = -(m[1][0] * c00 - m[1][2] * c12 + m[1][3] * c16)
        val i11 = +(m[0][0] * c00 - m[0][2] * c12 + m[0][3] * c16)
        val i12 = -(m[0][0] * c02 - m[0][2] * c14 + m[0][3] * c18)
        val i13 = +(m[0][0] * c03 - m[0][2] * c15 + m[0][3] * c19)

        val i20 = +(m[1][0] * c04 - m[1][1] * c12 + m[1][3] * c20)
        val i21 = -(m[0][0] * c04 - m[0][1] * c12 + m[0][3] * c20)
        val i22 = +(m[0][0] * c06 - m[0][1] * c14 + m[0][3] * c22)
        val i23 = -(m[0][0] * c07 - m[0][1] * c15 + m[0][3] * c23)

        val i30 = -(m[1][0] * c08 - m[1][1] * c16 + m[1][2] * c20)
        val i31 = +(m[0][0] * c08 - m[0][1] * c16 + m[0][2] * c20)
        val i32 = -(m[0][0] * c10 - m[0][1] * c18 + m[0][2] * c22)
        val i33 = +(m[0][0] * c11 - m[0][1] * c19 + m[0][2] * c23)

        val oneOverDet = 1 / (m[0][0] * i00 + m[0][1] * i10 + m[0][2] * i20 + m[0][3] * i30)

        res[0][0] = i00 * oneOverDet
        res[0][1] = i01 * oneOverDet
        res[0][2] = i02 * oneOverDet
        res[0][3] = i03 * oneOverDet

        res[1][0] = i10 * oneOverDet
        res[1][1] = i11 * oneOverDet
        res[1][2] = i12 * oneOverDet
        res[1][3] = i13 * oneOverDet

        res[2][0] = i20 * oneOverDet
        res[2][1] = i21 * oneOverDet
        res[2][2] = i22 * oneOverDet
        res[2][3] = i23 * oneOverDet

        res[3][0] = i30 * oneOverDet
        res[3][1] = i31 * oneOverDet
        res[3][2] = i32 * oneOverDet
        res[3][3] = i33 * oneOverDet

        return res
    }


    /**
     * Multiply matrix x by matrix y component-wise, main.getI.e.,
     */
    fun matrixCompMult(a: Mat2x2, b: Mat2x2, res: Mat2x2 = Mat2x2()): Mat2x2 {

        res[0][0] = a[0][0] * b[0][0]
        res[0][1] = a[0][1] * b[0][1]

        res[1][0] = a[1][0] * b[1][0]
        res[1][1] = a[1][1] * b[1][1]

        return res
    }

    /**
     * Multiply matrix x by matrix y component-wise, main.getI.e.,
     */
    fun matrixCompMult(a: Mat3x3, b: Mat3x3, res: Mat3x3 = Mat3x3()): Mat3x3 {

        res[0][0] = a[0][0] * b[0][0]
        res[0][1] = a[0][1] * b[0][1]
        res[0][2] = a[0][2] * b[0][2]

        res[1][0] = a[1][0] * b[1][0]
        res[1][1] = a[1][1] * b[1][1]
        res[1][2] = a[1][2] * b[1][2]

        res[2][0] = a[2][0] * b[2][0]
        res[2][1] = a[2][1] * b[2][1]
        res[2][2] = a[2][2] * b[2][2]

        return res
    }

    /**
     * Multiply matrix x by matrix y component-wise, main.getI.e.,
     */
    fun matrixCompMult(a: Mat4x4, b: Mat4x4, res: Mat4x4 = Mat4x4()): Mat4x4 {

        res[0][0] = a[0][0] * b[0][0]
        res[0][1] = a[0][1] * b[0][1]
        res[0][2] = a[0][2] * b[0][2]
        res[0][3] = a[0][3] * b[0][3]

        res[1][0] = a[1][0] * b[1][0]
        res[1][1] = a[1][1] * b[1][1]
        res[1][2] = a[1][2] * b[1][2]
        res[1][3] = a[1][3] * b[1][3]

        res[2][0] = a[2][0] * b[2][0]
        res[2][1] = a[2][1] * b[2][1]
        res[2][2] = a[2][2] * b[2][2]
        res[2][3] = a[2][3] * b[2][3]

        res[3][0] = a[3][0] * b[3][0]
        res[3][1] = a[3][1] * b[3][1]
        res[3][2] = a[3][2] * b[3][2]
        res[3][3] = a[3][3] * b[3][3]

        return res
    }


    /**
     * Treats the first parameter c as a column vector main.and the second parameter r as a row vector main.and does a linear
     * algebraic matrix multiply c * r.
     */
    fun outerProduct(c: Vec2, r: Vec2, res: Mat2x2 = Mat2x2()): Mat2x2 {

        res[0].x = c.x * r[0]
        res[0].y = c.y * r[0]

        res[1].x = c.x * r[1]
        res[1].y = c.y * r[1]

        return res
    }

    /**
     * Treats the first parameter c as a column vector main.and the second parameter r as a row vector main.and does a linear
     * algebraic matrix multiply c * r.
     */
    fun outerProduct(c: Vec3, r: Vec3, res: Mat3x3 = Mat3x3()): Mat3x3 {

        res[0].x = c.x * r[0]
        res[0].y = c.y * r[0]
        res[0].z = c.z * r[0]

        res[1].x = c.x * r[1]
        res[1].y = c.y * r[1]
        res[1].z = c.z * r[1]

        res[2].x = c.x * r[2]
        res[2].y = c.y * r[2]
        res[2].z = c.z * r[2]

        return res
    }

    /**
     * Treats the first parameter c as a column vector main.and the second parameter r as a row vector main.and does a linear
     * algebraic matrix multiply c * r.
     */
    fun outerProduct(c: Vec4, r: Vec4, res: Mat4x4 = Mat4x4()): Mat4x4 {

        res[0].x = c.x * r[0]
        res[0].y = c.y * r[0]
        res[0].z = c.z * r[0]
        res[0].w = c.w * r[0]

        res[1].x = c.x * r[1]
        res[1].y = c.y * r[1]
        res[1].z = c.z * r[1]
        res[1].w = c.w * r[1]

        res[2].x = c.x * r[2]
        res[2].y = c.y * r[2]
        res[2].z = c.z * r[2]
        res[2].w = c.w * r[2]

        res[3].x = c.x * r[3]
        res[3].y = c.y * r[3]
        res[3].z = c.z * r[3]
        res[3].w = c.w * r[3]

        return res
    }

    // TODO other matrices
}