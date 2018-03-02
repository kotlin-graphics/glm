package glm_.vec1

import glm_.Vector1Component
import glm_.b
import glm_.vec2.Vec2bool
import glm_.vec2.Vec2t
import glm_.vec3.Vec3bool
import glm_.vec3.Vec3t
import glm_.vec4.Vec4bool
import glm_.vec4.Vec4t
import java.nio.*

/**
 * Created bY GBarbieri on 05.10.2016.
 */

abstract class Vec1t<T : Number>(_x: T) : Vector1Component<T> {

    @JvmField
    var x = _x

    // -- infix Generic Constructors --

    infix fun put(v: Vec1t<out Number>) = put(v.x)
    infix fun put(v: Vec2t<out Number>) = put(v.x)
    infix fun put(v: Vec3t<out Number>) = put(v.x)
    infix fun put(v: Vec4t<out Number>) = put(v.x)

    infix fun put(v: Vec1bool) = put(v.x.b)
    infix fun put(v: Vec2bool) = put(v.x.b)
    infix fun put(v: Vec3bool) = put(v.x.b)
    infix fun put(v: Vec4bool) = put(v.x.b)

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

    abstract fun put(x: Number): Vec1t<T>

    // -- indexed Generic Constructors --

    fun put(bytes: ByteArray, index: Int) = put(bytes[index])
    fun put(chars: CharArray, index: Int) = put(chars[index].b)
    fun put(shorts: ShortArray, index: Int) = put(shorts[index])
    fun put(ints: IntArray, index: Int) = put(ints[index])
    fun put(longs: LongArray, index: Int) = put(longs[index])
    fun put(floats: FloatArray, index: Int) = put(floats[index])
    fun put(doubles: DoubleArray, index: Int) = put(doubles[index])
    fun put(booleans: BooleanArray, index: Int) = put(booleans[index].b)

    fun put(a: Array<out Number>, index: Int) = put(a[index])
    fun put(a: Array<Char>, index: Int) = put(a[index].b)
    fun put(a: Array<Boolean>, index: Int) = put(a[index].b)

    fun put(list: List<Any>, index: Int) {
        val x = list[index]
        val y = list[index + 1]
        if (x is Number && y is Number) put(x)
        else if (x is Char && y is Char) put(x.b)
        else if (x is Boolean && y is Boolean) put(x.b)
        else throw ArithmeticException("incompatible with this type")
    }

    fun put(bytes: ByteBuffer, index: Int) = put(bytes[index])
    fun put(chars: CharBuffer, index: Int) = put(chars[index].b)
    fun put(shorts: ShortBuffer, index: Int) = put(shorts[index])
    fun put(ints: IntBuffer, index: Int) = put(ints[index])
    fun put(longs: LongBuffer, index: Int) = put(longs[index])
    fun put(floats: FloatBuffer, index: Int) = put(floats[index])
    fun put(doubles: DoubleBuffer, index: Int) = put(doubles[index])

// TODO
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


    companion object {

        // -- functions --

        @JvmField
        val length = 2
    }


    // component alias

    var r
        @JvmName("r") get() = x
        @JvmName("r") set(value) {
            x = value
        }


    var s
        @JvmName("toShort") get() = x
        @JvmName("toShort") set(value) {
            x = value
        }

    override operator fun component1(): T = x
}