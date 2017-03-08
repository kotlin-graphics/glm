package quat

import glm.Glm
import quat.QuatD.Companion.mul
import vec._3.Vec3d
import vec._4.Vec4d

/**
 * Created by elect on 04/03/2017.
 */

interface quatD_operators {

    fun add(res: QuatD, a: QuatD, b: QuatD): QuatD {
        res.w = a.w + b.w
        res.x = a.x + b.x
        res.y = a.y + b.y
        res.z = a.z + b.z
        return res
    }


    fun sub(res: QuatD, a: QuatD, b: QuatD): QuatD {
        res.w = a.w - b.w
        res.x = a.x - b.x
        res.y = a.y - b.y
        res.z = a.z - b.z
        return res
    }


    fun mul(res: QuatD, a: QuatD, b: QuatD): QuatD {
        val resW = a.w * b.w - a.x * b.x - a.y * b.y - a.z * b.z
        val resX = a.w * b.x + a.x * b.w + a.y * b.z - a.z * b.y
        val resY = a.w * b.y + a.y * b.w + a.z * b.x - a.x * b.z
        val resZ = a.w * b.z + a.z * b.w + a.x * b.y - a.y * b.x
        return res.put(resW, resX, resY, resZ)
    }

    fun mul(res: QuatD, a: QuatD, b: Double): QuatD {
        res.w = a.w * b
        res.x = a.x * b
        res.y = a.y * b
        res.z = a.z * b
        return res
    }

    fun mul(res: Vec3d, a: QuatD, b: Vec3d): Vec3d {
        val uvX = a.y * b.z - b.y * a.z
        val uvY = a.z * b.x - b.z * a.x
        val uvZ = a.x * b.y - b.x * a.y
        val uuvX = a.y * uvZ - uvY * a.z
        val uuvY = a.z * uvX - uvZ * a.x
        val uuvZ = a.x * uvY - uvX * a.y
        res.x = b.x + (uvX * a.w + uuvX) * 2.0
        res.y = b.y + (uvY * a.w + uuvY) * 2.0
        res.z = b.z + (uvZ * a.w + uuvZ) * 2.0
        return res
    }

    fun mul(res: Vec3d, a: Vec3d, b: QuatD): Vec3d {
        val dot = Glm.dot(a, a)
        val iW = b.w / dot
        val iX = -b.x / dot
        val iY = -b.y / dot
        val iZ = -b.z / dot
        val uvX = iY * a.z - a.y * iZ
        val uvY = iZ * a.x - a.z * iX
        val uvZ = iX * a.y - a.x * iY
        val uuvX = iY * uvZ - uvY * iZ
        val uuvY = iZ * uvX - uvZ * iX
        val uuvZ = iX * uvY - uvX * iY
        res.x = a.x + (uvX * iW + uuvX) * 2.0
        res.y = a.y + (uvY * iW + uuvY) * 2.0
        res.z = a.z + (uvZ * iW + uuvZ) * 2.0
        return res
    }

    fun mul(res: QuatD, a: QuatD, b: Vec4d): QuatD {
        res.w = a.w
        res.x = a.x * b.x
        res.y = a.y * b.y
        res.z = a.z * b.z
        return res
    }


    fun div(res: QuatD, a: QuatD, b: Double): QuatD {
        res.w = a.w / b
        res.x = a.x / b
        res.y = a.y / b
        res.z = a.z / b
        return res
    }
}

operator fun Double.times(b: QuatD) = mul(QuatD(), b, this)
operator fun Vec3d.times(b: QuatD) = mul(Vec3d(), this, b)
operator fun Vec4d.times(b: QuatD) = mul(QuatD(), b, this)