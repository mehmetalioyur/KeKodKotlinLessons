package kekodkotlin.controlflow

/**
 * Diğer programlama dillerindeki switch-case yapısına karşılık gelir.
 * When kullanımı if-else-else ile tamamen aynı anlamdadır.
 *
 * Best practice olarak 2 case varsa if-else, daha fazla case varsa when kullanmak daha temiz görünüm sağlar.
 * Tek satır sonuç varsa süslü parantez kullanmamıza gerek yok. Bu best practice'dir.
 * iki farklı case aynı çıktıyı üretecekse onu "," virgül ya da "or" ile ayırabiliriz.
 * @sample whenUsageSample
 *
 * when'in yanına karşılaştırma ifadesi eklemeden bunu case'lerin yanına ekleyebiliriz. Bunun artısı && || kullanabilmemizi sağlar.
 * Ama bunun yerine if-else if- else kullanmak) ya da if-return kullanmak daha okunaklı kod yazmamızı sağlar.
 * @sample whenWithCompressionSample
 *
 * state ve expression kullanımı vardır. Örnek yazmadım.
 *
 *!is, is ile class referansı olup olmadığı karşılaştırılabilir.(if yerine when kullanmak daha okunaklı)
 * @sample whenWithClassReferenceSample
 *
 * !in, in ile range kontrolü yapılabilir.(if yerine when kullanmak daha okunaklı)
 * @sample whenWithRangeSample
 *
 */

fun main(args: Array<String>) {
    whenUsageSample()
    whenWithCompressionSample()
}

fun whenUsageSample() {
    println("Ülke kodunuzu giriniz.")
    val countryCode = readln()
    when (countryCode.lowercase()) {
        "tr", "az" -> println("Türk Vatandaşı")
        "ar" -> println("Arap Vatandaşı")
        "fr" -> println("Fransa Vatandaşı")
        "ru" -> println("Rus Vatandaşı")
        "uk" -> println("İngiliz Vatandaşı")
    }

    val phoneCode = readln()

    when (phoneCode.toInt()) {
        90 or 994 -> println("Türk Vatandaşı")
        90.or(994) -> println("Türk Vatandaşı")
        1 and 2 -> println("X Vatandaşı")
        1.and(2) -> println("X Vatandaşı")
    }

}

fun whenWithCompressionSample() {
    val countryCode = readln()

    when {
        countryCode.lowercase() == "tr" && countryCode.lowercase() == "az" -> println("Çifte Türk Vatandaşı")
        countryCode.lowercase() == "tr" || countryCode.lowercase() == "az" -> println("Türk Vatandaşı")
        else -> println("Türk değil")
    }

    if (countryCode.lowercase() == "tr" && countryCode.lowercase() == "az") {
        println("Çifte Türk Vatandaşı")
    } else if (countryCode.lowercase() == "tr" || countryCode.lowercase() == "az") {
        println("Türk vatandaşı")
    } else {
        println("Türk değil")
    }
}

fun whenWithClassReferenceSample() {
    var x: Any = "Ben bir stringim"
    x = 5
    when (x) {
        is String -> println("$x is String")
        is Int -> println("$x is Int")
        else -> println("Ben aslında yoğum")
    }
}

fun whenWithRangeSample() {
    var number = 3
    when (number) {
        in 0..10 -> println("0-10 arasında")
        in 11..20 -> println("11-20 arasında")
        !in 11..20 -> println("11-20 arasında değil")
    }
}
