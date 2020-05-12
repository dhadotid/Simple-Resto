package com.rsypj.restouts.ui.activity.presenter

import android.os.Handler
import com.rsypj.restouts.ui.navigation.ActivityNavigation

/**
 * Created by dhadotid on 03:35 | 2020-05-12.
 * -> ✉ : yudhapurbajagad@gmail.com <-
 */

class SplashScreenPresenter(private val activityNavigation: ActivityNavigation) {

    private val SPLASH_TIMEOUT: Long = 300

    fun onDelay(){
        Handler().postDelayed({
            activityNavigation.openHome()
        }, SPLASH_TIMEOUT)
    }
}