package glm_.vec1

import glm_.*
import glm_.vec2.Vec2bool
import glm_.vec2.Vec2t
import glm_.vec3.Vec3bool
import glm_.vec3.Vec3t
import glm_.vec4.Vec4bool
import glm_.vec4.Vec4t
import kool.Buffer
import kool.pos
import org.lwjgl.system.MemoryStack
import java.nio.*

/**
 * Created bY GBarbieri on 05.10.2016.
 */

abstract class Vec1t<T : Number>(_x: T): ToBuffer {

    @JvmField
    var x = _x

    fun component1() = x


    // -- Component accesses --

    operator fun get(index: Int) = when (index) {
        0 -> x
        else -> throw IndexOutOfBoundsException()
    }

    open operator fun set(index: Int, value: T) = when (index) {
        0 -> x = value
        else -> throw IndexOutOfBoundsException()
    }

    // -- infix Generic Constructors --

    abstract fun put(x: Number)

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
        if (x is Number) put(x)
        else if (x is Char) put(x.b)
        else if (x is Boolean) put(x.b)
        else throw ArithmeticException("incompatible with this type")
    }

    fun put(bytes: ByteBuffer, index: Int) = put(bytes[index])
    fun put(chars: CharBuffer, index: Int) = put(chars[index].b)
    fun put(shorts: ShortBuffer, index: Int) = put(shorts[index])
    fun put(ints: IntBuffer, index: Int) = put(ints[index])
    fun put(longs: LongBuffer, index: Int) = put(longs[index])
    fun put(floats: FloatBuffer, index: Int) = put(floats[index])
    fun put(doubles: DoubleBuffer, index: Int) = put(doubles[index])


    // Same, but with ()

    abstract operator fun invoke(x: Number): Vec1t<out Number>

    infix operator fun invoke(v: Vec1t<out Number>) = invoke(v.x)
    infix operator fun invoke(v: Vec2t<out Number>) = invoke(v.x)
    infix operator fun invoke(v: Vec3t<out Number>) = invoke(v.x)
    infix operator fun invoke(v: Vec4t<out Number>) = invoke(v.x)

    infix operator fun invoke(v: Vec1bool) = invoke(v.x.b)
    infix operator fun invoke(v: Vec2bool) = invoke(v.x.b)
    infix operator fun invoke(v: Vec3bool) = invoke(v.x.b)
    infix operator fun invoke(v: Vec4bool) = invoke(v.x.b)

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

    // -- indexed Generic Constructors --

    operator fun invoke(bytes: ByteArray, index: Int) = invoke(bytes[index])
    operator fun invoke(chars: CharArray, index: Int) = invoke(chars[index].b)
    operator fun invoke(shorts: ShortArray, index: Int) = invoke(shorts[index])
    operator fun invoke(ints: IntArray, index: Int) = invoke(ints[index])
    operator fun invoke(longs: LongArray, index: Int) = invoke(longs[index])
    operator fun invoke(floats: FloatArray, index: Int) = invoke(floats[index])
    operator fun invoke(doubles: DoubleArray, index: Int) = invoke(doubles[index])
    operator fun invoke(booleans: BooleanArray, index: Int) = invoke(booleans[index].b)

    operator fun invoke(a: Array<out Number>, index: Int) = invoke(a[index])
    operator fun invoke(a: Array<Char>, index: Int) = invoke(a[index].b)
    operator fun invoke(a: Array<Boolean>, index: Int) = invoke(a[index].b)

    operator fun invoke(list: List<Any>, index: Int) {
        val x = list[index]
        if (x is Number) invoke(x)
        else if (x is Char) invoke(x.b)
        else if (x is Boolean) invoke(x.b)
        else throw ArithmeticException("incompatible with this type")
    }

    operator fun invoke(bytes: ByteBuffer, index: Int) = invoke(bytes[index])
    operator fun invoke(chars: CharBuffer, index: Int) = invoke(chars[index].b)
    operator fun invoke(shorts: ShortBuffer, index: Int) = invoke(shorts[index])
    operator fun invoke(ints: IntBuffer, index: Int) = invoke(ints[index])
    operator fun invoke(longs: LongBuffer, index: Int) = invoke(longs[index])
    operator fun invoke(floats: FloatBuffer, index: Int) = invoke(floats[index])
    operator fun invoke(doubles: DoubleBuffer, index: Int) = invoke(doubles[index])


    fun toByteArray(): ByteArray = to(ByteArray(length), 0)
    infix fun to(bytes: ByteArray): ByteArray = to(bytes, 0)
    fun to(bytes: ByteArray, bigEndian: Boolean): ByteArray = to(bytes, 0, bigEndian)
    abstract fun to(bytes: ByteArray, index: Int, bigEndian: Boolean = true): ByteArray

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


    // component alias

    var r
        @JvmName("r") get() = x
        @JvmName("r") set(value) {
            x = value
        }


    var s
        @JvmName("s") get() = x
        @JvmName("s") set(value) {
            x = value
        }

    companion object {
        const val length = 1
    }

    override fun toString(): String = "Vect1 [$x]"
}