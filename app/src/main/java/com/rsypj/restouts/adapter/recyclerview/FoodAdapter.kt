package com.rsypj.restouts.adapter.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rsypj.restouts.R
import com.rsypj.restouts.adapter.listener.OnItemSelected
import com.rsypj.restouts.adapter.recyclerview.viewholder.CategoryViewHolder
import com.rsypj.restouts.adapter.recyclerview.viewholder.FoodViewHolder
import com.rsypj.restouts.model.Food
import com.rsypj.restouts.model.ListItem
import com.rsypj.restouts.model.Menu

/**
 * Created by dhadotid on 16:18 | 2020-05-12.
 * -> ✉ : yudhapurbajagad@gmail.com <-
 */

class FoodAdapter(
    val data: List<ListItem>,
    private val listener: OnItemSelected<Food>
):
    RecyclerView.Adapter<RecyclerView.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == ListItem.TYPE_HEADER){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_category, parent, false)
            CategoryViewHolder(view)
        }else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_food, parent, false)
            FoodViewHolder(view, listener)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == ListItem.TYPE_HEADER){
            val menu = data[position] as Menu
            (holder as CategoryViewHolder).setupModelToView(menu)
        }else if (getItemViewType(position) == ListItem.TYPE_CONTENT){
            val food = data[position] as Food
            (holder as FoodViewHolder).setupModelToView(food)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return data.get(position).getType()
    }

    override fun getItemCount(): Int = data.size

    fun getItem(position: Int) : ListItem {
        return data[position]
    }
}