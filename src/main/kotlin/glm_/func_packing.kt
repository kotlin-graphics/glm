package glm_

import glm_.vec2.Vec2
import glm_.vec4.Vec4
import unsigned.toUInt

interface func_packing {

    fun packUnorm2x16(v: Vec2): Int {

        val x = glm.round(glm.clamp(v.x, 0f, 1f) * 65535f).s
        val y = glm.round(glm.clamp(v.y, 0f, 1f) * 65535f).s

        val a = x.toUInt() shl 16
        val b = y.toUInt()

        return a or b
    }

    fun unpackUnorm2x16(p: Int, res: Vec2 = Vec2()): Vec2 {

        val x = (p ushr 16).s
        val y = (p and 0xffff).s

        res.x = x.toUInt().f * 1.5259021896696421759365224689097e-5f
        res.y = y.toUInt().f * 1.5259021896696421759365224689097e-5f

        return res
    }

    fun packSnorm2x16(v: Vec2): Int {

        val x = glm.round(glm.clamp(v.x, -1f, 1f) * 32767f).s
        val y = glm.round(glm.clamp(v.y, -1f, 1f) * 32767f).s

        val a = x.i shl 16
        val b = (y.i and 0xffff)

        return a or b
    }

    fun unpackSnorm2x16(p: Int, res: Vec2 = Vec2()): Vec2 {

        val x = (p shr 16).s
        val y = (p and 0xffff).s

        res.x = glm.clamp(x.f * 3.0518509475997192297128208258309e-5f, -1f, 1f)
        res.y = glm.clamp(y.f * 3.0518509475997192297128208258309e-5f, -1f, 1f)

        return res
    }

    fun packUnorm4x8(v: Vec4): Int {

        val x = glm.round(glm.clamp(v.x, 0f, 1f) * 255f).b
        val y = glm.round(glm.clamp(v.y, 0f, 1f) * 255f).b
        val z = glm.round(glm.clamp(v.z, 0f, 1f) * 255f).b
        val w = glm.round(glm.clamp(v.w, 0f, 1f) * 255f).b

        val a = x.toUInt() shl 24
        val b = (y.toUInt() and 0xff) shl 16
        val c = (z.toUInt() and 0xff) shl 8
        val d = w.toUInt() and 0xff

        return a or b or c or d
    }

    fun unpackUnorm4x8(p: Int, res: Vec4 = Vec4()): Vec4 {

        val x = (p ushr 24).b
        val y = ((p ushr 16) and 0xff).b
        val z = ((p ushr 8) and 0xff).b
        val w = (p and 0xff).b

        res.x = x.toUInt().f * 0.0039215686274509803921568627451f
        res.y = y.toUInt().f * 0.0039215686274509803921568627451f
        res.z = z.toUInt().f * 0.0039215686274509803921568627451f
        res.w = w.toUInt().f * 0.0039215686274509803921568627451f

        return res
    }

    fun packSnorm4x8(v: Vec4): Int {

        val x = glm.round(glm.clamp(v.x, -1f, 1f) * 127f).b
        val y = glm.round(glm.clamp(v.y, -1f, 1f) * 127f).b
        val z = glm.round(glm.clamp(v.z, -1f, 1f) * 127f).b
        val w = glm.round(glm.clamp(v.w, -1f, 1f) * 127f).b

        val a = x.i shl 24
        val b = (y.i and 0xff) shl 16
        val c = (z.i and 0xff) shl 8
        val d = w.i and 0xff

        return a or b or c or d
    }

    fun unpackSnorm4x8(p: Int, res: Vec4 = Vec4()): Vec4 {

        val x = (p shr 24).b
        val y = ((p shr 16) and 0xff).b
        val z = ((p shr 8) and 0xff).b
        val w = (p and 0xff).b

        res.x = glm.clamp(x.f * 0.0078740157480315f, -1f, 1f)
        res.y = glm.clamp(y.f * 0.0078740157480315f, -1f, 1f)
        res.z = glm.clamp(z.f * 0.0078740157480315f, -1f, 1f)
        res.w = glm.clamp(w.f * 0.0078740157480315f, -1f, 1f)

        return res
    }
}