package glm_.vec3.swizzle

import glm_.vec2.Vec2s
import glm_.vec3.Vec3s

val Vec3s.xx: Vec2s
    get() = Vec2s(x, x)
var Vec3s.xy: Vec2s
    get() = Vec2s(x, y)
    set(value) {
        x = value.x
        y = value.y
    }
var Vec3s.xz: Vec2s
    get() = Vec2s(x, z)
    set(value) {
        x = value.x
        z = value.y
    }
var Vec3s.yx: Vec2s
    get() = Vec2s(y, x)
    set(value) {
        y = value.x
        x = value.y
    }
val Vec3s.yy: Vec2s
    get() = Vec2s(y, y)
var Vec3s.yz: Vec2s
    get() = Vec2s(y, z)
    set(value) {
        y = value.x
        z = value.y
    }
var Vec3s.zx: Vec2s
    get() = Vec2s(z, x)
    set(value) {
        z = value.x
        x = value.y
    }
var Vec3s.zy: Vec2s
    get() = Vec2s(z, y)
    set(value) {
        z = value.x
        y = value.y
    }
val Vec3s.zz: Vec2s
    get() = Vec2s(z, z)


val Vec3s.xxx: Vec3s
    get() = Vec3s(x, x, x)
val Vec3s.xxy: Vec3s
    get() = Vec3s(x, x, y)
val Vec3s.xxz: Vec3s
    get() = Vec3s(x, x, z)
val Vec3s.xyx: Vec3s
    get() = Vec3s(x, y, x)
val Vec3s.xyy: Vec3s
    get() = Vec3s(x, y, y)
var Vec3s.xyz: Vec3s
    get() = Vec3s(x, y, z)
    set(value) = put(value.x, value.y, value.z)
val Vec3s.xzx: Vec3s
    get() = Vec3s(x, z, x)
var Vec3s.xzy: Vec3s
    get() = Vec3s(x, z, y)
    set(value) = put(value.x, value.z, value.y)
val Vec3s.xzz: Vec3s
    get() = Vec3s(x, z, z)

val Vec3s.yxx: Vec3s
    get() = Vec3s(y, x, x)
val Vec3s.yxy: Vec3s
    get() = Vec3s(y, x, y)
var Vec3s.yxz: Vec3s
    get() = Vec3s(y, x, z)
    set(value) = put(value.y, value.x, value.z)
val Vec3s.yyx: Vec3s
    get() = Vec3s(y, y, x)
val Vec3s.yyy: Vec3s
    get() = Vec3s(y, y, y)
val Vec3s.yyz: Vec3s
    get() = Vec3s(y, y, z)
var Vec3s.yzx: Vec3s
    get() = Vec3s(y, z, x)
    set(value) = put(value.y, value.z, value.x)
val Vec3s.yzy: Vec3s
    get() = Vec3s(y, z, y)
val Vec3s.yzz: Vec3s
    get() = Vec3s(y, z, z)

val Vec3s.zxx: Vec3s
    get() = Vec3s(z, x, x)
var Vec3s.zxy: Vec3s
    get() = Vec3s(z, x, y)
    set(value) = put(value.z, value.x, value.y)
val Vec3s.zxz: Vec3s
    get() = Vec3s(z, x, z)
var Vec3s.zyx: Vec3s
    get() = Vec3s(z, y, x)
    set(value) = put(value.z, value.y, value.x)
val Vec3s.zyy: Vec3s
    get() = Vec3s(z, y, y)
val Vec3s.zyz: Vec3s
    get() = Vec3s(z, y, z)
val Vec3s.zzx: Vec3s
    get() = Vec3s(z, z, x)
val Vec3s.zzy: Vec3s
    get() = Vec3s(z, z, y)
val Vec3s.zzz: Vec3s
    get() = Vec3s(z, z, z)