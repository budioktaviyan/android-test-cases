package id.kotlin.shop.home

import id.kotlin.shop.data.Database
import id.kotlin.shop.data.product.Product
import id.kotlin.shop.ext.safeDisposable
import io.reactivex.Flowable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class HomePresenter(private val view: HomeView,
                    private val database: Database) {

    private val disposables by lazy { CompositeDisposable() }

    fun save(product: Product) {
        if (product.name.isNullOrBlank()
        ||  product.quantity.isNullOrBlank()
        ||  product.supplier.isNullOrBlank()
        ||  product.date.isNullOrBlank()) {
            view.onSaveFailed()
            return
        }

        val dao = database.productDao()
        val disposable = Flowable.just(dao)
                .subscribeOn(Schedulers.io())
                .subscribe({
                    dao.create(product)
                })
        view.onSaveSuccess()
        disposables.add(disposable)
    }

    fun onDestroy() {
        disposables.safeDisposable()
    }
}