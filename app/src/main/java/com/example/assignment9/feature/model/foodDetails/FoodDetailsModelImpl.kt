package com.example.assignment9.feature.model.foodDetails

import android.view.View
import com.example.assignment9.network.FoodApiInterface
import com.example.assignment9.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FoodDetailsModelImpl():FoodDetailsModel {
    val apiInterface=RetrofitClient.getClient().create(FoodApiInterface::class.java)
    val call=apiInterface.getFoodDetails()
    override fun getFoodDetails(foodDetailsCallBack: FoodDetailsCallBack) {
        call.enqueue(object :Callback<Food>{
            override fun onResponse(call: Call<Food>, response: Response<Food>) {
               response.body()?.let {
                   foodDetailsCallBack.onSuccess(it)
               }

            }

            override fun onFailure(call: Call<Food>, t: Throwable) {
                foodDetailsCallBack.onError(t)
            }

        })
    }
}