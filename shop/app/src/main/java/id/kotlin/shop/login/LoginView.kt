package id.kotlin.shop.login

import id.kotlin.shop.data.user.User

interface LoginView {

    fun onUserCreated(user: User)
    fun onLoginSuccess()
}