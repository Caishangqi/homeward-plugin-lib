package kotlintest.basicsyntax

class Syntax {

}

fun main() {
    println("???")
    print(sum(1, 2))
}

fun sum(a: Int, b: Int): Int {
    return a + b
}

//Simple
fun sumSimple(a: Int, b: Int) = a + b

//No meaningful
fun printSum(a: Int, b: Int): Unit { //Can be noglate
    println(a + b)
}

//Variables
val a: Int = 1; //with immediate assignment


