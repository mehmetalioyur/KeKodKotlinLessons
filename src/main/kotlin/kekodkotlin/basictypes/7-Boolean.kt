package kekodkotlin.basictypes


/**
 * 8 bit yer kaplarlar.
 *
 * true ya da false değer ataması için kullanılır. Nullable versiyonları null değer de alır.
 *
 * 0 ya 1 Boolean olarak kullanılmaz
 *
 *  || (or) - && (and) - ! (not) gibi operatörler ile beraber kullanılır.
 *
 *  -----------------------------------------------------------------------------------------------
 * || ve && operatörleri lazily çalışma mekanizmasına sahiptir.
 * Eğer || operatörünün solu true ise sağdaki değere bakmaya gerek duymaz ve true kabul eder.
 * Eğer && operatörünün solu false ise sağdaki değere bakmaya gerek duymaz ve false kabul eder.
 *
 *
 *  true && true  = true  -> İki değer de kontrol edilir.
 *  true && false = false -> İki değer de kontrol edilir.
 *  false && true = false -> Sol değerin kontrol edilmesi yeterlidir.
 *  false && false = false -> Sol değerin kontrol edilmesi yeterlidir.
 *
 *  true || true  = true  -> Sol değerin kontrol edilmesi yeterlidir.
 *  true || false = true  -> Sol değerin kontrol edilmesi yeterlidir.
 *  false || true = true  -> İki değer de kontrol edilir.
 *  false || false = false -> İki değer de kontrol edilir.
 *
 */

fun main() {
}

fun logicOperatorExample() {
    val isStudent = false
    val isTeacher = true

    if (isStudent && isTeacher) { }
    if (isStudent and isTeacher) { }
    if (isStudent.and (isTeacher)) { }

    if (isStudent || isTeacher) { }
    if (isStudent or isTeacher) { }
    if (isStudent.or(isTeacher)) { }
    
    if (!isStudent) { }
    if (isStudent.not()) { }
}
