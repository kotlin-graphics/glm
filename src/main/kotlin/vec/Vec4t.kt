package vec

import main.b
import main.glm
import vec.bool.Vec2bool
import vec.bool.Vec3bool
import vec.bool.Vec4bool
import java.nio.*

// TODO other
abstract class Vec4t<T : Number> {

    abstract var x: T
    abstract var y: T
    abstract var z: T
    abstract var w: T

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
    var a = w
        get() = w
        set(value) {
            field = value
            w = field
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
    var q = w
        get() = w
        set(value) {
            field = value
            w = field
        }

    // -- infix Generic Constructors --

    infix fun Set(v: Vec2t<out Number>) = Set(v.x, v.y, 0, 1)
    infix fun Set(v: Vec3t<out Number>) = Set(v.x, v.y, v.z, 1)
    infix fun Set(v: Vec4t<out Number>) = Set(v.x, v.y, v.z, v.w)

    infix fun Set(v: Vec2bool) = Set(v.x.b, v.y.b, 0, 1)
    infix fun Set(v: Vec3bool) = Set(v.x.b, v.y.b, v.z.b, 1)
    infix fun Set(v: Vec4bool) = Set(v.x.b, v.y.b, v.z.b, v.w.b)

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

    infix fun Set(s: Number) = Set(s, s, s, s)
    abstract fun Set(x: Number, y: Number, z: Number, w: Number): Vec4t<T>

    // -- indexed Generic Constructors --

    fun Set(bytes: ByteArray, index: Int) = Set(bytes[index], bytes[index + 1], bytes[index + 2], bytes[index + 2])
    fun Set(chars: CharArray, index: Int) = Set(chars[index].b, chars[index + 1].b, chars[index + 2].b, chars[index + 3].b)
    fun Set(shorts: ShortArray, index: Int) = Set(shorts[index], shorts[index + 1], shorts[index + 2], shorts[index + 3])
    fun Set(ints: IntArray, index: Int) = Set(ints[index], ints[index + 1], ints[index + 2], ints[index + 3])
    fun Set(longs: LongArray, index: Int) = Set(longs[index], longs[index + 1], longs[index + 2], longs[index + 3])
    fun Set(floats: FloatArray, index: Int) = Set(floats[index], floats[index + 1], floats[index + 2], floats[index + 3])
    fun Set(doubles: DoubleArray, index: Int) = Set(doubles[index], doubles[index + 1], doubles[index + 2], doubles[index + 3])
    fun Set(booleans: BooleanArray, index: Int) = Set(booleans[index].b, booleans[index + 1].b, booleans[index + 2].b, booleans[index + 3].b)

    fun Set(a: Array<out Number>, index: Int) = Set(a[index], a[index + 1], a[index + 2], a[index + 3])
    fun Set(a: Array<Char>, index: Int) = Set(a[index].b, a[index + 1].b, a[index + 2].b, a[index + 3].b)
    fun Set(a: Array<Boolean>, index: Int) = Set(a[index].b, a[index + 1].b, a[index + 2].b, a[index + 3].b)

    fun Set(list: List<Any>, index: Int) {
        val x = list[index]
        val y = list[index + 1]
        val z = list[index + 2]
        val w = list[index + 3]
        if (x is Number && y is Number && z is Number && w is Number) Set(x, y, z, w)
        else if (x is Char && y is Char && z is Char && w is Char) Set(x.b, y.b, z.b, w.b)
        else if (x is Boolean && y is Boolean && z is Boolean && w is Boolean) Set(x.b, y.b, z.b, w.b)
        else throw ArithmeticException("incompatible this type")
    }

    fun Set(bytes: ByteBuffer, index: Int) = Set(bytes[index], bytes[index + 1], bytes[index + 2], bytes[index + 3])
    fun Set(chars: CharBuffer, index: Int) = Set(chars[index].b, chars[index + 1].b, chars[index + 2].b, chars[index + 3].b)
    fun Set(shorts: ShortBuffer, index: Int) = Set(shorts[index], shorts[index + 1], shorts[index + 2], shorts[index + 3])
    fun Set(ints: IntBuffer, index: Int) = Set(ints[index], ints[index + 1], ints[index + 2], ints[index + 3])
    fun Set(longs: LongBuffer, index: Int) = Set(longs[index], longs[index + 1], longs[index + 2], longs[index + 3])
    fun Set(floats: FloatBuffer, index: Int) = Set(floats[index], floats[index + 1], floats[index + 2], floats[index + 3])
    fun Set(doubles: DoubleBuffer, index: Int) = Set(doubles[index], doubles[index + 1], doubles[index + 2], doubles[index + 3])


    fun length() = 4


    infix fun lessThan(b: Vec4t<out Number>) = glm.lessThan(this, b, Vec4bool())
    fun lessThan(b: Vec4t<out Number>, res: Vec4bool = Vec4bool()) = glm.lessThan(this, b, res)

    infix fun lessThanEqual(b: Vec4t<out Number>) = glm.lessThan(this, b, Vec4bool())
    fun lessThanEqual(b: Vec4t<out Number>, res: Vec4bool = Vec4bool()) = glm.lessThan(this, b, res)

    infix fun greaterThan(b: Vec4t<out Number>) = glm.greaterThan(this, b, Vec4bool())
    fun greaterThan(b: Vec4t<out Number>, res: Vec4bool = Vec4bool()) = glm.greaterThan(this, b, res)

    infix fun greaterThanEqual(b: Vec4t<out Number>) = glm.greaterThanEqual(this, b, Vec4bool())
    fun greaterThanEqual(b: Vec4t<out Number>, res: Vec4bool = Vec4bool()) = glm.greaterThanEqual(this, b, res)

    infix fun equal(b: Vec4t<out Number>) = glm.equal(this, b, Vec4bool())
    fun equal(b: Vec4t<out Number>, res: Vec4bool = Vec4bool()) = glm.equal(this, b, res)

    infix fun notEqual(b: Vec4t<out Number>) = glm.notEqual(this, b, Vec4bool())
    fun notEqual(b: Vec4t<out Number>, res: Vec4bool = Vec4bool()) = glm.notEqual(this, b, res)
}