import org.gradle.api.JavaVersion

apply{
    plugin("java")
    plugin("kotlin")
    plugin("maven")
}

buildscript {

    repositories {
        gradleScriptKotlin()
    }

    dependencies {
        classpath(kotlinModule("gradle-plugin", "1.1.0"))
    }
}

//configure<JavaPluginConvention> {
//    sourceCompatibility = JavaVersion.VERSION_1_8
//    targetCompatibility = JavaVersion.VERSION_1_8
//}

repositories {
    gradleScriptKotlin()
}

dependencies {
    compile(kotlinModule("stdlib", "1.1.0"))
    testCompile("com.github.elect86:kotlintest:d8878d6da0944ec6bcbcdad6a1540bba021d768d")
    compile("com.github.elect86:kotlin-unsigned:v2.0")
}

allprojects {
    repositories {
        maven { setUrl("https://jitpack.io") }
    }
}