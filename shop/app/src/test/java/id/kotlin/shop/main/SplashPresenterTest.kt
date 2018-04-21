package id.kotlin.shop.main

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import id.kotlin.shop.data.Database
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

class SplashPresenterTest : Spek({

    given("a SplashPresenter") {
        val view: SplashView = mock()
        val database: Database = mock()
        val presenter = SplashPresenter(view, database)

        on("Check current user when it's empty") {
            whenever(presenter.userChecking()).thenReturn(view.onLaunchLogin())

            it("Should return to login screen if no user") {
                view.onLaunchLogin()
            }
        }

        on("Check current user when it's available") {
            whenever(presenter.userChecking()).thenReturn(view.onLaunchHome())

            it("Should return to home screen if user is available") {
                view.onLaunchHome()
            }
        }
    }
})