package com.example.assignment9.feature.view.foodList

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_food.view.*

class FoodViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
    val foodName:AppCompatTextView= itemView.tv_food_name
    val foodPriceValue:AppCompatTextView=itemView.tv_price_value
    val favourite:AppCompatImageView=itemView.iv_favorite
    val foodImage:AppCompatImageView=itemView.iv_food
}