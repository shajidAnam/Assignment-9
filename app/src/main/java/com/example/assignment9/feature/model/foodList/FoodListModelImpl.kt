package com.example.assignment9.feature.model.foodList

import com.example.assignment9.feature.model.foodDetails.Food
import com.example.assignment9.network.FoodApiInterface
import com.example.assignment9.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FoodListModelImpl():FoodListModel {
    private val apiInterface=RetrofitClient.getClient().create(FoodApiInterface::class.java)
    private val call=apiInterface.getFoodList()
    override fun getFoodList(foodListCallBack: FoodListCallBack) {
        call.enqueue(object :Callback<MutableList<Food>>{
            override fun onResponse(
                call: Call<MutableList<Food>>,
                response: Response<MutableList<Food>>
            ) {
                response.body()?.let {
                    foodListCallBack.onSuccess(it)
                }
            }

            override fun onFailure(call: Call<MutableList<Food>>, t: Throwable) {
                foodListCallBack.onError(t)
            }

        })
    }

}