package id.kotlin.shop.home

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import id.kotlin.shop.R
import id.kotlin.shop.data.product.Product
import id.kotlin.shop.deps.ShopDepsProvider
import id.kotlin.shop.router.ShopRouter
import kotlinx.android.synthetic.main.activity_home.*
import java.util.Calendar
import javax.inject.Inject

class HomeActivity : AppCompatActivity(), HomeView {

    @Inject lateinit var router: ShopRouter

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
        et_product_date.setOnClickListener {
            val calendar = Calendar.getInstance()
            val calendarDay = calendar.get(Calendar.DAY_OF_MONTH)
            val calendarMonth = calendar.get(Calendar.MONTH)
            val calendarYear = calendar.get(Calendar.YEAR)

            DatePickerDialog(this, OnDateSetListener { _, year, month, dayOfMonth ->
                val date = "$dayOfMonth/${month.plus(1)}/$year"
                et_product_date.setText(date)
            }, calendarYear, calendarMonth, calendarDay).show()
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.shop, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.menu_shop_detail -> router.launchDetail(this)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSaveFailed() {
        Toast.makeText(this, "Please input the product correctly", Toast.LENGTH_SHORT).show()
    }

    override fun onSaveSuccess() {
        Toast.makeText(this, "Success save a product", Toast.LENGTH_SHORT).show()
    }
}