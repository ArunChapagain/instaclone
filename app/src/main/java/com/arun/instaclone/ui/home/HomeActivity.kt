package com.arun.instaclone.ui.home

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil3.imageLoader
import coil3.request.CachePolicy
import coil3.request.ImageRequest
import com.arun.instaclone.R
import com.arun.instaclone.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private val storiesViewModel by viewModels<HomeStoriesViewModel>()
    private val _storiesAdaptor = HomeStoriesRecycleAdaptor()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.storiesRecycleView.layoutManager= LinearLayoutManager(this,RecyclerView.HORIZONTAL,false)
        binding.storiesRecycleView.adapter=_storiesAdaptor

        setupNav()

        storiesViewModel.getTags()

    }

    private fun setupNav() {
        // Set
        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        /*
        NOTE : Not using an actionbar in our app
        *************** Action Bar Code ***************
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_hot, R.id.navigation_top
            )
        )
            setupActionBarWithNavController(navController, appBarConfiguration)
        */
        navView.setupWithNavController(navController)
    }

    override fun onResume() {
        super.onResume()
        storiesViewModel.tags.observe(this) {
            it.forEach { story ->
                val request = ImageRequest.Builder(this)
                    .data("https://imgur.com/${story.backgroundHash}.jpg")
                    .diskCachePolicy(CachePolicy.DISABLED)
                    .build()
                imageLoader.enqueue(request)
            }
            _storiesAdaptor.submitList(it)
        }
    }
}

