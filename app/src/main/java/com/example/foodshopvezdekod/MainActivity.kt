package com.example.foodshopvezdekod


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodshopvezdekod.categories.Categories
import com.example.foodshopvezdekod.categories.CategoryAdapter
import com.example.foodshopvezdekod.categories.Products
import com.example.foodshopvezdekod.categories.ProductsAdapter

class MainActivity : AppCompatActivity() {
//    val categories = Categories()
    lateinit var productsRecycler: RecyclerView
    lateinit var productsAdapter: ProductsAdapter
    lateinit var products: Products
    lateinit var categories: Categories

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var cnt = applicationContext
        categories = Categories(cnt)
        products = Products(cnt, categories.getList())

        val categoriesRecycler: RecyclerView = findViewById(R.id.categories)
        var categoriesLinManager = LinearLayoutManager(this,
            LinearLayoutManager.HORIZONTAL, false)

        categoriesRecycler.layoutManager = categoriesLinManager
        categoriesRecycler.adapter = CategoryAdapter(categories,
            this, categoriesLinManager)

        productsRecycler = findViewById(R.id.products)
        productsAdapter = ProductsAdapter(products)

        productsRecycler.layoutManager = GridLayoutManager(this, 2)
        productsRecycler.adapter = productsAdapter
    }


    fun changeCategory(position: Int) {
        products.changeProducts(position)

        productsRecycler = findViewById(R.id.products)
        productsAdapter = ProductsAdapter(products)
        productsRecycler.layoutManager = GridLayoutManager(this, 2)
        productsRecycler.adapter = productsAdapter
    }



}