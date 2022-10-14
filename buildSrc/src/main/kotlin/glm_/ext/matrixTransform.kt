package glm_.ext

import glm_.*
import glm_.gen.Generator
import glm_.`0`

fun Generator.matrixTransform(width: Int, height: Int, type: String, extension: String, id: String, part: Generator.Part) {

    val matID = "Mat$matrixSize$id"

    imports += listOf("glm_.scalar.sin",
                      "glm_.scalar.cos",
                      "glm_.detail.GlmCoordinateSystem",
                      "glm_.detail.GLM_COORDINATE_SYSTEM")
    val `0` = type.`0`
    val `1` = type.`1`

    fun identity() = docs("Builds an identity matrix.")
    when (part) {
        Generator.Part.Class -> {
            identity()
            +"fun identityAssign(): $matID = identity(this)"
        }
        Generator.Part.CompanionObject -> {
            identity()
            +"fun identity(res: $matID = $matID()): $matID = res(${type.`1`})"
        }
        else -> Unit
    }
    if (width != 4 || height != 4)
        return
    if (type !in floatingPointTypes)
        return

    val abcdN = abcdJoint { "$it" }
    val `resXYZW type` = XyzwJoint(4) { "res$it: $type" }
    val resXYZW = XyzwJoint(4) { "res$it" }
    val `abc4 type` = abcdJoint(3, 4, ",\n") { "$it: $type" }
    val `abcd type` = abcdJoint(4, 4, ",\n") { "$it: $type" }
    val `v,xyz` = xyzwJoint(3) { "v.$it" }
    val `axis,xyz` = xyzwJoint(3) { "axis.$it" }
    val `axisXYZ` = XyzwJoint(3) { "axis$it" }
    val `axisXYZ type` = XyzwJoint(3) { "axis$it: $type" }
    val `vXYZ type` = XyzwJoint(3) { "v$it: $type" }
    val vXYZ = XyzwJoint(3) { "v$it" }
    val `xyz type` = xyzwJoint(3) { "$it: $type" }
    val xyz = xyzwJoint(3) { "$it" }
    val scalarJoint = xyzwJoint(3) { "scalar" }
    val `eyeXYZ type` = XyzwJoint(3) { "eye$it: $type" }
    val eyeXYZ = XyzwJoint(3) { "eye$it" }
    val `eye,xyz` = xyzwJoint(3) { "eye.$it" }
    val `centerXYZ type` = XyzwJoint(3) { "center$it: $type" }
    val centerXYZ = XyzwJoint(3) { "center$it" }
    val `center,xyz` = xyzwJoint(3) { "center.$it" }
    val `upXYZ type` = XyzwJoint(3) { "up$it: $type" }
    val upXYZ = XyzwJoint(3) { "up$it" }
    val `up,xyz` = xyzwJoint(3) { "up.$it" }
    val a0123 = xyzwJointIndexed(4) { i, _ -> "a$i" }
    val b0123 = xyzwJointIndexed(4) { i, _ -> "b$i" }
    val c0123 = xyzwJointIndexed(4) { i, _ -> "c$i" }
    val d0123 = xyzwJointIndexed(4) { i, _ -> "d$i" }

    fun translate(vector: String = "v",
                  receiverOrParam0: String = "",
                  param1: String = "v",
                  res: String = "") = docs("""
        |Builds a translation 4 * 4 matrix created from a vector `$vector`.
        |```
        |val mat = Mat4(1f) translate Vec3(1f) // create a new instance for the result
        |mat = 1f 0f 0f 1f
        |      0f 1f 0f 1f
        |      0f 0f 1f 1f
        |      0f 0f 0f 1f
        |```
        |@${if (receiverOrParam0.isEmpty()) "receiver" else "param $receiverOrParam0"} Input matrix multiplied by this translation matrix.
        |${
        when (param1) {
            xyz -> """
                @param x
                @param y
                @param z Coordinates of a translation vector.
                """.trimIndent()
            "scalar" -> "@param $param1 Coordinates of a translation vector `[$scalarJoint]`."
            else -> "@param $param1 Coordinates of a translation vector."
        } + when {
            res.isEmpty() -> ""
            res == "res" -> "\n@param $res resulting matrix\n"
            else -> """
                @param resX
                @param resY
                @param resZ
                @param resW Components of the last column of the resulting translation matrix
                """.trimIndent()
        }
    }
        |@see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/glTranslate.xml">glTranslate man page</a>""")
    when (part) {
        Generator.Part.Class -> {
            translate()
            +"fun translateAssign(v: Vec3$id): $matID = translate($`v,xyz`, this)"

            translate(vector = "[$xyz]", param1 = xyz)
            +"fun translateAssign($`xyz type`): $matID = translate($xyz, this)"

            translate(vector = "[$scalarJoint]", param1 = "scalar")
            +"fun translateAssign(scalar: $type): $matID = translate($scalarJoint, this)"


            translate()
            +"infix fun translate(v: Vec3$id): $matID = translate($`v,xyz`, $matID())"
            translate(res = "res")
            +"fun translate(v: Vec3$id, res: $matID): $matID = translate($`v,xyz`, res)"

            translate(vector = "[$scalarJoint]", param1 = "scalar")
            +"infix fun translate(scalar: $type): $matID = translate($scalarJoint, $matID())"
            translate(vector = "[$scalarJoint]", param1 = "scalar", res = "res")
            +"fun translate(scalar: $type, res: $matID): $matID = translate($scalarJoint, res)"

            translate("[$xyz]", param1 = xyz, res = "res")
            +"""
                fun translate($`xyz type`, res: $matID): $matID = translate(this, $xyz) { $`resXYZW type` ->
                    if (res !== this) res put this
                    res.with3($resXYZW)
                }"""
        }
        Generator.Part.CompanionObject -> {
            translate(receiverOrParam0 = "m", res = "->")
            +"""
                inline fun <R> translate(m: $matID, v: Vec3$id, res: ($`resXYZW type`) -> R): R {
                    $contract
                    return translate(m, $`v,xyz`, res) 
                }"""

            translate(vector = "[$xyz]", receiverOrParam0 = "m", param1 = xyz, res = "->")
            +"""
                inline fun <R> translate(m: $matID, $`xyz type`, res: ($`resXYZW type`) -> R): R {
                    $contract
                    return res(m[0, 0] * x + m[1, 0] * y + m[2, 0] * z + m[3, 0],
                               m[0, 1] * x + m[1, 1] * y + m[2, 1] * z + m[3, 1],
                               m[0, 2] * x + m[1, 2] * y + m[2, 2] * z + m[3, 2],
                               m[0, 3] * x + m[1, 3] * y + m[2, 3] * z + m[3, 3])
                }"""
        }
        else -> Unit
    }

    fun rotate(axis: String = "v.[$xyz]",
               receiverOrParam0: String = "",
               param1: String = "axis",
               res: String = "") = docs("""
        |Builds a rotation 4 * 4 matrix created from an axis vector `$axis` and an angle.
        |
        |@${if (receiverOrParam0.isEmpty()) "receiver" else "param $receiverOrParam0"} Input matrix multiplied by this rotation matrix.
        |@param angle Rotation angle expressed in radians.
        |${
        when (param1) {
            axisXYZ -> "@param axisX\n@param axisY\n@param axisz Rotation axis, recommended to be normalized."
            "scalar" -> "@param $param1 Rotation axis `[$scalarJoint]`, recommended to be normalized."
            "v.[$xyz]" -> "@param v.x\n@param v.y\n@param v.z Rotation axis, recommended to be normalized."
            else -> "@param $param1 Rotation axis, recommended to be normalized."
        } + when {
            res.isEmpty() -> ""
            res == "res" -> "\n@param $res resulting matrix\n"
            else -> "\n" + abcdJoint(3, 4, "\n", "\n") { "@param $it" } + " Components of the columns [0-2] of the resulting rotation matrix"
        }
    }
        |
        |@see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/glRotate.xml">glRotate man page</a>""")
    when (part) {
        Generator.Part.Class -> {
            rotate()
            +"fun rotateAssign(angle: $type, axis: Vec3$id): $matID = rotate(angle, $`axis,xyz`, this)"

            rotate(axis = "axis.[$xyz]", param1 = axisXYZ)
            +"fun rotateAssign(angle: $type, $`axisXYZ type`): $matID = rotate(angle, $axisXYZ, this)"

            rotate(axis = "[$scalarJoint]", param1 = "scalar")
            +"fun rotateAssign(angle: $type, scalar: $type): $matID = rotate(angle, $scalarJoint, this)"


            rotate(param1 = "v.[$xyz]")
            +"fun rotate(angle: $type, v: Vec3$id): $matID = rotate(angle, $`v,xyz`, $matID())"
            rotate(param1 = "v.[$xyz]", res = "res")
            +"fun rotate(angle: $type, v: Vec3$id, res: $matID): $matID = rotate(angle, $`v,xyz`, res)"

            rotate(axis = "[$scalarJoint]", param1 = "scalar")
            +"fun rotate(angle: $type, scalar: $type): $matID = rotate(angle, $scalarJoint, $matID())"
            rotate(axis = "[$scalarJoint]", param1 = "scalar", res = "res")
            +"fun rotate(angle: $type, scalar: $type, res: $matID): $matID = rotate(angle, $scalarJoint, res)"

            rotate(axis = "axis.[$xyz]", param1 = axisXYZ, res = "res")
            +"""
                fun rotate(angle: $type, $`axisXYZ type`, res: $matID): $matID = rotate(this, angle, $axisXYZ) { $`abc4 type` ->
                    res.with0($a0123).with1($b0123).with2($c0123)
                }"""
        }
        Generator.Part.CompanionObject -> {
            rotate(axis = "axis.[$xyz]", receiverOrParam0 = "m", res = "->")
            +"""
                inline fun <R> rotate(m: $matID, angle: $type, axis: Vec3$id, res: ($`abc4 type`) -> R): R {
                    $contract
                    return rotate(m, angle, $`axis,xyz`, res) 
                }"""

            rotate(axis = "axis.[$xyz]", receiverOrParam0 = "m", param1 = axisXYZ, res = "->")
            +"""
                inline fun <R> rotate(m: $matID, angle: $type, $`axisXYZ type`, res: ($`abc4 type`) -> R): R {
                    $contract
                    val c = angle.cos
                    val s = angle.sin
                    
                    return Vec3$id.normalize($axisXYZ) { aX, aY, aZ ->
                        val oneMinusC = ${type.`1`} - c
                        val tX = oneMinusC * aX; val tY = oneMinusC * aY; val tZ = oneMinusC * aZ
                    
                        val a0 = tX * aX + c;      val a1 = tX * aY + s * aZ; val a2 = tX * aZ - s * aY
                        val b0 = tY * aX - s * aZ; val b1 = tY * aY + c;      val b2 = tY * aZ + s * aX                
                        val c0 = tZ * aX + s * aY; val c1 = tZ * aY - s * aX; val c2 = tZ * aZ + c
                    
                        res(m.a0 * a0 + m.b0 * a1 + m.c0 * a2, m.a1 * a0 + m.b1 * a1 + m.c1 * a2, m.a2 * a0 + m.b2 * a1 + m.c2 * a2, m.a3 * a0 + m.b3 * a1 + m.c3 * a2,
                            m.a0 * b0 + m.b0 * b1 + m.c0 * b2, m.a1 * b0 + m.b1 * b1 + m.c1 * b2, m.a2 * b0 + m.b2 * b1 + m.c2 * b2, m.a3 * b0 + m.b3 * b1 + m.c3 * b2,                    
                            m.a0 * c0 + m.b0 * c1 + m.c0 * c2, m.a1 * c0 + m.b1 * c1 + m.c1 * c2, m.a2 * c0 + m.b2 * c1 + m.c2 * c2, m.a3 * c0 + m.b3 * c1 + m.c3 * c2)
                    }
                }"""
        }
        else -> Unit
    }

    // rotate[XYZ]?

    fun scale(receiverOrParam0: String = "",
              param1: String = "v",
              res: String = "") = docs("""
        |Builds a scale 4 * 4 matrix created from 3 scalars.
        |
        |@${if (receiverOrParam0.isEmpty()) "receiver" else "param $receiverOrParam0"} Input matrix multiplied by this scale matrix.
        |${
        when (param1) {
            vXYZ -> "@param vX Ratio of scaling for x axes.\n@param vY Ratio of scaling for y axes.\n@param vZ Ratio of scaling for z axes."
            else -> "@param $param1 Ratio of scaling for each axis."
        } + when {
            res.isEmpty() -> ""
            res == "res" -> "\n@param res resulting matrix"
            else -> "\n" + abcdJoint(4, 4, "\n", "\n") { "@param $it" } + " Components of the resulting matrix"
        }
    }
        |
        |@see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/glScale.xml">glScale man page</a>""")
    when (part) {
        Generator.Part.Class -> {
            scale()
            +"fun scaleAssign(v: Vec3$id): $matID = scale($`v,xyz`, this)"

            scale(param1 = vXYZ)
            +"fun scaleAssign($`vXYZ type`): $matID = scale($vXYZ, this)"

            scale(param1 = "scalar")
            +"fun scaleAssign(scalar: $type): $matID = scale($scalarJoint, this)"

            scale()
            +"infix fun scale(v: Vec3$id): $matID = scale($`v,xyz`, $matID())"
            scale(res = "res")
            +"fun scale(v: Vec3$id, res: $matID): $matID = scale($`v,xyz`, res)"

            scale(param1 = "scalar")
            +"infix fun scale(scalar: $type): $matID = scale($scalarJoint, $matID())"
            scale(param1 = "scalar", res = "res")
            +"fun scale(scalar: $type, res: $matID): $matID = scale($scalarJoint, res)"

            scale(param1 = vXYZ, res = "res")
            +"""
                fun scale($`vXYZ type`, res: $matID): $matID = scale(this, $vXYZ) { $`abcd type` ->
                    if (res !== this) res.set3($d0123)
                    res.with0($a0123).with1($b0123).with2($c0123)
                }"""
        }
        Generator.Part.CompanionObject -> {
            scale(receiverOrParam0 = "m", res = "->")
            +"""
                inline fun <R> scale(m: $matID, v: Vec3$id, res: ($`abcd type`) -> R): R {
                    $contract
                    return scale(m, $`v,xyz`, res)
                }"""

            scale(receiverOrParam0 = "m", param1 = vXYZ, res = "->")
            +"""
                inline fun <R> scale(m: $matID, $`vXYZ type`, res: ($`abcd type`) -> R): R {
                    $contract
                    return Vec4$id.times(m.a0, m.a1, m.a2, m.a3, vX, vX, vX, vX) { $a0123 ->
                        Vec4$id.times(m.b0, m.b1, m.b2, m.b3, vY, vY, vY, vY) { $b0123 ->
                            Vec4$id.times(m.c0, m.c1, m.c2, m.c3, vZ, vZ, vZ, vZ) { $c0123 ->
                                res($a0123,
                                    $b0123,
                                    $c0123,
                                    m.d0, m.d1, m.d2, m.d3)
                            }
                        }
                    }
                }"""
        }
        else -> Unit
    }

    fun lookAtRH(eye: String = "eye", center: String = "center", up: String = "up", res: String = "") = docs("""
        |Build a right handed look at view matrix.
        |
        |${
        when (eye) {
            eyeXYZ -> "@param eye.x\n@param eye.y\n@param eye.z"
            else -> "@param $eye"
        } + " Position of the camera."
    }
        |${
        when (center) {
            centerXYZ -> "@param center.x\n@param center.y\n@param center.z"
            else -> "@param $center"
        } + " Position where the camera is looking at"
    }
        |${
        when (up) {
            upXYZ -> "@param up.x\n@param up.y\n@param up.z"
            else -> "@param $up"
        } + " Normalized up vector, how the camera is oriented. Typically `(0, 0, 1)`"
                + when {
            res.isEmpty() -> ""
            res == "res" -> "\n@param res resulting matrix"
            else -> "\n" + abcdJoint(4, 4, "\n", "\n") { "@param $it" }
        } + " Components of the resulting matrix"
    }
        |
        |@see - frustum(left: $type, right: $type, bottom: $type, top: $type, nearVal: $type, farVal: $type)""")
    when (part) {
        Generator.Part.Class -> {
            lookAtRH()
            +"fun lookAtRHAssign(eye: Vec3$id, center: Vec3$id, up: Vec3$id): $matID = lookAtRH(eye, center, up, this)"

            lookAtRH(eye = eyeXYZ, center = centerXYZ, up = upXYZ)
            +"""
                fun lookAtRHAssign($`eyeXYZ type`, 
                                   $`centerXYZ type`, 
                                   $`upXYZ type`): $matID = lookAtRH($eyeXYZ, $centerXYZ, $upXYZ, this)"""

            lookAtRH(res = "res")
            +"fun lookAtRH(eye: Vec3$id, center: Vec3$id, up: Vec3$id, res: $matID = $matID()): $matID = lookAtRH($`eye,xyz`, $`center,xyz`, $`up,xyz`, res)"

            lookAtRH(eye = eyeXYZ, center = centerXYZ, up = upXYZ, res = "res")
            +"""
                fun lookAtRH($`eyeXYZ type`, 
                             $`centerXYZ type`, 
                             $`upXYZ type`, res: $matID): $matID = lookAtRH($eyeXYZ, $centerXYZ, $upXYZ) { $`abcd type` ->
                    res(a0, a1, a2, a3,
                        b0, b1, b2, b3,
                        c0, c1, c2, c3,
                        d0, d1, d2, d3)
                }"""
        }
        Generator.Part.CompanionObject -> {
            lookAtRH(res = "->")
            +"""
                inline fun <R> lookAtRH(eye: Vec3$id, center: Vec3$id, up: Vec3$id, res: ($`abcd type`) -> R): R {
                    $contract
                    return lookAtRH($`eye,xyz`, $`center,xyz`, $`up,xyz`, res)
                }"""

            lookAtRH(eyeXYZ, centerXYZ, upXYZ, res = "->")
            +"""
                inline fun <R> lookAtRH($`eyeXYZ type`, 
                                        $`centerXYZ type`, 
                                        $`upXYZ type`, res: ($`abcd type`) -> R): R {
                    $contract
                    return Vec3$id.minus($centerXYZ, $eyeXYZ) { ceX, ceY, ceZ ->
                        Vec3$id.normalize(ceX, ceY, ceZ) { fX, fY, fZ ->
                            Vec3$id.cross(fX, fY, fZ, $upXYZ) { ufX, ufY, ufZ ->
                                Vec3$id.normalize(ufX, ufY, ufZ) { sX, sY, sZ ->
                                    Vec3$id.cross(sX, sY, sZ, fX, fY, fZ) { uX, uY, uZ ->
                                        res(sX, uX, -fX, $`0`,
                                            sY, uY, -fY, $`0`,
                                            sZ, uZ, -fZ, $`0`,
                                            -Vec3$id.dot(sX, sY, sZ, $eyeXYZ), -Vec3$id.dot(uX, uY, uZ, $eyeXYZ), Vec3$id.dot(fX, fY, fZ, $eyeXYZ), $`1`)
                                    }
                                }
                            }
                        }
                    }
                }"""
        }
        else -> Unit
    }

    fun lookAtLH(eye: String = "eye", center: String = "center", up: String = "up", res: String = "") = docs("""
        |Build a left handed look at view matrix.
        |
        |${
        when (eye) {
            eyeXYZ -> "@param eye.x\n@param eye.y\n@param eye.z"
            else -> "@param $eye"
        } + " Position of the camera."
    }
        |${
        when (center) {
            centerXYZ -> "@param center.x\n@param center.y\n@param center.z"
            else -> "@param $center"
        } + " Position where the camera is looking at"
    }
        |${
        when (up) {
            upXYZ -> "@param up.x\n@param up.y\n@param up.z"
            else -> "@param $up"
        } + " Normalized up vector, how the camera is oriented. Typically `(0, 0, 1)`"
                + when {
            res.isEmpty() -> ""
            res == "res" -> "\n@param res resulting matrix"
            else -> "\n" + abcdJoint(4, 4, "\n", "\n") { "@param $it" }
        } + " Components of the resulting matrix"
    }
        |
        |@see - frustum(left: $type, right: $type, bottom: $type, top: $type, nearVal: $type, farVal: $type)""")
    when (part) {
        Generator.Part.Class -> {
            lookAtLH()
            +"fun lookAtLHAssign(eye: Vec3$id, center: Vec3$id, up: Vec3$id): $matID = lookAtLH(eye, center, up, this)"

            lookAtLH(eye = eyeXYZ, center = centerXYZ, up = upXYZ)
            +"""
                fun lookAtLHAssign($`eyeXYZ type`, 
                                   $`centerXYZ type`, 
                                   $`upXYZ type`): $matID = lookAtLH($eyeXYZ, $centerXYZ, $upXYZ, this)"""

            lookAtLH(res = "res")
            +"fun lookAtLH(eye: Vec3$id, center: Vec3$id, up: Vec3$id, res: $matID = $matID()): $matID = lookAtLH($`eye,xyz`, $`center,xyz`, $`up,xyz`, res)"

            lookAtLH(eye = eyeXYZ, center = centerXYZ, up = upXYZ, res = "res")
            +"""
                fun lookAtLH($`eyeXYZ type`, 
                             $`centerXYZ type`, 
                             $`upXYZ type`, res: $matID): $matID = lookAtLH($eyeXYZ, $centerXYZ, $upXYZ) { $`abcd type` ->
                    res(a0, a1, a2, a3,
                        b0, b1, b2, b3,
                        c0, c1, c2, c3,
                        d0, d1, d2, d3)
                }"""
        }
        Generator.Part.CompanionObject -> {
            lookAtLH(res = "->")
            +"""
                inline fun <R> lookAtLH(eye: Vec3$id, center: Vec3$id, up: Vec3$id, res: ($`abcd type`) -> R): R {
                    $contract
                    return lookAtLH($`eye,xyz`, $`center,xyz`, $`up,xyz`, res)
                }"""

            lookAtLH(eyeXYZ, centerXYZ, upXYZ, res = "->")
            +"""
                inline fun <R> lookAtLH($`eyeXYZ type`, 
                                        $`centerXYZ type`, 
                                        $`upXYZ type`, res: ($`abcd type`) -> R): R {
                    $contract
                    return Vec3$id.minus($centerXYZ, $eyeXYZ) { ceX, ceY, ceZ ->
                        Vec3$id.normalize(ceX, ceY, ceZ) { fX, fY, fZ ->
                            Vec3$id.cross($upXYZ, fX, fY, fZ) { ufX, ufY, ufZ ->
                                Vec3$id.normalize(ufX, ufY, ufZ) { sX, sY, sZ ->
                                    Vec3$id.cross(fX, fY, fZ, sX, sY, sZ) { uX, uY, uZ ->
                                        res(sX, uX, -fX, $`0`,
                                            sY, uY, -fY, $`0`,
                                            sZ, uZ, -fZ, $`0`,
                                            -Vec3$id.dot(sX, sY, sZ, $eyeXYZ), -Vec3$id.dot(uX, uY, uZ, $eyeXYZ), -Vec3$id.dot(fX, fY, fZ, $eyeXYZ), $`1`)
                                    }
                                }
                            }
                        }
                    }
                }"""
        }
        else -> Unit
    }

    fun lookAt(eye: String = "eye", center: String = "center", up: String = "up", res: String = "") = docs("""
        |Build a look at view matrix based on the default handedness.
        |
        |${
        when (eye) {
            eyeXYZ -> "@param eye.x\n@param eye.y\n@param eye.z"
            else -> "@param $eye"
        } + " Position of the camera."
    }
        |${
        when (center) {
            centerXYZ -> "@param center.x\n@param center.y\n@param center.z"
            else -> "@param $center"
        } + " Position where the camera is looking at"
    }
        |${
        when (up) {
            upXYZ -> "@param up.x\n@param up.y\n@param up.z"
            else -> "@param $up"
        } + " Normalized up vector, how the camera is oriented. Typically `(0, 0, 1)`"
                + when {
            res.isEmpty() -> ""
            res == "res" -> "\n@param res resulting matrix"
            else -> "\n" + abcdJoint(4, 4, "\n", "\n") { "@param $it" }
        } + " Components of the resulting matrix"
    }
        |
        |@see - frustum(left: $type, right: $type, bottom: $type, top: $type, nearVal: $type, farVal: $type)""${'"'})
        |@see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/gluLookAt.xml">gluLookAt man page</a>""")
    when (part) {
        Generator.Part.Class -> {
            lookAt()
            +"fun lookAtAssign(eye: Vec3$id, center: Vec3$id, up: Vec3$id): $matID = lookAt(eye, center, up, this)"

            lookAt(eye = eyeXYZ, center = centerXYZ, up = upXYZ)
            +"""
                fun lookAtAssign($`eyeXYZ type`, 
                                 $`centerXYZ type`, 
                                 $`upXYZ type`): $matID = lookAt($eyeXYZ, $centerXYZ, $upXYZ, this)"""

            lookAt(res = "res")
            +"fun lookAt(eye: Vec3$id, center: Vec3$id, up: Vec3$id, res: $matID = $matID()): $matID = lookAt($`eye,xyz`, $`center,xyz`, $`up,xyz`, res)"

            lookAt(eye = eyeXYZ, center = centerXYZ, up = upXYZ, res = "res")
            +"""
                fun lookAt($`eyeXYZ type`, 
                           $`centerXYZ type`, 
                           $`upXYZ type`, res: $matID): $matID = lookAt($eyeXYZ, $centerXYZ, $upXYZ) { $`abcd type` ->
                    res(a0, a1, a2, a3,
                        b0, b1, b2, b3,
                        c0, c1, c2, c3,
                        d0, d1, d2, d3)
                }"""
        }
        Generator.Part.CompanionObject -> {
            lookAt(res = "->")
            +"""
                inline fun <R> lookAt(eye: Vec3$id, center: Vec3$id, up: Vec3$id, res: ($`abcd type`) -> R): R {
                    $contract
                    return lookAt($`eye,xyz`, $`center,xyz`, $`up,xyz`, res)
                }"""

            lookAt(eyeXYZ, centerXYZ, upXYZ, res = "->")
            +"""
                inline fun <R> lookAt($`eyeXYZ type`, 
                                      $`centerXYZ type`, 
                                      $`upXYZ type`, res: ($`abcd type`) -> R): R {
                    $contract
                    return when (GLM_COORDINATE_SYSTEM) {
                        GlmCoordinateSystem.LEFT_HANDED -> lookAtLH($eyeXYZ, $centerXYZ, $upXYZ, res)
                        else -> lookAtRH($eyeXYZ, $centerXYZ, $upXYZ, res)
                    }
                }"""
        }
        else -> Unit
    }
}