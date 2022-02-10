fun parseCardNumber(cardNumber: String): Long {
    when {
        cardNumber.count { it == ' ' } != '3'.digitToInt() -> throw Exception("space")
        cardNumber.length != "19".toInt() -> throw Exception("symbols more than need")
    }
    val a = cardNumber.split(" ")
    for (i in 0 until a.lastIndex) {
        if (a[i].length != a[i + 1].length) throw Exception("4 symbols need")
    }
    return cardNumber.replace(" ", "").toLong()
}