package id.kotlin.shop.login

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import id.kotlin.shop.R
import id.kotlin.shop.deps.ShopDepsProvider
import id.kotlin.shop.router.ShopRouter
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : AppCompatActivity(), LoginView {

    @Inject lateinit var router: ShopRouter

    private lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        (application as? ShopDepsProvider)?.providesShopDeps?.inject(this)
        (application as? ShopDepsProvider)?.providesDatabaseDeps?.let {
            presenter = LoginPresenter(this, it)
        }

        btn_login.setOnClickListener {
            val username = et_username.text.toString()
            val password = et_password.text.toString()
            presenter.login(username, password)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun onUserCreated(username: String,
                               password: String) {
        Toast.makeText(this, "Created default user...", Toast.LENGTH_SHORT).show()
        presenter.create(username, password)
    }

    override fun onLoginSuccess() {
        router.launchHome(this)
    }
}