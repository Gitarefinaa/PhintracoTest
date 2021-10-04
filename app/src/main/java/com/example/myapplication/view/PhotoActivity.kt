package com.example.myapplication.view
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.adapter.AdapterGridPhoto
import com.example.myapplication.adapter.LoadingAdapter
import com.example.myapplication.databinding.ActivityPhoto2Binding
import com.example.myapplication.viewModel.PhotoViewModel
import dagger.hilt.android.AndroidEntryPoint
@AndroidEntryPoint
class PhotoActivity : AppCompatActivity(),AdapterGridPhoto.onItemClickListener {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityPhoto2Binding
    private lateinit var adapterGrid :AdapterGridPhoto
    private val viewModel by viewModels<PhotoViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPhoto2Binding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.viewModel =viewModel
        listView()
    }

    fun listView(){
            var layoutManager : LinearLayoutManager = LinearLayoutManager(this)
            binding.rvPhoto.layoutManager = layoutManager
            adapterGrid = AdapterGridPhoto(this)
            adapterGrid.withLoadStateHeaderAndFooter(
                header = LoadingAdapter{AdapterGridPhoto(this)},
                footer = LoadingAdapter{AdapterGridPhoto(this)}
            )

    }

    override fun onItemClick(pokemon: String?) {
        var intent = Intent(this,PhotoDetailActivity::class.java)
        intent.putExtra("url","pokemon")
    }


}