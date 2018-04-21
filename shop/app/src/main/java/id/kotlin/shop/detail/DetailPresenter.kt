package id.kotlin.shop.detail

import id.kotlin.shop.data.Database
import id.kotlin.shop.data.product.Product
import id.kotlin.shop.ext.applySchedulers
import id.kotlin.shop.ext.safeDisposable
import io.reactivex.disposables.CompositeDisposable

class DetailPresenter(private val view: DetailView,
                      private val database: Database) {

    private val disposables by lazy { CompositeDisposable() }

    fun load(): List<Product> {
        val dao = database.productDao()
        val disposable = dao.findAll()
                .applySchedulers()
                .subscribe({ view.onLoadSuccess(it) })
        disposables.add(disposable)

        return emptyList()
    }

    fun onDestroy() {
        disposables.safeDisposable()
    }
}