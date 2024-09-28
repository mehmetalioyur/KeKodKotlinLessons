package kekodkotlin.loops

/**
 *
 * Diğer dillerde nasıl kullanıyorsak Kotlin'de de aynı şekilde kullanılırız.
 * Eğer bir döngüye ihtiyacımız varsa ve döngü sırasında if else ile bir şartlı duruma ihtiyacımız varsa
 * bu druumda "for ve if-else" kullanmak yerine while kullanabiliriz.
 * @sample whileDeclarationSample
 */

fun main() {
    whileDeclarationSample()
}

fun whileDeclarationSample() {
    var number = 0
    while (number < 5) {
        print("${number++} , ")
    }
    println("-------------------------------")
    for (value in 1..Int.MAX_VALUE) {
        if (value < 5){
            print("$value , ")
        } else {
            break
        }
    }
}