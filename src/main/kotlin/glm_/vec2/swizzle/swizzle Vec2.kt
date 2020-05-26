package glm_.vec2.swizzle

import glm_.vec2.Vec2


val Vec2.xx: Vec2
    get() = Vec2(x, x)
var Vec2.xy: Vec2
    get() = Vec2(x, y)
    set(value) = put(value.x, value.y)

var Vec2.yx: Vec2
    get() = Vec2(y, x)
    set(value) = put(value.y, value.x)
val Vec2.yy: Vec2
    get() = Vec2(y, y)


val Vec2.rr: Vec2
    get() = Vec2(r, r)
var Vec2.rg: Vec2
    get() = Vec2(r, g)
    set(value) = put(value.r, value.g)
var Vec2.gr: Vec2
    get() = Vec2(g, r)
    set(value) = put(value.g, value.r)
val Vec2.gg: Vec2
    get() = Vec2(g, g)


val Vec2.ss: Vec2
    get() = Vec2(s, s)
var Vec2.st: Vec2
    get() = Vec2(s, t)
    set(value) = put(value.s, value.t)
var Vec2.ts: Vec2
    get() = Vec2(t, s)
    set(value) = put(value.t, value.s)
val Vec2.tt: Vec2
    get() = Vec2(t, t)