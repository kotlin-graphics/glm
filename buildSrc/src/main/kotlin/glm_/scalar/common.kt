package glm_.scalar

import glm_.*
import java.io.File

fun common(target: File) {

    generate(target, "glm_/scalar/common.kt") {

        +"@file:OptIn(kotlin.contracts.ExperimentalContracts::class)"
        +"package glm_.scalar"
        //            +"import glm_.extensions.swizzle.*"
        +"import glm_.extensions.*"
        +"import kotlin.reflect.KMutableProperty0"
        //                    +"import kotlin.jvm.*"
        +"import kotlin.math.*"
        +"import kotlin.math.pow"

        for ((type, extension, _, _) in vectorTypes) {

            if (type in numberTypes && type !in unsignedTypes) {

                // abs
                docs("""|Returns x if x >= 0; otherwise, it returns -x.
                        |
                        |[GLSL abs man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/abs.xml)
                        |[GLSL 4.20.8 specification, section 8.3 Common Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)""")
                // TODO this should be JVM only
                val maybeToInt = if (type in intPromotedTypes) "toInt()" else "this"
                val maybeBack = if (type in intPromotedTypes) ".to$type()" else ""
                +"inline fun $type.abs(): $type = abs($maybeToInt)$maybeBack"

                // sign in stdlib

                if (type in floatingPointTypes) {

                    // floor
                    docs("""|Returns a value equal to the nearest integer that is less then or equal to x.
                            |
                            |[GLSL floor man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/floor.xml)
                            |[GLSL 4.20.8 specification, section 8.3 Common Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)""")
                    +"inline fun $type.floor(): $type = floor(this)"

                    // trunc
                    docs("""|Returns a value equal to the nearest integer to x whose absolute value is not larger than the absolute value of x.
                            |
                            |[GLSL trunc man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/trunc.xml)
                            |[GLSL 4.20.8 specification, section 8.3 Common Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)""")
                    +"inline fun $type.trunc(): $type = truncate(this)"

                    // round
                    docs("""|Returns a value equal to the nearest integer to x.
                            |The fraction 0.5 will round in a direction chosen by the implementation, presumably the direction that is fastest.
                            |This includes the possibility that round(x) returns the same value as roundEven(x) for all values of x.
                            |
                            |[GLSL round man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/round.xml)
                            |[GLSL 4.20.8 specification, section 8.3 Common Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)""")
                    +"inline fun $type.round(): $type = roundTo${type.counterpart}().$extension"

                    // round even
                    docs("""|Returns a value equal to the nearest integer to x.
                            |A fractional part of 0.5 will round toward the nearest even integer. (Both 3.5 and 4.5 for x will return 4.0.)
                            |
                            |[GLSL roundEven man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/roundEven.xml)
                            |[GLSL 4.20.8 specification, section 8.3 Common Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)
                            |[New round to even technique](http://developer.amd.com/documentation/articles/pages/New-Round-to-Even-Technique.aspx)""")
                    +"inline fun $type.roundEven(): $type = round(this)"

                    // ceil
                    docs("""|Returns a value equal to the nearest integer that is greater than or equal to x.
                            |
                            |[GLSL ceil man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/ceil.xml)
                            |[GLSL 4.20.8 specification, section 8.3 Common Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)""")
                    +"inline fun $type.ceil(): $type = ceil(this)"

                    // fract
                    docs("""|Return x - floor(x).
                            |
                            |[GLSL fract man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/fract.xml)
                            |[GLSL 4.20.8 specification, section 8.3 Common Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)""")
                    +"inline fun $type.fract(): $type = 1f - floor()"

                    // mod in stdlib

                    // modf
                    val doc = """|Returns the fractional part of x and sets i to the integer part (as a whole number floating point value). 
                                 |Both the return value and the output parameter will have the same sign as x.
                                 |
                                 |[GLSL modf man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/modf.xml)
                                 |[GLSL 4.20.8 specification, section 8.3 Common Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)"""
                    docs(doc)
                    "inline fun $type.modf(resI: KMutableProperty0<$type>): $type" {
                        contract("resI")
                        +"val int = if (this > ${type.`0`}) floor() else ceil()"
                        +"resI.set(int)"
                        +"return this - int"
                    }
                    docs(doc)
                    "inline fun $type.modf(resI: ($type) -> Unit): $type" {
                        contract("resI")
                        +"val int = if (this > ${type.`0`}) floor() else ceil()"
                        +"resI(int)"
                        +"return this - int"
                    }
                    docs(doc)
                    "fun $type.modf(): Pair<$type, $type>" {
                        +"val int = if (this > ${type.`0`}) floor() else ceil()"
                        +"return (this - int) to int"
                    }
                }
            }
            if (type in numberTypes) {
                // min
                docs("""|Returns y if y < x; otherwise, it returns x.
                        |
                        |[GLSL min man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/min.xml)
                        |[GLSL 4.20.8 specification, section 8.3 Common Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)""")
                +"inline infix fun $type.min(b: $type): $type = min(${type.promotedExtensionOrThis}, b${type.promotedExtensionOrEmpty})${type.maybePromotedBack}"

                // max
                docs("""|Returns y if x < y; otherwise, it returns x.
                        |
                        |[GLSL max man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/max.xml)
                        |[GLSL 4.20.8 specification, section 8.3 Common Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)""")
                +"inline infix fun $type.max(b: $type): $type = max(${type.promotedExtensionOrThis}, b${type.promotedExtensionOrEmpty})${type.maybePromotedBack}"

                // clamp
                val doc = """|Returns min(max(x, minVal), maxVal) for each component in x using the floating-point values minVal and maxVal.
                             |
                             |[GLSL clamp man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/clamp.xml)
                             |[GLSL 4.20.8 specification, section 8.3 Common Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)"""
                docs(doc)
                +"inline fun $type.clamp(min: $type, max: $type): $type = max(min) min max"
                if (type == "Int" || type == "Long") {
                    docs(doc)
                    +"inline infix fun $type.clamp(range: ${type}Range): $type = max(range.first) min range.last"
                }
            }
            if (type in floatingPointTypes) {
                // mix
                var doc = """|If genTypeU is a floating scalar or vector: Returns x * (1.0 - a) + y * a, i.e., the linear blend of
                             |x and y using the floating-point value a.
                             |The value for a is not restricted to the range [0, 1].
                             |If genTypeU is a boolean scalar or vector: Selects which vector each returned component comes from. 
                             |For a component of 'a' that is false, the corresponding component of 'x' is returned. For a
                             |component of 'a' that is true, the corresponding component of 'y' is returned. Components of 'x' and 'y' that
                             |are not selected are allowed to be invalid floating point values and will have no effect on the results. 
                             |Thus, this provides different functionality than genType mix(genType x, genType y, genType(a)) where a is a Boolean vector.
                             |
                             |[GLSL mix man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/mix.xml)
                             |[GLSL 4.20.8 specification, section 8.3 Common Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)"""
                docs(doc)
                +"inline fun $type.mix(y: $type, a: $type): $type = this * (1 - a) + y * a"
                docs(doc)
                val otherFloat = if (type == "Float") "Double" else "Float"
                +"inline fun $type.mix(y: $type, a: $otherFloat): $type = mix(y, a.$extension)"
                docs(doc)
                +"inline fun $type.mix(y: $type, a: Boolean): $type = if (a) y else this"

                // step
                docs("""|Returns 0.0 if x < edge, otherwise it returns 1.0.
                        |
                        |[GLSL step man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/step.xml)
                        |[GLSL 4.20.8 specification, section 8.3 Common Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)""")
                +"inline infix fun $type.step(edge: $type): $type = if (this < edge) ${type.`0`} else ${type.`1`}"

                // smoothstep
                docs("""|Returns 0.0 if x <= edge0 and 1.0 if x >= edge1 and performs smooth Hermite interpolation between 0 and 1
                        |when edge0 < x < edge1. This is useful in cases where you would want a threshold function with a smooth
                        |transition. This is equivalent to:
                        |genType t;
                        |t = clamp ((x - edge0) / (edge1 - edge0), 0, 1);
                        |return t * t * (3 - 2 * t);
                        |Results are undefined if edge0 >= edge1.
                        |
                        |[GLSL smoothstep man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/smoothstep.xml)
                        |[GLSL 4.20.8 specification, section 8.3 Common Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)""")
                "inline fun $type.smoothstep(edge0: $type, edge1: $type): $type" {
                    +"val tmp = (this - edge0) / (edge1 - edge0)"
                    +"val clamp = tmp.clamp(${type.`0`}, ${type.`1`})"
                    +"return clamp * clamp * (${type.`3`} - ${type.`2`} * clamp)"
                }

                // bitsToInt
                val integer = type.counterpart
                docs("""|Returns a signed integer value representing the encoding of a floating-point value. 
                        |The floating-point value's bit-level representation is preserved.
                        |
                        |[GLSL floatBitsToInt man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/floatBitsToInt.xml)
                        |[GLSL 4.20.8 specification, section 8.3 Common Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)""")
                +"inline fun $type.bitsTo$integer(): $integer = toBits()"

                // bitsToUInt
                docs("""|Returns a unsigned integer value representing the encoding of a floating-point value. 
                        |The floatingpoint value's bit-level representation is preserved.
                        |
                        |[GLSL floatBitsToUint man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/floatBitsToUint.xml)
                        |[GLSL 4.20.8 specification, section 8.3 Common Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)""")
                +"inline fun $type.bitsToU$integer(): U$integer = toBits().u${integer[0].toLowerCase()}"
            }
            if ("Int" in type || "Long" in type) { // unsigneds as well
                // bitsToFloat
                val t = if (type[0] == 'U') type.drop(1) else type
                val counter = t.counterpart
                val bits = when (type) {
                    "UInt" -> "i"
                    "ULong" -> "L"
                    else -> "this"
                }
                docs("""|Returns a floating-point value corresponding to a signed integer encoding of a floating-point value.
                        |If an inf or NaN is passed in, it will not signal, and the resulting floating point value is unspecified. 
                        |Otherwise, the bit-level representation is preserved.
                        |
                        |[GLSL intBitsToFloat man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/intBitsToFloat.xml)
                        |[GLSL 4.20.8 specification, section 8.3 Common Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)""")
                +"inline fun $type.bitsTo$counter(): $counter = $counter.fromBits($bits)"
            }
            if (type in floatingPointTypes) {
                // frexp
                val doc = """|Splits x into a floating-point significand in the range [0.5, 1.0) and an integral exponent of two, such that:
                             |`x = significand * exp(2, exponent)`
                             |
                             |The significand is returned by the function and the exponent is returned in the parameter exp. 
                             |For a floating-point value of zero, the significant and exponent are both zero. 
                             |For a floating-point value that is an infinity or is not a number, the results are undefined.
                             |
                             |[GLSL frexp man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/frexp.xml)
                             |[GLSL 4.20.8 specification, section 8.3 Common Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)"""
                docs(doc)
                val x = if (type == "Float") 23 else 52
                "fun $type.frexp(resExp: KMutableProperty0<Int>): $type" {
                    builder.appendLine("""
                        val bits = toBits()
                        var realMant: $type
    
                        // Test for NaN, infinity, and zero.
                        return when {
                            isNaN() || this + this == this || isInfinite() -> {
                                resExp.set(0)
                                this
                            } 
                            else -> {
                                val neg = bits < 0
                                ${
                        when (type) {
                            "Float" -> "var exponent = (bits ushr $x) and 0xff"
                            else -> "var exponent = ((bits ushr $x) and 0x7ffL).i"
                        }
                    }
                                ${
                        when (type) {
                            "Float" -> "var mantissa = bits and 0xffffff"
                            else -> "var mantissa = bits and 0xfffffffffffffL"
                        }
                    }
                                if (exponent == 0)
                                    exponent++
                                else
                                    mantissa = mantissa or (1${if (type == "Float") "" else "L"} shl $x)
        
                                // bias the exponent - actually biased by ${if (type == "Float") "127" else "1023"}.
                                // we are treating the mantissa as m.0 instead of 0.m
                                // so subtract another $x.
                                exponent -= ${if (type == "Float") "150" else "1075"}
                                realMant = mantissa.${extension}
        
                                // normalize
                                while (realMant > ${type.`1`}) {
                                    mantissa = mantissa shr 1
                                    realMant /= ${type.`2`}
                                    exponent++
                                }
                                if (neg)
                                    realMant *= -1
                                    
                                resExp.set(exponent)
                                realMant
                            }
                        }
                    """.trimIndent().prependIndent("\t"))
                }
                docs(doc)
                "fun $type.frexp(resExp: (Int) -> Unit): $type" {
                    contract("resExp")
                    builder.appendLine("""
                        val bits = toBits()
                        var realMant: $type
    
                        // Test for NaN, infinity, and zero.
                        return when {
                            isNaN() || this + this == this || isInfinite() -> {
                                resExp(0)
                                this
                            } 
                            else -> {
                                val neg = bits < 0
                                ${
                        when (type) {
                            "Float" -> "var exponent = (bits ushr $x) and 0xff"
                            else -> "var exponent = ((bits ushr $x) and 0x7ffL).i"
                        }
                    }
                                ${
                        when (type) {
                            "Float" -> "var mantissa = bits and 0xffffff"
                            else -> "var mantissa = bits and 0xfffffffffffffL"
                        }
                    }
                                if (exponent == 0)
                                    exponent++
                                else
                                    mantissa = mantissa or (1${if (type == "Float") "" else "L"} shl $x)
        
                                // bias the exponent - actually biased by ${if (type == "Float") "127" else "1023"}.
                                // we are treating the mantissa as m.0 instead of 0.m
                                // so subtract another $x.
                                exponent -= ${if (type == "Float") "150" else "1075"}
                                realMant = mantissa.${extension}
        
                                // normalize
                                while (realMant > ${type.`1`}) {
                                    mantissa = mantissa shr 1
                                    realMant /= ${type.`2`}
                                    exponent++
                                }
                                if (neg)
                                    realMant *= -1
                                    
                                resExp(exponent)
                                realMant
                            }
                        }
                    """.trimIndent().prependIndent("\t"))
                }
                docs(doc)
                "fun $type.frexp(): Pair<$type, Int>" {
                    builder.appendLine("""
                        val bits = toBits()
                        var realMant: $type
    
                        // Test for NaN, infinity, and zero.
                        return when {
                            isNaN() || this + this == this || isInfinite() -> this to 0
                            else -> {
                                val neg = bits < 0
                                ${
                        when (type) {
                            "Float" -> "var exponent = (bits ushr $x) and 0xff"
                            else -> "var exponent = ((bits ushr $x) and 0x7ffL).i"
                        }
                    }
                                ${
                        when (type) {
                            "Float" -> "var mantissa = bits and 0xffffff"
                            else -> "var mantissa = bits and 0xfffffffffffffL"
                        }
                    }
                                if (exponent == 0)
                                    exponent++
                                else
                                    mantissa = mantissa or (1${if (type == "Float") "" else "L"} shl $x)
        
                                // bias the exponent - actually biased by ${if (type == "Float") "127" else "1023"}.
                                // we are treating the mantissa as m.0 instead of 0.m
                                // so subtract another $x.
                                exponent -= ${if (type == "Float") "150" else "1075"}
                                realMant = mantissa.${extension}
        
                                // normalize
                                while (realMant > ${type.`1`}) {
                                    mantissa = mantissa shr 1
                                    realMant /= ${type.`2`}
                                    exponent++
                                }
                                if (neg)
                                    realMant *= -1
                                    
                                realMant to exponent
                            }
                        }
                    """.trimIndent().prependIndent("\t"))
                }

                // TODO fill other docs as well?
                // fma
                docs("""|Computes and returns a * b + c.
                        |
                        |[GLSL fma man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/fma.xml)
                        |[GLSL 4.20.8 specification, section 8.3 Common Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)""")
                +"inline fun $type.fma(b: $type, c: $type): $type = this * b + c"

                // ldexp
                docs("""|Builds a floating-point number from x and the corresponding integral exponent of two in exp, returning:
                        |`significand * exp(2, exponent)`
                        |
                        |If this product is too large to be represented in the floating-point type, the result is undefined.
                        |
                        |[GLSL ldexp man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/ldexp.xml)
                        |[GLSL 4.20.8 specification, section 8.3 Common Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)""")
                +"inline infix fun $type.ldexp(exp: Int) = this * ${type.`2`}.pow(exp)"
            }
        }
    }
}
