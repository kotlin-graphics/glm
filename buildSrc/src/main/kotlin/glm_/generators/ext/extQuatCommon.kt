package glm_.generators.ext

import glm_.generators.*
import glm_.generators.gen.Generator

fun Generator.extQuatCommon(type: Type, part: Generator.Part) {

    +"// ext quaternion common\n"

    imports += listOf(
        "glm_.scalar.abs",
        "glm_.scalar.acos",
        "glm_.scalar.sin",
        "glm_.scalar.mix",
        "glm_.vec4.Vec4bool",
        "glm_.glm",
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
    val wxyz = wxyzJoint()
    val `q,wxyz` = wxyzJoint { "q.$it" }
    val `qWxyz type` = WxyzJoint { "q$it: $type" }
    val qWxyz = WxyzJoint { "q$it" }
    val `p,wxyz` = wxyzJoint { "p.$it" }
    val `pWxyz type` = WxyzJoint { "p$it: $type" }
    val pWxyz = WxyzJoint { "p$it" }
    val `1` = type.`1`
    val `0` = type.`0`

    // probably redundant for Quats
    if (type !in floatingPointTypes)
        return

    fun mix(x: String, y: String, a: String) = docs("""
        |Spherical linear interpolation of two quaternions.
        |The interpolation is oriented and the rotation is performed at constant speed.
        |For short path spherical linear interpolation, use the slerp function.
        |
        |@param $x A quaternion
        |@param $y A quaternion
        |@param $a Interpolation factor. The interpolation is defined beyond the range `[0, 1]`.
        |
        |@see - slerp(qua<T, Q> const& x, qua<T, Q> const& y, T const& a)""")
    when(part) {
        Generator.Part.Class -> {
            mix("this", "p", "a")
            +"fun mix(p: Quat$id, a: $type, res: Quat$id = Quat$id()): Quat$id = mix($`p,wxyz`, a, res) "
            mix("this[XYZW]", "p[WXYZ]", "a")
            +"fun mix($`pWxyz type`, a: $type, res: Quat$id = Quat$id()): Quat$id = Companion.mix($wxyz, $pWxyz, a) { $wxyz -> res($wxyz) }"
            mix("this", "p", "a")
            +"""
                inline fun <R> mix(p: Quat$id, a: $type, res: ($`wxyz type`) -> R): R {
                    $contract
                    return mix($`p,wxyz`, a, res)
                }"""
            mix("this", "p[WXYZ]", "a")
            +"""
                inline fun <R> mix($`pWxyz type`, a: $type, res: ($`wxyz type`) -> R): R {
                    $contract
                    return Companion.mix($wxyz, $pWxyz, a, res)
                }"""
        }
        Generator.Part.CompanionObject -> {
            mix("q", "p", "a")
            +"""
                inline fun <R> mix(q: Quat$id, p: Quat$id, a: $type, res: ($`wxyz type`) -> R): R {
                    $contract
                    return mix($`q,wxyz`, $`p,wxyz`, a, res)
                }"""
            mix("q[WXYZ]", "p[WXYZ]", "a")
            +"""
                inline fun <R> mix($`qWxyz type`, $`pWxyz type`, a: $type, res: ($`wxyz type`) -> R): R {
                    $contract
                    val cosTheta = Quat$id.dot($qWxyz, $pWxyz)
                    
                    // Perform a linear interpolation when cosTheta is close to 1 to avoid side effect of sin(angle) becoming a zero denominator
                    return when {
                        // Linear interpolation
                        cosTheta > $`1` - $type.MIN_VALUE -> res(qW.mix(pW, a), qX.mix(pX, a), qY.mix(pY, a), qZ.mix(pZ, a))
                        else -> {
                            // Essential Mathematics, page 467
                            val angle = cosTheta.acos
                            val x = (($`1` - a) * angle).sin 
                            val y = (a * angle).sin
                            val z = angle.sin
                            res((x * qW + y * pW) / z, (x * qX + y * pX) / z, (x * qY + y * pY) / z, (x * qZ + y * pZ) / z)
                        }
                    }
                }"""
        }
        else -> Unit
    }

    fun lerp(x: String, y: String, a: String) = docs("""
        |Linear interpolation of two quaternions.
        |The interpolation is oriented.
        |
        |@param $x A quaternion
        |@param $y A quaternion
        |@param $a Interpolation factor. The interpolation is defined in the range `[0, 1]`.""")
    when(part) {
        Generator.Part.Class -> {
            lerp("this", "p", "a")
            +"fun lerp(p: Quat$id, a: $type, res: Quat$id = Quat$id()): Quat$id = lerp($`p,wxyz`, a, res) "
            lerp("this[WXYZ]", "p[WXYZ]", "a")
            +"fun lerp($`pWxyz type`, a: $type, res: Quat$id = Quat$id()): Quat$id = Companion.lerp($wxyz, $pWxyz, a) { $wxyz -> res($wxyz) }"
            lerp("this", "p", "a")
            +"""
                inline fun <R> lerp(p: Quat$id, a: $type, res: ($`wxyz type`) -> R): R {
                    $contract
                    return lerp($`p,wxyz`, a, res)
                }"""
            lerp("this[WXYZ]", "p[WXYZ]", "a")
            +"""
                inline fun <R> lerp($`pWxyz type`, a: $type, res: ($`wxyz type`) -> R): R {
                    $contract
                    return Companion.lerp($wxyz, $pWxyz, a, res)
                }"""
        }
        Generator.Part.CompanionObject -> {
            lerp("q", "p", "a")
            +"""
                inline fun <R> lerp(q: Quat$id, p: Quat$id, a: $type, res: ($`wxyz type`) -> R): R {
                    $contract
                    return lerp($`q,wxyz`, $`p,wxyz`, a, res)
                }"""
            lerp("q[WXYZ]", "p[WXYZ]", "a")
            +"""
                inline fun <R> lerp($`qWxyz type`, $`pWxyz type`, a: $type, res: ($`wxyz type`) -> R): R {
                    $contract
                    check(a >= $`0` && a <= $`1`) { "Lerp is only defined in [0, 1]" }

                    val oma = $`1` - a
                    return res(qW * oma + pW * a, qX * oma + pX * a, qY * oma + pY * a, qZ * oma + pZ * a)
                }"""
        }
        else -> Unit
    }

    fun slerp(x: String, y: String, a: String) = docs("""
        |Spherical linear interpolation of two quaternions.
        |The interpolation always take the short path and the rotation is performed at constant speed.
        |
        |@param $x A quaternion
        |@param $y A quaternion
        |@param $a Interpolation factor. The interpolation is defined beyond the range `[0, 1]`.""")
    when(part) {
        Generator.Part.Class -> {
            slerp("this", "p", "a")
            +"fun slerp(p: Quat$id, a: $type, res: Quat$id = Quat$id()): Quat$id = slerp($`p,wxyz`, a, res) "
            slerp("this[WXYZ]", "p[WXYZ]", "a")
            +"fun slerp($`pWxyz type`, a: $type, res: Quat$id = Quat$id()): Quat$id = Companion.slerp($wxyz, $pWxyz, a) { $wxyz -> res($wxyz) }"
            slerp("this", "p", "a")
            +"""
                inline fun <R> slerp(p: Quat$id, a: $type, res: ($`wxyz type`) -> R): R {
                    $contract
                    return slerp($`p,wxyz`, a, res)
                }"""
            slerp("this[WXYZ]", "p[WXYZ]", "a")
            +"""
                inline fun <R> slerp($`pWxyz type`, a: $type, res: ($`wxyz type`) -> R): R {
                    $contract
                    return Companion.slerp($wxyz, $pWxyz, a, res)
                }"""
        }
        Generator.Part.CompanionObject -> {
            slerp("q", "p", "a")
            +"""
                inline fun <R> slerp(q: Quat$id, p: Quat$id, a: $type, res: ($`wxyz type`) -> R): R {
                    $contract
                    return slerp($`q,wxyz`, $`p,wxyz`, a, res)
                }"""
            slerp("q[WXYZ]", "p[WXYZ]", "a")
            +"""
                inline fun <R> slerp($`qWxyz type`, $`pWxyz type`, a: $type, res: ($`wxyz type`) -> R): R {
                    $contract
                    var rW = pW; var rX = pX; var rY = pY; var rZ = pZ

                    var cosTheta = Quat$id.dot($qWxyz, $pWxyz)
            
                    // If cosTheta < 0, the interpolation will take the long way around the sphere.
                    // To fix this, one quat must be negated.
                    if(cosTheta < $`0`) {
                        rW = -pW; rX = -pX; rY = -pY; rZ = -pZ
                        cosTheta = -cosTheta
                    }
            
                    // Perform a linear interpolation when cosTheta is close to 1 to avoid side effect of sin(angle) becoming a zero denominator
                    return when { 
                        // Linear interpolation
                        cosTheta > $`1` - $type.MIN_VALUE -> res(qW.mix(rW, a), qX.mix(rX, a), qY.mix(rY, a), qZ.mix(rZ, a))
                        else -> {
                            // Essential Mathematics, page 467
                            val angle = cosTheta.acos
                            val s = (($`1` - a) * angle).sin
                            val t = (a * angle).sin
                            val u = angle.sin
                            res((s * qW + t * rW) / u, (s * qX + t * rX) / u, (s * qY + t * rY) / u, (s * qZ + t * rZ) / u)
                        }
                    }
                }"""
        }
        else -> Unit
    }

    fun slerp2(x: String, y: String, a: String, k: String = "k") = docs("""
        |Spherical linear interpolation of two quaternions with multiple spins over rotation axis.
        |The interpolation always take the short path when the spin count is positive and long path
        |when count is negative. Rotation is performed at constant speed.
        |
        |@param $x A quaternion
        |@param $y A quaternion
        |@param $a Interpolation factor. The interpolation is defined beyond the range `[0, 1]`.
        |@param $k Additional spin count. If Value is negative interpolation will be on "long" path.""")
    when(part) {
        Generator.Part.Class -> {
            slerp2("this", "p", "a")
            +"fun slerp(p: Quat$id, a: $type, k: Int, res: Quat$id = Quat$id()): Quat$id = slerp($`p,wxyz`, a, k, res) "
            slerp2("this[WXYZ]", "p[WXYZ]", "a")
            +"fun slerp($`pWxyz type`, a: $type, k: Int, res: Quat$id = Quat$id()): Quat$id = Companion.slerp($wxyz, $pWxyz, a, k) { $wxyz -> res($wxyz) }"
            slerp2("this", "p", "a")
            +"""
                inline fun <R> slerp(p: Quat$id, a: $type, k: Int, res: ($`wxyz type`) -> R): R {
                    $contract
                    return slerp($`p,wxyz`, a, k, res)
                }"""
            slerp2("this[WXYZ]", "p[WXYZ]", "a")
            +"""
                inline fun <R> slerp($`pWxyz type`, a: $type, k: Int, res: ($`wxyz type`) -> R): R {
                    $contract
                    return Companion.slerp($wxyz, $pWxyz, a, k, res)
                }"""
        }
        Generator.Part.CompanionObject -> {
            slerp2("q", "p", "a")
            +"""
                inline fun <R> slerp(q: Quat$id, p: Quat$id, a: $type, k: Int, res: ($`wxyz type`) -> R): R {
                    $contract
                    return slerp($`q,wxyz`, $`p,wxyz`, a, k, res)
                }"""
            slerp2("q[WXYZ]", "p[WXYZ]", "a")
            +"""
                inline fun <R> slerp($`qWxyz type`, $`pWxyz type`, a: $type, k: Int, res: ($`wxyz type`) -> R): R {
                    $contract
                    var rW = pW; var rX = pX; var rY = pY; var rZ = pZ

                    var cosTheta = Quat$id.dot($qWxyz, $pWxyz)
            
                    // If cosTheta < 0, the interpolation will take the long way around the sphere.
                    // To fix this, one quat must be negated.
                    if(cosTheta < $`0`) {
                        rW = -pW; rX = -pX; rY = -pY; rZ = -pZ
                        cosTheta = -cosTheta
                    }
            
                    // Perform a linear interpolation when cosTheta is close to 1 to avoid side effect of sin(angle) becoming a zero denominator
                    return when { 
                        // Linear interpolation
                        cosTheta > $`1` - $type.MIN_VALUE -> res(qW.mix(rW, a), qX.mix(rX, a), qY.mix(rY, a), qZ.mix(rZ, a))
                        else -> {
                            // Graphics Gems III, page 96
                            val angle = (cosTheta).acos
                            val phi = angle + k * glm.pi.${type.extension}
                            val s = (angle - a * phi).sin
                            val t = (a * phi).sin
                            val u = angle.sin
                            res((s * qW + t * rW) / u, (s * qX + t * rX) / u, (s * qY + t * rY) / u, (s * qZ + t * rZ) / u)
                        }
                    }
                }"""
        }
        else -> Unit
    }

    fun conjugate(q: String = "this[wxyz]") = docs("Returns the $q conjugate.")
    when(part) {
        Generator.Part.Class -> {
            conjugate()
            +"fun conjugate(res: Quat$id = Quat$id()): Quat$id = Companion.conjugate($wxyz) { $wxyz -> res($wxyz) }"
            conjugate()
            +"""
                inline fun <R> conjugate(res: ($`wxyz type`) -> R): R {
                    $contract
                    return Companion.conjugate($wxyz, res)
                }"""
        }
        Generator.Part.CompanionObject -> {
            conjugate("q")
            +"""
                inline fun <R> conjugate(q: Quat$id, res: ($`wxyz type`) -> R): R {
                    $contract
                    return conjugate($`q,wxyz`, res)
                }"""
            conjugate("[wxyz]")
            +"""
                inline fun <R> conjugate($`wxyz type`, res: ($`wxyz type`) -> R): R {
                    $contract
                    return res(w, -x, -y, -z)
                }"""
        }
        else -> Unit
    }

    fun inverse(q: String = "this[wxyz]") = docs("Returns the $q inverse.")
    when(part) {
        Generator.Part.Class -> {
            inverse()
            +"fun inverse(res: Quat$id = Quat$id()): Quat$id = Companion.inverse($wxyz) { $wxyz -> res($wxyz) }"
            inverse()
            +"""
                inline fun <R> inverse(res: ($`wxyz type`) -> R): R {
                    $contract
                    return Companion.inverse($wxyz, res)
                }"""
        }
        Generator.Part.CompanionObject -> {
            inverse("q")
            +"""
                inline fun <R> inverse(q: Quat$id, res: ($`wxyz type`) -> R): R {
                    $contract
                    return inverse($`q,wxyz`, res)
                }"""
            inverse("[wxyz]")
            +"""
                inline fun <R> inverse($`wxyz type`, res: ($`wxyz type`) -> R): R {
                    $contract
                    Quat$id.conjugate($wxyz) { a, b, c, d ->
                        Quat$id.div(a, b, c, d, Quat$id.dot($wxyz, $wxyz)) { e, f, g, h ->
                            return res(e, f, g, h)
                        }
                    }
                }"""
        }
        else -> Unit
    }

    fun isNaN(x: String = "this[wxyz]") = docs("""
        |Returns `true` if `$x` holds a `NaN` (not a number) representation in the underlying implementation's set of
        |floating point representations. Returns `false` otherwise, including for implementations with no NaN representations.""")
    when(part) {
        Generator.Part.Class -> {
            isNaN()
            +"fun isNaN(res: Vec4bool = Vec4bool()): Vec4bool = Companion.isNaN($wxyz) { $wxyz -> res($wxyz) }"
            isNaN()
            +"""
                inline fun <R> isNaN(res: ($`wxyz Boolean`) -> R): R {
                    $contract
                    return Companion.isNaN($wxyz, res)
                }"""
        }
        Generator.Part.CompanionObject -> {
            isNaN("q")
            +"""
                inline fun <R> isNaN(q: Quat$id, res: ($`wxyz Boolean`) -> R): R {
                    $contract
                    return isNaN($`q,wxyz`, res)
                }"""
            isNaN("[wxyz]")
            +"""
                inline fun <R> isNaN($`wxyz type`, res: ($`wxyz Boolean`) -> R): R {
                    $contract
                    return res(w.isNaN(), x.isNaN(), y.isNaN(), z.isNaN())
                }"""
        }
        else -> Unit
    }

    fun isInf(x: String = "this[wxyz]") = docs("""
        |Returns `true` if `$x` holds a positive infinity or negative infinity representation in the underlying 
        |implementation's set of floating point representations. 
        |Returns `false` otherwise, including for implementations with no infinity representations.""")
    when(part) {
        Generator.Part.Class -> {
            isInf()
            +"fun isInf(res: Vec4bool = Vec4bool()): Vec4bool = Companion.isInf($wxyz) { $wxyz -> res($wxyz) }"
            isInf()
            +"""
                inline fun <R> isInf(res: ($`wxyz Boolean`) -> R): R {
                    $contract
                    return Companion.isInf($wxyz, res)
                }"""
        }
        Generator.Part.CompanionObject -> {
            isInf("q")
            +"""
                inline fun <R> isInf(q: Quat$id, res: ($`wxyz Boolean`) -> R): R {
                    $contract
                    return isInf($`q,wxyz`, res)
                }"""
            isInf("[wxyz]")
            +"""
                inline fun <R> isInf($`wxyz type`, res: ($`wxyz Boolean`) -> R): R {
                    $contract
                    return res(w.isInfinite(), x.isInfinite(), y.isInfinite(), z.isInfinite())
                }"""
        }
        else -> Unit
    }
}