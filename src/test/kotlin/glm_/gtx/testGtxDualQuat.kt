package glm_.gtx

import glm_.detail.Random
import glm_.dualQuat.DualQuat
import glm_.dualQuat.DualQuatD
import glm_.dualQuat.times
import glm_.f
import glm_.glm
import glm_.mat4x4.Mat4
import glm_.quat.Quat
import glm_.quat.QuatD
import glm_.shouldEqual
import glm_.vec3.Vec3
import glm_.vec3.Vec3d
import glm_.vec4.Vec4
import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.StringSpec

class testGtxDualQuat : StringSpec() {

    init {

        "dualQuat constructor" {

            val vA = Vec3d()
            val dqA = QuatD()
            val dqB = QuatD()
            val c = DualQuatD(dqA, dqB)
            val b = DualQuatD(dqA)
            val d = DualQuatD(dqA, vA)
        }

        "scalars" {

            val epsilon = 0.0001f

            val srcQ1 = Quat { (it + 1).f }
            val srcQ2 = Quat { (it + 5).f }
            val src1 = DualQuat(srcQ1, srcQ2)

            run {
                val dst1 = src1 * 2f
                val dst2 = 2f * src1
                val dst3 = DualQuat(src1)
                dst3 *= 2f
                val dstCmp = DualQuat(srcQ1 * 2f, srcQ2 * 2f)
                dst1.real.shouldEqual(dstCmp.real, epsilon); dst1.dual.shouldEqual(dstCmp.dual, epsilon)
                dst2.real.shouldEqual(dstCmp.real, epsilon); dst2.dual.shouldEqual(dstCmp.dual, epsilon)
                dst3.real.shouldEqual(dstCmp.real, epsilon); dst3.dual.shouldEqual(dstCmp.dual, epsilon)
            }

            run {
                val dst1 = src1 / 2f
                val dst2 = DualQuat(src1)
                dst2 /= 2f
                val dstCmp = DualQuat(srcQ1 / 2f, srcQ2 / 2f)
                dst1.real.shouldEqual(dstCmp.real, epsilon); dst1.dual.shouldEqual(dstCmp.dual, epsilon)
                dst2.real.shouldEqual(dstCmp.real, epsilon); dst2.dual.shouldEqual(dstCmp.dual, epsilon)
            }
        }

        fun myfrand() = Random[-1f, 1f]

        "inverse" {

            val epsilon = 0.0001f

            val dqId = DualQuat.identity()
            val mId = Mat4(1f)

            for (j in 0..99) {

                val rot = glm.yawPitchRoll { myfrand() * 360f }
                val vt = Vec3 { myfrand() * 10f }

                val m = mId.translate(vt) * rot

                val qr = m.toQuat()

                val dq = DualQuat(qr)

                val invDq = dq.inverse()

                val r1 = invDq * dq
                val r2 = dq * invDq

                r1.real.shouldEqual(dqId.real, epsilon); r1.dual.shouldEqual(dqId.dual, epsilon)
                r2.real.shouldEqual(dqId.real, epsilon); r2.dual.shouldEqual(dqId.dual, epsilon)

                // testing commutative property
                val r = DualQuat(Quat(myfrand() * glm.PIf * 2f, myfrand(), myfrand(), myfrand()), Vec3 { myfrand() * 10 })
                val riq = (r * invDq) * dq
                val rqi = (r * dq) * invDq

                riq.real.shouldEqual(rqi.real, epsilon); riq.dual.shouldEqual(rqi.dual, epsilon)
            }
        }

        "mul" {

            val epsilon = 0.0001f

            val mId = Mat4(1f)

            for (j in 0..99) {
                // generate random rotations and translations and compare transformed by matrix and dualquats random points
                val vt1 = Vec3 { myfrand() * 10f }
                val vt2 = Vec3 { myfrand() * 10f }

                val rot1 = glm.yawPitchRoll { myfrand() * 360f }
                val rot2 = glm.yawPitchRoll { myfrand() * 360f }
                val m1 = mId.translate(vt1) * rot1
                val m2 = mId.translate(vt2) * rot2
                val m3 = m2 * m1
                val m4 = m1 * m2

                val qRot1 = rot1.toQuat()
                val qRot2 = rot2.toQuat()

                val dq1 = DualQuat(qRot1, vt1)
                val dq2 = DualQuat(qRot2, vt2)
                val dq3 = dq2 * dq1
                val dq4 = dq1 * dq2

                for (i in 0..99) {
                    val srcPt = Vec4(myfrand() * 4f, myfrand() * 5f, myfrand() * 3f, 1f)
                    // test both multiplication orders
                    val `dst * m3` = m3 * srcPt
                    val `dst * dq3` = dq3 * srcPt

                    val `dst * m3_i` = m3.inverse() * srcPt
                    val `dst * dq3_i` = srcPt * dq3

                    val `dst * m4` = m4 * srcPt
                    val `dst * dq4` = dq4 * srcPt

                    val `dst * m4_i` = m4.inverse() * srcPt
                    val `dst * dq4_i` = srcPt * dq4

                    `dst * m3`.shouldEqual(`dst * dq3`, epsilon)
                    `dst * m4`.shouldEqual(`dst * dq4`, epsilon)
                    `dst * m3_i`.shouldEqual(`dst * dq3_i`, epsilon)
                    `dst * m4_i`.shouldEqual(`dst * dq4_i`, epsilon)
                }
            }
        }
    }
}