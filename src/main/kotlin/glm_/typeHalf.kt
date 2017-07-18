package glm_

import unsigned.toUInt
import unsigned.ushr

interface typeHalf {

    fun toFloat32(value: Short): Float {

        val s = ((value ushr 15) and 0x00000001).toUInt()
        var e = ((value ushr 10) and 0x0000001f).toUInt()
        var m = (value and 0x000003ff).toUInt()

        if (e == 0) {

            if (m == 0)

            // Plus or minus zero

                return glm.intBitsToFloat(s shl 31)
            else {

                // Denormalized number -- renormalize it

                while ((m and 0x00000400) == 0) {
                    m = m shl 1
                    e -= 1
                }

                e += 1
                m = m and 0x00000400.inv()
            }

        } else if (e == 31)

            if (m == 0)

            // Positive or negative infinity

                return glm.intBitsToFloat((s shl 31) or 0x7f800000)
            else

            // Nan -- preserve sign and significand bits

                return glm.intBitsToFloat((s shl 31) or 0x7f800000 or (m shl 13))

        // Normalized number

        e += 127 - 15
        m = m shl 13

        // Assemble s, e and m.

        return glm.intBitsToFloat((s shl 31) or (e shl 23) or m)
    }

    fun toFloat16(f: Float): Short {

        val i = glm.floatBitsToInt(f)

        /*  Our floating point number, f, is represented by the bit pattern in integer i.  Disassemble that bit pattern
            into the sign, s, the exponent, e, and the significand, m.
            Shift s into the position where it will go in in the resulting half number.
            Adjust e, accounting for the different exponent bias of float and half (127 versus 15). */

        val s = (i ushr 16) and 0x00008000
        var e = ((i ushr 23) and 0x000000ff) - (127 - 15)
        var m = i and 0x007fffff

        // Now reassemble s, e and m into a half:

        if (e <= 0) {

            if (e < -10)

            /*  E is less than -10.  The absolute value of f is less than half_MIN (f may be a small normalized
                float, a denormalized float or a zero).
                We convert f to a half zero.    */

                return s.s

            /*  E is between -10 and 0.  F is a normalized float, whose magnitude is less than __half_NRM_MIN.
                We convert f to a denormalized half.    */

            m = (m or 0x00800000) ushr (1 - e)

            /*  Round to nearest, round "0.5" up.
                Rounding may cause the significand to overflow and make our number normalized.  Because of the way a
                half's bits are laid out, we don't have to treat this case separately; the code below will handle it
                correctly.    */

            if ((m and 0x00001000) != 0)
                m += 0x00002000

            // Assemble the half from s, e (zero) and m.

            return (s or (m ushr 13)).s

        } else if (e == 0xff - (127 - 15))

            if (m == 0) {

                //  F is an infinity; convert f to a half infinity with the same sign as f.
                return (s or 0x7c00).s

            } else {

                /*  F is a NAN; we produce a half NAN that preserves the sign bit and the 10 leftmost bits of the
                    significand of f, with one exception: If the 10 leftmost bits are all zero, the NAN would turn into
                    an infinity, so we have to set at least one bit in the significand. */

                m = m ushr 13

                return (s or 0x7c00 or m or (if (m == 0) 1 else 0)).s
            }
        else {

            /*  E is greater than zero.  F is a normalized float.
                We try to convert f to a normalized half.             */

            // Round to nearest, round "0.5" up

            if ((m and 0x00001000) != 0) {

                m += 0x00002000

                if ((m and 0x00800000) != 0) {

                    m = 0   // overflow in significand,
                    e += 1  // adjust exponent
                }
            }

            // Handle exponent overflow

            if (e > 30) {

                System.err.println("overflow")//                overflow()        // Cause a hardware floating point overflow;

                return (s or 0x7c00).s  // if this returns, the half becomes an infinity with the same sign as f.
            }

            // Assemble the half from s, e and m.

            return (s or (e shl 10) or (m ushr 13)).s
        }
    }
}