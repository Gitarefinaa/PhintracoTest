package com.example.myapplication.viewModel

import android.util.Log
import androidx.lifecycle.*
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.myapplication.adapter.PagingDatasource
import com.example.myapplication.model.PokemonList
import com.example.myapplication.repository.Repository

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow

import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(private  val repository: Repository) : ViewModel(),LifecycleObserver {
    lateinit var poto: Flow<PagingData<PokemonList>>
    fun fetchPhotoList() {
        Pager(
            config = PagingConfig(
                5,10,true,10
            ),
            pagingSourceFactory = { PagingDatasource(repository) }
        ).flow
    }

    fun fetchPokemonList() {
        Pager(
            config = PagingConfig(
                5,10,true,10
            ),
            pagingSourceFactory = { PagingDatasource(repository) }
        ).flow
    }

}