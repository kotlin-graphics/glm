package glm

import glm.vec4.Vec4T


class Vec4b(x: Byte) : Vec4T<Byte>(x, x, x, x)

fun main() {
    val c = object : glm.vec1.Vec1T<Float>(3f) {}
    val a = Vec4b(0)

}