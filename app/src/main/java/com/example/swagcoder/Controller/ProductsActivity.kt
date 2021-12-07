package com.example.swagcoder.Controller

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.example.swagcoder.Adapters.ProductsAdapter
import com.example.swagcoder.Model.Product
import com.example.swagcoder.R
import com.example.swagcoder.Services.DataService
import com.example.swagcoder.Utilities.EXTRA_CATEGORY
import com.example.swagcoder.Utilities.EXTRA_PRODUCT
import kotlinx.android.synthetic.main.activity_products.*

class ProductsActivity : AppCompatActivity() {

    lateinit var adapter : ProductsAdapter
    //var product = Product("", "","")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)

        adapter = ProductsAdapter(this, DataService.getProducts(categoryType.toString())){
                product -> val productDetailsIntent = Intent(this, ProductsDetailsActivity::class.java)
            productDetailsIntent.putExtra(EXTRA_PRODUCT, product)
            startActivity(productDetailsIntent)
        }

        val orientation = resources.configuration.orientation
        var spanCount = 2
        if(orientation == Configuration.ORIENTATION_LANDSCAPE){
            spanCount = 3
        }

        val screenSize = resources.configuration.screenWidthDp
        if(screenSize > 720){
            spanCount = 3
        }

        val layoutManager = GridLayoutManager(this, spanCount)
        productsLV.layoutManager = layoutManager
        productsLV.adapter = adapter
    }
}