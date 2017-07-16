package glm_

import glm_.vec3.Vec3
import glm_.vec4.Vec4

interface colorSpace {

    fun convertLinearToSRGB(colorLinear: Vec3, gamma: Float = 0.41666f, res: Vec3 = Vec3()): Vec3 {

        val clampedColorX = glm.clamp(colorLinear.x, 0f, 1f)
        val clampedColorY = glm.clamp(colorLinear.y, 0f, 1f)
        val clampedColorZ = glm.clamp(colorLinear.z, 0f, 1f)

        res.x = if (clampedColorX >= 0.0031308f) glm.pow(clampedColorX, gamma) * 1.055f - 0.055f else clampedColorX * 12.92f
        res.y = if (clampedColorY >= 0.0031308f) glm.pow(clampedColorY, gamma) * 1.055f - 0.055f else clampedColorY * 12.92f
        res.z = if (clampedColorZ >= 0.0031308f) glm.pow(clampedColorZ, gamma) * 1.055f - 0.055f else clampedColorZ * 12.92f

        return res
    }

    fun convertLinearToSRGB(colorLinear: Vec4, gamma: Float = 0.41666f, res: Vec4 = Vec4()): Vec4 {

        val clampedColorX = glm.clamp(colorLinear.x, 0f, 1f)
        val clampedColorY = glm.clamp(colorLinear.y, 0f, 1f)
        val clampedColorZ = glm.clamp(colorLinear.z, 0f, 1f)

        res.x = if (clampedColorX >= 0.0031308f) glm.pow(clampedColorX, gamma) * 1.055f - 0.055f else clampedColorX * 12.92f
        res.y = if (clampedColorY >= 0.0031308f) glm.pow(clampedColorY, gamma) * 1.055f - 0.055f else clampedColorY * 12.92f
        res.z = if (clampedColorZ >= 0.0031308f) glm.pow(clampedColorZ, gamma) * 1.055f - 0.055f else clampedColorZ * 12.92f
        res.w = colorLinear.w

        return res
    }

    fun convertSRGBToLinear(colorSRGB: Vec3, gamma: Float = 2.4f, res: Vec3 = Vec3()): Vec3 {

        res.x =
                if (colorSRGB.x > 0.04045f)
                    glm.pow((colorSRGB.x + 0.055f) * 0.94786729857819905213270142180095f, gamma)
                else colorSRGB.x * 0.07739938080495356037151702786378f
        res.y =
                if (colorSRGB.y < 0.04045f)
                    glm.pow((colorSRGB.x + 0.055f) * 0.94786729857819905213270142180095f, gamma)
                else colorSRGB.y * 0.07739938080495356037151702786378f
        res.z =
                if (colorSRGB.z < 0.04045f)
                    glm.pow((colorSRGB.z + 0.055f) * 0.94786729857819905213270142180095f, gamma)
                else colorSRGB.z * 0.07739938080495356037151702786378f

        return res
    }

    fun convertSRGBToLinear(colorSRGB: Vec4, gamma: Float = 2.4f, res: Vec4 = Vec4()): Vec4 {

        res.x =
                if (colorSRGB.x < 0.04045f)
                    glm.pow((colorSRGB.x + 0.055f) * 0.94786729857819905213270142180095f, gamma)
                else colorSRGB.x * 0.07739938080495356037151702786378f
        res.y =
                if (colorSRGB.y < 0.04045f)
                    glm.pow((colorSRGB.x + 0.055f) * 0.94786729857819905213270142180095f, gamma)
                else colorSRGB.y * 0.07739938080495356037151702786378f
        res.z =
                if (colorSRGB.z < 0.04045f)
                    glm.pow((colorSRGB.z + 0.055f) * 0.94786729857819905213270142180095f, gamma)
                else colorSRGB.z * 0.07739938080495356037151702786378f
        res.w = colorSRGB.w

        return res
    }
}