package id.kotlin.shop.main

import id.kotlin.shop.data.Database
import id.kotlin.shop.ext.applySchedulers
import id.kotlin.shop.ext.safeDisposable
import io.reactivex.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit.MILLISECONDS

class SplashPresenter(private val view: SplashView,
                      private val database: Database) {

    private val disposables by lazy { CompositeDisposable() }

    fun userChecking() {
        val dao = database.userDao()
        val disposable = dao.findAll()
                .applySchedulers()
                .delay(1000L, MILLISECONDS)
                .subscribe({
                    when {
                        it.isEmpty() || it.size > 5 -> view.onLaunchLogin()
                        it.isNotEmpty() && it.size <= 5 -> view.onLaunchHome()
                    }
                })
        disposables.add(disposable)
    }

    fun onDestroy() {
        disposables.safeDisposable()
    }
}