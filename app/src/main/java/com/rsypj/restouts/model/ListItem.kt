package com.rsypj.restouts.model

/**
 * Created by dhadotid on 21:33 | 2020-05-12.
 * -> ✉ : yudhapurbajagad@gmail.com <-
 */

abstract class ListItem {

    companion object {
        val TYPE_HEADER = 1
        val TYPE_CONTENT = 2
    }

    abstract fun getType(): Int
}