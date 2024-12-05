package com.arun.instaclone.data

import com.arun.libimgur.ImgurClient
import com.arun.libimgur.models.Gallery
import com.arun.libimgur.models.GalleryResponse
import com.arun.libimgur.models.Image
import com.arun.libimgur.models.Tag
import com.arun.libimgur.models.TagsResponse
import com.arun.libimgur.params.Section

class ImgurRepository {
    private val api = ImgurClient.api

//    suspend fun getHotFeed(): List<Image>? {// may be Image Idk
    suspend fun getHotFeed(): List<GalleryResponse.Data>? {//ToDo: return proper error object if null
        val response = api.getGallery(Section.HOT)
//        return response.body()?.data// ToDo: used return type Image but It may be GalleryResponse
        return response.body()?.data
    }

    suspend fun getTopFeed(): List<GalleryResponse.Data>? {//ToDo: return proper error object if null
        val response = api.getGallery(Section.TOP)
        return response.body()?.data
    }

    suspend fun getTags(): List<Tag>?
    {
        val response = api.getTags()
        return response.body()?.data?.tags
    }

}