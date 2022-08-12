package kotlintest.basicsyntaxII

class StringTemplates {

}

fun main() {
    val a = 1
    // simple name in template:
    val string1: String = "a is $a"
    println(string1)
    // arbitrary expression in template:
    val string2: String = "${string1.replace("is","was")}, but now is $a"
    println(string2)

}