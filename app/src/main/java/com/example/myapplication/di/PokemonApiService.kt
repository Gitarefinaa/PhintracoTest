package com.example.myapplication.di

import com.example.myapplication.model.BaseModel
import com.example.myapplication.model.Pokemon
import com.example.myapplication.model.PokemonList
import io.ktor.client.*
import io.ktor.client.request.*
import javax.inject.Inject


class PokemonApiService @Inject constructor(private val httpClient: HttpClient) {
    val BASE_URL :String="https://pokeapi.co/api/v2/"
    suspend fun fetchPokemonList(): BaseModel<PokemonList>{
        val result: BaseModel<PokemonList> = httpClient.get(BASE_URL)
        return result
    }
    suspend fun  fetchPokemon(id:String):Pokemon{
        val result: Pokemon = httpClient.get("$BASE_URL"+"/Pokemon/"+"$id")
        return result
    }

}


