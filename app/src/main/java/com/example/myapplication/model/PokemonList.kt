package com.example.myapplication.model
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity
data class PokemonList(

    @ColumnInfo(name = "name")
    val name: String? = null,
    @PrimaryKey
    @ColumnInfo(name = "url")
    val url: String? = null
)






