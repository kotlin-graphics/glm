group = "groupId"
version = "1.0-SNAPSHOT"

buildscript {

    repositories {
        gradleScriptKotlin()
        maven { setUrl("http://dl.bintray.com/kotlin/kotlin-eap-1.1") }
        mavenCentral()
    }

    dependencies {
        classpath(kotlinModule("gradle-plugin"))
    }
}

apply {
    plugin("kotlin")
}

//configure<ApplicationPluginConvention> {
//    mainClassName = "samples.HelloWorldKt"
//}

repositories {
    gradleScriptKotlin()
    maven { setUrl("http://dl.bintray.com/kotlin/kotlin-eap-1.1") }
}

dependencies {
    compile(kotlinModule("stdlib"))
    testCompile("io.kotlintest:kotlintest:1.3.5")
    compile("com.github.elect86:kotlin-unsigned:master-SNAPSHOT")
}

allprojects {
    repositories {
        maven { setUrl("https://jitpack.io") }
    }
}