package glm_.vec3.swizzle

import glm_.vec2.Vec2l
import glm_.vec3.Vec3l

val Vec3l.xx: Vec2l
    get() = Vec2l(x, x)
var Vec3l.xy: Vec2l
    get() = Vec2l(x, y)
    set(value) {
        x = value.x
        y = value.y
    }
var Vec3l.xz: Vec2l
    get() = Vec2l(x, z)
    set(value) {
        x = value.x
        z = value.y
    }
var Vec3l.yx: Vec2l
    get() = Vec2l(y, x)
    set(value) {
        y = value.x
        x = value.y
    }
val Vec3l.yy: Vec2l
    get() = Vec2l(y, y)
var Vec3l.yz: Vec2l
    get() = Vec2l(y, z)
    set(value) {
        y = value.x
        z = value.y
    }
var Vec3l.zx: Vec2l
    get() = Vec2l(z, x)
    set(value) {
        z = value.x
        x = value.y
    }
var Vec3l.zy: Vec2l
    get() = Vec2l(z, y)
    set(value) {
        z = value.x
        y = value.y
    }
val Vec3l.zz: Vec2l
    get() = Vec2l(z, z)


val Vec3l.xxx: Vec3l
    get() = Vec3l(x, x, x)
val Vec3l.xxy: Vec3l
    get() = Vec3l(x, x, y)
val Vec3l.xxz: Vec3l
    get() = Vec3l(x, x, z)
val Vec3l.xyx: Vec3l
    get() = Vec3l(x, y, x)
val Vec3l.xyy: Vec3l
    get() = Vec3l(x, y, y)
var Vec3l.xyz: Vec3l
    get() = Vec3l(x, y, z)
    set(value) = put(value.x, value.y, value.z)
val Vec3l.xzx: Vec3l
    get() = Vec3l(x, z, x)
var Vec3l.xzy: Vec3l
    get() = Vec3l(x, z, y)
    set(value) = put(value.x, value.z, value.y)
val Vec3l.xzz: Vec3l
    get() = Vec3l(x, z, z)

val Vec3l.yxx: Vec3l
    get() = Vec3l(y, x, x)
val Vec3l.yxy: Vec3l
    get() = Vec3l(y, x, y)
var Vec3l.yxz: Vec3l
    get() = Vec3l(y, x, z)
    set(value) = put(value.y, value.x, value.z)
val Vec3l.yyx: Vec3l
    get() = Vec3l(y, y, x)
val Vec3l.yyy: Vec3l
    get() = Vec3l(y, y, y)
val Vec3l.yyz: Vec3l
    get() = Vec3l(y, y, z)
var Vec3l.yzx: Vec3l
    get() = Vec3l(y, z, x)
    set(value) = put(value.y, value.z, value.x)
val Vec3l.yzy: Vec3l
    get() = Vec3l(y, z, y)
val Vec3l.yzz: Vec3l
    get() = Vec3l(y, z, z)

val Vec3l.zxx: Vec3l
    get() = Vec3l(z, x, x)
var Vec3l.zxy: Vec3l
    get() = Vec3l(z, x, y)
    set(value) = put(value.z, value.x, value.y)
val Vec3l.zxz: Vec3l
    get() = Vec3l(z, x, z)
var Vec3l.zyx: Vec3l
    get() = Vec3l(z, y, x)
    set(value) = put(value.z, value.y, value.x)
val Vec3l.zyy: Vec3l
    get() = Vec3l(z, y, y)
val Vec3l.zyz: Vec3l
    get() = Vec3l(z, y, z)
val Vec3l.zzx: Vec3l
    get() = Vec3l(z, z, x)
val Vec3l.zzy: Vec3l
    get() = Vec3l(z, z, y)
val Vec3l.zzz: Vec3l
    get() = Vec3l(z, z, z)