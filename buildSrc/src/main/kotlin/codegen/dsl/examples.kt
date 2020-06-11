package codegen.dsl

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FunSpec

/*
    Here’s a HelloWorld file:

    class Greeter(val name: String) {
        fun greet() {
            println("""Hello, $name""")
        }
    }

    fun main(vararg args: String) {
        Greeter(args[0]).greet()
    }
*/

fun example1() =
        cd("examples", touch = "Greeter") {
            val greeterClass = Clazz("Greeter")(`val`("name").String) {
                fn("greet") {
                    "println(%P)"("Hello, \$name")
                }
            }
            main(vararg("args".String)) {
                "%T(args[0]).greet()"(greeterClass)
            }
        }


/*
    val main = FunSpec.builder("main")
        .addCode("""
            |var total = 0
            |for (i in 0 until 10) {
            |    total += i
            |}
            |""".trimMargin())
        .build()
 */

fun example2() =
        cd("examples", touch = "Example2") {
            main {
                code("""
                    |var total = 0
                    |for (i in 0 until 10) {
                    |    total += i
                    |}
                    |""".trimMargin())
            }
        }

fun example3() =
        cd("examples", touch = "Example3") {
            main {
                stm("var total = 0")
                "for (i in 0 until 10)" {
                    stm("total += i")
                }
            }
        }

fun example4() =
        cd("examples", touch = "Example4") {
            val from = 10
            val to = 20
            val op = "*"
            fn("multiply10to20").Int {
                stm("var result = 1")
                "for (i in $from until $to)" {
                    stm("result = result $op i")
                }
                stm("return result")
            }
        }

fun example5() =
        cd("examples", touch = "Example5") {

            fun whatsMyNameYo(name: String) =
                    fn(name).String `=` "return %S"(name)

            Clazz("HelloWorld") {
                whatsMyNameYo("slimShady")
                whatsMyNameYo("eminem")
                whatsMyNameYo("marshallMathers")
            }
        }

fun example6() =
        cd("examples", touch = "Example6") {
            val stringWithADollar = "Your total is " + "$" + "50"
            fn("printTotal").String `=` "return %S"(stringWithADollar)
            `val`("amount") `=` 50
            val stringWithADollar2 = "Your total is " + "$" + "amount"
            fn("printTotal2").String `=` "return %P"(stringWithADollar2)
        }