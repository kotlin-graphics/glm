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
    testCompile("com.github.elect86:kotlintest:c4b7b397a0d182d1adaf61f71a9423c228dc0106")
    compile("com.github.elect86:kotlin-unsigned:606ec0ea2b11bc604647cc61280f01db399d7191")
}

allprojects {
    repositories {
        maven { setUrl("https://jitpack.io") }
    }
}