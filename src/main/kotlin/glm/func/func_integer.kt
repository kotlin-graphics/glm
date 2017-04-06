package glm.func

import glm.i

/**
 * Created by GBarbieri on 06.04.2017.
 */

interface func_integer {

    fun bitCount(byte: Byte) = java.lang.Integer.bitCount(byte.i)
    fun bitCount(short: Short) = java.lang.Integer.bitCount(short.i)
    fun bitCount(int: Int) = java.lang.Integer.bitCount(int)
    fun bitCount(long: Long) = java.lang.Long.bitCount(long)
}