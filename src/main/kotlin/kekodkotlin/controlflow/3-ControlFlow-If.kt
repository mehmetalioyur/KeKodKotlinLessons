package kekodkotlin.controlflow


/**
 * if else case'lerinden sonra parantez açılır ve kapanır.
 * Ancak tek satır kod yazılacaksa, süslü parantez kullanılmadan da yazılabilir.
 * If - else case'lerini 2 kullanımı vardir. Bunlar;
 * State kullanımı : If-else kullanarak şartlı durumları ayrıştırmak,
 * Expression kullanımı : Eşitliğin karşı tarafına if else'in sonucunu atayarak kullanmaktır. Case'in son satırı sonuç olarak atanır.
 * @sample stateAndExpressionUsageOfIf
 *
 * Kotlin'de if else'lerin Expression kullanımından dolayu ternary operatörü yoktur. Bunun yerine "elvis" kullanabiliriz.
 *@sample elvisOperatorUsageSample
 *
 * 2 farklı tipteki number değişkenler karşılaştırılırken equals fonksiyonu önce tiplerini karşılaştırdığı için eğer tipler uyuşmuyorsa, ide hata verecektir.
 *@sample differentNumberTypeCompressionExample
 *
 * if-else if-else yapısında doğru cevapta flow'dan çıkar. Ancak if-if-if yazdığımızda doğru cevap bulunsa dahi tüm if conditionlarının içine girilir.
 *
 * Eğer durumlar içinde karşılaştırılan ifadeler birbirinden farklı değerler içeriyorsa if-return kullanmak daha temiz görünüm sağlar.
 *
 * !is, is ile class referansı olup olmadığı karşılaştırılabilir.(if yerine - when kullanmak daha okunaklı)
 * @sample ifWithClassReferenceSample
 *
 *  !in, in ile range kontrolü yapılabilir.(if yerine - when kullanmak daha okunaklı)
 *  @sample ifWithRangeSample
 */

fun main() {
    differentNumberTypeCompressionExample()
    stateAndExpressionUsageOfIf()
}

fun stateAndExpressionUsageOfIf() {
    //state kullanımı
    println("Öğrenci misin?")
    val isStudent = readln()

    if (isStudent.equals("evet", true)) {
        println("Öğrenci")
    } else {
        println("Öğrenci değil")
    }

    println("-----------------------------------------------------------")
    // expression kullanımı
    println("Öğrenci misin?")
    val isStudent2: String = if (readln().equals("evet", true)) {
        "Öğrenci"
    } else {
        "Öğrenci değil"
    }
    println(isStudent2)
}

fun elvisOperatorUsageSample(isStudent: Boolean?) {
    val isStudentString = isStudent ?: "false"
    //val isStudentString = isStudent ? "true" : "false" -> bu ternary operatörü. Javada var.
}

fun differentNumberTypeCompressionExample() {
    var intNumber = 1
    var longNumber = 1L
    //println(intNumber == longNumber)
    println(intNumber.equals(longNumber)) // false
}

fun ifWithClassReferenceSample() {
    var x: Any = "Ben bir stringim"
    x = 5
    if (x is String) {
        println("$x is String")
    } else if (x is Int) {
        println("$x is Int")
    } else {
        println("Ben aslında yoğum")
    }
}

fun ifWithRangeSample() {
    val number = 3

    if (number in 1..10) {
        println("0-10 arasında")
    } else if (number in 11..20) {
        println("11-20 arasında")
    } else if (number !in 11..20) {
        println("11-20 arasında değil")
    }
}