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
class PokemonDetailViewModel @Inject constructor(private  val repository: Repository) : ViewModel(),LifecycleObserver {

}