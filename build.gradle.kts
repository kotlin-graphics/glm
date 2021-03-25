import kx.LwjglModules.*
import kx.KxProject.*
import kx.kxImplementation
import kx.lwjglImplementation

plugins {
    val build = "0.7.0+79"
    id("kx.kotlin.11") version build
    id("kx.lwjgl") version build
    id("kx.dokka") version build
    id("kx.publish") version build
    java
}

version = "0.9.9.1-3+23"

repositories {
    maven("https://raw.githubusercontent.com/kotlin-graphics/mary/master")
}

dependencies {

    kxImplementation(unsigned, kool)

    lwjglImplementation(glfw, jemalloc, openal, opengl, stb)
}