package glm_.generators.vecs

import glm_.generators.*
import glm_.generators.detail.*
import glm_.generators.ext.extVectorRelational
import glm_.generators.gen.Generator
import glm_.generators.gen.Generator.Experimentals
import glm_.generators.gen.generate
import glm_.generators.gen.matrixSize
import java.io.File
import kotlin.math.pow

fun vectors(target: File) {
    for (i in 1..4)
        generate(target, "glm_/vec$i/Vec${i}T.kt", `package` = "glm_.vec$i", ordinal = i) {
            if (i > 1)
                imports += listOf("glm_.extensions.swizzle.*",
                                  "glm_.extensions.*",
                                  "kotlin.jvm.*")
            vectorsT(i)
        }

    for (type in vectorTypes)
        for (i in 1..4)
            generate(target, "glm_/vec$i/Vec$i${type.id}.kt", `package` = "glm_.vec$i", ordinal = i) {
                experimentals += Experimentals.Contracts
                if (type in unsignedTypes)
                    experimentals += Experimentals.UnsignedTypes
                imports += listOf("glm_.*",
                                  "glm_.ext.equal",
                                  "glm_.ext.notEqual",
                                  "glm_.extensions.*",
                                  "glm_.scalar.*",
                                  "kotlin.jvm.*",
                                  "kotlin.math.*")
                repeat(4) { imports += "glm_.vec${it + 1}.*" }
                abcdIndexed(3, 3) { c, r, _ -> imports += "glm_.mat${matrixSize(c + 2, r + 2)}.*" }

                vectors(i, type)
            }
}

private fun Generator.vectorsT(ordinal: Int) {

    "abstract class Vec${ordinal}T<T>" {
        xyzw { +"abstract var $it: T" }
        xyzwIndexed { i, c -> +"operator fun component${i + 1}() = $c" }

        +"// -- Aliases --"

        xyzwIndexed { i, c ->
            "var ${rgba[i]}: T".indented {
                +"get() = $c"
                +"set(value) { $c = value }"
            }
        }
        xyzwIndexed { i, c ->
            "var ${stpq[i]}: T".indented {
                +"get() = $c"
                +"set(value) { $c = value } "
            }
        }

        +"// -- Component accesses --"

        "operator fun get(index: Int): T = when (index)" {
            xyzwIndexed { i, c -> +"$i -> $c" }
            +"else -> throw IndexOutOfBoundsException()"
        }

        "operator fun set(index: Int, value: T) = when(index)" {
            xyzwIndexed { i, c ->
                "$i ->" {
                    +"$c = value"
                }
            }
            +"else -> throw IndexOutOfBoundsException()"
        }

        +"override fun toString() = \"${xyzwJoint { "$$it" }}\""

        "companion object" {
            +"const val length = $ordinal"
        }
    }

    if (ordinal > 1) {
        for (unsigned in (unsignedTypes + "out Number")) {
            +"@Suppress(\"UNCHECKED_CAST\")"
            if (unsigned != "out Number") +"@JvmName(\"dot$unsigned\")"
            "infix fun <N> Vec${ordinal}T<N>.dot(v: Vec${ordinal}T<$unsigned>): N = when (this)" {
                for ((_, _, _, id) in numberTypes) {
                    +"is Vec$ordinal$id -> this.dot(v) as N"
                }
                "is Vec${ordinal}Impl -> when (x)" {
                    for ((type, extension) in numberTypes) {
                        +"is $type -> (${xyzwJoint(separator = " + ") { "($it as $type) * v.$it.$extension" }}).$extension as N"
                    }
                    +"else -> throw IllegalArgumentException(\"Can't compute dot product of non-number vectors!\")"
                }
                +"else -> throw ArithmeticException(\"Can't compute dot product of non-number vectors!\")"
            }
        }
    }
}

private fun Generator.vectors(ordinal: Int, type: Type) {

    val vec = "Vec$ordinal"
    val extension = type.extension
    val id = type.id
    val VecID = vec + id
    "open class $VecID(var array: ${type}Array, var ofs: Int = 0) : ${vec}T<$type>()" {
        xyzwIndexed { i, c ->
            val delta = if (i == 0) "" else " + $i"

            "override var $c: $type".indented {
                +"get() = array[ofs$delta]"
                +"set(value) { array[ofs$delta] = value } "
            }
        }

        +"// Implicit basic constructors"
        +"constructor() : this(${type}Array($ordinal))"
        +"constructor(v: $VecID) : this(${xyzwJoint { "v.$it" }})"

        +"// Explicit basic constructors"
        val arrayOf = "${type.name.toLowerCase()}ArrayOf"
        val xxxx = "x" * ordinal
        +"constructor(x: $type) : this(${if (ordinal == 1) "$arrayOf($xxxx)" else xxxx})"
        +"constructor(x: Number) : this(x.$extension)"
        for (t in listOf(Type.UByte, Type.UShort, Type.UInt, Type.ULong) - type.signedToUnsigned)
            +"constructor(x: $t) : this(x.$extension)"

        val unsExt = if (type == Type.Boolean) "i" else type.signedToUnsigned.extension
        val signedInt = type !in floatingPointTypes && type !in unsignedTypes

        if (ordinal > 1) {
            +"constructor(${xyzwJoint { "$it: $type" }}) : this($arrayOf(${xyzwJoint()}))"
            if (type == Type.UByte || type == Type.UShort) {
                +"constructor(${xyzwJoint { "$it: UInt" }}) : this(${xyzwJoint { "$it.$extension" }})"
                +"constructor(${xyzwJoint { "$it: ULong" }}) : this(${xyzwJoint { "$it.$extension" }})"
            }

            +"// Conversion scalar constructors"
            +"constructor(v: Vec1T<out Number>) : this(v.x.$extension)"
            if (signedInt)
                +"constructor(v: Vec1$unsExt) : this(v.x.$extension)"

            +"// Explicit conversions (From section 5.4.1 Conversion and scalar constructors of GLSL 1.30.08 specification)"
            fun oneTypes(comp: String) = listOf("$comp: Number", "$comp: Vec1T<out Number>")
            fun value(p: String) = if ("Vec" in p) "${p[0]}.x" else p[0]
            var postfix = ".$extension"
            fun constructor(vararg args: String) {
                +"constructor(${args.joinToString()}) : this(${args.joinToString { "${value(it)}$postfix" }})"
                if (signedInt && "Vec" in args) { // avoid signature clashes
                    val argsUns = args.map {
                        when {
                            "Vec" in it -> it.replace("T<out Number>", unsExt)
                            else -> it.replace("Number", (if (type == Type.Boolean) Type.Int else type.signedToUnsigned).toString())
                        }
                    }
                    +"constructor(${argsUns.joinToString()}) : this(${argsUns.joinToString { "${value(it)}$postfix" }})"
                }
                postfix = ""
            }
            for (x in oneTypes("x"))
                for (y in oneTypes("y"))
                    if (ordinal > 2)
                        for (z in oneTypes("z"))
                            if (ordinal > 3)
                                for (w in oneTypes("w"))
                                    constructor(x, y, z, w)
                            else
                                constructor(x, y, z) else
                        constructor(x, y)
        }

        +"// Conversion vector constructors"
        +"// Explicit conversions (From section 5.4.1 Conversion and scalar constructors of GLSL 1.30.08 specification)"

        infix fun String.args(b: String) {
            +"constructor($this) : this($b)"
            if (type !in floatingPointTypes && type !in unsignedTypes) {
                val this2 = replace("T<out Number>", unsExt).replace("Number", (if (type == Type.Boolean) Type.Int else type.signedToUnsigned).toString())
                val b2 = when (type) {
                    Type.Boolean -> b
                    else -> b.replace(",", ".to$type(),") + ".to$type()"
                }
                +"constructor($this2) : this($b2)"
            }
        }

        val V1 = "Vec1T<out Number>"
        val V2 = "Vec2T<out Number>"
        val V3 = "Vec3T<out Number>"
        val V4 = "Vec4T<out Number>"
        val N = "Number"
        when (ordinal) {
            1 -> {
                "v: $V1" args "v.x"
                "v: $V2" args "v.x"
                "v: $V3" args "v.x"
                "v: $V4" args "v.x"
            }
            2 -> {
                "v: $V2" args "v.x, v.y"
                "v: $V3" args "v.x, v.y"
                "v: $V4" args "v.x, v.y"
            }
            3 -> {
                "xy: $V2, z: $N" args "xy.x, xy.y, z"
                "xy: $V2, z: $V1" args "xy.x, xy.y, z.x"
                "x: $N, yz: $V2" args "x, yz.x, yz.y"
                "x: $V1, yz: $V2" args "x.x, yz.x, yz.y"
                "v: $V3" args "v.x, v.y, v.z"
                "v: $V4" args "v.x, v.y, v.z"
            }
            4 -> {
                "xy: $V2, z: $N, w: $N" args "xy.x, xy.y, z, w"
                "xy: $V2, z: $V1, w: $N" args "xy.x, xy.y, z.x, w"
                "xy: $V2, z: $N, w: $V1" args "xy.x, xy.y, z, w.x"
                "xy: $V2, z: $V1, w: $V1" args "xy.x, xy.y, z.x, w.x"
                "x: $N, yz: $V2, w: $N" args "x, yz.x, yz.y, w"
                "x: $V1, yz: $V2, w: $N" args "x.x, yz.x, yz.y, w"
                "x: $N, yz: $V2, w: $V1" args "x, yz.x, yz.y, w.x"
                "x: $V1, yz: $V2, w: $V1" args "x.x, yz.x, yz.y, w.x"
                "x: $N, y: $N, zw: $V2" args "x, y, zw.x, zw.y"
                "x: $V1, y: $N, zw: $V2" args "x.x, y, zw.x, zw.y"
                "x: $N, y: $V1, zw: $V2" args "x, y.x, zw.x, zw.y"
                "x: $V1, y: $V1, zw: $V2" args "x.x, y.x, zw.x, zw.y"
                "xyz: $V3, w: $N" args "xyz.x, xyz.y, xyz.z, w"
                "xyz: $V3, w: $V1" args "xyz.x, xyz.y, xyz.z, w.x"
                "x: $N, yzw: $V3" args "x, yzw.x, yzw.y, yzw.z"
                "x: $V1, yzw: $V3" args "x.x, yzw.x, yzw.y, yzw.z"
                "xy: $V2, zw: $V2" args "xy.x, xy.y, zw.x, zw.y"
                "v: $V4" args "v.x, v.y, v.z, v.w"
            }
        }

        // custom glm, functional programming
        val block = xyzwJointIndexed { i, _ -> "block($i)" }
        +"constructor(block: (i: Int) -> $type) : this($block)"

        if (type in numberTypes) {
            +"// Unary arithmetic operators"
            for ((operatorChar, operatorName) in operators) {
                if (type in intPromotedTypes) {
                    for (scalar in listOf(N, type)) {
                        +"operator fun ${operatorName}Assign(scalar: $scalar) = ${operatorName}Assign(scalar.${if (type in unsignedTypes) "u" else ""}i)"
                    }
                } else {
                    +"operator fun ${operatorName}Assign(scalar: $N) = ${operatorName}Assign(scalar.$extension)"
                    "operator fun ${operatorName}Assign(scalar: $type)" {
                        xyzw {
                            when (type) {
                                in intPromotedTypes -> +"$it = ($it $operatorChar scalar).$extension"
                                else -> +"$it $operatorChar= scalar"
                            }
                        }
                    }
                }
                if (type in intPromotedTypes) {
                    "operator fun ${operatorName}Assign(scalar: ${if (type in unsignedTypes) "UInt" else "Int"})" {
                        xyzw { +"$it = ($it $operatorChar scalar).$extension" }
                    }
                    if (type in unsignedTypes)
                        +"operator fun ${operatorName}Assign(scalar: ULong) = ${operatorName}Assign(scalar.$extension)"
                } else if (type in unsignedTypes)
                    if (type == Type.UInt)
                        +"operator fun ${operatorName}Assign(scalar: ULong) = ${operatorName}Assign(scalar.ui)"
                    else +"operator fun ${operatorName}Assign(scalar: UInt) = ${operatorName}Assign(scalar.ul)"
                "operator fun ${operatorName}Assign(v: $V1)" {
                    xyzw {
                        if (type in intPromotedTypes)
                            +"$it = ($it $operatorChar v.x.$extension).$extension"
                        else +"$it $operatorChar= v.x.$extension"
                    }
                }
                "operator fun ${operatorName}Assign(v: Vec1$id)" {
                    xyzw {
                        if (type in intPromotedTypes)
                            +"$it = ($it $operatorChar v.x).$extension"
                        else +"$it $operatorChar= v.x"
                    }
                }
                if (ordinal > 1) {
                    "operator fun ${operatorName}Assign(v: Vec${ordinal}T<out Number>)" {
                        xyzw {
                            if (type in intPromotedTypes)
                                +"$it = ($it $operatorChar v.$it.$extension).$extension"
                            else +"$it $operatorChar= v.$it.$extension"
                        }
                    }
                    "operator fun ${operatorName}Assign(v: $VecID)" {
                        xyzw {
                            if (type in intPromotedTypes)
                                +"$it = ($it $operatorChar v.$it).$extension"
                            else +"$it $operatorChar= v.$it"
                        }
                    }
                }
            }

            +"// Increment and decrement operators"
            "operator fun inc(): $VecID" {
                xyzw { +"$it++" }
                +"return this"
            }
            "operator fun dec(): $VecID" {
                xyzw { +"$it--" }
                +"return this"
            }
        }

        "operator fun invoke(${xyzwJoint { "$it: $type" }}): $VecID" {
            xyzw { +"this.$it = $it" }
            +"return this"
        }
        if (type in intPromotedTypes) {
            val t = if (type in unsignedTypes) "UInt" else "Int"
            "operator fun invoke(${xyzwJoint { "$it: $t" }}): $VecID" {
                xyzw { +"this.$it = $it.$extension" }
                +"return this"
            }
        }

        "fun put(${xyzwJoint { "$it: $type" }})" {
            xyzw { +"this.$it = $it" }
        }
        if (type in intPromotedTypes) {
            val t = if (type in unsignedTypes) "UInt" else "Int"
            "fun put(${xyzwJoint { "$it: $t" }})" {
                xyzw { +"this.$it = $it.$extension" }
            }
        }

        if (type in numberTypes) {
            +"// Unary bit operators TODO"
            +"// Unary operators"
            +"operator fun unaryPlus(): $VecID = this"
            if (type !in unsignedTypes)
                +"operator fun unaryMinus(): $VecID = $VecID(${xyzwJoint { "-$it" }})"

            binary(ordinal, type, vec, Generator.Part.Class)
        }

        common(ordinal, type, id, vec, Generator.Part.Class)
        exponential(ordinal, type, id, vec, Generator.Part.Class)
        geometric(ordinal, type, id, vec, Generator.Part.Class)
        integer(ordinal, type, id, vec, Generator.Part.Class)
        matrix(ordinal, 0, type, Generator.Part.Class)
        packing(ordinal, type, id, vec, Generator.Part.Class)
        trigonometric(ordinal, type, id, vec, Generator.Part.Class)
        vectorRelational(ordinal, type, vec, Generator.Part.Class)
        // ext
        extVectorRelational(ordinal, type, vec, Generator.Part.Class)

        +"""
            override fun equals(other: Any?) = other is $VecID && ${xyzwJoint(separator = " && ") { "$it == other.$it" }}
            override fun hashCode() = ${xyzwJointIndexed(separator = " + ") { i, c -> "${31f.pow(i).toInt()} * $c.hashCode()" }}
            fun all(predicate: ($type) -> Boolean): Boolean {
                for (i in 0 until length)
                    if(!predicate(this[i]))
                        return false
                return true
            }
            fun any(predicate: ($type) -> Boolean): Boolean {
                for (i in 0 until length)
                    if(predicate(this[i]))
                        return true
                return false
            }"""

        if (type == Type.Boolean) {
            +"// Boolean operators"
            val v = "$vec$extension"
            +"infix fun and(v: $v) = $v(${xyzwJoint { "$it && v.$it" }})"
            +"infix fun or(v: $v) = $v(${xyzwJoint { "$it || v.$it" }})"
        }

        "companion object" {
            +"const val length = Vec${ordinal}T.length"
            if (type in numberTypes) {
                +"const val size: Int = length * $type.SIZE_BYTES"

                binary(ordinal, type, vec, Generator.Part.CompanionObject)
                common(ordinal, type, id, vec, Generator.Part.CompanionObject)
                exponential(ordinal, type, id, vec, Generator.Part.CompanionObject)
                geometric(ordinal, type, id, vec, Generator.Part.CompanionObject)
                integer(ordinal, type, id, vec, Generator.Part.CompanionObject)
                matrix(ordinal, 0, type, Generator.Part.CompanionObject)
                packing(ordinal, type, id, vec, Generator.Part.CompanionObject)
                trigonometric(ordinal, type, id, vec, Generator.Part.CompanionObject)
            }
            vectorRelational(ordinal, type, vec, Generator.Part.CompanionObject)

            // ext
            extVectorRelational(ordinal, type, vec, Generator.Part.CompanionObject)
        }
    }

    binary(ordinal, type, vec, Generator.Part.Scalar)
}