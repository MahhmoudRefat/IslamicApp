package com.example.islamicapp.api

import com.example.islamicapp.api.sourcesResponse.Radio
import retrofit2.Response
import retrofit2.http.GET

interface webServices {

    @GET("/api/v3/radios")
    fun getradiochannels(): Response<List<Radio>>
}