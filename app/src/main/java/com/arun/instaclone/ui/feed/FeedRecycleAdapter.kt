package com.arun.instaclone.ui.feed

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil3.load
import com.arun.instaclone.databinding.ListItemGalleryImageBinding
import com.arun.libimgur.models.GalleryResponse


/* Adapter design pattern
the implementation of the Adapter design pattern, which essentially acts as a bridge between two
incompatible interfaces, allowing classes with different structures to work together by converting
one interface to another that the client expects;
*/

//ListAdapter is a subclass of RecyclerView.Adapter that can compute the differences between the
//old list and the new list, and update only the affected items;
// It is a generic class that takes two parameters: the type of the data and the type of the ViewHolder;

class FeedRecycleAdapter() :
    ListAdapter<GalleryResponse.Data, FeedRecycleAdapter.FeedViewHolder>(FeedDiffCallback()) {

    class FeedViewHolder(val binding: ListItemGalleryImageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        //ViewHolder is a design pattern that allows you to access each item in the list
        //and bind the data to the view;
        //It is a class that holds the views for each item in the list;


    }

    private class FeedDiffCallback : DiffUtil.ItemCallback<GalleryResponse.Data>() {
        //DiffUtil is a utility class that calculates the difference between two lists and outputs a list of update operations that converts the first list into the second one;
        //It is used to calculate the difference between two lists and update only the affected items;

        // areItemsTheSame() is called to check whether two items represent the same object or not;
        override fun areItemsTheSame(
            oldItem: GalleryResponse.Data,
            newItem: GalleryResponse.Data
        ): Boolean {
            return oldItem === newItem//=== also called Reference Operator will check whether the two variables or objects refer/points to the same memory location.
        }

        // areContentsTheSame() is called to check whether two items have the same data;
        override fun areContentsTheSame(
            oldItem: GalleryResponse.Data,
            newItem: GalleryResponse.Data
        ): Boolean {
            return oldItem == newItem //== also called Structure Operator will check whether the values/content of two variables or objects are equal or not.
        }
    }

    //onCreateViewHolder() is called when the RecyclerView needs a new ViewHolder to represent an item;
    //It inflates the layout of the item and returns a new ViewHolder that holds the view for the item;

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val inflater: LayoutInflater =
            parent.context.getSystemService(LayoutInflater::class.java)//LayoutInflater is a class used to instantiate layout XML file into its corresponding View objects;
        val binding = ListItemGalleryImageBinding.inflate(
            inflater,
            parent,
            false
        )   //inflate() is a method used to inflate a new view hierarchy from the specified XML resource;
        return FeedViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        val image = getItem(position)
        holder.binding.captionTextView.text = image.title
        holder.binding.imageView.load("https://imgur.com/${image.cover}.jpg")
    }
}