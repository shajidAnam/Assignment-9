package com.example.assignment9.feature.view.foodDetails

import com.example.assignment9.feature.model.foodDetails.Food

interface FoodDetailsView {
    fun handleProgressbarVisibility(isVisible: Boolean)
    fun onFoodDetailsFetchSuccess(food: Food)
    fun onFoodDetailsFetchError(errorMessage:String)
}