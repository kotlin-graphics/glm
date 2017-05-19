package glm.vec4

import glm.b
import glm.glm
import java.nio.*
import glm.vec2.Vec2t
import glm.vec2.Vec2bool
import glm.vec3.Vec3t
import glm.vec3.Vec3bool

// TODO other
abstract class Vec4t<T : Number>(_x: T, _y: T, _z: T, _w: T) {

    @JvmField var x = _x
    @JvmField var y = _y
    @JvmField var z = _z
    @JvmField var w = _w


    fun x(x: T) {
        this.x = x
    }

    fun y(y: T) {
        this.y = y
    }

    fun z(z: T) {
        this.z = z
    }

    fun w(w: T) {
        this.w = w
    }

    fun x() = x
    fun y() = y
    fun z() = z
    fun w() = w


    // -- infix Generic Constructors --

    infix fun put(v: Vec2t<out Number>) = put(v.x, v.y, 0, 1)
    fun put(v: Vec2t<out Number>, z: Number) = put(v.x, v.y, z, 1)
    fun put(v: Vec2t<out Number>, z: Number, w: Number) = put(v.x, v.y, z, w)

    infix fun put(v:Vec3t<out Number>) = put(v.x, v.y, v.z, 1)
    fun put(v:Vec3t<out Number>, w: Number) = put(v.x, v.y, v.z, w)

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

    infix fun put(s: Number) = put(s, s, s, s)
    abstract fun put(x: Number, y: Number, z: Number, w: Number): Vec4t<T>

    infix abstract fun to(bytes: ByteBuffer): ByteBuffer
    abstract fun to(bytes: ByteBuffer, index: Int): ByteBuffer

    // -- indexed Generic Constructors --

    fun put(bytes: ByteArray, index: Int) = put(bytes[index], bytes[index + 1], bytes[index + 2], bytes[index + 2])
    fun put(chars: CharArray, index: Int) = put(chars[index].b, chars[index + 1].b, chars[index + 2].b, chars[index + 3].b)
    fun put(shorts: ShortArray, index: Int) = put(shorts[index], shorts[index + 1], shorts[index + 2], shorts[index + 3])
    fun put(ints: IntArray, index: Int) = put(ints[index], ints[index + 1], ints[index + 2], ints[index + 3])
    fun put(longs: LongArray, index: Int) = put(longs[index], longs[index + 1], longs[index + 2], longs[index + 3])
    fun put(floats: FloatArray, index: Int) = put(floats[index], floats[index + 1], floats[index + 2], floats[index + 3])
    fun put(doubles: DoubleArray, index: Int) = put(doubles[index], doubles[index + 1], doubles[index + 2], doubles[index + 3])
    fun put(booleans: BooleanArray, index: Int) = put(booleans[index].b, booleans[index + 1].b, booleans[index + 2].b, booleans[index + 3].b)

    fun put(a: Array<out Number>, index: Int) = put(a[index], a[index + 1], a[index + 2], a[index + 3])
    fun put(a: Array<Char>, index: Int) = put(a[index].b, a[index + 1].b, a[index + 2].b, a[index + 3].b)
    fun put(a: Array<Boolean>, index: Int) = put(a[index].b, a[index + 1].b, a[index + 2].b, a[index + 3].b)

    fun put(list: List<Any>, index: Int) {
        val x = list[index]
        val y = list[index + 1]
        val z = list[index + 2]
        val w = list[index + 3]
        if (x is Number && y is Number && z is Number && w is Number) put(x, y, z, w)
        else if (x is Char && y is Char && z is Char && w is Char) put(x.b, y.b, z.b, w.b)
        else if (x is Boolean && y is Boolean && z is Boolean && w is Boolean) put(x.b, y.b, z.b, w.b)
        else throw ArithmeticException("incompatible this type")
    }

    fun put(bytes: ByteBuffer, index: Int) = put(bytes[index], bytes[index + 1], bytes[index + 2], bytes[index + 3])
    fun put(chars: CharBuffer, index: Int) = put(chars[index].b, chars[index + 1].b, chars[index + 2].b, chars[index + 3].b)
    fun put(shorts: ShortBuffer, index: Int) = put(shorts[index], shorts[index + 1], shorts[index + 2], shorts[index + 3])
    fun put(ints: IntBuffer, index: Int) = put(ints[index], ints[index + 1], ints[index + 2], ints[index + 3])
    fun put(longs: LongBuffer, index: Int) = put(longs[index], longs[index + 1], longs[index + 2], longs[index + 3])
    fun put(floats: FloatBuffer, index: Int) = put(floats[index], floats[index + 1], floats[index + 2], floats[index + 3])
    fun put(doubles: DoubleBuffer, index: Int) = put(doubles[index], doubles[index + 1], doubles[index + 2], doubles[index + 3])


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

    infix fun isEqual(b: Vec4t<out Number>) = glm.isEqual(this, b)

    abstract fun instanceSize(): Int // TODO check

    // components alias

    var r = x
        @JvmName("r") get() = x
        @JvmName("r") set(value) {
            field = value
            x = field
        }
    var g = y
        @JvmName("g") get() = y
        @JvmName("g") set(value) {
            field = value
            y = field
        }
    var b = z
        @JvmName("b") get() = z
        @JvmName("b") set(value) {
            field = value
            z = field
        }
    var a = w
        @JvmName("a") get() = w
        @JvmName("a") set(value) {
            field = value
            w = field
        }


    var s = x
        @JvmName("s") get() = x
        @JvmName("s") set(value) {
            field = value
            x = field
        }
    var t = y
        @JvmName("t") get() = y
        @JvmName("t") set(value) {
            field = value
            y = field
        }
    var p = z
        @JvmName("p") get() = z
        @JvmName("p") set(value) {
            field = value
            z = field
        }
    var q = w
        @JvmName("q") get() = w
        @JvmName("q") set(value) {
            field = value
            w = field
        }

    override fun toString() = "$x, $y, $z, $w"
}