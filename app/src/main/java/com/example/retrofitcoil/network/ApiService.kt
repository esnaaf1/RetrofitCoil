package com.example.retrofitcoil.network


import com.example.retrofitcoil.Image
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.converter.gson.GsonConverterFactory



private const val BASE_URL = "https://api.nasa.gov"
// For testing purposes, in case of exceeding the rate limits use the base url below
//private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com/"


// Replace below with your own api key
//private const val API_KEY = "16MeKXFK4VkrtHTM3JuDgFqidDgbgJhqXaWhb124&"
private const val API_KEY = "DEMO_KEY"
private const val END_POINT = "/planetary/apod?api_key=$API_KEY&count=5"
private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface ApiService {

// For testing purposes, use the GET Below
//    @GET("photos")
    @GET(END_POINT)
    suspend fun getPhotos(): List<Image>
}

object Api {
    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}