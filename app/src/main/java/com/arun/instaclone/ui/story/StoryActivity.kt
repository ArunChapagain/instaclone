package com.arun.instaclone.ui.story

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel
import com.arun.instaclone.R
import com.arun.instaclone.databinding.ActivityStoryBinding
import com.arun.instaclone.databinding.PagaItemStoryBinding

class StoryActivity : AppCompatActivity() {

    private val _storyViewModel by viewModels<StoryViewModel> ()
    private lateinit var binding: ActivityStoryBinding
    private  val storyPageAdaptor = StoryPageAdaptor()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityStoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val tagName = intent.getStringExtra("tag")
        tagName?.let {
            _storyViewModel.fetchStoryImage(it)
        }
        binding.storyPager.adapter = storyPageAdaptor
    }

    override fun onResume() {
        super.onResume()
        _storyViewModel.images.observe(this) {

            storyPageAdaptor.submitList(it)
        }
    }
}