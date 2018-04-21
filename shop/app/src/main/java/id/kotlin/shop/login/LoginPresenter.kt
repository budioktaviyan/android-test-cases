package id.kotlin.shop.login

import id.kotlin.shop.data.Database
import id.kotlin.shop.data.user.User
import id.kotlin.shop.ext.safeDisposable
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit.MILLISECONDS

class LoginPresenter(private val view: LoginView,
                     private val database: Database) {

    private val disposables by lazy { CompositeDisposable() }

    fun login(user: User) {
        val dao = database.userDao()
        val disposable = dao.findById(user.username ?: "")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                        { view.onLoginSuccess() },
                        { _ -> view.onUserCreated(user) }
                )
        disposables.add(disposable)
    }

    fun create(user: User) {
        val dao = database.userDao()
        val disposable = Flowable.timer(1000L, MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .subscribe({
                    dao.create(user)
                })
        disposables.add(disposable)
    }

    fun onDestroy() {
        disposables.safeDisposable()
    }
}