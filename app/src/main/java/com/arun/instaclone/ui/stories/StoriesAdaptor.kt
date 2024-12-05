package com.arun.instaclone.ui.stories

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil3.load
import coil3.request.error
import coil3.request.placeholder
import coil3.size.Scale
import com.arun.instaclone.R
import com.arun.instaclone.databinding.ListItemStoryHeadBinding
import com.arun.libimgur.models.Tag
import kotlin.math.log

class StoriesAdaptor :
    ListAdapter<Tag, StoriesAdaptor.StoriesViewHolder>(StoriesDiffCallback()) {

    class StoriesViewHolder(var binding: ListItemStoryHeadBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    private class StoriesDiffCallback : DiffUtil.ItemCallback<Tag>() {
        override fun areItemsTheSame(oldItem: Tag, newItem: Tag): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Tag, newItem: Tag): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoriesViewHolder {
        val inflater: LayoutInflater =
            parent.context.getSystemService(LayoutInflater::class.java)//LayoutInflater is a class used to instantiate layout XML file into its corresponding View objects;
        val binding = ListItemStoryHeadBinding.inflate(
            inflater,
            parent,
            false
        )   //inflate() is a method used to inflate a new view hierarchy from the specified XML resource;
        return StoriesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StoriesViewHolder, position: Int) {
        val story = getItem(position)

        holder.binding.storyHeadTextView.text = story.displayName
        holder.binding.storyHeadImageView.load("https://imgur.com/${story.backgroundHash}.jpg") {
            placeholder(R.drawable.image_placeholder)
            error(R.drawable.image_placeholder)
            // you can add more options here like caching, transformations, etc.
        }
    }
}