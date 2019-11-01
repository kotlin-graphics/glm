package glm_.vec2.swizzle

import glm_.vec2.Vec2b

val Vec2b.xx: Vec2b
    get() = Vec2b(x, x)
var Vec2b.xy: Vec2b
    get() = Vec2b(x, y)
    set(value) = put(value.x, value.y)

var Vec2b.yx: Vec2b
    get() = Vec2b(y, x)
    set(value) = put(value.y, value.x)
val Vec2b.yy: Vec2b
    get() = Vec2b(y, y)


val Vec2b.rr: Vec2b
    get() = Vec2b(r, r)
var Vec2b.rg: Vec2b
    get() = Vec2b(r, g)
    set(value) = put(value.r, value.g)
var Vec2b.gr: Vec2b
    get() = Vec2b(g, r)
    set(value) = put(value.g, value.r)
val Vec2b.gg: Vec2b
    get() = Vec2b(g, g)


val Vec2b.ss: Vec2b
    get() = Vec2b(s, s)
var Vec2b.st: Vec2b
    get() = Vec2b(s, t)
    set(value) = put(value.s, value.t)
var Vec2b.ts: Vec2b
    get() = Vec2b(t, s)
    set(value) = put(value.t, value.s)
val Vec2b.tt: Vec2b
    get() = Vec2b(t, t)