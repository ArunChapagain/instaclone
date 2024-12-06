package com.arun.instaclone.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arun.instaclone.data.ImgurRepository
import com.arun.libimgur.models.Tag
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeStoriesViewModel :ViewModel() {
    private val repo = ImgurRepository()
    private val _tags = MutableLiveData<List<Tag>>()
    val tags: LiveData<List<Tag>> = _tags

    fun getTags() {
        viewModelScope.launch(Dispatchers.IO) {
            _tags.postValue(repo.getTags())
        }
    }
}