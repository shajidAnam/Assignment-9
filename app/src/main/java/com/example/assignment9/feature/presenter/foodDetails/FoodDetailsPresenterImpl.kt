package com.example.assignment9.feature.presenter.foodDetails

import com.example.assignment9.feature.model.foodDetails.Food
import com.example.assignment9.feature.model.foodDetails.FoodDetailsCallBack
import com.example.assignment9.feature.model.foodDetails.FoodDetailsModel
import com.example.assignment9.feature.model.foodDetails.FoodDetailsModelImpl
import com.example.assignment9.feature.view.foodDetails.FoodDetailsView

class FoodDetailsPresenterImpl(private val view: FoodDetailsView):FoodDetailsPresenter {
    private val foodDetailsModel:FoodDetailsModel=FoodDetailsModelImpl()
    override fun getFoodDetails() {
        view.handleProgressbarVisibility(true)
        foodDetailsModel.getFoodDetails(object :FoodDetailsCallBack{
            override fun onSuccess(food: Food) {
                view.handleProgressbarVisibility(false)
                view.onFoodDetailsFetchSuccess(food)
            }

            override fun onError(errorMessage: Throwable) {
                view.handleProgressbarVisibility(false)
                if (errorMessage.localizedMessage!=null)
                    view.onFoodDetailsFetchError(errorMessage.localizedMessage!!)
                else
                    view.onFoodDetailsFetchError("something Went Wrong")
            }

        })
    }
}