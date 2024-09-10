package kekodkotlin.basictypes


/**
 * 16 bit yer kaplarlar.
 * Tek tırnaklar arasına harf, sayı, escape char ya da unicode yazarak kullanılır.
 *
 *
 *  Çift tırnak içerisinde yazılırsa String olur, char olmaz!
 * @see getCharUsages
 *
 * Char içindeki bir  int değeri .toInt() ile decimal değere çevirdiğimizde ASCII tablodaki değerini bize verecek.
 * https://simple.m.wikipedia.org/wiki/File:ASCII-Table-wide.svg
 * @see getAsciiNumber
 *
 * Kaçış (escape) karakterlerini tanımlamak için kullanılabilir.
 * @sample getEscapeStrings
 *
 *
 * Unicode karakterlerini tanımlamak için kullanılır
 * @sample getUnicodeCharacters
 *
 */

fun main() {
    getAsciiNumber('6')
    getEscapeStrings()
    getUnicodeCharacters()
}

fun getCharUsages() {
    val firstCharOfName: Char = 'M'
    //val  firstCharOfName : Char = 'Me' // yanlış kullanım
    //val  firstCharOfName : Char = "M"  // yanlış kullanım
}

fun getAsciiNumber(number: Char) {
    println("toInt : ${number.toInt()}") // deprecated. "code" kullan
    println("code : ${number.code}")
    println("digitToInt : ${number.digitToInt()}")
}

fun getEscapeStrings() {
    val exampleString = "Kotlin'de escape karakterleri örnekleri:\n" +
            "\t\\t ile bir tab boşluğu ekleyebilirsiniz.\n" +
            "\t\\n ile yeni bir satıra geçebilirsiniz.\n" +
            "\t\\b ile bir backspace (geri al) işlemi yapabilirsiniz.\n" +
            "\t\\r ile satır başına dönebilirsiniz.\n" +
            "\t\\' ile tek tırnak (') karakterini kullanabilirsiniz.\n" +
            "\t\\\\ ile çift tırnak (\\\") karakterini kullanabilirsiniz.\n" +
            "\t\\\\ ile ters slash (\\) karakterini kullanabilirsiniz.\n" +
            "\t\\$ ile dolar işareti ($) karakterini kullanabilirsiniz."

    println(exampleString)
}

fun getUnicodeCharacters() {
    val blackHeart = '\u2665'
    val heavyBlackHeart = '\u2764'

    println(blackHeart)
    println(heavyBlackHeart)

    // başına koyulan metni istenilen renge dönüştürür
    val ANSI_RED = "\u001B[31m"
    val ANSI_RESET = "\u001B[0m"

    println("$blackHeart")
    println("$ANSI_RED$blackHeart")
    println("$blackHeart")
    println("$ANSI_RESET$blackHeart")
    println("$ANSI_RED Kırmızı text")

}

