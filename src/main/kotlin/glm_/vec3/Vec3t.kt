@file:Suppress("UNCHECKED_CAST")

package glm_.vec3

import glm_.*
import glm_.vec2.*
import glm_.vec4.Vec4bool
import glm_.vec4.Vec4t
import java.nio.*

abstract class Vec3t<T : Number>(_x: T, _y: T, _z: T) {

    @JvmField
    var x = _x
    @JvmField
    var y = _y
    @JvmField
    var z = _z

    open operator fun get(i: Int) = when (i) {
        0 -> x
        1 -> y
        2 -> z
        else -> throw IndexOutOfBoundsException()
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

    open infix fun put(s: Number) = put(s, s, s)
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

        // -- functions --

        @JvmField
        val length = 3
    }

    operator fun component1() = x
    operator fun component2() = y
    operator fun component3() = z

    override fun toString() = "($x, $y, $z)"

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
        @JvmName("toByte") get() = z
        @JvmName("toByte") set(value) {
            field = value
            z = field
        }

    var s = x
        @JvmName("toShort") get() = x
        @JvmName("toShort") set(value) {
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


    // swizzling

    val xx
        @JvmName("xx") get() = when (this) {
            is Vec3 -> Vec2(x, x)
            is Vec3d -> Vec2d(x, x)
            is Vec3b -> Vec2b(x, x)
            is Vec3i -> Vec2i(x, x)
            is Vec3s -> Vec2s(x, x)
            is Vec3l -> Vec2l(x, x)
            is Vec3ub -> Vec2ub(x, x)
            is Vec3ui -> Vec2ui(x, x)
            is Vec3us -> Vec2us(x, x)
            is Vec3ul -> Vec2ul(x, x)
            else -> throw IllegalStateException()
        }
    var xy
        @JvmName("xy") get() = when (this) {
            is Vec3 -> Vec2(this)
            is Vec3d -> Vec2d(this)
            is Vec3b -> Vec2b(this)
            is Vec3i -> Vec2i(this)
            is Vec3s -> Vec2s(this)
            is Vec3l -> Vec2l(this)
            is Vec3ub -> Vec2ub(this)
            is Vec3ui -> Vec2ui(this)
            is Vec3us -> Vec2us(this)
            is Vec3ul -> Vec2ul(this)
            else -> throw IllegalStateException()
        }
        @JvmName("xy") set(value) {
            x = value.x as T
            y = value.y as T
        }
    var yx
        @JvmName("yx") get() = when (this) {
            is Vec3 -> Vec2(y, x)
            is Vec3d -> Vec2d(y, x)
            is Vec3b -> Vec2b(y, x)
            is Vec3i -> Vec2i(y, x)
            is Vec3s -> Vec2s(y, x)
            is Vec3l -> Vec2l(y, x)
            is Vec3ub -> Vec2ub(y, x)
            is Vec3ui -> Vec2ui(y, x)
            is Vec3us -> Vec2us(y, x)
            is Vec3ul -> Vec2ul(y, x)
            else -> throw IllegalStateException()
        }
        @JvmName("yx") set(value) {
            y = value.x as T
            x = value.y as T
        }
    val yy
        @JvmName("yy") get() = when (this) {
            is Vec3 -> Vec2(y, y)
            is Vec3d -> Vec2d(y, y)
            is Vec3b -> Vec2b(y, y)
            is Vec3i -> Vec2i(y, y)
            is Vec3s -> Vec2s(y, y)
            is Vec3l -> Vec2l(y, y)
            is Vec3ub -> Vec2ub(y, y)
            is Vec3ui -> Vec2ui(y, y)
            is Vec3us -> Vec2us(y, y)
            is Vec3ul -> Vec2ul(y, y)
            else -> throw IllegalStateException()
        }


    val xxx
        @JvmName("xxx") get() = when (this) {
            is Vec3 -> Vec3(x, x, x)
            is Vec3d -> Vec3d(x, x, x)
            is Vec3b -> Vec3b(x, x, x)
            is Vec3i -> Vec3i(x, x, x)
            is Vec3s -> Vec3s(x, x, x)
            is Vec3l -> Vec3l(x, x, x)
            is Vec3ub -> Vec3ub(x, x, x)
            is Vec3ui -> Vec3ui(x, x, x)
            is Vec3us -> Vec3us(x, x, x)
            is Vec3ul -> Vec3ul(x, x, x)
            else -> throw IllegalStateException()
        }
    val xxy
        @JvmName("xxy") get() = when (this) {
            is Vec3 -> Vec3(x, x, y)
            is Vec3d -> Vec3d(x, x, y)
            is Vec3b -> Vec3b(x, x, y)
            is Vec3i -> Vec3i(x, x, y)
            is Vec3s -> Vec3s(x, x, y)
            is Vec3l -> Vec3l(x, x, y)
            is Vec3ub -> Vec3ub(x, x, y)
            is Vec3ui -> Vec3ui(x, x, y)
            is Vec3us -> Vec3us(x, x, y)
            is Vec3ul -> Vec3ul(x, x, y)
            else -> throw IllegalStateException()
        }
    val xxz
        @JvmName("xxz") get() = when (this) {
            is Vec3 -> Vec3(x, x, z)
            is Vec3d -> Vec3d(x, x, z)
            is Vec3b -> Vec3b(x, x, z)
            is Vec3i -> Vec3i(x, x, z)
            is Vec3s -> Vec3s(x, x, z)
            is Vec3l -> Vec3l(x, x, z)
            is Vec3ub -> Vec3ub(x, x, z)
            is Vec3ui -> Vec3ui(x, x, z)
            is Vec3us -> Vec3us(x, x, z)
            is Vec3ul -> Vec3ul(x, x, z)
            else -> throw IllegalStateException()
        }
    val xyx
        @JvmName("xyx") get() = when (this) {
            is Vec3 -> Vec3(x, y, x)
            is Vec3d -> Vec3d(x, y, x)
            is Vec3b -> Vec3b(x, y, x)
            is Vec3i -> Vec3i(x, y, x)
            is Vec3s -> Vec3s(x, y, x)
            is Vec3l -> Vec3l(x, y, x)
            is Vec3ub -> Vec3ub(x, y, x)
            is Vec3ui -> Vec3ui(x, y, x)
            is Vec3us -> Vec3us(x, y, x)
            is Vec3ul -> Vec3ul(x, y, x)
            else -> throw IllegalStateException()
        }
    val xyy
        @JvmName("xyy") get() = when (this) {
            is Vec3 -> Vec3(x, y, y)
            is Vec3d -> Vec3d(x, y, y)
            is Vec3b -> Vec3b(x, y, y)
            is Vec3i -> Vec3i(x, y, y)
            is Vec3s -> Vec3s(x, y, y)
            is Vec3l -> Vec3l(x, y, y)
            is Vec3ub -> Vec3ub(x, y, y)
            is Vec3ui -> Vec3ui(x, y, y)
            is Vec3us -> Vec3us(x, y, y)
            is Vec3ul -> Vec3ul(x, y, y)
            else -> throw IllegalStateException()
        }
    var xyz
        @JvmName("xyz") get() = when (this) {
            is Vec3 -> Vec3(x, y, z)
            is Vec3d -> Vec3d(x, y, z)
            is Vec3b -> Vec3b(x, y, z)
            is Vec3i -> Vec3i(x, y, z)
            is Vec3s -> Vec3s(x, y, z)
            is Vec3l -> Vec3l(x, y, z)
            is Vec3ub -> Vec3ub(x, y, z)
            is Vec3ui -> Vec3ui(x, y, z)
            is Vec3us -> Vec3us(x, y, z)
            is Vec3ul -> Vec3ul(x, y, z)
            else -> throw IllegalStateException()
        }
        @JvmName("xyz") set(value) {
            x = value.x as T
            y = value.y as T
            z = value.z as T
        }
    val xzx
        @JvmName("xzx") get() = when (this) {
            is Vec3 -> Vec3(x, z, x)
            is Vec3d -> Vec3d(x, z, x)
            is Vec3b -> Vec3b(x, z, x)
            is Vec3i -> Vec3i(x, z, x)
            is Vec3s -> Vec3s(x, z, x)
            is Vec3l -> Vec3l(x, z, x)
            is Vec3ub -> Vec3ub(x, z, x)
            is Vec3ui -> Vec3ui(x, z, x)
            is Vec3us -> Vec3us(x, z, x)
            is Vec3ul -> Vec3ul(x, z, x)
            else -> throw IllegalStateException()
        }
    var xzy
        @JvmName("xzy") get() = when (this) {
            is Vec3 -> Vec3(x, z, y)
            is Vec3d -> Vec3d(x, z, y)
            is Vec3b -> Vec3b(x, z, y)
            is Vec3i -> Vec3i(x, z, y)
            is Vec3s -> Vec3s(x, z, y)
            is Vec3l -> Vec3l(x, z, y)
            is Vec3ub -> Vec3ub(x, z, y)
            is Vec3ui -> Vec3ui(x, z, y)
            is Vec3us -> Vec3us(x, z, y)
            is Vec3ul -> Vec3ul(x, z, y)
            else -> throw IllegalStateException()
        }
        @JvmName("xzy") set(value) {
            x = value.x as T
            z = value.y as T
            y = value.z as T
        }
    val xzz
        @JvmName("xzz") get() = when (this) {
            is Vec3 -> Vec3(x, z, z)
            is Vec3d -> Vec3d(x, z, z)
            is Vec3b -> Vec3b(x, z, z)
            is Vec3i -> Vec3i(x, z, z)
            is Vec3s -> Vec3s(x, z, z)
            is Vec3l -> Vec3l(x, z, z)
            is Vec3ub -> Vec3ub(x, z, z)
            is Vec3ui -> Vec3ui(x, z, z)
            is Vec3us -> Vec3us(x, z, z)
            is Vec3ul -> Vec3ul(x, z, z)
            else -> throw IllegalStateException()
        }
    val yxx
        @JvmName("yxx") get() = when (this) {
            is Vec3 -> Vec3(y, x, x)
            is Vec3d -> Vec3d(y, x, x)
            is Vec3b -> Vec3b(y, x, x)
            is Vec3i -> Vec3i(y, x, x)
            is Vec3s -> Vec3s(y, x, x)
            is Vec3l -> Vec3l(y, x, x)
            is Vec3ub -> Vec3ub(y, x, x)
            is Vec3ui -> Vec3ui(y, x, x)
            is Vec3us -> Vec3us(y, x, x)
            is Vec3ul -> Vec3ul(y, x, x)
            else -> throw IllegalStateException()
        }
    val yxy
        @JvmName("yxy") get() = when (this) {
            is Vec3 -> Vec3(y, x, y)
            is Vec3d -> Vec3d(y, x, y)
            is Vec3b -> Vec3b(y, x, y)
            is Vec3i -> Vec3i(y, x, y)
            is Vec3s -> Vec3s(y, x, y)
            is Vec3l -> Vec3l(y, x, y)
            is Vec3ub -> Vec3ub(y, x, y)
            is Vec3ui -> Vec3ui(y, x, y)
            is Vec3us -> Vec3us(y, x, y)
            is Vec3ul -> Vec3ul(y, x, y)
            else -> throw IllegalStateException()
        }
    var yxz
        @JvmName("yxz") get() = when (this) {
            is Vec3 -> Vec3(y, x, z)
            is Vec3d -> Vec3d(y, x, z)
            is Vec3b -> Vec3b(y, x, z)
            is Vec3i -> Vec3i(y, x, z)
            is Vec3s -> Vec3s(y, x, z)
            is Vec3l -> Vec3l(y, x, z)
            is Vec3ub -> Vec3ub(y, x, z)
            is Vec3ui -> Vec3ui(y, x, z)
            is Vec3us -> Vec3us(y, x, z)
            is Vec3ul -> Vec3ul(y, x, z)
            else -> throw IllegalStateException()
        }
        @JvmName("yxz") set(value) {
            y = value.x as T
            x = value.y as T
            z = value.z as T
        }
    val yyx
        @JvmName("yyx") get() = when (this) {
            is Vec3 -> Vec3(y, y, x)
            is Vec3d -> Vec3d(y, y, x)
            is Vec3b -> Vec3b(y, y, x)
            is Vec3i -> Vec3i(y, y, x)
            is Vec3s -> Vec3s(y, y, x)
            is Vec3l -> Vec3l(y, y, x)
            is Vec3ub -> Vec3ub(y, y, x)
            is Vec3ui -> Vec3ui(y, y, x)
            is Vec3us -> Vec3us(y, y, x)
            is Vec3ul -> Vec3ul(y, y, x)
            else -> throw IllegalStateException()
        }
    val yyy
        @JvmName("yyy") get() = when (this) {
            is Vec3 -> Vec3(y, y, y)
            is Vec3d -> Vec3d(y, y, y)
            is Vec3b -> Vec3b(y, y, y)
            is Vec3i -> Vec3i(y, y, y)
            is Vec3s -> Vec3s(y, y, y)
            is Vec3l -> Vec3l(y, y, y)
            is Vec3ub -> Vec3ub(y, y, y)
            is Vec3ui -> Vec3ui(y, y, y)
            is Vec3us -> Vec3us(y, y, y)
            is Vec3ul -> Vec3ul(y, y, y)
            else -> throw IllegalStateException()
        }
    val yyz
        @JvmName("yyz") get() = when (this) {
            is Vec3 -> Vec3(y, y, z)
            is Vec3d -> Vec3d(y, y, z)
            is Vec3b -> Vec3b(y, y, z)
            is Vec3i -> Vec3i(y, y, z)
            is Vec3s -> Vec3s(y, y, z)
            is Vec3l -> Vec3l(y, y, z)
            is Vec3ub -> Vec3ub(y, y, z)
            is Vec3ui -> Vec3ui(y, y, z)
            is Vec3us -> Vec3us(y, y, z)
            is Vec3ul -> Vec3ul(y, y, z)
            else -> throw IllegalStateException()
        }
    var yzx
        @JvmName("yzx") get() = when (this) {
            is Vec3 -> Vec3(y, z, x)
            is Vec3d -> Vec3d(y, z, x)
            is Vec3b -> Vec3b(y, z, x)
            is Vec3i -> Vec3i(y, z, x)
            is Vec3s -> Vec3s(y, z, x)
            is Vec3l -> Vec3l(y, z, x)
            is Vec3ub -> Vec3ub(y, z, x)
            is Vec3ui -> Vec3ui(y, z, x)
            is Vec3us -> Vec3us(y, z, x)
            is Vec3ul -> Vec3ul(y, z, x)
            else -> throw IllegalStateException()
        }
        @JvmName("xzx") set(value) {
            y = value.x as T
            z = value.y as T
            x = value.z as T
        }
    val yzy
        @JvmName("yzy") get() = when (this) {
            is Vec3 -> Vec3(y, z, y)
            is Vec3d -> Vec3d(y, z, y)
            is Vec3b -> Vec3b(y, z, y)
            is Vec3i -> Vec3i(y, z, y)
            is Vec3s -> Vec3s(y, z, y)
            is Vec3l -> Vec3l(y, z, y)
            is Vec3ub -> Vec3ub(y, z, y)
            is Vec3ui -> Vec3ui(y, z, y)
            is Vec3us -> Vec3us(y, z, y)
            is Vec3ul -> Vec3ul(y, z, y)
            else -> throw IllegalStateException()
        }
    val yzz
        @JvmName("yzz") get() = when (this) {
            is Vec3 -> Vec3(y, z, z)
            is Vec3d -> Vec3d(y, z, z)
            is Vec3b -> Vec3b(y, z, z)
            is Vec3i -> Vec3i(y, z, z)
            is Vec3s -> Vec3s(y, z, z)
            is Vec3l -> Vec3l(y, z, z)
            is Vec3ub -> Vec3ub(y, z, z)
            is Vec3ui -> Vec3ui(y, z, z)
            is Vec3us -> Vec3us(y, z, z)
            is Vec3ul -> Vec3ul(y, z, z)
            else -> throw IllegalStateException()
        }
    val zxx
        @JvmName("zxx") get() = when (this) {
            is Vec3 -> Vec3(z, x, x)
            is Vec3d -> Vec3d(z, x, x)
            is Vec3b -> Vec3b(z, x, x)
            is Vec3i -> Vec3i(z, x, x)
            is Vec3s -> Vec3s(z, x, x)
            is Vec3l -> Vec3l(z, x, x)
            is Vec3ub -> Vec3ub(z, x, x)
            is Vec3ui -> Vec3ui(z, x, x)
            is Vec3us -> Vec3us(z, x, x)
            is Vec3ul -> Vec3ul(z, x, x)
            else -> throw IllegalStateException()
        }
    var zxy
        @JvmName("zxy") get() = when (this) {
            is Vec3 -> Vec3(z, x, y)
            is Vec3d -> Vec3d(z, x, y)
            is Vec3b -> Vec3b(z, x, y)
            is Vec3i -> Vec3i(z, x, y)
            is Vec3s -> Vec3s(z, x, y)
            is Vec3l -> Vec3l(z, x, y)
            is Vec3ub -> Vec3ub(z, x, y)
            is Vec3ui -> Vec3ui(z, x, y)
            is Vec3us -> Vec3us(z, x, y)
            is Vec3ul -> Vec3ul(z, x, y)
            else -> throw IllegalStateException()
        }
        @JvmName("zxy") set(value) {
            z = value.x as T
            x = value.y as T
            y = value.z as T
        }
    val zxz
        @JvmName("zxz") get() = when (this) {
            is Vec3 -> Vec3(z, x, z)
            is Vec3d -> Vec3d(z, x, z)
            is Vec3b -> Vec3b(z, x, z)
            is Vec3i -> Vec3i(z, x, z)
            is Vec3s -> Vec3s(z, x, z)
            is Vec3l -> Vec3l(z, x, z)
            is Vec3ub -> Vec3ub(z, x, z)
            is Vec3ui -> Vec3ui(z, x, z)
            is Vec3us -> Vec3us(z, x, z)
            is Vec3ul -> Vec3ul(z, x, z)
            else -> throw IllegalStateException()
        }
    var zyx
        @JvmName("zyx") get() = when (this) {
            is Vec3 -> Vec3(z, y, x)
            is Vec3d -> Vec3d(z, y, x)
            is Vec3b -> Vec3b(z, y, x)
            is Vec3i -> Vec3i(z, y, x)
            is Vec3s -> Vec3s(z, y, x)
            is Vec3l -> Vec3l(z, y, x)
            is Vec3ub -> Vec3ub(z, y, x)
            is Vec3ui -> Vec3ui(z, y, x)
            is Vec3us -> Vec3us(z, y, x)
            is Vec3ul -> Vec3ul(z, y, x)
            else -> throw IllegalStateException()
        }
        @JvmName("zyx") set(value) {
            z = value.x as T
            y = value.y as T
            x = value.z as T
        }
    val zyy
        @JvmName("zyy") get() = when (this) {
            is Vec3 -> Vec3(z, y, y)
            is Vec3d -> Vec3d(z, y, y)
            is Vec3b -> Vec3b(z, y, y)
            is Vec3i -> Vec3i(z, y, y)
            is Vec3s -> Vec3s(z, y, y)
            is Vec3l -> Vec3l(z, y, y)
            is Vec3ub -> Vec3ub(z, y, y)
            is Vec3ui -> Vec3ui(z, y, y)
            is Vec3us -> Vec3us(z, y, y)
            is Vec3ul -> Vec3ul(z, y, y)
            else -> throw IllegalStateException()
        }
    val zyz
        @JvmName("zyz") get() = when (this) {
            is Vec3 -> Vec3(z, y, z)
            is Vec3d -> Vec3d(z, y, z)
            is Vec3b -> Vec3b(z, y, z)
            is Vec3i -> Vec3i(z, y, z)
            is Vec3s -> Vec3s(z, y, z)
            is Vec3l -> Vec3l(z, y, z)
            is Vec3ub -> Vec3ub(z, y, z)
            is Vec3ui -> Vec3ui(z, y, z)
            is Vec3us -> Vec3us(z, y, z)
            is Vec3ul -> Vec3ul(z, y, z)
            else -> throw IllegalStateException()
        }
    val zzx
        @JvmName("zzx") get() = when (this) {
            is Vec3 -> Vec3(z, z, x)
            is Vec3d -> Vec3d(z, z, x)
            is Vec3b -> Vec3b(z, z, x)
            is Vec3i -> Vec3i(z, z, x)
            is Vec3s -> Vec3s(z, z, x)
            is Vec3l -> Vec3l(z, z, x)
            is Vec3ub -> Vec3ub(z, z, x)
            is Vec3ui -> Vec3ui(z, z, x)
            is Vec3us -> Vec3us(z, z, x)
            is Vec3ul -> Vec3ul(z, z, x)
            else -> throw IllegalStateException()
        }
    val zzy
        @JvmName("zzy") get() = when (this) {
            is Vec3 -> Vec3(z, z, y)
            is Vec3d -> Vec3d(z, z, y)
            is Vec3b -> Vec3b(z, z, y)
            is Vec3i -> Vec3i(z, z, y)
            is Vec3s -> Vec3s(z, z, y)
            is Vec3l -> Vec3l(z, z, y)
            is Vec3ub -> Vec3ub(z, z, y)
            is Vec3ui -> Vec3ui(z, z, y)
            is Vec3us -> Vec3us(z, z, y)
            is Vec3ul -> Vec3ul(z, z, y)
            else -> throw IllegalStateException()
        }
    val zzz
        @JvmName("zzz") get() = when (this) {
            is Vec3 -> Vec3(z, z, z)
            is Vec3d -> Vec3d(z, z, z)
            is Vec3b -> Vec3b(z, z, z)
            is Vec3i -> Vec3i(z, z, z)
            is Vec3s -> Vec3s(z, z, z)
            is Vec3l -> Vec3l(z, z, z)
            is Vec3ub -> Vec3ub(z, z, z)
            is Vec3ui -> Vec3ui(z, z, z)
            is Vec3us -> Vec3us(z, z, z)
            is Vec3ul -> Vec3ul(z, z, z)
            else -> throw IllegalStateException()
        }
}