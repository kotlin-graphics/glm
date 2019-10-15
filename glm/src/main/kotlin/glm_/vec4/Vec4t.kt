@file:Suppress("UNCHECKED_CAST")

package glm_.vec4

import glm_.*
import glm_.vec2.Vec2bool
import glm_.vec2.Vec2t
import glm_.vec3.Vec3bool
import glm_.vec3.Vec3t
import java.nio.*

// TODO other
abstract class Vec4t<T : Number> : ToBuffer {

    abstract var x: T
    abstract var y: T
    abstract var z: T
    abstract var w: T

    operator fun component1() = x
    operator fun component2() = y
    operator fun component3() = z
    operator fun component4() = w

    operator fun get(index: Int) = when (index) {
        0 -> x
        1 -> y
        2 -> z
        3 -> w
        else -> throw IndexOutOfBoundsException()
    }

    abstract operator fun set(index: Int, value: Number)

    // -- infix Generic Constructors --

    abstract fun put(x: Number, y: Number, z: Number, w: Number)

    infix fun put(x: Number) = put(x, x, x, x)

    infix fun put(v: Vec2t<out Number>) = put(v.x, v.y, 0, 1)
    fun put(v: Vec2t<out Number>, z: Number) = put(v.x, v.y, z, 1)
    fun put(v: Vec2t<out Number>, z: Number, w: Number) = put(v.x, v.y, z, w)
    fun put(x: Number, y: Number, v: Vec2t<out Number>) = put(x, y, v.x, v.y)

    infix fun put(v: Vec3t<out Number>) = put(v.x, v.y, v.z, 1)
    fun put(v: Vec3t<out Number>, w: Number) = put(v.x, v.y, v.z, w)

    infix fun put(v: Vec4t<out Number>) = put(v.x, v.y, v.z, v.w)

    infix fun put(v: Vec2bool) = put(v.x.b, v.y.b, 0, 1)
    infix fun put(v: Vec3bool) = put(v.x.b, v.y.b, v.z.b, 1)
    infix fun put(v: Vec4bool) = put(v.x.b, v.y.b, v.z.b, v.w.b)

    infix fun put(bytes: ByteArray) = put(bytes, 0)
    infix fun put(chars: CharArray) = put(chars, 0)
    infix fun put(shorts: ShortArray) = put(shorts, 0)
    infix fun put(ints: IntArray) = put(ints, 0)
    infix fun put(longs: LongArray) = put(longs, 0)
    infix fun put(floats: FloatArray) = put(floats, 0)
    infix fun put(doubles: DoubleArray) = put(doubles, 0)
    infix fun put(booleans: BooleanArray) = put(booleans, 0)

    infix fun put(numbers: Array<out Number>) = put(numbers, 0)
    infix fun put(chars: Array<Char>) = put(chars, 0)
    infix fun put(a: Array<Boolean>) = put(a, 0)

    infix fun put(list: List<Any>) = put(list, 0)

    infix fun put(bytes: ByteBuffer) = put(bytes, 0)
    infix fun put(chars: CharBuffer) = put(chars, 0)
    infix fun put(shorts: ShortBuffer) = put(shorts, 0)
    infix fun put(ints: IntBuffer) = put(ints, 0)
    infix fun put(longs: LongBuffer) = put(longs, 0)
    infix fun put(floats: FloatBuffer) = put(floats, 0)
    infix fun put(doubles: DoubleBuffer) = put(doubles, 0)

    // -- indexed Generic Constructors --

    fun put(bytes: ByteArray, index: Int) = put(bytes[index], bytes[index + 1], bytes[index + 2], bytes[index + 2])
    fun put(chars: CharArray, index: Int) = put(chars[index].b, chars[index + 1].b, chars[index + 2].b, chars[index + 3].b)
    fun put(shorts: ShortArray, index: Int) = put(shorts[index], shorts[index + 1], shorts[index + 2], shorts[index + 3])
    fun put(ints: IntArray, index: Int) = put(ints[index], ints[index + 1], ints[index + 2], ints[index + 3])
    fun put(longs: LongArray, index: Int) = put(longs[index], longs[index + 1], longs[index + 2], longs[index + 3])
    fun put(floats: FloatArray, index: Int) = put(floats[index], floats[index + 1], floats[index + 2], floats[index + 3])
    fun put(doubles: DoubleArray, index: Int) = put(doubles[index], doubles[index + 1], doubles[index + 2], doubles[index + 3])
    fun put(booleans: BooleanArray, index: Int) = put(booleans[index].b, booleans[index + 1].b, booleans[index + 2].b, booleans[index + 3].b)

    fun put(floats: FloatArray, index: Int, w: Number) = put(floats[index], floats[index + 1], floats[index + 2], w) // TODO others

    fun put(a: Array<out Number>, index: Int) = put(a[index], a[index + 1], a[index + 2], a[index + 3])
    fun put(a: Array<Char>, index: Int) = put(a[index].b, a[index + 1].b, a[index + 2].b, a[index + 3].b)
    fun put(a: Array<Boolean>, index: Int) = put(a[index].b, a[index + 1].b, a[index + 2].b, a[index + 3].b)

    fun put(list: Iterable<*>, index: Int) {
        val a = list.elementAt(index)!!
        val b = list.elementAt(index + 1)!!
        val c = list.elementAt(index + 2)!!
        val d = list.elementAt(index + 3)!!
        when {
            a is Number && b is Number && c is Number && d is Number -> put(a, b, c, d)
            a is Char && b is Char && c is Char && d is Char -> put(a.b, b.b, c.b, d.b)
            a is Boolean && b is Boolean && c is Boolean && d is Boolean -> put(a.b, b.b, c.b, d.b)
            a is String && b is String && c is String && d is String ->
                when {
                    x is Byte && y is Byte && z is Byte && w is Byte -> put(a.b, b.b, c.b, d.b)
                    x is Short && y is Short && z is Short && w is Short -> put(a.s, b.s, c.s, d.s)
                    x is Int && y is Int && z is Int && w is Int -> put(a.i, b.i, c.i, d.i)
                    x is Long && y is Long && z is Long && w is Long -> put(a.L, b.L, c.L, d.L)
                    x is Float && y is Float && z is Float && w is Float -> put(a.f, b.f, c.f, d.f)
                    x is Double && y is Double && z is Double && w is Double -> put(a.d, b.d, c.d, d.d)
                    else -> throw ArithmeticException("incompatible type")  //TODO uns
                }
            else -> throw ArithmeticException("incompatible type")
        }
    }

    fun put(bytes: ByteBuffer, index: Int) = put(bytes[index], bytes[index + 1], bytes[index + 2], bytes[index + 3])
    fun put(chars: CharBuffer, index: Int) = put(chars[index].b, chars[index + 1].b, chars[index + 2].b, chars[index + 3].b)
    fun put(shorts: ShortBuffer, index: Int) = put(shorts[index], shorts[index + 1], shorts[index + 2], shorts[index + 3])
    fun put(ints: IntBuffer, index: Int) = put(ints[index], ints[index + 1], ints[index + 2], ints[index + 3])
    fun put(longs: LongBuffer, index: Int) = put(longs[index], longs[index + 1], longs[index + 2], longs[index + 3])
    fun put(floats: FloatBuffer, index: Int) = put(floats[index], floats[index + 1], floats[index + 2], floats[index + 3])
    fun put(doubles: DoubleBuffer, index: Int) = put(doubles[index], doubles[index + 1], doubles[index + 2], doubles[index + 3])


    // -- Same but with () --

    abstract operator fun invoke(x: Number, y: Number, z: Number, w: Number): Vec4t<out Number>

    infix operator fun invoke(v: Vec2t<out Number>) = invoke(v.x, v.y, 0, 1)
    operator fun invoke(v: Vec2t<out Number>, z: Number) = invoke(v.x, v.y, z, 1)
    operator fun invoke(v: Vec2t<out Number>, z: Number, w: Number) = invoke(v.x, v.y, z, w)
    operator fun invoke(x: Number, y: Number, v: Vec2t<out Number>) = invoke(x, y, v.x, v.y)

    infix operator fun invoke(v: Vec3t<out Number>) = invoke(v.x, v.y, v.z, 1)
    operator fun invoke(v: Vec3t<out Number>, w: Number) = invoke(v.x, v.y, v.z, w)

    infix operator fun invoke(v: Vec4t<out Number>) = invoke(v.x, v.y, v.z, v.w)

    infix operator fun invoke(v: Vec2bool) = invoke(v.x.b, v.y.b, 0, 1)
    infix operator fun invoke(v: Vec3bool) = invoke(v.x.b, v.y.b, v.z.b, 1)
    infix operator fun invoke(v: Vec4bool) = invoke(v.x.b, v.y.b, v.z.b, v.w.b)

    infix operator fun invoke(bytes: ByteArray) = invoke(bytes, 0)
    infix operator fun invoke(chars: CharArray) = invoke(chars, 0)
    infix operator fun invoke(shorts: ShortArray) = invoke(shorts, 0)
    infix operator fun invoke(ints: IntArray) = invoke(ints, 0)
    infix operator fun invoke(longs: LongArray) = invoke(longs, 0)
    infix operator fun invoke(floats: FloatArray) = invoke(floats, 0)
    infix operator fun invoke(doubles: DoubleArray) = invoke(doubles, 0)
    infix operator fun invoke(booleans: BooleanArray) = invoke(booleans, 0)

    infix operator fun invoke(numbers: Array<out Number>) = invoke(numbers, 0)
    infix operator fun invoke(chars: Array<Char>) = invoke(chars, 0)
    infix operator fun invoke(a: Array<Boolean>) = invoke(a, 0)

    infix operator fun invoke(list: List<Any>) = invoke(list, 0)

    infix operator fun invoke(bytes: ByteBuffer) = invoke(bytes, 0)
    infix operator fun invoke(chars: CharBuffer) = invoke(chars, 0)
    infix operator fun invoke(shorts: ShortBuffer) = invoke(shorts, 0)
    infix operator fun invoke(ints: IntBuffer) = invoke(ints, 0)
    infix operator fun invoke(longs: LongBuffer) = invoke(longs, 0)
    infix operator fun invoke(floats: FloatBuffer) = invoke(floats, 0)
    infix operator fun invoke(doubles: DoubleBuffer) = invoke(doubles, 0)

    infix operator fun invoke(s: Number) = invoke(s, s, s, s)

    // -- indexed Generic Constructors --

    operator fun invoke(bytes: ByteArray, index: Int) = invoke(bytes[index], bytes[index + 1], bytes[index + 2], bytes[index + 2])
    operator fun invoke(chars: CharArray, index: Int) = invoke(chars[index].b, chars[index + 1].b, chars[index + 2].b, chars[index + 3].b)
    operator fun invoke(shorts: ShortArray, index: Int) = invoke(shorts[index], shorts[index + 1], shorts[index + 2], shorts[index + 3])
    operator fun invoke(ints: IntArray, index: Int) = invoke(ints[index], ints[index + 1], ints[index + 2], ints[index + 3])
    operator fun invoke(longs: LongArray, index: Int) = invoke(longs[index], longs[index + 1], longs[index + 2], longs[index + 3])
    operator fun invoke(floats: FloatArray, index: Int) = invoke(floats[index], floats[index + 1], floats[index + 2], floats[index + 3])
    operator fun invoke(doubles: DoubleArray, index: Int) = invoke(doubles[index], doubles[index + 1], doubles[index + 2], doubles[index + 3])
    operator fun invoke(booleans: BooleanArray, index: Int) = invoke(booleans[index].b, booleans[index + 1].b, booleans[index + 2].b, booleans[index + 3].b)

    operator fun invoke(a: Array<out Number>, index: Int) = invoke(a[index], a[index + 1], a[index + 2], a[index + 3])
    operator fun invoke(a: Array<Char>, index: Int) = invoke(a[index].b, a[index + 1].b, a[index + 2].b, a[index + 3].b)
    operator fun invoke(a: Array<Boolean>, index: Int) = invoke(a[index].b, a[index + 1].b, a[index + 2].b, a[index + 3].b)

    operator fun invoke(list: Iterable<*>, index: Int) {
        val a = list.elementAt(index)!!
        val b = list.elementAt(index + 1)!!
        val c = list.elementAt(index + 2)!!
        val d = list.elementAt(index + 3)!!
        when {
            a is Number && b is Number && c is Number && d is Number -> invoke(a, b, c, d)
            a is Char && b is Char && c is Char && d is Char -> invoke(a.b, b.b, c.b, d.b)
            a is Boolean && b is Boolean && c is Boolean && d is Boolean -> invoke(a.b, b.b, c.b, d.b)
            a is String && b is String && c is String && d is String ->
                when {
                    x is Byte && y is Byte && z is Byte && w is Byte -> invoke(a.b, b.b, c.b, d.b)
                    x is Short && y is Short && z is Short && w is Short -> invoke(a.s, b.s, c.s, d.s)
                    x is Int && y is Int && z is Int && w is Int -> invoke(a.i, b.i, c.i, d.i)
                    x is Long && y is Long && z is Long && w is Long -> invoke(a.L, b.L, c.L, d.L)
                    x is Float && y is Float && z is Float && w is Float -> invoke(a.f, b.f, c.f, d.f)
                    x is Double && y is Double && z is Double && w is Double -> invoke(a.d, b.d, c.d, d.d)
                    else -> throw ArithmeticException("incompatible type")  //TODO uns
                }
            else -> throw ArithmeticException("incompatible type")
        }
    }

    operator fun invoke(bytes: ByteBuffer, index: Int) = invoke(bytes[index], bytes[index + 1], bytes[index + 2], bytes[index + 3])
    operator fun invoke(chars: CharBuffer, index: Int) = invoke(chars[index].b, chars[index + 1].b, chars[index + 2].b, chars[index + 3].b)
    operator fun invoke(shorts: ShortBuffer, index: Int) = invoke(shorts[index], shorts[index + 1], shorts[index + 2], shorts[index + 3])
    operator fun invoke(ints: IntBuffer, index: Int) = invoke(ints[index], ints[index + 1], ints[index + 2], ints[index + 3])
    operator fun invoke(longs: LongBuffer, index: Int) = invoke(longs[index], longs[index + 1], longs[index + 2], longs[index + 3])
    operator fun invoke(floats: FloatBuffer, index: Int) = invoke(floats[index], floats[index + 1], floats[index + 2], floats[index + 3])
    operator fun invoke(doubles: DoubleBuffer, index: Int) = invoke(doubles[index], doubles[index + 1], doubles[index + 2], doubles[index + 3])


    fun toByteArray(bigEndian: Boolean = true): ByteArray = to(ByteArray(length), 0, bigEndian)
    infix fun to(bytes: ByteArray): ByteArray = to(bytes, 0)
    fun to(bytes: ByteArray, bigEndian: Boolean): ByteArray = to(bytes, 0, bigEndian)
    abstract fun to(bytes: ByteArray, index: Int, bigEndian: Boolean = true): ByteArray


//    infix fun lessThan(b: Vec4t<out Number>) = glm.lessThan(this, b, Vec4bool())
//    fun lessThan(b: Vec4t<out Number>, res: Vec4bool = Vec4bool()) = glm.lessThan(this, b, res)
//
//    infix fun lessThanEqual(b: Vec4t<out Number>) = glm.lessThan(this, b, Vec4bool())
//    fun lessThanEqual(b: Vec4t<out Number>, res: Vec4bool = Vec4bool()) = glm.lessThan(this, b, res)
//
//    infix fun greaterThan(b: Vec4t<out Number>) = glm.greaterThan(this, b, Vec4bool())
//    fun greaterThan(b: Vec4t<out Number>, res: Vec4bool = Vec4bool()) = glm.greaterThan(this, b, res)
//
//    infix fun greaterThanEqual(b: Vec4t<out Number>) = glm.greaterThanEqual(this, b, Vec4bool())
//    fun greaterThanEqual(b: Vec4t<out Number>, res: Vec4bool = Vec4bool()) = glm.greaterThanEqual(this, b, res)
//
//    infix fun equal(b: Vec4t<out Number>) = glm.equal(this, b, Vec4bool())
//    fun equal(b: Vec4t<out Number>, res: Vec4bool = Vec4bool()) = glm.equal(this, b, res)
//
//    infix fun notEqual(b: Vec4t<out Number>) = glm.notEqual(this, b, Vec4bool())
//    fun notEqual(b: Vec4t<out Number>, res: Vec4bool = Vec4bool()) = glm.notEqual(this, b, res)
//
//    infix fun isEqual(b: Vec4t<out Number>) = glm.isEqual(this, b)

//    fun isEqual(b: Vec4t<out Number>, e: Float) = glm.isEqual(this, b,e)

    // components alias

    var r
        @JvmName("r") get() = x
        @JvmName("r") set(value) {
            x = value
        }
    var g
        @JvmName("g") get() = y
        @JvmName("g") set(value) {
            y = value
        }
    var b
        @JvmName("b") get() = z
        @JvmName("b") set(value) {
            z = value
        }
    var a
        @JvmName("a") get() = w
        @JvmName("a") set(value) {
            w = value
        }


    var s
        @JvmName("s") get() = x
        @JvmName("s") set(value) {
            x = value
        }
    var t
        @JvmName("t") get() = y
        @JvmName("t") set(value) {
            y = value
        }
    var p
        @JvmName("p") get() = z
        @JvmName("p") set(value) {
            z = value
        }
    var q
        @JvmName("q") get() = w
        @JvmName("q") set(value) {
            w = value
        }


    // swizzling
    protected abstract fun createInstance(x: T, y: T): Vec2t<out Number>

    protected abstract fun createInstance(x: T, y: T, z: T): Vec3t<out Number>
    protected abstract fun createInstance(x: T, y: T, z: T, w: T): Vec4t<out Number>

    val xx @JvmName("xx") get() = createInstance(x, x)
    var xy
        @JvmName("xy") get() = createInstance(x, y)
        @JvmName("xy") set(value) {
            x = value.x as T
            y = value.y as T
        }
    var xz
        @JvmName("xz") get() = createInstance(x, z)
        @JvmName("xz") set(value) {
            x = value.x as T
            z = value.y as T
        }
    var xw
        @JvmName("xw") get() = createInstance(x, w)
        @JvmName("xw") set(value) {
            x = value.x as T
            w = value.y as T
        }
    var yx
        @JvmName("yx") get() = createInstance(y, x)
        @JvmName("yx") set(value) {
            y = value.x as T
            x = value.y as T
        }
    val yy @JvmName("yy") get() = createInstance(y, y)
    var yz
        @JvmName("yz") get() = createInstance(y, z)
        @JvmName("yz") set(value) {
            y = value.x as T
            z = value.y as T
        }
    var yw
        @JvmName("yw") get() = createInstance(y, w)
        @JvmName("yw") set(value) {
            y = value.x as T
            w = value.y as T
        }
    var zx
        @JvmName("zx") get() = createInstance(z, x)
        @JvmName("zx") set(value) {
            z = value.x as T
            x = value.y as T
        }
    var zy
        @JvmName("zy") get() = createInstance(z, y)
        @JvmName("zy") set(value) {
            z = value.x as T
            y = value.y as T
        }
    val zz @JvmName("zz") get() = createInstance(z, z)
    var zw
        @JvmName("zw") get() = createInstance(z, w)
        @JvmName("zw") set(value) {
            z = value.x as T
            w = value.y as T
        }
    var wx
        @JvmName("wx") get() = createInstance(w, x)
        @JvmName("wx") set(value) {
            w = value.x as T
            x = value.y as T
        }
    var wy
        @JvmName("wy") get() = createInstance(w, y)
        @JvmName("wy") set(value) {
            w = value.x as T
            y = value.y as T
        }
    var wz
        @JvmName("wz") get() = createInstance(w, z)
        @JvmName("wz") set(value) {
            w = value.x as T
            z = value.y as T
        }
    val ww @JvmName("ww") get() = createInstance(w, w)


    val xxx @JvmName("xxx") get() = createInstance(x, x, x)
    val xxy @JvmName("xxy") get() = createInstance(x, x, y)
    val xxz @JvmName("xxz") get() = createInstance(x, x, z)
    val xxw @JvmName("xxw") get() = createInstance(x, x, w)
    val xyx @JvmName("xyx") get() = createInstance(x, y, x)
    val xyy @JvmName("xyy") get() = createInstance(x, y, y)
    var xyz
        @JvmName("xyz") get() = createInstance(x, y, z)
        @JvmName("xyz") set(value) {
            x = value.x as T
            y = value.y as T
            z = value.z as T
        }
    var xyw
        @JvmName("xyw") get() = createInstance(x, y, w)
        @JvmName("xyw") set(value) {
            x = value.x as T
            y = value.y as T
            w = value.z as T
        }
    val xzx @JvmName("xzx") get() = createInstance(x, z, x)
    var xzy
        @JvmName("xzy") get() = createInstance(x, z, y)
        @JvmName("xzy") set(value) {
            x = value.x as T
            z = value.y as T
            y = value.z as T
        }
    val xzz @JvmName("xzz") get() = createInstance(x, z, z)
    var xzw
        @JvmName("xzw") get() = createInstance(x, z, w)
        @JvmName("xzw") set(value) {
            x = value.x as T
            z = value.y as T
            w = value.z as T
        }
    val xwx @JvmName("xwx") get() = createInstance(x, w, x)
    var xwy
        @JvmName("xwy") get() = createInstance(x, w, y)
        @JvmName("xwy") set(value) {
            x = value.x as T
            w = value.y as T
            y = value.z as T
        }
    var xwz
        @JvmName("xwz") get() = createInstance(x, w, z)
        @JvmName("xwz") set(value) {
            x = value.x as T
            w = value.y as T
            z = value.z as T
        }
    val xww @JvmName("xww") get() = createInstance(x, w, w)
    val yxx @JvmName("yxx") get() = createInstance(y, x, x)
    val yxy @JvmName("yxy") get() = createInstance(y, x, y)
    var yxz
        @JvmName("yxz") get() = createInstance(y, x, z)
        @JvmName("yxz") set(value) {
            y = value.x as T
            x = value.y as T
            z = value.z as T
        }
    var yxw
        @JvmName("yxw") get() = createInstance(y, x, w)
        @JvmName("yxw") set(value) {
            y = value.x as T
            x = value.y as T
            w = value.z as T
        }
    val yyx @JvmName("yyx") get() = createInstance(y, y, x)
    val yyy @JvmName("yyy") get() = createInstance(y, y, y)
    val yyz @JvmName("yyz") get() = createInstance(y, y, z)
    val yyw @JvmName("yyw") get() = createInstance(y, y, w)
    var yzx
        @JvmName("yzx") get() = createInstance(y, z, x)
        @JvmName("yzx") set(value) {
            y = value.x as T
            z = value.y as T
            x = value.z as T
        }
    val yzy @JvmName("yzy") get() = createInstance(y, z, y)
    val yzz @JvmName("yzz") get() = createInstance(y, z, z)
    var yzw
        @JvmName("yzw") get() = createInstance(y, z, w)
        @JvmName("yzw") set(value) {
            y = value.x as T
            z = value.y as T
            w = value.z as T
        }
    val zxx @JvmName("zxx") get() = createInstance(z, x, x)
    var zxy
        @JvmName("zxy") get() = createInstance(z, x, y)
        @JvmName("zxy") set(value) {
            z = value.x as T
            x = value.y as T
            y = value.z as T
        }
    val zxz @JvmName("zxz") get() = createInstance(z, x, z)
    var zxw
        @JvmName("zxw") get() = createInstance(z, x, w)
        @JvmName("zxw") set(value) {
            z = value.x as T
            x = value.y as T
            w = value.z as T
        }
    var zyx
        @JvmName("zyx") get() = createInstance(z, y, x)
        @JvmName("zyx") set(value) {
            z = value.x as T
            y = value.y as T
            x = value.z as T
        }
    val zyy @JvmName("zyy") get() = createInstance(z, y, y)
    val zyz @JvmName("zyz") get() = createInstance(z, y, z)
    var zyw
        @JvmName("zyw") get() = createInstance(z, y, w)
        @JvmName("zyw") set(value) {
            z = value.x as T
            y = value.y as T
            w = value.z as T
        }
    val zzx @JvmName("zzx") get() = createInstance(z, z, x)
    val zzy @JvmName("zzy") get() = createInstance(z, z, y)
    val zzz @JvmName("zzz") get() = createInstance(z, z, z)
    val zzw @JvmName("zzw") get() = createInstance(z, z, w)
    val wxx @JvmName("wxx") get() = createInstance(w, x, x)
    var wxy
        @JvmName("wxy") get() = createInstance(w, x, y)
        @JvmName("wxy") set(value) {
            w = value.x as T
            x = value.y as T
            y = value.z as T
        }
    var wxz
        @JvmName("wxz") get() = createInstance(w, x, z)
        @JvmName("wxz") set(value) {
            w = value.x as T
            x = value.y as T
            z = value.z as T
        }
    val wxw @JvmName("wxw") get() = createInstance(w, x, w)
    var wyx
        @JvmName("wyx") get() = createInstance(w, y, x)
        @JvmName("wyx") set(value) {
            w = value.x as T
            y = value.y as T
            x = value.z as T
        }
    val wyy @JvmName("wyy") get() = createInstance(w, y, y)
    var wyz
        @JvmName("wyz") get() = createInstance(w, y, z)
        @JvmName("wyz") set(value) {
            w = value.x as T
            y = value.y as T
            z = value.z as T
        }
    val wyw @JvmName("wyw") get() = createInstance(w, y, w)
    var wzx
        @JvmName("wzx") get() = createInstance(w, z, x)
        @JvmName("wzx") set(value) {
            w = value.x as T
            z = value.y as T
            x = value.z as T
        }
    var wzy
        @JvmName("wzy") get() = createInstance(w, z, y)
        @JvmName("wzy") set(value) {
            w = value.x as T
            z = value.y as T
            y = value.z as T
        }
    val wzw @JvmName("wzw") get() = createInstance(w, z, w)
    val wwx @JvmName("wwx") get() = createInstance(w, w, x)
    val wwy @JvmName("wwy") get() = createInstance(w, w, y)
    val wwz @JvmName("wwz") get() = createInstance(w, w, z)
    val www @JvmName("www") get() = createInstance(w, w, w)

    val xxxx @JvmName("xxxx") get() = createInstance(x, x, x, x)
    val xxxy @JvmName("xxxy") get() = createInstance(x, x, x, y)
    val xxxz @JvmName("xxxz") get() = createInstance(x, x, x, z)
    val xxxw @JvmName("xxxw") get() = createInstance(x, x, x, w)
    val xxyx @JvmName("xxyx") get() = createInstance(x, x, y, x)
    val xxyy @JvmName("xxyy") get() = createInstance(x, x, y, y)
    val xxyz @JvmName("xxyz") get() = createInstance(x, x, y, z)
    val xxyw @JvmName("xxyw") get() = createInstance(x, x, y, w)
    val xxzx @JvmName("xxzx") get() = createInstance(x, x, z, x)
    val xxzy @JvmName("xxzy") get() = createInstance(x, x, z, y)
    val xxzz @JvmName("xxzz") get() = createInstance(x, x, z, z)
    val xxzw @JvmName("xxzw") get() = createInstance(x, x, z, w)
    val xxwx @JvmName("xxwx") get() = createInstance(x, x, w, x)
    val xxwy @JvmName("xxwy") get() = createInstance(x, x, w, y)
    val xxwz @JvmName("xxwz") get() = createInstance(x, x, w, z)
    val xxww @JvmName("xxww") get() = createInstance(x, x, w, w)
    val xyxx @JvmName("xyxx") get() = createInstance(x, y, x, x)
    val xyxy @JvmName("xyxy") get() = createInstance(x, y, x, y)
    val xyxz @JvmName("xyxz") get() = createInstance(x, y, x, z)
    val xyxw @JvmName("xyxw") get() = createInstance(x, y, x, w)
    val xyyx @JvmName("xyyx") get() = createInstance(x, y, y, x)
    val xyyy @JvmName("xyyy") get() = createInstance(x, y, y, y)
    val xyyz @JvmName("xyyz") get() = createInstance(x, y, y, w)
    val xyyw @JvmName("xyyw") get() = createInstance(x, y, y, w)
    val xyzx @JvmName("xyzx") get() = createInstance(x, y, z, x)
    val xyzy @JvmName("xyzy") get() = createInstance(x, y, z, y)
    val xyzz @JvmName("xyzz") get() = createInstance(x, y, z, z)
    var xyzw
        @JvmName("xyzw") get() = createInstance(x, y, z, w)
        @JvmName("xyzw") set(value) = put(value.x, value.y, value.z, value.w)
    val xywx @JvmName("xywx") get() = createInstance(x, y, w, x)
    val xywy @JvmName("xywy") get() = createInstance(x, y, w, y)
    var xywz
        @JvmName("xywz") get() = createInstance(x, y, w, z)
        @JvmName("xywz") set(value) = put(value.x, value.y, value.w, value.z)
    val xyww @JvmName("xyww") get() = createInstance(x, y, w, w)
    val xzxx @JvmName("xzxx") get() = createInstance(x, z, x, x)
    val xzxy @JvmName("xzxy") get() = createInstance(x, z, x, y)
    val xzxz @JvmName("xzxz") get() = createInstance(x, z, x, z)
    val xzxw @JvmName("xzxw") get() = createInstance(x, z, x, w)
    val xzyx @JvmName("xzyx") get() = createInstance(x, z, y, x)
    val xzyy @JvmName("xzyy") get() = createInstance(x, z, y, y)
    val xzyz @JvmName("xzyz") get() = createInstance(x, z, y, z)
    var xzyw
        @JvmName("xzyw") get() = createInstance(x, z, y, w)
        @JvmName("xzyw") set(value) = put(value.x, value.z, value.y, value.w)
    val xzzx @JvmName("xzzx") get() = createInstance(x, z, z, x)
    val xzzy @JvmName("xzzy") get() = createInstance(x, z, z, y)
    val xzzz @JvmName("xzzz") get() = createInstance(x, z, z, z)
    val xzzw @JvmName("xzzw") get() = createInstance(x, z, z, w)
    val xzwx @JvmName("xzwx") get() = createInstance(x, z, w, x)
    var xzwy
        @JvmName("xzwy") get() = createInstance(x, z, w, y)
        @JvmName("xzwy") set(value) = put(value.x, value.z, value.w, value.y)
    val xzwz @JvmName("xzwz") get() = createInstance(x, z, w, z)
    val xzww @JvmName("xzww") get() = createInstance(x, z, w, w)
    val xwxx @JvmName("xwxx") get() = createInstance(x, w, x, x)
    val xwxy @JvmName("xwxy") get() = createInstance(x, w, x, y)
    val xwxz @JvmName("xwxz") get() = createInstance(x, w, x, z)
    val xwxw @JvmName("xwxw") get() = createInstance(x, w, x, w)
    val xwyx @JvmName("xwyx") get() = createInstance(x, w, y, x)
    val xwyy @JvmName("xwyy") get() = createInstance(x, w, y, y)
    var xwyz
        @JvmName("xwyz") get() = createInstance(x, w, y, z)
        @JvmName("xwyz") set(value) = put(value.x, value.w, value.y, value.z)
    val xwyw @JvmName("xwyw") get() = createInstance(x, w, y, w)
    val xwzx @JvmName("xwzx") get() = createInstance(x, w, z, x)
    var xwzy
        @JvmName("xwzy") get() = createInstance(x, w, z, y)
        @JvmName("xwzy") set(value) = put(value.x, value.w, value.z, value.y)
    val xwzz @JvmName("xwzz") get() = createInstance(x, w, z, z)
    val xwzw @JvmName("xwzw") get() = createInstance(x, w, z, w)
    val xwwx @JvmName("xwwx") get() = createInstance(x, w, w, x)
    val xwwy @JvmName("xwwy") get() = createInstance(x, w, w, y)
    val xwwz @JvmName("xwwz") get() = createInstance(x, w, w, z)
    val xwww @JvmName("xwww") get() = createInstance(x, w, w, w)
    val yxxx @JvmName("yxxx") get() = createInstance(y, x, x, x)
    val yxxy @JvmName("yxxy") get() = createInstance(y, x, x, y)
    val yxxz @JvmName("yxxz") get() = createInstance(y, x, x, z)
    val yxxw @JvmName("yxxw") get() = createInstance(y, x, x, w)
    val yxyx @JvmName("yxyx") get() = createInstance(y, x, y, x)
    val yxyy @JvmName("yxyy") get() = createInstance(y, x, y, y)
    val yxyz @JvmName("yxyz") get() = createInstance(y, x, y, z)
    val yxyw @JvmName("yxyw") get() = createInstance(y, x, y, w)
    val yxzx @JvmName("yxzx") get() = createInstance(y, x, z, x)
    val yxzy @JvmName("yxzy") get() = createInstance(y, x, z, y)
    val yxzz @JvmName("yxzz") get() = createInstance(y, x, z, z)
    var yxzw
        @JvmName("yxzw") get() = createInstance(y, x, z, w)
        @JvmName("yxzw") set(value) = put(value.y, value.x, value.z, value.w)
    val yxwx @JvmName("yxwx") get() = createInstance(y, x, w, x)
    val yxwy @JvmName("yxwy") get() = createInstance(y, x, w, y)
    var yxwz
        @JvmName("yxwz") get() = createInstance(y, x, w, z)
        @JvmName("yxwz") set(value) = put(value.y, value.x, value.w, value.z)
    val yxww @JvmName("yxww") get() = createInstance(y, x, w, w)
    val yyxx @JvmName("yyxx") get() = createInstance(y, y, x, x)
    val yyxy @JvmName("yyxy") get() = createInstance(y, y, x, y)
    val yyxz @JvmName("yyxz") get() = createInstance(y, y, x, z)
    val yyxw @JvmName("yyxw") get() = createInstance(y, y, x, w)
    val yyyx @JvmName("yyyx") get() = createInstance(y, y, y, x)
    val yyyy @JvmName("yyyy") get() = createInstance(y, y, y, y)
    val yyyz @JvmName("yyyz") get() = createInstance(y, y, y, z)
    val yyyw @JvmName("yyyw") get() = createInstance(y, y, y, w)
    val yyzx @JvmName("yyzx") get() = createInstance(y, y, z, x)
    val yyzy @JvmName("yyzy") get() = createInstance(y, y, z, y)
    val yyzz @JvmName("yyzz") get() = createInstance(y, y, z, z)
    val yyzw @JvmName("yyzw") get() = createInstance(y, y, z, w)
    val yywx @JvmName("yywx") get() = createInstance(y, y, w, x)
    val yywy @JvmName("yywy") get() = createInstance(y, y, w, y)
    val yywz @JvmName("yywz") get() = createInstance(y, y, w, z)
    val yyww @JvmName("yyww") get() = createInstance(y, y, w, w)
    val yzxx @JvmName("yzxx") get() = createInstance(y, z, x, x)
    val yzxy @JvmName("yzxy") get() = createInstance(y, z, x, z)
    val yzxz @JvmName("yzxz") get() = createInstance(y, z, x, z)
    var yzxw
        @JvmName("yzxw") get() = createInstance(y, z, x, w)
        @JvmName("yzxw") set(value) = put(value.y, value.z, value.x, value.w)
    val yzyx @JvmName("yzyx") get() = createInstance(y, z, y, x)
    val yzyy @JvmName("yzyy") get() = createInstance(y, z, y, y)
    val yzyz @JvmName("yzyz") get() = createInstance(y, z, y, z)
    val yzyw @JvmName("yzyw") get() = createInstance(y, z, y, w)
    val yzzx @JvmName("yzzx") get() = createInstance(y, z, z, x)
    val yzzy @JvmName("yzzy") get() = createInstance(y, z, z, y)
    val yzzz @JvmName("yzzz") get() = createInstance(y, z, z, z)
    val yzzw @JvmName("yzzw") get() = createInstance(y, z, z, w)
    var yzwx
        @JvmName("yzwx") get() = createInstance(y, z, w, x)
        @JvmName("yzwx") set(value) = put(value.y, value.z, value.w, value.x)
    val yzwy @JvmName("yzwy") get() = createInstance(y, z, w, y)
    val yzwz @JvmName("yzwz") get() = createInstance(y, z, w, z)
    val yzww @JvmName("yzww") get() = createInstance(y, z, w, w)
    val ywxx @JvmName("ywxx") get() = createInstance(y, w, x, x)
    val ywxy @JvmName("ywxy") get() = createInstance(y, w, x, y)
    var ywxz
        @JvmName("ywxz") get() = createInstance(y, w, x, z)
        @JvmName("ywxz") set(value) = put(value.y, value.w, value.x, value.z)
    val ywxw @JvmName("ywxw") get() = createInstance(y, w, x, w)
    val ywyx @JvmName("ywyx") get() = createInstance(y, w, y, x)
    val ywyy @JvmName("ywyy") get() = createInstance(y, w, y, y)
    val ywyz @JvmName("ywyz") get() = createInstance(y, w, y, z)
    val ywyw @JvmName("ywyw") get() = createInstance(y, w, y, w)
    var ywzx
        @JvmName("ywzx") get() = createInstance(y, w, z, x)
        @JvmName("ywzx") set(value) = put(value.y, value.w, value.z, value.x)
    val ywzy @JvmName("ywzy") get() = createInstance(y, w, z, y)
    val ywzz @JvmName("ywzz") get() = createInstance(y, w, z, z)
    val ywzw @JvmName("ywzw") get() = createInstance(y, w, z, w)
    val ywwx @JvmName("ywwx") get() = createInstance(y, w, w, x)
    val ywwy @JvmName("ywwy") get() = createInstance(y, w, w, y)
    val ywwz @JvmName("ywwz") get() = createInstance(y, w, w, z)
    val ywww @JvmName("ywww") get() = createInstance(y, w, w, w)
    val zxxx @JvmName("zxxx") get() = createInstance(z, x, x, x)
    val zxxy @JvmName("zxxy") get() = createInstance(z, x, x, y)
    val zxxz @JvmName("zxxz") get() = createInstance(z, x, x, z)
    val zxxw @JvmName("zxxw") get() = createInstance(z, x, x, w)
    val zxyx @JvmName("zxyx") get() = createInstance(z, x, y, x)
    val zxyy @JvmName("zxyy") get() = createInstance(z, x, y, y)
    val zxyz @JvmName("zxyz") get() = createInstance(z, x, y, z)
    var zxyw
        @JvmName("zxyw") get() = createInstance(z, x, y, w)
        @JvmName("zxyw") set(value) = put(value.z, value.x, value.y, value.w)
    val zxzx @JvmName("zxzx") get() = createInstance(z, x, z, x)
    val zxzy @JvmName("zxzy") get() = createInstance(z, x, z, y)
    val zxzz @JvmName("zxzz") get() = createInstance(z, x, z, z)
    val zxzw @JvmName("zxzw") get() = createInstance(z, x, w, x)
    val zxwx @JvmName("zxwx") get() = createInstance(z, x, w, x)
    var zxwy
        @JvmName("zxwy") get() = createInstance(z, x, w, y)
        @JvmName("zxwy") set(value) = put(value.z, value.x, value.w, value.y)
    val zxwz @JvmName("zxwz") get() = createInstance(z, x, w, y)
    val zxww @JvmName("zxww") get() = createInstance(z, x, w, w)
    val zyxx @JvmName("zyxx") get() = createInstance(z, y, x, x)
    val zyxy @JvmName("zyxy") get() = createInstance(z, y, x, y)
    val zyxz @JvmName("zyxz") get() = createInstance(z, y, x, z)
    var zyxw
        @JvmName("zyxw") get() = createInstance(z, y, x, w)
        @JvmName("zyxw") set(value) = put(value.z, value.y, value.x, value.w)
    val zyyx @JvmName("zyyx") get() = createInstance(z, y, y, x)
    val zyyy @JvmName("zyyy") get() = createInstance(z, y, y, y)
    val zyyz @JvmName("zyyz") get() = createInstance(z, y, y, z)
    val zyyw @JvmName("zyyw") get() = createInstance(z, y, y, w)
    val zyzx @JvmName("zyzx") get() = createInstance(z, y, z, x)
    val zyzy @JvmName("zyzy") get() = createInstance(z, y, z, y)
    val zyzz @JvmName("zyzz") get() = createInstance(z, y, z, z)
    val zyzw @JvmName("zyzw") get() = createInstance(z, y, z, w)
    var zywx
        @JvmName("zywx") get() = createInstance(z, y, w, x)
        @JvmName("zywx") set(value) = put(value.z, value.y, value.w, value.x)
    val zywy @JvmName("zywy") get() = createInstance(z, y, w, y)
    val zywz @JvmName("zywz") get() = createInstance(z, y, w, z)
    val zyww @JvmName("zyww") get() = createInstance(z, y, w, w)
    val zzxx @JvmName("zzxx") get() = createInstance(z, z, x, x)
    val zzxy @JvmName("zzxy") get() = createInstance(z, z, x, y)
    val zzxz @JvmName("zzxz") get() = createInstance(z, z, x, z)
    val zzxw @JvmName("zzxw") get() = createInstance(z, z, x, w)
    val zzyx @JvmName("zzyx") get() = createInstance(z, z, y, x)
    val zzyy @JvmName("zzyy") get() = createInstance(z, z, y, y)
    val zzyz @JvmName("zzyz") get() = createInstance(z, z, y, z)
    val zzyw @JvmName("zzyw") get() = createInstance(z, z, y, w)
    val zzzx @JvmName("zzzx") get() = createInstance(z, z, z, x)
    val zzzy @JvmName("zzzy") get() = createInstance(z, z, z, y)
    val zzzz @JvmName("zzzz") get() = createInstance(z, z, z, z)
    val zzzw @JvmName("zzzw") get() = createInstance(z, z, z, w)
    val zzwx @JvmName("zzwx") get() = createInstance(z, z, w, x)
    val zzwy @JvmName("zzwy") get() = createInstance(z, z, w, y)
    val zzwz @JvmName("zzwz") get() = createInstance(z, z, w, z)
    val zzww @JvmName("zzww") get() = createInstance(z, z, w, w)
    val zwxx @JvmName("zwxx") get() = createInstance(z, w, x, x)
    var zwxy
        @JvmName("zwxy") get() = createInstance(z, w, x, y)
        @JvmName("zwxy") set(value) = put(value.z, value.w, value.x, value.y)
    val zwxz @JvmName("zwxz") get() = createInstance(z, w, x, z)
    val zwxw @JvmName("zwxw") get() = createInstance(z, w, x, w)
    var zwyx
        @JvmName("zwyx") get() = createInstance(z, w, y, x)
        @JvmName("zwyx") set(value) = put(value.z, value.w, value.y, value.x)
    val zwyy @JvmName("zwyy") get() = createInstance(z, w, y, y)
    val zwyz @JvmName("zwyz") get() = createInstance(z, w, y, z)
    val zwyw @JvmName("zwyw") get() = createInstance(z, w, y, w)
    val zwzx @JvmName("zwzx") get() = createInstance(z, w, z, x)
    val zwzy @JvmName("zwzy") get() = createInstance(z, w, z, y)
    val zwzz @JvmName("zwzz") get() = createInstance(z, w, z, z)
    val zwzw @JvmName("zwzw") get() = createInstance(z, w, z, w)
    val zwwx @JvmName("zwwx") get() = createInstance(z, w, w, y)
    val zwwy @JvmName("zwwy") get() = createInstance(z, w, w, y)
    val zwwz @JvmName("zwwz") get() = createInstance(z, w, w, z)
    val zwww @JvmName("zwww") get() = createInstance(z, w, w, w)
    val wxxx @JvmName("wxxx") get() = createInstance(w, x, x, x)
    val wxxy @JvmName("wxxy") get() = createInstance(w, x, x, y)
    val wxxz @JvmName("wxxz") get() = createInstance(w, x, x, z)
    val wxxw @JvmName("wxxw") get() = createInstance(w, x, x, w)
    val wxyx @JvmName("wxyx") get() = createInstance(w, x, y, x)
    val wxyy @JvmName("wxyy") get() = createInstance(w, x, y, y)
    var wxyz
        @JvmName("wxyz") get() = createInstance(w, x, y, z)
        @JvmName("wxyz") set(value) = put(value.w, value.x, value.y, value.z)
    val wxyw @JvmName("wxyw") get() = createInstance(w, x, y, w)
    val wxzx @JvmName("wxzx") get() = createInstance(w, x, z, x)
    var wxzy
        @JvmName("wxzy") get() = createInstance(w, x, z, y)
        @JvmName("wxzy") set(value) = put(value.w, value.x, value.z, value.y)
    val wxzz @JvmName("wxzz") get() = createInstance(w, x, z, z)
    val wxzw @JvmName("wxzw") get() = createInstance(w, x, z, w)
    val wxwx @JvmName("wxwx") get() = createInstance(w, x, w, x)
    val wxwy @JvmName("wxwy") get() = createInstance(w, x, w, y)
    val wxwz @JvmName("wxwz") get() = createInstance(w, x, w, z)
    val wxww @JvmName("wxww") get() = createInstance(w, x, w, w)
    val wyxx @JvmName("wyxx") get() = createInstance(w, y, x, x)
    val wyxy @JvmName("wyxy") get() = createInstance(w, y, x, y)
    var wyxz
        @JvmName("wyxz") get() = createInstance(w, y, x, z)
        @JvmName("wyxz") set(value) = put(value.w, value.y, value.x, value.z)
    val wyxw @JvmName("wyxw") get() = createInstance(w, y, x, w)
    val wyyx @JvmName("wyyx") get() = createInstance(w, y, y, x)
    val wyyy @JvmName("wyyy") get() = createInstance(w, y, y, y)
    val wyyz @JvmName("wyyz") get() = createInstance(w, y, y, z)
    val wyyw @JvmName("wyyw") get() = createInstance(w, y, y, w)
    var wyzx
        @JvmName("wyzx") get() = createInstance(w, y, z, x)
        @JvmName("wyzx") set(value) = put(value.w, value.y, value.z, value.x)
    val wyzy @JvmName("wyzy") get() = createInstance(w, y, z, y)
    val wyzz @JvmName("wyzz") get() = createInstance(w, y, z, z)
    val wyzw @JvmName("wyzw") get() = createInstance(w, y, z, w)
    val wywx @JvmName("wywx") get() = createInstance(w, y, w, x)
    val wywy @JvmName("wywy") get() = createInstance(w, y, w, y)
    val wywz @JvmName("wywz") get() = createInstance(w, y, w, z)
    val wyww @JvmName("wyww") get() = createInstance(w, y, w, w)
    val wzxx @JvmName("wzxx") get() = createInstance(w, z, x, x)
    var wzxy
        @JvmName("wzxy") get() = createInstance(w, z, x, y)
        @JvmName("wzxy") set(value) = put(value.w, value.z, value.x, value.y)
    val wzxz @JvmName("wzxz") get() = createInstance(w, z, x, z)
    val wzxw @JvmName("wzxw") get() = createInstance(w, z, x, w)
    var wzyx
        @JvmName("wzyx") get() = createInstance(w, z, y, x)
        @JvmName("wzyx") set(value) = put(value.w, value.z, value.y, value.x)
    val wzyy @JvmName("wzyy") get() = createInstance(w, z, y, y)
    val wzyz @JvmName("wzyz") get() = createInstance(w, z, y, z)
    val wzyw @JvmName("wzyw") get() = createInstance(w, z, y, w)
    val wzzx @JvmName("wzzx") get() = createInstance(w, z, z, x)
    val wzzy @JvmName("wzzy") get() = createInstance(w, z, z, y)
    val wzzz @JvmName("wzzz") get() = createInstance(w, z, z, z)
    val wzzw @JvmName("wzzw") get() = createInstance(w, z, z, w)
    val wzwx @JvmName("wzwx") get() = createInstance(w, z, w, x)
    val wzwy @JvmName("wzwy") get() = createInstance(w, z, w, y)
    val wzwz @JvmName("wzwz") get() = createInstance(w, z, w, z)
    val wzww @JvmName("wzww") get() = createInstance(w, z, w, w)
    val wwxx @JvmName("wwxx") get() = createInstance(w, w, x, x)
    val wwxy @JvmName("wwxy") get() = createInstance(w, w, x, y)
    val wwxz @JvmName("wwxz") get() = createInstance(w, w, x, z)
    val wwxw @JvmName("wwxw") get() = createInstance(w, w, x, w)
    val wwyx @JvmName("wwyx") get() = createInstance(w, w, y, x)
    val wwyy @JvmName("wwyy") get() = createInstance(w, w, y, y)
    val wwyz @JvmName("wwyz") get() = createInstance(w, w, y, z)
    val wwyw @JvmName("wwyw") get() = createInstance(w, w, y, w)
    val wwzx @JvmName("wwzx") get() = createInstance(w, w, z, x)
    val wwzy @JvmName("wwzy") get() = createInstance(w, w, z, y)
    val wwzz @JvmName("wwzz") get() = createInstance(w, w, z, z)
    val wwzw @JvmName("wwzw") get() = createInstance(w, w, z, w)
    val wwwx @JvmName("wwwx") get() = createInstance(w, w, w, x)
    val wwwy @JvmName("wwwy") get() = createInstance(w, w, w, y)
    val wwwz @JvmName("wwwz") get() = createInstance(w, w, w, z)
    val wwww @JvmName("wwww") get() = createInstance(w, w, w, w)

    companion object {
        const val length = 4
    }

    override fun toString(): String = "($x, $y, $z, $w)"
}