package glm_

interface packing {

    fun float2half(f: Int): Short {
        /*  10 bits    =>                         EE EEEFFFFF
            11 bits    =>                        EEE EEFFFFFF
            Half bits  =>                   SEEEEEFF FFFFFFFF
            Float bits => SEEEEEEE EFFFFFFF FFFFFFFF FFFFFFFF

            0x00007c00 => 00000000 00000000 01111100 00000000
            0x000003ff => 00000000 00000000 00000011 11111111
            0x38000000 => 00111000 00000000 00000000 00000000
            0x7f800000 => 01111111 10000000 00000000 00000000
            0x00008000 => 00000000 00000000 10000000 00000000   */
        val sign = (f ushr 16) and 0x8000
        val exponential = (((f and 0x7f800000) - 0x38000000) ushr 13) and 0x7c00
        val mantissa = (f ushr 13) and 0x03ff
        return (sign or exponential or mantissa).s
    }

    fun float2packed11(f: Int): Int {
        /*  10 bits    =>                         EE EEEFFFFF
            11 bits    =>                        EEE EEFFFFFF
            Half bits  =>                   SEEEEEFF FFFFFFFF
            Float bits => SEEEEEEE EFFFFFFF FFFFFFFF FFFFFFFF

            0x000007c0 => 00000000 00000000 00000111 11000000
            0x00007c00 => 00000000 00000000 01111100 00000000
            0x000003ff => 00000000 00000000 00000011 11111111
            0x38000000 => 00111000 00000000 00000000 00000000
            0x7f800000 => 01111111 10000000 00000000 00000000
            0x00008000 => 00000000 00000000 10000000 00000000   */
        val exponential = (((f and 0x7f800000) - 0x38000000) ushr 17) and 0x07c0
        val mantissa = (f ushr 17) and 0x003f
        return exponential or mantissa
    }

    fun packed11ToFloat(p: Int): Int {
        /*  10 bits    =>                         EE EEEFFFFF
            11 bits    =>                        EEE EEFFFFFF
            Half bits  =>                   SEEEEEFF FFFFFFFF
            Float bits => SEEEEEEE EFFFFFFF FFFFFFFF FFFFFFFF

            0x000007c0 => 00000000 00000000 00000111 11000000
            0x00007c00 => 00000000 00000000 01111100 00000000
            0x000003ff => 00000000 00000000 00000011 11111111
            0x38000000 => 00111000 00000000 00000000 00000000
            0x7f800000 => 01111111 10000000 00000000 00000000
            0x00008000 => 00000000 00000000 10000000 00000000   */
        val exponential = (((p and 0x07c0) shl 17) + 0x38000000) and 0x7f800000
        val mantissa = (p and 0x003f) shl 17
        return exponential or mantissa
    }

    fun float2packed10(f: Int): Int {
        /*  10 bits    =>                         EE EEEFFFFF
            11 bits    =>                        EEE EEFFFFFF
            Half bits  =>                   SEEEEEFF FFFFFFFF
            Float bits => SEEEEEEE EFFFFFFF FFFFFFFF FFFFFFFF

            0x0000001F => 00000000 00000000 00000000 00011111
            0x0000003F => 00000000 00000000 00000000 00111111
            0x000003E0 => 00000000 00000000 00000011 11100000
            0x000007C0 => 00000000 00000000 00000111 11000000
            0x00007C00 => 00000000 00000000 01111100 00000000
            0x000003FF => 00000000 00000000 00000011 11111111
            0x38000000 => 00111000 00000000 00000000 00000000
            0x7f800000 => 01111111 10000000 00000000 00000000
            0x00008000 => 00000000 00000000 10000000 00000000   */
        val exponential = (((f and 0x7f800000) - 0x38000000) ushr 18) and 0x03E0
        val mantissa = (f ushr 18) and 0x001f
        return exponential or mantissa
    }

    fun packed10ToFloat(p: Int): Int {
        /*  10 bits    =>                         EE EEEFFFFF
            11 bits    =>                        EEE EEFFFFFF
            Half bits  =>                   SEEEEEFF FFFFFFFF
            Float bits => SEEEEEEE EFFFFFFF FFFFFFFF FFFFFFFF

            0x0000001F => 00000000 00000000 00000000 00011111
            0x0000003F => 00000000 00000000 00000000 00111111
            0x000003E0 => 00000000 00000000 00000011 11100000
            0x000007C0 => 00000000 00000000 00000111 11000000
            0x00007C00 => 00000000 00000000 01111100 00000000
            0x000003FF => 00000000 00000000 00000011 11111111
            0x38000000 => 00111000 00000000 00000000 00000000
            0x7f800000 => 01111111 10000000 00000000 00000000
            0x00008000 => 00000000 00000000 10000000 00000000   */
        val exponential = (((p and 0x03E0) shl 18) + 0x38000000) and 0x7f800000
        val mantissa = (p and 0x001f) shl 18
        return exponential or mantissa
    }

    fun half2float(h: Int) = ((h and 0x8000) shl 16) or (((h and 0x7c00) + 0x1C000) shl 13) or ((h and 0x03FF) shl 13)
}