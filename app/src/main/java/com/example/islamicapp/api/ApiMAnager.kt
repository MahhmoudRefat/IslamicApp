package com.example.islamicapp.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiMAnager {
    lateinit var retrofit: Retrofit

    init {
        //interceptor
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        val client = OkHttpClient.Builder().addInterceptor(logging).build()

        retrofit = Retrofit.Builder().client(client).baseUrl("http://mp3quran.net")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    fun getServices(): webServices {
        return retrofit.create(webServices::class.java)
    }

}