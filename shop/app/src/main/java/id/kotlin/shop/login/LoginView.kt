package id.kotlin.shop.login

interface LoginView {

    fun onUserCreated(username: String, password: String)
    fun onLoginSuccess()
}