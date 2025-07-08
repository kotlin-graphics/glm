import magik.github
import java.util.*

plugins {
    kotlin("jvm") version "2.2.0"
    id("elect86.magik") version "0.3.2"
    id("org.danilopianini.publish-on-central") version "9.0.7"
    signing
//    id("com.github.johnrengelman.shadow") version "8.1.1"
}

enum class MavenRepository(val group: String) {
    MARY("kotlin.graphics"),
    CENTRAL("io.github.kotlin-graphics"),
    ;
}

val repository = System.getenv("MAVEN_REPOSITORY")?.takeIf { it.isNotBlank() }?.let { MavenRepository.valueOf(it) } ?: MavenRepository.MARY


repositories {
    mavenCentral()
    if (repository == MavenRepository.MARY) {
        github("kotlin-graphics/mary")
    }
}

dependencies {
    compileOnly(repository.group, "kotlin-unsigned", "3.3.32")
    compileOnly(repository.group, "kool", "0.9.79")

    compileOnly("org.lwjgl:lwjgl-jemalloc:3.3.2")


    testImplementation("io.kotest:kotest-runner-junit5:5.6.2")
    testImplementation("io.kotest:kotest-assertions-core:5.6.2")

    testImplementation(repository.group, "kool", "0.9.79")
    testImplementation(repository.group, "kotlin-unsigned", "3.3.32")
}

kotlin.jvmToolchain { languageVersion.set(JavaLanguageVersion.of(8)) }

tasks {
    test { useJUnitPlatform() }
}


java {
    withJavadocJar()
    withSourcesJar()
}

configure<PublishingExtension> {
    publications {
        withType<MavenPublication> {
            groupId = MavenRepository.CENTRAL.group
            artifactId = "glm"
            versionMapping {
                usage("java-api") {
                    fromResolutionOf("runtimeClasspath")
                }
                usage("java-runtime") {
                    fromResolutionResult()
                }
            }
            pom {
                name.set("glm")
                description.set("Kotlin port of OpenGL Mathematics (GLM)")
                url.set("https://github.com/kotlin-graphics/glm")
                licenses {
                    license {
                        name.set("MIT")
                        url.set("https://choosealicense.com/licenses/mit/")
                    }
                }
                developers {
                    developer {
                        id.set("elect86")
                        name.set("Giuseppe Barbieri")
                        email.set("elect86@gmail.com")
                    }
                    developer {
                        id.set("bixilon")
                        name.set("Moritz Zwerger")
                        email.set("bixilon@bixilon.de")
                    }
                }
                scm {
                    connection.set("scm:git:https://github.com/kotlin-graphics/glm.git")
                    developerConnection.set("scm:git:ssh://git@github.com:kotlin-graphics/glm.git")
                    url.set("https://github.com/kotlin-graphics/glm")
                }
            }
        }
    }
}

signing {
    val keyId = project.properties["SIGNING_KEY_ID"]?.toString()
    val rawKey = project.properties["SIGNING_KEY"]?.toString()
    if (keyId == null || rawKey == null) {
        return@signing println("No signing key is set!")
    }

    val key = String(Base64.getDecoder().decode(rawKey)) // \n is not working in environment variables
    val password = project.properties["SIGNING_KEY_PASSWORD"]?.toString() ?: ""
    useInMemoryPgpKeys(keyId, key, password)
    sign(publishing.publications["OSSRH"])
}
