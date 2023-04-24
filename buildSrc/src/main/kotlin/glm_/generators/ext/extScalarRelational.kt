package glm_.generators.ext

import glm_.generators.floatingPointTypes
import glm_.generators.gen.Generator

fun Generator.extScalarRelational(type: String) {

    +"// ext scalar relational\n"

    if (type !in floatingPointTypes)
        return

    docs("Returns the component-wise comparison of `|this - b| <= epsilon`. True if this expression is satisfied.")
    +"fun $type.equal(b: $type, epsilon: $type): Boolean = (this - b).abs() <= epsilon"

    docs("Returns the component-wise comparison of `|this - b| > epsilon`. True if this expression is not satisfied.")
    +"fun $type.notEqual(b: $type, epsilon: $type): Boolean = (this - b).abs() > epsilon"

    docs("""
        |Returns the component-wise comparison between two scalars in term of ULPs. 
        |True if this expression is satisfied.
        |
        |@receiver First operand.
        |@param b Second operand.
        |@param ulps Maximum difference in ULPs between the two operators to consider them equal.""".trimIndent())
    +"""
        fun $type.equal(b: $type, ulps: Int): Boolean {
            // Different signs means they do not match.
            if(negative != b.negative)
                return false
    
            // Find the difference in ULPs.
            val diffULPs = (toRawBits() - b.toRawBits()).abs()
            return diffULPs <= ulps
        }"""

    docs("""
        |Returns the component-wise comparison between two scalars in term of ULPs.
        |True if this expression is not satisfied.
        |
        |@receiver First operand.
        |@param b Second operand.
        |@param ulps Maximum difference in ULPs between the two operators to consider them not equal.""")
    +"fun $type.notEqual(b: $type, ulps: Int): Boolean = !equal(b, ulps)"
}