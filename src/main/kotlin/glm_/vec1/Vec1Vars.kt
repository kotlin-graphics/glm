package glm_.vec1

interface Vec1Vars<T : Number> {
    var x: T

    operator fun component1() = x


    // -- Component accesses --

    operator fun get(index: Int) = when (index) {
        0 -> x
        else -> throw IndexOutOfBoundsException()
    }
}