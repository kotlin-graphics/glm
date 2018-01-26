package glm_.vec4.operators

import glm_.vec4.Vec4bool

open class vec4bool_operators {

    inline fun and(res: Vec4bool, a: Vec4bool, bX: Boolean, bY: Boolean, bZ: Boolean, bW: Boolean): Vec4bool {
        res.x = a.x and bX
        res.y = a.y and bY
        res.z = a.z and bZ
        res.w = a.w and bW
        return res
    }

    inline fun or(res: Vec4bool, a: Vec4bool, bX: Boolean, bY: Boolean, bZ: Boolean, bW: Boolean): Vec4bool {
        res.x = a.x or bX
        res.y = a.y or bY
        res.z = a.z or bZ
        res.w = a.w or bW
        return res
    }

    inline fun xor(res: Vec4bool, a: Vec4bool, bX: Boolean, bY: Boolean, bZ: Boolean, bW: Boolean): Vec4bool {
        res.x = a.x xor bX
        res.y = a.y xor bY
        res.z = a.z xor bZ
        res.w = a.w xor bW
        return res
    }
}