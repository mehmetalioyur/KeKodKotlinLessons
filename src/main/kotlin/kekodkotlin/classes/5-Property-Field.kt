package kekodkotlin.classes


/**
 *
 * Custom setter-getter kullanmadığımızda property'nin setterları ve getterları belirtmek zorunda değiliz.
 * Type Inferance yapılabildiği durumlarda tip belirtmek zorunda değiliz.
 * Property'nin eksiksiz belirtildiği durum:
 * @sample counter
 *
 * val propery'nin initial değeri yoksa onun backing fieldi yoktur. Sadece çalıştığı süre boyunca memoryde yer kaplar ve silinir.
 * Yani pratikte backing field'ı olmayan bir property ile fonksiyon'un bir farkı yoktur.
 * @sample Rectangle
 *
 * bir property'i kapsam dışında val gibi kullanmak istiyorsak setter'ını private'a çekebiliriz.
 *@sample PropertyEncapsulationExample.readOnlyProperty
 *
 * Local fonksiyonun içindeki field'lara getter setter yazamayız.
 *
 *
 */


fun main(args: Array<String>) {
    val property = PropertyEncapsulationExample()
    //property.readOnlyProperty = "Can't change value"
}

var counter: Int = 0

class Rectangle(val height: Int, val width: Int) {

    fun getArea() = height * width

    val area2
        get() = height * width

}


class PropertyEncapsulationExample {
    var readOnlyProperty = "I am read-only out of class"
        private set

    init {
        readOnlyProperty = "Property can change here"
    }
}
