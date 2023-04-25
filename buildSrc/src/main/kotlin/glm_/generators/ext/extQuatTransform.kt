package glm_.generators.ext

import glm_.generators.*
import glm_.generators.gen.Generator

fun Generator.extQuatTransform(type: Type, part: Generator.Part) {

    +"// ext quaternion transform\n"

    imports += listOf(
        "glm_.scalar.abs",
        "glm_.scalar.cos",
//        "glm_.scalar.sin",
//        "glm_.scalar.mix",
//        "glm_.vec4.Vec4bool",
//        "glm_.glm",
                     )

    val id = type.id
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
    val `axisXyz type` = XyzwJoint(3) { "axis$it: $type" }
    val axisXyz = XyzwJoint(3) { "axis$it" }
    val `axis,xyz` = xyzwJoint(3) { "axis.$it" }
    val wxyz = wxyzJoint()
    val `q,wxyz` = wxyzJoint { "q.$it" }
    val `qWxyz type` = WxyzJoint { "q$it: $type" }
    val qWxyz = WxyzJoint { "q$it" }
    val `p,wxyz` = wxyzJoint { "p.$it" }
    val `pWxyz type` = WxyzJoint { "p$it: $type" }
    val pWxyz = WxyzJoint { "p$it" }
    val `1` = type.`1`
    val `0` = type.`0`
    val `0,5` = type.`0,5`

    // probably redundant for Quats
    if (type !in floatingPointTypes)
        return

    fun rotate() = docs("""
        |Rotates a quaternion from a vector of 3 components axis and an angle.
        |
        |@param q Source orientation
        |@param angle Angle expressed in radians.
        |@param axis Axis of the rotation""")
    when(part) {
        Generator.Part.Class -> {
            rotate()
            +"fun rotate(angle: $type, axis: Vec3$id, res: Quat$id = Quat$id()): Quat$id = rotate(angle, $`axis,xyz`, res)"
            rotate()
            +"fun rotate(angle: $type, $`axisXyz type`, res: Quat$id = Quat$id()): Quat$id = rotate(angle, $axisXyz) { $wxyz -> res($wxyz) }"
            rotate()
            +"""
                inline fun <R> rotate(angle: $type, axis: Vec3$id, res: ($`wxyz type`) -> R): R {
                    $contract
                    return rotate(angle, $`axis,xyz`, res)
                }"""
            rotate()
            +"""
                inline fun <R> rotate(angle: $type, $`axisXyz type`, res: ($`wxyz type`) -> R): R {
                    $contract
                    return Companion.rotate($wxyz, angle, $axisXyz, res)
                }"""
        }
        Generator.Part.CompanionObject -> {
            rotate()
            +"""
                inline fun <R> rotate(q: Quat$id, angle: $type, axis: Vec3$id, res: ($`wxyz type`) -> R): R {
                    $contract
                    return rotate($`q,wxyz`, angle, $`axis,xyz`, res)
                }"""
            rotate()
            val `0,001` = if (type == Type.Float) "0.001f" else "0.001"
            +"""
                inline fun <R> rotate($`qWxyz type`, angle: $type, $`axisXyz type`, res: ($`wxyz type`) -> R): R {
                    $contract
                    var tmpX = axisX; var tmpY = axisY; var tmpZ = axisZ

                    // Axis of rotation must be normalised
                    val len = Vec3$id.length(tmpX, tmpY, tmpZ)
                    if((len - $`1`).abs() > $`0,001`) {
                        val oneOverLen = $`1` / len
                        tmpX *= oneOverLen
                        tmpY *= oneOverLen
                        tmpZ *= oneOverLen
                    }
            
                    val sin = (angle * $`0,5`).sin
            
                    Quat$id.times($qWxyz, (angle * $`0,5`).cos, tmpX * sin, tmpY * sin, tmpZ * sin) { $wxyz ->
                        return res($wxyz)
                    }
                }"""
        }
        else -> Unit
    }
}