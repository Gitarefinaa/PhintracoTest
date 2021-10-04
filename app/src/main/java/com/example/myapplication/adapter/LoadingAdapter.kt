package com.example.myapplication.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible

import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter

import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.StateLoadBinding

class LoadingAdapter (private val retry: ()-> Unit): LoadStateAdapter<LoadingAdapter.LoadViewHolder>() {

    inner class LoadViewHolder(private val binding: StateLoadBinding )
        : RecyclerView.ViewHolder(binding.root){

        init {
            binding.btnRetry.setOnClickListener {
                retry.invoke()
            }
        }

        fun bind(loadState: LoadState){
                binding.progressBar.isVisible = loadState is LoadState.Loading
                binding.btnRetry.isVisible = loadState !is LoadState.Loading
                binding.tvError.isVisible = loadState !is LoadState.Loading
            }

    }

    override fun onBindViewHolder(holder: LoadViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadViewHolder {
        val binding = StateLoadBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LoadViewHolder(binding)
    }
}