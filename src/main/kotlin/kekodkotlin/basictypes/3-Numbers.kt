package kekodkotlin.basictypes


/**
 *  Type    | Size (bits) |    Min value                            |    Max value
 * ---------------------------------------------------------------------------------
 *  Byte    |    8 bit    |       -128                              |       127
 *  Short   |   16 bit    |     -32,768                             |      32,767
 *  Int     |   32 bit    | -2,147,483,648 (-2^31)                  | 2,147,483,647 (2^31 - 1)
 *  Long    |   64 bit    | -9,223,372,036,854,775,808 (-2^63)      | 9,223,372,036,854,775,807 (2^63 - 1)
 *
 *  UByte   |    8 bit    |        0                                |       255
 *  UShort  |   16        |        0                                |     65,535
 *  UInt    |   32        |        0                                | 4,294,967,295 (2^32 - 1)
 *  ULong   |   64        |        0                                | 18,446,744,073,709,551,615 (2^64 - 1)
 */

/**
 *  Type    | Size (bits) | Significant bits | Exponent bits | Decimal digits
 * ---------------------------------------------------------------------------------
 *  Float   |     32      |        24        |       8       |     6-7
 *  Double  |     64      |        53        |       11      |    15-16
 */

/**
 * Maksimum performans için doğru değişken tipini kullanmak önemlidir.
 *
 * Type Inference sırasında eğer sayı Int ifadeden büyük değilse, default Int olarak set edilir.
 * Type Inference sırasında eğer sayı Int ifadeden büyükse, default Long olarak set edilir.
 *
 *
 * Boxed : Değişkenin obje referansı olarak tutulmasıdır.
 * Unboxed : Değişkenin primitive olarak tutulmasıdır.
 *
 * == operatörü değişeknlerin değerini karşılaştırırken kullanılır.
 * === operatörü değişkenlerin referansını karşılaştırırken kullanılır.
 *
 * Değişken Referansı : Objenin tutulduğu yeri ifade eder.
 *
 * Her şeyi nullable yapmak doğru değil. Çünkü primitive tipli değişkenler nullable olduğunda class referansı tipine dönüşür.
 * Bu da performans kaybı
 * @see getPrimitiveVsClass
 *
 *  * Eğer number -128-127 (byte) aralığında nullable olsa bile  primitive tip gibi davranır. Bu aralıkta bütün farklı değişkenler aynı yere setlenir.
 *  * @see compareTwoNumbersValue
 *
 *
 */

fun main() {
    compareTwoNumbersValue()
}

fun getPrimitiveVsClass(){
    val number : Int // primitive int
    val number2 : Int? //class Integer
}

fun compareTwoNumbersValue() {
    val number = 127
    val boxedNumber = number
    println("Is the referance types equal : ${boxedNumber === number}") // true

    val number2 = 128
    val boxedNumber2 = number
    println("Is the referance types equal : ${boxedNumber2 === number2}")  // false
}