package com.arun.libimgur.apis

import com.arun.libimgur.services.ImgurAPIv3
import okhttp3.OkHttpClient
import org.junit.Assert.assertNotNull
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ImgurAPIv3Test {

    private val client = OkHttpClient.Builder().addInterceptor {
        val request = it.request().newBuilder()
            .addHeader("Authorization", "Client-ID b6f98ee072eb23e").build()
        it.proceed(request)
    }
    private val retrofit = Retrofit.Builder()
        .client(client.build())
        .addConverterFactory(MoshiConverterFactory.create()).baseUrl("https://api.imgur.com/3/")
        .build()
    private val api = retrofit.create(ImgurAPIv3::class.java)
    @Test
    fun `get tags working`() {
        val response = api.getTags().execute()
        assertNotNull(response.body())
    }
}