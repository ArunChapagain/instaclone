package com.arun.libimgur.services

import com.arun.libimgur.models.GalleryResponse
import com.arun.libimgur.models.Tag
import com.arun.libimgur.models.TagsResponse
import retrofit2.Call
import retrofit2.http.GET

interface ImgurAPIv3 {
    @GET("gallery/hot/?album_previews=true") //ToDO: use path parameter
    fun  getGallery(): Call<GalleryResponse>

    @GET("tags")
    fun getTags(): Call<TagsResponse>
}