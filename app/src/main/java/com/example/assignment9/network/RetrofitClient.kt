package com.example.assignment9.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL="https://raw.githubusercontent.com/"
    private val gson=GsonBuilder().setLenient().create()
    private val retrofit=Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
    fun getClient():Retrofit{
        return retrofit
    }
}