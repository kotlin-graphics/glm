package glm_.ext

import glm_.mat2x2.Mat2
import glm_.mat2x2.Mat2d
import glm_.mat3x3.Mat3
import glm_.mat3x3.Mat3d
import glm_.mat4x4.Mat4
import glm_.mat4x4.Mat4d
import glm_.vec2.Vec2
import glm_.vec2.Vec2bool
import glm_.vec2.Vec2d
import glm_.vec3.Vec3
import glm_.vec3.Vec3bool
import glm_.vec3.Vec3d
import glm_.vec4.Vec4
import glm_.vec4.Vec4bool
import glm_.vec4.Vec4d

interface matrixRelational {

    /** Perform a component-wise equal-to comparison of two matrices.
     *  Return a boolean vector which components value is True if this expression is satisfied per column of the matrices. */
    fun equal(x: Mat2, y: Mat2, epsilon: Float = 0f, res: Vec2bool = Vec2bool()): Vec2bool {
        res.x = x[0, 0].equal(y[0, 0], epsilon) && x[0, 1].equal(y[0, 1], epsilon)
        res.y = x[1, 0].equal(y[1, 0], epsilon) && x[1, 1].equal(y[1, 1], epsilon)
        return res
    }

    /** Perform a component-wise equal-to comparison of two matrices.
     *  Return a boolean vector which components value is True if this expression is satisfied per column of the matrices. */
    fun equal(x: Mat3, y: Mat3, epsilon: Float = 0f, res: Vec3bool = Vec3bool()): Vec3bool {
        res.x = x[0, 0].equal(y[0, 0], epsilon) && x[0, 1].equal(y[0, 1], epsilon) && x[0, 2].equal(y[0, 2], epsilon)
        res.y = x[1, 0].equal(y[1, 0], epsilon) && x[1, 1].equal(y[1, 1], epsilon) && x[1, 2].equal(y[1, 2], epsilon)
        res.z = x[2, 0].equal(y[2, 0], epsilon) && x[2, 1].equal(y[2, 1], epsilon) && x[2, 2].equal(y[2, 2], epsilon)
        return res
    }

    /** Perform a component-wise equal-to comparison of two matrices.
     *  Return a boolean vector which components value is True if this expression is satisfied per column of the matrices. */
    fun equal(x: Mat4, y: Mat4, epsilon: Float = 0f, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = x[0, 0].equal(y[0, 0], epsilon) && x[0, 1].equal(y[0, 1], epsilon) && x[0, 2].equal(y[0, 2], epsilon) && x[0, 3].equal(y[0, 3], epsilon)
        res.y = x[1, 0].equal(y[1, 0], epsilon) && x[1, 1].equal(y[1, 1], epsilon) && x[1, 2].equal(y[1, 2], epsilon) && x[1, 3].equal(y[1, 3], epsilon)
        res.z = x[2, 0].equal(y[2, 0], epsilon) && x[2, 1].equal(y[2, 1], epsilon) && x[2, 2].equal(y[2, 2], epsilon) && x[2, 3].equal(y[2, 3], epsilon)
        res.w = x[3, 0].equal(y[3, 0], epsilon) && x[3, 1].equal(y[3, 1], epsilon) && x[3, 2].equal(y[3, 2], epsilon) && x[3, 3].equal(y[3, 3], epsilon)
        return res
    }

    /** Returns the component-wise comparison of |x - y| < epsilon.
     *  True if this expression is satisfied. */
    fun equal(x: Mat2, y: Mat2, epsilon: Vec2 = Vec2(0f), res: Vec2bool = Vec2bool()): Vec2bool {
        res.x = x[0, 0].equal(y[0, 0], epsilon[0]) && x[0, 1].equal(y[0, 1], epsilon[0])
        res.y = x[1, 0].equal(y[1, 0], epsilon[1]) && x[1, 1].equal(y[1, 1], epsilon[1])
        return res
    }

    /** Returns the component-wise comparison of |x - y| < epsilon.
     *  True if this expression is satisfied. */
    fun equal(x: Mat3, y: Mat3, epsilon: Vec3 = Vec3(0f), res: Vec3bool = Vec3bool()): Vec3bool {
        res.x = x[0, 0].equal(y[0, 0], epsilon[0]) && x[0, 1].equal(y[0, 1], epsilon[0]) && x[0, 2].equal(y[0, 2], epsilon[0])
        res.y = x[1, 0].equal(y[1, 0], epsilon[1]) && x[1, 1].equal(y[1, 1], epsilon[1]) && x[1, 2].equal(y[1, 2], epsilon[1])
        res.z = x[2, 0].equal(y[2, 0], epsilon[2]) && x[2, 1].equal(y[2, 1], epsilon[2]) && x[2, 2].equal(y[2, 2], epsilon[2])
        return res
    }

    /** Returns the component-wise comparison of |x - y| < epsilon.
     *  True if this expression is satisfied. */
    fun equal(x: Mat4, y: Mat4, epsilon: Vec4 = Vec4(0f), res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = x[0, 0].equal(y[0, 0], epsilon[0]) && x[0, 1].equal(y[0, 1], epsilon[0]) && x[0, 2].equal(y[0, 2], epsilon[0]) && x[0, 3].equal(y[0, 3], epsilon[0])
        res.y = x[1, 0].equal(y[1, 0], epsilon[1]) && x[1, 1].equal(y[1, 1], epsilon[1]) && x[1, 2].equal(y[1, 2], epsilon[1]) && x[1, 3].equal(y[1, 3], epsilon[1])
        res.z = x[2, 0].equal(y[2, 0], epsilon[2]) && x[2, 1].equal(y[2, 1], epsilon[2]) && x[2, 2].equal(y[2, 2], epsilon[2]) && x[2, 3].equal(y[2, 3], epsilon[2])
        res.w = x[3, 0].equal(y[3, 0], epsilon[3]) && x[3, 1].equal(y[3, 1], epsilon[3]) && x[3, 2].equal(y[3, 2], epsilon[3]) && x[3, 3].equal(y[3, 3], epsilon[3])
        return res
    }

    /** Perform a component-wise not-equal-to comparison of two matrices.
     *  Return a boolean vector which components value is True if this expression is satisfied per column of the matrices. */
    fun notEqual(x: Mat2, y: Mat2, epsilon: Float = 0f, res: Vec2bool = Vec2bool()): Vec2bool {
        res.x = x[0, 0].notEqual(y[0, 0], epsilon) || x[0, 1].notEqual(y[0, 1], epsilon)
        res.y = x[1, 0].notEqual(y[1, 0], epsilon) || x[1, 1].notEqual(y[1, 1], epsilon)
        return res
    }

    /** Perform a component-wise not-equal-to comparison of two matrices.
     *  Return a boolean vector which components value is True if this expression is satisfied per column of the matrices. */
    fun notEqual(x: Mat3, y: Mat3, epsilon: Float = 0f, res: Vec3bool = Vec3bool()): Vec3bool {
        res.x = x[0, 0].notEqual(y[0, 0], epsilon) || x[0, 1].notEqual(y[0, 1], epsilon) || x[0, 2].notEqual(y[0, 2], epsilon)
        res.y = x[1, 0].notEqual(y[1, 0], epsilon) || x[1, 1].notEqual(y[1, 1], epsilon) || x[1, 2].notEqual(y[1, 2], epsilon)
        res.z = x[2, 0].notEqual(y[2, 0], epsilon) || x[2, 1].notEqual(y[2, 1], epsilon) || x[2, 2].notEqual(y[2, 2], epsilon)
        return res
    }

    /** Perform a component-wise equal-to comparison of two matrices.
     *  Return a boolean vector which components value is True if this expression is satisfied per column of the matrices. */
    fun notEqual(x: Mat4, y: Mat4, epsilon: Float = 0f, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = x[0, 0].notEqual(y[0, 0], epsilon) || x[0, 1].notEqual(y[0, 1], epsilon) || x[0, 2].notEqual(y[0, 2], epsilon) || x[0, 3].notEqual(y[0, 3], epsilon)
        res.y = x[1, 0].notEqual(y[1, 0], epsilon) || x[1, 1].notEqual(y[1, 1], epsilon) || x[1, 2].notEqual(y[1, 2], epsilon) || x[1, 3].notEqual(y[1, 3], epsilon)
        res.z = x[2, 0].notEqual(y[2, 0], epsilon) || x[2, 1].notEqual(y[2, 1], epsilon) || x[2, 2].notEqual(y[2, 2], epsilon) || x[2, 3].notEqual(y[2, 3], epsilon)
        res.w = x[3, 0].notEqual(y[3, 0], epsilon) || x[3, 1].notEqual(y[3, 1], epsilon) || x[3, 2].notEqual(y[3, 2], epsilon) || x[3, 3].notEqual(y[3, 3], epsilon)
        return res
    }

    /** Returns the component-wise comparison of |x - y| >= epsilon.
     *  True if this expression is satisfied. */
    fun notEqual(x: Mat2, y: Mat2, epsilon: Vec2 = Vec2(0f), res: Vec2bool = Vec2bool()): Vec2bool {
        res.x = x[0, 0].notEqual(y[0, 0], epsilon[0]) || x[0, 1].notEqual(y[0, 1], epsilon[0])
        res.y = x[1, 0].notEqual(y[1, 0], epsilon[1]) || x[1, 1].notEqual(y[1, 1], epsilon[1])
        return res
    }

    /** Returns the component-wise comparison of |x - y| >= epsilon.
     *  True if this expression is satisfied. */
    fun notEqual(x: Mat3, y: Mat3, epsilon: Vec3 = Vec3(0f), res: Vec3bool = Vec3bool()): Vec3bool {
        res.x = x[0, 0].notEqual(y[0, 0], epsilon[0]) || x[0, 1].notEqual(y[0, 1], epsilon[0]) || x[0, 2].notEqual(y[0, 2], epsilon[0])
        res.y = x[1, 0].notEqual(y[1, 0], epsilon[1]) || x[1, 1].notEqual(y[1, 1], epsilon[1]) || x[1, 2].notEqual(y[1, 2], epsilon[1])
        res.z = x[2, 0].notEqual(y[2, 0], epsilon[2]) || x[2, 1].notEqual(y[2, 1], epsilon[2]) || x[2, 2].notEqual(y[2, 2], epsilon[2])
        return res
    }

    /** Returns the component-wise comparison of |x - y| >= epsilon.
     *  True if this expression is satisfied. */
    fun notEqual(x: Mat4, y: Mat4, epsilon: Vec4 = Vec4(0f), res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = x[0, 0].notEqual(y[0, 0], epsilon[0]) || x[0, 1].notEqual(y[0, 1], epsilon[0]) || x[0, 2].notEqual(y[0, 2], epsilon[0]) || x[0, 3].notEqual(y[0, 3], epsilon[0])
        res.y = x[1, 0].notEqual(y[1, 0], epsilon[1]) || x[1, 1].notEqual(y[1, 1], epsilon[1]) || x[1, 2].notEqual(y[1, 2], epsilon[1]) || x[1, 3].notEqual(y[1, 3], epsilon[1])
        res.z = x[2, 0].notEqual(y[2, 0], epsilon[2]) || x[2, 1].notEqual(y[2, 1], epsilon[2]) || x[2, 2].notEqual(y[2, 2], epsilon[2]) || x[2, 3].notEqual(y[2, 3], epsilon[2])
        res.w = x[3, 0].notEqual(y[3, 0], epsilon[3]) || x[3, 1].notEqual(y[3, 1], epsilon[3]) || x[3, 2].notEqual(y[3, 2], epsilon[3]) || x[3, 3].notEqual(y[3, 3], epsilon[3])
        return res
    }

    // double


    /** Perform a component-wise equal-to comparison of two matrices.
     *  Return a boolean vector which components value is True if this expression is satisfied per column of the matrices. */
    fun equal(x: Mat2d, y: Mat2d, epsilon: Double = 0.0, res: Vec2bool = Vec2bool()): Vec2bool {
        res.x = x[0, 0].equal(y[0, 0], epsilon) && x[0, 1].equal(y[0, 1], epsilon)
        res.y = x[1, 0].equal(y[1, 0], epsilon) && x[1, 1].equal(y[1, 1], epsilon)
        return res
    }

    /** Perform a component-wise equal-to comparison of two matrices.
     *  Return a boolean vector which components value is True if this expression is satisfied per column of the matrices. */
    fun equal(x: Mat3d, y: Mat3d, epsilon: Double = 0.0, res: Vec3bool = Vec3bool()): Vec3bool {
        res.x = x[0, 0].equal(y[0, 0], epsilon) && x[0, 1].equal(y[0, 1], epsilon) && x[0, 2].equal(y[0, 2], epsilon)
        res.y = x[1, 0].equal(y[1, 0], epsilon) && x[1, 1].equal(y[1, 1], epsilon) && x[1, 2].equal(y[1, 2], epsilon)
        res.z = x[2, 0].equal(y[2, 0], epsilon) && x[2, 1].equal(y[2, 1], epsilon) && x[2, 2].equal(y[2, 2], epsilon)
        return res
    }

    /** Perform a component-wise equal-to comparison of two matrices.
     *  Return a boolean vector which components value is True if this expression is satisfied per column of the matrices. */
    fun equal(x: Mat4d, y: Mat4d, epsilon: Double = 0.0, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = x[0, 0].equal(y[0, 0], epsilon) && x[0, 1].equal(y[0, 1], epsilon) && x[0, 2].equal(y[0, 2], epsilon) && x[0, 3].equal(y[0, 3], epsilon)
        res.y = x[1, 0].equal(y[1, 0], epsilon) && x[1, 1].equal(y[1, 1], epsilon) && x[1, 2].equal(y[1, 2], epsilon) && x[1, 3].equal(y[1, 3], epsilon)
        res.z = x[2, 0].equal(y[2, 0], epsilon) && x[2, 1].equal(y[2, 1], epsilon) && x[2, 2].equal(y[2, 2], epsilon) && x[2, 3].equal(y[2, 3], epsilon)
        res.w = x[3, 0].equal(y[3, 0], epsilon) && x[3, 1].equal(y[3, 1], epsilon) && x[3, 2].equal(y[3, 2], epsilon) && x[3, 3].equal(y[3, 3], epsilon)
        return res
    }

    /** Returns the component-wise comparison of |x - y| < epsilon.
     *  True if this expression is satisfied. */
    fun equal(x: Mat2d, y: Mat2d, epsilon: Vec2d = Vec2d(0.0), res: Vec2bool = Vec2bool()): Vec2bool {
        res.x = x[0, 0].equal(y[0, 0], epsilon[0]) && x[0, 1].equal(y[0, 1], epsilon[0])
        res.y = x[1, 0].equal(y[1, 0], epsilon[1]) && x[1, 1].equal(y[1, 1], epsilon[1])
        return res
    }

    /** Returns the component-wise comparison of |x - y| < epsilon.
     *  True if this expression is satisfied. */
    fun equal(x: Mat3d, y: Mat3d, epsilon: Vec3d = Vec3d(0.0), res: Vec3bool = Vec3bool()): Vec3bool {
        res.x = x[0, 0].equal(y[0, 0], epsilon[0]) && x[0, 1].equal(y[0, 1], epsilon[0]) && x[0, 2].equal(y[0, 2], epsilon[0])
        res.y = x[1, 0].equal(y[1, 0], epsilon[1]) && x[1, 1].equal(y[1, 1], epsilon[1]) && x[1, 2].equal(y[1, 2], epsilon[1])
        res.z = x[2, 0].equal(y[2, 0], epsilon[2]) && x[2, 1].equal(y[2, 1], epsilon[2]) && x[2, 2].equal(y[2, 2], epsilon[2])
        return res
    }

    /** Returns the component-wise comparison of |x - y| < epsilon.
     *  True if this expression is satisfied. */
    fun equal(x: Mat4d, y: Mat4d, epsilon: Vec4d = Vec4d(0.0), res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = x[0, 0].equal(y[0, 0], epsilon[0]) && x[0, 1].equal(y[0, 1], epsilon[0]) && x[0, 2].equal(y[0, 2], epsilon[0]) && x[0, 3].equal(y[0, 3], epsilon[0])
        res.y = x[1, 0].equal(y[1, 0], epsilon[1]) && x[1, 1].equal(y[1, 1], epsilon[1]) && x[1, 2].equal(y[1, 2], epsilon[1]) && x[1, 3].equal(y[1, 3], epsilon[1])
        res.z = x[2, 0].equal(y[2, 0], epsilon[2]) && x[2, 1].equal(y[2, 1], epsilon[2]) && x[2, 2].equal(y[2, 2], epsilon[2]) && x[2, 3].equal(y[2, 3], epsilon[2])
        res.w = x[3, 0].equal(y[3, 0], epsilon[3]) && x[3, 1].equal(y[3, 1], epsilon[3]) && x[3, 2].equal(y[3, 2], epsilon[3]) && x[3, 3].equal(y[3, 3], epsilon[3])
        return res
    }

    /** Perform a component-wise not-equal-to comparison of two matrices.
     *  Return a boolean vector which components value is True if this expression is satisfied per column of the matrices. */
    fun notEqual(x: Mat2d, y: Mat2d, epsilon: Double = 0.0, res: Vec2bool = Vec2bool()): Vec2bool {
        res.x = x[0, 0].notEqual(y[0, 0], epsilon) || x[0, 1].notEqual(y[0, 1], epsilon)
        res.y = x[1, 0].notEqual(y[1, 0], epsilon) || x[1, 1].notEqual(y[1, 1], epsilon)
        return res
    }

    /** Perform a component-wise not-equal-to comparison of two matrices.
     *  Return a boolean vector which components value is True if this expression is satisfied per column of the matrices. */
    fun notEqual(x: Mat3d, y: Mat3d, epsilon: Double = 0.0, res: Vec3bool = Vec3bool()): Vec3bool {
        res.x = x[0, 0].notEqual(y[0, 0], epsilon) || x[0, 1].notEqual(y[0, 1], epsilon) || x[0, 2].notEqual(y[0, 2], epsilon)
        res.y = x[1, 0].notEqual(y[1, 0], epsilon) || x[1, 1].notEqual(y[1, 1], epsilon) || x[1, 2].notEqual(y[1, 2], epsilon)
        res.z = x[2, 0].notEqual(y[2, 0], epsilon) || x[2, 1].notEqual(y[2, 1], epsilon) || x[2, 2].notEqual(y[2, 2], epsilon)
        return res
    }

    /** Perform a component-wise equal-to comparison of two matrices.
     *  Return a boolean vector which components value is True if this expression is satisfied per column of the matrices. */
    fun notEqual(x: Mat4d, y: Mat4d, epsilon: Double = 0.0, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = x[0, 0].notEqual(y[0, 0], epsilon) || x[0, 1].notEqual(y[0, 1], epsilon) || x[0, 2].notEqual(y[0, 2], epsilon) || x[0, 3].notEqual(y[0, 3], epsilon)
        res.y = x[1, 0].notEqual(y[1, 0], epsilon) || x[1, 1].notEqual(y[1, 1], epsilon) || x[1, 2].notEqual(y[1, 2], epsilon) || x[1, 3].notEqual(y[1, 3], epsilon)
        res.z = x[2, 0].notEqual(y[2, 0], epsilon) || x[2, 1].notEqual(y[2, 1], epsilon) || x[2, 2].notEqual(y[2, 2], epsilon) || x[2, 3].notEqual(y[2, 3], epsilon)
        res.w = x[3, 0].notEqual(y[3, 0], epsilon) || x[3, 1].notEqual(y[3, 1], epsilon) || x[3, 2].notEqual(y[3, 2], epsilon) || x[3, 3].notEqual(y[3, 3], epsilon)
        return res
    }

    /** Returns the component-wise comparison of |x - y| >= epsilon.
     *  True if this expression is satisfied. */
    fun notEqual(x: Mat2d, y: Mat2d, epsilon: Vec2d = Vec2d(0.0), res: Vec2bool = Vec2bool()): Vec2bool {
        res.x = x[0, 0].notEqual(y[0, 0], epsilon[0]) || x[0, 1].notEqual(y[0, 1], epsilon[0])
        res.y = x[1, 0].notEqual(y[1, 0], epsilon[1]) || x[1, 1].notEqual(y[1, 1], epsilon[1])
        return res
    }

    /** Returns the component-wise comparison of |x - y| >= epsilon.
     *  True if this expression is satisfied. */
    fun notEqual(x: Mat3d, y: Mat3d, epsilon: Vec3d = Vec3d(0.0), res: Vec3bool = Vec3bool()): Vec3bool {
        res.x = x[0, 0].notEqual(y[0, 0], epsilon[0]) || x[0, 1].notEqual(y[0, 1], epsilon[0]) || x[0, 2].notEqual(y[0, 2], epsilon[0])
        res.y = x[1, 0].notEqual(y[1, 0], epsilon[1]) || x[1, 1].notEqual(y[1, 1], epsilon[1]) || x[1, 2].notEqual(y[1, 2], epsilon[1])
        res.z = x[2, 0].notEqual(y[2, 0], epsilon[2]) || x[2, 1].notEqual(y[2, 1], epsilon[2]) || x[2, 2].notEqual(y[2, 2], epsilon[2])
        return res
    }

    /** Returns the component-wise comparison of |x - y| >= epsilon.
     *  True if this expression is satisfied. */
    fun notEqual(x: Mat4d, y: Mat4d, epsilon: Vec4d = Vec4d(0.0), res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = x[0, 0].notEqual(y[0, 0], epsilon[0]) || x[0, 1].notEqual(y[0, 1], epsilon[0]) || x[0, 2].notEqual(y[0, 2], epsilon[0]) || x[0, 3].notEqual(y[0, 3], epsilon[0])
        res.y = x[1, 0].notEqual(y[1, 0], epsilon[1]) || x[1, 1].notEqual(y[1, 1], epsilon[1]) || x[1, 2].notEqual(y[1, 2], epsilon[1]) || x[1, 3].notEqual(y[1, 3], epsilon[1])
        res.z = x[2, 0].notEqual(y[2, 0], epsilon[2]) || x[2, 1].notEqual(y[2, 1], epsilon[2]) || x[2, 2].notEqual(y[2, 2], epsilon[2]) || x[2, 3].notEqual(y[2, 3], epsilon[2])
        res.w = x[3, 0].notEqual(y[3, 0], epsilon[3]) || x[3, 1].notEqual(y[3, 1], epsilon[3]) || x[3, 2].notEqual(y[3, 2], epsilon[3]) || x[3, 3].notEqual(y[3, 3], epsilon[3])
        return res
    }

    // convenient

    fun allEqual(x: Mat2, y: Mat2, epsilon: Float = 0f): Boolean =
            x[0, 0].equal(y[0, 0], epsilon) && x[0, 1].equal(y[0, 1], epsilon) &&
                    x[1, 0].equal(y[1, 0], epsilon) && x[1, 1].equal(y[1, 1], epsilon)

    fun allEqual(x: Mat3, y: Mat3, epsilon: Float = 0f): Boolean =
            x[0, 0].equal(y[0, 0], epsilon) && x[0, 1].equal(y[0, 1], epsilon) && x[0, 2].equal(y[0, 2], epsilon) &&
                    x[1, 0].equal(y[1, 0], epsilon) && x[1, 1].equal(y[1, 1], epsilon) && x[1, 2].equal(y[1, 2], epsilon) &&
                    x[2, 0].equal(y[2, 0], epsilon) && x[2, 1].equal(y[2, 1], epsilon) && x[2, 2].equal(y[2, 2], epsilon)

    fun allEqual(x: Mat4, y: Mat4, epsilon: Float = 0f): Boolean =
            x[0, 0].equal(y[0, 0], epsilon) && x[0, 1].equal(y[0, 1], epsilon) && x[0, 2].equal(y[0, 2], epsilon) && x[0, 3].equal(y[0, 3], epsilon) &&
                    x[1, 0].equal(y[1, 0], epsilon) && x[1, 1].equal(y[1, 1], epsilon) && x[1, 2].equal(y[1, 2], epsilon) && x[1, 3].equal(y[1, 3], epsilon) &&
                    x[2, 0].equal(y[2, 0], epsilon) && x[2, 1].equal(y[2, 1], epsilon) && x[2, 2].equal(y[2, 2], epsilon) && x[2, 3].equal(y[2, 3], epsilon) &&
                    x[3, 0].equal(y[3, 0], epsilon) && x[3, 1].equal(y[3, 1], epsilon) && x[3, 2].equal(y[3, 2], epsilon) && x[3, 3].equal(y[3, 3], epsilon)

    fun anyNotEqual(x: Mat2, y: Mat2, epsilon: Float = 0f): Boolean =
            x[0, 0].notEqual(y[0, 0], epsilon) || x[0, 1].notEqual(y[0, 1], epsilon) ||
                    x[1, 0].notEqual(y[1, 0], epsilon) || x[1, 1].notEqual(y[1, 1], epsilon)

    fun anyNotEqual(x: Mat3, y: Mat3, epsilon: Float = 0f): Boolean =
            x[0, 0].notEqual(y[0, 0], epsilon) || x[0, 1].notEqual(y[0, 1], epsilon) || x[0, 2].notEqual(y[0, 2], epsilon) ||
                    x[1, 0].notEqual(y[1, 0], epsilon) || x[1, 1].notEqual(y[1, 1], epsilon) || x[1, 2].notEqual(y[1, 2], epsilon) ||
                    x[2, 0].notEqual(y[2, 0], epsilon) || x[2, 1].notEqual(y[2, 1], epsilon) || x[2, 2].notEqual(y[2, 2], epsilon)

    fun anyNotEqual(x: Mat4, y: Mat4, epsilon: Float = 0f): Boolean =
            x[0, 0].notEqual(y[0, 0], epsilon) || x[0, 1].notEqual(y[0, 1], epsilon) || x[0, 2].notEqual(y[0, 2], epsilon) || x[0, 3].notEqual(y[0, 3], epsilon) ||
                    x[1, 0].notEqual(y[1, 0], epsilon) || x[1, 1].notEqual(y[1, 1], epsilon) || x[1, 2].notEqual(y[1, 2], epsilon) || x[1, 3].notEqual(y[1, 3], epsilon) ||
                    x[2, 0].notEqual(y[2, 0], epsilon) || x[2, 1].notEqual(y[2, 1], epsilon) || x[2, 2].notEqual(y[2, 2], epsilon) || x[2, 3].notEqual(y[2, 3], epsilon) ||
                    x[3, 0].notEqual(y[3, 0], epsilon) || x[3, 1].notEqual(y[3, 1], epsilon) || x[3, 2].notEqual(y[3, 2], epsilon) || x[3, 3].notEqual(y[3, 3], epsilon)

    // double

    fun allEqual(x: Mat2d, y: Mat2d, epsilon: Double = 0.0): Boolean =
            x[0, 0].equal(y[0, 0], epsilon) && x[0, 1].equal(y[0, 1], epsilon) &&
                    x[1, 0].equal(y[1, 0], epsilon) && x[1, 1].equal(y[1, 1], epsilon)

    fun allEqual(x: Mat3d, y: Mat3d, epsilon: Double = 0.0): Boolean =
            x[0, 0].equal(y[0, 0], epsilon) && x[0, 1].equal(y[0, 1], epsilon) && x[0, 2].equal(y[0, 2], epsilon) &&
                    x[1, 0].equal(y[1, 0], epsilon) && x[1, 1].equal(y[1, 1], epsilon) && x[1, 2].equal(y[1, 2], epsilon) &&
                    x[2, 0].equal(y[2, 0], epsilon) && x[2, 1].equal(y[2, 1], epsilon) && x[2, 2].equal(y[2, 2], epsilon)

    fun allEqual(x: Mat4d, y: Mat4d, epsilon: Double = 0.0): Boolean =
            x[0, 0].equal(y[0, 0], epsilon) && x[0, 1].equal(y[0, 1], epsilon) && x[0, 2].equal(y[0, 2], epsilon) && x[0, 3].equal(y[0, 3], epsilon) &&
                    x[1, 0].equal(y[1, 0], epsilon) && x[1, 1].equal(y[1, 1], epsilon) && x[1, 2].equal(y[1, 2], epsilon) && x[1, 3].equal(y[1, 3], epsilon) &&
                    x[2, 0].equal(y[2, 0], epsilon) && x[2, 1].equal(y[2, 1], epsilon) && x[2, 2].equal(y[2, 2], epsilon) && x[2, 3].equal(y[2, 3], epsilon) &&
                    x[3, 0].equal(y[3, 0], epsilon) && x[3, 1].equal(y[3, 1], epsilon) && x[3, 2].equal(y[3, 2], epsilon) && x[3, 3].equal(y[3, 3], epsilon)

    fun anyNotEqual(x: Mat2d, y: Mat2d, epsilon: Double = 0.0): Boolean =
            x[0, 0].notEqual(y[0, 0], epsilon) || x[0, 1].notEqual(y[0, 1], epsilon) ||
                    x[1, 0].notEqual(y[1, 0], epsilon) || x[1, 1].notEqual(y[1, 1], epsilon)

    fun anyNotEqual(x: Mat3d, y: Mat3d, epsilon: Double = 0.0): Boolean =
            x[0, 0].notEqual(y[0, 0], epsilon) || x[0, 1].notEqual(y[0, 1], epsilon) || x[0, 2].notEqual(y[0, 2], epsilon) ||
                    x[1, 0].notEqual(y[1, 0], epsilon) || x[1, 1].notEqual(y[1, 1], epsilon) || x[1, 2].notEqual(y[1, 2], epsilon) ||
                    x[2, 0].notEqual(y[2, 0], epsilon) || x[2, 1].notEqual(y[2, 1], epsilon) || x[2, 2].notEqual(y[2, 2], epsilon)

    fun anyNotEqual(x: Mat4d, y: Mat4d, epsilon: Double = 0.0): Boolean =
            x[0, 0].notEqual(y[0, 0], epsilon) || x[0, 1].notEqual(y[0, 1], epsilon) || x[0, 2].notEqual(y[0, 2], epsilon) || x[0, 3].notEqual(y[0, 3], epsilon) ||
                    x[1, 0].notEqual(y[1, 0], epsilon) || x[1, 1].notEqual(y[1, 1], epsilon) || x[1, 2].notEqual(y[1, 2], epsilon) || x[1, 3].notEqual(y[1, 3], epsilon) ||
                    x[2, 0].notEqual(y[2, 0], epsilon) || x[2, 1].notEqual(y[2, 1], epsilon) || x[2, 2].notEqual(y[2, 2], epsilon) || x[2, 3].notEqual(y[2, 3], epsilon) ||
                    x[3, 0].notEqual(y[3, 0], epsilon) || x[3, 1].notEqual(y[3, 1], epsilon) || x[3, 2].notEqual(y[3, 2], epsilon) || x[3, 3].notEqual(y[3, 3], epsilon)
}