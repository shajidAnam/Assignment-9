package com.example.assignment9.feature.model.foodDetails

interface FoodDetailsCallBack {
    fun onSuccess(food:Food)
    fun onError(throwable: Throwable)
}