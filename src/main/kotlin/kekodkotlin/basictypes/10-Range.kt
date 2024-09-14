package kekodkotlin.basictypes


/**
 *
 * Sonlu sayıda liste oluşturmaya yarar.
 *
 * Küçükten büyüğe liste oluşturmak için;
 * ".." operatörünü, ya da "rangeTo()"
 * "..<" operatörünü ya da "rangeUntil()" ya da until(infix kullanımı var)
 * fonksiyonunu kullanabiliriz.
 *
 * Büyükten küçüğe ".." operatörünü ullanarak liste oluşturamayız. Ide hata verir.
 * Büyükten küçüğe liste oluşturmak için downTo() fonksiyonunu kullanabiliriz. Infix kullanımı da vardır.
 *
 * @sample rangeDeclarationSample
 *
 * Char'lardan oluşan bir liste tanımlanabilir. Türkçe karakterleri içermez
 * @sample charRangeSample
 *
 *
 * Step fonksiyonu kullanarak liste oluşturulurken belli sayıda atlamalar yapılabilir.
 * @sample rangeSampleWithStep
 *
 * CharRange, IntRange ve LongRange isimlerinde özel rangeler vardır. Progression olarak adlandırılır.
 * Diğer tipler bulunmaz. Bu durumda first,last,step,count değerleri kullanılabilir.
 *
 */

fun main(args: Array<String>) {
    rangeDeclarationSample()
    println("----------------------------------------------------------------------------------------------------")
    charRangeSample()
    println("----------------------------------------------------------------------------------------------------")
    rangeSampleWithStep()
}


fun rangeDeclarationSample() {
    val numbers1 = 1..100
    val numbers2 = 1.rangeTo(100)
    val numbers3 = 1..<100
    val numbers4 = 1.rangeUntil(100)
    val numbers5 = 1 until 100
    val numbers6 = 1.until(100)

    println("1. Sample  -> First Number: ${numbers1.first} Last Number: ${numbers1.last}")
    println("2. Sample  -> First Number: ${numbers2.first} Last Number: ${numbers2.last}")
    println("3. Sample  -> First Number: ${numbers3.first} Last Number: ${numbers3.last}")
    println("4. Sample  -> First Number: ${numbers4.first} Last Number: ${numbers4.last}")
    println("5. Sample  -> First Number: ${numbers5.first} Last Number: ${numbers5.last}")
    println("6. Sample  -> First Number: ${numbers6.first} Last Number: ${numbers6.last}")

    val numbers7 = 100 downTo 1
    val numbers8 = 100.downTo( 1)
    //val number9 = 100.. 1
    println("7. Sample  -> First Number: ${numbers7.first} Last Number: ${numbers7.last}")
    println("8. Sample  -> First Number: ${numbers8.first} Last Number: ${numbers8.last}")
}

fun charRangeSample() {
    val alphabet = ('a'..'z')
    alphabet.forEach { print("$it-") }
}

fun rangeSampleWithStep(){
    val rangeStep1 = 1..101 step (2)
    val rangeStep2 = 1..100 step 3
    rangeStep1.forEach { print("$it-") }

    val reverseRangeStep1 = 100 downTo 1 step (3)
    val reverseRangeStep2 = 100 downTo 1 step 2
    reverseRangeStep1.forEach { print("$it-") }
}