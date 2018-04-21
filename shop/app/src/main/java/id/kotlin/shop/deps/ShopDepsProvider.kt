package id.kotlin.shop.deps

import id.kotlin.shop.data.Database

interface ShopDepsProvider {

    val providesShopDeps: ShopDeps
    val providesDatabaseDeps: Database
}