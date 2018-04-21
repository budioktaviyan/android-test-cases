package id.kotlin.shop.deps

import dagger.Module
import dagger.Provides
import id.kotlin.shop.router.ShopRouter
import javax.inject.Singleton

@Module
class ShopModule {

    @Provides
    @Singleton
    fun providesShopRouter() = ShopRouter()
}