package id.kotlin.shop.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import id.kotlin.shop.deps.ShopDepsProvider
import id.kotlin.shop.router.ShopRouter
import javax.inject.Inject

class SplashActivity : AppCompatActivity(), SplashView {

    @Inject lateinit var router: ShopRouter

    private lateinit var presenter: SplashPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as? ShopDepsProvider)?.providesShopDeps?.inject(this)
        (application as? ShopDepsProvider)?.providesDatabaseDeps?.let {
            presenter = SplashPresenter(this, it)
            presenter.userChecking()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun onLaunchLogin() {
        router.launchLogin(this)
    }

    override fun onLaunchHome() {
        router.launchHome(this)
    }
}