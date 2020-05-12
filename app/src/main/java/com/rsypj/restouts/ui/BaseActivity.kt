package com.rsypj.restouts.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * Created by dhadotid on 15:12 | 2020-05-12.
 * -> ✉ : yudhapurbajagad@gmail.com <-
 */

abstract class BaseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initializeDefaultValue()
    }

    fun showToast(message: String?){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    abstract fun getLayoutId(): Int
    open fun initializeDefaultValue() {}
}