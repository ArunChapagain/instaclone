package com.arun.libimgur.services

import com.arun.libimgur.models.GalleryResponse
import com.arun.libimgur.models.TagResponse
import com.arun.libimgur.models.TagsResponse
import com.arun.libimgur.params.Section
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ImgurAPIv3 {
    @GET("gallery/{section}") //ToDO: use path parameter
   suspend fun  getGallery(
        @Path("section") section: Section,
        @Query("album_preview") albumPreview: Boolean ?= true,
    ): Response<GalleryResponse>//ToDo: it may be gallery response but I am using Image. I think it is only mapping Image.


    @GET("tags")
   suspend fun getTags(): Response<TagsResponse>


   @GET("gallery/t/{tag}")
   suspend fun  getTag(
         @Path("tag") tag: String,
    ): Response<TagResponse>//ToDo: it may be gallery response but I am using Image. I think it is only mapping Image.

}