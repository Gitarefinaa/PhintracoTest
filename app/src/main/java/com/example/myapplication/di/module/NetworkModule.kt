package com.example.myapplication.di.module

import com.example.myapplication.di.PokemonApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ServiceComponent
import dagger.hilt.android.scopes.ServiceScoped
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @ServiceScoped
    @Provides
    fun httpKtorClient(): HttpClient = HttpClient(CIO) {
        install(JsonFeature) {
            serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
        defaultRequest {

        }
    }
    @ServiceScoped
    @Provides
    fun pokemonApiService(httpClient: HttpClient): PokemonApiService = PokemonApiService(httpClient)



}