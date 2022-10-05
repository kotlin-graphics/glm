package glm_.scalar

actual val Float.rad: Float
    get() = Math.toRadians(this.toDouble()).toFloat()
actual val Double.rad: Double
    get() = Math.toRadians(this)

actual val Float.deg: Float
    get() = Math.toDegrees(this.toDouble()).toFloat()
actual val Double.deg: Double
    get() = Math.toDegrees(this)