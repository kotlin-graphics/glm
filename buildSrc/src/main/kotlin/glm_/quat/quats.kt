package glm_.quat

import java.io.File
import glm_.*
import glm_.gen.Generator
import glm_.gen.generate

fun quaternions(target: File) {
    generate(target, "glm_/quat/QuatT.kt") {

        `package` = "glm_.quat"
        "abstract class QuatT<T>" {

            +"// -- Data --"
            wxyz { +"abstract var $it: T" }
            wxyzIndexed { i, c -> +"operator fun component${i + 1}() = $c" }

            +"// -- Component accesses --"
            "operator fun get(index: Int): T = when (index)" {
                wxyzIndexed { i, c -> +"$i -> $c" }
                +"else -> throw IndexOutOfBoundsException()"
            }

            "operator fun set(index: Int, value: T) = when(index)" {
                wxyzIndexed { i, c ->
                    "$i ->" {
                        +"$c = value"
                    }
                }
                +"else -> throw IndexOutOfBoundsException()"
            }

            "companion object" {
                +"const val length = 4"
            }
        }
    }
    for ((type, extension, conversion, id) in numberTypeInformation.filter { it.type == "Float" || it.type == "Double" })
        generate(target, "glm_/quat/Quat$id.kt") {
            `package` = "glm_.quat"
            imports += listOf("glm_.vec3.Vec3$id",
                              "kotlin.math.sqrt",
                              "kotlin.math.abs")
            experimentals += Generator.Experimentals.Contracts
            quatId(type, extension, conversion, id)
        }
}

fun Generator.quatId(type: String, extension: String, conversion: String, id: String) {

    val `wxyz type` = wxyzJoint { "$it: $type" }
    imports += listOf(
        "glm_.extensions.$extension",
        "glm_.vec4.Vec4$id",
        "glm_.vec3.Vec3T",
                     )
    val `0,5` = type.`0,5`

    "open class Quat$id(var array: ${type}Array, var ofs: Int = 0): QuatT<$type>()" {
        wxyzIndexed { i, c ->
            +"override var $c: $type"
            val delta = if (i == 0) "" else " + $i"
            +"\tget() = array[ofs$delta]"
            "set(value)" {
                +"array[ofs$delta] = value"
            }
        }
        val postfix = if (type == "Float") "f" else ".0"
        val otherID = if (id.isEmpty()) "d" else ""
        +"""
            // -- Implicit basic constructors --
            constructor(): this(1$postfix, 0$postfix, 0$postfix, 0$postfix)
            constructor(q: Quat$id): this(q.w, q.x, q.y, q.z)
            constructor(q: Quat$otherID): this(q.w.to$type(), q.x.to$type(), q.y.to$type(), q.z.to$type())
            // -- Explicit basic constructors --
            constructor(s: $type, v: Vec3$id): this(s, v.x, v.y, v.z)
            constructor(s: Number, v: Vec3T<out Number>): this(s.$extension, v.x.$extension, v.y.$extension, v.z.$extension)
            constructor(w: $type, x: $type, y: $type, z: $type): this(${type.toLowerCase()}ArrayOf(w, x, y, z))
            constructor(w: Number, x: Number, y: Number, z: Number): this(w.$extension, x.$extension, y.$extension, z.$extension)
            // -- Conversion constructors --
            constructor(q: QuatT<out Number>): this(q.w.$conversion(), q.x.$conversion(), q.y.$conversion(), q.z.$conversion())
            /** Create a quaternion from two normalized axis
             *
             * @param u: A first normalized axis
             * @param v: A second normalized axis
             * http://lolengine.net/blog/2013/09/18/beautiful-maths-quaternion-from-vectors */
            constructor(u: Vec3$id, v: Vec3$id): this() {
                val normUnormV = sqrt((u dot u) * (v dot v))
                var realPart = normUnormV + (u dot v)
                val tX: $type; val tY: $type; val tZ: $type
                when {
                    realPart < 1e-6f * normUnormV -> {
                        /*  If u and v are exactly opposite, rotate 180 degrees around an arbitrary orthogonal axis.
                            Axis normalisation can happen later, when we normalise the quaternion. */
                        realPart = ${type.`0`}
                        if (abs(u.x) > abs(u.z)) {
                            tX = -u.y; tY = u.x; tZ = ${type.`0`}
                        } else {
                            tX = ${type.`0`}; tY = -u.z; tZ = u.y
                        }
                    }
                    // Otherwise, build quaternion the standard way.
                    else -> u.cross(v) { resX: $type, resY: $type, resZ: $type -> 
                        tX = resX; tY = resY; tZ = resZ
                    }
                }
                this(realPart, tX, tY, tZ).normalizeAssign()
            }
            /* Build a quaternion from euler angles (pitch, yaw, roll), in radians. */
            constructor(eulerAngle: Vec3$id) : this() {
                val eX = eulerAngle.x * $`0,5`
                val eY = eulerAngle.y * $`0,5`
                val eZ = eulerAngle.z * $`0,5`
                Vec3$id.cos(eX, eY, eZ) { cX, cY, cZ ->
                    Vec3$id.sin(eX, eY, eZ) { sX, sY, sZ ->
                        this.w = cX * cY * cZ + sX * sY * sZ
                        this.x = sX * cY * cZ - cX * sY * sZ
                        this.y = cX * sY * cZ + sX * cY * sZ
                        this.z = cX * cY * sZ - sX * sY * cZ
                    }
                }
            }"""

        // custom glm, functional programming
        val block = wxyzJointIndexed { i, _ -> "block($i)" }
        +"constructor(block: (i: Int) -> $type) : this($block)"

        /*template<typename T, qualifier Q>
        GLM_FUNC_QUALIFIER qua<T, Q>::qua(mat<3, 3, T, Q> const& m)
        {
            *this = quat_cast(m);
        }

        template<typename T, qualifier Q>
        GLM_FUNC_QUALIFIER qua<T, Q>::qua(mat<4, 4, T, Q> const& m)
        {
            *this = quat_cast(m);
        }*/

        "operator fun invoke($`wxyz type`): Quat$id" {
            wxyz { +"this.$it = $it" }
            +"return this"
        }
        "fun put($`wxyz type`)" { wxyz { +"this.$it = $it" } }

        +"// -- Unary bit operators --\n"

        +"""operator fun unaryPlus(): Quat$id = this"""
        +"""operator fun unaryMinus(): Quat$id = Quat$id(-w, -x, -y, -z)"""

        quaternionOperators(type, extension, conversion, id, Generator.Part.Class)
        quatGeometrical(type, extension, conversion, id, Generator.Part.Class)
        quatRelational(type, extension, conversion, id, Generator.Part.Class)

        "companion object" {
            +"const val length = QuatT.length"
            +"const val size: Int = length * $type.SIZE_BYTES"
            quaternionOperators(type, extension, conversion, id, Generator.Part.CompanionObject)
            quatGeometrical(type, extension, conversion, id, Generator.Part.CompanionObject)
            quatRelational(type, extension, conversion, id, Generator.Part.CompanionObject)
        }
    }

    // scalar operators
    +"operator infix fun $type.times(q: Quat$id): Quat$id = q * this"
}