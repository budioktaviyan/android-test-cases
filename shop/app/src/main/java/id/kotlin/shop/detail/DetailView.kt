package id.kotlin.shop.detail

import id.kotlin.shop.data.product.Product

interface DetailView {

    fun onLoadSuccess(products: List<Product>)
}