package kotlintest.basicsyntaxII

fun main() {

    val items = listOf("a", "b", "c")
    for (item in items) {
        println(item)
    }

    val items2 = listOf("apple", "banana", "kiwifruit")
    for (index in items2.indices) {
        println("item at $index is ${items2[index]}")
    }
}
