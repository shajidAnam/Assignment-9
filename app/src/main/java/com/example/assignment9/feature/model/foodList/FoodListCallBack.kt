package com.example.assignment9.feature.model.foodList

import com.example.assignment9.feature.model.foodDetails.Food

interface FoodListCallBack {
    fun onSuccess(foodlist:MutableList<Food>)
    fun onError(throwable: Throwable)
}