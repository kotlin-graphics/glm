package glm_.detail

import glm_.*
import glm_.gen.Generator

// this is called both from mats and vecs. With vecs, `width` is `ordinal` and `height` is 0
fun Generator.matrix(width: Int, height: Int, type: String, extension: String, id: String, part: Generator.Part) {

    if (part != Generator.Part.Scalar) +"// func matrix\n"

    val matID = "Mat$matrixSize$id"
    val xyzw = xyzwJoint()
    val `mCR type` = abcdJointIndexed(",\n") { c, r, _ -> "m${nn(c, r)}: $type" }
    val `nCR type` = abcdJointIndexed(",\n") { c, r, _ -> "n${nn(c, r)}: $type" }
    val `m,abcdN` = abcdJoint(rowSeparator = ",\n") { "m.$it" }
    val `n,abcdN` = abcdJoint(rowSeparator = ",\n") { "n.$it" }
    val nAbcdN = AbcdJoint(rowSeparator = ",\n") { "n$it" }
    val `nAbcdN type` = AbcdJoint(",\n") { "n$it: $type" }
    val abcdN = abcdJoint(",\n")
    val `abcdN type` = abcdJoint(rowSeparator = ",\n") { "$it: $type" }

    // int is included, which is part of ext_matrix_integer
    if (type !in matrixTypes.map { it.type })
        return

    fun matrix(doc: String, func: String) = docs("""
        ${if (doc.startsWith('|')) doc else "|$doc"}
        |
        |@see <a href="http://www.opengl.org/sdk/docs/manglsl/xhtml/$func.xml">GLSL $func man page</a>
        |@see <a href="http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf">GLSL 4.20.8 specification, section 8.6 Matrix Functions</a>""")

    val isMat = width > 0 && height > 0
    val isVec = width > 1 && height == 0
    val nl = '\n'

    if (isMat) {

        fun matrixCompMult(x: String = "this", y: String = "n") = matrix(
            "Multiply matrix `$x` by matrix `$y` component-wise, i.e., `result[i, j]` is the scalar product of `x[i, j]` and `y[i, j]`.", "matrixCompMult")
        when (part) {
            Generator.Part.Class -> {
                matrixCompMult()
                +"infix fun compMultAssign(n: $matID): $matID = compMult(n, this)"

                matrixCompMult()
                +"infix fun compMult(n: $matID): $matID = compMult(n, $matID())"
                matrixCompMult()
                +"""
                    fun compMult(n: $matID, res: $matID = $matID()): $matID = compMult(this, n) { $`abcdN type` ->
                        res($abcdN)
                    }"""

                matrixCompMult(y = "n[${AbcdJoint()}")
                +"""
                    fun compMult($`nAbcdN type`, res: $matID = $matID()): $matID = compMult($abcdN,$nl$`nAbcdN`) { $`abcdN type` ->
                        res($abcdN)
                    }"""

                matrixCompMult()
                +"inline fun <R> compMult(n: $matID, res: ($`abcdN type`) -> R): R = compMult(this, n, res)"
                matrixCompMult(y = "n[${AbcdJoint()}")
                +"inline fun <R> compMult($`nAbcdN type`, res: ($`abcdN type`) -> R): R = compMult($abcdN,\n$nAbcdN, res)"
            }
            Generator.Part.CompanionObject -> {
                matrixCompMult("m")
                +"""
                    inline fun <R> compMult(m: $matID, n: $matID, res: ($`abcdN type`) -> R): R {
                        $contract
                        return compMult($`m,abcdN`,$nl$`n,abcdN`, res)
                    }"""
                matrixCompMult("m")
                "inline fun <R> compMult($`mCR type`,\n$`nCR type`, res: ($`abcdN type`) -> R): R" {
                    +contract
                    fun times(c: Int) {
                        val mC = (0 until height).joinToString { "m$c$it" }
                        val nC = (0 until height).joinToString { "n$c$it" }
                        val abcdCN = (0 until height).joinToString { abcdN(c, it) }
                        "Vec${height}$id.times($mC, $nC) { $abcdCN ->".indentAndClose {
                            if (c + 1 < width)
                                times(c + 1)
                            else
                                +"return res($abcdN)"
                        }
                    }
                    times(0)
                }
            }
            else -> Unit
        }
    }

    if (isVec) {

        fun outerProduct(c: String = "this", r: String = "n") = matrix(
            "Treats the first parameter `$c` as a column vector and the second parameter `$r` as a row vector and does a linear algebraic matrix multiply `$c * $r`.", "outerProduct")

        for (i in 2..4) {
            val vecCid = "Vec$width$id"
            val vecRid = "Vec$i$id"
            // needs to overwrite since we are in a vec
            val matID = if(width == i) "Mat$width$id" else "Mat${i}x${width}$id"
            val `abcdN type` = abcdJoint(i, width, rowSeparator = ",\n") { "$it: $type" }
            val abcdN = abcdJoint(i, width,",\n")
            val `rXyzw type` = XyzwJoint(i) { "r$it: $type" }
            val rXyzw = XyzwJoint(i) { "r$it" }
            when (part) {
                Generator.Part.Class -> {
                    outerProduct()
                    +"infix fun outerProduct(r: $vecRid): $matID = outerProduct(r, $matID())"
                    outerProduct()
                    +"""
                        fun outerProduct(r: $vecRid, res: $matID): $matID = outerProduct(this, r) { $`abcdN type` ->
                            res($abcdN)
                        }"""
                    outerProduct(r = "n[${AbcdJoint()}")
                    +"""
                        inline fun <R> outerProduct($`rXyzw type`, res: ($`abcdN type`) -> R): R {
                            $contract
                            return outerProduct($xyzw, $rXyzw, res)
                        }"""
                }
                Generator.Part.CompanionObject -> {
                    val `resAbcd i x width type` = AbcdJoint(i, width, ",\n") { "res$it: $type" }
                    val `resAbcd i x width` = AbcdJoint(i, width, ",\n") { "res$it" }
                    val `c,xyzw` = xyzwJoint(width) { "c.$it" }
                    val `cXYZW type` = XyzwJoint(width) { "c$it: $type" }
                    val XYZW = XyzwJoint(width)
                    val `r,xyzw` = xyzwJoint(i) { "r.$it" }
                    val `rXYZW type` = XyzwJoint(i) { "r$it: $type" }
                    outerProduct("c", "r")
                    +"inline fun <R> outerProduct(c: $vecCid, r: $vecRid, res: ($`resAbcd i x width type`) -> R): R = outerProduct($`c,xyzw`,\n$`r,xyzw`, res)"
                    outerProduct("c[$XYZW]", "r[$XYZW]")
                    "inline fun <R> outerProduct($`cXYZW type`,\n$`rXYZW type`, res: ($`resAbcd i x width type`) -> R): R" {
                        +contract
                        fun times(c: Int) {
                            val cXYZW = XyzwJoint(width) { "c$it" }
                            val rXYZW = XyzwJoint(width) { "r${glm_.xyzw[c].toUpperCase()}" }
                            val abcdCN = (0 until width).joinToString { "res${glm_.abcd[c].toUpperCase()}$it: $type" }
                            "Vec${width}$id.times($cXYZW, $rXYZW) { $abcdCN ->".indentAndClose {
                                if (c + 1 < i)
                                    times(c + 1)
                                else
                                    +"return res($`resAbcd i x width`)"
                            }
                        }
                        times(0)
                    }
                }
                else -> Unit
            }
        }
    }

    if (isMat) {

        fun transpose(x: String = "this") = matrix("Returns the transposed matrix of `$x`", "transpose")
        val `abcd height x width type` = abcdJoint(height, width, ",\n") { "$it: $type" }
        val transposeMatID = if (width == height) matID else "Mat${height}x${width}$id"
        val abcdN = abcdJoint(height, width,",\n")
        when (part) {
            Generator.Part.Class -> {
                if (width == height) {
                    transpose()
                    +"fun transposeAssign(): $transposeMatID = transpose(this)"
                }
                transpose()
                "fun transpose(res: $transposeMatID = $transposeMatID()): $transposeMatID = transpose(this) { $`abcd height x width type` ->".indentAndClose {
                    +"res($abcdN)"
                }

                transpose()
                +"""
                    inline fun <R> transpose(res: ($`abcd height x width type`) -> R): R {
                        $contract
                        return transpose(this, res)
                    }"""
            }
            Generator.Part.CompanionObject -> {
                val `abcd height x width` = abcdJointIndexed(height, width, ",\n") { c, r, _ -> "${abcd[r]}$c" }
                transpose("m")
                +"inline fun <R> transpose(m: $matID, res: ($`abcd height x width type`) -> R): R = transpose($`m,abcdN`, res)"
                transpose("m[ABCDn]")
                "inline fun <R> transpose($`abcdN type`,\nres: ($`abcd height x width type`) -> R): R" {
                    +contract
                    +"return res($`abcd height x width`)"
                }
            }
            else -> Unit
        }

        if (width == height) {
            fun det() = matrix("Return the determinant of a squared matrix.", "determinant")
            when (part) {
                Generator.Part.Class -> {
                    det()
                    +"fun determinant(): $type = determinant(this)"
                }
                Generator.Part.CompanionObject -> {
                    det()
                    +"fun determinant(m: $matID): $type = determinant($`m,abcdN`)"

                    det()
                    when (width) {
                        2 -> +"fun determinant($`abcdN type`): $type = a0 * b1 - b0 * a1"
                        3 -> +"fun determinant($`abcdN type`): $type = + a0 * (b1 * c2 - c1 * b2) - b0 * (a1 * c2 - c1 * a2) + c0 * (a1 * b2 - b1 * a2)"
                        else -> +"""
                            fun determinant($`abcdN type`): $type {
                                val subFactor00 = c2 * d3 - d2 * c3
                                val subFactor01 = c1 * d3 - d1 * c3
                                val subFactor02 = c1 * d2 - d1 * c2
                                val subFactor03 = c0 * d3 - d0 * c3
                                val subFactor04 = c0 * d2 - d0 * c2
                                val subFactor05 = c0 * d1 - d0 * c1
                        
                                val detCof0 = + (b1 * subFactor00 - b2 * subFactor01 + b3 * subFactor02)
                                val detCof1 = - (b0 * subFactor00 - b2 * subFactor03 + b3 * subFactor04)
                                val detCof2 = + (b0 * subFactor01 - b1 * subFactor03 + b3 * subFactor05)
                                val detCof3 = - (b0 * subFactor02 - b1 * subFactor04 + b2 * subFactor05)
                        
                                return a0 * detCof0 + a1 * detCof1 +
                                       a2 * detCof2 + a3 * detCof3
                        }"""
                    }
                }
                else -> Unit
            }

            if (type == "Int")
                return

            fun inverse() = matrix("Return the inverse of a squared matrix.", "inverse")
            when (part) {
                Generator.Part.Class -> {
                    inverse()
                    +"fun inverseAssign(): $matID = inverse(this)"

                    inverse()
                    +"""
                        fun inverse(res: $matID = $matID()): $matID = inverse(this) { $`abcdN type` ->
                            res($abcdN)
                        }"""

                    inverse()
                    +"inline fun <R> inverse(res: ($`abcdN type`) -> R): R = inverse(this, res)"
                }
                Generator.Part.CompanionObject -> {
                    inverse()
                    +"inline fun <R> inverse(m: $matID, res: ($`abcdN type`) -> R): R = inverse($`m,abcdN`, res)"

                    inverse()
                    when (width) {
                        2 -> +"""
                            inline fun <R> inverse($`abcdN type`, res: ($`abcdN type`) -> R): R {
                                val oneOverDet = 1 / determinant($abcdN)
                                return res(+ b1 * oneOverDet,
                                           - a1 * oneOverDet,
                                           - b0 * oneOverDet,
                                           + a0 * oneOverDet)
                            }"""
                        3 -> +"""
                            inline fun <R> inverse($`abcdN type`, res: ($`abcdN type`) -> R): R {
                                val oneOverDet = 1 / determinant($abcdN)
                                return res(+ (b1 * c2 - c1 * b2) * oneOverDet,
                                           - (a1 * c2 - c1 * a2) * oneOverDet,
                                           + (a1 * b2 - b1 * a2) * oneOverDet,
                                           - (b0 * c2 - c0 * b2) * oneOverDet,
                                           + (a0 * c2 - c0 * a2) * oneOverDet,
                                           - (a0 * b2 - b0 * a2) * oneOverDet,
                                           + (b0 * c1 - c0 * b1) * oneOverDet,
                                           - (a0 * c1 - c0 * a1) * oneOverDet,
                                           + (a0 * b1 - b0 * a1) * oneOverDet)
                            }"""
                        4 -> +"""
                            inline fun <R> inverse($`abcdN type`, res: ($`abcdN type`) -> R): R {
                                val c00 = c2 * d3 - d2 * c3
                                val c02 = b2 * d3 - d2 * b3
                                val c03 = b2 * c3 - c2 * b3
                    
                                val c04 = c1 * d3 - d1 * c3
                                val c06 = b1 * d3 - d1 * b3
                                val c07 = b1 * c3 - c1 * b3
                    
                                val c08 = c1 * d2 - d1 * c2
                                val c10 = b1 * d2 - d1 * b2
                                val c11 = b1 * c2 - c1 * b2
                    
                                val c12 = c0 * d3 - d0 * c3
                                val c14 = b0 * d3 - d0 * b3
                                val c15 = b0 * c3 - c0 * b3
                    
                                val c16 = c0 * d2 - d0 * c2
                                val c18 = b0 * d2 - d0 * b2
                                val c19 = b0 * c2 - c0 * b2
                    
                                val c20 = c0 * d1 - d0 * c1
                                val c22 = b0 * d1 - d0 * b1
                                val c23 = b0 * c1 - c0 * b1
                    
                                val i00 = +(b1 * c00 - b2 * c04 + b3 * c08)
                                val i01 = -(a1 * c00 - a2 * c04 + a3 * c08)
                                val i02 = +(a1 * c02 - a2 * c06 + a3 * c10)
                                val i03 = -(a1 * c03 - a2 * c07 + a3 * c11)
                        
                                val i10 = -(b0 * c00 - b2 * c12 + b3 * c16)
                                val i11 = +(a0 * c00 - a2 * c12 + a3 * c16)
                                val i12 = -(a0 * c02 - a2 * c14 + a3 * c18)
                                val i13 = +(a0 * c03 - a2 * c15 + a3 * c19)
                        
                                val i20 = +(b0 * c04 - b1 * c12 + b3 * c20)
                                val i21 = -(a0 * c04 - a1 * c12 + a3 * c20)
                                val i22 = +(a0 * c06 - a1 * c14 + a3 * c22)
                                val i23 = -(a0 * c07 - a1 * c15 + a3 * c23)
                        
                                val i30 = -(b0 * c08 - b1 * c16 + b2 * c20)
                                val i31 = +(a0 * c08 - a1 * c16 + a2 * c20)
                                val i32 = -(a0 * c10 - a1 * c18 + a2 * c22)
                                val i33 = +(a0 * c11 - a1 * c19 + a2 * c23)
                    
                                val oneOverDet = 1 / (a0 * i00 + a1 * i10 + a2 * i20 + a3 * i30)

                                return res(i00 * oneOverDet, i01 * oneOverDet, i02 * oneOverDet, i03 * oneOverDet,
                                           i10 * oneOverDet, i11 * oneOverDet, i12 * oneOverDet, i13 * oneOverDet,
                                           i20 * oneOverDet, i21 * oneOverDet, i22 * oneOverDet, i23 * oneOverDet,
                                           i30 * oneOverDet, i31 * oneOverDet, i32 * oneOverDet, i33 * oneOverDet)
                            }"""
                    }
                }
                else -> Unit
            }
        }
    }
}