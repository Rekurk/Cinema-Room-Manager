import java.lang.NumberFormatException
const val DOUGLAS = 42
fun main() {
    val answer: Int = try {
        readLine()!!.toInt()
    } catch (e: NumberFormatException) {
        DOUGLAS
    } finally {
        println("The answer is a number")
    }
    println(answer)
}