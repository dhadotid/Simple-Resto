package com.rsypj.restouts.adapter.recyclerview.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.rsypj.restouts.model.Menu
import kotlinx.android.synthetic.main.layout_category.view.*

/**
 * Created by dhadotid on 22:14 | 2020-05-12.
 * -> ✉ : yudhapurbajagad@gmail.com <-
 */

class CategoryViewHolder(
    private val view: View
): RecyclerView.ViewHolder(view) {

    fun setupModelToView(data: Menu){
        view.category.text = data.category
        view.total_data_category.text = data.data.size.toString()
    }
}