package com.example.swagcoder.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.swagcoder.Model.Product
import com.example.swagcoder.R
import com.example.swagcoder.Utilities.EXTRA_PRODUCT
import kotlinx.android.synthetic.main.activity_products_details.*
import kotlinx.android.synthetic.main.product_list_item.*

class ProductsDetailsActivity : AppCompatActivity() {

    //lateinit var product : Product

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products_details)
        val product = intent.getParcelableExtra<Product>(EXTRA_PRODUCT)!!

        val resourceId = resources.getIdentifier(product.image, "drawable", packageName)
        productsDescriptionImage?.setImageResource(resourceId)
        productsDetailsName?.text = product.title
        productsDetailsPrice?.text = product.title
    }
}



















