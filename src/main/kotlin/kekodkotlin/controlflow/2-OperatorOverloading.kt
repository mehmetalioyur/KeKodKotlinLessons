package kekodkotlin.controlflow

/**
 *
 * Bir operatör ya da operatör fonksiyona yeni bir anlam yüklemek, overload etmektir.
 * Ama operatörün ana işlevini değiştirmememiz gerekir. Örneğin minus'u çarpma işlemi için kullanmamalıyız.
 * Aşağıda data class'ı minus(-) öparatörünü PairNumber'ı destekleyecek şekilde anlamını değiştirdik.
 *
 */

fun main(args: Array<String>) {
    val a = 5
    val b = 8
    var result = a.plus(b)

    val pairNumberOne = PairNumber(2, 4)
    val pairNumberTwo = PairNumber(-8, 11)

    //val resultPair = pairNumberTwo + pairNumberOne
    //val resultPair2 = pairNumberTwo.plus(pairNumberOne)

    val resultPair = pairNumberTwo - pairNumberOne //bu şekilde de kullanabiliyoruz.
    val resultPair2 = pairNumberTwo.minus(pairNumberOne)
}

data class PairNumber(val numberOne: Int, val numberTwo: Int) {

    operator fun minus(pair: PairNumber): PairNumber {
        val returnPairObject = PairNumber(numberOne - pair.numberOne, numberTwo - pair.numberTwo)
        println("Sonuç = (${returnPairObject.numberOne} , ${returnPairObject.numberTwo})")
        return returnPairObject
    }
}