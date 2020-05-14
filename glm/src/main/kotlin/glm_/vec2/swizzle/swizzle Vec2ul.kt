package glm_.vec2.swizzle

import glm_.vec2.Vec2ul

val Vec2ul.xx: Vec2ul
    get() = Vec2ul(x, x)
var Vec2ul.xy: Vec2ul
    get() = Vec2ul(x, y)
    set(value) = put(value.x, value.y)

var Vec2ul.yx: Vec2ul
    get() = Vec2ul(y, x)
    set(value) = put(value.y, value.x)
val Vec2ul.yy: Vec2ul
    get() = Vec2ul(y, y)


val Vec2ul.rr: Vec2ul
    get() = Vec2ul(r, r)
var Vec2ul.rg: Vec2ul
    get() = Vec2ul(r, g)
    set(value) = put(value.r, value.g)
var Vec2ul.gr: Vec2ul
    get() = Vec2ul(g, r)
    set(value) = put(value.g, value.r)
val Vec2ul.gg: Vec2ul
    get() = Vec2ul(g, g)


val Vec2ul.ss: Vec2ul
    get() = Vec2ul(s, s)
var Vec2ul.st: Vec2ul
    get() = Vec2ul(s, t)
    set(value) = put(value.s, value.t)
var Vec2ul.ts: Vec2ul
    get() = Vec2ul(t, s)
    set(value) = put(value.t, value.s)
val Vec2ul.tt: Vec2ul
    get() = Vec2ul(t, t)