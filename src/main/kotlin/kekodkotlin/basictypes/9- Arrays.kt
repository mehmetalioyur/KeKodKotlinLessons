package kekodkotlin.basictypes

/**
 * Aynı türden ya da belirtilen türün alt türlerinden, sabit sayıda veri tutan bir veri yapısıdır.
 * En sık kullanılan versiyonu Object-Type Array'lerdir.
 *
 * Primitive tipleri Object-Type Array olarak kullanırsak Boxed kullanım yapmış oluruz. Bu da performansa etki eder.
 * Eğer sadece primitive'lerden oluşan arrayler oluşturacaksak, bu durumda Primitive-Type arraylar kullanmak mantıklıdır.
 *
 * .toTypedArray() fonksiyonu ile Primitive-Type bir array Object-Typed bir array'e dönüştürülür.
 * .toCharArray() gibi fonksiyonlar ile Object-Typed bir array bir  Primitive-Type  array'e dönüştürülür.
 *
 * Bu tarz tanımlamalarda ilgili ildex değerine atama için set(index, value) ya da [index]= value kullanılabilir.
 * Bu tarz tanımlamalarda ilgili ildex değerine ulaşmak için get(index) ya da [index] kullanılabilir.
 *

 * @sample primitiveArrayDefinition
 *
 * Primitive Arraylar;
 * ByteArray(),
 * ShortArray(),
 * IntArray(),
 * LongArray(),
 * DoubleArray(),
 * FloatArray,
 * BooleanArray(),
 * CharArray()
 *
 *
 * Arraylar;
 * arrayOf(Aynı tür değerler)
 * arrayOf<Any>(Farklı tür değerler)
 * arrayOfNulls<Type>(size) -> Size'ı kadar o değeri içeren null eleman
 * emptyArray<Type>() -> boş array
 * olarak tanımlanabilir.
 * @sample getArrayDefinitionExample
 *
 * Array'ler sabit büyüklüktedir. Array'lere ekleme ve çıkarma yapmak Stringlerde olduğu gibi memoryde yeni bir Array oluşturulmasına neden olur.
 * Bu yüzden ekleme-çıkarma işlemleri için collectionlar daha performanslıyken, gösterim için arrayler daha performanslıdır.
 * @sample addNewElementInArray
 *
 * Arrayde yapılan her değişiklik heap'te yeni bir referans yarattığı için özellikle array'e ekleme yapmak memory menagement için kötü bir practicedir.
 *
 * Array<Type>(size) {higher order function} şeklinde de array tanımlanabilir.
 * Bu durumda higher order function içerisinde son satıra denk gelen değerler diziyi oluşturur.
 * Higher order function, içerisindeki dizinin boyutu kadar indexi bir arttırarak çalışır.
 * @sample higherOrderArrayDefinition
 *
 *
 * val ile tanımlanmış bir array'in herhangi bir index'indeki değer değiştirilebilir. Bu yüzden mutable'dır.
 * Ancak ilgili diziyi başka bir dizi atamamıza izin verilmez. Bunun için var yapmamız gerekir.
 * @sample mutableArraySample
 *
 *
 * Array içinde array (multi dimensional) tanımlayabiliriz.
 * @sample multiDimensionalArraySample
 *
 *
 * Any olan bir arrayin elemanına string atayabilirim. Ancak string array'ini any arrayinin yerine veremem.(in-variant)
 * @sample arrayInVarianceSample
 *
 *
 * vararg kelimesi ile istediğimiz sayıda parametreyi kabul edebiliriz.
 * Eğer vararg'a denk gelecek şekilde bir array kullanmak istiyorsak "*" -> "Spread" operatörünü kullanırız.
 * Spread operatörü verdiğimiz arrayin elemanlarının her birini bir variable olacak şekilde parametre olarak paslar.
 * @sample varargSample
 *
 *
 * Array'leri karşılaştırırken == operatörünü kullanamayız. == operatörü o array'lerin referans objecy'lerini karşılaştırır.
 * contentEquals yada contentDeepEquals kullanmamaız gerekiyor.
 * @sample contentDeepEquals
 *
 * Array ile yapılabilecek işlemler -> https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/
 *
 *
 * Arrayler collectionlara çevrilebilir. (Örnek : .toList())
 * Map'e dönüştürülebilir ancak bunun için arrayin pair sınıfından oluşması gerekir.
 * @sample arrayToMapSample
 */

fun main() {
    getArrayDefinitionExample()
    println("----------------------------------------------------------------------------------------------------")
    addNewElementInArray()
    println("----------------------------------------------------------------------------------------------------")
    higherOrderArrayDefinition()
    println("----------------------------------------------------------------------------------------------------")
    primitiveArrayDefinition()
    println("----------------------------------------------------------------------------------------------------")
    multiDimensionalArraySample()
    println("----------------------------------------------------------------------------------------------------")
    arrayEqualitySample()
}

fun getArrayDefinitionExample() {
    val studentNumber = arrayOf(1, 2, 3, 4, 5)
    val studentNames = arrayOf("Ahmet", "Mehmet", "Ayşe")
    val firstCharOfNames = arrayOf('A', 'M', 'A')

    val mixedArray = arrayOf<Any>(13, "Ahmet", 'M', true) // değişkenlerin boxed halini içerir
    val mixedArray2 = arrayOf<Number>(13, 13f, 13.0, 13L, 13.toShort())

    val arrayOfNulls = arrayOfNulls<String>(4)
    println("Array Of Nulls : ${arrayOfNulls.joinToString()}")


    val emptyArray = emptyArray<Boolean>()
    val emptyArray2: Array<String> = emptyArray()
}


fun addNewElementInArray() {
    var citiesArray = arrayOf("Denizli", "Antalya", "İzmir")
    //citiesArray[4] = "Ankara" // bu şekilde ekleme yapılamıyor.

    citiesArray += "Sivas" // bu şekilde ekleme yapılıyor. Heap'te eski referansının yerini bu alıyor.
    citiesArray += arrayOf("Luxembourg", "İstanbul")
    println(citiesArray.joinToString())
}

fun higherOrderArrayDefinition() {
    val piTimesArray = Array(5) {
        // pseudo code
        // pseudo code
        // pseudo code
        3.14 * it
    }
    println("Pi : " + piTimesArray.joinToString())
}

fun primitiveArrayDefinition() {


    val firstCharOfCountries = CharArray(4)
    firstCharOfCountries[0] = 'T'
    //firstCharOfCountries.set(0, 'T')

    println(firstCharOfCountries.joinToString())
    println(firstCharOfCountries[2])

    firstCharOfCountries[3] = 'C'
    firstCharOfCountries.set(1, 'A')
    firstCharOfCountries.set(2, 'B')

    val firstCharOfCountries4 = arrayOf('A', 'B', 'C') // az performanslı
    val firstCharOfCountries2 = arrayOf('A', 'B', 'C').toCharArray()  // çok performanslı
    firstCharOfCountries2.toTypedArray() //
}

private fun mutableArraySample() {
    val awesomeArray = arrayOfNulls<String>(5)
    awesomeArray[2] = "Mehmet"
    awesomeArray[4] = "Ali"
    //awesomeArray[5] = "Muhammet" //index out of bounds exception
    //awesomeArray = arrayOf("Dilek") //
}

private fun multiDimensionalArraySample() {
    val twoDArray = Array(2) { Array(2) { 0 } }
    val threeDArray = Array(3) { Array(3) { Array(3) { 0 } } }

    println(twoDArray.contentDeepToString())
    println(threeDArray.contentDeepToString())

    twoDArray[1][1] = 1
}

private fun arrayInVarianceSample() {
    val stringArray = arrayOf("Adana", "Bursa", "Ceyhan")
    var anyArray = arrayOf<Any>("Adana", "Bursa", "Ceyhan")

    anyArray[1] = "Denizli"
    //anyArray = stringArray // -> Type mismatch. Required: Array<Any> Found: Array<String>
}

fun varargSample() {
    fun printNames(vararg names: String) {
        names.forEach { println(it) }
    }

    val nameArray = arrayOf("Duygu", "Şahin")

    printNames("Barış", "Mehmet", "Ayşe", "Duygu", "Şahin")
    printNames("Barış", "Mehmet", "Ayşe", *nameArray)
    printNames(*nameArray, "Barış", "Mehmet", "Ayşe")
}

fun arrayEqualitySample() {
    val array1 = intArrayOf(1, 2, 3)
    val array2 = intArrayOf(1, 2, 3)

    println(array1 == array2)
    println(array1.contentEquals(array2))

    println("Second Sample")
    val array3 = arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))
    val array4 = arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))
    println(array3.contentDeepEquals(array4))
}

fun arrayToMapSample() {
    val cities = arrayOf(20 to "Denizli", 35 to "İzmir", 7 to "Antalya")
    cities.toMap()
}