package kotlintest.classess

class Rectangle(private var height: Double, private var length: Double) : Shape() {
    var perimeter = (height + length) * 2

    fun destroy() {
        perimeter = 0.0;
    }



}

fun main() {
    val rectangle = Rectangle(1.0, 2.0)
    println("The perimeter is ${rectangle.perimeter}")
    rectangle.destroy()
    println("The perimeter is ${rectangle.perimeter}")
}