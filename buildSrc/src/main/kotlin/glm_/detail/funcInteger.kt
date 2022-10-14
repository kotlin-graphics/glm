package glm_.detail

import glm_.*
import glm_.gen.Generator

// common.hpp
fun Generator.integer(ordinal: Int, type: String, extension: String, id: String, vec: String, part: Generator.Part) {

    if (part != Generator.Part.Scalar) +"// integer\n"

    val VecID = vec + id
    val xyzw = xyzwJoint
    val XYZW = XyzwJoint2
    val `aXYZW type` = XyzwJoint { "a$it: $type" }
    val `a,xyzw` = xyzwJoint { "a.$it" }
    //    val `a,xyzw type` = xyzwJoint { "a.$it: $type" }
    val `bXYZW` = XyzwJoint { "b$it" }
    val `bXYZW type` = XyzwJoint { "b$it: $type" }
    val `b,xyzw` = xyzwJoint { "b.$it" }
    val `c,xyzw` = xyzwJoint { "c.$it" }
    val `cXYZW type` = XyzwJoint { "c$it: $type" }
    val `cXYZW bool` = XyzwJoint { "c$it: Boolean" }
    val resXYZW = XyzwJoint { "res$it" }
    val `resXYZW type` = XyzwJoint { "res$it: $type" }
    val `resXYZW Int` = XyzwJoint { "res$it: Int" }
    val `xyzw type` = xyzwJoint { "$it: $type" }
    val `v,xyzw` = xyzwJoint { "v.$it" }
    val `vXYZW type` = XyzwJoint { "v$it: $type" }
    val `baseXYZW type` = XyzwJoint { "base$it: $type" }
    val baseXYZW = XyzwJoint { "base$it" }
    val `insertXYZW type` = XyzwJoint { "insert$it: $type" }
    val insertXYZW = XyzwJoint { "insert$it" }
    val `v0,xyzw` = xyzwJoint { "v0.$it" }
    val `v1,xyzw` = xyzwJoint { "v1.$it" }
    val bbbb = xyzwJoint { "b" }
    val minValJoint = xyzwJoint { "minVal" }
    val maxValJoint = xyzwJoint { "maxVal" }
    val `minVal,xyzw` = xyzwJoint { "minVal.$it" }
    val `maxVal,xyzw` = xyzwJoint { "maxVal.$it" }
    val `minValXYZW type` = XyzwJoint { "minVal$it: $type" }
    val `maxValXYZW type` = XyzwJoint { "maxVal$it: $type" }
    val otherFloatType = if (type == "Float") "Double" else "Float"
    val otherFloatVecID = if (type == "Float") "${vec}d" else vec
    val edgeJoint = XyzwJoint { "edge" }
    val edge0Joint = XyzwJoint { "edge0" }
    val edge1Joint = XyzwJoint { "edge1" }
    val edgeXYZW = XyzwJoint { "edge$it: $type" }
    val `edge,xyzw` = xyzwJoint { "edge.$it" }
    val `edge0,xyzw` = xyzwJoint { "edge0.$it" }
    val `edge1,xyzw` = xyzwJoint { "edge1.$it" }
    val `resCarryXYZW type` = XyzwJoint { "resCarry$it: $type" }
    val resCarryXYZW = XyzwJoint { "resCarry$it" }
    val `resBorrowXYZW type` = XyzwJoint { "resBorrow$it: $type" }
    val resBorrowXYZW = XyzwJoint { "resBorrow$it" }
    val `resMsbXYZW type` = XyzwJoint { "resMsb$it: $type" }
    val resMsbXYZW = XyzwJoint { "resMsb$it" }
    val `resLsbXYZW type` = XyzwJoint { "resLsb$it: $type" }
    val resLsbXYZW = XyzwJoint { "resLsb$it" }
    val `edge1XYZW type` = XyzwJoint { "edge1$it: $type" }
    val `expXYZW Int` = XyzwJoint { "exp$it: Int" }

    if (type == "UInt") {
        fun uaddCarry(x: String = "this", y: String = "b") = ("""
            |Adds 32-bit unsigned integer `$x` and `$y`, returning the `sum modulo pow(2, 32)`. 
            |The value carry is set to `0` if the sum was less than `pow(2, 32)`, or to `1` otherwise.
            |
            |@see <a href="http://www.opengl.org/sdk/docs/manglsl/xhtml/uaddCarry.xml">GLSL uaddCarry man page</a>
            |@see <a href="http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf">GLSL 4.20.8 specification, section 8.8 Integer Functions</a>""")
        when (part) {
            Generator.Part.Class -> {
                uaddCarry()
                +"fun uaddCarryAssign(b: $VecID, resCarry: $VecID): $VecID = uaddCarry(this, b, resCarry, this)"
                uaddCarry(y = "b[$XYZW]")
                +"""
                    inline fun <R> uaddCarryAssign($`bXYZW type`, resCarry: ($`resCarryXYZW type`) -> R): R {
                        ${contract("resCarry")}
                        return uaddCarry($xyzw, $bXYZW) { $`resXYZW type`, $`resCarryXYZW type` -> 
                            this($resXYZW)
                            resCarry($resCarryXYZW)
                        }
                    }"""
                uaddCarry()
                +"fun uaddCarry(b: $VecID, resCarry: $VecID, res: $VecID = $VecID()): $VecID = uaddCarry(this, b, resCarry, res)"
                uaddCarry(y = "b[$XYZW]")
                +"""
                    fun uaddCarry($`bXYZW type`, resCarry: $VecID, res: $VecID = $VecID()): $VecID = uaddCarry($xyzw, $bXYZW) { $`resXYZW type`, $`resCarryXYZW type` ->
                        resCarry.put($resCarryXYZW)
                        res($resXYZW)
                    }"""
            }
            Generator.Part.CompanionObject -> {
                uaddCarry("a[$XYZW]", "b[$XYZW]")
                "inline fun <R> uaddCarry($`aXYZW type`, $`bXYZW type`,\nres: ($`resXYZW type`, $`resCarryXYZW type`) -> R): R" {
                    Xyzw { +"val carry$it: UInt; val res$it = a$it.uaddCarry(b$it) { carry$it = it }" }
                    +"return res(${XyzwJoint { "res$it" }}, ${XyzwJoint { "carry$it" }})"
                }
                uaddCarry("a")
                "fun uaddCarry(a: $VecID, b: $VecID, resCarry: $VecID, res: $VecID = $VecID()): $VecID" {
                    xyzw { +"res.$it = a.$it.uaddCarry(b.$it) { resCarry.$it = it }" }
                    +"return res"
                }
            }
            Generator.Part.Scalar -> {
                uaddCarry()
                +"""
                    fun UInt.uaddCarry(b: UInt, resCarry: KMutableProperty0<UInt>): UInt {
                        val value64 = this.toULong() + b.toULong()
                        val max32 = (1uL shl 32) - 1uL
                        resCarry.set(if (value64 > max32) 1u else 0u)
                        return (value64 % (max32 + 1uL)).toUInt()
                    }"""
                uaddCarry()
                +"""
                    inline fun UInt.uaddCarry(b: UInt, resCarry: (UInt) -> Unit): UInt {
                        ${contract("resCarry")}
                        val value64 = this.toULong() + b.toULong()
                        val max32 = (1uL shl 32) - 1uL
                        resCarry(if (value64 > max32) 1u else 0u)
                        return (value64 % (max32 + 1uL)).toUInt()
                    }"""
                uaddCarry()
                +"""
                    infix fun UInt.uaddCarry(b: UInt): Pair<UInt, UInt> {
                        val value64 = this.toULong() + b.toULong()
                        val max32 = (1uL shl 32) - 1uL
                        return (value64 % (max32 + 1uL)).toUInt() to if (value64 > max32) 1u else 0u
                    }"""
            }
        }
        fun usubBorrow(x: String = "this", y: String = "b") = docs("""
            |Subtracts the 32-bit unsigned integer `$y` from `$x`, returning the difference if non-negative, 
            |or pow(2, 32) plus the difference otherwise. The value borrow is set to `0` if `$x >= $y`, or to `1` otherwise.
            |
            |@see <a href="http://www.opengl.org/sdk/docs/manglsl/xhtml/usubBorrow.xml">GLSL usubBorrow man page</a>
            |@see <a href="http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf">GLSL 4.20.8 specification, section 8.8 Integer Functions</a>""")
        when (part) {
            Generator.Part.Class -> {
                usubBorrow()
                +"fun usubBorrowAssign(b: $VecID, resBorrow: $VecID): $VecID = usubBorrow(this, b, resBorrow, this)"
                usubBorrow(y = "b[$XYZW]")
                +"""
                    inline fun <R> usubBorrowAssign($`bXYZW type`, resBorrow: ($`resBorrowXYZW type`) -> R): R {
                        ${contract("resBorrow")}
                        return usubBorrow($xyzw, $bXYZW) { $`resXYZW type`, $`resBorrowXYZW type` ->
                            this($resXYZW)
                            resBorrow($resBorrowXYZW)
                        }
                    }"""
                usubBorrow()
                +"fun usubBorrow(b: $VecID, resBorrow: $VecID, res: $VecID = $VecID()): $VecID = usubBorrow(this, b, resBorrow, res)"
                usubBorrow(y = "b[$XYZW]")
                +"""
                    fun usubBorrow($`bXYZW type`, resBorrow: $VecID, res: $VecID = $VecID()): $VecID = usubBorrow($xyzw, $bXYZW) { $`resXYZW type`, $`resBorrowXYZW type` -> 
                        resBorrow.put($resBorrowXYZW)
                        res($resXYZW)
                    }"""
            }
            Generator.Part.CompanionObject -> {
                usubBorrow("a[$XYZW]", "b[$XYZW]")
                "inline fun <R> usubBorrow($`aXYZW type`, $`bXYZW type`,\nres: ($`resXYZW type`, $`resBorrowXYZW type`) -> R): R" {
                    Xyzw { +"val borrow$it: UInt; val res$it = a$it.usubBorrow(b$it) { borrow$it = it }" }
                    +"return res(${XyzwJoint { "res$it" }}, ${XyzwJoint { "borrow$it" }})"
                }
                usubBorrow("a")
                "fun usubBorrow(a: $VecID, b: $VecID, resBorrow: $VecID, res: $VecID = $VecID()): $VecID" {
                    xyzw { +"res.$it = a.$it.usubBorrow(b.$it) { resBorrow.$it = it }" }
                    +"return res"
                }
            }
            Generator.Part.Scalar -> {
                usubBorrow()
                +"""
                    fun UInt.usubBorrow(b: UInt, resBorrow: KMutableProperty0<UInt>): UInt {
                        resBorrow.set(if (this >= b) 0u else 1u)
                        return when {
                            b >= this -> b - this
                            else -> ((1uL shl 32) + (b.toULong() - this.toULong())).toUInt()
                        }
                    }"""
                usubBorrow()
                +"""
                    inline fun UInt.usubBorrow(b: UInt, resBorrow: (UInt) -> Unit): UInt {
                        ${contract("resBorrow")}
                        resBorrow(if (this >= b) 0u else 1u)
                        return when {
                            b >= this -> b - this
                            else -> ((1uL shl 32) + (b.toULong() - this.toULong())).toUInt()
                        }
                    }"""
                usubBorrow()
                +"""
                    infix fun UInt.usubBorrow(b: UInt): Pair<UInt, UInt> =
                        when {
                            b >= this -> b - this
                            else -> ((1uL shl 32) + (b.toULong() - this.toULong())).toUInt()
                        } to if (this >= b) 0u else 1u"""
            }
        }

        fun umulExtended(x: String = "this", y: String = "b") = docs("""
            |Multiplies 32-bit integers `$x` and `$y`, producing a 64-bit result. 
            |The 32 least-significant bits are returned in lsb.
            |The 32 most-significant bits are returned in msb.
            |
            |@see <a href="http://www.opengl.org/sdk/docs/manglsl/xhtml/umulExtended.xml">GLSL umulExtended man page</a>
            |@see <a href="http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf">GLSL 4.20.8 specification, section 8.8 Integer Functions</a>""")
        when (part) {
            Generator.Part.Class -> {
                umulExtended()
                +"fun umulExtended(b: $VecID, resMsb: $VecID, resLsb: $VecID) = umulExtended(this, b, resMsb, resLsb)"
                umulExtended(y = "b[$XYZW]")
                +"""
                    fun umulExtended($`bXYZW type`, resMsb: $VecID, resLsb: $VecID) = umulExtended($xyzw, $bXYZW) { $`resMsbXYZW type`, $`resLsbXYZW type` ->
                        resMsb($resMsbXYZW)
                        resLsb($resLsbXYZW)
                    }"""
            }
            Generator.Part.CompanionObject -> {
                umulExtended("a[$XYZW]", "b[$XYZW]")
                "inline fun <R> umulExtended($`aXYZW type`, $`bXYZW type`,\nres: ($`resMsbXYZW type`, $`resLsbXYZW type`) -> R): R" {
                    +contract
                    Xyzw { +"val msb$it: UInt; val lsb$it: UInt; a$it.umulExtended(b$it) { msb, lsb -> msb$it = msb; lsb$it = lsb }" }
                    +"return res(${XyzwJoint { "msb$it" }}, ${XyzwJoint { "lsb$it" }})"
                }
                umulExtended("a")
                "fun umulExtended(a: $VecID, b: $VecID, resMsb: $VecID, resLsb: $VecID)" {
                    xyzw { +"a.$it.umulExtended(b.$it) { msb, lsb -> resMsb.$it = msb; resLsb.$it = lsb }" }
                }
            }
            Generator.Part.Scalar -> {
                umulExtended()
                +"""
                    fun UInt.umulExtended(b: UInt, resMsb: KMutableProperty0<UInt>, resLsb: KMutableProperty0<UInt>) {
                        val value64 = this.toULong() * b.toULong()
                        resMsb.set((value64 shr 32).toUInt())
                        resLsb.set(value64.toUInt())
                    }"""
                umulExtended()
                +"""
                    inline fun UInt.umulExtended(b: UInt, res: (msb: UInt, lsb: UInt) -> Unit) {
                        ${contract("res")}
                        val value64 = this.toULong() * b.toULong()
                        res((value64 shr 32).toUInt(), value64.toUInt())
                    }"""
                umulExtended()
                +"""
                    infix fun UInt.umulExtended(b: UInt): Pair<UInt, UInt> {
                        val value64 = this.toULong() * b.toULong()
                        return (value64 shr 32).toUInt() to value64.toUInt()
                    }"""
            }
        }
    }
    if (type == "Int") {
        fun imulExtended(x: String = "this", y: String = "b") = docs("""
                 |Multiplies 32-bit integers `$x` and `$y`, producing a 64-bit result. 
                 |The 32 least-significant bits are returned in lsb.
                 |The 32 most-significant bits are returned in msb.
                 |
                 |@see <a href="http://www.opengl.org/sdk/docs/manglsl/xhtml/imulExtended.xml">GLSL imulExtended man page</a>
                 |@see <a href="http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf">GLSL 4.20.8 specification, section 8.8 Integer Functions</a>""")
        when (part) {
            Generator.Part.Class -> {
                imulExtended()
                +"fun imulExtended(b: $VecID, resMsb: $VecID, resLsb: $VecID) = imulExtended(this, b, resMsb, resLsb)"
                imulExtended(y = "b[$XYZW]")
                +"""
                    fun imulExtended($`bXYZW type`, resMsb: $VecID, resLsb: $VecID) = imulExtended($xyzw, $bXYZW) { $`resMsbXYZW type`, $`resLsbXYZW type` ->
                        resMsb($resMsbXYZW)
                        resLsb($resLsbXYZW)
                    }"""
            }
            Generator.Part.CompanionObject -> {
                imulExtended("a[$XYZW]", "b[$XYZW]")
                "inline fun <R> imulExtended($`aXYZW type`, $`bXYZW type`,\nres: ($`resMsbXYZW type`, $`resLsbXYZW type`) -> R): R" {
                    +contract
                    Xyzw { +"val msb$it: Int; val lsb$it: Int; a$it.imulExtended(b$it) { msb, lsb -> msb$it = msb; lsb$it = lsb }" }
                    +"return res(${XyzwJoint { "msb$it" }}, ${XyzwJoint { "lsb$it" }})"
                }
                imulExtended("a")
                "fun imulExtended(a: $VecID, b: $VecID, resMsb: $VecID, resLsb: $VecID)" {
                    xyzw { +"a.$it.imulExtended(b.$it) { msb, lsb -> resMsb.$it = msb; resLsb.$it = lsb }" }
                }
            }
            Generator.Part.Scalar -> {
                imulExtended()
                +"""
                    fun Int.imulExtended(b: Int, resMsb: KMutableProperty0<Int>, resLsb: KMutableProperty0<Int>) {
                        val value64 = this.toLong() * b.toLong()
                        resMsb.set((value64 shr 32).toInt())
                        resLsb.set(value64.toInt())
                    }"""
                imulExtended()
                +"""
                    inline fun Int.imulExtended(b: Int, res: (msb: Int, lsb: Int) -> Unit) {
                        ${contract("res")}
                        val value64 = this.toLong() * b.toLong()
                        res((value64 shr 32).toInt(), value64.toInt())
                    }"""
                imulExtended()
                +"""
                    infix fun Int.imulExtended(b: Int): Pair<Int, Int> {
                        val value64 = this.toLong() * b.toLong()
                        return (value64 shr 32).toInt() to value64.toInt()
                    }"""
            }
        }
    }
    if ("Int" !in type && "Long" !in type)
        return

    fun bitfieldExtract() = docs("""
        |Extracts bits `[offset, offset + bits - 1]` from value, returning them in the least significant bits of the result.
        |For unsigned data types, the most significant bits of the result will be set to zero. For signed data types, 
        |the most significant bits will be set to the value of bit `offset + base - 1`.
        |
        |If `bits` is zero, the result will be zero. The result will be undefined if `offset` or `bits` is negative, 
        |or if the sum of `offset` and `bits` is greater than the number of bits used to store the operand.
        |
        |@see <a href="http://www.opengl.org/sdk/docs/manglsl/xhtml/bitfieldExtract.xml">GLSL bitfieldExtract man page</a>
        |@see <a href="http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf">GLSL 4.20.8 specification, section 8.8 Integer Functions</a>""")
    when (part) {
        Generator.Part.Class -> {
            bitfieldExtract()
            +"fun bitfieldExtractAssign(offset: Int, bits: $type): $VecID = bitfieldExtract(this, offset, bits, this)"

            bitfieldExtract()
            +"fun bitfieldExtract(offset: Int, bits: $type, res: $VecID = $VecID()): $VecID = bitfieldExtract(this, offset, bits, res)"
        }
        Generator.Part.CompanionObject -> {
            bitfieldExtract()
            "inline fun <R> bitfieldExtract($`vXYZW type`, offset: Int, bits: $type, res: ($`resXYZW type`) -> R): R" {
                +contract
                +"return res(${XyzwJoint { "v$it.bitfieldExtract(offset, bits)" }})"
            }
            bitfieldExtract()
            +"fun bitfieldExtract(v: $VecID, offset: Int, bits: $type, res: $VecID = $VecID()): $VecID = res(${xyzwJoint(separator = ",\n") { "v.$it.bitfieldExtract(offset, bits)" }})"
        }
        Generator.Part.Scalar -> {
            imports += "glm_.mask"
            bitfieldExtract()
            +"fun $type.bitfieldExtract(offset: Int, bits: $type): $type = (this shr offset) and bits.mask"
        }
    }

    fun bitfieldInsert(base: String = "this", insert: String = "insert") = docs("""
        |Returns the insertion the bits least-significant bits of `$insert` into `$base`.
        |
        |The result will have bits `[offset, offset + bits - 1]` taken from bits `[0, bits - 1]` of `insert`, and all other bits taken
        |directly from the corresponding bits of `$base`. If `bits` is zero, the result will simply be `$base`. The result will be
        |undefined if `offset` or `bits` is negative, or if the sum of `offset` and `bits` is greater than the number of bits used to
        |store the operand.
        |
        |@see <a href="http://www.opengl.org/sdk/docs/manglsl/xhtml/bitfieldInsert.xml">GLSL bitfieldInsert man page</a>
        |@see <a href="http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf">GLSL 4.20.8 specification, section 8.8 Integer Functions</a>""")
    when (part) {
        Generator.Part.Class -> {
            bitfieldInsert()
            +"fun bitfieldInsertAssign(insert: $VecID, offset: Int, bits: $type): $VecID = bitfieldInsert(this, insert, offset, bits, this)"
            bitfieldInsert(insert = "insert[$XYZW]")
            +"fun bitfieldInsertAssign($`insertXYZW type`, offset: Int, bits: $type): $VecID = bitfieldInsert($xyzw, $insertXYZW, offset, bits) { $`resXYZW type` -> this($resXYZW) }"

            bitfieldInsert()
            +"fun bitfieldInsert(insert: $VecID, offset: Int, bits: $type, res: $VecID = $VecID()): $VecID = bitfieldInsert(this, insert, offset, bits, res)"
            bitfieldInsert(insert = "insert[$XYZW]")
            "fun bitfieldInsert($`insertXYZW type`, offset: Int, bits: $type, res: $VecID = $VecID()): $VecID =".indented {
                +"bitfieldInsert($xyzw, $insertXYZW, offset, bits) { $`resXYZW type` -> res($resXYZW) }"
            }
        }
        Generator.Part.CompanionObject -> {
            bitfieldInsert("base[$XYZW]", "inser[$XYZW]")
            "inline fun <R> bitfieldInsert($`baseXYZW type`, $`insertXYZW type`, offset: Int, bits: $type, res: ($`resXYZW type`) -> R): R" {
                +contract
                +"return res(${XyzwJoint { "base$it.bitfieldInsert(insert$it, offset, bits)" }})"
            }
            bitfieldInsert("base")
            +"fun bitfieldInsert(base: $VecID, insert: $VecID, offset: Int, bits: $type, res: $VecID = $VecID()): $VecID = res(${xyzwJoint(separator = ",\n") { "base.$it.bitfieldInsert(insert.$it, offset, bits)" }})"
        }
        Generator.Part.Scalar -> {
            bitfieldInsert()
            //            val prefix = if (type == "UInt") "(" else ""
            //            val postfix = if (type == "UInt") ").toUInt()" else ""
            +"""
                fun $type.bitfieldInsert(insert: $type, offset: Int, bits: $type): $type {
                    val mask = ${""}bits.mask shl offset
                    return (this and mask.inv()) or ((insert shl offset) and mask)
                }"""
        }
    }

    fun bitfieldReverse() = docs("""
        |Returns the reversal of the bits of value.
        |The bit numbered `n` of the result will be taken from bit `(bits - 1) - n` of value,
        |where `bits` is the total number of bits used to represent value.
        |
        |@see <a href="http://www.opengl.org/sdk/docs/manglsl/xhtml/bitfieldReverse.xml">GLSL bitfieldReverse man page</a>
        |@see <a href="http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf">GLSL 4.20.8 specification, section 8.8 Integer Functions</a>""")
    when (part) {
        Generator.Part.Class -> {
            bitfieldReverse()
            +"fun bitfieldReverseAssign(): $VecID = bitfieldReverse(this, this)"

            bitfieldReverse()
            +"fun bitfieldReverse(res: $VecID = $VecID()): $VecID = bitfieldReverse(this, res)"
        }
        Generator.Part.CompanionObject -> {
            bitfieldReverse()
            "inline fun <R> bitfieldReverse($`xyzw type`, res: ($`resXYZW type`) -> R): R" {
                +contract
                +"return res(${xyzwJoint { "$it.bitfieldReverse()" }})"
            }
            bitfieldReverse()
            +"fun bitfieldReverse(v: $VecID, res: $VecID = $VecID()): $VecID = res(${xyzwJoint { "v.$it.bitfieldReverse()" }})"
        }
        Generator.Part.Scalar -> {
            bitfieldReverse()
            val unsType = if (type.startsWith('U')) "U" else ""
            val ext = if (type.startsWith('U')) "uL" else ""
            val (prefix, postfix) = when {
                "Long" in type -> "" to ".call(0x00000000FFFFFFFF$unsType, 32)"
                else -> "to${unsType}Long()." to ".to$type()"
            }
            +"""
                fun $type.bitfieldReverse(): $type {
                    fun ${unsType}Long.call(mask: ${unsType}Long, shift: Int) = (this and mask shl shift) or (this and mask.inv() shr shift)
                    return ${prefix}call(0x5555555555555555$ext, 1)
                        .call(0x3333333333333333$ext, 2)
                        .call(0x0F0F0F0F0F0F0F0F$ext, 4)
                        .call(0x00FF00FF00FF00FF$ext, 8)
                        .call(0x0000FFFF0000FFFF$ext, 16)$postfix
                }"""
        }
    }

    fun bitCount() = docs("""
        |Returns the number of bits set to `1` in the binary representation of value.
        |
        |@see <a href="http://www.opengl.org/sdk/docs/manglsl/xhtml/bitCount.xml">GLSL bitCount man page</a>
        |@see <a href="http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf">GLSL 4.20.8 specification, section 8.8 Integer Functions</a>""")
    when (part) {
        Generator.Part.Class -> {
            bitCount()
            +"fun bitCountAssign(): $VecID = bitCount(this, this)"

            bitCount()
            +"fun bitCount(res: $VecID = $VecID()): $VecID = bitCount(this, res)"
        }
        Generator.Part.CompanionObject -> {
            bitCount()
            "inline fun <R> bitCount($`xyzw type`, res: ($`resXYZW Int`) -> R): R" {
                +contract
                +"return res(${xyzwJoint { "$it.bitCount" }})"
            }
            bitCount()
            val maybeConvert = if (type == "Int") "" else ".to$type()"
            +"fun bitCount(v: $VecID, res: $VecID = $VecID()): $VecID = res(${xyzwJoint { "v.$it.bitCount$maybeConvert" }})"
        }
        Generator.Part.Scalar -> {
            bitCount()
            +"val $type.bitCount: Int get() = countOneBits()"
        }
    }

    fun findLSB() = docs("""
        |Returns the bit number of the least significant bit set to `1` in the binary representation of value.
        |If value is zero, `0` will be returned.
        |
        |
        |@see <a href="http://www.opengl.org/sdk/docs/manglsl/xhtml/findLSB.xml">GLSL findLSB man page</a>
        |@see <a href="http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf">GLSL 4.20.8 specification, section 8.8 Integer Functions</a>""")
    when (part) {
        Generator.Part.Class -> {
            findLSB()
            +"fun findLSBAssign(): $VecID = findLSB(this, this)"

            findLSB()
            +"fun findLSB(res: $VecID = $VecID()): $VecID = findLSB(this, res)"
        }
        Generator.Part.CompanionObject -> {
            findLSB()
            "inline fun <R> findLSB($`xyzw type`, res: ($`resXYZW type`) -> R): R" {
                +contract
                +"return res(${xyzwJoint { "$it.findLSB" }})"
            }
            findLSB()
            +"fun findLSB(v: $VecID, res: $VecID = $VecID()): $VecID = res(${xyzwJoint { "v.$it.findLSB" }})"
        }
        Generator.Part.Scalar -> {
            findLSB()
            +"val $type.findLSB: $type get() = takeLowestOneBit()"
        }
    }

    fun findMSB() = ("""
        |Returns the bit number of the most significant bit in the binary representation of value.
        |For positive integers, the result will be the bit number of the most significant bit set to `1`.
        |For negative integers, the result will be the bit number of the most significant
        |bit set to `0`. For a value of zero or negative one, `0` will be returned.
        |
        |@see <a href="http://www.opengl.org/sdk/docs/manglsl/xhtml/findMSB.xml">GLSL findMSB man page</a>
        |@see <a href="http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf">GLSL 4.20.8 specification, section 8.8 Integer Functions</a>""")
    when (part) {
        Generator.Part.Class -> {
            findMSB()
            +"fun findMSBAssign(): $VecID = findMSB(this, this)"

            findMSB()
            +"fun findMSB(res: $VecID = $VecID()): $VecID = findMSB(this, res)"
        }
        Generator.Part.CompanionObject -> {
            findMSB()
            "inline fun <R> findMSB($`xyzw type`, res: ($`resXYZW type`) -> R): R" {
                +contract
                +"return res(${xyzwJoint { "$it.findMSB" }})"
            }
            findMSB()
            +"fun findMSB(v: $VecID, res: $VecID = $VecID()): $VecID = res(${xyzwJoint { "v.$it.findMSB" }})"
        }
        Generator.Part.Scalar -> {
            findMSB()
            +"val $type.findMSB: $type get() = takeHighestOneBit()"
        }
    }
}