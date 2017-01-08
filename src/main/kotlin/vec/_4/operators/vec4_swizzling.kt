package vec._4.operators

import f
import vec.Vec2t
import vec._2.Vec2
import vec._4.Vec4

/**
 * Created by GBarbieri on 13.12.2016.
 */


var Vec4.yw: Vec2t<out Number>
    set(value) {
        y = value.x.f
        w = value.y.f
    }
    get() = Vec2(y, w)