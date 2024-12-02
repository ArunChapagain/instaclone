package com.arun.libimgur.services

import com.arun.libimgur.models.GalleryResponse
import com.arun.libimgur.models.TagsResponse
import com.arun.libimgur.params.Section
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ImgurAPIv3 {
    @GET("gallery/{section}") //ToDO: use path parameter
    fun  getGallery(
        @Path("section") section: Section,
        @Query("album_preview") albumPreview: Boolean ?= true,
    ): Call<GalleryResponse>

    @GET("tags")
    fun getTags(): Call<TagsResponse>
}