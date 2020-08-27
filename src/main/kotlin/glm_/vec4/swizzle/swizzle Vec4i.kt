package glm_.vec4.swizzle

import glm_.vec2.Vec2i
import glm_.vec3.Vec3i
import glm_.vec4.Vec4i

val Vec4i.xx: Vec2i
    get() = Vec2i(x, x)
var Vec4i.xy: Vec2i
    get() = Vec2i(x, y)
    set(value) {
        x = value.x
        y = value.y
    }
var Vec4i.xz: Vec2i
    get() = Vec2i(x, z)
    set(value) {
        x = value.x
        z = value.y
    }
var Vec4i.xw: Vec2i
    get() = Vec2i(x, w)
    set(value) {
        x = value.x
        w = value.y
    }
var Vec4i.yx: Vec2i
    get() = Vec2i(y, x)
    set(value) {
        y = value.x
        x = value.y
    }
val Vec4i.yy: Vec2i
    get() = Vec2i(y, y)
var Vec4i.yz: Vec2i
    get() = Vec2i(y, z)
    set(value) {
        y = value.x
        z = value.y
    }
var Vec4i.yw: Vec2i
    get() = Vec2i(y, w)
    set(value) {
        y = value.x
        w = value.y
    }
var Vec4i.zx: Vec2i
    get() = Vec2i(z, x)
    set(value) {
        z = value.x
        x = value.y
    }
var Vec4i.zy: Vec2i
    get() = Vec2i(z, y)
    set(value) {
        z = value.x
        y = value.y
    }
val Vec4i.zz: Vec2i
    get() = Vec2i(z, z)
var Vec4i.zw: Vec2i
    get() = Vec2i(z, w)
    set(value) {
        z = value.x
        w = value.y
    }
var Vec4i.wx: Vec2i
    get() = Vec2i(w, x)
    set(value) {
        w = value.x
        x = value.y
    }
var Vec4i.wy: Vec2i
    get() = Vec2i(w, y)
    set(value) {
        w = value.x
        y = value.y
    }
var Vec4i.wz: Vec2i
    get() = Vec2i(w, z)
    set(value) {
        w = value.x
        z = value.y
    }
val Vec4i.ww: Vec2i
    get() = Vec2i(w, w)


val Vec4i.xxx: Vec3i
    get() = Vec3i(x, x, x)
val Vec4i.xxy: Vec3i
    get() = Vec3i(x, x, y)
val Vec4i.xxz: Vec3i
    get() = Vec3i(x, x, z)
val Vec4i.xxw: Vec3i
    get() = Vec3i(x, x, w)
val Vec4i.xyx: Vec3i
    get() = Vec3i(x, y, x)
val Vec4i.xyy: Vec3i
    get() = Vec3i(x, y, y)
var Vec4i.xyz: Vec3i
    get() = Vec3i(x, y, z)
    set(value) {
        x = value.x
        y = value.y
        z = value.z
    }

var Vec4i.xyw: Vec3i
    get() = Vec3i(x, y, w)
    set(value) {
        x = value.x
        y = value.y
        w = value.z
    }

val Vec4i.xzx: Vec3i
    get() = Vec3i(x, z, x)
var Vec4i.xzy: Vec3i
    get() = Vec3i(x, z, y)
    set(value) {
        x = value.x
        z = value.y
        y = value.z
    }

val Vec4i.xzz: Vec3i
    get() = Vec3i(x, z, z)
var Vec4i.xzw: Vec3i
    get() = Vec3i(x, z, w)
    set(value) {
        x = value.x
        z = value.y
        w = value.z
    }

val Vec4i.xwx: Vec3i
    get() = Vec3i(x, w, x)
var Vec4i.xwy: Vec3i
    get() = Vec3i(x, w, y)
    set(value) {
        x = value.x
        w = value.y
        y = value.z
    }

var Vec4i.xwz: Vec3i
    get() = Vec3i(x, w, z)
    set(value) {
        x = value.x
        w = value.y
        z = value.z
    }

val Vec4i.xww: Vec3i
    get() = Vec3i(x, w, w)

val Vec4i.yxx: Vec3i
    get() = Vec3i(y, x, x)
val Vec4i.yxy: Vec3i
    get() = Vec3i(y, x, y)
var Vec4i.yxz: Vec3i
    get() = Vec3i(y, x, z)
    set(value) {
        y = value.x
        x = value.y
        z = value.z
    }

var Vec4i.yxw: Vec3i
    get() = Vec3i(y, x, w)
    set(value) {
        y = value.x
        x = value.y
        w = value.z
    }

val Vec4i.yyx: Vec3i
    get() = Vec3i(y, y, x)
val Vec4i.yyy: Vec3i
    get() = Vec3i(y, y, y)
val Vec4i.yyz: Vec3i
    get() = Vec3i(y, y, z)
val Vec4i.yyw: Vec3i
    get() = Vec3i(y, y, w)
var Vec4i.yzx: Vec3i
    get() = Vec3i(y, z, x)
    set(value) {
        y = value.x
        z = value.y
        x = value.z
    }

val Vec4i.yzy: Vec3i
    get() = Vec3i(y, z, y)
val Vec4i.yzz: Vec3i
    get() = Vec3i(y, z, z)
var Vec4i.yzw: Vec3i
    get() = Vec3i(y, z, w)
    set(value) {
        y = value.x
        z = value.y
        w = value.z
    }
var Vec4i.ywx: Vec3i
    get() = Vec3i(y, w, x)
    set(value) {
        y = value.x
        w = value.y
        x = value.z
    }
val Vec4i.ywy: Vec3i
    get() = Vec3i(y, w, y)
var Vec4i.ywz: Vec3i
    get() = Vec3i(y, w, z)
    set(value) {
        y = value.x
        w = value.y
        z = value.z
    }
val Vec4i.yww: Vec3i
    get() = Vec3i(y, w, w)

val Vec4i.zxx: Vec3i
    get() = Vec3i(z, x, x)
var Vec4i.zxy: Vec3i
    get() = Vec3i(z, x, y)
    set(value) {
        z = value.x
        x = value.y
        y = value.z
    }

val Vec4i.zxz: Vec3i
    get() = Vec3i(z, x, z)
var Vec4i.zxw: Vec3i
    get() = Vec3i(z, x, w)
    set(value) {
        z = value.x
        x = value.y
        w = value.z
    }

var Vec4i.zyx: Vec3i
    get() = Vec3i(z, y, x)
    set(value) {
        z = value.x
        y = value.y
        x = value.z
    }

val Vec4i.zyy: Vec3i
    get() = Vec3i(z, y, y)
val Vec4i.zyz: Vec3i
    get() = Vec3i(z, y, z)
var Vec4i.zyw: Vec3i
    get() = Vec3i(z, y, w)
    set(value) {
        z = value.x
        y = value.y
        w = value.z
    }

val Vec4i.zzx: Vec3i
    get() = Vec3i(z, z, x)
val Vec4i.zzy: Vec3i
    get() = Vec3i(z, z, y)
val Vec4i.zzz: Vec3i
    get() = Vec3i(z, z, z)
val Vec4i.zzw: Vec3i
    get() = Vec3i(z, z, w)

var Vec4i.zwx: Vec3i
    get() = Vec3i(z, w, x)
    set(value) {
        z = value.x
        w = value.y
        x = value.z
    }
var Vec4i.zwy: Vec3i
    get() = Vec3i(z, w, y)
    set(value) {
        z = value.x
        w = value.y
        y = value.z
    }
val Vec4i.zwz: Vec3i
    get() = Vec3i(z, w, z)
val Vec4i.zww: Vec3i
    get() = Vec3i(z, w, w)

val Vec4i.wxx: Vec3i
    get() = Vec3i(w, x, x)
var Vec4i.wxy: Vec3i
    get() = Vec3i(w, x, y)
    set(value) {
        w = value.x
        x = value.y
        y = value.z
    }

var Vec4i.wxz: Vec3i
    get() = Vec3i(w, x, z)
    set(value) {
        w = value.x
        x = value.y
        z = value.z
    }

val Vec4i.wxw: Vec3i
    get() = Vec3i(w, x, w)
var Vec4i.wyx: Vec3i
    get() = Vec3i(w, y, x)
    set(value) {
        w = value.x
        y = value.y
        x = value.z
    }

val Vec4i.wyy: Vec3i
    get() = Vec3i(w, y, y)
var Vec4i.wyz: Vec3i
    get() = Vec3i(w, y, z)
    set(value) {
        w = value.x
        y = value.y
        z = value.z
    }

val Vec4i.wyw: Vec3i
    get() = Vec3i(w, y, w)
var Vec4i.wzx: Vec3i
    get() = Vec3i(w, z, x)
    set(value) {
        w = value.x
        z = value.y
        x = value.z
    }

var Vec4i.wzy: Vec3i
    get() = Vec3i(w, z, y)
    set(value) {
        w = value.x
        z = value.y
        y = value.z
    }
val Vec4i.wzz: Vec3i
    get() = Vec3i(w, z, z)

val Vec4i.wzw: Vec3i
    get() = Vec3i(w, z, w)
val Vec4i.wwx: Vec3i
    get() = Vec3i(w, w, x)
val Vec4i.wwy: Vec3i
    get() = Vec3i(w, w, y)
val Vec4i.wwz: Vec3i
    get() = Vec3i(w, w, z)
val Vec4i.www: Vec3i
    get() = Vec3i(w, w, w)

val Vec4i.xxxx: Vec4i
    get() = Vec4i(x, x, x, x)
val Vec4i.xxxy: Vec4i
    get() = Vec4i(x, x, x, y)
val Vec4i.xxxz: Vec4i
    get() = Vec4i(x, x, x, z)
val Vec4i.xxxw: Vec4i
    get() = Vec4i(x, x, x, w)
val Vec4i.xxyx: Vec4i
    get() = Vec4i(x, x, y, x)
val Vec4i.xxyy: Vec4i
    get() = Vec4i(x, x, y, y)
val Vec4i.xxyz: Vec4i
    get() = Vec4i(x, x, y, z)
val Vec4i.xxyw: Vec4i
    get() = Vec4i(x, x, y, w)
val Vec4i.xxzx: Vec4i
    get() = Vec4i(x, x, z, x)
val Vec4i.xxzy: Vec4i
    get() = Vec4i(x, x, z, y)
val Vec4i.xxzz: Vec4i
    get() = Vec4i(x, x, z, z)
val Vec4i.xxzw: Vec4i
    get() = Vec4i(x, x, z, w)
val Vec4i.xxwx: Vec4i
    get() = Vec4i(x, x, w, x)
val Vec4i.xxwy: Vec4i
    get() = Vec4i(x, x, w, y)
val Vec4i.xxwz: Vec4i
    get() = Vec4i(x, x, w, z)
val Vec4i.xxww: Vec4i
    get() = Vec4i(x, x, w, w)
val Vec4i.xyxx: Vec4i
    get() = Vec4i(x, y, x, x)
val Vec4i.xyxy: Vec4i
    get() = Vec4i(x, y, x, y)
val Vec4i.xyxz: Vec4i
    get() = Vec4i(x, y, x, z)
val Vec4i.xyxw: Vec4i
    get() = Vec4i(x, y, x, w)
val Vec4i.xyyx: Vec4i
    get() = Vec4i(x, y, y, x)
val Vec4i.xyyy: Vec4i
    get() = Vec4i(x, y, y, y)
val Vec4i.xyyz: Vec4i
    get() = Vec4i(x, y, y, w)
val Vec4i.xyyw: Vec4i
    get() = Vec4i(x, y, y, w)
val Vec4i.xyzx: Vec4i
    get() = Vec4i(x, y, z, x)
val Vec4i.xyzy: Vec4i
    get() = Vec4i(x, y, z, y)
val Vec4i.xyzz: Vec4i
    get() = Vec4i(x, y, z, z)
var Vec4i.xyzw
    get() = Vec4i(x, y, z, w)
    set(value) = put(value.x, value.y, value.z, value.w)
val Vec4i.xywx
    get() = Vec4i(x, y, w, x)
val Vec4i.xywy
    get() = Vec4i(x, y, w, y)
var Vec4i.xywz
    get() = Vec4i(x, y, w, z)
    set(value) = put(value.x, value.y, value.w, value.z)
val Vec4i.xyww: Vec4i
    get() = Vec4i(x, y, w, w)
val Vec4i.xzxx: Vec4i
    get() = Vec4i(x, z, x, x)
val Vec4i.xzxy: Vec4i
    get() = Vec4i(x, z, x, y)
val Vec4i.xzxz: Vec4i
    get() = Vec4i(x, z, x, z)
val Vec4i.xzxw: Vec4i
    get() = Vec4i(x, z, x, w)
val Vec4i.xzyx: Vec4i
    get() = Vec4i(x, z, y, x)
val Vec4i.xzyy: Vec4i
    get() = Vec4i(x, z, y, y)
val Vec4i.xzyz: Vec4i
    get() = Vec4i(x, z, y, z)
var Vec4i.xzyw
    get() = Vec4i(x, z, y, w)
    set(value) = put(value.x, value.z, value.y, value.w)
val Vec4i.xzzx: Vec4i
    get() = Vec4i(x, z, z, x)
val Vec4i.xzzy: Vec4i
    get() = Vec4i(x, z, z, y)
val Vec4i.xzzz: Vec4i
    get() = Vec4i(x, z, z, z)
val Vec4i.xzzw: Vec4i
    get() = Vec4i(x, z, z, w)
val Vec4i.xzwx: Vec4i
    get() = Vec4i(x, z, w, x)
var Vec4i.xzwy: Vec4i
    get() = Vec4i(x, z, w, y)
    set(value) = put(value.x, value.z, value.w, value.y)
val Vec4i.xzwz: Vec4i
    get() = Vec4i(x, z, w, z)
val Vec4i.xzww: Vec4i
    get() = Vec4i(x, z, w, w)
val Vec4i.xwxx: Vec4i
    get() = Vec4i(x, w, x, x)
val Vec4i.xwxy: Vec4i
    get() = Vec4i(x, w, x, y)
val Vec4i.xwxz: Vec4i
    get() = Vec4i(x, w, x, z)
val Vec4i.xwxw: Vec4i
    get() = Vec4i(x, w, x, w)
val Vec4i.xwyx: Vec4i
    get() = Vec4i(x, w, y, x)
val Vec4i.xwyy: Vec4i
    get() = Vec4i(x, w, y, y)
var Vec4i.xwyz
    get() = Vec4i(x, w, y, z)
    set(value) = put(value.x, value.w, value.y, value.z)
val Vec4i.xwyw: Vec4i
    get() = Vec4i(x, w, y, w)
val Vec4i.xwzx: Vec4i
    get() = Vec4i(x, w, z, x)
var Vec4i.xwzy: Vec4i
    get() = Vec4i(x, w, z, y)
    set(value) = put(value.x, value.w, value.z, value.y)
val Vec4i.xwzz: Vec4i
    get() = Vec4i(x, w, z, z)
val Vec4i.xwzw: Vec4i
    get() = Vec4i(x, w, z, w)
val Vec4i.xwwx: Vec4i
    get() = Vec4i(x, w, w, x)
val Vec4i.xwwy: Vec4i
    get() = Vec4i(x, w, w, y)
val Vec4i.xwwz: Vec4i
    get() = Vec4i(x, w, w, z)
val Vec4i.xwww: Vec4i
    get() = Vec4i(x, w, w, w)
val Vec4i.yxxx: Vec4i
    get() = Vec4i(y, x, x, x)
val Vec4i.yxxy: Vec4i
    get() = Vec4i(y, x, x, y)
val Vec4i.yxxz: Vec4i
    get() = Vec4i(y, x, x, z)
val Vec4i.yxxw: Vec4i
    get() = Vec4i(y, x, x, w)
val Vec4i.yxyx: Vec4i
    get() = Vec4i(y, x, y, x)
val Vec4i.yxyy: Vec4i
    get() = Vec4i(y, x, y, y)
val Vec4i.yxyz: Vec4i
    get() = Vec4i(y, x, y, z)
val Vec4i.yxyw: Vec4i
    get() = Vec4i(y, x, y, w)
val Vec4i.yxzx: Vec4i
    get() = Vec4i(y, x, z, x)
val Vec4i.yxzy: Vec4i
    get() = Vec4i(y, x, z, y)
val Vec4i.yxzz: Vec4i
    get() = Vec4i(y, x, z, z)
var Vec4i.yxzw: Vec4i
    get() = Vec4i(y, x, z, w)
    set(value) = put(value.y, value.x, value.z, value.w)
val Vec4i.yxwx
    get() = Vec4i(y, x, w, x)
val Vec4i.yxwy
    get() = Vec4i(y, x, w, y)
var Vec4i.yxwz
    get() = Vec4i(y, x, w, z)
    set(value) = put(value.y, value.x, value.w, value.z)
val Vec4i.yxww
    get() = Vec4i(y, x, w, w)
val Vec4i.yyxx: Vec4i
    get() = Vec4i(y, y, x, x)
val Vec4i.yyxy: Vec4i
    get() = Vec4i(y, y, x, y)
val Vec4i.yyxz: Vec4i
    get() = Vec4i(y, y, x, z)
val Vec4i.yyxw: Vec4i
    get() = Vec4i(y, y, x, w)
val Vec4i.yyyx: Vec4i
    get() = Vec4i(y, y, y, x)
val Vec4i.yyyy: Vec4i
    get() = Vec4i(y, y, y, y)
val Vec4i.yyyz: Vec4i
    get() = Vec4i(y, y, y, z)
val Vec4i.yyyw: Vec4i
    get() = Vec4i(y, y, y, w)
val Vec4i.yyzx: Vec4i
    get() = Vec4i(y, y, z, x)
val Vec4i.yyzy: Vec4i
    get() = Vec4i(y, y, z, y)
val Vec4i.yyzz: Vec4i
    get() = Vec4i(y, y, z, z)
val Vec4i.yyzw: Vec4i
    get() = Vec4i(y, y, z, w)
val Vec4i.yywx: Vec4i
    get() = Vec4i(y, y, w, x)
val Vec4i.yywy: Vec4i
    get() = Vec4i(y, y, w, y)
val Vec4i.yywz: Vec4i
    get() = Vec4i(y, y, w, z)
val Vec4i.yyww: Vec4i
    get() = Vec4i(y, y, w, w)
val Vec4i.yzxx: Vec4i
    get() = Vec4i(y, z, x, x)
val Vec4i.yzxy: Vec4i
    get() = Vec4i(y, z, x, z)
val Vec4i.yzxz: Vec4i
    get() = Vec4i(y, z, x, z)
var Vec4i.yzxw
    get() = Vec4i(y, z, x, w)
    set(value) = put(value.y, value.z, value.x, value.w)
val Vec4i.yzyx: Vec4i
    get() = Vec4i(y, z, y, x)
val Vec4i.yzyy: Vec4i
    get() = Vec4i(y, z, y, y)
val Vec4i.yzyz: Vec4i
    get() = Vec4i(y, z, y, z)
val Vec4i.yzyw: Vec4i
    get() = Vec4i(y, z, y, w)
val Vec4i.yzzx: Vec4i
    get() = Vec4i(y, z, z, x)
val Vec4i.yzzy: Vec4i
    get() = Vec4i(y, z, z, y)
val Vec4i.yzzz: Vec4i
    get() = Vec4i(y, z, z, z)
val Vec4i.yzzw: Vec4i
    get() = Vec4i(y, z, z, w)
var Vec4i.yzwx
    get() = Vec4i(y, z, w, x)
    set(value) = put(value.y, value.z, value.w, value.x)
val Vec4i.yzwy: Vec4i
    get() = Vec4i(y, z, w, y)
val Vec4i.yzwz: Vec4i
    get() = Vec4i(y, z, w, z)
val Vec4i.yzww: Vec4i
    get() = Vec4i(y, z, w, w)
val Vec4i.ywxx: Vec4i
    get() = Vec4i(y, w, x, x)
val Vec4i.ywxy: Vec4i
    get() = Vec4i(y, w, x, y)
var Vec4i.ywxz: Vec4i
    get() = Vec4i(y, w, x, z)
    set(value) = put(value.y, value.w, value.x, value.z)
val Vec4i.ywxw: Vec4i
    get() = Vec4i(y, w, x, w)
val Vec4i.ywyx: Vec4i
    get() = Vec4i(y, w, y, x)
val Vec4i.ywyy: Vec4i
    get() = Vec4i(y, w, y, y)
val Vec4i.ywyz: Vec4i
    get() = Vec4i(y, w, y, z)
val Vec4i.ywyw: Vec4i
    get() = Vec4i(y, w, y, w)
var Vec4i.ywzx: Vec4i
    get() = Vec4i(y, w, z, x)
    set(value) = put(value.y, value.w, value.z, value.x)
val Vec4i.ywzy: Vec4i
    get() = Vec4i(y, w, z, y)
val Vec4i.ywzz: Vec4i
    get() = Vec4i(y, w, z, z)
val Vec4i.ywzw: Vec4i
    get() = Vec4i(y, w, z, w)
val Vec4i.ywwx: Vec4i
    get() = Vec4i(y, w, w, x)
val Vec4i.ywwy: Vec4i
    get() = Vec4i(y, w, w, y)
val Vec4i.ywwz: Vec4i
    get() = Vec4i(y, w, w, z)
val Vec4i.ywww: Vec4i
    get() = Vec4i(y, w, w, w)
val Vec4i.zxxx: Vec4i
    get() = Vec4i(z, x, x, x)
val Vec4i.zxxy: Vec4i
    get() = Vec4i(z, x, x, y)
val Vec4i.zxxz: Vec4i
    get() = Vec4i(z, x, x, z)
val Vec4i.zxxw: Vec4i
    get() = Vec4i(z, x, x, w)
val Vec4i.zxyx: Vec4i
    get() = Vec4i(z, x, y, x)
val Vec4i.zxyy: Vec4i
    get() = Vec4i(z, x, y, y)
val Vec4i.zxyz: Vec4i
    get() = Vec4i(z, x, y, z)
var Vec4i.zxyw: Vec4i
    get() = Vec4i(z, x, y, w)
    set(value) = put(value.z, value.x, value.y, value.w)
val Vec4i.zxzx: Vec4i
    get() = Vec4i(z, x, z, x)
val Vec4i.zxzy: Vec4i
    get() = Vec4i(z, x, z, y)
val Vec4i.zxzz: Vec4i
    get() = Vec4i(z, x, z, z)
val Vec4i.zxzw: Vec4i
    get() = Vec4i(z, x, w, x)
val Vec4i.zxwx: Vec4i
    get() = Vec4i(z, x, w, x)
var Vec4i.zxwy: Vec4i
    get() = Vec4i(z, x, w, y)
    set(value) = put(value.z, value.x, value.w, value.y)
val Vec4i.zxwz: Vec4i
    get() = Vec4i(z, x, w, y)
val Vec4i.zxww: Vec4i
    get() = Vec4i(z, x, w, w)
val Vec4i.zyxx: Vec4i
    get() = Vec4i(z, y, x, x)
val Vec4i.zyxy: Vec4i
    get() = Vec4i(z, y, x, y)
val Vec4i.zyxz: Vec4i
    get() = Vec4i(z, y, x, z)
var Vec4i.zyxw: Vec4i
    get() = Vec4i(z, y, x, w)
    set(value) = put(value.z, value.y, value.x, value.w)
val Vec4i.zyyx: Vec4i
    get() = Vec4i(z, y, y, x)
val Vec4i.zyyy: Vec4i
    get() = Vec4i(z, y, y, y)
val Vec4i.zyyz: Vec4i
    get() = Vec4i(z, y, y, z)
val Vec4i.zyyw: Vec4i
    get() = Vec4i(z, y, y, w)
val Vec4i.zyzx: Vec4i
    get() = Vec4i(z, y, z, x)
val Vec4i.zyzy: Vec4i
    get() = Vec4i(z, y, z, y)
val Vec4i.zyzz: Vec4i
    get() = Vec4i(z, y, z, z)
val Vec4i.zyzw: Vec4i
    get() = Vec4i(z, y, z, w)
var Vec4i.zywx: Vec4i
    get() = Vec4i(z, y, w, x)
    set(value) = put(value.z, value.y, value.w, value.x)
val Vec4i.zywy: Vec4i
    get() = Vec4i(z, y, w, y)
val Vec4i.zywz: Vec4i
    get() = Vec4i(z, y, w, z)
val Vec4i.zyww: Vec4i
    get() = Vec4i(z, y, w, w)
val Vec4i.zzxx: Vec4i
    get() = Vec4i(z, z, x, x)
val Vec4i.zzxy: Vec4i
    get() = Vec4i(z, z, x, y)
val Vec4i.zzxz: Vec4i
    get() = Vec4i(z, z, x, z)
val Vec4i.zzxw: Vec4i
    get() = Vec4i(z, z, x, w)
val Vec4i.zzyx: Vec4i
    get() = Vec4i(z, z, y, x)
val Vec4i.zzyy: Vec4i
    get() = Vec4i(z, z, y, y)
val Vec4i.zzyz: Vec4i
    get() = Vec4i(z, z, y, z)
val Vec4i.zzyw: Vec4i
    get() = Vec4i(z, z, y, w)
val Vec4i.zzzx: Vec4i
    get() = Vec4i(z, z, z, x)
val Vec4i.zzzy: Vec4i
    get() = Vec4i(z, z, z, y)
val Vec4i.zzzz: Vec4i
    get() = Vec4i(z, z, z, z)
val Vec4i.zzzw: Vec4i
    get() = Vec4i(z, z, z, w)
val Vec4i.zzwx: Vec4i
    get() = Vec4i(z, z, w, x)
val Vec4i.zzwy: Vec4i
    get() = Vec4i(z, z, w, y)
val Vec4i.zzwz: Vec4i
    get() = Vec4i(z, z, w, z)
val Vec4i.zzww: Vec4i
    get() = Vec4i(z, z, w, w)
val Vec4i.zwxx: Vec4i
    get() = Vec4i(z, w, x, x)
var Vec4i.zwxy: Vec4i
    get() = Vec4i(z, w, x, y)
    set(value) = put(value.z, value.w, value.x, value.y)
val Vec4i.zwxz: Vec4i
    get() = Vec4i(z, w, x, z)
val Vec4i.zwxw: Vec4i
    get() = Vec4i(z, w, x, w)
var Vec4i.zwyx: Vec4i
    get() = Vec4i(z, w, y, x)
    set(value) = put(value.z, value.w, value.y, value.x)
val Vec4i.zwyy: Vec4i
    get() = Vec4i(z, w, y, y)
val Vec4i.zwyz: Vec4i
    get() = Vec4i(z, w, y, z)
val Vec4i.zwyw: Vec4i
    get() = Vec4i(z, w, y, w)
val Vec4i.zwzx: Vec4i
    get() = Vec4i(z, w, z, x)
val Vec4i.zwzy: Vec4i
    get() = Vec4i(z, w, z, y)
val Vec4i.zwzz: Vec4i
    get() = Vec4i(z, w, z, z)
val Vec4i.zwzw: Vec4i
    get() = Vec4i(z, w, z, w)
val Vec4i.zwwx: Vec4i
    get() = Vec4i(z, w, w, y)
val Vec4i.zwwy: Vec4i
    get() = Vec4i(z, w, w, y)
val Vec4i.zwwz: Vec4i
    get() = Vec4i(z, w, w, z)
val Vec4i.zwww: Vec4i
    get() = Vec4i(z, w, w, w)
val Vec4i.wxxx: Vec4i
    get() = Vec4i(w, x, x, x)
val Vec4i.wxxy: Vec4i
    get() = Vec4i(w, x, x, y)
val Vec4i.wxxz: Vec4i
    get() = Vec4i(w, x, x, z)
val Vec4i.wxxw: Vec4i
    get() = Vec4i(w, x, x, w)
val Vec4i.wxyx: Vec4i
    get() = Vec4i(w, x, y, x)
val Vec4i.wxyy: Vec4i
    get() = Vec4i(w, x, y, y)
var Vec4i.wxyz: Vec4i
    get() = Vec4i(w, x, y, z)
    set(value) = put(value.w, value.x, value.y, value.z)
val Vec4i.wxyw: Vec4i
    get() = Vec4i(w, x, y, w)
val Vec4i.wxzx: Vec4i
    get() = Vec4i(w, x, z, x)
var Vec4i.wxzy: Vec4i
    get() = Vec4i(w, x, z, y)
    set(value) = put(value.w, value.x, value.z, value.y)
val Vec4i.wxzz: Vec4i
    get() = Vec4i(w, x, z, z)
val Vec4i.wxzw: Vec4i
    get() = Vec4i(w, x, z, w)
val Vec4i.wxwx: Vec4i
    get() = Vec4i(w, x, w, x)
val Vec4i.wxwy: Vec4i
    get() = Vec4i(w, x, w, y)
val Vec4i.wxwz: Vec4i
    get() = Vec4i(w, x, w, z)
val Vec4i.wxww: Vec4i
    get() = Vec4i(w, x, w, w)
val Vec4i.wyxx: Vec4i
    get() = Vec4i(w, y, x, x)
val Vec4i.wyxy: Vec4i
    get() = Vec4i(w, y, x, y)
var Vec4i.wyxz: Vec4i
    get() = Vec4i(w, y, x, z)
    set(value) = put(value.w, value.y, value.x, value.z)
val Vec4i.wyxw: Vec4i
    get() = Vec4i(w, y, x, w)
val Vec4i.wyyx: Vec4i
    get() = Vec4i(w, y, y, x)
val Vec4i.wyyy: Vec4i
    get() = Vec4i(w, y, y, y)
val Vec4i.wyyz: Vec4i
    get() = Vec4i(w, y, y, z)
val Vec4i.wyyw: Vec4i
    get() = Vec4i(w, y, y, w)
var Vec4i.wyzx: Vec4i
    get() = Vec4i(w, y, z, x)
    set(value) = put(value.w, value.y, value.z, value.x)
val Vec4i.wyzy: Vec4i
    get() = Vec4i(w, y, z, y)
val Vec4i.wyzz: Vec4i
    get() = Vec4i(w, y, z, z)
val Vec4i.wyzw: Vec4i
    get() = Vec4i(w, y, z, w)
val Vec4i.wywx: Vec4i
    get() = Vec4i(w, y, w, x)
val Vec4i.wywy: Vec4i
    get() = Vec4i(w, y, w, y)
val Vec4i.wywz: Vec4i
    get() = Vec4i(w, y, w, z)
val Vec4i.wyww: Vec4i
    get() = Vec4i(w, y, w, w)
val Vec4i.wzxx: Vec4i
    get() = Vec4i(w, z, x, x)
var Vec4i.wzxy: Vec4i
    get() = Vec4i(w, z, x, y)
    set(value) = put(value.w, value.z, value.x, value.y)
val Vec4i.wzxz: Vec4i
    get() = Vec4i(w, z, x, z)
val Vec4i.wzxw: Vec4i
    get() = Vec4i(w, z, x, w)
var Vec4i.wzyx: Vec4i
    get() = Vec4i(w, z, y, x)
    set(value) = put(value.w, value.z, value.y, value.x)
val Vec4i.wzyy: Vec4i
    get() = Vec4i(w, z, y, y)
val Vec4i.wzyz: Vec4i
    get() = Vec4i(w, z, y, z)
val Vec4i.wzyw: Vec4i
    get() = Vec4i(w, z, y, w)
val Vec4i.wzzx: Vec4i
    get() = Vec4i(w, z, z, x)
val Vec4i.wzzy: Vec4i
    get() = Vec4i(w, z, z, y)
val Vec4i.wzzz: Vec4i
    get() = Vec4i(w, z, z, z)
val Vec4i.wzzw: Vec4i
    get() = Vec4i(w, z, z, w)
val Vec4i.wzwx: Vec4i
    get() = Vec4i(w, z, w, x)
val Vec4i.wzwy: Vec4i
    get() = Vec4i(w, z, w, y)
val Vec4i.wzwz: Vec4i
    get() = Vec4i(w, z, w, z)
val Vec4i.wzww: Vec4i
    get() = Vec4i(w, z, w, w)
val Vec4i.wwxx: Vec4i
    get() = Vec4i(w, w, x, x)
val Vec4i.wwxy: Vec4i
    get() = Vec4i(w, w, x, y)
val Vec4i.wwxz: Vec4i
    get() = Vec4i(w, w, x, z)
val Vec4i.wwxw: Vec4i
    get() = Vec4i(w, w, x, w)
val Vec4i.wwyx: Vec4i
    get() = Vec4i(w, w, y, x)
val Vec4i.wwyy: Vec4i
    get() = Vec4i(w, w, y, y)
val Vec4i.wwyz: Vec4i
    get() = Vec4i(w, w, y, z)
val Vec4i.wwyw: Vec4i
    get() = Vec4i(w, w, y, w)
val Vec4i.wwzx: Vec4i
    get() = Vec4i(w, w, z, x)
val Vec4i.wwzy: Vec4i
    get() = Vec4i(w, w, z, y)
val Vec4i.wwzz: Vec4i
    get() = Vec4i(w, w, z, z)
val Vec4i.wwzw: Vec4i
    get() = Vec4i(w, w, z, w)
val Vec4i.wwwx: Vec4i
    get() = Vec4i(w, w, w, x)
val Vec4i.wwwy: Vec4i
    get() = Vec4i(w, w, w, y)
val Vec4i.wwwz: Vec4i
    get() = Vec4i(w, w, w, z)
val Vec4i.wwww: Vec4i
    get() = Vec4i(w, w, w, w)