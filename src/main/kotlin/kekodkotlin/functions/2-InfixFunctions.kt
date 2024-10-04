package kekodkotlin.functions

/**
 * Daha okunaklı kod yazmak için kullanılır.
 * nokta(.) kullanımını kaldırır.
 * Bir fonksiyonu infix yapabilmek için 5 şart vardır.Bunlar;
 * 1- Infix keywordu ile başlamalıdır.
 * 2- Uye bir fonksiyon olmalıdır. (Bir sınıfa bağlı olmalıdır.)
 * 3- Ya da bir extension fonksiyon olmalıdır.
 * 4- Sadece 1 parametre almalıdır. (vararg'da alamaz.)
 * 5- Infix method'un parametresi default değer almamalıdır. (Çünkü JVM'de hem 1 hem 0 parametreli fonksioynu üretilir. 0 parametreli fonksiyon kuralı bozar)
 *@sample InfixClass.downloadVideo
 *
 * and,or,xor gibi kullanımlar infix kullanımdır.
 * @sample logicalOperatorsInfixSample
 *
 * matematiksel operatörlerin, tip dönüşümlerinin(type conversion), range kullanımının, infix methodlara göre işlem önceliği varıdr.
 * İnfix methodların da mantık operatörlerine göre işlem önceliği vardır.
 * @sample priorityExample
 *
 * bir sınıfın içindeyken this kullanımı bulunduğu sınıfı işaret eder.
 * Sample: downloadImage "google"-this downloadImage "google" aynıdır.
 */

fun main() {
    val infixInstance = InfixClass()
    infixInstance downloadVideo "www.google.com"
    infixInstance.downloadVideo2("www.google.com")
}

class InfixClass {

    infix fun downloadVideo(url: String): String {
        return "downloading $url"
    }

    fun downloadVideo2(url: String): String {
        return "downloading $url"
    }

    infix fun specialPlus(value: Int) = value + 5
}

fun logicalOperatorsInfixSample() {
    val isStudent = true
    val isTeacher = false

    isStudent.or(isTeacher) // kodun okunaklığı az
    isStudent or isTeacher // kodun okunaklığını arttırıyor.

    isStudent and isTeacher
    isStudent xor isTeacher
}

fun priorityExample() {
    var number = 5
    var infixClassInstance = InfixClass()
    number + number - 2 * (infixClassInstance specialPlus 1) == 5

    number == 3 && number < 5 ||infixClassInstance specialPlus  1 == 5

}

