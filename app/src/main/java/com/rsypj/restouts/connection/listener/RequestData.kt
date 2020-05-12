package com.rsypj.restouts.connection.listener

/**
 * Created by dhadotid on 04:49 | 2020-05-12.
 * -> ✉ : yudhapurbajagad@gmail.com <-
 */

interface RequestData<T> {
    fun setData(data: List<T>)
    fun setDataError(message: String?)
}