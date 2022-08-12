package kotlintest.basicsyntaxII

fun main() {

    println(maxOf(1, 2))

}

fun maxOf(a: Int, b: Int): Int {
    if (a > b) {
        return a
    } else {
        return b
    }
}

//In Kotlin, if can also be used as an expression.
fun maxOfII(a: Int,b: Int) = if (a>b) a else b
