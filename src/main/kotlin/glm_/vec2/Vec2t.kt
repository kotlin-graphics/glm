@file:Suppress("UNCHECKED_CAST")

package glm_.vec2

import glm_.*
import glm_.vec3.Vec3bool
import glm_.vec3.Vec3t
import glm_.vec4.Vec4bool
import glm_.vec4.Vec4t
import java.nio.*

/**
 * Created bY GBarbieri on 05.10.2016.
 */

interface Vec2t<T : Number> : ToBuffer {

    var _x: T
    var _y: T

    operator fun component1() = _x
    operator fun component2() = _y

    // -- Component accesses --

    operator fun get(index: Int) = when (index) {
        0 -> _x
        1 -> _y
        else -> throw IndexOutOfBoundsException()
    }

    operator fun set(index: Int, value: T)
    operator fun set(index: Int, value: Number)

    // -- infix Generic Constructors --

    fun put(x: Number, y: Number)

    infix fun put(x: Number) = put(x, x)

    infix fun put(v: Vec2t<out Number>) = put(v._x, v._y)
    infix fun put(v: Vec3t<out Number>) = put(v.x, v.y)
    infix fun put(v: Vec4t<out Number>) = put(v.x, v.y)

    infix fun put(v: Vec2bool) = put(v.x.b, v.y.b)
    infix fun put(v: Vec3bool) = put(v.x.b, v.y.b)
    infix fun put(v: Vec4bool) = put(v.x.b, v.y.b)

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

    fun put(bytes: ByteArray, index: Int) = put(bytes[index], bytes[index + 1])
    fun put(chars: CharArray, index: Int) = put(chars[index].b, chars[index + 1].b)
    fun put(shorts: ShortArray, index: Int) = put(shorts[index], shorts[index + 1])
    fun put(ints: IntArray, index: Int) = put(ints[index], ints[index + 1])
    fun put(longs: LongArray, index: Int) = put(longs[index], longs[index + 1])
    fun put(floats: FloatArray, index: Int) = put(floats[index], floats[index + 1])
    fun put(doubles: DoubleArray, index: Int) = put(doubles[index], doubles[index + 1])
    fun put(booleans: BooleanArray, index: Int) = put(booleans[index].b, booleans[index + 1].b)

    fun put(a: Array<out Number>, index: Int) = put(a[index], a[index + 1])
    fun put(a: Array<Char>, index: Int) = put(a[index].b, a[index + 1].b)
    fun put(a: Array<Boolean>, index: Int) = put(a[index].b, a[index + 1].b)

    fun put(list: Iterable<*>, index: Int) {
        val a = list.elementAt(index)!!
        val b = list.elementAt(index + 1)!!
        when {
            a is Number && b is Number -> put(a, b)
            a is Char && b is Char -> put(a.b, b.b)
            a is Boolean && b is Boolean -> put(a.b, b.b)
            a is String && b is String ->
                when {
                    _x is Byte && _y is Byte -> put(a.b, b.b)
                    _x is Short && _y is Short -> put(a.s, b.s)
                    _x is Int && _y is Int -> put(a.i, b.i)
                    _x is Long && _y is Long -> put(a.L, b.L)
                    _x is Float && _y is Float -> put(a.f, b.f)
                    _x is Double && _y is Double -> put(a.d, b.d)
                    else -> throw ArithmeticException("incompatible type")
                }
            else -> throw ArithmeticException("incompatible type")
        }
    }

    fun put(bytes: ByteBuffer, index: Int) = put(bytes[index], bytes[index + 1])
    fun put(chars: CharBuffer, index: Int) = put(chars[index].b, chars[index + 1].b)
    fun put(shorts: ShortBuffer, index: Int) = put(shorts[index], shorts[index + 1])
    fun put(ints: IntBuffer, index: Int) = put(ints[index], ints[index + 1])
    fun put(longs: LongBuffer, index: Int) = put(longs[index], longs[index + 1])
    fun put(floats: FloatBuffer, index: Int) = put(floats[index], floats[index + 1])
    fun put(doubles: DoubleBuffer, index: Int) = put(doubles[index], doubles[index + 1])


    // -- Same but with () --

    operator fun invoke(x: Number, y: Number): Vec2t<out Number>

    infix operator fun invoke(v: Vec2t<out Number>) = invoke(v._x, v._y)
    infix operator fun invoke(v: Vec3t<out Number>) = invoke(v.x, v.y)
    infix operator fun invoke(v: Vec4t<out Number>) = invoke(v.x, v.y)

    infix operator fun invoke(v: Vec2bool) = invoke(v.x.b, v.y.b)
    infix operator fun invoke(v: Vec3bool) = invoke(v.x.b, v.y.b)
    infix operator fun invoke(v: Vec4bool) = invoke(v.x.b, v.y.b)

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

    infix operator fun invoke(s: Number) = invoke(s, s)

    // -- indexed Generic Constructors --

    operator fun invoke(bytes: ByteArray, index: Int) = invoke(bytes[index], bytes[index + 1])
    operator fun invoke(chars: CharArray, index: Int) = invoke(chars[index].b, chars[index + 1].b)
    operator fun invoke(shorts: ShortArray, index: Int) = invoke(shorts[index], shorts[index + 1])
    operator fun invoke(ints: IntArray, index: Int) = invoke(ints[index], ints[index + 1])
    operator fun invoke(longs: LongArray, index: Int) = invoke(longs[index], longs[index + 1])
    operator fun invoke(floats: FloatArray, index: Int) = invoke(floats[index], floats[index + 1])
    operator fun invoke(doubles: DoubleArray, index: Int) = invoke(doubles[index], doubles[index + 1])
    operator fun invoke(booleans: BooleanArray, index: Int) = invoke(booleans[index].b, booleans[index + 1].b)

    operator fun invoke(a: Array<out Number>, index: Int) = invoke(a[index], a[index + 1])
    operator fun invoke(a: Array<Char>, index: Int) = invoke(a[index].b, a[index + 1].b)
    operator fun invoke(a: Array<Boolean>, index: Int) = invoke(a[index].b, a[index + 1].b)

    operator fun invoke(list: Iterable<*>, index: Int) {
        val a = list.elementAt(index)!!
        val b = list.elementAt(index + 1)!!
        when {
            a is Number && b is Number -> invoke(a, b)
            a is Char && b is Char -> invoke(a.b, b.b)
            a is Boolean && b is Boolean -> invoke(a.b, b.b)
            a is String && b is String ->
                when {
                    _x is Byte && _y is Byte -> invoke(a.b, b.b)
                    _x is Short && _y is Short -> invoke(a.s, b.s)
                    _x is Int && _y is Int -> invoke(a.i, b.i)
                    _x is Long && _y is Long -> invoke(a.L, b.L)
                    _x is Float && _y is Float -> invoke(a.f, b.f)
                    _x is Double && _y is Double -> invoke(a.d, b.d)
                    else -> throw ArithmeticException("incompatible type")
                }
            else -> throw ArithmeticException("incompatible type")
        }
    }

    operator fun invoke(bytes: ByteBuffer, index: Int) = invoke(bytes[index], bytes[index + 1])
    operator fun invoke(chars: CharBuffer, index: Int) = invoke(chars[index].b, chars[index + 1].b)
    operator fun invoke(shorts: ShortBuffer, index: Int) = invoke(shorts[index], shorts[index + 1])
    operator fun invoke(ints: IntBuffer, index: Int) = invoke(ints[index], ints[index + 1])
    operator fun invoke(longs: LongBuffer, index: Int) = invoke(longs[index], longs[index + 1])
    operator fun invoke(floats: FloatBuffer, index: Int) = invoke(floats[index], floats[index + 1])
    operator fun invoke(doubles: DoubleBuffer, index: Int) = invoke(doubles[index], doubles[index + 1])

    fun toByteArray(bigEndian: Boolean = true): ByteArray = to(ByteArray(LENGTH), 0, bigEndian)
    infix fun to(bytes: ByteArray): ByteArray = to(bytes, 0)
    fun to(bytes: ByteArray, bigEndian: Boolean): ByteArray = to(bytes, 0, bigEndian)
    fun to(bytes: ByteArray, index: Int, bigEndian: Boolean = true): ByteArray

//    infix fun lessThan(b: Vec2t<out Number>) = glm.lessThan(this, b, Vec2bool())
//    fun lessThan(b: Vec2t<out Number>, res: Vec2bool = Vec2bool()) = glm.lessThan(this, b, res)
//
//    infix fun lessThanEqual(b: Vec2t<out Number>) = glm.lessThan(this, b, Vec2bool())
//    fun lessThanEqual(b: Vec2t<out Number>, res: Vec2bool = Vec2bool()) = glm.lessThan(this, b, res)
//
//    infix fun greaterThan(b: Vec2t<out Number>) = glm.greaterThan(this, b, Vec2bool())
//    fun greaterThan(b: Vec2t<out Number>, res: Vec2bool = Vec2bool()) = glm.greaterThan(this, b, res)
//
//    infix fun greaterThanEqual(b: Vec2t<out Number>) = glm.greaterThanEqual(this, b, Vec2bool())
//    fun greaterThanEqual(b: Vec2t<out Number>, res: Vec2bool = Vec2bool()) = glm.greaterThanEqual(this, b, res)
//
//    infix fun equal(b: Vec2t<out Number>) = glm.equal(this, b, Vec2bool())
//    fun equal(b: Vec2t<out Number>, res: Vec2bool = Vec2bool()) = glm.equal(this, b, res)
//
//    infix fun notEqual(b: Vec2t<out Number>) = glm.notEqual(this, b, Vec2bool())
//    fun notEqual(b: Vec2t<out Number>, res: Vec2bool = Vec2bool()) = glm.notEqual(this, b, res)
//
//    infix fun isEqual(b: Vec2t<out Number>) = glm.isEqual(this, b)

    // component alias


    //@formatter:off
    var r get() = _x; set(value) { _x = value }
    var s get() = _x; set(value) { _x = value }

    var g get() = _y; set(value) { _y = value }
    var t get() = _y; set(value) { _y = value }
    //@formatter:on

    companion object {
        const val LENGTH = 2
    }
}
