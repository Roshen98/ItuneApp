package com.roger.assignment_2.view.adapter

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.roger.assignment_2.R
import com.roger.assignment_2.databinding.SongItemLayoutBinding
import com.roger.assignment_2.view.model.SongDetail
import com.roger.assignment_2.view.model.SongItem
import com.squareup.picasso.Picasso

private const val TAG = "SongAdapter"
class SongAdapter():
    ListAdapter<SongItem, SongAdapter.ViewHolder>(SongItemDiffUtil) {

    class ViewHolder(private val binding: SongItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun onBind(dataItem: SongItem) {
            binding.songName.text = dataItem.collectionName
            binding.songAuthor.text = dataItem.artistName
            binding.songCost.text = dataItem.trackPrice + " USD"

            Picasso.get()
                .load(dataItem.artworkUrl60)
                .placeholder(R.drawable.place_holder)
                .error(R.drawable.error_image_loading)
                .into(binding.songImage)


            binding.root.setOnClickListener {

                val musicIntent = Intent()
                val bundle = Bundle()

                musicIntent.action = Intent.ACTION_VIEW
                musicIntent.setDataAndType(Uri.parse(dataItem.previewUrl), "audio/*")

                startActivity(binding.root.context, musicIntent,bundle)



            }
        }

    }

    object SongItemDiffUtil : DiffUtil.ItemCallback<SongItem>() {
        override fun areItemsTheSame(oldItem: SongItem, newItem: SongItem): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: SongItem, newItem: SongItem): Boolean {
            return oldItem.collectionName == newItem.collectionName
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        SongItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(currentList[position])
    }
}

