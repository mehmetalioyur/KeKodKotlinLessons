package kekodkotlin.loops


/**
 *
 *  3 farklı şekilde for tanımlayabiliriz.
 *  value in list şeklinde                      value değerlerini alabiliriz.
 *  index in list.indices şeklinde              index değerleirni alabiliriz.
 *  (index,value) in list.withIndex() şeklinde  index, value değerlerini alabiliriz. Destrucati
 *  @sample forLoopDeclarationSample()
 *
 *  repeat(size) şeklinde herangi bir listeye ihtiyaç duymadan tekrarlanan işler yapabiliriz.
 *  @sample loopWithRepeatExample
 *
 *
 * return kullanarak ilgili şart sağlanırsa, döngüden çıkabiliriz.
 * continue kullanarak ilgili şart sağlanırsa, o değereyi atlayarak devam edebiliriz.
 * @sample forLoopReturnContinueExample
 *
 * iç içe for döngüleri kullanıyorsak bir üstteki for'a değil de daha üstlerdeki for'a dönmek istiyorsak label kullanabiliriz.
 * Bunun için "labelname@" ifadesini ilgili for'uun önüne yazabilir, return ya da continue yapılacak yere ise @labelname
 * şeklinde yazabiliriz.
 *
 */
fun main(args: Array<String>) {
    forLoopDeclarationSample()
    println("---------------------------------------------------------------------------")
    loopWithRepeatExample()
    println("---------------------------------------------------------------------------")
    forLoopReturnContinueExample()
    println("---------------------------------------------------------------------------")
    forLoopLabelReturnContinueExample()
    println("---------------------------------------------------------------------------")
}

fun forLoopDeclarationSample() {

    for (value: Int in 1..10) {
        print("$value")
    }

    val countryCodeArray = arrayOf("tr", "az", "en", "ru", "fr")

    //1. gösterim
    for (value in countryCodeArray) {
        print("$value ")
    }

    //2. gösterim
    for (index in countryCodeArray.indices) {
        print("\n$index değeri : ${countryCodeArray[index]}")
    }

    //3. gösterim -
    for ((index, value) in countryCodeArray.withIndex()) {
        print("\n$index değeri : $value")
    }
}

fun loopWithRepeatExample() {
    repeat(10) {
        println("$it.Tekrar")
    }
}

fun forLoopReturnContinueExample() {
    for (i in 1..10) {
        if (i % 2 == 1) {
            continue
        }
        println("$i")
    }

    println("------------------------------")
    for (i in 1..10) {
        if (i % 7 == 5) {
            break
        }
        println("$i")
    }

}

fun forLoopLabelReturnContinueExample() {
    for (i1 in 1..2) {

        returnLabel@ for (i2 in 1..3) {
            for (i3 in 1..3) {
                if (i3 == 2) {
                    continue@returnLabel
                }
                println("first loop. Value is : $i1---second loop. Value is : $i2---third loop. Value is : $i3")
            }
        }
    }
    println("-----------")

    for (i1 in 1..2) {

        returnLabel@ for (i2 in 1..3) {
            for (i3 in 1..3) {
                if (i3 == 2) {
                    break@returnLabel
                }
                println("first loop. Value is : $i1---second loop. Value is : $i2---third loop. Value is : $i3")
            }
        }
    }

}