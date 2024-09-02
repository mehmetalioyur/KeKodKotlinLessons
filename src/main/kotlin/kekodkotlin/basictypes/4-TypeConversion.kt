package kekodkotlin.basictypes


/**
 * Implicit Type Conversion : Örtülü - belirgin olmayan tip dönüşümü
 * Explicit Conversion : Açık - belirgin tip dönüşümü
 *
 * Kotlin'de örtülü (implicit) tip dönüşümü yoktur.
 * Javada bir fonksiyon için başka bir tipte number verildiğinde fonksiyon çalışıyor. Örneğin parametrede short isteniyor ancak ben int verdim. Çalışıyor.
 * Kotlinde açık açık neye dönüştüdüğümüzü belirtmemiz gerekiyor. 125.toShort() şeklinde.
 *
 *
 * Number'lar eğer int sınırları içindeyse int olarak tutulur. Üstündeyse long tutulur.
 * @see printType
 *
 * Küçük tipler büyüklere cast edilirken bir problem yaşanmaz. Ancak büyük küçüğe cast edilirken küçük değer aralığının modunu alıp, kalanını yazdırır.
 *
 *
 * İki number tip arasında matematiksel bir işlem yapılırsa, sonuç büyük olanın tipinde çıkar. Long + Byte = Long
 *
 * Değer aralığı daha küçük number tipinde olsa bile tip değişmez 1000L / 1000L = Long
 *
 * İki aynı tip işeminin sonucu bu tipin range'ine sığmazsa, bir üst ya da bir alt tip dönüşüm yapılmaz. Sonucun modu alınıp, kalanı yazılır.
 * @see sumIntLimits
 */

fun main() {
    printType(100)
    printType(3_000_000_000)
    sumIntLimits()
}


fun printType(value: Number) {
    when (value) {
        is Int -> println("Int")
        is Double -> println("Double")
        is Float -> println("Float")
        is Long -> println("Long")
        is Short -> println("Short")
        is Byte -> println("Byte")
    }

}

fun sumIntLimits() {
    printType(Int.MAX_VALUE + Int.MAX_VALUE)
}
