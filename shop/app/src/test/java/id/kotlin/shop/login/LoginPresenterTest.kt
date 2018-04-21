package id.kotlin.shop.login

import com.nhaarman.mockito_kotlin.mock
import id.kotlin.shop.data.Database
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

class LoginPresenterTest : Spek({

    given("a LoginPresenter") {
        val view: LoginView = mock()
        val database: Database = mock()
        val presenter = LoginPresenter(view, database)

        on("Do login") {
            presenter.login("budi", "oktaviyan")

            it("Should return to home screen") {
                view.onLoginSuccess()
            }
        }

        on("Do login with fresh install") {
            val username = "admin"
            val password = "password"
            presenter.login(username, password)

            it("Should stay at current screen") {
                view.onUserCreated(username, password)
            }
        }
    }
})