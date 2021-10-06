package com.example.myapplication.model
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable


@Serializable
@Entity
data class Pokemon(
    @ColumnInfo(name = "abilities") val abilities: List<Ability>? = null,

    @ColumnInfo(name = "base_experience") val base_experience: Int? = null,

    @ColumnInfo(name = "forms") val forms: List<PokemonList>? = null,

    @ColumnInfo(name = "game_indices") val gameIndices: List<GameIndex>? = null,

    @ColumnInfo(name = "height")  val height: Int? = null,

    @ColumnInfo(name = "held_items")  val held_items: List<HeldItem>? = null,

    @PrimaryKey  @ColumnInfo(name = "id") val id: Int? = null,

    @ColumnInfo(name = "is_default")  val is_default: Boolean? = null,

    @ColumnInfo(name = "location_area_encounters")  val location_area_encounters: String? = null,

    @ColumnInfo(name = "moves")  val moves: List<Move>? = null,

    @ColumnInfo(name = "name")  val name: String? = null,

    @ColumnInfo(name = "order")  val order: Int? = null,

    @ColumnInfo(name = "species")  val species: PokemonList? = null,

    @ColumnInfo(name = "sprites")  val sprites: Sprites? = null,

    @ColumnInfo(name = "stats")  val stats: List<Stat>? = null,

    @ColumnInfo(name = "types")  val types: List<PokeType>? = null,

    @ColumnInfo(name = "weight")  val weight: Int? = null
)