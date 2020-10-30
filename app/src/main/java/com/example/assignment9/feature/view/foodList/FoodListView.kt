package com.example.assignment9.feature.view.foodList

import com.example.assignment9.feature.model.foodDetails.Food

interface FoodListView {
    fun handleProgressbarVisibility(isVisible: Boolean)
    fun onFoodListFetchSuccess(foodlist:MutableList<Food>)
    fun onFoodListFetchFailure(errorMessage:String)
}