package main

import io.kotlintest.KTestJUnitRunner
import io.kotlintest.specs.StringSpec
import org.junit.runner.RunWith
import quat.Quat
import vec._3.Vec3

/**
 * Created by elect on 04/03/2017.
 */

@RunWith(KTestJUnitRunner::class)
class quaternion : StringSpec() {

    init {

        with(glm) {

            "quat angle" {

                run {

                    val q = Quat().angleAxis(pi.f * .25f, Vec3(0, 0, 1))
                    val n = q.normalize()
                    val l = n.length()

                    epsilonEqual(l, 1f, .01f) shouldBe true

                    val a = n.angle()

                    epsilonEqual(a, pi.f * .25f, .01f) shouldBe true
                }

                run {

                    val q = Quat().angleAxis(pi.f * .25f, Vec3(0, 1, 1).normalize())
                    val n = q.normalize()
                    val l = n.length()

                    epsilonEqual(l, 1f, .01f) shouldBe true

                    val a = n.angle()

                    epsilonEqual(a, pi.f * .25f, .01f) shouldBe true
                }

                run {

                    val q = Quat().angleAxis(pi.f * .25f, Vec3(1, 2, 3).normalize())
                    val n = q.normalize()
                    val l = n.length()

                    epsilonEqual(l, 1f, .01f) shouldBe true

                    val a = n.angle()

                    epsilonEqual(a, pi.f * .25f, .01f) shouldBe true
                }
            }

            "quat axis" {

                val a = Quat().angleAxis(0f, Vec3(0, 0, 1))
                val b = Quat().angleAxis(pi.f * .5f, Vec3(0, 0, 1))
                val c = glm.mix(Quat(), a, b, .5f)
                val d = Quat().angleAxis(pi.f * .25f, Vec3(0, 0, 1))

                all(epsilonEqual(c, d, .01f)) shouldBe true
            }

            "quat mix" {

                val a = Quat().angleAxis(0f, Vec3(0, 0, 1))
                val b = Quat().angleAxis(pi.f * .5f, Vec3(0, 0, 1))
                val c = glm.mix(Quat(), a, b, .5f)
                val d = Quat().angleAxis(pi.f * .25f, Vec3(0, 0, 1))

                all(epsilonEqual(c, d, .01f)) shouldBe true
            }

            "quat normalize" {

                run {
                    val q = Quat().angleAxis(pi.f * .25f, Vec3(0, 0, 1))
                    val n = q.normalize()
                    val l = n.length()

                    epsilonEqual(l, 1f, .000001f) shouldBe true
                }
                run {
                    val q = Quat().angleAxis(pi.f * .25f, Vec3(0, 0, 2))
                    val n = q.normalize()
                    val l = n.length()

                    epsilonEqual(l, 1f, .000001f) shouldBe true
                }
                run {
                    val q = Quat().angleAxis(pi.f * .25f, Vec3(1, 2, 3))
                    val n = q.normalize()
                    val l = n.length()

                    epsilonEqual(l, 1f, .000001f) shouldBe true
                }
            }

            "quat eurler" {

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
                val y180rot = Quat(0f, 0f, 1f, 0f)

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
                epsilonEqual(y45angle3, pi.f * .25f, epsilon) shouldBe true
//                all(epsilonEqual(ym45rot2, y45rot3, epsilon)) shouldBe true
//
//                // Same, but inverted
//                // Must also be 45° rotation on Y :  0 0.38 0 0.92
//                // -0 -0.38 -0 -0.92 is ok too
//                glm::quat Y45rot4 = glm::slerp(-Y90rot, id, 0.5f);
//                Error += glm::all(glm::epsilonEqual(Ym45rot2, -Y45rot4, Epsilon)) ? 0 : 1;
//
//                // Testing q1 = q2
//                // Must be 90° rotation on Y : 0 0.7 0 0.7
//                glm::quat Y90rot3 = glm::slerp(Y90rot, Y90rot, 0.5f);
//                Error += glm::all(glm::epsilonEqual(Y90rot, Y90rot3, Epsilon)) ? 0 : 1;
//
//                // Testing 180° rotation
//                // Must be 90° rotation on almost any axis that is on the XZ plane
//                glm::quat XZ90rot = glm::slerp(id, -Y90rot, 0.5f);
//                float XZ90angle = glm::angle(XZ90rot); // Must be PI/4 = 0.78;
//                Error += glm::epsilonEqual(XZ90angle, glm::pi<float>() * 0.25f, Epsilon) ? 0 : 1;
//
//                // Testing almost equal quaternions (this test should pass through the linear interpolation)
//                // Must be 0 0.00X 0 0.99999
//                glm::quat almostid = glm::slerp(id, glm::angleAxis(0.1f, glm::vec3(0.0f, 1.0f, 0.0f)), 0.5f);
            }
        }
    }
}