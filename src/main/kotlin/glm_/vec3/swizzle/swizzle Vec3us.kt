package glm_.vec3.swizzle

import glm_.vec2.Vec2us
import glm_.vec3.Vec3us

val Vec3us.xx: Vec2us
    get() = Vec2us(x, x)
var Vec3us.xy: Vec2us
    get() = Vec2us(x, y)
    set(value) {
        x = value.x
        y = value.y
    }
var Vec3us.xz: Vec2us
    get() = Vec2us(x, z)
    set(value) {
        x = value.x
        z = value.y
    }
var Vec3us.yx: Vec2us
    get() = Vec2us(y, x)
    set(value) {
        y = value.x
        x = value.y
    }
val Vec3us.yy: Vec2us
    get() = Vec2us(y, y)
var Vec3us.yz: Vec2us
    get() = Vec2us(y, z)
    set(value) {
        y = value.x
        z = value.y
    }
var Vec3us.zx: Vec2us
    get() = Vec2us(z, x)
    set(value) {
        z = value.x
        x = value.y
    }
var Vec3us.zy: Vec2us
    get() = Vec2us(z, y)
    set(value) {
        z = value.x
        y = value.y
    }
val Vec3us.zz: Vec2us
    get() = Vec2us(z, z)


val Vec3us.xxx: Vec3us
    get() = Vec3us(x, x, x)
val Vec3us.xxy: Vec3us
    get() = Vec3us(x, x, y)
val Vec3us.xxz: Vec3us
    get() = Vec3us(x, x, z)
val Vec3us.xyx: Vec3us
    get() = Vec3us(x, y, x)
val Vec3us.xyy: Vec3us
    get() = Vec3us(x, y, y)
var Vec3us.xyz: Vec3us
    get() = Vec3us(x, y, z)
    set(value) = put(value.x, value.y, value.z)
val Vec3us.xzx: Vec3us
    get() = Vec3us(x, z, x)
var Vec3us.xzy: Vec3us
    get() = Vec3us(x, z, y)
    set(value) = put(value.x, value.z, value.y)
val Vec3us.xzz: Vec3us
    get() = Vec3us(x, z, z)

val Vec3us.yxx: Vec3us
    get() = Vec3us(y, x, x)
val Vec3us.yxy: Vec3us
    get() = Vec3us(y, x, y)
var Vec3us.yxz: Vec3us
    get() = Vec3us(y, x, z)
    set(value) = put(value.y, value.x, value.z)
val Vec3us.yyx: Vec3us
    get() = Vec3us(y, y, x)
val Vec3us.yyy: Vec3us
    get() = Vec3us(y, y, y)
val Vec3us.yyz: Vec3us
    get() = Vec3us(y, y, z)
var Vec3us.yzx: Vec3us
    get() = Vec3us(y, z, x)
    set(value) = put(value.y, value.z, value.x)
val Vec3us.yzy: Vec3us
    get() = Vec3us(y, z, y)
val Vec3us.yzz: Vec3us
    get() = Vec3us(y, z, z)

val Vec3us.zxx: Vec3us
    get() = Vec3us(z, x, x)
var Vec3us.zxy: Vec3us
    get() = Vec3us(z, x, y)
    set(value) = put(value.z, value.x, value.y)
val Vec3us.zxz: Vec3us
    get() = Vec3us(z, x, z)
var Vec3us.zyx: Vec3us
    get() = Vec3us(z, y, x)
    set(value) = put(value.z, value.y, value.x)
val Vec3us.zyy: Vec3us
    get() = Vec3us(z, y, y)
val Vec3us.zyz: Vec3us
    get() = Vec3us(z, y, z)
val Vec3us.zzx: Vec3us
    get() = Vec3us(z, z, x)
val Vec3us.zzy: Vec3us
    get() = Vec3us(z, z, y)
val Vec3us.zzz: Vec3us
    get() = Vec3us(z, z, z)