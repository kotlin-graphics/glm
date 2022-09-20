package glm_

// common.hpp
fun Generator.common(ordinal: Int, type: String, extension: String, id: String, vec: String) {

    +"\n// common\n"

    val VecID = vec + id
    val xyzw = xyzwJoint { it }
    val `bXYZW` = XyzwJoint { "b$it" }
    val `bXYZW type` = XyzwJoint { "b$it: $type" }
    val `b,xyzw` = xyzwJoint { "b.$it" }
    val `c,xyzw` = xyzwJoint { "c.$it" }
    val resXYZW = XyzwJoint { "res$it" }
    val `resXYZW type` = XyzwJoint { "res$it: $type" }
    if (type !in unsignedTypes && type != "Boolean") {

        var doc = """|Returns this [$VecID] if this >= 0; otherwise, it returns -x.
                     |
                     |[GLSL abs man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/abs.xml)
                     |[GLSL 4.20.8 specification, section 8.3 Common Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)"""
        docs(doc)
        +"fun absAssign(): $VecID = abs(this)"
        docs(doc)
        +"fun abs(res: $VecID = $VecID()): $VecID = abs { $resXYZW -> res($resXYZW) }"
        docs(doc)
        "inline fun <R> abs(res: ($`resXYZW type`) -> R): R" {
            contract
            +"return abs($xyzw, res)"
        }


        if (type in floatingPointTypes) {

            doc = """|Returns 1 if x > 0, 0 if x == 0, or -1 if x < 0.
                     |
                     |[GLSL sign man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/sign.xml)
                     |[GLSL 4.20.8 specification, section 8.3 Common Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)"""
            docs(doc)
            +"fun signAssign(): $VecID = sign(this)"
            docs(doc)
            +"fun sign(res: $VecID = $VecID()): $VecID = sign { $resXYZW -> res($resXYZW) }"
            docs(doc)
            "inline fun <R> sign(res: ($`resXYZW type`) -> R): R" {
                contract
                +"return sign($xyzw, res)"
            }


            doc = """|Returns a value equal to the nearest integer that is less then or equal to this [$VecID].
                     |
                     |[GLSL floor man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/floor.xml)
                     |[GLSL 4.20.8 specification, section 8.3 Common Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)"""
            docs(doc)
            +"fun floorAssign(): $VecID = floor(this)"
            docs(doc)
            +"fun floor(res: $VecID = $VecID()): $VecID = floor { $resXYZW -> res($resXYZW) }"
            docs(doc)
            "inline fun <R> floor(res: ($`resXYZW type`) -> R): R" {
                contract
                +"return floor($xyzw, res)"
            }


            doc = """|Returns a value equal to the nearest integer to this [$VecID]
                     |whose absolute value is not larger than the absolute value of this [$VecID].
                     |
                     |[GLSL trunc man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/trunc.xml)
                     |[GLSL 4.20.8 specification, section 8.3 Common Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)"""
            docs(doc)
            +"fun truncAssign(): $VecID = trunc(this)"
            docs(doc)
            +"fun trunc(res: $VecID = $VecID()): $VecID = trunc { $resXYZW -> res($resXYZW) }"
            docs(doc)
            "inline fun <R> trunc(res: ($`resXYZW type`) -> R): R" {
                contract
                +"return trunc($xyzw, res)"
            }


            doc = """|Returns a value equal to the nearest integer to this [$VecID]. The fraction 0.5 will round in a 
                     |direction chosen by the implementation, presumably the direction that is fastest.
                     |This includes the possibility that `round` returns the same value as `roundEven` for all values of
                     |this [$VecID].
                     |
                     |[GLSL round man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/round.xml)
                     |[GLSL 4.20.8 specification, section 8.3 Common Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)"""
            docs(doc)
            +"fun roundAssign(): $VecID = round(this)"
            docs(doc)
            +"fun round(res: $VecID = $VecID()): $VecID = round { $resXYZW -> res($resXYZW) }"
            docs(doc)
            "inline fun <R> round(res: ($`resXYZW type`) -> R): R" {
                contract
                +"return round($xyzw, res)"
            }


            doc = """|Returns a value equal to the nearest integer to this [$VecID]. A fractional part of 0.5 will round
                     |toward the nearest even integer. (Both 3.5 and 4.5 for x will return 4.0.)
                     |
                     |[GLSL roundEven man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/roundEven.xml)
                     |[GLSL 4.20.8 specification, section 8.3 Common Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)
                     |[New round to even technique](http://developer.amd.com/documentation/articles/pages/New-Round-to-Even-Technique.aspx)"""
            docs(doc)
            +"fun roundEvenAssign(): $VecID = roundEven(this)"
            docs(doc)
            +"fun roundEven(res: $VecID = $VecID()): $VecID = roundEven { $resXYZW -> res($resXYZW) }"
            docs(doc)
            "inline fun <R> roundEven(res: ($`resXYZW type`) -> R): R" {
                contract
                +"return roundEven($xyzw, res)"
            }


            doc = """|Returns a value equal to the nearest integer that is greater than or equal to this [$VecID].
                     |
                     |[GLSL ceil man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/ceil.xml)
                     |[GLSL 4.20.8 specification, section 8.3 Common Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)"""
            docs(doc)
            +"fun ceilAssign(): $VecID = ceil(this)"
            docs(doc)
            +"fun ceil(res: $VecID = $VecID()): $VecID = ceil { $resXYZW -> res($resXYZW) }"
            docs(doc)
            "inline fun <R> ceil(res: ($`resXYZW type`) -> R): R" {
                contract
                +"return ceil($xyzw, res)"
            }


            doc = """|Return this [$VecID] - this.floor.
                     |
                     |[GLSL fract man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/fract.xml)
                     |[GLSL 4.20.8 specification, section 8.3 Common Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)"""
            docs(doc)
            +"fun fractAssign(): $VecID = fract(this)"
            docs(doc)
            +"fun fract(res: $VecID = $VecID()): $VecID = fract { $resXYZW -> res($resXYZW) }"
            docs(doc)
            "inline fun <R> fract(res: ($`resXYZW type`) -> R): R" {
                contract
                +"return fract($xyzw, res)"
            }

            val bbbb = xyzwJoint { "b" }

            doc = """|Modulus. Returns this - b * floor(this / b) for each component in this [$VecID] using the floating point value b.
                     |
                     |[GLSL mod man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/mod.xml)
                     |[GLSL 4.20.8 specification, section 8.3 Common Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)"""
            docs(doc)
            +"infix fun modAssign(b: $type): $VecID = mod(b, this)"
            docs(doc)
            +"fun mod(b: $type, res: $VecID = $VecID()): $VecID = mod(b) { $resXYZW -> res($resXYZW) }"
            docs(doc)
            "inline fun <R> mod(b: $type, res: ($`resXYZW type`) -> R): R" {
                contract
                +"return mod($xyzw, $bbbb, res)"
            }
            if (ordinal > 1) {
                docs(doc)
                +"fun mod(b: $VecID, res: $VecID = $VecID()): $VecID = mod(b) { $resXYZW -> res($resXYZW) }"
                docs(doc)
                "inline fun <R> mod(b: $VecID, res: ($`resXYZW type`) -> R): R" {
                    contract
                    +"return mod($xyzw, $`b,xyzw`, res)"
                }
                docs(doc)
                +"fun modAssign($`bXYZW type`): $VecID = mod($`bXYZW`, this)"
                docs(doc)
                +"fun mod($`bXYZW type`, res: $VecID = $VecID()): $VecID = mod($`bXYZW`) { $resXYZW -> res($resXYZW) }"
                docs(doc)
                "inline fun <R> mod($`bXYZW type`, res: ($`resXYZW type`) -> R): R" {
                    contract
                    +"return mod($xyzw, $`bXYZW`, res)"
                }
            }


            doc = """|Returns the fractional part of this [$VecID] and its integer counterpart (as a whole number floating point value). 
                     |Both the return values will have the same sign as this [$VecID].
                     |
                     |[GLSL modf man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/modf.xml)
                     |[GLSL 4.20.8 specification, section 8.3 Common Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)"""
            docs(doc)
            val fXYZW = XyzwJoint { "f$it" }
            val iXYZW = XyzwJoint { "i$it" }
            +"fun modf(resF: $VecID = $VecID(), resI: $VecID = $VecID()) = modf($xyzw) { $fXYZW, $iXYZW ->"
            +"\tresF.put($fXYZW)"
            +"\tresI.put($iXYZW)"
            +"}"
            docs(doc)
            +"fun modf(res: Pair<$VecID, $VecID> = $VecID() to $VecID()): Pair<$VecID, $VecID> = modf { $fXYZW, $iXYZW ->"
            +"\tres.first.put($fXYZW)"
            +"\tres.second.put($iXYZW)"
            +"\tres"
            +"}"
            docs(doc)
            val `fXZYW type` = XyzwJoint { "f$it: $type" }
            val `iXYZW type` = XyzwJoint { "i$it: $type" }
            +"fun <R> modf(res: ($`fXZYW type`, $`iXYZW type`) -> R): R = modf($xyzw, res)"

            doc = """|Returns [b] if [b] < this [$VecID]; otherwise, it returns this.
                     |
                     |[GLSL min man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/min.xml)
                     |[GLSL 4.20.8 specification, section 8.3 Common Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)"""
            // min scalar
            docs(doc)
            +"infix fun minAssign(b: $type): $VecID = min(b, this)"
            docs(doc)
            +"infix fun min(b: $type): $VecID = min(b, $VecID())"
            docs(doc)
            +"fun min(b: $type, res: $VecID): $VecID = min(b) { $resXYZW -> res($resXYZW) }"
            docs(doc)
            "inline fun <R> min(b: $type, res: ($`resXYZW type`) -> R): R" {
                contract
                +"return min($xyzw, $bbbb, res)"
            }
            // min vectorial
            docs(doc)
            +"infix fun minAssign(b: $VecID): $VecID = min($`b,xyzw`, this)"
            docs(doc)
            +"infix fun min(b: $VecID): $VecID = min($`b,xyzw`, $VecID())"
            docs(doc)
            +"fun min(b: $VecID, res: $VecID): $VecID = min($`b,xyzw`) { $resXYZW -> res($resXYZW) }"
            docs(doc)
            "inline fun <R> min(b: $VecID, res: ($`resXYZW type`) -> R): R" {
                contract
                +"return min($xyzw, $`b,xyzw`, res)"
            }
            if (ordinal > 1) {
                docs(doc)
                +"fun minAssign($`bXYZW type`): $VecID = min($`bXYZW`, this)"
                docs(doc)
                +"fun min($`bXYZW type`, res: $VecID = $VecID()): $VecID = min($`bXYZW`) { $resXYZW -> res($resXYZW) }"
                docs(doc)
                "inline fun <R> min($`bXYZW type`, res: ($`resXYZW type`) -> R): R" {
                    contract
                    +"return min($xyzw, $bXYZW, res)"
                }
            }

            doc = """|Returns [b] if this [$VecID] < [b]; otherwise, it returns this.
                     |
                     |[GLSL max man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/max.xml)
                     |[GLSL 4.20.8 specification, section 8.3 Common Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)"""
            // max scalar
            docs(doc)
            +"infix fun maxAssign(b: $type): $VecID = max(b, this)"
            docs(doc)
            +"infix fun max(b: $type): $VecID = max(b, $VecID())"
            docs(doc)
            +"fun max(b: $type, res: $VecID): $VecID = max(b) { $resXYZW -> res($resXYZW) }"
            docs(doc)
            "inline fun <R> max(b: $type, res: ($`resXYZW type`) -> R): R" {
                contract
                +"return max($xyzw, $bbbb, res)"
            }
            // max vectorial
            docs(doc)
            +"infix fun maxAssign(b: $VecID): $VecID = max($`b,xyzw`, this)"
            docs(doc)
            +"infix fun max(b: $VecID): $VecID = max(b, $VecID())"
            docs(doc)
            +"fun max(b: $VecID, res: $VecID): $VecID = max(b) { $resXYZW -> res($resXYZW) }"
            docs(doc)
            "inline fun <R> max(b: $VecID, res: ($`resXYZW type`) -> R): R" {
                contract
                +"return max($xyzw, $`b,xyzw`, res)"
            }
            if (ordinal > 1) {
                docs(doc)
                +"fun maxAssign($`bXYZW type`): $VecID = max($`bXYZW`, this)"
                docs(doc)
                +"fun max($`bXYZW type`, res: $VecID = $VecID()): $VecID = max($`bXYZW`) { $resXYZW -> res($resXYZW) }"
                docs(doc)
                "inline fun <R> max($`bXYZW type`, res: ($`resXYZW type`) -> R): R" {
                    contract
                    +"return max($xyzw, $bXYZW, res)"
                }
            }


            doc = """|Returns `min(max(x, minVal), maxVal)` for each component in this [$VecID] using the values minVal and maxVal.
                     |
                     |[GLSL clamp man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/clamp.xml)
                     |[GLSL 4.20.8 specification, section 8.3 Common Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)"""
            docs(doc)
            val minMin = xyzwJoint { "min" }
            val maxMax = xyzwJoint { "max" }
            +"fun clampAssign(min: $type, max: $type): $VecID = clamp(min, max, this)"
            docs(doc)
            +"fun clamp(min: $type, max: $type, res: $VecID = $VecID()): $VecID = clamp(min, max) { $resXYZW -> res($resXYZW) }"
            docs(doc)
            "inline fun <R> clamp(min: $type, max: $type, res: ($`resXYZW type`) -> R): R" {
                contract
                +"return clamp($xyzw, $minMin, $maxMax, res)"
            }

            doc = """|Returns 0.0 if x < edge, otherwise it returns 1.0.
                     |
                     |[GLSL step man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/step.xml)
                     |[GLSL 4.20.8 specification, section 8.3 Common Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)"""
            // step scalar
            docs(doc)
            +"infix fun stepAssign(edge: $type): $VecID = step(edge, this)"
            docs(doc)
            +"infix fun step(edge: $type): $VecID = step(edge, $VecID())"
            docs(doc)
            +"fun step(edge: $type, res: $VecID): $VecID = step(edge) { $resXYZW -> res($resXYZW) }"
            docs(doc)
            "inline fun <R> step(edge: $type, res: ($`resXYZW type`) -> R): R" {
                contract
                +"return step($xyzw, edge, res)"
            }
            // step vectorial
            docs(doc)
            +"infix fun stepAssign(edge: $VecID): $VecID = step(edge, this)"
            docs(doc)
            +"infix fun step(edge: $VecID): $VecID = step(edge, $VecID())"
            docs(doc)
            +"fun step(edge: $VecID, res: $VecID): $VecID = step(edge) { $resXYZW -> res($resXYZW) }"
            docs(doc)
            val `edge,xyzw` = xyzwJoint { "edge.$it" }
            "inline fun <R> step(edge: $VecID, res: ($`resXYZW type`) -> R): R" {
                contract
                +"return step($xyzw, $`edge,xyzw`, res)"
            }

            doc = """|If genTypeU is a floating scalar or vector: Returns x * (1.0 - a) + y * a, i.e., the linear blend of x and y using the floating-point value a.
                     |The value for a is not restricted to the range [0, 1]. If genTypeU is a boolean scalar or vector: Selects which vector each returned component comes from. 
                     |For a component of a that is false, the corresponding component of x is returned. For a component of a that is true, the corresponding component of y is returned. 
                     |Components of x and y that are not selected are allowed to be invalid floating point values and will have no effect on the results. 
                     |Thus, this provides different functionality than genType mix(genType x, genType y, genType(a)) where a is a Boolean vector.
                     |@param x: Value to interpolate.
                     |@param y: Value to interpolate.
                     |@param a: Interpolant."""
            // mix scalar same float type
            docs(doc)
            +"fun mixAssign(b: $VecID, c: $type): $VecID = mix(b, c, this)"
            docs(doc)
            +"fun mix(b: $VecID, c: $type, res: $VecID = $VecID()): $VecID = mix(b, c) { $resXYZW -> res($resXYZW) }"
            docs(doc)
            "inline fun <R> mix(b: $VecID, c: $type, res: ($`resXYZW type`) -> R): R" {
                contract
                +"return mix($xyzw, $`b,xyzw`, c, res)"
            }
            // mix scalar other float type
            docs(doc)
            var otherFloatType = if (type == "Float") "Double" else "Float"
            +"fun mixAssign(b: $VecID, c: $otherFloatType): $VecID = mix(b, c.$extension, this)"
            docs(doc)
            +"fun mix(b: $VecID, c: $otherFloatType, res: $VecID = $VecID()): $VecID = mix(b, c.$extension) { $resXYZW -> res($resXYZW) }"
            docs(doc)
            +"inline fun <R> mix(b: $VecID, c: $otherFloatType, res: ($`resXYZW type`) -> R): R = mix(b, c.$extension, res)"
            // mix scalar boolean
            docs(doc)
            +"fun mixAssign(b: $VecID, c: Boolean): $VecID = mix(b, c, this)"
            docs(doc)
            +"fun mix(b: $VecID, c: Boolean, res: $VecID = $VecID()): $VecID = mix(b, c) { $resXYZW -> res($resXYZW) }"
            docs(doc)
            "inline fun <R> mix(b: $VecID, c: Boolean, res: ($`resXYZW type`) -> R): R" {
                contract
                +"return mix($xyzw, $`b,xyzw`, c, res)"
            }
            // mix vectorial same float type
            docs(doc)
            +"fun mixAssign(b: $VecID, c: $VecID): $VecID = mix(b, c, this)"
            docs(doc)
            +"fun mix(b: $VecID, c: $VecID, res: $VecID = $VecID()): $VecID = mix(b, c) { $resXYZW -> res($resXYZW) }"
            docs(doc)
            "inline fun <R> mix(b: $VecID, c: $VecID, res: ($`resXYZW type`) -> R): R" {
                contract
                +"return mix($xyzw, $`b,xyzw`, $`c,xyzw`, res)"
            }
            // mix vectorial other float type
            docs(doc)
            otherFloatType = if (type == "Float") "${vec}d" else vec
            +"fun mixAssign(b: $VecID, c: $otherFloatType): $VecID = mix(b, c, this)"
            docs(doc)
            +"fun mix(b: $VecID, c: $otherFloatType, res: $VecID = $VecID()): $VecID = mix(b, c) { $resXYZW -> res($resXYZW) }"
            docs(doc)
            +"inline fun <R> mix(b: $VecID, c: $otherFloatType, res: ($`resXYZW type`) -> R): R = mix($xyzw, $`b,xyzw`, ${xyzwJoint { "c.$it.$extension" }}, res)"
            // mix vectorial boolean
            docs(doc)
            +"fun mixAssign(b: $VecID, c: glm_.vec$ordinal.${vec}bool): $VecID = mix(b, c, this)"
            docs(doc)
            +"fun mix(b: $VecID, c: glm_.vec$ordinal.${vec}bool, res: $VecID = $VecID()): $VecID = mix(b, c) { $resXYZW -> res($resXYZW) }"
            docs(doc)
            "inline fun <R> mix(b: $VecID, c: glm_.vec$ordinal.${vec}bool, res: ($`resXYZW type`) -> R): R" {
                contract
                +"return mix($xyzw, $`b,xyzw`, $`c,xyzw`, res)"
            }
        }
    }
    when (type) {
        "Float" -> {
            docs("""|Returns a signed integer value representing the encoding of a floating-point value. 
                            |The floatingpoint value's bit-level representation is preserved.
                            |
                            |[GLSL floatBitsToInt man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/floatBitsToInt.xml)
                            |[GLSL 4.20.8 specification, section 8.3 Common Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)""")
            +"fun bitsToInt(res: ${vec}i = ${vec}i()): ${vec}i = res(${xyzwJoint { "$it.bitsToInt()" }})"
            docs("""|Returns a unsigned integer value representing the encoding of a floating-point value. 
                            |The floatingpoint value's bit-level representation is preserved.
                            |
                            |[GLSL floatBitsToUint man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/floatBitsToUint.xml)
                            |[GLSL 4.20.8 specification, section 8.3 Common Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)""")
            +"fun bitsToUInt(res: ${vec}ui = ${vec}ui()): ${vec}ui = res(${xyzwJoint { "$it.bitsToUInt()" }})"
        }
        "Double" -> {
            +"fun bitsToLong(res: ${vec}L = ${vec}L()): ${vec}L = res(${xyzwJoint { "$it.bitsToLong()" }})"
            +"fun bitsToULong(res: ${vec}ul = ${vec}ul()): ${vec}ul = res(${xyzwJoint { "$it.bitsToULong()" }})"
        }
        "Int" -> {
            docs("""|Returns a floating-point value corresponding to a signed integer encoding of a floating-point value.
                            |If an inf or NaN is passed in, it will not signal, and the resulting floating point value is unspecified. 
                            |Otherwise, the bit-level representation is preserved.
                            |
                            |[GLSL intBitsToFloat man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/intBitsToFloat.xml)
                            |[GLSL 4.20.8 specification, section 8.3 Common Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)""")
            +"fun bitsToFloat(res: $vec = $vec()): $vec = res(${xyzwJoint { "$it.bitsToFloat()" }})"
        }
        "UInt" -> {
            docs("""|Returns a floating-point value corresponding to a unsigned integer encoding of a floating-point value.
                            |If an inf or NaN is passed in, it will not signal, and the resulting floating point value is unspecified. 
                            |Otherwise, the bit-level representation is preserved.
                            |
                            |[GLSL uintBitsToFloat man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/uintBitsToFloat.xml)
                            |[GLSL 4.20.8 specification, section 8.3 Common Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)""")
            +"fun bitsToFloat(res: $vec = $vec()): $vec = res(${xyzwJoint { "$it.bitsToFloat()" }})"
        }
        "Long" -> +"fun bitsToDouble(res: ${vec}d = ${vec}d()): ${vec}d = res(${xyzwJoint { "$it.bitsToDouble()" }})"
        "ULong" -> +"fun bitsToDouble(res: ${vec}d = ${vec}d()): ${vec}d = res(${xyzwJoint { "$it.bitsToDouble()" }})"
    }
    if (type in floatingPointTypes) {
        var doc = """|Computes and returns a * b + c.
                     |
                     |[GLSL fma man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/fma.xml)
                     |[GLSL 4.20.8 specification, section 8.3 Common Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)"""
        // fma
        docs(doc)
        +"fun fmaAssign(b: $VecID, c: $VecID): $VecID = fma(b, c, this)"
        docs(doc)
        +"fun fma(b: $VecID, c: $VecID, res: $VecID = $VecID()): $VecID = fma(b, c) { $resXYZW -> res($resXYZW) }"
        docs(doc)
        "inline fun <R> fma(b: $VecID, c: $VecID, res: ($`resXYZW type`) -> R): R" {
            contract
            +"return fma($xyzw, $`b,xyzw`, $`c,xyzw`, res)"
        }

        // frexp
        doc = """|Splits x into a floating-point significand in the range [0.5, 1.0) and an integral exponent of two, such that:
                 |`x = significand * exp(2, exponent)`
                 |
                 |The significand is returned by the function and the exponent is returned in the parameter exp. 
                 |For a floating-point value of zero, the significant and exponent are both zero. 
                 |For a floating-point value that is an infinity or is not a number, the results are undefined.
                 |
                 |[GLSL frexp man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/frexp.xml)
                 |[GLSL 4.20.8 specification, section 8.3 Common Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)"""
        docs(doc)
        val mantXYZW = XyzwJoint { "mant$it" }
        val expXYZW = XyzwJoint { "exp$it" }
        +"fun frexp(resMant: $VecID = $VecID(), resExp: ${vec}i = ${vec}i()) = frexp($xyzw) { $mantXYZW, $expXYZW ->"
        +"\tresMant.put($mantXYZW)"
        +"\tresExp.put($expXYZW)"
        +"}"
        docs(doc)
        +"fun frexp(res: Pair<$VecID, ${vec}i> = $VecID() to ${vec}i()): Pair<$VecID, ${vec}i> = frexp($xyzw) { $mantXYZW, $expXYZW ->"
        +"\tres.first.put($mantXYZW)"
        +"\tres.second.put($expXYZW)"
        +"\tres"
        +"}"
        docs(doc)
        val `mantXZYW type` = XyzwJoint { "mant$it: $type" }
        val `expXYZW type` = XyzwJoint { "exp$it: Int" }
        +"fun <R> frexp(res: ($`mantXZYW type`, $`expXYZW type`) -> R): R = frexp($xyzw, res)"

        // ldexp
        doc = """|Builds a floating-point number from x and the corresponding integral exponent of two in exp, returning:
                 |`significand * exp(2, exponent)`
                 |
                 |If this product is too large to be represented in the floating-point type, the result is undefined.
                 |
                 |[GLSL ldexp man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/ldexp.xml)
                 |[GLSL 4.20.8 specification, section 8.3 Common Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)"""
        docs(doc)
        +"fun ldexpAssign(exp: ${vec}i): $VecID = ldexp(exp, this)"
        docs(doc)
        +"infix fun ldexp(exp: ${vec}i): $VecID = ldexp(exp, $VecID())"
        docs(doc)
        +"fun ldexp(exp: ${vec}i, res: $VecID): $VecID = ldexp(exp) { $resXYZW -> res($resXYZW) }"
        docs(doc)
        "inline fun <R> ldexp(exp: ${vec}i, res: ($`resXYZW type`) -> R): R" {
            contract
            +"return ldexp($xyzw, ${xyzwJoint { "exp.$it" }}, res)"
        }
    }
}