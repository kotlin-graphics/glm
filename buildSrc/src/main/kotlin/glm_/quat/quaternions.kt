package glm_.quat

import java.io.File
import glm_.*
import glm_.gen.Generator
import glm_.gen.generate

fun quaternions(target: File) {
    generate(target, "glm_/quat/QuatT.kt") {

        +"package glm_.quat"
        "abstract class QuatT<T>" {

            +"// -- Data --"
            wxyz { c -> +"abstract var $c: T" }
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
            quaternionT(type, extension, conversion, id)
        }
}

fun Generator.quaternionT(type: String, extension: String, conversion: String, id: String) {
    +"package glm_.quat"
    +"import glm_.vec3.Vec3$id"
    +"import kotlin.math.sqrt"
    +"import kotlin.math.abs"

    val `wxyz type` = wxyzJoint { "$it: $type" }

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
            constructor(w: $type, x: $type, y: $type, z: $type): this(${type.toLowerCase()}ArrayOf(w, x, y, z))
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
                val tX: $type
                val tY: $type
                val tZ: $type
                when {
                    realPart < 1e-6f * normUnormV -> {
                        /*  If u and v are exactly opposite, rotate 180 degrees around an arbitrary orthogonal axis.
                            Axis normalisation can happen later, when we normalise the quaternion. */
                        realPart = ${type.`0`}
                        if (abs(u.x) > abs(u.z)) {
                            tX = -u.y
                            tY = u.x
                            tZ = ${type.`0`}
                        } else {
                            tX = ${type.`0`}
                            tY = -u.z
                            tZ = u.y
                        }
                    }
                    // Otherwise, build quaternion the standard way.
                    else -> u.cross(v) { resX: $type, resY: $type, resZ: $type -> 
                        tX = resX
                        tY = resY
                        tZ = resZ
                    }
                }
                //this(realPart, tX, tY, tZ).normalizeAssign()
            }
            /* Build a quaternion from euler angles (pitch, yaw, roll), in radians. */
            //constructor("""

        "operator fun invoke($`wxyz type`): Quat$id" {
            wxyz { +"this.$it = $it" }
            +"return this"
        }
        "fun put($`wxyz type`)" { wxyz { +"this.$it = $it" } }
    }
}