package vec

import main.b
import main.d
import main.glm
import vec.bool.Vec2bool
import vec.bool.Vec3bool
import vec.bool.Vec4bool
import java.nio.*

abstract class Vec3t<T : Number> {

    companion object {
        fun length() = 3
    }

    abstract var x: T
    abstract var y: T
    abstract var z: T

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
    var b = z
        get() = z
        set(value) {
            field = value
            z = field
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
    var p = z
        get() = z
        set(value) {
            field = value
            z = field
        }


    // -- infix Generic Constructors --

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

    infix fun put(s: Number) = put(s, s, s)
    abstract fun put(x: Number, y: Number, z: Number): Vec3t<T>

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

    fun put(list: List<Any>, index: Int) {
        val x = list[index]
        val y = list[index + 1]
        val z = list[index + 2]
        if (x is Number && y is Number && z is Number) put(x, y, z)
        else if (x is String && y is String && z is String) put(x.d, y.d, z.d)
        else if (x is Char && y is Char && z is Char) put(x.b, y.b, z.b)
        else if (x is Boolean && y is Boolean && z is Boolean) put(x.b, y.b, z.b)
        else throw ArithmeticException("incompatible this type")
    }

    fun put(bytes: ByteBuffer, index: Int) = put(bytes[index], bytes[index + 1], bytes[index + 2])
    fun put(chars: CharBuffer, index: Int) = put(chars[index].b, chars[index + 1].b, chars[index + 2].b)
    fun put(shorts: ShortBuffer, index: Int) = put(shorts[index], shorts[index + 1], shorts[index + 2])
    fun put(ints: IntBuffer, index: Int) = put(ints[index], ints[index + 1], ints[index + 2])
    fun put(longs: LongBuffer, index: Int) = put(longs[index], longs[index + 1], longs[index + 2])
    fun put(floats: FloatBuffer, index: Int) = put(floats[index], floats[index + 1], floats[index + 2])
    fun put(doubles: DoubleBuffer, index: Int) = put(doubles[index], doubles[index + 1], doubles[index + 2])


    fun length() = 3


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
}