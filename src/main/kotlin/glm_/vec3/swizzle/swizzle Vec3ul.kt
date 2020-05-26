package glm_.vec3.swizzle

import glm_.vec2.Vec2ul
import glm_.vec3.Vec3ul

val Vec3ul.xx: Vec2ul
    get() = Vec2ul(x, x)
var Vec3ul.xy: Vec2ul
    get() = Vec2ul(x, y)
    set(value) {
        x = value.x
        y = value.y
    }
var Vec3ul.xz: Vec2ul
    get() = Vec2ul(x, z)
    set(value) {
        x = value.x
        z = value.y
    }
var Vec3ul.yx: Vec2ul
    get() = Vec2ul(y, x)
    set(value) {
        y = value.x
        x = value.y
    }
val Vec3ul.yy: Vec2ul
    get() = Vec2ul(y, y)
var Vec3ul.yz: Vec2ul
    get() = Vec2ul(y, z)
    set(value) {
        y = value.x
        z = value.y
    }
var Vec3ul.zx: Vec2ul
    get() = Vec2ul(z, x)
    set(value) {
        z = value.x
        x = value.y
    }
var Vec3ul.zy: Vec2ul
    get() = Vec2ul(z, y)
    set(value) {
        z = value.x
        y = value.y
    }
val Vec3ul.zz: Vec2ul
    get() = Vec2ul(z, z)


val Vec3ul.xxx: Vec3ul
    get() = Vec3ul(x, x, x)
val Vec3ul.xxy: Vec3ul
    get() = Vec3ul(x, x, y)
val Vec3ul.xxz: Vec3ul
    get() = Vec3ul(x, x, z)
val Vec3ul.xyx: Vec3ul
    get() = Vec3ul(x, y, x)
val Vec3ul.xyy: Vec3ul
    get() = Vec3ul(x, y, y)
var Vec3ul.xyz: Vec3ul
    get() = Vec3ul(x, y, z)
    set(value) = put(value.x, value.y, value.z)
val Vec3ul.xzx: Vec3ul
    get() = Vec3ul(x, z, x)
var Vec3ul.xzy: Vec3ul
    get() = Vec3ul(x, z, y)
    set(value) = put(value.x, value.z, value.y)
val Vec3ul.xzz: Vec3ul
    get() = Vec3ul(x, z, z)

val Vec3ul.yxx: Vec3ul
    get() = Vec3ul(y, x, x)
val Vec3ul.yxy: Vec3ul
    get() = Vec3ul(y, x, y)
var Vec3ul.yxz: Vec3ul
    get() = Vec3ul(y, x, z)
    set(value) = put(value.y, value.x, value.z)
val Vec3ul.yyx: Vec3ul
    get() = Vec3ul(y, y, x)
val Vec3ul.yyy: Vec3ul
    get() = Vec3ul(y, y, y)
val Vec3ul.yyz: Vec3ul
    get() = Vec3ul(y, y, z)
var Vec3ul.yzx: Vec3ul
    get() = Vec3ul(y, z, x)
    set(value) = put(value.y, value.z, value.x)
val Vec3ul.yzy: Vec3ul
    get() = Vec3ul(y, z, y)
val Vec3ul.yzz: Vec3ul
    get() = Vec3ul(y, z, z)

val Vec3ul.zxx: Vec3ul
    get() = Vec3ul(z, x, x)
var Vec3ul.zxy: Vec3ul
    get() = Vec3ul(z, x, y)
    set(value) = put(value.z, value.x, value.y)
val Vec3ul.zxz: Vec3ul
    get() = Vec3ul(z, x, z)
var Vec3ul.zyx: Vec3ul
    get() = Vec3ul(z, y, x)
    set(value) = put(value.z, value.y, value.x)
val Vec3ul.zyy: Vec3ul
    get() = Vec3ul(z, y, y)
val Vec3ul.zyz: Vec3ul
    get() = Vec3ul(z, y, z)
val Vec3ul.zzx: Vec3ul
    get() = Vec3ul(z, z, x)
val Vec3ul.zzy: Vec3ul
    get() = Vec3ul(z, z, y)
val Vec3ul.zzz: Vec3ul
    get() = Vec3ul(z, z, z)