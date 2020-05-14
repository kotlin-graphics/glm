package glm_.vec2.swizzle

import glm_.vec2.Vec2d

val Vec2d.xx: Vec2d
    get() = Vec2d(x, x)
var Vec2d.xy: Vec2d
    get() = Vec2d(x, y)
    set(value) = put(value.x, value.y)

var Vec2d.yx: Vec2d
    get() = Vec2d(y, x)
    set(value) = put(value.y, value.x)
val Vec2d.yy: Vec2d
    get() = Vec2d(y, y)


val Vec2d.rr: Vec2d
    get() = Vec2d(r, r)
var Vec2d.rg: Vec2d
    get() = Vec2d(r, g)
    set(value) = put(value.r, value.g)
var Vec2d.gr: Vec2d
    get() = Vec2d(g, r)
    set(value) = put(value.g, value.r)
val Vec2d.gg: Vec2d
    get() = Vec2d(g, g)


val Vec2d.ss: Vec2d
    get() = Vec2d(s, s)
var Vec2d.st: Vec2d
    get() = Vec2d(s, t)
    set(value) = put(value.s, value.t)
var Vec2d.ts: Vec2d
    get() = Vec2d(t, s)
    set(value) = put(value.t, value.s)
val Vec2d.tt: Vec2d
    get() = Vec2d(t, t)