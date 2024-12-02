package com.arun.instaclone.ui.feed

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.arun.instaclone.R
import org.w3c.dom.Text

class FeedFragment : Fragment() {

    companion object {
        fun newInstance() = FeedFragment()
    }

    private val viewModel: FeedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
      val feed=  arguments?.getString("feedType")
       val rootView= inflater.inflate(R.layout.fragment_feed, container, false)
        feed?.let {
            rootView.findViewById<TextView>(R.id.tvFeedType).text=it
        }

        return rootView
    }
}