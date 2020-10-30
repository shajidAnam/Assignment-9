package com.example.assignment9.feature.view.foodList

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignment9.R
import com.example.assignment9.core.BaseActivity
import com.example.assignment9.feature.model.foodDetails.Food
import com.example.assignment9.feature.presenter.foodList.FoodListPresenter
import com.example.assignment9.feature.presenter.foodList.FoodListPresenterImpl
import com.example.assignment9.feature.view.foodDetails.FoodDetailsActivity
import kotlinx.android.synthetic.main.activity_food_list.*
import kotlinx.android.synthetic.main.toolbar.*

class FoodListActivity : BaseActivity(),FoodListView {
    override fun setToolbar(): Toolbar {
        toolbar.title="Biriany House"
        return toolbar
    }

    override fun setLayoutId(): Int {
        return R.layout.activity_food_list
    }

    override val isHomeButtonEnabled: Boolean
        get() = true

    private lateinit var  foodListPresenter:FoodListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        foodListPresenter=FoodListPresenterImpl(this)
        foodListPresenter.getFoodList()

    }

    override fun handleProgressbarVisibility(isVisible: Boolean) {
        if (isVisible)
            progress.visibility=View.VISIBLE
        else
            progress.visibility=View.GONE
    }

    override fun onFoodListFetchSuccess(foodlist: MutableList<Food>) {
        initAdapter(foodlist)
    }
    override fun onFoodListFetchFailure(errorMessage: String) {
        showShortToast(errorMessage)
    }

    private fun initAdapter(foodlist: MutableList<Food>) {
        val adapter=FoodAdapter(foodlist,object :OnClickListener{
            override fun onItemClickListener(position: Int) {
                val intent=Intent(this@FoodListActivity,FoodDetailsActivity::class.java)
                startActivity(intent)
            }

        })
        recyclerView.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter=adapter

    }


}