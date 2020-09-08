package glm_

// for flags

infix fun Byte.has(i: Int): Boolean = toInt().has(i)

infix fun Int.has(other: Int): Boolean = and(other) != 0
infix fun Int.hasnt(other: Int): Boolean = and(other) == 0
infix fun Int.wo(other: Int): Int = and(other.inv())

infix fun Long.has(other: Long): Boolean = and(other) != 0L
infix fun Long.hasnt(other: Long): Boolean = and(other) == 0L
infix fun Long.wo(other: Long): Long = and(other.inv())
