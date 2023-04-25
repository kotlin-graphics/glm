package glm_.generators.detail

import glm_.generators.Type
import glm_.generators.gen.Generator

fun Generator.packing(ordinal: Int, type: Type, id: String, vec: String, part: Generator.Part) {

    fun packing(doc: String, func: String) = docs("""
        ${if (doc.startsWith('|')) doc else "|$doc"}
        |
        |@see <a href="http://www.opengl.org/sdk/docs/manglsl/xhtml/$func.xml">GLSL $func man page</a>
        |@see <a href="http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf">GLSL 4.20.8 specification, section 8.4 Floating-Point Pack and Unpack Functions</a>""")

    val vecID = "Vec$ordinal$id"

    if (vecID == "Vec2") {
        imports += listOf("glm_.vec2.Vec2", "kotlin.UInt")
        fun packUnorm2x16(v: String = "v") = packing("""
            |First, converts each component of the normalized floating-point value `$v` into 8- or 16-bit integer values.
            |Then, the results are packed into the returned 32-bit unsigned integer.
            |
            |The conversion for component `c` of `$v` to fixed point is done as follows:
            |packUnorm2x16: `round(clamp(c, 0, +1) * 65535.0)`
            |
            |The first component of the vector will be written to the least significant bits of the output;
            |the last component will be written to the most significant bits.""", "packUnorm2x16")
        when (part) {
            Generator.Part.Class -> {
                packUnorm2x16("this")
                +"fun packUnorm2x16(): UInt = packUnorm2x16(this)"
            }
            Generator.Part.CompanionObject -> {
                imports += listOf("glm_.extensions.us", "glm_.extensions.ui")
                packUnorm2x16()
                +"""
                    fun packUnorm2x16(v: Vec2): UInt {
                        val x = (v.x.clamp(0f, 1f) * 65535f).round().us
                        val y = (v.y.clamp(0f, 1f) * 65535f).round().us
                
                        val a = x.ui and 0xFFFFu
                        val b = y.ui shl 16
                
                        return a or b
                    }"""
            }
            else -> Unit
        }

        fun packSnorm2x16(v: String = "v") = packing("""
            |First, converts each component of the normalized floating-point value `$v` into 8- or 16-bit integer values.
            |Then, the results are packed into the returned 32-bit unsigned integer.
            |
            |The conversion for component `c` of `v` to fixed point is done as follows:
            |packSnorm2x16: `round(clamp(v, -1, +1) * 32767.0)`
            |
            |The first component of the vector will be written to the least significant bits of the output;
            |the last component will be written to the most significant bits.""", "packSnorm2x16")
        when (part) {
            Generator.Part.Class -> {
                packSnorm2x16("this")
                +"fun packSnorm2x16(): UInt = packSnorm2x16(this)"
            }
            Generator.Part.CompanionObject -> {
                packSnorm2x16()
                +"""
                    fun packSnorm2x16(v: Vec2): UInt {
                        val x = (v.x.clamp(-1f, 1f) * 32767f).round().s
                        val y = (v.y.clamp(-1f, 1f) * 32767f).round().s
                
                        val a = x.ui and 0xFFFFu
                        val b = y.ui shl 16
                
                        return a or b
                    }"""
            }
            else -> Unit
        }
    } else if (vecID == "Vec4") {
        fun packUnorm4x8(v: String = "v") = packing("""
        |First, converts each component of the normalized floating-point value `$v` into 8- or 16-bit integer values.
        |Then, the results are packed into the returned 32-bit unsigned integer.
        |
        |The conversion for component `c` of `$v` to fixed point is done as follows:
        |packUnorm4x8: `round(clamp(c, 0, +1) * 255.0)`
        |
        |The first component of the vector will be written to the least significant bits of the output;
        |the last component will be written to the most significant bits.""", "packUnorm4x8")
        when (part) {
            Generator.Part.Class -> {
                packUnorm4x8("this")
                +"fun packUnorm4x8(): UInt = packUnorm4x8(this)"
            }
            Generator.Part.CompanionObject -> {
                packUnorm4x8()
                +"""
                    fun packUnorm4x8(v: Vec4): UInt {
                        val x = (v.x.clamp(0f, 1f) * 255f).round().ub
                        val y = (v.y.clamp(0f, 1f) * 255f).round().ub
                        val z = (v.z.clamp(0f, 1f) * 255f).round().ub
                        val w = (v.w.clamp(0f, 1f) * 255f).round().ub
                
                        val a = x.ui and 0xFFu
                        val b = (y.ui and 0xFFu) shl 8
                        val c = (z.ui and 0xFFu) shl 16
                        val d = w.ui shl 24
                
                        return a or b or c or d
                    }"""
            }
            else -> Unit
        }

        fun packSnorm4x8(v: String = "v") = packing("""
            |First, converts each component of the normalized floating-point value `$v` into 8- or 16-bit integer values.
            |Then, the results are packed into the returned 32-bit unsigned integer.
            |
            |The conversion for component `c` of `$v` to fixed point is done as follows:
            |packSnorm4x8:	`round(clamp(c, -1, +1) * 127.0)`
            |
            |The first component of the vector will be written to the least significant bits of the output;
            |the last component will be written to the most significant bits.""", "packSnorm4x8")
        when (part) {
            Generator.Part.Class -> {
                packSnorm4x8("this")
                +"fun packSnorm4x8(): UInt = packSnorm4x8(this)"
            }
            Generator.Part.CompanionObject -> {
                packSnorm4x8()
                +"""
                    fun packSnorm4x8(v: Vec4): UInt {
                        val x = (v.x.clamp(-1f, 1f) * 127f).round().b
                        val y = (v.y.clamp(-1f, 1f) * 127f).round().b
                        val z = (v.z.clamp(-1f, 1f) * 127f).round().b
                        val w = (v.w.clamp(-1f, 1f) * 127f).round().b
                
                        val a = x.ui and 0xFFu
                        val b = (y.ui and 0xFFu) shl 8
                        val c = (z.ui and 0xFFu) shl 16
                        val d = w.ui shl 24
                
                        return a or b or c or d
                    }"""
            }
            else -> Unit
        }
    }

    val isUInt = ordinal == 0 && type == Type.UInt && part == Generator.Part.Scalar
    if (isUInt) {
        imports += listOf("glm_.vec2.Vec2", "glm_.vec4.Vec4", "kotlin.UInt", "glm_.extensions.*")
        packing("""
            |First, unpacks a single 32-bit unsigned integer `this` into a pair of 16-bit unsigned integers, four 8-bit unsigned integers, or four 8-bit signed integers.
            |Then, each component is converted to a normalized floating-point value to generate the returned two- or four-component vector.
            |
            |The conversion for unpacked fixed-point value `f` to floating point is done as follows:
            |unpackUnorm2x16: `f / 65535.0`
            |
            |The first component of the returned vector will be extracted from the least significant bits of the input;
            |the last component will be extracted from the most significant bits.""", "unpackUnorm2x16")
        +"""
            fun UInt.unpackUnorm2x16(res: Vec2 = Vec2()): Vec2 {
                val x = (this and 0xFFFFu).us
                val y = (this shr 16).us
        
                return res(x.ui.f * 1.5259021896696421759365224689097e-5f,
                           y.ui.f * 1.5259021896696421759365224689097e-5f)
            }"""
        packing("""
            |First, unpacks a single 32-bit unsigned integer `this` into a pair of 16-bit unsigned integers, four 8-bit unsigned integers, or four 8-bit signed integers.
            |Then, each component is converted to a normalized floating-point value to generate the returned two- or four-component vector.
            |
            |The conversion for unpacked fixed-point value `f` to floating point is done as follows:
            |unpackSnorm2x16: `clamp(f / 32767.0, -1, +1)`
            |
            |The first component of the returned vector will be extracted from the least significant bits of the input;
            |the last component will be extracted from the most significant bits.""", "unpackSnorm2x16")
        +"""
            fun UInt.unpackSnorm2x16(res: Vec2 = Vec2()): Vec2 {
                val x = (this and 0xFFFFu).s
                val y = (this shr 16).s
                        
                return res((x.f * 3.0518509475997192297128208258309e-5f).clamp(-1f, 1f),
                           (y.f * 3.0518509475997192297128208258309e-5f).clamp(-1f, 1f))
            }"""

        packing("""
            |First, unpacks a single 32-bit unsigned integer `this` into a pair of 16-bit unsigned integers, four 8-bit unsigned integers, or four 8-bit signed integers.
            |Then, each component is converted to a normalized floating-point value to generate the returned two- or four-component vector.
            |
            |The conversion for unpacked fixed-point value f to floating point is done as follows:
            |unpackUnorm4x8: `f / 255.0`
            |
            |The first component of the returned vector will be extracted from the least significant bits of the input;
            |the last component will be extracted from the most significant bits.""", "unpackUnorm4x8")
        +"""
            fun UInt.unpackUnorm4x8(res: Vec4 = Vec4()): Vec4 {
                val x = (this and 0xFFu).ub
                val y = ((this shr 8) and 0xFFu).ub
                val z = ((this shr 16) and 0xFFu).ub
                val w = (this shr 24).ub
        
                res.x = x.ui.f * 0.0039215686274509803921568627451f
                res.y = y.ui.f * 0.0039215686274509803921568627451f
                res.z = z.ui.f * 0.0039215686274509803921568627451f
                res.w = w.ui.f * 0.0039215686274509803921568627451f
        
                return res
            }"""

        packing("""
            |First, unpacks a single 32-bit unsigned integer p into a pair of 16-bit unsigned integers, four 8-bit unsigned integers, or four 8-bit signed integers.
            |Then, each component is converted to a normalized floating-point value to generate the returned two- or four-component vector.
            |
            |The conversion for unpacked fixed-point value `f` to floating point is done as follows:
            |unpackSnorm4x8: `clamp(f / 127.0, -1, +1)`
            |
            |The first component of the returned vector will be extracted from the least significant bits of the input;
            |the last component will be extracted from the most significant bits.""", "unpackSnorm4x8")
        +"""
            fun UInt.unpackSnorm4x8(res: Vec4 = Vec4()): Vec4 {
                val x = (this and 0xFFu).b
                val y = ((this shr 8) and 0xFFu).b
                val z = ((this shr 16) and 0xFFu).b
                val w = (this shr 24).b
        
                res.x = (x.f * 0.0078740157480315f).clamp(-1f, 1f)
                res.y = (y.f * 0.0078740157480315f).clamp(-1f, 1f)
                res.z = (z.f * 0.0078740157480315f).clamp(-1f, 1f)
                res.w = (w.f * 0.0078740157480315f).clamp(-1f, 1f)
        
                return res
            }"""
    }
    if (vecID == "Vec2ui") {
        fun packDouble2x32(v: String = "v") = packing("""
            |Returns a double-qualifier value obtained by packing the components of `$v` into a 64-bit value.
            |If an IEEE 754 `Inf` or `NaN` is created, it will not signal, and the resulting floating point value is unspecified.
            |Otherwise, the bit- level representation of `$v` is preserved.
            |The first vector component specifies the 32 least significant bits;
            |the second component specifies the 32 most significant bits.""", "packDouble2x32")
        when (part) {
            Generator.Part.Class -> {
                packDouble2x32("this")
                +"fun packDouble2x32(): Double = packDouble2x32(this)"
            }
            Generator.Part.CompanionObject -> {
                packDouble2x32()
                +"""
                    fun packDouble2x32(v: Vec2ui): Double {
                        val x = v.x.ul and 0xFFFFFFFFuL
                        val y = v.y.ul shl 32
                        
                        return (x or y).bitsToDouble()
                    }"""
            }
            else -> Unit
        }
    }
    if(ordinal == 0 && type == Type.Double && part == Generator.Part.Scalar) {
        imports += "glm_.vec2.Vec2ui"
        packing("""
            |Returns a two-component unsigned integer vector representation of `this`.
            |The bit-level representation of `this` is preserved.
            |The first component of the vector contains the 32 least significant bits of the double;
            |the second component consists the 32 most significant bits.""", "unpackDouble2x32")
        +"""
            fun Double.unpackDouble2x32(res: Vec2ui = Vec2ui()): Vec2ui {
                val long = this.bitsToLong()
                val x = (long and 0xFFFFFFFF).ui
                val y = (long shr 32).ui
                return res(x, y)
            }"""
    }
    if (vecID == "Vec2") {
        fun packHalf2x16() = packing("""
            |Returns an unsigned integer obtained by converting the components of a two-component floating-point vector
            |to the 16-bit floating-point representation found in the OpenGL Specification, and then packing these two 
            |16- bit integers into a 32-bit unsigned integer.
            |The first vector component specifies the 16 least-significant bits of the result;
            |the second component specifies the 16 most-significant bits.""", "packHalf2x16")
        when (part) {
            Generator.Part.Class -> {
                packHalf2x16()
                +"fun packHalf2x16(): UInt = packHalf2x16(this)"
            }
            Generator.Part.CompanionObject -> {
                packHalf2x16()
                +"""
                    fun packHalf2x16(v: Vec2): UInt {
                        val x = v.x.toFloat16().s
                        val y = v.y.toFloat16().s
                
                        val a = x.ui and 0xFFFFu
                        val b = y.ui shl 16
                
                        return a or b
                    }"""
            }
            else -> Unit
        }
    }
    if (isUInt) {
        imports += "glm_.toFloat32"
        packing("""
            |Returns a two-component floating-point vector with components obtained by unpacking a 32-bit unsigned integer into a pair of 16-bit values,
            |interpreting those values as 16-bit floating-point numbers according to the OpenGL Specification,
            |and converting them to 32-bit floating-point values.
            |The first component of the vector is obtained from the 16 least-significant bits of `v`;
            |the second component is obtained from the 16 most-significant bits of `v`.""", "unpackHalf2x16")
        +"""
            fun UInt.unpackHalf2x16(res: Vec2 = Vec2()): Vec2 {
                val x = (this and 0xFFFFu).s
                val y = (this shr 16).s
                
                return res(x.toFloat32(),
                           y.toFloat32())
            }"""
    }
}