package com.example.myapplication.view
import android.app.Activity
import android.app.Dialog
import android.content.Context
import com.example.myapplication.R
import com.example.myapplication.databinding.CatchPokemonBinding
import com.example.myapplication.helper.Helper
import com.example.myapplication.model.Pokemon
import com.squareup.picasso.Picasso

class CatchPokemonDialog(pokemon: Pokemon) {
    lateinit var dialog: CustomDialog
    var helper :Helper = Helper()
    val pokemon:Pokemon = pokemon

    fun show(context: Context): Dialog {
        return show(context, null)
    }

    fun show(context: Context, title: CharSequence?): Dialog {
        val inflater = (context as Activity).layoutInflater
        val binding = CatchPokemonBinding.inflate(inflater)
        var probabilty :Boolean= helper.probability()
        if(probabilty==true){
            binding.pokemonName.text= pokemon.name
            Picasso.with(context).load(""+pokemon.id.toString()+".png").into(binding.imageView2)

        }
        if(probabilty==false){
            binding.pokemonName.text = "Anda gagal mendapatkan pokemon"

        }
        dialog = CustomDialog(context)
        dialog.setContentView(binding.root)
        dialog.show()
        return dialog
    }


    class CustomDialog(context: Context) : Dialog(context, R.style.ThemeOverlay_AppCompat_Dark) {
        init {

            }
        }
    }
