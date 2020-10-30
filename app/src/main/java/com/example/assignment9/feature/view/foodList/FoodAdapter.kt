package com.example.assignment9.feature.view.foodList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.assignment9.R
import com.example.assignment9.feature.model.foodDetails.Food

class FoodAdapter(private val foodlist:MutableList<Food>, private val itemClickListener: OnClickListener):RecyclerView.Adapter<FoodViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_food,parent,false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food=foodlist[position]
        holder.foodName.text=food.name
        holder.foodPriceValue.text=holder.itemView.context.getString(R.string.price_format,food.price)
        Glide.with(holder.foodImage)
            .load(food.imageUrl)
            .into(holder.foodImage)

        holder.itemView.setOnClickListener {
            itemClickListener.onItemClickListener(position)
        }
    }

    override fun getItemCount(): Int {
        return foodlist.size
    }
}