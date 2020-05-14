package glm_.vec3.swizzle

import glm_.vec2.Vec2d
import glm_.vec3.Vec3d

val Vec3d.xx: Vec2d
    get() = Vec2d(x, x)
var Vec3d.xy: Vec2d
    get() = Vec2d(x, y)
    set(value) {
        x = value.x
        y = value.y
    }
var Vec3d.xz: Vec2d
    get() = Vec2d(x, z)
    set(value) {
        x = value.x
        z = value.y
    }
var Vec3d.yx: Vec2d
    get() = Vec2d(y, x)
    set(value) {
        y = value.x
        x = value.y
    }
val Vec3d.yy: Vec2d
    get() = Vec2d(y, y)
var Vec3d.yz: Vec2d
    get() = Vec2d(y, z)
    set(value) {
        y = value.x
        z = value.y
    }
var Vec3d.zx: Vec2d
    get() = Vec2d(z, x)
    set(value) {
        z = value.x
        x = value.y
    }
var Vec3d.zy: Vec2d
    get() = Vec2d(z, y)
    set(value) {
        z = value.x
        y = value.y
    }
val Vec3d.zz: Vec2d
    get() = Vec2d(z, z)


val Vec3d.xxx: Vec3d
    get() = Vec3d(x, x, x)
val Vec3d.xxy: Vec3d
    get() = Vec3d(x, x, y)
val Vec3d.xxz: Vec3d
    get() = Vec3d(x, x, z)
val Vec3d.xyx: Vec3d
    get() = Vec3d(x, y, x)
val Vec3d.xyy: Vec3d
    get() = Vec3d(x, y, y)
var Vec3d.xyz: Vec3d
    get() = Vec3d(x, y, z)
    set(value) = put(value.x, value.y, value.z)
val Vec3d.xzx: Vec3d
    get() = Vec3d(x, z, x)
var Vec3d.xzy: Vec3d
    get() = Vec3d(x, z, y)
    set(value) = put(value.x, value.z, value.y)
val Vec3d.xzz: Vec3d
    get() = Vec3d(x, z, z)

val Vec3d.yxx: Vec3d
    get() = Vec3d(y, x, x)
val Vec3d.yxy: Vec3d
    get() = Vec3d(y, x, y)
var Vec3d.yxz: Vec3d
    get() = Vec3d(y, x, z)
    set(value) = put(value.y, value.x, value.z)
val Vec3d.yyx: Vec3d
    get() = Vec3d(y, y, x)
val Vec3d.yyy: Vec3d
    get() = Vec3d(y, y, y)
val Vec3d.yyz: Vec3d
    get() = Vec3d(y, y, z)
var Vec3d.yzx: Vec3d
    get() = Vec3d(y, z, x)
    set(value) = put(value.y, value.z, value.x)
val Vec3d.yzy: Vec3d
    get() = Vec3d(y, z, y)
val Vec3d.yzz: Vec3d
    get() = Vec3d(y, z, z)

val Vec3d.zxx: Vec3d
    get() = Vec3d(z, x, x)
var Vec3d.zxy: Vec3d
    get() = Vec3d(z, x, y)
    set(value) = put(value.z, value.x, value.y)
val Vec3d.zxz: Vec3d
    get() = Vec3d(z, x, z)
var Vec3d.zyx: Vec3d
    get() = Vec3d(z, y, x)
    set(value) = put(value.z, value.y, value.x)
val Vec3d.zyy: Vec3d
    get() = Vec3d(z, y, y)
val Vec3d.zyz: Vec3d
    get() = Vec3d(z, y, z)
val Vec3d.zzx: Vec3d
    get() = Vec3d(z, z, x)
val Vec3d.zzy: Vec3d
    get() = Vec3d(z, z, y)
val Vec3d.zzz: Vec3d
    get() = Vec3d(z, z, z)