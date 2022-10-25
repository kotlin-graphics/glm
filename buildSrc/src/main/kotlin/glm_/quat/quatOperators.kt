package glm_.quat

import glm_.WxyzJoint
import glm_.XyzwJoint
import glm_.gen.Generator
import glm_.wxyzJoint
import glm_.xyzwJoint
import glm_.`2`


fun Generator.quatOperators(type: String, extension: String, conversion: String, id: String, part: Generator.Part) {

    +"// -- Unary arithmetic operators --\n"

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
    val `2` = type.`2`

    // only + and -
    for ((sign, func) in operators.take(2)) {
        val `qWxyz func pWxyz` = WxyzJoint { "q$it $sign p$it" }
        when (part) {
            Generator.Part.Class -> {
                +"operator infix fun ${func}Assign(p: Quat$id) { w ${sign}= p.w; x ${sign}= p.x; y ${sign}= p.y; z ${sign}= p.z }"
                +"operator infix fun $func(p: Quat$id): Quat$id = $func(p, Quat$id())"
                +"fun ${func}Assign($`pWxyz type`): Quat$id = $func($pWxyz, this)"
                +"fun $func(p: Quat$id, res: Quat$id): Quat$id = $func($`p,wxyz`, res)"
                +"fun $func($`pWxyz type`, res: Quat$id): Quat$id = Companion.$func($wxyz, $pWxyz) { $wxyz -> res($wxyz) }"
                +"""
                inline fun <R> $func(p: Quat$id, res: ($`wxyz type`) -> R): R {
                    $contract
                    return $func($`p,wxyz`, res)
                }"""
                +"""
                inline fun <R> $func($`pWxyz type`, res: ($`wxyz type`) -> R): R {
                    $contract
                    return $func($wxyz, $pWxyz, res)
                }"""
            }
            Generator.Part.CompanionObject -> {
                +"""
                inline fun <R> $func(q: Quat$id, p: Quat$id, res: ($`wxyz type`) -> R): R {
                    $contract
                    return $func($`q,wxyz`, $`p,wxyz`, res)
                }"""
                +"""
                inline fun <R> $func($`qWxyz type`, $`pWxyz type`, res: ($`wxyz type`) -> R): R {
                    $contract
                    return res($`qWxyz func pWxyz`)
                }"""
            }
            else -> Unit
        }
    }

    when (part) {
        Generator.Part.Class -> {
            // quat
            +"operator infix fun timesAssign(p: Quat$id) = Companion.times($wxyz, $`p,wxyz`) { $wxyz -> put($wxyz) }"
            +"operator infix fun times(p: Quat$id): Quat$id = times(p, Quat$id())"
            +"fun timesAssign($`pWxyz type`): Quat$id = times($pWxyz, this)"
            +"fun times(p: Quat$id, res: Quat$id): Quat$id = times($`p,wxyz`, res)"
            +"fun times($`pWxyz type`, res: Quat$id): Quat$id = Companion.times($wxyz, $pWxyz) { $wxyz -> res($wxyz) }"
            +"""
                inline fun <R> times(p: Quat$id, res: ($`wxyz type`) -> R): R {
                    $contract
                    return times($`p,wxyz`, res)
                }"""
            +"""
                inline fun <R> times($`pWxyz type`, res: ($`wxyz type`) -> R): R {
                    $contract
                    return times($wxyz, $pWxyz, res)
                }"""
            // vec3
            +"operator infix fun times(v: Vec3$id): Vec3$id = times(v, Vec3$id())"
            +"fun times(v: Vec3$id, res: Vec3$id): Vec3$id = times($`v,xyz`, res)"
            +"fun times($`vXyz type`, res: Vec3$id): Vec3$id = Companion.times($wxyz, $vXyz) { $xyz -> res($xyz) }"
            +"""
                inline fun <R> times(v: Vec3$id, res: ($`xyz type`) -> R): R {
                    $contract
                    return times($`v,xyz`, res)
                }"""
            +"""
                inline fun <R> times($`vXyz type`, res: ($`xyz type`) -> R): R {
                    $contract
                    return times($wxyz, $vXyz, res)
                }"""
            // vec4
            +"operator infix fun times(v: Vec4$id): Vec4$id = times(v, Vec4$id())"
            +"fun times(v: Vec4$id, res: Vec4$id): Vec4$id = timesV4($`v,xyzw`, res)"
            +"fun timesV4($`vXyzw type`, res: Vec4$id): Vec4$id = Companion.times($wxyz, $vXyzw) { $xyzw -> res($xyzw) }"
            +"""
                inline fun <R> times(v: Vec4$id, res: ($`xyzw type`) -> R): R {
                    $contract
                    return timesV4($`v,xyzw`, res)
                }"""
            +"""
                inline fun <R> timesV4($`vXyzw type`, res: ($`xyzw type`) -> R): R {
                    $contract
                    return timesV4($wxyz, $vXyzw, res)
                }"""
        }
        Generator.Part.CompanionObject -> {
            // quat
            +"""
                inline fun <R> times(q: Quat$id, p: Quat$id, res: ($`wxyz type`) -> R): R {
                    $contract
                    return times($`q,wxyz`, $`p,wxyz`, res)
                }"""
            +"""
                inline fun <R> times($`qWxyz type`, $`pWxyz type`, res: ($`wxyz type`) -> R): R {
                    $contract
                    return res(qW * pW - qX * pX - qY * pY - qZ * pZ,
                               qW * pX + qX * pW + qY * pZ - qZ * pY,
                               qW * pY + qY * pW + qZ * pX - qX * pZ,
                               qW * pZ + qZ * pW + qX * pY - qY * pX)
                }"""

            // vec3
            +"""
                inline fun <R> times(q: Quat$id, v: Vec3$id, res: ($`xyz type`) -> R): R {
                    $contract
                    return times($`q,wxyz`, $`v,xyz`, res)
                }"""
            +"""
                inline fun <R> times($`qWxyz type`, $`vXyz type`, res: ($`xyz type`) -> R): R {
                    $contract
                    val quatVectorX = qX; val quatVectorY = qY; val quatVectorZ = qZ
                    Vec3$id.cross(quatVectorX, quatVectorY, quatVectorZ, vX, vY, vZ) { uvX, uvY, uvZ ->
                        Vec3$id.cross(quatVectorX, quatVectorY, quatVectorZ, uvX, uvY, uvZ) { uuvX, uuvY, uuvZ ->
                            return res(vX + ((uvX * qW) + uuvX) * $`2`,
                                       vY + ((uvY * qW) + uuvY) * $`2`,
                                       vZ + ((uvZ * qW) + uuvZ) * $`2`)
                        }
                    }
                }"""
            // vec4
            +"""
                inline fun <R> times(q: Quat$id, v: Vec4$id, res: ($`xyzw type`) -> R): R {
                    $contract
                    return timesV4($`q,wxyz`, $`v,xyzw`, res)
                }"""
            +"""
                inline fun <R> timesV4($`qWxyz type`, $`vXyzw type`, res: ($`xyzw type`) -> R): R {
                    $contract
                    Quat$id.times($qWxyz, $vXyz) { $xyz ->
                        return res($xyz, vW)
                    }
                }"""
        }
        else -> Unit
    }

    // scalar
    // only * and /
    for ((sign, func) in operators.drop(2)) {
        when(part) {
            Generator.Part.Class -> {
                +"operator infix fun ${func}Assign(s: $type) = Companion.$func($wxyz, s) { $wxyz -> put($wxyz) }"
                +"operator infix fun $func(s: $type): Quat$id = $func(s, Quat$id())"
                +"fun $func(s: $type, res: Quat$id): Quat$id = $func(s, res)"
                +"""
                inline fun <R> $func(s: $type, res: ($`wxyz type`) -> R): R {
                    $contract
                    return Companion.$func($wxyz, s, res)
                }"""
            }
            Generator.Part.CompanionObject -> {
                +"""
                inline fun <R> $func(q: Quat$id, s: $type, res: ($`wxyz type`) -> R): R {
                    $contract
                    return $func($`q,wxyz`, s, res)
                }"""
                +"""
                inline fun <R> $func($`qWxyz type`, s: $type, res: ($`wxyz type`) -> R): R {
                    $contract
                    return res(qW $sign s, qX $sign s, qY $sign s, qZ $sign s)
                }"""
            }
        }
    }
}