package glm_

import kotlin.test.Test

class FloatConsts {

    @Test
    fun static() {
        // verify bit masks cover all bit positions and that the bit
        // masks are non-overlapping
        assert(Float.SIGN_BIT_MASK or Float.EXP_BIT_MASK or Float.SIGNIF_BIT_MASK == 0.inv())
        assert(Float.SIGN_BIT_MASK and Float.EXP_BIT_MASK == 0)
        assert(Float.SIGN_BIT_MASK and Float.SIGNIF_BIT_MASK == 0)
        assert(Float.EXP_BIT_MASK and Float.SIGNIF_BIT_MASK == 0)
    }
}