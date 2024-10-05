package kekodkotlin.functions


/**
 *
 * Üzerinde değişiklik yapamadığımız (readOnly) sınıflara ya da değişiklik yapmak istemediğimiz sınıflara, bu sınıfların
 * içerisine yazmadan fonksiyon tanımlayabilmemizi sağlar. Böylece o sınıfa yeni uye bir fonksiyon kazandırabiliriz.
 * Bunu yaparken unutmamamız gereken; yazdığımız extension fonksioyn aslında o sınıfın gerçek bir fonksiyonu olmayacaktır.
 *
 * Receiver diye adlandıracağımız bir sınıfa ihtiyaç duyarlar. Receiver tanımı extension yazacağımız sınıfı ifade eder.
 *
 * Yapısal olarak aşağıdaki gibidir.
 * fun String.extPrint(handsomeValue : HandsomeOne) {}
 *
 * Javadaki public statik methodlar yerine kullanabiliriz.
 * Javadaki util fonksiyonlarının yerine kullanabiliriz. (Util fonksiyonlar OOP davranışı, Extensionlar Functional Programming davranışı)
 *
 * Extension fonksiyonlar direkt value üzerinden çağırılabilir.
 *@sample callExtensionFromValueExample
 *
 * Tek parametre alan extension fonksiyonlar Infix fonksiyon olarak kullanabilir.
 *@sample extPlus2
 *
 * Fonksiyonu global olarak kullanabilmemizi sağlatan extension olması değil, top level olmasıdır.
 *
 * Bir classın içindeki fonksiyonunu ile aynı parametrelere sahip extension fonksiyon yazılırsa, içerideki method görünür.
 * @sample testShape
 * @sample testShape2 (class içindeki fonksiyon private ise reflection yerine kullanılabilir.)
 *
 * Extension propertylerde tanımlanabilir. Bunların fonksiyonlardan herhangi bir farkı yoktur. (property vs field)
 * @sample testShape3
 *
 * Nullable extension fonksyion yazılabilir.
 * Companion object'lere de extension fonksiyon yazılabilir.
 *
 *Open bir sınıfı receiver olarak alan  open extension fonksiyonlar override edilebilir
 *@sample Rectangle
 */


fun main() {
    "3".extPlus(3)
    "3" extPlus2 4

    val shape = Shape()
    shape.testShape(2) // member function'u işaret etti.
    shape.testShape2(2) // member function private olduğu için extension'ı işaret etti.
}


fun String.extPlus(value: Int) {
    this.plus(value)
}

infix fun String.extPlus2(value: Int) {
    this.plus(value)
}

fun callExtensionFromValueExample() {
    (3 + 3.14).plus(34)
    "Mehmet".takeLast(4)
}


open class Shape {
    fun testShape(number: Int) = 1
    private fun testShape2(number: Int) = 2
    open fun Shape.testShape4(number: Int) {}
}

fun Shape.testShape(number: Int) = 3
fun Shape.testShape2(number: Int) = 4

val Shape.testShape3
    get() = 2


class Rectangle : Shape() {
    override fun Shape.testShape4(number: Int) {

    }
}


