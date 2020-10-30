package com.example.assignment9.feature.view.foodDetails

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide
import com.example.assignment9.R
import com.example.assignment9.core.BaseActivity
import com.example.assignment9.feature.model.foodDetails.Food
import com.example.assignment9.feature.presenter.foodDetails.FoodDetailsPresenter
import com.example.assignment9.feature.presenter.foodDetails.FoodDetailsPresenterImpl
import kotlinx.android.synthetic.main.activity_food_details.*
import kotlinx.android.synthetic.main.activity_food_list.*
import kotlinx.android.synthetic.main.item_food.iv_food
import kotlinx.android.synthetic.main.item_food.tv_food_name
import kotlinx.android.synthetic.main.item_food.tv_price_value
import kotlinx.android.synthetic.main.toolbar.*

class  FoodDetailsActivity : BaseActivity() ,FoodDetailsView{
    override fun setToolbar(): Toolbar {
        toolbar.title="Mutton Biriany Details"
        return toolbar
    }

    override fun setLayoutId(): Int {
        return R.layout.activity_food_details
    }

    override val isHomeButtonEnabled: Boolean
        get() = true

    private lateinit var foodDetailsPresenter:FoodDetailsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        foodDetailsPresenter=FoodDetailsPresenterImpl(this)
        foodDetailsPresenter.getFoodDetails()
    }

    override fun handleProgressbarVisibility(isVisible: Boolean) {
        if (isVisible)
            progress.visibility=View.VISIBLE
        else
            progress.visibility=View.GONE
    }

    override fun onFoodDetailsFetchSuccess(food: Food) {
        Glide.with(iv_food)
            .load(food.imageUrl)
            .into(iv_food)
        tv_food_name.text=food.name
        tv_price_value.text=getString(R.string.price_format,food.price)
        tv_description.text=food.description
    }

    override fun onFoodDetailsFetchError(errorMessage: String) {
        showShortToast(errorMessage)
    }
}