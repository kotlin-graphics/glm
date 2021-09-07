import kx.KxProject.kool
import kx.KxProject.unsigned
import kx.Lwjgl
import kx.Lwjgl.Modules.*
import kx.implementation

plugins {
    val build = "0.7.3+41"
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