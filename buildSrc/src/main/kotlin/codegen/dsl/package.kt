package codegen.dsl

import codegen.KotlinPoetDsl
import com.squareup.kotlinpoet.*
import java.util.*
import kotlin.collections.ArrayList
import kotlin.reflect.KClass


@KotlinPoetDsl
abstract class Assign {
    abstract val type: TypeName
    var initializer: String? = null
}

@KotlinPoetDsl
class Floats(size: Int) : Assign() {
    override val type: ClassName
        get() = FLOAT_ARRAY

    init {
        initializer = "FloatArray($size)"
    }
}

@KotlinPoetDsl
abstract class Prop(
        val name: String,
        val clazz: KClass<*>,
        val modifiers: ArrayList<KModifier> = arrayListOf()
) {

    abstract val mutable: Boolean
    infix fun `=`(assign: Assign) {
        val propBuilder = PropertySpec
                .builder(name, assign.type, modifiers)
                .mutable(mutable)
        assign.initializer?.let(propBuilder::initializer)
    }
}

@KotlinPoetDsl
class ValBase(val name: String, val modifiers: ArrayList<KModifier> = arrayListOf()) {

    val String: Val
        get() = Val(name, kotlin.String::class, modifiers)
}

@KotlinPoetDsl
class Val(name: String, clazz: KClass<*>, modifiers: ArrayList<KModifier> = arrayListOf()) :
        Prop(name, clazz, modifiers) {

    override val mutable: Boolean
        get() = false

//    constructor(param: Param) : this(param.name) {
//        clazz = param.clazz
//    }
}

@KotlinPoetDsl
class Var(name: String, clazz: KClass<*>, modifiers: ArrayList<KModifier> = arrayListOf()) :
        Prop(name, clazz, modifiers) {

    override val mutable: Boolean
        get() = true

//    constructor(param: Param) : this(param.name) {
//        clazz = param.clazz
//    }
}

//class VarArg(name: String, clazz: KClass<*>, modifiers: ArrayList<KModifier> = arrayListOf()) :
//        Prop(name, clazz, modifiers) {
//
//    override val mutable: Boolean
//        get() = false
//
//    constructor(param: Param) : this(param.name) {
//        clazz = param.clazz
//    }
//}

@KotlinPoetDsl
class FnRet(val clazz: KClass<*>? = null) : Fn() {

    // same as invoke without block()
    infix fun `=`(any: Any) {
        clazz?.let(funBuilder::returns)
        val fb = funBuilder.build()
        typeStack.pop()
        if (typeStack.last() == Type.file)
            fileBuilder.addFunction(fb)
        else
            classBuilder.addFunction(fb)
    }

    operator fun invoke(block: Fn.() -> Unit) {
        clazz?.let(funBuilder::returns)
        block()
        val fb = funBuilder.build()
        typeStack.pop()
        if (typeStack.last() == Type.file)
            fileBuilder.addFunction(fb)
        else
            classBuilder.addFunction(fb)
    }
}

@KotlinPoetDsl
class FnArg : Fn() {

    fun ret(clazz: KClass<*>) = FnRet(clazz)

    val Int: FnRet
        get() = FnRet(kotlin.Int::class)

    val String: FnRet
        get() = FnRet(kotlin.String::class)

    operator fun invoke(block: Fn.() -> Unit) = FnRet()(block)
}

@KotlinPoetDsl
open class Fn {

    fun code(code: String) = funBuilder.addCode(code)
    fun stm(statement: String) = funBuilder.addStatement(statement)

    // same as class KtFile
    fun stm(statement: String, vararg args: Any) = funBuilder.addStatement(statement, *args)
    operator fun String.invoke(block: () -> Unit) {
        funBuilder.beginControlFlow(this)
        block()
        funBuilder.endControlFlow()
    }

    operator fun String.invoke(vararg args_: Any) {
        val args = Array(args_.size) {
            when (val arg = args_[it]) {
                is Clazz -> ClassName(arg.dir, arg.name)
                else -> arg
            }
        }
        stm(this, *args)
    }

    operator fun invoke(vararg args: Any): FnArg {
        for (arg in args)
            TODO()
        return FnArg()
    }
}

@KotlinPoetDsl
class Clazz(val name: String, val dir: String) {

    fun `val`(name: String) = Val(name)

    init {
        classBuilder = TypeSpec.classBuilder(name)
        typeStack += Type.clazz
    }

    fun fn(name: String, block: Fn.() -> Unit) {
        funBuilder = FunSpec.builder(name)
        typeStack += Type.func
        Fn().block()
        classBuilder.addFunction(funBuilder.build())
        assert(typeStack.pop() == Type.func) { "Clazz::fn failed" }
    }

    operator fun invoke(vararg params: Any, block: Clazz.() -> Unit): Clazz {
        constructorBuilder = FunSpec.constructorBuilder()

        val props = ArrayList<PropertySpec>()
        for (param in params)
            when (param) {
                is Param -> TODO()
                is Prop -> {
                    constructorBuilder.addParameter(param.name, param.clazz!!)
                    props += PropertySpec
                            .builder(param.name, param.clazz!!)
                            .initializer(param.name)
                            .build()
                }
            }
        classBuilder.primaryConstructor(constructorBuilder.build())
        for (prop in props)
            classBuilder.addProperty(prop)

        block()

        fileBuilder.addType(classBuilder.build())
        assert(typeStack.pop() == Type.clazz) { "Clazz::invoke failed" }
        return this
    }
}

@KotlinPoetDsl
class Param(val name: String, val clazz: KClass<*>)

//class Constructor(vararg val params: Any) {
//    val props = ArrayList<Prop>()
//    operator fun invoke(): FunSpec {
//        funBuilder = FunSpec.constructorBuilder()
////        for (param in params)
////            funBuilder.addParameter(param.name, param.clazz)
//        return funBuilder.build()
//    }
//}

@KotlinPoetDsl
class KtFile(val dir: String, val name: String) {

    fun `val`(name: String) = ValBase(name)
//    fun vararg(param: Param) = VarArg(param)


    fun Clazz(name: String) = Clazz(name, dir)

    fun Clazz(name: String, block: Clazz.() -> Unit) {
        Clazz(name).block()
        fileBuilder.addType(classBuilder.build())
        assert(typeStack.pop() == Type.clazz) { "Clazz failed" }
    }

    fun main(block: Fn.() -> Unit) {
        funBuilder = FunSpec.builder("main")
        typeStack += Type.func
        Fn().block()
        fileBuilder.addFunction(funBuilder.build())
        assert(typeStack.pop() == Type.func) { "main failed" }
    }

    fun main(vararg args: Any, block: Fn.() -> Unit) {
        funBuilder = FunSpec.builder("main")
        typeStack += Type.func
        for (arg in args)
            when (arg) {
                is VarArg -> funBuilder.addParameter(arg.name, arg.clazz!!, KModifier.VARARG)
            }
        Fn().block()
        fileBuilder.addFunction(funBuilder.build())
        assert(typeStack.pop() == Type.func) { "main vararg failed" }
    }

    fun maina(block: Fn.() -> Unit) {
        funBuilder = FunSpec.builder("main")
        typeStack += Type.func
        Fn().block()
        fileBuilder.addFunction(funBuilder.build())
        assert(typeStack.pop() == Type.func) { "maina failed" }
    }

    fun fn(name: String): FnArg {
        funBuilder = FunSpec.builder(name)
        typeStack += Type.func
        return FnArg()
    }

//    fun fn(name: String, block: Fn.() -> Unit) {
//        funBuilder = FunSpec.builder(name)
//        FnArg(top = true)(block)
//    }

    val String.String: Param
        get() = Param(this, kotlin.String::class)

    // same as class Fn
    fun stm(statement: String, vararg args: Any) = funBuilder.addStatement(statement, *args)
    operator fun String.invoke(block: () -> Unit) {
        funBuilder.beginControlFlow(this)
        block()
        funBuilder.endControlFlow()
    }

    operator fun String.invoke(vararg args_: Any) {
        val args = Array(args_.size) {
            when (val arg = args_[it]) {
                is Clazz -> ClassName("", arg.name)
                else -> arg
            }
        }
        stm(this, *args)
    }
}

@KotlinPoetDsl
class Package(val dir: String) {

    fun touch(file: String, block: KtFile.() -> Unit): FileSpec =
            touch(dir, file, block)
}

fun cd(dir: String, block: Package.() -> Unit) = Package(dir).block()

fun cd(dir: String, touch: String, block: KtFile.() -> Unit) =
        Package(dir).touch(touch, block)

fun touch(file: String, block: KtFile.() -> Unit): FileSpec =
        touch("", file, block)

fun touch(dir: String, file: String, block: KtFile.() -> Unit): FileSpec {
    fileBuilder = FileSpec.builder(dir, file)
    typeStack += Type.file
    KtFile(dir, file).block()
    return fileBuilder.build().also {
        assert(typeStack.pop() == Type.file) { "touch failed" }
    }
}

lateinit var fileBuilder: FileSpec.Builder
lateinit var classBuilder: TypeSpec.Builder
lateinit var constructorBuilder: FunSpec.Builder
lateinit var funBuilder: FunSpec.Builder

enum class Type { file, clazz, func }

val typeStack = Stack<Type>()