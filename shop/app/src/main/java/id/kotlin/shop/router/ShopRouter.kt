package id.kotlin.shop.router

import android.app.Activity
import android.content.Intent
import id.kotlin.shop.ext.clazz
import id.kotlin.shop.home.HomeActivity
import id.kotlin.shop.login.LoginActivity

class ShopRouter {

    fun launchLogin(activity: Activity) {
        val intent = Intent(activity, clazz<LoginActivity>())
        activity.startActivity(intent)
        activity.finish()
    }

    fun launchHome(activity: Activity) {
        val intent = Intent(activity, clazz<HomeActivity>())
        activity.startActivity(intent)
        activity.finish()
    }
}