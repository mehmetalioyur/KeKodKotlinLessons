package kekodkotlin.classes


/**
 * Abstract classlar bir şablon niteliğindedir ve tanımlarken verilen bilgiler çok genel olmalıdır. Ama bilgiler net olmalıdır.
 * Örneğin bir insan classının gözü, kulağı, yüzü, eli ,ayağı olacak.
 * Ancak Ege şivesi sadece ege bölgesinde yaşayan insanlarda vardır.
 * Bunu insan hiyerarşisinde belirtemeyiz.
 *
 * Bir Türk, Bir Azeri insanın nesnesini yaratabilirim. Ama insan kadar genel bir classın nesnesini üretmeme gerek yok.
 *
 *
 */

/**
 * Abstract Class
 * Accessibility modifier kullanmamıza gerek yokturlar. Open'dırlar. Amacı inheritance olduğu için final keywordu kullanamayız.
 *
 * Constructor'u olsa bile nesnesi yaratılamaz.
 * Constructor olmasının sebebi, içerisinde farklı classın nesnesi varsa onu inject etmektir.
 * @sample Human.sendEvent
 *
 * State tutabilirler.
 * normal,open ve abstract property ve fonksiyon tanımlayabilirim.
 *
 * Abstract fonksiyonlara ve property'lere body ve değer atayamam.
 * Abstract propertyler değerlerini constructordanda override edebilirim..
 * Abstract class başka bir abstract class tarafından miras alınıyorsa üye property,fonksiyonlarının overide edilmesi zorunlu değildir. (Open zorunlu)
 * Ancak miras alan class bir abstract property ya da fonksiyonu override ediyorsa, miras alan classı miras alan
 * classlarda o property ya da fonksiyonun override edilmesi zorunlu değlidir.
 * "Final override fun" ile override'ı kapatabiliriz.
 *
 * Open Class
 *
 * Open classlar şablondan ziyade gruplama yapmaya başladığımız classlardır. Daha detay bilgi ve tanımlamalar içermesi gerekir .
 * Open classlarda ve diğer classlarda abstact fonksiyon yazamam. Interface fonksiyonları zaten abstractır
 * Open property ve fonksiyonlar optional'dır. İstersek override edebiliriz. Ancak zorunlu değildir.
 *
 * Abstract class- open class seçim senaryoları.
 * Nesnesine ihtiyacım olacaksa open, olmayacaksa abstract ya da open.
 * Class'da başka abstract memberlar var mı? Evet ise abstract
 * Class'da UI bileşenleri aynı ama içerikleri farklı mı? Open yapılabilir. UI'nın farklılaşma ihtimali varsa Abstract + 2 child ui da yapılabilir.
 *
 */


class EventManager {
    fun sendEvent(event: String) {
        println("Sending start event: $event")
    }
}

abstract class Human(val eventText: String, val eventManager: EventManager) {
    abstract fun speak()
    fun walk() {
        "Yürüyorum"
    }

    open fun run() {
        "Koşuyorum"
    } //

    abstract val voice: String
    val eyeColor: String = "#Black"
    open val ancestor = "Monkey"

    init {
        sendEvent()
    }

    private fun sendEvent() {
        eventManager.sendEvent(eventText)
    }

}

class Turkish : Human("Türk insan oluşturuldu", EventManager()) {
    override fun speak() {}
    override val voice = "Selam"
    override val ancestor = "Wolf"

}

class Turkish2(override val voice: String = "Merhaba") : Human("Türk İnsan oluşturuldu", EventManager()) {
    override fun speak() {}
    override val ancestor = "Wolf"
}





