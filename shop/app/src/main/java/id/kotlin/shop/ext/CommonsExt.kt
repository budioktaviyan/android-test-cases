package id.kotlin.shop.ext

internal inline fun <reified T : Any> clazz() = T::class.java