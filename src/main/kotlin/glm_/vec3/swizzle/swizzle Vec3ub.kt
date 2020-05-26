package glm_.vec3.swizzle

import glm_.vec2.Vec2ub
import glm_.vec3.Vec3ub

val Vec3ub.xx: Vec2ub
    get() = Vec2ub(x, x)
var Vec3ub.xy: Vec2ub
    get() = Vec2ub(x, y)
    set(value) {
        x = value.x
        y = value.y
    }
var Vec3ub.xz: Vec2ub
    get() = Vec2ub(x, z)
    set(value) {
        x = value.x
        z = value.y
    }
var Vec3ub.yx: Vec2ub
    get() = Vec2ub(y, x)
    set(value) {
        y = value.x
        x = value.y
    }
val Vec3ub.yy: Vec2ub
    get() = Vec2ub(y, y)
var Vec3ub.yz: Vec2ub
    get() = Vec2ub(y, z)
    set(value) {
        y = value.x
        z = value.y
    }
var Vec3ub.zx: Vec2ub
    get() = Vec2ub(z, x)
    set(value) {
        z = value.x
        x = value.y
    }
var Vec3ub.zy: Vec2ub
    get() = Vec2ub(z, y)
    set(value) {
        z = value.x
        y = value.y
    }
val Vec3ub.zz: Vec2ub
    get() = Vec2ub(z, z)


val Vec3ub.xxx: Vec3ub
    get() = Vec3ub(x, x, x)
val Vec3ub.xxy: Vec3ub
    get() = Vec3ub(x, x, y)
val Vec3ub.xxz: Vec3ub
    get() = Vec3ub(x, x, z)
val Vec3ub.xyx: Vec3ub
    get() = Vec3ub(x, y, x)
val Vec3ub.xyy: Vec3ub
    get() = Vec3ub(x, y, y)
var Vec3ub.xyz: Vec3ub
    get() = Vec3ub(x, y, z)
    set(value) = put(value.x, value.y, value.z)
val Vec3ub.xzx: Vec3ub
    get() = Vec3ub(x, z, x)
var Vec3ub.xzy: Vec3ub
    get() = Vec3ub(x, z, y)
    set(value) = put(value.x, value.z, value.y)
val Vec3ub.xzz: Vec3ub
    get() = Vec3ub(x, z, z)

val Vec3ub.yxx: Vec3ub
    get() = Vec3ub(y, x, x)
val Vec3ub.yxy: Vec3ub
    get() = Vec3ub(y, x, y)
var Vec3ub.yxz: Vec3ub
    get() = Vec3ub(y, x, z)
    set(value) = put(value.y, value.x, value.z)
val Vec3ub.yyx: Vec3ub
    get() = Vec3ub(y, y, x)
val Vec3ub.yyy: Vec3ub
    get() = Vec3ub(y, y, y)
val Vec3ub.yyz: Vec3ub
    get() = Vec3ub(y, y, z)
var Vec3ub.yzx: Vec3ub
    get() = Vec3ub(y, z, x)
    set(value) = put(value.y, value.z, value.x)
val Vec3ub.yzy: Vec3ub
    get() = Vec3ub(y, z, y)
val Vec3ub.yzz: Vec3ub
    get() = Vec3ub(y, z, z)

val Vec3ub.zxx: Vec3ub
    get() = Vec3ub(z, x, x)
var Vec3ub.zxy: Vec3ub
    get() = Vec3ub(z, x, y)
    set(value) = put(value.z, value.x, value.y)
val Vec3ub.zxz: Vec3ub
    get() = Vec3ub(z, x, z)
var Vec3ub.zyx: Vec3ub
    get() = Vec3ub(z, y, x)
    set(value) = put(value.z, value.y, value.x)
val Vec3ub.zyy: Vec3ub
    get() = Vec3ub(z, y, y)
val Vec3ub.zyz: Vec3ub
    get() = Vec3ub(z, y, z)
val Vec3ub.zzx: Vec3ub
    get() = Vec3ub(z, z, x)
val Vec3ub.zzy: Vec3ub
    get() = Vec3ub(z, z, y)
val Vec3ub.zzz: Vec3ub
    get() = Vec3ub(z, z, z)