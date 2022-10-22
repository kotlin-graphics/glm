package glm_.ext

import glm_.gen.Generator
import glm_.gen.generate
import glm_.*
import java.io.File

fun extMatrixClipSpace(target: File) {
    generate(target, "glm_/ext/extMatrixClipSpace.kt") {

        experimentals += Generator.Experimentals.Contracts
        `package` = "glm_.ext"
        //            +"import glm_.extensions.swizzle.*"
        imports += listOf(
            "glm_.glm",
            "glm_.scalar.abs",
            "glm_.scalar.tan",
            "glm_.scalar.sin",
            "glm_.scalar.cos",
            "glm_.mat4.Mat4",
            "glm_.mat4.Mat4d",
            "glm_.detail.GLM_COORDINATE_SYSTEM",
            "glm_.detail.GlmDepthClipSpace",
            "glm_.detail.GLM_DEPTH_CLIP_SPACE",
            "glm_.detail.GlmCoordinateSystem",
            //                          "kotlin.reflect.KMutableProperty0",
            //                    +"import kotlin.jvm.*"
            //                          "kotlin.math.*",
            //                          "kotlin.math.pow"
                         )

        for ((type, extension, _, id) in numberTypeInformation.filter { it.type in floatingPointTypes })
            extMatrixClipSpace(type, extension, id)
    }
}

fun Generator.extMatrixClipSpace(type: String, extension: String, id: String) {

    val `-1` = type.`-1`
    val `0` = type.`0`
    val `0,5` = type.`0,5`
    val `1` = type.`1`
    val `2` = type.`2`
    docs("""
        |Creates a matrix for projecting two-dimensional coordinates onto the screen.
        |
        |@see - ortho(left: $type, right: $type, bottom: $type, top: $type, zNear: $type, zFar: $type)
        |@see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/gluOrtho2D.xml">gluOrtho2D man page</a>""")
    +"""
        fun glm.ortho(left: $type, right: $type, bottom: $type, top: $type, res: Mat4$id = Mat4$id()): Mat4$id {
            res put $`1`
            res[0, 0] = $`2` / (right - left)
            res[1, 1] = $`2` / (top - bottom)
            res[2, 2] = -$`1`
            res[3, 0] = - (right + left) / (right - left)
            res[3, 1] = - (top + bottom) / (top - bottom)
            return res
        }"""
    docs("""
        |Creates a matrix for an orthographic parallel viewing volume, using left-handed coordinates.
        |The near and far clip planes correspond to z normalized device coordinates of `0` and `+1` respectively. (Direct3D clip volume definition)
        |
        |@see - glm::ortho(left: $type, right: $type, bottom: $type, top: $type)""")
    +"""
        fun glm.orthoLH_ZO(left: $type, right: $type, bottom: $type, top: $type, zNear: $type, zFar: $type, res: Mat4$id = Mat4$id()): Mat4$id {
            res put $`1`
            res[0, 0] = $`2` / (right - left)
            res[1, 1] = $`2` / (top - bottom)
            res[2, 2] = $`1` / (zFar - zNear)
            res[3, 0] = - (right + left) / (right - left)
            res[3, 1] = - (top + bottom) / (top - bottom)
            res[3, 2] = - zNear / (zFar - zNear)
            return res
        }"""

    docs("""
        |Creates a matrix for an orthographic parallel viewing volume using right-handed coordinates.
        |The near and far clip planes correspond to z normalized device coordinates of `-1` and `+1` respectively. (OpenGL clip volume definition)
        |
        |@see - glm::ortho(left: $type, right: $type, bottom: $type, top: $type)""")
    +"""
        fun glm.orthoLH_NO(left: $type, right: $type, bottom: $type, top: $type, zNear: $type, zFar: $type, res: Mat4$id = Mat4$id()): Mat4$id {
            res put $`1`
            res[0, 0] = $`2` / (right - left)
            res[1, 1] = $`2` / (top - bottom)
            res[2, 2] = $`2` / (zFar - zNear)
            res[3, 0] = - (right + left) / (right - left)
            res[3, 1] = - (top + bottom) / (top - bottom)
            res[3, 2] = - (zFar + zNear) / (zFar - zNear)
            return res
        }"""

    docs("""
        |Creates a matrix for an orthographic parallel viewing volume, using left-handed coordinates.
        |The near and far clip planes correspond to z normalized device coordinates of `0` and `+1` respectively. (Direct3D clip volume definition)
        |
        |@see - glm::ortho(left: $type, right: $type, bottom: $type, top: $type)""")
    +"""
         fun glm.orthoRH_ZO(left: $type, right: $type, bottom: $type, top: $type, zNear: $type, zFar: $type, res: Mat4$id = Mat4$id()): Mat4$id {
            res put $`1`
            res[0, 0] = $`2` / (right - left)
            res[1, 1] = $`2` / (top - bottom)
            res[2, 2] = - $`1` / (zFar - zNear)
            res[3, 0] = - (right + left) / (right - left)
            res[3, 1] = - (top + bottom) / (top - bottom)
            res[3, 2] = - zNear / (zFar - zNear)
            return res
         }"""

    docs("""
        |Creates a matrix for an orthographic parallel viewing volume, using right-handed coordinates.
        |The near and far clip planes correspond to z normalized device coordinates of `-1` and `+1` respectively. (OpenGL clip volume definition)
        |
        |@see - glm::ortho(left: $type, right: $type, bottom: $type, top: $type, res: Mat4$id = Mat4$id())""")
    +"""
        fun glm.orthoRH_NO(left: $type, right: $type, bottom: $type, top: $type, zNear: $type, zFar: $type, res: Mat4$id = Mat4$id()): Mat4$id {
            res put $`1`
            res[0, 0] = $`2` / (right - left)
            res[1, 1] = $`2` / (top - bottom)
            res[2, 2] = - $`2` / (zFar - zNear)
            res[3, 0] = - (right + left) / (right - left)
            res[3, 1] = - (top + bottom) / (top - bottom)
            res[3, 2] = - (zFar + zNear) / (zFar - zNear)
            return res
        }"""

    docs("""
        |Creates a matrix for an orthographic parallel viewing volume, using left-handed coordinates.
        |The near and far clip planes correspond to z normalized device coordinates of `0` and `+1` respectively. (Direct3D clip volume definition)
        |
        |@see - glm::ortho(left: $type, right: $type, bottom: $type, top: $type, res: Mat4$id = Mat4$id())""")
    + """
        fun glm.orthoZO(left: $type, right: $type, bottom: $type, top: $type, zNear: $type, zFar: $type, res: Mat4$id = Mat4$id()): Mat4$id = 
            when (GLM_COORDINATE_SYSTEM) {
                GlmCoordinateSystem.LEFT_HANDED -> orthoLH_ZO(left, right, bottom, top, zNear, zFar, res)
                else -> orthoRH_ZO(left, right, bottom, top, zNear, zFar, res)
            }"""

    docs("""
        |Creates a matrix for an orthographic parallel viewing volume, using left-handed coordinates if `GLM_COORDINATE_SYSTEM == GlmCoordinateSystem.LEFT_HANDED`
        |or right-handed coordinates otherwise.
        |The near and far clip planes correspond to z normalized device coordinates of `-1` and `+1` respectively. (OpenGL clip volume definition)
        |
        |@see - glm::ortho(left: $type, right: $type, bottom: $type, top: $type)""")
    +"""
        fun glm.orthoNO(left: $type, right: $type, bottom: $type, top: $type, zNear: $type, zFar: $type, res: Mat4$id = Mat4$id()): Mat4$id =
            when (GLM_COORDINATE_SYSTEM) {
                GlmCoordinateSystem.LEFT_HANDED -> orthoLH_NO(left, right, bottom, top, zNear, zFar, res)
                else -> orthoRH_NO(left, right, bottom, top, zNear, zFar, res)
            }"""

    docs("""
        |Creates a matrix for an orthographic parallel viewing volume, using left-handed coordinates.
        |If `GLM_DEPTH_CLIP_SPACE == GlmDepthClipSpace.ZERO_TO_ONE`, the near and far clip planes correspond 
        |to z normalized device coordinates of `0` and `+1` respectively. (Direct3D clip volume definition)
        |Otherwise, the near and far clip planes correspond to z normalized device coordinates of `-1` and `+1` respectively. (OpenGL clip volume definition)
        |
        |@see - glm::ortho(left: $type, right: $type, bottom: $type, top: $type)""")
    +"""
        fun glm.orthoLH(left: $type, right: $type, bottom: $type, top: $type, zNear: $type, zFar: $type, res: Mat4$id = Mat4$id()): Mat4$id =
            when (GLM_DEPTH_CLIP_SPACE) {
                GlmDepthClipSpace.ZERO_TO_ONE -> orthoLH_ZO(left, right, bottom, top, zNear, zFar, res)
                else -> orthoLH_NO(left, right, bottom, top, zNear, zFar, res)
            }"""

    docs("""
         |Creates a matrix for an orthographic parallel viewing volume, using right-handed coordinates.
         |If `GLM_DEPTH_CLIP_SPACE = GlmDepthClipSpace.ZERO_TO_ONE`, the near and far clip planes correspond to z 
         |normalized device coordinates of `0` and `+1` respectively. (Direct3D clip volume definition)
         |Otherwise, the near and far clip planes correspond to z normalized device coordinates of `-1` and `+1` respectively. (OpenGL clip volume definition)
         |
         |@see - glm::ortho(left: $type, right: $type, bottom: $type, top: $type)""")
    +"""
        fun glm.orthoRH(left: $type, right: $type, bottom: $type, top: $type, zNear: $type, zFar: $type, res: Mat4$id = Mat4$id()): Mat4$id = 
            when (GLM_DEPTH_CLIP_SPACE) {
                GlmDepthClipSpace.ZERO_TO_ONE -> orthoRH_ZO(left, right, bottom, top, zNear, zFar, res)
                else -> orthoRH_NO(left, right, bottom, top, zNear, zFar, res)
            }"""

    docs("""
         |Creates a matrix for an orthographic parallel viewing volume, using the default handedness and default near and far clip planes definition.
         |To change default handedness use `GLM_COORDINATE_SYSTEM`. To change default near and far clip planes definition use `GLM_DEPTH_CLIP_SPACE`.
         |
         |@see - glm::ortho(left: $type, right: $type, bottom: $type, top: $type)
         |@see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/glOrtho.xml">glOrtho man page</a>""")
    +"""
         fun glm.ortho(left: $type, right: $type, bottom: $type, top: $type, zNear: $type, zFar: $type, res: Mat4$id = Mat4$id()): Mat4$id =
            when (GLM_COORDINATE_SYSTEM) {
                GlmCoordinateSystem.LEFT_HANDED -> when (GLM_DEPTH_CLIP_SPACE) {
                    GlmDepthClipSpace.ZERO_TO_ONE -> orthoLH_ZO(left, right, bottom, top, zNear, zFar, res)
                    else -> orthoLH_NO(left, right, bottom, top, zNear, zFar, res)
                }
                else -> when (GLM_DEPTH_CLIP_SPACE) {
                    GlmDepthClipSpace.ZERO_TO_ONE -> orthoRH_ZO(left, right, bottom, top, zNear, zFar, res)
                    else -> orthoRH_NO(left, right, bottom, top, zNear, zFar, res)
                }
            }"""

    docs("""
        |Creates a left handed frustum matrix.
        |The near and far clip planes correspond to z normalized device coordinates of `0` and `+1` respectively. (Direct3D clip volume definition)""")
    +"""
        fun glm.frustumLH_ZO(left: $type, right: $type, bottom: $type, top: $type, near: $type, far: $type, res: Mat4$id = Mat4$id()): Mat4$id {
            res put $`0`
            res[0, 0] = ($`2` * near) / (right - left)
            res[1, 1] = ($`2` * near) / (top - bottom)
            res[2, 0] = (right + left) / (right - left)
            res[2, 1] = (top + bottom) / (top - bottom)
            res[2, 2] = far / (far - near)
            res[2, 3] = $`1`
            res[3, 2] = -(far * near) / (far - near)
            return res
        }"""

    docs("""
        |Creates a left handed frustum matrix.
        |The near and far clip planes correspond to z normalized device coordinates of `-1` and `+1` respectively. (OpenGL clip volume definition)""")
    +"""
        fun glm.frustumLH_NO(left: $type, right: $type, bottom: $type, top: $type, near: $type, far: $type, res: Mat4$id = Mat4$id()): Mat4$id {
            res put $`0`
            res[0, 0] = ($`2` * near) / (right - left)
            res[1, 1] = ($`2` * near) / (top - bottom)
            res[2, 0] = (right + left) / (right - left)
            res[2, 1] = (top + bottom) / (top - bottom)
            res[2, 2] = (far + near) / (far - near)
            res[2, 3] = $`1`
            res[3, 2] = - ($`2` * far * near) / (far - near)
            return res
        }"""

    docs("""
        |Creates a right handed frustum matrix.
        |The near and far clip planes correspond to z normalized device coordinates of `0` and `+1` respectively. (Direct3D clip volume definition)""")
    +"""
         fun glm.frustumRH_ZO(left: $type, right: $type, bottom: $type, top: $type, near: $type, far: $type, res: Mat4$id = Mat4$id()): Mat4$id {
             res put $`0`
             res[0, 0] = ($`2` * near) / (right - left)
             res[1, 1] = ($`2` * near) / (top - bottom)
             res[2, 0] = (right + left) / (right - left)
             res[2, 1] = (top + bottom) / (top - bottom)
             res[2, 2] = far / (near - far)
             res[2, 3] = $`-1`
             res[3, 2] = -(far * near) / (far - near)
             return res
         }"""

    docs("""
        |Creates a right handed frustum matrix.
        |The near and far clip planes correspond to z normalized device coordinates of `-1` and `+1` respectively. (OpenGL clip volume definition)""")
    +"""
        fun glm.frustumRH_NO(left: $type, right: $type, bottom: $type, top: $type, near: $type, far: $type, res: Mat4$id = Mat4$id()): Mat4$id {
            res put $`0`
            res[0, 0] = ($`2` * near) / (right - left)
            res[1, 1] = ($`2` * near) / (top - bottom)
            res[2, 0] = (right + left) / (right - left)
            res[2, 1] = (top + bottom) / (top - bottom)
            res[2, 2] = - (far + near) / (far - near)
            res[2, 3] = $`-1`
            res[3, 2] = - ($`2` * far * near) / (far - near)
            return res
        }"""

    docs("""
        |Creates a frustum matrix using left-handed coordinates if `GLM_COORDINATE_SYSTEM == GlmCoordinateSystem.LEFT_HANDED`
        |or right-handed coordinates otherwise.
        |The near and far clip planes correspond to z normalized device coordinates of `0` and `+1` respectively. (Direct3D clip volume definition)""")
    +"""
        fun glm.frustumZO(left: $type, right: $type, bottom: $type, top: $type, near: $type, far: $type, res: Mat4$id = Mat4$id()): Mat4$id =
            when (GLM_COORDINATE_SYSTEM) {
                GlmCoordinateSystem.LEFT_HANDED -> frustumLH_ZO(left, right, bottom, top, near, far, res)
                else -> frustumRH_ZO(left, right, bottom, top, near, far, res)
            }"""

    docs("""
         |Creates a frustum matrix using left-handed coordinates if `GLM_COORDINATE_SYSTEM == GlmCoordinateSystem.LEFT_HANDED`
         |or right-handed coordinates otherwise.
         |The near and far clip planes correspond to z normalized device coordinates of `-1` and `+1` respectively. (OpenGL clip volume definition)""")
    +"""
        fun glm.frustumNO(left: $type, right: $type, bottom: $type, top: $type, near: $type, far: $type, res: Mat4$id = Mat4$id()): Mat4$id =
            when (GLM_COORDINATE_SYSTEM) {
                GlmCoordinateSystem.LEFT_HANDED -> frustumLH_NO(left, right, bottom, top, near, far, res)
                else -> frustumRH_NO(left, right, bottom, top, near, far, res)
            }"""

    docs("""
        |Creates a left handed frustum matrix.
        |If `GLM_DEPTH_CLIP_SPACE == GlmDepthClipSpace.ZERO_TO_ONE`, the near and far clip planes correspond to z 
        |normalized device coordinates of `0` and `+1` respectively. (Direct3D clip volume definition)
        |Otherwise, the near and far clip planes correspond to z normalized device coordinates of `-1` and `+1` respectively. (OpenGL clip volume definition)""")
    +"""
         fun glm.frustumLH(left: $type, right: $type, bottom: $type, top: $type, near: $type, far: $type, res: Mat4$id = Mat4$id()): Mat4$id =
            when (GLM_DEPTH_CLIP_SPACE) {
                GlmDepthClipSpace.ZERO_TO_ONE -> frustumLH_ZO(left, right, bottom, top, near, far, res)
                else -> frustumLH_NO(left, right, bottom, top, near, far, res)
            }"""

    docs("""
        |Creates a right handed frustum matrix.
        |If `GLM_DEPTH_CLIP_SPACE == GlmDepthClipSpace.ZERO_TO_ONE`, the near and far clip planes correspond to z 
        |normalized device coordinates of `0` and `+1` respectively. (Direct3D clip volume definition)
        |Otherwise, the near and far clip planes correspond to z normalized device coordinates of `-1` and `+1` respectively. (OpenGL clip volume definition)""")
    +"""
        fun glm.frustumRH(left: $type, right: $type, bottom: $type, top: $type, near: $type, far: $type, res: Mat4$id = Mat4$id()): Mat4$id =
            when (GLM_DEPTH_CLIP_SPACE) {
                GlmDepthClipSpace.ZERO_TO_ONE -> frustumRH_ZO(left, right, bottom, top, near, far, res)
                else -> frustumRH_NO(left, right, bottom, top, near, far, res)
            }"""

    docs("""
        |Creates a frustum matrix with default handedness, using the default handedness and default near and far clip planes definition.
        |To change default handedness use `GLM_COORDINATE_SYSTEM`. To change default near and far clip planes definition use `GLM_DEPTH_CLIP_SPACE`.
        |
        |@see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/glFrustum.xml">glFrustum man page</a>""")
    +"""
         fun glm.frustum(left: $type, right: $type, bottom: $type, top: $type, near: $type, far: $type, res: Mat4$id = Mat4$id()): Mat4$id =
            when (GLM_COORDINATE_SYSTEM) {
                GlmCoordinateSystem.LEFT_HANDED -> when (GLM_DEPTH_CLIP_SPACE) {
                    GlmDepthClipSpace.ZERO_TO_ONE -> frustumLH_ZO(left, right, bottom, top, near, far, res)
                    else -> frustumLH_NO(left, right, bottom, top, near, far, res)
                }
                else -> when (GLM_DEPTH_CLIP_SPACE) {
                    GlmDepthClipSpace.ZERO_TO_ONE -> frustumRH_ZO(left, right, bottom, top, near, far, res)
                    else -> frustumRH_NO(left, right, bottom, top, near, far, res)
                }
            }"""

    docs("""
         |Creates a matrix for a right handed, symetric perspective-view frustum.
         |The near and far clip planes correspond to z normalized device coordinates of `0` and `+1` respectively. (Direct3D clip volume definition)
         |
         |@param fovy Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
         |@param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
         |@param zNear Specifies the distance from the viewer to the near clipping plane (always positive).
         |@param zFar Specifies the distance from the viewer to the far clipping plane (always positive).""")
    +"""
        fun glm.perspectiveRH_ZO(fovy: $type, aspect: $type, zNear: $type, zFar: $type, res: Mat4$id = Mat4$id()): Mat4$id {
            check((aspect - $type.MIN_VALUE).abs() > $`0`) { "glm::perspectiveRH_ZO(fovy: $type, aspect: $type, zNear: $type, zFar: $type), aspect is too small!" }

            val tanHalfFovy = (fovy / $`2`).tan
    
            res put $`0`
            res[0, 0] = $`1` / (aspect * tanHalfFovy)
            res[1, 1] = $`1` / (tanHalfFovy)
            res[2, 2] = zFar / (zNear - zFar)
            res[2, 3] = - $`1`
            res[3, 2] = -(zFar * zNear) / (zFar - zNear)
            return res
        }"""

    docs("""
         |Creates a matrix for a right handed, symetric perspective-view frustum.
         |The near and far clip planes correspond to z normalized device coordinates of `-1` and `+1` respectively. (OpenGL clip volume definition)
         |
         |@param fovy Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
         |@param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
         |@param zNear Specifies the distance from the viewer to the near clipping plane (always positive).
         |@param zFar Specifies the distance from the viewer to the far clipping plane (always positive).""")
    +"""
         fun glm.perspectiveRH_NO(fovy: $type, aspect: $type, zNear: $type, zFar: $type, res: Mat4$id = Mat4$id()): Mat4$id {
            check((aspect - $type.MIN_VALUE).abs() > $`0`) { "glm::perspectiveRH_NO(fovy: $type, aspect: $type, zNear: $type, zFar: $type), aspect is too small!" }

            val tanHalfFovy = (fovy / $`2`).tan
    
            res put $`0`
            res[0, 0] = $`1` / (aspect * tanHalfFovy)
            res[1, 1] = $`1` / (tanHalfFovy)
            res[2, 2] = - (zFar + zNear) / (zFar - zNear)
            res[2, 3] = - $`1`
            res[3, 2] = - ($`2` * zFar * zNear) / (zFar - zNear)
            return res
        }"""

    docs("""
        |Creates a matrix for a left handed, symetric perspective-view frustum.
        |The near and far clip planes correspond to z normalized device coordinates of `0` and `+1` respectively. (Direct3D clip volume definition)
        |
        |@param fovy Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
        |@param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
        |@param zNear Specifies the distance from the viewer to the near clipping plane (always positive).
        |@param zFar Specifies the distance from the viewer to the far clipping plane (always positive).""")
    +"""
        fun glm.perspectiveLH_ZO(fovy: $type, aspect: $type, zNear: $type, zFar: $type, res: Mat4$id = Mat4$id()): Mat4$id {
            check((aspect - $type.MIN_VALUE).abs() > $`0`) { "glm::perspectiveLH_ZO(fovy: $type, aspect: $type, zNear: $type, zFar: $type), aspect is too small!" }

            val tanHalfFovy = (fovy / $`2`).tan
    
            res put $`0`
            res[0, 0] = $`1` / (aspect * tanHalfFovy)
            res[1, 1] = $`1` / (tanHalfFovy)
            res[2, 2] = zFar / (zFar - zNear)
            res[2, 3] = $`1`
            res[3, 2] = -(zFar * zNear) / (zFar - zNear)
            return res
        }"""

    docs("""
        |Creates a matrix for a left handed, symetric perspective-view frustum.
        |The near and far clip planes correspond to z normalized device coordinates of `-1` and `+1` respectively. (OpenGL clip volume definition)
        |
        |@param fovy Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
        |@param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
        |@param zNear Specifies the distance from the viewer to the near clipping plane (always positive).
        |@param zFar Specifies the distance from the viewer to the far clipping plane (always positive).""")
    +"""fun glm.perspectiveLH_NO(fovy: $type, aspect: $type, zNear: $type, zFar: $type, res: Mat4$id = Mat4$id()): Mat4$id {
            check((aspect - $type.MIN_VALUE).abs() > $`0`) { "glm::perspectiveLH_NO(fovy: $type, aspect: $type, zNear: $type, zFar: $type), aspect is too small!" }
    
            val tanHalfFovy = (fovy / $`2`).tan
    
            res put $`0`
            res[0, 0] = $`1` / (aspect * tanHalfFovy)
            res[1, 1] = $`1` / (tanHalfFovy)
            res[2, 2] = (zFar + zNear) / (zFar - zNear)
            res[2, 3] = $`1`
            res[3, 2] = - ($`2` * zFar * zNear) / (zFar - zNear)
            return res
        }"""

    docs("""
        |Creates a matrix for a symetric perspective-view frustum using left-handed coordinates if `GLM_COORDINATE_SYSTEM == GlmCoordinateSystem.LEFT_HANDED`
        |or right-handed coordinates otherwise.
        |The near and far clip planes correspond to z normalized device coordinates of `0` and `+1` respectively. (Direct3D clip volume definition)
        |
        |@param fovy Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
        |@param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
        |@param zNear Specifies the distance from the viewer to the near clipping plane (always positive).
        |@param zFar Specifies the distance from the viewer to the far clipping plane (always positive).""")
    +"""
        fun glm.perspectiveZO(fovy: $type, aspect: $type, zNear: $type, zFar: $type, res: Mat4$id = Mat4$id()): Mat4$id =
            when (GLM_COORDINATE_SYSTEM) {
                GlmCoordinateSystem.LEFT_HANDED -> perspectiveLH_ZO(fovy, aspect, zNear, zFar, res)
                else -> perspectiveRH_ZO(fovy, aspect, zNear, zFar, res)
            }"""

    docs("""
        |Creates a matrix for a symetric perspective-view frustum using left-handed coordinates if `GLM_COORDINATE_SYSTEM == GlmCoordinateSystem.LEFT_HANDED`
        |or right-handed coordinates otherwise.
        |The near and far clip planes correspond to z normalized device coordinates of `-1` and `+1` respectively. (OpenGL clip volume definition)
        |
        |@param fovy Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
        |@param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
        |@param zNear Specifies the distance from the viewer to the near clipping plane (always positive).
        |@param zFar Specifies the distance from the viewer to the far clipping plane (always positive).""")
    +"""
        fun glm.perspectiveNO(fovy: $type, aspect: $type, zNear: $type, zFar: $type, res: Mat4$id = Mat4$id()): Mat4$id =
            when (GLM_COORDINATE_SYSTEM) {
                GlmCoordinateSystem.LEFT_HANDED -> perspectiveLH_NO(fovy, aspect, zNear, zFar, res)
                else -> perspectiveRH_NO(fovy, aspect, zNear, zFar, res)
            }"""

    docs("""
        |Creates a matrix for a right handed, symetric perspective-view frustum.
        |If `GLM_DEPTH_CLIP_SPACE == GlmDepthClipSpace.ZERO_TO_ONE`, the near and far clip planes correspond to 
        |z normalized device coordinates of `0` and `+1` respectively. (Direct3D clip volume definition)
        |Otherwise, the near and far clip planes correspond to z normalized device coordinates of `-1` and `+1` respectively. (OpenGL clip volume definition)
        |
        |@param fovy Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
        |@param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
        |@param zNear Specifies the distance from the viewer to the near clipping plane (always positive).
        |@param zFar Specifies the distance from the viewer to the far clipping plane (always positive).""")
    +"""
        fun glm.perspectiveRH(fovy: $type, aspect: $type, zNear: $type, zFar: $type, res: Mat4$id = Mat4$id()) =
            when (GLM_DEPTH_CLIP_SPACE) {
                GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveRH_ZO(fovy, aspect, zNear, zFar, res)
                else -> perspectiveRH_NO(fovy, aspect, zNear, zFar, res)
            }"""

    docs("""
        |Creates a matrix for a left handed, symetric perspective-view frustum.
        |If `GLM_DEPTH_CLIP_SPACE == GlmDepthClipSpace.ZERO_TO_ONE`, the near and far clip planes correspond to 
        |z normalized device coordinates of `0` and `+1` respectively. (Direct3D clip volume definition)
        |Otherwise, the near and far clip planes correspond to z normalized device coordinates of `-1` and `+1` respectively. (OpenGL clip volume definition)
        |
        |@param fovy Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
        |@param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
        |@param zNear Specifies the distance from the viewer to the near clipping plane (always positive).
        |@param zFar Specifies the distance from the viewer to the far clipping plane (always positive).""")
    +"""
        fun glm.perspectiveLH(fovy: $type, aspect: $type, zNear: $type, zFar: $type, res: Mat4$id = Mat4$id()): Mat4$id =
            when (GLM_DEPTH_CLIP_SPACE) {
                GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveLH_ZO(fovy, aspect, zNear, zFar, res)
                else -> perspectiveLH_NO(fovy, aspect, zNear, zFar, res)
            }"""

    docs("""
        |Creates a matrix for a symetric perspective-view frustum based on the default handedness and default near and far clip planes definition.
        |To change default handedness use `GLM_COORDINATE_SYSTEM`. To change default near and far clip planes definition use `GLM_DEPTH_CLIP_SPACE`.
        |
        |@param fovy Specifies the field of view angle in the y direction. Expressed in radians.
        |@param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
        |@param zNear Specifies the distance from the viewer to the near clipping plane (always positive).
        |@param zFar Specifies the distance from the viewer to the far clipping plane (always positive).
        |
        |@see <a href="https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/gluPerspective.xml">gluPerspective man page</a>""")
    +"""
        fun glm.perspective(fovy: $type, aspect: $type, zNear: $type, zFar: $type, res: Mat4$id = Mat4$id()): Mat4$id =
            when (GLM_COORDINATE_SYSTEM) {
                GlmCoordinateSystem.LEFT_HANDED -> when (GLM_DEPTH_CLIP_SPACE) {
                    GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveLH_ZO(fovy, aspect, zNear, zFar, res)
                    else -> perspectiveLH_NO(fovy, aspect, zNear, zFar, res)
                }
                else -> when (GLM_DEPTH_CLIP_SPACE) {
                    GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveRH_ZO(fovy, aspect, zNear, zFar, res)
                    else -> perspectiveRH_NO(fovy, aspect, zNear, zFar, res)
                }
            }"""

    docs("""
        |Builds a perspective projection matrix based on a field of view using right-handed coordinates.
        |The near and far clip planes correspond to z normalized device coordinates of `0` and `+1` respectively. (Direct3D clip volume definition)
        |
        |@param fov Expressed in radians.
        |@param width Width of the viewport
        |@param height Height of the viewport
        |@param zNear Specifies the distance from the viewer to the near clipping plane (always positive).
        |@param zFar Specifies the distance from the viewer to the far clipping plane (always positive).""")
    +"""
        fun glm.perspectiveFovRH_ZO(fov: $type, width: $type, height: $type, zNear: $type, zFar: $type, res: Mat4$id = Mat4$id()): Mat4$id {
            check(width > $`0`) { "glm::perspectiveFovRH_ZO(fov: $type, width: $type, height: $type, zNear: $type, zFar: $type), width <= $`0`" }
            check(height > $`0`) { "glm::perspectiveFovRH_ZO(fov: $type, width: $type, height: $type, zNear: $type, zFar: $type), height <= $`0`" }
            check(fov > $`0`) { "glm::perspectiveFovRH_ZO(fov: $type, width: $type, height: $type, zNear: $type, zFar: $type), fov <= $`0`" }
    
            val rad = fov
            val h = ($`0,5` * rad).cos / ($`0,5` * rad).sin
            val w = h * height / width ///todo max(width , Height) / min(width , Height)?
    
            res put $`0`
            res[0, 0] = w
            res[1, 1] = h
            res[2, 2] = zFar / (zNear - zFar)
            res[2, 3] = - $`1`
            res[3, 2] = -(zFar * zNear) / (zFar - zNear)
            return res
        }
        """

    docs("""
        |Builds a perspective projection matrix based on a field of view using right-handed coordinates.
        |The near and far clip planes correspond to z normalized device coordinates of `-1` and `+1` respectively. (OpenGL clip volume definition)
        |
        |@param fov Expressed in radians.
        |@param width Width of the viewport
        |@param height Height of the viewport
        |@param zNear Specifies the distance from the viewer to the near clipping plane (always positive).
        |@param zFar Specifies the distance from the viewer to the far clipping plane (always positive).""")
    +"""
        fun glm.perspectiveFovRH_NO(fov: $type, width: $type, height: $type, zNear: $type, zFar: $type, res: Mat4$id = Mat4$id()): Mat4$id {
            check(width > $`0`) { "glm::perspectiveFovRH_NO(fov: $type, width: $type, height: $type, zNear: $type, zFar: $type), width <= $`0`" }
            check(height > $`0`) { "glm::perspectiveFovRH_NO(fov: $type, width: $type, height: $type, zNear: $type, zFar: $type), height <= $`0`" }
            check(fov > $`0`) { "glm::perspectiveFovRH_NO(fov: $type, width: $type, height: $type, zNear: $type, zFar: $type), fov <= $`0`" }
    
            val rad = fov
            val h = ($`0,5` * rad).cos / ($`0,5` * rad).sin
            val w = h * height / width ///todo max(width , Height) / min(width , Height)?
    
            res put $`0`
            res[0, 0] = w
            res[1, 1] = h
            res[2, 2] = - (zFar + zNear) / (zFar - zNear)
            res[2, 3] = - $`1`
            res[3, 2] = - ($`2` * zFar * zNear) / (zFar - zNear)
            return res
        }"""

    docs("""
        |Builds a perspective projection matrix based on a field of view using left-handed coordinates.
        |The near and far clip planes correspond to z normalized device coordinates of `0` and `+1` respectively. (Direct3D clip volume definition)
        |
        |@param fov Expressed in radians.
        |@param width Width of the viewport
        |@param height Height of the viewport
        |@param zNear Specifies the distance from the viewer to the near clipping plane (always positive).
        |@param zFar Specifies the distance from the viewer to the far clipping plane (always positive).""")
    +"""
        fun glm.perspectiveFovLH_ZO(fov: $type, width: $type, height: $type, zNear: $type, zFar: $type, res: Mat4$id = Mat4$id()): Mat4$id {
            check(width > $`0`) { "glm::perspectiveFovLH_ZO(fov: $type, width: $type, height: $type, zNear: $type, zFar: $type), width <= $`0`" }
            check(height > $`0`) { "glm::perspectiveFovLH_ZO(fov: $type, width: $type, height: $type, zNear: $type, zFar: $type), height <= $`0`" }
            check(fov > $`0`) { "glm::perspectiveFovLH_ZO(fov: $type, width: $type, height: $type, zNear: $type, zFar: $type), fov <= $`0`" }
    
            val rad = fov
            val h = ($`0,5` * rad).cos / ($`0,5` * rad).sin
            val w = h * height / width ///todo max(width , Height) / min(width , Height)?
    
            res put $`0`
            res[0, 0] = w
            res[1, 1] = h
            res[2, 2] = zFar / (zFar - zNear)
            res[2, 3] = $`1`
            res[3, 2] = -(zFar * zNear) / (zFar - zNear)
            return res
        }"""

    docs("""
        |Builds a perspective projection matrix based on a field of view using left-handed coordinates.
        |The near and far clip planes correspond to z normalized device coordinates of `-1` and `+1` respectively. (OpenGL clip volume definition)
        |
        |@param fov Expressed in radians.
        |@param width Width of the viewport
        |@param height Height of the viewport
        |@param zNear Specifies the distance from the viewer to the near clipping plane (always positive).
        |@param zFar Specifies the distance from the viewer to the far clipping plane (always positive).""")
    +"""
        fun glm.perspectiveFovLH_NO(fov: $type, width: $type, height: $type, zNear: $type, zFar: $type, res: Mat4$id = Mat4$id()): Mat4$id {
            check(width > $`0`) { "glm::perspectiveFovLH_NO(fov: $type, width: $type, height: $type, zNear: $type, zFar: $type), width < $`0`!" } 
            check(height > $`0`) { "glm::perspectiveFovLH_NO(fov: $type, width: $type, height: $type, zNear: $type, zFar: $type), height < $`0`!" } 
            check(fov > $`0`) { "glm::perspectiveFovLH_NO(fov: $type, width: $type, height: $type, zNear: $type, zFar: $type), fov < $`0`!" } 

            val rad = fov
            val h = ($`0,5` * rad).cos / ($`0,5` * rad).sin
            val w = h * height / width ///todo max(width , Height) / min(width , Height)
    
            res put $`0`
            res[0, 0] = w
            res[1, 1] = h
            res[2, 2] = (zFar + zNear) / (zFar - zNear)
            res[2, 3] = $`1`
            res[3, 2] = - ($`2` * zFar * zNear) / (zFar - zNear)
            return res
        }"""

    docs("""
        |Builds a perspective projection matrix based on a field of view using left-handed coordinates if `GLM_COORDINATE_SYSTEM == GlmCoordinateSystem.LEFT_HANDED`
        |or right-handed coordinates otherwise.
        |The near and far clip planes correspond to z normalized device coordinates of `0` and `+1` respectively. (Direct3D clip volume definition)
        |
        |@param fov Expressed in radians.
        |@param width Width of the viewport
        |@param height Height of the viewport
        |@param zNear Specifies the distance from the viewer to the near clipping plane (always positive).
        |@param zFar Specifies the distance from the viewer to the far clipping plane (always positive).""")
    +"""
        fun glm.perspectiveFovZO(fov: $type, width: $type, height: $type, zNear: $type, zFar: $type, res: Mat4$id = Mat4$id()): Mat4$id =
            when (GLM_COORDINATE_SYSTEM) {
                GlmCoordinateSystem.LEFT_HANDED -> perspectiveFovLH_ZO(fov, width, height, zNear, zFar, res)
                else -> perspectiveFovRH_ZO(fov, width, height, zNear, zFar, res)
            }"""

    docs("""
        |Builds a perspective projection matrix based on a field of view using left-handed coordinates if `GLM_COORDINATE_SYSTEM == GlmCoordinateSystem.LEFT_HANDED`
        |or right-handed coordinates otherwise.
        |The near and far clip planes correspond to z normalized device coordinates of `-1` and `+1` respectively. (OpenGL clip volume definition)
        |
        |@param fov Expressed in radians.
        |@param width Width of the viewport
        |@param height Height of the viewport
        |@param zNear Specifies the distance from the viewer to the near clipping plane (always positive).
        |@param zFar Specifies the distance from the viewer to the far clipping plane (always positive).""")
    +"""
        fun glm.perspectiveFovNO(fov: $type, width: $type, height: $type, zNear: $type, zFar: $type, res: Mat4$id = Mat4$id()): Mat4$id =
            when (GLM_COORDINATE_SYSTEM) {
                GlmCoordinateSystem.LEFT_HANDED -> perspectiveFovLH_NO(fov, width, height, zNear, zFar, res)
                else -> perspectiveFovRH_NO(fov, width, height, zNear, zFar)
            }"""

    docs("""
        |Builds a right handed perspective projection matrix based on a field of view.
        |If `GLM_DEPTH_CLIP_SPACE == GlmDepthClipSpace.ZERO_TO_ONE`, the near and far clip planes correspond to 
        |z normalized device coordinates of `0` and `+1` respectively. (Direct3D clip volume definition)
        |Otherwise, the near and far clip planes correspond to z normalized device coordinates of `-1` and `+1` respectively. (OpenGL clip volume definition)
        |
        |@param fov Expressed in radians.
        |@param width Width of the viewport
        |@param height Height of the viewport
        |@param zNear Specifies the distance from the viewer to the near clipping plane (always positive).
        |@param zFar Specifies the distance from the viewer to the far clipping plane (always positive).""")
    +"""
        fun glm.perspectiveFovRH(fov: $type, width: $type, height: $type, zNear: $type, zFar: $type, res: Mat4$id = Mat4$id()): Mat4$id =
            when (GLM_DEPTH_CLIP_SPACE) {
                GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovRH_ZO(fov, width, height, zNear, zFar, res)
                else -> perspectiveFovRH_NO(fov, width, height, zNear, zFar, res)
            }"""

    docs("""
        |Builds a left handed perspective projection matrix based on a field of view.
        |If `GLM_DEPTH_CLIP_SPACE == GlmDepthClipSpace.ZERO_TO_ONE`, the near and far clip planes correspond to 
        |z normalized device coordinates of `0` and `+1` respectively. (Direct3D clip volume definition)
        |Otherwise, the near and far clip planes correspond to z normalized device coordinates of `-1` and `+1` respectively. (OpenGL clip volume definition)
        |
        |@param fov Expressed in radians.
        |@param width Width of the viewport
        |@param height Height of the viewport
        |@param zNear Specifies the distance from the viewer to the near clipping plane (always positive).
        |@param zFar Specifies the distance from the viewer to the far clipping plane (always positive).""")
    +"""
        fun glm.perspectiveFovLH(fov: $type, width: $type, height: $type, zNear: $type, zFar: $type, res: Mat4$id = Mat4$id()): Mat4$id =
            when (GLM_DEPTH_CLIP_SPACE) {
                GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovLH_ZO(fov, width, height, zNear, zFar, res)
                else -> perspectiveFovLH_NO(fov, width, height, zNear, zFar, res)
            }"""

    docs("""
        |Builds a perspective projection matrix based on a field of view and the default handedness and default near and far clip planes definition.
        |To change default handedness use `GLM_COORDINATE_SYSTEM`. To change default near and far clip planes definition use `GLM_DEPTH_CLIP_SPACE`.
        |
        |@param fov Expressed in radians.
        |@param width Width of the viewport
        |@param height Height of the viewport
        |@param zNear Specifies the distance from the viewer to the near clipping plane (always positive).
        |@param zFar Specifies the distance from the viewer to the far clipping plane (always positive).""")
    +"""
         fun glm.perspectiveFov(fov: $type, width: $type, height: $type, zNear: $type, zFar: $type, res: Mat4$id = Mat4$id()): Mat4$id =
            when (GLM_COORDINATE_SYSTEM) {
                GlmCoordinateSystem.LEFT_HANDED -> when (GLM_DEPTH_CLIP_SPACE) {
                    GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovLH_ZO(fov, width, height, zNear, zFar, res)
                    else -> perspectiveFovLH_NO(fov, width, height, zNear, zFar, res)
                }
                else -> when (GLM_DEPTH_CLIP_SPACE) {
                    GlmDepthClipSpace.ZERO_TO_ONE -> perspectiveFovRH_ZO(fov, width, height, zNear, zFar, res)
                    else -> perspectiveFovRH_NO(fov, width, height, zNear, zFar, res)
                }
            }"""

    docs("""
        |Creates a matrix for a left handed, symmetric perspective-view frustum with far plane at infinite.
        |
        |@param fovy Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
        |@param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
        |@param zNear Specifies the distance from the viewer to the near clipping plane (always positive).""")
    +"""
        fun glm.infinitePerspectiveLH(fovy: $type, aspect: $type, zNear: $type, res: Mat4$id = Mat4$id()): Mat4$id {
            val range = (fovy / $`2`).tan * zNear
            val left = -range * aspect
            val right = range * aspect
            val bottom = -range
            val top = range
    
            res put $`0`
            res[0, 0] = ($`2` * zNear) / (right - left)
            res[1, 1] = ($`2` * zNear) / (top - bottom)
            res[2, 2] = $`1`
            res[2, 3] = $`1`
            res[3, 2] = - $`2` * zNear
            return res
        }"""

    docs("""
        |Creates a matrix for a right handed, symmetric perspective-view frustum with far plane at infinite.
        |
        |@param fovy Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
        |@param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
        |@param zNear Specifies the distance from the viewer to the near clipping plane (always positive).""")
    +"""
        fun glm.infinitePerspectiveRH(fovy: $type, aspect: $type, zNear: $type, res: Mat4$id = Mat4$id()): Mat4$id {
            val range = (fovy / $`2`).tan * zNear
            val left = -range * aspect
            val right = range * aspect
            val bottom = -range
            val top = range
    
            res put $`0`
            res[0, 0] = ($`2` * zNear) / (right - left)
            res[1, 1] = ($`2` * zNear) / (top - bottom)
            res[2, 2] = - $`1`
            res[2, 3] = - $`1`
            res[3, 2] = - $`2` * zNear
            return res
        }"""

    docs("""
        |Creates a matrix for a symmetric perspective-view frustum with far plane at infinite with default handedness.
        |
        |@param fovy Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
        |@param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
        |@param zNear Specifies the distance from the viewer to the near clipping plane (always positive).""")
    +"""
        fun glm.infinitePerspective(fovy: $type, aspect: $type, zNear: $type, res: Mat4$id = Mat4$id()): Mat4$id =
            when (GLM_COORDINATE_SYSTEM) {
                GlmCoordinateSystem.LEFT_HANDED -> infinitePerspectiveLH(fovy, aspect, zNear, res)
                else -> infinitePerspectiveRH(fovy, aspect, zNear, res)
            }"""

    docs("""
        |Creates a matrix for a symmetric perspective-view frustum with far plane at infinite for graphics hardware that doesn't support depth clamping.
        |
        |@param fovy Specifies the field of view angle, in degrees, in the y direction. Expressed in radians.
        |@param aspect Specifies the aspect ratio that determines the field of view in the x direction. The aspect ratio is the ratio of x (width) to y (height).
        |@param near Specifies the distance from the viewer to the near clipping plane (always positive).
        |@param ep Epsilon""")
    +"""
        fun glm.tweakedInfinitePerspective(fovy: $type, aspect: $type, zNear: $type, ep: $type = glm.epsilon.$extension, res: Mat4$id = Mat4$id()): Mat4$id {
            val range = (fovy / $`2`).tan * zNear
            val left = -range * aspect
            val right = range * aspect
            val bottom = -range
            val top = range
    
            res put $`0`
            res[0, 0] = ($`2` * zNear) / (right - left)
            res[1, 1] = ($`2` * zNear) / (top - bottom)
            res[2, 2] = ep - $`1`
            res[2, 3] = $`-1`
            res[3, 2] = (ep - $`2`) * zNear
            return res
        }"""
}