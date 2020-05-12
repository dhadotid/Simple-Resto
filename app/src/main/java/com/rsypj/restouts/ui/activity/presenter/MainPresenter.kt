package com.rsypj.restouts.ui.activity.presenter

import androidx.lifecycle.MutableLiveData
import com.rsypj.restouts.helper.asImmutable
import com.rsypj.restouts.connection.FoodRequest
import com.rsypj.restouts.connection.listener.RequestData
import com.rsypj.restouts.model.ListItem
import com.rsypj.restouts.model.Menu

/**
 * Created by dhadotid on 04:47 | 2020-05-12.
 * -> ✉ : yudhapurbajagad@gmail.com <-
 */

class MainPresenter {

    private val menuList = MutableLiveData<Pair<List<ListItem>, List<Menu>>>()
    fun getMenuList() = menuList.asImmutable()
    private val onError = MutableLiveData<String>()
    fun getOnError() = onError.asImmutable()
    private val itemsList: MutableList<ListItem> = ArrayList()

    fun requestFoodlist(foodJson: String){
        FoodRequest.requestFood(foodJson, object : RequestData<Menu>{
            override fun setData(data: List<Menu>) {
                data.forEachIndexed { index, menu ->
                    itemsList.add(menu)
                    menu.data.forEachIndexed { index, food ->
                        itemsList.add(food)
                    }
                }
                menuList.value = Pair(itemsList, data)
            }

            override fun setDataError(message: String?) {
                onError.value = message
            }
        })
    }
}