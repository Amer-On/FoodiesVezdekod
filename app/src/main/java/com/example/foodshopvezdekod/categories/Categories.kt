package com.example.foodshopvezdekod.categories

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class Categories {
    private var categories: ArrayList<Category> = ArrayList()

    inner class Category (val id: Int, val name: String)


    constructor(applicationContext: Context) {
        val jsonString: String? = readJsonToString(applicationContext, "categories.json")

        val gson = Gson()
        val listCategoryType = object : TypeToken<List<Categories.Category>>() {}.type
        categories = gson.fromJson(jsonString, listCategoryType)

        categories.sortBy { it.id }
    }

    fun getList(): ArrayList<Category> { return categories }

    fun getSize(): Int { return categories.size }

    fun getElByPos(pos: Int): Category { return categories[pos] }
}
