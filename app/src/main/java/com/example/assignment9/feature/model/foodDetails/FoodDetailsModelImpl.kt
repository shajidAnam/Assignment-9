package com.example.assignment9.feature.model.foodDetails

import com.example.assignment9.network.FoodApiInterface
import com.example.assignment9.network.RetrofitClient

class FoodDetailsModelImpl():FoodDetailsModel {
    val apiInterface=RetrofitClient.getClient().create(FoodApiInterface::class.java)
    val call=apiInterface.
    override fun getFoodDetails(foodDetailsCallBack: FoodDetailsCallBack) {
        TODO("Not yet implemented")
    }
}