import kx.*
import kx.Lwjgl.Modules.*

plugins {
    val build = "0.7.3+52"
    id("kx.kotlin") version build
    //    id("kx.dokka") version build
    id("kx.publish") version build
    id("kx.dynamic-align") version build
    id("kx.util") version build
}

dependencies {

    implementation(unsigned, kool)

    Lwjgl { implementation(glfw, jemalloc, openal, opengl, stb) }
}