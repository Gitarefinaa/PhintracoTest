package com.example.myapplication.view
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.adapter.AdapterPokemonList
import com.example.myapplication.adapter.LoadingAdapter
import com.example.myapplication.databinding.ActivityPhoto2Binding
import com.example.myapplication.viewModel.PokemonListViewModel
import dagger.hilt.android.AndroidEntryPoint
@AndroidEntryPoint
class PhotoActivity : AppCompatActivity(),AdapterPokemonList.onItemClickListener {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityPhoto2Binding
    private lateinit var adapterGrid :AdapterPokemonList
    private val viewModel by viewModels<PokemonListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPhoto2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewModel =viewModel
        listView()
    }

    fun listView(){
            viewModel.fetchPokemonList().let{res->
                val a = res
                var layoutManager : GridLayoutManager = GridLayoutManager(this,2)
                binding.rvPhoto.layoutManager = layoutManager
                adapterGrid = AdapterPokemonList(this)
                adapterGrid.withLoadStateHeaderAndFooter(
                    header = LoadingAdapter{AdapterPokemonList(this)},
                    footer = LoadingAdapter{AdapterPokemonList(this)}
                )
            }



    }

    override fun onItemClick(pokemon: String?) {
        var intent = Intent(this,PhotoDetailActivity::class.java)
        intent.putExtra("url","pokemon")
    }


}