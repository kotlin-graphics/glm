package glm_.vec4.swizzle

import glm_.vec2.Vec2s
import glm_.vec3.Vec3s
import glm_.vec4.Vec4s

val Vec4s.xx: Vec2s
    get() = Vec2s(x, x)
var Vec4s.xy: Vec2s
    get() = Vec2s(x, y)
    set(value) {
        x = value.x
        y = value.y
    }
var Vec4s.xz: Vec2s
    get() = Vec2s(x, z)
    set(value) {
        x = value.x
        z = value.y
    }
var Vec4s.xw: Vec2s
    get() = Vec2s(x, w)
    set(value) {
        x = value.x
        w = value.y
    }
var Vec4s.yx: Vec2s
    get() = Vec2s(y, x)
    set(value) {
        y = value.x
        x = value.y
    }
val Vec4s.yy: Vec2s
    get() = Vec2s(y, y)
var Vec4s.yz: Vec2s
    get() = Vec2s(y, z)
    set(value) {
        y = value.x
        z = value.y
    }
var Vec4s.yw: Vec2s
    get() = Vec2s(y, w)
    set(value) {
        y = value.x
        w = value.y
    }
var Vec4s.zx: Vec2s
    get() = Vec2s(z, x)
    set(value) {
        z = value.x
        x = value.y
    }
var Vec4s.zy: Vec2s
    get() = Vec2s(z, y)
    set(value) {
        z = value.x
        y = value.y
    }
val Vec4s.zz: Vec2s
    get() = Vec2s(z, z)
var Vec4s.zw: Vec2s
    get() = Vec2s(z, w)
    set(value) {
        z = value.x
        w = value.y
    }
var Vec4s.wx: Vec2s
    get() = Vec2s(w, x)
    set(value) {
        w = value.x
        x = value.y
    }
var Vec4s.wy: Vec2s
    get() = Vec2s(w, y)
    set(value) {
        w = value.x
        y = value.y
    }
var Vec4s.wz: Vec2s
    get() = Vec2s(w, z)
    set(value) {
        w = value.x
        z = value.y
    }
val Vec4s.ww: Vec2s
    get() = Vec2s(w, w)


val Vec4s.xxx: Vec3s
    get() = Vec3s(x, x, x)
val Vec4s.xxy: Vec3s
    get() = Vec3s(x, x, y)
val Vec4s.xxz: Vec3s
    get() = Vec3s(x, x, z)
val Vec4s.xxw: Vec3s
    get() = Vec3s(x, x, w)
val Vec4s.xyx: Vec3s
    get() = Vec3s(x, y, x)
val Vec4s.xyy: Vec3s
    get() = Vec3s(x, y, y)
var Vec4s.xyz: Vec3s
    get() = Vec3s(x, y, z)
    set(value) {
        x = value.x
        y = value.y
        z = value.z
    }

var Vec4s.xyw: Vec3s
    get() = Vec3s(x, y, w)
    set(value) {
        x = value.x
        y = value.y
        w = value.z
    }

val Vec4s.xzx: Vec3s
    get() = Vec3s(x, z, x)
var Vec4s.xzy: Vec3s
    get() = Vec3s(x, z, y)
    set(value) {
        x = value.x
        z = value.y
        y = value.z
    }

val Vec4s.xzz: Vec3s
    get() = Vec3s(x, z, z)
var Vec4s.xzw: Vec3s
    get() = Vec3s(x, z, w)
    set(value) {
        x = value.x
        z = value.y
        w = value.z
    }

val Vec4s.xwx: Vec3s
    get() = Vec3s(x, w, x)
var Vec4s.xwy: Vec3s
    get() = Vec3s(x, w, y)
    set(value) {
        x = value.x
        w = value.y
        y = value.z
    }

var Vec4s.xwz: Vec3s
    get() = Vec3s(x, w, z)
    set(value) {
        x = value.x
        w = value.y
        z = value.z
    }

val Vec4s.xww: Vec3s
    get() = Vec3s(x, w, w)

val Vec4s.yxx: Vec3s
    get() = Vec3s(y, x, x)
val Vec4s.yxy: Vec3s
    get() = Vec3s(y, x, y)
var Vec4s.yxz: Vec3s
    get() = Vec3s(y, x, z)
    set(value) {
        y = value.x
        x = value.y
        z = value.z
    }

var Vec4s.yxw: Vec3s
    get() = Vec3s(y, x, w)
    set(value) {
        y = value.x
        x = value.y
        w = value.z
    }

val Vec4s.yyx: Vec3s
    get() = Vec3s(y, y, x)
val Vec4s.yyy: Vec3s
    get() = Vec3s(y, y, y)
val Vec4s.yyz: Vec3s
    get() = Vec3s(y, y, z)
val Vec4s.yyw: Vec3s
    get() = Vec3s(y, y, w)
var Vec4s.yzx: Vec3s
    get() = Vec3s(y, z, x)
    set(value) {
        y = value.x
        z = value.y
        x = value.z
    }

val Vec4s.yzy: Vec3s
    get() = Vec3s(y, z, y)
val Vec4s.yzz: Vec3s
    get() = Vec3s(y, z, z)
var Vec4s.yzw: Vec3s
    get() = Vec3s(y, z, w)
    set(value) {
        y = value.x
        z = value.y
        w = value.z
    }
var Vec4s.ywx: Vec3s
    get() = Vec3s(y, w, x)
    set(value) {
        y = value.x
        w = value.y
        x = value.z
    }
val Vec4s.ywy: Vec3s
    get() = Vec3s(y, w, y)
var Vec4s.ywz: Vec3s
    get() = Vec3s(y, w, z)
    set(value) {
        y = value.x
        w = value.y
        z = value.z
    }
val Vec4s.yww: Vec3s
    get() = Vec3s(y, w, w)

val Vec4s.zxx: Vec3s
    get() = Vec3s(z, x, x)
var Vec4s.zxy: Vec3s
    get() = Vec3s(z, x, y)
    set(value) {
        z = value.x
        x = value.y
        y = value.z
    }

val Vec4s.zxz: Vec3s
    get() = Vec3s(z, x, z)
var Vec4s.zxw: Vec3s
    get() = Vec3s(z, x, w)
    set(value) {
        z = value.x
        x = value.y
        w = value.z
    }

var Vec4s.zyx: Vec3s
    get() = Vec3s(z, y, x)
    set(value) {
        z = value.x
        y = value.y
        x = value.z
    }

val Vec4s.zyy: Vec3s
    get() = Vec3s(z, y, y)
val Vec4s.zyz: Vec3s
    get() = Vec3s(z, y, z)
var Vec4s.zyw: Vec3s
    get() = Vec3s(z, y, w)
    set(value) {
        z = value.x
        y = value.y
        w = value.z
    }

val Vec4s.zzx: Vec3s
    get() = Vec3s(z, z, x)
val Vec4s.zzy: Vec3s
    get() = Vec3s(z, z, y)
val Vec4s.zzz: Vec3s
    get() = Vec3s(z, z, z)
val Vec4s.zzw: Vec3s
    get() = Vec3s(z, z, w)

var Vec4s.zwx: Vec3s
    get() = Vec3s(z, w, x)
    set(value) {
        z = value.x
        w = value.y
        x = value.z
    }
var Vec4s.zwy: Vec3s
    get() = Vec3s(z, w, y)
    set(value) {
        z = value.x
        w = value.y
        y = value.z
    }
val Vec4s.zwz: Vec3s
    get() = Vec3s(z, w, z)
val Vec4s.zww: Vec3s
    get() = Vec3s(z, w, w)

val Vec4s.wxx: Vec3s
    get() = Vec3s(w, x, x)
var Vec4s.wxy: Vec3s
    get() = Vec3s(w, x, y)
    set(value) {
        w = value.x
        x = value.y
        y = value.z
    }

var Vec4s.wxz: Vec3s
    get() = Vec3s(w, x, z)
    set(value) {
        w = value.x
        x = value.y
        z = value.z
    }

val Vec4s.wxw: Vec3s
    get() = Vec3s(w, x, w)
var Vec4s.wyx: Vec3s
    get() = Vec3s(w, y, x)
    set(value) {
        w = value.x
        y = value.y
        x = value.z
    }

val Vec4s.wyy: Vec3s
    get() = Vec3s(w, y, y)
var Vec4s.wyz: Vec3s
    get() = Vec3s(w, y, z)
    set(value) {
        w = value.x
        y = value.y
        z = value.z
    }

val Vec4s.wyw: Vec3s
    get() = Vec3s(w, y, w)
var Vec4s.wzx: Vec3s
    get() = Vec3s(w, z, x)
    set(value) {
        w = value.x
        z = value.y
        x = value.z
    }

var Vec4s.wzy: Vec3s
    get() = Vec3s(w, z, y)
    set(value) {
        w = value.x
        z = value.y
        y = value.z
    }
val Vec4s.wzz: Vec3s
    get() = Vec3s(w, z, z)

val Vec4s.wzw: Vec3s
    get() = Vec3s(w, z, w)
val Vec4s.wwx: Vec3s
    get() = Vec3s(w, w, x)
val Vec4s.wwy: Vec3s
    get() = Vec3s(w, w, y)
val Vec4s.wwz: Vec3s
    get() = Vec3s(w, w, z)
val Vec4s.www: Vec3s
    get() = Vec3s(w, w, w)

val Vec4s.xxxx: Vec4s
    get() = Vec4s(x, x, x, x)
val Vec4s.xxxy: Vec4s
    get() = Vec4s(x, x, x, y)
val Vec4s.xxxz: Vec4s
    get() = Vec4s(x, x, x, z)
val Vec4s.xxxw: Vec4s
    get() = Vec4s(x, x, x, w)
val Vec4s.xxyx: Vec4s
    get() = Vec4s(x, x, y, x)
val Vec4s.xxyy: Vec4s
    get() = Vec4s(x, x, y, y)
val Vec4s.xxyz: Vec4s
    get() = Vec4s(x, x, y, z)
val Vec4s.xxyw: Vec4s
    get() = Vec4s(x, x, y, w)
val Vec4s.xxzx: Vec4s
    get() = Vec4s(x, x, z, x)
val Vec4s.xxzy: Vec4s
    get() = Vec4s(x, x, z, y)
val Vec4s.xxzz: Vec4s
    get() = Vec4s(x, x, z, z)
val Vec4s.xxzw: Vec4s
    get() = Vec4s(x, x, z, w)
val Vec4s.xxwx: Vec4s
    get() = Vec4s(x, x, w, x)
val Vec4s.xxwy: Vec4s
    get() = Vec4s(x, x, w, y)
val Vec4s.xxwz: Vec4s
    get() = Vec4s(x, x, w, z)
val Vec4s.xxww: Vec4s
    get() = Vec4s(x, x, w, w)
val Vec4s.xyxx: Vec4s
    get() = Vec4s(x, y, x, x)
val Vec4s.xyxy: Vec4s
    get() = Vec4s(x, y, x, y)
val Vec4s.xyxz: Vec4s
    get() = Vec4s(x, y, x, z)
val Vec4s.xyxw: Vec4s
    get() = Vec4s(x, y, x, w)
val Vec4s.xyyx: Vec4s
    get() = Vec4s(x, y, y, x)
val Vec4s.xyyy: Vec4s
    get() = Vec4s(x, y, y, y)
val Vec4s.xyyz: Vec4s
    get() = Vec4s(x, y, y, w)
val Vec4s.xyyw: Vec4s
    get() = Vec4s(x, y, y, w)
val Vec4s.xyzx: Vec4s
    get() = Vec4s(x, y, z, x)
val Vec4s.xyzy: Vec4s
    get() = Vec4s(x, y, z, y)
val Vec4s.xyzz: Vec4s
    get() = Vec4s(x, y, z, z)
var Vec4s.xyzw
    get() = Vec4s(x, y, z, w)
    set(value) = put(value.x, value.y, value.z, value.w)
val Vec4s.xywx
    get() = Vec4s(x, y, w, x)
val Vec4s.xywy
    get() = Vec4s(x, y, w, y)
var Vec4s.xywz
    get() = Vec4s(x, y, w, z)
    set(value) = put(value.x, value.y, value.w, value.z)
val Vec4s.xyww: Vec4s
    get() = Vec4s(x, y, w, w)
val Vec4s.xzxx: Vec4s
    get() = Vec4s(x, z, x, x)
val Vec4s.xzxy: Vec4s
    get() = Vec4s(x, z, x, y)
val Vec4s.xzxz: Vec4s
    get() = Vec4s(x, z, x, z)
val Vec4s.xzxw: Vec4s
    get() = Vec4s(x, z, x, w)
val Vec4s.xzyx: Vec4s
    get() = Vec4s(x, z, y, x)
val Vec4s.xzyy: Vec4s
    get() = Vec4s(x, z, y, y)
val Vec4s.xzyz: Vec4s
    get() = Vec4s(x, z, y, z)
var Vec4s.xzyw
    get() = Vec4s(x, z, y, w)
    set(value) = put(value.x, value.z, value.y, value.w)
val Vec4s.xzzx: Vec4s
    get() = Vec4s(x, z, z, x)
val Vec4s.xzzy: Vec4s
    get() = Vec4s(x, z, z, y)
val Vec4s.xzzz: Vec4s
    get() = Vec4s(x, z, z, z)
val Vec4s.xzzw: Vec4s
    get() = Vec4s(x, z, z, w)
val Vec4s.xzwx: Vec4s
    get() = Vec4s(x, z, w, x)
var Vec4s.xzwy: Vec4s
    get() = Vec4s(x, z, w, y)
    set(value) = put(value.x, value.z, value.w, value.y)
val Vec4s.xzwz: Vec4s
    get() = Vec4s(x, z, w, z)
val Vec4s.xzww: Vec4s
    get() = Vec4s(x, z, w, w)
val Vec4s.xwxx: Vec4s
    get() = Vec4s(x, w, x, x)
val Vec4s.xwxy: Vec4s
    get() = Vec4s(x, w, x, y)
val Vec4s.xwxz: Vec4s
    get() = Vec4s(x, w, x, z)
val Vec4s.xwxw: Vec4s
    get() = Vec4s(x, w, x, w)
val Vec4s.xwyx: Vec4s
    get() = Vec4s(x, w, y, x)
val Vec4s.xwyy: Vec4s
    get() = Vec4s(x, w, y, y)
var Vec4s.xwyz
    get() = Vec4s(x, w, y, z)
    set(value) = put(value.x, value.w, value.y, value.z)
val Vec4s.xwyw: Vec4s
    get() = Vec4s(x, w, y, w)
val Vec4s.xwzx: Vec4s
    get() = Vec4s(x, w, z, x)
var Vec4s.xwzy: Vec4s
    get() = Vec4s(x, w, z, y)
    set(value) = put(value.x, value.w, value.z, value.y)
val Vec4s.xwzz: Vec4s
    get() = Vec4s(x, w, z, z)
val Vec4s.xwzw: Vec4s
    get() = Vec4s(x, w, z, w)
val Vec4s.xwwx: Vec4s
    get() = Vec4s(x, w, w, x)
val Vec4s.xwwy: Vec4s
    get() = Vec4s(x, w, w, y)
val Vec4s.xwwz: Vec4s
    get() = Vec4s(x, w, w, z)
val Vec4s.xwww: Vec4s
    get() = Vec4s(x, w, w, w)
val Vec4s.yxxx: Vec4s
    get() = Vec4s(y, x, x, x)
val Vec4s.yxxy: Vec4s
    get() = Vec4s(y, x, x, y)
val Vec4s.yxxz: Vec4s
    get() = Vec4s(y, x, x, z)
val Vec4s.yxxw: Vec4s
    get() = Vec4s(y, x, x, w)
val Vec4s.yxyx: Vec4s
    get() = Vec4s(y, x, y, x)
val Vec4s.yxyy: Vec4s
    get() = Vec4s(y, x, y, y)
val Vec4s.yxyz: Vec4s
    get() = Vec4s(y, x, y, z)
val Vec4s.yxyw: Vec4s
    get() = Vec4s(y, x, y, w)
val Vec4s.yxzx: Vec4s
    get() = Vec4s(y, x, z, x)
val Vec4s.yxzy: Vec4s
    get() = Vec4s(y, x, z, y)
val Vec4s.yxzz: Vec4s
    get() = Vec4s(y, x, z, z)
var Vec4s.yxzw: Vec4s
    get() = Vec4s(y, x, z, w)
    set(value) = put(value.y, value.x, value.z, value.w)
val Vec4s.yxwx
    get() = Vec4s(y, x, w, x)
val Vec4s.yxwy
    get() = Vec4s(y, x, w, y)
var Vec4s.yxwz
    get() = Vec4s(y, x, w, z)
    set(value) = put(value.y, value.x, value.w, value.z)
val Vec4s.yxww
    get() = Vec4s(y, x, w, w)
val Vec4s.yyxx: Vec4s
    get() = Vec4s(y, y, x, x)
val Vec4s.yyxy: Vec4s
    get() = Vec4s(y, y, x, y)
val Vec4s.yyxz: Vec4s
    get() = Vec4s(y, y, x, z)
val Vec4s.yyxw: Vec4s
    get() = Vec4s(y, y, x, w)
val Vec4s.yyyx: Vec4s
    get() = Vec4s(y, y, y, x)
val Vec4s.yyyy: Vec4s
    get() = Vec4s(y, y, y, y)
val Vec4s.yyyz: Vec4s
    get() = Vec4s(y, y, y, z)
val Vec4s.yyyw: Vec4s
    get() = Vec4s(y, y, y, w)
val Vec4s.yyzx: Vec4s
    get() = Vec4s(y, y, z, x)
val Vec4s.yyzy: Vec4s
    get() = Vec4s(y, y, z, y)
val Vec4s.yyzz: Vec4s
    get() = Vec4s(y, y, z, z)
val Vec4s.yyzw: Vec4s
    get() = Vec4s(y, y, z, w)
val Vec4s.yywx: Vec4s
    get() = Vec4s(y, y, w, x)
val Vec4s.yywy: Vec4s
    get() = Vec4s(y, y, w, y)
val Vec4s.yywz: Vec4s
    get() = Vec4s(y, y, w, z)
val Vec4s.yyww: Vec4s
    get() = Vec4s(y, y, w, w)
val Vec4s.yzxx: Vec4s
    get() = Vec4s(y, z, x, x)
val Vec4s.yzxy: Vec4s
    get() = Vec4s(y, z, x, z)
val Vec4s.yzxz: Vec4s
    get() = Vec4s(y, z, x, z)
var Vec4s.yzxw
    get() = Vec4s(y, z, x, w)
    set(value) = put(value.y, value.z, value.x, value.w)
val Vec4s.yzyx: Vec4s
    get() = Vec4s(y, z, y, x)
val Vec4s.yzyy: Vec4s
    get() = Vec4s(y, z, y, y)
val Vec4s.yzyz: Vec4s
    get() = Vec4s(y, z, y, z)
val Vec4s.yzyw: Vec4s
    get() = Vec4s(y, z, y, w)
val Vec4s.yzzx: Vec4s
    get() = Vec4s(y, z, z, x)
val Vec4s.yzzy: Vec4s
    get() = Vec4s(y, z, z, y)
val Vec4s.yzzz: Vec4s
    get() = Vec4s(y, z, z, z)
val Vec4s.yzzw: Vec4s
    get() = Vec4s(y, z, z, w)
var Vec4s.yzwx
    get() = Vec4s(y, z, w, x)
    set(value) = put(value.y, value.z, value.w, value.x)
val Vec4s.yzwy: Vec4s
    get() = Vec4s(y, z, w, y)
val Vec4s.yzwz: Vec4s
    get() = Vec4s(y, z, w, z)
val Vec4s.yzww: Vec4s
    get() = Vec4s(y, z, w, w)
val Vec4s.ywxx: Vec4s
    get() = Vec4s(y, w, x, x)
val Vec4s.ywxy: Vec4s
    get() = Vec4s(y, w, x, y)
var Vec4s.ywxz: Vec4s
    get() = Vec4s(y, w, x, z)
    set(value) = put(value.y, value.w, value.x, value.z)
val Vec4s.ywxw: Vec4s
    get() = Vec4s(y, w, x, w)
val Vec4s.ywyx: Vec4s
    get() = Vec4s(y, w, y, x)
val Vec4s.ywyy: Vec4s
    get() = Vec4s(y, w, y, y)
val Vec4s.ywyz: Vec4s
    get() = Vec4s(y, w, y, z)
val Vec4s.ywyw: Vec4s
    get() = Vec4s(y, w, y, w)
var Vec4s.ywzx: Vec4s
    get() = Vec4s(y, w, z, x)
    set(value) = put(value.y, value.w, value.z, value.x)
val Vec4s.ywzy: Vec4s
    get() = Vec4s(y, w, z, y)
val Vec4s.ywzz: Vec4s
    get() = Vec4s(y, w, z, z)
val Vec4s.ywzw: Vec4s
    get() = Vec4s(y, w, z, w)
val Vec4s.ywwx: Vec4s
    get() = Vec4s(y, w, w, x)
val Vec4s.ywwy: Vec4s
    get() = Vec4s(y, w, w, y)
val Vec4s.ywwz: Vec4s
    get() = Vec4s(y, w, w, z)
val Vec4s.ywww: Vec4s
    get() = Vec4s(y, w, w, w)
val Vec4s.zxxx: Vec4s
    get() = Vec4s(z, x, x, x)
val Vec4s.zxxy: Vec4s
    get() = Vec4s(z, x, x, y)
val Vec4s.zxxz: Vec4s
    get() = Vec4s(z, x, x, z)
val Vec4s.zxxw: Vec4s
    get() = Vec4s(z, x, x, w)
val Vec4s.zxyx: Vec4s
    get() = Vec4s(z, x, y, x)
val Vec4s.zxyy: Vec4s
    get() = Vec4s(z, x, y, y)
val Vec4s.zxyz: Vec4s
    get() = Vec4s(z, x, y, z)
var Vec4s.zxyw: Vec4s
    get() = Vec4s(z, x, y, w)
    set(value) = put(value.z, value.x, value.y, value.w)
val Vec4s.zxzx: Vec4s
    get() = Vec4s(z, x, z, x)
val Vec4s.zxzy: Vec4s
    get() = Vec4s(z, x, z, y)
val Vec4s.zxzz: Vec4s
    get() = Vec4s(z, x, z, z)
val Vec4s.zxzw: Vec4s
    get() = Vec4s(z, x, w, x)
val Vec4s.zxwx: Vec4s
    get() = Vec4s(z, x, w, x)
var Vec4s.zxwy: Vec4s
    get() = Vec4s(z, x, w, y)
    set(value) = put(value.z, value.x, value.w, value.y)
val Vec4s.zxwz: Vec4s
    get() = Vec4s(z, x, w, y)
val Vec4s.zxww: Vec4s
    get() = Vec4s(z, x, w, w)
val Vec4s.zyxx: Vec4s
    get() = Vec4s(z, y, x, x)
val Vec4s.zyxy: Vec4s
    get() = Vec4s(z, y, x, y)
val Vec4s.zyxz: Vec4s
    get() = Vec4s(z, y, x, z)
var Vec4s.zyxw: Vec4s
    get() = Vec4s(z, y, x, w)
    set(value) = put(value.z, value.y, value.x, value.w)
val Vec4s.zyyx: Vec4s
    get() = Vec4s(z, y, y, x)
val Vec4s.zyyy: Vec4s
    get() = Vec4s(z, y, y, y)
val Vec4s.zyyz: Vec4s
    get() = Vec4s(z, y, y, z)
val Vec4s.zyyw: Vec4s
    get() = Vec4s(z, y, y, w)
val Vec4s.zyzx: Vec4s
    get() = Vec4s(z, y, z, x)
val Vec4s.zyzy: Vec4s
    get() = Vec4s(z, y, z, y)
val Vec4s.zyzz: Vec4s
    get() = Vec4s(z, y, z, z)
val Vec4s.zyzw: Vec4s
    get() = Vec4s(z, y, z, w)
var Vec4s.zywx: Vec4s
    get() = Vec4s(z, y, w, x)
    set(value) = put(value.z, value.y, value.w, value.x)
val Vec4s.zywy: Vec4s
    get() = Vec4s(z, y, w, y)
val Vec4s.zywz: Vec4s
    get() = Vec4s(z, y, w, z)
val Vec4s.zyww: Vec4s
    get() = Vec4s(z, y, w, w)
val Vec4s.zzxx: Vec4s
    get() = Vec4s(z, z, x, x)
val Vec4s.zzxy: Vec4s
    get() = Vec4s(z, z, x, y)
val Vec4s.zzxz: Vec4s
    get() = Vec4s(z, z, x, z)
val Vec4s.zzxw: Vec4s
    get() = Vec4s(z, z, x, w)
val Vec4s.zzyx: Vec4s
    get() = Vec4s(z, z, y, x)
val Vec4s.zzyy: Vec4s
    get() = Vec4s(z, z, y, y)
val Vec4s.zzyz: Vec4s
    get() = Vec4s(z, z, y, z)
val Vec4s.zzyw: Vec4s
    get() = Vec4s(z, z, y, w)
val Vec4s.zzzx: Vec4s
    get() = Vec4s(z, z, z, x)
val Vec4s.zzzy: Vec4s
    get() = Vec4s(z, z, z, y)
val Vec4s.zzzz: Vec4s
    get() = Vec4s(z, z, z, z)
val Vec4s.zzzw: Vec4s
    get() = Vec4s(z, z, z, w)
val Vec4s.zzwx: Vec4s
    get() = Vec4s(z, z, w, x)
val Vec4s.zzwy: Vec4s
    get() = Vec4s(z, z, w, y)
val Vec4s.zzwz: Vec4s
    get() = Vec4s(z, z, w, z)
val Vec4s.zzww: Vec4s
    get() = Vec4s(z, z, w, w)
val Vec4s.zwxx: Vec4s
    get() = Vec4s(z, w, x, x)
var Vec4s.zwxy: Vec4s
    get() = Vec4s(z, w, x, y)
    set(value) = put(value.z, value.w, value.x, value.y)
val Vec4s.zwxz: Vec4s
    get() = Vec4s(z, w, x, z)
val Vec4s.zwxw: Vec4s
    get() = Vec4s(z, w, x, w)
var Vec4s.zwyx: Vec4s
    get() = Vec4s(z, w, y, x)
    set(value) = put(value.z, value.w, value.y, value.x)
val Vec4s.zwyy: Vec4s
    get() = Vec4s(z, w, y, y)
val Vec4s.zwyz: Vec4s
    get() = Vec4s(z, w, y, z)
val Vec4s.zwyw: Vec4s
    get() = Vec4s(z, w, y, w)
val Vec4s.zwzx: Vec4s
    get() = Vec4s(z, w, z, x)
val Vec4s.zwzy: Vec4s
    get() = Vec4s(z, w, z, y)
val Vec4s.zwzz: Vec4s
    get() = Vec4s(z, w, z, z)
val Vec4s.zwzw: Vec4s
    get() = Vec4s(z, w, z, w)
val Vec4s.zwwx: Vec4s
    get() = Vec4s(z, w, w, y)
val Vec4s.zwwy: Vec4s
    get() = Vec4s(z, w, w, y)
val Vec4s.zwwz: Vec4s
    get() = Vec4s(z, w, w, z)
val Vec4s.zwww: Vec4s
    get() = Vec4s(z, w, w, w)
val Vec4s.wxxx: Vec4s
    get() = Vec4s(w, x, x, x)
val Vec4s.wxxy: Vec4s
    get() = Vec4s(w, x, x, y)
val Vec4s.wxxz: Vec4s
    get() = Vec4s(w, x, x, z)
val Vec4s.wxxw: Vec4s
    get() = Vec4s(w, x, x, w)
val Vec4s.wxyx: Vec4s
    get() = Vec4s(w, x, y, x)
val Vec4s.wxyy: Vec4s
    get() = Vec4s(w, x, y, y)
var Vec4s.wxyz: Vec4s
    get() = Vec4s(w, x, y, z)
    set(value) = put(value.w, value.x, value.y, value.z)
val Vec4s.wxyw: Vec4s
    get() = Vec4s(w, x, y, w)
val Vec4s.wxzx: Vec4s
    get() = Vec4s(w, x, z, x)
var Vec4s.wxzy: Vec4s
    get() = Vec4s(w, x, z, y)
    set(value) = put(value.w, value.x, value.z, value.y)
val Vec4s.wxzz: Vec4s
    get() = Vec4s(w, x, z, z)
val Vec4s.wxzw: Vec4s
    get() = Vec4s(w, x, z, w)
val Vec4s.wxwx: Vec4s
    get() = Vec4s(w, x, w, x)
val Vec4s.wxwy: Vec4s
    get() = Vec4s(w, x, w, y)
val Vec4s.wxwz: Vec4s
    get() = Vec4s(w, x, w, z)
val Vec4s.wxww: Vec4s
    get() = Vec4s(w, x, w, w)
val Vec4s.wyxx: Vec4s
    get() = Vec4s(w, y, x, x)
val Vec4s.wyxy: Vec4s
    get() = Vec4s(w, y, x, y)
var Vec4s.wyxz: Vec4s
    get() = Vec4s(w, y, x, z)
    set(value) = put(value.w, value.y, value.x, value.z)
val Vec4s.wyxw: Vec4s
    get() = Vec4s(w, y, x, w)
val Vec4s.wyyx: Vec4s
    get() = Vec4s(w, y, y, x)
val Vec4s.wyyy: Vec4s
    get() = Vec4s(w, y, y, y)
val Vec4s.wyyz: Vec4s
    get() = Vec4s(w, y, y, z)
val Vec4s.wyyw: Vec4s
    get() = Vec4s(w, y, y, w)
var Vec4s.wyzx: Vec4s
    get() = Vec4s(w, y, z, x)
    set(value) = put(value.w, value.y, value.z, value.x)
val Vec4s.wyzy: Vec4s
    get() = Vec4s(w, y, z, y)
val Vec4s.wyzz: Vec4s
    get() = Vec4s(w, y, z, z)
val Vec4s.wyzw: Vec4s
    get() = Vec4s(w, y, z, w)
val Vec4s.wywx: Vec4s
    get() = Vec4s(w, y, w, x)
val Vec4s.wywy: Vec4s
    get() = Vec4s(w, y, w, y)
val Vec4s.wywz: Vec4s
    get() = Vec4s(w, y, w, z)
val Vec4s.wyww: Vec4s
    get() = Vec4s(w, y, w, w)
val Vec4s.wzxx: Vec4s
    get() = Vec4s(w, z, x, x)
var Vec4s.wzxy: Vec4s
    get() = Vec4s(w, z, x, y)
    set(value) = put(value.w, value.z, value.x, value.y)
val Vec4s.wzxz: Vec4s
    get() = Vec4s(w, z, x, z)
val Vec4s.wzxw: Vec4s
    get() = Vec4s(w, z, x, w)
var Vec4s.wzyx: Vec4s
    get() = Vec4s(w, z, y, x)
    set(value) = put(value.w, value.z, value.y, value.x)
val Vec4s.wzyy: Vec4s
    get() = Vec4s(w, z, y, y)
val Vec4s.wzyz: Vec4s
    get() = Vec4s(w, z, y, z)
val Vec4s.wzyw: Vec4s
    get() = Vec4s(w, z, y, w)
val Vec4s.wzzx: Vec4s
    get() = Vec4s(w, z, z, x)
val Vec4s.wzzy: Vec4s
    get() = Vec4s(w, z, z, y)
val Vec4s.wzzz: Vec4s
    get() = Vec4s(w, z, z, z)
val Vec4s.wzzw: Vec4s
    get() = Vec4s(w, z, z, w)
val Vec4s.wzwx: Vec4s
    get() = Vec4s(w, z, w, x)
val Vec4s.wzwy: Vec4s
    get() = Vec4s(w, z, w, y)
val Vec4s.wzwz: Vec4s
    get() = Vec4s(w, z, w, z)
val Vec4s.wzww: Vec4s
    get() = Vec4s(w, z, w, w)
val Vec4s.wwxx: Vec4s
    get() = Vec4s(w, w, x, x)
val Vec4s.wwxy: Vec4s
    get() = Vec4s(w, w, x, y)
val Vec4s.wwxz: Vec4s
    get() = Vec4s(w, w, x, z)
val Vec4s.wwxw: Vec4s
    get() = Vec4s(w, w, x, w)
val Vec4s.wwyx: Vec4s
    get() = Vec4s(w, w, y, x)
val Vec4s.wwyy: Vec4s
    get() = Vec4s(w, w, y, y)
val Vec4s.wwyz: Vec4s
    get() = Vec4s(w, w, y, z)
val Vec4s.wwyw: Vec4s
    get() = Vec4s(w, w, y, w)
val Vec4s.wwzx: Vec4s
    get() = Vec4s(w, w, z, x)
val Vec4s.wwzy: Vec4s
    get() = Vec4s(w, w, z, y)
val Vec4s.wwzz: Vec4s
    get() = Vec4s(w, w, z, z)
val Vec4s.wwzw: Vec4s
    get() = Vec4s(w, w, z, w)
val Vec4s.wwwx: Vec4s
    get() = Vec4s(w, w, w, x)
val Vec4s.wwwy: Vec4s
    get() = Vec4s(w, w, w, y)
val Vec4s.wwwz: Vec4s
    get() = Vec4s(w, w, w, z)
val Vec4s.wwww: Vec4s
    get() = Vec4s(w, w, w, w)