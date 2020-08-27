package glm_.Vec4b.swizzle

import glm_.vec2.Vec2b
import glm_.vec3.Vec3b
import glm_.vec4.Vec4b

val Vec4b.xx: Vec2b
    get() = Vec2b(x, x)
var Vec4b.xy: Vec2b
    get() = Vec2b(x, y)
    set(value) {
        x = value.x
        y = value.y
    }
var Vec4b.xz: Vec2b
    get() = Vec2b(x, z)
    set(value) {
        x = value.x
        z = value.y
    }
var Vec4b.xw: Vec2b
    get() = Vec2b(x, w)
    set(value) {
        x = value.x
        w = value.y
    }
var Vec4b.yx: Vec2b
    get() = Vec2b(y, x)
    set(value) {
        y = value.x
        x = value.y
    }
val Vec4b.yy: Vec2b
    get() = Vec2b(y, y)
var Vec4b.yz: Vec2b
    get() = Vec2b(y, z)
    set(value) {
        y = value.x
        z = value.y
    }
var Vec4b.yw: Vec2b
    get() = Vec2b(y, w)
    set(value) {
        y = value.x
        w = value.y
    }
var Vec4b.zx: Vec2b
    get() = Vec2b(z, x)
    set(value) {
        z = value.x
        x = value.y
    }
var Vec4b.zy: Vec2b
    get() = Vec2b(z, y)
    set(value) {
        z = value.x
        y = value.y
    }
val Vec4b.zz: Vec2b
    get() = Vec2b(z, z)
var Vec4b.zw: Vec2b
    get() = Vec2b(z, w)
    set(value) {
        z = value.x
        w = value.y
    }
var Vec4b.wx: Vec2b
    get() = Vec2b(w, x)
    set(value) {
        w = value.x
        x = value.y
    }
var Vec4b.wy: Vec2b
    get() = Vec2b(w, y)
    set(value) {
        w = value.x
        y = value.y
    }
var Vec4b.wz: Vec2b
    get() = Vec2b(w, z)
    set(value) {
        w = value.x
        z = value.y
    }
val Vec4b.ww: Vec2b
    get() = Vec2b(w, w)


val Vec4b.xxx: Vec3b
    get() = Vec3b(x, x, x)
val Vec4b.xxy: Vec3b
    get() = Vec3b(x, x, y)
val Vec4b.xxz: Vec3b
    get() = Vec3b(x, x, z)
val Vec4b.xxw: Vec3b
    get() = Vec3b(x, x, w)
val Vec4b.xyx: Vec3b
    get() = Vec3b(x, y, x)
val Vec4b.xyy: Vec3b
    get() = Vec3b(x, y, y)
var Vec4b.xyz: Vec3b
    get() = Vec3b(x, y, z)
    set(value) {
        x = value.x
        y = value.y
        z = value.z
    }

var Vec4b.xyw: Vec3b
    get() = Vec3b(x, y, w)
    set(value) {
        x = value.x
        y = value.y
        w = value.z
    }

val Vec4b.xzx: Vec3b
    get() = Vec3b(x, z, x)
var Vec4b.xzy: Vec3b
    get() = Vec3b(x, z, y)
    set(value) {
        x = value.x
        z = value.y
        y = value.z
    }

val Vec4b.xzz: Vec3b
    get() = Vec3b(x, z, z)
var Vec4b.xzw: Vec3b
    get() = Vec3b(x, z, w)
    set(value) {
        x = value.x
        z = value.y
        w = value.z
    }

val Vec4b.xwx: Vec3b
    get() = Vec3b(x, w, x)
var Vec4b.xwy: Vec3b
    get() = Vec3b(x, w, y)
    set(value) {
        x = value.x
        w = value.y
        y = value.z
    }

var Vec4b.xwz: Vec3b
    get() = Vec3b(x, w, z)
    set(value) {
        x = value.x
        w = value.y
        z = value.z
    }

val Vec4b.xww: Vec3b
    get() = Vec3b(x, w, w)

val Vec4b.yxx: Vec3b
    get() = Vec3b(y, x, x)
val Vec4b.yxy: Vec3b
    get() = Vec3b(y, x, y)
var Vec4b.yxz: Vec3b
    get() = Vec3b(y, x, z)
    set(value) {
        y = value.x
        x = value.y
        z = value.z
    }

var Vec4b.yxw: Vec3b
    get() = Vec3b(y, x, w)
    set(value) {
        y = value.x
        x = value.y
        w = value.z
    }

val Vec4b.yyx: Vec3b
    get() = Vec3b(y, y, x)
val Vec4b.yyy: Vec3b
    get() = Vec3b(y, y, y)
val Vec4b.yyz: Vec3b
    get() = Vec3b(y, y, z)
val Vec4b.yyw: Vec3b
    get() = Vec3b(y, y, w)
var Vec4b.yzx: Vec3b
    get() = Vec3b(y, z, x)
    set(value) {
        y = value.x
        z = value.y
        x = value.z
    }

val Vec4b.yzy: Vec3b
    get() = Vec3b(y, z, y)
val Vec4b.yzz: Vec3b
    get() = Vec3b(y, z, z)
var Vec4b.yzw: Vec3b
    get() = Vec3b(y, z, w)
    set(value) {
        y = value.x
        z = value.y
        w = value.z
    }
var Vec4b.ywx: Vec3b
    get() = Vec3b(y, w, x)
    set(value) {
        y = value.x
        w = value.y
        x = value.z
    }
val Vec4b.ywy: Vec3b
    get() = Vec3b(y, w, y)
var Vec4b.ywz: Vec3b
    get() = Vec3b(y, w, z)
    set(value) {
        y = value.x
        w = value.y
        z = value.z
    }
val Vec4b.yww: Vec3b
    get() = Vec3b(y, w, w)

val Vec4b.zxx: Vec3b
    get() = Vec3b(z, x, x)
var Vec4b.zxy: Vec3b
    get() = Vec3b(z, x, y)
    set(value) {
        z = value.x
        x = value.y
        y = value.z
    }

val Vec4b.zxz: Vec3b
    get() = Vec3b(z, x, z)
var Vec4b.zxw: Vec3b
    get() = Vec3b(z, x, w)
    set(value) {
        z = value.x
        x = value.y
        w = value.z
    }

var Vec4b.zyx: Vec3b
    get() = Vec3b(z, y, x)
    set(value) {
        z = value.x
        y = value.y
        x = value.z
    }

val Vec4b.zyy: Vec3b
    get() = Vec3b(z, y, y)
val Vec4b.zyz: Vec3b
    get() = Vec3b(z, y, z)
var Vec4b.zyw: Vec3b
    get() = Vec3b(z, y, w)
    set(value) {
        z = value.x
        y = value.y
        w = value.z
    }

val Vec4b.zzx: Vec3b
    get() = Vec3b(z, z, x)
val Vec4b.zzy: Vec3b
    get() = Vec3b(z, z, y)
val Vec4b.zzz: Vec3b
    get() = Vec3b(z, z, z)
val Vec4b.zzw: Vec3b
    get() = Vec3b(z, z, w)

var Vec4b.zwx: Vec3b
    get() = Vec3b(z, w, x)
    set(value) {
        z = value.x
        w = value.y
        x = value.z
    }
var Vec4b.zwy: Vec3b
    get() = Vec3b(z, w, y)
    set(value) {
        z = value.x
        w = value.y
        y = value.z
    }
val Vec4b.zwz: Vec3b
    get() = Vec3b(z, w, z)
val Vec4b.zww: Vec3b
    get() = Vec3b(z, w, w)

val Vec4b.wxx: Vec3b
    get() = Vec3b(w, x, x)
var Vec4b.wxy: Vec3b
    get() = Vec3b(w, x, y)
    set(value) {
        w = value.x
        x = value.y
        y = value.z
    }

var Vec4b.wxz: Vec3b
    get() = Vec3b(w, x, z)
    set(value) {
        w = value.x
        x = value.y
        z = value.z
    }

val Vec4b.wxw: Vec3b
    get() = Vec3b(w, x, w)
var Vec4b.wyx: Vec3b
    get() = Vec3b(w, y, x)
    set(value) {
        w = value.x
        y = value.y
        x = value.z
    }

val Vec4b.wyy: Vec3b
    get() = Vec3b(w, y, y)
var Vec4b.wyz: Vec3b
    get() = Vec3b(w, y, z)
    set(value) {
        w = value.x
        y = value.y
        z = value.z
    }

val Vec4b.wyw: Vec3b
    get() = Vec3b(w, y, w)
var Vec4b.wzx: Vec3b
    get() = Vec3b(w, z, x)
    set(value) {
        w = value.x
        z = value.y
        x = value.z
    }

var Vec4b.wzy: Vec3b
    get() = Vec3b(w, z, y)
    set(value) {
        w = value.x
        z = value.y
        y = value.z
    }
val Vec4b.wzz: Vec3b
    get() = Vec3b(w, z, z)

val Vec4b.wzw: Vec3b
    get() = Vec3b(w, z, w)
val Vec4b.wwx: Vec3b
    get() = Vec3b(w, w, x)
val Vec4b.wwy: Vec3b
    get() = Vec3b(w, w, y)
val Vec4b.wwz: Vec3b
    get() = Vec3b(w, w, z)
val Vec4b.www: Vec3b
    get() = Vec3b(w, w, w)

val Vec4b.xxxx: Vec4b
    get() = Vec4b(x, x, x, x)
val Vec4b.xxxy: Vec4b
    get() = Vec4b(x, x, x, y)
val Vec4b.xxxz: Vec4b
    get() = Vec4b(x, x, x, z)
val Vec4b.xxxw: Vec4b
    get() = Vec4b(x, x, x, w)
val Vec4b.xxyx: Vec4b
    get() = Vec4b(x, x, y, x)
val Vec4b.xxyy: Vec4b
    get() = Vec4b(x, x, y, y)
val Vec4b.xxyz: Vec4b
    get() = Vec4b(x, x, y, z)
val Vec4b.xxyw: Vec4b
    get() = Vec4b(x, x, y, w)
val Vec4b.xxzx: Vec4b
    get() = Vec4b(x, x, z, x)
val Vec4b.xxzy: Vec4b
    get() = Vec4b(x, x, z, y)
val Vec4b.xxzz: Vec4b
    get() = Vec4b(x, x, z, z)
val Vec4b.xxzw: Vec4b
    get() = Vec4b(x, x, z, w)
val Vec4b.xxwx: Vec4b
    get() = Vec4b(x, x, w, x)
val Vec4b.xxwy: Vec4b
    get() = Vec4b(x, x, w, y)
val Vec4b.xxwz: Vec4b
    get() = Vec4b(x, x, w, z)
val Vec4b.xxww: Vec4b
    get() = Vec4b(x, x, w, w)
val Vec4b.xyxx: Vec4b
    get() = Vec4b(x, y, x, x)
val Vec4b.xyxy: Vec4b
    get() = Vec4b(x, y, x, y)
val Vec4b.xyxz: Vec4b
    get() = Vec4b(x, y, x, z)
val Vec4b.xyxw: Vec4b
    get() = Vec4b(x, y, x, w)
val Vec4b.xyyx: Vec4b
    get() = Vec4b(x, y, y, x)
val Vec4b.xyyy: Vec4b
    get() = Vec4b(x, y, y, y)
val Vec4b.xyyz: Vec4b
    get() = Vec4b(x, y, y, w)
val Vec4b.xyyw: Vec4b
    get() = Vec4b(x, y, y, w)
val Vec4b.xyzx: Vec4b
    get() = Vec4b(x, y, z, x)
val Vec4b.xyzy: Vec4b
    get() = Vec4b(x, y, z, y)
val Vec4b.xyzz: Vec4b
    get() = Vec4b(x, y, z, z)
var Vec4b.xyzw
    get() = Vec4b(x, y, z, w)
    set(value) = put(value.x, value.y, value.z, value.w)
val Vec4b.xywx
    get() = Vec4b(x, y, w, x)
val Vec4b.xywy
    get() = Vec4b(x, y, w, y)
var Vec4b.xywz
    get() = Vec4b(x, y, w, z)
    set(value) = put(value.x, value.y, value.w, value.z)
val Vec4b.xyww: Vec4b
    get() = Vec4b(x, y, w, w)
val Vec4b.xzxx: Vec4b
    get() = Vec4b(x, z, x, x)
val Vec4b.xzxy: Vec4b
    get() = Vec4b(x, z, x, y)
val Vec4b.xzxz: Vec4b
    get() = Vec4b(x, z, x, z)
val Vec4b.xzxw: Vec4b
    get() = Vec4b(x, z, x, w)
val Vec4b.xzyx: Vec4b
    get() = Vec4b(x, z, y, x)
val Vec4b.xzyy: Vec4b
    get() = Vec4b(x, z, y, y)
val Vec4b.xzyz: Vec4b
    get() = Vec4b(x, z, y, z)
var Vec4b.xzyw
    get() = Vec4b(x, z, y, w)
    set(value) = put(value.x, value.z, value.y, value.w)
val Vec4b.xzzx: Vec4b
    get() = Vec4b(x, z, z, x)
val Vec4b.xzzy: Vec4b
    get() = Vec4b(x, z, z, y)
val Vec4b.xzzz: Vec4b
    get() = Vec4b(x, z, z, z)
val Vec4b.xzzw: Vec4b
    get() = Vec4b(x, z, z, w)
val Vec4b.xzwx: Vec4b
    get() = Vec4b(x, z, w, x)
var Vec4b.xzwy: Vec4b
    get() = Vec4b(x, z, w, y)
    set(value) = put(value.x, value.z, value.w, value.y)
val Vec4b.xzwz: Vec4b
    get() = Vec4b(x, z, w, z)
val Vec4b.xzww: Vec4b
    get() = Vec4b(x, z, w, w)
val Vec4b.xwxx: Vec4b
    get() = Vec4b(x, w, x, x)
val Vec4b.xwxy: Vec4b
    get() = Vec4b(x, w, x, y)
val Vec4b.xwxz: Vec4b
    get() = Vec4b(x, w, x, z)
val Vec4b.xwxw: Vec4b
    get() = Vec4b(x, w, x, w)
val Vec4b.xwyx: Vec4b
    get() = Vec4b(x, w, y, x)
val Vec4b.xwyy: Vec4b
    get() = Vec4b(x, w, y, y)
var Vec4b.xwyz
    get() = Vec4b(x, w, y, z)
    set(value) = put(value.x, value.w, value.y, value.z)
val Vec4b.xwyw: Vec4b
    get() = Vec4b(x, w, y, w)
val Vec4b.xwzx: Vec4b
    get() = Vec4b(x, w, z, x)
var Vec4b.xwzy: Vec4b
    get() = Vec4b(x, w, z, y)
    set(value) = put(value.x, value.w, value.z, value.y)
val Vec4b.xwzz: Vec4b
    get() = Vec4b(x, w, z, z)
val Vec4b.xwzw: Vec4b
    get() = Vec4b(x, w, z, w)
val Vec4b.xwwx: Vec4b
    get() = Vec4b(x, w, w, x)
val Vec4b.xwwy: Vec4b
    get() = Vec4b(x, w, w, y)
val Vec4b.xwwz: Vec4b
    get() = Vec4b(x, w, w, z)
val Vec4b.xwww: Vec4b
    get() = Vec4b(x, w, w, w)
val Vec4b.yxxx: Vec4b
    get() = Vec4b(y, x, x, x)
val Vec4b.yxxy: Vec4b
    get() = Vec4b(y, x, x, y)
val Vec4b.yxxz: Vec4b
    get() = Vec4b(y, x, x, z)
val Vec4b.yxxw: Vec4b
    get() = Vec4b(y, x, x, w)
val Vec4b.yxyx: Vec4b
    get() = Vec4b(y, x, y, x)
val Vec4b.yxyy: Vec4b
    get() = Vec4b(y, x, y, y)
val Vec4b.yxyz: Vec4b
    get() = Vec4b(y, x, y, z)
val Vec4b.yxyw: Vec4b
    get() = Vec4b(y, x, y, w)
val Vec4b.yxzx: Vec4b
    get() = Vec4b(y, x, z, x)
val Vec4b.yxzy: Vec4b
    get() = Vec4b(y, x, z, y)
val Vec4b.yxzz: Vec4b
    get() = Vec4b(y, x, z, z)
var Vec4b.yxzw: Vec4b
    get() = Vec4b(y, x, z, w)
    set(value) = put(value.y, value.x, value.z, value.w)
val Vec4b.yxwx
    get() = Vec4b(y, x, w, x)
val Vec4b.yxwy
    get() = Vec4b(y, x, w, y)
var Vec4b.yxwz
    get() = Vec4b(y, x, w, z)
    set(value) = put(value.y, value.x, value.w, value.z)
val Vec4b.yxww
    get() = Vec4b(y, x, w, w)
val Vec4b.yyxx: Vec4b
    get() = Vec4b(y, y, x, x)
val Vec4b.yyxy: Vec4b
    get() = Vec4b(y, y, x, y)
val Vec4b.yyxz: Vec4b
    get() = Vec4b(y, y, x, z)
val Vec4b.yyxw: Vec4b
    get() = Vec4b(y, y, x, w)
val Vec4b.yyyx: Vec4b
    get() = Vec4b(y, y, y, x)
val Vec4b.yyyy: Vec4b
    get() = Vec4b(y, y, y, y)
val Vec4b.yyyz: Vec4b
    get() = Vec4b(y, y, y, z)
val Vec4b.yyyw: Vec4b
    get() = Vec4b(y, y, y, w)
val Vec4b.yyzx: Vec4b
    get() = Vec4b(y, y, z, x)
val Vec4b.yyzy: Vec4b
    get() = Vec4b(y, y, z, y)
val Vec4b.yyzz: Vec4b
    get() = Vec4b(y, y, z, z)
val Vec4b.yyzw: Vec4b
    get() = Vec4b(y, y, z, w)
val Vec4b.yywx: Vec4b
    get() = Vec4b(y, y, w, x)
val Vec4b.yywy: Vec4b
    get() = Vec4b(y, y, w, y)
val Vec4b.yywz: Vec4b
    get() = Vec4b(y, y, w, z)
val Vec4b.yyww: Vec4b
    get() = Vec4b(y, y, w, w)
val Vec4b.yzxx: Vec4b
    get() = Vec4b(y, z, x, x)
val Vec4b.yzxy: Vec4b
    get() = Vec4b(y, z, x, z)
val Vec4b.yzxz: Vec4b
    get() = Vec4b(y, z, x, z)
var Vec4b.yzxw
    get() = Vec4b(y, z, x, w)
    set(value) = put(value.y, value.z, value.x, value.w)
val Vec4b.yzyx: Vec4b
    get() = Vec4b(y, z, y, x)
val Vec4b.yzyy: Vec4b
    get() = Vec4b(y, z, y, y)
val Vec4b.yzyz: Vec4b
    get() = Vec4b(y, z, y, z)
val Vec4b.yzyw: Vec4b
    get() = Vec4b(y, z, y, w)
val Vec4b.yzzx: Vec4b
    get() = Vec4b(y, z, z, x)
val Vec4b.yzzy: Vec4b
    get() = Vec4b(y, z, z, y)
val Vec4b.yzzz: Vec4b
    get() = Vec4b(y, z, z, z)
val Vec4b.yzzw: Vec4b
    get() = Vec4b(y, z, z, w)
var Vec4b.yzwx
    get() = Vec4b(y, z, w, x)
    set(value) = put(value.y, value.z, value.w, value.x)
val Vec4b.yzwy: Vec4b
    get() = Vec4b(y, z, w, y)
val Vec4b.yzwz: Vec4b
    get() = Vec4b(y, z, w, z)
val Vec4b.yzww: Vec4b
    get() = Vec4b(y, z, w, w)
val Vec4b.ywxx: Vec4b
    get() = Vec4b(y, w, x, x)
val Vec4b.ywxy: Vec4b
    get() = Vec4b(y, w, x, y)
var Vec4b.ywxz: Vec4b
    get() = Vec4b(y, w, x, z)
    set(value) = put(value.y, value.w, value.x, value.z)
val Vec4b.ywxw: Vec4b
    get() = Vec4b(y, w, x, w)
val Vec4b.ywyx: Vec4b
    get() = Vec4b(y, w, y, x)
val Vec4b.ywyy: Vec4b
    get() = Vec4b(y, w, y, y)
val Vec4b.ywyz: Vec4b
    get() = Vec4b(y, w, y, z)
val Vec4b.ywyw: Vec4b
    get() = Vec4b(y, w, y, w)
var Vec4b.ywzx: Vec4b
    get() = Vec4b(y, w, z, x)
    set(value) = put(value.y, value.w, value.z, value.x)
val Vec4b.ywzy: Vec4b
    get() = Vec4b(y, w, z, y)
val Vec4b.ywzz: Vec4b
    get() = Vec4b(y, w, z, z)
val Vec4b.ywzw: Vec4b
    get() = Vec4b(y, w, z, w)
val Vec4b.ywwx: Vec4b
    get() = Vec4b(y, w, w, x)
val Vec4b.ywwy: Vec4b
    get() = Vec4b(y, w, w, y)
val Vec4b.ywwz: Vec4b
    get() = Vec4b(y, w, w, z)
val Vec4b.ywww: Vec4b
    get() = Vec4b(y, w, w, w)
val Vec4b.zxxx: Vec4b
    get() = Vec4b(z, x, x, x)
val Vec4b.zxxy: Vec4b
    get() = Vec4b(z, x, x, y)
val Vec4b.zxxz: Vec4b
    get() = Vec4b(z, x, x, z)
val Vec4b.zxxw: Vec4b
    get() = Vec4b(z, x, x, w)
val Vec4b.zxyx: Vec4b
    get() = Vec4b(z, x, y, x)
val Vec4b.zxyy: Vec4b
    get() = Vec4b(z, x, y, y)
val Vec4b.zxyz: Vec4b
    get() = Vec4b(z, x, y, z)
var Vec4b.zxyw: Vec4b
    get() = Vec4b(z, x, y, w)
    set(value) = put(value.z, value.x, value.y, value.w)
val Vec4b.zxzx: Vec4b
    get() = Vec4b(z, x, z, x)
val Vec4b.zxzy: Vec4b
    get() = Vec4b(z, x, z, y)
val Vec4b.zxzz: Vec4b
    get() = Vec4b(z, x, z, z)
val Vec4b.zxzw: Vec4b
    get() = Vec4b(z, x, w, x)
val Vec4b.zxwx: Vec4b
    get() = Vec4b(z, x, w, x)
var Vec4b.zxwy: Vec4b
    get() = Vec4b(z, x, w, y)
    set(value) = put(value.z, value.x, value.w, value.y)
val Vec4b.zxwz: Vec4b
    get() = Vec4b(z, x, w, y)
val Vec4b.zxww: Vec4b
    get() = Vec4b(z, x, w, w)
val Vec4b.zyxx: Vec4b
    get() = Vec4b(z, y, x, x)
val Vec4b.zyxy: Vec4b
    get() = Vec4b(z, y, x, y)
val Vec4b.zyxz: Vec4b
    get() = Vec4b(z, y, x, z)
var Vec4b.zyxw: Vec4b
    get() = Vec4b(z, y, x, w)
    set(value) = put(value.z, value.y, value.x, value.w)
val Vec4b.zyyx: Vec4b
    get() = Vec4b(z, y, y, x)
val Vec4b.zyyy: Vec4b
    get() = Vec4b(z, y, y, y)
val Vec4b.zyyz: Vec4b
    get() = Vec4b(z, y, y, z)
val Vec4b.zyyw: Vec4b
    get() = Vec4b(z, y, y, w)
val Vec4b.zyzx: Vec4b
    get() = Vec4b(z, y, z, x)
val Vec4b.zyzy: Vec4b
    get() = Vec4b(z, y, z, y)
val Vec4b.zyzz: Vec4b
    get() = Vec4b(z, y, z, z)
val Vec4b.zyzw: Vec4b
    get() = Vec4b(z, y, z, w)
var Vec4b.zywx: Vec4b
    get() = Vec4b(z, y, w, x)
    set(value) = put(value.z, value.y, value.w, value.x)
val Vec4b.zywy: Vec4b
    get() = Vec4b(z, y, w, y)
val Vec4b.zywz: Vec4b
    get() = Vec4b(z, y, w, z)
val Vec4b.zyww: Vec4b
    get() = Vec4b(z, y, w, w)
val Vec4b.zzxx: Vec4b
    get() = Vec4b(z, z, x, x)
val Vec4b.zzxy: Vec4b
    get() = Vec4b(z, z, x, y)
val Vec4b.zzxz: Vec4b
    get() = Vec4b(z, z, x, z)
val Vec4b.zzxw: Vec4b
    get() = Vec4b(z, z, x, w)
val Vec4b.zzyx: Vec4b
    get() = Vec4b(z, z, y, x)
val Vec4b.zzyy: Vec4b
    get() = Vec4b(z, z, y, y)
val Vec4b.zzyz: Vec4b
    get() = Vec4b(z, z, y, z)
val Vec4b.zzyw: Vec4b
    get() = Vec4b(z, z, y, w)
val Vec4b.zzzx: Vec4b
    get() = Vec4b(z, z, z, x)
val Vec4b.zzzy: Vec4b
    get() = Vec4b(z, z, z, y)
val Vec4b.zzzz: Vec4b
    get() = Vec4b(z, z, z, z)
val Vec4b.zzzw: Vec4b
    get() = Vec4b(z, z, z, w)
val Vec4b.zzwx: Vec4b
    get() = Vec4b(z, z, w, x)
val Vec4b.zzwy: Vec4b
    get() = Vec4b(z, z, w, y)
val Vec4b.zzwz: Vec4b
    get() = Vec4b(z, z, w, z)
val Vec4b.zzww: Vec4b
    get() = Vec4b(z, z, w, w)
val Vec4b.zwxx: Vec4b
    get() = Vec4b(z, w, x, x)
var Vec4b.zwxy: Vec4b
    get() = Vec4b(z, w, x, y)
    set(value) = put(value.z, value.w, value.x, value.y)
val Vec4b.zwxz: Vec4b
    get() = Vec4b(z, w, x, z)
val Vec4b.zwxw: Vec4b
    get() = Vec4b(z, w, x, w)
var Vec4b.zwyx: Vec4b
    get() = Vec4b(z, w, y, x)
    set(value) = put(value.z, value.w, value.y, value.x)
val Vec4b.zwyy: Vec4b
    get() = Vec4b(z, w, y, y)
val Vec4b.zwyz: Vec4b
    get() = Vec4b(z, w, y, z)
val Vec4b.zwyw: Vec4b
    get() = Vec4b(z, w, y, w)
val Vec4b.zwzx: Vec4b
    get() = Vec4b(z, w, z, x)
val Vec4b.zwzy: Vec4b
    get() = Vec4b(z, w, z, y)
val Vec4b.zwzz: Vec4b
    get() = Vec4b(z, w, z, z)
val Vec4b.zwzw: Vec4b
    get() = Vec4b(z, w, z, w)
val Vec4b.zwwx: Vec4b
    get() = Vec4b(z, w, w, y)
val Vec4b.zwwy: Vec4b
    get() = Vec4b(z, w, w, y)
val Vec4b.zwwz: Vec4b
    get() = Vec4b(z, w, w, z)
val Vec4b.zwww: Vec4b
    get() = Vec4b(z, w, w, w)
val Vec4b.wxxx: Vec4b
    get() = Vec4b(w, x, x, x)
val Vec4b.wxxy: Vec4b
    get() = Vec4b(w, x, x, y)
val Vec4b.wxxz: Vec4b
    get() = Vec4b(w, x, x, z)
val Vec4b.wxxw: Vec4b
    get() = Vec4b(w, x, x, w)
val Vec4b.wxyx: Vec4b
    get() = Vec4b(w, x, y, x)
val Vec4b.wxyy: Vec4b
    get() = Vec4b(w, x, y, y)
var Vec4b.wxyz: Vec4b
    get() = Vec4b(w, x, y, z)
    set(value) = put(value.w, value.x, value.y, value.z)
val Vec4b.wxyw: Vec4b
    get() = Vec4b(w, x, y, w)
val Vec4b.wxzx: Vec4b
    get() = Vec4b(w, x, z, x)
var Vec4b.wxzy: Vec4b
    get() = Vec4b(w, x, z, y)
    set(value) = put(value.w, value.x, value.z, value.y)
val Vec4b.wxzz: Vec4b
    get() = Vec4b(w, x, z, z)
val Vec4b.wxzw: Vec4b
    get() = Vec4b(w, x, z, w)
val Vec4b.wxwx: Vec4b
    get() = Vec4b(w, x, w, x)
val Vec4b.wxwy: Vec4b
    get() = Vec4b(w, x, w, y)
val Vec4b.wxwz: Vec4b
    get() = Vec4b(w, x, w, z)
val Vec4b.wxww: Vec4b
    get() = Vec4b(w, x, w, w)
val Vec4b.wyxx: Vec4b
    get() = Vec4b(w, y, x, x)
val Vec4b.wyxy: Vec4b
    get() = Vec4b(w, y, x, y)
var Vec4b.wyxz: Vec4b
    get() = Vec4b(w, y, x, z)
    set(value) = put(value.w, value.y, value.x, value.z)
val Vec4b.wyxw: Vec4b
    get() = Vec4b(w, y, x, w)
val Vec4b.wyyx: Vec4b
    get() = Vec4b(w, y, y, x)
val Vec4b.wyyy: Vec4b
    get() = Vec4b(w, y, y, y)
val Vec4b.wyyz: Vec4b
    get() = Vec4b(w, y, y, z)
val Vec4b.wyyw: Vec4b
    get() = Vec4b(w, y, y, w)
var Vec4b.wyzx: Vec4b
    get() = Vec4b(w, y, z, x)
    set(value) = put(value.w, value.y, value.z, value.x)
val Vec4b.wyzy: Vec4b
    get() = Vec4b(w, y, z, y)
val Vec4b.wyzz: Vec4b
    get() = Vec4b(w, y, z, z)
val Vec4b.wyzw: Vec4b
    get() = Vec4b(w, y, z, w)
val Vec4b.wywx: Vec4b
    get() = Vec4b(w, y, w, x)
val Vec4b.wywy: Vec4b
    get() = Vec4b(w, y, w, y)
val Vec4b.wywz: Vec4b
    get() = Vec4b(w, y, w, z)
val Vec4b.wyww: Vec4b
    get() = Vec4b(w, y, w, w)
val Vec4b.wzxx: Vec4b
    get() = Vec4b(w, z, x, x)
var Vec4b.wzxy: Vec4b
    get() = Vec4b(w, z, x, y)
    set(value) = put(value.w, value.z, value.x, value.y)
val Vec4b.wzxz: Vec4b
    get() = Vec4b(w, z, x, z)
val Vec4b.wzxw: Vec4b
    get() = Vec4b(w, z, x, w)
var Vec4b.wzyx: Vec4b
    get() = Vec4b(w, z, y, x)
    set(value) = put(value.w, value.z, value.y, value.x)
val Vec4b.wzyy: Vec4b
    get() = Vec4b(w, z, y, y)
val Vec4b.wzyz: Vec4b
    get() = Vec4b(w, z, y, z)
val Vec4b.wzyw: Vec4b
    get() = Vec4b(w, z, y, w)
val Vec4b.wzzx: Vec4b
    get() = Vec4b(w, z, z, x)
val Vec4b.wzzy: Vec4b
    get() = Vec4b(w, z, z, y)
val Vec4b.wzzz: Vec4b
    get() = Vec4b(w, z, z, z)
val Vec4b.wzzw: Vec4b
    get() = Vec4b(w, z, z, w)
val Vec4b.wzwx: Vec4b
    get() = Vec4b(w, z, w, x)
val Vec4b.wzwy: Vec4b
    get() = Vec4b(w, z, w, y)
val Vec4b.wzwz: Vec4b
    get() = Vec4b(w, z, w, z)
val Vec4b.wzww: Vec4b
    get() = Vec4b(w, z, w, w)
val Vec4b.wwxx: Vec4b
    get() = Vec4b(w, w, x, x)
val Vec4b.wwxy: Vec4b
    get() = Vec4b(w, w, x, y)
val Vec4b.wwxz: Vec4b
    get() = Vec4b(w, w, x, z)
val Vec4b.wwxw: Vec4b
    get() = Vec4b(w, w, x, w)
val Vec4b.wwyx: Vec4b
    get() = Vec4b(w, w, y, x)
val Vec4b.wwyy: Vec4b
    get() = Vec4b(w, w, y, y)
val Vec4b.wwyz: Vec4b
    get() = Vec4b(w, w, y, z)
val Vec4b.wwyw: Vec4b
    get() = Vec4b(w, w, y, w)
val Vec4b.wwzx: Vec4b
    get() = Vec4b(w, w, z, x)
val Vec4b.wwzy: Vec4b
    get() = Vec4b(w, w, z, y)
val Vec4b.wwzz: Vec4b
    get() = Vec4b(w, w, z, z)
val Vec4b.wwzw: Vec4b
    get() = Vec4b(w, w, z, w)
val Vec4b.wwwx: Vec4b
    get() = Vec4b(w, w, w, x)
val Vec4b.wwwy: Vec4b
    get() = Vec4b(w, w, w, y)
val Vec4b.wwwz: Vec4b
    get() = Vec4b(w, w, w, z)
val Vec4b.wwww: Vec4b
    get() = Vec4b(w, w, w, w)