package com.arun.instaclone

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arun.instaclone.databinding.ActivityMainBinding
import com.arun.instaclone.ui.stories.StoriesAdaptor
import com.arun.instaclone.ui.stories.StoriesViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private val storiesViewModel by viewModels<StoriesViewModel>()
    private val _storiesAdaptor = StoriesAdaptor()


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
            _storiesAdaptor.submitList(it)
        }
    }
}



/*

binding.feedRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.feedRecyclerView.adapter = _feedAdapter
 *
  viewModel.feed.observe(viewLifecycleOwner) {
            _feedAdapter.submitList(it)
        }
package com.arun.instaclone

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arun.instaclone.databinding.ActivityMainBinding
import com.arun.instaclone.ui.stories.StoriesAdaptor
import com.arun.instaclone.ui.stories.StoriesViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private val storiesViewModel by viewModels<StoriesViewModel>()
    private val storiesAdaptor = StoriesAdaptor()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.storiesRecycleView.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            adapter = storiesAdaptor
        }

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
        storiesViewModel.tags.observe(this
        ) {
            storiesAdaptor.submitList(it)
        }
    }
}
 */