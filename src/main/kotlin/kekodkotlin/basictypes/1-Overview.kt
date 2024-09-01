package kekodkotlin.basictypes


/**
 *
 * Java' da int,bool,char primitive tiplerdir. String bir class'tır ancak özel optimizasyonlarla primitive hızında çalışır.
 * Kotlin'de her şey bir nesnenir. Herhangi bir değişkende üye fonksiyonları ve özellikleri çağırabiliriz. 2024.plus(1)
 *
 * Diğer programlama dillerinden aşina olduğumuz primitive types Kotlin'de birer class gibi görünürler.
 * Buna rağmen çalışma zamanında ilker hallerine optimize edilirler.
 * Bu primitive değişkenler oluşturulduktan sonra, Java ile üretilen primitive tiplerin bytecode'u karşılaştırdığında aynı çıktıyı üretirler.
 *
 * Bu değişken tipleri aşağıdaki gibidir;
 *
 * Numbers ve onların unsigned muailleri.
 * Boolean
 * Character (Char)
 * String
 * Arrays
 *
 * Bir değişken oluşturmak için "val" ya da "var" kelimelerini kullanırız.
 * val = "Değeri sonradan değiştirilmez, değişken "Value" sabit kelimesinin kısaltmasıdır.
 * var = "Değeri sonradan değiştirilebilir", değişken "Variable" değişken kelimesinin kısaltmasıdır.
 *
 * val değişkenlere genelde immutable denir. Ancak bu yanlış bir ifadedir. Çünkü;
 * immutable ise bir değişkenin / nesnenin durumu asla ilk değerden farklı olamaz demek.
 * read only demek ilk değer atamasından sonra tekrar değer atanamaz demek. val değişkenler read only demektir.
 *
 * @sample calculateAvailableSpace -> Immutable olsaydı, sonuçların aynı olması gerekirdi.
 *
 *  * val - var performans farkı
 *  Dikkate almamız gereken bir fark yok
 *  en basic levelde var daha performanslı. Çünkü val'da değer atandıktan sonra değerinin değişmemesi için bir if var.
 *  multi thread kullandığımızda threadler birbiri içindeki değerleri kontrol etme gereksinimi duyar. Multi thread'de
 *  val ile tanımlanan değişkenler kontrol edilmediği için, val bu koşulda daha hızlıdır.
 *  ama best practice olarak, kodun değişmeyeceğini bilmemiz debug'ı kolaylaştırır. bu yüzden öncelik val
 *
 *
 *
 *
 *  Type Inference : Idenin atama yapılan değerden değişken tipini çıkarmasıdır.
 *  @see getExampleOfTypeInference
 *
 *  var değişkeni nasıl val yaparım? setterini private'a çekerim.
 *  @see setName
 *
 *

 */
fun main() {
    val name: String = "Mehmet Ali"
    val age: Int = 29
    val isMale: Boolean = true
    val firstLetterOfSurname: Char = 'Ö'
}

fun calculateAvailableSpace() {
    val box = Box()
    box.height = 10
    box.width = 20
    box.length = 5
    box.usedSpace = 2
    println(box.availableSpace) //Sonuç : 998

    box.height = 5
    box.width = 5
    box.length = 5
    box.usedSpace = 0
    println(box.availableSpace) // Sonuç : 125


}

class Box() {
    var width: Int = 0
    var height: Int = 0
    var length: Int = 0
    var usedSpace: Int = 0


    val availableSpace: Int
        get() = (width * height * length) - usedSpace
}

/**-----------------------------------------------------------------------------------------------------------*/

fun getExampleOfTypeInference() {
    val name = "Mehmet" // type inference var
    var surname: String // type inference yok.
}

/**-----------------------------------------------------------------------------------------------------------*/

class User {
    var name: String = "Mehmet"
        private set
}

fun setName() {
    val user = User()
    // user.name = "Mehmet"
}

