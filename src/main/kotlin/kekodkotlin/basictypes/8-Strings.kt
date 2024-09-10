package kekodkotlin.basictypes

import java.util.*


/**
 *
 * String primitive tip değildir ama özel optimizasyonlarla primitive hızında çalışır.
 *
 *
 * Yaklaşık olarak her karakter başına 2 byte yer kaplar. UTF-16 encoding kullanır.
 * Çift tırnak içerine yazılan karakterler bütünüdür.
 * Bir string ifadenin tüm karakterlerini tek tek alıp char bir listeye atayabilir ya da ekrana yazırabiliriz.
 * @sample charAndStringRelationExample
 *
 *
 * Stringler immurable'dır. Bir string ilk değer ataması yapıldıktan sonra değerini değiştiremez ya da yeni bir değer
 * set edilemez. String üzerinde yapacağımız tüm işlemler bizlere yeni bir String object'i dönecektir ve yeni object işaret edilecektir.
 * Garbage collector eskiyi işaret eden bir name olamdığı için onu silecektir.
 * String'in ilk hali değişmeyecektir.
 * Bunun sebebi ayırılan yer ile ilgilidir. 5 haneli string(10 byte), 8 haneli bir string(16 byte) ile değiştirildiğinde
 * eski alanı kullanamaz.
 *
 *
 * Farklı tipteki bir değişkenin önüne String bir değişken ya da ifade koyarak toplarsak, sonuç String olacaktır.
 * Ancak String bir değişkenin ya da ifadenin sonuna + operatörü ile farklı bir tipte bir değişken eklersek, kod çalışmaz.
 * @sample stringAndNumberRelationExample
 *
 *
 * Herhangi bir değişken + operatörüne ihtiyaç duyulmadan direkt olarak "" arasına yzılarak kullanılabilir.
 * Bunun için sadce $ işaretine ihtiyaç vardır. Bu yapıya String Template denir.
 * Eğer değişkenin Bir özelliğine ihtiyaç duyulmayacaksa ${] şeklinde kullanılabilir.
 *@sample stringTemplateUsageExample
 *
 *
 * 3 tane çift tırnak kullanarak Row string (Multiline String) oluşturulabilir.
 * Row Stringler ide'ye nasıl yazılıyorsa öyle kullanılır. Hizalamada bozulma olmaz.
 *
 * trimIndent() fonksiyonu ile bu Raw String'in kenar boşluklarını silebiliriz. Bu silme işlemini yaparken tüm
 * satırlardaki en soldaki karakterleri en soldaki karakteri baz alarak silme işlemini sağlar.
 * Alttaki örnek için 3 satırdan da $ işaretinin solundaki boşluğa kadarını siler.
 * @sample getRawPineTree
 *
 * trimMargin(marginPrefix) ise verilen karakter ne ise, string satırlarındaki o kadaktere kadar olan kısmı siler.
 * Yukarıdan farklı olarak bu karakter tek bir satırda ise, sadece o satırın o karaktere kadar olan kısmı silinir.
 * trimMargin() ise o karaktere bakmadan tüm satırların en solundaki değeri baz alıp, tüm satırlardan o değerin solundaki boşluk kadar boşluk siler.
 * @sample getRawPineTree2()
 *
 * Row Stringlerin içinde escape karakterler(\) çalışmaz.
 * Row Stringler içinde escape characterler kullanmak için ${'$'} yapısı kullanılabilir.
 *@sample rowStringWithEscapeCharacters(){
 *
 * Kotlin'de String.format() metodu, Java'nın String.format() metoduna çok benzer bir şekilde çalışır.
 * Bu metod, belirli bir string içinde yer tutucuları belirtilen değerlerle değiştirerek yeni bir string oluşturmamıza olanak sağlar.
 * Yer tutucular, formatlama belirtimleriyle tanımlanır ve bu belirtimler, değiştirilecek değerlerin nasıl biçimlendirileceğini kontrol eder.
 *
 * %s : String
 * %d : Tam sayı
 * %f : Ondalıklı sayı
 * %n : Yeni bir satıra geçmek için kullanılır.
 * @sample stringWithPlaceHoldersExample()
 *
 */

fun main() {
    charAndStringRelationExample()
    stringAndNumberRelationExample()
    getRawPineTree()
    getRawPineTree2()
    rowStringWithEscapeCharacters()
    stringWithPlaceHoldersExample()
}

fun charAndStringRelationExample() {
    val name = "KeKod"
    val char1 = 'K'
    val char2 = 'e'
    val char3 = 'K'
    val char4 = 'o'
    val char5 = 'd'
    val nameArray = charArrayOf(char1, char2, char3, char4, char5)

    for (char in nameArray) {
        print(char)
    }

    println()

    for (char in name) {
        print(char)
    }
    println()

}

fun stringAndNumberRelationExample() {
    val stringFirst = "value" + (4 + 2 + 8)
    //val numberFirst = (4 + 2 + 8) + "value" çalışmaz!
    println(stringFirst)
}

fun stringTemplateUsageExample() {
    val numberValue = "92"
    println("numberValue " + numberValue) // Java syntax
    println("numberValue $numberValue") // Kotlin String Template Syntax
    println("numberValue ${numberValue.length}") // Kotlin String Template. Ve stringin özelliğine ihtiyaç duyduğumuz için {} kullanıyoruz.
    println("numberValue \$numberValue") // dolar işaretini string elemanı olarak kullanıyoruz.
}

fun getRawPineTree() {
    val rawPineTree =
        """
               *
       $      ***
             ***** 
        """.trimIndent()
    println(rawPineTree)
}

fun getRawPineTree2() {
    val rawPineTree =
        """
               *
       $      ***
             ***** 
        """.trimMargin("$")
    println(rawPineTree)
}

fun rowStringWithEscapeCharacters() {
    val priceNormal = "Price \$_9.99"

    val price = """
        Price ${'$'}_9.99
    """.trimIndent()

    println(priceNormal)
    println(price)
}

fun stringWithPlaceHoldersExample() {
    val yas = 30
    val mesaj = String.format("%d", yas)
    println(mesaj)

    val boy = 1.8912312313123123f
    val boyMesaj = String.format("Boyum: %.2f metre", boy)
    println(boyMesaj) // .2 ondalık basamak

    val ad = "Mehmet"
    val kisiBilgisi = String.format("Adım: %s, Yaşım: %d, Boyum: %.2f", ad, yas, boy)
    println(kisiBilgisi)

    val sayi = 1234567.89
    val usFormat = String.format(Locale.US, "US formatında: %,.2f", sayi)
    println(usFormat)

// Türkçe için Locale nesnesi, "tr" ISO 639 dil kodu ve "TR" ISO 3166 ülke kodu ile oluşturulabilir.
    val localeTR = Locale("tr", "TR")
    val usFormatTR = String.format(localeTR, "TR formatında: %,.2f", sayi)

    println(usFormatTR)
}