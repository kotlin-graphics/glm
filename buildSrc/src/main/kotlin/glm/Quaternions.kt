package glm

import java.io.File

fun quaternions(target: File) {
    generate(target, "glm/quat/QuatT.kt") {

        +"package glm.quat"
        "abstract class QuatT<T>" {

            +"// -- Data --"
            wxyz { c -> +"abstract var $c: T" }
            wxyz { i, c -> +"operator fun component${i + 1}() = $c" }

            +"// -- Component accesses --"
            "operator fun get(index: Int): T = when (index)" {
                wxyz { i, c -> +"$i -> $c" }
                +"else -> throw IndexOutOfBoundsException()"
            }

            "operator fun set(index: Int, value: T) = when(index)" {
                wxyz { i, c ->
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
        generate(target, "glm/quat/Quat$id.kt") {
            quaternionT(type, extension, conversion, id)
        }
}

fun Generator.quaternionT(type: String, extension: String, conversion: String, id: String) {
    +"package glm.quat"
    +"import glm.vec3.Vec3$id"
    +"import kotlin.math.sqrt"
    +"import kotlin.math.abs"
    "open class Quat$id(var array: ${type}Array, var ofs: Int = 0): QuatT<$type>()" {
        wxyz { i, c ->
            +"override var $c: $type"
            val delta = if (i == 0) "" else " + $i"
            +"\tget() = array[ofs$delta]"
            "set(value)" {
                +"array[ofs$delta] = value"
            }
        }
        +"// -- Implicit basic constructors --"
        val postfix = if (type == "Float") "f" else ".0"
        +"constructor(): this(1$postfix, 0$postfix, 0$postfix, 0$postfix)"
        +"constructor(q: Quat$id): this(q.w, q.x, q.y, q.z)"
        +"// -- Explicit basic constructors --"
        +"constructor(s: $type, v: Vec3$id): this(s, v.x, v.y, v.z)"
        +"constructor(w: $type, x: $type, y: $type, z: $type): this(${type.toLowerCase()}ArrayOf(w, x, y, z))"
        +"// -- Conversion constructors --"
        +"constructor(q: QuatT<out Number>): this(q.w.$conversion(), q.x.$conversion(), q.y.$conversion(), q.z.$conversion())"
        +"/** Create a quaternion from two normalized axis"
        +" *  "
        +" * @param u: A first normalized axis"
        +" * @param v: A second normalized axis"
        +" * @see http://lolengine.net/blog/2013/09/18/beautiful-maths-quaternion-from-vectors */"
        "constructor(u: Vec3$id, v: Vec3$id): this()" {
            +"val normU_normV = sqrt((u dot u) * (v dot v))"
            +"var realPart = normU_normV + (u dot v)"
//            vec<3, T, Q> t;

            "if(realPart < 1e-6f * normU_normV)" {
                +"// If u and v are exactly opposite, rotate 180 degrees"
                +"// around an arbitrary orthogonal axis. Axis normalisation"
                +"// can happen later, when we normalise the quaternion."
                +"realPart = 0${if (type == "Double") ".0" else "f"}"
                "if(abs(u.x) > abs(u.z))"{
                    +"array[1] = -u.y"
                    +"array[2] = u.x"
                }
                "else" {
                    +"array[2] = -u.z"
                    +"array[3] = u.y"
                }
            }
            "else" {
                +"// Otherwise, build quaternion the standard way."
//                t = cross(u, v);
            }
//            *this = normalize(qua<T, Q>(real_part, t.x, t.y, t.z));
        }
    }
}