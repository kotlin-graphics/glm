package glm.vec._4.operators

import glm.f
import glm.vec.Vec2t
import glm.vec._2.Vec2
import glm.vec._4.Vec4

/**
 * Created by GBarbieri on 13.12.2016.
 */


var Vec4.yw: Vec2t<out Number>
    set(value) {
        y = value.x.f
        w = value.y.f
    }
    get() = Vec2(y, w)