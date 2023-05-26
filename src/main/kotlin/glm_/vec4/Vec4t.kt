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

    inline operator fun component1() = x
    inline operator fun component2() = y
    inline operator fun component3() = z
    inline operator fun component4() = w

    inline operator fun get(index: Int) = when (index) {
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

    inline var r
        @JvmName("r") get() = x
        @JvmName("r") set(value) {
            x = value
        }
    inline var g
        @JvmName("g") get() = y
        @JvmName("g") set(value) {
            y = value
        }
    inline var b
        @JvmName("b") get() = z
        @JvmName("b") set(value) {
            z = value
        }
    inline var a
        @JvmName("a") get() = w
        @JvmName("a") set(value) {
            w = value
        }


    inline var s
        @JvmName("s") get() = x
        @JvmName("s") set(value) {
            x = value
        }
    inline var t
        @JvmName("t") get() = y
        @JvmName("t") set(value) {
            y = value
        }
    inline var p
        @JvmName("p") get() = z
        @JvmName("p") set(value) {
            z = value
        }
    inline var q
        @JvmName("q") get() = w
        @JvmName("q") set(value) {
            w = value
        }

    companion object {
        const val length = 4
    }

    override fun toString(): String = "($x, $y, $z, $w)"
}