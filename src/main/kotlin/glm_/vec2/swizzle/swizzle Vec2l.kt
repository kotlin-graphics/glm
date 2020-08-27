package glm_.vec2.swizzle

import glm_.vec2.Vec2l

val Vec2l.xx: Vec2l
    get() = Vec2l(x, x)
var Vec2l.xy: Vec2l
    get() = Vec2l(x, y)
    set(value) = put(value.x, value.y)

var Vec2l.yx: Vec2l
    get() = Vec2l(y, x)
    set(value) = put(value.y, value.x)
val Vec2l.yy: Vec2l
    get() = Vec2l(y, y)


val Vec2l.rr: Vec2l
    get() = Vec2l(r, r)
var Vec2l.rg: Vec2l
    get() = Vec2l(r, g)
    set(value) = put(value.r, value.g)
var Vec2l.gr: Vec2l
    get() = Vec2l(g, r)
    set(value) = put(value.g, value.r)
val Vec2l.gg: Vec2l
    get() = Vec2l(g, g)


val Vec2l.ss: Vec2l
    get() = Vec2l(s, s)
var Vec2l.st: Vec2l
    get() = Vec2l(s, t)
    set(value) = put(value.s, value.t)
var Vec2l.ts: Vec2l
    get() = Vec2l(t, s)
    set(value) = put(value.t, value.s)
val Vec2l.tt: Vec2l
    get() = Vec2l(t, t)