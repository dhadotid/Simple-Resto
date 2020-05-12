package com.rsypj.restouts.model

/**
 * Created by dhadotid on 16:36 | 2020-05-12.
 * -> ✉ : yudhapurbajagad@gmail.com <-
 */

data class Menu (
    val category: String,
    val data: List<Food>
): ListItem(){

    override fun getType(): Int = TYPE_HEADER
}