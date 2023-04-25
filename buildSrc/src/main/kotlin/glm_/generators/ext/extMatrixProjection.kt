package glm_.generators.ext

import glm_.generators.gen.Generator
import glm_.generators.gen.generate
import glm_.generators.*
import java.io.File

fun extMatrixProjection(target: File) {
    generate(target, "glm_/ext/extMatrixProjection.kt", `package` = "glm_.ext") {

        experimentals += Generator.Experimentals.Contracts
        //            +"import glm_.extensions.swizzle.*"
        imports += listOf(
            "glm_.glm",
//            "glm_.scalar.abs",
//            "glm_.scalar.tan",
//            "glm_.scalar.sin",
//            "glm_.scalar.cos",
            "glm_.mat4.Mat4",
            "glm_.mat4.Mat4d",
            "glm_.vec4.Vec4",
            "glm_.vec4.Vec4i",
            "glm_.vec4.Vec4d",
            "glm_.vec3.Vec3",
            "glm_.vec3.Vec3d",
            "glm_.vec2.Vec2",
            "glm_.vec2.Vec2d",
//            "glm_.mat4.Mat4d",
            "glm_.detail.GLM_DEPTH_CLIP_SPACE",
            "glm_.detail.GlmDepthClipSpace",
//            "glm_.detail.GLM_DEPTH_CLIP_SPACE",
//            "glm_.detail.GlmCoordinateSystem",
            //                          "kotlin.reflect.KMutableProperty0",
            //                    +"import kotlin.jvm.*"
            //                          "kotlin.math.*",
            //                          "kotlin.math.pow"
                         )

        for (type in floatingPointTypes)
            extMatrixProjection(type)
    }
}

fun Generator.extMatrixProjection(type: Type) {
    val id = type.id

    val `-1` = type.`-1`
    val `0` = type.`0`
    val `0,5` = type.`0,5`
    val `0,5 joint3` = xyzwJoint(3) { type.`0,5` }
    val `1` = type.`1`
    val `1 joint4` = xyzwJoint(4) { type.`1` }
    val `2` = type.`2`
    val `2 joint4` = xyzwJoint(4) { type.`2` }

    val nl = '\n'

    val `objXyz type` = XyzwJoint(3) { "obj$it: $type" }
    val objXyz = XyzwJoint(3) { "obj$it" }
    val objXyzw = XyzwJoint(4) { "obj$it" }
    val `obj,xyz` = xyzwJoint(3) { "obj.$it" }
    val `winXyz type` = XyzwJoint(3) { "win$it: $type" }
    val winXyz = XyzwJoint(3) { "win$it" }
    val `win,xyz` = xyzwJoint(3) { "win.$it" }
    val `modelAbcdN type` = AbcdJoint(4, 4, rowSeparator = ",\n") { "model$it: $type" }
    val modelAbcdN = AbcdJoint(4, 4, rowSeparator = ",\n") { "model$it" }
    val abcdN = abcdJoint(4, 4, rowSeparator = ",\n")
    val d4 = "d0, d1, d2, d3"
    val `abcdN type` = abcdJoint(4, 4, rowSeparator = ",\n") { "$it: $type" }
    val `model,abcdN` = abcdJoint(4, 4, rowSeparator = ",\n") { "model.$it" }
    val `projAbcdN type` = AbcdJoint(4, 4, rowSeparator = ",\n") { "proj$it: $type" }
    val projAbcdN = AbcdJoint(4, 4, rowSeparator = ",\n") { "proj$it" }
    val `proj,abcdN` = abcdJoint(4, 4, rowSeparator = ",\n") { "proj.$it" }
    val `viewportXyzw type` = XyzwJoint(4) { "viewport$it: $type" }
    val `viewportXyzw Int` = XyzwJoint(4) { "viewport$it: Int" }
    val viewportXyzw = XyzwJoint(4) { "viewport$it" }
    val `viewport,xyzw` = xyzwJoint(4) { "viewport.$it" }
    val tmpXyzw = XyzwJoint(4) { "tmp$it" }
    val tmpXyz = XyzwJoint(3) { "tmp$it" }
    val xyz = xyzwJoint(3)
    val `xyz type` = xyzwJoint(3) { "$it: $type" }

    fun projectZO() = docs("""
        |Map the specified object coordinates (obj.x, obj.y, obj.z) into window coordinates.
        |The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
        |
        |@param obj Specify the object coordinates.
        |@param model Specifies the current modelview matrix
        |@param proj Specifies the current projection matrix
        |@param viewport Specifies the current viewport
        |@return Return the computed window coordinates.
        |
        |@see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/gluProject.xml">gluProject man page</a>""")
    projectZO()
    +"""
        fun glm.projectZO(obj: Vec3$id, model: Mat4$id, proj: Mat4$id, viewport: Vec4$id, res: Vec3$id = Vec3$id()): Vec3$id = 
            glm.projectZO(obj.x, obj.y, obj.z,$nl$`model,abcdN`,$nl$`proj,abcdN`, $`viewport,xyzw`) { $xyz -> res($xyz) } 
    """
    // viewport int
    projectZO()
    +"""
        fun glm.projectZO(obj: Vec3$id, model: Mat4$id, proj: Mat4$id, viewport: Vec4i, res: Vec3$id = Vec3$id()): Vec3$id = 
            glm.projectZO(obj.x, obj.y, obj.z,$nl$`model,abcdN`,$nl$`proj,abcdN`, $`viewport,xyzw`) { $xyz -> res($xyz) } 
    """

    projectZO()
    +"""inline fun <R> glm.projectZO($`objXyz type`,$nl$`modelAbcdN type`,$nl$`projAbcdN type`,$nl$`viewportXyzw type`, res: ($`xyz type`) -> R): R {
            $contract
            Mat4$id.times($modelAbcdN, objX, objY, objZ, ${type.`1`}) { $tmpXyzw ->
                Mat4$id.times($projAbcdN, $tmpXyzw) { $tmpXyzw ->
                    Vec3$id.div($tmpXyz, tmpW, tmpW, tmpW) { $tmpXyz ->
                        val tmpX = tmpX * $`0,5` + $`0,5`
                        val tmpY = tmpY * $`0,5` + $`0,5`
                        return res(tmpX * viewportZ + viewportX, tmpY * viewportW + viewportY, tmpZ)
                    }
                }
            }
        }"""
    // viewport int
    projectZO()
    +"""inline fun <R> glm.projectZO($`objXyz type`,$nl$`modelAbcdN type`,$nl$`projAbcdN type`,$nl$`viewportXyzw Int`, res: ($`xyz type`) -> R): R {
            $contract
            Mat4$id.times($modelAbcdN, objX, objY, objZ, ${type.`1`}) { $tmpXyzw ->
                Mat4$id.times($projAbcdN, $tmpXyzw) { $tmpXyzw ->
                    Vec3$id.div($tmpXyz, tmpW, tmpW, tmpW) { $tmpXyz ->
                        val tmpX = tmpX * $`0,5` + $`0,5`
                        val tmpY = tmpY * $`0,5` + $`0,5`
                        return res(tmpX * viewportZ + viewportX, tmpY * viewportW + viewportY, tmpZ)
                    }
                }
            }
        }"""

    fun projectNO() = docs("""
        |Map the specified object coordinates (obj.x, obj.y, obj.z) into window coordinates.
        |The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
        |
        |@param obj Specify the object coordinates.
        |@param model Specifies the current modelview matrix
        |@param proj Specifies the current projection matrix
        |@param viewport Specifies the current viewport
        |@return Return the computed window coordinates.
        |
        |@see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/gluProject.xml">gluProject man page</a>""")
    projectNO()
    +"""
        fun glm.projectNO(obj: Vec3$id, model: Mat4$id, proj: Mat4$id, viewport: Vec4$id, res: Vec3$id = Vec3$id()): Vec3$id = 
            glm.projectNO(obj.x, obj.y, obj.z,$nl$`model,abcdN`,$nl$`proj,abcdN`, $`viewport,xyzw`) { $xyz -> res($xyz) } 
    """
    // viewport int
    projectNO()
    +"""
        fun glm.projectNO(obj: Vec3$id, model: Mat4$id, proj: Mat4$id, viewport: Vec4i, res: Vec3$id = Vec3$id()): Vec3$id = 
            glm.projectNO(obj.x, obj.y, obj.z,$nl$`model,abcdN`,$nl$`proj,abcdN`, $`viewport,xyzw`) { $xyz -> res($xyz) } 
    """

    projectNO()
    +"""inline fun <R> glm.projectNO($`objXyz type`,$nl$`modelAbcdN type`,$nl$`projAbcdN type`,$nl$`viewportXyzw type`, res: ($`xyz type`) -> R): R {
            $contract
            Mat4$id.times($modelAbcdN, objX, objY, objZ, ${type.`1`}) { $tmpXyzw ->
                Mat4$id.times($projAbcdN, $tmpXyzw) { $tmpXyzw ->
                    Vec3$id.div($tmpXyz, tmpW, tmpW, tmpW) { $tmpXyz ->
                        Vec3$id.fma($tmpXyz, $`0,5 joint3`, $`0,5 joint3`) { $tmpXyz ->
                            return res(tmpX * viewportZ + viewportX, tmpY * viewportW + viewportY, tmpZ)
                        }
                    }
                }
            }
        }"""
    // viewport int
    projectNO()
    +"""inline fun <R> glm.projectNO($`objXyz type`,$nl$`modelAbcdN type`,$nl$`projAbcdN type`,$nl$`viewportXyzw Int`, res: ($`xyz type`) -> R): R {
            $contract
            Mat4$id.times($modelAbcdN, objX, objY, objZ, ${type.`1`}) { $tmpXyzw ->
                Mat4$id.times($projAbcdN, $tmpXyzw) { $tmpXyzw ->
                    Vec3$id.div($tmpXyz, tmpW, tmpW, tmpW) { $tmpXyz ->
                        Vec3$id.fma($tmpXyz, $`0,5 joint3`, $`0,5 joint3`) { $tmpXyz ->
                            return res(tmpX * viewportZ + viewportX, tmpY * viewportW + viewportY, tmpZ)
                        }
                    }
                }
            }
        }"""

    fun project() = docs("""
        |Map the specified object coordinates (`obj.x, obj.y, obj.z`) into window coordinates using default near and far clip planes definition.
        |To change default near and far clip planes definition use `GLM_DEPTH_CLIP_SPACE`.
        |
        |@param obj Specify the object coordinates.
        |@param model Specifies the current modelview matrix
        |@param proj Specifies the current projection matrix
        |@param viewport Specifies the current viewport
        |@return Return the computed window coordinates.
        |
        |@see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/gluProject.xml">gluProject man page</a>""")
    project()
    +"""
        fun glm.project(obj: Vec3$id, model: Mat4$id, proj: Mat4$id, viewport: Vec4$id, res: Vec3$id = Vec3$id()): Vec3$id =
            glm.project($`obj,xyz`,$nl$`model,abcdN`,$nl$`proj,abcdN`, $`viewport,xyzw`) { $xyz -> res($xyz) }"""
    project()
    +"""
        fun glm.project(obj: Vec3$id, model: Mat4$id, proj: Mat4$id, viewport: Vec4i, res: Vec3$id = Vec3$id()): Vec3$id =
            glm.project($`obj,xyz`,$nl$`model,abcdN`,$nl$`proj,abcdN`, $`viewport,xyzw`) { $xyz -> res($xyz) }"""
    project()
    +"""
        inline fun <R> glm.project($`objXyz type`,$nl$`modelAbcdN type`,$nl$`projAbcdN type`,$nl$`viewportXyzw type`, res: ($`xyz type`) -> R): R {
            $contract
            return when (GLM_DEPTH_CLIP_SPACE) {
                GlmDepthClipSpace.ZERO_TO_ONE -> projectZO($objXyz,$nl$modelAbcdN,$nl$projAbcdN, $viewportXyzw, res)
                else -> projectNO($objXyz,$nl$modelAbcdN,$nl$projAbcdN, $viewportXyzw, res)
            }
        }"""
    project()
    +"""
        inline fun <R> glm.project($`objXyz type`,$nl$`modelAbcdN type`,$nl$`projAbcdN type`,$nl$`viewportXyzw Int`, res: ($`xyz type`) -> R): R {
            $contract
            return when (GLM_DEPTH_CLIP_SPACE) {
                GlmDepthClipSpace.ZERO_TO_ONE -> projectZO($objXyz,$nl$modelAbcdN,$nl$projAbcdN, $viewportXyzw, res)
                else -> projectNO($objXyz,$nl$modelAbcdN,$nl$projAbcdN, $viewportXyzw, res)
            }
        }"""

    fun unProjectZO() = docs("""
        |Map the specified window coordinates (`win.x, win.y, win.z`) into object coordinates.
        |The near and far clip planes correspond to z normalized device coordinates of 0 and +1 respectively. (Direct3D clip volume definition)
        |
        |@param win Specify the window coordinates to be mapped.
        |@param model Specifies the modelview matrix
        |@param proj Specifies the projection matrix
        |@param viewport Specifies the viewport
        |@return Returns the computed object coordinates.
        |
        |@see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/gluUnProject.xml">gluUnProject man page</a>""")
    unProjectZO()
    +"""
        fun glm.unProjectZO(win: Vec3$id, model: Mat4$id, proj: Mat4$id, viewport: Vec4$id, res: Vec3$id = Vec3$id()): Vec3$id = 
            glm.unProjectZO($`win,xyz`,$nl$`model,abcdN`,$nl$`proj,abcdN`,$nl$`viewport,xyzw`) { $xyz -> res($xyz) }"""
    // viewport int
    unProjectZO()
    +"""
        fun glm.unProjectZO(win: Vec3$id, model: Mat4$id, proj: Mat4$id, viewport: Vec4i, res: Vec3$id = Vec3$id()): Vec3$id = 
            glm.unProjectZO($`win,xyz`,$nl$`model,abcdN`,$nl$`proj,abcdN`,$nl$`viewport,xyzw`) { $xyz -> res($xyz) }"""

    unProjectZO()
    +"""inline fun <R> glm.unProjectZO($`winXyz type`,$nl$`modelAbcdN type`,$nl$`projAbcdN type`,$nl$`viewportXyzw type`, res: ($`xyz type`) -> R): R {
            $contract
            Mat4$id.times($projAbcdN,$nl$modelAbcdN) { $abcdN ->
                Mat4$id.inverse($abcdN) { $abcdN ->
                    var tmpX = winX; var tmpY = winY; val tmpZ = winZ; val tmpW = $`1`
                    tmpX = (tmpX - viewportX) / viewportZ
                    tmpY = (tmpY - viewportY) / viewportW
                    tmpX = tmpX * $`2` - $`1`
                    tmpY = tmpY * $`2` - $`1`
                    Mat4$id.times($abcdN,$nl$tmpXyzw) { $objXyzw ->
                        Vec3$id.div($objXyz, objW, objW, objW) { $objXyz ->
                            return res($objXyz)
                        }
                    }
                }
            }
        }"""
    // viewport int
    unProjectZO()
    +"""inline fun <R> glm.unProjectZO($`winXyz type`,$nl$`modelAbcdN type`,$nl$`projAbcdN type`,$nl$`viewportXyzw Int`, res: ($`xyz type`) -> R): R {
            $contract
            Mat4$id.times($projAbcdN,$nl$modelAbcdN) { $abcdN ->
                Mat4$id.inverse($abcdN) { $abcdN ->
                    var tmpX = winX; var tmpY = winY; val tmpZ = winZ; val tmpW = $`1`
                    tmpX = (tmpX - viewportX) / viewportZ
                    tmpY = (tmpY - viewportY) / viewportW
                    tmpX = tmpX * $`2` - $`1`
                    tmpY = tmpY * $`2` - $`1`
                    Mat4$id.times($abcdN,$nl$tmpXyzw) { $objXyzw ->
                        Vec3$id.div($objXyz, objW, objW, objW) { $objXyz ->
                            return res($objXyz)
                        }
                    }
                }
            }
        }"""

    fun unProjectNO() = docs("""
        |Map the specified window coordinates (`win.x, win.y, win.z`) into object coordinates.
        |The near and far clip planes correspond to z normalized device coordinates of -1 and +1 respectively. (OpenGL clip volume definition)
        |
        |@param win Specify the window coordinates to be mapped.
        |@param model Specifies the modelview matrix
        |@param proj Specifies the projection matrix
        |@param viewport Specifies the viewport
        |@return Returns the computed object coordinates.
        |
        |@see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/gluUnProject.xml">gluUnProject man page</a>""")
    unProjectNO()
    +"""
        fun glm.unProjectNO(win: Vec3$id, model: Mat4$id, proj: Mat4$id, viewport: Vec4$id, res: Vec3$id = Vec3$id()): Vec3$id = 
            glm.unProjectNO($`win,xyz`,$nl$`model,abcdN`,$nl$`proj,abcdN`,$nl$`viewport,xyzw`) { $xyz -> res($xyz) }"""
    // viewport int
    unProjectNO()
    +"""
        fun glm.unProjectNO(win: Vec3$id, model: Mat4$id, proj: Mat4$id, viewport: Vec4i, res: Vec3$id = Vec3$id()): Vec3$id = 
            glm.unProjectNO($`win,xyz`,$nl$`model,abcdN`,$nl$`proj,abcdN`,$nl$`viewport,xyzw`) { $xyz -> res($xyz) }"""

    unProjectNO()
    +"""inline fun <R> glm.unProjectNO($`winXyz type`,$nl$`modelAbcdN type`,$nl$`projAbcdN type`,$nl$`viewportXyzw type`, res: ($`xyz type`) -> R): R {
            $contract
            Mat4$id.times($projAbcdN,$nl$modelAbcdN) { $abcdN ->
                Mat4$id.inverse($abcdN) { $abcdN ->
                    var tmpX = winX; var tmpY = winY; val tmpZ = winZ; val tmpW = $`1`
                    tmpX = (tmpX - viewportX) / viewportZ
                    tmpY = (tmpY - viewportY) / viewportW
                    tmpX = tmpX * $`2` - $`1`
                    tmpY = tmpY * $`2` - $`1`
                    Mat4$id.times($abcdN,$nl$tmpXyzw) { $objXyzw ->
                        Vec3$id.div($objXyz, objW, objW, objW) { $objXyz ->
                            return res($objXyz)
                        }
                    }
                }
            }
        }"""
    // viewport int
    unProjectNO()
    +"""inline fun <R> glm.unProjectNO($`winXyz type`,$nl$`modelAbcdN type`,$nl$`projAbcdN type`,$nl$`viewportXyzw Int`, res: ($`xyz type`) -> R): R {
            $contract
            Mat4$id.times($projAbcdN,$nl$modelAbcdN) { $abcdN ->
                Mat4$id.inverse($abcdN) { $abcdN ->
                    var tmpX = winX; var tmpY = winY; val tmpZ = winZ; val tmpW = $`1`
                    tmpX = (tmpX - viewportX) / viewportZ
                    tmpY = (tmpY - viewportY) / viewportW
                    tmpX = tmpX * $`2` - $`1`
                    tmpY = tmpY * $`2` - $`1`
                    Mat4$id.times($abcdN,$nl$tmpXyzw) { $objXyzw ->
                        Vec3$id.div($objXyz, objW, objW, objW) { $objXyz ->
                            return res($objXyz)
                        }
                    }
                }
            }
        }"""

    fun unProject() = docs("""
        |Map the specified window coordinates (`win.x, win.y, win.z`) into object coordinates using default near and far clip planes definition.
        |To change default near and far clip planes definition use `GLM_DEPTH_CLIP_SPACE`.
        |
        |@param win Specify the window coordinates to be mapped.
        |@param model Specifies the modelview matrix
        |@param proj Specifies the projection matrix
        |@param viewport Specifies the viewport
        |@return Returns the computed object coordinates.
        |
        |@see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/gluUnProject.xml">gluUnProject man page</a>""")
    unProject()
    +"""
        fun glm.unProject(win: Vec3$id, model: Mat4$id, proj: Mat4$id, viewport: Vec4$id, res: Vec3$id = Vec3$id()): Vec3$id =
            glm.unProject($`win,xyz`,$nl$`model,abcdN`,$nl$`proj,abcdN`, $`viewport,xyzw`) { $xyz -> res($xyz) }"""
    unProject()
    +"""
        fun glm.unProject(win: Vec3$id, model: Mat4$id, proj: Mat4$id, viewport: Vec4i, res: Vec3$id = Vec3$id()): Vec3$id =
            glm.unProject($`win,xyz`,$nl$`model,abcdN`,$nl$`proj,abcdN`, $`viewport,xyzw`) { $xyz -> res($xyz) }"""
    unProject()
    +"""
        inline fun <R> glm.unProject($`winXyz type`,$nl$`modelAbcdN type`,$nl$`projAbcdN type`,$nl$`viewportXyzw type`, res: ($`xyz type`) -> R): R =
            when (GLM_DEPTH_CLIP_SPACE) {
                GlmDepthClipSpace.ZERO_TO_ONE -> unProjectZO($winXyz,$nl$modelAbcdN,$nl$projAbcdN, $viewportXyzw, res)
                else -> unProjectNO($winXyz,$nl$modelAbcdN,$nl$projAbcdN, $viewportXyzw, res)
            }"""
    unProject()
    +"""
        inline fun <R> glm.unProject($`winXyz type`,$nl$`modelAbcdN type`,$nl$`projAbcdN type`,$nl$`viewportXyzw Int`, res: ($`xyz type`) -> R): R =
            when (GLM_DEPTH_CLIP_SPACE) {
                GlmDepthClipSpace.ZERO_TO_ONE -> unProjectZO($winXyz,$nl$modelAbcdN,$nl$projAbcdN, $viewportXyzw, res)
                else -> unProjectNO($winXyz,$nl$modelAbcdN,$nl$projAbcdN, $viewportXyzw, res)
            }"""

    val `centerXy type` = XyzwJoint(2) { "center$it: $type" }
    val `center,xy` = xyzwJoint(2) { "center.$it" }
    val `deltaXy type` = XyzwJoint(2) { "delta$it: $type" }
    val `delta,xy` = xyzwJoint(2) { "delta.$it" }

    fun pickMatrix() = docs("""
        |Define a picking region
        |
        |@param center Specify the center of a picking region in window coordinates.
        |@param delta Specify the width and height, respectively, of the picking region in window coordinates.
        |@param viewport Rendering viewport
        |
        |@see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/gluPickMatrix.xml">gluPickMatrix man page</a>""")
    pickMatrix()
    +"""
        fun glm.pickMatrix(center: Vec2$id, delta: Vec2$id, viewport: Vec4$id, res: Mat4$id = Mat4$id()): Mat4$id =
            glm.pickMatrix($`center,xy`, $`delta,xy`, $`viewport,xyzw`) { $abcdN -> 
                res($abcdN)
            }"""
    pickMatrix()
    +"""
        fun glm.pickMatrix(center: Vec2$id, delta: Vec2$id, viewport: Vec4i, res: Mat4$id = Mat4$id()): Mat4$id =
            glm.pickMatrix($`center,xy`, $`delta,xy`, $`viewport,xyzw`) { $abcdN -> 
                res($abcdN)
            }"""

    pickMatrix()
    +"""
        inline fun <R> glm.pickMatrix($`centerXy type`,$nl$`deltaXy type`,$nl$`viewportXyzw type`, res: ($`abcdN type`) -> R): R {
            check(deltaX > $`0` && deltaY > $`0`)
            
            val tmpX = (viewportZ - $`2` * (centerX - viewportX)) / deltaX
            val tmpY = (viewportW - $`2` * (centerY - viewportY)) / deltaY
            val tmpZ = $`0`

            // Translate and scale the picked region to the entire window
            Mat4$id.translate($`1`, $`0`, $`0`, $`0`,$nl$`0`, $`1`, $`0`, $`0`,$nl$`0`, $`0`, $`1`, $`0`,$nl$`0`, $`0`, $`0`, $`1`, tmpX, tmpY, tmpZ) { $d4 ->
                Mat4$id.scale($`1`, $`0`, $`0`, $`0`,$nl$`0`, $`1`, $`0`, $`0`,$nl$`0`, $`0`, $`1`, $`0`,$nl$d4,${nl}viewportZ / deltaX, viewportW / deltaY, $`1`) { $abcdN ->
                    return res($abcdN)
                }
            }
        }"""
    pickMatrix()
    +"""
        inline fun <R> glm.pickMatrix($`centerXy type`,$nl$`deltaXy type`,$nl$`viewportXyzw Int`, res: ($`abcdN type`) -> R): R {
            check(deltaX > $`0` && deltaY > $`0`)
            
            val tmpX = (viewportZ - $`2` * (centerX - viewportX)) / deltaX
            val tmpY = (viewportW - $`2` * (centerY - viewportY)) / deltaY
            val tmpZ = $`0`

            // Translate and scale the picked region to the entire window
            Mat4$id.translate($`1`, $`0`, $`0`, $`0`,$nl$`0`, $`1`, $`0`, $`0`,$nl$`0`, $`0`, $`1`, $`0`,$nl$`0`, $`0`, $`0`, $`1`, tmpX, tmpY, tmpZ) { $d4 ->
                Mat4$id.scale($`1`, $`0`, $`0`, $`0`,$nl$`0`, $`1`, $`0`, $`0`,$nl$`0`, $`0`, $`1`, $`0`,$nl$d4,${nl}viewportZ / deltaX, viewportW / deltaY, $`1`) { $abcdN ->
                    return res($abcdN)
                }
            }
        }"""
}