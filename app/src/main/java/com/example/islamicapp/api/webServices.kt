package com.example.islamicapp.api

import com.example.islamicapp.api.sourcesResponse.Radio
import com.example.islamicapp.api.sourcesResponse.radiochannel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface webServices {

    @GET("api/v3/radios")
    fun getradiochannels(): Call<radiochannel>
}