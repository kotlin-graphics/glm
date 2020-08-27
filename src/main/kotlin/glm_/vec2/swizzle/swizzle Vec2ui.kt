package glm_.vec2.swizzle

import glm_.vec2.Vec2ui

val Vec2ui.xx: Vec2ui
    get() = Vec2ui(x, x)
var Vec2ui.xy: Vec2ui
    get() = Vec2ui(x, y)
    set(value) = put(value.x, value.y)

var Vec2ui.yx: Vec2ui
    get() = Vec2ui(y, x)
    set(value) = put(value.y, value.x)
val Vec2ui.yy: Vec2ui
    get() = Vec2ui(y, y)


val Vec2ui.rr: Vec2ui
    get() = Vec2ui(r, r)
var Vec2ui.rg: Vec2ui
    get() = Vec2ui(r, g)
    set(value) = put(value.r, value.g)
var Vec2ui.gr: Vec2ui
    get() = Vec2ui(g, r)
    set(value) = put(value.g, value.r)
val Vec2ui.gg: Vec2ui
    get() = Vec2ui(g, g)


val Vec2ui.ss: Vec2ui
    get() = Vec2ui(s, s)
var Vec2ui.st: Vec2ui
    get() = Vec2ui(s, t)
    set(value) = put(value.s, value.t)
var Vec2ui.ts: Vec2ui
    get() = Vec2ui(t, s)
    set(value) = put(value.t, value.s)
val Vec2ui.tt: Vec2ui
    get() = Vec2ui(t, t)