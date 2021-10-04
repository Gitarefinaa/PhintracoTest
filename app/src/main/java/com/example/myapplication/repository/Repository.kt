package com.example.myapplication.repository

import com.example.myapplication.di.PokemonApiService
import com.example.myapplication.model.BaseModel
import com.example.myapplication.model.PokemonList
import com.example.myapplication.retrofitNetwork.retrofitService
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.get
import io.ktor.client.request.*
import javax.inject.Inject

class Repository@Inject constructor(private val api: retrofitService,private val ktorNetworkService:PokemonApiService):RepositorySource {
    val BASE_URL:String =""

    override suspend fun getPokemonList(): BaseModel<PokemonList> {
        try {
            val dataPokemon = api.getAllPokemon()
            return dataPokemon
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun fetchPokemonList(): BaseModel<PokemonList> {
        val tempSongs = ktorNetworkService.fetchPokemonList()
        return tempSongs
        }
    }




