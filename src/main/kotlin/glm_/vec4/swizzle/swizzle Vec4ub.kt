package glm_.vec4.swizzle

import glm_.vec2.Vec2ub
import glm_.vec3.Vec3ub
import glm_.vec4.Vec4ub

val Vec4ub.xx: Vec2ub
    get() = Vec2ub(x, x)
var Vec4ub.xy: Vec2ub
    get() = Vec2ub(x, y)
    set(value) {
        x = value.x
        y = value.y
    }
var Vec4ub.xz: Vec2ub
    get() = Vec2ub(x, z)
    set(value) {
        x = value.x
        z = value.y
    }
var Vec4ub.xw: Vec2ub
    get() = Vec2ub(x, w)
    set(value) {
        x = value.x
        w = value.y
    }
var Vec4ub.yx: Vec2ub
    get() = Vec2ub(y, x)
    set(value) {
        y = value.x
        x = value.y
    }
val Vec4ub.yy: Vec2ub
    get() = Vec2ub(y, y)
var Vec4ub.yz: Vec2ub
    get() = Vec2ub(y, z)
    set(value) {
        y = value.x
        z = value.y
    }
var Vec4ub.yw: Vec2ub
    get() = Vec2ub(y, w)
    set(value) {
        y = value.x
        w = value.y
    }
var Vec4ub.zx: Vec2ub
    get() = Vec2ub(z, x)
    set(value) {
        z = value.x
        x = value.y
    }
var Vec4ub.zy: Vec2ub
    get() = Vec2ub(z, y)
    set(value) {
        z = value.x
        y = value.y
    }
val Vec4ub.zz: Vec2ub
    get() = Vec2ub(z, z)
var Vec4ub.zw: Vec2ub
    get() = Vec2ub(z, w)
    set(value) {
        z = value.x
        w = value.y
    }
var Vec4ub.wx: Vec2ub
    get() = Vec2ub(w, x)
    set(value) {
        w = value.x
        x = value.y
    }
var Vec4ub.wy: Vec2ub
    get() = Vec2ub(w, y)
    set(value) {
        w = value.x
        y = value.y
    }
var Vec4ub.wz: Vec2ub
    get() = Vec2ub(w, z)
    set(value) {
        w = value.x
        z = value.y
    }
val Vec4ub.ww: Vec2ub
    get() = Vec2ub(w, w)


val Vec4ub.xxx: Vec3ub
    get() = Vec3ub(x, x, x)
val Vec4ub.xxy: Vec3ub
    get() = Vec3ub(x, x, y)
val Vec4ub.xxz: Vec3ub
    get() = Vec3ub(x, x, z)
val Vec4ub.xxw: Vec3ub
    get() = Vec3ub(x, x, w)
val Vec4ub.xyx: Vec3ub
    get() = Vec3ub(x, y, x)
val Vec4ub.xyy: Vec3ub
    get() = Vec3ub(x, y, y)
var Vec4ub.xyz: Vec3ub
    get() = Vec3ub(x, y, z)
    set(value) {
        x = value.x
        y = value.y
        z = value.z
    }

var Vec4ub.xyw: Vec3ub
    get() = Vec3ub(x, y, w)
    set(value) {
        x = value.x
        y = value.y
        w = value.z
    }

val Vec4ub.xzx: Vec3ub
    get() = Vec3ub(x, z, x)
var Vec4ub.xzy: Vec3ub
    get() = Vec3ub(x, z, y)
    set(value) {
        x = value.x
        z = value.y
        y = value.z
    }

val Vec4ub.xzz: Vec3ub
    get() = Vec3ub(x, z, z)
var Vec4ub.xzw: Vec3ub
    get() = Vec3ub(x, z, w)
    set(value) {
        x = value.x
        z = value.y
        w = value.z
    }

val Vec4ub.xwx: Vec3ub
    get() = Vec3ub(x, w, x)
var Vec4ub.xwy: Vec3ub
    get() = Vec3ub(x, w, y)
    set(value) {
        x = value.x
        w = value.y
        y = value.z
    }

var Vec4ub.xwz: Vec3ub
    get() = Vec3ub(x, w, z)
    set(value) {
        x = value.x
        w = value.y
        z = value.z
    }

val Vec4ub.xww: Vec3ub
    get() = Vec3ub(x, w, w)

val Vec4ub.yxx: Vec3ub
    get() = Vec3ub(y, x, x)
val Vec4ub.yxy: Vec3ub
    get() = Vec3ub(y, x, y)
var Vec4ub.yxz: Vec3ub
    get() = Vec3ub(y, x, z)
    set(value) {
        y = value.x
        x = value.y
        z = value.z
    }

var Vec4ub.yxw: Vec3ub
    get() = Vec3ub(y, x, w)
    set(value) {
        y = value.x
        x = value.y
        w = value.z
    }

val Vec4ub.yyx: Vec3ub
    get() = Vec3ub(y, y, x)
val Vec4ub.yyy: Vec3ub
    get() = Vec3ub(y, y, y)
val Vec4ub.yyz: Vec3ub
    get() = Vec3ub(y, y, z)
val Vec4ub.yyw: Vec3ub
    get() = Vec3ub(y, y, w)
var Vec4ub.yzx: Vec3ub
    get() = Vec3ub(y, z, x)
    set(value) {
        y = value.x
        z = value.y
        x = value.z
    }

val Vec4ub.yzy: Vec3ub
    get() = Vec3ub(y, z, y)
val Vec4ub.yzz: Vec3ub
    get() = Vec3ub(y, z, z)
var Vec4ub.yzw: Vec3ub
    get() = Vec3ub(y, z, w)
    set(value) {
        y = value.x
        z = value.y
        w = value.z
    }
var Vec4ub.ywx: Vec3ub
    get() = Vec3ub(y, w, x)
    set(value) {
        y = value.x
        w = value.y
        x = value.z
    }
val Vec4ub.ywy: Vec3ub
    get() = Vec3ub(y, w, y)
var Vec4ub.ywz: Vec3ub
    get() = Vec3ub(y, w, z)
    set(value) {
        y = value.x
        w = value.y
        z = value.z
    }
val Vec4ub.yww: Vec3ub
    get() = Vec3ub(y, w, w)

val Vec4ub.zxx: Vec3ub
    get() = Vec3ub(z, x, x)
var Vec4ub.zxy: Vec3ub
    get() = Vec3ub(z, x, y)
    set(value) {
        z = value.x
        x = value.y
        y = value.z
    }

val Vec4ub.zxz: Vec3ub
    get() = Vec3ub(z, x, z)
var Vec4ub.zxw: Vec3ub
    get() = Vec3ub(z, x, w)
    set(value) {
        z = value.x
        x = value.y
        w = value.z
    }

var Vec4ub.zyx: Vec3ub
    get() = Vec3ub(z, y, x)
    set(value) {
        z = value.x
        y = value.y
        x = value.z
    }

val Vec4ub.zyy: Vec3ub
    get() = Vec3ub(z, y, y)
val Vec4ub.zyz: Vec3ub
    get() = Vec3ub(z, y, z)
var Vec4ub.zyw: Vec3ub
    get() = Vec3ub(z, y, w)
    set(value) {
        z = value.x
        y = value.y
        w = value.z
    }

val Vec4ub.zzx: Vec3ub
    get() = Vec3ub(z, z, x)
val Vec4ub.zzy: Vec3ub
    get() = Vec3ub(z, z, y)
val Vec4ub.zzz: Vec3ub
    get() = Vec3ub(z, z, z)
val Vec4ub.zzw: Vec3ub
    get() = Vec3ub(z, z, w)

var Vec4ub.zwx: Vec3ub
    get() = Vec3ub(z, w, x)
    set(value) {
        z = value.x
        w = value.y
        x = value.z
    }
var Vec4ub.zwy: Vec3ub
    get() = Vec3ub(z, w, y)
    set(value) {
        z = value.x
        w = value.y
        y = value.z
    }
val Vec4ub.zwz: Vec3ub
    get() = Vec3ub(z, w, z)
val Vec4ub.zww: Vec3ub
    get() = Vec3ub(z, w, w)

val Vec4ub.wxx: Vec3ub
    get() = Vec3ub(w, x, x)
var Vec4ub.wxy: Vec3ub
    get() = Vec3ub(w, x, y)
    set(value) {
        w = value.x
        x = value.y
        y = value.z
    }

var Vec4ub.wxz: Vec3ub
    get() = Vec3ub(w, x, z)
    set(value) {
        w = value.x
        x = value.y
        z = value.z
    }

val Vec4ub.wxw: Vec3ub
    get() = Vec3ub(w, x, w)
var Vec4ub.wyx: Vec3ub
    get() = Vec3ub(w, y, x)
    set(value) {
        w = value.x
        y = value.y
        x = value.z
    }

val Vec4ub.wyy: Vec3ub
    get() = Vec3ub(w, y, y)
var Vec4ub.wyz: Vec3ub
    get() = Vec3ub(w, y, z)
    set(value) {
        w = value.x
        y = value.y
        z = value.z
    }

val Vec4ub.wyw: Vec3ub
    get() = Vec3ub(w, y, w)
var Vec4ub.wzx: Vec3ub
    get() = Vec3ub(w, z, x)
    set(value) {
        w = value.x
        z = value.y
        x = value.z
    }

var Vec4ub.wzy: Vec3ub
    get() = Vec3ub(w, z, y)
    set(value) {
        w = value.x
        z = value.y
        y = value.z
    }
val Vec4ub.wzz: Vec3ub
    get() = Vec3ub(w, z, z)

val Vec4ub.wzw: Vec3ub
    get() = Vec3ub(w, z, w)
val Vec4ub.wwx: Vec3ub
    get() = Vec3ub(w, w, x)
val Vec4ub.wwy: Vec3ub
    get() = Vec3ub(w, w, y)
val Vec4ub.wwz: Vec3ub
    get() = Vec3ub(w, w, z)
val Vec4ub.www: Vec3ub
    get() = Vec3ub(w, w, w)

val Vec4ub.xxxx: Vec4ub
    get() = Vec4ub(x, x, x, x)
val Vec4ub.xxxy: Vec4ub
    get() = Vec4ub(x, x, x, y)
val Vec4ub.xxxz: Vec4ub
    get() = Vec4ub(x, x, x, z)
val Vec4ub.xxxw: Vec4ub
    get() = Vec4ub(x, x, x, w)
val Vec4ub.xxyx: Vec4ub
    get() = Vec4ub(x, x, y, x)
val Vec4ub.xxyy: Vec4ub
    get() = Vec4ub(x, x, y, y)
val Vec4ub.xxyz: Vec4ub
    get() = Vec4ub(x, x, y, z)
val Vec4ub.xxyw: Vec4ub
    get() = Vec4ub(x, x, y, w)
val Vec4ub.xxzx: Vec4ub
    get() = Vec4ub(x, x, z, x)
val Vec4ub.xxzy: Vec4ub
    get() = Vec4ub(x, x, z, y)
val Vec4ub.xxzz: Vec4ub
    get() = Vec4ub(x, x, z, z)
val Vec4ub.xxzw: Vec4ub
    get() = Vec4ub(x, x, z, w)
val Vec4ub.xxwx: Vec4ub
    get() = Vec4ub(x, x, w, x)
val Vec4ub.xxwy: Vec4ub
    get() = Vec4ub(x, x, w, y)
val Vec4ub.xxwz: Vec4ub
    get() = Vec4ub(x, x, w, z)
val Vec4ub.xxww: Vec4ub
    get() = Vec4ub(x, x, w, w)
val Vec4ub.xyxx: Vec4ub
    get() = Vec4ub(x, y, x, x)
val Vec4ub.xyxy: Vec4ub
    get() = Vec4ub(x, y, x, y)
val Vec4ub.xyxz: Vec4ub
    get() = Vec4ub(x, y, x, z)
val Vec4ub.xyxw: Vec4ub
    get() = Vec4ub(x, y, x, w)
val Vec4ub.xyyx: Vec4ub
    get() = Vec4ub(x, y, y, x)
val Vec4ub.xyyy: Vec4ub
    get() = Vec4ub(x, y, y, y)
val Vec4ub.xyyz: Vec4ub
    get() = Vec4ub(x, y, y, w)
val Vec4ub.xyyw: Vec4ub
    get() = Vec4ub(x, y, y, w)
val Vec4ub.xyzx: Vec4ub
    get() = Vec4ub(x, y, z, x)
val Vec4ub.xyzy: Vec4ub
    get() = Vec4ub(x, y, z, y)
val Vec4ub.xyzz: Vec4ub
    get() = Vec4ub(x, y, z, z)
var Vec4ub.xyzw
    get() = Vec4ub(x, y, z, w)
    set(value) = put(value.x, value.y, value.z, value.w)
val Vec4ub.xywx
    get() = Vec4ub(x, y, w, x)
val Vec4ub.xywy
    get() = Vec4ub(x, y, w, y)
var Vec4ub.xywz
    get() = Vec4ub(x, y, w, z)
    set(value) = put(value.x, value.y, value.w, value.z)
val Vec4ub.xyww: Vec4ub
    get() = Vec4ub(x, y, w, w)
val Vec4ub.xzxx: Vec4ub
    get() = Vec4ub(x, z, x, x)
val Vec4ub.xzxy: Vec4ub
    get() = Vec4ub(x, z, x, y)
val Vec4ub.xzxz: Vec4ub
    get() = Vec4ub(x, z, x, z)
val Vec4ub.xzxw: Vec4ub
    get() = Vec4ub(x, z, x, w)
val Vec4ub.xzyx: Vec4ub
    get() = Vec4ub(x, z, y, x)
val Vec4ub.xzyy: Vec4ub
    get() = Vec4ub(x, z, y, y)
val Vec4ub.xzyz: Vec4ub
    get() = Vec4ub(x, z, y, z)
var Vec4ub.xzyw
    get() = Vec4ub(x, z, y, w)
    set(value) = put(value.x, value.z, value.y, value.w)
val Vec4ub.xzzx: Vec4ub
    get() = Vec4ub(x, z, z, x)
val Vec4ub.xzzy: Vec4ub
    get() = Vec4ub(x, z, z, y)
val Vec4ub.xzzz: Vec4ub
    get() = Vec4ub(x, z, z, z)
val Vec4ub.xzzw: Vec4ub
    get() = Vec4ub(x, z, z, w)
val Vec4ub.xzwx: Vec4ub
    get() = Vec4ub(x, z, w, x)
var Vec4ub.xzwy: Vec4ub
    get() = Vec4ub(x, z, w, y)
    set(value) = put(value.x, value.z, value.w, value.y)
val Vec4ub.xzwz: Vec4ub
    get() = Vec4ub(x, z, w, z)
val Vec4ub.xzww: Vec4ub
    get() = Vec4ub(x, z, w, w)
val Vec4ub.xwxx: Vec4ub
    get() = Vec4ub(x, w, x, x)
val Vec4ub.xwxy: Vec4ub
    get() = Vec4ub(x, w, x, y)
val Vec4ub.xwxz: Vec4ub
    get() = Vec4ub(x, w, x, z)
val Vec4ub.xwxw: Vec4ub
    get() = Vec4ub(x, w, x, w)
val Vec4ub.xwyx: Vec4ub
    get() = Vec4ub(x, w, y, x)
val Vec4ub.xwyy: Vec4ub
    get() = Vec4ub(x, w, y, y)
var Vec4ub.xwyz
    get() = Vec4ub(x, w, y, z)
    set(value) = put(value.x, value.w, value.y, value.z)
val Vec4ub.xwyw: Vec4ub
    get() = Vec4ub(x, w, y, w)
val Vec4ub.xwzx: Vec4ub
    get() = Vec4ub(x, w, z, x)
var Vec4ub.xwzy: Vec4ub
    get() = Vec4ub(x, w, z, y)
    set(value) = put(value.x, value.w, value.z, value.y)
val Vec4ub.xwzz: Vec4ub
    get() = Vec4ub(x, w, z, z)
val Vec4ub.xwzw: Vec4ub
    get() = Vec4ub(x, w, z, w)
val Vec4ub.xwwx: Vec4ub
    get() = Vec4ub(x, w, w, x)
val Vec4ub.xwwy: Vec4ub
    get() = Vec4ub(x, w, w, y)
val Vec4ub.xwwz: Vec4ub
    get() = Vec4ub(x, w, w, z)
val Vec4ub.xwww: Vec4ub
    get() = Vec4ub(x, w, w, w)
val Vec4ub.yxxx: Vec4ub
    get() = Vec4ub(y, x, x, x)
val Vec4ub.yxxy: Vec4ub
    get() = Vec4ub(y, x, x, y)
val Vec4ub.yxxz: Vec4ub
    get() = Vec4ub(y, x, x, z)
val Vec4ub.yxxw: Vec4ub
    get() = Vec4ub(y, x, x, w)
val Vec4ub.yxyx: Vec4ub
    get() = Vec4ub(y, x, y, x)
val Vec4ub.yxyy: Vec4ub
    get() = Vec4ub(y, x, y, y)
val Vec4ub.yxyz: Vec4ub
    get() = Vec4ub(y, x, y, z)
val Vec4ub.yxyw: Vec4ub
    get() = Vec4ub(y, x, y, w)
val Vec4ub.yxzx: Vec4ub
    get() = Vec4ub(y, x, z, x)
val Vec4ub.yxzy: Vec4ub
    get() = Vec4ub(y, x, z, y)
val Vec4ub.yxzz: Vec4ub
    get() = Vec4ub(y, x, z, z)
var Vec4ub.yxzw: Vec4ub
    get() = Vec4ub(y, x, z, w)
    set(value) = put(value.y, value.x, value.z, value.w)
val Vec4ub.yxwx
    get() = Vec4ub(y, x, w, x)
val Vec4ub.yxwy
    get() = Vec4ub(y, x, w, y)
var Vec4ub.yxwz
    get() = Vec4ub(y, x, w, z)
    set(value) = put(value.y, value.x, value.w, value.z)
val Vec4ub.yxww
    get() = Vec4ub(y, x, w, w)
val Vec4ub.yyxx: Vec4ub
    get() = Vec4ub(y, y, x, x)
val Vec4ub.yyxy: Vec4ub
    get() = Vec4ub(y, y, x, y)
val Vec4ub.yyxz: Vec4ub
    get() = Vec4ub(y, y, x, z)
val Vec4ub.yyxw: Vec4ub
    get() = Vec4ub(y, y, x, w)
val Vec4ub.yyyx: Vec4ub
    get() = Vec4ub(y, y, y, x)
val Vec4ub.yyyy: Vec4ub
    get() = Vec4ub(y, y, y, y)
val Vec4ub.yyyz: Vec4ub
    get() = Vec4ub(y, y, y, z)
val Vec4ub.yyyw: Vec4ub
    get() = Vec4ub(y, y, y, w)
val Vec4ub.yyzx: Vec4ub
    get() = Vec4ub(y, y, z, x)
val Vec4ub.yyzy: Vec4ub
    get() = Vec4ub(y, y, z, y)
val Vec4ub.yyzz: Vec4ub
    get() = Vec4ub(y, y, z, z)
val Vec4ub.yyzw: Vec4ub
    get() = Vec4ub(y, y, z, w)
val Vec4ub.yywx: Vec4ub
    get() = Vec4ub(y, y, w, x)
val Vec4ub.yywy: Vec4ub
    get() = Vec4ub(y, y, w, y)
val Vec4ub.yywz: Vec4ub
    get() = Vec4ub(y, y, w, z)
val Vec4ub.yyww: Vec4ub
    get() = Vec4ub(y, y, w, w)
val Vec4ub.yzxx: Vec4ub
    get() = Vec4ub(y, z, x, x)
val Vec4ub.yzxy: Vec4ub
    get() = Vec4ub(y, z, x, z)
val Vec4ub.yzxz: Vec4ub
    get() = Vec4ub(y, z, x, z)
var Vec4ub.yzxw
    get() = Vec4ub(y, z, x, w)
    set(value) = put(value.y, value.z, value.x, value.w)
val Vec4ub.yzyx: Vec4ub
    get() = Vec4ub(y, z, y, x)
val Vec4ub.yzyy: Vec4ub
    get() = Vec4ub(y, z, y, y)
val Vec4ub.yzyz: Vec4ub
    get() = Vec4ub(y, z, y, z)
val Vec4ub.yzyw: Vec4ub
    get() = Vec4ub(y, z, y, w)
val Vec4ub.yzzx: Vec4ub
    get() = Vec4ub(y, z, z, x)
val Vec4ub.yzzy: Vec4ub
    get() = Vec4ub(y, z, z, y)
val Vec4ub.yzzz: Vec4ub
    get() = Vec4ub(y, z, z, z)
val Vec4ub.yzzw: Vec4ub
    get() = Vec4ub(y, z, z, w)
var Vec4ub.yzwx
    get() = Vec4ub(y, z, w, x)
    set(value) = put(value.y, value.z, value.w, value.x)
val Vec4ub.yzwy: Vec4ub
    get() = Vec4ub(y, z, w, y)
val Vec4ub.yzwz: Vec4ub
    get() = Vec4ub(y, z, w, z)
val Vec4ub.yzww: Vec4ub
    get() = Vec4ub(y, z, w, w)
val Vec4ub.ywxx: Vec4ub
    get() = Vec4ub(y, w, x, x)
val Vec4ub.ywxy: Vec4ub
    get() = Vec4ub(y, w, x, y)
var Vec4ub.ywxz: Vec4ub
    get() = Vec4ub(y, w, x, z)
    set(value) = put(value.y, value.w, value.x, value.z)
val Vec4ub.ywxw: Vec4ub
    get() = Vec4ub(y, w, x, w)
val Vec4ub.ywyx: Vec4ub
    get() = Vec4ub(y, w, y, x)
val Vec4ub.ywyy: Vec4ub
    get() = Vec4ub(y, w, y, y)
val Vec4ub.ywyz: Vec4ub
    get() = Vec4ub(y, w, y, z)
val Vec4ub.ywyw: Vec4ub
    get() = Vec4ub(y, w, y, w)
var Vec4ub.ywzx: Vec4ub
    get() = Vec4ub(y, w, z, x)
    set(value) = put(value.y, value.w, value.z, value.x)
val Vec4ub.ywzy: Vec4ub
    get() = Vec4ub(y, w, z, y)
val Vec4ub.ywzz: Vec4ub
    get() = Vec4ub(y, w, z, z)
val Vec4ub.ywzw: Vec4ub
    get() = Vec4ub(y, w, z, w)
val Vec4ub.ywwx: Vec4ub
    get() = Vec4ub(y, w, w, x)
val Vec4ub.ywwy: Vec4ub
    get() = Vec4ub(y, w, w, y)
val Vec4ub.ywwz: Vec4ub
    get() = Vec4ub(y, w, w, z)
val Vec4ub.ywww: Vec4ub
    get() = Vec4ub(y, w, w, w)
val Vec4ub.zxxx: Vec4ub
    get() = Vec4ub(z, x, x, x)
val Vec4ub.zxxy: Vec4ub
    get() = Vec4ub(z, x, x, y)
val Vec4ub.zxxz: Vec4ub
    get() = Vec4ub(z, x, x, z)
val Vec4ub.zxxw: Vec4ub
    get() = Vec4ub(z, x, x, w)
val Vec4ub.zxyx: Vec4ub
    get() = Vec4ub(z, x, y, x)
val Vec4ub.zxyy: Vec4ub
    get() = Vec4ub(z, x, y, y)
val Vec4ub.zxyz: Vec4ub
    get() = Vec4ub(z, x, y, z)
var Vec4ub.zxyw: Vec4ub
    get() = Vec4ub(z, x, y, w)
    set(value) = put(value.z, value.x, value.y, value.w)
val Vec4ub.zxzx: Vec4ub
    get() = Vec4ub(z, x, z, x)
val Vec4ub.zxzy: Vec4ub
    get() = Vec4ub(z, x, z, y)
val Vec4ub.zxzz: Vec4ub
    get() = Vec4ub(z, x, z, z)
val Vec4ub.zxzw: Vec4ub
    get() = Vec4ub(z, x, w, x)
val Vec4ub.zxwx: Vec4ub
    get() = Vec4ub(z, x, w, x)
var Vec4ub.zxwy: Vec4ub
    get() = Vec4ub(z, x, w, y)
    set(value) = put(value.z, value.x, value.w, value.y)
val Vec4ub.zxwz: Vec4ub
    get() = Vec4ub(z, x, w, y)
val Vec4ub.zxww: Vec4ub
    get() = Vec4ub(z, x, w, w)
val Vec4ub.zyxx: Vec4ub
    get() = Vec4ub(z, y, x, x)
val Vec4ub.zyxy: Vec4ub
    get() = Vec4ub(z, y, x, y)
val Vec4ub.zyxz: Vec4ub
    get() = Vec4ub(z, y, x, z)
var Vec4ub.zyxw: Vec4ub
    get() = Vec4ub(z, y, x, w)
    set(value) = put(value.z, value.y, value.x, value.w)
val Vec4ub.zyyx: Vec4ub
    get() = Vec4ub(z, y, y, x)
val Vec4ub.zyyy: Vec4ub
    get() = Vec4ub(z, y, y, y)
val Vec4ub.zyyz: Vec4ub
    get() = Vec4ub(z, y, y, z)
val Vec4ub.zyyw: Vec4ub
    get() = Vec4ub(z, y, y, w)
val Vec4ub.zyzx: Vec4ub
    get() = Vec4ub(z, y, z, x)
val Vec4ub.zyzy: Vec4ub
    get() = Vec4ub(z, y, z, y)
val Vec4ub.zyzz: Vec4ub
    get() = Vec4ub(z, y, z, z)
val Vec4ub.zyzw: Vec4ub
    get() = Vec4ub(z, y, z, w)
var Vec4ub.zywx: Vec4ub
    get() = Vec4ub(z, y, w, x)
    set(value) = put(value.z, value.y, value.w, value.x)
val Vec4ub.zywy: Vec4ub
    get() = Vec4ub(z, y, w, y)
val Vec4ub.zywz: Vec4ub
    get() = Vec4ub(z, y, w, z)
val Vec4ub.zyww: Vec4ub
    get() = Vec4ub(z, y, w, w)
val Vec4ub.zzxx: Vec4ub
    get() = Vec4ub(z, z, x, x)
val Vec4ub.zzxy: Vec4ub
    get() = Vec4ub(z, z, x, y)
val Vec4ub.zzxz: Vec4ub
    get() = Vec4ub(z, z, x, z)
val Vec4ub.zzxw: Vec4ub
    get() = Vec4ub(z, z, x, w)
val Vec4ub.zzyx: Vec4ub
    get() = Vec4ub(z, z, y, x)
val Vec4ub.zzyy: Vec4ub
    get() = Vec4ub(z, z, y, y)
val Vec4ub.zzyz: Vec4ub
    get() = Vec4ub(z, z, y, z)
val Vec4ub.zzyw: Vec4ub
    get() = Vec4ub(z, z, y, w)
val Vec4ub.zzzx: Vec4ub
    get() = Vec4ub(z, z, z, x)
val Vec4ub.zzzy: Vec4ub
    get() = Vec4ub(z, z, z, y)
val Vec4ub.zzzz: Vec4ub
    get() = Vec4ub(z, z, z, z)
val Vec4ub.zzzw: Vec4ub
    get() = Vec4ub(z, z, z, w)
val Vec4ub.zzwx: Vec4ub
    get() = Vec4ub(z, z, w, x)
val Vec4ub.zzwy: Vec4ub
    get() = Vec4ub(z, z, w, y)
val Vec4ub.zzwz: Vec4ub
    get() = Vec4ub(z, z, w, z)
val Vec4ub.zzww: Vec4ub
    get() = Vec4ub(z, z, w, w)
val Vec4ub.zwxx: Vec4ub
    get() = Vec4ub(z, w, x, x)
var Vec4ub.zwxy: Vec4ub
    get() = Vec4ub(z, w, x, y)
    set(value) = put(value.z, value.w, value.x, value.y)
val Vec4ub.zwxz: Vec4ub
    get() = Vec4ub(z, w, x, z)
val Vec4ub.zwxw: Vec4ub
    get() = Vec4ub(z, w, x, w)
var Vec4ub.zwyx: Vec4ub
    get() = Vec4ub(z, w, y, x)
    set(value) = put(value.z, value.w, value.y, value.x)
val Vec4ub.zwyy: Vec4ub
    get() = Vec4ub(z, w, y, y)
val Vec4ub.zwyz: Vec4ub
    get() = Vec4ub(z, w, y, z)
val Vec4ub.zwyw: Vec4ub
    get() = Vec4ub(z, w, y, w)
val Vec4ub.zwzx: Vec4ub
    get() = Vec4ub(z, w, z, x)
val Vec4ub.zwzy: Vec4ub
    get() = Vec4ub(z, w, z, y)
val Vec4ub.zwzz: Vec4ub
    get() = Vec4ub(z, w, z, z)
val Vec4ub.zwzw: Vec4ub
    get() = Vec4ub(z, w, z, w)
val Vec4ub.zwwx: Vec4ub
    get() = Vec4ub(z, w, w, y)
val Vec4ub.zwwy: Vec4ub
    get() = Vec4ub(z, w, w, y)
val Vec4ub.zwwz: Vec4ub
    get() = Vec4ub(z, w, w, z)
val Vec4ub.zwww: Vec4ub
    get() = Vec4ub(z, w, w, w)
val Vec4ub.wxxx: Vec4ub
    get() = Vec4ub(w, x, x, x)
val Vec4ub.wxxy: Vec4ub
    get() = Vec4ub(w, x, x, y)
val Vec4ub.wxxz: Vec4ub
    get() = Vec4ub(w, x, x, z)
val Vec4ub.wxxw: Vec4ub
    get() = Vec4ub(w, x, x, w)
val Vec4ub.wxyx: Vec4ub
    get() = Vec4ub(w, x, y, x)
val Vec4ub.wxyy: Vec4ub
    get() = Vec4ub(w, x, y, y)
var Vec4ub.wxyz: Vec4ub
    get() = Vec4ub(w, x, y, z)
    set(value) = put(value.w, value.x, value.y, value.z)
val Vec4ub.wxyw: Vec4ub
    get() = Vec4ub(w, x, y, w)
val Vec4ub.wxzx: Vec4ub
    get() = Vec4ub(w, x, z, x)
var Vec4ub.wxzy: Vec4ub
    get() = Vec4ub(w, x, z, y)
    set(value) = put(value.w, value.x, value.z, value.y)
val Vec4ub.wxzz: Vec4ub
    get() = Vec4ub(w, x, z, z)
val Vec4ub.wxzw: Vec4ub
    get() = Vec4ub(w, x, z, w)
val Vec4ub.wxwx: Vec4ub
    get() = Vec4ub(w, x, w, x)
val Vec4ub.wxwy: Vec4ub
    get() = Vec4ub(w, x, w, y)
val Vec4ub.wxwz: Vec4ub
    get() = Vec4ub(w, x, w, z)
val Vec4ub.wxww: Vec4ub
    get() = Vec4ub(w, x, w, w)
val Vec4ub.wyxx: Vec4ub
    get() = Vec4ub(w, y, x, x)
val Vec4ub.wyxy: Vec4ub
    get() = Vec4ub(w, y, x, y)
var Vec4ub.wyxz: Vec4ub
    get() = Vec4ub(w, y, x, z)
    set(value) = put(value.w, value.y, value.x, value.z)
val Vec4ub.wyxw: Vec4ub
    get() = Vec4ub(w, y, x, w)
val Vec4ub.wyyx: Vec4ub
    get() = Vec4ub(w, y, y, x)
val Vec4ub.wyyy: Vec4ub
    get() = Vec4ub(w, y, y, y)
val Vec4ub.wyyz: Vec4ub
    get() = Vec4ub(w, y, y, z)
val Vec4ub.wyyw: Vec4ub
    get() = Vec4ub(w, y, y, w)
var Vec4ub.wyzx: Vec4ub
    get() = Vec4ub(w, y, z, x)
    set(value) = put(value.w, value.y, value.z, value.x)
val Vec4ub.wyzy: Vec4ub
    get() = Vec4ub(w, y, z, y)
val Vec4ub.wyzz: Vec4ub
    get() = Vec4ub(w, y, z, z)
val Vec4ub.wyzw: Vec4ub
    get() = Vec4ub(w, y, z, w)
val Vec4ub.wywx: Vec4ub
    get() = Vec4ub(w, y, w, x)
val Vec4ub.wywy: Vec4ub
    get() = Vec4ub(w, y, w, y)
val Vec4ub.wywz: Vec4ub
    get() = Vec4ub(w, y, w, z)
val Vec4ub.wyww: Vec4ub
    get() = Vec4ub(w, y, w, w)
val Vec4ub.wzxx: Vec4ub
    get() = Vec4ub(w, z, x, x)
var Vec4ub.wzxy: Vec4ub
    get() = Vec4ub(w, z, x, y)
    set(value) = put(value.w, value.z, value.x, value.y)
val Vec4ub.wzxz: Vec4ub
    get() = Vec4ub(w, z, x, z)
val Vec4ub.wzxw: Vec4ub
    get() = Vec4ub(w, z, x, w)
var Vec4ub.wzyx: Vec4ub
    get() = Vec4ub(w, z, y, x)
    set(value) = put(value.w, value.z, value.y, value.x)
val Vec4ub.wzyy: Vec4ub
    get() = Vec4ub(w, z, y, y)
val Vec4ub.wzyz: Vec4ub
    get() = Vec4ub(w, z, y, z)
val Vec4ub.wzyw: Vec4ub
    get() = Vec4ub(w, z, y, w)
val Vec4ub.wzzx: Vec4ub
    get() = Vec4ub(w, z, z, x)
val Vec4ub.wzzy: Vec4ub
    get() = Vec4ub(w, z, z, y)
val Vec4ub.wzzz: Vec4ub
    get() = Vec4ub(w, z, z, z)
val Vec4ub.wzzw: Vec4ub
    get() = Vec4ub(w, z, z, w)
val Vec4ub.wzwx: Vec4ub
    get() = Vec4ub(w, z, w, x)
val Vec4ub.wzwy: Vec4ub
    get() = Vec4ub(w, z, w, y)
val Vec4ub.wzwz: Vec4ub
    get() = Vec4ub(w, z, w, z)
val Vec4ub.wzww: Vec4ub
    get() = Vec4ub(w, z, w, w)
val Vec4ub.wwxx: Vec4ub
    get() = Vec4ub(w, w, x, x)
val Vec4ub.wwxy: Vec4ub
    get() = Vec4ub(w, w, x, y)
val Vec4ub.wwxz: Vec4ub
    get() = Vec4ub(w, w, x, z)
val Vec4ub.wwxw: Vec4ub
    get() = Vec4ub(w, w, x, w)
val Vec4ub.wwyx: Vec4ub
    get() = Vec4ub(w, w, y, x)
val Vec4ub.wwyy: Vec4ub
    get() = Vec4ub(w, w, y, y)
val Vec4ub.wwyz: Vec4ub
    get() = Vec4ub(w, w, y, z)
val Vec4ub.wwyw: Vec4ub
    get() = Vec4ub(w, w, y, w)
val Vec4ub.wwzx: Vec4ub
    get() = Vec4ub(w, w, z, x)
val Vec4ub.wwzy: Vec4ub
    get() = Vec4ub(w, w, z, y)
val Vec4ub.wwzz: Vec4ub
    get() = Vec4ub(w, w, z, z)
val Vec4ub.wwzw: Vec4ub
    get() = Vec4ub(w, w, z, w)
val Vec4ub.wwwx: Vec4ub
    get() = Vec4ub(w, w, w, x)
val Vec4ub.wwwy: Vec4ub
    get() = Vec4ub(w, w, w, y)
val Vec4ub.wwwz: Vec4ub
    get() = Vec4ub(w, w, w, z)
val Vec4ub.wwww: Vec4ub
    get() = Vec4ub(w, w, w, w)