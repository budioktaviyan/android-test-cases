package id.kotlin.shop.detail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import id.kotlin.shop.R
import id.kotlin.shop.deps.ShopDepsProvider
import id.kotlin.shop.ext.getDrawableResource
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity(), DetailView {

    private lateinit var presenter: DetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        (application as? ShopDepsProvider)?.providesShopDeps?.inject(this)
        (application as? ShopDepsProvider)?.providesDatabaseDeps?.let {
            presenter = DetailPresenter(this, it)
        }

        toolbar_detail.navigationIcon = getDrawableResource(R.drawable.bg_menu_back)
        setSupportActionBar(toolbar_detail)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            title = title
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}