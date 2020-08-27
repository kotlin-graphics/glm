package glm_.vec4.swizzle

import glm_.vec2.Vec2ul
import glm_.vec3.Vec3ul
import glm_.vec4.Vec4ul

val Vec4ul.xx: Vec2ul
    get() = Vec2ul(x, x)
var Vec4ul.xy: Vec2ul
    get() = Vec2ul(x, y)
    set(value) {
        x = value.x
        y = value.y
    }
var Vec4ul.xz: Vec2ul
    get() = Vec2ul(x, z)
    set(value) {
        x = value.x
        z = value.y
    }
var Vec4ul.xw: Vec2ul
    get() = Vec2ul(x, w)
    set(value) {
        x = value.x
        w = value.y
    }
var Vec4ul.yx: Vec2ul
    get() = Vec2ul(y, x)
    set(value) {
        y = value.x
        x = value.y
    }
val Vec4ul.yy: Vec2ul
    get() = Vec2ul(y, y)
var Vec4ul.yz: Vec2ul
    get() = Vec2ul(y, z)
    set(value) {
        y = value.x
        z = value.y
    }
var Vec4ul.yw: Vec2ul
    get() = Vec2ul(y, w)
    set(value) {
        y = value.x
        w = value.y
    }
var Vec4ul.zx: Vec2ul
    get() = Vec2ul(z, x)
    set(value) {
        z = value.x
        x = value.y
    }
var Vec4ul.zy: Vec2ul
    get() = Vec2ul(z, y)
    set(value) {
        z = value.x
        y = value.y
    }
val Vec4ul.zz: Vec2ul
    get() = Vec2ul(z, z)
var Vec4ul.zw: Vec2ul
    get() = Vec2ul(z, w)
    set(value) {
        z = value.x
        w = value.y
    }
var Vec4ul.wx: Vec2ul
    get() = Vec2ul(w, x)
    set(value) {
        w = value.x
        x = value.y
    }
var Vec4ul.wy: Vec2ul
    get() = Vec2ul(w, y)
    set(value) {
        w = value.x
        y = value.y
    }
var Vec4ul.wz: Vec2ul
    get() = Vec2ul(w, z)
    set(value) {
        w = value.x
        z = value.y
    }
val Vec4ul.ww: Vec2ul
    get() = Vec2ul(w, w)


val Vec4ul.xxx: Vec3ul
    get() = Vec3ul(x, x, x)
val Vec4ul.xxy: Vec3ul
    get() = Vec3ul(x, x, y)
val Vec4ul.xxz: Vec3ul
    get() = Vec3ul(x, x, z)
val Vec4ul.xxw: Vec3ul
    get() = Vec3ul(x, x, w)
val Vec4ul.xyx: Vec3ul
    get() = Vec3ul(x, y, x)
val Vec4ul.xyy: Vec3ul
    get() = Vec3ul(x, y, y)
var Vec4ul.xyz: Vec3ul
    get() = Vec3ul(x, y, z)
    set(value) {
        x = value.x
        y = value.y
        z = value.z
    }

var Vec4ul.xyw: Vec3ul
    get() = Vec3ul(x, y, w)
    set(value) {
        x = value.x
        y = value.y
        w = value.z
    }

val Vec4ul.xzx: Vec3ul
    get() = Vec3ul(x, z, x)
var Vec4ul.xzy: Vec3ul
    get() = Vec3ul(x, z, y)
    set(value) {
        x = value.x
        z = value.y
        y = value.z
    }

val Vec4ul.xzz: Vec3ul
    get() = Vec3ul(x, z, z)
var Vec4ul.xzw: Vec3ul
    get() = Vec3ul(x, z, w)
    set(value) {
        x = value.x
        z = value.y
        w = value.z
    }

val Vec4ul.xwx: Vec3ul
    get() = Vec3ul(x, w, x)
var Vec4ul.xwy: Vec3ul
    get() = Vec3ul(x, w, y)
    set(value) {
        x = value.x
        w = value.y
        y = value.z
    }

var Vec4ul.xwz: Vec3ul
    get() = Vec3ul(x, w, z)
    set(value) {
        x = value.x
        w = value.y
        z = value.z
    }

val Vec4ul.xww: Vec3ul
    get() = Vec3ul(x, w, w)

val Vec4ul.yxx: Vec3ul
    get() = Vec3ul(y, x, x)
val Vec4ul.yxy: Vec3ul
    get() = Vec3ul(y, x, y)
var Vec4ul.yxz: Vec3ul
    get() = Vec3ul(y, x, z)
    set(value) {
        y = value.x
        x = value.y
        z = value.z
    }

var Vec4ul.yxw: Vec3ul
    get() = Vec3ul(y, x, w)
    set(value) {
        y = value.x
        x = value.y
        w = value.z
    }

val Vec4ul.yyx: Vec3ul
    get() = Vec3ul(y, y, x)
val Vec4ul.yyy: Vec3ul
    get() = Vec3ul(y, y, y)
val Vec4ul.yyz: Vec3ul
    get() = Vec3ul(y, y, z)
val Vec4ul.yyw: Vec3ul
    get() = Vec3ul(y, y, w)
var Vec4ul.yzx: Vec3ul
    get() = Vec3ul(y, z, x)
    set(value) {
        y = value.x
        z = value.y
        x = value.z
    }

val Vec4ul.yzy: Vec3ul
    get() = Vec3ul(y, z, y)
val Vec4ul.yzz: Vec3ul
    get() = Vec3ul(y, z, z)
var Vec4ul.yzw: Vec3ul
    get() = Vec3ul(y, z, w)
    set(value) {
        y = value.x
        z = value.y
        w = value.z
    }
var Vec4ul.ywx: Vec3ul
    get() = Vec3ul(y, w, x)
    set(value) {
        y = value.x
        w = value.y
        x = value.z
    }
val Vec4ul.ywy: Vec3ul
    get() = Vec3ul(y, w, y)
var Vec4ul.ywz: Vec3ul
    get() = Vec3ul(y, w, z)
    set(value) {
        y = value.x
        w = value.y
        z = value.z
    }
val Vec4ul.yww: Vec3ul
    get() = Vec3ul(y, w, w)

val Vec4ul.zxx: Vec3ul
    get() = Vec3ul(z, x, x)
var Vec4ul.zxy: Vec3ul
    get() = Vec3ul(z, x, y)
    set(value) {
        z = value.x
        x = value.y
        y = value.z
    }

val Vec4ul.zxz: Vec3ul
    get() = Vec3ul(z, x, z)
var Vec4ul.zxw: Vec3ul
    get() = Vec3ul(z, x, w)
    set(value) {
        z = value.x
        x = value.y
        w = value.z
    }

var Vec4ul.zyx: Vec3ul
    get() = Vec3ul(z, y, x)
    set(value) {
        z = value.x
        y = value.y
        x = value.z
    }

val Vec4ul.zyy: Vec3ul
    get() = Vec3ul(z, y, y)
val Vec4ul.zyz: Vec3ul
    get() = Vec3ul(z, y, z)
var Vec4ul.zyw: Vec3ul
    get() = Vec3ul(z, y, w)
    set(value) {
        z = value.x
        y = value.y
        w = value.z
    }

val Vec4ul.zzx: Vec3ul
    get() = Vec3ul(z, z, x)
val Vec4ul.zzy: Vec3ul
    get() = Vec3ul(z, z, y)
val Vec4ul.zzz: Vec3ul
    get() = Vec3ul(z, z, z)
val Vec4ul.zzw: Vec3ul
    get() = Vec3ul(z, z, w)

var Vec4ul.zwx: Vec3ul
    get() = Vec3ul(z, w, x)
    set(value) {
        z = value.x
        w = value.y
        x = value.z
    }
var Vec4ul.zwy: Vec3ul
    get() = Vec3ul(z, w, y)
    set(value) {
        z = value.x
        w = value.y
        y = value.z
    }
val Vec4ul.zwz: Vec3ul
    get() = Vec3ul(z, w, z)
val Vec4ul.zww: Vec3ul
    get() = Vec3ul(z, w, w)

val Vec4ul.wxx: Vec3ul
    get() = Vec3ul(w, x, x)
var Vec4ul.wxy: Vec3ul
    get() = Vec3ul(w, x, y)
    set(value) {
        w = value.x
        x = value.y
        y = value.z
    }

var Vec4ul.wxz: Vec3ul
    get() = Vec3ul(w, x, z)
    set(value) {
        w = value.x
        x = value.y
        z = value.z
    }

val Vec4ul.wxw: Vec3ul
    get() = Vec3ul(w, x, w)
var Vec4ul.wyx: Vec3ul
    get() = Vec3ul(w, y, x)
    set(value) {
        w = value.x
        y = value.y
        x = value.z
    }

val Vec4ul.wyy: Vec3ul
    get() = Vec3ul(w, y, y)
var Vec4ul.wyz: Vec3ul
    get() = Vec3ul(w, y, z)
    set(value) {
        w = value.x
        y = value.y
        z = value.z
    }

val Vec4ul.wyw: Vec3ul
    get() = Vec3ul(w, y, w)
var Vec4ul.wzx: Vec3ul
    get() = Vec3ul(w, z, x)
    set(value) {
        w = value.x
        z = value.y
        x = value.z
    }

var Vec4ul.wzy: Vec3ul
    get() = Vec3ul(w, z, y)
    set(value) {
        w = value.x
        z = value.y
        y = value.z
    }
val Vec4ul.wzz: Vec3ul
    get() = Vec3ul(w, z, z)

val Vec4ul.wzw: Vec3ul
    get() = Vec3ul(w, z, w)
val Vec4ul.wwx: Vec3ul
    get() = Vec3ul(w, w, x)
val Vec4ul.wwy: Vec3ul
    get() = Vec3ul(w, w, y)
val Vec4ul.wwz: Vec3ul
    get() = Vec3ul(w, w, z)
val Vec4ul.www: Vec3ul
    get() = Vec3ul(w, w, w)

val Vec4ul.xxxx: Vec4ul
    get() = Vec4ul(x, x, x, x)
val Vec4ul.xxxy: Vec4ul
    get() = Vec4ul(x, x, x, y)
val Vec4ul.xxxz: Vec4ul
    get() = Vec4ul(x, x, x, z)
val Vec4ul.xxxw: Vec4ul
    get() = Vec4ul(x, x, x, w)
val Vec4ul.xxyx: Vec4ul
    get() = Vec4ul(x, x, y, x)
val Vec4ul.xxyy: Vec4ul
    get() = Vec4ul(x, x, y, y)
val Vec4ul.xxyz: Vec4ul
    get() = Vec4ul(x, x, y, z)
val Vec4ul.xxyw: Vec4ul
    get() = Vec4ul(x, x, y, w)
val Vec4ul.xxzx: Vec4ul
    get() = Vec4ul(x, x, z, x)
val Vec4ul.xxzy: Vec4ul
    get() = Vec4ul(x, x, z, y)
val Vec4ul.xxzz: Vec4ul
    get() = Vec4ul(x, x, z, z)
val Vec4ul.xxzw: Vec4ul
    get() = Vec4ul(x, x, z, w)
val Vec4ul.xxwx: Vec4ul
    get() = Vec4ul(x, x, w, x)
val Vec4ul.xxwy: Vec4ul
    get() = Vec4ul(x, x, w, y)
val Vec4ul.xxwz: Vec4ul
    get() = Vec4ul(x, x, w, z)
val Vec4ul.xxww: Vec4ul
    get() = Vec4ul(x, x, w, w)
val Vec4ul.xyxx: Vec4ul
    get() = Vec4ul(x, y, x, x)
val Vec4ul.xyxy: Vec4ul
    get() = Vec4ul(x, y, x, y)
val Vec4ul.xyxz: Vec4ul
    get() = Vec4ul(x, y, x, z)
val Vec4ul.xyxw: Vec4ul
    get() = Vec4ul(x, y, x, w)
val Vec4ul.xyyx: Vec4ul
    get() = Vec4ul(x, y, y, x)
val Vec4ul.xyyy: Vec4ul
    get() = Vec4ul(x, y, y, y)
val Vec4ul.xyyz: Vec4ul
    get() = Vec4ul(x, y, y, w)
val Vec4ul.xyyw: Vec4ul
    get() = Vec4ul(x, y, y, w)
val Vec4ul.xyzx: Vec4ul
    get() = Vec4ul(x, y, z, x)
val Vec4ul.xyzy: Vec4ul
    get() = Vec4ul(x, y, z, y)
val Vec4ul.xyzz: Vec4ul
    get() = Vec4ul(x, y, z, z)
var Vec4ul.xyzw
    get() = Vec4ul(x, y, z, w)
    set(value) = put(value.x, value.y, value.z, value.w)
val Vec4ul.xywx
    get() = Vec4ul(x, y, w, x)
val Vec4ul.xywy
    get() = Vec4ul(x, y, w, y)
var Vec4ul.xywz
    get() = Vec4ul(x, y, w, z)
    set(value) = put(value.x, value.y, value.w, value.z)
val Vec4ul.xyww: Vec4ul
    get() = Vec4ul(x, y, w, w)
val Vec4ul.xzxx: Vec4ul
    get() = Vec4ul(x, z, x, x)
val Vec4ul.xzxy: Vec4ul
    get() = Vec4ul(x, z, x, y)
val Vec4ul.xzxz: Vec4ul
    get() = Vec4ul(x, z, x, z)
val Vec4ul.xzxw: Vec4ul
    get() = Vec4ul(x, z, x, w)
val Vec4ul.xzyx: Vec4ul
    get() = Vec4ul(x, z, y, x)
val Vec4ul.xzyy: Vec4ul
    get() = Vec4ul(x, z, y, y)
val Vec4ul.xzyz: Vec4ul
    get() = Vec4ul(x, z, y, z)
var Vec4ul.xzyw
    get() = Vec4ul(x, z, y, w)
    set(value) = put(value.x, value.z, value.y, value.w)
val Vec4ul.xzzx: Vec4ul
    get() = Vec4ul(x, z, z, x)
val Vec4ul.xzzy: Vec4ul
    get() = Vec4ul(x, z, z, y)
val Vec4ul.xzzz: Vec4ul
    get() = Vec4ul(x, z, z, z)
val Vec4ul.xzzw: Vec4ul
    get() = Vec4ul(x, z, z, w)
val Vec4ul.xzwx: Vec4ul
    get() = Vec4ul(x, z, w, x)
var Vec4ul.xzwy: Vec4ul
    get() = Vec4ul(x, z, w, y)
    set(value) = put(value.x, value.z, value.w, value.y)
val Vec4ul.xzwz: Vec4ul
    get() = Vec4ul(x, z, w, z)
val Vec4ul.xzww: Vec4ul
    get() = Vec4ul(x, z, w, w)
val Vec4ul.xwxx: Vec4ul
    get() = Vec4ul(x, w, x, x)
val Vec4ul.xwxy: Vec4ul
    get() = Vec4ul(x, w, x, y)
val Vec4ul.xwxz: Vec4ul
    get() = Vec4ul(x, w, x, z)
val Vec4ul.xwxw: Vec4ul
    get() = Vec4ul(x, w, x, w)
val Vec4ul.xwyx: Vec4ul
    get() = Vec4ul(x, w, y, x)
val Vec4ul.xwyy: Vec4ul
    get() = Vec4ul(x, w, y, y)
var Vec4ul.xwyz
    get() = Vec4ul(x, w, y, z)
    set(value) = put(value.x, value.w, value.y, value.z)
val Vec4ul.xwyw: Vec4ul
    get() = Vec4ul(x, w, y, w)
val Vec4ul.xwzx: Vec4ul
    get() = Vec4ul(x, w, z, x)
var Vec4ul.xwzy: Vec4ul
    get() = Vec4ul(x, w, z, y)
    set(value) = put(value.x, value.w, value.z, value.y)
val Vec4ul.xwzz: Vec4ul
    get() = Vec4ul(x, w, z, z)
val Vec4ul.xwzw: Vec4ul
    get() = Vec4ul(x, w, z, w)
val Vec4ul.xwwx: Vec4ul
    get() = Vec4ul(x, w, w, x)
val Vec4ul.xwwy: Vec4ul
    get() = Vec4ul(x, w, w, y)
val Vec4ul.xwwz: Vec4ul
    get() = Vec4ul(x, w, w, z)
val Vec4ul.xwww: Vec4ul
    get() = Vec4ul(x, w, w, w)
val Vec4ul.yxxx: Vec4ul
    get() = Vec4ul(y, x, x, x)
val Vec4ul.yxxy: Vec4ul
    get() = Vec4ul(y, x, x, y)
val Vec4ul.yxxz: Vec4ul
    get() = Vec4ul(y, x, x, z)
val Vec4ul.yxxw: Vec4ul
    get() = Vec4ul(y, x, x, w)
val Vec4ul.yxyx: Vec4ul
    get() = Vec4ul(y, x, y, x)
val Vec4ul.yxyy: Vec4ul
    get() = Vec4ul(y, x, y, y)
val Vec4ul.yxyz: Vec4ul
    get() = Vec4ul(y, x, y, z)
val Vec4ul.yxyw: Vec4ul
    get() = Vec4ul(y, x, y, w)
val Vec4ul.yxzx: Vec4ul
    get() = Vec4ul(y, x, z, x)
val Vec4ul.yxzy: Vec4ul
    get() = Vec4ul(y, x, z, y)
val Vec4ul.yxzz: Vec4ul
    get() = Vec4ul(y, x, z, z)
var Vec4ul.yxzw: Vec4ul
    get() = Vec4ul(y, x, z, w)
    set(value) = put(value.y, value.x, value.z, value.w)
val Vec4ul.yxwx
    get() = Vec4ul(y, x, w, x)
val Vec4ul.yxwy
    get() = Vec4ul(y, x, w, y)
var Vec4ul.yxwz
    get() = Vec4ul(y, x, w, z)
    set(value) = put(value.y, value.x, value.w, value.z)
val Vec4ul.yxww
    get() = Vec4ul(y, x, w, w)
val Vec4ul.yyxx: Vec4ul
    get() = Vec4ul(y, y, x, x)
val Vec4ul.yyxy: Vec4ul
    get() = Vec4ul(y, y, x, y)
val Vec4ul.yyxz: Vec4ul
    get() = Vec4ul(y, y, x, z)
val Vec4ul.yyxw: Vec4ul
    get() = Vec4ul(y, y, x, w)
val Vec4ul.yyyx: Vec4ul
    get() = Vec4ul(y, y, y, x)
val Vec4ul.yyyy: Vec4ul
    get() = Vec4ul(y, y, y, y)
val Vec4ul.yyyz: Vec4ul
    get() = Vec4ul(y, y, y, z)
val Vec4ul.yyyw: Vec4ul
    get() = Vec4ul(y, y, y, w)
val Vec4ul.yyzx: Vec4ul
    get() = Vec4ul(y, y, z, x)
val Vec4ul.yyzy: Vec4ul
    get() = Vec4ul(y, y, z, y)
val Vec4ul.yyzz: Vec4ul
    get() = Vec4ul(y, y, z, z)
val Vec4ul.yyzw: Vec4ul
    get() = Vec4ul(y, y, z, w)
val Vec4ul.yywx: Vec4ul
    get() = Vec4ul(y, y, w, x)
val Vec4ul.yywy: Vec4ul
    get() = Vec4ul(y, y, w, y)
val Vec4ul.yywz: Vec4ul
    get() = Vec4ul(y, y, w, z)
val Vec4ul.yyww: Vec4ul
    get() = Vec4ul(y, y, w, w)
val Vec4ul.yzxx: Vec4ul
    get() = Vec4ul(y, z, x, x)
val Vec4ul.yzxy: Vec4ul
    get() = Vec4ul(y, z, x, z)
val Vec4ul.yzxz: Vec4ul
    get() = Vec4ul(y, z, x, z)
var Vec4ul.yzxw
    get() = Vec4ul(y, z, x, w)
    set(value) = put(value.y, value.z, value.x, value.w)
val Vec4ul.yzyx: Vec4ul
    get() = Vec4ul(y, z, y, x)
val Vec4ul.yzyy: Vec4ul
    get() = Vec4ul(y, z, y, y)
val Vec4ul.yzyz: Vec4ul
    get() = Vec4ul(y, z, y, z)
val Vec4ul.yzyw: Vec4ul
    get() = Vec4ul(y, z, y, w)
val Vec4ul.yzzx: Vec4ul
    get() = Vec4ul(y, z, z, x)
val Vec4ul.yzzy: Vec4ul
    get() = Vec4ul(y, z, z, y)
val Vec4ul.yzzz: Vec4ul
    get() = Vec4ul(y, z, z, z)
val Vec4ul.yzzw: Vec4ul
    get() = Vec4ul(y, z, z, w)
var Vec4ul.yzwx
    get() = Vec4ul(y, z, w, x)
    set(value) = put(value.y, value.z, value.w, value.x)
val Vec4ul.yzwy: Vec4ul
    get() = Vec4ul(y, z, w, y)
val Vec4ul.yzwz: Vec4ul
    get() = Vec4ul(y, z, w, z)
val Vec4ul.yzww: Vec4ul
    get() = Vec4ul(y, z, w, w)
val Vec4ul.ywxx: Vec4ul
    get() = Vec4ul(y, w, x, x)
val Vec4ul.ywxy: Vec4ul
    get() = Vec4ul(y, w, x, y)
var Vec4ul.ywxz: Vec4ul
    get() = Vec4ul(y, w, x, z)
    set(value) = put(value.y, value.w, value.x, value.z)
val Vec4ul.ywxw: Vec4ul
    get() = Vec4ul(y, w, x, w)
val Vec4ul.ywyx: Vec4ul
    get() = Vec4ul(y, w, y, x)
val Vec4ul.ywyy: Vec4ul
    get() = Vec4ul(y, w, y, y)
val Vec4ul.ywyz: Vec4ul
    get() = Vec4ul(y, w, y, z)
val Vec4ul.ywyw: Vec4ul
    get() = Vec4ul(y, w, y, w)
var Vec4ul.ywzx: Vec4ul
    get() = Vec4ul(y, w, z, x)
    set(value) = put(value.y, value.w, value.z, value.x)
val Vec4ul.ywzy: Vec4ul
    get() = Vec4ul(y, w, z, y)
val Vec4ul.ywzz: Vec4ul
    get() = Vec4ul(y, w, z, z)
val Vec4ul.ywzw: Vec4ul
    get() = Vec4ul(y, w, z, w)
val Vec4ul.ywwx: Vec4ul
    get() = Vec4ul(y, w, w, x)
val Vec4ul.ywwy: Vec4ul
    get() = Vec4ul(y, w, w, y)
val Vec4ul.ywwz: Vec4ul
    get() = Vec4ul(y, w, w, z)
val Vec4ul.ywww: Vec4ul
    get() = Vec4ul(y, w, w, w)
val Vec4ul.zxxx: Vec4ul
    get() = Vec4ul(z, x, x, x)
val Vec4ul.zxxy: Vec4ul
    get() = Vec4ul(z, x, x, y)
val Vec4ul.zxxz: Vec4ul
    get() = Vec4ul(z, x, x, z)
val Vec4ul.zxxw: Vec4ul
    get() = Vec4ul(z, x, x, w)
val Vec4ul.zxyx: Vec4ul
    get() = Vec4ul(z, x, y, x)
val Vec4ul.zxyy: Vec4ul
    get() = Vec4ul(z, x, y, y)
val Vec4ul.zxyz: Vec4ul
    get() = Vec4ul(z, x, y, z)
var Vec4ul.zxyw: Vec4ul
    get() = Vec4ul(z, x, y, w)
    set(value) = put(value.z, value.x, value.y, value.w)
val Vec4ul.zxzx: Vec4ul
    get() = Vec4ul(z, x, z, x)
val Vec4ul.zxzy: Vec4ul
    get() = Vec4ul(z, x, z, y)
val Vec4ul.zxzz: Vec4ul
    get() = Vec4ul(z, x, z, z)
val Vec4ul.zxzw: Vec4ul
    get() = Vec4ul(z, x, w, x)
val Vec4ul.zxwx: Vec4ul
    get() = Vec4ul(z, x, w, x)
var Vec4ul.zxwy: Vec4ul
    get() = Vec4ul(z, x, w, y)
    set(value) = put(value.z, value.x, value.w, value.y)
val Vec4ul.zxwz: Vec4ul
    get() = Vec4ul(z, x, w, y)
val Vec4ul.zxww: Vec4ul
    get() = Vec4ul(z, x, w, w)
val Vec4ul.zyxx: Vec4ul
    get() = Vec4ul(z, y, x, x)
val Vec4ul.zyxy: Vec4ul
    get() = Vec4ul(z, y, x, y)
val Vec4ul.zyxz: Vec4ul
    get() = Vec4ul(z, y, x, z)
var Vec4ul.zyxw: Vec4ul
    get() = Vec4ul(z, y, x, w)
    set(value) = put(value.z, value.y, value.x, value.w)
val Vec4ul.zyyx: Vec4ul
    get() = Vec4ul(z, y, y, x)
val Vec4ul.zyyy: Vec4ul
    get() = Vec4ul(z, y, y, y)
val Vec4ul.zyyz: Vec4ul
    get() = Vec4ul(z, y, y, z)
val Vec4ul.zyyw: Vec4ul
    get() = Vec4ul(z, y, y, w)
val Vec4ul.zyzx: Vec4ul
    get() = Vec4ul(z, y, z, x)
val Vec4ul.zyzy: Vec4ul
    get() = Vec4ul(z, y, z, y)
val Vec4ul.zyzz: Vec4ul
    get() = Vec4ul(z, y, z, z)
val Vec4ul.zyzw: Vec4ul
    get() = Vec4ul(z, y, z, w)
var Vec4ul.zywx: Vec4ul
    get() = Vec4ul(z, y, w, x)
    set(value) = put(value.z, value.y, value.w, value.x)
val Vec4ul.zywy: Vec4ul
    get() = Vec4ul(z, y, w, y)
val Vec4ul.zywz: Vec4ul
    get() = Vec4ul(z, y, w, z)
val Vec4ul.zyww: Vec4ul
    get() = Vec4ul(z, y, w, w)
val Vec4ul.zzxx: Vec4ul
    get() = Vec4ul(z, z, x, x)
val Vec4ul.zzxy: Vec4ul
    get() = Vec4ul(z, z, x, y)
val Vec4ul.zzxz: Vec4ul
    get() = Vec4ul(z, z, x, z)
val Vec4ul.zzxw: Vec4ul
    get() = Vec4ul(z, z, x, w)
val Vec4ul.zzyx: Vec4ul
    get() = Vec4ul(z, z, y, x)
val Vec4ul.zzyy: Vec4ul
    get() = Vec4ul(z, z, y, y)
val Vec4ul.zzyz: Vec4ul
    get() = Vec4ul(z, z, y, z)
val Vec4ul.zzyw: Vec4ul
    get() = Vec4ul(z, z, y, w)
val Vec4ul.zzzx: Vec4ul
    get() = Vec4ul(z, z, z, x)
val Vec4ul.zzzy: Vec4ul
    get() = Vec4ul(z, z, z, y)
val Vec4ul.zzzz: Vec4ul
    get() = Vec4ul(z, z, z, z)
val Vec4ul.zzzw: Vec4ul
    get() = Vec4ul(z, z, z, w)
val Vec4ul.zzwx: Vec4ul
    get() = Vec4ul(z, z, w, x)
val Vec4ul.zzwy: Vec4ul
    get() = Vec4ul(z, z, w, y)
val Vec4ul.zzwz: Vec4ul
    get() = Vec4ul(z, z, w, z)
val Vec4ul.zzww: Vec4ul
    get() = Vec4ul(z, z, w, w)
val Vec4ul.zwxx: Vec4ul
    get() = Vec4ul(z, w, x, x)
var Vec4ul.zwxy: Vec4ul
    get() = Vec4ul(z, w, x, y)
    set(value) = put(value.z, value.w, value.x, value.y)
val Vec4ul.zwxz: Vec4ul
    get() = Vec4ul(z, w, x, z)
val Vec4ul.zwxw: Vec4ul
    get() = Vec4ul(z, w, x, w)
var Vec4ul.zwyx: Vec4ul
    get() = Vec4ul(z, w, y, x)
    set(value) = put(value.z, value.w, value.y, value.x)
val Vec4ul.zwyy: Vec4ul
    get() = Vec4ul(z, w, y, y)
val Vec4ul.zwyz: Vec4ul
    get() = Vec4ul(z, w, y, z)
val Vec4ul.zwyw: Vec4ul
    get() = Vec4ul(z, w, y, w)
val Vec4ul.zwzx: Vec4ul
    get() = Vec4ul(z, w, z, x)
val Vec4ul.zwzy: Vec4ul
    get() = Vec4ul(z, w, z, y)
val Vec4ul.zwzz: Vec4ul
    get() = Vec4ul(z, w, z, z)
val Vec4ul.zwzw: Vec4ul
    get() = Vec4ul(z, w, z, w)
val Vec4ul.zwwx: Vec4ul
    get() = Vec4ul(z, w, w, y)
val Vec4ul.zwwy: Vec4ul
    get() = Vec4ul(z, w, w, y)
val Vec4ul.zwwz: Vec4ul
    get() = Vec4ul(z, w, w, z)
val Vec4ul.zwww: Vec4ul
    get() = Vec4ul(z, w, w, w)
val Vec4ul.wxxx: Vec4ul
    get() = Vec4ul(w, x, x, x)
val Vec4ul.wxxy: Vec4ul
    get() = Vec4ul(w, x, x, y)
val Vec4ul.wxxz: Vec4ul
    get() = Vec4ul(w, x, x, z)
val Vec4ul.wxxw: Vec4ul
    get() = Vec4ul(w, x, x, w)
val Vec4ul.wxyx: Vec4ul
    get() = Vec4ul(w, x, y, x)
val Vec4ul.wxyy: Vec4ul
    get() = Vec4ul(w, x, y, y)
var Vec4ul.wxyz: Vec4ul
    get() = Vec4ul(w, x, y, z)
    set(value) = put(value.w, value.x, value.y, value.z)
val Vec4ul.wxyw: Vec4ul
    get() = Vec4ul(w, x, y, w)
val Vec4ul.wxzx: Vec4ul
    get() = Vec4ul(w, x, z, x)
var Vec4ul.wxzy: Vec4ul
    get() = Vec4ul(w, x, z, y)
    set(value) = put(value.w, value.x, value.z, value.y)
val Vec4ul.wxzz: Vec4ul
    get() = Vec4ul(w, x, z, z)
val Vec4ul.wxzw: Vec4ul
    get() = Vec4ul(w, x, z, w)
val Vec4ul.wxwx: Vec4ul
    get() = Vec4ul(w, x, w, x)
val Vec4ul.wxwy: Vec4ul
    get() = Vec4ul(w, x, w, y)
val Vec4ul.wxwz: Vec4ul
    get() = Vec4ul(w, x, w, z)
val Vec4ul.wxww: Vec4ul
    get() = Vec4ul(w, x, w, w)
val Vec4ul.wyxx: Vec4ul
    get() = Vec4ul(w, y, x, x)
val Vec4ul.wyxy: Vec4ul
    get() = Vec4ul(w, y, x, y)
var Vec4ul.wyxz: Vec4ul
    get() = Vec4ul(w, y, x, z)
    set(value) = put(value.w, value.y, value.x, value.z)
val Vec4ul.wyxw: Vec4ul
    get() = Vec4ul(w, y, x, w)
val Vec4ul.wyyx: Vec4ul
    get() = Vec4ul(w, y, y, x)
val Vec4ul.wyyy: Vec4ul
    get() = Vec4ul(w, y, y, y)
val Vec4ul.wyyz: Vec4ul
    get() = Vec4ul(w, y, y, z)
val Vec4ul.wyyw: Vec4ul
    get() = Vec4ul(w, y, y, w)
var Vec4ul.wyzx: Vec4ul
    get() = Vec4ul(w, y, z, x)
    set(value) = put(value.w, value.y, value.z, value.x)
val Vec4ul.wyzy: Vec4ul
    get() = Vec4ul(w, y, z, y)
val Vec4ul.wyzz: Vec4ul
    get() = Vec4ul(w, y, z, z)
val Vec4ul.wyzw: Vec4ul
    get() = Vec4ul(w, y, z, w)
val Vec4ul.wywx: Vec4ul
    get() = Vec4ul(w, y, w, x)
val Vec4ul.wywy: Vec4ul
    get() = Vec4ul(w, y, w, y)
val Vec4ul.wywz: Vec4ul
    get() = Vec4ul(w, y, w, z)
val Vec4ul.wyww: Vec4ul
    get() = Vec4ul(w, y, w, w)
val Vec4ul.wzxx: Vec4ul
    get() = Vec4ul(w, z, x, x)
var Vec4ul.wzxy: Vec4ul
    get() = Vec4ul(w, z, x, y)
    set(value) = put(value.w, value.z, value.x, value.y)
val Vec4ul.wzxz: Vec4ul
    get() = Vec4ul(w, z, x, z)
val Vec4ul.wzxw: Vec4ul
    get() = Vec4ul(w, z, x, w)
var Vec4ul.wzyx: Vec4ul
    get() = Vec4ul(w, z, y, x)
    set(value) = put(value.w, value.z, value.y, value.x)
val Vec4ul.wzyy: Vec4ul
    get() = Vec4ul(w, z, y, y)
val Vec4ul.wzyz: Vec4ul
    get() = Vec4ul(w, z, y, z)
val Vec4ul.wzyw: Vec4ul
    get() = Vec4ul(w, z, y, w)
val Vec4ul.wzzx: Vec4ul
    get() = Vec4ul(w, z, z, x)
val Vec4ul.wzzy: Vec4ul
    get() = Vec4ul(w, z, z, y)
val Vec4ul.wzzz: Vec4ul
    get() = Vec4ul(w, z, z, z)
val Vec4ul.wzzw: Vec4ul
    get() = Vec4ul(w, z, z, w)
val Vec4ul.wzwx: Vec4ul
    get() = Vec4ul(w, z, w, x)
val Vec4ul.wzwy: Vec4ul
    get() = Vec4ul(w, z, w, y)
val Vec4ul.wzwz: Vec4ul
    get() = Vec4ul(w, z, w, z)
val Vec4ul.wzww: Vec4ul
    get() = Vec4ul(w, z, w, w)
val Vec4ul.wwxx: Vec4ul
    get() = Vec4ul(w, w, x, x)
val Vec4ul.wwxy: Vec4ul
    get() = Vec4ul(w, w, x, y)
val Vec4ul.wwxz: Vec4ul
    get() = Vec4ul(w, w, x, z)
val Vec4ul.wwxw: Vec4ul
    get() = Vec4ul(w, w, x, w)
val Vec4ul.wwyx: Vec4ul
    get() = Vec4ul(w, w, y, x)
val Vec4ul.wwyy: Vec4ul
    get() = Vec4ul(w, w, y, y)
val Vec4ul.wwyz: Vec4ul
    get() = Vec4ul(w, w, y, z)
val Vec4ul.wwyw: Vec4ul
    get() = Vec4ul(w, w, y, w)
val Vec4ul.wwzx: Vec4ul
    get() = Vec4ul(w, w, z, x)
val Vec4ul.wwzy: Vec4ul
    get() = Vec4ul(w, w, z, y)
val Vec4ul.wwzz: Vec4ul
    get() = Vec4ul(w, w, z, z)
val Vec4ul.wwzw: Vec4ul
    get() = Vec4ul(w, w, z, w)
val Vec4ul.wwwx: Vec4ul
    get() = Vec4ul(w, w, w, x)
val Vec4ul.wwwy: Vec4ul
    get() = Vec4ul(w, w, w, y)
val Vec4ul.wwwz: Vec4ul
    get() = Vec4ul(w, w, w, z)
val Vec4ul.wwww: Vec4ul
    get() = Vec4ul(w, w, w, w)