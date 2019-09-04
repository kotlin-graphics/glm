package glm_.ext

import glm_.glm
import glm_.mat4x4.Mat4
import glm_.mat4x4.Mat4x4t
import glm_.vec4.Vec4
import io.kotlintest.matchers.numerics.shouldBeExactly
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class test_extMatrixRelational : StringSpec() {

    init {
//        int test_equal()
//        {
//            int Error = 0;
//
//            Error += glm::all(glm::equal(glm::mat4x3(1), glm::mat4x3(1), 0.001f)) ? 0 : 1;
//            Error += glm::all(glm::equal(glm::mat4x3(1), glm::mat4x3(2), glm::vec4(0.001f))) ? 1 : 0;
//
//            return Error;
//        }
//
//        int test_notEqual()
//        {
//            int Error = 0;
//
//            Error += !glm::any(glm::notEqual(glm::mat4x3(1), glm::mat4x3(1), 0.001f)) ? 0 : 1;
//            Error += !glm::any(glm::notEqual(glm::mat4x3(1), glm::mat4x3(2), glm::vec4(0.001f))) ? 1 : 0;
//
//            return Error;
//        }
//

        "test equal"        {

            (Mat4(1).equal(Mat4(1),  0.001f)) shouldBe true
            (Mat4(1).equal(Mat4(2), Vec4(0.001f))).all shouldBe false
        }

        "test notEqual"        {

            (Mat4(1).equal(Mat4(1), 0.001f)) shouldBe true
            (Mat4(1).equal(Mat4(2), Vec4(0.001f))).all shouldBe false
        }
    }
}