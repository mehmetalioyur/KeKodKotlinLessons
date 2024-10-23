package kekodkotlin.functions


/**
 *
 * Bir higher order fonksiyonu decompile ettiğimizde bir nesne oluşturduğunu görürüz. Yani bir memory alanı işgal eder.
 * Bu işlem interface kullanımında da böyledir. Interface instance'ları da memory'de yer kaplar
 *
 * Higher order fonksiyona inline keywordünü eklediğimizdeyse, lambda parametresi build time sırasında higher order
 * fonksiyonunun çağırıldığı yere kopyalanır ve nesnesi oluşturulmaz.
 *
 * @sample runAndPrint2Transformed
 *
 * Ancak bu lambda fonksiyonun bodysi çok büyükse ve az kez çağırılıyorsa; build süresi performans artışını karşılamayabilir.
 *
 *
 * Higher order Function'da inline keywordunu kullandığımızda, birden fazla lambda fonksiyonu varsa, noinline ve
 * crossinline keywordlerini kullanmak anlamlı olabilir.
 *
 *
 * Inline - Noinline
 * Eğer inline fonksiyonun parametresindeki lambda, inline fonksiyonun bodysinde, inline olmayan bir başka bir
 * fonksiyona parametre olarak veriliyorsa hata alacağız.
 *
 * Çünkü inline olmayan fonksiyon nesne bekliyor. Ancak inline fonksiyonun parametresindeki lambda inline olduğu için
 * bir nesne oluşturmuyor.
 *
 * Inline olmayan fonksiyonu da inline yaparsak ya da inline fonksiyonun parametresindeki lambdaya "noinline"
 * keywordunu eklersek bu problem ortadan kalkacaktır.
 *
 * @sample runAndPrint3
 * @sample runAndPrint4
 * @sample log
 * @sample logInline
 *
 *
 * Non-Local Return
 * Döngülerde continue döngüyü bir atlatıyordu, break döngüden dışarı çıkarıyordu.
 * Ancak higher order ve return kullanıyorsak, döngünün bulunduğu fonksiyonun dışına çıkarır.Buna non-local return denir.
 * Higher Order Fonksiyon'ın non-local return etmesi gerekiyorsa bu fonksiyonun inline olması gerekir. Aksi halde hata alırız.
 * @sample callHigherOrderReturn
 *
 *
 * Inline - CrossInline
 * Eğer inline higher order fonksiyonun parametresindeki lambda'yı fonksiyon içinde çağırıyorsak, onun non-local return etmeyeceğini biliriz.
 * Ancak başka bir fonksiyona parametre olarak verirsek bilemeyiz.
 * Non local return etmeyeceğini bildiğimiz durumda parametrede crossinline keywordunu kullanarak, inline performans artışını sağlayabiliriz.
 * Ancak non-local return özelliğini kullanamayız.
 *
 *
 * crossinline kullanmayarak crossinline özelliği yaratmak için "contract" ile non-local return özelliği kullanmayacağımızı
 * beyan edebiliriz..

 *@sample callButtonClick
 */

fun main() {
    runAndPrint {
        println(it)
    }
    runAndPrint2Transformed(1, 1) {
        // println(it) ->  burası kopyalanacak
    }

    callHigherOrderReturn()
}

fun runAndPrint(run: (String) -> Unit) {
    run("Hello")
}

inline fun runAndPrint2Transformed(number1: Int, number2: Int, run: (String) -> Unit) {
    run("Hello") //Fonksiyon çağırıldığında
    // println(it) ->  buraya yapıştırılacak
}


//---------------------------------------------//
inline fun runAndPrint3(logger: (String) -> Unit, noinline logger2: (String) -> Unit) {
    //log(logger)
    log(logger2)
    logInline(logger)
}

inline fun runAndPrint4(noinline logger: (String) -> Unit) {
    log(logger)
    logInline(logger)
}

fun log(logger: (String) -> Unit) {
    println("Start")
}

inline fun logInline(logger: (String) -> Unit) {
    println("Start")
}
//---------------------------------------------//

fun callHigherOrderReturn() {
    // higherOrderReturnExample { return } -> Commenti kaldırdığımda hata verecek. Çünkü higher order fonksiyon inline keywordu olmadan returne izin vermiyor.

    higherOrderReturnExample { return@higherOrderReturnExample }  // LOCAL(LABELED) RETURN
    higherOrderReturnExample2 { return@higherOrderReturnExample2 }  // LOCAL(LABELED) RETURN

    println("Before Return")
    higherOrderReturnExample2 {
        println(it);
        return /* NON-LOCAL RETURN */
    }
    println("After Return") // çalışmayacak
}

fun higherOrderReturnExample(x: (String) -> Unit) {
    x.invoke("")
}

inline fun higherOrderReturnExample2(x: (String) -> Unit) {
    x.invoke("In Lambda"); return /* LOCAL RETURN */
}

//---------------------------------------------//


fun invokeButtonClick(lambda: (String) -> Unit) {
    lambda.invoke("")
}

inline fun callButtonClick(crossinline lambda: (String) -> Unit) {
    //Inline olmayan hof çağırdım, local return ok.
    invokeButtonClick {
        lambda(it)
        return@invokeButtonClick
    }

    //Inline olmayan hof çağırdım, non-local return hata.
    invokeButtonClick {
        lambda(it)
        //return
    }

    //Inline olmayan hof'u parametremdeki hof'a verdim. Hata.
    //invokeButtonClick(lambda)

}









