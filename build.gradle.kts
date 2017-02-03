// Required Gradle 3.3

buildscript {

    repositories {
        gradleScriptKotlin()
    }

    dependencies {
        classpath(kotlinModule("gradle-plugin", "1.1.0-beta-38"))
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
    compile(kotlinModule("stdlib", "1.1.0-beta-38"))
    testCompile("io.kotlintest:kotlintest:1.3.5")
    compile("com.github.elect86:kotlin-unsigned:f15009c794")
}

allprojects {
    repositories {
        maven { setUrl("https://jitpack.io") }
    }
}