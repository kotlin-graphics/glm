package glm_.ext

import glm_.*
import kotlin.math.max
import kotlin.math.min

interface ext_scalarCommon {

    /** Returns the minimum component-wise values of 3 inputs */
    fun min(a: Float, b: Float, c: Float): Float = min(min(a, b), c)
    /** Returns the minimum component-wise values of 3 inputs */
    fun min(a: Double, b: Double, c: Double): Double = min(min(a, b), c)
    /** Returns the minimum component-wise values of 3 inputs */
    fun min(a: Byte, b: Byte, c: Byte): Byte = min(min(a.i, b.i), c.i).b
    /** Returns the minimum component-wise values of 3 inputs */
    fun min(a: Int, b: Int, c: Int): Int = min(min(a, b), c)
    /** Returns the minimum component-wise values of 3 inputs */
    fun min(a: Long, b: Long, c: Long): Long = min(min(a, b), c)
    /** Returns the minimum component-wise values of 3 inputs */
    fun min(a: Short, b: Short, c: Short): Short = min(min(a.i, b.i), c.i).s
    /** Returns the minimum component-wise values of 3 inputs */
    fun min(a: Char, b: Char, c: Char): Char = glm.min(glm.min(a, b), c)


    /** Returns the maximum component-wise values of 3 inputs */
    fun max(a: Float, b: Float, c: Float): Float = max(max(a, b), c)
    /** Returns the maximum component-wise values of 3 inputs */
    fun max(a: Double, b: Double, c: Double): Double = max(max(a, b), c)
    /** Returns the maximum component-wise values of 3 inputs */
    fun max(a: Byte, b: Byte, c: Byte): Byte = max(max(a.i, b.i), c.i).b
    /** Returns the maximum component-wise values of 3 inputs */
    fun max(a: Int, b: Int, c: Int): Int = max(max(a, b), c)
    /** Returns the maximum component-wise values of 3 inputs */
    fun max(a: Long, b: Long, c: Long): Long = max(max(a, b), c)
    /** Returns the maximum component-wise values of 3 inputs */
    fun max(a: Short, b: Short, c: Short): Short = max(max(a.i, b.i), c.i).s
    /** Returns the maximum component-wise values of 3 inputs */
    fun max(a: Char, b: Char, c: Char): Char = glm.max(glm.max(a, b), c)


    /** Returns the minimum component-wise values of 4 inputs */
    fun min(a: Float, b: Float, c: Float, d: Float): Float = min(min(a, b), min(c, d))
    /** Returns the minimum component-wise values of 4 inputs */
    fun min(a: Double, b: Double, c: Double, d: Double): Double = min(min(a, b), min(c, d))
    /** Returns the minimum component-wise values of 4 inputs */
    fun min(a: Byte, b: Byte, c: Byte, d: Byte): Byte = min(min(a.i, b.i), min(c.i, d.i)).b
    /** Returns the minimum component-wise values of 4 inputs */
    fun min(a: Int, b: Int, c: Int, d: Int): Int = min(min(a, b), min(c, d))
    /** Returns the minimum component-wise values of 4 inputs */
    fun min(a: Long, b: Long, c: Long, d: Long): Long = min(min(a, b), min(c, d))
    /** Returns the minimum component-wise values of 4 inputs */
    fun min(a: Short, b: Short, c: Short, d: Long): Short = min(min(a.i, b.i), min(c.i, d.i)).s
    /** Returns the minimum component-wise values of 4 inputs */
    fun min(a: Char, b: Char, c: Char, d: Char): Char = glm.min(glm.min(a, b), glm.min(c, d))


    /** Returns the maximum component-wise values of 4 inputs */
    fun max(a: Float, b: Float, c: Float, d: Float): Float = max(max(a, b), max(c, d))
    /** Returns the maximum component-wise values of 4 inputs */
    fun max(a: Double, b: Double, c: Double, d: Double): Double = max(max(a, b), max(c, d))
    /** Returns the maximum component-wise values of 4 inputs */
    fun max(a: Byte, b: Byte, c: Byte, d: Byte): Byte = max(max(a.i, b.i), max(c.i, d.i)).b
    /** Returns the maximum component-wise values of 4 inputs */
    fun max(a: Int, b: Int, c: Int, d: Int): Int = max(max(a, b), max(c, d))
    /** Returns the maximum component-wise values of 4 inputs */
    fun max(a: Long, b: Long, c: Long, d: Long): Long = max(max(a, b), max(c, d))
    /** Returns the maximum component-wise values of 4 inputs */
    fun max(a: Short, b: Short, c: Short, d: Long): Short = max(max(a.i, b.i), max(c.i, d.i)).s
    /** Returns the maximum component-wise values of 4 inputs */
    fun max(a: Char, b: Char, c: Char, d: Char): Char = glm.max(glm.max(a, b), glm.max(c, d))


    /** Returns the minimum component-wise values of 2 inputs. If one of the two arguments is NaN, the value of the other argument is returned. */
    fun fmin(a: Float, b: Float): Float = when {
        a.isNaN -> b
        b.isNaN -> a
        else -> min(a, b)
    }

    /** Returns the maximum component-wise values of 3 inputs. If one of the two arguments is NaN,
     *  the value of the other argument is returned. */
    fun fmin(a: Float, b: Float, c: Float): Float = when {
        a.isNaN -> fmin(b, c)
        b.isNaN -> fmin(a, c)
        c.isNaN -> min(a, b)
        else -> min(a, b, c)
    }

    /** Returns the minimum component-wise values of 4 inputs. If one of the two arguments is NaN, the value of the other argument is returned. */
    fun fmin(a: Float, b: Float, c: Float, d: Float): Float = when {
        a.isNaN -> fmin(b, c, d)
        b.isNaN -> min(a, fmin(c, d))
        c.isNaN -> fmin(min(a, b), d)
        d.isNaN -> min(a, b, c)
        else -> min(a, b, c, d)
    }

    /** Returns the minimum component-wise values of 2 inputs. If one of the two arguments is NaN, the value of the other argument is returned. */
    fun fmax(a: Float, b: Float): Float = when {
        a.isNaN -> b
        b.isNaN -> a
        else -> max(a, b)
    }

    /** Returns the maximum component-wise values of 3 inputs. If one of the two arguments is NaN,
     *  the value of the other argument is returned. */
    fun fmax(a: Float, b: Float, c: Float): Float = when {
        a.isNaN -> fmax(b, c)
        b.isNaN -> fmax(a, c)
        c.isNaN -> max(a, b)
        else -> max(a, b, c)
    }

    /** Returns the minimum component-wise values of 4 inputs. If one of the two arguments is NaN, the value of the other argument is returned. */
    fun fmax(a: Float, b: Float, c: Float, d: Float): Float = when {
        a.isNaN -> fmax(b, c, d)
        b.isNaN -> max(a, fmax(c, d))
        c.isNaN -> fmax(max(a, b), d)
        d.isNaN -> max(a, b, c)
        else -> max(a, b, c, d)
    }


    // ------------------------------------------- Double -------------------------------------------


    /** Returns the minimum component-wise values of 2 inputs. If one of the two arguments is NaN, the value of the other argument is returned. */
    fun fmin(a: Double, b: Double): Double = when {
        a.isNaN -> b
        b.isNaN -> a
        else -> min(a, b)
    }

    /** Returns the maximum component-wise values of 3 inputs. If one of the two arguments is NaN,
     *  the value of the other argument is returned. */
    fun fmin(a: Double, b: Double, c: Double): Double = when {
        a.isNaN -> fmin(b, c)
        b.isNaN -> fmin(a, c)
        c.isNaN -> min(a, b)
        else -> min(a, b, c)
    }

    /** Returns the minimum component-wise values of 4 inputs. If one of the two arguments is NaN, the value of the other argument is returned. */
    fun fmin(a: Double, b: Double, c: Double, d: Double): Double = when {
        a.isNaN -> fmin(b, c, d)
        b.isNaN -> min(a, fmin(c, d))
        c.isNaN -> fmin(min(a, b), d)
        d.isNaN -> min(a, b, c)
        else -> min(a, b, c, d)
    }

    /** Returns the minimum component-wise values of 2 inputs. If one of the two arguments is NaN, the value of the other argument is returned. */
    fun fmax(a: Double, b: Double): Double = when {
        a.isNaN -> b
        b.isNaN -> a
        else -> max(a, b)
    }

    /** Returns the maximum component-wise values of 3 inputs. If one of the two arguments is NaN,
     *  the value of the other argument is returned. */
    fun fmax(a: Double, b: Double, c: Double): Double = when {
        a.isNaN -> fmax(b, c)
        b.isNaN -> fmax(a, c)
        c.isNaN -> max(a, b)
        else -> max(a, b, c)
    }

    /** Returns the minimum component-wise values of 4 inputs. If one of the two arguments is NaN, the value of the other argument is returned. */
    fun fmax(a: Double, b: Double, c: Double, d: Double): Double = when {
        a.isNaN -> fmax(b, c, d)
        b.isNaN -> max(a, fmax(c, d))
        c.isNaN -> fmax(max(a, b), d)
        d.isNaN -> max(a, b, c)
        else -> max(a, b, c, d)
    }
}
