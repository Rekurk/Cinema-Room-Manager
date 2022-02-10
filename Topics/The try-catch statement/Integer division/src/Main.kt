fun intDivision(x: String, y: String): Int {
    return try {
        val xInt = x.toInt()
        val yInt = y.toInt()
        xInt / yInt
    } catch (e: NumberFormatException) {
        println("Read values are not integers.")
        0
    } catch (e: ArithmeticException) {
        println("Exception: division by zero!")
        0
    }
}

fun main() {
    val x = readLine()!!
    val y = readLine()!!
    println(intDivision(x, y))

}