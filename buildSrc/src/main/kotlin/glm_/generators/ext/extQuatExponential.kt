package glm_.generators.ext

import glm_.generators.*
import glm_.generators.gen.Generator

fun Generator.extQuatExponential(type: Type, part: Generator.Part) {

    +"// ext quaternion exponential\n"

    imports += listOf(
        "glm_.scalar.sqrt",
        "glm_.scalar.cos",
        "glm_.scalar.acos",
        "glm_.scalar.abs",
        "glm_.scalar.pow",
        "glm_.scalar.log",
        "glm_.scalar.atan",
        "glm_.glm",
                     )

    val extension = type.extension
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
    val `0,5` = type.`0,5`

    // probably redundant for Quats
    if (type !in floatingPointTypes)
        return

    fun exp() = docs("Returns a exponential of a quaternion.")
    when(part) {
        Generator.Part.Class -> {
            exp()
            +"fun exp(res: Quat$id = Quat$id()): Quat$id = exp(this) { $wxyz -> res($wxyz) }"
            exp()
            +"""
                inline fun <R> exp(res: ($`wxyz type`) -> R): R {
                    $contract
                    return exp(this, res) 
                }"""
        }
        Generator.Part.CompanionObject -> {
            exp()
            +"""
                inline fun <R> exp(q: Quat$id, res: ($`wxyz type`) -> R): R {
                    $contract
                    return exp($`q,wxyz`, res) 
                }"""
            exp()
            +"""
                inline fun <R> exp($`wxyz type`, res: ($`wxyz type`) -> R): R {
                    $contract
                    val angle = Vec3$id.length(x, y, z)
                    if (angle < $type.MIN_VALUE)
                        return res($`1`, $`0`, $`0`, $`0`)
                        
                    val vX = x / angle; val vY = y / angle; val vZ = z / angle
                    val sin = angle.sin
                    return res(angle.cos, vX * sin, vY * sin, vZ * sin) 
                }"""
        }
        else -> Unit
    }

    fun log() = docs("Returns a logarithm of a quaternion.")
    when(part) {
        Generator.Part.Class -> {
            log()
            +"fun log(res: Quat$id = Quat$id()): Quat$id = log(this) { $wxyz -> res($wxyz) }"
            log()
            +"""
                inline fun <R> log(res: ($`wxyz type`) -> R): R {
                    $contract
                    return log(this, res) 
                }"""
        }
        Generator.Part.CompanionObject -> {
            log()
            +"""
                inline fun <R> log(q: Quat$id, res: ($`wxyz type`) -> R): R {
                    $contract
                    return log($`q,wxyz`, res) 
                }"""
            log()
            +"""
                inline fun <R> log($`wxyz type`, res: ($`wxyz type`) -> R): R {
                    $contract
                    val vec3Len = Vec3$id.length(x, y, z)
            
                    return when {
                        vec3Len < $type.MIN_VALUE -> when {
                            w > $`0` -> res(w.log(), $`0`, $`0`, $`0`)
                            w < $`0` -> res((-w).log(), glm.pi.$extension, $`0`, $`0`)
                            else -> res($type.POSITIVE_INFINITY, $type.POSITIVE_INFINITY, $type.POSITIVE_INFINITY, $type.POSITIVE_INFINITY)
                        }
                        else -> {
                            val t = vec3Len.atan(w) / vec3Len
                            val quatLen2 = vec3Len * vec3Len + w * w
                            res($`0,5` * quatLen2.log(), t * x, t * y, t * z)
                        } 
                    }
                }"""
        }
        else -> Unit
    }

    fun pow() = docs("Returns a quaternion raised to a power.")
    when(part) {
        Generator.Part.Class -> {
            pow()
            +"infix fun pow(power: $type): Quat$id = pow(power, Quat$id())"
            pow()
            +"fun pow(power: $type, res: Quat$id): Quat$id = pow(this, power) { $wxyz -> res($wxyz) }"
            pow()
            +"""
                inline fun <R> pow(power: $type, res: ($`wxyz type`) -> R): R {
                    $contract
                    return pow(this, power, res) 
                }"""
        }
        Generator.Part.CompanionObject -> {
            pow()
            +"""
                inline fun <R> pow(q: Quat$id, power: $type, res: ($`wxyz type`) -> R): R {
                    $contract
                    return pow($`q,wxyz`, power, res) 
                }"""
            pow()
            +"""
                inline fun <R> pow($`wxyz type`, power: $type, res: ($`wxyz type`) -> R): R {
                    $contract
                    //Raising to the power of 0 should yield 1
                    //Needed to prevent a division by 0 error later on
                    if(power > -$type.MIN_VALUE && power < $type.MIN_VALUE)
                        return res($`1`, $`0`, $`0`, $`0`)
            
                    //To deal with non-unit quaternions
                    val m = x * x + y * y + z * z + w * w
                    val magnitude = m.sqrt()
            
                    val angle = when {
                        (w / magnitude).abs() > glm.`cos 1 over 2`.$extension -> {
                            //Scalar component is close to 1; using it to recover angle would lose precision
                            //Instead, we use the non-scalar components since sin() is accurate around 0
                
                            //Prevent a division by 0 error later on
                            val vectorMagnitude = m
                            //Despite the compiler might say, we actually want to compare `vectorMagnitude` to `0` here; 
                            //we could use denorm_int() compiling a project with unsafe maths optimizations might make 
                            // the comparison always false, even when `vectorMagnitude` is `0`.
                            if (vectorMagnitude < $type.MIN_VALUE)
                                //Equivalent to raising a real number to a power
                                return res(w pow power, $`0`, $`0`, $`0`)
                
                            (vectorMagnitude.sqrt() / magnitude).asin
                        }
                        //Scalar component is small, shouldn't cause loss of precision
                        else -> (w / magnitude).acos
                    }
                    val newAngle = angle * power
                    val div = newAngle.sin / angle.sin
                    val mag = magnitude pow (power - $`1`)
                    return res(newAngle.cos * magnitude * mag, x * div * mag, y * div * mag, z * div * mag)
                }"""
        }
        else -> Unit
    }

    fun sqrt() = docs("Returns the square root of a quaternion")
    when(part) {
        Generator.Part.Class -> {
            sqrt()
            +"fun sqrt(res: Quat$id = Quat$id()): Quat$id = sqrt(this) { $wxyz -> res($wxyz) }"
            sqrt()
            +"""
                inline fun <R> sqrt(res: ($`wxyz type`) -> R): R {
                    $contract
                    return sqrt(this, res) 
                }"""
        }
        Generator.Part.CompanionObject -> {
            sqrt()
            +"""
                inline fun <R> sqrt(q: Quat$id, res: ($`wxyz type`) -> R): R {
                    $contract
                    return sqrt($`q,wxyz`, res) 
                }"""
            sqrt()
            +"""
                inline fun <R> sqrt($`wxyz type`, res: ($`wxyz type`) -> R): R {
                    $contract
                    Quat$id.pow($wxyz, $`0,5`) { $wxyz ->
                        return res($wxyz)
                    }
                }"""
        }
        else -> Unit
    }
}