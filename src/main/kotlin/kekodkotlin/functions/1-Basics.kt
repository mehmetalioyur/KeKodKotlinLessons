package kekodkotlin.functions


/**
 *  Fonksiyonlar fun keyword'u ile başlar.
 *  fonksiyon ismi verilir.
 *  parametre parantezleri açılır ve parametreler girilir.
 *  : operatörü ve geri dönüş değeri yazılır.
 *  fonksiyon body'si açılır ve kapatılır.
 *  Geri dönüş değeri verilmeyen fonksiyonlar unit tipini geri döndürür.
 * @sample plusWithThree
 *
 * Fonksiyonlar kotlinde "First Class Citizen"dir.ani değişkenlere değer olarak atanabilir.
 *
 *  Fonksiyonlar çağırılırken ismi ve oarametleri kullanılır.
 * Fonksiyonların bir geri dönüş tipi varsa değişkene atanabilir.
 * @sample assignValue
 *
 * Bir class'ın fonksiyonunu çağırırken nokta işareti kullanılır.
 *@sample Math.pow
 *
 * fonksiyon parametresi tanımlanırken, val-var gibi betimleyiciler kullanılmaz.
 *
 * @sample plusWithThree
 *
 * Fonsiyonlara default argument tanımlanamabilir. Bu parametrelerin girilmesi opsiyoneldir. Java Byte Kode'a çevirdiğimizde
 * her durum için parametreli ve parametresiz farklı fonkiyon yazıldığı görülür.
 *  Aynı fonksyionun farklı sayıda parametre ile ya da farklı geri dönüş tipi ile ya da farklı parametre tipi ile çok kez çağılmasına  fonksiyon overload denir.
 *  Kotlinde default argumentten dolayı buna gerek yoktur.
 *@sample repeat
 *
 * Default değeri olan parametrelere named argument atanmadan çağırılacaksa, parametre sırasını korumak gerekir.
 * Named argument kullanılırsa sırasını değiştirebiliriz
 *
 *
 * Çok uzun sayıda parametreye sahip olacaksam "variable number of arguments" - vararg tanımlanabilir.
 * Bu sayede fonksiyon tek bir parametre alıyor gibi gözükürken kendisine çok miktarda değişken atanabilir.
 * Bu değişkenlere array'e erişir gibi [index] ya da .get(index) erişebiliriz.
 *
 * vararg tek parametre ya da son parametre olarak yazılırsa JVM'e hazırlanırken Javadaki "String..." gibi
 * Ancak vararg param fonksiyonun son elemanı değilse JVM'e hazırlanırken arraye dönüştürür. Bu da çok küçük bir
 * performans kaybına sebep olur(array sınıfı daha yetenekli olduğu için)
 * Aynı forksiyon içerisinde birden fazla vararz tanımlanamaz.
 *
 * Bast Practice olarak parametre sayısı belli olmayanlar için vararg kullan. Çok parametresi varsa vararg kullanma.
 * Parametre sayısı 7'yi geçiyorsa bir class'ın içine wrap et.
 *
 * @sample getUserInfo
 * @sample getUserInfo2
 *
 * Bir fonksiyonana = koyularak return edeceği değer yazılabilir. (Single-Expression Kullanımı)
 * @sample getUserInfo3
 *
 * Default değeri olan parametrelere sahip bir fonksiyon Java sınıflarından çağırılacaksa eğer, bu fonksiyona @JvmOverloads
 * annotation'ı verilmelidir.
 * Böylece yazılan kod JVM'e hazır hale getirilirken ilgili fonksiyonun tüm varyaasyonları yazılır. (overload edilir)
 * @sample print
 *
 *
 * Extend edilebilir bir sınır, child sınıf tarafından miras alınırsa ve bu sınıfın override edilebilir open bir methodu
 * varsa, bu method default argumente sahip olursa, bu sınıfı miras alan sınıfta method override edilirse,
 * override edilen methodun parametresine default argument atanamaz.
 *@sample A
 *@sample B
 *
 * Any : Her şeyin başlangıcı, her sınıfın inherit aldığı class
 * Nothing: Nesnesi oluşturulamayan, en uç class.
 *
 * Nothing, Unit Farkı: Unit sonuç dönme, nothing anlamsız da olsa bir sonuç dön anlamına geliyor.
 *
 * Bir kod bloğunda her bir business lojik için tek satır olsa bile ayrı bir fonksiyon yazmak zorundayız!
 * If-else, toString, for döngüsü, mapleme vs. her biri ayrı bir business lojiktir.
 *
 */

fun main(args: Array<String>) {
    repeat(4)
    println("---------")
    repeat(4, 2)
    println("---------")
    print()
}

@JvmOverloads
fun print(message: String = "Message") {
    println(message)
}

fun getUserInfo(vararg userInfo: String, key: Int) {
    userInfo[3]
    userInfo.get(3)
}

fun getUserInfo2(key: Int,vararg userInfo: String,) {
    userInfo[3]
    userInfo.get(3)
}

fun getUserInfo3(user : String)  = "User =$user"



fun repeat(times: Int, startValue: Int = 0) {
    for (index in startValue until times) {
        print("$index     ")
    }

}

fun plusWithThree(number: Int): Int {
    return number + 3
}

fun assignValue() {
    val x = plusWithThree(2)
    println(x)
}

open class A {
    open fun foo(i : Int = 10 ) {}
}

class B : A() {
    override fun foo(i: Int) {
        //no default value allowed for "i"
    }
}