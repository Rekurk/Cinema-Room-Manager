import java.lang.NumberFormatException

fun calculateBrakingDistance(v1: String, a: String): Int {
    return try {
        val v1Int = v1.toInt()
        val aInt = a.toInt()
        val c = -(v1Int * v1Int) / (2 * aInt)
        c
    } catch (e: NumberFormatException) {
        println(e.message)
        -1
    } catch (e: ArithmeticException) {
        println("The car does not slow down!")
        -1
    }
}