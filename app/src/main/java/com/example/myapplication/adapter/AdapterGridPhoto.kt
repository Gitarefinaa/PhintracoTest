package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.AdapterImageGridBinding
import com.example.myapplication.model.PokemonList

import com.squareup.picasso.Picasso

class AdapterGridPhoto(private val listener:  onItemClickListener) : PagingDataAdapter<PokemonList, AdapterGridPhoto.PhotoViewHolder>(PHOTO_COMPARATOR) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val binding: AdapterImageGridBinding= AdapterImageGridBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotoViewHolder(binding!!)
    }



    inner class PhotoViewHolder(private val binding: AdapterImageGridBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(result: PokemonList?) {
                Picasso.with(itemView.context).load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+result?.url?.substring(25,26)+".png")
                binding?.textView.text = result!!.name
            }

    }
    interface onItemClickListener{
        fun onItemClick(pokemon: String?)
    }

    companion object {
        private val PHOTO_COMPARATOR = object : DiffUtil.ItemCallback<PokemonList>() {
            override fun areItemsTheSame(oldItem: PokemonList, newItem: PokemonList) =
                oldItem.url == newItem.url

            override fun areContentsTheSame(oldItem: PokemonList, newItem: PokemonList) =
                oldItem == newItem
        }
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        var photoModel :PokemonList = getItem(position)!!
        holder.bind(photoModel!!)
        listener.onItemClick(photoModel.url)
    }

}





