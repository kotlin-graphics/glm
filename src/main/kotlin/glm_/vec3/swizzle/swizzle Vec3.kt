package glm_.vec3.swizzle

import glm_.vec2.Vec2
import glm_.vec3.Vec3

val Vec3.xx: Vec2
    get() = Vec2(x, x)
var Vec3.xy: Vec2
    get() = Vec2(x, y)
    set(value) {
        x = value.x
        y = value.y
    }
var Vec3.xz: Vec2
    get() = Vec2(x, z)
    set(value) {
        x = value.x
        z = value.y
    }
var Vec3.yx: Vec2
    get() = Vec2(y, x)
    set(value) {
        y = value.x
        x = value.y
    }
val Vec3.yy: Vec2
    get() = Vec2(y, y)
var Vec3.yz: Vec2
    get() = Vec2(y, z)
    set(value) {
        y = value.x
        z = value.y
    }
var Vec3.zx: Vec2
    get() = Vec2(z, x)
    set(value) {
        z = value.x
        x = value.y
    }
var Vec3.zy: Vec2
    get() = Vec2(z, y)
    set(value) {
        z = value.x
        y = value.y
    }
val Vec3.zz: Vec2
    get() = Vec2(z, z)


val Vec3.xxx: Vec3
    get() = Vec3(x, x, x)
val Vec3.xxy: Vec3
    get() = Vec3(x, x, y)
val Vec3.xxz: Vec3
    get() = Vec3(x, x, z)
val Vec3.xyx: Vec3
    get() = Vec3(x, y, x)
val Vec3.xyy: Vec3
    get() = Vec3(x, y, y)
var Vec3.xyz: Vec3
    get() = Vec3(x, y, z)
    set(value) = put(value.x, value.y, value.z)
val Vec3.xzx: Vec3
    get() = Vec3(x, z, x)
var Vec3.xzy: Vec3
    get() = Vec3(x, z, y)
    set(value) = put(value.x, value.z, value.y)
val Vec3.xzz: Vec3
    get() = Vec3(x, z, z)

val Vec3.yxx: Vec3
    get() = Vec3(y, x, x)
val Vec3.yxy: Vec3
    get() = Vec3(y, x, y)
var Vec3.yxz: Vec3
    get() = Vec3(y, x, z)
    set(value) = put(value.y, value.x, value.z)
val Vec3.yyx: Vec3
    get() = Vec3(y, y, x)
val Vec3.yyy: Vec3
    get() = Vec3(y, y, y)
val Vec3.yyz: Vec3
    get() = Vec3(y, y, z)
var Vec3.yzx: Vec3
    get() = Vec3(y, z, x)
    set(value) = put(value.y, value.z, value.x)
val Vec3.yzy: Vec3
    get() = Vec3(y, z, y)
val Vec3.yzz: Vec3
    get() = Vec3(y, z, z)

val Vec3.zxx: Vec3
    get() = Vec3(z, x, x)
var Vec3.zxy: Vec3
    get() = Vec3(z, x, y)
    set(value) = put(value.z, value.x, value.y)
val Vec3.zxz: Vec3
    get() = Vec3(z, x, z)
var Vec3.zyx: Vec3
    get() = Vec3(z, y, x)
    set(value) = put(value.z, value.y, value.x)
val Vec3.zyy: Vec3
    get() = Vec3(z, y, y)
val Vec3.zyz: Vec3
    get() = Vec3(z, y, z)
val Vec3.zzx: Vec3
    get() = Vec3(z, z, x)
val Vec3.zzy: Vec3
    get() = Vec3(z, z, y)
val Vec3.zzz: Vec3
    get() = Vec3(z, z, z)