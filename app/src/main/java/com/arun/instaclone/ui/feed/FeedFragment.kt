package com.arun.instaclone.ui.feed

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.arun.instaclone.databinding.FragmentFeedBinding

class FeedFragment : Fragment() {

    companion object {
        fun newInstance() = FeedFragment()
    }

    private val viewModel: FeedViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
      val feed=  arguments?.getString("feedType")//from navigation bar
        val binding = FragmentFeedBinding.inflate(inflater, container, false)
        feed?.let {
            binding.tvFeedType.text= feed
        }
        return binding.root
    }
}