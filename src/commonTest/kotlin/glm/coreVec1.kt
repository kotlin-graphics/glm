package glm

import glm.vec1.Vec1i
import kotlin.test.Test

class coreVec1 {

    @Test
    fun `vec1 operators`() {

        val a = Vec1i(1)
        val b = Vec1i(1)
        run {
            val r = a != b
            val s = a == b

            assert(s && !r)
        }

        run {
            a *= 1
            b *= 1
            a += 1
            b += 1

            val r = a != b
            val s = a == b

            assert(s && !r)
        }
    }
}