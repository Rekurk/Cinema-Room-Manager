fun main() {
    val a = MutableList(2) { readln().toInt() }
    if (a[1] == 0) {
        println("Division by zero, please fix the second argument!")
    } else println(a[0] / a[1])
}