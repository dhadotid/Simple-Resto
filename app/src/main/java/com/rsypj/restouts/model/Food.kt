package com.rsypj.restouts.model


/**
 * Created by dhadotid on 03:05 | 2020-05-12.
 * -> ✉ : yudhapurbajagad@gmail.com <-
 */

data class Food (
    val id: String,
    val name: String,
    val price: String,
    val qty: String? = "",
    val description: String,
    val photo: String
): ListItem(){
    override fun getType(): Int = TYPE_CONTENT
}