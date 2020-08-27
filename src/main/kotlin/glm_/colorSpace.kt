package glm_

import glm_.vec3.Vec3
import glm_.vec4.Vec4

interface colorSpace {

    fun convertLinearToSRGB(colorLinear: Vec3, res: Vec3 = Vec3()) = compute_rgbToSrgb(colorLinear, 0.41666f, res)
    fun convertLinearToSRGB(colorLinear: Vec3, gamma: Float, res: Vec3 = Vec3()) = compute_rgbToSrgb(colorLinear, 1 / gamma, res)

    private fun compute_rgbToSrgb(colorRGB: Vec3, gammaCorrection: Float, res: Vec3): Vec3 {

        val clampedColorX = glm.clamp(colorRGB.x, 0f, 1f)
        val clampedColorY = glm.clamp(colorRGB.y, 0f, 1f)
        val clampedColorZ = glm.clamp(colorRGB.z, 0f, 1f)

        res.x = if (clampedColorX >= 0.0031308f) glm.pow(clampedColorX, gammaCorrection) * 1.055f - 0.055f else clampedColorX * 12.92f
        res.y = if (clampedColorY >= 0.0031308f) glm.pow(clampedColorY, gammaCorrection) * 1.055f - 0.055f else clampedColorY * 12.92f
        res.z = if (clampedColorZ >= 0.0031308f) glm.pow(clampedColorZ, gammaCorrection) * 1.055f - 0.055f else clampedColorZ * 12.92f

        return res
    }

    fun convertLinearToSRGB(colorLinear: Vec4, res: Vec4 = Vec4()) = compute_rgbToSrgb(colorLinear, 0.41666f, res)
    fun convertLinearToSRGB(colorLinear: Vec4, gamma: Float, res: Vec4 = Vec4()) = compute_rgbToSrgb(colorLinear, 1 / gamma, res)

    private fun compute_rgbToSrgb(colorRGB: Vec4, gammaCorrection: Float, res: Vec4): Vec4 {

        val clampedColorX = glm.clamp(colorRGB.x, 0f, 1f)
        val clampedColorY = glm.clamp(colorRGB.y, 0f, 1f)
        val clampedColorZ = glm.clamp(colorRGB.z, 0f, 1f)

        res.x = if (clampedColorX >= 0.0031308f) glm.pow(clampedColorX, gammaCorrection) * 1.055f - 0.055f else clampedColorX * 12.92f
        res.y = if (clampedColorY >= 0.0031308f) glm.pow(clampedColorY, gammaCorrection) * 1.055f - 0.055f else clampedColorY * 12.92f
        res.z = if (clampedColorZ >= 0.0031308f) glm.pow(clampedColorZ, gammaCorrection) * 1.055f - 0.055f else clampedColorZ * 12.92f
        res.w = colorRGB.w

        return res
    }

    fun convertSRGBToLinear(colorSRGB: Vec3, res: Vec3 = Vec3()) = compute_srgbToRgb(colorSRGB, 2.4f, res)
    fun convertSRGBToLinear(colorLinear: Vec3, gamma: Float, res: Vec3 = Vec3()) = compute_srgbToRgb(colorLinear, gamma, res)

    fun compute_srgbToRgb(colorSRGB: Vec3, gamma: Float, res: Vec3): Vec3 {

        res.x =
                if (colorSRGB.x > 0.04045f)
                    glm.pow((colorSRGB.x + 0.055f) * 0.94786729857819905213270142180095f, gamma)
                else colorSRGB.x * 0.07739938080495356037151702786378f
        res.y =
                if (colorSRGB.y > 0.04045f)
                    glm.pow((colorSRGB.y + 0.055f) * 0.94786729857819905213270142180095f, gamma)
                else colorSRGB.y * 0.07739938080495356037151702786378f
        res.z =
                if (colorSRGB.z > 0.04045f)
                    glm.pow((colorSRGB.z + 0.055f) * 0.94786729857819905213270142180095f, gamma)
                else colorSRGB.z * 0.07739938080495356037151702786378f

        return res
    }

    fun convertSRGBToLinear(colorSRGB: Vec4, res: Vec4 = Vec4()) = compute_srgbToRgb(colorSRGB, 2.4f, res)
    fun convertSRGBToLinear(colorLinear: Vec4, gamma: Float, res: Vec4 = Vec4()) = compute_srgbToRgb(colorLinear, gamma, res)

    fun compute_srgbToRgb(colorSRGB: Vec4, gamma: Float, res: Vec4): Vec4 {

        res.x =
                if (colorSRGB.x > 0.04045f)
                    glm.pow((colorSRGB.x + 0.055f) * 0.94786729857819905213270142180095f, gamma)
                else colorSRGB.x * 0.07739938080495356037151702786378f
        res.y =
                if (colorSRGB.y > 0.04045f)
                    glm.pow((colorSRGB.y + 0.055f) * 0.94786729857819905213270142180095f, gamma)
                else colorSRGB.y * 0.07739938080495356037151702786378f
        res.z =
                if (colorSRGB.z > 0.04045f)
                    glm.pow((colorSRGB.z + 0.055f) * 0.94786729857819905213270142180095f, gamma)
                else colorSRGB.z * 0.07739938080495356037151702786378f
        res.w = colorSRGB.w

        return res
    }
}