@file:Suppress("UNCHECKED_CAST")

package glm_.vec4

import glm_.b
import glm_.glm
import glm_.vec2.*
import glm_.vec3.*
import java.nio.*

// TODO other
abstract class Vec4t<T : Number>(_x: T, _y: T, _z: T, _w: T) {

    @JvmField var x = _x
    @JvmField var y = _y
    @JvmField var z = _z
    @JvmField var w = _w

    open operator fun get(i: Int) = when (i) {
        0 -> x
        1 -> y
        2 -> z
        3 -> 2
        else -> throw IndexOutOfBoundsException()
    }

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

    operator fun component1() = x
    operator fun component2() = y
    operator fun component3() = z
    operator fun component4() = w

    override fun toString() = "($x, $y, $z, $w)"

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


    // swizzling

    val xx @JvmName("xx") get() = when (this) {
        is Vec4 -> Vec2(x, x)
        is Vec4d -> Vec2d(x, x)
        is Vec4b -> Vec2b(x, x)
        is Vec4i -> Vec2i(x, x)
        is Vec4s -> Vec2s(x, x)
        is Vec4l -> Vec2l(x, x)
        is Vec4ub -> Vec2ub(x, x)
        is Vec4ui -> Vec2ui(x, x)
        is Vec4us -> Vec2us(x, x)
        is Vec4ul -> Vec2ul(x, x)
        else -> throw IllegalStateException()
    }
    var xy @JvmName("xy") get() = when (this) {
        is Vec4 -> Vec2(this)
        is Vec4d -> Vec2d(this)
        is Vec4b -> Vec2b(this)
        is Vec4i -> Vec2i(this)
        is Vec4s -> Vec2s(this)
        is Vec4l -> Vec2l(this)
        is Vec4ub -> Vec2ub(this)
        is Vec4ui -> Vec2ui(this)
        is Vec4us -> Vec2us(this)
        is Vec4ul -> Vec2ul(this)
        else -> throw IllegalStateException()
    }
        @JvmName("xy") set(value) {
            x = value.x as T
            y = value.y as T
        }
    var yx @JvmName("yx") get() = when (this) {
        is Vec4 -> Vec2(y, x)
        is Vec4d -> Vec2d(y, x)
        is Vec4b -> Vec2b(y, x)
        is Vec4i -> Vec2i(y, x)
        is Vec4s -> Vec2s(y, x)
        is Vec4l -> Vec2l(y, x)
        is Vec4ub -> Vec2ub(y, x)
        is Vec4ui -> Vec2ui(y, x)
        is Vec4us -> Vec2us(y, x)
        is Vec4ul -> Vec2ul(y, x)
        else -> throw IllegalStateException()
    }
        @JvmName("yx") set(value) {
            y = value.x as T
            x = value.y as T
        }
    val yy @JvmName("yy") get() = when (this) {
        is Vec4 -> Vec2(y, y)
        is Vec4d -> Vec2d(y, y)
        is Vec4b -> Vec2b(y, y)
        is Vec4i -> Vec2i(y, y)
        is Vec4s -> Vec2s(y, y)
        is Vec4l -> Vec2l(y, y)
        is Vec4ub -> Vec2ub(y, y)
        is Vec4ui -> Vec2ui(y, y)
        is Vec4us -> Vec2us(y, y)
        is Vec4ul -> Vec2ul(y, y)
        else -> throw IllegalStateException()
    }


    val xxx @JvmName("xxx") get() = when (this) {
        is Vec4 -> Vec3(x, x, x)
        is Vec4d -> Vec3d(x, x, x)
        is Vec4b -> Vec3b(x, x, x)
        is Vec4i -> Vec3i(x, x, x)
        is Vec4s -> Vec3s(x, x, x)
        is Vec4l -> Vec3l(x, x, x)
        is Vec4ub -> Vec3ub(x, x, x)
        is Vec4ui -> Vec3ui(x, x, x)
        is Vec4us -> Vec3us(x, x, x)
        is Vec4ul -> Vec3ul(x, x, x)
        else -> throw IllegalStateException()
    }
    val xxy @JvmName("xxy") get() = when (this) {
        is Vec4 -> Vec3(x, x, y)
        is Vec4d -> Vec3d(x, x, y)
        is Vec4b -> Vec3b(x, x, y)
        is Vec4i -> Vec3i(x, x, y)
        is Vec4s -> Vec3s(x, x, y)
        is Vec4l -> Vec3l(x, x, y)
        is Vec4ub -> Vec3ub(x, x, y)
        is Vec4ui -> Vec3ui(x, x, y)
        is Vec4us -> Vec3us(x, x, y)
        is Vec4ul -> Vec3ul(x, x, y)
        else -> throw IllegalStateException()
    }
    val xxz @JvmName("xxz") get() = when (this) {
        is Vec4 -> Vec3(x, x, z)
        is Vec4d -> Vec3d(x, x, z)
        is Vec4b -> Vec3b(x, x, z)
        is Vec4i -> Vec3i(x, x, z)
        is Vec4s -> Vec3s(x, x, z)
        is Vec4l -> Vec3l(x, x, z)
        is Vec4ub -> Vec3ub(x, x, z)
        is Vec4ui -> Vec3ui(x, x, z)
        is Vec4us -> Vec3us(x, x, z)
        is Vec4ul -> Vec3ul(x, x, z)
        else -> throw IllegalStateException()
    }
    val xyx @JvmName("xyx") get() = when (this) {
        is Vec4 -> Vec3(x, y, x)
        is Vec4d -> Vec3d(x, y, x)
        is Vec4b -> Vec3b(x, y, x)
        is Vec4i -> Vec3i(x, y, x)
        is Vec4s -> Vec3s(x, y, x)
        is Vec4l -> Vec3l(x, y, x)
        is Vec4ub -> Vec3ub(x, y, x)
        is Vec4ui -> Vec3ui(x, y, x)
        is Vec4us -> Vec3us(x, y, x)
        is Vec4ul -> Vec3ul(x, y, x)
        else -> throw IllegalStateException()
    }
    val xyy @JvmName("xyy") get() = when (this) {
        is Vec4 -> Vec3(x, y, y)
        is Vec4d -> Vec3d(x, y, y)
        is Vec4b -> Vec3b(x, y, y)
        is Vec4i -> Vec3i(x, y, y)
        is Vec4s -> Vec3s(x, y, y)
        is Vec4l -> Vec3l(x, y, y)
        is Vec4ub -> Vec3ub(x, y, y)
        is Vec4ui -> Vec3ui(x, y, y)
        is Vec4us -> Vec3us(x, y, y)
        is Vec4ul -> Vec3ul(x, y, y)
        else -> throw IllegalStateException()
    }
    var xyz @JvmName("xyz") get() = when (this) {
        is Vec4 -> Vec3(x, y, z)
        is Vec4d -> Vec3d(x, y, z)
        is Vec4b -> Vec3b(x, y, z)
        is Vec4i -> Vec3i(x, y, z)
        is Vec4s -> Vec3s(x, y, z)
        is Vec4l -> Vec3l(x, y, z)
        is Vec4ub -> Vec3ub(x, y, z)
        is Vec4ui -> Vec3ui(x, y, z)
        is Vec4us -> Vec3us(x, y, z)
        is Vec4ul -> Vec3ul(x, y, z)
        else -> throw IllegalStateException()
    }
        @JvmName("xyz") set(value) {
            x = value.x as T
            y = value.y as T
            z = value.z as T
        }
    val xzx @JvmName("xzx") get() = when (this) {
        is Vec4 -> Vec3(x, z, x)
        is Vec4d -> Vec3d(x, z, x)
        is Vec4b -> Vec3b(x, z, x)
        is Vec4i -> Vec3i(x, z, x)
        is Vec4s -> Vec3s(x, z, x)
        is Vec4l -> Vec3l(x, z, x)
        is Vec4ub -> Vec3ub(x, z, x)
        is Vec4ui -> Vec3ui(x, z, x)
        is Vec4us -> Vec3us(x, z, x)
        is Vec4ul -> Vec3ul(x, z, x)
        else -> throw IllegalStateException()
    }
    var xzy @JvmName("xzy") get() = when (this) {
        is Vec4 -> Vec3(x, z, y)
        is Vec4d -> Vec3d(x, z, y)
        is Vec4b -> Vec3b(x, z, y)
        is Vec4i -> Vec3i(x, z, y)
        is Vec4s -> Vec3s(x, z, y)
        is Vec4l -> Vec3l(x, z, y)
        is Vec4ub -> Vec3ub(x, z, y)
        is Vec4ui -> Vec3ui(x, z, y)
        is Vec4us -> Vec3us(x, z, y)
        is Vec4ul -> Vec3ul(x, z, y)
        else -> throw IllegalStateException()
    }
        @JvmName("xzy") set(value) {
            x = value.x as T
            z = value.y as T
            y = value.z as T
        }
    val xzz @JvmName("xzz") get() = when (this) {
        is Vec4 -> Vec3(x, z, z)
        is Vec4d -> Vec3d(x, z, z)
        is Vec4b -> Vec3b(x, z, z)
        is Vec4i -> Vec3i(x, z, z)
        is Vec4s -> Vec3s(x, z, z)
        is Vec4l -> Vec3l(x, z, z)
        is Vec4ub -> Vec3ub(x, z, z)
        is Vec4ui -> Vec3ui(x, z, z)
        is Vec4us -> Vec3us(x, z, z)
        is Vec4ul -> Vec3ul(x, z, z)
        else -> throw IllegalStateException()
    }
    val yxx @JvmName("yxx") get() = when (this) {
        is Vec4 -> Vec3(y, x, x)
        is Vec4d -> Vec3d(y, x, x)
        is Vec4b -> Vec3b(y, x, x)
        is Vec4i -> Vec3i(y, x, x)
        is Vec4s -> Vec3s(y, x, x)
        is Vec4l -> Vec3l(y, x, x)
        is Vec4ub -> Vec3ub(y, x, x)
        is Vec4ui -> Vec3ui(y, x, x)
        is Vec4us -> Vec3us(y, x, x)
        is Vec4ul -> Vec3ul(y, x, x)
        else -> throw IllegalStateException()
    }
    val yxy @JvmName("yxy") get() = when (this) {
        is Vec4 -> Vec3(y, x, y)
        is Vec4d -> Vec3d(y, x, y)
        is Vec4b -> Vec3b(y, x, y)
        is Vec4i -> Vec3i(y, x, y)
        is Vec4s -> Vec3s(y, x, y)
        is Vec4l -> Vec3l(y, x, y)
        is Vec4ub -> Vec3ub(y, x, y)
        is Vec4ui -> Vec3ui(y, x, y)
        is Vec4us -> Vec3us(y, x, y)
        is Vec4ul -> Vec3ul(y, x, y)
        else -> throw IllegalStateException()
    }
    var yxz @JvmName("yxz") get() = when (this) {
        is Vec4 -> Vec3(y, x, z)
        is Vec4d -> Vec3d(y, x, z)
        is Vec4b -> Vec3b(y, x, z)
        is Vec4i -> Vec3i(y, x, z)
        is Vec4s -> Vec3s(y, x, z)
        is Vec4l -> Vec3l(y, x, z)
        is Vec4ub -> Vec3ub(y, x, z)
        is Vec4ui -> Vec3ui(y, x, z)
        is Vec4us -> Vec3us(y, x, z)
        is Vec4ul -> Vec3ul(y, x, z)
        else -> throw IllegalStateException()
    }
        @JvmName("yxz") set(value) {
            y = value.x as T
            x = value.y as T
            z = value.z as T
        }
    val yyx @JvmName("yyx") get() = when (this) {
        is Vec4 -> Vec3(y, y, x)
        is Vec4d -> Vec3d(y, y, x)
        is Vec4b -> Vec3b(y, y, x)
        is Vec4i -> Vec3i(y, y, x)
        is Vec4s -> Vec3s(y, y, x)
        is Vec4l -> Vec3l(y, y, x)
        is Vec4ub -> Vec3ub(y, y, x)
        is Vec4ui -> Vec3ui(y, y, x)
        is Vec4us -> Vec3us(y, y, x)
        is Vec4ul -> Vec3ul(y, y, x)
        else -> throw IllegalStateException()
    }
    val yyy @JvmName("yyy") get() = when (this) {
        is Vec4 -> Vec3(y, y, y)
        is Vec4d -> Vec3d(y, y, y)
        is Vec4b -> Vec3b(y, y, y)
        is Vec4i -> Vec3i(y, y, y)
        is Vec4s -> Vec3s(y, y, y)
        is Vec4l -> Vec3l(y, y, y)
        is Vec4ub -> Vec3ub(y, y, y)
        is Vec4ui -> Vec3ui(y, y, y)
        is Vec4us -> Vec3us(y, y, y)
        is Vec4ul -> Vec3ul(y, y, y)
        else -> throw IllegalStateException()
    }
    val yyz @JvmName("yyz") get() = when (this) {
        is Vec4 -> Vec3(y, y, z)
        is Vec4d -> Vec3d(y, y, z)
        is Vec4b -> Vec3b(y, y, z)
        is Vec4i -> Vec3i(y, y, z)
        is Vec4s -> Vec3s(y, y, z)
        is Vec4l -> Vec3l(y, y, z)
        is Vec4ub -> Vec3ub(y, y, z)
        is Vec4ui -> Vec3ui(y, y, z)
        is Vec4us -> Vec3us(y, y, z)
        is Vec4ul -> Vec3ul(y, y, z)
        else -> throw IllegalStateException()
    }
    var yzx @JvmName("yzx") get() = when (this) {
        is Vec4 -> Vec3(y, z, x)
        is Vec4d -> Vec3d(y, z, x)
        is Vec4b -> Vec3b(y, z, x)
        is Vec4i -> Vec3i(y, z, x)
        is Vec4s -> Vec3s(y, z, x)
        is Vec4l -> Vec3l(y, z, x)
        is Vec4ub -> Vec3ub(y, z, x)
        is Vec4ui -> Vec3ui(y, z, x)
        is Vec4us -> Vec3us(y, z, x)
        is Vec4ul -> Vec3ul(y, z, x)
        else -> throw IllegalStateException()
    }
        @JvmName("xzx") set(value) {
            y = value.x as T
            z = value.y as T
            x = value.z as T
        }
    val yzy @JvmName("yzy") get() = when (this) {
        is Vec4 -> Vec3(y, z, y)
        is Vec4d -> Vec3d(y, z, y)
        is Vec4b -> Vec3b(y, z, y)
        is Vec4i -> Vec3i(y, z, y)
        is Vec4s -> Vec3s(y, z, y)
        is Vec4l -> Vec3l(y, z, y)
        is Vec4ub -> Vec3ub(y, z, y)
        is Vec4ui -> Vec3ui(y, z, y)
        is Vec4us -> Vec3us(y, z, y)
        is Vec4ul -> Vec3ul(y, z, y)
        else -> throw IllegalStateException()
    }
    val yzz @JvmName("yzz") get() = when (this) {
        is Vec4 -> Vec3(y, z, z)
        is Vec4d -> Vec3d(y, z, z)
        is Vec4b -> Vec3b(y, z, z)
        is Vec4i -> Vec3i(y, z, z)
        is Vec4s -> Vec3s(y, z, z)
        is Vec4l -> Vec3l(y, z, z)
        is Vec4ub -> Vec3ub(y, z, z)
        is Vec4ui -> Vec3ui(y, z, z)
        is Vec4us -> Vec3us(y, z, z)
        is Vec4ul -> Vec3ul(y, z, z)
        else -> throw IllegalStateException()
    }
    val zxx @JvmName("zxx") get() = when (this) {
        is Vec4 -> Vec3(z, x, x)
        is Vec4d -> Vec3d(z, x, x)
        is Vec4b -> Vec3b(z, x, x)
        is Vec4i -> Vec3i(z, x, x)
        is Vec4s -> Vec3s(z, x, x)
        is Vec4l -> Vec3l(z, x, x)
        is Vec4ub -> Vec3ub(z, x, x)
        is Vec4ui -> Vec3ui(z, x, x)
        is Vec4us -> Vec3us(z, x, x)
        is Vec4ul -> Vec3ul(z, x, x)
        else -> throw IllegalStateException()
    }
    var zxy @JvmName("zxy") get() = when (this) {
        is Vec4 -> Vec3(z, x, y)
        is Vec4d -> Vec3d(z, x, y)
        is Vec4b -> Vec3b(z, x, y)
        is Vec4i -> Vec3i(z, x, y)
        is Vec4s -> Vec3s(z, x, y)
        is Vec4l -> Vec3l(z, x, y)
        is Vec4ub -> Vec3ub(z, x, y)
        is Vec4ui -> Vec3ui(z, x, y)
        is Vec4us -> Vec3us(z, x, y)
        is Vec4ul -> Vec3ul(z, x, y)
        else -> throw IllegalStateException()
    }
        @JvmName("zxy") set(value) {
            z = value.x as T
            x = value.y as T
            y = value.z as T
        }
    val zxz @JvmName("zxz") get() = when (this) {
        is Vec4 -> Vec3(z, x, z)
        is Vec4d -> Vec3d(z, x, z)
        is Vec4b -> Vec3b(z, x, z)
        is Vec4i -> Vec3i(z, x, z)
        is Vec4s -> Vec3s(z, x, z)
        is Vec4l -> Vec3l(z, x, z)
        is Vec4ub -> Vec3ub(z, x, z)
        is Vec4ui -> Vec3ui(z, x, z)
        is Vec4us -> Vec3us(z, x, z)
        is Vec4ul -> Vec3ul(z, x, z)
        else -> throw IllegalStateException()
    }
    var zyx @JvmName("zyx") get() = when (this) {
        is Vec4 -> Vec3(z, y, x)
        is Vec4d -> Vec3d(z, y, x)
        is Vec4b -> Vec3b(z, y, x)
        is Vec4i -> Vec3i(z, y, x)
        is Vec4s -> Vec3s(z, y, x)
        is Vec4l -> Vec3l(z, y, x)
        is Vec4ub -> Vec3ub(z, y, x)
        is Vec4ui -> Vec3ui(z, y, x)
        is Vec4us -> Vec3us(z, y, x)
        is Vec4ul -> Vec3ul(z, y, x)
        else -> throw IllegalStateException()
    }
        @JvmName("zyx") set(value) {
            z = value.x as T
            y = value.y as T
            x = value.z as T
        }
    val zyy @JvmName("zyy") get() = when (this) {
        is Vec4 -> Vec3(z, y, y)
        is Vec4d -> Vec3d(z, y, y)
        is Vec4b -> Vec3b(z, y, y)
        is Vec4i -> Vec3i(z, y, y)
        is Vec4s -> Vec3s(z, y, y)
        is Vec4l -> Vec3l(z, y, y)
        is Vec4ub -> Vec3ub(z, y, y)
        is Vec4ui -> Vec3ui(z, y, y)
        is Vec4us -> Vec3us(z, y, y)
        is Vec4ul -> Vec3ul(z, y, y)
        else -> throw IllegalStateException()
    }
    val zyz @JvmName("zyz") get() = when (this) {
        is Vec4 -> Vec3(z, y, z)
        is Vec4d -> Vec3d(z, y, z)
        is Vec4b -> Vec3b(z, y, z)
        is Vec4i -> Vec3i(z, y, z)
        is Vec4s -> Vec3s(z, y, z)
        is Vec4l -> Vec3l(z, y, z)
        is Vec4ub -> Vec3ub(z, y, z)
        is Vec4ui -> Vec3ui(z, y, z)
        is Vec4us -> Vec3us(z, y, z)
        is Vec4ul -> Vec3ul(z, y, z)
        else -> throw IllegalStateException()
    }
    val zzx @JvmName("zzx") get() = when (this) {
        is Vec4 -> Vec3(z, z, x)
        is Vec4d -> Vec3d(z, z, x)
        is Vec4b -> Vec3b(z, z, x)
        is Vec4i -> Vec3i(z, z, x)
        is Vec4s -> Vec3s(z, z, x)
        is Vec4l -> Vec3l(z, z, x)
        is Vec4ub -> Vec3ub(z, z, x)
        is Vec4ui -> Vec3ui(z, z, x)
        is Vec4us -> Vec3us(z, z, x)
        is Vec4ul -> Vec3ul(z, z, x)
        else -> throw IllegalStateException()
    }
    val zzy @JvmName("zzy") get() = when (this) {
        is Vec4 -> Vec3(z, z, y)
        is Vec4d -> Vec3d(z, z, y)
        is Vec4b -> Vec3b(z, z, y)
        is Vec4i -> Vec3i(z, z, y)
        is Vec4s -> Vec3s(z, z, y)
        is Vec4l -> Vec3l(z, z, y)
        is Vec4ub -> Vec3ub(z, z, y)
        is Vec4ui -> Vec3ui(z, z, y)
        is Vec4us -> Vec3us(z, z, y)
        is Vec4ul -> Vec3ul(z, z, y)
        else -> throw IllegalStateException()
    }
    val zzz @JvmName("zzz") get() = when (this) {
        is Vec4 -> Vec3(z, z, z)
        is Vec4d -> Vec3d(z, z, z)
        is Vec4b -> Vec3b(z, z, z)
        is Vec4i -> Vec3i(z, z, z)
        is Vec4s -> Vec3s(z, z, z)
        is Vec4l -> Vec3l(z, z, z)
        is Vec4ub -> Vec3ub(z, z, z)
        is Vec4ui -> Vec3ui(z, z, z)
        is Vec4us -> Vec3us(z, z, z)
        is Vec4ul -> Vec3ul(z, z, z)
        else -> throw IllegalStateException()
    }


    val xxxx @JvmName("xxxx") get() = when (this) {
        is Vec4 -> Vec4(x, x, x, x)
        is Vec4d -> Vec4d(x, x, x, x)
        is Vec4b -> Vec4b(x, x, x, x)
        is Vec4i -> Vec4i(x, x, x, x)
        is Vec4s -> Vec4s(x, x, x, x)
        is Vec4l -> Vec4l(x, x, x, x)
        is Vec4ub -> Vec4ub(x, x, x, x)
        is Vec4ui -> Vec4ui(x, x, x, x)
        is Vec4us -> Vec4us(x, x, x, x)
        is Vec4ul -> Vec4ul(x, x, x, x)
        else -> throw IllegalStateException()
    }
    val xxxy @JvmName("xxxy") get() = when (this) {
        is Vec4 -> Vec4(x, x, x, y)
        is Vec4d -> Vec4d(x, x, x, y)
        is Vec4b -> Vec4b(x, x, x, y)
        is Vec4i -> Vec4i(x, x, x, y)
        is Vec4s -> Vec4s(x, x, x, y)
        is Vec4l -> Vec4l(x, x, x, y)
        is Vec4ub -> Vec4ub(x, x, x, y)
        is Vec4ui -> Vec4ui(x, x, x, y)
        is Vec4us -> Vec4us(x, x, x, y)
        is Vec4ul -> Vec4ul(x, x, x, y)
        else -> throw IllegalStateException()
    }
    val xxxz @JvmName("xxxz") get() = when (this) {
        is Vec4 -> Vec4(x, x, x, z)
        is Vec4d -> Vec4d(x, x, x, z)
        is Vec4b -> Vec4b(x, x, x, z)
        is Vec4i -> Vec4i(x, x, x, z)
        is Vec4s -> Vec4s(x, x, x, z)
        is Vec4l -> Vec4l(x, x, x, z)
        is Vec4ub -> Vec4ub(x, x, x, z)
        is Vec4ui -> Vec4ui(x, x, x, z)
        is Vec4us -> Vec4us(x, x, x, z)
        is Vec4ul -> Vec4ul(x, x, x, z)
        else -> throw IllegalStateException()
    }
    val xxxw @JvmName("xxxw") get() = when (this) {
        is Vec4 -> Vec4(x, x, x, w)
        is Vec4d -> Vec4d(x, x, x, w)
        is Vec4b -> Vec4b(x, x, x, w)
        is Vec4i -> Vec4i(x, x, x, w)
        is Vec4s -> Vec4s(x, x, x, w)
        is Vec4l -> Vec4l(x, x, x, w)
        is Vec4ub -> Vec4ub(x, x, x, w)
        is Vec4ui -> Vec4ui(x, x, x, w)
        is Vec4us -> Vec4us(x, x, x, w)
        is Vec4ul -> Vec4ul(x, x, x, w)
        else -> throw IllegalStateException()
    }
    val xxyx @JvmName("xxyx") get() = when (this) {
        is Vec4 -> Vec4(x, x, y, x)
        is Vec4d -> Vec4d(x, x, y, x)
        is Vec4b -> Vec4b(x, x, y, x)
        is Vec4i -> Vec4i(x, x, y, x)
        is Vec4s -> Vec4s(x, x, y, x)
        is Vec4l -> Vec4l(x, x, y, x)
        is Vec4ub -> Vec4ub(x, x, y, x)
        is Vec4ui -> Vec4ui(x, x, y, x)
        is Vec4us -> Vec4us(x, x, y, x)
        is Vec4ul -> Vec4ul(x, x, y, x)
        else -> throw IllegalStateException()
    }
    val xxyy @JvmName("xxyy") get() = when (this) {
        is Vec4 -> Vec4(x, x, y, y)
        is Vec4d -> Vec4d(x, x, y, y)
        is Vec4b -> Vec4b(x, x, y, y)
        is Vec4i -> Vec4i(x, x, y, y)
        is Vec4s -> Vec4s(x, x, y, y)
        is Vec4l -> Vec4l(x, x, y, y)
        is Vec4ub -> Vec4ub(x, x, y, y)
        is Vec4ui -> Vec4ui(x, x, y, y)
        is Vec4us -> Vec4us(x, x, y, y)
        is Vec4ul -> Vec4ul(x, x, y, y)
        else -> throw IllegalStateException()
    }
    val xxyz @JvmName("xxyz") get() = when (this) {
        is Vec4 -> Vec4(x, x, y, z)
        is Vec4d -> Vec4d(x, x, y, z)
        is Vec4b -> Vec4b(x, x, y, z)
        is Vec4i -> Vec4i(x, x, y, z)
        is Vec4s -> Vec4s(x, x, y, z)
        is Vec4l -> Vec4l(x, x, y, z)
        is Vec4ub -> Vec4ub(x, x, y, z)
        is Vec4ui -> Vec4ui(x, x, y, z)
        is Vec4us -> Vec4us(x, x, y, z)
        is Vec4ul -> Vec4ul(x, x, y, z)
        else -> throw IllegalStateException()
    }
    val xxyw @JvmName("xxyw") get() = when (this) {
        is Vec4 -> Vec4(x, x, y, w)
        is Vec4d -> Vec4d(x, x, y, w)
        is Vec4b -> Vec4b(x, x, y, w)
        is Vec4i -> Vec4i(x, x, y, w)
        is Vec4s -> Vec4s(x, x, y, w)
        is Vec4l -> Vec4l(x, x, y, w)
        is Vec4ub -> Vec4ub(x, x, y, w)
        is Vec4ui -> Vec4ui(x, x, y, w)
        is Vec4us -> Vec4us(x, x, y, w)
        is Vec4ul -> Vec4ul(x, x, y, w)
        else -> throw IllegalStateException()
    }
    val xxzx @JvmName("xxzx") get() = when (this) {
        is Vec4 -> Vec4(x, x, z, x)
        is Vec4d -> Vec4d(x, x, z, x)
        is Vec4b -> Vec4b(x, x, z, x)
        is Vec4i -> Vec4i(x, x, z, x)
        is Vec4s -> Vec4s(x, x, z, x)
        is Vec4l -> Vec4l(x, x, z, x)
        is Vec4ub -> Vec4ub(x, x, z, x)
        is Vec4ui -> Vec4ui(x, x, z, x)
        is Vec4us -> Vec4us(x, x, z, x)
        is Vec4ul -> Vec4ul(x, x, z, x)
        else -> throw IllegalStateException()
    }
    val xxzy @JvmName("xxzy") get() = when (this) {
        is Vec4 -> Vec4(x, x, z, y)
        is Vec4d -> Vec4d(x, x, z, y)
        is Vec4b -> Vec4b(x, x, z, y)
        is Vec4i -> Vec4i(x, x, z, y)
        is Vec4s -> Vec4s(x, x, z, y)
        is Vec4l -> Vec4l(x, x, z, y)
        is Vec4ub -> Vec4ub(x, x, z, y)
        is Vec4ui -> Vec4ui(x, x, z, y)
        is Vec4us -> Vec4us(x, x, z, y)
        is Vec4ul -> Vec4ul(x, x, z, y)
        else -> throw IllegalStateException()
    }
    val xxzz @JvmName("xxzz") get() = when (this) {
        is Vec4 -> Vec4(x, x, z, z)
        is Vec4d -> Vec4d(x, x, z, z)
        is Vec4b -> Vec4b(x, x, z, z)
        is Vec4i -> Vec4i(x, x, z, z)
        is Vec4s -> Vec4s(x, x, z, z)
        is Vec4l -> Vec4l(x, x, z, z)
        is Vec4ub -> Vec4ub(x, x, z, z)
        is Vec4ui -> Vec4ui(x, x, z, z)
        is Vec4us -> Vec4us(x, x, z, z)
        is Vec4ul -> Vec4ul(x, x, z, z)
        else -> throw IllegalStateException()
    }
    val xxzw @JvmName("xxzw") get() = when (this) {
        is Vec4 -> Vec4(x, x, z, w)
        is Vec4d -> Vec4d(x, x, z, w)
        is Vec4b -> Vec4b(x, x, z, w)
        is Vec4i -> Vec4i(x, x, z, w)
        is Vec4s -> Vec4s(x, x, z, w)
        is Vec4l -> Vec4l(x, x, z, w)
        is Vec4ub -> Vec4ub(x, x, z, w)
        is Vec4ui -> Vec4ui(x, x, z, w)
        is Vec4us -> Vec4us(x, x, z, w)
        is Vec4ul -> Vec4ul(x, x, z, w)
        else -> throw IllegalStateException()
    }
    val xxwx @JvmName("xxwx") get() = when (this) {
        is Vec4 -> Vec4(x, x, w, x)
        is Vec4d -> Vec4d(x, x, w, x)
        is Vec4b -> Vec4b(x, x, w, x)
        is Vec4i -> Vec4i(x, x, w, x)
        is Vec4s -> Vec4s(x, x, w, x)
        is Vec4l -> Vec4l(x, x, w, x)
        is Vec4ub -> Vec4ub(x, x, w, x)
        is Vec4ui -> Vec4ui(x, x, w, x)
        is Vec4us -> Vec4us(x, x, w, x)
        is Vec4ul -> Vec4ul(x, x, w, x)
        else -> throw IllegalStateException()
    }
    val xxwy @JvmName("xxwy") get() = when (this) {
        is Vec4 -> Vec4(x, x, w, y)
        is Vec4d -> Vec4d(x, x, w, y)
        is Vec4b -> Vec4b(x, x, w, y)
        is Vec4i -> Vec4i(x, x, w, y)
        is Vec4s -> Vec4s(x, x, w, y)
        is Vec4l -> Vec4l(x, x, w, y)
        is Vec4ub -> Vec4ub(x, x, w, y)
        is Vec4ui -> Vec4ui(x, x, w, y)
        is Vec4us -> Vec4us(x, x, w, y)
        is Vec4ul -> Vec4ul(x, x, w, y)
        else -> throw IllegalStateException()
    }
    val xxwz @JvmName("xxwz") get() = when (this) {
        is Vec4 -> Vec4(x, x, w, z)
        is Vec4d -> Vec4d(x, x, w, z)
        is Vec4b -> Vec4b(x, x, w, z)
        is Vec4i -> Vec4i(x, x, w, z)
        is Vec4s -> Vec4s(x, x, w, z)
        is Vec4l -> Vec4l(x, x, w, z)
        is Vec4ub -> Vec4ub(x, x, w, z)
        is Vec4ui -> Vec4ui(x, x, w, z)
        is Vec4us -> Vec4us(x, x, w, z)
        is Vec4ul -> Vec4ul(x, x, w, z)
        else -> throw IllegalStateException()
    }
    val xxww @JvmName("xxww") get() = when (this) {
        is Vec4 -> Vec4(x, x, w, w)
        is Vec4d -> Vec4d(x, x, w, w)
        is Vec4b -> Vec4b(x, x, w, w)
        is Vec4i -> Vec4i(x, x, w, w)
        is Vec4s -> Vec4s(x, x, w, w)
        is Vec4l -> Vec4l(x, x, w, w)
        is Vec4ub -> Vec4ub(x, x, w, w)
        is Vec4ui -> Vec4ui(x, x, w, w)
        is Vec4us -> Vec4us(x, x, w, w)
        is Vec4ul -> Vec4ul(x, x, w, w)
        else -> throw IllegalStateException()
    }
    val xyxx @JvmName("xyxx") get() = when (this) {
        is Vec4 -> Vec4(x, y, x, x)
        is Vec4d -> Vec4d(x, y, x, x)
        is Vec4b -> Vec4b(x, y, x, x)
        is Vec4i -> Vec4i(x, y, x, x)
        is Vec4s -> Vec4s(x, y, x, x)
        is Vec4l -> Vec4l(x, y, x, x)
        is Vec4ub -> Vec4ub(x, y, x, x)
        is Vec4ui -> Vec4ui(x, y, x, x)
        is Vec4us -> Vec4us(x, y, x, x)
        is Vec4ul -> Vec4ul(x, y, x, x)
        else -> throw IllegalStateException()
    }
    val xyxy @JvmName("xyxy") get() = when (this) {
        is Vec4 -> Vec4(x, y, x, y)
        is Vec4d -> Vec4d(x, y, x, y)
        is Vec4b -> Vec4b(x, y, x, y)
        is Vec4i -> Vec4i(x, y, x, y)
        is Vec4s -> Vec4s(x, y, x, y)
        is Vec4l -> Vec4l(x, y, x, y)
        is Vec4ub -> Vec4ub(x, y, x, y)
        is Vec4ui -> Vec4ui(x, y, x, y)
        is Vec4us -> Vec4us(x, y, x, y)
        is Vec4ul -> Vec4ul(x, y, x, y)
        else -> throw IllegalStateException()
    }
    val xyxz @JvmName("xyxz") get() = when (this) {
        is Vec4 -> Vec4(x, y, x, z)
        is Vec4d -> Vec4d(x, y, x, z)
        is Vec4b -> Vec4b(x, y, x, z)
        is Vec4i -> Vec4i(x, y, x, z)
        is Vec4s -> Vec4s(x, y, x, z)
        is Vec4l -> Vec4l(x, y, x, z)
        is Vec4ub -> Vec4ub(x, y, x, z)
        is Vec4ui -> Vec4ui(x, y, x, z)
        is Vec4us -> Vec4us(x, y, x, z)
        is Vec4ul -> Vec4ul(x, y, x, z)
        else -> throw IllegalStateException()
    }
    val xyxw @JvmName("xyxw") get() = when (this) {
        is Vec4 -> Vec4(x, y, x, w)
        is Vec4d -> Vec4d(x, y, x, w)
        is Vec4b -> Vec4b(x, y, x, w)
        is Vec4i -> Vec4i(x, y, x, w)
        is Vec4s -> Vec4s(x, y, x, w)
        is Vec4l -> Vec4l(x, y, x, w)
        is Vec4ub -> Vec4ub(x, y, x, w)
        is Vec4ui -> Vec4ui(x, y, x, w)
        is Vec4us -> Vec4us(x, y, x, w)
        is Vec4ul -> Vec4ul(x, y, x, w)
        else -> throw IllegalStateException()
    }
    val xyyx @JvmName("xyyx") get() = when (this) {
        is Vec4 -> Vec4(x, y, y, x)
        is Vec4d -> Vec4d(x, y, y, x)
        is Vec4b -> Vec4b(x, y, y, x)
        is Vec4i -> Vec4i(x, y, y, x)
        is Vec4s -> Vec4s(x, y, y, x)
        is Vec4l -> Vec4l(x, y, y, x)
        is Vec4ub -> Vec4ub(x, y, y, x)
        is Vec4ui -> Vec4ui(x, y, y, x)
        is Vec4us -> Vec4us(x, y, y, x)
        is Vec4ul -> Vec4ul(x, y, y, x)
        else -> throw IllegalStateException()
    }
    val xyyy @JvmName("xyyy") get() = when (this) {
        is Vec4 -> Vec4(x, y, y, y)
        is Vec4d -> Vec4d(x, y, y, y)
        is Vec4b -> Vec4b(x, y, y, y)
        is Vec4i -> Vec4i(x, y, y, y)
        is Vec4s -> Vec4s(x, y, y, y)
        is Vec4l -> Vec4l(x, y, y, y)
        is Vec4ub -> Vec4ub(x, y, y, y)
        is Vec4ui -> Vec4ui(x, y, y, y)
        is Vec4us -> Vec4us(x, y, y, y)
        is Vec4ul -> Vec4ul(x, y, y, y)
        else -> throw IllegalStateException()
    }
    val xyyz @JvmName("xyyz") get() = when (this) {
        is Vec4 -> Vec4(x, y, y, z)
        is Vec4d -> Vec4d(x, y, y, z)
        is Vec4b -> Vec4b(x, y, y, z)
        is Vec4i -> Vec4i(x, y, y, z)
        is Vec4s -> Vec4s(x, y, y, z)
        is Vec4l -> Vec4l(x, y, y, z)
        is Vec4ub -> Vec4ub(x, y, y, z)
        is Vec4ui -> Vec4ui(x, y, y, z)
        is Vec4us -> Vec4us(x, y, y, z)
        is Vec4ul -> Vec4ul(x, y, y, z)
        else -> throw IllegalStateException()
    }
    val xyyw @JvmName("xyyw") get() = when (this) {
        is Vec4 -> Vec4(x, y, y, w)
        is Vec4d -> Vec4d(x, y, y, w)
        is Vec4b -> Vec4b(x, y, y, w)
        is Vec4i -> Vec4i(x, y, y, w)
        is Vec4s -> Vec4s(x, y, y, w)
        is Vec4l -> Vec4l(x, y, y, w)
        is Vec4ub -> Vec4ub(x, y, y, w)
        is Vec4ui -> Vec4ui(x, y, y, w)
        is Vec4us -> Vec4us(x, y, y, w)
        is Vec4ul -> Vec4ul(x, y, y, w)
        else -> throw IllegalStateException()
    }
    val xyzx @JvmName("xyzx") get() = when (this) {
        is Vec4 -> Vec4(x, y, z, x)
        is Vec4d -> Vec4d(x, y, z, x)
        is Vec4b -> Vec4b(x, y, z, x)
        is Vec4i -> Vec4i(x, y, z, x)
        is Vec4s -> Vec4s(x, y, z, x)
        is Vec4l -> Vec4l(x, y, z, x)
        is Vec4ub -> Vec4ub(x, y, z, x)
        is Vec4ui -> Vec4ui(x, y, z, x)
        is Vec4us -> Vec4us(x, y, z, x)
        is Vec4ul -> Vec4ul(x, y, z, x)
        else -> throw IllegalStateException()
    }
    val xyzy @JvmName("xyzy") get() = when (this) {
        is Vec4 -> Vec4(x, y, z, y)
        is Vec4d -> Vec4d(x, y, z, y)
        is Vec4b -> Vec4b(x, y, z, y)
        is Vec4i -> Vec4i(x, y, z, y)
        is Vec4s -> Vec4s(x, y, z, y)
        is Vec4l -> Vec4l(x, y, z, y)
        is Vec4ub -> Vec4ub(x, y, z, y)
        is Vec4ui -> Vec4ui(x, y, z, y)
        is Vec4us -> Vec4us(x, y, z, y)
        is Vec4ul -> Vec4ul(x, y, z, y)
        else -> throw IllegalStateException()
    }
    val xyzz @JvmName("xyzz") get() = when (this) {
        is Vec4 -> Vec4(x, y, z, z)
        is Vec4d -> Vec4d(x, y, z, z)
        is Vec4b -> Vec4b(x, y, z, z)
        is Vec4i -> Vec4i(x, y, z, z)
        is Vec4s -> Vec4s(x, y, z, z)
        is Vec4l -> Vec4l(x, y, z, z)
        is Vec4ub -> Vec4ub(x, y, z, z)
        is Vec4ui -> Vec4ui(x, y, z, z)
        is Vec4us -> Vec4us(x, y, z, z)
        is Vec4ul -> Vec4ul(x, y, z, z)
        else -> throw IllegalStateException()
    }
    var xyzw @JvmName("xyzw") get() = when (this) {
        is Vec4 -> Vec4(x, y, z, w)
        is Vec4d -> Vec4d(x, y, z, w)
        is Vec4b -> Vec4b(x, y, z, w)
        is Vec4i -> Vec4i(x, y, z, w)
        is Vec4s -> Vec4s(x, y, z, w)
        is Vec4l -> Vec4l(x, y, z, w)
        is Vec4ub -> Vec4ub(x, y, z, w)
        is Vec4ui -> Vec4ui(x, y, z, w)
        is Vec4us -> Vec4us(x, y, z, w)
        is Vec4ul -> Vec4ul(x, y, z, w)
        else -> throw IllegalStateException()
    }
        @JvmName("xyzw") set(value) {
            x = value.x as T
            y = value.y as T
            z = value.z as T
            w = value.w as T
        }
    val xywx @JvmName("xywx") get() = when (this) {
        is Vec4 -> Vec4(x, y, w, x)
        is Vec4d -> Vec4d(x, y, w, x)
        is Vec4b -> Vec4b(x, y, w, x)
        is Vec4i -> Vec4i(x, y, w, x)
        is Vec4s -> Vec4s(x, y, w, x)
        is Vec4l -> Vec4l(x, y, w, x)
        is Vec4ub -> Vec4ub(x, y, w, x)
        is Vec4ui -> Vec4ui(x, y, w, x)
        is Vec4us -> Vec4us(x, y, w, x)
        is Vec4ul -> Vec4ul(x, y, w, x)
        else -> throw IllegalStateException()
    }
    val xywy @JvmName("xywy") get() = when (this) {
        is Vec4 -> Vec4(x, y, w, y)
        is Vec4d -> Vec4d(x, y, w, y)
        is Vec4b -> Vec4b(x, y, w, y)
        is Vec4i -> Vec4i(x, y, w, y)
        is Vec4s -> Vec4s(x, y, w, y)
        is Vec4l -> Vec4l(x, y, w, y)
        is Vec4ub -> Vec4ub(x, y, w, y)
        is Vec4ui -> Vec4ui(x, y, w, y)
        is Vec4us -> Vec4us(x, y, w, y)
        is Vec4ul -> Vec4ul(x, y, w, y)
        else -> throw IllegalStateException()
    }
    var xywz @JvmName("xywz") get() = when (this) {
        is Vec4 -> Vec4(x, y, w, z)
        is Vec4d -> Vec4d(x, y, w, z)
        is Vec4b -> Vec4b(x, y, w, z)
        is Vec4i -> Vec4i(x, y, w, z)
        is Vec4s -> Vec4s(x, y, w, z)
        is Vec4l -> Vec4l(x, y, w, z)
        is Vec4ub -> Vec4ub(x, y, w, z)
        is Vec4ui -> Vec4ui(x, y, w, z)
        is Vec4us -> Vec4us(x, y, w, z)
        is Vec4ul -> Vec4ul(x, y, w, z)
        else -> throw IllegalStateException()
    }
        @JvmName("xywz") set(value) {
            x = value.x as T
            y = value.y as T
            w = value.z as T
            z = value.w as T
        }
    val xyww @JvmName("xyww") get() = when (this) {
        is Vec4 -> Vec4(x, y, w, w)
        is Vec4d -> Vec4d(x, y, w, w)
        is Vec4b -> Vec4b(x, y, w, w)
        is Vec4i -> Vec4i(x, y, w, w)
        is Vec4s -> Vec4s(x, y, w, w)
        is Vec4l -> Vec4l(x, y, w, w)
        is Vec4ub -> Vec4ub(x, y, w, w)
        is Vec4ui -> Vec4ui(x, y, w, w)
        is Vec4us -> Vec4us(x, y, w, w)
        is Vec4ul -> Vec4ul(x, y, w, w)
        else -> throw IllegalStateException()
    }
    val xzxx @JvmName("xzxx") get() = when (this) {
        is Vec4 -> Vec4(x, z, x, x)
        is Vec4d -> Vec4d(x, z, x, x)
        is Vec4b -> Vec4b(x, z, x, x)
        is Vec4i -> Vec4i(x, z, x, x)
        is Vec4s -> Vec4s(x, z, x, x)
        is Vec4l -> Vec4l(x, z, x, x)
        is Vec4ub -> Vec4ub(x, z, x, x)
        is Vec4ui -> Vec4ui(x, z, x, x)
        is Vec4us -> Vec4us(x, z, x, x)
        is Vec4ul -> Vec4ul(x, z, x, x)
        else -> throw IllegalStateException()
    }
    val xzxy @JvmName("xzxy") get() = when (this) {
        is Vec4 -> Vec4(x, z, x, y)
        is Vec4d -> Vec4d(x, z, x, y)
        is Vec4b -> Vec4b(x, z, x, y)
        is Vec4i -> Vec4i(x, z, x, y)
        is Vec4s -> Vec4s(x, z, x, y)
        is Vec4l -> Vec4l(x, z, x, y)
        is Vec4ub -> Vec4ub(x, z, x, y)
        is Vec4ui -> Vec4ui(x, z, x, y)
        is Vec4us -> Vec4us(x, z, x, y)
        is Vec4ul -> Vec4ul(x, z, x, y)
        else -> throw IllegalStateException()
    }
    val xzxz @JvmName("xzxz") get() = when (this) {
        is Vec4 -> Vec4(x, z, x, z)
        is Vec4d -> Vec4d(x, z, x, z)
        is Vec4b -> Vec4b(x, z, x, z)
        is Vec4i -> Vec4i(x, z, x, z)
        is Vec4s -> Vec4s(x, z, x, z)
        is Vec4l -> Vec4l(x, z, x, z)
        is Vec4ub -> Vec4ub(x, z, x, z)
        is Vec4ui -> Vec4ui(x, z, x, z)
        is Vec4us -> Vec4us(x, z, x, z)
        is Vec4ul -> Vec4ul(x, z, x, z)
        else -> throw IllegalStateException()
    }
    val xzxw @JvmName("xzxw") get() = when (this) {
        is Vec4 -> Vec4(x, z, x, w)
        is Vec4d -> Vec4d(x, z, x, w)
        is Vec4b -> Vec4b(x, z, x, w)
        is Vec4i -> Vec4i(x, z, x, w)
        is Vec4s -> Vec4s(x, z, x, w)
        is Vec4l -> Vec4l(x, z, x, w)
        is Vec4ub -> Vec4ub(x, z, x, w)
        is Vec4ui -> Vec4ui(x, z, x, w)
        is Vec4us -> Vec4us(x, z, x, w)
        is Vec4ul -> Vec4ul(x, z, x, w)
        else -> throw IllegalStateException()
    }
    val xzyx @JvmName("xzyx") get() = when (this) {
        is Vec4 -> Vec4(x, z, y, x)
        is Vec4d -> Vec4d(x, z, y, x)
        is Vec4b -> Vec4b(x, z, y, x)
        is Vec4i -> Vec4i(x, z, y, x)
        is Vec4s -> Vec4s(x, z, y, x)
        is Vec4l -> Vec4l(x, z, y, x)
        is Vec4ub -> Vec4ub(x, z, y, x)
        is Vec4ui -> Vec4ui(x, z, y, x)
        is Vec4us -> Vec4us(x, z, y, x)
        is Vec4ul -> Vec4ul(x, z, y, x)
        else -> throw IllegalStateException()
    }
    val xzyy @JvmName("xzyy") get() = when (this) {
        is Vec4 -> Vec4(x, z, y, y)
        is Vec4d -> Vec4d(x, z, y, y)
        is Vec4b -> Vec4b(x, z, y, y)
        is Vec4i -> Vec4i(x, z, y, y)
        is Vec4s -> Vec4s(x, z, y, y)
        is Vec4l -> Vec4l(x, z, y, y)
        is Vec4ub -> Vec4ub(x, z, y, y)
        is Vec4ui -> Vec4ui(x, z, y, y)
        is Vec4us -> Vec4us(x, z, y, y)
        is Vec4ul -> Vec4ul(x, z, y, y)
        else -> throw IllegalStateException()
    }
    val xzyz @JvmName("xzyz") get() = when (this) {
        is Vec4 -> Vec4(x, z, y, z)
        is Vec4d -> Vec4d(x, z, y, z)
        is Vec4b -> Vec4b(x, z, y, z)
        is Vec4i -> Vec4i(x, z, y, z)
        is Vec4s -> Vec4s(x, z, y, z)
        is Vec4l -> Vec4l(x, z, y, z)
        is Vec4ub -> Vec4ub(x, z, y, z)
        is Vec4ui -> Vec4ui(x, z, y, z)
        is Vec4us -> Vec4us(x, z, y, z)
        is Vec4ul -> Vec4ul(x, z, y, z)
        else -> throw IllegalStateException()
    }
    var xzyw @JvmName("xzyw") get() = when (this) {
        is Vec4 -> Vec4(x, z, y, w)
        is Vec4d -> Vec4d(x, z, y, w)
        is Vec4b -> Vec4b(x, z, y, w)
        is Vec4i -> Vec4i(x, z, y, w)
        is Vec4s -> Vec4s(x, z, y, w)
        is Vec4l -> Vec4l(x, z, y, w)
        is Vec4ub -> Vec4ub(x, z, y, w)
        is Vec4ui -> Vec4ui(x, z, y, w)
        is Vec4us -> Vec4us(x, z, y, w)
        is Vec4ul -> Vec4ul(x, z, y, w)
        else -> throw IllegalStateException()
    }
        @JvmName("xzyw") set(value) {
            x = value.x as T
            z = value.y as T
            y = value.z as T
            w = value.w as T
        }
    val xzzx @JvmName("xzzx") get() = when (this) {
        is Vec4 -> Vec4(x, z, z, x)
        is Vec4d -> Vec4d(x, z, z, x)
        is Vec4b -> Vec4b(x, z, z, x)
        is Vec4i -> Vec4i(x, z, z, x)
        is Vec4s -> Vec4s(x, z, z, x)
        is Vec4l -> Vec4l(x, z, z, x)
        is Vec4ub -> Vec4ub(x, z, z, x)
        is Vec4ui -> Vec4ui(x, z, z, x)
        is Vec4us -> Vec4us(x, z, z, x)
        is Vec4ul -> Vec4ul(x, z, z, x)
        else -> throw IllegalStateException()
    }
    val xzzy @JvmName("xzzy") get() = when (this) {
        is Vec4 -> Vec4(x, z, z, y)
        is Vec4d -> Vec4d(x, z, z, y)
        is Vec4b -> Vec4b(x, z, z, y)
        is Vec4i -> Vec4i(x, z, z, y)
        is Vec4s -> Vec4s(x, z, z, y)
        is Vec4l -> Vec4l(x, z, z, y)
        is Vec4ub -> Vec4ub(x, z, z, y)
        is Vec4ui -> Vec4ui(x, z, z, y)
        is Vec4us -> Vec4us(x, z, z, y)
        is Vec4ul -> Vec4ul(x, z, z, y)
        else -> throw IllegalStateException()
    }
    val xzzz @JvmName("xzzz") get() = when (this) {
        is Vec4 -> Vec4(x, z, z, z)
        is Vec4d -> Vec4d(x, z, z, z)
        is Vec4b -> Vec4b(x, z, z, z)
        is Vec4i -> Vec4i(x, z, z, z)
        is Vec4s -> Vec4s(x, z, z, z)
        is Vec4l -> Vec4l(x, z, z, z)
        is Vec4ub -> Vec4ub(x, z, z, z)
        is Vec4ui -> Vec4ui(x, z, z, z)
        is Vec4us -> Vec4us(x, z, z, z)
        is Vec4ul -> Vec4ul(x, z, z, z)
        else -> throw IllegalStateException()
    }
    val xzzw @JvmName("xzzw") get() = when (this) {
        is Vec4 -> Vec4(x, z, z, w)
        is Vec4d -> Vec4d(x, z, z, w)
        is Vec4b -> Vec4b(x, z, z, w)
        is Vec4i -> Vec4i(x, z, z, w)
        is Vec4s -> Vec4s(x, z, z, w)
        is Vec4l -> Vec4l(x, z, z, w)
        is Vec4ub -> Vec4ub(x, z, z, w)
        is Vec4ui -> Vec4ui(x, z, z, w)
        is Vec4us -> Vec4us(x, z, z, w)
        is Vec4ul -> Vec4ul(x, z, z, w)
        else -> throw IllegalStateException()
    }
    val xzwx @JvmName("xzwx") get() = when (this) {
        is Vec4 -> Vec4(x, z, w, x)
        is Vec4d -> Vec4d(x, z, w, x)
        is Vec4b -> Vec4b(x, z, w, x)
        is Vec4i -> Vec4i(x, z, w, x)
        is Vec4s -> Vec4s(x, z, w, x)
        is Vec4l -> Vec4l(x, z, w, x)
        is Vec4ub -> Vec4ub(x, z, w, x)
        is Vec4ui -> Vec4ui(x, z, w, x)
        is Vec4us -> Vec4us(x, z, w, x)
        is Vec4ul -> Vec4ul(x, z, w, x)
        else -> throw IllegalStateException()
    }
    var xzwy @JvmName("xzwy") get() = when (this) {
        is Vec4 -> Vec4(x, z, w, y)
        is Vec4d -> Vec4d(x, z, w, y)
        is Vec4b -> Vec4b(x, z, w, y)
        is Vec4i -> Vec4i(x, z, w, y)
        is Vec4s -> Vec4s(x, z, w, y)
        is Vec4l -> Vec4l(x, z, w, y)
        is Vec4ub -> Vec4ub(x, z, w, y)
        is Vec4ui -> Vec4ui(x, z, w, y)
        is Vec4us -> Vec4us(x, z, w, y)
        is Vec4ul -> Vec4ul(x, z, w, y)
        else -> throw IllegalStateException()
    }
        @JvmName("xzwy") set(value) {
            x = value.x as T
            z = value.y as T
            w = value.z as T
            y = value.w as T
        }
    val xzwz @JvmName("xzwz") get() = when (this) {
        is Vec4 -> Vec4(x, z, w, z)
        is Vec4d -> Vec4d(x, z, w, z)
        is Vec4b -> Vec4b(x, z, w, z)
        is Vec4i -> Vec4i(x, z, w, z)
        is Vec4s -> Vec4s(x, z, w, z)
        is Vec4l -> Vec4l(x, z, w, z)
        is Vec4ub -> Vec4ub(x, z, w, z)
        is Vec4ui -> Vec4ui(x, z, w, z)
        is Vec4us -> Vec4us(x, z, w, z)
        is Vec4ul -> Vec4ul(x, z, w, z)
        else -> throw IllegalStateException()
    }
    val xzww @JvmName("xzww") get() = when (this) {
        is Vec4 -> Vec4(x, z, w, w)
        is Vec4d -> Vec4d(x, z, w, w)
        is Vec4b -> Vec4b(x, z, w, w)
        is Vec4i -> Vec4i(x, z, w, w)
        is Vec4s -> Vec4s(x, z, w, w)
        is Vec4l -> Vec4l(x, z, w, w)
        is Vec4ub -> Vec4ub(x, z, w, w)
        is Vec4ui -> Vec4ui(x, z, w, w)
        is Vec4us -> Vec4us(x, z, w, w)
        is Vec4ul -> Vec4ul(x, z, w, w)
        else -> throw IllegalStateException()
    }
    val xwxx @JvmName("xwxx") get() = when (this) {
        is Vec4 -> Vec4(x, w, x, x)
        is Vec4d -> Vec4d(x, w, x, x)
        is Vec4b -> Vec4b(x, w, x, x)
        is Vec4i -> Vec4i(x, w, x, x)
        is Vec4s -> Vec4s(x, w, x, x)
        is Vec4l -> Vec4l(x, w, x, x)
        is Vec4ub -> Vec4ub(x, w, x, x)
        is Vec4ui -> Vec4ui(x, w, x, x)
        is Vec4us -> Vec4us(x, w, x, x)
        is Vec4ul -> Vec4ul(x, w, x, x)
        else -> throw IllegalStateException()
    }
    val xwxy @JvmName("xwxy") get() = when (this) {
        is Vec4 -> Vec4(x, w, x, y)
        is Vec4d -> Vec4d(x, w, x, y)
        is Vec4b -> Vec4b(x, w, x, y)
        is Vec4i -> Vec4i(x, w, x, y)
        is Vec4s -> Vec4s(x, w, x, y)
        is Vec4l -> Vec4l(x, w, x, y)
        is Vec4ub -> Vec4ub(x, w, x, y)
        is Vec4ui -> Vec4ui(x, w, x, y)
        is Vec4us -> Vec4us(x, w, x, y)
        is Vec4ul -> Vec4ul(x, w, x, y)
        else -> throw IllegalStateException()
    }
    val xwxz @JvmName("xwxz") get() = when (this) {
        is Vec4 -> Vec4(x, w, x, z)
        is Vec4d -> Vec4d(x, w, x, z)
        is Vec4b -> Vec4b(x, w, x, z)
        is Vec4i -> Vec4i(x, w, x, z)
        is Vec4s -> Vec4s(x, w, x, z)
        is Vec4l -> Vec4l(x, w, x, z)
        is Vec4ub -> Vec4ub(x, w, x, z)
        is Vec4ui -> Vec4ui(x, w, x, z)
        is Vec4us -> Vec4us(x, w, x, z)
        is Vec4ul -> Vec4ul(x, w, x, z)
        else -> throw IllegalStateException()
    }
    val xwxw @JvmName("xwxw") get() = when (this) {
        is Vec4 -> Vec4(x, w, x, w)
        is Vec4d -> Vec4d(x, w, x, w)
        is Vec4b -> Vec4b(x, w, x, w)
        is Vec4i -> Vec4i(x, w, x, w)
        is Vec4s -> Vec4s(x, w, x, w)
        is Vec4l -> Vec4l(x, w, x, w)
        is Vec4ub -> Vec4ub(x, w, x, w)
        is Vec4ui -> Vec4ui(x, w, x, w)
        is Vec4us -> Vec4us(x, w, x, w)
        is Vec4ul -> Vec4ul(x, w, x, w)
        else -> throw IllegalStateException()
    }
    val xwyx @JvmName("xwyx") get() = when (this) {
        is Vec4 -> Vec4(x, w, y, x)
        is Vec4d -> Vec4d(x, w, y, x)
        is Vec4b -> Vec4b(x, w, y, x)
        is Vec4i -> Vec4i(x, w, y, x)
        is Vec4s -> Vec4s(x, w, y, x)
        is Vec4l -> Vec4l(x, w, y, x)
        is Vec4ub -> Vec4ub(x, w, y, x)
        is Vec4ui -> Vec4ui(x, w, y, x)
        is Vec4us -> Vec4us(x, w, y, x)
        is Vec4ul -> Vec4ul(x, w, y, x)
        else -> throw IllegalStateException()
    }
    val xwyy @JvmName("xwyy") get() = when (this) {
        is Vec4 -> Vec4(x, w, y, y)
        is Vec4d -> Vec4d(x, w, y, y)
        is Vec4b -> Vec4b(x, w, y, y)
        is Vec4i -> Vec4i(x, w, y, y)
        is Vec4s -> Vec4s(x, w, y, y)
        is Vec4l -> Vec4l(x, w, y, y)
        is Vec4ub -> Vec4ub(x, w, y, y)
        is Vec4ui -> Vec4ui(x, w, y, y)
        is Vec4us -> Vec4us(x, w, y, y)
        is Vec4ul -> Vec4ul(x, w, y, y)
        else -> throw IllegalStateException()
    }
    var xwyz @JvmName("xwyz") get() = when (this) {
        is Vec4 -> Vec4(x, w, y, z)
        is Vec4d -> Vec4d(x, w, y, z)
        is Vec4b -> Vec4b(x, w, y, z)
        is Vec4i -> Vec4i(x, w, y, z)
        is Vec4s -> Vec4s(x, w, y, z)
        is Vec4l -> Vec4l(x, w, y, z)
        is Vec4ub -> Vec4ub(x, w, y, z)
        is Vec4ui -> Vec4ui(x, w, y, z)
        is Vec4us -> Vec4us(x, w, y, z)
        is Vec4ul -> Vec4ul(x, w, y, z)
        else -> throw IllegalStateException()
    }
        @JvmName("xwyz") set(value) {
            x = value.x as T
            w = value.y as T
            y = value.z as T
            z = value.w as T
        }
    val xwyw @JvmName("xwyw") get() = when (this) {
        is Vec4 -> Vec4(x, w, y, w)
        is Vec4d -> Vec4d(x, w, y, w)
        is Vec4b -> Vec4b(x, w, y, w)
        is Vec4i -> Vec4i(x, w, y, w)
        is Vec4s -> Vec4s(x, w, y, w)
        is Vec4l -> Vec4l(x, w, y, w)
        is Vec4ub -> Vec4ub(x, w, y, w)
        is Vec4ui -> Vec4ui(x, w, y, w)
        is Vec4us -> Vec4us(x, w, y, w)
        is Vec4ul -> Vec4ul(x, w, y, w)
        else -> throw IllegalStateException()
    }
    val xwzx @JvmName("xwzx") get() = when (this) {
        is Vec4 -> Vec4(x, w, z, x)
        is Vec4d -> Vec4d(x, w, z, x)
        is Vec4b -> Vec4b(x, w, z, x)
        is Vec4i -> Vec4i(x, w, z, x)
        is Vec4s -> Vec4s(x, w, z, x)
        is Vec4l -> Vec4l(x, w, z, x)
        is Vec4ub -> Vec4ub(x, w, z, x)
        is Vec4ui -> Vec4ui(x, w, z, x)
        is Vec4us -> Vec4us(x, w, z, x)
        is Vec4ul -> Vec4ul(x, w, z, x)
        else -> throw IllegalStateException()
    }
    var xwzy @JvmName("xwzy") get() = when (this) {
        is Vec4 -> Vec4(x, w, z, y)
        is Vec4d -> Vec4d(x, w, z, y)
        is Vec4b -> Vec4b(x, w, z, y)
        is Vec4i -> Vec4i(x, w, z, y)
        is Vec4s -> Vec4s(x, w, z, y)
        is Vec4l -> Vec4l(x, w, z, y)
        is Vec4ub -> Vec4ub(x, w, z, y)
        is Vec4ui -> Vec4ui(x, w, z, y)
        is Vec4us -> Vec4us(x, w, z, y)
        is Vec4ul -> Vec4ul(x, w, z, y)
        else -> throw IllegalStateException()
    }
        @JvmName("xwzy") set(value) {
            x = value.x as T
            w = value.y as T
            z = value.z as T
            y = value.w as T
        }
    val xwzz @JvmName("xwzz") get() = when (this) {
        is Vec4 -> Vec4(x, w, z, z)
        is Vec4d -> Vec4d(x, w, z, z)
        is Vec4b -> Vec4b(x, w, z, z)
        is Vec4i -> Vec4i(x, w, z, z)
        is Vec4s -> Vec4s(x, w, z, z)
        is Vec4l -> Vec4l(x, w, z, z)
        is Vec4ub -> Vec4ub(x, w, z, z)
        is Vec4ui -> Vec4ui(x, w, z, z)
        is Vec4us -> Vec4us(x, w, z, z)
        is Vec4ul -> Vec4ul(x, w, z, z)
        else -> throw IllegalStateException()
    }
    val xwzw @JvmName("xwzw") get() = when (this) {
        is Vec4 -> Vec4(x, w, z, w)
        is Vec4d -> Vec4d(x, w, z, w)
        is Vec4b -> Vec4b(x, w, z, w)
        is Vec4i -> Vec4i(x, w, z, w)
        is Vec4s -> Vec4s(x, w, z, w)
        is Vec4l -> Vec4l(x, w, z, w)
        is Vec4ub -> Vec4ub(x, w, z, w)
        is Vec4ui -> Vec4ui(x, w, z, w)
        is Vec4us -> Vec4us(x, w, z, w)
        is Vec4ul -> Vec4ul(x, w, z, w)
        else -> throw IllegalStateException()
    }
    val xwwx @JvmName("xwwx") get() = when (this) {
        is Vec4 -> Vec4(x, w, w, x)
        is Vec4d -> Vec4d(x, w, w, x)
        is Vec4b -> Vec4b(x, w, w, x)
        is Vec4i -> Vec4i(x, w, w, x)
        is Vec4s -> Vec4s(x, w, w, x)
        is Vec4l -> Vec4l(x, w, w, x)
        is Vec4ub -> Vec4ub(x, w, w, x)
        is Vec4ui -> Vec4ui(x, w, w, x)
        is Vec4us -> Vec4us(x, w, w, x)
        is Vec4ul -> Vec4ul(x, w, w, x)
        else -> throw IllegalStateException()
    }
    val xwwy @JvmName("xwwy") get() = when (this) {
        is Vec4 -> Vec4(x, w, w, y)
        is Vec4d -> Vec4d(x, w, w, y)
        is Vec4b -> Vec4b(x, w, w, y)
        is Vec4i -> Vec4i(x, w, w, y)
        is Vec4s -> Vec4s(x, w, w, y)
        is Vec4l -> Vec4l(x, w, w, y)
        is Vec4ub -> Vec4ub(x, w, w, y)
        is Vec4ui -> Vec4ui(x, w, w, y)
        is Vec4us -> Vec4us(x, w, w, y)
        is Vec4ul -> Vec4ul(x, w, w, y)
        else -> throw IllegalStateException()
    }
    val xwwz @JvmName("xwwz") get() = when (this) {
        is Vec4 -> Vec4(x, w, w, z)
        is Vec4d -> Vec4d(x, w, w, z)
        is Vec4b -> Vec4b(x, w, w, z)
        is Vec4i -> Vec4i(x, w, w, z)
        is Vec4s -> Vec4s(x, w, w, z)
        is Vec4l -> Vec4l(x, w, w, z)
        is Vec4ub -> Vec4ub(x, w, w, z)
        is Vec4ui -> Vec4ui(x, w, w, z)
        is Vec4us -> Vec4us(x, w, w, z)
        is Vec4ul -> Vec4ul(x, w, w, z)
        else -> throw IllegalStateException()
    }
    val xwww @JvmName("xwww") get() = when (this) {
        is Vec4 -> Vec4(x, w, w, w)
        is Vec4d -> Vec4d(x, w, w, w)
        is Vec4b -> Vec4b(x, w, w, w)
        is Vec4i -> Vec4i(x, w, w, w)
        is Vec4s -> Vec4s(x, w, w, w)
        is Vec4l -> Vec4l(x, w, w, w)
        is Vec4ub -> Vec4ub(x, w, w, w)
        is Vec4ui -> Vec4ui(x, w, w, w)
        is Vec4us -> Vec4us(x, w, w, w)
        is Vec4ul -> Vec4ul(x, w, w, w)
        else -> throw IllegalStateException()
    }
    val yxxx @JvmName("yxxx") get() = when (this) {
        is Vec4 -> Vec4(y, x, x, x)
        is Vec4d -> Vec4d(y, x, x, x)
        is Vec4b -> Vec4b(y, x, x, x)
        is Vec4i -> Vec4i(y, x, x, x)
        is Vec4s -> Vec4s(y, x, x, x)
        is Vec4l -> Vec4l(y, x, x, x)
        is Vec4ub -> Vec4ub(y, x, x, x)
        is Vec4ui -> Vec4ui(y, x, x, x)
        is Vec4us -> Vec4us(y, x, x, x)
        is Vec4ul -> Vec4ul(y, x, x, x)
        else -> throw IllegalStateException()
    }
    val yxxy @JvmName("yxxy") get() = when (this) {
        is Vec4 -> Vec4(y, x, x, y)
        is Vec4d -> Vec4d(y, x, x, y)
        is Vec4b -> Vec4b(y, x, x, y)
        is Vec4i -> Vec4i(y, x, x, y)
        is Vec4s -> Vec4s(y, x, x, y)
        is Vec4l -> Vec4l(y, x, x, y)
        is Vec4ub -> Vec4ub(y, x, x, y)
        is Vec4ui -> Vec4ui(y, x, x, y)
        is Vec4us -> Vec4us(y, x, x, y)
        is Vec4ul -> Vec4ul(y, x, x, y)
        else -> throw IllegalStateException()
    }
    val yxxz @JvmName("yxxz") get() = when (this) {
        is Vec4 -> Vec4(y, x, x, z)
        is Vec4d -> Vec4d(y, x, x, z)
        is Vec4b -> Vec4b(y, x, x, z)
        is Vec4i -> Vec4i(y, x, x, z)
        is Vec4s -> Vec4s(y, x, x, z)
        is Vec4l -> Vec4l(y, x, x, z)
        is Vec4ub -> Vec4ub(y, x, x, z)
        is Vec4ui -> Vec4ui(y, x, x, z)
        is Vec4us -> Vec4us(y, x, x, z)
        is Vec4ul -> Vec4ul(y, x, x, z)
        else -> throw IllegalStateException()
    }
    val yxxw @JvmName("yxxw") get() = when (this) {
        is Vec4 -> Vec4(y, x, x, w)
        is Vec4d -> Vec4d(y, x, x, w)
        is Vec4b -> Vec4b(y, x, x, w)
        is Vec4i -> Vec4i(y, x, x, w)
        is Vec4s -> Vec4s(y, x, x, w)
        is Vec4l -> Vec4l(y, x, x, w)
        is Vec4ub -> Vec4ub(y, x, x, w)
        is Vec4ui -> Vec4ui(y, x, x, w)
        is Vec4us -> Vec4us(y, x, x, w)
        is Vec4ul -> Vec4ul(y, x, x, w)
        else -> throw IllegalStateException()
    }
    val yxyx @JvmName("yxyx") get() = when (this) {
        is Vec4 -> Vec4(y, x, y, x)
        is Vec4d -> Vec4d(y, x, y, x)
        is Vec4b -> Vec4b(y, x, y, x)
        is Vec4i -> Vec4i(y, x, y, x)
        is Vec4s -> Vec4s(y, x, y, x)
        is Vec4l -> Vec4l(y, x, y, x)
        is Vec4ub -> Vec4ub(y, x, y, x)
        is Vec4ui -> Vec4ui(y, x, y, x)
        is Vec4us -> Vec4us(y, x, y, x)
        is Vec4ul -> Vec4ul(y, x, y, x)
        else -> throw IllegalStateException()
    }
    val yxyy @JvmName("yxyy") get() = when (this) {
        is Vec4 -> Vec4(y, x, y, y)
        is Vec4d -> Vec4d(y, x, y, y)
        is Vec4b -> Vec4b(y, x, y, y)
        is Vec4i -> Vec4i(y, x, y, y)
        is Vec4s -> Vec4s(y, x, y, y)
        is Vec4l -> Vec4l(y, x, y, y)
        is Vec4ub -> Vec4ub(y, x, y, y)
        is Vec4ui -> Vec4ui(y, x, y, y)
        is Vec4us -> Vec4us(y, x, y, y)
        is Vec4ul -> Vec4ul(y, x, y, y)
        else -> throw IllegalStateException()
    }
    val yxyz @JvmName("yxyz") get() = when (this) {
        is Vec4 -> Vec4(y, x, y, z)
        is Vec4d -> Vec4d(y, x, y, z)
        is Vec4b -> Vec4b(y, x, y, z)
        is Vec4i -> Vec4i(y, x, y, z)
        is Vec4s -> Vec4s(y, x, y, z)
        is Vec4l -> Vec4l(y, x, y, z)
        is Vec4ub -> Vec4ub(y, x, y, z)
        is Vec4ui -> Vec4ui(y, x, y, z)
        is Vec4us -> Vec4us(y, x, y, z)
        is Vec4ul -> Vec4ul(y, x, y, z)
        else -> throw IllegalStateException()
    }
    val yxyw @JvmName("yxyw") get() = when (this) {
        is Vec4 -> Vec4(y, x, y, w)
        is Vec4d -> Vec4d(y, x, y, w)
        is Vec4b -> Vec4b(y, x, y, w)
        is Vec4i -> Vec4i(y, x, y, w)
        is Vec4s -> Vec4s(y, x, y, w)
        is Vec4l -> Vec4l(y, x, y, w)
        is Vec4ub -> Vec4ub(y, x, y, w)
        is Vec4ui -> Vec4ui(y, x, y, w)
        is Vec4us -> Vec4us(y, x, y, w)
        is Vec4ul -> Vec4ul(y, x, y, w)
        else -> throw IllegalStateException()
    }
    val yxzx @JvmName("yxzx") get() = when (this) {
        is Vec4 -> Vec4(y, x, z, x)
        is Vec4d -> Vec4d(y, x, z, x)
        is Vec4b -> Vec4b(y, x, z, x)
        is Vec4i -> Vec4i(y, x, z, x)
        is Vec4s -> Vec4s(y, x, z, x)
        is Vec4l -> Vec4l(y, x, z, x)
        is Vec4ub -> Vec4ub(y, x, z, x)
        is Vec4ui -> Vec4ui(y, x, z, x)
        is Vec4us -> Vec4us(y, x, z, x)
        is Vec4ul -> Vec4ul(y, x, z, x)
        else -> throw IllegalStateException()
    }
    val yxzy @JvmName("yxzy") get() = when (this) {
        is Vec4 -> Vec4(y, x, z, y)
        is Vec4d -> Vec4d(y, x, z, y)
        is Vec4b -> Vec4b(y, x, z, y)
        is Vec4i -> Vec4i(y, x, z, y)
        is Vec4s -> Vec4s(y, x, z, y)
        is Vec4l -> Vec4l(y, x, z, y)
        is Vec4ub -> Vec4ub(y, x, z, y)
        is Vec4ui -> Vec4ui(y, x, z, y)
        is Vec4us -> Vec4us(y, x, z, y)
        is Vec4ul -> Vec4ul(y, x, z, y)
        else -> throw IllegalStateException()
    }
    val yxzz @JvmName("yxzz") get() = when (this) {
        is Vec4 -> Vec4(y, x, z, z)
        is Vec4d -> Vec4d(y, x, z, z)
        is Vec4b -> Vec4b(y, x, z, z)
        is Vec4i -> Vec4i(y, x, z, z)
        is Vec4s -> Vec4s(y, x, z, z)
        is Vec4l -> Vec4l(y, x, z, z)
        is Vec4ub -> Vec4ub(y, x, z, z)
        is Vec4ui -> Vec4ui(y, x, z, z)
        is Vec4us -> Vec4us(y, x, z, z)
        is Vec4ul -> Vec4ul(y, x, z, z)
        else -> throw IllegalStateException()
    }
    var yxzw @JvmName("yxzw") get() = when (this) {
        is Vec4 -> Vec4(y, x, z, w)
        is Vec4d -> Vec4d(y, x, z, w)
        is Vec4b -> Vec4b(y, x, z, w)
        is Vec4i -> Vec4i(y, x, z, w)
        is Vec4s -> Vec4s(y, x, z, w)
        is Vec4l -> Vec4l(y, x, z, w)
        is Vec4ub -> Vec4ub(y, x, z, w)
        is Vec4ui -> Vec4ui(y, x, z, w)
        is Vec4us -> Vec4us(y, x, z, w)
        is Vec4ul -> Vec4ul(y, x, z, w)
        else -> throw IllegalStateException()
    }
        @JvmName("yxzw") set(value) {
            y = value.x as T
            x = value.y as T
            z = value.z as T
            w = value.w as T
        }
    val yxwx @JvmName("yxwx") get() = when (this) {
        is Vec4 -> Vec4(y, x, w, x)
        is Vec4d -> Vec4d(y, x, w, x)
        is Vec4b -> Vec4b(y, x, w, x)
        is Vec4i -> Vec4i(y, x, w, x)
        is Vec4s -> Vec4s(y, x, w, x)
        is Vec4l -> Vec4l(y, x, w, x)
        is Vec4ub -> Vec4ub(y, x, w, x)
        is Vec4ui -> Vec4ui(y, x, w, x)
        is Vec4us -> Vec4us(y, x, w, x)
        is Vec4ul -> Vec4ul(y, x, w, x)
        else -> throw IllegalStateException()
    }
    val yxwy @JvmName("yxwy") get() = when (this) {
        is Vec4 -> Vec4(y, x, w, y)
        is Vec4d -> Vec4d(y, x, w, y)
        is Vec4b -> Vec4b(y, x, w, y)
        is Vec4i -> Vec4i(y, x, w, y)
        is Vec4s -> Vec4s(y, x, w, y)
        is Vec4l -> Vec4l(y, x, w, y)
        is Vec4ub -> Vec4ub(y, x, w, y)
        is Vec4ui -> Vec4ui(y, x, w, y)
        is Vec4us -> Vec4us(y, x, w, y)
        is Vec4ul -> Vec4ul(y, x, w, y)
        else -> throw IllegalStateException()
    }
    var yxwz @JvmName("yxwz") get() = when (this) {
        is Vec4 -> Vec4(y, x, w, z)
        is Vec4d -> Vec4d(y, x, w, z)
        is Vec4b -> Vec4b(y, x, w, z)
        is Vec4i -> Vec4i(y, x, w, z)
        is Vec4s -> Vec4s(y, x, w, z)
        is Vec4l -> Vec4l(y, x, w, z)
        is Vec4ub -> Vec4ub(y, x, w, z)
        is Vec4ui -> Vec4ui(y, x, w, z)
        is Vec4us -> Vec4us(y, x, w, z)
        is Vec4ul -> Vec4ul(y, x, w, z)
        else -> throw IllegalStateException()
    }
        @JvmName("yxwz") set(value) {
            y = value.x as T
            x = value.y as T
            w = value.z as T
            z = value.w as T
        }
    val yxww @JvmName("yxww") get() = when (this) {
        is Vec4 -> Vec4(y, x, w, w)
        is Vec4d -> Vec4d(y, x, w, w)
        is Vec4b -> Vec4b(y, x, w, w)
        is Vec4i -> Vec4i(y, x, w, w)
        is Vec4s -> Vec4s(y, x, w, w)
        is Vec4l -> Vec4l(y, x, w, w)
        is Vec4ub -> Vec4ub(y, x, w, w)
        is Vec4ui -> Vec4ui(y, x, w, w)
        is Vec4us -> Vec4us(y, x, w, w)
        is Vec4ul -> Vec4ul(y, x, w, w)
        else -> throw IllegalStateException()
    }
    val yyxx @JvmName("yyxx") get() = when (this) {
        is Vec4 -> Vec4(y, y, x, x)
        is Vec4d -> Vec4d(y, y, x, x)
        is Vec4b -> Vec4b(y, y, x, x)
        is Vec4i -> Vec4i(y, y, x, x)
        is Vec4s -> Vec4s(y, y, x, x)
        is Vec4l -> Vec4l(y, y, x, x)
        is Vec4ub -> Vec4ub(y, y, x, x)
        is Vec4ui -> Vec4ui(y, y, x, x)
        is Vec4us -> Vec4us(y, y, x, x)
        is Vec4ul -> Vec4ul(y, y, x, x)
        else -> throw IllegalStateException()
    }
    val yyxy @JvmName("yyxy") get() = when (this) {
        is Vec4 -> Vec4(y, y, x, y)
        is Vec4d -> Vec4d(y, y, x, y)
        is Vec4b -> Vec4b(y, y, x, y)
        is Vec4i -> Vec4i(y, y, x, y)
        is Vec4s -> Vec4s(y, y, x, y)
        is Vec4l -> Vec4l(y, y, x, y)
        is Vec4ub -> Vec4ub(y, y, x, y)
        is Vec4ui -> Vec4ui(y, y, x, y)
        is Vec4us -> Vec4us(y, y, x, y)
        is Vec4ul -> Vec4ul(y, y, x, y)
        else -> throw IllegalStateException()
    }
    val yyxz @JvmName("yyxz") get() = when (this) {
        is Vec4 -> Vec4(y, y, x, z)
        is Vec4d -> Vec4d(y, y, x, z)
        is Vec4b -> Vec4b(y, y, x, z)
        is Vec4i -> Vec4i(y, y, x, z)
        is Vec4s -> Vec4s(y, y, x, z)
        is Vec4l -> Vec4l(y, y, x, z)
        is Vec4ub -> Vec4ub(y, y, x, z)
        is Vec4ui -> Vec4ui(y, y, x, z)
        is Vec4us -> Vec4us(y, y, x, z)
        is Vec4ul -> Vec4ul(y, y, x, z)
        else -> throw IllegalStateException()
    }
    val yyxw @JvmName("yyxw") get() = when (this) {
        is Vec4 -> Vec4(y, y, x, w)
        is Vec4d -> Vec4d(y, y, x, w)
        is Vec4b -> Vec4b(y, y, x, w)
        is Vec4i -> Vec4i(y, y, x, w)
        is Vec4s -> Vec4s(y, y, x, w)
        is Vec4l -> Vec4l(y, y, x, w)
        is Vec4ub -> Vec4ub(y, y, x, w)
        is Vec4ui -> Vec4ui(y, y, x, w)
        is Vec4us -> Vec4us(y, y, x, w)
        is Vec4ul -> Vec4ul(y, y, x, w)
        else -> throw IllegalStateException()
    }
    val yyyx @JvmName("yyyx") get() = when (this) {
        is Vec4 -> Vec4(y, y, y, x)
        is Vec4d -> Vec4d(y, y, y, x)
        is Vec4b -> Vec4b(y, y, y, x)
        is Vec4i -> Vec4i(y, y, y, x)
        is Vec4s -> Vec4s(y, y, y, x)
        is Vec4l -> Vec4l(y, y, y, x)
        is Vec4ub -> Vec4ub(y, y, y, x)
        is Vec4ui -> Vec4ui(y, y, y, x)
        is Vec4us -> Vec4us(y, y, y, x)
        is Vec4ul -> Vec4ul(y, y, y, x)
        else -> throw IllegalStateException()
    }
    val yyyy @JvmName("yyyy") get() = when (this) {
        is Vec4 -> Vec4(y, y, y, y)
        is Vec4d -> Vec4d(y, y, y, y)
        is Vec4b -> Vec4b(y, y, y, y)
        is Vec4i -> Vec4i(y, y, y, y)
        is Vec4s -> Vec4s(y, y, y, y)
        is Vec4l -> Vec4l(y, y, y, y)
        is Vec4ub -> Vec4ub(y, y, y, y)
        is Vec4ui -> Vec4ui(y, y, y, y)
        is Vec4us -> Vec4us(y, y, y, y)
        is Vec4ul -> Vec4ul(y, y, y, y)
        else -> throw IllegalStateException()
    }
    val yyyz @JvmName("yyyz") get() = when (this) {
        is Vec4 -> Vec4(y, y, y, z)
        is Vec4d -> Vec4d(y, y, y, z)
        is Vec4b -> Vec4b(y, y, y, z)
        is Vec4i -> Vec4i(y, y, y, z)
        is Vec4s -> Vec4s(y, y, y, z)
        is Vec4l -> Vec4l(y, y, y, z)
        is Vec4ub -> Vec4ub(y, y, y, z)
        is Vec4ui -> Vec4ui(y, y, y, z)
        is Vec4us -> Vec4us(y, y, y, z)
        is Vec4ul -> Vec4ul(y, y, y, z)
        else -> throw IllegalStateException()
    }
    val yyyw @JvmName("yyyw") get() = when (this) {
        is Vec4 -> Vec4(y, y, y, w)
        is Vec4d -> Vec4d(y, y, y, w)
        is Vec4b -> Vec4b(y, y, y, w)
        is Vec4i -> Vec4i(y, y, y, w)
        is Vec4s -> Vec4s(y, y, y, w)
        is Vec4l -> Vec4l(y, y, y, w)
        is Vec4ub -> Vec4ub(y, y, y, w)
        is Vec4ui -> Vec4ui(y, y, y, w)
        is Vec4us -> Vec4us(y, y, y, w)
        is Vec4ul -> Vec4ul(y, y, y, w)
        else -> throw IllegalStateException()
    }
    val yyzx @JvmName("yyzx") get() = when (this) {
        is Vec4 -> Vec4(y, y, z, x)
        is Vec4d -> Vec4d(y, y, z, x)
        is Vec4b -> Vec4b(y, y, z, x)
        is Vec4i -> Vec4i(y, y, z, x)
        is Vec4s -> Vec4s(y, y, z, x)
        is Vec4l -> Vec4l(y, y, z, x)
        is Vec4ub -> Vec4ub(y, y, z, x)
        is Vec4ui -> Vec4ui(y, y, z, x)
        is Vec4us -> Vec4us(y, y, z, x)
        is Vec4ul -> Vec4ul(y, y, z, x)
        else -> throw IllegalStateException()
    }
    val yyzy @JvmName("yyzy") get() = when (this) {
        is Vec4 -> Vec4(y, y, z, y)
        is Vec4d -> Vec4d(y, y, z, y)
        is Vec4b -> Vec4b(y, y, z, y)
        is Vec4i -> Vec4i(y, y, z, y)
        is Vec4s -> Vec4s(y, y, z, y)
        is Vec4l -> Vec4l(y, y, z, y)
        is Vec4ub -> Vec4ub(y, y, z, y)
        is Vec4ui -> Vec4ui(y, y, z, y)
        is Vec4us -> Vec4us(y, y, z, y)
        is Vec4ul -> Vec4ul(y, y, z, y)
        else -> throw IllegalStateException()
    }
    val yyzz @JvmName("yyzz") get() = when (this) {
        is Vec4 -> Vec4(y, y, z, z)
        is Vec4d -> Vec4d(y, y, z, z)
        is Vec4b -> Vec4b(y, y, z, z)
        is Vec4i -> Vec4i(y, y, z, z)
        is Vec4s -> Vec4s(y, y, z, z)
        is Vec4l -> Vec4l(y, y, z, z)
        is Vec4ub -> Vec4ub(y, y, z, z)
        is Vec4ui -> Vec4ui(y, y, z, z)
        is Vec4us -> Vec4us(y, y, z, z)
        is Vec4ul -> Vec4ul(y, y, z, z)
        else -> throw IllegalStateException()
    }
    val yyzw @JvmName("yyzw") get() = when (this) {
        is Vec4 -> Vec4(y, y, z, w)
        is Vec4d -> Vec4d(y, y, z, w)
        is Vec4b -> Vec4b(y, y, z, w)
        is Vec4i -> Vec4i(y, y, z, w)
        is Vec4s -> Vec4s(y, y, z, w)
        is Vec4l -> Vec4l(y, y, z, w)
        is Vec4ub -> Vec4ub(y, y, z, w)
        is Vec4ui -> Vec4ui(y, y, z, w)
        is Vec4us -> Vec4us(y, y, z, w)
        is Vec4ul -> Vec4ul(y, y, z, w)
        else -> throw IllegalStateException()
    }
    val yywx @JvmName("yywx") get() = when (this) {
        is Vec4 -> Vec4(y, y, w, x)
        is Vec4d -> Vec4d(y, y, w, x)
        is Vec4b -> Vec4b(y, y, w, x)
        is Vec4i -> Vec4i(y, y, w, x)
        is Vec4s -> Vec4s(y, y, w, x)
        is Vec4l -> Vec4l(y, y, w, x)
        is Vec4ub -> Vec4ub(y, y, w, x)
        is Vec4ui -> Vec4ui(y, y, w, x)
        is Vec4us -> Vec4us(y, y, w, x)
        is Vec4ul -> Vec4ul(y, y, w, x)
        else -> throw IllegalStateException()
    }
    val yywy @JvmName("yywy") get() = when (this) {
        is Vec4 -> Vec4(y, y, w, y)
        is Vec4d -> Vec4d(y, y, w, y)
        is Vec4b -> Vec4b(y, y, w, y)
        is Vec4i -> Vec4i(y, y, w, y)
        is Vec4s -> Vec4s(y, y, w, y)
        is Vec4l -> Vec4l(y, y, w, y)
        is Vec4ub -> Vec4ub(y, y, w, y)
        is Vec4ui -> Vec4ui(y, y, w, y)
        is Vec4us -> Vec4us(y, y, w, y)
        is Vec4ul -> Vec4ul(y, y, w, y)
        else -> throw IllegalStateException()
    }
    val yywz @JvmName("yywz") get() = when (this) {
        is Vec4 -> Vec4(y, y, w, z)
        is Vec4d -> Vec4d(y, y, w, z)
        is Vec4b -> Vec4b(y, y, w, z)
        is Vec4i -> Vec4i(y, y, w, z)
        is Vec4s -> Vec4s(y, y, w, z)
        is Vec4l -> Vec4l(y, y, w, z)
        is Vec4ub -> Vec4ub(y, y, w, z)
        is Vec4ui -> Vec4ui(y, y, w, z)
        is Vec4us -> Vec4us(y, y, w, z)
        is Vec4ul -> Vec4ul(y, y, w, z)
        else -> throw IllegalStateException()
    }
    val yyww @JvmName("yyww") get() = when (this) {
        is Vec4 -> Vec4(y, y, w, w)
        is Vec4d -> Vec4d(y, y, w, w)
        is Vec4b -> Vec4b(y, y, w, w)
        is Vec4i -> Vec4i(y, y, w, w)
        is Vec4s -> Vec4s(y, y, w, w)
        is Vec4l -> Vec4l(y, y, w, w)
        is Vec4ub -> Vec4ub(y, y, w, w)
        is Vec4ui -> Vec4ui(y, y, w, w)
        is Vec4us -> Vec4us(y, y, w, w)
        is Vec4ul -> Vec4ul(y, y, w, w)
        else -> throw IllegalStateException()
    }
    val yzxx @JvmName("yzxx") get() = when (this) {
        is Vec4 -> Vec4(y, z, x, x)
        is Vec4d -> Vec4d(y, z, x, x)
        is Vec4b -> Vec4b(y, z, x, x)
        is Vec4i -> Vec4i(y, z, x, x)
        is Vec4s -> Vec4s(y, z, x, x)
        is Vec4l -> Vec4l(y, z, x, x)
        is Vec4ub -> Vec4ub(y, z, x, x)
        is Vec4ui -> Vec4ui(y, z, x, x)
        is Vec4us -> Vec4us(y, z, x, x)
        is Vec4ul -> Vec4ul(y, z, x, x)
        else -> throw IllegalStateException()
    }
    val yzxy @JvmName("yzxy") get() = when (this) {
        is Vec4 -> Vec4(y, z, x, y)
        is Vec4d -> Vec4d(y, z, x, y)
        is Vec4b -> Vec4b(y, z, x, y)
        is Vec4i -> Vec4i(y, z, x, y)
        is Vec4s -> Vec4s(y, z, x, y)
        is Vec4l -> Vec4l(y, z, x, y)
        is Vec4ub -> Vec4ub(y, z, x, y)
        is Vec4ui -> Vec4ui(y, z, x, y)
        is Vec4us -> Vec4us(y, z, x, y)
        is Vec4ul -> Vec4ul(y, z, x, y)
        else -> throw IllegalStateException()
    }
    val yzxz @JvmName("yzxz") get() = when (this) {
        is Vec4 -> Vec4(y, z, x, z)
        is Vec4d -> Vec4d(y, z, x, z)
        is Vec4b -> Vec4b(y, z, x, z)
        is Vec4i -> Vec4i(y, z, x, z)
        is Vec4s -> Vec4s(y, z, x, z)
        is Vec4l -> Vec4l(y, z, x, z)
        is Vec4ub -> Vec4ub(y, z, x, z)
        is Vec4ui -> Vec4ui(y, z, x, z)
        is Vec4us -> Vec4us(y, z, x, z)
        is Vec4ul -> Vec4ul(y, z, x, z)
        else -> throw IllegalStateException()
    }
    var yzxw @JvmName("yzxw") get() = when (this) {
        is Vec4 -> Vec4(y, z, x, w)
        is Vec4d -> Vec4d(y, z, x, w)
        is Vec4b -> Vec4b(y, z, x, w)
        is Vec4i -> Vec4i(y, z, x, w)
        is Vec4s -> Vec4s(y, z, x, w)
        is Vec4l -> Vec4l(y, z, x, w)
        is Vec4ub -> Vec4ub(y, z, x, w)
        is Vec4ui -> Vec4ui(y, z, x, w)
        is Vec4us -> Vec4us(y, z, x, w)
        is Vec4ul -> Vec4ul(y, z, x, w)
        else -> throw IllegalStateException()
    }
        @JvmName("yzxw") set(value) {
            y = value.x as T
            z = value.y as T
            x = value.z as T
            w = value.w as T
        }
    val yzyx @JvmName("yzyx") get() = when (this) {
        is Vec4 -> Vec4(y, z, y, x)
        is Vec4d -> Vec4d(y, z, y, x)
        is Vec4b -> Vec4b(y, z, y, x)
        is Vec4i -> Vec4i(y, z, y, x)
        is Vec4s -> Vec4s(y, z, y, x)
        is Vec4l -> Vec4l(y, z, y, x)
        is Vec4ub -> Vec4ub(y, z, y, x)
        is Vec4ui -> Vec4ui(y, z, y, x)
        is Vec4us -> Vec4us(y, z, y, x)
        is Vec4ul -> Vec4ul(y, z, y, x)
        else -> throw IllegalStateException()
    }
    val yzyy @JvmName("yzyy") get() = when (this) {
        is Vec4 -> Vec4(y, z, y, y)
        is Vec4d -> Vec4d(y, z, y, y)
        is Vec4b -> Vec4b(y, z, y, y)
        is Vec4i -> Vec4i(y, z, y, y)
        is Vec4s -> Vec4s(y, z, y, y)
        is Vec4l -> Vec4l(y, z, y, y)
        is Vec4ub -> Vec4ub(y, z, y, y)
        is Vec4ui -> Vec4ui(y, z, y, y)
        is Vec4us -> Vec4us(y, z, y, y)
        is Vec4ul -> Vec4ul(y, z, y, y)
        else -> throw IllegalStateException()
    }
    val yzyz @JvmName("yzyz") get() = when (this) {
        is Vec4 -> Vec4(y, z, y, z)
        is Vec4d -> Vec4d(y, z, y, z)
        is Vec4b -> Vec4b(y, z, y, z)
        is Vec4i -> Vec4i(y, z, y, z)
        is Vec4s -> Vec4s(y, z, y, z)
        is Vec4l -> Vec4l(y, z, y, z)
        is Vec4ub -> Vec4ub(y, z, y, z)
        is Vec4ui -> Vec4ui(y, z, y, z)
        is Vec4us -> Vec4us(y, z, y, z)
        is Vec4ul -> Vec4ul(y, z, y, z)
        else -> throw IllegalStateException()
    }
    val yzyw @JvmName("yzyw") get() = when (this) {
        is Vec4 -> Vec4(y, z, y, w)
        is Vec4d -> Vec4d(y, z, y, w)
        is Vec4b -> Vec4b(y, z, y, w)
        is Vec4i -> Vec4i(y, z, y, w)
        is Vec4s -> Vec4s(y, z, y, w)
        is Vec4l -> Vec4l(y, z, y, w)
        is Vec4ub -> Vec4ub(y, z, y, w)
        is Vec4ui -> Vec4ui(y, z, y, w)
        is Vec4us -> Vec4us(y, z, y, w)
        is Vec4ul -> Vec4ul(y, z, y, w)
        else -> throw IllegalStateException()
    }
    val yzzx @JvmName("yzzx") get() = when (this) {
        is Vec4 -> Vec4(y, z, z, x)
        is Vec4d -> Vec4d(y, z, z, x)
        is Vec4b -> Vec4b(y, z, z, x)
        is Vec4i -> Vec4i(y, z, z, x)
        is Vec4s -> Vec4s(y, z, z, x)
        is Vec4l -> Vec4l(y, z, z, x)
        is Vec4ub -> Vec4ub(y, z, z, x)
        is Vec4ui -> Vec4ui(y, z, z, x)
        is Vec4us -> Vec4us(y, z, z, x)
        is Vec4ul -> Vec4ul(y, z, z, x)
        else -> throw IllegalStateException()
    }
    val yzzy @JvmName("yzzy") get() = when (this) {
        is Vec4 -> Vec4(y, z, z, y)
        is Vec4d -> Vec4d(y, z, z, y)
        is Vec4b -> Vec4b(y, z, z, y)
        is Vec4i -> Vec4i(y, z, z, y)
        is Vec4s -> Vec4s(y, z, z, y)
        is Vec4l -> Vec4l(y, z, z, y)
        is Vec4ub -> Vec4ub(y, z, z, y)
        is Vec4ui -> Vec4ui(y, z, z, y)
        is Vec4us -> Vec4us(y, z, z, y)
        is Vec4ul -> Vec4ul(y, z, z, y)
        else -> throw IllegalStateException()
    }
    val yzzz @JvmName("yzzz") get() = when (this) {
        is Vec4 -> Vec4(y, z, z, z)
        is Vec4d -> Vec4d(y, z, z, z)
        is Vec4b -> Vec4b(y, z, z, z)
        is Vec4i -> Vec4i(y, z, z, z)
        is Vec4s -> Vec4s(y, z, z, z)
        is Vec4l -> Vec4l(y, z, z, z)
        is Vec4ub -> Vec4ub(y, z, z, z)
        is Vec4ui -> Vec4ui(y, z, z, z)
        is Vec4us -> Vec4us(y, z, z, z)
        is Vec4ul -> Vec4ul(y, z, z, z)
        else -> throw IllegalStateException()
    }
    val yzzw @JvmName("yzzw") get() = when (this) {
        is Vec4 -> Vec4(y, z, z, w)
        is Vec4d -> Vec4d(y, z, z, w)
        is Vec4b -> Vec4b(y, z, z, w)
        is Vec4i -> Vec4i(y, z, z, w)
        is Vec4s -> Vec4s(y, z, z, w)
        is Vec4l -> Vec4l(y, z, z, w)
        is Vec4ub -> Vec4ub(y, z, z, w)
        is Vec4ui -> Vec4ui(y, z, z, w)
        is Vec4us -> Vec4us(y, z, z, w)
        is Vec4ul -> Vec4ul(y, z, z, w)
        else -> throw IllegalStateException()
    }
    var yzwx @JvmName("yzwx") get() = when (this) {
        is Vec4 -> Vec4(y, z, w, x)
        is Vec4d -> Vec4d(y, z, w, x)
        is Vec4b -> Vec4b(y, z, w, x)
        is Vec4i -> Vec4i(y, z, w, x)
        is Vec4s -> Vec4s(y, z, w, x)
        is Vec4l -> Vec4l(y, z, w, x)
        is Vec4ub -> Vec4ub(y, z, w, x)
        is Vec4ui -> Vec4ui(y, z, w, x)
        is Vec4us -> Vec4us(y, z, w, x)
        is Vec4ul -> Vec4ul(y, z, w, x)
        else -> throw IllegalStateException()
    }
        @JvmName("yzwx") set(value) {
            y = value.x as T
            z = value.y as T
            w = value.z as T
            x = value.w as T
        }
    val yzwy @JvmName("yzwy") get() = when (this) {
        is Vec4 -> Vec4(y, z, w, y)
        is Vec4d -> Vec4d(y, z, w, y)
        is Vec4b -> Vec4b(y, z, w, y)
        is Vec4i -> Vec4i(y, z, w, y)
        is Vec4s -> Vec4s(y, z, w, y)
        is Vec4l -> Vec4l(y, z, w, y)
        is Vec4ub -> Vec4ub(y, z, w, y)
        is Vec4ui -> Vec4ui(y, z, w, y)
        is Vec4us -> Vec4us(y, z, w, y)
        is Vec4ul -> Vec4ul(y, z, w, y)
        else -> throw IllegalStateException()
    }
    val yzwz @JvmName("yzwz") get() = when (this) {
        is Vec4 -> Vec4(y, z, w, z)
        is Vec4d -> Vec4d(y, z, w, z)
        is Vec4b -> Vec4b(y, z, w, z)
        is Vec4i -> Vec4i(y, z, w, z)
        is Vec4s -> Vec4s(y, z, w, z)
        is Vec4l -> Vec4l(y, z, w, z)
        is Vec4ub -> Vec4ub(y, z, w, z)
        is Vec4ui -> Vec4ui(y, z, w, z)
        is Vec4us -> Vec4us(y, z, w, z)
        is Vec4ul -> Vec4ul(y, z, w, z)
        else -> throw IllegalStateException()
    }
    val yzww @JvmName("yzww") get() = when (this) {
        is Vec4 -> Vec4(y, z, w, w)
        is Vec4d -> Vec4d(y, z, w, w)
        is Vec4b -> Vec4b(y, z, w, w)
        is Vec4i -> Vec4i(y, z, w, w)
        is Vec4s -> Vec4s(y, z, w, w)
        is Vec4l -> Vec4l(y, z, w, w)
        is Vec4ub -> Vec4ub(y, z, w, w)
        is Vec4ui -> Vec4ui(y, z, w, w)
        is Vec4us -> Vec4us(y, z, w, w)
        is Vec4ul -> Vec4ul(y, z, w, w)
        else -> throw IllegalStateException()
    }
    val ywxx @JvmName("ywxx") get() = when (this) {
        is Vec4 -> Vec4(y, w, x, x)
        is Vec4d -> Vec4d(y, w, x, x)
        is Vec4b -> Vec4b(y, w, x, x)
        is Vec4i -> Vec4i(y, w, x, x)
        is Vec4s -> Vec4s(y, w, x, x)
        is Vec4l -> Vec4l(y, w, x, x)
        is Vec4ub -> Vec4ub(y, w, x, x)
        is Vec4ui -> Vec4ui(y, w, x, x)
        is Vec4us -> Vec4us(y, w, x, x)
        is Vec4ul -> Vec4ul(y, w, x, x)
        else -> throw IllegalStateException()
    }
    val ywxy @JvmName("ywxy") get() = when (this) {
        is Vec4 -> Vec4(y, w, x, y)
        is Vec4d -> Vec4d(y, w, x, y)
        is Vec4b -> Vec4b(y, w, x, y)
        is Vec4i -> Vec4i(y, w, x, y)
        is Vec4s -> Vec4s(y, w, x, y)
        is Vec4l -> Vec4l(y, w, x, y)
        is Vec4ub -> Vec4ub(y, w, x, y)
        is Vec4ui -> Vec4ui(y, w, x, y)
        is Vec4us -> Vec4us(y, w, x, y)
        is Vec4ul -> Vec4ul(y, w, x, y)
        else -> throw IllegalStateException()
    }
    var ywxz @JvmName("ywxz") get() = when (this) {
        is Vec4 -> Vec4(y, w, x, z)
        is Vec4d -> Vec4d(y, w, x, z)
        is Vec4b -> Vec4b(y, w, x, z)
        is Vec4i -> Vec4i(y, w, x, z)
        is Vec4s -> Vec4s(y, w, x, z)
        is Vec4l -> Vec4l(y, w, x, z)
        is Vec4ub -> Vec4ub(y, w, x, z)
        is Vec4ui -> Vec4ui(y, w, x, z)
        is Vec4us -> Vec4us(y, w, x, z)
        is Vec4ul -> Vec4ul(y, w, x, z)
        else -> throw IllegalStateException()
    }
        @JvmName("ywxz") set(value) {
            y = value.x as T
            w = value.y as T
            x = value.z as T
            z = value.w as T
        }
    val ywxw @JvmName("ywxw") get() = when (this) {
        is Vec4 -> Vec4(y, w, x, w)
        is Vec4d -> Vec4d(y, w, x, w)
        is Vec4b -> Vec4b(y, w, x, w)
        is Vec4i -> Vec4i(y, w, x, w)
        is Vec4s -> Vec4s(y, w, x, w)
        is Vec4l -> Vec4l(y, w, x, w)
        is Vec4ub -> Vec4ub(y, w, x, w)
        is Vec4ui -> Vec4ui(y, w, x, w)
        is Vec4us -> Vec4us(y, w, x, w)
        is Vec4ul -> Vec4ul(y, w, x, w)
        else -> throw IllegalStateException()
    }
    val ywyx @JvmName("ywyx") get() = when (this) {
        is Vec4 -> Vec4(y, w, y, x)
        is Vec4d -> Vec4d(y, w, y, x)
        is Vec4b -> Vec4b(y, w, y, x)
        is Vec4i -> Vec4i(y, w, y, x)
        is Vec4s -> Vec4s(y, w, y, x)
        is Vec4l -> Vec4l(y, w, y, x)
        is Vec4ub -> Vec4ub(y, w, y, x)
        is Vec4ui -> Vec4ui(y, w, y, x)
        is Vec4us -> Vec4us(y, w, y, x)
        is Vec4ul -> Vec4ul(y, w, y, x)
        else -> throw IllegalStateException()
    }
    val ywyy @JvmName("ywyy") get() = when (this) {
        is Vec4 -> Vec4(y, w, y, y)
        is Vec4d -> Vec4d(y, w, y, y)
        is Vec4b -> Vec4b(y, w, y, y)
        is Vec4i -> Vec4i(y, w, y, y)
        is Vec4s -> Vec4s(y, w, y, y)
        is Vec4l -> Vec4l(y, w, y, y)
        is Vec4ub -> Vec4ub(y, w, y, y)
        is Vec4ui -> Vec4ui(y, w, y, y)
        is Vec4us -> Vec4us(y, w, y, y)
        is Vec4ul -> Vec4ul(y, w, y, y)
        else -> throw IllegalStateException()
    }
    val ywyz @JvmName("ywyz") get() = when (this) {
        is Vec4 -> Vec4(y, w, y, z)
        is Vec4d -> Vec4d(y, w, y, z)
        is Vec4b -> Vec4b(y, w, y, z)
        is Vec4i -> Vec4i(y, w, y, z)
        is Vec4s -> Vec4s(y, w, y, z)
        is Vec4l -> Vec4l(y, w, y, z)
        is Vec4ub -> Vec4ub(y, w, y, z)
        is Vec4ui -> Vec4ui(y, w, y, z)
        is Vec4us -> Vec4us(y, w, y, z)
        is Vec4ul -> Vec4ul(y, w, y, z)
        else -> throw IllegalStateException()
    }
    val ywyw @JvmName("ywyw") get() = when (this) {
        is Vec4 -> Vec4(y, w, y, w)
        is Vec4d -> Vec4d(y, w, y, w)
        is Vec4b -> Vec4b(y, w, y, w)
        is Vec4i -> Vec4i(y, w, y, w)
        is Vec4s -> Vec4s(y, w, y, w)
        is Vec4l -> Vec4l(y, w, y, w)
        is Vec4ub -> Vec4ub(y, w, y, w)
        is Vec4ui -> Vec4ui(y, w, y, w)
        is Vec4us -> Vec4us(y, w, y, w)
        is Vec4ul -> Vec4ul(y, w, y, w)
        else -> throw IllegalStateException()
    }
    var ywzx @JvmName("ywzx") get() = when (this) {
        is Vec4 -> Vec4(y, w, z, x)
        is Vec4d -> Vec4d(y, w, z, x)
        is Vec4b -> Vec4b(y, w, z, x)
        is Vec4i -> Vec4i(y, w, z, x)
        is Vec4s -> Vec4s(y, w, z, x)
        is Vec4l -> Vec4l(y, w, z, x)
        is Vec4ub -> Vec4ub(y, w, z, x)
        is Vec4ui -> Vec4ui(y, w, z, x)
        is Vec4us -> Vec4us(y, w, z, x)
        is Vec4ul -> Vec4ul(y, w, z, x)
        else -> throw IllegalStateException()
    }
        @JvmName("ywzx") set(value) {
            y = value.x as T
            w = value.y as T
            z = value.z as T
            x = value.w as T
        }
    val ywzy @JvmName("ywzy") get() = when (this) {
        is Vec4 -> Vec4(y, w, z, y)
        is Vec4d -> Vec4d(y, w, z, y)
        is Vec4b -> Vec4b(y, w, z, y)
        is Vec4i -> Vec4i(y, w, z, y)
        is Vec4s -> Vec4s(y, w, z, y)
        is Vec4l -> Vec4l(y, w, z, y)
        is Vec4ub -> Vec4ub(y, w, z, y)
        is Vec4ui -> Vec4ui(y, w, z, y)
        is Vec4us -> Vec4us(y, w, z, y)
        is Vec4ul -> Vec4ul(y, w, z, y)
        else -> throw IllegalStateException()
    }
    val ywzz @JvmName("ywzz") get() = when (this) {
        is Vec4 -> Vec4(y, w, z, z)
        is Vec4d -> Vec4d(y, w, z, z)
        is Vec4b -> Vec4b(y, w, z, z)
        is Vec4i -> Vec4i(y, w, z, z)
        is Vec4s -> Vec4s(y, w, z, z)
        is Vec4l -> Vec4l(y, w, z, z)
        is Vec4ub -> Vec4ub(y, w, z, z)
        is Vec4ui -> Vec4ui(y, w, z, z)
        is Vec4us -> Vec4us(y, w, z, z)
        is Vec4ul -> Vec4ul(y, w, z, z)
        else -> throw IllegalStateException()
    }
    val ywzw @JvmName("ywzw") get() = when (this) {
        is Vec4 -> Vec4(y, w, z, w)
        is Vec4d -> Vec4d(y, w, z, w)
        is Vec4b -> Vec4b(y, w, z, w)
        is Vec4i -> Vec4i(y, w, z, w)
        is Vec4s -> Vec4s(y, w, z, w)
        is Vec4l -> Vec4l(y, w, z, w)
        is Vec4ub -> Vec4ub(y, w, z, w)
        is Vec4ui -> Vec4ui(y, w, z, w)
        is Vec4us -> Vec4us(y, w, z, w)
        is Vec4ul -> Vec4ul(y, w, z, w)
        else -> throw IllegalStateException()
    }
    val ywwx @JvmName("ywwx") get() = when (this) {
        is Vec4 -> Vec4(y, w, w, x)
        is Vec4d -> Vec4d(y, w, w, x)
        is Vec4b -> Vec4b(y, w, w, x)
        is Vec4i -> Vec4i(y, w, w, x)
        is Vec4s -> Vec4s(y, w, w, x)
        is Vec4l -> Vec4l(y, w, w, x)
        is Vec4ub -> Vec4ub(y, w, w, x)
        is Vec4ui -> Vec4ui(y, w, w, x)
        is Vec4us -> Vec4us(y, w, w, x)
        is Vec4ul -> Vec4ul(y, w, w, x)
        else -> throw IllegalStateException()
    }
    val ywwy @JvmName("ywwy") get() = when (this) {
        is Vec4 -> Vec4(y, w, w, y)
        is Vec4d -> Vec4d(y, w, w, y)
        is Vec4b -> Vec4b(y, w, w, y)
        is Vec4i -> Vec4i(y, w, w, y)
        is Vec4s -> Vec4s(y, w, w, y)
        is Vec4l -> Vec4l(y, w, w, y)
        is Vec4ub -> Vec4ub(y, w, w, y)
        is Vec4ui -> Vec4ui(y, w, w, y)
        is Vec4us -> Vec4us(y, w, w, y)
        is Vec4ul -> Vec4ul(y, w, w, y)
        else -> throw IllegalStateException()
    }
    val ywwz @JvmName("ywwz") get() = when (this) {
        is Vec4 -> Vec4(y, w, w, z)
        is Vec4d -> Vec4d(y, w, w, z)
        is Vec4b -> Vec4b(y, w, w, z)
        is Vec4i -> Vec4i(y, w, w, z)
        is Vec4s -> Vec4s(y, w, w, z)
        is Vec4l -> Vec4l(y, w, w, z)
        is Vec4ub -> Vec4ub(y, w, w, z)
        is Vec4ui -> Vec4ui(y, w, w, z)
        is Vec4us -> Vec4us(y, w, w, z)
        is Vec4ul -> Vec4ul(y, w, w, z)
        else -> throw IllegalStateException()
    }
    val ywww @JvmName("ywww") get() = when (this) {
        is Vec4 -> Vec4(y, w, w, w)
        is Vec4d -> Vec4d(y, w, w, w)
        is Vec4b -> Vec4b(y, w, w, w)
        is Vec4i -> Vec4i(y, w, w, w)
        is Vec4s -> Vec4s(y, w, w, w)
        is Vec4l -> Vec4l(y, w, w, w)
        is Vec4ub -> Vec4ub(y, w, w, w)
        is Vec4ui -> Vec4ui(y, w, w, w)
        is Vec4us -> Vec4us(y, w, w, w)
        is Vec4ul -> Vec4ul(y, w, w, w)
        else -> throw IllegalStateException()
    }
    val zxxx @JvmName("zxxx") get() = when (this) {
        is Vec4 -> Vec4(z, x, x, x)
        is Vec4d -> Vec4d(z, x, x, x)
        is Vec4b -> Vec4b(z, x, x, x)
        is Vec4i -> Vec4i(z, x, x, x)
        is Vec4s -> Vec4s(z, x, x, x)
        is Vec4l -> Vec4l(z, x, x, x)
        is Vec4ub -> Vec4ub(z, x, x, x)
        is Vec4ui -> Vec4ui(z, x, x, x)
        is Vec4us -> Vec4us(z, x, x, x)
        is Vec4ul -> Vec4ul(z, x, x, x)
        else -> throw IllegalStateException()
    }
    val zxxy @JvmName("zxxy") get() = when (this) {
        is Vec4 -> Vec4(z, x, x, y)
        is Vec4d -> Vec4d(z, x, x, y)
        is Vec4b -> Vec4b(z, x, x, y)
        is Vec4i -> Vec4i(z, x, x, y)
        is Vec4s -> Vec4s(z, x, x, y)
        is Vec4l -> Vec4l(z, x, x, y)
        is Vec4ub -> Vec4ub(z, x, x, y)
        is Vec4ui -> Vec4ui(z, x, x, y)
        is Vec4us -> Vec4us(z, x, x, y)
        is Vec4ul -> Vec4ul(z, x, x, y)
        else -> throw IllegalStateException()
    }
    val zxxz @JvmName("zxxz") get() = when (this) {
        is Vec4 -> Vec4(z, x, x, z)
        is Vec4d -> Vec4d(z, x, x, z)
        is Vec4b -> Vec4b(z, x, x, z)
        is Vec4i -> Vec4i(z, x, x, z)
        is Vec4s -> Vec4s(z, x, x, z)
        is Vec4l -> Vec4l(z, x, x, z)
        is Vec4ub -> Vec4ub(z, x, x, z)
        is Vec4ui -> Vec4ui(z, x, x, z)
        is Vec4us -> Vec4us(z, x, x, z)
        is Vec4ul -> Vec4ul(z, x, x, z)
        else -> throw IllegalStateException()
    }
    val zxxw @JvmName("zxxw") get() = when (this) {
        is Vec4 -> Vec4(z, x, x, w)
        is Vec4d -> Vec4d(z, x, x, w)
        is Vec4b -> Vec4b(z, x, x, w)
        is Vec4i -> Vec4i(z, x, x, w)
        is Vec4s -> Vec4s(z, x, x, w)
        is Vec4l -> Vec4l(z, x, x, w)
        is Vec4ub -> Vec4ub(z, x, x, w)
        is Vec4ui -> Vec4ui(z, x, x, w)
        is Vec4us -> Vec4us(z, x, x, w)
        is Vec4ul -> Vec4ul(z, x, x, w)
        else -> throw IllegalStateException()
    }
    val zxyx @JvmName("zxyx") get() = when (this) {
        is Vec4 -> Vec4(z, x, y, x)
        is Vec4d -> Vec4d(z, x, y, x)
        is Vec4b -> Vec4b(z, x, y, x)
        is Vec4i -> Vec4i(z, x, y, x)
        is Vec4s -> Vec4s(z, x, y, x)
        is Vec4l -> Vec4l(z, x, y, x)
        is Vec4ub -> Vec4ub(z, x, y, x)
        is Vec4ui -> Vec4ui(z, x, y, x)
        is Vec4us -> Vec4us(z, x, y, x)
        is Vec4ul -> Vec4ul(z, x, y, x)
        else -> throw IllegalStateException()
    }
    val zxyy @JvmName("zxyy") get() = when (this) {
        is Vec4 -> Vec4(z, x, y, y)
        is Vec4d -> Vec4d(z, x, y, y)
        is Vec4b -> Vec4b(z, x, y, y)
        is Vec4i -> Vec4i(z, x, y, y)
        is Vec4s -> Vec4s(z, x, y, y)
        is Vec4l -> Vec4l(z, x, y, y)
        is Vec4ub -> Vec4ub(z, x, y, y)
        is Vec4ui -> Vec4ui(z, x, y, y)
        is Vec4us -> Vec4us(z, x, y, y)
        is Vec4ul -> Vec4ul(z, x, y, y)
        else -> throw IllegalStateException()
    }
    val zxyz @JvmName("zxyz") get() = when (this) {
        is Vec4 -> Vec4(z, x, y, z)
        is Vec4d -> Vec4d(z, x, y, z)
        is Vec4b -> Vec4b(z, x, y, z)
        is Vec4i -> Vec4i(z, x, y, z)
        is Vec4s -> Vec4s(z, x, y, z)
        is Vec4l -> Vec4l(z, x, y, z)
        is Vec4ub -> Vec4ub(z, x, y, z)
        is Vec4ui -> Vec4ui(z, x, y, z)
        is Vec4us -> Vec4us(z, x, y, z)
        is Vec4ul -> Vec4ul(z, x, y, z)
        else -> throw IllegalStateException()
    }
    var zxyw @JvmName("zxyw") get() = when (this) {
        is Vec4 -> Vec4(z, x, y, w)
        is Vec4d -> Vec4d(z, x, y, w)
        is Vec4b -> Vec4b(z, x, y, w)
        is Vec4i -> Vec4i(z, x, y, w)
        is Vec4s -> Vec4s(z, x, y, w)
        is Vec4l -> Vec4l(z, x, y, w)
        is Vec4ub -> Vec4ub(z, x, y, w)
        is Vec4ui -> Vec4ui(z, x, y, w)
        is Vec4us -> Vec4us(z, x, y, w)
        is Vec4ul -> Vec4ul(z, x, y, w)
        else -> throw IllegalStateException()
    }
        @JvmName("zxyw") set(value) {
            z = value.x as T
            x = value.y as T
            y = value.z as T
            w = value.w as T
        }
    val zxzx @JvmName("zxzx") get() = when (this) {
        is Vec4 -> Vec4(z, x, z, x)
        is Vec4d -> Vec4d(z, x, z, x)
        is Vec4b -> Vec4b(z, x, z, x)
        is Vec4i -> Vec4i(z, x, z, x)
        is Vec4s -> Vec4s(z, x, z, x)
        is Vec4l -> Vec4l(z, x, z, x)
        is Vec4ub -> Vec4ub(z, x, z, x)
        is Vec4ui -> Vec4ui(z, x, z, x)
        is Vec4us -> Vec4us(z, x, z, x)
        is Vec4ul -> Vec4ul(z, x, z, x)
        else -> throw IllegalStateException()
    }
    val zxzy @JvmName("zxzy") get() = when (this) {
        is Vec4 -> Vec4(z, x, z, y)
        is Vec4d -> Vec4d(z, x, z, y)
        is Vec4b -> Vec4b(z, x, z, y)
        is Vec4i -> Vec4i(z, x, z, y)
        is Vec4s -> Vec4s(z, x, z, y)
        is Vec4l -> Vec4l(z, x, z, y)
        is Vec4ub -> Vec4ub(z, x, z, y)
        is Vec4ui -> Vec4ui(z, x, z, y)
        is Vec4us -> Vec4us(z, x, z, y)
        is Vec4ul -> Vec4ul(z, x, z, y)
        else -> throw IllegalStateException()
    }
    val zxzz @JvmName("zxzz") get() = when (this) {
        is Vec4 -> Vec4(z, x, z, z)
        is Vec4d -> Vec4d(z, x, z, z)
        is Vec4b -> Vec4b(z, x, z, z)
        is Vec4i -> Vec4i(z, x, z, z)
        is Vec4s -> Vec4s(z, x, z, z)
        is Vec4l -> Vec4l(z, x, z, z)
        is Vec4ub -> Vec4ub(z, x, z, z)
        is Vec4ui -> Vec4ui(z, x, z, z)
        is Vec4us -> Vec4us(z, x, z, z)
        is Vec4ul -> Vec4ul(z, x, z, z)
        else -> throw IllegalStateException()
    }
    val zxzw @JvmName("zxzw") get() = when (this) {
        is Vec4 -> Vec4(z, x, z, w)
        is Vec4d -> Vec4d(z, x, z, w)
        is Vec4b -> Vec4b(z, x, z, w)
        is Vec4i -> Vec4i(z, x, z, w)
        is Vec4s -> Vec4s(z, x, z, w)
        is Vec4l -> Vec4l(z, x, z, w)
        is Vec4ub -> Vec4ub(z, x, z, w)
        is Vec4ui -> Vec4ui(z, x, z, w)
        is Vec4us -> Vec4us(z, x, z, w)
        is Vec4ul -> Vec4ul(z, x, z, w)
        else -> throw IllegalStateException()
    }
    val zxwx @JvmName("zxwx") get() = when (this) {
        is Vec4 -> Vec4(z, x, w, x)
        is Vec4d -> Vec4d(z, x, w, x)
        is Vec4b -> Vec4b(z, x, w, x)
        is Vec4i -> Vec4i(z, x, w, x)
        is Vec4s -> Vec4s(z, x, w, x)
        is Vec4l -> Vec4l(z, x, w, x)
        is Vec4ub -> Vec4ub(z, x, w, x)
        is Vec4ui -> Vec4ui(z, x, w, x)
        is Vec4us -> Vec4us(z, x, w, x)
        is Vec4ul -> Vec4ul(z, x, w, x)
        else -> throw IllegalStateException()
    }
    var zxwy @JvmName("zxwy") get() = when (this) {
        is Vec4 -> Vec4(z, x, w, y)
        is Vec4d -> Vec4d(z, x, w, y)
        is Vec4b -> Vec4b(z, x, w, y)
        is Vec4i -> Vec4i(z, x, w, y)
        is Vec4s -> Vec4s(z, x, w, y)
        is Vec4l -> Vec4l(z, x, w, y)
        is Vec4ub -> Vec4ub(z, x, w, y)
        is Vec4ui -> Vec4ui(z, x, w, y)
        is Vec4us -> Vec4us(z, x, w, y)
        is Vec4ul -> Vec4ul(z, x, w, y)
        else -> throw IllegalStateException()
    }
        @JvmName("zxwy") set(value) {
            z = value.x as T
            x = value.y as T
            w = value.z as T
            y = value.w as T
        }
    val zxwz @JvmName("zxwz") get() = when (this) {
        is Vec4 -> Vec4(z, x, w, z)
        is Vec4d -> Vec4d(z, x, w, z)
        is Vec4b -> Vec4b(z, x, w, z)
        is Vec4i -> Vec4i(z, x, w, z)
        is Vec4s -> Vec4s(z, x, w, z)
        is Vec4l -> Vec4l(z, x, w, z)
        is Vec4ub -> Vec4ub(z, x, w, z)
        is Vec4ui -> Vec4ui(z, x, w, z)
        is Vec4us -> Vec4us(z, x, w, z)
        is Vec4ul -> Vec4ul(z, x, w, z)
        else -> throw IllegalStateException()
    }
    val zxww @JvmName("zxww") get() = when (this) {
        is Vec4 -> Vec4(z, x, w, w)
        is Vec4d -> Vec4d(z, x, w, w)
        is Vec4b -> Vec4b(z, x, w, w)
        is Vec4i -> Vec4i(z, x, w, w)
        is Vec4s -> Vec4s(z, x, w, w)
        is Vec4l -> Vec4l(z, x, w, w)
        is Vec4ub -> Vec4ub(z, x, w, w)
        is Vec4ui -> Vec4ui(z, x, w, w)
        is Vec4us -> Vec4us(z, x, w, w)
        is Vec4ul -> Vec4ul(z, x, w, w)
        else -> throw IllegalStateException()
    }
    val zyxx @JvmName("zyxx") get() = when (this) {
        is Vec4 -> Vec4(z, y, x, x)
        is Vec4d -> Vec4d(z, y, x, x)
        is Vec4b -> Vec4b(z, y, x, x)
        is Vec4i -> Vec4i(z, y, x, x)
        is Vec4s -> Vec4s(z, y, x, x)
        is Vec4l -> Vec4l(z, y, x, x)
        is Vec4ub -> Vec4ub(z, y, x, x)
        is Vec4ui -> Vec4ui(z, y, x, x)
        is Vec4us -> Vec4us(z, y, x, x)
        is Vec4ul -> Vec4ul(z, y, x, x)
        else -> throw IllegalStateException()
    }
    val zyxy @JvmName("zyxy") get() = when (this) {
        is Vec4 -> Vec4(z, y, x, y)
        is Vec4d -> Vec4d(z, y, x, y)
        is Vec4b -> Vec4b(z, y, x, y)
        is Vec4i -> Vec4i(z, y, x, y)
        is Vec4s -> Vec4s(z, y, x, y)
        is Vec4l -> Vec4l(z, y, x, y)
        is Vec4ub -> Vec4ub(z, y, x, y)
        is Vec4ui -> Vec4ui(z, y, x, y)
        is Vec4us -> Vec4us(z, y, x, y)
        is Vec4ul -> Vec4ul(z, y, x, y)
        else -> throw IllegalStateException()
    }
    val zyxz @JvmName("zyxz") get() = when (this) {
        is Vec4 -> Vec4(z, y, x, z)
        is Vec4d -> Vec4d(z, y, x, z)
        is Vec4b -> Vec4b(z, y, x, z)
        is Vec4i -> Vec4i(z, y, x, z)
        is Vec4s -> Vec4s(z, y, x, z)
        is Vec4l -> Vec4l(z, y, x, z)
        is Vec4ub -> Vec4ub(z, y, x, z)
        is Vec4ui -> Vec4ui(z, y, x, z)
        is Vec4us -> Vec4us(z, y, x, z)
        is Vec4ul -> Vec4ul(z, y, x, z)
        else -> throw IllegalStateException()
    }
    var zyxw @JvmName("zyxw") get() = when (this) {
        is Vec4 -> Vec4(z, y, x, w)
        is Vec4d -> Vec4d(z, y, x, w)
        is Vec4b -> Vec4b(z, y, x, w)
        is Vec4i -> Vec4i(z, y, x, w)
        is Vec4s -> Vec4s(z, y, x, w)
        is Vec4l -> Vec4l(z, y, x, w)
        is Vec4ub -> Vec4ub(z, y, x, w)
        is Vec4ui -> Vec4ui(z, y, x, w)
        is Vec4us -> Vec4us(z, y, x, w)
        is Vec4ul -> Vec4ul(z, y, x, w)
        else -> throw IllegalStateException()
    }
        @JvmName("zyxw") set(value) {
            z = value.x as T
            y = value.y as T
            x = value.z as T
            w = value.w as T
        }
    val zyyx @JvmName("zyyx") get() = when (this) {
        is Vec4 -> Vec4(z, y, y, x)
        is Vec4d -> Vec4d(z, y, y, x)
        is Vec4b -> Vec4b(z, y, y, x)
        is Vec4i -> Vec4i(z, y, y, x)
        is Vec4s -> Vec4s(z, y, y, x)
        is Vec4l -> Vec4l(z, y, y, x)
        is Vec4ub -> Vec4ub(z, y, y, x)
        is Vec4ui -> Vec4ui(z, y, y, x)
        is Vec4us -> Vec4us(z, y, y, x)
        is Vec4ul -> Vec4ul(z, y, y, x)
        else -> throw IllegalStateException()
    }
    val zyyy @JvmName("zyyy") get() = when (this) {
        is Vec4 -> Vec4(z, y, y, y)
        is Vec4d -> Vec4d(z, y, y, y)
        is Vec4b -> Vec4b(z, y, y, y)
        is Vec4i -> Vec4i(z, y, y, y)
        is Vec4s -> Vec4s(z, y, y, y)
        is Vec4l -> Vec4l(z, y, y, y)
        is Vec4ub -> Vec4ub(z, y, y, y)
        is Vec4ui -> Vec4ui(z, y, y, y)
        is Vec4us -> Vec4us(z, y, y, y)
        is Vec4ul -> Vec4ul(z, y, y, y)
        else -> throw IllegalStateException()
    }
    val zyyz @JvmName("zyyz") get() = when (this) {
        is Vec4 -> Vec4(z, y, y, z)
        is Vec4d -> Vec4d(z, y, y, z)
        is Vec4b -> Vec4b(z, y, y, z)
        is Vec4i -> Vec4i(z, y, y, z)
        is Vec4s -> Vec4s(z, y, y, z)
        is Vec4l -> Vec4l(z, y, y, z)
        is Vec4ub -> Vec4ub(z, y, y, z)
        is Vec4ui -> Vec4ui(z, y, y, z)
        is Vec4us -> Vec4us(z, y, y, z)
        is Vec4ul -> Vec4ul(z, y, y, z)
        else -> throw IllegalStateException()
    }
    val zyyw @JvmName("zyyw") get() = when (this) {
        is Vec4 -> Vec4(z, y, y, w)
        is Vec4d -> Vec4d(z, y, y, w)
        is Vec4b -> Vec4b(z, y, y, w)
        is Vec4i -> Vec4i(z, y, y, w)
        is Vec4s -> Vec4s(z, y, y, w)
        is Vec4l -> Vec4l(z, y, y, w)
        is Vec4ub -> Vec4ub(z, y, y, w)
        is Vec4ui -> Vec4ui(z, y, y, w)
        is Vec4us -> Vec4us(z, y, y, w)
        is Vec4ul -> Vec4ul(z, y, y, w)
        else -> throw IllegalStateException()
    }
    val zyzx @JvmName("zyzx") get() = when (this) {
        is Vec4 -> Vec4(z, y, z, x)
        is Vec4d -> Vec4d(z, y, z, x)
        is Vec4b -> Vec4b(z, y, z, x)
        is Vec4i -> Vec4i(z, y, z, x)
        is Vec4s -> Vec4s(z, y, z, x)
        is Vec4l -> Vec4l(z, y, z, x)
        is Vec4ub -> Vec4ub(z, y, z, x)
        is Vec4ui -> Vec4ui(z, y, z, x)
        is Vec4us -> Vec4us(z, y, z, x)
        is Vec4ul -> Vec4ul(z, y, z, x)
        else -> throw IllegalStateException()
    }
    val zyzy @JvmName("zyzy") get() = when (this) {
        is Vec4 -> Vec4(z, y, z, y)
        is Vec4d -> Vec4d(z, y, z, y)
        is Vec4b -> Vec4b(z, y, z, y)
        is Vec4i -> Vec4i(z, y, z, y)
        is Vec4s -> Vec4s(z, y, z, y)
        is Vec4l -> Vec4l(z, y, z, y)
        is Vec4ub -> Vec4ub(z, y, z, y)
        is Vec4ui -> Vec4ui(z, y, z, y)
        is Vec4us -> Vec4us(z, y, z, y)
        is Vec4ul -> Vec4ul(z, y, z, y)
        else -> throw IllegalStateException()
    }
    val zyzz @JvmName("zyzz") get() = when (this) {
        is Vec4 -> Vec4(z, y, z, z)
        is Vec4d -> Vec4d(z, y, z, z)
        is Vec4b -> Vec4b(z, y, z, z)
        is Vec4i -> Vec4i(z, y, z, z)
        is Vec4s -> Vec4s(z, y, z, z)
        is Vec4l -> Vec4l(z, y, z, z)
        is Vec4ub -> Vec4ub(z, y, z, z)
        is Vec4ui -> Vec4ui(z, y, z, z)
        is Vec4us -> Vec4us(z, y, z, z)
        is Vec4ul -> Vec4ul(z, y, z, z)
        else -> throw IllegalStateException()
    }
    val zyzw @JvmName("zyzw") get() = when (this) {
        is Vec4 -> Vec4(z, y, z, w)
        is Vec4d -> Vec4d(z, y, z, w)
        is Vec4b -> Vec4b(z, y, z, w)
        is Vec4i -> Vec4i(z, y, z, w)
        is Vec4s -> Vec4s(z, y, z, w)
        is Vec4l -> Vec4l(z, y, z, w)
        is Vec4ub -> Vec4ub(z, y, z, w)
        is Vec4ui -> Vec4ui(z, y, z, w)
        is Vec4us -> Vec4us(z, y, z, w)
        is Vec4ul -> Vec4ul(z, y, z, w)
        else -> throw IllegalStateException()
    }
    var zywx @JvmName("zywx") get() = when (this) {
        is Vec4 -> Vec4(z, y, w, x)
        is Vec4d -> Vec4d(z, y, w, x)
        is Vec4b -> Vec4b(z, y, w, x)
        is Vec4i -> Vec4i(z, y, w, x)
        is Vec4s -> Vec4s(z, y, w, x)
        is Vec4l -> Vec4l(z, y, w, x)
        is Vec4ub -> Vec4ub(z, y, w, x)
        is Vec4ui -> Vec4ui(z, y, w, x)
        is Vec4us -> Vec4us(z, y, w, x)
        is Vec4ul -> Vec4ul(z, y, w, x)
        else -> throw IllegalStateException()
    }
        @JvmName("zywx") set(value) {
            z = value.x as T
            y = value.y as T
            w = value.z as T
            x = value.w as T
        }
    val zywy @JvmName("zywy") get() = when (this) {
        is Vec4 -> Vec4(z, y, w, y)
        is Vec4d -> Vec4d(z, y, w, y)
        is Vec4b -> Vec4b(z, y, w, y)
        is Vec4i -> Vec4i(z, y, w, y)
        is Vec4s -> Vec4s(z, y, w, y)
        is Vec4l -> Vec4l(z, y, w, y)
        is Vec4ub -> Vec4ub(z, y, w, y)
        is Vec4ui -> Vec4ui(z, y, w, y)
        is Vec4us -> Vec4us(z, y, w, y)
        is Vec4ul -> Vec4ul(z, y, w, y)
        else -> throw IllegalStateException()
    }
    val zywz @JvmName("zywz") get() = when (this) {
        is Vec4 -> Vec4(z, y, w, z)
        is Vec4d -> Vec4d(z, y, w, z)
        is Vec4b -> Vec4b(z, y, w, z)
        is Vec4i -> Vec4i(z, y, w, z)
        is Vec4s -> Vec4s(z, y, w, z)
        is Vec4l -> Vec4l(z, y, w, z)
        is Vec4ub -> Vec4ub(z, y, w, z)
        is Vec4ui -> Vec4ui(z, y, w, z)
        is Vec4us -> Vec4us(z, y, w, z)
        is Vec4ul -> Vec4ul(z, y, w, z)
        else -> throw IllegalStateException()
    }
    val zyww @JvmName("zyww") get() = when (this) {
        is Vec4 -> Vec4(z, y, w, w)
        is Vec4d -> Vec4d(z, y, w, w)
        is Vec4b -> Vec4b(z, y, w, w)
        is Vec4i -> Vec4i(z, y, w, w)
        is Vec4s -> Vec4s(z, y, w, w)
        is Vec4l -> Vec4l(z, y, w, w)
        is Vec4ub -> Vec4ub(z, y, w, w)
        is Vec4ui -> Vec4ui(z, y, w, w)
        is Vec4us -> Vec4us(z, y, w, w)
        is Vec4ul -> Vec4ul(z, y, w, w)
        else -> throw IllegalStateException()
    }
    val zzxx @JvmName("zzxx") get() = when (this) {
        is Vec4 -> Vec4(z, z, x, x)
        is Vec4d -> Vec4d(z, z, x, x)
        is Vec4b -> Vec4b(z, z, x, x)
        is Vec4i -> Vec4i(z, z, x, x)
        is Vec4s -> Vec4s(z, z, x, x)
        is Vec4l -> Vec4l(z, z, x, x)
        is Vec4ub -> Vec4ub(z, z, x, x)
        is Vec4ui -> Vec4ui(z, z, x, x)
        is Vec4us -> Vec4us(z, z, x, x)
        is Vec4ul -> Vec4ul(z, z, x, x)
        else -> throw IllegalStateException()
    }
    val zzxy @JvmName("zzxy") get() = when (this) {
        is Vec4 -> Vec4(z, z, x, y)
        is Vec4d -> Vec4d(z, z, x, y)
        is Vec4b -> Vec4b(z, z, x, y)
        is Vec4i -> Vec4i(z, z, x, y)
        is Vec4s -> Vec4s(z, z, x, y)
        is Vec4l -> Vec4l(z, z, x, y)
        is Vec4ub -> Vec4ub(z, z, x, y)
        is Vec4ui -> Vec4ui(z, z, x, y)
        is Vec4us -> Vec4us(z, z, x, y)
        is Vec4ul -> Vec4ul(z, z, x, y)
        else -> throw IllegalStateException()
    }
    val zzxz @JvmName("zzxz") get() = when (this) {
        is Vec4 -> Vec4(z, z, x, z)
        is Vec4d -> Vec4d(z, z, x, z)
        is Vec4b -> Vec4b(z, z, x, z)
        is Vec4i -> Vec4i(z, z, x, z)
        is Vec4s -> Vec4s(z, z, x, z)
        is Vec4l -> Vec4l(z, z, x, z)
        is Vec4ub -> Vec4ub(z, z, x, z)
        is Vec4ui -> Vec4ui(z, z, x, z)
        is Vec4us -> Vec4us(z, z, x, z)
        is Vec4ul -> Vec4ul(z, z, x, z)
        else -> throw IllegalStateException()
    }
    val zzxw @JvmName("zzxw") get() = when (this) {
        is Vec4 -> Vec4(z, z, x, w)
        is Vec4d -> Vec4d(z, z, x, w)
        is Vec4b -> Vec4b(z, z, x, w)
        is Vec4i -> Vec4i(z, z, x, w)
        is Vec4s -> Vec4s(z, z, x, w)
        is Vec4l -> Vec4l(z, z, x, w)
        is Vec4ub -> Vec4ub(z, z, x, w)
        is Vec4ui -> Vec4ui(z, z, x, w)
        is Vec4us -> Vec4us(z, z, x, w)
        is Vec4ul -> Vec4ul(z, z, x, w)
        else -> throw IllegalStateException()
    }
    val zzyx @JvmName("zzyx") get() = when (this) {
        is Vec4 -> Vec4(z, z, y, x)
        is Vec4d -> Vec4d(z, z, y, x)
        is Vec4b -> Vec4b(z, z, y, x)
        is Vec4i -> Vec4i(z, z, y, x)
        is Vec4s -> Vec4s(z, z, y, x)
        is Vec4l -> Vec4l(z, z, y, x)
        is Vec4ub -> Vec4ub(z, z, y, x)
        is Vec4ui -> Vec4ui(z, z, y, x)
        is Vec4us -> Vec4us(z, z, y, x)
        is Vec4ul -> Vec4ul(z, z, y, x)
        else -> throw IllegalStateException()
    }
    val zzyy @JvmName("zzyy") get() = when (this) {
        is Vec4 -> Vec4(z, z, y, y)
        is Vec4d -> Vec4d(z, z, y, y)
        is Vec4b -> Vec4b(z, z, y, y)
        is Vec4i -> Vec4i(z, z, y, y)
        is Vec4s -> Vec4s(z, z, y, y)
        is Vec4l -> Vec4l(z, z, y, y)
        is Vec4ub -> Vec4ub(z, z, y, y)
        is Vec4ui -> Vec4ui(z, z, y, y)
        is Vec4us -> Vec4us(z, z, y, y)
        is Vec4ul -> Vec4ul(z, z, y, y)
        else -> throw IllegalStateException()
    }
    val zzyz @JvmName("zzyz") get() = when (this) {
        is Vec4 -> Vec4(z, z, y, z)
        is Vec4d -> Vec4d(z, z, y, z)
        is Vec4b -> Vec4b(z, z, y, z)
        is Vec4i -> Vec4i(z, z, y, z)
        is Vec4s -> Vec4s(z, z, y, z)
        is Vec4l -> Vec4l(z, z, y, z)
        is Vec4ub -> Vec4ub(z, z, y, z)
        is Vec4ui -> Vec4ui(z, z, y, z)
        is Vec4us -> Vec4us(z, z, y, z)
        is Vec4ul -> Vec4ul(z, z, y, z)
        else -> throw IllegalStateException()
    }
    val zzyw @JvmName("zzyw") get() = when (this) {
        is Vec4 -> Vec4(z, z, y, w)
        is Vec4d -> Vec4d(z, z, y, w)
        is Vec4b -> Vec4b(z, z, y, w)
        is Vec4i -> Vec4i(z, z, y, w)
        is Vec4s -> Vec4s(z, z, y, w)
        is Vec4l -> Vec4l(z, z, y, w)
        is Vec4ub -> Vec4ub(z, z, y, w)
        is Vec4ui -> Vec4ui(z, z, y, w)
        is Vec4us -> Vec4us(z, z, y, w)
        is Vec4ul -> Vec4ul(z, z, y, w)
        else -> throw IllegalStateException()
    }
    val zzzx @JvmName("zzzx") get() = when (this) {
        is Vec4 -> Vec4(z, z, z, x)
        is Vec4d -> Vec4d(z, z, z, x)
        is Vec4b -> Vec4b(z, z, z, x)
        is Vec4i -> Vec4i(z, z, z, x)
        is Vec4s -> Vec4s(z, z, z, x)
        is Vec4l -> Vec4l(z, z, z, x)
        is Vec4ub -> Vec4ub(z, z, z, x)
        is Vec4ui -> Vec4ui(z, z, z, x)
        is Vec4us -> Vec4us(z, z, z, x)
        is Vec4ul -> Vec4ul(z, z, z, x)
        else -> throw IllegalStateException()
    }
    val zzzy @JvmName("zzzy") get() = when (this) {
        is Vec4 -> Vec4(z, z, z, y)
        is Vec4d -> Vec4d(z, z, z, y)
        is Vec4b -> Vec4b(z, z, z, y)
        is Vec4i -> Vec4i(z, z, z, y)
        is Vec4s -> Vec4s(z, z, z, y)
        is Vec4l -> Vec4l(z, z, z, y)
        is Vec4ub -> Vec4ub(z, z, z, y)
        is Vec4ui -> Vec4ui(z, z, z, y)
        is Vec4us -> Vec4us(z, z, z, y)
        is Vec4ul -> Vec4ul(z, z, z, y)
        else -> throw IllegalStateException()
    }
    val zzzz @JvmName("zzzz") get() = when (this) {
        is Vec4 -> Vec4(z, z, z, z)
        is Vec4d -> Vec4d(z, z, z, z)
        is Vec4b -> Vec4b(z, z, z, z)
        is Vec4i -> Vec4i(z, z, z, z)
        is Vec4s -> Vec4s(z, z, z, z)
        is Vec4l -> Vec4l(z, z, z, z)
        is Vec4ub -> Vec4ub(z, z, z, z)
        is Vec4ui -> Vec4ui(z, z, z, z)
        is Vec4us -> Vec4us(z, z, z, z)
        is Vec4ul -> Vec4ul(z, z, z, z)
        else -> throw IllegalStateException()
    }
    val zzzw @JvmName("zzzw") get() = when (this) {
        is Vec4 -> Vec4(z, z, z, w)
        is Vec4d -> Vec4d(z, z, z, w)
        is Vec4b -> Vec4b(z, z, z, w)
        is Vec4i -> Vec4i(z, z, z, w)
        is Vec4s -> Vec4s(z, z, z, w)
        is Vec4l -> Vec4l(z, z, z, w)
        is Vec4ub -> Vec4ub(z, z, z, w)
        is Vec4ui -> Vec4ui(z, z, z, w)
        is Vec4us -> Vec4us(z, z, z, w)
        is Vec4ul -> Vec4ul(z, z, z, w)
        else -> throw IllegalStateException()
    }
    val zzwx @JvmName("zzwx") get() = when (this) {
        is Vec4 -> Vec4(z, z, w, x)
        is Vec4d -> Vec4d(z, z, w, x)
        is Vec4b -> Vec4b(z, z, w, x)
        is Vec4i -> Vec4i(z, z, w, x)
        is Vec4s -> Vec4s(z, z, w, x)
        is Vec4l -> Vec4l(z, z, w, x)
        is Vec4ub -> Vec4ub(z, z, w, x)
        is Vec4ui -> Vec4ui(z, z, w, x)
        is Vec4us -> Vec4us(z, z, w, x)
        is Vec4ul -> Vec4ul(z, z, w, x)
        else -> throw IllegalStateException()
    }
    val zzwy @JvmName("zzwy") get() = when (this) {
        is Vec4 -> Vec4(z, z, w, y)
        is Vec4d -> Vec4d(z, z, w, y)
        is Vec4b -> Vec4b(z, z, w, y)
        is Vec4i -> Vec4i(z, z, w, y)
        is Vec4s -> Vec4s(z, z, w, y)
        is Vec4l -> Vec4l(z, z, w, y)
        is Vec4ub -> Vec4ub(z, z, w, y)
        is Vec4ui -> Vec4ui(z, z, w, y)
        is Vec4us -> Vec4us(z, z, w, y)
        is Vec4ul -> Vec4ul(z, z, w, y)
        else -> throw IllegalStateException()
    }
    val zzwz @JvmName("zzwz") get() = when (this) {
        is Vec4 -> Vec4(z, z, w, z)
        is Vec4d -> Vec4d(z, z, w, z)
        is Vec4b -> Vec4b(z, z, w, z)
        is Vec4i -> Vec4i(z, z, w, z)
        is Vec4s -> Vec4s(z, z, w, z)
        is Vec4l -> Vec4l(z, z, w, z)
        is Vec4ub -> Vec4ub(z, z, w, z)
        is Vec4ui -> Vec4ui(z, z, w, z)
        is Vec4us -> Vec4us(z, z, w, z)
        is Vec4ul -> Vec4ul(z, z, w, z)
        else -> throw IllegalStateException()
    }
    val zzww @JvmName("zzww") get() = when (this) {
        is Vec4 -> Vec4(z, z, w, w)
        is Vec4d -> Vec4d(z, z, w, w)
        is Vec4b -> Vec4b(z, z, w, w)
        is Vec4i -> Vec4i(z, z, w, w)
        is Vec4s -> Vec4s(z, z, w, w)
        is Vec4l -> Vec4l(z, z, w, w)
        is Vec4ub -> Vec4ub(z, z, w, w)
        is Vec4ui -> Vec4ui(z, z, w, w)
        is Vec4us -> Vec4us(z, z, w, w)
        is Vec4ul -> Vec4ul(z, z, w, w)
        else -> throw IllegalStateException()
    }
    val zwxx @JvmName("zwxx") get() = when (this) {
        is Vec4 -> Vec4(z, w, x, x)
        is Vec4d -> Vec4d(z, w, x, x)
        is Vec4b -> Vec4b(z, w, x, x)
        is Vec4i -> Vec4i(z, w, x, x)
        is Vec4s -> Vec4s(z, w, x, x)
        is Vec4l -> Vec4l(z, w, x, x)
        is Vec4ub -> Vec4ub(z, w, x, x)
        is Vec4ui -> Vec4ui(z, w, x, x)
        is Vec4us -> Vec4us(z, w, x, x)
        is Vec4ul -> Vec4ul(z, w, x, x)
        else -> throw IllegalStateException()
    }
    var zwxy @JvmName("zwxy") get() = when (this) {
        is Vec4 -> Vec4(z, w, x, y)
        is Vec4d -> Vec4d(z, w, x, y)
        is Vec4b -> Vec4b(z, w, x, y)
        is Vec4i -> Vec4i(z, w, x, y)
        is Vec4s -> Vec4s(z, w, x, y)
        is Vec4l -> Vec4l(z, w, x, y)
        is Vec4ub -> Vec4ub(z, w, x, y)
        is Vec4ui -> Vec4ui(z, w, x, y)
        is Vec4us -> Vec4us(z, w, x, y)
        is Vec4ul -> Vec4ul(z, w, x, y)
        else -> throw IllegalStateException()
    }
        @JvmName("zwxy") set(value) {
            z = value.x as T
            w = value.y as T
            x = value.z as T
            y = value.w as T
        }
    val zwxz @JvmName("zwxz") get() = when (this) {
        is Vec4 -> Vec4(z, w, x, z)
        is Vec4d -> Vec4d(z, w, x, z)
        is Vec4b -> Vec4b(z, w, x, z)
        is Vec4i -> Vec4i(z, w, x, z)
        is Vec4s -> Vec4s(z, w, x, z)
        is Vec4l -> Vec4l(z, w, x, z)
        is Vec4ub -> Vec4ub(z, w, x, z)
        is Vec4ui -> Vec4ui(z, w, x, z)
        is Vec4us -> Vec4us(z, w, x, z)
        is Vec4ul -> Vec4ul(z, w, x, z)
        else -> throw IllegalStateException()
    }
    val zwxw @JvmName("zwxw") get() = when (this) {
        is Vec4 -> Vec4(z, w, x, w)
        is Vec4d -> Vec4d(z, w, x, w)
        is Vec4b -> Vec4b(z, w, x, w)
        is Vec4i -> Vec4i(z, w, x, w)
        is Vec4s -> Vec4s(z, w, x, w)
        is Vec4l -> Vec4l(z, w, x, w)
        is Vec4ub -> Vec4ub(z, w, x, w)
        is Vec4ui -> Vec4ui(z, w, x, w)
        is Vec4us -> Vec4us(z, w, x, w)
        is Vec4ul -> Vec4ul(z, w, x, w)
        else -> throw IllegalStateException()
    }
    var zwyx @JvmName("zwyx") get() = when (this) {
        is Vec4 -> Vec4(z, w, y, x)
        is Vec4d -> Vec4d(z, w, y, x)
        is Vec4b -> Vec4b(z, w, y, x)
        is Vec4i -> Vec4i(z, w, y, x)
        is Vec4s -> Vec4s(z, w, y, x)
        is Vec4l -> Vec4l(z, w, y, x)
        is Vec4ub -> Vec4ub(z, w, y, x)
        is Vec4ui -> Vec4ui(z, w, y, x)
        is Vec4us -> Vec4us(z, w, y, x)
        is Vec4ul -> Vec4ul(z, w, y, x)
        else -> throw IllegalStateException()
    }
        @JvmName("zwyx") set(value) {
            z = value.x as T
            w = value.y as T
            y = value.z as T
            x = value.w as T
        }
    val zwyy @JvmName("zwyy") get() = when (this) {
        is Vec4 -> Vec4(z, w, y, y)
        is Vec4d -> Vec4d(z, w, y, y)
        is Vec4b -> Vec4b(z, w, y, y)
        is Vec4i -> Vec4i(z, w, y, y)
        is Vec4s -> Vec4s(z, w, y, y)
        is Vec4l -> Vec4l(z, w, y, y)
        is Vec4ub -> Vec4ub(z, w, y, y)
        is Vec4ui -> Vec4ui(z, w, y, y)
        is Vec4us -> Vec4us(z, w, y, y)
        is Vec4ul -> Vec4ul(z, w, y, y)
        else -> throw IllegalStateException()
    }
    val zwyz @JvmName("zwyz") get() = when (this) {
        is Vec4 -> Vec4(z, w, y, z)
        is Vec4d -> Vec4d(z, w, y, z)
        is Vec4b -> Vec4b(z, w, y, z)
        is Vec4i -> Vec4i(z, w, y, z)
        is Vec4s -> Vec4s(z, w, y, z)
        is Vec4l -> Vec4l(z, w, y, z)
        is Vec4ub -> Vec4ub(z, w, y, z)
        is Vec4ui -> Vec4ui(z, w, y, z)
        is Vec4us -> Vec4us(z, w, y, z)
        is Vec4ul -> Vec4ul(z, w, y, z)
        else -> throw IllegalStateException()
    }
    val zwyw @JvmName("zwyw") get() = when (this) {
        is Vec4 -> Vec4(z, w, y, w)
        is Vec4d -> Vec4d(z, w, y, w)
        is Vec4b -> Vec4b(z, w, y, w)
        is Vec4i -> Vec4i(z, w, y, w)
        is Vec4s -> Vec4s(z, w, y, w)
        is Vec4l -> Vec4l(z, w, y, w)
        is Vec4ub -> Vec4ub(z, w, y, w)
        is Vec4ui -> Vec4ui(z, w, y, w)
        is Vec4us -> Vec4us(z, w, y, w)
        is Vec4ul -> Vec4ul(z, w, y, w)
        else -> throw IllegalStateException()
    }
    val zwzx @JvmName("zwzx") get() = when (this) {
        is Vec4 -> Vec4(z, w, z, x)
        is Vec4d -> Vec4d(z, w, z, x)
        is Vec4b -> Vec4b(z, w, z, x)
        is Vec4i -> Vec4i(z, w, z, x)
        is Vec4s -> Vec4s(z, w, z, x)
        is Vec4l -> Vec4l(z, w, z, x)
        is Vec4ub -> Vec4ub(z, w, z, x)
        is Vec4ui -> Vec4ui(z, w, z, x)
        is Vec4us -> Vec4us(z, w, z, x)
        is Vec4ul -> Vec4ul(z, w, z, x)
        else -> throw IllegalStateException()
    }
    val zwzy @JvmName("zwzy") get() = when (this) {
        is Vec4 -> Vec4(z, w, z, y)
        is Vec4d -> Vec4d(z, w, z, y)
        is Vec4b -> Vec4b(z, w, z, y)
        is Vec4i -> Vec4i(z, w, z, y)
        is Vec4s -> Vec4s(z, w, z, y)
        is Vec4l -> Vec4l(z, w, z, y)
        is Vec4ub -> Vec4ub(z, w, z, y)
        is Vec4ui -> Vec4ui(z, w, z, y)
        is Vec4us -> Vec4us(z, w, z, y)
        is Vec4ul -> Vec4ul(z, w, z, y)
        else -> throw IllegalStateException()
    }
    val zwzz @JvmName("zwzz") get() = when (this) {
        is Vec4 -> Vec4(z, w, z, z)
        is Vec4d -> Vec4d(z, w, z, z)
        is Vec4b -> Vec4b(z, w, z, z)
        is Vec4i -> Vec4i(z, w, z, z)
        is Vec4s -> Vec4s(z, w, z, z)
        is Vec4l -> Vec4l(z, w, z, z)
        is Vec4ub -> Vec4ub(z, w, z, z)
        is Vec4ui -> Vec4ui(z, w, z, z)
        is Vec4us -> Vec4us(z, w, z, z)
        is Vec4ul -> Vec4ul(z, w, z, z)
        else -> throw IllegalStateException()
    }
    val zwzw @JvmName("zwzw") get() = when (this) {
        is Vec4 -> Vec4(z, w, z, w)
        is Vec4d -> Vec4d(z, w, z, w)
        is Vec4b -> Vec4b(z, w, z, w)
        is Vec4i -> Vec4i(z, w, z, w)
        is Vec4s -> Vec4s(z, w, z, w)
        is Vec4l -> Vec4l(z, w, z, w)
        is Vec4ub -> Vec4ub(z, w, z, w)
        is Vec4ui -> Vec4ui(z, w, z, w)
        is Vec4us -> Vec4us(z, w, z, w)
        is Vec4ul -> Vec4ul(z, w, z, w)
        else -> throw IllegalStateException()
    }
    val zwwx @JvmName("zwwx") get() = when (this) {
        is Vec4 -> Vec4(z, w, w, x)
        is Vec4d -> Vec4d(z, w, w, x)
        is Vec4b -> Vec4b(z, w, w, x)
        is Vec4i -> Vec4i(z, w, w, x)
        is Vec4s -> Vec4s(z, w, w, x)
        is Vec4l -> Vec4l(z, w, w, x)
        is Vec4ub -> Vec4ub(z, w, w, x)
        is Vec4ui -> Vec4ui(z, w, w, x)
        is Vec4us -> Vec4us(z, w, w, x)
        is Vec4ul -> Vec4ul(z, w, w, x)
        else -> throw IllegalStateException()
    }
    val zwwy @JvmName("zwwy") get() = when (this) {
        is Vec4 -> Vec4(z, w, w, y)
        is Vec4d -> Vec4d(z, w, w, y)
        is Vec4b -> Vec4b(z, w, w, y)
        is Vec4i -> Vec4i(z, w, w, y)
        is Vec4s -> Vec4s(z, w, w, y)
        is Vec4l -> Vec4l(z, w, w, y)
        is Vec4ub -> Vec4ub(z, w, w, y)
        is Vec4ui -> Vec4ui(z, w, w, y)
        is Vec4us -> Vec4us(z, w, w, y)
        is Vec4ul -> Vec4ul(z, w, w, y)
        else -> throw IllegalStateException()
    }
    val zwwz @JvmName("zwwz") get() = when (this) {
        is Vec4 -> Vec4(z, w, w, z)
        is Vec4d -> Vec4d(z, w, w, z)
        is Vec4b -> Vec4b(z, w, w, z)
        is Vec4i -> Vec4i(z, w, w, z)
        is Vec4s -> Vec4s(z, w, w, z)
        is Vec4l -> Vec4l(z, w, w, z)
        is Vec4ub -> Vec4ub(z, w, w, z)
        is Vec4ui -> Vec4ui(z, w, w, z)
        is Vec4us -> Vec4us(z, w, w, z)
        is Vec4ul -> Vec4ul(z, w, w, z)
        else -> throw IllegalStateException()
    }
    val zwww @JvmName("zwww") get() = when (this) {
        is Vec4 -> Vec4(z, w, w, w)
        is Vec4d -> Vec4d(z, w, w, w)
        is Vec4b -> Vec4b(z, w, w, w)
        is Vec4i -> Vec4i(z, w, w, w)
        is Vec4s -> Vec4s(z, w, w, w)
        is Vec4l -> Vec4l(z, w, w, w)
        is Vec4ub -> Vec4ub(z, w, w, w)
        is Vec4ui -> Vec4ui(z, w, w, w)
        is Vec4us -> Vec4us(z, w, w, w)
        is Vec4ul -> Vec4ul(z, w, w, w)
        else -> throw IllegalStateException()
    }
    val wxxx @JvmName("wxxx") get() = when (this) {
        is Vec4 -> Vec4(w, x, x, x)
        is Vec4d -> Vec4d(w, x, x, x)
        is Vec4b -> Vec4b(w, x, x, x)
        is Vec4i -> Vec4i(w, x, x, x)
        is Vec4s -> Vec4s(w, x, x, x)
        is Vec4l -> Vec4l(w, x, x, x)
        is Vec4ub -> Vec4ub(w, x, x, x)
        is Vec4ui -> Vec4ui(w, x, x, x)
        is Vec4us -> Vec4us(w, x, x, x)
        is Vec4ul -> Vec4ul(w, x, x, x)
        else -> throw IllegalStateException()
    }
    val wxxy @JvmName("wxxy") get() = when (this) {
        is Vec4 -> Vec4(w, x, x, y)
        is Vec4d -> Vec4d(w, x, x, y)
        is Vec4b -> Vec4b(w, x, x, y)
        is Vec4i -> Vec4i(w, x, x, y)
        is Vec4s -> Vec4s(w, x, x, y)
        is Vec4l -> Vec4l(w, x, x, y)
        is Vec4ub -> Vec4ub(w, x, x, y)
        is Vec4ui -> Vec4ui(w, x, x, y)
        is Vec4us -> Vec4us(w, x, x, y)
        is Vec4ul -> Vec4ul(w, x, x, y)
        else -> throw IllegalStateException()
    }
    val wxxz @JvmName("wxxz") get() = when (this) {
        is Vec4 -> Vec4(w, x, x, z)
        is Vec4d -> Vec4d(w, x, x, z)
        is Vec4b -> Vec4b(w, x, x, z)
        is Vec4i -> Vec4i(w, x, x, z)
        is Vec4s -> Vec4s(w, x, x, z)
        is Vec4l -> Vec4l(w, x, x, z)
        is Vec4ub -> Vec4ub(w, x, x, z)
        is Vec4ui -> Vec4ui(w, x, x, z)
        is Vec4us -> Vec4us(w, x, x, z)
        is Vec4ul -> Vec4ul(w, x, x, z)
        else -> throw IllegalStateException()
    }
    val wxxw @JvmName("wxxw") get() = when (this) {
        is Vec4 -> Vec4(w, x, x, w)
        is Vec4d -> Vec4d(w, x, x, w)
        is Vec4b -> Vec4b(w, x, x, w)
        is Vec4i -> Vec4i(w, x, x, w)
        is Vec4s -> Vec4s(w, x, x, w)
        is Vec4l -> Vec4l(w, x, x, w)
        is Vec4ub -> Vec4ub(w, x, x, w)
        is Vec4ui -> Vec4ui(w, x, x, w)
        is Vec4us -> Vec4us(w, x, x, w)
        is Vec4ul -> Vec4ul(w, x, x, w)
        else -> throw IllegalStateException()
    }
    val wxyx @JvmName("wxyx") get() = when (this) {
        is Vec4 -> Vec4(w, x, y, x)
        is Vec4d -> Vec4d(w, x, y, x)
        is Vec4b -> Vec4b(w, x, y, x)
        is Vec4i -> Vec4i(w, x, y, x)
        is Vec4s -> Vec4s(w, x, y, x)
        is Vec4l -> Vec4l(w, x, y, x)
        is Vec4ub -> Vec4ub(w, x, y, x)
        is Vec4ui -> Vec4ui(w, x, y, x)
        is Vec4us -> Vec4us(w, x, y, x)
        is Vec4ul -> Vec4ul(w, x, y, x)
        else -> throw IllegalStateException()
    }
    val wxyy @JvmName("wxyy") get() = when (this) {
        is Vec4 -> Vec4(w, x, y, y)
        is Vec4d -> Vec4d(w, x, y, y)
        is Vec4b -> Vec4b(w, x, y, y)
        is Vec4i -> Vec4i(w, x, y, y)
        is Vec4s -> Vec4s(w, x, y, y)
        is Vec4l -> Vec4l(w, x, y, y)
        is Vec4ub -> Vec4ub(w, x, y, y)
        is Vec4ui -> Vec4ui(w, x, y, y)
        is Vec4us -> Vec4us(w, x, y, y)
        is Vec4ul -> Vec4ul(w, x, y, y)
        else -> throw IllegalStateException()
    }
    var wxyz @JvmName("wxyz") get() = when (this) {
        is Vec4 -> Vec4(w, x, y, z)
        is Vec4d -> Vec4d(w, x, y, z)
        is Vec4b -> Vec4b(w, x, y, z)
        is Vec4i -> Vec4i(w, x, y, z)
        is Vec4s -> Vec4s(w, x, y, z)
        is Vec4l -> Vec4l(w, x, y, z)
        is Vec4ub -> Vec4ub(w, x, y, z)
        is Vec4ui -> Vec4ui(w, x, y, z)
        is Vec4us -> Vec4us(w, x, y, z)
        is Vec4ul -> Vec4ul(w, x, y, z)
        else -> throw IllegalStateException()
    }
        @JvmName("wxyz") set(value) {
            w = value.x as T
            x = value.y as T
            y = value.z as T
            z = value.w as T
        }
    val wxyw @JvmName("wxyw") get() = when (this) {
        is Vec4 -> Vec4(w, x, y, w)
        is Vec4d -> Vec4d(w, x, y, w)
        is Vec4b -> Vec4b(w, x, y, w)
        is Vec4i -> Vec4i(w, x, y, w)
        is Vec4s -> Vec4s(w, x, y, w)
        is Vec4l -> Vec4l(w, x, y, w)
        is Vec4ub -> Vec4ub(w, x, y, w)
        is Vec4ui -> Vec4ui(w, x, y, w)
        is Vec4us -> Vec4us(w, x, y, w)
        is Vec4ul -> Vec4ul(w, x, y, w)
        else -> throw IllegalStateException()
    }
    val wxzx @JvmName("wxzx") get() = when (this) {
        is Vec4 -> Vec4(w, x, z, x)
        is Vec4d -> Vec4d(w, x, z, x)
        is Vec4b -> Vec4b(w, x, z, x)
        is Vec4i -> Vec4i(w, x, z, x)
        is Vec4s -> Vec4s(w, x, z, x)
        is Vec4l -> Vec4l(w, x, z, x)
        is Vec4ub -> Vec4ub(w, x, z, x)
        is Vec4ui -> Vec4ui(w, x, z, x)
        is Vec4us -> Vec4us(w, x, z, x)
        is Vec4ul -> Vec4ul(w, x, z, x)
        else -> throw IllegalStateException()
    }
    var wxzy @JvmName("wxzy") get() = when (this) {
        is Vec4 -> Vec4(w, x, z, y)
        is Vec4d -> Vec4d(w, x, z, y)
        is Vec4b -> Vec4b(w, x, z, y)
        is Vec4i -> Vec4i(w, x, z, y)
        is Vec4s -> Vec4s(w, x, z, y)
        is Vec4l -> Vec4l(w, x, z, y)
        is Vec4ub -> Vec4ub(w, x, z, y)
        is Vec4ui -> Vec4ui(w, x, z, y)
        is Vec4us -> Vec4us(w, x, z, y)
        is Vec4ul -> Vec4ul(w, x, z, y)
        else -> throw IllegalStateException()
    }
        @JvmName("wxzy") set(value) {
            w = value.x as T
            x = value.y as T
            z = value.z as T
            y = value.w as T
        }
    val wxzz @JvmName("wxzz") get() = when (this) {
        is Vec4 -> Vec4(w, x, z, z)
        is Vec4d -> Vec4d(w, x, z, z)
        is Vec4b -> Vec4b(w, x, z, z)
        is Vec4i -> Vec4i(w, x, z, z)
        is Vec4s -> Vec4s(w, x, z, z)
        is Vec4l -> Vec4l(w, x, z, z)
        is Vec4ub -> Vec4ub(w, x, z, z)
        is Vec4ui -> Vec4ui(w, x, z, z)
        is Vec4us -> Vec4us(w, x, z, z)
        is Vec4ul -> Vec4ul(w, x, z, z)
        else -> throw IllegalStateException()
    }
    val wxzw @JvmName("wxzw") get() = when (this) {
        is Vec4 -> Vec4(w, x, z, w)
        is Vec4d -> Vec4d(w, x, z, w)
        is Vec4b -> Vec4b(w, x, z, w)
        is Vec4i -> Vec4i(w, x, z, w)
        is Vec4s -> Vec4s(w, x, z, w)
        is Vec4l -> Vec4l(w, x, z, w)
        is Vec4ub -> Vec4ub(w, x, z, w)
        is Vec4ui -> Vec4ui(w, x, z, w)
        is Vec4us -> Vec4us(w, x, z, w)
        is Vec4ul -> Vec4ul(w, x, z, w)
        else -> throw IllegalStateException()
    }
    val wxwx @JvmName("wxwx") get() = when (this) {
        is Vec4 -> Vec4(w, x, w, x)
        is Vec4d -> Vec4d(w, x, w, x)
        is Vec4b -> Vec4b(w, x, w, x)
        is Vec4i -> Vec4i(w, x, w, x)
        is Vec4s -> Vec4s(w, x, w, x)
        is Vec4l -> Vec4l(w, x, w, x)
        is Vec4ub -> Vec4ub(w, x, w, x)
        is Vec4ui -> Vec4ui(w, x, w, x)
        is Vec4us -> Vec4us(w, x, w, x)
        is Vec4ul -> Vec4ul(w, x, w, x)
        else -> throw IllegalStateException()
    }
    val wxwy @JvmName("wxwy") get() = when (this) {
        is Vec4 -> Vec4(w, x, w, y)
        is Vec4d -> Vec4d(w, x, w, y)
        is Vec4b -> Vec4b(w, x, w, y)
        is Vec4i -> Vec4i(w, x, w, y)
        is Vec4s -> Vec4s(w, x, w, y)
        is Vec4l -> Vec4l(w, x, w, y)
        is Vec4ub -> Vec4ub(w, x, w, y)
        is Vec4ui -> Vec4ui(w, x, w, y)
        is Vec4us -> Vec4us(w, x, w, y)
        is Vec4ul -> Vec4ul(w, x, w, y)
        else -> throw IllegalStateException()
    }
    val wxwz @JvmName("wxwz") get() = when (this) {
        is Vec4 -> Vec4(w, x, w, z)
        is Vec4d -> Vec4d(w, x, w, z)
        is Vec4b -> Vec4b(w, x, w, z)
        is Vec4i -> Vec4i(w, x, w, z)
        is Vec4s -> Vec4s(w, x, w, z)
        is Vec4l -> Vec4l(w, x, w, z)
        is Vec4ub -> Vec4ub(w, x, w, z)
        is Vec4ui -> Vec4ui(w, x, w, z)
        is Vec4us -> Vec4us(w, x, w, z)
        is Vec4ul -> Vec4ul(w, x, w, z)
        else -> throw IllegalStateException()
    }
    val wxww @JvmName("wxww") get() = when (this) {
        is Vec4 -> Vec4(w, x, w, w)
        is Vec4d -> Vec4d(w, x, w, w)
        is Vec4b -> Vec4b(w, x, w, w)
        is Vec4i -> Vec4i(w, x, w, w)
        is Vec4s -> Vec4s(w, x, w, w)
        is Vec4l -> Vec4l(w, x, w, w)
        is Vec4ub -> Vec4ub(w, x, w, w)
        is Vec4ui -> Vec4ui(w, x, w, w)
        is Vec4us -> Vec4us(w, x, w, w)
        is Vec4ul -> Vec4ul(w, x, w, w)
        else -> throw IllegalStateException()
    }
    val wyxx @JvmName("wyxx") get() = when (this) {
        is Vec4 -> Vec4(w, y, x, x)
        is Vec4d -> Vec4d(w, y, x, x)
        is Vec4b -> Vec4b(w, y, x, x)
        is Vec4i -> Vec4i(w, y, x, x)
        is Vec4s -> Vec4s(w, y, x, x)
        is Vec4l -> Vec4l(w, y, x, x)
        is Vec4ub -> Vec4ub(w, y, x, x)
        is Vec4ui -> Vec4ui(w, y, x, x)
        is Vec4us -> Vec4us(w, y, x, x)
        is Vec4ul -> Vec4ul(w, y, x, x)
        else -> throw IllegalStateException()
    }
    val wyxy @JvmName("wyxy") get() = when (this) {
        is Vec4 -> Vec4(w, y, x, y)
        is Vec4d -> Vec4d(w, y, x, y)
        is Vec4b -> Vec4b(w, y, x, y)
        is Vec4i -> Vec4i(w, y, x, y)
        is Vec4s -> Vec4s(w, y, x, y)
        is Vec4l -> Vec4l(w, y, x, y)
        is Vec4ub -> Vec4ub(w, y, x, y)
        is Vec4ui -> Vec4ui(w, y, x, y)
        is Vec4us -> Vec4us(w, y, x, y)
        is Vec4ul -> Vec4ul(w, y, x, y)
        else -> throw IllegalStateException()
    }
    var wyxz @JvmName("wyxz") get() = when (this) {
        is Vec4 -> Vec4(w, y, x, z)
        is Vec4d -> Vec4d(w, y, x, z)
        is Vec4b -> Vec4b(w, y, x, z)
        is Vec4i -> Vec4i(w, y, x, z)
        is Vec4s -> Vec4s(w, y, x, z)
        is Vec4l -> Vec4l(w, y, x, z)
        is Vec4ub -> Vec4ub(w, y, x, z)
        is Vec4ui -> Vec4ui(w, y, x, z)
        is Vec4us -> Vec4us(w, y, x, z)
        is Vec4ul -> Vec4ul(w, y, x, z)
        else -> throw IllegalStateException()
    }
        @JvmName("wyxz") set(value) {
            w = value.x as T
            y = value.y as T
            x = value.z as T
            z = value.w as T
        }
    val wyxw @JvmName("wyxw") get() = when (this) {
        is Vec4 -> Vec4(w, y, x, w)
        is Vec4d -> Vec4d(w, y, x, w)
        is Vec4b -> Vec4b(w, y, x, w)
        is Vec4i -> Vec4i(w, y, x, w)
        is Vec4s -> Vec4s(w, y, x, w)
        is Vec4l -> Vec4l(w, y, x, w)
        is Vec4ub -> Vec4ub(w, y, x, w)
        is Vec4ui -> Vec4ui(w, y, x, w)
        is Vec4us -> Vec4us(w, y, x, w)
        is Vec4ul -> Vec4ul(w, y, x, w)
        else -> throw IllegalStateException()
    }
    val wyyx @JvmName("wyyx") get() = when (this) {
        is Vec4 -> Vec4(w, y, y, x)
        is Vec4d -> Vec4d(w, y, y, x)
        is Vec4b -> Vec4b(w, y, y, x)
        is Vec4i -> Vec4i(w, y, y, x)
        is Vec4s -> Vec4s(w, y, y, x)
        is Vec4l -> Vec4l(w, y, y, x)
        is Vec4ub -> Vec4ub(w, y, y, x)
        is Vec4ui -> Vec4ui(w, y, y, x)
        is Vec4us -> Vec4us(w, y, y, x)
        is Vec4ul -> Vec4ul(w, y, y, x)
        else -> throw IllegalStateException()
    }
    val wyyy @JvmName("wyyy") get() = when (this) {
        is Vec4 -> Vec4(w, y, y, y)
        is Vec4d -> Vec4d(w, y, y, y)
        is Vec4b -> Vec4b(w, y, y, y)
        is Vec4i -> Vec4i(w, y, y, y)
        is Vec4s -> Vec4s(w, y, y, y)
        is Vec4l -> Vec4l(w, y, y, y)
        is Vec4ub -> Vec4ub(w, y, y, y)
        is Vec4ui -> Vec4ui(w, y, y, y)
        is Vec4us -> Vec4us(w, y, y, y)
        is Vec4ul -> Vec4ul(w, y, y, y)
        else -> throw IllegalStateException()
    }
    val wyyz @JvmName("wyyz") get() = when (this) {
        is Vec4 -> Vec4(w, y, y, z)
        is Vec4d -> Vec4d(w, y, y, z)
        is Vec4b -> Vec4b(w, y, y, z)
        is Vec4i -> Vec4i(w, y, y, z)
        is Vec4s -> Vec4s(w, y, y, z)
        is Vec4l -> Vec4l(w, y, y, z)
        is Vec4ub -> Vec4ub(w, y, y, z)
        is Vec4ui -> Vec4ui(w, y, y, z)
        is Vec4us -> Vec4us(w, y, y, z)
        is Vec4ul -> Vec4ul(w, y, y, z)
        else -> throw IllegalStateException()
    }
    val wyyw @JvmName("wyyw") get() = when (this) {
        is Vec4 -> Vec4(w, y, y, w)
        is Vec4d -> Vec4d(w, y, y, w)
        is Vec4b -> Vec4b(w, y, y, w)
        is Vec4i -> Vec4i(w, y, y, w)
        is Vec4s -> Vec4s(w, y, y, w)
        is Vec4l -> Vec4l(w, y, y, w)
        is Vec4ub -> Vec4ub(w, y, y, w)
        is Vec4ui -> Vec4ui(w, y, y, w)
        is Vec4us -> Vec4us(w, y, y, w)
        is Vec4ul -> Vec4ul(w, y, y, w)
        else -> throw IllegalStateException()
    }
    var wyzx @JvmName("wyzx") get() = when (this) {
        is Vec4 -> Vec4(w, y, z, x)
        is Vec4d -> Vec4d(w, y, z, x)
        is Vec4b -> Vec4b(w, y, z, x)
        is Vec4i -> Vec4i(w, y, z, x)
        is Vec4s -> Vec4s(w, y, z, x)
        is Vec4l -> Vec4l(w, y, z, x)
        is Vec4ub -> Vec4ub(w, y, z, x)
        is Vec4ui -> Vec4ui(w, y, z, x)
        is Vec4us -> Vec4us(w, y, z, x)
        is Vec4ul -> Vec4ul(w, y, z, x)
        else -> throw IllegalStateException()
    }
        @JvmName("wyzx") set(value) {
            w = value.x as T
            y = value.y as T
            z = value.z as T
            x = value.w as T
        }
    val wyzy @JvmName("wyzy") get() = when (this) {
        is Vec4 -> Vec4(w, y, z, y)
        is Vec4d -> Vec4d(w, y, z, y)
        is Vec4b -> Vec4b(w, y, z, y)
        is Vec4i -> Vec4i(w, y, z, y)
        is Vec4s -> Vec4s(w, y, z, y)
        is Vec4l -> Vec4l(w, y, z, y)
        is Vec4ub -> Vec4ub(w, y, z, y)
        is Vec4ui -> Vec4ui(w, y, z, y)
        is Vec4us -> Vec4us(w, y, z, y)
        is Vec4ul -> Vec4ul(w, y, z, y)
        else -> throw IllegalStateException()
    }
    val wyzz @JvmName("wyzz") get() = when (this) {
        is Vec4 -> Vec4(w, y, z, z)
        is Vec4d -> Vec4d(w, y, z, z)
        is Vec4b -> Vec4b(w, y, z, z)
        is Vec4i -> Vec4i(w, y, z, z)
        is Vec4s -> Vec4s(w, y, z, z)
        is Vec4l -> Vec4l(w, y, z, z)
        is Vec4ub -> Vec4ub(w, y, z, z)
        is Vec4ui -> Vec4ui(w, y, z, z)
        is Vec4us -> Vec4us(w, y, z, z)
        is Vec4ul -> Vec4ul(w, y, z, z)
        else -> throw IllegalStateException()
    }
    val wyzw @JvmName("wyzw") get() = when (this) {
        is Vec4 -> Vec4(w, y, z, w)
        is Vec4d -> Vec4d(w, y, z, w)
        is Vec4b -> Vec4b(w, y, z, w)
        is Vec4i -> Vec4i(w, y, z, w)
        is Vec4s -> Vec4s(w, y, z, w)
        is Vec4l -> Vec4l(w, y, z, w)
        is Vec4ub -> Vec4ub(w, y, z, w)
        is Vec4ui -> Vec4ui(w, y, z, w)
        is Vec4us -> Vec4us(w, y, z, w)
        is Vec4ul -> Vec4ul(w, y, z, w)
        else -> throw IllegalStateException()
    }
    val wywx @JvmName("wywx") get() = when (this) {
        is Vec4 -> Vec4(w, y, w, x)
        is Vec4d -> Vec4d(w, y, w, x)
        is Vec4b -> Vec4b(w, y, w, x)
        is Vec4i -> Vec4i(w, y, w, x)
        is Vec4s -> Vec4s(w, y, w, x)
        is Vec4l -> Vec4l(w, y, w, x)
        is Vec4ub -> Vec4ub(w, y, w, x)
        is Vec4ui -> Vec4ui(w, y, w, x)
        is Vec4us -> Vec4us(w, y, w, x)
        is Vec4ul -> Vec4ul(w, y, w, x)
        else -> throw IllegalStateException()
    }
    val wywy @JvmName("wywy") get() = when (this) {
        is Vec4 -> Vec4(w, y, w, y)
        is Vec4d -> Vec4d(w, y, w, y)
        is Vec4b -> Vec4b(w, y, w, y)
        is Vec4i -> Vec4i(w, y, w, y)
        is Vec4s -> Vec4s(w, y, w, y)
        is Vec4l -> Vec4l(w, y, w, y)
        is Vec4ub -> Vec4ub(w, y, w, y)
        is Vec4ui -> Vec4ui(w, y, w, y)
        is Vec4us -> Vec4us(w, y, w, y)
        is Vec4ul -> Vec4ul(w, y, w, y)
        else -> throw IllegalStateException()
    }
    val wywz @JvmName("wywz") get() = when (this) {
        is Vec4 -> Vec4(w, y, w, z)
        is Vec4d -> Vec4d(w, y, w, z)
        is Vec4b -> Vec4b(w, y, w, z)
        is Vec4i -> Vec4i(w, y, w, z)
        is Vec4s -> Vec4s(w, y, w, z)
        is Vec4l -> Vec4l(w, y, w, z)
        is Vec4ub -> Vec4ub(w, y, w, z)
        is Vec4ui -> Vec4ui(w, y, w, z)
        is Vec4us -> Vec4us(w, y, w, z)
        is Vec4ul -> Vec4ul(w, y, w, z)
        else -> throw IllegalStateException()
    }
    val wyww @JvmName("wyww") get() = when (this) {
        is Vec4 -> Vec4(w, y, w, w)
        is Vec4d -> Vec4d(w, y, w, w)
        is Vec4b -> Vec4b(w, y, w, w)
        is Vec4i -> Vec4i(w, y, w, w)
        is Vec4s -> Vec4s(w, y, w, w)
        is Vec4l -> Vec4l(w, y, w, w)
        is Vec4ub -> Vec4ub(w, y, w, w)
        is Vec4ui -> Vec4ui(w, y, w, w)
        is Vec4us -> Vec4us(w, y, w, w)
        is Vec4ul -> Vec4ul(w, y, w, w)
        else -> throw IllegalStateException()
    }
    val wzxx @JvmName("wzxx") get() = when (this) {
        is Vec4 -> Vec4(w, z, x, x)
        is Vec4d -> Vec4d(w, z, x, x)
        is Vec4b -> Vec4b(w, z, x, x)
        is Vec4i -> Vec4i(w, z, x, x)
        is Vec4s -> Vec4s(w, z, x, x)
        is Vec4l -> Vec4l(w, z, x, x)
        is Vec4ub -> Vec4ub(w, z, x, x)
        is Vec4ui -> Vec4ui(w, z, x, x)
        is Vec4us -> Vec4us(w, z, x, x)
        is Vec4ul -> Vec4ul(w, z, x, x)
        else -> throw IllegalStateException()
    }
    var wzxy @JvmName("wzxy") get() = when (this) {
        is Vec4 -> Vec4(w, z, x, y)
        is Vec4d -> Vec4d(w, z, x, y)
        is Vec4b -> Vec4b(w, z, x, y)
        is Vec4i -> Vec4i(w, z, x, y)
        is Vec4s -> Vec4s(w, z, x, y)
        is Vec4l -> Vec4l(w, z, x, y)
        is Vec4ub -> Vec4ub(w, z, x, y)
        is Vec4ui -> Vec4ui(w, z, x, y)
        is Vec4us -> Vec4us(w, z, x, y)
        is Vec4ul -> Vec4ul(w, z, x, y)
        else -> throw IllegalStateException()
    }
        @JvmName("wzxy") set(value) {
            w = value.x as T
            z = value.y as T
            x = value.z as T
            y = value.w as T
        }
    val wzxz @JvmName("wzxz") get() = when (this) {
        is Vec4 -> Vec4(w, z, x, z)
        is Vec4d -> Vec4d(w, z, x, z)
        is Vec4b -> Vec4b(w, z, x, z)
        is Vec4i -> Vec4i(w, z, x, z)
        is Vec4s -> Vec4s(w, z, x, z)
        is Vec4l -> Vec4l(w, z, x, z)
        is Vec4ub -> Vec4ub(w, z, x, z)
        is Vec4ui -> Vec4ui(w, z, x, z)
        is Vec4us -> Vec4us(w, z, x, z)
        is Vec4ul -> Vec4ul(w, z, x, z)
        else -> throw IllegalStateException()
    }
    val wzxw @JvmName("wzxw") get() = when (this) {
        is Vec4 -> Vec4(w, z, x, w)
        is Vec4d -> Vec4d(w, z, x, w)
        is Vec4b -> Vec4b(w, z, x, w)
        is Vec4i -> Vec4i(w, z, x, w)
        is Vec4s -> Vec4s(w, z, x, w)
        is Vec4l -> Vec4l(w, z, x, w)
        is Vec4ub -> Vec4ub(w, z, x, w)
        is Vec4ui -> Vec4ui(w, z, x, w)
        is Vec4us -> Vec4us(w, z, x, w)
        is Vec4ul -> Vec4ul(w, z, x, w)
        else -> throw IllegalStateException()
    }
    var wzyx @JvmName("wzyx") get() = when (this) {
        is Vec4 -> Vec4(w, z, y, x)
        is Vec4d -> Vec4d(w, z, y, x)
        is Vec4b -> Vec4b(w, z, y, x)
        is Vec4i -> Vec4i(w, z, y, x)
        is Vec4s -> Vec4s(w, z, y, x)
        is Vec4l -> Vec4l(w, z, y, x)
        is Vec4ub -> Vec4ub(w, z, y, x)
        is Vec4ui -> Vec4ui(w, z, y, x)
        is Vec4us -> Vec4us(w, z, y, x)
        is Vec4ul -> Vec4ul(w, z, y, x)
        else -> throw IllegalStateException()
    }
        @JvmName("wzyx") set(value) {
            w = value.x as T
            z = value.y as T
            y = value.z as T
            x = value.w as T
        }
    val wzyy @JvmName("wzyy") get() = when (this) {
        is Vec4 -> Vec4(w, z, y, y)
        is Vec4d -> Vec4d(w, z, y, y)
        is Vec4b -> Vec4b(w, z, y, y)
        is Vec4i -> Vec4i(w, z, y, y)
        is Vec4s -> Vec4s(w, z, y, y)
        is Vec4l -> Vec4l(w, z, y, y)
        is Vec4ub -> Vec4ub(w, z, y, y)
        is Vec4ui -> Vec4ui(w, z, y, y)
        is Vec4us -> Vec4us(w, z, y, y)
        is Vec4ul -> Vec4ul(w, z, y, y)
        else -> throw IllegalStateException()
    }
    val wzyz @JvmName("wzyz") get() = when (this) {
        is Vec4 -> Vec4(w, z, y, z)
        is Vec4d -> Vec4d(w, z, y, z)
        is Vec4b -> Vec4b(w, z, y, z)
        is Vec4i -> Vec4i(w, z, y, z)
        is Vec4s -> Vec4s(w, z, y, z)
        is Vec4l -> Vec4l(w, z, y, z)
        is Vec4ub -> Vec4ub(w, z, y, z)
        is Vec4ui -> Vec4ui(w, z, y, z)
        is Vec4us -> Vec4us(w, z, y, z)
        is Vec4ul -> Vec4ul(w, z, y, z)
        else -> throw IllegalStateException()
    }
    val wzyw @JvmName("wzyw") get() = when (this) {
        is Vec4 -> Vec4(w, z, y, w)
        is Vec4d -> Vec4d(w, z, y, w)
        is Vec4b -> Vec4b(w, z, y, w)
        is Vec4i -> Vec4i(w, z, y, w)
        is Vec4s -> Vec4s(w, z, y, w)
        is Vec4l -> Vec4l(w, z, y, w)
        is Vec4ub -> Vec4ub(w, z, y, w)
        is Vec4ui -> Vec4ui(w, z, y, w)
        is Vec4us -> Vec4us(w, z, y, w)
        is Vec4ul -> Vec4ul(w, z, y, w)
        else -> throw IllegalStateException()
    }
    val wzzx @JvmName("wzzx") get() = when (this) {
        is Vec4 -> Vec4(w, z, z, x)
        is Vec4d -> Vec4d(w, z, z, x)
        is Vec4b -> Vec4b(w, z, z, x)
        is Vec4i -> Vec4i(w, z, z, x)
        is Vec4s -> Vec4s(w, z, z, x)
        is Vec4l -> Vec4l(w, z, z, x)
        is Vec4ub -> Vec4ub(w, z, z, x)
        is Vec4ui -> Vec4ui(w, z, z, x)
        is Vec4us -> Vec4us(w, z, z, x)
        is Vec4ul -> Vec4ul(w, z, z, x)
        else -> throw IllegalStateException()
    }
    val wzzy @JvmName("wzzy") get() = when (this) {
        is Vec4 -> Vec4(w, z, z, y)
        is Vec4d -> Vec4d(w, z, z, y)
        is Vec4b -> Vec4b(w, z, z, y)
        is Vec4i -> Vec4i(w, z, z, y)
        is Vec4s -> Vec4s(w, z, z, y)
        is Vec4l -> Vec4l(w, z, z, y)
        is Vec4ub -> Vec4ub(w, z, z, y)
        is Vec4ui -> Vec4ui(w, z, z, y)
        is Vec4us -> Vec4us(w, z, z, y)
        is Vec4ul -> Vec4ul(w, z, z, y)
        else -> throw IllegalStateException()
    }
    val wzzz @JvmName("wzzz") get() = when (this) {
        is Vec4 -> Vec4(w, z, z, z)
        is Vec4d -> Vec4d(w, z, z, z)
        is Vec4b -> Vec4b(w, z, z, z)
        is Vec4i -> Vec4i(w, z, z, z)
        is Vec4s -> Vec4s(w, z, z, z)
        is Vec4l -> Vec4l(w, z, z, z)
        is Vec4ub -> Vec4ub(w, z, z, z)
        is Vec4ui -> Vec4ui(w, z, z, z)
        is Vec4us -> Vec4us(w, z, z, z)
        is Vec4ul -> Vec4ul(w, z, z, z)
        else -> throw IllegalStateException()
    }
    val wzzw @JvmName("wzzw") get() = when (this) {
        is Vec4 -> Vec4(w, z, z, w)
        is Vec4d -> Vec4d(w, z, z, w)
        is Vec4b -> Vec4b(w, z, z, w)
        is Vec4i -> Vec4i(w, z, z, w)
        is Vec4s -> Vec4s(w, z, z, w)
        is Vec4l -> Vec4l(w, z, z, w)
        is Vec4ub -> Vec4ub(w, z, z, w)
        is Vec4ui -> Vec4ui(w, z, z, w)
        is Vec4us -> Vec4us(w, z, z, w)
        is Vec4ul -> Vec4ul(w, z, z, w)
        else -> throw IllegalStateException()
    }
    val wzwx @JvmName("wzwx") get() = when (this) {
        is Vec4 -> Vec4(w, z, w, x)
        is Vec4d -> Vec4d(w, z, w, x)
        is Vec4b -> Vec4b(w, z, w, x)
        is Vec4i -> Vec4i(w, z, w, x)
        is Vec4s -> Vec4s(w, z, w, x)
        is Vec4l -> Vec4l(w, z, w, x)
        is Vec4ub -> Vec4ub(w, z, w, x)
        is Vec4ui -> Vec4ui(w, z, w, x)
        is Vec4us -> Vec4us(w, z, w, x)
        is Vec4ul -> Vec4ul(w, z, w, x)
        else -> throw IllegalStateException()
    }
    val wzwy @JvmName("wzwy") get() = when (this) {
        is Vec4 -> Vec4(w, z, w, y)
        is Vec4d -> Vec4d(w, z, w, y)
        is Vec4b -> Vec4b(w, z, w, y)
        is Vec4i -> Vec4i(w, z, w, y)
        is Vec4s -> Vec4s(w, z, w, y)
        is Vec4l -> Vec4l(w, z, w, y)
        is Vec4ub -> Vec4ub(w, z, w, y)
        is Vec4ui -> Vec4ui(w, z, w, y)
        is Vec4us -> Vec4us(w, z, w, y)
        is Vec4ul -> Vec4ul(w, z, w, y)
        else -> throw IllegalStateException()
    }
    val wzwz @JvmName("wzwz") get() = when (this) {
        is Vec4 -> Vec4(w, z, w, z)
        is Vec4d -> Vec4d(w, z, w, z)
        is Vec4b -> Vec4b(w, z, w, z)
        is Vec4i -> Vec4i(w, z, w, z)
        is Vec4s -> Vec4s(w, z, w, z)
        is Vec4l -> Vec4l(w, z, w, z)
        is Vec4ub -> Vec4ub(w, z, w, z)
        is Vec4ui -> Vec4ui(w, z, w, z)
        is Vec4us -> Vec4us(w, z, w, z)
        is Vec4ul -> Vec4ul(w, z, w, z)
        else -> throw IllegalStateException()
    }
    val wzww @JvmName("wzww") get() = when (this) {
        is Vec4 -> Vec4(w, z, w, w)
        is Vec4d -> Vec4d(w, z, w, w)
        is Vec4b -> Vec4b(w, z, w, w)
        is Vec4i -> Vec4i(w, z, w, w)
        is Vec4s -> Vec4s(w, z, w, w)
        is Vec4l -> Vec4l(w, z, w, w)
        is Vec4ub -> Vec4ub(w, z, w, w)
        is Vec4ui -> Vec4ui(w, z, w, w)
        is Vec4us -> Vec4us(w, z, w, w)
        is Vec4ul -> Vec4ul(w, z, w, w)
        else -> throw IllegalStateException()
    }
    val wwxx @JvmName("wwxx") get() = when (this) {
        is Vec4 -> Vec4(w, w, x, x)
        is Vec4d -> Vec4d(w, w, x, x)
        is Vec4b -> Vec4b(w, w, x, x)
        is Vec4i -> Vec4i(w, w, x, x)
        is Vec4s -> Vec4s(w, w, x, x)
        is Vec4l -> Vec4l(w, w, x, x)
        is Vec4ub -> Vec4ub(w, w, x, x)
        is Vec4ui -> Vec4ui(w, w, x, x)
        is Vec4us -> Vec4us(w, w, x, x)
        is Vec4ul -> Vec4ul(w, w, x, x)
        else -> throw IllegalStateException()
    }
    val wwxy @JvmName("wwxy") get() = when (this) {
        is Vec4 -> Vec4(w, w, x, y)
        is Vec4d -> Vec4d(w, w, x, y)
        is Vec4b -> Vec4b(w, w, x, y)
        is Vec4i -> Vec4i(w, w, x, y)
        is Vec4s -> Vec4s(w, w, x, y)
        is Vec4l -> Vec4l(w, w, x, y)
        is Vec4ub -> Vec4ub(w, w, x, y)
        is Vec4ui -> Vec4ui(w, w, x, y)
        is Vec4us -> Vec4us(w, w, x, y)
        is Vec4ul -> Vec4ul(w, w, x, y)
        else -> throw IllegalStateException()
    }
    val wwxz @JvmName("wwxz") get() = when (this) {
        is Vec4 -> Vec4(w, w, x, z)
        is Vec4d -> Vec4d(w, w, x, z)
        is Vec4b -> Vec4b(w, w, x, z)
        is Vec4i -> Vec4i(w, w, x, z)
        is Vec4s -> Vec4s(w, w, x, z)
        is Vec4l -> Vec4l(w, w, x, z)
        is Vec4ub -> Vec4ub(w, w, x, z)
        is Vec4ui -> Vec4ui(w, w, x, z)
        is Vec4us -> Vec4us(w, w, x, z)
        is Vec4ul -> Vec4ul(w, w, x, z)
        else -> throw IllegalStateException()
    }
    val wwxw @JvmName("wwxw") get() = when (this) {
        is Vec4 -> Vec4(w, w, x, w)
        is Vec4d -> Vec4d(w, w, x, w)
        is Vec4b -> Vec4b(w, w, x, w)
        is Vec4i -> Vec4i(w, w, x, w)
        is Vec4s -> Vec4s(w, w, x, w)
        is Vec4l -> Vec4l(w, w, x, w)
        is Vec4ub -> Vec4ub(w, w, x, w)
        is Vec4ui -> Vec4ui(w, w, x, w)
        is Vec4us -> Vec4us(w, w, x, w)
        is Vec4ul -> Vec4ul(w, w, x, w)
        else -> throw IllegalStateException()
    }
    val wwyx @JvmName("wwyx") get() = when (this) {
        is Vec4 -> Vec4(w, w, y, x)
        is Vec4d -> Vec4d(w, w, y, x)
        is Vec4b -> Vec4b(w, w, y, x)
        is Vec4i -> Vec4i(w, w, y, x)
        is Vec4s -> Vec4s(w, w, y, x)
        is Vec4l -> Vec4l(w, w, y, x)
        is Vec4ub -> Vec4ub(w, w, y, x)
        is Vec4ui -> Vec4ui(w, w, y, x)
        is Vec4us -> Vec4us(w, w, y, x)
        is Vec4ul -> Vec4ul(w, w, y, x)
        else -> throw IllegalStateException()
    }
    val wwyy @JvmName("wwyy") get() = when (this) {
        is Vec4 -> Vec4(w, w, y, y)
        is Vec4d -> Vec4d(w, w, y, y)
        is Vec4b -> Vec4b(w, w, y, y)
        is Vec4i -> Vec4i(w, w, y, y)
        is Vec4s -> Vec4s(w, w, y, y)
        is Vec4l -> Vec4l(w, w, y, y)
        is Vec4ub -> Vec4ub(w, w, y, y)
        is Vec4ui -> Vec4ui(w, w, y, y)
        is Vec4us -> Vec4us(w, w, y, y)
        is Vec4ul -> Vec4ul(w, w, y, y)
        else -> throw IllegalStateException()
    }
    val wwyz @JvmName("wwyz") get() = when (this) {
        is Vec4 -> Vec4(w, w, y, z)
        is Vec4d -> Vec4d(w, w, y, z)
        is Vec4b -> Vec4b(w, w, y, z)
        is Vec4i -> Vec4i(w, w, y, z)
        is Vec4s -> Vec4s(w, w, y, z)
        is Vec4l -> Vec4l(w, w, y, z)
        is Vec4ub -> Vec4ub(w, w, y, z)
        is Vec4ui -> Vec4ui(w, w, y, z)
        is Vec4us -> Vec4us(w, w, y, z)
        is Vec4ul -> Vec4ul(w, w, y, z)
        else -> throw IllegalStateException()
    }
    val wwyw @JvmName("wwyw") get() = when (this) {
        is Vec4 -> Vec4(w, w, y, w)
        is Vec4d -> Vec4d(w, w, y, w)
        is Vec4b -> Vec4b(w, w, y, w)
        is Vec4i -> Vec4i(w, w, y, w)
        is Vec4s -> Vec4s(w, w, y, w)
        is Vec4l -> Vec4l(w, w, y, w)
        is Vec4ub -> Vec4ub(w, w, y, w)
        is Vec4ui -> Vec4ui(w, w, y, w)
        is Vec4us -> Vec4us(w, w, y, w)
        is Vec4ul -> Vec4ul(w, w, y, w)
        else -> throw IllegalStateException()
    }
    val wwzx @JvmName("wwzx") get() = when (this) {
        is Vec4 -> Vec4(w, w, z, x)
        is Vec4d -> Vec4d(w, w, z, x)
        is Vec4b -> Vec4b(w, w, z, x)
        is Vec4i -> Vec4i(w, w, z, x)
        is Vec4s -> Vec4s(w, w, z, x)
        is Vec4l -> Vec4l(w, w, z, x)
        is Vec4ub -> Vec4ub(w, w, z, x)
        is Vec4ui -> Vec4ui(w, w, z, x)
        is Vec4us -> Vec4us(w, w, z, x)
        is Vec4ul -> Vec4ul(w, w, z, x)
        else -> throw IllegalStateException()
    }
    val wwzy @JvmName("wwzy") get() = when (this) {
        is Vec4 -> Vec4(w, w, z, y)
        is Vec4d -> Vec4d(w, w, z, y)
        is Vec4b -> Vec4b(w, w, z, y)
        is Vec4i -> Vec4i(w, w, z, y)
        is Vec4s -> Vec4s(w, w, z, y)
        is Vec4l -> Vec4l(w, w, z, y)
        is Vec4ub -> Vec4ub(w, w, z, y)
        is Vec4ui -> Vec4ui(w, w, z, y)
        is Vec4us -> Vec4us(w, w, z, y)
        is Vec4ul -> Vec4ul(w, w, z, y)
        else -> throw IllegalStateException()
    }
    val wwzz @JvmName("wwzz") get() = when (this) {
        is Vec4 -> Vec4(w, w, z, z)
        is Vec4d -> Vec4d(w, w, z, z)
        is Vec4b -> Vec4b(w, w, z, z)
        is Vec4i -> Vec4i(w, w, z, z)
        is Vec4s -> Vec4s(w, w, z, z)
        is Vec4l -> Vec4l(w, w, z, z)
        is Vec4ub -> Vec4ub(w, w, z, z)
        is Vec4ui -> Vec4ui(w, w, z, z)
        is Vec4us -> Vec4us(w, w, z, z)
        is Vec4ul -> Vec4ul(w, w, z, z)
        else -> throw IllegalStateException()
    }
    val wwzw @JvmName("wwzw") get() = when (this) {
        is Vec4 -> Vec4(w, w, z, w)
        is Vec4d -> Vec4d(w, w, z, w)
        is Vec4b -> Vec4b(w, w, z, w)
        is Vec4i -> Vec4i(w, w, z, w)
        is Vec4s -> Vec4s(w, w, z, w)
        is Vec4l -> Vec4l(w, w, z, w)
        is Vec4ub -> Vec4ub(w, w, z, w)
        is Vec4ui -> Vec4ui(w, w, z, w)
        is Vec4us -> Vec4us(w, w, z, w)
        is Vec4ul -> Vec4ul(w, w, z, w)
        else -> throw IllegalStateException()
    }
    val wwwx @JvmName("wwwx") get() = when (this) {
        is Vec4 -> Vec4(w, w, w, x)
        is Vec4d -> Vec4d(w, w, w, x)
        is Vec4b -> Vec4b(w, w, w, x)
        is Vec4i -> Vec4i(w, w, w, x)
        is Vec4s -> Vec4s(w, w, w, x)
        is Vec4l -> Vec4l(w, w, w, x)
        is Vec4ub -> Vec4ub(w, w, w, x)
        is Vec4ui -> Vec4ui(w, w, w, x)
        is Vec4us -> Vec4us(w, w, w, x)
        is Vec4ul -> Vec4ul(w, w, w, x)
        else -> throw IllegalStateException()
    }
    val wwwy @JvmName("wwwy") get() = when (this) {
        is Vec4 -> Vec4(w, w, w, y)
        is Vec4d -> Vec4d(w, w, w, y)
        is Vec4b -> Vec4b(w, w, w, y)
        is Vec4i -> Vec4i(w, w, w, y)
        is Vec4s -> Vec4s(w, w, w, y)
        is Vec4l -> Vec4l(w, w, w, y)
        is Vec4ub -> Vec4ub(w, w, w, y)
        is Vec4ui -> Vec4ui(w, w, w, y)
        is Vec4us -> Vec4us(w, w, w, y)
        is Vec4ul -> Vec4ul(w, w, w, y)
        else -> throw IllegalStateException()
    }
    val wwwz @JvmName("wwwz") get() = when (this) {
        is Vec4 -> Vec4(w, w, w, z)
        is Vec4d -> Vec4d(w, w, w, z)
        is Vec4b -> Vec4b(w, w, w, z)
        is Vec4i -> Vec4i(w, w, w, z)
        is Vec4s -> Vec4s(w, w, w, z)
        is Vec4l -> Vec4l(w, w, w, z)
        is Vec4ub -> Vec4ub(w, w, w, z)
        is Vec4ui -> Vec4ui(w, w, w, z)
        is Vec4us -> Vec4us(w, w, w, z)
        is Vec4ul -> Vec4ul(w, w, w, z)
        else -> throw IllegalStateException()
    }
    val wwww @JvmName("wwww") get() = when (this) {
        is Vec4 -> Vec4(w, w, w, w)
        is Vec4d -> Vec4d(w, w, w, w)
        is Vec4b -> Vec4b(w, w, w, w)
        is Vec4i -> Vec4i(w, w, w, w)
        is Vec4s -> Vec4s(w, w, w, w)
        is Vec4l -> Vec4l(w, w, w, w)
        is Vec4ub -> Vec4ub(w, w, w, w)
        is Vec4ui -> Vec4ui(w, w, w, w)
        is Vec4us -> Vec4us(w, w, w, w)
        is Vec4ul -> Vec4ul(w, w, w, w)
        else -> throw IllegalStateException()
    }
}
