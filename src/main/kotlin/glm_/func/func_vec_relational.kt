package glm_.func

import glm_.b
import glm_.s
import glm_.vec1.*
import glm_.vec2.*
import glm_.vec3.*
import glm_.vec4.*

/**
 * Created by GBarbieri on 08.11.2016.
 */


interface func_vector1_relational {

    fun lessThan(a: Vec1b, b: Vec1b, res: Vec1bool = Vec1bool()): Vec1bool {
        res.x = a.x < b.x
        return res
    }

    fun lessThanEqual(a: Vec1b, b: Vec1b, res: Vec1bool = Vec1bool()): Vec1bool {
        res.x = a.x <= b.x
        return res
    }

    fun greaterThan(a: Vec1b, b: Vec1b, res: Vec1bool = Vec1bool()): Vec1bool {
        res.x = a.x > b.x
        return res
    }

    fun greaterThanEqual(a: Vec1b, b: Vec1b, res: Vec1bool = Vec1bool()): Vec1bool {
        res.x = a.x >= b.x
        return res
    }

    fun equal(a: Vec1b, b: Vec1b, res: Vec1bool = Vec1bool()): Vec1bool {
        res.x = a.x == b.x
        return res
    }

    fun notEqual(a: Vec1b, b: Vec1b, res: Vec1bool = Vec1bool()): Vec1bool {
        res.x = a.x != b.x
        return res
    }

    fun isEqual(a: Vec1b, b: Vec1b): Boolean = a.x == b.x

    fun any(a: Vec1b): Boolean = a[0] != 0.b

    fun all(a: Vec1b): Boolean = a[0] != 0.b

    fun not(a: Vec1b, res: Vec1b = Vec1b()): Vec1b {
        res[0] = if(a[0] == 0.b) 1 else 0
        return res
    }
    
    
    fun lessThan(a: Vec1s, b: Vec1s, res: Vec1bool = Vec1bool()): Vec1bool {
        res.x = a.x < b.x
        return res
    }

    fun lessThanEqual(a: Vec1s, b: Vec1s, res: Vec1bool = Vec1bool()): Vec1bool {
        res.x = a.x <= b.x
        return res
    }

    fun greaterThan(a: Vec1s, b: Vec1s, res: Vec1bool = Vec1bool()): Vec1bool {
        res.x = a.x > b.x
        return res
    }

    fun greaterThanEqual(a: Vec1s, b: Vec1s, res: Vec1bool = Vec1bool()): Vec1bool {
        res.x = a.x >= b.x
        return res
    }

    fun equal(a: Vec1s, b: Vec1s, res: Vec1bool = Vec1bool()): Vec1bool {
        res.x = a.x == b.x
        return res
    }

    fun notEqual(a: Vec1s, b: Vec1s, res: Vec1bool = Vec1bool()): Vec1bool {
        res.x = a.x != b.x
        return res
    }
    
    fun isEqual(a: Vec1s, b: Vec1s): Boolean = a.x == b.x

    fun any(a: Vec1s): Boolean = a[0] != 0.s

    fun all(a: Vec1s): Boolean = a[0] != 0.s

//    fun not(a: Vec1s, res: Vec1s = Vec1s()): Vec1s {
//        res[0] = if(a[0] == 0.s) 1 else 0
//        return res
//    }
    
    
    fun lessThan(a: Vec1i, b: Vec1i, res: Vec1bool = Vec1bool()): Vec1bool {
        res.x = a.x < b.x
        return res
    }

    fun lessThanEqual(a: Vec1i, b: Vec1i, res: Vec1bool = Vec1bool()): Vec1bool {
        res.x = a.x <= b.x
        return res
    }

    fun greaterThan(a: Vec1i, b: Vec1i, res: Vec1bool = Vec1bool()): Vec1bool {
        res.x = a.x > b.x
        return res
    }

    fun greaterThanEqual(a: Vec1i, b: Vec1i, res: Vec1bool = Vec1bool()): Vec1bool {
        res.x = a.x >= b.x
        return res
    }

    fun equal(a: Vec1i, b: Vec1i, res: Vec1bool = Vec1bool()): Vec1bool {
        res.x = a.x == b.x
        return res
    }

    fun notEqual(a: Vec1i, b: Vec1i, res: Vec1bool = Vec1bool()): Vec1bool {
        res.x = a.x != b.x
        return res
    }

    fun isEqual(a: Vec1i, b: Vec1i): Boolean = a.x == b.x

    fun any(a: Vec1i): Boolean = a[0] != 0

    fun all(a: Vec1i): Boolean = a[0] != 0

    fun not(a: Vec1i, res: Vec1i = Vec1i()): Vec1i {
        res[0] = if(a[0] == 0) 1 else 0
        return res
    }
    
    
//    fun lessThan(a: Vec1l, b: Vec1l, res: Vec1bool = Vec1bool()): Vec1bool {
//        res.x = a.x < b.x
//        return res
//    }
//
//    fun lessThanEqual(a: Vec1l, b: Vec1l, res: Vec1bool = Vec1bool()): Vec1bool {
//        res.x = a.x <= b.x
//        return res
//    }
//
//    fun greaterThan(a: Vec1l, b: Vec1l, res: Vec1bool = Vec1bool()): Vec1bool {
//        res.x = a.x > b.x
//        return res
//    }
//
//    fun greaterThanEqual(a: Vec1l, b: Vec1l, res: Vec1bool = Vec1bool()): Vec1bool {
//        res.x = a.x >= b.x
//        return res
//    }
//
//    fun equal(a: Vec1l, b: Vec1l, res: Vec1bool = Vec1bool()): Vec1bool {
//        res.x = a.x == b.x
//        return res
//    }
//
//    fun notEqual(a: Vec1l, b: Vec1l, res: Vec1bool = Vec1bool()): Vec1bool {
//        res.x = a.x != b.x
//        return res
//    }
//
//    fun isEqual(a: Vec1l, b: Vec1l): Boolean = a.x == b.x
//
//    fun any(a: Vec1l): Boolean = a[0] != 0L
//
//    fun all(a: Vec1l): Boolean = a[0] != 0L
//
//    fun not(a: Vec1l, res: Vec1l = Vec1l()): Vec1l {
//        res[0] = if(a[0] == 0L) 1 else 0
//        return res
//    }
    
    
    fun lessThan(a: Vec1, b: Vec1, res: Vec1bool = Vec1bool()): Vec1bool {
        res.x = a.x < b.x
        return res
    }

    fun lessThanEqual(a: Vec1, b: Vec1, res: Vec1bool = Vec1bool()): Vec1bool {
        res.x = a.x <= b.x
        return res
    }

    fun greaterThan(a: Vec1, b: Vec1, res: Vec1bool = Vec1bool()): Vec1bool {
        res.x = a.x > b.x
        return res
    }

    fun greaterThanEqual(a: Vec1, b: Vec1, res: Vec1bool = Vec1bool()): Vec1bool {
        res.x = a.x >= b.x
        return res
    }

    fun equal(a: Vec1, b: Vec1, res: Vec1bool = Vec1bool()): Vec1bool {
        res.x = a.x.equals(b.x) // TODO https://youtrack.jetbrains.com/issue/KT-48648
        return res
    }

    fun notEqual(a: Vec1, b: Vec1, res: Vec1bool = Vec1bool()): Vec1bool {
        res.x = !a.x.equals(b.x) // TODO https://youtrack.jetbrains.com/issue/KT-48648
        return res
    }

    fun isEqual(a: Vec1, b: Vec1): Boolean = a.x.equals(b.x) // TODO https://youtrack.jetbrains.com/issue/KT-48648

    fun any(a: Vec1): Boolean = a[0] != 0f

    fun all(a: Vec1): Boolean = a[0] != 0f

//    fun not(a: Vec1, res: Vec1 = Vec1()): Vec1 {
//        res[0] = if(a[0] == 0f) 1 else 0
//        return res
//    }
    
    
    fun lessThan(a: Vec1d, b: Vec1d, res: Vec1bool = Vec1bool()): Vec1bool {
        res.x = a.x < b.x
        return res
    }

    fun lessThanEqual(a: Vec1d, b: Vec1d, res: Vec1bool = Vec1bool()): Vec1bool {
        res.x = a.x <= b.x
        return res
    }

    fun greaterThan(a: Vec1d, b: Vec1d, res: Vec1bool = Vec1bool()): Vec1bool {
        res.x = a.x > b.x
        return res
    }

    fun greaterThanEqual(a: Vec1d, b: Vec1d, res: Vec1bool = Vec1bool()): Vec1bool {
        res.x = a.x >= b.x
        return res
    }

    fun equal(a: Vec1d, b: Vec1d, res: Vec1bool = Vec1bool()): Vec1bool {
        res.x = a.x.equals(b.x)// TODO https://youtrack.jetbrains.com/issue/KT-48648
        return res
    }

    fun notEqual(a: Vec1d, b: Vec1d, res: Vec1bool = Vec1bool()): Vec1bool {
        res.x = !a.x.equals(b.x)// TODO https://youtrack.jetbrains.com/issue/KT-48648
        return res
    }

    fun isEqual(a: Vec1d, b: Vec1d): Boolean = a.x.equals(b.x)// TODO https://youtrack.jetbrains.com/issue/KT-48648

    fun any(a: Vec1d): Boolean = a[0] != 0.0

    fun all(a: Vec1d): Boolean = a[0] != 0.0

//    fun not(a: Vec1d, res: Vec1d = Vec1d()): Vec1d {
//        res[0] = if(a[0] == 0.0) 1 else 0
//        return res
//    }


    fun isEqual(a: Vec1bool, b: Vec1bool): Boolean = a.x == b.x

    fun any(a: Vec1bool): Boolean = a[0]

    fun all(a: Vec1bool): Boolean = a[0]

    fun not(a: Vec1bool, res: Vec1bool = Vec1bool()): Vec1bool {
        res[0] = !a[0]
        return res
    }

    // TODO utypes?
}

interface func_vector2_relational {

    fun lessThan(a: Vec2b, b: Vec2b, res: Vec2bool = Vec2bool()): Vec2bool {
        res.x = a.x < b.x
        res.y = a.y < b.y
        return res
    }

    fun lessThanEqual(a: Vec2b, b: Vec2b, res: Vec2bool = Vec2bool()): Vec2bool {
        res.x = a.x <= b.x
        res.y = a.y <= b.y
        return res
    }

    fun greaterThan(a: Vec2b, b: Vec2b, res: Vec2bool = Vec2bool()): Vec2bool {
        res.x = a.x > b.x
        res.y = a.y > b.y
        return res
    }

    fun greaterThanEqual(a: Vec2b, b: Vec2b, res: Vec2bool = Vec2bool()): Vec2bool {
        res.x = a.x >= b.x
        res.y = a.y >= b.y
        return res
    }

    fun equal(a: Vec2b, b: Vec2b, res: Vec2bool = Vec2bool()): Vec2bool {
        res.x = a.x == b.x
        res.y = a.y == b.y
        return res
    }

    fun notEqual(a: Vec2b, b: Vec2b, res: Vec2bool = Vec2bool()): Vec2bool {
        res.x = a.x != b.x
        res.y = a.y != b.y
        return res
    }

    fun isEqual(a: Vec2b, b: Vec2b): Boolean = a.x == b.x && a.y == b.y

    fun any(a: Vec2b): Boolean = a[0] != 0.b || a[1] != 0.b

    fun all(a: Vec2b): Boolean = a[0] != 0.b && a[1] != 0.b

    fun not(a: Vec2b, res: Vec2b = Vec2b()): Vec2b {
        res[0] = if(a[0] == 0.b) 1 else 0
        res[1] = if(a[1] == 0.b) 1 else 0
        return res
    }
    
    
    fun lessThan(a: Vec2s, b: Vec2s, res: Vec2bool = Vec2bool()): Vec2bool {
        res.x = a.x < b.x
        res.y = a.y < b.y
        return res
    }

    fun lessThanEqual(a: Vec2s, b: Vec2s, res: Vec2bool = Vec2bool()): Vec2bool {
        res.x = a.x <= b.x
        res.y = a.y <= b.y
        return res
    }

    fun greaterThan(a: Vec2s, b: Vec2s, res: Vec2bool = Vec2bool()): Vec2bool {
        res.x = a.x > b.x
        res.y = a.y > b.y
        return res
    }

    fun greaterThanEqual(a: Vec2s, b: Vec2s, res: Vec2bool = Vec2bool()): Vec2bool {
        res.x = a.x >= b.x
        res.y = a.y >= b.y
        return res
    }

    fun equal(a: Vec2s, b: Vec2s, res: Vec2bool = Vec2bool()): Vec2bool {
        res.x = a.x == b.x
        res.y = a.y == b.y
        return res
    }

    fun notEqual(a: Vec2s, b: Vec2s, res: Vec2bool = Vec2bool()): Vec2bool {
        res.x = a.x != b.x
        res.y = a.y != b.y
        return res
    }
    
    fun isEqual(a: Vec2s, b: Vec2s): Boolean = a.x == b.x && a.y == b.y

    fun any(a: Vec2s): Boolean = a[0] != 0.s || a[1] != 0.s

    fun all(a: Vec2s): Boolean = a[0] != 0.s && a[1] != 0.s

    fun not(a: Vec2s, res: Vec2s = Vec2s()): Vec2s {
        res[0] = if(a[0] == 0.s) 1 else 0
        res[1] = if(a[1] == 0.s) 1 else 0
        return res
    }
    
    
    fun lessThan(a: Vec2i, b: Vec2i, res: Vec2bool = Vec2bool()): Vec2bool {
        res.x = a.x < b.x
        res.y = a.y < b.y
        return res
    }

    fun lessThanEqual(a: Vec2i, b: Vec2i, res: Vec2bool = Vec2bool()): Vec2bool {
        res.x = a.x <= b.x
        res.y = a.y <= b.y
        return res
    }

    fun greaterThan(a: Vec2i, b: Vec2i, res: Vec2bool = Vec2bool()): Vec2bool {
        res.x = a.x > b.x
        res.y = a.y > b.y
        return res
    }

    fun greaterThanEqual(a: Vec2i, b: Vec2i, res: Vec2bool = Vec2bool()): Vec2bool {
        res.x = a.x >= b.x
        res.y = a.y >= b.y
        return res
    }

    fun equal(a: Vec2i, b: Vec2i, res: Vec2bool = Vec2bool()): Vec2bool {
        res.x = a.x == b.x
        res.y = a.y == b.y
        return res
    }

    fun notEqual(a: Vec2i, b: Vec2i, res: Vec2bool = Vec2bool()): Vec2bool {
        res.x = a.x != b.x
        res.y = a.y != b.y
        return res
    }

    fun isEqual(a: Vec2i, b: Vec2i): Boolean = a.x == b.x && a.y == b.y

    fun any(a: Vec2i): Boolean = a[0] != 0 || a[1] != 0

    fun all(a: Vec2i): Boolean = a[0] != 0 && a[1] != 0

    fun not(a: Vec2i, res: Vec2i = Vec2i()): Vec2i {
        res[0] = if(a[0] == 0) 1 else 0
        res[1] = if(a[1] == 0) 1 else 0
        return res
    }
    
    
    fun lessThan(a: Vec2l, b: Vec2l, res: Vec2bool = Vec2bool()): Vec2bool {
        res.x = a.x < b.x
        res.y = a.y < b.y
        return res
    }

    fun lessThanEqual(a: Vec2l, b: Vec2l, res: Vec2bool = Vec2bool()): Vec2bool {
        res.x = a.x <= b.x
        res.y = a.y <= b.y
        return res
    }

    fun greaterThan(a: Vec2l, b: Vec2l, res: Vec2bool = Vec2bool()): Vec2bool {
        res.x = a.x > b.x
        res.y = a.y > b.y
        return res
    }

    fun greaterThanEqual(a: Vec2l, b: Vec2l, res: Vec2bool = Vec2bool()): Vec2bool {
        res.x = a.x >= b.x
        res.y = a.y >= b.y
        return res
    }

    fun equal(a: Vec2l, b: Vec2l, res: Vec2bool = Vec2bool()): Vec2bool {
        res.x = a.x == b.x
        res.y = a.y == b.y
        return res
    }

    fun notEqual(a: Vec2l, b: Vec2l, res: Vec2bool = Vec2bool()): Vec2bool {
        res.x = a.x != b.x
        res.y = a.y != b.y
        return res
    }

    fun isEqual(a: Vec2l, b: Vec2l): Boolean = a.x == b.x && a.y == b.y

    fun any(a: Vec2l): Boolean = a[0] != 0L || a[1] != 0L

    fun all(a: Vec2l): Boolean = a[0] != 0L && a[1] != 0L

    fun not(a: Vec2l, res: Vec2l = Vec2l()): Vec2l {
        res[0] = if(a[0] == 0L) 1 else 0
        res[1] = if(a[1] == 0L) 1 else 0
        return res
    }
    
    
    fun lessThan(a: Vec2, b: Vec2, res: Vec2bool = Vec2bool()): Vec2bool {
        res.x = a.x < b.x
        res.y = a.y < b.y
        return res
    }

    fun lessThanEqual(a: Vec2, b: Vec2, res: Vec2bool = Vec2bool()): Vec2bool {
        res.x = a.x <= b.x
        res.y = a.y <= b.y
        return res
    }

    fun greaterThan(a: Vec2, b: Vec2, res: Vec2bool = Vec2bool()): Vec2bool {
        res.x = a.x > b.x
        res.y = a.y > b.y
        return res
    }

    fun greaterThanEqual(a: Vec2, b: Vec2, res: Vec2bool = Vec2bool()): Vec2bool {
        res.x = a.x >= b.x
        res.y = a.y >= b.y
        return res
    }

    fun equal(a: Vec2, b: Vec2, res: Vec2bool = Vec2bool()): Vec2bool {
        res.x = a.x == b.x
        res.y = a.y == b.y
        return res
    }

    fun notEqual(a: Vec2, b: Vec2, res: Vec2bool = Vec2bool()): Vec2bool {
        res.x = a.x != b.x
        res.y = a.y != b.y
        return res
    }

    fun isEqual(a: Vec2, b: Vec2): Boolean = a.x == b.x && a.y == b.y

    fun any(a: Vec2): Boolean = a[0] != 0f || a[1] != 0f

    fun all(a: Vec2): Boolean = a[0] != 0f && a[1] != 0f

    fun not(a: Vec2, res: Vec2 = Vec2()): Vec2 {
        res[0] = if(a[0] == 0f) 1 else 0
        res[1] = if(a[1] == 0f) 1 else 0
        return res
    }
    
    
    fun lessThan(a: Vec2d, b: Vec2d, res: Vec2bool = Vec2bool()): Vec2bool {
        res.x = a.x < b.x
        res.y = a.y < b.y
        return res
    }

    fun lessThanEqual(a: Vec2d, b: Vec2d, res: Vec2bool = Vec2bool()): Vec2bool {
        res.x = a.x <= b.x
        res.y = a.y <= b.y
        return res
    }

    fun greaterThan(a: Vec2d, b: Vec2d, res: Vec2bool = Vec2bool()): Vec2bool {
        res.x = a.x > b.x
        res.y = a.y > b.y
        return res
    }

    fun greaterThanEqual(a: Vec2d, b: Vec2d, res: Vec2bool = Vec2bool()): Vec2bool {
        res.x = a.x >= b.x
        res.y = a.y >= b.y
        return res
    }

    fun equal(a: Vec2d, b: Vec2d, res: Vec2bool = Vec2bool()): Vec2bool {
        res.x = a.x == b.x
        res.y = a.y == b.y
        return res
    }

    fun notEqual(a: Vec2d, b: Vec2d, res: Vec2bool = Vec2bool()): Vec2bool {
        res.x = a.x != b.x
        res.y = a.y != b.y
        return res
    }

    fun isEqual(a: Vec2d, b: Vec2d): Boolean = a.x == b.x && a.y == b.y

    fun any(a: Vec2d): Boolean = a[0] != 0.0 || a[1] != 0.0

    fun all(a: Vec2d): Boolean = a[0] != 0.0 && a[1] != 0.0

    fun not(a: Vec2d, res: Vec2d = Vec2d()): Vec2d {
        res[0] = if(a[0] == 0.0) 1 else 0
        res[1] = if(a[1] == 0.0) 1 else 0
        return res
    }


    fun isEqual(a: Vec2bool, b: Vec2bool): Boolean = a.x == b.x && a.y == b.y

    fun any(a: Vec2bool): Boolean = a[0] || a[1]

    fun all(a: Vec2bool): Boolean = a[0] && a[1]

    fun not(a: Vec2bool, res: Vec2bool = Vec2bool()): Vec2bool {
        res[0] = !a[0]
        res[1] = !a[1]
        return res
    }

    // TODO utypes?
}

interface func_vector3_relational {

    fun lessThan(a: Vec3b, b: Vec3b, res: Vec3bool = Vec3bool()): Vec3bool {
        res.x = a.x < b.x
        res.y = a.y < b.y
        res.z = a.z < b.z
        return res
    }

    fun lessThanEqual(a: Vec3b, b: Vec3b, res: Vec3bool = Vec3bool()): Vec3bool {
        res.x = a.x <= b.x
        res.y = a.y <= b.y
        res.z = a.z <= b.z
        return res
    }

    fun greaterThan(a: Vec3b, b: Vec3b, res: Vec3bool = Vec3bool()): Vec3bool {
        res.x = a.x > b.x
        res.y = a.y > b.y
        res.z = a.z > b.z
        return res
    }

    fun greaterThanEqual(a: Vec3b, b: Vec3b, res: Vec3bool = Vec3bool()): Vec3bool {
        res.x = a.x >= b.x
        res.y = a.y >= b.y
        res.z = a.z >= b.z
        return res
    }

    fun equal(a: Vec3b, b: Vec3b, res: Vec3bool = Vec3bool()): Vec3bool {
        res.x = a.x == b.x
        res.y = a.y == b.y
        res.z = a.z == b.z
        return res
    }

    fun notEqual(a: Vec3b, b: Vec3b, res: Vec3bool = Vec3bool()): Vec3bool {
        res.x = a.x != b.x
        res.y = a.y != b.y
        res.z = a.z != b.z
        return res
    }

    fun isEqual(a: Vec3b, b: Vec3b): Boolean = a.x == b.x && a.y == b.y && a.z == b.z

    fun any(a: Vec3b): Boolean = a[0] != 0.b || a[1] != 0.b || a[2] != 0.b

    fun all(a: Vec3b): Boolean = a[0] != 0.b && a[1] != 0.b && a[2] != 0.b

    fun not(a: Vec3b, res: Vec3b = Vec3b()): Vec3b {
        res[0] = if(a[0] == 0.b) 1 else 0
        res[1] = if(a[1] == 0.b) 1 else 0
        res[2] = if(a[2] == 0.b) 1 else 0
        return res
    }
    
    
    fun lessThan(a: Vec3s, b: Vec3s, res: Vec3bool = Vec3bool()): Vec3bool {
        res.x = a.x < b.x
        res.y = a.y < b.y
        res.z = a.z < b.z
        return res
    }

    fun lessThanEqual(a: Vec3s, b: Vec3s, res: Vec3bool = Vec3bool()): Vec3bool {
        res.x = a.x <= b.x
        res.y = a.y <= b.y
        res.z = a.z <= b.z
        return res
    }

    fun greaterThan(a: Vec3s, b: Vec3s, res: Vec3bool = Vec3bool()): Vec3bool {
        res.x = a.x > b.x
        res.y = a.y > b.y
        res.z = a.z > b.z
        return res
    }

    fun greaterThanEqual(a: Vec3s, b: Vec3s, res: Vec3bool = Vec3bool()): Vec3bool {
        res.x = a.x >= b.x
        res.y = a.y >= b.y
        res.z = a.z >= b.z
        return res
    }

    fun equal(a: Vec3s, b: Vec3s, res: Vec3bool = Vec3bool()): Vec3bool {
        res.x = a.x == b.x
        res.y = a.y == b.y
        res.z = a.z == b.z
        return res
    }

    fun notEqual(a: Vec3s, b: Vec3s, res: Vec3bool = Vec3bool()): Vec3bool {
        res.x = a.x != b.x
        res.y = a.y != b.y
        res.z = a.z != b.z
        return res
    }
    
    fun isEqual(a: Vec3s, b: Vec3s): Boolean = a.x == b.x && a.y == b.y && a.z == b.z

    fun any(a: Vec3s): Boolean = a[0] != 0.s || a[1] != 0.s || a[2] != 0.s

    fun all(a: Vec3s): Boolean = a[0] != 0.s && a[1] != 0.s && a[2] != 0.s

    fun not(a: Vec3s, res: Vec3s = Vec3s()): Vec3s {
        res[0] = if(a[0] == 0.s) 1 else 0
        res[1] = if(a[1] == 0.s) 1 else 0
        res[2] = if(a[2] == 0.s) 1 else 0
        return res
    }
    
    
    fun lessThan(a: Vec3i, b: Vec3i, res: Vec3bool = Vec3bool()): Vec3bool {
        res.x = a.x < b.x
        res.y = a.y < b.y
        res.z = a.z < b.z
        return res
    }

    fun lessThanEqual(a: Vec3i, b: Vec3i, res: Vec3bool = Vec3bool()): Vec3bool {
        res.x = a.x <= b.x
        res.y = a.y <= b.y
        res.z = a.z <= b.z
        return res
    }

    fun greaterThan(a: Vec3i, b: Vec3i, res: Vec3bool = Vec3bool()): Vec3bool {
        res.x = a.x > b.x
        res.y = a.y > b.y
        res.z = a.z > b.z
        return res
    }

    fun greaterThanEqual(a: Vec3i, b: Vec3i, res: Vec3bool = Vec3bool()): Vec3bool {
        res.x = a.x >= b.x
        res.y = a.y >= b.y
        res.z = a.z >= b.z
        return res
    }

    fun equal(a: Vec3i, b: Vec3i, res: Vec3bool = Vec3bool()): Vec3bool {
        res.x = a.x == b.x
        res.y = a.y == b.y
        res.z = a.z == b.z
        return res
    }

    fun notEqual(a: Vec3i, b: Vec3i, res: Vec3bool = Vec3bool()): Vec3bool {
        res.x = a.x != b.x
        res.y = a.y != b.y
        res.z = a.z != b.z
        return res
    }

    fun isEqual(a: Vec3i, b: Vec3i): Boolean = a.x == b.x && a.y == b.y && a.z == b.z

    fun any(a: Vec3i): Boolean = a[0] != 0 || a[1] != 0 || a[2] != 0

    fun all(a: Vec3i): Boolean = a[0] != 0 && a[1] != 0 && a[2] != 0

    fun not(a: Vec3i, res: Vec3i = Vec3i()): Vec3i {
        res[0] = if(a[0] == 0) 1 else 0
        res[1] = if(a[1] == 0) 1 else 0
        res[2] = if(a[2] == 0) 1 else 0
        return res
    }
    
    
    fun lessThan(a: Vec3l, b: Vec3l, res: Vec3bool = Vec3bool()): Vec3bool {
        res.x = a.x < b.x
        res.y = a.y < b.y
        res.z = a.z < b.z
        return res
    }

    fun lessThanEqual(a: Vec3l, b: Vec3l, res: Vec3bool = Vec3bool()): Vec3bool {
        res.x = a.x <= b.x
        res.y = a.y <= b.y
        res.z = a.z <= b.z
        return res
    }

    fun greaterThan(a: Vec3l, b: Vec3l, res: Vec3bool = Vec3bool()): Vec3bool {
        res.x = a.x > b.x
        res.y = a.y > b.y
        res.z = a.z > b.z
        return res
    }

    fun greaterThanEqual(a: Vec3l, b: Vec3l, res: Vec3bool = Vec3bool()): Vec3bool {
        res.x = a.x >= b.x
        res.y = a.y >= b.y
        res.z = a.z >= b.z
        return res
    }

    fun equal(a: Vec3l, b: Vec3l, res: Vec3bool = Vec3bool()): Vec3bool {
        res.x = a.x == b.x
        res.y = a.y == b.y
        res.z = a.z == b.z
        return res
    }

    fun notEqual(a: Vec3l, b: Vec3l, res: Vec3bool = Vec3bool()): Vec3bool {
        res.x = a.x != b.x
        res.y = a.y != b.y
        res.z = a.z != b.z
        return res
    }

    fun isEqual(a: Vec3l, b: Vec3l): Boolean = a.x == b.x && a.y == b.y && a.z == b.z

    fun any(a: Vec3l): Boolean = a[0] != 0L || a[1] != 0L || a[2] != 0L

    fun all(a: Vec3l): Boolean = a[0] != 0L && a[1] != 0L && a[2] != 0L

    fun not(a: Vec3l, res: Vec3l = Vec3l()): Vec3l {
        res[0] = if(a[0] == 0L) 1 else 0
        res[1] = if(a[1] == 0L) 1 else 0
        res[2] = if(a[2] == 0L) 1 else 0
        return res
    }
    
    
    fun lessThan(a: Vec3, b: Vec3, res: Vec3bool = Vec3bool()): Vec3bool {
        res.x = a.x < b.x
        res.y = a.y < b.y
        res.z = a.z < b.z
        return res
    }

    fun lessThanEqual(a: Vec3, b: Vec3, res: Vec3bool = Vec3bool()): Vec3bool {
        res.x = a.x <= b.x
        res.y = a.y <= b.y
        res.z = a.z <= b.z
        return res
    }

    fun greaterThan(a: Vec3, b: Vec3, res: Vec3bool = Vec3bool()): Vec3bool {
        res.x = a.x > b.x
        res.y = a.y > b.y
        res.z = a.z > b.z
        return res
    }

    fun greaterThanEqual(a: Vec3, b: Vec3, res: Vec3bool = Vec3bool()): Vec3bool {
        res.x = a.x >= b.x
        res.y = a.y >= b.y
        res.z = a.z >= b.z
        return res
    }

    fun equal(a: Vec3, b: Vec3, res: Vec3bool = Vec3bool()): Vec3bool {
        res.x = a.x == b.x
        res.y = a.y == b.y
        res.z = a.z == b.z
        return res
    }

    fun notEqual(a: Vec3, b: Vec3, res: Vec3bool = Vec3bool()): Vec3bool {
        res.x = a.x != b.x
        res.y = a.y != b.y
        res.z = a.z != b.z
        return res
    }

    fun isEqual(a: Vec3, b: Vec3): Boolean = a.x == b.x && a.y == b.y && a.z == b.z

    fun any(a: Vec3): Boolean = a[0] != 0f || a[1] != 0f || a[2] != 0f

    fun all(a: Vec3): Boolean = a[0] != 0f && a[1] != 0f && a[2] != 0f

    fun not(a: Vec3, res: Vec3 = Vec3()): Vec3 {
        res[0] = if(a[0] == 0f) 1 else 0
        res[1] = if(a[1] == 0f) 1 else 0
        res[2] = if(a[2] == 0f) 1 else 0
        return res
    }
    
    
    fun lessThan(a: Vec3d, b: Vec3d, res: Vec3bool = Vec3bool()): Vec3bool {
        res.x = a.x < b.x
        res.y = a.y < b.y
        res.z = a.z < b.z
        return res
    }

    fun lessThanEqual(a: Vec3d, b: Vec3d, res: Vec3bool = Vec3bool()): Vec3bool {
        res.x = a.x <= b.x
        res.y = a.y <= b.y
        res.z = a.z <= b.z
        return res
    }

    fun greaterThan(a: Vec3d, b: Vec3d, res: Vec3bool = Vec3bool()): Vec3bool {
        res.x = a.x > b.x
        res.y = a.y > b.y
        res.z = a.z > b.z
        return res
    }

    fun greaterThanEqual(a: Vec3d, b: Vec3d, res: Vec3bool = Vec3bool()): Vec3bool {
        res.x = a.x >= b.x
        res.y = a.y >= b.y
        res.z = a.z >= b.z
        return res
    }

    fun equal(a: Vec3d, b: Vec3d, res: Vec3bool = Vec3bool()): Vec3bool {
        res.x = a.x == b.x
        res.y = a.y == b.y
        res.z = a.z == b.z
        return res
    }

    fun notEqual(a: Vec3d, b: Vec3d, res: Vec3bool = Vec3bool()): Vec3bool {
        res.x = a.x != b.x
        res.y = a.y != b.y
        res.z = a.z != b.z
        return res
    }

    fun isEqual(a: Vec3d, b: Vec3d): Boolean = a.x == b.x && a.y == b.y && a.z == b.z

    fun any(a: Vec3d): Boolean = a[0] != 0.0 || a[1] != 0.0 || a[2] != 0.0

    fun all(a: Vec3d): Boolean = a[0] != 0.0 && a[1] != 0.0 && a[2] != 0.0

    fun not(a: Vec3d, res: Vec3d = Vec3d()): Vec3d {
        res[0] = if(a[0] == 0.0) 1 else 0
        res[1] = if(a[1] == 0.0) 1 else 0
        res[2] = if(a[2] == 0.0) 1 else 0
        return res
    }


    fun isEqual(a: Vec3bool, b: Vec3bool): Boolean = a.x == b.x && a.y == b.y && a.z == b.z

    fun any(a: Vec3bool): Boolean = a[0] || a[1] || a[2]

    fun all(a: Vec3bool): Boolean = a[0] && a[1] && a[2]

    fun not(a: Vec3bool, res: Vec3bool = Vec3bool()): Vec3bool {
        res[0] = !a[0]
        res[1] = !a[1]
        res[2] = !a[2]
        return res
    }

    // TODO utypes?
}

interface func_vector4_relational {

    fun lessThan(a: Vec4b, b: Vec4b, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = a.x < b.x
        res.y = a.y < b.y
        res.z = a.z < b.z
        res.w = a.w < b.w
        return res
    }

    fun lessThanEqual(a: Vec4b, b: Vec4b, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = a.x <= b.x
        res.y = a.y <= b.y
        res.z = a.z <= b.z
        res.w = a.w <= b.w
        return res
    }

    fun greaterThan(a: Vec4b, b: Vec4b, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = a.x > b.x
        res.y = a.y > b.y
        res.z = a.z > b.z
        res.w = a.w > b.w
        return res
    }

    fun greaterThanEqual(a: Vec4b, b: Vec4b, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = a.x >= b.x
        res.y = a.y >= b.y
        res.z = a.z >= b.z
        res.w = a.w >= b.w
        return res
    }

    fun equal(a: Vec4b, b: Vec4b, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = a.x == b.x
        res.y = a.y == b.y
        res.z = a.z == b.z
        res.w = a.w == b.w
        return res
    }

    fun notEqual(a: Vec4b, b: Vec4b, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = a.x != b.x
        res.y = a.y != b.y
        res.z = a.z != b.z
        res.w = a.w != b.w
        return res
    }

    fun isEqual(a: Vec4b, b: Vec4b): Boolean = a.x == b.x && a.y == b.y && a.z == b.z && a.w == b.w

    fun any(a: Vec4b): Boolean = a[0] != 0.b || a[1] != 0.b || a[2] != 0.b || a[3] != 0.b

    fun all(a: Vec4b): Boolean = a[0] != 0.b && a[1] != 0.b && a[2] != 0.b && a[3] != 0.b

    fun not(a: Vec4b, res: Vec4b = Vec4b()): Vec4b {
        res[0] = if(a[0] == 0.b) 1 else 0
        res[1] = if(a[1] == 0.b) 1 else 0
        res[2] = if(a[2] == 0.b) 1 else 0
        res[3] = if(a[3] == 0.b) 1 else 0
        return res
    }
    
    
    fun lessThan(a: Vec4s, b: Vec4s, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = a.x < b.x
        res.y = a.y < b.y
        res.z = a.z < b.z
        res.w = a.w < b.w
        return res
    }

    fun lessThanEqual(a: Vec4s, b: Vec4s, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = a.x <= b.x
        res.y = a.y <= b.y
        res.z = a.z <= b.z
        res.w = a.w <= b.w
        return res
    }

    fun greaterThan(a: Vec4s, b: Vec4s, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = a.x > b.x
        res.y = a.y > b.y
        res.z = a.z > b.z
        res.w = a.w > b.w
        return res
    }

    fun greaterThanEqual(a: Vec4s, b: Vec4s, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = a.x >= b.x
        res.y = a.y >= b.y
        res.z = a.z >= b.z
        res.w = a.w >= b.w
        return res
    }

    fun equal(a: Vec4s, b: Vec4s, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = a.x == b.x
        res.y = a.y == b.y
        res.z = a.z == b.z
        res.w = a.w == b.w
        return res
    }

    fun notEqual(a: Vec4s, b: Vec4s, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = a.x != b.x
        res.y = a.y != b.y
        res.z = a.z != b.z
        res.w = a.w != b.w
        return res
    }

    fun isEqual(a: Vec4s, b: Vec4s): Boolean = a.x == b.x && a.y == b.y && a.z == b.z && a.w == b.w

    fun any(a: Vec4s): Boolean = a[0] != 0.s || a[1] != 0.s || a[2] != 0.s || a[3] != 0.s

    fun all(a: Vec4s): Boolean = a[0] != 0.s && a[1] != 0.s && a[2] != 0.s && a[3] != 0.s

    fun not(a: Vec4s, res: Vec4s = Vec4s()): Vec4s {
        res[0] = if(a[0] == 0.s) 1 else 0
        res[1] = if(a[1] == 0.s) 1 else 0
        res[2] = if(a[2] == 0.s) 1 else 0
        res[3] = if(a[3] == 0.s) 1 else 0
        return res
    }
    
    
    fun lessThan(a: Vec4i, b: Vec4i, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = a.x < b.x
        res.y = a.y < b.y
        res.z = a.z < b.z
        res.w = a.w < b.w
        return res
    }

    fun lessThanEqual(a: Vec4i, b: Vec4i, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = a.x <= b.x
        res.y = a.y <= b.y
        res.z = a.z <= b.z
        res.w = a.w <= b.w
        return res
    }

    fun greaterThan(a: Vec4i, b: Vec4i, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = a.x > b.x
        res.y = a.y > b.y
        res.z = a.z > b.z
        res.w = a.w > b.w
        return res
    }

    fun greaterThanEqual(a: Vec4i, b: Vec4i, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = a.x >= b.x
        res.y = a.y >= b.y
        res.z = a.z >= b.z
        res.w = a.w >= b.w
        return res
    }

    fun equal(a: Vec4i, b: Vec4i, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = a.x == b.x
        res.y = a.y == b.y
        res.z = a.z == b.z
        res.w = a.w == b.w
        return res
    }

    fun notEqual(a: Vec4i, b: Vec4i, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = a.x != b.x
        res.y = a.y != b.y
        res.z = a.z != b.z
        res.w = a.w != b.w
        return res
    }

    fun isEqual(a: Vec4i, b: Vec4i): Boolean = a.x == b.x && a.y == b.y && a.z == b.z && a.w == b.w

    fun any(a: Vec4i): Boolean = a[0] != 0 || a[1] != 0 || a[2] != 0 || a[3] != 0

    fun all(a: Vec4i): Boolean = a[0] != 0 && a[1] != 0 && a[2] != 0 && a[3] != 0

    fun not(a: Vec4i, res: Vec4i = Vec4i()): Vec4i {
        res[0] = if(a[0] == 0) 1 else 0
        res[1] = if(a[1] == 0) 1 else 0
        res[2] = if(a[2] == 0) 1 else 0
        res[3] = if(a[3] == 0) 1 else 0
        return res
    }
    
    
    fun lessThan(a: Vec4l, b: Vec4l, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = a.x < b.x
        res.y = a.y < b.y
        res.z = a.z < b.z
        res.w = a.w < b.w
        return res
    }

    fun lessThanEqual(a: Vec4l, b: Vec4l, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = a.x <= b.x
        res.y = a.y <= b.y
        res.z = a.z <= b.z
        res.w = a.w <= b.w
        return res
    }

    fun greaterThan(a: Vec4l, b: Vec4l, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = a.x > b.x
        res.y = a.y > b.y
        res.z = a.z > b.z
        res.w = a.w > b.w
        return res
    }

    fun greaterThanEqual(a: Vec4l, b: Vec4l, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = a.x >= b.x
        res.y = a.y >= b.y
        res.z = a.z >= b.z
        res.w = a.w >= b.w
        return res
    }

    fun equal(a: Vec4l, b: Vec4l, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = a.x == b.x
        res.y = a.y == b.y
        res.z = a.z == b.z
        res.w = a.w == b.w
        return res
    }

    fun notEqual(a: Vec4l, b: Vec4l, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = a.x != b.x
        res.y = a.y != b.y
        res.z = a.z != b.z
        res.w = a.w != b.w
        return res
    }

    fun isEqual(a: Vec4l, b: Vec4l): Boolean = a.x == b.x && a.y == b.y && a.z == b.z && a.w == b.w

    fun any(a: Vec4l): Boolean = a[0] != 0L || a[1] != 0L || a[2] != 0L || a[3] != 0L

    fun all(a: Vec4l): Boolean = a[0] != 0L && a[1] != 0L && a[2] != 0L && a[3] != 0L

    fun not(a: Vec4l, res: Vec4l = Vec4l()): Vec4l {
        res[0] = if(a[0] == 0L) 1 else 0
        res[1] = if(a[1] == 0L) 1 else 0
        res[2] = if(a[2] == 0L) 1 else 0
        res[3] = if(a[3] == 0L) 1 else 0
        return res
    }
    
    
    fun lessThan(a: Vec4, b: Vec4, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = a.x < b.x
        res.y = a.y < b.y
        res.z = a.z < b.z
        res.w = a.w < b.w
        return res
    }

    fun lessThanEqual(a: Vec4, b: Vec4, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = a.x <= b.x
        res.y = a.y <= b.y
        res.z = a.z <= b.z
        res.w = a.w <= b.w
        return res
    }

    fun greaterThan(a: Vec4, b: Vec4, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = a.x > b.x
        res.y = a.y > b.y
        res.z = a.z > b.z
        res.w = a.w > b.w
        return res
    }

    fun greaterThanEqual(a: Vec4, b: Vec4, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = a.x >= b.x
        res.y = a.y >= b.y
        res.z = a.z >= b.z
        res.w = a.w >= b.w
        return res
    }

    fun equal(a: Vec4, b: Vec4, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = a.x == b.x
        res.y = a.y == b.y
        res.z = a.z == b.z
        res.w = a.w == b.w
        return res
    }

    fun notEqual(a: Vec4, b: Vec4, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = a.x != b.x
        res.y = a.y != b.y
        res.z = a.z != b.z
        res.w = a.w != b.w
        return res
    }

    fun isEqual(a: Vec4, b: Vec4): Boolean = a.x == b.x && a.y == b.y && a.z == b.z && a.w == b.w

    fun any(a: Vec4): Boolean = a[0] != 0f || a[1] != 0f || a[2] != 0f || a[3] != 0f

    fun all(a: Vec4): Boolean = a[0] != 0f && a[1] != 0f && a[2] != 0f && a[3] != 0f

    fun not(a: Vec4, res: Vec4 = Vec4()): Vec4 {
        res[0] = if(a[0] == 0f) 1 else 0
        res[1] = if(a[1] == 0f) 1 else 0
        res[2] = if(a[2] == 0f) 1 else 0
        res[3] = if(a[3] == 0f) 1 else 0
        return res
    }
    
    
    fun lessThan(a: Vec4d, b: Vec4d, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = a.x < b.x
        res.y = a.y < b.y
        res.z = a.z < b.z
        res.w = a.w < b.w
        return res
    }

    fun lessThanEqual(a: Vec4d, b: Vec4d, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = a.x <= b.x
        res.y = a.y <= b.y
        res.z = a.z <= b.z
        res.w = a.w <= b.w
        return res
    }

    fun greaterThan(a: Vec4d, b: Vec4d, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = a.x > b.x
        res.y = a.y > b.y
        res.z = a.z > b.z
        res.w = a.w > b.w
        return res
    }

    fun greaterThanEqual(a: Vec4d, b: Vec4d, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = a.x >= b.x
        res.y = a.y >= b.y
        res.z = a.z >= b.z
        res.w = a.w >= b.w
        return res
    }

    fun equal(a: Vec4d, b: Vec4d, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = a.x == b.x
        res.y = a.y == b.y
        res.z = a.z == b.z
        res.w = a.w == b.w
        return res
    }

    fun notEqual(a: Vec4d, b: Vec4d, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = a.x != b.x
        res.y = a.y != b.y
        res.z = a.z != b.z
        res.w = a.w != b.w
        return res
    }

    fun isEqual(a: Vec4d, b: Vec4d): Boolean = a.x == b.x && a.y == b.y && a.z == b.z && a.w == b.w

    fun any(a: Vec4d): Boolean = a[0] != 0.0 || a[1] != 0.0 || a[2] != 0.0 || a[3] != 0.0

    fun all(a: Vec4d): Boolean = a[0] != 0.0 && a[1] != 0.0 && a[2] != 0.0 && a[3] != 0.0

    fun not(a: Vec4d, res: Vec4d = Vec4d()): Vec4d {
        res[0] = if(a[0] == 0.0) 1 else 0
        res[1] = if(a[1] == 0.0) 1 else 0
        res[2] = if(a[2] == 0.0) 1 else 0
        res[3] = if(a[3] == 0.0) 1 else 0
        return res
    }


    fun isEqual(a: Vec4bool, b: Vec4bool): Boolean = a.x == b.x && a.y == b.y && a.z == b.z && a.w == b.w

    fun any(a: Vec4bool): Boolean = a[0] || a[1] || a[2] || a[3]

    fun all(a: Vec4bool): Boolean = a[0] && a[1] && a[2] && a[3]

    fun not(a: Vec4bool, res: Vec4bool = Vec4bool()): Vec4bool {
        res[0] = !a[0]
        res[1] = !a[1]
        res[2] = !a[2]
        res[3] = !a[3]
        return res
    }

    // TODO utypes?
}

interface func_vectorBoolean_relational {

    fun equal(a: Vec2bool, b: Vec2bool, res: Vec2bool = Vec2bool()): Vec2bool {
        res[0] = a[0] == b[0]
        res[1] = a[1] == b[1]
        return res
    }

    fun notEqual(a: Vec2bool, b: Vec2bool, res: Vec2bool = Vec2bool()): Vec2bool {
        res[0] = a[0] != b[0]
        res[1] = a[1] != b[1]
        return res
    }

    fun equal(a: Vec3bool, b: Vec3bool, res: Vec3bool = Vec3bool()): Vec3bool {
        res[0] = a[0] == b[0]
        res[1] = a[1] == b[1]
        res[2] = a[2] == b[2]
        return res
    }

    fun notEqual(a: Vec3bool, b: Vec3bool, res: Vec3bool = Vec3bool()): Vec3bool {
        res[0] = a[0] != b[0]
        res[1] = a[1] != b[1]
        res[2] = a[2] != b[2]
        return res
    }

    fun equal(a: Vec4bool, b: Vec4bool, res: Vec4bool = Vec4bool()): Vec4bool {
        res[0] = a[0] == b[0]
        res[1] = a[1] == b[1]
        res[2] = a[2] == b[2]
        res[3] = a[3] == b[3]
        return res
    }

    fun notEqual(a: Vec4bool, b: Vec4bool, res: Vec4bool = Vec4bool()): Vec4bool {
        res[0] = a[0] != b[0]
        res[1] = a[1] != b[1]
        res[2] = a[2] != b[2]
        res[3] = a[3] != b[3]
        return res
    }
}
