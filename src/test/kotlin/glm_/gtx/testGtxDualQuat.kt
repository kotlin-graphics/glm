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
import glm_.vec3.Vec3
import glm_.vec3.Vec3d
import glm_.vec4.Vec4
import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec

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
                (glm.epsilonEqual(dst1.real, dstCmp.real, epsilon).all && glm.epsilonEqual(dst1.dual, dstCmp.dual, epsilon).all) shouldBe true
                (glm.epsilonEqual(dst2.real, dstCmp.real, epsilon).all && glm.epsilonEqual(dst2.dual, dstCmp.dual, epsilon).all) shouldBe true
                (glm.epsilonEqual(dst3.real, dstCmp.real, epsilon).all && glm.epsilonEqual(dst3.dual, dstCmp.dual, epsilon).all) shouldBe true
            }

            run {
                val dst1 = src1 / 2f
                val dst2 = DualQuat(src1)
                dst2 /= 2f
                val dstCmp = DualQuat(srcQ1 / 2f, srcQ2 / 2f)
                (glm.epsilonEqual(dst1.real, dstCmp.real, epsilon).all && glm.epsilonEqual(dst1.dual, dstCmp.dual, epsilon).all) shouldBe true
                (glm.epsilonEqual(dst2.real, dstCmp.real, epsilon).all && glm.epsilonEqual(dst2.dual, dstCmp.dual, epsilon).all) shouldBe true
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

                (glm.epsilonEqual(r1.real, dqId.real, epsilon).all && glm.epsilonEqual(r1.dual, dqId.dual, epsilon).all) shouldBe true
                (glm.epsilonEqual(r2.real, dqId.real, epsilon).all && glm.epsilonEqual(r2.dual, dqId.dual, epsilon).all) shouldBe true

                // testing commutative property
                val r = DualQuat(Quat(myfrand() * glm.PIf * 2f, myfrand(), myfrand(), myfrand()), Vec3 { myfrand() * 10 })
                val riq = (r * invDq) * dq
                val rqi = (r * dq) * invDq

                (glm.epsilonEqual(riq.real, rqi.real, epsilon).all && glm.epsilonEqual(riq.dual, rqi.dual, epsilon).all) shouldBe true
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

                    glm.epsilonEqual(`dst * m3`, `dst * dq3`, epsilon).all shouldBe true
                    glm.epsilonEqual(`dst * m4`, `dst * dq4`, epsilon).all shouldBe true
                    glm.epsilonEqual(`dst * m3_i`, `dst * dq3_i`, epsilon).all shouldBe true
                    glm.epsilonEqual(`dst * m4_i`, `dst * dq4_i`, epsilon).all shouldBe true
                }
            }
        }
    }
}