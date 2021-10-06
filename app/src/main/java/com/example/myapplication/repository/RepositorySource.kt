package com.example.myapplication.repository

import com.example.myapplication.model.BaseModel
import com.example.myapplication.model.Pokemon
import com.example.myapplication.model.PokemonList


interface RepositorySource {
    suspend fun getPokemonList():BaseModel<PokemonList>
    suspend fun fetchPokemonList():BaseModel<PokemonList>
    suspend fun getPokemonDetail(id:String): Pokemon

}

