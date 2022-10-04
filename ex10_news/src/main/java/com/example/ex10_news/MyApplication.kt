package com.example.ex10_news

import android.app.Application
import com.example.ex10_news.retrofit.NetworkService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyApplication : Application() {
    companion object {
        val API_KEY = "a8f0d4f98b2f4e60847d990ca71a8503"
        val BASE_URL = "https://newsapi.org"

        val retrofit: Retrofit
            get() = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        var networkService: NetworkService

        init {
            networkService = retrofit.create(NetworkService::class.java)
        }
    }
}