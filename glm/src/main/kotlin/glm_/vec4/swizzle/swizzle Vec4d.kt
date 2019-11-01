package glm_.vec4.swizzle

import glm_.vec2.Vec2d
import glm_.vec3.Vec3d
import glm_.vec4.Vec4d

val Vec4d.xx: Vec2d
    get() = Vec2d(x, x)
var Vec4d.xy: Vec2d
    get() = Vec2d(x, y)
    set(value) {
        x = value.x
        y = value.y
    }
var Vec4d.xz: Vec2d
    get() = Vec2d(x, z)
    set(value) {
        x = value.x
        z = value.y
    }
var Vec4d.xw: Vec2d
    get() = Vec2d(x, w)
    set(value) {
        x = value.x
        w = value.y
    }
var Vec4d.yx: Vec2d
    get() = Vec2d(y, x)
    set(value) {
        y = value.x
        x = value.y
    }
val Vec4d.yy: Vec2d
    get() = Vec2d(y, y)
var Vec4d.yz: Vec2d
    get() = Vec2d(y, z)
    set(value) {
        y = value.x
        z = value.y
    }
var Vec4d.yw: Vec2d
    get() = Vec2d(y, w)
    set(value) {
        y = value.x
        w = value.y
    }
var Vec4d.zx: Vec2d
    get() = Vec2d(z, x)
    set(value) {
        z = value.x
        x = value.y
    }
var Vec4d.zy: Vec2d
    get() = Vec2d(z, y)
    set(value) {
        z = value.x
        y = value.y
    }
val Vec4d.zz: Vec2d
    get() = Vec2d(z, z)
var Vec4d.zw: Vec2d
    get() = Vec2d(z, w)
    set(value) {
        z = value.x
        w = value.y
    }
var Vec4d.wx: Vec2d
    get() = Vec2d(w, x)
    set(value) {
        w = value.x
        x = value.y
    }
var Vec4d.wy: Vec2d
    get() = Vec2d(w, y)
    set(value) {
        w = value.x
        y = value.y
    }
var Vec4d.wz: Vec2d
    get() = Vec2d(w, z)
    set(value) {
        w = value.x
        z = value.y
    }
val Vec4d.ww: Vec2d
    get() = Vec2d(w, w)


val Vec4d.xxx: Vec3d
    get() = Vec3d(x, x, x)
val Vec4d.xxy: Vec3d
    get() = Vec3d(x, x, y)
val Vec4d.xxz: Vec3d
    get() = Vec3d(x, x, z)
val Vec4d.xxw: Vec3d
    get() = Vec3d(x, x, w)
val Vec4d.xyx: Vec3d
    get() = Vec3d(x, y, x)
val Vec4d.xyy: Vec3d
    get() = Vec3d(x, y, y)
var Vec4d.xyz: Vec3d
    get() = Vec3d(x, y, z)
    set(value) {
        x = value.x
        y = value.y
        z = value.z
    }

var Vec4d.xyw: Vec3d
    get() = Vec3d(x, y, w)
    set(value) {
        x = value.x
        y = value.y
        w = value.z
    }

val Vec4d.xzx: Vec3d
    get() = Vec3d(x, z, x)
var Vec4d.xzy: Vec3d
    get() = Vec3d(x, z, y)
    set(value) {
        x = value.x
        z = value.y
        y = value.z
    }

val Vec4d.xzz: Vec3d
    get() = Vec3d(x, z, z)
var Vec4d.xzw: Vec3d
    get() = Vec3d(x, z, w)
    set(value) {
        x = value.x
        z = value.y
        w = value.z
    }

val Vec4d.xwx: Vec3d
    get() = Vec3d(x, w, x)
var Vec4d.xwy: Vec3d
    get() = Vec3d(x, w, y)
    set(value) {
        x = value.x
        w = value.y
        y = value.z
    }

var Vec4d.xwz: Vec3d
    get() = Vec3d(x, w, z)
    set(value) {
        x = value.x
        w = value.y
        z = value.z
    }

val Vec4d.xww: Vec3d
    get() = Vec3d(x, w, w)

val Vec4d.yxx: Vec3d
    get() = Vec3d(y, x, x)
val Vec4d.yxy: Vec3d
    get() = Vec3d(y, x, y)
var Vec4d.yxz: Vec3d
    get() = Vec3d(y, x, z)
    set(value) {
        y = value.x
        x = value.y
        z = value.z
    }

var Vec4d.yxw: Vec3d
    get() = Vec3d(y, x, w)
    set(value) {
        y = value.x
        x = value.y
        w = value.z
    }

val Vec4d.yyx: Vec3d
    get() = Vec3d(y, y, x)
val Vec4d.yyy: Vec3d
    get() = Vec3d(y, y, y)
val Vec4d.yyz: Vec3d
    get() = Vec3d(y, y, z)
val Vec4d.yyw: Vec3d
    get() = Vec3d(y, y, w)
var Vec4d.yzx: Vec3d
    get() = Vec3d(y, z, x)
    set(value) {
        y = value.x
        z = value.y
        x = value.z
    }

val Vec4d.yzy: Vec3d
    get() = Vec3d(y, z, y)
val Vec4d.yzz: Vec3d
    get() = Vec3d(y, z, z)
var Vec4d.yzw: Vec3d
    get() = Vec3d(y, z, w)
    set(value) {
        y = value.x
        z = value.y
        w = value.z
    }
var Vec4d.ywx: Vec3d
    get() = Vec3d(y, w, x)
    set(value) {
        y = value.x
        w = value.y
        x = value.z
    }
val Vec4d.ywy: Vec3d
    get() = Vec3d(y, w, y)
var Vec4d.ywz: Vec3d
    get() = Vec3d(y, w, z)
    set(value) {
        y = value.x
        w = value.y
        z = value.z
    }
val Vec4d.yww: Vec3d
    get() = Vec3d(y, w, w)

val Vec4d.zxx: Vec3d
    get() = Vec3d(z, x, x)
var Vec4d.zxy: Vec3d
    get() = Vec3d(z, x, y)
    set(value) {
        z = value.x
        x = value.y
        y = value.z
    }

val Vec4d.zxz: Vec3d
    get() = Vec3d(z, x, z)
var Vec4d.zxw: Vec3d
    get() = Vec3d(z, x, w)
    set(value) {
        z = value.x
        x = value.y
        w = value.z
    }

var Vec4d.zyx: Vec3d
    get() = Vec3d(z, y, x)
    set(value) {
        z = value.x
        y = value.y
        x = value.z
    }

val Vec4d.zyy: Vec3d
    get() = Vec3d(z, y, y)
val Vec4d.zyz: Vec3d
    get() = Vec3d(z, y, z)
var Vec4d.zyw: Vec3d
    get() = Vec3d(z, y, w)
    set(value) {
        z = value.x
        y = value.y
        w = value.z
    }

val Vec4d.zzx: Vec3d
    get() = Vec3d(z, z, x)
val Vec4d.zzy: Vec3d
    get() = Vec3d(z, z, y)
val Vec4d.zzz: Vec3d
    get() = Vec3d(z, z, z)
val Vec4d.zzw: Vec3d
    get() = Vec3d(z, z, w)

var Vec4d.zwx: Vec3d
    get() = Vec3d(z, w, x)
    set(value) {
        z = value.x
        w = value.y
        x = value.z
    }
var Vec4d.zwy: Vec3d
    get() = Vec3d(z, w, y)
    set(value) {
        z = value.x
        w = value.y
        y = value.z
    }
val Vec4d.zwz: Vec3d
    get() = Vec3d(z, w, z)
val Vec4d.zww: Vec3d
    get() = Vec3d(z, w, w)

val Vec4d.wxx: Vec3d
    get() = Vec3d(w, x, x)
var Vec4d.wxy: Vec3d
    get() = Vec3d(w, x, y)
    set(value) {
        w = value.x
        x = value.y
        y = value.z
    }

var Vec4d.wxz: Vec3d
    get() = Vec3d(w, x, z)
    set(value) {
        w = value.x
        x = value.y
        z = value.z
    }

val Vec4d.wxw: Vec3d
    get() = Vec3d(w, x, w)
var Vec4d.wyx: Vec3d
    get() = Vec3d(w, y, x)
    set(value) {
        w = value.x
        y = value.y
        x = value.z
    }

val Vec4d.wyy: Vec3d
    get() = Vec3d(w, y, y)
var Vec4d.wyz: Vec3d
    get() = Vec3d(w, y, z)
    set(value) {
        w = value.x
        y = value.y
        z = value.z
    }

val Vec4d.wyw: Vec3d
    get() = Vec3d(w, y, w)
var Vec4d.wzx: Vec3d
    get() = Vec3d(w, z, x)
    set(value) {
        w = value.x
        z = value.y
        x = value.z
    }

var Vec4d.wzy: Vec3d
    get() = Vec3d(w, z, y)
    set(value) {
        w = value.x
        z = value.y
        y = value.z
    }
val Vec4d.wzz: Vec3d
    get() = Vec3d(w, z, z)

val Vec4d.wzw: Vec3d
    get() = Vec3d(w, z, w)
val Vec4d.wwx: Vec3d
    get() = Vec3d(w, w, x)
val Vec4d.wwy: Vec3d
    get() = Vec3d(w, w, y)
val Vec4d.wwz: Vec3d
    get() = Vec3d(w, w, z)
val Vec4d.www: Vec3d
    get() = Vec3d(w, w, w)

val Vec4d.xxxx: Vec4d
    get() = Vec4d(x, x, x, x)
val Vec4d.xxxy: Vec4d
    get() = Vec4d(x, x, x, y)
val Vec4d.xxxz: Vec4d
    get() = Vec4d(x, x, x, z)
val Vec4d.xxxw: Vec4d
    get() = Vec4d(x, x, x, w)
val Vec4d.xxyx: Vec4d
    get() = Vec4d(x, x, y, x)
val Vec4d.xxyy: Vec4d
    get() = Vec4d(x, x, y, y)
val Vec4d.xxyz: Vec4d
    get() = Vec4d(x, x, y, z)
val Vec4d.xxyw: Vec4d
    get() = Vec4d(x, x, y, w)
val Vec4d.xxzx: Vec4d
    get() = Vec4d(x, x, z, x)
val Vec4d.xxzy: Vec4d
    get() = Vec4d(x, x, z, y)
val Vec4d.xxzz: Vec4d
    get() = Vec4d(x, x, z, z)
val Vec4d.xxzw: Vec4d
    get() = Vec4d(x, x, z, w)
val Vec4d.xxwx: Vec4d
    get() = Vec4d(x, x, w, x)
val Vec4d.xxwy: Vec4d
    get() = Vec4d(x, x, w, y)
val Vec4d.xxwz: Vec4d
    get() = Vec4d(x, x, w, z)
val Vec4d.xxww: Vec4d
    get() = Vec4d(x, x, w, w)
val Vec4d.xyxx: Vec4d
    get() = Vec4d(x, y, x, x)
val Vec4d.xyxy: Vec4d
    get() = Vec4d(x, y, x, y)
val Vec4d.xyxz: Vec4d
    get() = Vec4d(x, y, x, z)
val Vec4d.xyxw: Vec4d
    get() = Vec4d(x, y, x, w)
val Vec4d.xyyx: Vec4d
    get() = Vec4d(x, y, y, x)
val Vec4d.xyyy: Vec4d
    get() = Vec4d(x, y, y, y)
val Vec4d.xyyz: Vec4d
    get() = Vec4d(x, y, y, w)
val Vec4d.xyyw: Vec4d
    get() = Vec4d(x, y, y, w)
val Vec4d.xyzx: Vec4d
    get() = Vec4d(x, y, z, x)
val Vec4d.xyzy: Vec4d
    get() = Vec4d(x, y, z, y)
val Vec4d.xyzz: Vec4d
    get() = Vec4d(x, y, z, z)
var Vec4d.xyzw
    get() = Vec4d(x, y, z, w)
    set(value) = put(value.x, value.y, value.z, value.w)
val Vec4d.xywx
    get() = Vec4d(x, y, w, x)
val Vec4d.xywy
    get() = Vec4d(x, y, w, y)
var Vec4d.xywz
    get() = Vec4d(x, y, w, z)
    set(value) = put(value.x, value.y, value.w, value.z)
val Vec4d.xyww: Vec4d
    get() = Vec4d(x, y, w, w)
val Vec4d.xzxx: Vec4d
    get() = Vec4d(x, z, x, x)
val Vec4d.xzxy: Vec4d
    get() = Vec4d(x, z, x, y)
val Vec4d.xzxz: Vec4d
    get() = Vec4d(x, z, x, z)
val Vec4d.xzxw: Vec4d
    get() = Vec4d(x, z, x, w)
val Vec4d.xzyx: Vec4d
    get() = Vec4d(x, z, y, x)
val Vec4d.xzyy: Vec4d
    get() = Vec4d(x, z, y, y)
val Vec4d.xzyz: Vec4d
    get() = Vec4d(x, z, y, z)
var Vec4d.xzyw
    get() = Vec4d(x, z, y, w)
    set(value) = put(value.x, value.z, value.y, value.w)
val Vec4d.xzzx: Vec4d
    get() = Vec4d(x, z, z, x)
val Vec4d.xzzy: Vec4d
    get() = Vec4d(x, z, z, y)
val Vec4d.xzzz: Vec4d
    get() = Vec4d(x, z, z, z)
val Vec4d.xzzw: Vec4d
    get() = Vec4d(x, z, z, w)
val Vec4d.xzwx: Vec4d
    get() = Vec4d(x, z, w, x)
var Vec4d.xzwy: Vec4d
    get() = Vec4d(x, z, w, y)
    set(value) = put(value.x, value.z, value.w, value.y)
val Vec4d.xzwz: Vec4d
    get() = Vec4d(x, z, w, z)
val Vec4d.xzww: Vec4d
    get() = Vec4d(x, z, w, w)
val Vec4d.xwxx: Vec4d
    get() = Vec4d(x, w, x, x)
val Vec4d.xwxy: Vec4d
    get() = Vec4d(x, w, x, y)
val Vec4d.xwxz: Vec4d
    get() = Vec4d(x, w, x, z)
val Vec4d.xwxw: Vec4d
    get() = Vec4d(x, w, x, w)
val Vec4d.xwyx: Vec4d
    get() = Vec4d(x, w, y, x)
val Vec4d.xwyy: Vec4d
    get() = Vec4d(x, w, y, y)
var Vec4d.xwyz
    get() = Vec4d(x, w, y, z)
    set(value) = put(value.x, value.w, value.y, value.z)
val Vec4d.xwyw: Vec4d
    get() = Vec4d(x, w, y, w)
val Vec4d.xwzx: Vec4d
    get() = Vec4d(x, w, z, x)
var Vec4d.xwzy: Vec4d
    get() = Vec4d(x, w, z, y)
    set(value) = put(value.x, value.w, value.z, value.y)
val Vec4d.xwzz: Vec4d
    get() = Vec4d(x, w, z, z)
val Vec4d.xwzw: Vec4d
    get() = Vec4d(x, w, z, w)
val Vec4d.xwwx: Vec4d
    get() = Vec4d(x, w, w, x)
val Vec4d.xwwy: Vec4d
    get() = Vec4d(x, w, w, y)
val Vec4d.xwwz: Vec4d
    get() = Vec4d(x, w, w, z)
val Vec4d.xwww: Vec4d
    get() = Vec4d(x, w, w, w)
val Vec4d.yxxx: Vec4d
    get() = Vec4d(y, x, x, x)
val Vec4d.yxxy: Vec4d
    get() = Vec4d(y, x, x, y)
val Vec4d.yxxz: Vec4d
    get() = Vec4d(y, x, x, z)
val Vec4d.yxxw: Vec4d
    get() = Vec4d(y, x, x, w)
val Vec4d.yxyx: Vec4d
    get() = Vec4d(y, x, y, x)
val Vec4d.yxyy: Vec4d
    get() = Vec4d(y, x, y, y)
val Vec4d.yxyz: Vec4d
    get() = Vec4d(y, x, y, z)
val Vec4d.yxyw: Vec4d
    get() = Vec4d(y, x, y, w)
val Vec4d.yxzx: Vec4d
    get() = Vec4d(y, x, z, x)
val Vec4d.yxzy: Vec4d
    get() = Vec4d(y, x, z, y)
val Vec4d.yxzz: Vec4d
    get() = Vec4d(y, x, z, z)
var Vec4d.yxzw: Vec4d
    get() = Vec4d(y, x, z, w)
    set(value) = put(value.y, value.x, value.z, value.w)
val Vec4d.yxwx
    get() = Vec4d(y, x, w, x)
val Vec4d.yxwy
    get() = Vec4d(y, x, w, y)
var Vec4d.yxwz
    get() = Vec4d(y, x, w, z)
    set(value) = put(value.y, value.x, value.w, value.z)
val Vec4d.yxww
    get() = Vec4d(y, x, w, w)
val Vec4d.yyxx: Vec4d
    get() = Vec4d(y, y, x, x)
val Vec4d.yyxy: Vec4d
    get() = Vec4d(y, y, x, y)
val Vec4d.yyxz: Vec4d
    get() = Vec4d(y, y, x, z)
val Vec4d.yyxw: Vec4d
    get() = Vec4d(y, y, x, w)
val Vec4d.yyyx: Vec4d
    get() = Vec4d(y, y, y, x)
val Vec4d.yyyy: Vec4d
    get() = Vec4d(y, y, y, y)
val Vec4d.yyyz: Vec4d
    get() = Vec4d(y, y, y, z)
val Vec4d.yyyw: Vec4d
    get() = Vec4d(y, y, y, w)
val Vec4d.yyzx: Vec4d
    get() = Vec4d(y, y, z, x)
val Vec4d.yyzy: Vec4d
    get() = Vec4d(y, y, z, y)
val Vec4d.yyzz: Vec4d
    get() = Vec4d(y, y, z, z)
val Vec4d.yyzw: Vec4d
    get() = Vec4d(y, y, z, w)
val Vec4d.yywx: Vec4d
    get() = Vec4d(y, y, w, x)
val Vec4d.yywy: Vec4d
    get() = Vec4d(y, y, w, y)
val Vec4d.yywz: Vec4d
    get() = Vec4d(y, y, w, z)
val Vec4d.yyww: Vec4d
    get() = Vec4d(y, y, w, w)
val Vec4d.yzxx: Vec4d
    get() = Vec4d(y, z, x, x)
val Vec4d.yzxy: Vec4d
    get() = Vec4d(y, z, x, z)
val Vec4d.yzxz: Vec4d
    get() = Vec4d(y, z, x, z)
var Vec4d.yzxw
    get() = Vec4d(y, z, x, w)
    set(value) = put(value.y, value.z, value.x, value.w)
val Vec4d.yzyx: Vec4d
    get() = Vec4d(y, z, y, x)
val Vec4d.yzyy: Vec4d
    get() = Vec4d(y, z, y, y)
val Vec4d.yzyz: Vec4d
    get() = Vec4d(y, z, y, z)
val Vec4d.yzyw: Vec4d
    get() = Vec4d(y, z, y, w)
val Vec4d.yzzx: Vec4d
    get() = Vec4d(y, z, z, x)
val Vec4d.yzzy: Vec4d
    get() = Vec4d(y, z, z, y)
val Vec4d.yzzz: Vec4d
    get() = Vec4d(y, z, z, z)
val Vec4d.yzzw: Vec4d
    get() = Vec4d(y, z, z, w)
var Vec4d.yzwx
    get() = Vec4d(y, z, w, x)
    set(value) = put(value.y, value.z, value.w, value.x)
val Vec4d.yzwy: Vec4d
    get() = Vec4d(y, z, w, y)
val Vec4d.yzwz: Vec4d
    get() = Vec4d(y, z, w, z)
val Vec4d.yzww: Vec4d
    get() = Vec4d(y, z, w, w)
val Vec4d.ywxx: Vec4d
    get() = Vec4d(y, w, x, x)
val Vec4d.ywxy: Vec4d
    get() = Vec4d(y, w, x, y)
var Vec4d.ywxz: Vec4d
    get() = Vec4d(y, w, x, z)
    set(value) = put(value.y, value.w, value.x, value.z)
val Vec4d.ywxw: Vec4d
    get() = Vec4d(y, w, x, w)
val Vec4d.ywyx: Vec4d
    get() = Vec4d(y, w, y, x)
val Vec4d.ywyy: Vec4d
    get() = Vec4d(y, w, y, y)
val Vec4d.ywyz: Vec4d
    get() = Vec4d(y, w, y, z)
val Vec4d.ywyw: Vec4d
    get() = Vec4d(y, w, y, w)
var Vec4d.ywzx: Vec4d
    get() = Vec4d(y, w, z, x)
    set(value) = put(value.y, value.w, value.z, value.x)
val Vec4d.ywzy: Vec4d
    get() = Vec4d(y, w, z, y)
val Vec4d.ywzz: Vec4d
    get() = Vec4d(y, w, z, z)
val Vec4d.ywzw: Vec4d
    get() = Vec4d(y, w, z, w)
val Vec4d.ywwx: Vec4d
    get() = Vec4d(y, w, w, x)
val Vec4d.ywwy: Vec4d
    get() = Vec4d(y, w, w, y)
val Vec4d.ywwz: Vec4d
    get() = Vec4d(y, w, w, z)
val Vec4d.ywww: Vec4d
    get() = Vec4d(y, w, w, w)
val Vec4d.zxxx: Vec4d
    get() = Vec4d(z, x, x, x)
val Vec4d.zxxy: Vec4d
    get() = Vec4d(z, x, x, y)
val Vec4d.zxxz: Vec4d
    get() = Vec4d(z, x, x, z)
val Vec4d.zxxw: Vec4d
    get() = Vec4d(z, x, x, w)
val Vec4d.zxyx: Vec4d
    get() = Vec4d(z, x, y, x)
val Vec4d.zxyy: Vec4d
    get() = Vec4d(z, x, y, y)
val Vec4d.zxyz: Vec4d
    get() = Vec4d(z, x, y, z)
var Vec4d.zxyw: Vec4d
    get() = Vec4d(z, x, y, w)
    set(value) = put(value.z, value.x, value.y, value.w)
val Vec4d.zxzx: Vec4d
    get() = Vec4d(z, x, z, x)
val Vec4d.zxzy: Vec4d
    get() = Vec4d(z, x, z, y)
val Vec4d.zxzz: Vec4d
    get() = Vec4d(z, x, z, z)
val Vec4d.zxzw: Vec4d
    get() = Vec4d(z, x, w, x)
val Vec4d.zxwx: Vec4d
    get() = Vec4d(z, x, w, x)
var Vec4d.zxwy: Vec4d
    get() = Vec4d(z, x, w, y)
    set(value) = put(value.z, value.x, value.w, value.y)
val Vec4d.zxwz: Vec4d
    get() = Vec4d(z, x, w, y)
val Vec4d.zxww: Vec4d
    get() = Vec4d(z, x, w, w)
val Vec4d.zyxx: Vec4d
    get() = Vec4d(z, y, x, x)
val Vec4d.zyxy: Vec4d
    get() = Vec4d(z, y, x, y)
val Vec4d.zyxz: Vec4d
    get() = Vec4d(z, y, x, z)
var Vec4d.zyxw: Vec4d
    get() = Vec4d(z, y, x, w)
    set(value) = put(value.z, value.y, value.x, value.w)
val Vec4d.zyyx: Vec4d
    get() = Vec4d(z, y, y, x)
val Vec4d.zyyy: Vec4d
    get() = Vec4d(z, y, y, y)
val Vec4d.zyyz: Vec4d
    get() = Vec4d(z, y, y, z)
val Vec4d.zyyw: Vec4d
    get() = Vec4d(z, y, y, w)
val Vec4d.zyzx: Vec4d
    get() = Vec4d(z, y, z, x)
val Vec4d.zyzy: Vec4d
    get() = Vec4d(z, y, z, y)
val Vec4d.zyzz: Vec4d
    get() = Vec4d(z, y, z, z)
val Vec4d.zyzw: Vec4d
    get() = Vec4d(z, y, z, w)
var Vec4d.zywx: Vec4d
    get() = Vec4d(z, y, w, x)
    set(value) = put(value.z, value.y, value.w, value.x)
val Vec4d.zywy: Vec4d
    get() = Vec4d(z, y, w, y)
val Vec4d.zywz: Vec4d
    get() = Vec4d(z, y, w, z)
val Vec4d.zyww: Vec4d
    get() = Vec4d(z, y, w, w)
val Vec4d.zzxx: Vec4d
    get() = Vec4d(z, z, x, x)
val Vec4d.zzxy: Vec4d
    get() = Vec4d(z, z, x, y)
val Vec4d.zzxz: Vec4d
    get() = Vec4d(z, z, x, z)
val Vec4d.zzxw: Vec4d
    get() = Vec4d(z, z, x, w)
val Vec4d.zzyx: Vec4d
    get() = Vec4d(z, z, y, x)
val Vec4d.zzyy: Vec4d
    get() = Vec4d(z, z, y, y)
val Vec4d.zzyz: Vec4d
    get() = Vec4d(z, z, y, z)
val Vec4d.zzyw: Vec4d
    get() = Vec4d(z, z, y, w)
val Vec4d.zzzx: Vec4d
    get() = Vec4d(z, z, z, x)
val Vec4d.zzzy: Vec4d
    get() = Vec4d(z, z, z, y)
val Vec4d.zzzz: Vec4d
    get() = Vec4d(z, z, z, z)
val Vec4d.zzzw: Vec4d
    get() = Vec4d(z, z, z, w)
val Vec4d.zzwx: Vec4d
    get() = Vec4d(z, z, w, x)
val Vec4d.zzwy: Vec4d
    get() = Vec4d(z, z, w, y)
val Vec4d.zzwz: Vec4d
    get() = Vec4d(z, z, w, z)
val Vec4d.zzww: Vec4d
    get() = Vec4d(z, z, w, w)
val Vec4d.zwxx: Vec4d
    get() = Vec4d(z, w, x, x)
var Vec4d.zwxy: Vec4d
    get() = Vec4d(z, w, x, y)
    set(value) = put(value.z, value.w, value.x, value.y)
val Vec4d.zwxz: Vec4d
    get() = Vec4d(z, w, x, z)
val Vec4d.zwxw: Vec4d
    get() = Vec4d(z, w, x, w)
var Vec4d.zwyx: Vec4d
    get() = Vec4d(z, w, y, x)
    set(value) = put(value.z, value.w, value.y, value.x)
val Vec4d.zwyy: Vec4d
    get() = Vec4d(z, w, y, y)
val Vec4d.zwyz: Vec4d
    get() = Vec4d(z, w, y, z)
val Vec4d.zwyw: Vec4d
    get() = Vec4d(z, w, y, w)
val Vec4d.zwzx: Vec4d
    get() = Vec4d(z, w, z, x)
val Vec4d.zwzy: Vec4d
    get() = Vec4d(z, w, z, y)
val Vec4d.zwzz: Vec4d
    get() = Vec4d(z, w, z, z)
val Vec4d.zwzw: Vec4d
    get() = Vec4d(z, w, z, w)
val Vec4d.zwwx: Vec4d
    get() = Vec4d(z, w, w, y)
val Vec4d.zwwy: Vec4d
    get() = Vec4d(z, w, w, y)
val Vec4d.zwwz: Vec4d
    get() = Vec4d(z, w, w, z)
val Vec4d.zwww: Vec4d
    get() = Vec4d(z, w, w, w)
val Vec4d.wxxx: Vec4d
    get() = Vec4d(w, x, x, x)
val Vec4d.wxxy: Vec4d
    get() = Vec4d(w, x, x, y)
val Vec4d.wxxz: Vec4d
    get() = Vec4d(w, x, x, z)
val Vec4d.wxxw: Vec4d
    get() = Vec4d(w, x, x, w)
val Vec4d.wxyx: Vec4d
    get() = Vec4d(w, x, y, x)
val Vec4d.wxyy: Vec4d
    get() = Vec4d(w, x, y, y)
var Vec4d.wxyz: Vec4d
    get() = Vec4d(w, x, y, z)
    set(value) = put(value.w, value.x, value.y, value.z)
val Vec4d.wxyw: Vec4d
    get() = Vec4d(w, x, y, w)
val Vec4d.wxzx: Vec4d
    get() = Vec4d(w, x, z, x)
var Vec4d.wxzy: Vec4d
    get() = Vec4d(w, x, z, y)
    set(value) = put(value.w, value.x, value.z, value.y)
val Vec4d.wxzz: Vec4d
    get() = Vec4d(w, x, z, z)
val Vec4d.wxzw: Vec4d
    get() = Vec4d(w, x, z, w)
val Vec4d.wxwx: Vec4d
    get() = Vec4d(w, x, w, x)
val Vec4d.wxwy: Vec4d
    get() = Vec4d(w, x, w, y)
val Vec4d.wxwz: Vec4d
    get() = Vec4d(w, x, w, z)
val Vec4d.wxww: Vec4d
    get() = Vec4d(w, x, w, w)
val Vec4d.wyxx: Vec4d
    get() = Vec4d(w, y, x, x)
val Vec4d.wyxy: Vec4d
    get() = Vec4d(w, y, x, y)
var Vec4d.wyxz: Vec4d
    get() = Vec4d(w, y, x, z)
    set(value) = put(value.w, value.y, value.x, value.z)
val Vec4d.wyxw: Vec4d
    get() = Vec4d(w, y, x, w)
val Vec4d.wyyx: Vec4d
    get() = Vec4d(w, y, y, x)
val Vec4d.wyyy: Vec4d
    get() = Vec4d(w, y, y, y)
val Vec4d.wyyz: Vec4d
    get() = Vec4d(w, y, y, z)
val Vec4d.wyyw: Vec4d
    get() = Vec4d(w, y, y, w)
var Vec4d.wyzx: Vec4d
    get() = Vec4d(w, y, z, x)
    set(value) = put(value.w, value.y, value.z, value.x)
val Vec4d.wyzy: Vec4d
    get() = Vec4d(w, y, z, y)
val Vec4d.wyzz: Vec4d
    get() = Vec4d(w, y, z, z)
val Vec4d.wyzw: Vec4d
    get() = Vec4d(w, y, z, w)
val Vec4d.wywx: Vec4d
    get() = Vec4d(w, y, w, x)
val Vec4d.wywy: Vec4d
    get() = Vec4d(w, y, w, y)
val Vec4d.wywz: Vec4d
    get() = Vec4d(w, y, w, z)
val Vec4d.wyww: Vec4d
    get() = Vec4d(w, y, w, w)
val Vec4d.wzxx: Vec4d
    get() = Vec4d(w, z, x, x)
var Vec4d.wzxy: Vec4d
    get() = Vec4d(w, z, x, y)
    set(value) = put(value.w, value.z, value.x, value.y)
val Vec4d.wzxz: Vec4d
    get() = Vec4d(w, z, x, z)
val Vec4d.wzxw: Vec4d
    get() = Vec4d(w, z, x, w)
var Vec4d.wzyx: Vec4d
    get() = Vec4d(w, z, y, x)
    set(value) = put(value.w, value.z, value.y, value.x)
val Vec4d.wzyy: Vec4d
    get() = Vec4d(w, z, y, y)
val Vec4d.wzyz: Vec4d
    get() = Vec4d(w, z, y, z)
val Vec4d.wzyw: Vec4d
    get() = Vec4d(w, z, y, w)
val Vec4d.wzzx: Vec4d
    get() = Vec4d(w, z, z, x)
val Vec4d.wzzy: Vec4d
    get() = Vec4d(w, z, z, y)
val Vec4d.wzzz: Vec4d
    get() = Vec4d(w, z, z, z)
val Vec4d.wzzw: Vec4d
    get() = Vec4d(w, z, z, w)
val Vec4d.wzwx: Vec4d
    get() = Vec4d(w, z, w, x)
val Vec4d.wzwy: Vec4d
    get() = Vec4d(w, z, w, y)
val Vec4d.wzwz: Vec4d
    get() = Vec4d(w, z, w, z)
val Vec4d.wzww: Vec4d
    get() = Vec4d(w, z, w, w)
val Vec4d.wwxx: Vec4d
    get() = Vec4d(w, w, x, x)
val Vec4d.wwxy: Vec4d
    get() = Vec4d(w, w, x, y)
val Vec4d.wwxz: Vec4d
    get() = Vec4d(w, w, x, z)
val Vec4d.wwxw: Vec4d
    get() = Vec4d(w, w, x, w)
val Vec4d.wwyx: Vec4d
    get() = Vec4d(w, w, y, x)
val Vec4d.wwyy: Vec4d
    get() = Vec4d(w, w, y, y)
val Vec4d.wwyz: Vec4d
    get() = Vec4d(w, w, y, z)
val Vec4d.wwyw: Vec4d
    get() = Vec4d(w, w, y, w)
val Vec4d.wwzx: Vec4d
    get() = Vec4d(w, w, z, x)
val Vec4d.wwzy: Vec4d
    get() = Vec4d(w, w, z, y)
val Vec4d.wwzz: Vec4d
    get() = Vec4d(w, w, z, z)
val Vec4d.wwzw: Vec4d
    get() = Vec4d(w, w, z, w)
val Vec4d.wwwx: Vec4d
    get() = Vec4d(w, w, w, x)
val Vec4d.wwwy: Vec4d
    get() = Vec4d(w, w, w, y)
val Vec4d.wwwz: Vec4d
    get() = Vec4d(w, w, w, z)
val Vec4d.wwww: Vec4d
    get() = Vec4d(w, w, w, w)