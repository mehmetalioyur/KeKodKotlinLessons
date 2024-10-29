package kekodkotlin.classes

/**
 * Encapsulation: Bir sınıfın sahip olabileceği; property, fonksiyon, inner class, nested class vb. gibi üye elemanları
 * private'da tutmamızı, dışarıdan hangisinin erişilmesini istiyorsak, onu dışarıya açmamızı, dışarıya açtığımızın da
 * dışarıda okumaya açmamızı söyler.
 *
 * Mimari kurabilmemiz için belirli classların belirli classları görmemesi, belirli classları, kısıtlanmış olarak görmesi gerekir.
 * Encapsulaton yaparak kodun dışarıdan değiştirilmesini önleriz.
 * Encapsulaton yaparak karmaşıklığı da önleriz.
 *
 * Kotlin'de aşamadığımız bir encapsulation vardır. Yani field'lar privatedır.
 * Field'a sadece getter, setter ve local fonksiyonlarından erişebiliriz.
 * propertyleri val yaptığımızda, field'ların sadece getter fonksiyonu yazılır.
 * propertyleri var yaptığımızda, field'ların getter ve setter fonksiyonu yazılır.
 * propertyleri private yaptığımızda property'nin dahil olduğu class'ın nesnesi oluşturulduğunda getter ve setter yazılmaz.
 *
 * Yani var ile tanımladığımız bir property'de zaten encapsulation vardır. Private veya val yaparak ekstra bir güvenlik ekleriz.
 *
 */

class User constructor() {
    var name: String = "Mehmet Ali"

    val surname: String = "ÖYÜR"

    fun getFullName(): String {
        return "$name $surname"
    }
}

fun main(args: Array<String>) {
    val user = User()
    user.name = "Mehmet"
    //user.surname = "ÖZGÜN"
    println(user.getFullName())
}