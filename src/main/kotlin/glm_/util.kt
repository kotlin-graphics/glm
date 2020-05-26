package glm_

import glm_.vec2.Vec2

// for flags

infix fun Int.has(b: Int): Boolean = and(b) != 0
infix fun Int.hasnt(b: Int): Boolean = and(b) == 0

infix fun Long.has(b: Long): Boolean = and(b) != 0L
infix fun Long.hasnt(b: Long): Boolean = and(b) == 0L