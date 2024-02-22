package com.example.retrofitcoil.network

import kotlinx.serialization.Serializable


import kotlinx.serialization.json.Json

import retrofit2.create
import com.example.retrofitcoil.Image
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.converter.gson.GsonConverterFactory
import android.provider.ContactsContract.Contacts.Photo
import com.google.gson.Gson
import retrofit2.Response

//import retrofit2.converter.gson.GsonConverterFactory



//private const val BASE_URL = "https://api.nasa.gov"
 private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com/"
private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface ApiService {
//    @GET("/planetary/apod?api_key=16MeKXFK4VkrtHTM3JuDgFqidDgbgJhqXaWhb124&count=5")
    @GET("photos")
    suspend fun getPhotos(): List<Image>
}

object Api {
    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}