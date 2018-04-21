package id.kotlin.shop.home

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import id.kotlin.shop.R
import id.kotlin.shop.data.product.Product
import id.kotlin.shop.deps.ShopDepsProvider
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), HomeView {

    private lateinit var presenter: HomePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        (application as? ShopDepsProvider)?.providesShopDeps?.inject(this)
        (application as? ShopDepsProvider)?.providesDatabaseDeps?.let {
            presenter = HomePresenter(this, it)
        }

        setSupportActionBar(toolbar_home)
        supportActionBar?.apply {
            title = title
        }
        btn_save.setOnClickListener {
            val productName = et_product_name.text.toString()
            val productQuantity = et_product_quantity.text.toString()
            val productSupplier = et_product_supplier.text.toString()
            val productDate = et_product_date.text.toString()
            val notes = et_product_notes.text.toString()
            val product = Product(
                    name = productName,
                    quantity = productQuantity,
                    supplier = productSupplier,
                    date = productDate,
                    notes = notes
            )

            presenter.save(product)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun onSaveFailed() {
        Toast.makeText(this, "Please input the product correctly", Toast.LENGTH_SHORT).show()
    }

    override fun onSaveSuccess() {
        Toast.makeText(this, "Success save a product", Toast.LENGTH_SHORT).show()
    }
}