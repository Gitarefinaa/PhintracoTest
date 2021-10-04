package com.example.myapplication.model
import kotlinx.serialization.Serializable


@Serializable
data class Pokemon(
val abilities: List<Ability>? = null,

val baseExperience: Int? = null,

val forms: List<PokemonList>? = null,

val gameIndices: List<GameIndex>? = null,

val height: Int? = null,

val heldItems: List<HeldItem>? = null,

val id: Int? = null,

val isDefault: Boolean? = null,

val locationAreaEncounters: String? = null,

val moves: List<Move>? = null,

val name: String? = null,

val order: Int? = null,

val species: PokemonList? = null,

val sprites: Sprites? = null,

val stats: List<Stat>? = null,

val types: List<PokeType>? = null,

val weight: Int? = null
)