package com.arun.instaclone.ui.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import coil3.request.ImageRequest
import com.arun.instaclone.databinding.FragmentFeedBinding
import coil3.imageLoader
import coil3.request.CachePolicy

class FeedFragment : Fragment() {

    companion object {
        fun newInstance() = FeedFragment()
    }

    private val viewModel: FeedViewModel by viewModels()
    private val _feedAdapter = FeedRecycleAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val feed = arguments?.getString("feedType")//from navigation bar Todo:turn into enum
// if feet is available then update the feed
        feed?.let {
            viewModel.updateFeed(it)
        }

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentFeedBinding.inflate(inflater, container, false)
        binding.feedRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.feedRecyclerView.adapter = _feedAdapter
        viewModel.feed.observe(viewLifecycleOwner) {

            it.forEach { image ->
                val request = ImageRequest.Builder(requireContext())
                    .data( "https://imgur.com/${image.cover}.jpg")
                    .diskCachePolicy(CachePolicy.DISABLED)
                    .build()
              requireContext().imageLoader.enqueue(request)

            }
            _feedAdapter.submitList(it)
        }
        return binding.root
    }
}