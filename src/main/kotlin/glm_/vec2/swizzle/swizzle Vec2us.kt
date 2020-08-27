package glm_.vec2.swizzle

import glm_.vec2.Vec2us

val Vec2us.xx: Vec2us
    get() = Vec2us(x, x)
var Vec2us.xy: Vec2us
    get() = Vec2us(x, y)
    set(value) = put(value.x, value.y)

var Vec2us.yx: Vec2us
    get() = Vec2us(y, x)
    set(value) = put(value.y, value.x)
val Vec2us.yy: Vec2us
    get() = Vec2us(y, y)


val Vec2us.rr: Vec2us
    get() = Vec2us(r, r)
var Vec2us.rg: Vec2us
    get() = Vec2us(r, g)
    set(value) = put(value.r, value.g)
var Vec2us.gr: Vec2us
    get() = Vec2us(g, r)
    set(value) = put(value.g, value.r)
val Vec2us.gg: Vec2us
    get() = Vec2us(g, g)


val Vec2us.ss: Vec2us
    get() = Vec2us(s, s)
var Vec2us.st: Vec2us
    get() = Vec2us(s, t)
    set(value) = put(value.s, value.t)
var Vec2us.ts: Vec2us
    get() = Vec2us(t, s)
    set(value) = put(value.t, value.s)
val Vec2us.tt: Vec2us
    get() = Vec2us(t, t)