package id.kotlin.shop.ext

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

fun CompositeDisposable?.safeDisposable() {
    this?.clear()
}

fun <T> Observable<T>.applySchedulers(): Observable<T> = observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io())