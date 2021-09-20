fun main(args: Array<String>) {
    val isValid = isValid("79927398713")
    if (isValid) {
        println("Cartão de crédito válido")
    } else {
        println("Cartão de crédito inválido")
    }

}

fun isValid(credCardDigits: String): Boolean {
    val credCardDigitsReverse = credCardDigits.reversed()
    val digitsList: MutableList<String> = ArrayList()

    for (i in credCardDigitsReverse.indices) {
        val digit = credCardDigitsReverse.substring(i, i + 1).toInt()

        if (i % 2 == 1) {
            digitsList.add((digit * 2).toString())
        } else {
            digitsList.add(credCardDigitsReverse.substring(i, i + 1))
        }

        val d = digitsList[i]
        if (d.length >= 2) {
            digitsList.removeAt(i)
            for (j in d.indices) {
                digitsList.add(d.substring(j, j + 1))
            }
        }
    }
    var total = 0
    digitsList.forEach { digits ->
        val d = digits.toInt()
        total += d
    }
    return total % 10 == 0
}
