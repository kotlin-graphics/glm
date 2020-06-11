package codegen.dsl

import codegen.KotlinPoetDsl
import com.squareup.kotlinpoet.*


@KotlinPoetDsl
fun FileSpec.Builder.fn(
        name: String,
        block: FunSpec.Builder.() -> Unit = {}
): FunSpec {
    return FunSpec.builder(name)
            .apply(block)
            .build()
            .also { addFunction(it) }
}
@KotlinPoetDsl
inline fun TypeSpec.Builder.`val`(
        name: String,
        type: TypeName,
        initializer: String? = null,
        block: PropertySpec.Builder.() -> Unit = {}
): PropertySpec = PropertySpec.builder(name, type)
        .apply(block)
        .apply { initializer?.let(::initializer) }
        .build()
        .also { addProperty(it) }


@KotlinPoetDsl
inline fun TypeSpec.Builder.`private val`(
        name: String,
        type: TypeName,
        initializer: String? = null,
        block: PropertySpec.Builder.() -> Unit = {}
): PropertySpec = PropertySpec.builder(name, type, KModifier.PRIVATE)
        .apply(block)
        .apply { initializer?.let(::initializer) }
        .build()
        .also { addProperty(it) }