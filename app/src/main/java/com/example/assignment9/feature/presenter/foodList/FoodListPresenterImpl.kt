package com.example.assignment9.feature.presenter.foodList


import com.example.assignment9.feature.model.foodDetails.Food
import com.example.assignment9.feature.model.foodList.FoodListCallBack
import com.example.assignment9.feature.model.foodList.FoodListModel
import com.example.assignment9.feature.model.foodList.FoodListModelImpl
import com.example.assignment9.feature.view.foodList.FoodListView

class FoodListPresenterImpl(private val view:FoodListView):FoodListPresenter {
    private val foodListModel:FoodListModel=FoodListModelImpl()
    override fun getFoodList() {
        view.handleProgressbarVisibility(true)
        foodListModel.getFoodList(object :FoodListCallBack{
            override fun onSuccess(foodlist: MutableList<Food>) {
                view.handleProgressbarVisibility(false)
                view.onFoodListFetchSuccess(foodlist)
            }

            override fun onError(throwable: Throwable) {
                view.handleProgressbarVisibility(false)
                if (throwable.localizedMessage!=null)
                    view.onFoodListFetchFailure(throwable.localizedMessage!!)
                else
                    view.onFoodListFetchFailure("An error occured")
            }

        })
    }
}