package id.kotlin.shop.ext

import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

fun CompositeDisposable?.safeDisposable() {
    this?.clear()
}

fun <T> Flowable<T>.applySchedulers(): Flowable<T> = observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io())