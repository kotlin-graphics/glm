package glm_.vec2.swizzle

import glm_.vec2.Vec2s

val Vec2s.xx: Vec2s
    get() = Vec2s(x, x)
var Vec2s.xy: Vec2s
    get() = Vec2s(x, y)
    set(value) = put(value.x, value.y)

var Vec2s.yx: Vec2s
    get() = Vec2s(y, x)
    set(value) = put(value.y, value.x)
val Vec2s.yy: Vec2s
    get() = Vec2s(y, y)


val Vec2s.rr: Vec2s
    get() = Vec2s(r, r)
var Vec2s.rg: Vec2s
    get() = Vec2s(r, g)
    set(value) = put(value.r, value.g)
var Vec2s.gr: Vec2s
    get() = Vec2s(g, r)
    set(value) = put(value.g, value.r)
val Vec2s.gg: Vec2s
    get() = Vec2s(g, g)


val Vec2s.ss: Vec2s
    get() = Vec2s(s, s)
var Vec2s.st: Vec2s
    get() = Vec2s(s, t)
    set(value) = put(value.s, value.t)
var Vec2s.ts: Vec2s
    get() = Vec2s(t, s)
    set(value) = put(value.t, value.s)
val Vec2s.tt: Vec2s
    get() = Vec2s(t, t)