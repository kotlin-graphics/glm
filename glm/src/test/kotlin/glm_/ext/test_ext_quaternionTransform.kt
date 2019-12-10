package glm_.ext

import glm_.glm
import glm_.vec3.Vec3
import io.kotlintest.matchers.floats.shouldNotBeGreaterThan
import io.kotlintest.specs.StringSpec

class test_ext_quaternionTransform : StringSpec() {

    init {
        "lookAt" {

            val eye = Vec3(0f)
            val center = Vec3(1.1f, -2f, 3.1416f)
            val up = Vec3(-0.17f, 7.23f, -1.744f)

            val testQuat = glm.quatLookAt(glm.normalize(center - eye), up)
            val testMat = glm.conjugate(glm.quat_cast(glm.lookAt(eye, center, up)))

            glm.abs(glm.length(testQuat) - 1f) shouldNotBeGreaterThan glm.εf
            glm.min(glm.length(testQuat + (-testMat)), glm.length(testQuat + testMat)) shouldNotBeGreaterThan glm.εf

             // Test left-handed implementation
            val testQuatLH = glm.quatLookAtLH(glm.normalize(center - eye), up)
            val testMatLH = glm.conjugate(glm.quat_cast(glm.lookAtLH(eye, center, up)))
            glm.abs(glm.length(testQuatLH) - 1f) shouldNotBeGreaterThan glm.εf
            glm.min(glm.length(testQuatLH - testMatLH), glm.length(testQuatLH + testMatLH)) shouldNotBeGreaterThan glm.εf

             // Test right-handed implementation
            val testQuatRH = glm.quatLookAtRH(glm.normalize(center - eye), up)
            val testMatRH = glm.conjugate(glm.quat_cast(glm.lookAtRH(eye, center, up)))
            glm.abs(glm.length(testQuatRH) - 1f) shouldNotBeGreaterThan glm.εf
            glm.min(glm.length(testQuatRH - testMatRH), glm.length(testQuatRH + testMatRH)) shouldNotBeGreaterThan glm.εf
        }
    }
}