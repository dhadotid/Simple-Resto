package com.rsypj.restouts.helper

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.text.NumberFormat
import java.util.*

/**
 * Created by dhadotid on 15:27 | 2020-05-12.
 * -> ✉ : yudhapurbajagad@gmail.com <-
 */

inline fun <T> MutableLiveData<T>.asImmutable(): LiveData<T> = this

fun rupiah(number: Double): String{
    val localeID =  Locale("in", "ID")
    val numberFormat = NumberFormat.getCurrencyInstance(localeID)
    return numberFormat.format(number).toString()
}