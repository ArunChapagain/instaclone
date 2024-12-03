package com.arun.instaclone.ui.feed

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arun.instaclone.data.ImgurRepository
import com.arun.libimgur.models.GalleryResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FeedViewModel : ViewModel() {
    private val repo = ImgurRepository()

    //  private  val _feed = MutableLiveData<List<Image>>()
//    val feed: LiveData<List<Image>> = _feed
    private val _feed = MutableLiveData<List<GalleryResponse.Data>>()
    val feed: LiveData<List<GalleryResponse.Data>> = _feed

    fun updateFeed(feedType: String) {
//      viewModelScope.launch: This starts a new coroutine in the viewModelScope, which is tied to the lifecycle of the ViewModel.
        //      This ensures that the coroutine is canceled when the ViewModel is cleared.
//      Dispatchers.IO: This dispatcher is optimized for offloading blocking IO tasks to a shared pool of threads. It is used here to perform network or disk operations without blocking the main thread.
        viewModelScope.launch(Dispatchers.IO)
        {
            when (feedType) {
                "hot" -> _feed.postValue(repo.getHotFeed())
                "top" -> _feed.postValue(repo.getTopFeed())
                else  -> Log.e("FEED", "Feed has to be either top or hot")

            }
        }

    }
}