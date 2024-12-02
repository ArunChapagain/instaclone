package com.arun.libimgur

import com.arun.libimgur.converter.EnumConverterFactory
import com.arun.libimgur.services.ImgurAPIv3
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ImgurClient {

    private const val API_KEY = "b6f98ee072eb23e" // TODO: ideally this should be in app not in lib

    //httpClient is created only when it is needed
    private val httpClient: OkHttpClient by lazy {
        OkHttpClient.Builder().addInterceptor {
            val request = it.request().newBuilder()
                .addHeader("Authorization", "Client-ID $API_KEY").build()
            it.proceed(request)
        }.build()
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .client(httpClient)
            .addConverterFactory(MoshiConverterFactory.create()).baseUrl("https://api.imgur.com/3/")
            .addConverterFactory(EnumConverterFactory())
            .build()
    }

    val api: ImgurAPIv3 by lazy {
        retrofit.create(ImgurAPIv3::class.java)
    }
}