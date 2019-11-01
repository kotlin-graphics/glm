package glm_.vec3.swizzle

import glm_.vec2.Vec2ui
import glm_.vec3.Vec3ui

val Vec3ui.xx: Vec2ui
    get() = Vec2ui(x, x)
var Vec3ui.xy: Vec2ui
    get() = Vec2ui(x, y)
    set(value) {
        x = value.x
        y = value.y
    }
var Vec3ui.xz: Vec2ui
    get() = Vec2ui(x, z)
    set(value) {
        x = value.x
        z = value.y
    }
var Vec3ui.yx: Vec2ui
    get() = Vec2ui(y, x)
    set(value) {
        y = value.x
        x = value.y
    }
val Vec3ui.yy: Vec2ui
    get() = Vec2ui(y, y)
var Vec3ui.yz: Vec2ui
    get() = Vec2ui(y, z)
    set(value) {
        y = value.x
        z = value.y
    }
var Vec3ui.zx: Vec2ui
    get() = Vec2ui(z, x)
    set(value) {
        z = value.x
        x = value.y
    }
var Vec3ui.zy: Vec2ui
    get() = Vec2ui(z, y)
    set(value) {
        z = value.x
        y = value.y
    }
val Vec3ui.zz: Vec2ui
    get() = Vec2ui(z, z)


val Vec3ui.xxx: Vec3ui
    get() = Vec3ui(x, x, x)
val Vec3ui.xxy: Vec3ui
    get() = Vec3ui(x, x, y)
val Vec3ui.xxz: Vec3ui
    get() = Vec3ui(x, x, z)
val Vec3ui.xyx: Vec3ui
    get() = Vec3ui(x, y, x)
val Vec3ui.xyy: Vec3ui
    get() = Vec3ui(x, y, y)
var Vec3ui.xyz: Vec3ui
    get() = Vec3ui(x, y, z)
    set(value) = put(value.x, value.y, value.z)
val Vec3ui.xzx: Vec3ui
    get() = Vec3ui(x, z, x)
var Vec3ui.xzy: Vec3ui
    get() = Vec3ui(x, z, y)
    set(value) = put(value.x, value.z, value.y)
val Vec3ui.xzz: Vec3ui
    get() = Vec3ui(x, z, z)

val Vec3ui.yxx: Vec3ui
    get() = Vec3ui(y, x, x)
val Vec3ui.yxy: Vec3ui
    get() = Vec3ui(y, x, y)
var Vec3ui.yxz: Vec3ui
    get() = Vec3ui(y, x, z)
    set(value) = put(value.y, value.x, value.z)
val Vec3ui.yyx: Vec3ui
    get() = Vec3ui(y, y, x)
val Vec3ui.yyy: Vec3ui
    get() = Vec3ui(y, y, y)
val Vec3ui.yyz: Vec3ui
    get() = Vec3ui(y, y, z)
var Vec3ui.yzx: Vec3ui
    get() = Vec3ui(y, z, x)
    set(value) = put(value.y, value.z, value.x)
val Vec3ui.yzy: Vec3ui
    get() = Vec3ui(y, z, y)
val Vec3ui.yzz: Vec3ui
    get() = Vec3ui(y, z, z)

val Vec3ui.zxx: Vec3ui
    get() = Vec3ui(z, x, x)
var Vec3ui.zxy: Vec3ui
    get() = Vec3ui(z, x, y)
    set(value) = put(value.z, value.x, value.y)
val Vec3ui.zxz: Vec3ui
    get() = Vec3ui(z, x, z)
var Vec3ui.zyx: Vec3ui
    get() = Vec3ui(z, y, x)
    set(value) = put(value.z, value.y, value.x)
val Vec3ui.zyy: Vec3ui
    get() = Vec3ui(z, y, y)
val Vec3ui.zyz: Vec3ui
    get() = Vec3ui(z, y, z)
val Vec3ui.zzx: Vec3ui
    get() = Vec3ui(z, z, x)
val Vec3ui.zzy: Vec3ui
    get() = Vec3ui(z, z, y)
val Vec3ui.zzz: Vec3ui
    get() = Vec3ui(z, z, z)