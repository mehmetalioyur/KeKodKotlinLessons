package kekodkotlin.functions


/**
 * Bir fonksiyon başka bir fonksiyonu body'sinde alabiliyorsa o fonksiyon Higher Order Fonksiyondur.
 * @sample sampleHigherOrderFunction Higher Order functiondur.functionParam higher order değildir.(Lambda gösterimdir).
 * Eğer functionParam içinde bir lambda gösterimi alırsa o zaman higher order function olur.
 *
 * Fonksiyon'lar Kotlin'de "First Class Citizen'dir;
 *
 * Yani değişkenlere değer olarak atanabilir,
 * Başka fonksiyonlara parametre olarak verilebilir.
 * Bir fonksiyonun geri dönüş değeri olabilir.
 *
 * Higher Order Function'lar basitçe bir fonksiyona parametre olarak verilen fonksiyonlardır.
 * Parametre olarak verilmekten kasıt, fonksiyonun çağrımının parametre kısmında yapılması değil, fonksiyon gövdesinin
 * yani süslü parantezler arasında kalan görev alanının başka bir fonksiyona parametre olarak verilmesidir.
 *
 * Higher Order Functionsları tanımlamanın 3 yolu vardır.
 *
 * Lambda okları arasına yazılabilir.
 * @sample minusFunction1
 *
 * Bu şekilde son parametre ise {} şeklinde çağrılabilir
 * @sample main
 *
 * Anonymous fonksiyonlar olarak yazılabilir
 * @sample minusFunction2
 *
 * Normal fonksiyon :: ile referans edilebilir.
 * @sample minusFunction3
 *
 * HigherOrder Fonksiyonlara default değer verilebilir.
 * @sample callMinusOneFunction2
 *
 * Lambda tek parametre alıyorsa, isim vermek zorunda değiliz. it ile çağırabiliriz.
 *
 * Bir Higher Order Function'a parametre verirken Class ismi.() şeklinde tanımlama yapılaiblir.
 * Bu sayede ilgili class da parametre parantezi içerisine yazılabilir.
 * @sample functionMinus4
 *
 */

fun main() {
    println(minusFunction1.invoke(4, 2))
    callMinusOneFunction(1, 2) { x, y -> x + y }
    callMinusOneFunction2(1, 2) { x, y -> x + y }
    println(minusFunction2.invoke(4, 2))
    println(minusFunction3.invoke(4, 2))

    functionMinus4(1, 2) { number1, number2 -> 4 }
}

fun sampleHigherOrderFunction(paramOne: String, functionParam: () -> Unit) {

}

fun callMinusOneFunction(num1: Int, num2: Int, minusFunction1: (Int, Int) -> Int) {
    val x = minusFunction1(num1, num2)
    println("Result of $num1 + $num2 = $x")
}

fun callMinusOneFunction2(
    num1: Int, num2: Int, minusFunction1: (Int, Int) -> Int = { a, b -> 4 }
) {

}


val minusFunction1 = { number1: Int, number2: Int ->
    number1 - number2
}

val minusFunction2 = fun(number1: Int, number2: Int): Int {
    return number1 - number2
}

val minusFunction3 = ::functionMinus3

fun functionMinus3(number1: Int, number2: Int): Int {
    return number1 - number2
}


fun functionMinus4(number1: Int, number2: Int, minusFunction1: String.(Int, Int) -> Int): Int {
    return 4
}
