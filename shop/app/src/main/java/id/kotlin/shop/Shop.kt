package id.kotlin.shop

import android.arch.persistence.room.Room
import android.support.multidex.MultiDexApplication
import id.kotlin.shop.data.Database
import id.kotlin.shop.ext.clazz

class Shop : MultiDexApplication() {

    lateinit var database: Database

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, clazz<Database>(), "shop.db").build()
    }
}