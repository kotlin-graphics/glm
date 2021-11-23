package main

import com.google.devtools.ksp.processing.*
import com.google.devtools.ksp.symbol.*

class Processor(private val codeGenerator: CodeGenerator,
                private val logger: KSPLogger,
                private val options: Map<String, String>) : SymbolProcessor {
    var invoked = false

    override fun process(resolver: Resolver): List<KSAnnotated> {

        logger.warn(resolver.getAllFiles().map { it.fileName }.toString())

        if (invoked) {
            return emptyList()
        }
        invoked = true

        //        codeGenerator.createNewFile(Dependencies(false), "", "Foo", "kt").use { output ->
        //            OutputStreamWriter(output).use { writer ->
        //                writer.write("package com.example\n\n")
        //                writer.write("class Foo {\n")
        //
        //                val visitor = ClassVisitor()
        //                resolver.getAllFiles().forEach {
        //                    it.accept(visitor, writer)
        //                }
        //
        //                writer.write("}\n")
        //            }
        //        }

        vecs(codeGenerator)

        return emptyList()
    }
}


class ProcessorProvider : SymbolProcessorProvider {

    override fun create(environment: SymbolProcessorEnvironment): SymbolProcessor =
        Processor(environment.codeGenerator, environment.logger, environment.options)
}