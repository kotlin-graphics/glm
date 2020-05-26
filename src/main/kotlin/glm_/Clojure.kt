package glm_

class Clojure {

    companion object {
        @JvmStatic
        fun frustum(left: Float, right: Float, bottom: Float, top: Float, near: Float, far: Float) = glm.frustum(left, right, bottom, top, near, far)
    }
}