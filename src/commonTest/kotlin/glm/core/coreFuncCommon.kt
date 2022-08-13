package glm.core

import glm.assert
import kotlin.math.sign
import kotlin.test.Test

class int {

    @Test
    fun testInt() {
        val value = intArrayOf(Int.MAX_VALUE, Int.MIN_VALUE, +0, +1, +2, +3, -1, -2, -3)
        val result = intArrayOf(+1, -1, +0, +1, +1, +1, -1, -1, -1)

        for (i in value.indices)
            assert(value[i].sign == result[i])
        //
        //        for(std::size_t i = 0; i < sizeof(Data) / sizeof(type<glm::int32>); ++i)
        //        {
        //            glm::int32 Result = sign_cmp(Data[i].Value);
        //            Error += Data[i].Return == Result ? 0 : 1;
        //        }
        //
        //        for(std::size_t i = 0; i < sizeof(Data) / sizeof(type<glm::int32>); ++i)
        //        {
        //            glm::int32 Result = sign_if(Data[i].Value);
        //            Error += Data[i].Return == Result ? 0 : 1;
        //        }
        //
        //        for(std::size_t i = 0; i < sizeof(Data) / sizeof(type<glm::int32>); ++i)
        //        {
        //            glm::int32 Result = sign_alu1(Data[i].Value);
        //            Error += Data[i].Return == Result ? 0 : 1;
        //        }
        //
        //        for(std::size_t i = 0; i < sizeof(Data) / sizeof(type<glm::int32>); ++i)
        //        {
        //            glm::int32 Result = sign_alu2(Data[i].Value);
        //            Error += Data[i].Return == Result ? 0 : 1;
        //        }
    }
}