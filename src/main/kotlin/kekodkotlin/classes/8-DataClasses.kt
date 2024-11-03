package kekodkotlin.classes

/**
 * Primary constructur'ı olmalı ve en azından 1 tane parametre içermelidir. Bu parametre var/val ile yazılmalıdır.
 * var/val ile yazılmasının sebebi, generate edilen fonksiyonların constructor parametresine erişmesi gerekliliğidir.
 *
 * Visibility Modifierları kullanabilirim.
 * Default olarak  accessibility modifier'i final ve open yapamıyorum.
 * Abstract, open classları miras alabilir, interfaceleri implement edebiliriz.
 * Parametreleri default değer alabilir.
 * inner, sealed class yapılamaz.
 * Nested olarak kullanılabilir.
 * @sample PokemonData.ClassInPokemon
 * Companion object içerebilir.
 *
 * Member fonksiyonlar için componentN fonksiyon'ugenerate edilmez.Constructor propertyleri için generate edilir
 * Member fonksiyonlar hashCode, equals ve toString fonksiyonları generate edilirken kullanılmazlar. sadece constructor propertyleri kullanılır.
 *
 * Copy fonksiyonu generate edilir.
 *
 *
 */

class Pokemon(
    val name: String,
    val type: String,
    val age: Int,
    val origin: String,
)

data class PokemonData(
    val name: String,
    val type: String,
    val age: Int,
    val origin: String,
){



    class ClassInPokemon
}

fun main(args: Array<String>) {
    val pokemon = Pokemon("Squirtle", "Pokemon", 32, "")
    val pokemon2 = Pokemon("Squirtle", "Pokemon", 32, "")
    val pokemonData = PokemonData("Squirtle", "Pokemon", 32, "")
    val pokemonData2 = PokemonData("Squirtle", "Pokemon", 32, "")

    println(pokemon.hashCode())
    println(pokemon2.hashCode())
    println(pokemonData.hashCode())
    println(pokemonData2.hashCode())
    println(pokemonData2 === pokemonData)

}