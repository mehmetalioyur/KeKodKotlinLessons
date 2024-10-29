package kekodkotlin.classes


/**
 * Gruplayabileceğim özelliklere sahip iki classım varsa daha iyi bir kod için bunların parent classını oluşturabilirim.
 * Bizi boilerplate kodlardan kurtarız ve bir class hiyerarşisi oluşturmamızı sağlar.
 *
 * Open ve Final keywordleri accessibility modifierdır. Visibility modifier ile karıştırma.
 *
 * Java'da bir class default'ta miras alınabilir.
 * Kotlinde classlar default olarak finaldır. Miras alınabilmeyi open keywordu ile sağlarız.
 * Miras aldığımız yerde, miras alınan classın constructor parantezlerini kullanırız.
 *
 * Başka bir class'ı miras almıyorsa her class Any classını miras alır ve Any classından hashCode, equals ve toString override edilebilir.
 *
 * Miras alınan classların initialize'ında ilk önce parent class çalışır.
 *
 * Dinamik Polymorphism(Override): Eğer parent class'taki property veya fonksiyonun, child classta özelliği ya da değeri değişiyorsa buna polymorphism denilir.
 * @sample Cat.makeASound
 * @sample Cat.name
 *
 * override ettiğim fonksiyon kendi içinde bir body'e sahipse ve ben bu body'yi child class'ta kullanmak istiyorsam "super" çağırımını yapabilirim.
 * iki farklı classı implement ettiğimizde(bir interface,bir class- iki interface) ve ikisinde de aynı isimle bir fonksiyon varsa
 * hangisini override ettiğimizi "super.<Rectangle>.draw()" şeklinde belirtebilirim.
 *
 *
 * Statik Polymorphism(Overload): Eğer aynı isimli fonksiyonlar farklı parametrelerle çalışıyorsa, buna statik polymorphism denir.
 * @sample HotDrinkMaker.make
 *
 *
 *
 * parent-secondParent-child class hiyerarşisinde oluşturulan bir fonksiyonun  secondParentta override edilmesini
 * istiyorsam ancak childda override edilmesini istiyorsam ancak childda override edilmesini istemiyorsam,
 * secondParent'ta "final override fun" keywordunu kullanabilirim.
 *
 *
 */

open class Animal(open val name: String = "Ev Hayvanı") {
    var feetCount: Int = 4
    var origin: String = "Sivas"
    var tailShape: String = "oval"

    open fun makeASound() = "hav hav"
    fun attackTheWolf() = false
    fun eat() {}
    fun walk() {}
}

class Dog : Animal()

class Cat(override val name: String = "Rengar") : Animal() {
    override fun makeASound(): String {
        println(super.makeASound())
        return "Miyav"
    }
}

fun main() {
    val dog = Dog()
    val cat = Cat()

    println(dog.makeASound())
    println(cat.makeASound())
}

class Tea{
    fun makeHotDrink(){}
}

class Coffee{
    fun makeHotDrink(){}
}

class HotDrinkMaker(){
    fun make(tea: Tea){
        tea.makeHotDrink()
    }
    fun make(coffee: Coffee){
        coffee.makeHotDrink()
    }
}