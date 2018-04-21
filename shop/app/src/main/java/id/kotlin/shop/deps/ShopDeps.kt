package id.kotlin.shop.deps

import dagger.Component
import id.kotlin.shop.home.HomeActivity
import id.kotlin.shop.login.LoginActivity
import id.kotlin.shop.main.SplashActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ShopModule::class
])
interface ShopDeps {

    fun inject(splashActivity: SplashActivity)
    fun inject(loginActivity: LoginActivity)
    fun inject(homeActivity: HomeActivity)
}