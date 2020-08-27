package glm_.vec3.swizzle

import glm_.vec2.Vec2b
import glm_.vec3.Vec3b

val Vec3b.xx: Vec2b
    get() = Vec2b(x, x)
var Vec3b.xy: Vec2b
    get() = Vec2b(x, y)
    set(value) {
        x = value.x
        y = value.y
    }
var Vec3b.xz: Vec2b
    get() = Vec2b(x, z)
    set(value) {
        x = value.x
        z = value.y
    }
var Vec3b.yx: Vec2b
    get() = Vec2b(y, x)
    set(value) {
        y = value.x
        x = value.y
    }
val Vec3b.yy: Vec2b
    get() = Vec2b(y, y)
var Vec3b.yz: Vec2b
    get() = Vec2b(y, z)
    set(value) {
        y = value.x
        z = value.y
    }
var Vec3b.zx: Vec2b
    get() = Vec2b(z, x)
    set(value) {
        z = value.x
        x = value.y
    }
var Vec3b.zy: Vec2b
    get() = Vec2b(z, y)
    set(value) {
        z = value.x
        y = value.y
    }
val Vec3b.zz: Vec2b
    get() = Vec2b(z, z)


val Vec3b.xxx: Vec3b
    get() = Vec3b(x, x, x)
val Vec3b.xxy: Vec3b
    get() = Vec3b(x, x, y)
val Vec3b.xxz: Vec3b
    get() = Vec3b(x, x, z)
val Vec3b.xyx: Vec3b
    get() = Vec3b(x, y, x)
val Vec3b.xyy: Vec3b
    get() = Vec3b(x, y, y)
var Vec3b.xyz: Vec3b
    get() = Vec3b(x, y, z)
    set(value) = put(value.x, value.y, value.z)
val Vec3b.xzx: Vec3b
    get() = Vec3b(x, z, x)
var Vec3b.xzy: Vec3b
    get() = Vec3b(x, z, y)
    set(value) = put(value.x, value.z, value.y)
val Vec3b.xzz: Vec3b
    get() = Vec3b(x, z, z)

val Vec3b.yxx: Vec3b
    get() = Vec3b(y, x, x)
val Vec3b.yxy: Vec3b
    get() = Vec3b(y, x, y)
var Vec3b.yxz: Vec3b
    get() = Vec3b(y, x, z)
    set(value) = put(value.y, value.x, value.z)
val Vec3b.yyx: Vec3b
    get() = Vec3b(y, y, x)
val Vec3b.yyy: Vec3b
    get() = Vec3b(y, y, y)
val Vec3b.yyz: Vec3b
    get() = Vec3b(y, y, z)
var Vec3b.yzx: Vec3b
    get() = Vec3b(y, z, x)
    set(value) = put(value.y, value.z, value.x)
val Vec3b.yzy: Vec3b
    get() = Vec3b(y, z, y)
val Vec3b.yzz: Vec3b
    get() = Vec3b(y, z, z)

val Vec3b.zxx: Vec3b
    get() = Vec3b(z, x, x)
var Vec3b.zxy: Vec3b
    get() = Vec3b(z, x, y)
    set(value) = put(value.z, value.x, value.y)
val Vec3b.zxz: Vec3b
    get() = Vec3b(z, x, z)
var Vec3b.zyx: Vec3b
    get() = Vec3b(z, y, x)
    set(value) = put(value.z, value.y, value.x)
val Vec3b.zyy: Vec3b
    get() = Vec3b(z, y, y)
val Vec3b.zyz: Vec3b
    get() = Vec3b(z, y, z)
val Vec3b.zzx: Vec3b
    get() = Vec3b(z, z, x)
val Vec3b.zzy: Vec3b
    get() = Vec3b(z, z, y)
val Vec3b.zzz: Vec3b
    get() = Vec3b(z, z, z)