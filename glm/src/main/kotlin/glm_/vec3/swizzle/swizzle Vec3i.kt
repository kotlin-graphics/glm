package glm_.vec3.swizzle

import glm_.vec2.Vec2i
import glm_.vec3.Vec3i

val Vec3i.xx: Vec2i
    get() = Vec2i(x, x)
var Vec3i.xy: Vec2i
    get() = Vec2i(x, y)
    set(value) {
        x = value.x
        y = value.y
    }
var Vec3i.xz: Vec2i
    get() = Vec2i(x, z)
    set(value) {
        x = value.x
        z = value.y
    }
var Vec3i.yx: Vec2i
    get() = Vec2i(y, x)
    set(value) {
        y = value.x
        x = value.y
    }
val Vec3i.yy: Vec2i
    get() = Vec2i(y, y)
var Vec3i.yz: Vec2i
    get() = Vec2i(y, z)
    set(value) {
        y = value.x
        z = value.y
    }
var Vec3i.zx: Vec2i
    get() = Vec2i(z, x)
    set(value) {
        z = value.x
        x = value.y
    }
var Vec3i.zy: Vec2i
    get() = Vec2i(z, y)
    set(value) {
        z = value.x
        y = value.y
    }
val Vec3i.zz: Vec2i
    get() = Vec2i(z, z)

// TODO swizzle aliases for others Vec3*
val Vec3i.rr: Vec2i
    get() = Vec2i(x, x)
var Vec3i.rg: Vec2i
    get() = Vec2i(x, y)
    set(value) {
        x = value.x
        y = value.y
    }
var Vec3i.rb: Vec2i
    get() = Vec2i(x, z)
    set(value) {
        x = value.x
        z = value.y
    }
var Vec3i.gr: Vec2i
    get() = Vec2i(y, x)
    set(value) {
        y = value.x
        x = value.y
    }
val Vec3i.gg: Vec2i
    get() = Vec2i(y, y)
var Vec3i.gb: Vec2i
    get() = Vec2i(y, z)
    set(value) {
        y = value.x
        z = value.y
    }
var Vec3i.br: Vec2i
    get() = Vec2i(z, x)
    set(value) {
        z = value.x
        x = value.y
    }
var Vec3i.bg: Vec2i
    get() = Vec2i(z, y)
    set(value) {
        z = value.x
        y = value.y
    }
val Vec3i.bb: Vec2i
    get() = Vec2i(z, z)


val Vec3i.xxx: Vec3i
    get() = Vec3i(x, x, x)
val Vec3i.xxy: Vec3i
    get() = Vec3i(x, x, y)
val Vec3i.xxz: Vec3i
    get() = Vec3i(x, x, z)
val Vec3i.xyx: Vec3i
    get() = Vec3i(x, y, x)
val Vec3i.xyy: Vec3i
    get() = Vec3i(x, y, y)
var Vec3i.xyz: Vec3i
    get() = Vec3i(x, y, z)
    set(value) = put(value.x, value.y, value.z)
val Vec3i.xzx: Vec3i
    get() = Vec3i(x, z, x)
var Vec3i.xzy: Vec3i
    get() = Vec3i(x, z, y)
    set(value) = put(value.x, value.z, value.y)
val Vec3i.xzz: Vec3i
    get() = Vec3i(x, z, z)

val Vec3i.yxx: Vec3i
    get() = Vec3i(y, x, x)
val Vec3i.yxy: Vec3i
    get() = Vec3i(y, x, y)
var Vec3i.yxz: Vec3i
    get() = Vec3i(y, x, z)
    set(value) = put(value.y, value.x, value.z)
val Vec3i.yyx: Vec3i
    get() = Vec3i(y, y, x)
val Vec3i.yyy: Vec3i
    get() = Vec3i(y, y, y)
val Vec3i.yyz: Vec3i
    get() = Vec3i(y, y, z)
var Vec3i.yzx: Vec3i
    get() = Vec3i(y, z, x)
    set(value) = put(value.y, value.z, value.x)
val Vec3i.yzy: Vec3i
    get() = Vec3i(y, z, y)
val Vec3i.yzz: Vec3i
    get() = Vec3i(y, z, z)

val Vec3i.zxx: Vec3i
    get() = Vec3i(z, x, x)
var Vec3i.zxy: Vec3i
    get() = Vec3i(z, x, y)
    set(value) = put(value.z, value.x, value.y)
val Vec3i.zxz: Vec3i
    get() = Vec3i(z, x, z)
var Vec3i.zyx: Vec3i
    get() = Vec3i(z, y, x)
    set(value) = put(value.z, value.y, value.x)
val Vec3i.zyy: Vec3i
    get() = Vec3i(z, y, y)
val Vec3i.zyz: Vec3i
    get() = Vec3i(z, y, z)
val Vec3i.zzx: Vec3i
    get() = Vec3i(z, z, x)
val Vec3i.zzy: Vec3i
    get() = Vec3i(z, z, y)
val Vec3i.zzz: Vec3i
    get() = Vec3i(z, z, z)