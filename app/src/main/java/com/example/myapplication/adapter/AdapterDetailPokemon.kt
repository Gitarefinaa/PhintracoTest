package com.example.myapplication.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.Pokemon
import com.squareup.picasso.Picasso

class AdapterDetailPokemon(val context: Context, val data: Pokemon) :  RecyclerView.Adapter<AdapterDetailPokemon.MyView>() {
        class MyView(view: View) : RecyclerView.ViewHolder(view) {
            var  image : ImageView
            var pokemon :TextView
            init {
                image =  view.findViewById<ImageView>(R.id.imageView)
                pokemon = view.findViewById(R.id.name_pokemon)
            }
        }

        override fun getItemCount(): Int {
            return 1
        }

        override fun onBindViewHolder(holder: AdapterDetailPokemon.MyView, position: Int) {
            val context = context
            val listData = data
            holder.pokemon.text = listData.name
            Picasso.with(context).load(listData.id.toString()).centerCrop().into(holder.image)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterDetailPokemon.MyView {
            val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.detail_pokemon, parent, false)
            return MyView(itemView)
        }

    }
