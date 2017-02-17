import org.gradle.api.JavaVersion

apply{
    plugin("java")
}

buildscript {

    repositories {
        gradleScriptKotlin()
    }

    dependencies {
        classpath(kotlinModule("gradle-plugin", "1.1.0-rc-91"))
    }
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

apply {
    plugin("kotlin")
    plugin("maven")
}

repositories {
    gradleScriptKotlin()
}

dependencies {
    compile(kotlinModule("stdlib", "1.1.0-rc-91"))
    testCompile("io.kotlintest:kotlintest:1.3.6")
    compile("com.github.elect86:kotlin-unsigned:a18c7c53c74c0fa0f8e4962b36b76f5a2dfee48b")
}

allprojects {
    repositories {
        maven { setUrl("https://jitpack.io") }
    }
}