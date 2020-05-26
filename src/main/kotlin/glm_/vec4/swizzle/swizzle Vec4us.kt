package glm_.vec4.swizzle

import glm_.vec2.Vec2us
import glm_.vec3.Vec3us
import glm_.vec4.Vec4us

val Vec4us.xx: Vec2us
    get() = Vec2us(x, x)
var Vec4us.xy: Vec2us
    get() = Vec2us(x, y)
    set(value) {
        x = value.x
        y = value.y
    }
var Vec4us.xz: Vec2us
    get() = Vec2us(x, z)
    set(value) {
        x = value.x
        z = value.y
    }
var Vec4us.xw: Vec2us
    get() = Vec2us(x, w)
    set(value) {
        x = value.x
        w = value.y
    }
var Vec4us.yx: Vec2us
    get() = Vec2us(y, x)
    set(value) {
        y = value.x
        x = value.y
    }
val Vec4us.yy: Vec2us
    get() = Vec2us(y, y)
var Vec4us.yz: Vec2us
    get() = Vec2us(y, z)
    set(value) {
        y = value.x
        z = value.y
    }
var Vec4us.yw: Vec2us
    get() = Vec2us(y, w)
    set(value) {
        y = value.x
        w = value.y
    }
var Vec4us.zx: Vec2us
    get() = Vec2us(z, x)
    set(value) {
        z = value.x
        x = value.y
    }
var Vec4us.zy: Vec2us
    get() = Vec2us(z, y)
    set(value) {
        z = value.x
        y = value.y
    }
val Vec4us.zz: Vec2us
    get() = Vec2us(z, z)
var Vec4us.zw: Vec2us
    get() = Vec2us(z, w)
    set(value) {
        z = value.x
        w = value.y
    }
var Vec4us.wx: Vec2us
    get() = Vec2us(w, x)
    set(value) {
        w = value.x
        x = value.y
    }
var Vec4us.wy: Vec2us
    get() = Vec2us(w, y)
    set(value) {
        w = value.x
        y = value.y
    }
var Vec4us.wz: Vec2us
    get() = Vec2us(w, z)
    set(value) {
        w = value.x
        z = value.y
    }
val Vec4us.ww: Vec2us
    get() = Vec2us(w, w)


val Vec4us.xxx: Vec3us
    get() = Vec3us(x, x, x)
val Vec4us.xxy: Vec3us
    get() = Vec3us(x, x, y)
val Vec4us.xxz: Vec3us
    get() = Vec3us(x, x, z)
val Vec4us.xxw: Vec3us
    get() = Vec3us(x, x, w)
val Vec4us.xyx: Vec3us
    get() = Vec3us(x, y, x)
val Vec4us.xyy: Vec3us
    get() = Vec3us(x, y, y)
var Vec4us.xyz: Vec3us
    get() = Vec3us(x, y, z)
    set(value) {
        x = value.x
        y = value.y
        z = value.z
    }

var Vec4us.xyw: Vec3us
    get() = Vec3us(x, y, w)
    set(value) {
        x = value.x
        y = value.y
        w = value.z
    }

val Vec4us.xzx: Vec3us
    get() = Vec3us(x, z, x)
var Vec4us.xzy: Vec3us
    get() = Vec3us(x, z, y)
    set(value) {
        x = value.x
        z = value.y
        y = value.z
    }

val Vec4us.xzz: Vec3us
    get() = Vec3us(x, z, z)
var Vec4us.xzw: Vec3us
    get() = Vec3us(x, z, w)
    set(value) {
        x = value.x
        z = value.y
        w = value.z
    }

val Vec4us.xwx: Vec3us
    get() = Vec3us(x, w, x)
var Vec4us.xwy: Vec3us
    get() = Vec3us(x, w, y)
    set(value) {
        x = value.x
        w = value.y
        y = value.z
    }

var Vec4us.xwz: Vec3us
    get() = Vec3us(x, w, z)
    set(value) {
        x = value.x
        w = value.y
        z = value.z
    }

val Vec4us.xww: Vec3us
    get() = Vec3us(x, w, w)

val Vec4us.yxx: Vec3us
    get() = Vec3us(y, x, x)
val Vec4us.yxy: Vec3us
    get() = Vec3us(y, x, y)
var Vec4us.yxz: Vec3us
    get() = Vec3us(y, x, z)
    set(value) {
        y = value.x
        x = value.y
        z = value.z
    }

var Vec4us.yxw: Vec3us
    get() = Vec3us(y, x, w)
    set(value) {
        y = value.x
        x = value.y
        w = value.z
    }

val Vec4us.yyx: Vec3us
    get() = Vec3us(y, y, x)
val Vec4us.yyy: Vec3us
    get() = Vec3us(y, y, y)
val Vec4us.yyz: Vec3us
    get() = Vec3us(y, y, z)
val Vec4us.yyw: Vec3us
    get() = Vec3us(y, y, w)
var Vec4us.yzx: Vec3us
    get() = Vec3us(y, z, x)
    set(value) {
        y = value.x
        z = value.y
        x = value.z
    }

val Vec4us.yzy: Vec3us
    get() = Vec3us(y, z, y)
val Vec4us.yzz: Vec3us
    get() = Vec3us(y, z, z)
var Vec4us.yzw: Vec3us
    get() = Vec3us(y, z, w)
    set(value) {
        y = value.x
        z = value.y
        w = value.z
    }
var Vec4us.ywx: Vec3us
    get() = Vec3us(y, w, x)
    set(value) {
        y = value.x
        w = value.y
        x = value.z
    }
val Vec4us.ywy: Vec3us
    get() = Vec3us(y, w, y)
var Vec4us.ywz: Vec3us
    get() = Vec3us(y, w, z)
    set(value) {
        y = value.x
        w = value.y
        z = value.z
    }
val Vec4us.yww: Vec3us
    get() = Vec3us(y, w, w)

val Vec4us.zxx: Vec3us
    get() = Vec3us(z, x, x)
var Vec4us.zxy: Vec3us
    get() = Vec3us(z, x, y)
    set(value) {
        z = value.x
        x = value.y
        y = value.z
    }

val Vec4us.zxz: Vec3us
    get() = Vec3us(z, x, z)
var Vec4us.zxw: Vec3us
    get() = Vec3us(z, x, w)
    set(value) {
        z = value.x
        x = value.y
        w = value.z
    }

var Vec4us.zyx: Vec3us
    get() = Vec3us(z, y, x)
    set(value) {
        z = value.x
        y = value.y
        x = value.z
    }

val Vec4us.zyy: Vec3us
    get() = Vec3us(z, y, y)
val Vec4us.zyz: Vec3us
    get() = Vec3us(z, y, z)
var Vec4us.zyw: Vec3us
    get() = Vec3us(z, y, w)
    set(value) {
        z = value.x
        y = value.y
        w = value.z
    }

val Vec4us.zzx: Vec3us
    get() = Vec3us(z, z, x)
val Vec4us.zzy: Vec3us
    get() = Vec3us(z, z, y)
val Vec4us.zzz: Vec3us
    get() = Vec3us(z, z, z)
val Vec4us.zzw: Vec3us
    get() = Vec3us(z, z, w)

var Vec4us.zwx: Vec3us
    get() = Vec3us(z, w, x)
    set(value) {
        z = value.x
        w = value.y
        x = value.z
    }
var Vec4us.zwy: Vec3us
    get() = Vec3us(z, w, y)
    set(value) {
        z = value.x
        w = value.y
        y = value.z
    }
val Vec4us.zwz: Vec3us
    get() = Vec3us(z, w, z)
val Vec4us.zww: Vec3us
    get() = Vec3us(z, w, w)

val Vec4us.wxx: Vec3us
    get() = Vec3us(w, x, x)
var Vec4us.wxy: Vec3us
    get() = Vec3us(w, x, y)
    set(value) {
        w = value.x
        x = value.y
        y = value.z
    }

var Vec4us.wxz: Vec3us
    get() = Vec3us(w, x, z)
    set(value) {
        w = value.x
        x = value.y
        z = value.z
    }

val Vec4us.wxw: Vec3us
    get() = Vec3us(w, x, w)
var Vec4us.wyx: Vec3us
    get() = Vec3us(w, y, x)
    set(value) {
        w = value.x
        y = value.y
        x = value.z
    }

val Vec4us.wyy: Vec3us
    get() = Vec3us(w, y, y)
var Vec4us.wyz: Vec3us
    get() = Vec3us(w, y, z)
    set(value) {
        w = value.x
        y = value.y
        z = value.z
    }

val Vec4us.wyw: Vec3us
    get() = Vec3us(w, y, w)
var Vec4us.wzx: Vec3us
    get() = Vec3us(w, z, x)
    set(value) {
        w = value.x
        z = value.y
        x = value.z
    }

var Vec4us.wzy: Vec3us
    get() = Vec3us(w, z, y)
    set(value) {
        w = value.x
        z = value.y
        y = value.z
    }
val Vec4us.wzz: Vec3us
    get() = Vec3us(w, z, z)

val Vec4us.wzw: Vec3us
    get() = Vec3us(w, z, w)
val Vec4us.wwx: Vec3us
    get() = Vec3us(w, w, x)
val Vec4us.wwy: Vec3us
    get() = Vec3us(w, w, y)
val Vec4us.wwz: Vec3us
    get() = Vec3us(w, w, z)
val Vec4us.www: Vec3us
    get() = Vec3us(w, w, w)

val Vec4us.xxxx: Vec4us
    get() = Vec4us(x, x, x, x)
val Vec4us.xxxy: Vec4us
    get() = Vec4us(x, x, x, y)
val Vec4us.xxxz: Vec4us
    get() = Vec4us(x, x, x, z)
val Vec4us.xxxw: Vec4us
    get() = Vec4us(x, x, x, w)
val Vec4us.xxyx: Vec4us
    get() = Vec4us(x, x, y, x)
val Vec4us.xxyy: Vec4us
    get() = Vec4us(x, x, y, y)
val Vec4us.xxyz: Vec4us
    get() = Vec4us(x, x, y, z)
val Vec4us.xxyw: Vec4us
    get() = Vec4us(x, x, y, w)
val Vec4us.xxzx: Vec4us
    get() = Vec4us(x, x, z, x)
val Vec4us.xxzy: Vec4us
    get() = Vec4us(x, x, z, y)
val Vec4us.xxzz: Vec4us
    get() = Vec4us(x, x, z, z)
val Vec4us.xxzw: Vec4us
    get() = Vec4us(x, x, z, w)
val Vec4us.xxwx: Vec4us
    get() = Vec4us(x, x, w, x)
val Vec4us.xxwy: Vec4us
    get() = Vec4us(x, x, w, y)
val Vec4us.xxwz: Vec4us
    get() = Vec4us(x, x, w, z)
val Vec4us.xxww: Vec4us
    get() = Vec4us(x, x, w, w)
val Vec4us.xyxx: Vec4us
    get() = Vec4us(x, y, x, x)
val Vec4us.xyxy: Vec4us
    get() = Vec4us(x, y, x, y)
val Vec4us.xyxz: Vec4us
    get() = Vec4us(x, y, x, z)
val Vec4us.xyxw: Vec4us
    get() = Vec4us(x, y, x, w)
val Vec4us.xyyx: Vec4us
    get() = Vec4us(x, y, y, x)
val Vec4us.xyyy: Vec4us
    get() = Vec4us(x, y, y, y)
val Vec4us.xyyz: Vec4us
    get() = Vec4us(x, y, y, w)
val Vec4us.xyyw: Vec4us
    get() = Vec4us(x, y, y, w)
val Vec4us.xyzx: Vec4us
    get() = Vec4us(x, y, z, x)
val Vec4us.xyzy: Vec4us
    get() = Vec4us(x, y, z, y)
val Vec4us.xyzz: Vec4us
    get() = Vec4us(x, y, z, z)
var Vec4us.xyzw
    get() = Vec4us(x, y, z, w)
    set(value) = put(value.x, value.y, value.z, value.w)
val Vec4us.xywx
    get() = Vec4us(x, y, w, x)
val Vec4us.xywy
    get() = Vec4us(x, y, w, y)
var Vec4us.xywz
    get() = Vec4us(x, y, w, z)
    set(value) = put(value.x, value.y, value.w, value.z)
val Vec4us.xyww: Vec4us
    get() = Vec4us(x, y, w, w)
val Vec4us.xzxx: Vec4us
    get() = Vec4us(x, z, x, x)
val Vec4us.xzxy: Vec4us
    get() = Vec4us(x, z, x, y)
val Vec4us.xzxz: Vec4us
    get() = Vec4us(x, z, x, z)
val Vec4us.xzxw: Vec4us
    get() = Vec4us(x, z, x, w)
val Vec4us.xzyx: Vec4us
    get() = Vec4us(x, z, y, x)
val Vec4us.xzyy: Vec4us
    get() = Vec4us(x, z, y, y)
val Vec4us.xzyz: Vec4us
    get() = Vec4us(x, z, y, z)
var Vec4us.xzyw
    get() = Vec4us(x, z, y, w)
    set(value) = put(value.x, value.z, value.y, value.w)
val Vec4us.xzzx: Vec4us
    get() = Vec4us(x, z, z, x)
val Vec4us.xzzy: Vec4us
    get() = Vec4us(x, z, z, y)
val Vec4us.xzzz: Vec4us
    get() = Vec4us(x, z, z, z)
val Vec4us.xzzw: Vec4us
    get() = Vec4us(x, z, z, w)
val Vec4us.xzwx: Vec4us
    get() = Vec4us(x, z, w, x)
var Vec4us.xzwy: Vec4us
    get() = Vec4us(x, z, w, y)
    set(value) = put(value.x, value.z, value.w, value.y)
val Vec4us.xzwz: Vec4us
    get() = Vec4us(x, z, w, z)
val Vec4us.xzww: Vec4us
    get() = Vec4us(x, z, w, w)
val Vec4us.xwxx: Vec4us
    get() = Vec4us(x, w, x, x)
val Vec4us.xwxy: Vec4us
    get() = Vec4us(x, w, x, y)
val Vec4us.xwxz: Vec4us
    get() = Vec4us(x, w, x, z)
val Vec4us.xwxw: Vec4us
    get() = Vec4us(x, w, x, w)
val Vec4us.xwyx: Vec4us
    get() = Vec4us(x, w, y, x)
val Vec4us.xwyy: Vec4us
    get() = Vec4us(x, w, y, y)
var Vec4us.xwyz
    get() = Vec4us(x, w, y, z)
    set(value) = put(value.x, value.w, value.y, value.z)
val Vec4us.xwyw: Vec4us
    get() = Vec4us(x, w, y, w)
val Vec4us.xwzx: Vec4us
    get() = Vec4us(x, w, z, x)
var Vec4us.xwzy: Vec4us
    get() = Vec4us(x, w, z, y)
    set(value) = put(value.x, value.w, value.z, value.y)
val Vec4us.xwzz: Vec4us
    get() = Vec4us(x, w, z, z)
val Vec4us.xwzw: Vec4us
    get() = Vec4us(x, w, z, w)
val Vec4us.xwwx: Vec4us
    get() = Vec4us(x, w, w, x)
val Vec4us.xwwy: Vec4us
    get() = Vec4us(x, w, w, y)
val Vec4us.xwwz: Vec4us
    get() = Vec4us(x, w, w, z)
val Vec4us.xwww: Vec4us
    get() = Vec4us(x, w, w, w)
val Vec4us.yxxx: Vec4us
    get() = Vec4us(y, x, x, x)
val Vec4us.yxxy: Vec4us
    get() = Vec4us(y, x, x, y)
val Vec4us.yxxz: Vec4us
    get() = Vec4us(y, x, x, z)
val Vec4us.yxxw: Vec4us
    get() = Vec4us(y, x, x, w)
val Vec4us.yxyx: Vec4us
    get() = Vec4us(y, x, y, x)
val Vec4us.yxyy: Vec4us
    get() = Vec4us(y, x, y, y)
val Vec4us.yxyz: Vec4us
    get() = Vec4us(y, x, y, z)
val Vec4us.yxyw: Vec4us
    get() = Vec4us(y, x, y, w)
val Vec4us.yxzx: Vec4us
    get() = Vec4us(y, x, z, x)
val Vec4us.yxzy: Vec4us
    get() = Vec4us(y, x, z, y)
val Vec4us.yxzz: Vec4us
    get() = Vec4us(y, x, z, z)
var Vec4us.yxzw: Vec4us
    get() = Vec4us(y, x, z, w)
    set(value) = put(value.y, value.x, value.z, value.w)
val Vec4us.yxwx
    get() = Vec4us(y, x, w, x)
val Vec4us.yxwy
    get() = Vec4us(y, x, w, y)
var Vec4us.yxwz
    get() = Vec4us(y, x, w, z)
    set(value) = put(value.y, value.x, value.w, value.z)
val Vec4us.yxww
    get() = Vec4us(y, x, w, w)
val Vec4us.yyxx: Vec4us
    get() = Vec4us(y, y, x, x)
val Vec4us.yyxy: Vec4us
    get() = Vec4us(y, y, x, y)
val Vec4us.yyxz: Vec4us
    get() = Vec4us(y, y, x, z)
val Vec4us.yyxw: Vec4us
    get() = Vec4us(y, y, x, w)
val Vec4us.yyyx: Vec4us
    get() = Vec4us(y, y, y, x)
val Vec4us.yyyy: Vec4us
    get() = Vec4us(y, y, y, y)
val Vec4us.yyyz: Vec4us
    get() = Vec4us(y, y, y, z)
val Vec4us.yyyw: Vec4us
    get() = Vec4us(y, y, y, w)
val Vec4us.yyzx: Vec4us
    get() = Vec4us(y, y, z, x)
val Vec4us.yyzy: Vec4us
    get() = Vec4us(y, y, z, y)
val Vec4us.yyzz: Vec4us
    get() = Vec4us(y, y, z, z)
val Vec4us.yyzw: Vec4us
    get() = Vec4us(y, y, z, w)
val Vec4us.yywx: Vec4us
    get() = Vec4us(y, y, w, x)
val Vec4us.yywy: Vec4us
    get() = Vec4us(y, y, w, y)
val Vec4us.yywz: Vec4us
    get() = Vec4us(y, y, w, z)
val Vec4us.yyww: Vec4us
    get() = Vec4us(y, y, w, w)
val Vec4us.yzxx: Vec4us
    get() = Vec4us(y, z, x, x)
val Vec4us.yzxy: Vec4us
    get() = Vec4us(y, z, x, z)
val Vec4us.yzxz: Vec4us
    get() = Vec4us(y, z, x, z)
var Vec4us.yzxw
    get() = Vec4us(y, z, x, w)
    set(value) = put(value.y, value.z, value.x, value.w)
val Vec4us.yzyx: Vec4us
    get() = Vec4us(y, z, y, x)
val Vec4us.yzyy: Vec4us
    get() = Vec4us(y, z, y, y)
val Vec4us.yzyz: Vec4us
    get() = Vec4us(y, z, y, z)
val Vec4us.yzyw: Vec4us
    get() = Vec4us(y, z, y, w)
val Vec4us.yzzx: Vec4us
    get() = Vec4us(y, z, z, x)
val Vec4us.yzzy: Vec4us
    get() = Vec4us(y, z, z, y)
val Vec4us.yzzz: Vec4us
    get() = Vec4us(y, z, z, z)
val Vec4us.yzzw: Vec4us
    get() = Vec4us(y, z, z, w)
var Vec4us.yzwx
    get() = Vec4us(y, z, w, x)
    set(value) = put(value.y, value.z, value.w, value.x)
val Vec4us.yzwy: Vec4us
    get() = Vec4us(y, z, w, y)
val Vec4us.yzwz: Vec4us
    get() = Vec4us(y, z, w, z)
val Vec4us.yzww: Vec4us
    get() = Vec4us(y, z, w, w)
val Vec4us.ywxx: Vec4us
    get() = Vec4us(y, w, x, x)
val Vec4us.ywxy: Vec4us
    get() = Vec4us(y, w, x, y)
var Vec4us.ywxz: Vec4us
    get() = Vec4us(y, w, x, z)
    set(value) = put(value.y, value.w, value.x, value.z)
val Vec4us.ywxw: Vec4us
    get() = Vec4us(y, w, x, w)
val Vec4us.ywyx: Vec4us
    get() = Vec4us(y, w, y, x)
val Vec4us.ywyy: Vec4us
    get() = Vec4us(y, w, y, y)
val Vec4us.ywyz: Vec4us
    get() = Vec4us(y, w, y, z)
val Vec4us.ywyw: Vec4us
    get() = Vec4us(y, w, y, w)
var Vec4us.ywzx: Vec4us
    get() = Vec4us(y, w, z, x)
    set(value) = put(value.y, value.w, value.z, value.x)
val Vec4us.ywzy: Vec4us
    get() = Vec4us(y, w, z, y)
val Vec4us.ywzz: Vec4us
    get() = Vec4us(y, w, z, z)
val Vec4us.ywzw: Vec4us
    get() = Vec4us(y, w, z, w)
val Vec4us.ywwx: Vec4us
    get() = Vec4us(y, w, w, x)
val Vec4us.ywwy: Vec4us
    get() = Vec4us(y, w, w, y)
val Vec4us.ywwz: Vec4us
    get() = Vec4us(y, w, w, z)
val Vec4us.ywww: Vec4us
    get() = Vec4us(y, w, w, w)
val Vec4us.zxxx: Vec4us
    get() = Vec4us(z, x, x, x)
val Vec4us.zxxy: Vec4us
    get() = Vec4us(z, x, x, y)
val Vec4us.zxxz: Vec4us
    get() = Vec4us(z, x, x, z)
val Vec4us.zxxw: Vec4us
    get() = Vec4us(z, x, x, w)
val Vec4us.zxyx: Vec4us
    get() = Vec4us(z, x, y, x)
val Vec4us.zxyy: Vec4us
    get() = Vec4us(z, x, y, y)
val Vec4us.zxyz: Vec4us
    get() = Vec4us(z, x, y, z)
var Vec4us.zxyw: Vec4us
    get() = Vec4us(z, x, y, w)
    set(value) = put(value.z, value.x, value.y, value.w)
val Vec4us.zxzx: Vec4us
    get() = Vec4us(z, x, z, x)
val Vec4us.zxzy: Vec4us
    get() = Vec4us(z, x, z, y)
val Vec4us.zxzz: Vec4us
    get() = Vec4us(z, x, z, z)
val Vec4us.zxzw: Vec4us
    get() = Vec4us(z, x, w, x)
val Vec4us.zxwx: Vec4us
    get() = Vec4us(z, x, w, x)
var Vec4us.zxwy: Vec4us
    get() = Vec4us(z, x, w, y)
    set(value) = put(value.z, value.x, value.w, value.y)
val Vec4us.zxwz: Vec4us
    get() = Vec4us(z, x, w, y)
val Vec4us.zxww: Vec4us
    get() = Vec4us(z, x, w, w)
val Vec4us.zyxx: Vec4us
    get() = Vec4us(z, y, x, x)
val Vec4us.zyxy: Vec4us
    get() = Vec4us(z, y, x, y)
val Vec4us.zyxz: Vec4us
    get() = Vec4us(z, y, x, z)
var Vec4us.zyxw: Vec4us
    get() = Vec4us(z, y, x, w)
    set(value) = put(value.z, value.y, value.x, value.w)
val Vec4us.zyyx: Vec4us
    get() = Vec4us(z, y, y, x)
val Vec4us.zyyy: Vec4us
    get() = Vec4us(z, y, y, y)
val Vec4us.zyyz: Vec4us
    get() = Vec4us(z, y, y, z)
val Vec4us.zyyw: Vec4us
    get() = Vec4us(z, y, y, w)
val Vec4us.zyzx: Vec4us
    get() = Vec4us(z, y, z, x)
val Vec4us.zyzy: Vec4us
    get() = Vec4us(z, y, z, y)
val Vec4us.zyzz: Vec4us
    get() = Vec4us(z, y, z, z)
val Vec4us.zyzw: Vec4us
    get() = Vec4us(z, y, z, w)
var Vec4us.zywx: Vec4us
    get() = Vec4us(z, y, w, x)
    set(value) = put(value.z, value.y, value.w, value.x)
val Vec4us.zywy: Vec4us
    get() = Vec4us(z, y, w, y)
val Vec4us.zywz: Vec4us
    get() = Vec4us(z, y, w, z)
val Vec4us.zyww: Vec4us
    get() = Vec4us(z, y, w, w)
val Vec4us.zzxx: Vec4us
    get() = Vec4us(z, z, x, x)
val Vec4us.zzxy: Vec4us
    get() = Vec4us(z, z, x, y)
val Vec4us.zzxz: Vec4us
    get() = Vec4us(z, z, x, z)
val Vec4us.zzxw: Vec4us
    get() = Vec4us(z, z, x, w)
val Vec4us.zzyx: Vec4us
    get() = Vec4us(z, z, y, x)
val Vec4us.zzyy: Vec4us
    get() = Vec4us(z, z, y, y)
val Vec4us.zzyz: Vec4us
    get() = Vec4us(z, z, y, z)
val Vec4us.zzyw: Vec4us
    get() = Vec4us(z, z, y, w)
val Vec4us.zzzx: Vec4us
    get() = Vec4us(z, z, z, x)
val Vec4us.zzzy: Vec4us
    get() = Vec4us(z, z, z, y)
val Vec4us.zzzz: Vec4us
    get() = Vec4us(z, z, z, z)
val Vec4us.zzzw: Vec4us
    get() = Vec4us(z, z, z, w)
val Vec4us.zzwx: Vec4us
    get() = Vec4us(z, z, w, x)
val Vec4us.zzwy: Vec4us
    get() = Vec4us(z, z, w, y)
val Vec4us.zzwz: Vec4us
    get() = Vec4us(z, z, w, z)
val Vec4us.zzww: Vec4us
    get() = Vec4us(z, z, w, w)
val Vec4us.zwxx: Vec4us
    get() = Vec4us(z, w, x, x)
var Vec4us.zwxy: Vec4us
    get() = Vec4us(z, w, x, y)
    set(value) = put(value.z, value.w, value.x, value.y)
val Vec4us.zwxz: Vec4us
    get() = Vec4us(z, w, x, z)
val Vec4us.zwxw: Vec4us
    get() = Vec4us(z, w, x, w)
var Vec4us.zwyx: Vec4us
    get() = Vec4us(z, w, y, x)
    set(value) = put(value.z, value.w, value.y, value.x)
val Vec4us.zwyy: Vec4us
    get() = Vec4us(z, w, y, y)
val Vec4us.zwyz: Vec4us
    get() = Vec4us(z, w, y, z)
val Vec4us.zwyw: Vec4us
    get() = Vec4us(z, w, y, w)
val Vec4us.zwzx: Vec4us
    get() = Vec4us(z, w, z, x)
val Vec4us.zwzy: Vec4us
    get() = Vec4us(z, w, z, y)
val Vec4us.zwzz: Vec4us
    get() = Vec4us(z, w, z, z)
val Vec4us.zwzw: Vec4us
    get() = Vec4us(z, w, z, w)
val Vec4us.zwwx: Vec4us
    get() = Vec4us(z, w, w, y)
val Vec4us.zwwy: Vec4us
    get() = Vec4us(z, w, w, y)
val Vec4us.zwwz: Vec4us
    get() = Vec4us(z, w, w, z)
val Vec4us.zwww: Vec4us
    get() = Vec4us(z, w, w, w)
val Vec4us.wxxx: Vec4us
    get() = Vec4us(w, x, x, x)
val Vec4us.wxxy: Vec4us
    get() = Vec4us(w, x, x, y)
val Vec4us.wxxz: Vec4us
    get() = Vec4us(w, x, x, z)
val Vec4us.wxxw: Vec4us
    get() = Vec4us(w, x, x, w)
val Vec4us.wxyx: Vec4us
    get() = Vec4us(w, x, y, x)
val Vec4us.wxyy: Vec4us
    get() = Vec4us(w, x, y, y)
var Vec4us.wxyz: Vec4us
    get() = Vec4us(w, x, y, z)
    set(value) = put(value.w, value.x, value.y, value.z)
val Vec4us.wxyw: Vec4us
    get() = Vec4us(w, x, y, w)
val Vec4us.wxzx: Vec4us
    get() = Vec4us(w, x, z, x)
var Vec4us.wxzy: Vec4us
    get() = Vec4us(w, x, z, y)
    set(value) = put(value.w, value.x, value.z, value.y)
val Vec4us.wxzz: Vec4us
    get() = Vec4us(w, x, z, z)
val Vec4us.wxzw: Vec4us
    get() = Vec4us(w, x, z, w)
val Vec4us.wxwx: Vec4us
    get() = Vec4us(w, x, w, x)
val Vec4us.wxwy: Vec4us
    get() = Vec4us(w, x, w, y)
val Vec4us.wxwz: Vec4us
    get() = Vec4us(w, x, w, z)
val Vec4us.wxww: Vec4us
    get() = Vec4us(w, x, w, w)
val Vec4us.wyxx: Vec4us
    get() = Vec4us(w, y, x, x)
val Vec4us.wyxy: Vec4us
    get() = Vec4us(w, y, x, y)
var Vec4us.wyxz: Vec4us
    get() = Vec4us(w, y, x, z)
    set(value) = put(value.w, value.y, value.x, value.z)
val Vec4us.wyxw: Vec4us
    get() = Vec4us(w, y, x, w)
val Vec4us.wyyx: Vec4us
    get() = Vec4us(w, y, y, x)
val Vec4us.wyyy: Vec4us
    get() = Vec4us(w, y, y, y)
val Vec4us.wyyz: Vec4us
    get() = Vec4us(w, y, y, z)
val Vec4us.wyyw: Vec4us
    get() = Vec4us(w, y, y, w)
var Vec4us.wyzx: Vec4us
    get() = Vec4us(w, y, z, x)
    set(value) = put(value.w, value.y, value.z, value.x)
val Vec4us.wyzy: Vec4us
    get() = Vec4us(w, y, z, y)
val Vec4us.wyzz: Vec4us
    get() = Vec4us(w, y, z, z)
val Vec4us.wyzw: Vec4us
    get() = Vec4us(w, y, z, w)
val Vec4us.wywx: Vec4us
    get() = Vec4us(w, y, w, x)
val Vec4us.wywy: Vec4us
    get() = Vec4us(w, y, w, y)
val Vec4us.wywz: Vec4us
    get() = Vec4us(w, y, w, z)
val Vec4us.wyww: Vec4us
    get() = Vec4us(w, y, w, w)
val Vec4us.wzxx: Vec4us
    get() = Vec4us(w, z, x, x)
var Vec4us.wzxy: Vec4us
    get() = Vec4us(w, z, x, y)
    set(value) = put(value.w, value.z, value.x, value.y)
val Vec4us.wzxz: Vec4us
    get() = Vec4us(w, z, x, z)
val Vec4us.wzxw: Vec4us
    get() = Vec4us(w, z, x, w)
var Vec4us.wzyx: Vec4us
    get() = Vec4us(w, z, y, x)
    set(value) = put(value.w, value.z, value.y, value.x)
val Vec4us.wzyy: Vec4us
    get() = Vec4us(w, z, y, y)
val Vec4us.wzyz: Vec4us
    get() = Vec4us(w, z, y, z)
val Vec4us.wzyw: Vec4us
    get() = Vec4us(w, z, y, w)
val Vec4us.wzzx: Vec4us
    get() = Vec4us(w, z, z, x)
val Vec4us.wzzy: Vec4us
    get() = Vec4us(w, z, z, y)
val Vec4us.wzzz: Vec4us
    get() = Vec4us(w, z, z, z)
val Vec4us.wzzw: Vec4us
    get() = Vec4us(w, z, z, w)
val Vec4us.wzwx: Vec4us
    get() = Vec4us(w, z, w, x)
val Vec4us.wzwy: Vec4us
    get() = Vec4us(w, z, w, y)
val Vec4us.wzwz: Vec4us
    get() = Vec4us(w, z, w, z)
val Vec4us.wzww: Vec4us
    get() = Vec4us(w, z, w, w)
val Vec4us.wwxx: Vec4us
    get() = Vec4us(w, w, x, x)
val Vec4us.wwxy: Vec4us
    get() = Vec4us(w, w, x, y)
val Vec4us.wwxz: Vec4us
    get() = Vec4us(w, w, x, z)
val Vec4us.wwxw: Vec4us
    get() = Vec4us(w, w, x, w)
val Vec4us.wwyx: Vec4us
    get() = Vec4us(w, w, y, x)
val Vec4us.wwyy: Vec4us
    get() = Vec4us(w, w, y, y)
val Vec4us.wwyz: Vec4us
    get() = Vec4us(w, w, y, z)
val Vec4us.wwyw: Vec4us
    get() = Vec4us(w, w, y, w)
val Vec4us.wwzx: Vec4us
    get() = Vec4us(w, w, z, x)
val Vec4us.wwzy: Vec4us
    get() = Vec4us(w, w, z, y)
val Vec4us.wwzz: Vec4us
    get() = Vec4us(w, w, z, z)
val Vec4us.wwzw: Vec4us
    get() = Vec4us(w, w, z, w)
val Vec4us.wwwx: Vec4us
    get() = Vec4us(w, w, w, x)
val Vec4us.wwwy: Vec4us
    get() = Vec4us(w, w, w, y)
val Vec4us.wwwz: Vec4us
    get() = Vec4us(w, w, w, z)
val Vec4us.wwww: Vec4us
    get() = Vec4us(w, w, w, w)