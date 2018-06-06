@file:Suppress("UNCHECKED_CAST")

package glm_.vec3

import glm_.*
import glm_.buffer.bufferBig
import glm_.vec2.*
import glm_.vec4.Vec4bool
import glm_.vec4.Vec4t
import java.nio.*

abstract class Vec3t<T : Number> {

    abstract var x: T
    abstract var y: T
    abstract var z: T

    operator fun component1() = x
    operator fun component2() = y
    operator fun component3() = z


    // -- Component accesses --

    operator fun get(index: Int) = when (index) {
        0 -> x
        1 -> y
        2 -> z
        else -> throw IndexOutOfBoundsException()
    }

    abstract operator fun set(index: Int, value: Number)

    abstract fun size(): Int

    // -- infix Generic Constructors --

    abstract fun put(x: Number, y: Number, z: Number)

    infix fun put(x: Number) = put(x, x, x)

    infix fun put(v: Vec2t<out Number>) = put(v.x, v.y, 0)
    infix fun put(v: Vec3t<out Number>) = put(v.x, v.y, v.z)
    infix fun put(v: Vec4t<out Number>) = put(v.x, v.y, v.z)

    infix fun put(v: Vec2bool) = put(v.x.b, v.y.b, 0)
    infix fun put(v: Vec3bool) = put(v.x.b, v.y.b, v.z.b)
    infix fun put(v: Vec4bool) = put(v.x.b, v.y.b, v.z.b)

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

    fun put(bytes: ByteArray, index: Int) = put(bytes[index], bytes[index + 1], bytes[index + 2])
    fun put(chars: CharArray, index: Int) = put(chars[index].b, chars[index + 1].b, chars[index + 2].b)
    fun put(shorts: ShortArray, index: Int) = put(shorts[index], shorts[index + 1], shorts[index + 2])
    fun put(ints: IntArray, index: Int) = put(ints[index], ints[index + 1], ints[index + 2])
    fun put(longs: LongArray, index: Int) = put(longs[index], longs[index + 1], longs[index + 2])
    fun put(floats: FloatArray, index: Int) = put(floats[index], floats[index + 1], floats[index + 2])
    fun put(doubles: DoubleArray, index: Int) = put(doubles[index], doubles[index + 1], doubles[index + 2])
    fun put(booleans: BooleanArray, index: Int) = put(booleans[index].b, booleans[index + 1].b, booleans[index + 2].b)

    fun put(a: Array<out Number>, index: Int) = put(a[index], a[index + 1], a[index + 2])
    fun put(a: Array<Char>, index: Int) = put(a[index].b, a[index + 1].b, a[index + 2].b)
    fun put(a: Array<Boolean>, index: Int) = put(a[index].b, a[index + 1].b, a[index + 2].b)

    fun put(list: Iterable<*>, index: Int) {
        val a = list.elementAt(index)!!
        val b = list.elementAt(index + 1)!!
        val c = list.elementAt(index + 2)!!
        when {
            a is Number && b is Number && c is Number -> put(a, b, c)
            a is Char && b is Char && c is Char -> put(a.b, b.b, c.b)
            a is Boolean && b is Boolean && c is Boolean -> put(a.b, b.b, c.b)
            a is String && b is String && c is String ->
                when {
                    x is Byte && y is Byte && z is Byte -> put(a.b, b.b, c.b)
                    x is Short && y is Short && z is Short -> put(a.s, b.s, c.s)
                    x is Int && y is Int && z is Int -> put(a.i, b.i, c.i)
                    x is Long && y is Long && z is Long -> put(a.L, b.L, c.L)
                    x is Float && y is Float && z is Float -> put(a.f, b.f, c.f)
                    x is Double && y is Double && z is Double -> put(a.d, b.d, c.d)
                    else -> throw ArithmeticException("incompatible type")  //TODO uns
                }
            else -> throw ArithmeticException("incompatible type")
        }
    }

    fun put(bytes: ByteBuffer, index: Int) = put(bytes[index], bytes[index + 1], bytes[index + 2])
    fun put(chars: CharBuffer, index: Int) = put(chars[index].b, chars[index + 1].b, chars[index + 2].b)
    fun put(shorts: ShortBuffer, index: Int) = put(shorts[index], shorts[index + 1], shorts[index + 2])
    fun put(ints: IntBuffer, index: Int) = put(ints[index], ints[index + 1], ints[index + 2])
    fun put(longs: LongBuffer, index: Int) = put(longs[index], longs[index + 1], longs[index + 2])
    fun put(floats: FloatBuffer, index: Int) = put(floats[index], floats[index + 1], floats[index + 2])
    fun put(doubles: DoubleBuffer, index: Int) = put(doubles[index], doubles[index + 1], doubles[index + 2])


    // -- Same, but with () operator --

    abstract operator fun invoke(x: Number, y: Number, z: Number): Vec3t<out Number>

    infix operator fun invoke(v: Vec2t<out Number>) = invoke(v.x, v.y, 0)
    infix operator fun invoke(v: Vec3t<out Number>) = invoke(v.x, v.y, v.z)
    infix operator fun invoke(v: Vec4t<out Number>) = invoke(v.x, v.y, v.z)

    infix operator fun invoke(v: Vec2bool) = invoke(v.x.b, v.y.b, 0)
    infix operator fun invoke(v: Vec3bool) = invoke(v.x.b, v.y.b, v.z.b)
    infix operator fun invoke(v: Vec4bool) = invoke(v.x.b, v.y.b, v.z.b)

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

    open infix operator fun invoke(s: Number) = invoke(s, s, s)

    // -- indexed Generic Constructors --

    operator fun invoke(bytes: ByteArray, index: Int) = invoke(bytes[index], bytes[index + 1], bytes[index + 2])
    operator fun invoke(chars: CharArray, index: Int) = invoke(chars[index].b, chars[index + 1].b, chars[index + 2].b)
    operator fun invoke(shorts: ShortArray, index: Int) = invoke(shorts[index], shorts[index + 1], shorts[index + 2])
    operator fun invoke(ints: IntArray, index: Int) = invoke(ints[index], ints[index + 1], ints[index + 2])
    operator fun invoke(longs: LongArray, index: Int) = invoke(longs[index], longs[index + 1], longs[index + 2])
    operator fun invoke(floats: FloatArray, index: Int) = invoke(floats[index], floats[index + 1], floats[index + 2])
    operator fun invoke(doubles: DoubleArray, index: Int) = invoke(doubles[index], doubles[index + 1], doubles[index + 2])
    operator fun invoke(booleans: BooleanArray, index: Int) = invoke(booleans[index].b, booleans[index + 1].b, booleans[index + 2].b)

    operator fun invoke(a: Array<out Number>, index: Int) = invoke(a[index], a[index + 1], a[index + 2])
    operator fun invoke(a: Array<Char>, index: Int) = invoke(a[index].b, a[index + 1].b, a[index + 2].b)
    operator fun invoke(a: Array<Boolean>, index: Int) = invoke(a[index].b, a[index + 1].b, a[index + 2].b)

    operator fun invoke(list: Iterable<*>, index: Int) {
        val a = list.elementAt(index)!!
        val b = list.elementAt(index + 1)!!
        val c = list.elementAt(index + 2)!!
        when {
            a is Number && b is Number && c is Number -> invoke(a, b, c)
            a is Char && b is Char && c is Char -> invoke(a.b, b.b, c.b)
            a is Boolean && b is Boolean && c is Boolean -> invoke(a.b, b.b, c.b)
            a is String && b is String && c is String ->
                when {
                    x is Byte && y is Byte && z is Byte -> invoke(a.b, b.b, c.b)
                    x is Short && y is Short && z is Short -> invoke(a.s, b.s, c.s)
                    x is Int && y is Int && z is Int -> invoke(a.i, b.i, c.i)
                    x is Long && y is Long && z is Long -> invoke(a.L, b.L, c.L)
                    x is Float && y is Float && z is Float -> invoke(a.f, b.f, c.f)
                    x is Double && y is Double && z is Double -> invoke(a.d, b.d, c.d)
                    else -> throw ArithmeticException("incompatible type")  //TODO uns
                }
            else -> throw ArithmeticException("incompatible type")
        }
    }

    operator fun invoke(bytes: ByteBuffer, index: Int) = invoke(bytes[index], bytes[index + 1], bytes[index + 2])
    operator fun invoke(chars: CharBuffer, index: Int) = invoke(chars[index].b, chars[index + 1].b, chars[index + 2].b)
    operator fun invoke(shorts: ShortBuffer, index: Int) = invoke(shorts[index], shorts[index + 1], shorts[index + 2])
    operator fun invoke(ints: IntBuffer, index: Int) = invoke(ints[index], ints[index + 1], ints[index + 2])
    operator fun invoke(longs: LongBuffer, index: Int) = invoke(longs[index], longs[index + 1], longs[index + 2])
    operator fun invoke(floats: FloatBuffer, index: Int) = invoke(floats[index], floats[index + 1], floats[index + 2])
    operator fun invoke(doubles: DoubleBuffer, index: Int) = invoke(doubles[index], doubles[index + 1], doubles[index + 2])


    fun toByteArray(bigEndian: Boolean = true) = to(ByteArray(length), 0, bigEndian)
    infix fun to(bytes: ByteArray) = to(bytes, 0)
    fun to(bytes: ByteArray, bigEndian: Boolean) = to(bytes, 0, bigEndian)
    abstract fun to(bytes: ByteArray, index: Int, bigEndian: Boolean = true): ByteArray

    fun toByteBuffer() = to(bufferBig(size()), 0)
    infix fun to(bytes: ByteBuffer) = to(bytes, bytes.position())
    abstract fun to(bytes: ByteBuffer, index: Int): ByteBuffer


    infix fun lessThan(b: Vec3t<out Number>) = glm.lessThan(this, b, Vec3bool())
    fun lessThan(b: Vec3t<out Number>, res: Vec3bool = Vec3bool()) = glm.lessThan(this, b, res)

    infix fun lessThanEqual(b: Vec3t<out Number>) = glm.lessThan(this, b, Vec3bool())
    fun lessThanEqual(b: Vec3t<out Number>, res: Vec3bool = Vec3bool()) = glm.lessThan(this, b, res)

    infix fun greaterThan(b: Vec3t<out Number>) = glm.greaterThan(this, b, Vec3bool())
    fun greaterThan(b: Vec3t<out Number>, res: Vec3bool = Vec3bool()) = glm.greaterThan(this, b, res)

    infix fun greaterThanEqual(b: Vec3t<out Number>) = glm.greaterThanEqual(this, b, Vec3bool())
    fun greaterThanEqual(b: Vec3t<out Number>, res: Vec3bool = Vec3bool()) = glm.greaterThanEqual(this, b, res)

    infix fun equal(b: Vec3t<out Number>) = glm.equal(this, b, Vec3bool())
    fun equal(b: Vec3t<out Number>, res: Vec3bool = Vec3bool()) = glm.equal(this, b, res)

    infix fun notEqual(b: Vec3t<out Number>) = glm.notEqual(this, b, Vec3bool())
    fun notEqual(b: Vec3t<out Number>, res: Vec3bool = Vec3bool()) = glm.notEqual(this, b, res)

    infix fun isEqual(b: Vec3t<out Number>) = glm.isEqual(this, b)


    companion object {
        const val length = 3
    }


    override fun toString() = "($x, $y, $z)"

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


    // swizzling
    protected abstract fun createInstance(x: T, y: T): Vec2t<out Number>
    protected abstract fun createInstance(x: T, y: T, z: T): Vec3t<out Number>

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


    val xxx @JvmName("xxx") get() = createInstance(x, x, x)
    val xxy @JvmName("xxy") get() = createInstance(x, x, y)
    val xxz @JvmName("xxz") get() = createInstance(x, x, z)
    val xyx @JvmName("xyx") get() = createInstance(x, y, x)
    val xyy @JvmName("xyy") get() = createInstance(x, y, y)
    var xyz
        @JvmName("xyz") get() = createInstance(x, y, z)
        @JvmName("xyz") set(value) = put(value.x, value.y, value.z)
    val xzx @JvmName("xzx") get() = createInstance(x, z, x)
    var xzy
        @JvmName("xzy") get() = createInstance(x, z, y)
        @JvmName("xzy") set(value) = put(value.x, value.z, value.y)
    val xzz @JvmName("xzz") get() = createInstance(x, z, z)

    val yxx @JvmName("yxx") get() = createInstance(y, x, x)
    val yxy @JvmName("yxy") get() = createInstance(y, x, y)
    var yxz
        @JvmName("yxz") get() = createInstance(y, x, z)
        @JvmName("yxz") set(value) = put(value.y, value.x, value.z)
    val yyx @JvmName("yyx") get() = createInstance(y, y, x)
    val yyy @JvmName("yyy") get() = createInstance(y, y, y)
    val yyz @JvmName("yyz") get() = createInstance(y, y, z)
    var yzx
        @JvmName("yzx") get() = createInstance(y, z, x)
        @JvmName("yzx") set(value) = put(value.y, value.z, value.x)
    val yzy @JvmName("yzy") get() = createInstance(y, z, y)
    val yzz @JvmName("yzz") get() = createInstance(y, z, z)

    val zxx @JvmName("zxx") get() = createInstance(z, x, x)
    var zxy
        @JvmName("zxy") get() = createInstance(z, x, y)
        @JvmName("zxy") set(value) = put(value.z, value.x, value.y)
    val zxz @JvmName("zxz") get() = createInstance(z, x, z)
    var zyx
        @JvmName("zyx") get() = createInstance(z, y, x)
        @JvmName("zyx") set(value) = put(value.z, value.y, value.x)
    val zyy @JvmName("zyy") get() = createInstance(z, y, y)
    val zyz @JvmName("zyz") get() = createInstance(z, y, z)
    val zzx @JvmName("zzx") get() = createInstance(z, z, x)
    val zzy @JvmName("zzy") get() = createInstance(z, z, y)
    val zzz @JvmName("zzz") get() = createInstance(z, z, z)
}