package id.kotlin.shop

import android.arch.persistence.room.Room
import android.support.multidex.MultiDexApplication
import id.kotlin.shop.data.Database
import id.kotlin.shop.deps.DaggerShopDeps
import id.kotlin.shop.deps.ShopDeps
import id.kotlin.shop.deps.ShopDepsProvider
import id.kotlin.shop.deps.ShopModule
import id.kotlin.shop.ext.clazz

class Shop : MultiDexApplication(), ShopDepsProvider {

    private lateinit var deps: ShopDeps
    private lateinit var database: Database

    override fun onCreate() {
        super.onCreate()
        deps = DaggerShopDeps.builder().shopModule(ShopModule()).build()
        database = Room.databaseBuilder(this, clazz<Database>(), "shop.db").build()
    }

    override val providesShopDeps: ShopDeps
        get() = deps
}