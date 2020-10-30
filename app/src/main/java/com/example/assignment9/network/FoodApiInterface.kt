package com.example.assignment9.network

import com.example.assignment9.feature.model.foodDetails.Food
import retrofit2.Call
import retrofit2.http.GET

interface FoodApiInterface {
    @GET("shajidAnam/Assignment-9/master/foodList.json")
    fun getFoodList(): Call<MutableList<Food>>
    @GET("shajidAnam/Assignment-9/master/foodDetails.json")
    fun getFoodDetails():Call<Food>
}