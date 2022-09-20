package glm_

fun Generator.geometric(ordinal: Int, type: String, extension: String, id: String, vec: String) {

    +"\n// geometric\n"
    val VecID = vec + id
    if (type in floatingPointTypes) {

        docs("""|Returns the length of this [$VecID], i.e., `sqrt(this * this)`.
                |[GLSL length man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/length.xml)
                |[GLSL 4.20.8 specification, section 8.5 Geometric Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)""")
        +"fun length(): $type = sqrt(this dot this)"

        docs("""|Returns the distance between this [$VecID] and [p], i.e., `length(this - p).`
                |[GLSL distance man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/distance.xml)
                |[GLSL 4.20.8 specification, section 8.5 Geometric Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)""")
        +"infix fun distance(p: $VecID): $type = distance(${xyzwJoint { it }}, ${xyzwJoint { "p.$it" }})"

        docs("""|Returns the dot product of this [$VecID] and [b], i.e., `result = this * b`.
                |[GLSL dot man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/dot.xml)
                |[GLSL 4.20.8 specification, section 8.5 Geometric Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)""")
        +"infix fun dot(b: $VecID): $type = dot(${xyzwJoint { it }}, ${xyzwJoint { "b.$it" }})"

        if (ordinal == 3) {
            docs("""|Returns the cross product of this [$VecID] and [v] in a newly allocated $VecID.
                    |[GLSL cross man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/cross.xml)
                    |[GLSL 4.20.8 specification, section 8.5 Geometric Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)""")
            +"infix fun cross(v: Vec3$id): Vec3$id { cross(x, y, z, v.x, v.z, v.y) { resX, resY, resZ -> return Vec3$id(resX, resY, resZ) } }"
            docs("""|Returns the cross product of this [$VecID] and [v] in [res].
                    |[GLSL cross man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/cross.xml)
                    |[GLSL 4.20.8 specification, section 8.5 Geometric Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)""")
            +"fun cross(v: Vec3$id, res: Vec3$id): Vec3$id { cross(x, y, z, v.x, v.z, v.y) { resX, resY, resZ -> return res(resX, resY, resZ) } }"
        }
        docs("""|Returns a vector in the same direction as this [$VecID] but with length of 1.
                |According to issue 10 GLSL 1.10 specification, if length(x) == 0 then result is undefined and generate an error.
                |[GLSL normalize man page](http://www.opengl.org/sdk/docs/manglsl/xhtml/normalize.xml)
                |[GLSL 4.20.8 specification, section 8.5 Geometric Functions](http://www.opengl.org/registry/doc/GLSLangSpec.4.20.8.pdf)""")
    }
    if (ordinal > 1 && type in numberTypes) {
        +"// Dot products"
        for (unsigned in (unsignedTypes + "out Number")) {
            if (unsigned != "out Number") +"@JvmName(\"dot$unsigned\")"
            +"infix fun dot(v: Vec${ordinal}T<$unsigned>) = (${xyzwJoint(separator = " + ") { "$it * v.$it.$extension" }}).$extension"
        }
    }
}