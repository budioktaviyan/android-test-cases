package id.kotlin.shop.detail

import android.support.v7.widget.RecyclerView.Adapter
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.View
import android.view.ViewGroup
import id.kotlin.shop.R
import id.kotlin.shop.data.product.Product
import id.kotlin.shop.detail.DetailAdapter.DetailViewHolder
import id.kotlin.shop.ext.inflate
import kotlinx.android.synthetic.main.item_detail.view.*

class DetailAdapter(private val products: List<Product>) : Adapter<DetailViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        val view = parent.inflate(parent.context, R.layout.item_detail, false)
        return DetailViewHolder(view)
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        val product = products[position]
        holder.bindView(product)
    }

    override fun getItemCount(): Int = products.size

    inner class DetailViewHolder(itemView: View) : ViewHolder(itemView) {

        fun bindView(product: Product) {
            with(product) {
                val resources = itemView.context.resources
                val productName = resources.getString(R.string.product_name).format(product.name)
                val productQuantity = resources.getString(R.string.product_quantity).format(product.quantity)
                val supplier = resources.getString(R.string.product_supplier).format(product.supplier)
                val date = resources.getString(R.string.product_date).format(product.date)

                itemView.tv_detail_name.text = productName
                itemView.tv_detail_quantity.text = productQuantity
                itemView.tv_detail_supplier.text = supplier
                itemView.tv_detail_date.text = date
            }
        }
    }
}