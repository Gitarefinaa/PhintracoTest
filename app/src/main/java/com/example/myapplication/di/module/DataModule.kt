package com.example.myapplication.di.module

import android.app.Application
import android.content.Context
import androidx.room.Dao
import com.example.myapplication.PokemonApp
import com.example.myapplication.database.pokemonDao
import com.example.myapplication.database.pokemonDatabase
import com.example.myapplication.di.PokemonApiService
import com.example.myapplication.repository.Repository
import com.example.myapplication.repository.RepositorySource
import com.example.myapplication.retrofitNetwork.retrofitService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DataModule {
    @Singleton
    @Provides
    fun remoteRepositorySource( api: retrofitService,  apiservice: PokemonApiService): Repository {
        return Repository(api,apiservice)

    }



}