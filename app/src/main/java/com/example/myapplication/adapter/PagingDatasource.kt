package com.example.myapplication.adapter

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.myapplication.model.PokemonList
import com.example.myapplication.repository.Repository
import retrofit2.HttpException
import java.io.IOException
private const val PAGE_INDEX = 1

class PagingDatasource(private val repository: Repository): PagingSource<Int, PokemonList>() {
    override val keyReuseSupported: Boolean = true
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PokemonList> {
        val position = params.key ?: PAGE_INDEX
        val response = repository.fetchPokemonList().results
        return try {
            LoadResult.Page(data = response,prevKey =  if (position == PAGE_INDEX) null else position - 1,nextKey = if (response.isEmpty()) null else position + 1)
        }
        catch (e: IOException) {
            Log.d("UnsplashPagingSource", "load: Internet Error"+e.toString())
            LoadResult.Error(e)
        } catch (e: HttpException) {
            // server error
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, PokemonList>): Int? {
        TODO("Not yet implemented")
    }


}