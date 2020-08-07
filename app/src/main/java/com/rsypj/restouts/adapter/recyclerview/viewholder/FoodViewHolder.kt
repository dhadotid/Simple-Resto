package com.rsypj.restouts.adapter.recyclerview.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.rsypj.restouts.adapter.listener.OnItemSelected
import com.rsypj.restouts.helper.loadCenterCropImage
import com.rsypj.restouts.helper.loadImage
import com.rsypj.restouts.helper.rupiah
import com.rsypj.restouts.model.Food
import kotlinx.android.synthetic.main.layout_food.view.*

/**
 * Created by dhadotid on 16:20 | 2020-05-12.
 * -> ✉ : yudhapurbajagad@gmail.com <-
 */

class FoodViewHolder(
    private val view: View,
    private val listener: OnItemSelected<Food>
    ): RecyclerView.ViewHolder(view) {

    lateinit var food: Food

    init {
        view.setOnClickListener {
            listener.onSelectedItem(food)
        }
    }

    fun setupModelToView(food: Food){
        this.food = food
        view.layout_food_title.text = food.name
        view.layout_food_description.text = food.description
        view.layout_food_price.text = rupiah(food.price.toDouble())
        view.layout_food_photos.loadCenterCropImage(food.photo)
        if (!food.qty.isNullOrEmpty()){
            view.layout_food_qty.text = "Qty: ${food.qty}"
            view.layout_food_qty.visibility = View.VISIBLE
        }
    }
}