package kekodkotlin.basictypes


/**
 *
 * Bir değişkene null değer ataması yapabilmek için değişken tipinin sonuna "?" işareti konulur.
 * Java'da bu yapılamıyor. Bu yüzden null pointer exception alınıyor. Null safety bu demek.
 * @see plusWithResult
 *
 * Eğer bir değişkene tip verilmez ve direkt olarak null atamasıyapılırsa, IDE tip çıkarımı yaparken
 * bu değişkenin değerini Nothing? olarak işaretler. Çünkü hangi tipe karşılık geldiğini bilemez.
 * @see getDirectNull
 *
 *
 */
fun main(args: Array<String>) {

}

val result: Int? = null
fun plusWithResult() {
    result?.plus(1) // result null değil ise topla, null ise bir şey yapma
    result!!.minus(1) // her türlü bu işlemi çalıştır. (Java böyle.)
}

fun getDirectNull() {
    val nullVariable = null
}

