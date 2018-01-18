package glm_.func

import glm_.*
import glm_.vec1.Vec1
import glm_.vec1.Vec1bool
import glm_.vec1.Vec1i
import glm_.vec1.Vec1t
import glm_.vec2.*
import glm_.vec3.*
import glm_.vec4.*

/**
 * Created by GBarbieri on 08.11.2016.
 */

interface func_vector1_relational {

    fun lessThan(a: Vec1t<out Number>, b: Vec1t<out Number>, res: Vec1bool = Vec1bool()): Vec1bool {
        val A = a
        when (A) {
            is Vec1 -> res.x = A.x < b.x.f
//            is Vec1b -> res.x = A.x < b.x.i
//            is Vec1d -> res.x = A.x < b.x.d
            is Vec1i -> res.x = A.x < b.x.i
//            is Vec1l -> res.x = A.x < b.x.L
//            is Vec1s -> res.x = A.x < b.x.i
//            is Vec1ub -> res.x = A.x < b.x.i
//            is Vec1ui -> res.x = A.x < b.x.i
//            is Vec1ul -> res.x = A.x < b.x.L
//            is Vec1us -> res.x = A.x < b.x.i
        }
        return res
    }

    fun lessThanEqual(a: Vec1t<out Number>, b: Number, res: Vec1bool = Vec1bool()): Vec1bool {
        val A = a
        when (A) {
            is Vec1 -> res.x = A.x <= b.f
//            is Vec1b -> res.x = A.x <= b.x.i
//            is Vec1d -> res.x = A.x <= b.x.d
            is Vec1i -> res.x = A.x <= b.i
//            is Vec1l -> res.x = A.x <= b.x.L
//            is Vec1s -> res.x = A.x <= b.x.i
//            is Vec1ub -> res.x = A.x <= b.x.i
//            is Vec1ui -> res.x = A.x <= b.x.i
//            is Vec1ul -> res.x = A.x <= b.x.L
//            is Vec1us -> res.x = A.x <= b.x.i
        }
        return res
    }

    fun lessThanEqual(a: Vec1t<out Number>, b: Vec1t<out Number>, res: Vec1bool = Vec1bool()): Vec1bool {
        val A = a
        when (A) {
            is Vec1 -> res.x = A.x <= b.x.f
//            is Vec1b -> res.x = A.x <= b.x.i
//            is Vec1d -> res.x = A.x <= b.x.d
            is Vec1i -> res.x = A.x <= b.x.i
//            is Vec1l -> res.x = A.x <= b.x.L
//            is Vec1s -> res.x = A.x <= b.x.i
//            is Vec1ub -> res.x = A.x <= b.x.i
//            is Vec1ui -> res.x = A.x <= b.x.i
//            is Vec1ul -> res.x = A.x <= b.x.L
//            is Vec1us -> res.x = A.x <= b.x.i
        }
        return res
    }

    fun greaterThan(a: Vec1t<out Number>, b: Vec1t<out Number>, res: Vec1bool = Vec1bool()): Vec1bool {
        val A = a
        when (A) {
            is Vec1 -> res.x = A.x > b.x.f
//            is Vec1b -> res.x = A.x > b.x.i
//            is Vec1d -> res.x = A.x > b.x.d
            is Vec1i -> res.x = A.x > b.x.i
//            is Vec1l -> res.x = A.x > b.x.L
//            is Vec1s -> res.x = A.x > b.x.i
//            is Vec1ub -> res.x = A.x > b.x.i
//            is Vec1ui -> res.x = A.x > b.x.i
//            is Vec1ul -> res.x = A.x > b.x.L
//            is Vec1us -> res.x = A.x > b.x.i
        }
        return res
    }

    fun greaterThanEqual(a: Vec1t<out Number>, b: Vec1t<out Number>, res: Vec1bool = Vec1bool()): Vec1bool {
        val A = a
        when (A) {
            is Vec1 -> res.x = A.x >= b.x.f
//            is Vec1b -> res.x = A.x >= b.x.i
//            is Vec1d -> res.x = A.x >= b.x.d
            is Vec1i -> res.x = A.x >= b.x.i
//            is Vec1l -> res.x = A.x >= b.x.L
//            is Vec1s -> res.x = A.x >= b.x.i
//            is Vec1ub -> res.x = A.x >= b.x.i
//            is Vec1ui -> res.x = A.x >= b.x.i
//            is Vec1ul -> res.x = A.x >= b.x.L
//            is Vec1us -> res.x = A.x >= b.x.i
        }
        return res
    }

    fun equal(a: Vec1t<out Number>, b: Vec1t<out Number>, res: Vec1bool = Vec1bool()): Vec1bool {
        val A = a
        when (A) {
            is Vec1 -> res.x = A.x == b.x.f
//            is Vec1b -> res.x = A.x == b.x.b
//            is Vec1d -> res.x = A.x == b.x.d
            is Vec1i -> res.x = A.x == b.x.i
//            is Vec1l -> res.x = A.x == b.x.L
//            is Vec1s -> res.x = A.x == b.x.s
//            is Vec1ub -> res.x = A.x.v == b.x.b
//            is Vec1ui -> res.x = A.x.v == b.x.i
//            is Vec1ul -> res.x = A.x.v == b.x.L
//            is Vec1us -> res.x = A.x.v == b.x.s
        }
        return res
    }

    fun notEqual(a: Vec1t<out Number>, b: Vec1t<out Number>, res: Vec1bool = Vec1bool()): Vec1bool {
        val A = a
        when (A) {
            is Vec1 -> res.x = A.x != b.x.f
//            is Vec1b -> res.x = A.x != b.x.b
//            is Vec1d -> res.x = A.x != b.x.d
            is Vec1i -> res.x = A.x != b.x.i
//            is Vec1l -> res.x = A.x != b.x.L
//            is Vec1s -> res.x = A.x != b.x.s
//            is Vec1ub -> res.x = A.x.v != b.x.b
//            is Vec1ui -> res.x = A.x.v != b.x.i
//            is Vec1ul -> res.x = A.x.v != b.x.L
//            is Vec1us -> res.x = A.x.v != b.x.s
        }
        return res
    }

    fun isEqual(a: Vec1t<out Number>, b: Vec1t<out Number>): Boolean {
        val A = a
        return when (A) {
            is Vec1 -> A.x == b.x.f
//            is Vec1b -> A.x == b.x.b
//            is Vec1d -> A.x == b.x.d
            is Vec1i -> A.x == b.x.i
//            is Vec1l -> A.x == b.x.L
//            is Vec1s -> A.x == b.x.s
//            is Vec1ub -> A.x.v == b.x.b
//            is Vec1ui -> A.x.v == b.x.i
//            is Vec1ul -> A.x.v == b.x.L
//            is Vec1us -> A.x.v == b.x.s
            else -> false
        }
    }


    fun any(a: Vec1bool) = a[0] || a[1]

    fun all(a: Vec1bool) = a[0] && a[1]

    fun not(a: Vec1bool, res: Vec1bool = Vec1bool()): Vec1bool {
        res[0] = !a[0]
        res[1] = !a[1]
        return res
    }
}

interface func_vector2_relational {

    fun lessThan(a: Vec2t<out Number>, b: Vec2t<out Number>, res: Vec2bool = Vec2bool()): Vec2bool {
        val A = a
        when (A) {
            is Vec2 -> {
                res.x = A.x < b.x.f
                res.y = A.y < b.y.f
            }
            is Vec2b -> {
                res.x = A.x < b.x.i
                res.y = A.y < b.y.i
            }
            is Vec2d -> {
                res.x = A.x < b.x.d
                res.y = A.y < b.y.d
            }
            is Vec2i -> {
                res.x = A.x < b.x.i
                res.y = A.y < b.y.i
            }
            is Vec2l -> {
                res.x = A.x < b.x.L
                res.y = A.y < b.y.L
            }
            is Vec2s -> {
                res.x = A.x < b.x.i
                res.y = A.y < b.y.i
            }
            is Vec2ub -> {
                res.x = A.x < b.x.i
                res.y = A.y < b.y.i
            }
            is Vec2ui -> {
                res.x = A.x < b.x.i
                res.y = A.y < b.y.i
            }
            is Vec2ul -> {
                res.x = A.x < b.x.L
                res.y = A.y < b.y.L
            }
            is Vec2us -> {
                res.x = A.x < b.x.i
                res.y = A.y < b.y.i
            }
        }
        return res
    }

    fun lessThanEqual(a: Vec2t<out Number>, b: Vec2t<out Number>, res: Vec2bool = Vec2bool()): Vec2bool {
        val A = a
        when (A) {
            is Vec2 -> {
                res.x = A.x <= b.x.f
                res.y = A.y <= b.y.f
            }
            is Vec2b -> {
                res.x = A.x <= b.x.i
                res.y = A.y <= b.y.i
            }
            is Vec2d -> {
                res.x = A.x <= b.x.d
                res.y = A.y <= b.y.d
            }
            is Vec2i -> {
                res.x = A.x <= b.x.i
                res.y = A.y <= b.y.i
            }
            is Vec2l -> {
                res.x = A.x <= b.x.L
                res.y = A.y <= b.y.L
            }
            is Vec2s -> {
                res.x = A.x <= b.x.i
                res.y = A.y <= b.y.i
            }
            is Vec2ub -> {
                res.x = A.x <= b.x.i
                res.y = A.y <= b.y.i
            }
            is Vec2ui -> {
                res.x = A.x <= b.x.i
                res.y = A.y <= b.y.i
            }
            is Vec2ul -> {
                res.x = A.x <= b.x.L
                res.y = A.y <= b.y.L
            }
            is Vec2us -> {
                res.x = A.x <= b.x.i
                res.y = A.y <= b.y.i
            }
        }
        return res
    }

    fun greaterThan(a: Vec2t<out Number>, b: Vec2t<out Number>, res: Vec2bool = Vec2bool()): Vec2bool {
        val A = a
        when (A) {
            is Vec2 -> {
                res.x = A.x > b.x.f
                res.y = A.y > b.y.f
            }
            is Vec2b -> {
                res.x = A.x > b.x.i
                res.y = A.y > b.y.i
            }
            is Vec2d -> {
                res.x = A.x > b.x.d
                res.y = A.y > b.y.d
            }
            is Vec2i -> {
                res.x = A.x > b.x.i
                res.y = A.y > b.y.i
            }
            is Vec2l -> {
                res.x = A.x > b.x.L
                res.y = A.y > b.y.L
            }
            is Vec2s -> {
                res.x = A.x > b.x.i
                res.y = A.y > b.y.i
            }
            is Vec2ub -> {
                res.x = A.x > b.x.i
                res.y = A.y > b.y.i
            }
            is Vec2ui -> {
                res.x = A.x > b.x.i
                res.y = A.y > b.y.i
            }
            is Vec2ul -> {
                res.x = A.x > b.x.L
                res.y = A.y > b.y.L
            }
            is Vec2us -> {
                res.x = A.x > b.x.i
                res.y = A.y > b.y.i
            }
        }
        return res
    }

    fun greaterThanEqual(a: Vec2t<out Number>, b: Vec2t<out Number>, res: Vec2bool = Vec2bool()): Vec2bool {
        val A = a
        when (A) {
            is Vec2 -> {
                res.x = A.x >= b.x.f
                res.y = A.y >= b.y.f
            }
            is Vec2b -> {
                res.x = A.x >= b.x.i
                res.y = A.y >= b.y.i
            }
            is Vec2d -> {
                res.x = A.x >= b.x.d
                res.y = A.y >= b.y.d
            }
            is Vec2i -> {
                res.x = A.x >= b.x.i
                res.y = A.y >= b.y.i
            }
            is Vec2l -> {
                res.x = A.x >= b.x.L
                res.y = A.y >= b.y.L
            }
            is Vec2s -> {
                res.x = A.x >= b.x.i
                res.y = A.y >= b.y.i
            }
            is Vec2ub -> {
                res.x = A.x >= b.x.i
                res.y = A.y >= b.y.i
            }
            is Vec2ui -> {
                res.x = A.x >= b.x.i
                res.y = A.y >= b.y.i
            }
            is Vec2ul -> {
                res.x = A.x >= b.x.L
                res.y = A.y >= b.y.L
            }
            is Vec2us -> {
                res.x = A.x >= b.x.i
                res.y = A.y >= b.y.i
            }
        }
        return res
    }

    fun equal(a: Vec2t<out Number>, b: Vec2t<out Number>, res: Vec2bool = Vec2bool()): Vec2bool {
        val A = a
        when (A) {
            is Vec2 -> {
                res.x = A.x == b.x.f
                res.y = A.y == b.y.f
            }
            is Vec2b -> {
                res.x = A.x == b.x.b
                res.y = A.y == b.y.b
            }
            is Vec2d -> {
                res.x = A.x == b.x.d
                res.y = A.y == b.y.d
            }
            is Vec2i -> {
                res.x = A.x == b.x.i
                res.y = A.y == b.y.i
            }
            is Vec2l -> {
                res.x = A.x == b.x.L
                res.y = A.y == b.y.L
            }
            is Vec2s -> {
                res.x = A.x == b.x.s
                res.y = A.y == b.y.s
            }
            is Vec2ub -> {
                res.x = A.x.v == b.x.b
                res.y = A.y.v == b.y.b
            }
            is Vec2ui -> {
                res.x = A.x.v == b.x.i
                res.y = A.y.v == b.y.i
            }
            is Vec2ul -> {
                res.x = A.x.v == b.x.L
                res.y = A.y.v == b.y.L
            }
            is Vec2us -> {
                res.x = A.x.v == b.x.s
                res.y = A.y.v == b.y.s
            }
        }
        return res
    }

    fun notEqual(a: Vec2t<out Number>, b: Vec2t<out Number>, res: Vec2bool = Vec2bool()): Vec2bool {
        val A = a
        when (A) {
            is Vec2 -> {
                res.x = A.x != b.x.f
                res.y = A.y != b.y.f
            }
            is Vec2b -> {
                res.x = A.x != b.x.b
                res.y = A.y != b.y.b
            }
            is Vec2d -> {
                res.x = A.x != b.x.d
                res.y = A.y != b.y.d
            }
            is Vec2i -> {
                res.x = A.x != b.x.i
                res.y = A.y != b.y.i
            }
            is Vec2l -> {
                res.x = A.x != b.x.L
                res.y = A.y != b.y.L
            }
            is Vec2s -> {
                res.x = A.x != b.x.s
                res.y = A.y != b.y.s
            }
            is Vec2ub -> {
                res.x = A.x.v != b.x.b
                res.y = A.y.v != b.y.b
            }
            is Vec2ui -> {
                res.x = A.x.v != b.x.i
                res.y = A.y.v != b.y.i
            }
            is Vec2ul -> {
                res.x = A.x.v != b.x.L
                res.y = A.y.v != b.y.L
            }
            is Vec2us -> {
                res.x = A.x.v != b.x.s
                res.y = A.y.v != b.y.s
            }
        }
        return res
    }

    fun isEqual(a: Vec2t<out Number>, b: Vec2t<out Number>): Boolean {
        val A = a
        var res = false
        when (A) {
            is Vec2 -> {
                res = ((A.x == b.x.f)
                        && (A.y == b.y.f))
            }
            is Vec2b -> {
                res = ((A.x == b.x.b)
                        && (A.y == b.y.b))
            }
            is Vec2d -> {
                res = ((A.x == b.x.d)
                        && (A.y == b.y.d))
            }
            is Vec2i -> {
                res = ((A.x == b.x.i)
                        && (A.y == b.y.i))
            }
            is Vec2l -> {
                res = ((A.x == b.x.L)
                        && (A.y == b.y.L))
            }
            is Vec2s -> {
                res = ((A.x == b.x.s)
                        && (A.y == b.y.s))
            }
            is Vec2ub -> {
                res = ((A.x.v == b.x.b)
                        && (A.y.v == b.y.b))
            }
            is Vec2ui -> {
                res = ((A.x.v == b.x.i)
                        && (A.y.v == b.y.i))
            }
            is Vec2ul -> {
                res = ((A.x.v == b.x.L)
                        && (A.y.v == b.y.L))
            }
            is Vec2us -> {
                res = ((A.x.v == b.x.s)
                        && (A.y.v == b.y.s))
            }
        }

        return res
    }


    fun any(a: Vec2bool) = a[0] || a[1]

    fun all(a: Vec2bool) = a[0] && a[1]

    fun not(a: Vec2bool, res: Vec2bool = Vec2bool()): Vec2bool {
        res[0] = !a[0]
        res[1] = !a[1]
        return res
    }
}

interface func_vector3_relational {

    fun lessThan(a: Vec3t<out Number>, b: Vec3t<out Number>, res: Vec3bool = Vec3bool()): Vec3bool {
        val A = a
        when (A) {
            is Vec3 -> {
                res.x = A.x < b.x.f
                res.y = A.y < b.y.f
                res.z = A.z < b.z.f
            }
            is Vec3b -> {
                res.x = A.x < b.x.i
                res.y = A.y < b.y.i
                res.z = A.z < b.z.i
            }
            is Vec3d -> {
                res.x = A.x < b.x.d
                res.y = A.y < b.y.d
                res.z = A.z < b.z.d
            }
            is Vec3i -> {
                res.x = A.x < b.x.i
                res.y = A.y < b.y.i
                res.z = A.z < b.z.i
            }
            is Vec3l -> {
                res.x = A.x < b.x.L
                res.y = A.y < b.y.L
                res.z = A.z < b.z.L
            }
            is Vec3s -> {
                res.x = A.x < b.x.i
                res.y = A.y < b.y.i
                res.z = A.z < b.z.i
            }
            is Vec3ub -> {
                res.x = A.x < b.x.i
                res.y = A.y < b.y.i
                res.z = A.z < b.z.i
            }
            is Vec3ui -> {
                res.x = A.x < b.x.i
                res.y = A.y < b.y.i
                res.z = A.z < b.z.i
            }
            is Vec3ul -> {
                res.x = A.x < b.x.L
                res.y = A.y < b.y.L
                res.z = A.z < b.z.L
            }
            is Vec3us -> {
                res.x = A.x < b.x.i
                res.y = A.y < b.y.i
                res.z = A.z < b.z.i
            }
        }
        return res
    }

    fun lessThanEqual(a: Vec3t<out Number>, b: Vec3t<out Number>, res: Vec3bool = Vec3bool()): Vec3bool {
        val A = a
        when (A) {
            is Vec3 -> {
                res.x = A.x <= b.x.f
                res.y = A.y <= b.y.f
                res.z = A.z <= b.z.f
            }
            is Vec3b -> {
                res.x = A.x <= b.x.i
                res.y = A.y <= b.y.i
                res.z = A.z <= b.z.i
            }
            is Vec3d -> {
                res.x = A.x <= b.x.d
                res.y = A.y <= b.y.d
                res.z = A.z <= b.z.d
            }
            is Vec3i -> {
                res.x = A.x <= b.x.i
                res.y = A.y <= b.y.i
                res.z = A.z <= b.z.i
            }
            is Vec3l -> {
                res.x = A.x <= b.x.L
                res.y = A.y <= b.y.L
                res.z = A.z <= b.z.L
            }
            is Vec3s -> {
                res.x = A.x <= b.x.i
                res.y = A.y <= b.y.i
                res.z = A.z <= b.z.i
            }
            is Vec3ub -> {
                res.x = A.x <= b.x.i
                res.y = A.y <= b.y.i
                res.z = A.z <= b.z.i
            }
            is Vec3ui -> {
                res.x = A.x <= b.x.i
                res.y = A.y <= b.y.i
                res.z = A.z <= b.z.i
            }
            is Vec3ul -> {
                res.x = A.x <= b.x.L
                res.y = A.y <= b.y.L
                res.z = A.z <= b.z.L
            }
            is Vec3us -> {
                res.x = A.x <= b.x.i
                res.y = A.y <= b.y.i
                res.z = A.z <= b.z.i
            }
        }
        return res
    }

    fun greaterThan(a: Vec3t<out Number>, b: Vec3t<out Number>, res: Vec3bool = Vec3bool()): Vec3bool {
        val A = a
        when (A) {
            is Vec3 -> {
                res.x = A.x > b.x.f
                res.y = A.y > b.y.f
                res.z = A.z > b.z.f
            }
            is Vec3b -> {
                res.x = A.x > b.x.i
                res.y = A.y > b.y.i
                res.z = A.z > b.z.i
            }
            is Vec3d -> {
                res.x = A.x > b.x.d
                res.y = A.y > b.y.d
                res.z = A.z > b.z.d
            }
            is Vec3i -> {
                res.x = A.x > b.x.i
                res.y = A.y > b.y.i
                res.z = A.z > b.z.i
            }
            is Vec3l -> {
                res.x = A.x > b.x.L
                res.y = A.y > b.y.L
                res.z = A.z > b.z.L
            }
            is Vec3s -> {
                res.x = A.x > b.x.i
                res.y = A.y > b.y.i
                res.z = A.z > b.z.i
            }
            is Vec3ub -> {
                res.x = A.x > b.x.i
                res.y = A.y > b.y.i
                res.z = A.z > b.z.i
            }
            is Vec3ui -> {
                res.x = A.x > b.x.i
                res.y = A.y > b.y.i
                res.z = A.z > b.z.i
            }
            is Vec3ul -> {
                res.x = A.x > b.x.L
                res.y = A.y > b.y.L
                res.z = A.z > b.z.L
            }
            is Vec3us -> {
                res.x = A.x > b.x.i
                res.y = A.y > b.y.i
                res.z = A.z > b.z.i
            }
        }
        return res
    }

    fun greaterThanEqual(a: Vec3t<out Number>, b: Vec3t<out Number>, res: Vec3bool = Vec3bool()): Vec3bool {
        val A = a
        when (A) {
            is Vec3 -> {
                res.x = A.x >= b.x.f
                res.y = A.y >= b.y.f
                res.z = A.z >= b.z.f
            }
            is Vec3b -> {
                res.x = A.x >= b.x.i
                res.y = A.y >= b.y.i
                res.z = A.z >= b.z.i
            }
            is Vec3d -> {
                res.x = A.x >= b.x.d
                res.y = A.y >= b.y.d
                res.z = A.z >= b.z.d
            }
            is Vec3i -> {
                res.x = A.x >= b.x.i
                res.y = A.y >= b.y.i
                res.z = A.z >= b.z.i
            }
            is Vec3l -> {
                res.x = A.x >= b.x.L
                res.y = A.y >= b.y.L
                res.z = A.z >= b.z.L
            }
            is Vec3s -> {
                res.x = A.x >= b.x.i
                res.y = A.y >= b.y.i
                res.z = A.z >= b.z.i
            }
            is Vec3ub -> {
                res.x = A.x >= b.x.i
                res.y = A.y >= b.y.i
                res.z = A.z >= b.z.i
            }
            is Vec3ui -> {
                res.x = A.x >= b.x.i
                res.y = A.y >= b.y.i
                res.z = A.z >= b.z.i
            }
            is Vec3ul -> {
                res.x = A.x >= b.x.L
                res.y = A.y >= b.y.L
                res.z = A.z >= b.z.L
            }
            is Vec3us -> {
                res.x = A.x >= b.x.i
                res.y = A.y >= b.y.i
                res.z = A.z >= b.z.i
            }
        }
        return res
    }

    fun equal(a: Vec3t<out Number>, b: Vec3t<out Number>, res: Vec3bool = Vec3bool()): Vec3bool {
        val A = a
        when (A) {
            is Vec3 -> {
                res.x = A.x == b.x.f
                res.y = A.y == b.y.f
                res.z = A.z == b.z.f
            }
            is Vec3b -> {
                res.x = A.x == b.x.b
                res.y = A.y == b.y.b
                res.z = A.z == b.z.b
            }
            is Vec3d -> {
                res.x = A.x == b.x.d
                res.y = A.y == b.y.d
                res.z = A.z == b.z.d
            }
            is Vec3i -> {
                res.x = A.x == b.x.i
                res.y = A.y == b.y.i
                res.z = A.z == b.z.i
            }
            is Vec3l -> {
                res.x = A.x == b.x.L
                res.y = A.y == b.y.L
                res.z = A.z == b.z.L
            }
            is Vec3s -> {
                res.x = A.x == b.x.s
                res.y = A.y == b.y.s
                res.z = A.z == b.z.s
            }
            is Vec3ub -> {
                res.x = A.x.v == b.x.b
                res.y = A.y.v == b.y.b
                res.z = A.z.v == b.z.b
            }
            is Vec3ui -> {
                res.x = A.x.v == b.x.i
                res.y = A.y.v == b.y.i
                res.z = A.z.v == b.z.i
            }
            is Vec3ul -> {
                res.x = A.x.v == b.x.L
                res.y = A.y.v == b.y.L
                res.z = A.z.v == b.z.L
            }
            is Vec3us -> {
                res.x = A.x.v == b.x.s
                res.y = A.y.v == b.y.s
                res.z = A.z.v == b.z.s
            }
        }
        return res
    }

    fun notEqual(a: Vec3t<out Number>, b: Vec3t<out Number>, res: Vec3bool = Vec3bool()): Vec3bool {
        val A = a
        when (A) {
            is Vec3 -> {
                res.x = A.x != b.x.f
                res.y = A.y != b.y.f
                res.z = A.z != b.z.f
            }
            is Vec3b -> {
                res.x = A.x != b.x.b
                res.y = A.y != b.y.b
                res.z = A.z != b.z.b
            }
            is Vec3d -> {
                res.x = A.x != b.x.d
                res.y = A.y != b.y.d
                res.z = A.z != b.z.d
            }
            is Vec3i -> {
                res.x = A.x != b.x.i
                res.y = A.y != b.y.i
                res.z = A.z != b.z.i
            }
            is Vec3l -> {
                res.x = A.x != b.x.L
                res.y = A.y != b.y.L
                res.z = A.z != b.z.L
            }
            is Vec3s -> {
                res.x = A.x != b.x.s
                res.y = A.y != b.y.s
                res.z = A.z != b.z.s
            }
            is Vec3ub -> {
                res.x = A.x.v != b.x.b
                res.y = A.y.v != b.y.b
                res.z = A.z.v != b.z.b
            }
            is Vec3ui -> {
                res.x = A.x.v != b.x.i
                res.y = A.y.v != b.y.i
                res.z = A.z.v != b.z.i
            }
            is Vec3ul -> {
                res.x = A.x.v != b.x.L
                res.y = A.y.v != b.y.L
                res.z = A.z.v != b.z.L
            }
            is Vec3us -> {
                res.x = A.x.v != b.x.s
                res.y = A.y.v != b.y.s
                res.z = A.z.v != b.z.s
            }
        }
        return res
    }

    fun isEqual(a: Vec3t<out Number>, b: Vec3t<out Number>): Boolean {
        val A = a
        var res = false
        when (A) {
            is Vec3 -> {
                res = ((A.x == b.x.f)
                        && (A.y == b.y.f)
                        && (A.z == b.z.f))
            }
            is Vec3b -> {
                res = ((A.x == b.x.b)
                        && (A.y == b.y.b)
                        && (A.z == b.z.b))
            }
            is Vec3d -> {
                res = ((A.x == b.x.d)
                        && (A.y == b.y.d)
                        && (A.z == b.z.d))
            }
            is Vec3i -> {
                res = ((A.x == b.x.i)
                        && (A.y == b.y.i)
                        && (A.z == b.z.i))
            }
            is Vec3l -> {
                res = ((A.x == b.x.L)
                        && (A.y == b.y.L)
                        && (A.z == b.z.L))
            }
            is Vec3s -> {
                res = ((A.x == b.x.s)
                        && (A.y == b.y.s)
                        && (A.z == b.z.s))
            }
            is Vec3ub -> {
                res = ((A.x.v == b.x.b)
                        && (A.y.v == b.y.b)
                        && (A.z.v == b.z.b))
            }
            is Vec3ui -> {
                res = ((A.x.v == b.x.i)
                        && (A.y.v == b.y.i)
                        && (A.z.v == b.z.i))
            }
            is Vec3ul -> {
                res = ((A.x.v == b.x.L)
                        && (A.y.v == b.y.L)
                        && (A.z.v == b.z.L))
            }
            is Vec3us -> {
                res = ((A.x.v == b.x.s)
                        && (A.y.v == b.y.s)
                        && (A.z.v == b.z.s))
            }
        }

        return res
    }

    fun any(a: Vec3bool) = a[0] || a[1] || a[2]

    fun all(a: Vec3bool) = a[0] && a[1] && a[2]

    fun not(a: Vec3bool, res: Vec3bool = Vec3bool()): Vec3bool {
        res[0] = !a[0]
        res[1] = !a[1]
        res[2] = !a[2]
        return res
    }
}

interface func_vector4_relational {

    fun lessThan(a: Vec4t<out Number>, b: Vec4t<out Number>, res: Vec4bool = Vec4bool()): Vec4bool {
        val A = a
        when (A) {
            is Vec4 -> {
                res.x = A.x < b.x.f
                res.y = A.y < b.y.f
                res.z = A.z < b.z.f
                res.w = A.w < b.w.f
            }
            is Vec4b -> {
                res.x = A.x < b.x.i
                res.y = A.y < b.y.i
                res.z = A.z < b.z.i
                res.w = A.w < b.w.i
            }
            is Vec4d -> {
                res.x = A.x < b.x.d
                res.y = A.y < b.y.d
                res.z = A.z < b.z.d
                res.w = A.w < b.w.d
            }
            is Vec4i -> {
                res.x = A.x < b.x.i
                res.y = A.y < b.y.i
                res.z = A.z < b.z.i
                res.w = A.w < b.w.i
            }
            is Vec4l -> {
                res.x = A.x < b.x.L
                res.y = A.y < b.y.L
                res.z = A.z < b.z.L
                res.w = A.w < b.w.L
            }
            is Vec4s -> {
                res.x = A.x < b.x.i
                res.y = A.y < b.y.i
                res.z = A.z < b.z.i
                res.w = A.w < b.w.i
            }
            is Vec4ub -> {
                res.x = A.x < b.x.i
                res.y = A.y < b.y.i
                res.z = A.z < b.z.i
                res.w = A.w < b.w.i
            }
            is Vec4ui -> {
                res.x = A.x < b.x.i
                res.y = A.y < b.y.i
                res.z = A.z < b.z.i
                res.w = A.w < b.w.i
            }
            is Vec4ul -> {
                res.x = A.x < b.x.L
                res.y = A.y < b.y.L
                res.z = A.z < b.z.L
                res.w = A.w < b.w.L
            }
            is Vec4us -> {
                res.x = A.x < b.x.i
                res.y = A.y < b.y.i
                res.z = A.z < b.z.i
                res.w = A.w < b.w.i
            }
        }
        return res
    }

    fun lessThanEqual(a: Vec4t<out Number>, b: Vec4t<out Number>, res: Vec4bool = Vec4bool()): Vec4bool {
        val A = a
        when (A) {
            is Vec4 -> {
                res.x = A.x <= b.x.f
                res.y = A.y <= b.y.f
                res.z = A.z <= b.z.f
                res.w = A.w <= b.w.f
            }
            is Vec4b -> {
                res.x = A.x <= b.x.i
                res.y = A.y <= b.y.i
                res.z = A.z <= b.z.i
                res.w = A.w <= b.w.i
            }
            is Vec4d -> {
                res.x = A.x <= b.x.d
                res.y = A.y <= b.y.d
                res.z = A.z <= b.z.d
                res.w = A.w <= b.w.d
            }
            is Vec4i -> {
                res.x = A.x <= b.x.i
                res.y = A.y <= b.y.i
                res.z = A.z <= b.z.i
                res.w = A.w <= b.w.i
            }
            is Vec4l -> {
                res.x = A.x <= b.x.L
                res.y = A.y <= b.y.L
                res.z = A.z <= b.z.L
                res.w = A.w <= b.w.L
            }
            is Vec4s -> {
                res.x = A.x <= b.x.i
                res.y = A.y <= b.y.i
                res.z = A.z <= b.z.i
                res.w = A.w <= b.w.i
            }
            is Vec4ub -> {
                res.x = A.x <= b.x.i
                res.y = A.y <= b.y.i
                res.z = A.z <= b.z.i
                res.w = A.w <= b.w.i
            }
            is Vec4ui -> {
                res.x = A.x <= b.x.i
                res.y = A.y <= b.y.i
                res.z = A.z <= b.z.i
                res.w = A.w <= b.w.i
            }
            is Vec4ul -> {
                res.x = A.x <= b.x.L
                res.y = A.y <= b.y.L
                res.z = A.z <= b.z.L
                res.w = A.w <= b.w.L
            }
            is Vec4us -> {
                res.x = A.x <= b.x.i
                res.y = A.y <= b.y.i
                res.z = A.z <= b.z.i
                res.w = A.w <= b.w.i
            }
        }
        return res
    }

    fun greaterThan(a: Vec4t<out Number>, b: Vec4t<out Number>, res: Vec4bool = Vec4bool()): Vec4bool {
        val A = a
        when (A) {
            is Vec4 -> {
                res.x = A.x > b.x.f
                res.y = A.y > b.y.f
                res.z = A.z > b.z.f
                res.w = A.w > b.w.f
            }
            is Vec4b -> {
                res.x = A.x > b.x.i
                res.y = A.y > b.y.i
                res.z = A.z > b.z.i
                res.w = A.w > b.w.i
            }
            is Vec4d -> {
                res.x = A.x > b.x.d
                res.y = A.y > b.y.d
                res.z = A.z > b.z.d
                res.w = A.w > b.w.d
            }
            is Vec4i -> {
                res.x = A.x > b.x.i
                res.y = A.y > b.y.i
                res.z = A.z > b.z.i
                res.w = A.w > b.w.i
            }
            is Vec4l -> {
                res.x = A.x > b.x.L
                res.y = A.y > b.y.L
                res.z = A.z > b.z.L
                res.w = A.w > b.w.L
            }
            is Vec4s -> {
                res.x = A.x > b.x.i
                res.y = A.y > b.y.i
                res.z = A.z > b.z.i
                res.w = A.w > b.w.i
            }
            is Vec4ub -> {
                res.x = A.x > b.x.i
                res.y = A.y > b.y.i
                res.z = A.z > b.z.i
                res.w = A.w > b.w.i
            }
            is Vec4ui -> {
                res.x = A.x > b.x.i
                res.y = A.y > b.y.i
                res.z = A.z > b.z.i
                res.w = A.w > b.w.i
            }
            is Vec4ul -> {
                res.x = A.x > b.x.L
                res.y = A.y > b.y.L
                res.z = A.z > b.z.L
                res.w = A.w > b.w.L
            }
            is Vec4us -> {
                res.x = A.x > b.x.i
                res.y = A.y > b.y.i
                res.z = A.z > b.z.i
                res.w = A.w > b.w.i
            }
        }
        return res
    }

    fun greaterThanEqual(a: Vec4t<out Number>, b: Vec4t<out Number>, res: Vec4bool = Vec4bool()): Vec4bool {
        val A = a
        when (A) {
            is Vec4 -> {
                res.x = A.x >= b.x.f
                res.y = A.y >= b.y.f
                res.z = A.z >= b.z.f
                res.w = A.w >= b.w.f
            }
            is Vec4b -> {
                res.x = A.x >= b.x.i
                res.y = A.y >= b.y.i
                res.z = A.z >= b.z.i
                res.w = A.w >= b.w.i
            }
            is Vec4d -> {
                res.x = A.x >= b.x.d
                res.y = A.y >= b.y.d
                res.z = A.z >= b.z.d
                res.w = A.w >= b.w.d
            }
            is Vec4i -> {
                res.x = A.x >= b.x.i
                res.y = A.y >= b.y.i
                res.z = A.z >= b.z.i
                res.w = A.w >= b.w.i
            }
            is Vec4l -> {
                res.x = A.x >= b.x.L
                res.y = A.y >= b.y.L
                res.z = A.z >= b.z.L
                res.w = A.w >= b.w.L
            }
            is Vec4s -> {
                res.x = A.x >= b.x.i
                res.y = A.y >= b.y.i
                res.z = A.z >= b.z.i
                res.w = A.w >= b.w.i
            }
            is Vec4ub -> {
                res.x = A.x >= b.x.i
                res.y = A.y >= b.y.i
                res.z = A.z >= b.z.i
                res.w = A.w >= b.w.i
            }
            is Vec4ui -> {
                res.x = A.x >= b.x.i
                res.y = A.y >= b.y.i
                res.z = A.z >= b.z.i
                res.w = A.w >= b.w.i
            }
            is Vec4ul -> {
                res.x = A.x >= b.x.L
                res.y = A.y >= b.y.L
                res.z = A.z >= b.z.L
                res.w = A.w >= b.w.L
            }
            is Vec4us -> {
                res.x = A.x >= b.x.i
                res.y = A.y >= b.y.i
                res.z = A.z >= b.z.i
                res.w = A.w >= b.w.i
            }
        }
        return res
    }

    fun equal(a: Vec4t<out Number>, b: Vec4t<out Number>, res: Vec4bool = Vec4bool()): Vec4bool {
        val A = a
        when (A) {
            is Vec4 -> {
                res.x = A.x == b.x.f
                res.y = A.y == b.y.f
                res.z = A.z == b.z.f
                res.w = A.w == b.w.f
            }
            is Vec4b -> {
                res.x = A.x == b.x.b
                res.y = A.y == b.y.b
                res.z = A.z == b.z.b
                res.w = A.w == b.w.b
            }
            is Vec4d -> {
                res.x = A.x == b.x.d
                res.y = A.y == b.y.d
                res.z = A.z == b.z.d
                res.w = A.w == b.w.d
            }
            is Vec4i -> {
                res.x = A.x == b.x.i
                res.y = A.y == b.y.i
                res.z = A.z == b.z.i
                res.w = A.w == b.w.i
            }
            is Vec4l -> {
                res.x = A.x == b.x.L
                res.y = A.y == b.y.L
                res.z = A.z == b.z.L
                res.w = A.w == b.w.L
            }
            is Vec4s -> {
                res.x = A.x == b.x.s
                res.y = A.y == b.y.s
                res.z = A.z == b.z.s
                res.w = A.w == b.w.s
            }
            is Vec4ub -> {
                res.x = A.x.v == b.x.b
                res.y = A.y.v == b.y.b
                res.z = A.z.v == b.z.b
                res.w = A.w.v == b.w.b
            }
            is Vec4ui -> {
                res.x = A.x.v == b.x.i
                res.y = A.y.v == b.y.i
                res.z = A.z.v == b.z.i
                res.w = A.w.v == b.w.i
            }
            is Vec4ul -> {
                res.x = A.x.v == b.x.L
                res.y = A.y.v == b.y.L
                res.z = A.z.v == b.z.L
                res.w = A.w.v == b.w.L
            }
            is Vec4us -> {
                res.x = A.x.v == b.x.s
                res.y = A.y.v == b.y.s
                res.z = A.z.v == b.z.s
                res.w = A.w.v == b.w.s
            }
        }
        return res
    }

    fun notEqual(a: Vec4t<out Number>, b: Vec4t<out Number>, res: Vec4bool = Vec4bool()): Vec4bool {
        val A = a
        when (A) {
            is Vec4 -> {
                res.x = A.x != b.x.f
                res.y = A.y != b.y.f
                res.z = A.z != b.z.f
                res.w = A.w != b.w.f
            }
            is Vec4b -> {
                res.x = A.x != b.x.b
                res.y = A.y != b.y.b
                res.z = A.z != b.z.b
                res.w = A.w != b.w.b
            }
            is Vec4d -> {
                res.x = A.x != b.x.d
                res.y = A.y != b.y.d
                res.z = A.z != b.z.d
                res.w = A.w != b.w.d
            }
            is Vec4i -> {
                res.x = A.x != b.x.i
                res.y = A.y != b.y.i
                res.z = A.z != b.z.i
                res.w = A.w != b.w.i
            }
            is Vec4l -> {
                res.x = A.x != b.x.L
                res.y = A.y != b.y.L
                res.z = A.z != b.z.L
                res.w = A.w != b.w.L
            }
            is Vec4s -> {
                res.x = A.x != b.x.s
                res.y = A.y != b.y.s
                res.z = A.z != b.z.s
                res.w = A.w != b.w.s
            }
            is Vec4ub -> {
                res.x = A.x.v != b.x.b
                res.y = A.y.v != b.y.b
                res.z = A.z.v != b.z.b
                res.w = A.w.v != b.w.b
            }
            is Vec4ui -> {
                res.x = A.x.v != b.x.i
                res.y = A.y.v != b.y.i
                res.z = A.z.v != b.z.i
                res.w = A.w.v != b.w.i
            }
            is Vec4ul -> {
                res.x = A.x.v != b.x.L
                res.y = A.y.v != b.y.L
                res.z = A.z.v != b.z.L
                res.w = A.w.v != b.w.L
            }
            is Vec4us -> {
                res.x = A.x.v != b.x.s
                res.y = A.y.v != b.y.s
                res.z = A.z.v != b.z.s
                res.w = A.w.v != b.w.s
            }
        }
        return res
    }

    fun isEqual(a: Vec4t<out Number>, b: Vec4t<out Number>): Boolean {
        val A = a
        var res = false
        when (A) {
            is Vec4 -> {
                res = ((A.x == b.x.f)
                        && (A.y == b.y.f)
                        && (A.z == b.z.f)
                        && (A.w == b.w.f))
            }
            is Vec4b -> {
                res = ((A.x == b.x.b)
                        && (A.y == b.y.b)
                        && (A.z == b.z.b)
                        && (A.w == b.w.b))
            }
            is Vec4d -> {
                res = ((A.x == b.x.d)
                        && (A.y == b.y.d)
                        && (A.z == b.z.d)
                        && (A.w == b.w.d))
            }
            is Vec4i -> {
                res = ((A.x == b.x.i)
                        && (A.y == b.y.i)
                        && (A.z == b.z.i)
                        && (A.w == b.w.i))
            }
            is Vec4l -> {
                res = ((A.x == b.x.L)
                        && (A.y == b.y.L)
                        && (A.z == b.z.L)
                        && (A.w == b.w.L))
            }
            is Vec4s -> {
                res = ((A.x == b.x.s)
                        && (A.y == b.y.s)
                        && (A.z == b.z.s)
                        && (A.w == b.w.s))
            }
            is Vec4ub -> {
                res = ((A.x.v == b.x.b)
                        && (A.y.v == b.y.b)
                        && (A.z.v == b.z.b)
                        && (A.w.v == b.w.b))
            }
            is Vec4ui -> {
                res = ((A.x.v == b.x.i)
                        && (A.y.v == b.y.i)
                        && (A.z.v == b.z.i)
                        && (A.w.v == b.w.i))
            }
            is Vec4ul -> {
                res = ((A.x.v == b.x.L)
                        && (A.y.v == b.y.L)
                        && (A.z.v == b.z.L)
                        && (A.w.v == b.w.L))
            }
            is Vec4us -> {
                res = ((A.x.v == b.x.s)
                        && (A.y.v == b.y.s)
                        && (A.z.v == b.z.s)
                        && (A.w.v == b.w.s))
            }
        }

        return res
    }

    fun any(a: Vec4bool) = a[0] || a[1] || a[2] || a[3]

    fun all(a: Vec4bool) = a[0] && a[1] && a[2] && a[3]

    fun not(a: Vec4bool, res: Vec4bool = Vec4bool()): Vec4bool {
        res[0] = !a[0]
        res[1] = !a[1]
        res[2] = !a[2]
        res[3] = !a[3]
        return res
    }
}

interface func_vectorBoolean_relational {

    fun equal(a: Vec2bool, b: Vec2bool, res: Vec2bool = Vec2bool()): Vec2bool {
        res[0] = a[0] == b[0]
        res[1] = a[1] == b[1]
        return res
    }

    fun notEqual(a: Vec2bool, b: Vec2bool, res: Vec2bool = Vec2bool()): Vec2bool {
        res[0] = a[0] != b[0]
        res[1] = a[1] != b[1]
        return res
    }

    fun equal(a: Vec3bool, b: Vec3bool, res: Vec3bool = Vec3bool()): Vec3bool {
        res[0] = a[0] == b[0]
        res[1] = a[1] == b[1]
        res[2] = a[2] == b[2]
        return res
    }

    fun notEqual(a: Vec3bool, b: Vec3bool, res: Vec3bool = Vec3bool()): Vec3bool {
        res[0] = a[0] != b[0]
        res[1] = a[1] != b[1]
        res[2] = a[2] != b[2]
        return res
    }

    fun equal(a: Vec4bool, b: Vec4bool, res: Vec4bool = Vec4bool()): Vec4bool {
        res[0] = a[0] == b[0]
        res[1] = a[1] == b[1]
        res[2] = a[2] == b[2]
        res[3] = a[3] == b[3]
        return res
    }

    fun notEqual(a: Vec4bool, b: Vec4bool, res: Vec4bool = Vec4bool()): Vec4bool {
        res[0] = a[0] != b[0]
        res[1] = a[1] != b[1]
        res[2] = a[2] != b[2]
        res[3] = a[3] != b[3]
        return res
    }
}