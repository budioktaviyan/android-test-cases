package id.kotlin.shop.detail

import id.kotlin.shop.data.Database
import id.kotlin.shop.ext.safeDisposable
import io.reactivex.disposables.CompositeDisposable

class DetailPresenter(private val view: DetailView,
                      private val database: Database) {

    private val disposables by lazy { CompositeDisposable() }

    fun onDestroy() {
        disposables.safeDisposable()
    }
}