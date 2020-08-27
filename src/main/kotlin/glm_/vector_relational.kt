package glm_

import glm_.vec1.Vec1
import glm_.vec1.Vec1bool
import glm_.vec1.Vec1i
import glm_.vec2.Vec2
import glm_.vec2.Vec2bool
import glm_.vec2.Vec2i
import glm_.vec3.Vec3
import glm_.vec3.Vec3bool
import glm_.vec3.Vec3i
import glm_.vec4.Vec4
import glm_.vec4.Vec4bool
import glm_.vec4.Vec4i
import kotlin.math.abs

/*  only for floating points

    https://randomascii.wordpress.com/2012/02/25/comparing-floating-point-numbers-2012-edition/
        https://randomascii.wordpress.com/2012/01/11/tricks-with-the-floating-point-format/

    https://www.ibm.com/developerworks/library/j-math2/index.html

 */
interface vector1_relational {

    fun equals(a: Vec1, b: Vec1, epsilon: Float): Boolean =  abs(a.x - b.x) <= epsilon

    fun equals(a: Vec1, b: Vec1, epsilon: Vec1, res: Vec1bool = Vec1bool()): Vec1bool {
        res.x = abs(a.x - b.x) <= epsilon.x
        return res
    }

    fun notEquals(a: Vec1, b: Vec1, epsilon: Float): Boolean = abs(a.x - b.x) > epsilon

    fun notEquals(a: Vec1, b: Vec1, epsilon: Vec1, res: Vec1bool = Vec1bool()): Vec1bool {
        res.x = abs(a.x - b.x) > epsilon.x
        return res
    }

    fun equals(a: Vec1, b: Vec1, maxUlps: Int): Boolean =  a.x.isEqual(b.x, maxUlps)

    fun equals(a: Vec1, b: Vec1, maxUlps: Vec1i, res: Vec1bool = Vec1bool()): Vec1bool {
        res.x = a.x.isEqual(b.x, maxUlps.x)
        return res
    }

    fun notEquals(a: Vec1, b: Vec1, maxUlps: Int): Boolean = !a.x.isEqual(b.x, maxUlps)

    fun notEquals(a: Vec1, b: Vec1, maxUlps: Vec1i, res: Vec1bool = Vec1bool()): Vec1bool {
        res.x = !a.x.isEqual(b.x, maxUlps.x)
        return res
    }
}

interface vector2_relational {

    fun equals(a: Vec2, b: Vec2, epsilon: Float): Boolean =  abs(a.x - b.x) <= epsilon && abs(a.y - b.y) <= epsilon

    fun equals(a: Vec2, b: Vec2, epsilon: Vec2, res: Vec2bool = Vec2bool()): Vec2bool {
        res.x = abs(a.x - b.x) <= epsilon.x
        res.y = abs(a.y - b.y) <= epsilon.y
        return res
    }

    fun notEquals(a: Vec2, b: Vec2, epsilon: Float): Boolean = abs(a.x - b.x) > epsilon || abs(a.y - b.y) > epsilon 

    fun notEquals(a: Vec2, b: Vec2, epsilon: Vec2, res: Vec2bool = Vec2bool()): Vec2bool {
        res.x = abs(a.x - b.x) > epsilon.x
        res.y = abs(a.y - b.y) > epsilon.y
        return res
    }

    fun equals(a: Vec2, b: Vec2, maxUlps: Int): Boolean =  a.x.isEqual(b.x, maxUlps) && a.y.isEqual(b.y, maxUlps) 

    fun equals(a: Vec2, b: Vec2, maxUlps: Vec2i, res: Vec2bool = Vec2bool()): Vec2bool {
        res.x = a.x.isEqual(b.x, maxUlps.x)
        res.y = a.y.isEqual(b.y, maxUlps.y)
        return res
    }

    fun notEquals(a: Vec2, b: Vec2, maxUlps: Int): Boolean = !a.x.isEqual(b.x, maxUlps) || !a.y.isEqual(b.y, maxUlps)

    fun notEquals(a: Vec2, b: Vec2, maxUlps: Vec2i, res: Vec2bool = Vec2bool()): Vec2bool {
        res.x = !a.x.isEqual(b.x, maxUlps.x)
        res.y = !a.y.isEqual(b.y, maxUlps.y)
        return res
    }
}

interface vector3_relational {

    fun equals(a: Vec3, b: Vec3, epsilon: Float): Boolean =  abs(a.x - b.x) <= epsilon && abs(a.y - b.y) <= epsilon && abs(a.z - b.z) <= epsilon

    fun equals(a: Vec3, b: Vec3, epsilon: Vec3, res: Vec3bool = Vec3bool()): Vec3bool {
        res.x = abs(a.x - b.x) <= epsilon.x
        res.y = abs(a.y - b.y) <= epsilon.y
        res.z = abs(a.z - b.z) <= epsilon.z
        return res
    }

    fun notEquals(a: Vec3, b: Vec3, epsilon: Float): Boolean = abs(a.x - b.x) > epsilon || abs(a.y - b.y) > epsilon || abs(a.z - b.z) > epsilon

    fun notEquals(a: Vec3, b: Vec3, epsilon: Vec3, res: Vec3bool = Vec3bool()): Vec3bool {
        res.x = abs(a.x - b.x) > epsilon.x
        res.y = abs(a.y - b.y) > epsilon.y
        res.z = abs(a.z - b.z) > epsilon.z
        return res
    }

    fun equals(a: Vec3, b: Vec3, maxUlps: Int): Boolean =  a.x.isEqual(b.x, maxUlps) && a.y.isEqual(b.y, maxUlps) && a.z.isEqual(b.z, maxUlps)

    fun equals(a: Vec3, b: Vec3, maxUlps: Vec3i, res: Vec3bool = Vec3bool()): Vec3bool {
        res.x = a.x.isEqual(b.x, maxUlps.x)
        res.y = a.y.isEqual(b.y, maxUlps.y)
        res.z = a.z.isEqual(b.z, maxUlps.z)
        return res
    }

    fun notEquals(a: Vec3, b: Vec3, maxUlps: Int): Boolean = !a.x.isEqual(b.x, maxUlps) || !a.y.isEqual(b.y, maxUlps) || !a.z.isEqual(b.z, maxUlps)

    fun notEquals(a: Vec3, b: Vec3, maxUlps: Vec3i, res: Vec3bool = Vec3bool()): Vec3bool {
        res.x = !a.x.isEqual(b.x, maxUlps.x)
        res.y = !a.y.isEqual(b.y, maxUlps.y)
        res.z = !a.z.isEqual(b.z, maxUlps.z)
        return res
    }
}

interface vector4_relational {

    fun equals(a: Vec4, b: Vec4, epsilon: Float): Boolean =  abs(a.x - b.x) <= epsilon && abs(a.y - b.y) <= epsilon && abs(a.z - b.z) <= epsilon && abs(a.w - b.w) <= epsilon

    fun equals(a: Vec4, b: Vec4, epsilon: Vec4, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = abs(a.x - b.x) <= epsilon.x
        res.y = abs(a.y - b.y) <= epsilon.y
        res.z = abs(a.z - b.z) <= epsilon.z
        res.w = abs(a.w - b.w) <= epsilon.w
        return res
    }

    fun notEquals(a: Vec4, b: Vec4, epsilon: Float): Boolean = abs(a.x - b.x) > epsilon || abs(a.y - b.y) > epsilon || abs(a.z - b.z) > epsilon || abs(a.w - b.w) > epsilon

    fun notEquals(a: Vec4, b: Vec4, epsilon: Vec4, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = abs(a.x - b.x) > epsilon.x
        res.y = abs(a.y - b.y) > epsilon.y
        res.z = abs(a.z - b.z) > epsilon.z
        res.w = abs(a.w - b.w) > epsilon.w
        return res
    }

    fun equals(a: Vec4, b: Vec4, maxUlps: Int): Boolean =  a.x.isEqual(b.x, maxUlps) && a.y.isEqual(b.y, maxUlps) && a.z.isEqual(b.z, maxUlps) && a.w.isEqual(b.w, maxUlps)

    fun equals(a: Vec4, b: Vec4, maxUlps: Vec4i, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = a.x.isEqual(b.x, maxUlps.x)
        res.y = a.y.isEqual(b.y, maxUlps.y)
        res.z = a.z.isEqual(b.z, maxUlps.z)
        res.w = a.w.isEqual(b.w, maxUlps.w)
        return res
    }

    fun notEquals(a: Vec4, b: Vec4, maxUlps: Int): Boolean = !a.x.isEqual(b.x, maxUlps) || !a.y.isEqual(b.y, maxUlps) || !a.z.isEqual(b.z, maxUlps) || !a.w.isEqual(b.w, maxUlps)

    fun notEquals(a: Vec4, b: Vec4, maxUlps: Vec4i, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = !a.x.isEqual(b.x, maxUlps.x)
        res.y = !a.y.isEqual(b.y, maxUlps.y)
        res.z = !a.z.isEqual(b.z, maxUlps.z)
        res.w = !a.w.isEqual(b.w, maxUlps.w)
        return res
    }
}

//fun main() {
//    2.68435456E8f.print()
//    5.36870912E8f.print()
//    1.073741824E9f.print()
//    2.147483648E9f.print()
//    4.294967296E9f.print()
//    println('\n')
//    0f.print()
//    (-0f).print()
//    1.40129846e-45f.print()
//    1.17549435e-38f.print()
//    0.2f.print()
//
//    println(0f == (-0f))
//    println(0f.isEqual(-0f, 5))
//    println(0.0 == (-0.0))
//}
//
//fun Float.print() = println("i: ${f.asRawIntBits}, exponent: ${f.exponent}, mantissa: ${f.mantissa.asIntBits.asHexString}")