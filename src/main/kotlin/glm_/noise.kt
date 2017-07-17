package glm_

/**
 * Created by GBarbieri on 08.02.2017.
 */

import glm_.glm.floor
import glm_.vec2.Vec2
import glm_.vec2.Vec2d
import glm_.vec2.operators.minus
import glm_.vec2.operators.times
import glm_.vec3.Vec3
import glm_.vec3.Vec3d
import glm_.vec3.operators.minus
import glm_.vec3.operators.times
import glm_.vec4.Vec4
import glm_.vec4.Vec4d
import glm_.vec4.operators.minus
import glm_.vec4.operators.times
import glm_.vec3.operators.plus

interface noise {

    fun mod289(a: Float) = a - floor(a * (1f / 289f)) * 289f
    fun mod289(a: Vec2) = a - floor(a * (1f / 289f)) * 289f
    fun mod289(a: Vec3) = a - floor(a * (1f / 289f)) * 289f
    fun mod289(a: Vec4) = a - floor(a * (1f / 289f)) * 289f

    fun mod289(a: Double) = a - floor(a * (1.0 / 289.0)) * 289.0
    fun mod289(a: Vec2d) = a - floor(a * (1.0 / 289.0)) * 289.0
    fun mod289(a: Vec3d) = a - floor(a * (1.0 / 289.0)) * 289.0
    fun mod289(a: Vec4d) = a - floor(a * (1.0 / 289.0)) * 289.0


    fun permute(a: Float) = mod289((a * 34f + 1f) * a)
    fun permute(a: Vec2) = mod289((a * 34f + 1f) * a)
    fun permute(a: Vec3) = mod289((a * 34f + 1f) * a)
    fun permute(a: Vec4) = mod289((a * 34f + 1f) * a)

    fun permute(a: Double) = mod289((a * 34.0 + 1.0) * a)
    fun permute(a: Vec2d) = mod289((a * 34.0 + 1.0) * a)
    fun permute(a: Vec3d) = mod289((a * 34.0 + 1.0) * a)
    fun permute(a: Vec4d) = mod289((a * 34.0 + 1.0) * a)


    fun taylorInvSqrt(a: Float) = 1.79284291400159f - 0.85373472095314f * a
    fun taylorInvSqrt(a: Vec2) = 1.79284291400159f - 0.85373472095314f * a
    fun taylorInvSqrt(a: Vec3) = 1.79284291400159f - 0.85373472095314f * a
    fun taylorInvSqrt(a: Vec4) = 1.79284291400159f - 0.85373472095314f * a

    fun taylorInvSqrt(a: Double) = 1.79284291400159 - 0.85373472095314 * a
    fun taylorInvSqrt(a: Vec2d) = 1.79284291400159 - 0.85373472095314 * a
    fun taylorInvSqrt(a: Vec3d) = 1.79284291400159 - 0.85373472095314 * a
    fun taylorInvSqrt(a: Vec4d) = 1.79284291400159 - 0.85373472095314 * a

    fun fade(a: Vec2) = (a * a * a) * (a * (a * 6f - 15f) + 10f)
    fun fade(a: Vec3) = (a * a * a) * (a * (a * 6f - 15f) + 10f)
    fun fade(a: Vec4) = (a * a * a) * (a * (a * 6f - 15f) + 10f)

    fun fade(a: Vec2d) = (a * a * a) * (a * (a * 6.0 - 15.0) + 10.0)
    fun fade(a: Vec3d) = (a * a * a) * (a * (a * 6.0 - 15.0) + 10.0)
    fun fade(a: Vec4d) = (a * a * a) * (a * (a * 6.0 - 15.0) + 10.0)


    // ------------------------------GTC------------------------------


    fun grad4(j: Float, ip: Vec4): Vec4 = with(glm) {
        var pXYZ = floor(fract(Vec3(j) * Vec3(ip)) * 7f) * ip[2] - 1f
        val pW = 1.5f - dot(abs(pXYZ), Vec3(1))
        val s = Vec4(lessThan(Vec4(pXYZ, pW), Vec4(0.0f)))
        pXYZ += (Vec3(s) * 2f - 1f) * s.w
        return Vec4(pXYZ, pW)
    }

    fun perlin(position: Vec2): Float = with(glm) {

        var Pi = floor(Vec4(position, position)) + Vec4(0f, 0f, 1f, 1f)
        val Pf = fract(Vec4(position, position)) - Vec4(0f, 0f, 1f, 1f)
        Pi = mod(Pi, Vec4(289)) // To avoid truncation effects in permutation
        val ix = Vec4(Pi.x, Pi.z, Pi.x, Pi.z)
        val iy = Vec4(Pi.y, Pi.y, Pi.w, Pi.w)
        val fx = Vec4(Pf.x, Pf.z, Pf.x, Pf.z)
        val fy = Vec4(Pf.y, Pf.y, Pf.w, Pf.w)

        val i = detail.permute(detail.permute(ix) + iy)

        val gx = 2f * fract(i / 41f) - 1f
        val gy = abs(gx) - 0.5f
        val tx = floor(gx + 0.5f)
        gx minus_ tx

        val g00 = Vec2(gx.x, gy.x)
        val g10 = Vec2(gx.y, gy.y)
        val g01 = Vec2(gx.z, gy.z)
        val g11 = Vec2(gx.w, gy.w)

        val norm = detail.taylorInvSqrt(Vec4(dot(g00, g00), dot(g01, g01), dot(g10, g10), dot(g11, g11)))
        g00 times_ norm.x
        g01 times_ norm.y
        g10 times_ norm.z
        g11 times_ norm.w

        val n00 = dot(g00, Vec2(fx.x, fy.x))
        val n10 = dot(g10, Vec2(fx.y, fy.y))
        val n01 = dot(g01, Vec2(fx.z, fy.z))
        val n11 = dot(g11, Vec2(fx.w, fy.w))

        val fade_xy = detail.fade(Vec2(Pf.x, Pf.y))
        val n_x = mix(Vec2(n00, n01), Vec2(n10, n11), fade_xy.x)
        val n_xy = mix(n_x.x, n_x.y, fade_xy.y)
        return 2.3f * n_xy
    }

    fun perlin(position: Vec3): Float = with(glm) {

        var Pi0 = floor(position) // Integer part for indexing
        var Pi1 = Pi0 + 1f // Integer part + 1
        Pi0 = detail.mod289(Pi0)
        Pi1 = detail.mod289(Pi1)
        val Pf0 = fract(position) // Fractional part for interpolation
        val Pf1 = Pf0 - 1f // Fractional part - 1.0
        val ix = Vec4(Pi0.x, Pi1.x, Pi0.x, Pi1.x)
        val iy = Vec4(Pi0.y, Pi0.y, Pi1.y, Pi1.y)
        val iz0 = Vec4(Pi0.z)
        val iz1 = Vec4(Pi1.z)

        val ixy = detail.permute(detail.permute(ix) + iy)
        val ixy0 = detail.permute(ixy + iz0)
        val ixy1 = detail.permute(ixy + iz1)

        var gx0 = ixy0 * (1f / 7f)
        var gy0 = fract(floor(gx0) * (1f / 7f)) - 0.5f
        gx0 = fract(gx0)
        val gz0 = Vec4(0.5f) - abs(gx0) - abs(gy0)
        val sz0 = step(gz0, Vec4(0f))
        gx0 -= sz0 * (step(0f, gx0) - 0.5f)
        gy0 -= sz0 * (step(0f, gy0) - 0.5f)

        var gx1 = ixy1 * (1f / 7f)
        var gy1 = fract(floor(gx1) * (1f / 7f)) - 0.5f
        gx1 = fract(gx1)
        val gz1 = Vec4(0.5f) - abs(gx1) - abs(gy1)
        val sz1 = step(gz1, Vec4(0f))
        gx1 -= sz1 * (step(0f, gx1) - 0.5f)
        gy1 -= sz1 * (step(0f, gy1) - 0.5f)

        var g000 = Vec3(gx0.x, gy0.x, gz0.x)
        var g100 = Vec3(gx0.y, gy0.y, gz0.y)
        var g010 = Vec3(gx0.z, gy0.z, gz0.z)
        var g110 = Vec3(gx0.w, gy0.w, gz0.w)
        var g001 = Vec3(gx1.x, gy1.x, gz1.x)
        var g101 = Vec3(gx1.y, gy1.y, gz1.y)
        var g011 = Vec3(gx1.z, gy1.z, gz1.z)
        var g111 = Vec3(gx1.w, gy1.w, gz1.w)

        val norm0 = detail.taylorInvSqrt(Vec4(dot(g000, g000), dot(g010, g010), dot(g100, g100), dot(g110, g110)))
        g000 *= norm0.x
        g010 *= norm0.y
        g100 *= norm0.z
        g110 *= norm0.w
        val norm1 = detail.taylorInvSqrt(Vec4(dot(g001, g001), dot(g011, g011), dot(g101, g101), dot(g111, g111)))
        g001 *= norm1.x
        g011 *= norm1.y
        g101 *= norm1.z
        g111 *= norm1.w

        val n000 = dot(g000, Pf0)
        val n100 = dot(g100, Vec3(Pf1.x, Pf0.y, Pf0.z))
        val n010 = dot(g010, Vec3(Pf0.x, Pf1.y, Pf0.z))
        val n110 = dot(g110, Vec3(Pf1.x, Pf1.y, Pf0.z))
        val n001 = dot(g001, Vec3(Pf0.x, Pf0.y, Pf1.z))
        val n101 = dot(g101, Vec3(Pf1.x, Pf0.y, Pf1.z))
        val n011 = dot(g011, Vec3(Pf0.x, Pf1.y, Pf1.z))
        val n111 = dot(g111, Pf1)

        val fade_xyz = detail.fade(Pf0)
        val n_z = mix(Vec4(n000, n100, n010, n110), Vec4(n001, n101, n011, n111), fade_xyz.z)
        val n_yz = mix(Vec2(n_z.x, n_z.y), Vec2(n_z.z, n_z.w), fade_xyz.y)
        val n_xyz = mix(n_yz.x, n_yz.y, fade_xyz.x)
        return 2.2f * n_xyz
    }

    fun perlin(position: Vec4): Float = with(glm) {
        var Pi0 = floor(position)    // Integer part for indexing
        var Pi1 = Pi0 + 1f        // Integer part + 1
        Pi0 = mod(Pi0, Vec4(289))
        Pi1 = mod(Pi1, Vec4(289))
        val Pf0 = fract(position)    // Fractional part for interpolation
        val Pf1 = Pf0 - 1f        // Fractional part - 1.0
        val ix = Vec4(Pi0.x, Pi1.x, Pi0.x, Pi1.x)
        val iy = Vec4(Pi0.y, Pi0.y, Pi1.y, Pi1.y)
        val iz0 = Vec4(Pi0.z)
        val iz1 = Vec4(Pi1.z)
        val iw0 = Vec4(Pi0.w)
        val iw1 = Vec4(Pi1.w)

        val ixy = detail.permute(detail.permute(ix) + iy)
        val ixy0 = detail.permute(ixy + iz0)
        val ixy1 = detail.permute(ixy + iz1)
        val ixy00 = detail.permute(ixy0 + iw0)
        val ixy01 = detail.permute(ixy0 + iw1)
        val ixy10 = detail.permute(ixy1 + iw0)
        val ixy11 = detail.permute(ixy1 + iw1)

        var gx00 = ixy00 / 7f
        var gy00 = floor(gx00) / 7f
        var gz00 = floor(gy00) / 6f
        gx00 = fract(gx00) - 0.5f
        gy00 = fract(gy00) - 0.5f
        gz00 = fract(gz00) - 0.5f
        val gw00 = Vec4(0.75f) - abs(gx00) - abs(gy00) - abs(gz00)
        val sw00 = step(gw00, Vec4(0f))
        gx00 -= sw00 * (step(0f, gx00) - 0.5f)
        gy00 -= sw00 * (step(0f, gy00) - 0.5f)

        var gx01 = ixy01 / 7f
        var gy01 = floor(gx01) / 7f
        var gz01 = floor(gy01) / 6f
        gx01 = fract(gx01) - 0.5f
        gy01 = fract(gy01) - 0.5f
        gz01 = fract(gz01) - 0.5f
        val gw01 = Vec4(0.75f) - abs(gx01) - abs(gy01) - abs(gz01)
        val sw01 = step(gw01, Vec4(0f))
        gx01 -= sw01 * (step(0f, gx01) - 0.5f)
        gy01 -= sw01 * (step(0f, gy01) - 0.5f)

        var gx10 = ixy10 / 7f
        var gy10 = floor(gx10) / 7f
        var gz10 = floor(gy10) / 6f
        gx10 = fract(gx10) - 0.5f
        gy10 = fract(gy10) - 0.5f
        gz10 = fract(gz10) - 0.5f
        val gw10 = Vec4(0.75f) - abs(gx10) - abs(gy10) - abs(gz10)
        val sw10 = step(gw10, Vec4(0f))
        gx10 -= sw10 * (step(0f, gx10) - 0.5f)
        gy10 -= sw10 * (step(0f, gy10) - 0.5f)

        var gx11 = ixy11 / 7f
        var gy11 = floor(gx11) / 7f
        var gz11 = floor(gy11) / 6f
        gx11 = fract(gx11) - 0.5f
        gy11 = fract(gy11) - 0.5f
        gz11 = fract(gz11) - 0.5f
        val gw11 = Vec4(0.75f) - abs(gx11) - abs(gy11) - abs(gz11)
        val sw11 = step(gw11, Vec4(0f))
        gx11 -= sw11 * (step(0f, gx11) - 0.5f)
        gy11 -= sw11 * (step(0f, gy11) - 0.5f)

        var g0000 = Vec4(gx00.x, gy00.x, gz00.x, gw00.x)
        var g1000 = Vec4(gx00.y, gy00.y, gz00.y, gw00.y)
        var g0100 = Vec4(gx00.z, gy00.z, gz00.z, gw00.z)
        var g1100 = Vec4(gx00.w, gy00.w, gz00.w, gw00.w)
        var g0010 = Vec4(gx10.x, gy10.x, gz10.x, gw10.x)
        var g1010 = Vec4(gx10.y, gy10.y, gz10.y, gw10.y)
        var g0110 = Vec4(gx10.z, gy10.z, gz10.z, gw10.z)
        var g1110 = Vec4(gx10.w, gy10.w, gz10.w, gw10.w)
        var g0001 = Vec4(gx01.x, gy01.x, gz01.x, gw01.x)
        var g1001 = Vec4(gx01.y, gy01.y, gz01.y, gw01.y)
        var g0101 = Vec4(gx01.z, gy01.z, gz01.z, gw01.z)
        var g1101 = Vec4(gx01.w, gy01.w, gz01.w, gw01.w)
        var g0011 = Vec4(gx11.x, gy11.x, gz11.x, gw11.x)
        var g1011 = Vec4(gx11.y, gy11.y, gz11.y, gw11.y)
        var g0111 = Vec4(gx11.z, gy11.z, gz11.z, gw11.z)
        var g1111 = Vec4(gx11.w, gy11.w, gz11.w, gw11.w)

        val norm00 = detail.taylorInvSqrt(Vec4(dot(g0000, g0000), dot(g0100, g0100), dot(g1000, g1000), dot(g1100, g1100)))
        g0000 *= norm00.x
        g0100 *= norm00.y
        g1000 *= norm00.z
        g1100 *= norm00.w

        val norm01 = detail.taylorInvSqrt(Vec4(dot(g0001, g0001), dot(g0101, g0101), dot(g1001, g1001), dot(g1101, g1101)))
        g0001 *= norm01.x
        g0101 *= norm01.y
        g1001 *= norm01.z
        g1101 *= norm01.w

        val norm10 = detail.taylorInvSqrt(Vec4(dot(g0010, g0010), dot(g0110, g0110), dot(g1010, g1010), dot(g1110, g1110)))
        g0010 *= norm10.x
        g0110 *= norm10.y
        g1010 *= norm10.z
        g1110 *= norm10.w

        val norm11 = detail.taylorInvSqrt(Vec4(dot(g0011, g0011), dot(g0111, g0111), dot(g1011, g1011), dot(g1111, g1111)))
        g0011 *= norm11.x
        g0111 *= norm11.y
        g1011 *= norm11.z
        g1111 *= norm11.w

        val n0000 = dot(g0000, Pf0)
        val n1000 = dot(g1000, Vec4(Pf1.x, Pf0.y, Pf0.z, Pf0.w))
        val n0100 = dot(g0100, Vec4(Pf0.x, Pf1.y, Pf0.z, Pf0.w))
        val n1100 = dot(g1100, Vec4(Pf1.x, Pf1.y, Pf0.z, Pf0.w))
        val n0010 = dot(g0010, Vec4(Pf0.x, Pf0.y, Pf1.z, Pf0.w))
        val n1010 = dot(g1010, Vec4(Pf1.x, Pf0.y, Pf1.z, Pf0.w))
        val n0110 = dot(g0110, Vec4(Pf0.x, Pf1.y, Pf1.z, Pf0.w))
        val n1110 = dot(g1110, Vec4(Pf1.x, Pf1.y, Pf1.z, Pf0.w))
        val n0001 = dot(g0001, Vec4(Pf0.x, Pf0.y, Pf0.z, Pf1.w))
        val n1001 = dot(g1001, Vec4(Pf1.x, Pf0.y, Pf0.z, Pf1.w))
        val n0101 = dot(g0101, Vec4(Pf0.x, Pf1.y, Pf0.z, Pf1.w))
        val n1101 = dot(g1101, Vec4(Pf1.x, Pf1.y, Pf0.z, Pf1.w))
        val n0011 = dot(g0011, Vec4(Pf0.x, Pf0.y, Pf1.z, Pf1.w))
        val n1011 = dot(g1011, Vec4(Pf1.x, Pf0.y, Pf1.z, Pf1.w))
        val n0111 = dot(g0111, Vec4(Pf0.x, Pf1.y, Pf1.z, Pf1.w))
        val n1111 = dot(g1111, Pf1)

        val fade_xyzw = detail.fade(Pf0)
        val n_0w = mix(Vec4(n0000, n1000, n0100, n1100), Vec4(n0001, n1001, n0101, n1101), fade_xyzw.w)
        val n_1w = mix(Vec4(n0010, n1010, n0110, n1110), Vec4(n0011, n1011, n0111, n1111), fade_xyzw.w)
        val n_zw = mix(n_0w, n_1w, fade_xyzw.z)
        val n_yzw = mix(Vec2(n_zw.x, n_zw.y), Vec2(n_zw.z, n_zw.w), fade_xyzw.y)
        val n_xyzw = mix(n_yzw.x, n_yzw.y, fade_xyzw.x)
        return 2.2f * n_xyzw
    }

    fun perlin(position: Vec2, rep: Vec2): Float = with(glm) {

        var Pi = floor(Vec4(position, position)) + Vec4(0f, 0f, 1f, 1f)
        val Pf = fract(Vec4(position, position)) - Vec4(0f, 0f, 1f, 1f)
        Pi = mod(Pi, Vec4(rep, rep)) // To create noise with explicit period
        Pi = mod(Pi, Vec4(289)) // To avoid truncation effects in permutation
        val ix = Vec4(Pi.x, Pi.z, Pi.x, Pi.z)
        val iy = Vec4(Pi.y, Pi.y, Pi.w, Pi.w)
        val fx = Vec4(Pf.x, Pf.z, Pf.x, Pf.z)
        val fy = Vec4(Pf.y, Pf.y, Pf.w, Pf.w)

        val i = detail.permute(detail.permute(ix) + iy)

        val gx = 2f * fract(i / 41f) - 1f
        val gy = abs(gx) - 0.5f
        val tx = floor(gx + 0.5f)
        gx minus_ tx

        var g00 = Vec2(gx.x, gy.x)
        var g10 = Vec2(gx.y, gy.y)
        var g01 = Vec2(gx.z, gy.z)
        var g11 = Vec2(gx.w, gy.w)

        val norm = detail.taylorInvSqrt(Vec4(dot(g00, g00), dot(g01, g01), dot(g10, g10), dot(g11, g11)))
        g00 *= norm.x
        g01 *= norm.y
        g10 *= norm.z
        g11 *= norm.w

        val n00 = dot(g00, Vec2(fx.x, fy.x))
        val n10 = dot(g10, Vec2(fx.y, fy.y))
        val n01 = dot(g01, Vec2(fx.z, fy.z))
        val n11 = dot(g11, Vec2(fx.w, fy.w))

        val fade_xy = detail.fade(Vec2(Pf.x, Pf.y))
        val n_x = mix(Vec2(n00, n01), Vec2(n10, n11), fade_xy.x)
        val n_xy = mix(n_x.x, n_x.y, fade_xy.y)
        return 2.3f * n_xy
    }

    fun perlin(position: Vec3, rep: Vec3): Float = with(glm) {

        var Pi0 = mod(floor(position), rep) // Integer part, modulo period
        var Pi1 = mod(Pi0 + Vec3(1f), rep) // Integer part + 1, mod period
        Pi0 = mod(Pi0, Vec3(289))
        Pi1 = mod(Pi1, Vec3(289))
        val Pf0 = fract(position) // Fractional part for interpolation
        val Pf1 = Pf0 - Vec3(1f) // Fractional part - 1.0
        val ix = Vec4(Pi0.x, Pi1.x, Pi0.x, Pi1.x)
        val iy = Vec4(Pi0.y, Pi0.y, Pi1.y, Pi1.y)
        val iz0 = Vec4(Pi0.z)
        val iz1 = Vec4(Pi1.z)

        val ixy = detail.permute(detail.permute(ix) + iy)
        val ixy0 = detail.permute(ixy + iz0)
        val ixy1 = detail.permute(ixy + iz1)

        var gx0 = ixy0 / 7f
        var gy0 = fract(floor(gx0) / 7f) - 0.5f
        gx0 = fract(gx0)
        val gz0 = Vec4(0.5f) - abs(gx0) - abs(gy0)
        val sz0 = step(gz0, Vec4(0f))
        gx0 -= sz0 * (step(0f, gx0) - 0.5f)
        gy0 -= sz0 * (step(0f, gy0) - 0.5f)

        var gx1 = ixy1 / 7f
        var gy1 = fract(floor(gx1) / 7f) - 0.5f
        gx1 = fract(gx1)
        val gz1 = Vec4(0.5f) - abs(gx1) - abs(gy1)
        val sz1 = step(gz1, Vec4(0f))
        gx1 -= sz1 * (step(0f, gx1) - 0.5f)
        gy1 -= sz1 * (step(0f, gy1) - 0.5f)

        var g000 = Vec3(gx0.x, gy0.x, gz0.x)
        var g100 = Vec3(gx0.y, gy0.y, gz0.y)
        var g010 = Vec3(gx0.z, gy0.z, gz0.z)
        var g110 = Vec3(gx0.w, gy0.w, gz0.w)
        var g001 = Vec3(gx1.x, gy1.x, gz1.x)
        var g101 = Vec3(gx1.y, gy1.y, gz1.y)
        var g011 = Vec3(gx1.z, gy1.z, gz1.z)
        var g111 = Vec3(gx1.w, gy1.w, gz1.w)

        val norm0 = detail.taylorInvSqrt(Vec4(dot(g000, g000), dot(g010, g010), dot(g100, g100), dot(g110, g110)))
        g000 *= norm0.x
        g010 *= norm0.y
        g100 *= norm0.z
        g110 *= norm0.w
        val norm1 = detail.taylorInvSqrt(Vec4(dot(g001, g001), dot(g011, g011), dot(g101, g101), dot(g111, g111)))
        g001 *= norm1.x
        g011 *= norm1.y
        g101 *= norm1.z
        g111 *= norm1.w

        val n000 = dot(g000, Pf0)
        val n100 = dot(g100, Vec3(Pf1.x, Pf0.y, Pf0.z))
        val n010 = dot(g010, Vec3(Pf0.x, Pf1.y, Pf0.z))
        val n110 = dot(g110, Vec3(Pf1.x, Pf1.y, Pf0.z))
        val n001 = dot(g001, Vec3(Pf0.x, Pf0.y, Pf1.z))
        val n101 = dot(g101, Vec3(Pf1.x, Pf0.y, Pf1.z))
        val n011 = dot(g011, Vec3(Pf0.x, Pf1.y, Pf1.z))
        val n111 = dot(g111, Pf1)

        val fade_xyz = detail.fade(Pf0)
        val n_z = mix(Vec4(n000, n100, n010, n110), Vec4(n001, n101, n011, n111), fade_xyz.z)
        val n_yz = mix(Vec2(n_z.x, n_z.y), Vec2(n_z.z, n_z.w), fade_xyz.y)
        val n_xyz = mix(n_yz.x, n_yz.y, fade_xyz.x)
        return 2.2f * n_xyz
    }

    fun perlin(position: Vec4, rep: Vec4): Float = with(glm) {

        val Pi0 = mod(floor(position), rep) // Integer part modulo rep
        val Pi1 = mod(Pi0 + 1f, rep) // Integer part + 1 mod rep
        val Pf0 = fract(position) // Fractional part for interpolation
        val Pf1 = Pf0 - 1f // Fractional part - 1.0
        val ix = Vec4(Pi0.x, Pi1.x, Pi0.x, Pi1.x)
        val iy = Vec4(Pi0.y, Pi0.y, Pi1.y, Pi1.y)
        val iz0 = Vec4(Pi0.z)
        val iz1 = Vec4(Pi1.z)
        val iw0 = Vec4(Pi0.w)
        val iw1 = Vec4(Pi1.w)

        val ixy = detail.permute(detail.permute(ix) + iy)
        val ixy0 = detail.permute(ixy + iz0)
        val ixy1 = detail.permute(ixy + iz1)
        val ixy00 = detail.permute(ixy0 + iw0)
        val ixy01 = detail.permute(ixy0 + iw1)
        val ixy10 = detail.permute(ixy1 + iw0)
        val ixy11 = detail.permute(ixy1 + iw1)

        var gx00 = ixy00 / 7f
        var gy00 = floor(gx00) / 7f
        var gz00 = floor(gy00) / 6f
        gx00 = fract(gx00) - 0.5f
        gy00 = fract(gy00) - 0.5f
        gz00 = fract(gz00) - 0.5f
        val gw00 = Vec4(0.75f) - abs(gx00) - abs(gy00) - abs(gz00)
        val sw00 = step(gw00, Vec4(0f))
        gx00 -= sw00 * (step(0f, gx00) - 0.5f)
        gy00 -= sw00 * (step(0f, gy00) - 0.5f)

        var gx01 = ixy01 / 7f
        var gy01 = floor(gx01) / 7f
        var gz01 = floor(gy01) / 6f
        gx01 = fract(gx01) - 0.5f
        gy01 = fract(gy01) - 0.5f
        gz01 = fract(gz01) - 0.5f
        val gw01 = Vec4(0.75f) - abs(gx01) - abs(gy01) - abs(gz01)
        val sw01 = step(gw01, Vec4(0f))
        gx01 -= sw01 * (step(0f, gx01) - 0.5f)
        gy01 -= sw01 * (step(0f, gy01) - 0.5f)

        var gx10 = ixy10 / 7f
        var gy10 = floor(gx10) / 7f
        var gz10 = floor(gy10) / 6f
        gx10 = fract(gx10) - 0.5f
        gy10 = fract(gy10) - 0.5f
        gz10 = fract(gz10) - 0.5f
        val gw10 = Vec4(0.75f) - abs(gx10) - abs(gy10) - abs(gz10)
        val sw10 = step(gw10, Vec4(0f))
        gx10 -= sw10 * (step(0f, gx10) - 0.5f)
        gy10 -= sw10 * (step(0f, gy10) - 0.5f)

        var gx11 = ixy11 / 7f
        var gy11 = floor(gx11) / 7f
        var gz11 = floor(gy11) / 6f
        gx11 = fract(gx11) - 0.5f
        gy11 = fract(gy11) - 0.5f
        gz11 = fract(gz11) - 0.5f
        val gw11 = Vec4(0.75f) - abs(gx11) - abs(gy11) - abs(gz11)
        val sw11 = step(gw11, Vec4(0f))
        gx11 -= sw11 * (step(0f, gx11) - 0.5f)
        gy11 -= sw11 * (step(0f, gy11) - 0.5f)

        var g0000 = Vec4(gx00.x, gy00.x, gz00.x, gw00.x)
        var g1000 = Vec4(gx00.y, gy00.y, gz00.y, gw00.y)
        var g0100 = Vec4(gx00.z, gy00.z, gz00.z, gw00.z)
        var g1100 = Vec4(gx00.w, gy00.w, gz00.w, gw00.w)
        var g0010 = Vec4(gx10.x, gy10.x, gz10.x, gw10.x)
        var g1010 = Vec4(gx10.y, gy10.y, gz10.y, gw10.y)
        var g0110 = Vec4(gx10.z, gy10.z, gz10.z, gw10.z)
        var g1110 = Vec4(gx10.w, gy10.w, gz10.w, gw10.w)
        var g0001 = Vec4(gx01.x, gy01.x, gz01.x, gw01.x)
        var g1001 = Vec4(gx01.y, gy01.y, gz01.y, gw01.y)
        var g0101 = Vec4(gx01.z, gy01.z, gz01.z, gw01.z)
        var g1101 = Vec4(gx01.w, gy01.w, gz01.w, gw01.w)
        var g0011 = Vec4(gx11.x, gy11.x, gz11.x, gw11.x)
        var g1011 = Vec4(gx11.y, gy11.y, gz11.y, gw11.y)
        var g0111 = Vec4(gx11.z, gy11.z, gz11.z, gw11.z)
        var g1111 = Vec4(gx11.w, gy11.w, gz11.w, gw11.w)

        val norm00 = detail.taylorInvSqrt(Vec4(dot(g0000, g0000), dot(g0100, g0100), dot(g1000, g1000), dot(g1100, g1100)))
        g0000 *= norm00.x
        g0100 *= norm00.y
        g1000 *= norm00.z
        g1100 *= norm00.w

        val norm01 = detail.taylorInvSqrt(Vec4(dot(g0001, g0001), dot(g0101, g0101), dot(g1001, g1001), dot(g1101, g1101)))
        g0001 *= norm01.x
        g0101 *= norm01.y
        g1001 *= norm01.z
        g1101 *= norm01.w

        val norm10 = detail.taylorInvSqrt(Vec4(dot(g0010, g0010), dot(g0110, g0110), dot(g1010, g1010), dot(g1110, g1110)))
        g0010 *= norm10.x
        g0110 *= norm10.y
        g1010 *= norm10.z
        g1110 *= norm10.w

        val norm11 = detail.taylorInvSqrt(Vec4(dot(g0011, g0011), dot(g0111, g0111), dot(g1011, g1011), dot(g1111, g1111)))
        g0011 *= norm11.x
        g0111 *= norm11.y
        g1011 *= norm11.z
        g1111 *= norm11.w

        val n0000 = dot(g0000, Pf0)
        val n1000 = dot(g1000, Vec4(Pf1.x, Pf0.y, Pf0.z, Pf0.w))
        val n0100 = dot(g0100, Vec4(Pf0.x, Pf1.y, Pf0.z, Pf0.w))
        val n1100 = dot(g1100, Vec4(Pf1.x, Pf1.y, Pf0.z, Pf0.w))
        val n0010 = dot(g0010, Vec4(Pf0.x, Pf0.y, Pf1.z, Pf0.w))
        val n1010 = dot(g1010, Vec4(Pf1.x, Pf0.y, Pf1.z, Pf0.w))
        val n0110 = dot(g0110, Vec4(Pf0.x, Pf1.y, Pf1.z, Pf0.w))
        val n1110 = dot(g1110, Vec4(Pf1.x, Pf1.y, Pf1.z, Pf0.w))
        val n0001 = dot(g0001, Vec4(Pf0.x, Pf0.y, Pf0.z, Pf1.w))
        val n1001 = dot(g1001, Vec4(Pf1.x, Pf0.y, Pf0.z, Pf1.w))
        val n0101 = dot(g0101, Vec4(Pf0.x, Pf1.y, Pf0.z, Pf1.w))
        val n1101 = dot(g1101, Vec4(Pf1.x, Pf1.y, Pf0.z, Pf1.w))
        val n0011 = dot(g0011, Vec4(Pf0.x, Pf0.y, Pf1.z, Pf1.w))
        val n1011 = dot(g1011, Vec4(Pf1.x, Pf0.y, Pf1.z, Pf1.w))
        val n0111 = dot(g0111, Vec4(Pf0.x, Pf1.y, Pf1.z, Pf1.w))
        val n1111 = dot(g1111, Pf1)

        val fade_xyzw = detail.fade(Pf0)
        val n_0w = mix(Vec4(n0000, n1000, n0100, n1100), Vec4(n0001, n1001, n0101, n1101), fade_xyzw.w)
        val n_1w = mix(Vec4(n0010, n1010, n0110, n1110), Vec4(n0011, n1011, n0111, n1111), fade_xyzw.w)
        val n_zw = mix(n_0w, n_1w, fade_xyzw.z)
        val n_yzw = mix(Vec2(n_zw.x, n_zw.y), Vec2(n_zw.z, n_zw.w), fade_xyzw.y)
        val n_xyzw = mix(n_yzw.x, n_yzw.y, fade_xyzw.x)
        return 2.2f * n_xyzw
    }

    fun simplex(v: Vec2): Float = with(glm) {

        val C = Vec4(
                +0.211324865405187f, // (3.0 -  sqrt(3.0)) / 6.0
                +0.366025403784439f, //  0.5 * (sqrt(3.0)  - 1.0)
                -0.577350269189626f, // -1.0 + 2.0 * C.x
                +0.024390243902439f) //  1.0 / 41.0

        // First corner
        var i = floor(v + dot(v, Vec2(C[1])))
        val x0 = v - i + dot(i, Vec2(C[0]))

        // Other corners
        //i1.x = step( x0.y, x0.x ); // x0.x > x0.y ? 1.0 : 0.0
        //i1.y = 1.0 - i1.x;
        val i1 = if (x0.x > x0.y) Vec2(1f, 0f) else Vec2(0f, 1f)
        // x0 = x0 - 0.0 + 0.0 * C.xx ;
        // x1 = x0 - i1 + 1.0 * C.xx ;
        // x2 = x0 - 1.0 + 2.0 * C.xx ;
        var x12 = Vec4(x0, x0) + Vec4(C.x, C.x, C.z, C.z)
        x12 = Vec4(Vec2(x12) - i1, x12.z, x12.w)

        // Permutations
        i = mod(i, Vec2(289f)) // Avoid truncation effects in permutation
        val p = detail.permute(
                detail.permute(i.y + Vec3(0f, i1.y, 1f))
                        + i.x + Vec3(0f, i1.x, 1f))

        var m = max(Vec3(0.5f) - Vec3(
                dot(x0, x0),
                dot(Vec2(x12.x, x12.y), Vec2(x12.x, x12.y)),
                dot(Vec2(x12.z, x12.w), Vec2(x12.z, x12.w))), Vec3(0f))
        m = m * m
        m = m * m

        // Gradients: 41 points uniformly over a line, mapped onto a diamond.
        // The ring size 17*17 = 289 is close to a multiple of 41 (41*7 = 287)

        val x = 2f * fract(p * C.w) - 1f
        val h = abs(x) - 0.5f
        val ox = floor(x + 0.5f)
        val a0 = x - ox

        // Normalise gradients implicitly by scaling m
        // Inlined for speed: m *= taylorInvSqrt( a0*a0 + h*h );
        m *= 1.79284291400159f - 0.85373472095314f * (a0 * a0 + h * h)

        // Compute final noise value at P
        val g = Vec3(
                a0.x * x0.x + h.x * x0.y,
                //g.yz = a0.yz * x12.xz + h.yz * x12.yw;
                a0.y * x12.x + h.y * x12.y,
                a0.z * x12.z + h.z * x12.w)
        return 130f * dot(m, g)
    }
}