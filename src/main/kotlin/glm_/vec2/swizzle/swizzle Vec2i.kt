package glm_.vec2.swizzle

import glm_.vec2.Vec2i

val Vec2i.xx: Vec2i
    get() = Vec2i(x, x)
var Vec2i.xy: Vec2i
    get() = Vec2i(x, y)
    set(value) = put(value.x, value.y)

var Vec2i.yx: Vec2i
    get() = Vec2i(y, x)
    set(value) = put(value.y, value.x)
val Vec2i.yy: Vec2i
    get() = Vec2i(y, y)


val Vec2i.rr: Vec2i
    get() = Vec2i(r, r)
var Vec2i.rg: Vec2i
    get() = Vec2i(r, g)
    set(value) = put(value.r, value.g)
var Vec2i.gr: Vec2i
    get() = Vec2i(g, r)
    set(value) = put(value.g, value.r)
val Vec2i.gg: Vec2i
    get() = Vec2i(g, g)


val Vec2i.ss: Vec2i
    get() = Vec2i(s, s)
var Vec2i.st: Vec2i
    get() = Vec2i(s, t)
    set(value) = put(value.s, value.t)
var Vec2i.ts: Vec2i
    get() = Vec2i(t, s)
    set(value) = put(value.t, value.s)
val Vec2i.tt: Vec2i
    get() = Vec2i(t, t)