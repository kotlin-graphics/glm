package glm_.vec4.swizzle

import glm_.vec2.Vec2
import glm_.vec3.Vec3
import glm_.vec4.Vec4

val Vec4.xx: Vec2
    get() = Vec2(x, x)
var Vec4.xy: Vec2
    get() = Vec2(x, y)
    set(value) {
        x = value.x
        y = value.y
    }
var Vec4.xz: Vec2
    get() = Vec2(x, z)
    set(value) {
        x = value.x
        z = value.y
    }
var Vec4.xw: Vec2
    get() = Vec2(x, w)
    set(value) {
        x = value.x
        w = value.y
    }
var Vec4.yx: Vec2
    get() = Vec2(y, x)
    set(value) {
        y = value.x
        x = value.y
    }
val Vec4.yy: Vec2
    get() = Vec2(y, y)
var Vec4.yz: Vec2
    get() = Vec2(y, z)
    set(value) {
        y = value.x
        z = value.y
    }
var Vec4.yw: Vec2
    get() = Vec2(y, w)
    set(value) {
        y = value.x
        w = value.y
    }
var Vec4.zx: Vec2
    get() = Vec2(z, x)
    set(value) {
        z = value.x
        x = value.y
    }
var Vec4.zy: Vec2
    get() = Vec2(z, y)
    set(value) {
        z = value.x
        y = value.y
    }
val Vec4.zz: Vec2
    get() = Vec2(z, z)
var Vec4.zw: Vec2
    get() = Vec2(z, w)
    set(value) {
        z = value.x
        w = value.y
    }
var Vec4.wx: Vec2
    get() = Vec2(w, x)
    set(value) {
        w = value.x
        x = value.y
    }
var Vec4.wy: Vec2
    get() = Vec2(w, y)
    set(value) {
        w = value.x
        y = value.y
    }
var Vec4.wz: Vec2
    get() = Vec2(w, z)
    set(value) {
        w = value.x
        z = value.y
    }
val Vec4.ww: Vec2
    get() = Vec2(w, w)


val Vec4.xxx: Vec3
    get() = Vec3(x, x, x)
val Vec4.xxy: Vec3
    get() = Vec3(x, x, y)
val Vec4.xxz: Vec3
    get() = Vec3(x, x, z)
val Vec4.xxw: Vec3
    get() = Vec3(x, x, w)
val Vec4.xyx: Vec3
    get() = Vec3(x, y, x)
val Vec4.xyy: Vec3
    get() = Vec3(x, y, y)
var Vec4.xyz: Vec3
    get() = Vec3(x, y, z)
    set(value) {
        x = value.x
        y = value.y
        z = value.z
    }

var Vec4.xyw: Vec3
    get() = Vec3(x, y, w)
    set(value) {
        x = value.x
        y = value.y
        w = value.z
    }

val Vec4.xzx: Vec3
    get() = Vec3(x, z, x)
var Vec4.xzy: Vec3
    get() = Vec3(x, z, y)
    set(value) {
        x = value.x
        z = value.y
        y = value.z
    }

val Vec4.xzz: Vec3
    get() = Vec3(x, z, z)
var Vec4.xzw: Vec3
    get() = Vec3(x, z, w)
    set(value) {
        x = value.x
        z = value.y
        w = value.z
    }

val Vec4.xwx: Vec3
    get() = Vec3(x, w, x)
var Vec4.xwy: Vec3
    get() = Vec3(x, w, y)
    set(value) {
        x = value.x
        w = value.y
        y = value.z
    }

var Vec4.xwz: Vec3
    get() = Vec3(x, w, z)
    set(value) {
        x = value.x
        w = value.y
        z = value.z
    }

val Vec4.xww: Vec3
    get() = Vec3(x, w, w)

val Vec4.yxx: Vec3
    get() = Vec3(y, x, x)
val Vec4.yxy: Vec3
    get() = Vec3(y, x, y)
var Vec4.yxz: Vec3
    get() = Vec3(y, x, z)
    set(value) {
        y = value.x
        x = value.y
        z = value.z
    }

var Vec4.yxw: Vec3
    get() = Vec3(y, x, w)
    set(value) {
        y = value.x
        x = value.y
        w = value.z
    }

val Vec4.yyx: Vec3
    get() = Vec3(y, y, x)
val Vec4.yyy: Vec3
    get() = Vec3(y, y, y)
val Vec4.yyz: Vec3
    get() = Vec3(y, y, z)
val Vec4.yyw: Vec3
    get() = Vec3(y, y, w)
var Vec4.yzx: Vec3
    get() = Vec3(y, z, x)
    set(value) {
        y = value.x
        z = value.y
        x = value.z
    }

val Vec4.yzy: Vec3
    get() = Vec3(y, z, y)
val Vec4.yzz: Vec3
    get() = Vec3(y, z, z)
var Vec4.yzw: Vec3
    get() = Vec3(y, z, w)
    set(value) {
        y = value.x
        z = value.y
        w = value.z
    }
var Vec4.ywx: Vec3
    get() = Vec3(y, w, x)
    set(value) {
        y = value.x
        w = value.y
        x = value.z
    }
val Vec4.ywy: Vec3
    get() = Vec3(y, w, y)
var Vec4.ywz: Vec3
    get() = Vec3(y, w, z)
    set(value) {
        y = value.x
        w = value.y
        z = value.z
    }
val Vec4.yww: Vec3
    get() = Vec3(y, w, w)

val Vec4.zxx: Vec3
    get() = Vec3(z, x, x)
var Vec4.zxy: Vec3
    get() = Vec3(z, x, y)
    set(value) {
        z = value.x
        x = value.y
        y = value.z
    }

val Vec4.zxz: Vec3
    get() = Vec3(z, x, z)
var Vec4.zxw: Vec3
    get() = Vec3(z, x, w)
    set(value) {
        z = value.x
        x = value.y
        w = value.z
    }

var Vec4.zyx: Vec3
    get() = Vec3(z, y, x)
    set(value) {
        z = value.x
        y = value.y
        x = value.z
    }

val Vec4.zyy: Vec3
    get() = Vec3(z, y, y)
val Vec4.zyz: Vec3
    get() = Vec3(z, y, z)
var Vec4.zyw: Vec3
    get() = Vec3(z, y, w)
    set(value) {
        z = value.x
        y = value.y
        w = value.z
    }

val Vec4.zzx: Vec3
    get() = Vec3(z, z, x)
val Vec4.zzy: Vec3
    get() = Vec3(z, z, y)
val Vec4.zzz: Vec3
    get() = Vec3(z, z, z)
val Vec4.zzw: Vec3
    get() = Vec3(z, z, w)

var Vec4.zwx: Vec3
    get() = Vec3(z, w, x)
    set(value) {
        z = value.x
        w = value.y
        x = value.z
    }
var Vec4.zwy: Vec3
    get() = Vec3(z, w, y)
    set(value) {
        z = value.x
        w = value.y
        y = value.z
    }
val Vec4.zwz: Vec3
    get() = Vec3(z, w, z)
val Vec4.zww: Vec3
    get() = Vec3(z, w, w)

val Vec4.wxx: Vec3
    get() = Vec3(w, x, x)
var Vec4.wxy: Vec3
    get() = Vec3(w, x, y)
    set(value) {
        w = value.x
        x = value.y
        y = value.z
    }

var Vec4.wxz: Vec3
    get() = Vec3(w, x, z)
    set(value) {
        w = value.x
        x = value.y
        z = value.z
    }

val Vec4.wxw: Vec3
    get() = Vec3(w, x, w)
var Vec4.wyx: Vec3
    get() = Vec3(w, y, x)
    set(value) {
        w = value.x
        y = value.y
        x = value.z
    }

val Vec4.wyy: Vec3
    get() = Vec3(w, y, y)
var Vec4.wyz: Vec3
    get() = Vec3(w, y, z)
    set(value) {
        w = value.x
        y = value.y
        z = value.z
    }

val Vec4.wyw: Vec3
    get() = Vec3(w, y, w)
var Vec4.wzx: Vec3
    get() = Vec3(w, z, x)
    set(value) {
        w = value.x
        z = value.y
        x = value.z
    }

var Vec4.wzy: Vec3
    get() = Vec3(w, z, y)
    set(value) {
        w = value.x
        z = value.y
        y = value.z
    }
val Vec4.wzz: Vec3
    get() = Vec3(w, z, z)

val Vec4.wzw: Vec3
    get() = Vec3(w, z, w)
val Vec4.wwx: Vec3
    get() = Vec3(w, w, x)
val Vec4.wwy: Vec3
    get() = Vec3(w, w, y)
val Vec4.wwz: Vec3
    get() = Vec3(w, w, z)
val Vec4.www: Vec3
    get() = Vec3(w, w, w)

val Vec4.xxxx: Vec4
    get() = Vec4(x, x, x, x)
val Vec4.xxxy: Vec4
    get() = Vec4(x, x, x, y)
val Vec4.xxxz: Vec4
    get() = Vec4(x, x, x, z)
val Vec4.xxxw: Vec4
    get() = Vec4(x, x, x, w)
val Vec4.xxyx: Vec4
    get() = Vec4(x, x, y, x)
val Vec4.xxyy: Vec4
    get() = Vec4(x, x, y, y)
val Vec4.xxyz: Vec4
    get() = Vec4(x, x, y, z)
val Vec4.xxyw: Vec4
    get() = Vec4(x, x, y, w)
val Vec4.xxzx: Vec4
    get() = Vec4(x, x, z, x)
val Vec4.xxzy: Vec4
    get() = Vec4(x, x, z, y)
val Vec4.xxzz: Vec4
    get() = Vec4(x, x, z, z)
val Vec4.xxzw: Vec4
    get() = Vec4(x, x, z, w)
val Vec4.xxwx: Vec4
    get() = Vec4(x, x, w, x)
val Vec4.xxwy: Vec4
    get() = Vec4(x, x, w, y)
val Vec4.xxwz: Vec4
    get() = Vec4(x, x, w, z)
val Vec4.xxww: Vec4
    get() = Vec4(x, x, w, w)
val Vec4.xyxx: Vec4
    get() = Vec4(x, y, x, x)
val Vec4.xyxy: Vec4
    get() = Vec4(x, y, x, y)
val Vec4.xyxz: Vec4
    get() = Vec4(x, y, x, z)
val Vec4.xyxw: Vec4
    get() = Vec4(x, y, x, w)
val Vec4.xyyx: Vec4
    get() = Vec4(x, y, y, x)
val Vec4.xyyy: Vec4
    get() = Vec4(x, y, y, y)
val Vec4.xyyz: Vec4
    get() = Vec4(x, y, y, w)
val Vec4.xyyw: Vec4
    get() = Vec4(x, y, y, w)
val Vec4.xyzx: Vec4
    get() = Vec4(x, y, z, x)
val Vec4.xyzy: Vec4
    get() = Vec4(x, y, z, y)
val Vec4.xyzz: Vec4
    get() = Vec4(x, y, z, z)
var Vec4.xyzw
    get() = Vec4(x, y, z, w)
    set(value) = put(value.x, value.y, value.z, value.w)
val Vec4.xywx
    get() = Vec4(x, y, w, x)
val Vec4.xywy
    get() = Vec4(x, y, w, y)
var Vec4.xywz
    get() = Vec4(x, y, w, z)
    set(value) = put(value.x, value.y, value.w, value.z)
val Vec4.xyww: Vec4
    get() = Vec4(x, y, w, w)
val Vec4.xzxx: Vec4
    get() = Vec4(x, z, x, x)
val Vec4.xzxy: Vec4
    get() = Vec4(x, z, x, y)
val Vec4.xzxz: Vec4
    get() = Vec4(x, z, x, z)
val Vec4.xzxw: Vec4
    get() = Vec4(x, z, x, w)
val Vec4.xzyx: Vec4
    get() = Vec4(x, z, y, x)
val Vec4.xzyy: Vec4
    get() = Vec4(x, z, y, y)
val Vec4.xzyz: Vec4
    get() = Vec4(x, z, y, z)
var Vec4.xzyw
    get() = Vec4(x, z, y, w)
    set(value) = put(value.x, value.z, value.y, value.w)
val Vec4.xzzx: Vec4
    get() = Vec4(x, z, z, x)
val Vec4.xzzy: Vec4
    get() = Vec4(x, z, z, y)
val Vec4.xzzz: Vec4
    get() = Vec4(x, z, z, z)
val Vec4.xzzw: Vec4
    get() = Vec4(x, z, z, w)
val Vec4.xzwx: Vec4
    get() = Vec4(x, z, w, x)
var Vec4.xzwy: Vec4
    get() = Vec4(x, z, w, y)
    set(value) = put(value.x, value.z, value.w, value.y)
val Vec4.xzwz: Vec4
    get() = Vec4(x, z, w, z)
val Vec4.xzww: Vec4
    get() = Vec4(x, z, w, w)
val Vec4.xwxx: Vec4
    get() = Vec4(x, w, x, x)
val Vec4.xwxy: Vec4
    get() = Vec4(x, w, x, y)
val Vec4.xwxz: Vec4
    get() = Vec4(x, w, x, z)
val Vec4.xwxw: Vec4
    get() = Vec4(x, w, x, w)
val Vec4.xwyx: Vec4
    get() = Vec4(x, w, y, x)
val Vec4.xwyy: Vec4
    get() = Vec4(x, w, y, y)
var Vec4.xwyz
    get() = Vec4(x, w, y, z)
    set(value) = put(value.x, value.w, value.y, value.z)
val Vec4.xwyw: Vec4
    get() = Vec4(x, w, y, w)
val Vec4.xwzx: Vec4
    get() = Vec4(x, w, z, x)
var Vec4.xwzy: Vec4
    get() = Vec4(x, w, z, y)
    set(value) = put(value.x, value.w, value.z, value.y)
val Vec4.xwzz: Vec4
    get() = Vec4(x, w, z, z)
val Vec4.xwzw: Vec4
    get() = Vec4(x, w, z, w)
val Vec4.xwwx: Vec4
    get() = Vec4(x, w, w, x)
val Vec4.xwwy: Vec4
    get() = Vec4(x, w, w, y)
val Vec4.xwwz: Vec4
    get() = Vec4(x, w, w, z)
val Vec4.xwww: Vec4
    get() = Vec4(x, w, w, w)
val Vec4.yxxx: Vec4
    get() = Vec4(y, x, x, x)
val Vec4.yxxy: Vec4
    get() = Vec4(y, x, x, y)
val Vec4.yxxz: Vec4
    get() = Vec4(y, x, x, z)
val Vec4.yxxw: Vec4
    get() = Vec4(y, x, x, w)
val Vec4.yxyx: Vec4
    get() = Vec4(y, x, y, x)
val Vec4.yxyy: Vec4
    get() = Vec4(y, x, y, y)
val Vec4.yxyz: Vec4
    get() = Vec4(y, x, y, z)
val Vec4.yxyw: Vec4
    get() = Vec4(y, x, y, w)
val Vec4.yxzx: Vec4
    get() = Vec4(y, x, z, x)
val Vec4.yxzy: Vec4
    get() = Vec4(y, x, z, y)
val Vec4.yxzz: Vec4
    get() = Vec4(y, x, z, z)
var Vec4.yxzw: Vec4
    get() = Vec4(y, x, z, w)
    set(value) = put(value.y, value.x, value.z, value.w)
val Vec4.yxwx
    get() = Vec4(y, x, w, x)
val Vec4.yxwy
    get() = Vec4(y, x, w, y)
var Vec4.yxwz
    get() = Vec4(y, x, w, z)
    set(value) = put(value.y, value.x, value.w, value.z)
val Vec4.yxww
    get() = Vec4(y, x, w, w)
val Vec4.yyxx: Vec4
    get() = Vec4(y, y, x, x)
val Vec4.yyxy: Vec4
    get() = Vec4(y, y, x, y)
val Vec4.yyxz: Vec4
    get() = Vec4(y, y, x, z)
val Vec4.yyxw: Vec4
    get() = Vec4(y, y, x, w)
val Vec4.yyyx: Vec4
    get() = Vec4(y, y, y, x)
val Vec4.yyyy: Vec4
    get() = Vec4(y, y, y, y)
val Vec4.yyyz: Vec4
    get() = Vec4(y, y, y, z)
val Vec4.yyyw: Vec4
    get() = Vec4(y, y, y, w)
val Vec4.yyzx: Vec4
    get() = Vec4(y, y, z, x)
val Vec4.yyzy: Vec4
    get() = Vec4(y, y, z, y)
val Vec4.yyzz: Vec4
    get() = Vec4(y, y, z, z)
val Vec4.yyzw: Vec4
    get() = Vec4(y, y, z, w)
val Vec4.yywx: Vec4
    get() = Vec4(y, y, w, x)
val Vec4.yywy: Vec4
    get() = Vec4(y, y, w, y)
val Vec4.yywz: Vec4
    get() = Vec4(y, y, w, z)
val Vec4.yyww: Vec4
    get() = Vec4(y, y, w, w)
val Vec4.yzxx: Vec4
    get() = Vec4(y, z, x, x)
val Vec4.yzxy: Vec4
    get() = Vec4(y, z, x, z)
val Vec4.yzxz: Vec4
    get() = Vec4(y, z, x, z)
var Vec4.yzxw
    get() = Vec4(y, z, x, w)
    set(value) = put(value.y, value.z, value.x, value.w)
val Vec4.yzyx: Vec4
    get() = Vec4(y, z, y, x)
val Vec4.yzyy: Vec4
    get() = Vec4(y, z, y, y)
val Vec4.yzyz: Vec4
    get() = Vec4(y, z, y, z)
val Vec4.yzyw: Vec4
    get() = Vec4(y, z, y, w)
val Vec4.yzzx: Vec4
    get() = Vec4(y, z, z, x)
val Vec4.yzzy: Vec4
    get() = Vec4(y, z, z, y)
val Vec4.yzzz: Vec4
    get() = Vec4(y, z, z, z)
val Vec4.yzzw: Vec4
    get() = Vec4(y, z, z, w)
var Vec4.yzwx
    get() = Vec4(y, z, w, x)
    set(value) = put(value.y, value.z, value.w, value.x)
val Vec4.yzwy: Vec4
    get() = Vec4(y, z, w, y)
val Vec4.yzwz: Vec4
    get() = Vec4(y, z, w, z)
val Vec4.yzww: Vec4
    get() = Vec4(y, z, w, w)
val Vec4.ywxx: Vec4
    get() = Vec4(y, w, x, x)
val Vec4.ywxy: Vec4
    get() = Vec4(y, w, x, y)
var Vec4.ywxz: Vec4
    get() = Vec4(y, w, x, z)
    set(value) = put(value.y, value.w, value.x, value.z)
val Vec4.ywxw: Vec4
    get() = Vec4(y, w, x, w)
val Vec4.ywyx: Vec4
    get() = Vec4(y, w, y, x)
val Vec4.ywyy: Vec4
    get() = Vec4(y, w, y, y)
val Vec4.ywyz: Vec4
    get() = Vec4(y, w, y, z)
val Vec4.ywyw: Vec4
    get() = Vec4(y, w, y, w)
var Vec4.ywzx: Vec4
    get() = Vec4(y, w, z, x)
    set(value) = put(value.y, value.w, value.z, value.x)
val Vec4.ywzy: Vec4
    get() = Vec4(y, w, z, y)
val Vec4.ywzz: Vec4
    get() = Vec4(y, w, z, z)
val Vec4.ywzw: Vec4
    get() = Vec4(y, w, z, w)
val Vec4.ywwx: Vec4
    get() = Vec4(y, w, w, x)
val Vec4.ywwy: Vec4
    get() = Vec4(y, w, w, y)
val Vec4.ywwz: Vec4
    get() = Vec4(y, w, w, z)
val Vec4.ywww: Vec4
    get() = Vec4(y, w, w, w)
val Vec4.zxxx: Vec4
    get() = Vec4(z, x, x, x)
val Vec4.zxxy: Vec4
    get() = Vec4(z, x, x, y)
val Vec4.zxxz: Vec4
    get() = Vec4(z, x, x, z)
val Vec4.zxxw: Vec4
    get() = Vec4(z, x, x, w)
val Vec4.zxyx: Vec4
    get() = Vec4(z, x, y, x)
val Vec4.zxyy: Vec4
    get() = Vec4(z, x, y, y)
val Vec4.zxyz: Vec4
    get() = Vec4(z, x, y, z)
var Vec4.zxyw: Vec4
    get() = Vec4(z, x, y, w)
    set(value) = put(value.z, value.x, value.y, value.w)
val Vec4.zxzx: Vec4
    get() = Vec4(z, x, z, x)
val Vec4.zxzy: Vec4
    get() = Vec4(z, x, z, y)
val Vec4.zxzz: Vec4
    get() = Vec4(z, x, z, z)
val Vec4.zxzw: Vec4
    get() = Vec4(z, x, w, x)
val Vec4.zxwx: Vec4
    get() = Vec4(z, x, w, x)
var Vec4.zxwy: Vec4
    get() = Vec4(z, x, w, y)
    set(value) = put(value.z, value.x, value.w, value.y)
val Vec4.zxwz: Vec4
    get() = Vec4(z, x, w, y)
val Vec4.zxww: Vec4
    get() = Vec4(z, x, w, w)
val Vec4.zyxx: Vec4
    get() = Vec4(z, y, x, x)
val Vec4.zyxy: Vec4
    get() = Vec4(z, y, x, y)
val Vec4.zyxz: Vec4
    get() = Vec4(z, y, x, z)
var Vec4.zyxw: Vec4
    get() = Vec4(z, y, x, w)
    set(value) = put(value.z, value.y, value.x, value.w)
val Vec4.zyyx: Vec4
    get() = Vec4(z, y, y, x)
val Vec4.zyyy: Vec4
    get() = Vec4(z, y, y, y)
val Vec4.zyyz: Vec4
    get() = Vec4(z, y, y, z)
val Vec4.zyyw: Vec4
    get() = Vec4(z, y, y, w)
val Vec4.zyzx: Vec4
    get() = Vec4(z, y, z, x)
val Vec4.zyzy: Vec4
    get() = Vec4(z, y, z, y)
val Vec4.zyzz: Vec4
    get() = Vec4(z, y, z, z)
val Vec4.zyzw: Vec4
    get() = Vec4(z, y, z, w)
var Vec4.zywx: Vec4
    get() = Vec4(z, y, w, x)
    set(value) = put(value.z, value.y, value.w, value.x)
val Vec4.zywy: Vec4
    get() = Vec4(z, y, w, y)
val Vec4.zywz: Vec4
    get() = Vec4(z, y, w, z)
val Vec4.zyww: Vec4
    get() = Vec4(z, y, w, w)
val Vec4.zzxx: Vec4
    get() = Vec4(z, z, x, x)
val Vec4.zzxy: Vec4
    get() = Vec4(z, z, x, y)
val Vec4.zzxz: Vec4
    get() = Vec4(z, z, x, z)
val Vec4.zzxw: Vec4
    get() = Vec4(z, z, x, w)
val Vec4.zzyx: Vec4
    get() = Vec4(z, z, y, x)
val Vec4.zzyy: Vec4
    get() = Vec4(z, z, y, y)
val Vec4.zzyz: Vec4
    get() = Vec4(z, z, y, z)
val Vec4.zzyw: Vec4
    get() = Vec4(z, z, y, w)
val Vec4.zzzx: Vec4
    get() = Vec4(z, z, z, x)
val Vec4.zzzy: Vec4
    get() = Vec4(z, z, z, y)
val Vec4.zzzz: Vec4
    get() = Vec4(z, z, z, z)
val Vec4.zzzw: Vec4
    get() = Vec4(z, z, z, w)
val Vec4.zzwx: Vec4
    get() = Vec4(z, z, w, x)
val Vec4.zzwy: Vec4
    get() = Vec4(z, z, w, y)
val Vec4.zzwz: Vec4
    get() = Vec4(z, z, w, z)
val Vec4.zzww: Vec4
    get() = Vec4(z, z, w, w)
val Vec4.zwxx: Vec4
    get() = Vec4(z, w, x, x)
var Vec4.zwxy: Vec4
    get() = Vec4(z, w, x, y)
 set(value) = put(value.z, value.w, value.x, value.y)
val Vec4.zwxz: Vec4
    get() = Vec4(z, w, x, z)
val Vec4.zwxw: Vec4
    get() = Vec4(z, w, x, w)
var Vec4.zwyx: Vec4
 get() = Vec4(z, w, y, x)
 set(value) = put(value.z, value.w, value.y, value.x)
val Vec4.zwyy: Vec4
    get() = Vec4(z, w, y, y)
val Vec4.zwyz: Vec4
    get() = Vec4(z, w, y, z)
val Vec4.zwyw: Vec4
    get() = Vec4(z, w, y, w)
val Vec4.zwzx: Vec4
    get() = Vec4(z, w, z, x)
val Vec4.zwzy: Vec4
    get() = Vec4(z, w, z, y)
val Vec4.zwzz: Vec4
    get() = Vec4(z, w, z, z)
val Vec4.zwzw: Vec4
    get() = Vec4(z, w, z, w)
val Vec4.zwwx: Vec4
    get() = Vec4(z, w, w, y)
val Vec4.zwwy: Vec4
    get() = Vec4(z, w, w, y)
val Vec4.zwwz: Vec4
    get() = Vec4(z, w, w, z)
val Vec4.zwww: Vec4
    get() = Vec4(z, w, w, w)
val Vec4.wxxx: Vec4
    get() = Vec4(w, x, x, x)
val Vec4.wxxy: Vec4
    get() = Vec4(w, x, x, y)
val Vec4.wxxz: Vec4
    get() = Vec4(w, x, x, z)
val Vec4.wxxw: Vec4
    get() = Vec4(w, x, x, w)
val Vec4.wxyx: Vec4
    get() = Vec4(w, x, y, x)
val Vec4.wxyy: Vec4
    get() = Vec4(w, x, y, y)
var Vec4.wxyz: Vec4
 get() = Vec4(w, x, y, z)
 set(value) = put(value.w, value.x, value.y, value.z)
val Vec4.wxyw: Vec4
    get() = Vec4(w, x, y, w)
val Vec4.wxzx: Vec4
    get() = Vec4(w, x, z, x)
var Vec4.wxzy: Vec4
 get() = Vec4(w, x, z, y)
 set(value) = put(value.w, value.x, value.z, value.y)
val Vec4.wxzz: Vec4
    get() = Vec4(w, x, z, z)
val Vec4.wxzw: Vec4
    get() = Vec4(w, x, z, w)
val Vec4.wxwx: Vec4
    get() = Vec4(w, x, w, x)
val Vec4.wxwy: Vec4
    get() = Vec4(w, x, w, y)
val Vec4.wxwz: Vec4
    get() = Vec4(w, x, w, z)
val Vec4.wxww: Vec4
    get() = Vec4(w, x, w, w)
val Vec4.wyxx: Vec4
    get() = Vec4(w, y, x, x)
val Vec4.wyxy: Vec4
    get() = Vec4(w, y, x, y)
var Vec4.wyxz: Vec4
 get() = Vec4(w, y, x, z)
 set(value) = put(value.w, value.y, value.x, value.z)
val Vec4.wyxw: Vec4
    get() = Vec4(w, y, x, w)
val Vec4.wyyx: Vec4
    get() = Vec4(w, y, y, x)
val Vec4.wyyy: Vec4
    get() = Vec4(w, y, y, y)
val Vec4.wyyz: Vec4
    get() = Vec4(w, y, y, z)
val Vec4.wyyw: Vec4
    get() = Vec4(w, y, y, w)
var Vec4.wyzx: Vec4
 get() = Vec4(w, y, z, x)
 set(value) = put(value.w, value.y, value.z, value.x)
val Vec4.wyzy: Vec4
    get() = Vec4(w, y, z, y)
val Vec4.wyzz: Vec4
    get() = Vec4(w, y, z, z)
val Vec4.wyzw: Vec4
    get() = Vec4(w, y, z, w)
val Vec4.wywx: Vec4
    get() = Vec4(w, y, w, x)
val Vec4.wywy: Vec4
    get() = Vec4(w, y, w, y)
val Vec4.wywz: Vec4
    get() = Vec4(w, y, w, z)
val Vec4.wyww: Vec4
    get() = Vec4(w, y, w, w)
val Vec4.wzxx: Vec4
    get() = Vec4(w, z, x, x)
var Vec4.wzxy: Vec4
 get() = Vec4(w, z, x, y)
 set(value) = put(value.w, value.z, value.x, value.y)
val Vec4.wzxz: Vec4
    get() = Vec4(w, z, x, z)
val Vec4.wzxw: Vec4
    get() = Vec4(w, z, x, w)
var Vec4.wzyx: Vec4
 get() = Vec4(w, z, y, x)
 set(value) = put(value.w, value.z, value.y, value.x)
val Vec4.wzyy: Vec4
    get() = Vec4(w, z, y, y)
val Vec4.wzyz: Vec4
    get() = Vec4(w, z, y, z)
val Vec4.wzyw: Vec4
    get() = Vec4(w, z, y, w)
val Vec4.wzzx: Vec4
    get() = Vec4(w, z, z, x)
val Vec4.wzzy: Vec4
    get() = Vec4(w, z, z, y)
val Vec4.wzzz: Vec4
    get() = Vec4(w, z, z, z)
val Vec4.wzzw: Vec4
    get() = Vec4(w, z, z, w)
val Vec4.wzwx: Vec4
    get() = Vec4(w, z, w, x)
val Vec4.wzwy: Vec4
    get() = Vec4(w, z, w, y)
val Vec4.wzwz: Vec4
    get() = Vec4(w, z, w, z)
val Vec4.wzww: Vec4
    get() = Vec4(w, z, w, w)
val Vec4.wwxx: Vec4
    get() = Vec4(w, w, x, x)
val Vec4.wwxy: Vec4
    get() = Vec4(w, w, x, y)
val Vec4.wwxz: Vec4
    get() = Vec4(w, w, x, z)
val Vec4.wwxw: Vec4
    get() = Vec4(w, w, x, w)
val Vec4.wwyx: Vec4
    get() = Vec4(w, w, y, x)
val Vec4.wwyy: Vec4
    get() = Vec4(w, w, y, y)
val Vec4.wwyz: Vec4
    get() = Vec4(w, w, y, z)
val Vec4.wwyw: Vec4
    get() = Vec4(w, w, y, w)
val Vec4.wwzx: Vec4
    get() = Vec4(w, w, z, x)
val Vec4.wwzy: Vec4
    get() = Vec4(w, w, z, y)
val Vec4.wwzz: Vec4
    get() = Vec4(w, w, z, z)
val Vec4.wwzw: Vec4
    get() = Vec4(w, w, z, w)
val Vec4.wwwx: Vec4
    get() = Vec4(w, w, w, x)
val Vec4.wwwy: Vec4
    get() = Vec4(w, w, w, y)
val Vec4.wwwz: Vec4
    get() = Vec4(w, w, w, z)
val Vec4.wwww: Vec4
    get() = Vec4(w, w, w, w)