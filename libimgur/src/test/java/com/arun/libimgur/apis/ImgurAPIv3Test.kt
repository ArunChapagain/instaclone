package com.arun.libimgur.apis

import com.arun.libimgur.ImgurClient
import com.arun.libimgur.params.Section
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertNotNull
import org.junit.Test

class ImgurAPIv3Test {

    private val api = ImgurClient.api

    @Test
    fun `get tags working`() = runBlocking {
        val response = api.getTags()
        println("response: $response")
        assertNotNull(response.body())
    }

    @Test
    fun `get tag -tree working`() = runBlocking {
        val response = api.getTag("aww")
        assertNotNull(response.body())
    }


    @Test
    fun `get galleries -hot working`() = runBlocking {
        val response = api.getGallery(Section.HOT)
        assertNotNull(response.body())
    }

    @Test
    fun `get galleries -top working`() = runBlocking {
        val response = api.getGallery(Section.TOP)
        assertNotNull(response.body())
    }


}