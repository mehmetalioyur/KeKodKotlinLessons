package kekodkotlin.controlflow

/**
 * Bir number değişkenin başına veya sonuna toplama-çıkarma operatörleri eklenebilir.
 * Operatör değişkenin önüne eklendiğinde önce matematiksel işlem yapılır. Sonrasında atama yapılır.
 * Operatör değişkenin sonuna eklendiğinde önce atama yapılır, sonra matematiksel işlem yapılır.
 *@sample operatorPriorityExample
 *
 * Matamtik işlemleri hem operatörlerle (+,-,*,/,%) hem de operatör fonksiyonlarla(plus, minus, times, div, rem) yapılabilir.
 * Değer atama işlemleri +=, -+, *=, /= %= ile yapılabilir
 * @sample mathOperationsExample
 *
 * Kıyaslamalar için büyüktür(>), küçüktür(<), eşittir(==), küçük eşittir(<=), büyük eşittir(>=) operatörlerini ve
 * equals() ve compareTo() operatör fonksiyonlarını kullanabiliriz.
 *
 * x.compareTo(y) sonucu; x büyükken 1 y büyükken -1 eşitlikte 0 döndürür. Değerler nullable olduğunda kullanışlı olabilir.
 * x.equals(y) sonucu;
 *
 *
 * @sample findFinalGrade
 */

fun main() {
    findFinalGrade()
    println("--------------------------------------")
    mathOperationsExample()
}

fun operatorPriorityExample() {
    var numberOne = 10
    val numberTwo = 5

    println("Number One: $numberOne") // 10
    println("Number One: ${numberOne++}") // 11
    println("Number One: $numberOne") // 11
    println("Number One: ${++numberOne}") // 12
}

fun mathOperationsExample() {
    var numberOne = 10
    val numberTwo = 5

    print("${numberOne + numberTwo}")
    println("${numberOne.plus(numberTwo)}")

    print("${numberOne - numberTwo}")
    println("${numberOne.minus(numberTwo)}")

    print("${numberOne * numberTwo}")
    println("${numberOne.times(numberTwo)}")

    print("${numberOne / numberTwo}")
    println("${numberOne.div(numberTwo)}")

    print("${numberOne % numberTwo}")
    println("${numberOne.rem(numberTwo)}")

    println("---------------------------")

    var x = 20
    var y = 5

    x += y
    println(x)
    x -= y
    println(x)
    x *= y
    println(x)
    x /= y
    println(x)
    x %= y
    println(x)


}

fun findFinalGrade() {
    print("Sınav Notunu giriniz : ")
    val grade = readln().toInt()
    val charGrade = if (grade == 100) {
        "A"
    } else if (grade < 100 && grade > 80) {
        "B"
    } else if (grade < 80 && grade > 60) {
        "C"
    } else if (grade < 60 && grade > 40) {
        "D"
    } else if (grade >= 0 && grade < 40) {
        "F"
    } else {
        "Hata"
    }
    println("Sınav Notunuz : $charGrade")

    println(grade.compareTo(100) == -1) //iki kontrol var. zorunda kalmadıkça kullanma.
    println(grade.compareTo(100) == 0)
    println(grade.compareTo(100) == 1)
    println(grade.equals(100))
    println(grade.equals(100).not())
}

