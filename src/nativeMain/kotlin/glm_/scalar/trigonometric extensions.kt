package glm_.scalar

actual val Float.rad: Float
    get() = this * 0.017453292f
actual val Double.rad: Double
    get() = this * 0.017453292519943295

actual val Float.deg: Float
    get() = this * 57.29578f
actual val Double.deg: Double
    get() = this * 57.29577951308232