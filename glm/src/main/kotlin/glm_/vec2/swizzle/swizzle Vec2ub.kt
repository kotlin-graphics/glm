package glm_.vec2.swizzle

import glm_.vec2.Vec2ub

val Vec2ub.xx: Vec2ub
    get() = Vec2ub(x, x)
var Vec2ub.xy: Vec2ub
    get() = Vec2ub(x, y)
    set(value) = put(value.x, value.y)

var Vec2ub.yx: Vec2ub
    get() = Vec2ub(y, x)
    set(value) = put(value.y, value.x)
val Vec2ub.yy: Vec2ub
    get() = Vec2ub(y, y)


val Vec2ub.rr: Vec2ub
    get() = Vec2ub(r, r)
var Vec2ub.rg: Vec2ub
    get() = Vec2ub(r, g)
    set(value) = put(value.r, value.g)
var Vec2ub.gr: Vec2ub
    get() = Vec2ub(g, r)
    set(value) = put(value.g, value.r)
val Vec2ub.gg: Vec2ub
    get() = Vec2ub(g, g)


val Vec2ub.ss: Vec2ub
    get() = Vec2ub(s, s)
var Vec2ub.st: Vec2ub
    get() = Vec2ub(s, t)
    set(value) = put(value.s, value.t)
var Vec2ub.ts: Vec2ub
    get() = Vec2ub(t, s)
    set(value) = put(value.t, value.s)
val Vec2ub.tt: Vec2ub
    get() = Vec2ub(t, t)