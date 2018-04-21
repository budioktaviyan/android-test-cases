package id.kotlin.shop.main

import id.kotlin.shop.ext.applySchedulers
import id.kotlin.shop.ext.safeDisposable
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit

class SplashPresenter(private val view: SplashView) {

    private val disposables by lazy { CompositeDisposable() }

    fun userChecking() {
        val disposable = Observable.timer(3000L, TimeUnit.MILLISECONDS)
                .applySchedulers()
                .subscribe({ view.onLaunchLogin() })
        disposables.add(disposable)
    }

    fun onDestroy() {
        disposables.safeDisposable()
    }
}