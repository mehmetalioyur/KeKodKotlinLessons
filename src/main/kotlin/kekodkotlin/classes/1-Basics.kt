package kekodkotlin.classes


/**
 * Init Bloğu primary constructor'ın body'sidir.
 * Biz primary constructor tanımlamasak bile görünmez bir empty constructor oluşturulur.
 * Secondary constructor kullanıyorsam primary'i constructor'a işaret etmeli. Böylece birbirinden bağımsız constructorlar yazamam.
 * ilk olarak init bloğu çalışır ardından secondary constructor bodysi çalışır.
 * @sample main
 * constructor'da val, var keywordlerini verdiğimizde class içinde her yerden erişilebilir.
 * Bir class'ın içine property'ler ve init bloğu koyduğumda yazım sırasına göre çalışır.
 * @sample InitOrderDemo
 * Constructor'ın içindeki property'i üye propetry'e atayabiliriz.
 * @sample Customer.uppercaseName
 * Constructor'a optional parametre verebilirim.
 *
 * Bir classın nesnesin  oluşturulmasını engellemek istioyrsak bunu abstract yapmadan constructoru private'a çekerek yapabiliriz.
 * @sample DontCreateMe
 *
 * Bir class constructura ve init bloklarına, fonksyionlara, proprety'lere, nested-inner classlara ve object'e sahip olabilir.
 *
 */

fun main() {
    val turtleOne = Turtle()
    val turtleTwo = Turtle()

    turtleTwo.feetColor

    val demo = InitOrderDemo()
   //DontCreateMe()

}

class Turtle {
    val feetCount: Int = 4
    val feetColor: String = "Brown"
    val headCount: Int = 1
    val headColor: String = "Brown"
    val shelterColor: String = "Green"
    val tailCount: Int = 1

    fun run(): String {
        return "Fuck Off"
    }
}

class InitOrderDemo(){
    val firstProperty = "First property".also(::println)

    init {
        println("First initializer block")
    }

    val secondProperty = "Second property".also(::println)

    init {
        println("Second initializer block")
    }
}

class Customer(name: String){
    val uppercaseName = name.uppercase()
}

class DontCreateMe private constructor() {}
