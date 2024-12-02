package com.arun.libimgur.apis

import com.arun.libimgur.ImgurClient
import com.arun.libimgur.params.Section
import com.arun.libimgur.services.ImgurAPIv3
import okhttp3.OkHttpClient
import org.junit.Assert.assertNotNull
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ImgurAPIv3Test {

    private val api = ImgurClient.api

    @Test
    fun `get tags working`() {
        val response = api.getTags().execute()
        println("response: $response")
        assertNotNull(response.body())
    }

    @Test
    fun `get galleries -hot working`() {
        val response = api.getGallery(Section.HOT).execute()
        assertNotNull(response.body())
    }
    @Test
    fun `get galleries -top working`() {
        val response = api.getGallery(Section.TOP).execute()
        assertNotNull(response.body())
    }
}