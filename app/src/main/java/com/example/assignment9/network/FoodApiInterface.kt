package com.example.assignment9.network

import com.example.assignment9.feature.model.foodDetails.Food
import retrofit2.Call
import retrofit2.http.GET

interface FoodApiInterface {
    @GET("shajidAnam/assignment7/master/data.json")
    fun getFoodList(): Call<MutableList<Food>>
}