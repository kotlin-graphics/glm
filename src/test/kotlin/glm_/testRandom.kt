package glm_

import glm_.vec2.Vec2ub
import io.kotlintest.specs.StringSpec

class testRandom : StringSpec() {

    val testSamples = 10_000

    init {

        "test_linearRand" {

            val (min, max) = 16 to 32

            run {
                var aMin = Vec2ub(255)
                var aMax = Vec2ub(0)
                run {
                    //                    for(i in 0 until testSamples)                    {
//
//                        val a = glm.linearRand(Vec2b(min), Vec2b(max))
//                        aMin = glm.min(aMin, a)
//                        aMax = glm.max(aMax, a)
//
//                        glm.all(glm.lessThanEqual(a, Vec2b(max))) shouldBe false
//                        glm.all(glm.greaterThanEqual(a, Vec2b(min))) shouldBe false
//                    }
//
//                    glm.all(glm.equal(aMin, Vec2b(min))) shouldBe true
//                    glm.all(glm.equal(aMax, Vec2b(max))) shouldBe true
                }

//                glm::u16vec2 BMin(std::numeric_limits<glm::u16>::max())
//                glm::u16vec2 BMax(std::numeric_limits<glm::u16>::min());
//                {
//                    for(std::size_t i = 0; i < TestSamples; ++i)
//                    {
//                        glm::u16vec2 B = glm::linearRand(glm::u16vec2(Min), glm::u16vec2(Max))
//                        BMin = glm::min(BMin, B)
//                        BMax = glm::max(BMax, B)
//
//                        if(!glm::all(glm::lessThanEqual(B, glm::u16vec2(Max))))
//                            ++Error
//                        if(!glm::all(glm::greaterThanEqual(B, glm::u16vec2(Min))))
//                            ++Error
//                        assert(!Error)
//                    }
//
//                    Error += glm::all(glm::equal(BMin, glm::u16vec2(Min))) ? 0 : 1
//                    Error += glm::all(glm::equal(BMax, glm::u16vec2(Max))) ? 0 : 1
//                    assert(!Error)
//                }
//
//                glm::u32vec2 CMin(std::numeric_limits<glm::u32>::max())
//                glm::u32vec2 CMax(std::numeric_limits<glm::u32>::min());
//                {
//                    for(std::size_t i = 0; i < TestSamples; ++i)
//                    {
//                        glm::u32vec2 C = glm::linearRand(glm::u32vec2(Min), glm::u32vec2(Max))
//                        CMin = glm::min(CMin, C)
//                        CMax = glm::max(CMax, C)
//
//                        if(!glm::all(glm::lessThanEqual(C, glm::u32vec2(Max))))
//                            ++Error
//                        if(!glm::all(glm::greaterThanEqual(C, glm::u32vec2(Min))))
//                            ++Error
//                        assert(!Error)
//                    }
//
//                    Error += glm::all(glm::equal(CMin, glm::u32vec2(Min))) ? 0 : 1
//                    Error += glm::all(glm::equal(CMax, glm::u32vec2(Max))) ? 0 : 1
//                    assert(!Error)
//                }
//
//                glm::u64vec2 DMin(std::numeric_limits<glm::u64>::max())
//                glm::u64vec2 DMax(std::numeric_limits<glm::u64>::min());
//                {
//                    for(std::size_t i = 0; i < TestSamples; ++i)
//                    {
//                        glm::u64vec2 D = glm::linearRand(glm::u64vec2(Min), glm::u64vec2(Max))
//                        DMin = glm::min(DMin, D)
//                        DMax = glm::max(DMax, D)
//
//                        if(!glm::all(glm::lessThanEqual(D, glm::u64vec2(Max))))
//                            ++Error
//                        if(!glm::all(glm::greaterThanEqual(D, glm::u64vec2(Min))))
//                            ++Error
//                        assert(!Error)
//                    }
//
//                    Error += glm::all(glm::equal(DMin, glm::u64vec2(Min))) ? 0 : 1
//                    Error += glm::all(glm::equal(DMax, glm::u64vec2(Max))) ? 0 : 1
//                    assert(!Error)
//                }
            }
        }
    }
}