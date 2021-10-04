package com.example.myapplication.database

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.model.BaseModel
import com.example.myapplication.model.Pokemon
import com.example.myapplication.model.PokemonList
import com.example.myapplication.utils.Resource

interface pokemonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun  insertPokemon(pokemon: Pokemon)

    @Query("SELECT * FROM pokemon")
    suspend fun   getMyPokemonList():Resource<BaseModel<Pokemon>>


}