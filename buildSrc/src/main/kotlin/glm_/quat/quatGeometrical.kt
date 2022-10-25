package glm_.quat

import glm_.WxyzJoint
import glm_.XyzwJoint
import glm_.gen.Generator
import glm_.wxyzJoint
import glm_.xyzwJoint
import glm_.`0`
import glm_.`1`

fun Generator.quatGeometrical(type: String, extension: String, conversion: String, id: String, part: Generator.Part) {

    +"// quat geometrical\n"

    imports += listOf(
        "glm_.scalar.sqrt"
                     )

    val `wxyz type` = wxyzJoint { "$it: $type" }
    val xyz = xyzwJoint(3)
    val xyzw = xyzwJoint(4)
    val `xyz type` = xyzwJoint(3) { "$it: $type" }
    val `xyzw type` = xyzwJoint(4) { "$it: $type" }
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
//    val `2` = type.`2`
    val `0` = type.`0`
    val `1` = type.`1`

    fun length() = docs("Returns the norm of a quaternions")
    when (part) {
        Generator.Part.Class -> {
            length()
            +"fun length(): $type = Companion.length($wxyz)"
        }
        Generator.Part.CompanionObject -> {
            length()
            +"fun length(q: Quat$id): $type = length($`q,wxyz`)"
            length()
            +"fun length($`qWxyz type`): $type = Companion.dot($qWxyz, $qWxyz).sqrt()"
        }
        else -> Unit
    }

    fun normalize() = docs("Returns the normalized quaternion.")
    when (part) {
        Generator.Part.Class -> {
            normalize()
            +"fun normalizeAssign(): Quat$id = normalize(this)"
            normalize()
            +"fun normalize(res: Quat$id = Quat$id()): Quat$id = Companion.normalize($wxyz) { $wxyz -> res($wxyz) }"
        }
        Generator.Part.CompanionObject -> {
            normalize()
            +"""
                inline fun <R> normalize(q: Quat$id, res: ($`wxyz type`) -> R): R {
                    $contract
                    return normalize($`q,wxyz`, res)
                }"""
            normalize()
            +"""
                inline fun <R> normalize($`qWxyz type`, res: ($`wxyz type`) -> R): R {
                    $contract
                    val len = length($qWxyz)
                    if(len <= $`0`) // Problem
                        return res($`1`, $`0`, $`0`, $`0`)
                    val oneOverLen = $`1` / len
                    return res(qW * oneOverLen, qX * oneOverLen, qY * oneOverLen, qZ * oneOverLen)
                }"""
        }
        else -> Unit
    }

    fun dot() = docs("Returns dot product of q1 and q2, i.e., q1[0] * q2[0] + q1[1] * q2[1] + ...")
    when (part) {
        Generator.Part.Class -> {
            dot()
            +"infix fun dot(p: Quat$id): $type = Companion.dot($wxyz, $`p,wxyz`)"
            dot()
            +"fun dot($`pWxyz type`): $type = Companion.dot($wxyz, $pWxyz)"
        }
        Generator.Part.CompanionObject -> {
            dot()
            +"fun dot(q: Quat$id, p: Quat$id): $type = dot($`q,wxyz`, $`p,wxyz`)"
            dot()
            +"fun dot($`qWxyz type`, $`pWxyz type`): $type = qW * pW + qX * pX + qY * pY + qZ * pZ"
        }
        else -> Unit
    }

    fun cross() = docs("Compute a cross product.")
    when (part) {
        Generator.Part.Class -> {
            cross()
            +"fun crossAssign(): Quat$id = cross(this, this)"
            cross()
            +"infix fun cross(p: Quat$id): Quat$id = cross(p, Quat$id())"
            cross()
            +"fun cross(p: Quat$id, res: Quat$id): Quat$id = Companion.cross($wxyz, $`p,wxyz`) { $wxyz -> res($wxyz) }"
        }
        Generator.Part.CompanionObject -> {
            cross()
            +"""
                inline fun <R> cross(q: Quat$id, p: Quat$id, res: ($`wxyz type`) -> R): R {
                    $contract
                    return cross($`q,wxyz`, $`p,wxyz`, res)
                }"""
            cross()
            +"""
                inline fun <R> cross($`qWxyz type`, $`pWxyz type`, res: ($`wxyz type`) -> R): R {
                    $contract
                    return res(qW * pW - qX * pX - qY * pY - qZ * pZ,
                               qW * pX + qX * pW + qY * pZ - qZ * pY,
                               qW * pY + qY * pW + qZ * pX - qX * pZ,
                               qW * pZ + qZ * pW + qX * pY - qY * pX)
                }"""
        }
        else -> Unit
    }
}