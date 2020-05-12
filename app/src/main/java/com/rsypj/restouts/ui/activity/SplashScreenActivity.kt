package com.rsypj.restouts.ui.activity

import com.rsypj.restouts.ui.navigation.ActivityContainerNavigator
import com.rsypj.restouts.R
import com.rsypj.restouts.ui.BaseActivity
import com.rsypj.restouts.ui.activity.presenter.SplashScreenPresenter

/**
 * Created by dhadotid on 03:34 | 2020-05-12.
 * -> ✉ : yudhapurbajagad@gmail.com <-
 */

class SplashScreenActivity: BaseActivity() {

    private lateinit var presenter: SplashScreenPresenter
    private val contentNavigator by lazy { ActivityContainerNavigator(this) }

    override fun getLayoutId(): Int = R.layout.activity_splash_screen

    override fun initializeDefaultValue() {
        presenter = SplashScreenPresenter(contentNavigator)
        presenter.onDelay()
    }
}