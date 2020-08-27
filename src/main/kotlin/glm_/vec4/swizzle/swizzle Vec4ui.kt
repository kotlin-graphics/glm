package glm_.vec4.swizzle

import glm_.vec2.Vec2ui
import glm_.vec3.Vec3ui
import glm_.vec4.Vec4ui

val Vec4ui.xx: Vec2ui
    get() = Vec2ui(x, x)
var Vec4ui.xy: Vec2ui
    get() = Vec2ui(x, y)
    set(value) {
        x = value.x
        y = value.y
    }
var Vec4ui.xz: Vec2ui
    get() = Vec2ui(x, z)
    set(value) {
        x = value.x
        z = value.y
    }
var Vec4ui.xw: Vec2ui
    get() = Vec2ui(x, w)
    set(value) {
        x = value.x
        w = value.y
    }
var Vec4ui.yx: Vec2ui
    get() = Vec2ui(y, x)
    set(value) {
        y = value.x
        x = value.y
    }
val Vec4ui.yy: Vec2ui
    get() = Vec2ui(y, y)
var Vec4ui.yz: Vec2ui
    get() = Vec2ui(y, z)
    set(value) {
        y = value.x
        z = value.y
    }
var Vec4ui.yw: Vec2ui
    get() = Vec2ui(y, w)
    set(value) {
        y = value.x
        w = value.y
    }
var Vec4ui.zx: Vec2ui
    get() = Vec2ui(z, x)
    set(value) {
        z = value.x
        x = value.y
    }
var Vec4ui.zy: Vec2ui
    get() = Vec2ui(z, y)
    set(value) {
        z = value.x
        y = value.y
    }
val Vec4ui.zz: Vec2ui
    get() = Vec2ui(z, z)
var Vec4ui.zw: Vec2ui
    get() = Vec2ui(z, w)
    set(value) {
        z = value.x
        w = value.y
    }
var Vec4ui.wx: Vec2ui
    get() = Vec2ui(w, x)
    set(value) {
        w = value.x
        x = value.y
    }
var Vec4ui.wy: Vec2ui
    get() = Vec2ui(w, y)
    set(value) {
        w = value.x
        y = value.y
    }
var Vec4ui.wz: Vec2ui
    get() = Vec2ui(w, z)
    set(value) {
        w = value.x
        z = value.y
    }
val Vec4ui.ww: Vec2ui
    get() = Vec2ui(w, w)


val Vec4ui.xxx: Vec3ui
    get() = Vec3ui(x, x, x)
val Vec4ui.xxy: Vec3ui
    get() = Vec3ui(x, x, y)
val Vec4ui.xxz: Vec3ui
    get() = Vec3ui(x, x, z)
val Vec4ui.xxw: Vec3ui
    get() = Vec3ui(x, x, w)
val Vec4ui.xyx: Vec3ui
    get() = Vec3ui(x, y, x)
val Vec4ui.xyy: Vec3ui
    get() = Vec3ui(x, y, y)
var Vec4ui.xyz: Vec3ui
    get() = Vec3ui(x, y, z)
    set(value) {
        x = value.x
        y = value.y
        z = value.z
    }

var Vec4ui.xyw: Vec3ui
    get() = Vec3ui(x, y, w)
    set(value) {
        x = value.x
        y = value.y
        w = value.z
    }

val Vec4ui.xzx: Vec3ui
    get() = Vec3ui(x, z, x)
var Vec4ui.xzy: Vec3ui
    get() = Vec3ui(x, z, y)
    set(value) {
        x = value.x
        z = value.y
        y = value.z
    }

val Vec4ui.xzz: Vec3ui
    get() = Vec3ui(x, z, z)
var Vec4ui.xzw: Vec3ui
    get() = Vec3ui(x, z, w)
    set(value) {
        x = value.x
        z = value.y
        w = value.z
    }

val Vec4ui.xwx: Vec3ui
    get() = Vec3ui(x, w, x)
var Vec4ui.xwy: Vec3ui
    get() = Vec3ui(x, w, y)
    set(value) {
        x = value.x
        w = value.y
        y = value.z
    }

var Vec4ui.xwz: Vec3ui
    get() = Vec3ui(x, w, z)
    set(value) {
        x = value.x
        w = value.y
        z = value.z
    }

val Vec4ui.xww: Vec3ui
    get() = Vec3ui(x, w, w)

val Vec4ui.yxx: Vec3ui
    get() = Vec3ui(y, x, x)
val Vec4ui.yxy: Vec3ui
    get() = Vec3ui(y, x, y)
var Vec4ui.yxz: Vec3ui
    get() = Vec3ui(y, x, z)
    set(value) {
        y = value.x
        x = value.y
        z = value.z
    }

var Vec4ui.yxw: Vec3ui
    get() = Vec3ui(y, x, w)
    set(value) {
        y = value.x
        x = value.y
        w = value.z
    }

val Vec4ui.yyx: Vec3ui
    get() = Vec3ui(y, y, x)
val Vec4ui.yyy: Vec3ui
    get() = Vec3ui(y, y, y)
val Vec4ui.yyz: Vec3ui
    get() = Vec3ui(y, y, z)
val Vec4ui.yyw: Vec3ui
    get() = Vec3ui(y, y, w)
var Vec4ui.yzx: Vec3ui
    get() = Vec3ui(y, z, x)
    set(value) {
        y = value.x
        z = value.y
        x = value.z
    }

val Vec4ui.yzy: Vec3ui
    get() = Vec3ui(y, z, y)
val Vec4ui.yzz: Vec3ui
    get() = Vec3ui(y, z, z)
var Vec4ui.yzw: Vec3ui
    get() = Vec3ui(y, z, w)
    set(value) {
        y = value.x
        z = value.y
        w = value.z
    }
var Vec4ui.ywx: Vec3ui
    get() = Vec3ui(y, w, x)
    set(value) {
        y = value.x
        w = value.y
        x = value.z
    }
val Vec4ui.ywy: Vec3ui
    get() = Vec3ui(y, w, y)
var Vec4ui.ywz: Vec3ui
    get() = Vec3ui(y, w, z)
    set(value) {
        y = value.x
        w = value.y
        z = value.z
    }
val Vec4ui.yww: Vec3ui
    get() = Vec3ui(y, w, w)

val Vec4ui.zxx: Vec3ui
    get() = Vec3ui(z, x, x)
var Vec4ui.zxy: Vec3ui
    get() = Vec3ui(z, x, y)
    set(value) {
        z = value.x
        x = value.y
        y = value.z
    }

val Vec4ui.zxz: Vec3ui
    get() = Vec3ui(z, x, z)
var Vec4ui.zxw: Vec3ui
    get() = Vec3ui(z, x, w)
    set(value) {
        z = value.x
        x = value.y
        w = value.z
    }

var Vec4ui.zyx: Vec3ui
    get() = Vec3ui(z, y, x)
    set(value) {
        z = value.x
        y = value.y
        x = value.z
    }

val Vec4ui.zyy: Vec3ui
    get() = Vec3ui(z, y, y)
val Vec4ui.zyz: Vec3ui
    get() = Vec3ui(z, y, z)
var Vec4ui.zyw: Vec3ui
    get() = Vec3ui(z, y, w)
    set(value) {
        z = value.x
        y = value.y
        w = value.z
    }

val Vec4ui.zzx: Vec3ui
    get() = Vec3ui(z, z, x)
val Vec4ui.zzy: Vec3ui
    get() = Vec3ui(z, z, y)
val Vec4ui.zzz: Vec3ui
    get() = Vec3ui(z, z, z)
val Vec4ui.zzw: Vec3ui
    get() = Vec3ui(z, z, w)

var Vec4ui.zwx: Vec3ui
    get() = Vec3ui(z, w, x)
    set(value) {
        z = value.x
        w = value.y
        x = value.z
    }
var Vec4ui.zwy: Vec3ui
    get() = Vec3ui(z, w, y)
    set(value) {
        z = value.x
        w = value.y
        y = value.z
    }
val Vec4ui.zwz: Vec3ui
    get() = Vec3ui(z, w, z)
val Vec4ui.zww: Vec3ui
    get() = Vec3ui(z, w, w)

val Vec4ui.wxx: Vec3ui
    get() = Vec3ui(w, x, x)
var Vec4ui.wxy: Vec3ui
    get() = Vec3ui(w, x, y)
    set(value) {
        w = value.x
        x = value.y
        y = value.z
    }

var Vec4ui.wxz: Vec3ui
    get() = Vec3ui(w, x, z)
    set(value) {
        w = value.x
        x = value.y
        z = value.z
    }

val Vec4ui.wxw: Vec3ui
    get() = Vec3ui(w, x, w)
var Vec4ui.wyx: Vec3ui
    get() = Vec3ui(w, y, x)
    set(value) {
        w = value.x
        y = value.y
        x = value.z
    }

val Vec4ui.wyy: Vec3ui
    get() = Vec3ui(w, y, y)
var Vec4ui.wyz: Vec3ui
    get() = Vec3ui(w, y, z)
    set(value) {
        w = value.x
        y = value.y
        z = value.z
    }

val Vec4ui.wyw: Vec3ui
    get() = Vec3ui(w, y, w)
var Vec4ui.wzx: Vec3ui
    get() = Vec3ui(w, z, x)
    set(value) {
        w = value.x
        z = value.y
        x = value.z
    }

var Vec4ui.wzy: Vec3ui
    get() = Vec3ui(w, z, y)
    set(value) {
        w = value.x
        z = value.y
        y = value.z
    }
val Vec4ui.wzz: Vec3ui
    get() = Vec3ui(w, z, z)

val Vec4ui.wzw: Vec3ui
    get() = Vec3ui(w, z, w)
val Vec4ui.wwx: Vec3ui
    get() = Vec3ui(w, w, x)
val Vec4ui.wwy: Vec3ui
    get() = Vec3ui(w, w, y)
val Vec4ui.wwz: Vec3ui
    get() = Vec3ui(w, w, z)
val Vec4ui.www: Vec3ui
    get() = Vec3ui(w, w, w)

val Vec4ui.xxxx: Vec4ui
    get() = Vec4ui(x, x, x, x)
val Vec4ui.xxxy: Vec4ui
    get() = Vec4ui(x, x, x, y)
val Vec4ui.xxxz: Vec4ui
    get() = Vec4ui(x, x, x, z)
val Vec4ui.xxxw: Vec4ui
    get() = Vec4ui(x, x, x, w)
val Vec4ui.xxyx: Vec4ui
    get() = Vec4ui(x, x, y, x)
val Vec4ui.xxyy: Vec4ui
    get() = Vec4ui(x, x, y, y)
val Vec4ui.xxyz: Vec4ui
    get() = Vec4ui(x, x, y, z)
val Vec4ui.xxyw: Vec4ui
    get() = Vec4ui(x, x, y, w)
val Vec4ui.xxzx: Vec4ui
    get() = Vec4ui(x, x, z, x)
val Vec4ui.xxzy: Vec4ui
    get() = Vec4ui(x, x, z, y)
val Vec4ui.xxzz: Vec4ui
    get() = Vec4ui(x, x, z, z)
val Vec4ui.xxzw: Vec4ui
    get() = Vec4ui(x, x, z, w)
val Vec4ui.xxwx: Vec4ui
    get() = Vec4ui(x, x, w, x)
val Vec4ui.xxwy: Vec4ui
    get() = Vec4ui(x, x, w, y)
val Vec4ui.xxwz: Vec4ui
    get() = Vec4ui(x, x, w, z)
val Vec4ui.xxww: Vec4ui
    get() = Vec4ui(x, x, w, w)
val Vec4ui.xyxx: Vec4ui
    get() = Vec4ui(x, y, x, x)
val Vec4ui.xyxy: Vec4ui
    get() = Vec4ui(x, y, x, y)
val Vec4ui.xyxz: Vec4ui
    get() = Vec4ui(x, y, x, z)
val Vec4ui.xyxw: Vec4ui
    get() = Vec4ui(x, y, x, w)
val Vec4ui.xyyx: Vec4ui
    get() = Vec4ui(x, y, y, x)
val Vec4ui.xyyy: Vec4ui
    get() = Vec4ui(x, y, y, y)
val Vec4ui.xyyz: Vec4ui
    get() = Vec4ui(x, y, y, w)
val Vec4ui.xyyw: Vec4ui
    get() = Vec4ui(x, y, y, w)
val Vec4ui.xyzx: Vec4ui
    get() = Vec4ui(x, y, z, x)
val Vec4ui.xyzy: Vec4ui
    get() = Vec4ui(x, y, z, y)
val Vec4ui.xyzz: Vec4ui
    get() = Vec4ui(x, y, z, z)
var Vec4ui.xyzw
    get() = Vec4ui(x, y, z, w)
    set(value) = put(value.x, value.y, value.z, value.w)
val Vec4ui.xywx
    get() = Vec4ui(x, y, w, x)
val Vec4ui.xywy
    get() = Vec4ui(x, y, w, y)
var Vec4ui.xywz
    get() = Vec4ui(x, y, w, z)
    set(value) = put(value.x, value.y, value.w, value.z)
val Vec4ui.xyww: Vec4ui
    get() = Vec4ui(x, y, w, w)
val Vec4ui.xzxx: Vec4ui
    get() = Vec4ui(x, z, x, x)
val Vec4ui.xzxy: Vec4ui
    get() = Vec4ui(x, z, x, y)
val Vec4ui.xzxz: Vec4ui
    get() = Vec4ui(x, z, x, z)
val Vec4ui.xzxw: Vec4ui
    get() = Vec4ui(x, z, x, w)
val Vec4ui.xzyx: Vec4ui
    get() = Vec4ui(x, z, y, x)
val Vec4ui.xzyy: Vec4ui
    get() = Vec4ui(x, z, y, y)
val Vec4ui.xzyz: Vec4ui
    get() = Vec4ui(x, z, y, z)
var Vec4ui.xzyw
    get() = Vec4ui(x, z, y, w)
    set(value) = put(value.x, value.z, value.y, value.w)
val Vec4ui.xzzx: Vec4ui
    get() = Vec4ui(x, z, z, x)
val Vec4ui.xzzy: Vec4ui
    get() = Vec4ui(x, z, z, y)
val Vec4ui.xzzz: Vec4ui
    get() = Vec4ui(x, z, z, z)
val Vec4ui.xzzw: Vec4ui
    get() = Vec4ui(x, z, z, w)
val Vec4ui.xzwx: Vec4ui
    get() = Vec4ui(x, z, w, x)
var Vec4ui.xzwy: Vec4ui
    get() = Vec4ui(x, z, w, y)
    set(value) = put(value.x, value.z, value.w, value.y)
val Vec4ui.xzwz: Vec4ui
    get() = Vec4ui(x, z, w, z)
val Vec4ui.xzww: Vec4ui
    get() = Vec4ui(x, z, w, w)
val Vec4ui.xwxx: Vec4ui
    get() = Vec4ui(x, w, x, x)
val Vec4ui.xwxy: Vec4ui
    get() = Vec4ui(x, w, x, y)
val Vec4ui.xwxz: Vec4ui
    get() = Vec4ui(x, w, x, z)
val Vec4ui.xwxw: Vec4ui
    get() = Vec4ui(x, w, x, w)
val Vec4ui.xwyx: Vec4ui
    get() = Vec4ui(x, w, y, x)
val Vec4ui.xwyy: Vec4ui
    get() = Vec4ui(x, w, y, y)
var Vec4ui.xwyz
    get() = Vec4ui(x, w, y, z)
    set(value) = put(value.x, value.w, value.y, value.z)
val Vec4ui.xwyw: Vec4ui
    get() = Vec4ui(x, w, y, w)
val Vec4ui.xwzx: Vec4ui
    get() = Vec4ui(x, w, z, x)
var Vec4ui.xwzy: Vec4ui
    get() = Vec4ui(x, w, z, y)
    set(value) = put(value.x, value.w, value.z, value.y)
val Vec4ui.xwzz: Vec4ui
    get() = Vec4ui(x, w, z, z)
val Vec4ui.xwzw: Vec4ui
    get() = Vec4ui(x, w, z, w)
val Vec4ui.xwwx: Vec4ui
    get() = Vec4ui(x, w, w, x)
val Vec4ui.xwwy: Vec4ui
    get() = Vec4ui(x, w, w, y)
val Vec4ui.xwwz: Vec4ui
    get() = Vec4ui(x, w, w, z)
val Vec4ui.xwww: Vec4ui
    get() = Vec4ui(x, w, w, w)
val Vec4ui.yxxx: Vec4ui
    get() = Vec4ui(y, x, x, x)
val Vec4ui.yxxy: Vec4ui
    get() = Vec4ui(y, x, x, y)
val Vec4ui.yxxz: Vec4ui
    get() = Vec4ui(y, x, x, z)
val Vec4ui.yxxw: Vec4ui
    get() = Vec4ui(y, x, x, w)
val Vec4ui.yxyx: Vec4ui
    get() = Vec4ui(y, x, y, x)
val Vec4ui.yxyy: Vec4ui
    get() = Vec4ui(y, x, y, y)
val Vec4ui.yxyz: Vec4ui
    get() = Vec4ui(y, x, y, z)
val Vec4ui.yxyw: Vec4ui
    get() = Vec4ui(y, x, y, w)
val Vec4ui.yxzx: Vec4ui
    get() = Vec4ui(y, x, z, x)
val Vec4ui.yxzy: Vec4ui
    get() = Vec4ui(y, x, z, y)
val Vec4ui.yxzz: Vec4ui
    get() = Vec4ui(y, x, z, z)
var Vec4ui.yxzw: Vec4ui
    get() = Vec4ui(y, x, z, w)
    set(value) = put(value.y, value.x, value.z, value.w)
val Vec4ui.yxwx
    get() = Vec4ui(y, x, w, x)
val Vec4ui.yxwy
    get() = Vec4ui(y, x, w, y)
var Vec4ui.yxwz
    get() = Vec4ui(y, x, w, z)
    set(value) = put(value.y, value.x, value.w, value.z)
val Vec4ui.yxww
    get() = Vec4ui(y, x, w, w)
val Vec4ui.yyxx: Vec4ui
    get() = Vec4ui(y, y, x, x)
val Vec4ui.yyxy: Vec4ui
    get() = Vec4ui(y, y, x, y)
val Vec4ui.yyxz: Vec4ui
    get() = Vec4ui(y, y, x, z)
val Vec4ui.yyxw: Vec4ui
    get() = Vec4ui(y, y, x, w)
val Vec4ui.yyyx: Vec4ui
    get() = Vec4ui(y, y, y, x)
val Vec4ui.yyyy: Vec4ui
    get() = Vec4ui(y, y, y, y)
val Vec4ui.yyyz: Vec4ui
    get() = Vec4ui(y, y, y, z)
val Vec4ui.yyyw: Vec4ui
    get() = Vec4ui(y, y, y, w)
val Vec4ui.yyzx: Vec4ui
    get() = Vec4ui(y, y, z, x)
val Vec4ui.yyzy: Vec4ui
    get() = Vec4ui(y, y, z, y)
val Vec4ui.yyzz: Vec4ui
    get() = Vec4ui(y, y, z, z)
val Vec4ui.yyzw: Vec4ui
    get() = Vec4ui(y, y, z, w)
val Vec4ui.yywx: Vec4ui
    get() = Vec4ui(y, y, w, x)
val Vec4ui.yywy: Vec4ui
    get() = Vec4ui(y, y, w, y)
val Vec4ui.yywz: Vec4ui
    get() = Vec4ui(y, y, w, z)
val Vec4ui.yyww: Vec4ui
    get() = Vec4ui(y, y, w, w)
val Vec4ui.yzxx: Vec4ui
    get() = Vec4ui(y, z, x, x)
val Vec4ui.yzxy: Vec4ui
    get() = Vec4ui(y, z, x, z)
val Vec4ui.yzxz: Vec4ui
    get() = Vec4ui(y, z, x, z)
var Vec4ui.yzxw
    get() = Vec4ui(y, z, x, w)
    set(value) = put(value.y, value.z, value.x, value.w)
val Vec4ui.yzyx: Vec4ui
    get() = Vec4ui(y, z, y, x)
val Vec4ui.yzyy: Vec4ui
    get() = Vec4ui(y, z, y, y)
val Vec4ui.yzyz: Vec4ui
    get() = Vec4ui(y, z, y, z)
val Vec4ui.yzyw: Vec4ui
    get() = Vec4ui(y, z, y, w)
val Vec4ui.yzzx: Vec4ui
    get() = Vec4ui(y, z, z, x)
val Vec4ui.yzzy: Vec4ui
    get() = Vec4ui(y, z, z, y)
val Vec4ui.yzzz: Vec4ui
    get() = Vec4ui(y, z, z, z)
val Vec4ui.yzzw: Vec4ui
    get() = Vec4ui(y, z, z, w)
var Vec4ui.yzwx
    get() = Vec4ui(y, z, w, x)
    set(value) = put(value.y, value.z, value.w, value.x)
val Vec4ui.yzwy: Vec4ui
    get() = Vec4ui(y, z, w, y)
val Vec4ui.yzwz: Vec4ui
    get() = Vec4ui(y, z, w, z)
val Vec4ui.yzww: Vec4ui
    get() = Vec4ui(y, z, w, w)
val Vec4ui.ywxx: Vec4ui
    get() = Vec4ui(y, w, x, x)
val Vec4ui.ywxy: Vec4ui
    get() = Vec4ui(y, w, x, y)
var Vec4ui.ywxz: Vec4ui
    get() = Vec4ui(y, w, x, z)
    set(value) = put(value.y, value.w, value.x, value.z)
val Vec4ui.ywxw: Vec4ui
    get() = Vec4ui(y, w, x, w)
val Vec4ui.ywyx: Vec4ui
    get() = Vec4ui(y, w, y, x)
val Vec4ui.ywyy: Vec4ui
    get() = Vec4ui(y, w, y, y)
val Vec4ui.ywyz: Vec4ui
    get() = Vec4ui(y, w, y, z)
val Vec4ui.ywyw: Vec4ui
    get() = Vec4ui(y, w, y, w)
var Vec4ui.ywzx: Vec4ui
    get() = Vec4ui(y, w, z, x)
    set(value) = put(value.y, value.w, value.z, value.x)
val Vec4ui.ywzy: Vec4ui
    get() = Vec4ui(y, w, z, y)
val Vec4ui.ywzz: Vec4ui
    get() = Vec4ui(y, w, z, z)
val Vec4ui.ywzw: Vec4ui
    get() = Vec4ui(y, w, z, w)
val Vec4ui.ywwx: Vec4ui
    get() = Vec4ui(y, w, w, x)
val Vec4ui.ywwy: Vec4ui
    get() = Vec4ui(y, w, w, y)
val Vec4ui.ywwz: Vec4ui
    get() = Vec4ui(y, w, w, z)
val Vec4ui.ywww: Vec4ui
    get() = Vec4ui(y, w, w, w)
val Vec4ui.zxxx: Vec4ui
    get() = Vec4ui(z, x, x, x)
val Vec4ui.zxxy: Vec4ui
    get() = Vec4ui(z, x, x, y)
val Vec4ui.zxxz: Vec4ui
    get() = Vec4ui(z, x, x, z)
val Vec4ui.zxxw: Vec4ui
    get() = Vec4ui(z, x, x, w)
val Vec4ui.zxyx: Vec4ui
    get() = Vec4ui(z, x, y, x)
val Vec4ui.zxyy: Vec4ui
    get() = Vec4ui(z, x, y, y)
val Vec4ui.zxyz: Vec4ui
    get() = Vec4ui(z, x, y, z)
var Vec4ui.zxyw: Vec4ui
    get() = Vec4ui(z, x, y, w)
    set(value) = put(value.z, value.x, value.y, value.w)
val Vec4ui.zxzx: Vec4ui
    get() = Vec4ui(z, x, z, x)
val Vec4ui.zxzy: Vec4ui
    get() = Vec4ui(z, x, z, y)
val Vec4ui.zxzz: Vec4ui
    get() = Vec4ui(z, x, z, z)
val Vec4ui.zxzw: Vec4ui
    get() = Vec4ui(z, x, w, x)
val Vec4ui.zxwx: Vec4ui
    get() = Vec4ui(z, x, w, x)
var Vec4ui.zxwy: Vec4ui
    get() = Vec4ui(z, x, w, y)
    set(value) = put(value.z, value.x, value.w, value.y)
val Vec4ui.zxwz: Vec4ui
    get() = Vec4ui(z, x, w, y)
val Vec4ui.zxww: Vec4ui
    get() = Vec4ui(z, x, w, w)
val Vec4ui.zyxx: Vec4ui
    get() = Vec4ui(z, y, x, x)
val Vec4ui.zyxy: Vec4ui
    get() = Vec4ui(z, y, x, y)
val Vec4ui.zyxz: Vec4ui
    get() = Vec4ui(z, y, x, z)
var Vec4ui.zyxw: Vec4ui
    get() = Vec4ui(z, y, x, w)
    set(value) = put(value.z, value.y, value.x, value.w)
val Vec4ui.zyyx: Vec4ui
    get() = Vec4ui(z, y, y, x)
val Vec4ui.zyyy: Vec4ui
    get() = Vec4ui(z, y, y, y)
val Vec4ui.zyyz: Vec4ui
    get() = Vec4ui(z, y, y, z)
val Vec4ui.zyyw: Vec4ui
    get() = Vec4ui(z, y, y, w)
val Vec4ui.zyzx: Vec4ui
    get() = Vec4ui(z, y, z, x)
val Vec4ui.zyzy: Vec4ui
    get() = Vec4ui(z, y, z, y)
val Vec4ui.zyzz: Vec4ui
    get() = Vec4ui(z, y, z, z)
val Vec4ui.zyzw: Vec4ui
    get() = Vec4ui(z, y, z, w)
var Vec4ui.zywx: Vec4ui
    get() = Vec4ui(z, y, w, x)
    set(value) = put(value.z, value.y, value.w, value.x)
val Vec4ui.zywy: Vec4ui
    get() = Vec4ui(z, y, w, y)
val Vec4ui.zywz: Vec4ui
    get() = Vec4ui(z, y, w, z)
val Vec4ui.zyww: Vec4ui
    get() = Vec4ui(z, y, w, w)
val Vec4ui.zzxx: Vec4ui
    get() = Vec4ui(z, z, x, x)
val Vec4ui.zzxy: Vec4ui
    get() = Vec4ui(z, z, x, y)
val Vec4ui.zzxz: Vec4ui
    get() = Vec4ui(z, z, x, z)
val Vec4ui.zzxw: Vec4ui
    get() = Vec4ui(z, z, x, w)
val Vec4ui.zzyx: Vec4ui
    get() = Vec4ui(z, z, y, x)
val Vec4ui.zzyy: Vec4ui
    get() = Vec4ui(z, z, y, y)
val Vec4ui.zzyz: Vec4ui
    get() = Vec4ui(z, z, y, z)
val Vec4ui.zzyw: Vec4ui
    get() = Vec4ui(z, z, y, w)
val Vec4ui.zzzx: Vec4ui
    get() = Vec4ui(z, z, z, x)
val Vec4ui.zzzy: Vec4ui
    get() = Vec4ui(z, z, z, y)
val Vec4ui.zzzz: Vec4ui
    get() = Vec4ui(z, z, z, z)
val Vec4ui.zzzw: Vec4ui
    get() = Vec4ui(z, z, z, w)
val Vec4ui.zzwx: Vec4ui
    get() = Vec4ui(z, z, w, x)
val Vec4ui.zzwy: Vec4ui
    get() = Vec4ui(z, z, w, y)
val Vec4ui.zzwz: Vec4ui
    get() = Vec4ui(z, z, w, z)
val Vec4ui.zzww: Vec4ui
    get() = Vec4ui(z, z, w, w)
val Vec4ui.zwxx: Vec4ui
    get() = Vec4ui(z, w, x, x)
var Vec4ui.zwxy: Vec4ui
    get() = Vec4ui(z, w, x, y)
    set(value) = put(value.z, value.w, value.x, value.y)
val Vec4ui.zwxz: Vec4ui
    get() = Vec4ui(z, w, x, z)
val Vec4ui.zwxw: Vec4ui
    get() = Vec4ui(z, w, x, w)
var Vec4ui.zwyx: Vec4ui
    get() = Vec4ui(z, w, y, x)
    set(value) = put(value.z, value.w, value.y, value.x)
val Vec4ui.zwyy: Vec4ui
    get() = Vec4ui(z, w, y, y)
val Vec4ui.zwyz: Vec4ui
    get() = Vec4ui(z, w, y, z)
val Vec4ui.zwyw: Vec4ui
    get() = Vec4ui(z, w, y, w)
val Vec4ui.zwzx: Vec4ui
    get() = Vec4ui(z, w, z, x)
val Vec4ui.zwzy: Vec4ui
    get() = Vec4ui(z, w, z, y)
val Vec4ui.zwzz: Vec4ui
    get() = Vec4ui(z, w, z, z)
val Vec4ui.zwzw: Vec4ui
    get() = Vec4ui(z, w, z, w)
val Vec4ui.zwwx: Vec4ui
    get() = Vec4ui(z, w, w, y)
val Vec4ui.zwwy: Vec4ui
    get() = Vec4ui(z, w, w, y)
val Vec4ui.zwwz: Vec4ui
    get() = Vec4ui(z, w, w, z)
val Vec4ui.zwww: Vec4ui
    get() = Vec4ui(z, w, w, w)
val Vec4ui.wxxx: Vec4ui
    get() = Vec4ui(w, x, x, x)
val Vec4ui.wxxy: Vec4ui
    get() = Vec4ui(w, x, x, y)
val Vec4ui.wxxz: Vec4ui
    get() = Vec4ui(w, x, x, z)
val Vec4ui.wxxw: Vec4ui
    get() = Vec4ui(w, x, x, w)
val Vec4ui.wxyx: Vec4ui
    get() = Vec4ui(w, x, y, x)
val Vec4ui.wxyy: Vec4ui
    get() = Vec4ui(w, x, y, y)
var Vec4ui.wxyz: Vec4ui
    get() = Vec4ui(w, x, y, z)
    set(value) = put(value.w, value.x, value.y, value.z)
val Vec4ui.wxyw: Vec4ui
    get() = Vec4ui(w, x, y, w)
val Vec4ui.wxzx: Vec4ui
    get() = Vec4ui(w, x, z, x)
var Vec4ui.wxzy: Vec4ui
    get() = Vec4ui(w, x, z, y)
    set(value) = put(value.w, value.x, value.z, value.y)
val Vec4ui.wxzz: Vec4ui
    get() = Vec4ui(w, x, z, z)
val Vec4ui.wxzw: Vec4ui
    get() = Vec4ui(w, x, z, w)
val Vec4ui.wxwx: Vec4ui
    get() = Vec4ui(w, x, w, x)
val Vec4ui.wxwy: Vec4ui
    get() = Vec4ui(w, x, w, y)
val Vec4ui.wxwz: Vec4ui
    get() = Vec4ui(w, x, w, z)
val Vec4ui.wxww: Vec4ui
    get() = Vec4ui(w, x, w, w)
val Vec4ui.wyxx: Vec4ui
    get() = Vec4ui(w, y, x, x)
val Vec4ui.wyxy: Vec4ui
    get() = Vec4ui(w, y, x, y)
var Vec4ui.wyxz: Vec4ui
    get() = Vec4ui(w, y, x, z)
    set(value) = put(value.w, value.y, value.x, value.z)
val Vec4ui.wyxw: Vec4ui
    get() = Vec4ui(w, y, x, w)
val Vec4ui.wyyx: Vec4ui
    get() = Vec4ui(w, y, y, x)
val Vec4ui.wyyy: Vec4ui
    get() = Vec4ui(w, y, y, y)
val Vec4ui.wyyz: Vec4ui
    get() = Vec4ui(w, y, y, z)
val Vec4ui.wyyw: Vec4ui
    get() = Vec4ui(w, y, y, w)
var Vec4ui.wyzx: Vec4ui
    get() = Vec4ui(w, y, z, x)
    set(value) = put(value.w, value.y, value.z, value.x)
val Vec4ui.wyzy: Vec4ui
    get() = Vec4ui(w, y, z, y)
val Vec4ui.wyzz: Vec4ui
    get() = Vec4ui(w, y, z, z)
val Vec4ui.wyzw: Vec4ui
    get() = Vec4ui(w, y, z, w)
val Vec4ui.wywx: Vec4ui
    get() = Vec4ui(w, y, w, x)
val Vec4ui.wywy: Vec4ui
    get() = Vec4ui(w, y, w, y)
val Vec4ui.wywz: Vec4ui
    get() = Vec4ui(w, y, w, z)
val Vec4ui.wyww: Vec4ui
    get() = Vec4ui(w, y, w, w)
val Vec4ui.wzxx: Vec4ui
    get() = Vec4ui(w, z, x, x)
var Vec4ui.wzxy: Vec4ui
    get() = Vec4ui(w, z, x, y)
    set(value) = put(value.w, value.z, value.x, value.y)
val Vec4ui.wzxz: Vec4ui
    get() = Vec4ui(w, z, x, z)
val Vec4ui.wzxw: Vec4ui
    get() = Vec4ui(w, z, x, w)
var Vec4ui.wzyx: Vec4ui
    get() = Vec4ui(w, z, y, x)
    set(value) = put(value.w, value.z, value.y, value.x)
val Vec4ui.wzyy: Vec4ui
    get() = Vec4ui(w, z, y, y)
val Vec4ui.wzyz: Vec4ui
    get() = Vec4ui(w, z, y, z)
val Vec4ui.wzyw: Vec4ui
    get() = Vec4ui(w, z, y, w)
val Vec4ui.wzzx: Vec4ui
    get() = Vec4ui(w, z, z, x)
val Vec4ui.wzzy: Vec4ui
    get() = Vec4ui(w, z, z, y)
val Vec4ui.wzzz: Vec4ui
    get() = Vec4ui(w, z, z, z)
val Vec4ui.wzzw: Vec4ui
    get() = Vec4ui(w, z, z, w)
val Vec4ui.wzwx: Vec4ui
    get() = Vec4ui(w, z, w, x)
val Vec4ui.wzwy: Vec4ui
    get() = Vec4ui(w, z, w, y)
val Vec4ui.wzwz: Vec4ui
    get() = Vec4ui(w, z, w, z)
val Vec4ui.wzww: Vec4ui
    get() = Vec4ui(w, z, w, w)
val Vec4ui.wwxx: Vec4ui
    get() = Vec4ui(w, w, x, x)
val Vec4ui.wwxy: Vec4ui
    get() = Vec4ui(w, w, x, y)
val Vec4ui.wwxz: Vec4ui
    get() = Vec4ui(w, w, x, z)
val Vec4ui.wwxw: Vec4ui
    get() = Vec4ui(w, w, x, w)
val Vec4ui.wwyx: Vec4ui
    get() = Vec4ui(w, w, y, x)
val Vec4ui.wwyy: Vec4ui
    get() = Vec4ui(w, w, y, y)
val Vec4ui.wwyz: Vec4ui
    get() = Vec4ui(w, w, y, z)
val Vec4ui.wwyw: Vec4ui
    get() = Vec4ui(w, w, y, w)
val Vec4ui.wwzx: Vec4ui
    get() = Vec4ui(w, w, z, x)
val Vec4ui.wwzy: Vec4ui
    get() = Vec4ui(w, w, z, y)
val Vec4ui.wwzz: Vec4ui
    get() = Vec4ui(w, w, z, z)
val Vec4ui.wwzw: Vec4ui
    get() = Vec4ui(w, w, z, w)
val Vec4ui.wwwx: Vec4ui
    get() = Vec4ui(w, w, w, x)
val Vec4ui.wwwy: Vec4ui
    get() = Vec4ui(w, w, w, y)
val Vec4ui.wwwz: Vec4ui
    get() = Vec4ui(w, w, w, z)
val Vec4ui.wwww: Vec4ui
    get() = Vec4ui(w, w, w, w)