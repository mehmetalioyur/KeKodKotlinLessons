package kekodkotlin.classes

/**
 *
 *
 *
 * Interface'ler tek başına kullanılan yapılar değildirler.
 * Constructur'a sahip olamaz.
 * Nesnesi oluşturulamaz.
 * object expression ile nesneye benzer bir yapı kurulabilir.
 * @sample TextWatcher
 *
 * interface içindeki fonksiyon'a body yazarsam o fonksiyon statik yapılır ve override etme zorunluluğu kalkar.
 * Abstact class'ta member fonksiyon yazılıyordu. Farklılık!
 * @sample TextWatcher.funWithBody
 *
 * class'tan miras alamazlar, başka bir interface'i implement edebilirler.
 * SOLID'in interface segregation methodu için bu özellik kullanılır. Interface'leri gruplayabildiğimiz kadar gruplayabilmemiz gerekir.
 * bir class istediği kadar interface implement edebilir.
 *
 * "final override" keywordunu interfacelerde kullanamıyoruz. Bu yüzden child classlarda override'ı(polymorphisim) engellemek istiyorsak interface kullanamayız.
 *
 * interface bir interface'i implement ettiğimizde override etme zorunluluğu ortadan kalkar.
 *
 * val keywordu ile BACKING FIELD'ı olmayan propertyler de tanımlayabiliriz. Interfaceler state tutmaz. Companion object ile tutulabilir. Ama yapma!
 * @sample TextWatcher.property
 *
 * Interface-Abstract Class farkları!
 * Interface'ler state tutmaz. Abstract class'lar istediğimiz veri tutabilir.
 * Istediğimiz kadar interface implement edebiliriz. Ancak bir classı inherit alabiliriz.
 *
 * Eğer bir fonksiyonu abstract class'a mı interface'e mi yazacağıma nasıl karar veririm?
 * Eğer state ile ilgili bir işlem varsa, abstract class kullanmam gerekir.
 * Doğuştan varolan özellikler için abstract classlar kullanılır, yetenek için interfaceler kullanılır.
 *
 *
 *
 *
 */

fun main() {
    val textWatcher = object : TextWatcher {
        override fun addOnTextChanged() {}
        override fun beforeTextChanged() {}
        override fun onTextChanged() {}
        override val property: String
            get() = ""
    }
}

interface TextWatcher: X {
    fun addOnTextChanged()
    fun beforeTextChanged()
    fun onTextChanged()
    fun funWithBody(){}
    val property : String
}
interface X
