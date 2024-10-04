package kekodkotlin.functions


/**
 *
 * Bir fonksiyon herhangi bir sınıfın içerisinde değil de bir dosyanın içerisinde boşlukta tanımlanıyorsa o
 *  "Top Level Function" adını alır.
 *
 * Bir fonksiyon oluşturulurken top level tanımlama yapılamıyor, sadece bir sınıfa ait fonksiyonlar yazılabiliyorsa
 * ona fonksiyon değil, method denir. Bir fonksiyona fonksiyon diyebilmemiz için top level tanımlanır.
 *
 *
 * Fonksiyon içerisinde fonksiyon tanımı kotlin'de yapılabilir. Bu fonksiyonlara "Local Functions" denir.
 * Sebebi ise, yazılan bu fonksiyonun kendi sınıfından dahi çağırılmamasının istenmesidir.
 * Bu fonksiyonun herhangi bir başka fonksiyon ya da sınıf için değiştirilmemesini istemeyebiliriz.
 * Refrection ile fonksiyonlar erişilirken gizli kalmasını isteyebiliriz.
 * Bu gibi durumlarda bu çok onemli fonksiyonumuzu başka bir fonksiyon içerisine yazmalıyız.
 * @sample topLevelFunction
 *
 */

fun main(){}


fun topLevelFunction() {
    fun localFunction() {}
}