package glm_.ext

import glm_.*
import glm_.gen.Generator
import glm_.gen.generate
import java.io.File

fun Generator.extQuatTrigonometric(type: String, extension: String, conversion: String, id: String, part: Generator.Part) {

    +"// quaternion trigonometric"

    imports += listOf(
        "glm_.scalar.sqrt",
        "glm_.scalar.asin",
        "glm_.scalar.sin",
        "glm_.scalar.acos",
        "glm_.scalar.cos",
//        "glm_.vec4.Vec4bool",
        "glm_.glm",
                     )

    val `wxyz type` = wxyzJoint { "$it: $type" }
    val xyz = xyzwJoint(3)
    val xyzw = xyzwJoint(4)
    val `xyz type` = xyzwJoint(3) { "$it: $type" }
    val `wxyz Boolean` = wxyzJoint { "$it: Boolean" }
    val `v,xyz` = xyzwJoint(3) { "v.$it" }
    val `v,xyzw` = xyzwJoint(4) { "v.$it" }
    val vXyz = XyzwJoint(3) { "v$it" }
    val vXyzw = XyzwJoint(4) { "v$it" }
    val `vXyz type` = XyzwJoint(3) { "v$it: $type" }
    val `vXyzw type` = XyzwJoint(4) { "v$it: $type" }
    val wxyz = wxyzJoint()
    val `q,wxyz` = wxyzJoint { "q.$it" }
    val `qWxyz type` = WxyzJoint { "q$it: $type" }
    val qWxyz = WxyzJoint { "q$it" }
    val `p,wxyz` = wxyzJoint { "p.$it" }
    val `pWxyz type` = WxyzJoint { "p$it: $type" }
    val pWxyz = WxyzJoint { "p$it" }
    val `2` = type.`2`
    val `1` = type.`1`
    val `0` = type.`0`

    // probably redundant for Quats
    if (type !in floatingPointTypes)
        return

    fun angle() = docs("Returns the quaternion rotation angle.")
    when(part) {
        Generator.Part.Class -> {
            angle()
            +"fun angle(): $type = Companion.angle($wxyz)"
        }
        Generator.Part.CompanionObject -> {
            angle()
            +"fun angle(q: Quat$id): $type = angle($`q,wxyz`)"
            angle()
            +"""
                fun angle($`wxyz type`): $type {
                    if (w.abs() > glm.`cos 1 over 2`.$extension) {
                        val a = (x * x + y * y + z * z).sqrt().asin * $`2`
                        if(w < $`0`)
                            return glm.pi.$extension * $`2` - a
                        return a
                    }
                    return w.acos * $`2`
                }"""
        }
        else -> Unit
    }


    fun axis(q: String = "this[wxyz]") = docs("Returns the `$q` rotation axis.")
    when(part) {
        Generator.Part.Class -> {
            axis()
            +"fun axis(res: Vec3$id = Vec3$id()): Vec3$id = axis { $xyz -> res($xyz) }"
            axis()
            +"""
                inline fun <R> axis(res: ($`xyz type`) -> R): R {
                    $contract
                    return Companion.axis(this, res)
                }"""
        }
        Generator.Part.CompanionObject -> {
            axis("q")
            +"""
                inline fun <R> axis(q: Quat$id, res: ($`xyz type`) -> R): R {
                    $contract
                    return axis($`q,wxyz`, res)
                }"""
            axis("[wxyz]")
            +"""
                inline fun <R> axis($`wxyz type`, res: ($`xyz type`) -> R): R {
                    $contract
                    val tmp1 = $`1` - w * w
                    if(tmp1 <= $`0`)
                        return res($`0`, $`0`, $`1`)
                    val tmp2 = $`1` / tmp1.sqrt()
                    return res(x * tmp2, y * tmp2, z * tmp2)
                }"""
        }
        else -> Unit
    }
}

fun extQuatTrigonometric(target: File) {
    generate(target, "glm_/ext/extQuatTrigonometric.kt") {

        experimentals += Generator.Experimentals.Contracts
        `package` = "glm_.ext"

        //            +"import glm_.extensions.swizzle.*"
        for ((type, extension, _, id) in numberTypeInformation.filter { it.type in floatingPointTypes })
            quatTrigonometric(type, extension, id)
    }
}


fun Generator.quatTrigonometric(type: String, extension: String, id: String) {

    val `v,xyz` = xyzwJoint(3) { "v.$it" }
    val vXyz = XyzwJoint(3) { "v$it" }
    val `v,xyzw` = xyzwJoint(4) { "v.$it" }
    val `vXyz type` = XyzwJoint(3) { "v$it: $type" }
    val `vXyzw type` = XyzwJoint(4) { "v$it: $type" }
    val `wxyz type` = wxyzJoint { "$it: $type" }
    val wxyz = wxyzJoint()
    val `0,5` = type.`0,5`

    imports += listOf(
        "glm_.glm",
        "glm_.quat.Quat$id",
        "glm_.vec3.Vec3$id",
        "glm_.scalar.sin",
        "glm_.scalar.cos",
                     )

    fun angleAxis() = docs("""
        |Build a quaternion from an angle and a normalized axis.
        |
        |@param angle Angle expressed in radians.
        |@param axis Axis of the quaternion, must be normalized.""")
    angleAxis()
    +"fun glm.angleAxis(angle: $type, v: Vec3$id, res: Quat$id = Quat$id()): Quat$id = glm.angleAxis(angle, $`v,xyz`, res)"
    angleAxis()
    +"fun glm.angleAxis(angle: $type, $`vXyz type`, res: Quat$id = Quat$id()): Quat$id = glm.angleAxis(angle, $vXyz) { $wxyz -> res($wxyz) }"
    angleAxis()
    +"""
        inline fun <R> glm.angleAxis(angle: $type, v: Vec3$id, res: ($`wxyz type`) -> R): R {
            $contract
            return glm.angleAxis(angle, $`v,xyz`, res)
        }"""
    angleAxis()
    +"""
        inline fun <R> glm.angleAxis(angle: $type, $`vXyz type`, res: ($`wxyz type`) -> R): R {
            $contract
            val s = (angle * $`0,5`).sin
            return res((angle * $`0,5`).cos, vX * s, vY * s, vZ * s)
        }"""
}
