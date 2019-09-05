package glm_

import glm_.mat4x4.Mat4
import glm_.quat.Quat
import glm_.quat.times
import glm_.vec3.Vec3
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

/**
 * Created by elect on 04/03/2017.
 */

class testQuaternion : StringSpec() {

    init {

        with(glm) {

            val epsilon = .0001f

            "quat angle" {

                run {

                    val q = Quat().angleAxis(PIf * .25f, Vec3(0, 0, 1))
                    val n = q.normalize()
                    val l = n.length()

                    epsilonEqual(l, 1f, .01f) shouldBe true

                    val a = n.angle()

                    epsilonEqual(a, PIf * .25f, .01f) shouldBe true
                }

                run {

                    val q = Quat().angleAxis(PIf * .25f, Vec3(0, 1, 1).normalize())
                    val n = q.normalize()
                    val l = n.length()

                    epsilonEqual(l, 1f, .01f) shouldBe true

                    val a = n.angle()

                    epsilonEqual(a, PIf * .25f, .01f) shouldBe true
                }

                run {

                    val q = Quat().angleAxis(PIf * .25f, Vec3(1, 2, 3).normalize())
                    val n = q.normalize()
                    val l = n.length()

                    epsilonEqual(l, 1f, .01f) shouldBe true

                    val a = n.angle()

                    epsilonEqual(a, PIf * .25f, .01f) shouldBe true
                }
            }

            "quat axis" {

                val a = Quat().angleAxis(0f, Vec3(0, 0, 1))
                val b = Quat().angleAxis(PIf * .5f, Vec3(0, 0, 1))
                val c = glm.mix(a, b, .5f, Quat())
                val d = Quat().angleAxis(PIf * .25f, Vec3(0, 0, 1))

                all(epsilonEqual(c, d, .01f)) shouldBe true
            }

            "quat mix" {

                val a = Quat().angleAxis(0f, Vec3(0, 0, 1))
                val b = Quat().angleAxis(PIf * .5f, Vec3(0, 0, 1))
                val c = glm.mix(a, b, .5f, Quat())
                val d = Quat().angleAxis(PIf * .25f, Vec3(0, 0, 1))

                all(epsilonEqual(c, d, .01f)) shouldBe true
            }

            "quat normalize" {

                run {
                    val q = Quat().angleAxis(PIf * .25f, Vec3(0, 0, 1))
                    val n = q.normalize()
                    val l = n.length()

                    epsilonEqual(l, 1f, .000001f) shouldBe true
                }
                run {
                    val q = Quat().angleAxis(PIf * .25f, Vec3(0, 0, 2))
                    val n = q.normalize()
                    val l = n.length()

                    epsilonEqual(l, 1f, .000001f) shouldBe true
                }
                run {
                    val q = Quat().angleAxis(PIf * .25f, Vec3(1, 2, 3))
                    val n = q.normalize()
                    val l = n.length()

                    epsilonEqual(l, 1f, .000001f) shouldBe true
                }
            }

            "quat euler" {

                run {
                    val q = Quat(1f, 0f, 0f, 1f)
                    val roll = roll(q)
                    val pitch = pitch(q)
                    val yaw = yaw(q)
                    val angles = q.eulerAngles()
                }
                run {
                    val q = Quat(1f, 0f, 0f, 1f)
                    val roll = roll(q)
                    val pitch = pitch(q)
                    val yaw = yaw(q)
                    val angles = q.eulerAngles()
                }
            }

            "quat slerp" {

                val sqrt2 = glm.sqrt(2f) / 2f
                val id = Quat()
                val y90rot = Quat(sqrt2, 0f, sqrt2, 0f)

                // Testing a == 0
                // Must be id
                val id2 = id.slerp(y90rot, .0f)
                all(epsilonEqual(id, id2, epsilon)) shouldBe true

                // Testing a == 1
                // Must be 90° rotation on Y : 0 0.7 0 0.7
                val y90rot2 = id.slerp(y90rot, 1f)
                all(epsilonEqual(y90rot, y90rot2, epsilon)) shouldBe true

                // Testing standard, easy case
                // Must be 45° rotation on Y : 0 0.38 0 0.92
                val y45rot1 = id.slerp(y90rot, .5f)
                all(epsilonEqual(y45rot1, Quat(.92f, 0f, .38f, 0f), .01f)) shouldBe true

                // Testing reverse case
                // Must be 45° rotation on Y : 0 0.38 0 0.92
                val ym45rot2 = id.slerp(y90rot, .5f)
                all(epsilonEqual(ym45rot2, Quat(.92f, 0f, .38f, 0f), .01f)) shouldBe true

                // Testing against full circle around the sphere instead of shortest path
                // Must be 45° rotation on Y
                // certainly not a 135° rotation
                val y45rot3 = id.slerp(-y90rot, .5f)
                val y45angle3 = y45rot3.angle()
                epsilonEqual(y45angle3, PIf * .25f, epsilon) shouldBe true
                all(epsilonEqual(ym45rot2, y45rot3, epsilon)) shouldBe true

                // Same, but inverted
                // Must also be 45° rotation on Y :  0 0.38 0 0.92
                // -0 -0.38 -0 -0.92 is ok too
                val y45rot4 = slerp(-y90rot, id, 0.5f, Quat())
                all(epsilonEqual(ym45rot2, -y45rot4, epsilon)) shouldBe true

                // Testing q1 = q2
                // Must be 90° rotation on Y : 0 0.7 0 0.7
                val y90rot3 = y90rot.slerp(y90rot, .5f)
                all(epsilonEqual(y90rot, y90rot3, epsilon)) shouldBe true

                // Testing 180° rotation
                // Must be 90° rotation on almost any axis that is on the XZ plane
                val xz90rot = id.slerp(-y90rot, .5f)
                val xz90angle = xz90rot.angle() // Must be PI/4 = 0.78
                epsilonEqual(xz90angle, PIf * .25f, epsilon) shouldBe true

                // Testing almost equal quaternions (this test should pass through the linear interpolation)
                // Must be 0 0.00X 0 0.99999
                val almostid = id.slerp(angleAxis(.1f, Vec3(0f, 1f, 0f)), .5f, Quat())
                all(epsilonEqual(almostid, Quat(.99968f, 0.f, .02499f, 0f), epsilon)) shouldBe true

                // Testing quaternions with opposite sign
                run {

                    val a = Quat(-1, 0, 0, 0)

                    val result = a.slerp(id, .5f)

                    val b = id dot result
                    val c = pow(id dot result, 2f)
                    epsilonEqual(pow(id dot result, 2f), 1f, .01f) shouldBe true
                }
            }

            "quat times" {

                val temp1 = Quat(1f, Vec3(0, 1, 0)).normalize()
                val temp2 = Quat(.5f, Vec3(1, 0, 0)).normalize()

                val transformed0 = temp1 * Vec3(0, 1, 0) * temp1.inverse()
            }

            /**
             *  gtx_quaternion
             */

            "quat fastMix" {

                val A = angleAxis(0f, Vec3(0, 0, 1))
                val B = angleAxis(PIf * 0.5f, Vec3(0, 0, 1))
                val C = fastMix(A, B, 0.5f)
                val D = angleAxis(PIf * 0.25f, Vec3(0, 0, 1))

                epsilonEqual(C.x, D.x, 0.01f) shouldBe true
                epsilonEqual(C.y, D.y, 0.01f) shouldBe true
                epsilonEqual(C.z, D.z, 0.01f) shouldBe true
                epsilonEqual(C.w, D.w, 0.01f) shouldBe true
            }

            "quat shortMix" {

                val A = angleAxis(0f, Vec3(0, 0, 1))
                val B = angleAxis(PIf * 0.5f, Vec3(0, 0, 1))
                val C = shortMix(A, B, 0.5f)
                val D = angleAxis(PIf * 0.25f, Vec3(0, 0, 1))

                epsilonEqual(C.x, D.x, 0.01f) shouldBe true
                epsilonEqual(C.y, D.y, 0.01f) shouldBe true
                epsilonEqual(C.z, D.z, 0.01f) shouldBe true
                epsilonEqual(C.w, D.w, 0.01f) shouldBe true
            }

            "orientation" {

                run {
                    val q = Quat(1f, 0f, 0f, 1f)
                    val p = roll(q)
                    epsilonEqual(p, PIf * 0.5f, 0.0001f) shouldBe true
                }

                run {
                    val q = Quat(1f, 0f, 0f, 1f)
                    val p = pitch(q)
                    epsilonEqual(p, 0f, 0.0001f) shouldBe true
                }

                run {
                    val q = Quat(1f, 0f, 0f, 1f)
                    val p = yaw(q)
                    epsilonEqual(p, 0f, 0.0001f) shouldBe true
                }
            }

            "rotation" {

                val v = Vec3(1, 0, 0)
                val u = Vec3(0, 1, 0)

                val rotation = rotation(v, u)

                val angle = angle(rotation)

                (abs(angle - PIf * 0.5f) < epsilonF) shouldBe true
            }

            "log" {

                val q = Quat()
                val p = log(q)
                val r = exp(p)
            }

            "quat lookAt" {

                val eye = Vec3(0f)
                val center = Vec3(1.1f, -2f, 3.1416f)
                val up = Vec3(-0.17f, 7.23f, -1.744f)

                // Test left-handed implementation
                val testQuatLH = quatLookAtLH(normalize(center - eye), up)
                val testMatLH = conjugate(quat_cast(lookAtLh(Mat4(), eye, center, up)))
                (abs(length(testQuatLH) - 1f) > epsilonF) shouldBe false
                (min(length(testQuatLH - testMatLH), length(testQuatLH + testMatLH)) > epsilonF) shouldBe false

                // Test right-handed implementation
                val testQuatRH = quatLookAtRH(normalize(center - eye), up)
                val testMatRH = conjugate(quat_cast(lookAtRh(Mat4(), eye, center, up)))
                (abs(length(testQuatRH) - 1f) > epsilonF) shouldBe false
                (min(length(testQuatRH - testMatRH), length(testQuatRH + testMatRH)) > epsilonF) shouldBe false
            }
        }
    }
}