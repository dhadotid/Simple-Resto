package com.rsypj.restouts.ui.navigation

import android.app.Activity
import android.content.Intent
import com.rsypj.restouts.ui.activity.MainActivity

/**
 * Created by dhadotid on 03:53 | 2020-05-12.
 * -> ✉ : yudhapurbajagad@gmail.com <-
 */

class ActivityContainerNavigator(
    private val activity: Activity
): ActivityNavigation {

    override fun openHome() {
        activity.startActivity(Intent(activity, MainActivity::class.java))
        activity.finish()
    }
}