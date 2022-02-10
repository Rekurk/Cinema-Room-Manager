package cinema
const val MSE = 60
const val TICKET = 10
const val TICK2PART = 8
/** fieldPrint just printing out movie field */
fun fieldPrint (movieField: Array<Array<Char>>) {
    println()
    println("Cinema:")
    print("  ")
    for (i in movieField[0].indices) print("${ i + 1 } ")
    println()
    for (i in movieField.indices) println("${ i + 1 } ${ movieField[i].joinToString(" ") }")
    println()
}
/** ticketMax search max value of rows and columns */
fun ticketMax (rowMovie: Int, columnMovie: Int, movieField: Array<Array<Char>>): Array<Int> {
    val seat = inputSeat(movieField)
    var doublePar = Array(3) { 0 }
    doublePar[1] = seat[0]
    doublePar[2] = seat[1]
    doublePar = switchPrice(rowMovie, columnMovie, seat[0], doublePar)
    println()
    return doublePar
}
fun inputSeat (movieField: Array<Array<Char>>): Array<Int> {
    var seat = Array(2) { 0 }
    return try {
        println()
        println("Enter a row number:")
        seat[0] = readln().toInt()
        println("Enter a seat number in that row:")
        seat[1] = readln().toInt()
        if (movieField[seat[0] - 1][seat[1] - 1] != 'S') {
            println("That ticket has already been purchased!")
            seat = inputSeat(movieField)
        }
        movieField[seat[0] - 1][seat[1] - 1] = 'B'
        seat
    } catch (e: Exception) {
        println()
        println("Wrong input!")
        seat = inputSeat(movieField)
        seat
    }
}
/** switchPrice search cost of seat */
fun switchPrice (rowMovie: Int, columnMovie: Int, row: Int, doublePar: Array<Int>): Array<Int> {
    when {
        rowMovie * columnMovie <= MSE -> {
            print("Ticket price: $$TICKET")
            doublePar[0] = TICKET
        }
        rowMovie % 2 == 0 && rowMovie / 2 < row -> {
            print("Ticket price: $$TICK2PART")
            doublePar[0] = TICK2PART
        }
        rowMovie / 2 < row -> {
            print("Ticket price: $$TICK2PART")
            doublePar[0] = TICK2PART
        }
        else -> {
            print("Ticket price: $$TICKET")
            doublePar[0] = TICKET
        }
    }
    return doublePar
}
/** statisticMove print statistic our Cinema */
fun statisticMove (countTicket: Int, priceMov: Int, rowMovie: Int, columnMovie: Int) {
    println()
    println("Number of purchased tickets: $countTicket")
    print (String.format("Percentage: %.2f", 100 * countTicket.toDouble() / (rowMovie * columnMovie)))
    println("%")
    println("Current income: $$priceMov")
    print("Total income: $")
    println(when{
        rowMovie * columnMovie <= MSE -> rowMovie * columnMovie * TICKET
        rowMovie % 2 == 0 -> (rowMovie / 2) * columnMovie * (TICKET + TICK2PART)
        else -> ((rowMovie / 2) * TICKET + (rowMovie / 2 + 1) * TICK2PART) * columnMovie
    })
}
fun main() {
    println("Enter the number of rows:")
    val rowMovieI = readln().toInt()
    println("Enter the number of seats in each row:")
    val columnMovieI = readln().toInt()
    val movieField = Array(rowMovieI) { Array(columnMovieI) {'S'} }
    var priceOfMovie = 0
    var countTicket = 0
    var currentIncome: Array<Int>
    while (true) {
        println()
        println("1. Show the seats")
        println("2. Buy a ticket")
        println("3. Statistics")
        println("0. Exit")
        when (readln().toInt()) {
            1 -> fieldPrint(movieField)
            2 -> {
                currentIncome = ticketMax(rowMovieI, columnMovieI, movieField)
                movieField[currentIncome[1] - 1][currentIncome[2] - 1] = 'B'
                priceOfMovie += currentIncome[0]
                countTicket++
            }
            3 -> statisticMove(countTicket ,priceOfMovie, rowMovieI, columnMovieI)
            else -> break
        }
    }
}