package com.example.myapplication.retrofitNetwork

import com.example.myapplication.model.BaseModel
import com.example.myapplication.model.PokemonList
import retrofit2.http.GET
import retrofit2.http.Query

interface retrofitService {
    @GET("pokemon/{name}")
    suspend fun getAllPokemon(@Query("limit") limit: Int = 20, @Query("offset") offset: Int = 0): BaseModel<PokemonList>
}