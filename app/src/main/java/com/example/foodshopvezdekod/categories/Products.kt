package com.example.foodshopvezdekod.categories

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class Products {
    private var currentProducts: ArrayList<Product> = ArrayList();
    var allProducts: HashMap<Int, ArrayList<Product>> = HashMap()
    var currentId: Int = 0


    inner class Product(
        val id: Int, val category_id: Int, val name: String,
        val description: String, val image: String, var price_current: Int,
        var price_old: Int, val measure: Int, val measure_unit: String,
        val energy_per_100_grams: Float, val proteins_per_100_grams: Float,
        val fats_per_100_grams: Float, val carbohydrates_per_100_grams: Float,
        val tag_ids: ArrayList<Int>
    )


    constructor (applicationContext: Context, categories: ArrayList<Categories.Category>) {
        val jsonString: String? = readJsonToString(applicationContext, "products.json")

        val gson = Gson()
        val listProductType = object : TypeToken<List<Product>>() {}.type
        val everything: ArrayList<Product> = gson.fromJson(jsonString, listProductType)

        everything.sortBy { it.category_id }

        for (el in categories) { allProducts[el.id] = ArrayList() }

        for (el in everything) { allProducts[el.category_id]!!.add(el) }

        currentProducts = allProducts.get(categories[0].id)!!
    }

    fun changeProducts(id: Int) { currentProducts = allProducts[id]!! }

    fun getProducts(): ArrayList<Product> { return currentProducts }

    fun getSize(): Int { return currentProducts.size }
}