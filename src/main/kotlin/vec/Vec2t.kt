package vec

import b
import glm
import vec.bool.Vec2bool
import vec.bool.Vec3bool
import vec.bool.Vec4bool
import java.nio.*

/**
 * Created bY GBarbieri on 05.10.2016.
 */

abstract class Vec2t<T : Number> {

    abstract var x: T
    abstract var y: T

    var r = x
        get() = x
        set(value) {
            field = value
            x = field
        }
    var g = y
        get() = y
        set(value) {
            field = value
            y = field
        }


    var s = x
        get() = x
        set(value) {
            field = value
            x = field
        }
    var t = y
        get() = y
        set(value) {
            field = value
            y = field
        }

    // -- infix Generic Constructors --

    infix fun Set(v: Vec2t<out Number>) = Set(v.x, v.y)
    infix fun Set(v: Vec3t<out Number>) = Set(v.x, v.y)
    infix fun Set(v: Vec4t<out Number>) = Set(v.x, v.y)

    infix fun Set(v: Vec2bool) = Set(v.x.b, v.y.b)
    infix fun Set(v: Vec3bool) = Set(v.x.b, v.y.b)
    infix fun Set(v: Vec4bool) = Set(v.x.b, v.y.b)

    infix fun Set(bytes: ByteArray) = Set(bytes, 0)
    infix fun Set(chars: CharArray) = Set(chars, 0)
    infix fun Set(shorts: ShortArray) = Set(shorts, 0)
    infix fun Set(ints: IntArray) = Set(ints, 0)
    infix fun Set(longs: LongArray) = Set(longs, 0)
    infix fun Set(floats: FloatArray) = Set(floats, 0)
    infix fun Set(doubles: DoubleArray) = Set(doubles, 0)
    infix fun Set(booleans: BooleanArray) = Set(booleans, 0)

    infix fun Set(numbers: Array<out Number>) = Set(numbers, 0)
    infix fun Set(chars: Array<Char>) = Set(chars, 0)
    infix fun Set(a: Array<Boolean>) = Set(a, 0)

    infix fun Set(list: List<Any>) = Set(list, 0)

    infix fun Set(bytes: ByteBuffer) = Set(bytes, 0)
    infix fun Set(chars: CharBuffer) = Set(chars, 0)
    infix fun Set(shorts: ShortBuffer) = Set(shorts, 0)
    infix fun Set(ints: IntBuffer) = Set(ints, 0)
    infix fun Set(longs: LongBuffer) = Set(longs, 0)
    infix fun Set(floats: FloatBuffer) = Set(floats, 0)
    infix fun Set(doubles: DoubleBuffer) = Set(doubles, 0)

    infix fun Set(s: Number) = Set(s, s)
    abstract fun Set(x: Number, y: Number): Vec2t<T>

    // -- indexed Generic Constructors --

    fun Set(bytes: ByteArray, index: Int) = Set(bytes[index], bytes[index + 1])
    fun Set(chars: CharArray, index: Int) = Set(chars[index].b, chars[index + 1].b)
    fun Set(shorts: ShortArray, index: Int) = Set(shorts[index], shorts[index + 1])
    fun Set(ints: IntArray, index: Int) = Set(ints[index], ints[index + 1])
    fun Set(longs: LongArray, index: Int) = Set(longs[index], longs[index + 1])
    fun Set(floats: FloatArray, index: Int) = Set(floats[index], floats[index + 1])
    fun Set(doubles: DoubleArray, index: Int) = Set(doubles[index], doubles[index + 1])
    fun Set(booleans: BooleanArray, index: Int) = Set(booleans[index].b, booleans[index + 1].b)

    fun Set(a: Array<out Number>, index: Int) = Set(a[index], a[index + 1])
    fun Set(a: Array<Char>, index: Int) = Set(a[index].b, a[index + 1].b)
    fun Set(a: Array<Boolean>, index: Int) = Set(a[index].b, a[index + 1].b)

    fun Set(list: List<Any>, index: Int) {
        val x = list[index]
        val y = list[index + 1]
        if (x is Number && y is Number) Set(x, y)
        else if (x is Char && y is Char) Set(x.b, y.b)
        else if (x is Boolean && y is Boolean) Set(x.b, y.b)
        else throw ArithmeticException("incompatible this type")
    }

    fun Set(bytes: ByteBuffer, index: Int) = Set(bytes[index], bytes[index + 1])
    fun Set(chars: CharBuffer, index: Int) = Set(chars[index].b, chars[index + 1].b)
    fun Set(shorts: ShortBuffer, index: Int) = Set(shorts[index], shorts[index + 1])
    fun Set(ints: IntBuffer, index: Int) = Set(ints[index], ints[index + 1])
    fun Set(longs: LongBuffer, index: Int) = Set(longs[index], longs[index + 1])
    fun Set(floats: FloatBuffer, index: Int) = Set(floats[index], floats[index + 1])
    fun Set(doubles: DoubleBuffer, index: Int) = Set(doubles[index], doubles[index + 1])


    fun length() = 2


    infix fun lessThan(b: Vec2t<out Number>) = glm.lessThan(this, b, Vec2bool())
    fun lessThan(b: Vec2t<out Number>, res: Vec2bool = Vec2bool()) = glm.lessThan(this, b, res)

    infix fun lessThanEqual(b: Vec2t<out Number>) = glm.lessThan(this, b, Vec2bool())
    fun lessThanEqual(b: Vec2t<out Number>, res: Vec2bool = Vec2bool()) = glm.lessThan(this, b, res)

    infix fun greaterThan(b: Vec2t<out Number>) = glm.greaterThan(this, b, Vec2bool())
    fun greaterThan(b: Vec2t<out Number>, res: Vec2bool = Vec2bool()) = glm.greaterThan(this, b, res)

    infix fun greaterThanEqual(b: Vec2t<out Number>) = glm.greaterThanEqual(this, b, Vec2bool())
    fun greaterThanEqual(b: Vec2t<out Number>, res: Vec2bool = Vec2bool()) = glm.greaterThanEqual(this, b, res)

    infix fun equal(b: Vec2t<out Number>) = glm.equal(this, b, Vec2bool())
    fun equal(b: Vec2t<out Number>, res: Vec2bool = Vec2bool()) = glm.equal(this, b, res)

    infix fun notEqual(b: Vec2t<out Number>) = glm.notEqual(this, b, Vec2bool())
    fun notEqual(b: Vec2t<out Number>, res: Vec2bool = Vec2bool()) = glm.notEqual(this, b, res)
}