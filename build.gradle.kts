import kx.*
import org.lwjgl.Lwjgl
import org.lwjgl.Lwjgl.Module.*

plugins {
    fun kx(vararg p: Pair<String, String>) = p.forEach { id("io.github.kotlin-graphics.${it.first}") version it.second }
    kx("align" to "0.0.7",
       "base" to "0.0.10",
       "publish" to "0.0.6",
       "utils" to "0.0.5")
    id("org.lwjgl.plugin") version "0.0.20"
}

dependencies {
    implementation(unsigned, kool)
    Lwjgl { implementation(glfw, jemalloc, openal, opengl, stb) }
}