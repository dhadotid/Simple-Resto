package com.rsypj.restouts.helper

import android.content.Context
import java.io.IOException

/**
 * Created by dhadotid on 04:19 | 2020-05-12.
 * -> ✉ : yudhapurbajagad@gmail.com <-
 */

fun getJsonDataFromAsset(context: Context, fileName: String): String? {
    val jsonString: String
    try {
        jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
    } catch (ioException: IOException) {
        ioException.printStackTrace()
        return null
    }
    return jsonString
}