package com.arun.instaclone.ui.story

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil3.imageLoader
import coil3.load
import coil3.request.CachePolicy
import coil3.request.ImageRequest
import com.arun.instaclone.databinding.PagaItemStoryBinding
import com.arun.libimgur.models.Image

class StoryPageAdaptor :
    ListAdapter<Image, StoryPageAdaptor.StoryPageViewHolder>(StoryDiffCallback()) {
    class StoryPageViewHolder(var binding: PagaItemStoryBinding) :
        RecyclerView.ViewHolder(binding.root) {}

    private class StoryDiffCallback : DiffUtil.ItemCallback<Image>() {
        override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryPageViewHolder {
        val inflater = parent.context.getSystemService(LayoutInflater::class.java)
        val binding = PagaItemStoryBinding.inflate(inflater, parent, false)
        return StoryPageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StoryPageViewHolder, position: Int) {

        val image = getItem(position)
        val imgUrl = if (image?.isAlbum == true && image.imagesCount != 0) {
            image.images?.get(0)?.link
            //image.images!![0].link!!
        } else {
            image?.link
        }

        imgUrl?.let {
            //Glide.with(holder.itemView).load(it).into(holder.binding.storyImage)
            holder.binding.storyImageView.load(
                imgUrl
            )
        }
        cacheNext(position, holder.binding.storyImageView.context)

    }

    private fun cacheNext(position: Int, context: Context) {
        val image = try {
            getItem(position + 1)
        } catch (e: IndexOutOfBoundsException) {
            null
        }
        val imgUrl = if (image?.isAlbum == true && image.imagesCount != 0) {
            image.images?.get(0)?.link
        } else {
            image?.link
        }
        imgUrl?.let {
            val request = ImageRequest.Builder(context)
                .data(imgUrl)
                .diskCachePolicy(CachePolicy.DISABLED)
                .build()
            context.imageLoader.enqueue(request)
        }
    }


}