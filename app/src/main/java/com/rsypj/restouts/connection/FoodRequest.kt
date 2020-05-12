package com.rsypj.restouts.connection

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.rsypj.restouts.connection.listener.RequestData
import com.rsypj.restouts.model.Menu
import com.rsypj.restouts.model.BaseRequestEntity

/**
 * Created by dhadotid on 04:52 | 2020-05-12.
 * -> ✉ : yudhapurbajagad@gmail.com <-
 */

object FoodRequest {

    private val gson = Gson()

    fun requestFood(jsonFileString: String, listener: RequestData<Menu>) {
        try {
            val listMenu = object : TypeToken<BaseRequestEntity>() {}.type
            var baseRequestEntity: BaseRequestEntity = gson.fromJson(jsonFileString, listMenu)

            listener.setData(baseRequestEntity.data)
        }catch (e: Exception){
            listener.setDataError(e.message)
        }
    }
}