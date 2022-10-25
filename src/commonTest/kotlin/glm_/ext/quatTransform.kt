package glm_.ext

import glm_.vec3.Vec3
import kotlin.test.Test

class quatTransform {

    @Test
    fun lookAt() {

        val eye = Vec3(0f)
        val center = Vec3(1.1f, -2f, 3.1416f)
        val up = Vec3(-0.17f, 7.23f, -1.744f)

        // TODO

//        val test_quat = glm::quatLookAt(glm::normalize(center - eye), up)
//        glm::quat test_mat = glm::conjugate(glm::quat_cast(glm::lookAt(eye, center, up)))
//
//        Error += static_cast<int>(glm::abs(glm::length(test_quat) - 1.0f) > glm::epsilon<float>())
//        Error += static_cast<int>(glm::min(glm::length(test_quat + (-test_mat)), glm::length(test_quat + test_mat)) > glm::epsilon<float>())
//
//        // Test left-handed implementation
//        glm::quat test_quatLH = glm::quatLookAtLH(glm::normalize(center - eye), up)
//        glm::quat test_matLH = glm::conjugate(glm::quat_cast(glm::lookAtLH(eye, center, up)))
//        Error += static_cast<int>(glm::abs(glm::length(test_quatLH) - 1.0f) > glm::epsilon<float>())
//        Error += static_cast<int>(glm::min(glm::length(test_quatLH - test_matLH), glm::length(test_quatLH + test_matLH)) > glm::epsilon<float>())
//
//        // Test right-handed implementation
//        glm::quat test_quatRH = glm::quatLookAtRH(glm::normalize(center - eye), up)
//        glm::quat test_matRH = glm::conjugate(glm::quat_cast(glm::lookAtRH(eye, center, up)))
//        Error += static_cast<int>(glm::abs(glm::length(test_quatRH) - 1.0f) > glm::epsilon<float>())
//        Error += static_cast<int>(glm::min(glm::length(test_quatRH - test_matRH), glm::length(test_quatRH + test_matRH)) > glm::epsilon<float>())
    }
}