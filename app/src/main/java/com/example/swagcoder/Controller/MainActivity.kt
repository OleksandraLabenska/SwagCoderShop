package com.example.swagcoder.Controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.swagcoder.Adapters.CategoryAdapter
import com.example.swagcoder.Adapters.CategoryRecycleAdapter
import com.example.swagcoder.R
import com.example.swagcoder.Services.DataService
import com.example.swagcoder.Utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter : CategoryRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryRecycleAdapter(this, DataService.categories){
            category -> val productIntent = Intent(this, ProductsActivity::class.java)
            productIntent.putExtra(EXTRA_CATEGORY, category.title)
            startActivity(productIntent)
        }
        categoriesLV.adapter = adapter

        val layoutManager = LinearLayoutManager(this)
        categoriesLV.layoutManager = layoutManager
        categoriesLV.setHasFixedSize(true)


    }
}