![glm](/src/main/resources/logo-mini.png)

This is the Kotlin port of the original [OpenGL Mathematics](http://glm.g-truc.net/) (*GLM*), a header only C++ mathematics library for graphics software based on the [OpenGL Shading Language (GLSL) specifications](https://www.opengl.org/registry/doc/GLSLangSpec.4.50.diff.pdf).

*GLM* provides classes and functions designed and implemented with the same naming conventions and functionality than *GLSL* so that anyone who knows *GLSL*, can use *GLM* as well in Kotlin and Java.

This project isn't limited to *GLSL* features. An extension system, based on the *GLSL* extension conventions, provides extended capabilities: matrix transformations, quaternions, data packing, random numbers, noise, etc...

This library works perfectly with *[OpenGL](https://www.opengl.org)* but it also ensures interoperability with other third party libraries and SDK. It is a good candidate for software rendering (raytracing / rasterisation), image processing, physic simulations and any development context that requires a simple and convenient mathematics library.

*GLM* is written entirely in Kotlin, but can be also used from Java. It is a platform independent library with no dependences other than [kotlin-unsigned](https://github.com/elect86/kotlin-unsigned) for unsigned support and [kotlin-test](https://github.com/kotlintest/kotlintest) for testing.

For more information about *GLM*, please have a look at the [manual](https://github.com/kotlin-graphics/glm/wiki/Manual) and the original [API reference documentation](http://glm.g-truc.net/0.9.8/api/index.html).
The source code and the documentation are licensed under both the [Happy Bunny License (Modified MIT) or the MIT License](https://github.com/kotlin-graphics/glm/wiki/Manual#section0).

Don't hesitate to contribute to the project by submitting [issues](https://github.com/kotlin-graphics/glm/issues) or [pull requests](https://github.com/kotlin-graphics/glm/pulls) for bugs and features. Any feedback is welcome at [elect86@gmail.com](mailto://elect86@gmail.com).

```kotlin
import glm.vec2.Vec2
import glm.vec3.Vec3
import glm.mat4x4.Mat4
import glm.glm

fun camera(translate: Float, rotate: Vec2): Mat4 {

    val projection = glm.perspective(glm.PIf * 0.25f, 4.0f / 3.0f, 0.1f, 100.f)
    var view = glm.translate(Mat4(1.0f), Vec3(0.0f, 0.0f, -translate))
    view = glm.rotate(view, rotate.y, Vec3(-1.0f, 0.0f, 0.0f))
    view = glm.rotate(view, rotate.x, Vec3(0.0f, 1.0f, 0.0f))
    val model = glm.scale(Mat4(1.0f), Vec3(0.5f))
    return projection * view * model
}
```

### Gradle:

- Add it in your root build.gradle at the end of repositories:

	    allprojects {
		    repositories {
			        ...
			        maven { url 'https://jitpack.io' }
		    }
	    }
    
- Add the dependency

	    dependencies {
	        compile 'com.github.kotlin-graphics:glm:0.01'
	    }


[Gradle, Maven, Sbt, Leiningen](https://jitpack.io/#kotlin-graphics/glm/0.01)



