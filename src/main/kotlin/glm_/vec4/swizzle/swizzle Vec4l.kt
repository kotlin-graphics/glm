package glm_.vec4.swizzle

import glm_.vec2.Vec2l
import glm_.vec3.Vec3l
import glm_.vec4.Vec4l

val Vec4l.xx: Vec2l
    get() = Vec2l(x, x)
var Vec4l.xy: Vec2l
    get() = Vec2l(x, y)
    set(value) {
        x = value.x
        y = value.y
    }
var Vec4l.xz: Vec2l
    get() = Vec2l(x, z)
    set(value) {
        x = value.x
        z = value.y
    }
var Vec4l.xw: Vec2l
    get() = Vec2l(x, w)
    set(value) {
        x = value.x
        w = value.y
    }
var Vec4l.yx: Vec2l
    get() = Vec2l(y, x)
    set(value) {
        y = value.x
        x = value.y
    }
val Vec4l.yy: Vec2l
    get() = Vec2l(y, y)
var Vec4l.yz: Vec2l
    get() = Vec2l(y, z)
    set(value) {
        y = value.x
        z = value.y
    }
var Vec4l.yw: Vec2l
    get() = Vec2l(y, w)
    set(value) {
        y = value.x
        w = value.y
    }
var Vec4l.zx: Vec2l
    get() = Vec2l(z, x)
    set(value) {
        z = value.x
        x = value.y
    }
var Vec4l.zy: Vec2l
    get() = Vec2l(z, y)
    set(value) {
        z = value.x
        y = value.y
    }
val Vec4l.zz: Vec2l
    get() = Vec2l(z, z)
var Vec4l.zw: Vec2l
    get() = Vec2l(z, w)
    set(value) {
        z = value.x
        w = value.y
    }
var Vec4l.wx: Vec2l
    get() = Vec2l(w, x)
    set(value) {
        w = value.x
        x = value.y
    }
var Vec4l.wy: Vec2l
    get() = Vec2l(w, y)
    set(value) {
        w = value.x
        y = value.y
    }
var Vec4l.wz: Vec2l
    get() = Vec2l(w, z)
    set(value) {
        w = value.x
        z = value.y
    }
val Vec4l.ww: Vec2l
    get() = Vec2l(w, w)


val Vec4l.xxx: Vec3l
    get() = Vec3l(x, x, x)
val Vec4l.xxy: Vec3l
    get() = Vec3l(x, x, y)
val Vec4l.xxz: Vec3l
    get() = Vec3l(x, x, z)
val Vec4l.xxw: Vec3l
    get() = Vec3l(x, x, w)
val Vec4l.xyx: Vec3l
    get() = Vec3l(x, y, x)
val Vec4l.xyy: Vec3l
    get() = Vec3l(x, y, y)
var Vec4l.xyz: Vec3l
    get() = Vec3l(x, y, z)
    set(value) {
        x = value.x
        y = value.y
        z = value.z
    }

var Vec4l.xyw: Vec3l
    get() = Vec3l(x, y, w)
    set(value) {
        x = value.x
        y = value.y
        w = value.z
    }

val Vec4l.xzx: Vec3l
    get() = Vec3l(x, z, x)
var Vec4l.xzy: Vec3l
    get() = Vec3l(x, z, y)
    set(value) {
        x = value.x
        z = value.y
        y = value.z
    }

val Vec4l.xzz: Vec3l
    get() = Vec3l(x, z, z)
var Vec4l.xzw: Vec3l
    get() = Vec3l(x, z, w)
    set(value) {
        x = value.x
        z = value.y
        w = value.z
    }

val Vec4l.xwx: Vec3l
    get() = Vec3l(x, w, x)
var Vec4l.xwy: Vec3l
    get() = Vec3l(x, w, y)
    set(value) {
        x = value.x
        w = value.y
        y = value.z
    }

var Vec4l.xwz: Vec3l
    get() = Vec3l(x, w, z)
    set(value) {
        x = value.x
        w = value.y
        z = value.z
    }

val Vec4l.xww: Vec3l
    get() = Vec3l(x, w, w)

val Vec4l.yxx: Vec3l
    get() = Vec3l(y, x, x)
val Vec4l.yxy: Vec3l
    get() = Vec3l(y, x, y)
var Vec4l.yxz: Vec3l
    get() = Vec3l(y, x, z)
    set(value) {
        y = value.x
        x = value.y
        z = value.z
    }

var Vec4l.yxw: Vec3l
    get() = Vec3l(y, x, w)
    set(value) {
        y = value.x
        x = value.y
        w = value.z
    }

val Vec4l.yyx: Vec3l
    get() = Vec3l(y, y, x)
val Vec4l.yyy: Vec3l
    get() = Vec3l(y, y, y)
val Vec4l.yyz: Vec3l
    get() = Vec3l(y, y, z)
val Vec4l.yyw: Vec3l
    get() = Vec3l(y, y, w)
var Vec4l.yzx: Vec3l
    get() = Vec3l(y, z, x)
    set(value) {
        y = value.x
        z = value.y
        x = value.z
    }

val Vec4l.yzy: Vec3l
    get() = Vec3l(y, z, y)
val Vec4l.yzz: Vec3l
    get() = Vec3l(y, z, z)
var Vec4l.yzw: Vec3l
    get() = Vec3l(y, z, w)
    set(value) {
        y = value.x
        z = value.y
        w = value.z
    }
var Vec4l.ywx: Vec3l
    get() = Vec3l(y, w, x)
    set(value) {
        y = value.x
        w = value.y
        x = value.z
    }
val Vec4l.ywy: Vec3l
    get() = Vec3l(y, w, y)
var Vec4l.ywz: Vec3l
    get() = Vec3l(y, w, z)
    set(value) {
        y = value.x
        w = value.y
        z = value.z
    }
val Vec4l.yww: Vec3l
    get() = Vec3l(y, w, w)

val Vec4l.zxx: Vec3l
    get() = Vec3l(z, x, x)
var Vec4l.zxy: Vec3l
    get() = Vec3l(z, x, y)
    set(value) {
        z = value.x
        x = value.y
        y = value.z
    }

val Vec4l.zxz: Vec3l
    get() = Vec3l(z, x, z)
var Vec4l.zxw: Vec3l
    get() = Vec3l(z, x, w)
    set(value) {
        z = value.x
        x = value.y
        w = value.z
    }

var Vec4l.zyx: Vec3l
    get() = Vec3l(z, y, x)
    set(value) {
        z = value.x
        y = value.y
        x = value.z
    }

val Vec4l.zyy: Vec3l
    get() = Vec3l(z, y, y)
val Vec4l.zyz: Vec3l
    get() = Vec3l(z, y, z)
var Vec4l.zyw: Vec3l
    get() = Vec3l(z, y, w)
    set(value) {
        z = value.x
        y = value.y
        w = value.z
    }

val Vec4l.zzx: Vec3l
    get() = Vec3l(z, z, x)
val Vec4l.zzy: Vec3l
    get() = Vec3l(z, z, y)
val Vec4l.zzz: Vec3l
    get() = Vec3l(z, z, z)
val Vec4l.zzw: Vec3l
    get() = Vec3l(z, z, w)

var Vec4l.zwx: Vec3l
    get() = Vec3l(z, w, x)
    set(value) {
        z = value.x
        w = value.y
        x = value.z
    }
var Vec4l.zwy: Vec3l
    get() = Vec3l(z, w, y)
    set(value) {
        z = value.x
        w = value.y
        y = value.z
    }
val Vec4l.zwz: Vec3l
    get() = Vec3l(z, w, z)
val Vec4l.zww: Vec3l
    get() = Vec3l(z, w, w)

val Vec4l.wxx: Vec3l
    get() = Vec3l(w, x, x)
var Vec4l.wxy: Vec3l
    get() = Vec3l(w, x, y)
    set(value) {
        w = value.x
        x = value.y
        y = value.z
    }

var Vec4l.wxz: Vec3l
    get() = Vec3l(w, x, z)
    set(value) {
        w = value.x
        x = value.y
        z = value.z
    }

val Vec4l.wxw: Vec3l
    get() = Vec3l(w, x, w)
var Vec4l.wyx: Vec3l
    get() = Vec3l(w, y, x)
    set(value) {
        w = value.x
        y = value.y
        x = value.z
    }

val Vec4l.wyy: Vec3l
    get() = Vec3l(w, y, y)
var Vec4l.wyz: Vec3l
    get() = Vec3l(w, y, z)
    set(value) {
        w = value.x
        y = value.y
        z = value.z
    }

val Vec4l.wyw: Vec3l
    get() = Vec3l(w, y, w)
var Vec4l.wzx: Vec3l
    get() = Vec3l(w, z, x)
    set(value) {
        w = value.x
        z = value.y
        x = value.z
    }

var Vec4l.wzy: Vec3l
    get() = Vec3l(w, z, y)
    set(value) {
        w = value.x
        z = value.y
        y = value.z
    }
val Vec4l.wzz: Vec3l
    get() = Vec3l(w, z, z)

val Vec4l.wzw: Vec3l
    get() = Vec3l(w, z, w)
val Vec4l.wwx: Vec3l
    get() = Vec3l(w, w, x)
val Vec4l.wwy: Vec3l
    get() = Vec3l(w, w, y)
val Vec4l.wwz: Vec3l
    get() = Vec3l(w, w, z)
val Vec4l.www: Vec3l
    get() = Vec3l(w, w, w)

val Vec4l.xxxx: Vec4l
    get() = Vec4l(x, x, x, x)
val Vec4l.xxxy: Vec4l
    get() = Vec4l(x, x, x, y)
val Vec4l.xxxz: Vec4l
    get() = Vec4l(x, x, x, z)
val Vec4l.xxxw: Vec4l
    get() = Vec4l(x, x, x, w)
val Vec4l.xxyx: Vec4l
    get() = Vec4l(x, x, y, x)
val Vec4l.xxyy: Vec4l
    get() = Vec4l(x, x, y, y)
val Vec4l.xxyz: Vec4l
    get() = Vec4l(x, x, y, z)
val Vec4l.xxyw: Vec4l
    get() = Vec4l(x, x, y, w)
val Vec4l.xxzx: Vec4l
    get() = Vec4l(x, x, z, x)
val Vec4l.xxzy: Vec4l
    get() = Vec4l(x, x, z, y)
val Vec4l.xxzz: Vec4l
    get() = Vec4l(x, x, z, z)
val Vec4l.xxzw: Vec4l
    get() = Vec4l(x, x, z, w)
val Vec4l.xxwx: Vec4l
    get() = Vec4l(x, x, w, x)
val Vec4l.xxwy: Vec4l
    get() = Vec4l(x, x, w, y)
val Vec4l.xxwz: Vec4l
    get() = Vec4l(x, x, w, z)
val Vec4l.xxww: Vec4l
    get() = Vec4l(x, x, w, w)
val Vec4l.xyxx: Vec4l
    get() = Vec4l(x, y, x, x)
val Vec4l.xyxy: Vec4l
    get() = Vec4l(x, y, x, y)
val Vec4l.xyxz: Vec4l
    get() = Vec4l(x, y, x, z)
val Vec4l.xyxw: Vec4l
    get() = Vec4l(x, y, x, w)
val Vec4l.xyyx: Vec4l
    get() = Vec4l(x, y, y, x)
val Vec4l.xyyy: Vec4l
    get() = Vec4l(x, y, y, y)
val Vec4l.xyyz: Vec4l
    get() = Vec4l(x, y, y, w)
val Vec4l.xyyw: Vec4l
    get() = Vec4l(x, y, y, w)
val Vec4l.xyzx: Vec4l
    get() = Vec4l(x, y, z, x)
val Vec4l.xyzy: Vec4l
    get() = Vec4l(x, y, z, y)
val Vec4l.xyzz: Vec4l
    get() = Vec4l(x, y, z, z)
var Vec4l.xyzw
    get() = Vec4l(x, y, z, w)
    set(value) = put(value.x, value.y, value.z, value.w)
val Vec4l.xywx
    get() = Vec4l(x, y, w, x)
val Vec4l.xywy
    get() = Vec4l(x, y, w, y)
var Vec4l.xywz
    get() = Vec4l(x, y, w, z)
    set(value) = put(value.x, value.y, value.w, value.z)
val Vec4l.xyww: Vec4l
    get() = Vec4l(x, y, w, w)
val Vec4l.xzxx: Vec4l
    get() = Vec4l(x, z, x, x)
val Vec4l.xzxy: Vec4l
    get() = Vec4l(x, z, x, y)
val Vec4l.xzxz: Vec4l
    get() = Vec4l(x, z, x, z)
val Vec4l.xzxw: Vec4l
    get() = Vec4l(x, z, x, w)
val Vec4l.xzyx: Vec4l
    get() = Vec4l(x, z, y, x)
val Vec4l.xzyy: Vec4l
    get() = Vec4l(x, z, y, y)
val Vec4l.xzyz: Vec4l
    get() = Vec4l(x, z, y, z)
var Vec4l.xzyw
    get() = Vec4l(x, z, y, w)
    set(value) = put(value.x, value.z, value.y, value.w)
val Vec4l.xzzx: Vec4l
    get() = Vec4l(x, z, z, x)
val Vec4l.xzzy: Vec4l
    get() = Vec4l(x, z, z, y)
val Vec4l.xzzz: Vec4l
    get() = Vec4l(x, z, z, z)
val Vec4l.xzzw: Vec4l
    get() = Vec4l(x, z, z, w)
val Vec4l.xzwx: Vec4l
    get() = Vec4l(x, z, w, x)
var Vec4l.xzwy: Vec4l
    get() = Vec4l(x, z, w, y)
    set(value) = put(value.x, value.z, value.w, value.y)
val Vec4l.xzwz: Vec4l
    get() = Vec4l(x, z, w, z)
val Vec4l.xzww: Vec4l
    get() = Vec4l(x, z, w, w)
val Vec4l.xwxx: Vec4l
    get() = Vec4l(x, w, x, x)
val Vec4l.xwxy: Vec4l
    get() = Vec4l(x, w, x, y)
val Vec4l.xwxz: Vec4l
    get() = Vec4l(x, w, x, z)
val Vec4l.xwxw: Vec4l
    get() = Vec4l(x, w, x, w)
val Vec4l.xwyx: Vec4l
    get() = Vec4l(x, w, y, x)
val Vec4l.xwyy: Vec4l
    get() = Vec4l(x, w, y, y)
var Vec4l.xwyz
    get() = Vec4l(x, w, y, z)
    set(value) = put(value.x, value.w, value.y, value.z)
val Vec4l.xwyw: Vec4l
    get() = Vec4l(x, w, y, w)
val Vec4l.xwzx: Vec4l
    get() = Vec4l(x, w, z, x)
var Vec4l.xwzy: Vec4l
    get() = Vec4l(x, w, z, y)
    set(value) = put(value.x, value.w, value.z, value.y)
val Vec4l.xwzz: Vec4l
    get() = Vec4l(x, w, z, z)
val Vec4l.xwzw: Vec4l
    get() = Vec4l(x, w, z, w)
val Vec4l.xwwx: Vec4l
    get() = Vec4l(x, w, w, x)
val Vec4l.xwwy: Vec4l
    get() = Vec4l(x, w, w, y)
val Vec4l.xwwz: Vec4l
    get() = Vec4l(x, w, w, z)
val Vec4l.xwww: Vec4l
    get() = Vec4l(x, w, w, w)
val Vec4l.yxxx: Vec4l
    get() = Vec4l(y, x, x, x)
val Vec4l.yxxy: Vec4l
    get() = Vec4l(y, x, x, y)
val Vec4l.yxxz: Vec4l
    get() = Vec4l(y, x, x, z)
val Vec4l.yxxw: Vec4l
    get() = Vec4l(y, x, x, w)
val Vec4l.yxyx: Vec4l
    get() = Vec4l(y, x, y, x)
val Vec4l.yxyy: Vec4l
    get() = Vec4l(y, x, y, y)
val Vec4l.yxyz: Vec4l
    get() = Vec4l(y, x, y, z)
val Vec4l.yxyw: Vec4l
    get() = Vec4l(y, x, y, w)
val Vec4l.yxzx: Vec4l
    get() = Vec4l(y, x, z, x)
val Vec4l.yxzy: Vec4l
    get() = Vec4l(y, x, z, y)
val Vec4l.yxzz: Vec4l
    get() = Vec4l(y, x, z, z)
var Vec4l.yxzw: Vec4l
    get() = Vec4l(y, x, z, w)
    set(value) = put(value.y, value.x, value.z, value.w)
val Vec4l.yxwx
    get() = Vec4l(y, x, w, x)
val Vec4l.yxwy
    get() = Vec4l(y, x, w, y)
var Vec4l.yxwz
    get() = Vec4l(y, x, w, z)
    set(value) = put(value.y, value.x, value.w, value.z)
val Vec4l.yxww
    get() = Vec4l(y, x, w, w)
val Vec4l.yyxx: Vec4l
    get() = Vec4l(y, y, x, x)
val Vec4l.yyxy: Vec4l
    get() = Vec4l(y, y, x, y)
val Vec4l.yyxz: Vec4l
    get() = Vec4l(y, y, x, z)
val Vec4l.yyxw: Vec4l
    get() = Vec4l(y, y, x, w)
val Vec4l.yyyx: Vec4l
    get() = Vec4l(y, y, y, x)
val Vec4l.yyyy: Vec4l
    get() = Vec4l(y, y, y, y)
val Vec4l.yyyz: Vec4l
    get() = Vec4l(y, y, y, z)
val Vec4l.yyyw: Vec4l
    get() = Vec4l(y, y, y, w)
val Vec4l.yyzx: Vec4l
    get() = Vec4l(y, y, z, x)
val Vec4l.yyzy: Vec4l
    get() = Vec4l(y, y, z, y)
val Vec4l.yyzz: Vec4l
    get() = Vec4l(y, y, z, z)
val Vec4l.yyzw: Vec4l
    get() = Vec4l(y, y, z, w)
val Vec4l.yywx: Vec4l
    get() = Vec4l(y, y, w, x)
val Vec4l.yywy: Vec4l
    get() = Vec4l(y, y, w, y)
val Vec4l.yywz: Vec4l
    get() = Vec4l(y, y, w, z)
val Vec4l.yyww: Vec4l
    get() = Vec4l(y, y, w, w)
val Vec4l.yzxx: Vec4l
    get() = Vec4l(y, z, x, x)
val Vec4l.yzxy: Vec4l
    get() = Vec4l(y, z, x, z)
val Vec4l.yzxz: Vec4l
    get() = Vec4l(y, z, x, z)
var Vec4l.yzxw
    get() = Vec4l(y, z, x, w)
    set(value) = put(value.y, value.z, value.x, value.w)
val Vec4l.yzyx: Vec4l
    get() = Vec4l(y, z, y, x)
val Vec4l.yzyy: Vec4l
    get() = Vec4l(y, z, y, y)
val Vec4l.yzyz: Vec4l
    get() = Vec4l(y, z, y, z)
val Vec4l.yzyw: Vec4l
    get() = Vec4l(y, z, y, w)
val Vec4l.yzzx: Vec4l
    get() = Vec4l(y, z, z, x)
val Vec4l.yzzy: Vec4l
    get() = Vec4l(y, z, z, y)
val Vec4l.yzzz: Vec4l
    get() = Vec4l(y, z, z, z)
val Vec4l.yzzw: Vec4l
    get() = Vec4l(y, z, z, w)
var Vec4l.yzwx
    get() = Vec4l(y, z, w, x)
    set(value) = put(value.y, value.z, value.w, value.x)
val Vec4l.yzwy: Vec4l
    get() = Vec4l(y, z, w, y)
val Vec4l.yzwz: Vec4l
    get() = Vec4l(y, z, w, z)
val Vec4l.yzww: Vec4l
    get() = Vec4l(y, z, w, w)
val Vec4l.ywxx: Vec4l
    get() = Vec4l(y, w, x, x)
val Vec4l.ywxy: Vec4l
    get() = Vec4l(y, w, x, y)
var Vec4l.ywxz: Vec4l
    get() = Vec4l(y, w, x, z)
    set(value) = put(value.y, value.w, value.x, value.z)
val Vec4l.ywxw: Vec4l
    get() = Vec4l(y, w, x, w)
val Vec4l.ywyx: Vec4l
    get() = Vec4l(y, w, y, x)
val Vec4l.ywyy: Vec4l
    get() = Vec4l(y, w, y, y)
val Vec4l.ywyz: Vec4l
    get() = Vec4l(y, w, y, z)
val Vec4l.ywyw: Vec4l
    get() = Vec4l(y, w, y, w)
var Vec4l.ywzx: Vec4l
    get() = Vec4l(y, w, z, x)
    set(value) = put(value.y, value.w, value.z, value.x)
val Vec4l.ywzy: Vec4l
    get() = Vec4l(y, w, z, y)
val Vec4l.ywzz: Vec4l
    get() = Vec4l(y, w, z, z)
val Vec4l.ywzw: Vec4l
    get() = Vec4l(y, w, z, w)
val Vec4l.ywwx: Vec4l
    get() = Vec4l(y, w, w, x)
val Vec4l.ywwy: Vec4l
    get() = Vec4l(y, w, w, y)
val Vec4l.ywwz: Vec4l
    get() = Vec4l(y, w, w, z)
val Vec4l.ywww: Vec4l
    get() = Vec4l(y, w, w, w)
val Vec4l.zxxx: Vec4l
    get() = Vec4l(z, x, x, x)
val Vec4l.zxxy: Vec4l
    get() = Vec4l(z, x, x, y)
val Vec4l.zxxz: Vec4l
    get() = Vec4l(z, x, x, z)
val Vec4l.zxxw: Vec4l
    get() = Vec4l(z, x, x, w)
val Vec4l.zxyx: Vec4l
    get() = Vec4l(z, x, y, x)
val Vec4l.zxyy: Vec4l
    get() = Vec4l(z, x, y, y)
val Vec4l.zxyz: Vec4l
    get() = Vec4l(z, x, y, z)
var Vec4l.zxyw: Vec4l
    get() = Vec4l(z, x, y, w)
    set(value) = put(value.z, value.x, value.y, value.w)
val Vec4l.zxzx: Vec4l
    get() = Vec4l(z, x, z, x)
val Vec4l.zxzy: Vec4l
    get() = Vec4l(z, x, z, y)
val Vec4l.zxzz: Vec4l
    get() = Vec4l(z, x, z, z)
val Vec4l.zxzw: Vec4l
    get() = Vec4l(z, x, w, x)
val Vec4l.zxwx: Vec4l
    get() = Vec4l(z, x, w, x)
var Vec4l.zxwy: Vec4l
    get() = Vec4l(z, x, w, y)
    set(value) = put(value.z, value.x, value.w, value.y)
val Vec4l.zxwz: Vec4l
    get() = Vec4l(z, x, w, y)
val Vec4l.zxww: Vec4l
    get() = Vec4l(z, x, w, w)
val Vec4l.zyxx: Vec4l
    get() = Vec4l(z, y, x, x)
val Vec4l.zyxy: Vec4l
    get() = Vec4l(z, y, x, y)
val Vec4l.zyxz: Vec4l
    get() = Vec4l(z, y, x, z)
var Vec4l.zyxw: Vec4l
    get() = Vec4l(z, y, x, w)
    set(value) = put(value.z, value.y, value.x, value.w)
val Vec4l.zyyx: Vec4l
    get() = Vec4l(z, y, y, x)
val Vec4l.zyyy: Vec4l
    get() = Vec4l(z, y, y, y)
val Vec4l.zyyz: Vec4l
    get() = Vec4l(z, y, y, z)
val Vec4l.zyyw: Vec4l
    get() = Vec4l(z, y, y, w)
val Vec4l.zyzx: Vec4l
    get() = Vec4l(z, y, z, x)
val Vec4l.zyzy: Vec4l
    get() = Vec4l(z, y, z, y)
val Vec4l.zyzz: Vec4l
    get() = Vec4l(z, y, z, z)
val Vec4l.zyzw: Vec4l
    get() = Vec4l(z, y, z, w)
var Vec4l.zywx: Vec4l
    get() = Vec4l(z, y, w, x)
    set(value) = put(value.z, value.y, value.w, value.x)
val Vec4l.zywy: Vec4l
    get() = Vec4l(z, y, w, y)
val Vec4l.zywz: Vec4l
    get() = Vec4l(z, y, w, z)
val Vec4l.zyww: Vec4l
    get() = Vec4l(z, y, w, w)
val Vec4l.zzxx: Vec4l
    get() = Vec4l(z, z, x, x)
val Vec4l.zzxy: Vec4l
    get() = Vec4l(z, z, x, y)
val Vec4l.zzxz: Vec4l
    get() = Vec4l(z, z, x, z)
val Vec4l.zzxw: Vec4l
    get() = Vec4l(z, z, x, w)
val Vec4l.zzyx: Vec4l
    get() = Vec4l(z, z, y, x)
val Vec4l.zzyy: Vec4l
    get() = Vec4l(z, z, y, y)
val Vec4l.zzyz: Vec4l
    get() = Vec4l(z, z, y, z)
val Vec4l.zzyw: Vec4l
    get() = Vec4l(z, z, y, w)
val Vec4l.zzzx: Vec4l
    get() = Vec4l(z, z, z, x)
val Vec4l.zzzy: Vec4l
    get() = Vec4l(z, z, z, y)
val Vec4l.zzzz: Vec4l
    get() = Vec4l(z, z, z, z)
val Vec4l.zzzw: Vec4l
    get() = Vec4l(z, z, z, w)
val Vec4l.zzwx: Vec4l
    get() = Vec4l(z, z, w, x)
val Vec4l.zzwy: Vec4l
    get() = Vec4l(z, z, w, y)
val Vec4l.zzwz: Vec4l
    get() = Vec4l(z, z, w, z)
val Vec4l.zzww: Vec4l
    get() = Vec4l(z, z, w, w)
val Vec4l.zwxx: Vec4l
    get() = Vec4l(z, w, x, x)
var Vec4l.zwxy: Vec4l
    get() = Vec4l(z, w, x, y)
    set(value) = put(value.z, value.w, value.x, value.y)
val Vec4l.zwxz: Vec4l
    get() = Vec4l(z, w, x, z)
val Vec4l.zwxw: Vec4l
    get() = Vec4l(z, w, x, w)
var Vec4l.zwyx: Vec4l
    get() = Vec4l(z, w, y, x)
    set(value) = put(value.z, value.w, value.y, value.x)
val Vec4l.zwyy: Vec4l
    get() = Vec4l(z, w, y, y)
val Vec4l.zwyz: Vec4l
    get() = Vec4l(z, w, y, z)
val Vec4l.zwyw: Vec4l
    get() = Vec4l(z, w, y, w)
val Vec4l.zwzx: Vec4l
    get() = Vec4l(z, w, z, x)
val Vec4l.zwzy: Vec4l
    get() = Vec4l(z, w, z, y)
val Vec4l.zwzz: Vec4l
    get() = Vec4l(z, w, z, z)
val Vec4l.zwzw: Vec4l
    get() = Vec4l(z, w, z, w)
val Vec4l.zwwx: Vec4l
    get() = Vec4l(z, w, w, y)
val Vec4l.zwwy: Vec4l
    get() = Vec4l(z, w, w, y)
val Vec4l.zwwz: Vec4l
    get() = Vec4l(z, w, w, z)
val Vec4l.zwww: Vec4l
    get() = Vec4l(z, w, w, w)
val Vec4l.wxxx: Vec4l
    get() = Vec4l(w, x, x, x)
val Vec4l.wxxy: Vec4l
    get() = Vec4l(w, x, x, y)
val Vec4l.wxxz: Vec4l
    get() = Vec4l(w, x, x, z)
val Vec4l.wxxw: Vec4l
    get() = Vec4l(w, x, x, w)
val Vec4l.wxyx: Vec4l
    get() = Vec4l(w, x, y, x)
val Vec4l.wxyy: Vec4l
    get() = Vec4l(w, x, y, y)
var Vec4l.wxyz: Vec4l
    get() = Vec4l(w, x, y, z)
    set(value) = put(value.w, value.x, value.y, value.z)
val Vec4l.wxyw: Vec4l
    get() = Vec4l(w, x, y, w)
val Vec4l.wxzx: Vec4l
    get() = Vec4l(w, x, z, x)
var Vec4l.wxzy: Vec4l
    get() = Vec4l(w, x, z, y)
    set(value) = put(value.w, value.x, value.z, value.y)
val Vec4l.wxzz: Vec4l
    get() = Vec4l(w, x, z, z)
val Vec4l.wxzw: Vec4l
    get() = Vec4l(w, x, z, w)
val Vec4l.wxwx: Vec4l
    get() = Vec4l(w, x, w, x)
val Vec4l.wxwy: Vec4l
    get() = Vec4l(w, x, w, y)
val Vec4l.wxwz: Vec4l
    get() = Vec4l(w, x, w, z)
val Vec4l.wxww: Vec4l
    get() = Vec4l(w, x, w, w)
val Vec4l.wyxx: Vec4l
    get() = Vec4l(w, y, x, x)
val Vec4l.wyxy: Vec4l
    get() = Vec4l(w, y, x, y)
var Vec4l.wyxz: Vec4l
    get() = Vec4l(w, y, x, z)
    set(value) = put(value.w, value.y, value.x, value.z)
val Vec4l.wyxw: Vec4l
    get() = Vec4l(w, y, x, w)
val Vec4l.wyyx: Vec4l
    get() = Vec4l(w, y, y, x)
val Vec4l.wyyy: Vec4l
    get() = Vec4l(w, y, y, y)
val Vec4l.wyyz: Vec4l
    get() = Vec4l(w, y, y, z)
val Vec4l.wyyw: Vec4l
    get() = Vec4l(w, y, y, w)
var Vec4l.wyzx: Vec4l
    get() = Vec4l(w, y, z, x)
    set(value) = put(value.w, value.y, value.z, value.x)
val Vec4l.wyzy: Vec4l
    get() = Vec4l(w, y, z, y)
val Vec4l.wyzz: Vec4l
    get() = Vec4l(w, y, z, z)
val Vec4l.wyzw: Vec4l
    get() = Vec4l(w, y, z, w)
val Vec4l.wywx: Vec4l
    get() = Vec4l(w, y, w, x)
val Vec4l.wywy: Vec4l
    get() = Vec4l(w, y, w, y)
val Vec4l.wywz: Vec4l
    get() = Vec4l(w, y, w, z)
val Vec4l.wyww: Vec4l
    get() = Vec4l(w, y, w, w)
val Vec4l.wzxx: Vec4l
    get() = Vec4l(w, z, x, x)
var Vec4l.wzxy: Vec4l
    get() = Vec4l(w, z, x, y)
    set(value) = put(value.w, value.z, value.x, value.y)
val Vec4l.wzxz: Vec4l
    get() = Vec4l(w, z, x, z)
val Vec4l.wzxw: Vec4l
    get() = Vec4l(w, z, x, w)
var Vec4l.wzyx: Vec4l
    get() = Vec4l(w, z, y, x)
    set(value) = put(value.w, value.z, value.y, value.x)
val Vec4l.wzyy: Vec4l
    get() = Vec4l(w, z, y, y)
val Vec4l.wzyz: Vec4l
    get() = Vec4l(w, z, y, z)
val Vec4l.wzyw: Vec4l
    get() = Vec4l(w, z, y, w)
val Vec4l.wzzx: Vec4l
    get() = Vec4l(w, z, z, x)
val Vec4l.wzzy: Vec4l
    get() = Vec4l(w, z, z, y)
val Vec4l.wzzz: Vec4l
    get() = Vec4l(w, z, z, z)
val Vec4l.wzzw: Vec4l
    get() = Vec4l(w, z, z, w)
val Vec4l.wzwx: Vec4l
    get() = Vec4l(w, z, w, x)
val Vec4l.wzwy: Vec4l
    get() = Vec4l(w, z, w, y)
val Vec4l.wzwz: Vec4l
    get() = Vec4l(w, z, w, z)
val Vec4l.wzww: Vec4l
    get() = Vec4l(w, z, w, w)
val Vec4l.wwxx: Vec4l
    get() = Vec4l(w, w, x, x)
val Vec4l.wwxy: Vec4l
    get() = Vec4l(w, w, x, y)
val Vec4l.wwxz: Vec4l
    get() = Vec4l(w, w, x, z)
val Vec4l.wwxw: Vec4l
    get() = Vec4l(w, w, x, w)
val Vec4l.wwyx: Vec4l
    get() = Vec4l(w, w, y, x)
val Vec4l.wwyy: Vec4l
    get() = Vec4l(w, w, y, y)
val Vec4l.wwyz: Vec4l
    get() = Vec4l(w, w, y, z)
val Vec4l.wwyw: Vec4l
    get() = Vec4l(w, w, y, w)
val Vec4l.wwzx: Vec4l
    get() = Vec4l(w, w, z, x)
val Vec4l.wwzy: Vec4l
    get() = Vec4l(w, w, z, y)
val Vec4l.wwzz: Vec4l
    get() = Vec4l(w, w, z, z)
val Vec4l.wwzw: Vec4l
    get() = Vec4l(w, w, z, w)
val Vec4l.wwwx: Vec4l
    get() = Vec4l(w, w, w, x)
val Vec4l.wwwy: Vec4l
    get() = Vec4l(w, w, w, y)
val Vec4l.wwwz: Vec4l
    get() = Vec4l(w, w, w, z)
val Vec4l.wwww: Vec4l
    get() = Vec4l(w, w, w, w)