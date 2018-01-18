package glm_.gtx

interface gtxInteger {

    // TODO others

    /** factorial (!12 max, integer only)   */
    fun factorial(x: Int): Int {
        var temp = x
        var result = 1
        while(temp > 1) {
            result *= temp
            --temp
        }
        return result
    }
}