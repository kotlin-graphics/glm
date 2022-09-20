package glm_

fun Generator.exponential(ordinal: Int, type: String, extension: String, id: String, vec: String) {

    +"\n// exponential\n"

    val VecID = vec + id
    if (type in floatingPointTypes) {

        var docs = """|Returns this [$VecID] base raised to the power [exponent].
                      |
                      |@receiver: Floating point value. pow function is defined for input values of this [$VecID] defined in the range (inf-, inf+) in the limit of the type qualifier.
                      |@param exponent: Floating point value representing the [exponent].
                      |[GLSL pow man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/pow.xml)
                      |[GLSL 4.20.8 specification, section 8.2 Exponential Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)"""
        docs(docs)
        val base = xyzwJoint { it }
        val exponent = xyzwJoint { "exponent.$it" }
        val res = XyzwJoint { "res$it" }
        +"infix fun pow(exponent: $VecID): $VecID { pow($base, $exponent) { $res -> return $VecID($res) } }"
        docs(docs)
        +"fun pow(exponent: $VecID, res: $VecID): $VecID { pow($base, $exponent) { $res -> return res($res) } }"


        docs = """|Returns the natural exponentiation of this [$VecID], i.e., e^x.
                  |
                  |@receiver: exp function is defined for input values of this [$VecID] defined in the range (inf-, inf+) in the limit of the type qualifier.
                  |@param exponent: Floating point value representing the [exponent].
                  |[GLSL exp man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/exp.xml)
                  |[GLSL 4.20.8 specification, section 8.2 Exponential Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)"""
        docs(docs)
        +"fun exp(): $VecID { exp($base) { $res -> return $VecID($res) } }"
        docs(docs)
        +"infix fun exp(res: $VecID): $VecID { exp($base) { $res -> return res($res) } }"


        docs = """|Returns the natural logarithm of this [$VecID], i.e., returns the value y which satisfies the equation x = e^y.
                  |Results are undefined if v <= 0.
                  |
                  |@receiver: log function is defined for input values of v defined in the range (0, inf+) in the limit of the type qualifier.
                  |[GLSL log man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/log.xml)
                  |[GLSL 4.20.8 specification, section 8.2 Exponential Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)"""
        docs(docs)
        +"fun log(): $VecID { log($base) { $res -> return $VecID($res) } }"
        docs(docs)
        +"infix fun log(res: $VecID): $VecID { log($base) { $res -> return res($res) } }"


        docs = """|Returns 2 raised to the this [$VecID] power.
                  |
                  |@receiver: exp2 function is defined for input values of v defined in the range (inf-, inf+) in the limit of the type qualifier.
                  |[GLSL exp2 man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/exp2.xml)
                  |[GLSL 4.20.8 specification, section 8.2 Exponential Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)"""
        docs(docs)
        +"fun exp2(): $VecID { exp2($base) { $res -> return $VecID($res) } }"
        docs(docs)
        +"infix fun exp2(res: $VecID): $VecID { exp2($base) { $res -> return res($res) } }"


        docs = """|Returns the base 2 log of this [$VecID], i.e., returns the value y, which satisfies the equation x = 2 ^ y.
                  |
                  |@receiver: log2 function is defined for input values of v defined in the range (0, inf+) in the limit of the type qualifier.
                  |[GLSL log2 man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/log2.xml)
                  |[GLSL 4.20.8 specification, section 8.2 Exponential Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)"""
        docs(docs)
        +"fun log2(): $VecID { log2($base) { $res -> return $VecID($res) } }"
        docs(docs)
        +"infix fun log2(res: $VecID): $VecID { log2($base) { $res -> return res($res) } }"


        docs = """|Returns the positive square root of this [$VecID].
                  |
                  |@receiver: sqrt function is defined for input values of v defined in the range [0, inf+) in the limit of the type qualifier.
                  |[GLSL sqrt man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/sqrt.xml)
                  |[GLSL 4.20.8 specification, section 8.2 Exponential Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)"""
        docs(docs)
        +"fun sqrt(): $VecID { sqrt($base) { $res -> return $VecID($res) } }"
        docs(docs)
        +"infix fun sqrt(res: $VecID): $VecID { sqrt($base) { $res -> return res($res) } }"


        docs = """|Returns the reciprocal of the positive square root of this [$VecID].
                  |
                  |@receiver: inverseSqrt function is defined for input values of v defined in the range [0, inf+) in the limit of the type qualifier.
                  |[GLSL inversesqrt man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/inversesqrt.xml)
                  |[GLSL 4.20.8 specification, section 8.2 Exponential Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)"""
        docs(docs)
        +"fun inverseSqrt(): $VecID { inverseSqrt($base) { $res -> return $VecID($res) } }"
        docs(docs)
        +"infix fun inverseSqrt(res: $VecID): $VecID { inverseSqrt($base) { $res -> return res($res) } }"
    }
}