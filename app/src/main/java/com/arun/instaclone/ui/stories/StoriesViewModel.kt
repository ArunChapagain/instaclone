package com.arun.instaclone.ui.stories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arun.instaclone.data.ImgurRepository
import com.arun.libimgur.models.Tag
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StoriesViewModel :ViewModel() {
    private val repo = ImgurRepository()
    private val _tags = MutableLiveData<List<Tag>>()
    val tags: LiveData<List<Tag>> = _tags

    fun getTags() {
        viewModelScope.launch(Dispatchers.IO) {
            _tags.postValue(repo.getTags())
        }
    }
}