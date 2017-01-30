// Required Gradle 3.3

buildscript {

    repositories {
        gradleScriptKotlin()
    }

    dependencies {
        classpath(kotlinModule("gradle-plugin", "1.1-M04"))
    }
}

apply {
    plugin("kotlin")
    plugin("maven")
}

repositories {
    gradleScriptKotlin()
}

dependencies {
    compile(kotlinModule("stdlib", "1.1-M04"))
    testCompile("io.kotlintest:kotlintest:1.3.5")
    compile("com.github.elect86:kotlin-unsigned:eb2fe2011a")
}

allprojects {
    repositories {
        maven { setUrl("https://jitpack.io") }
    }
}