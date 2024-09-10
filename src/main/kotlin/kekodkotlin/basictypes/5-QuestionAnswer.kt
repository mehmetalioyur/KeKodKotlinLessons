package kekodkotlin.basictypes


/**
 *
 * Aşağıdaki sebepleri çok dert etmemize gerek yok. JVM dillerinde memory kullanımı bu levelda önemli değil.
 *
 * Memoryde stack ve heap olarak iki alanımız vardır.
 * Stack alanı değişmezdir bu sebeple heap'ten daha hızlıdır.
 * Primitive tipler hem name hem de value'yu stackte tutar.
 * Primitive tipler nullable ise name stackte, value heapte tutuluyor. yani veriyi nulladığımızda heapteki değer kaybolur ancak name stackte tutulmaya devam eder.
 *
 *Ide'nin değişken tipini çıkarmasına smart cast denir.
 * @see findTypeOfVariable
 *
 * Defansive Programming : Çok düşük bir ihtimalle gerçekleşecek olan bir ihtimal için çok fazla kez o kontrolü yapmaya denir. O ihtimal için test yazmak daha mantıklıdır.
 * Örneğin : Int.MAX_VALUE + Int.MAX_VALUE -> Sonucu long aralığındadır.
 * Toplama operatörüne bir if case'i eklenerek, bu durumd sonucun tipi Long'a dönüştürülebilir.
 * Ama her toplama işleminde bu kontrol yapılacağı için bunu yapmamalıyız.
 *
 */

fun main(args: Array<String>) {
    findTypeOfVariable(5)
    findTypeOfVariable("Selam")
    findTypeOfVariable(5L)
}

fun findTypeOfVariable(variable: Any) {
    when (variable) {
        is String -> println(variable.length)
        is Int -> (println(variable * 2))
        else -> println("Type of variable is not supported")
    }

}
