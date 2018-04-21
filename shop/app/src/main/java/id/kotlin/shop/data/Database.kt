package id.kotlin.shop.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import id.kotlin.shop.data.product.Product
import id.kotlin.shop.data.product.ProductDao
import id.kotlin.shop.data.user.User
import id.kotlin.shop.data.user.UserDao

@Database(entities =
[
    User::class,
    Product::class
], version = 1)
abstract class Database : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun productDao(): ProductDao
}