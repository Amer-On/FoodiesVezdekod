package com.example.foodshopvezdekod.categories

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class Products {
    private var currentProducts: ArrayList<Product> = ArrayList();
//    var allProducts: ArrayList<ArrayList<Product>> = ArrayList();

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

//        var curId: Int = 0
//        var idNotChanged: Boolean = true
//
//        var prodArray: ArrayList<Product> = ArrayList()
//
//        for (el in everything) {
//            if (idNotChanged) {
//                curId = el.category_id
//                prodArray.add(el)
//                idNotChanged = false
//            } else {
//                if (curId == el.category_id) {
//                    prodArray.add(el)
//                } else {
//                    allProducts.add(prodArray.clone() as ArrayList<Product>)
//                    prodArray = ArrayList()
//                    idNotChanged = true
//                }
//            }
//        }
//
//        if (!idNotChanged) { allProducts.add(prodArray.clone() as ArrayList<Product>) }



//        currentProducts = allProducts[0]

    }


//    init {
//
//        var products: ArrayList<Product> = ArrayList()
//        products.add(Product(19304061, 676171,
//            "Спайси унаги ролл 4шт", "Авторский ролл с трюфельным угрем, с начинкой из огурца, омлета и соуса спайси. Украшается соусом унаги и фурикакэ  Комплектуется бесплатным набором для роллов (Соевый соус Лайт 35г., васаби 6г., имбирь 15г.). +1 набор за каждые 600 рублей в заказе",
//            "1.jpg", 99999, 32953, 130, "г", 342.1f, 7f, 15.2f, 44.3f, arrayListOf(1)))
//        products.add(Product(19304062, 676171,
//            "Спайси унаги ролл 4шт", "Авторский ролл с трюфельным угрем, с начинкой из огурца, омлета и соуса спайси. Украшается соусом унаги и фурикакэ  Комплектуется бесплатным набором для роллов (Соевый соус Лайт 35г., васаби 6г., имбирь 15г.). +1 набор за каждые 600 рублей в заказе",
//            "1.jpg", 26000, 32953, 130, "г", 342.1f, 7f, 15.2f, 44.3f, arrayListOf(1)))
//        products.add(Product(19304063, 676171,
//            "Спайси унаги ролл 4шт", "Авторский ролл с трюфельным угрем, с начинкой из огурца, омлета и соуса спайси. Украшается соусом унаги и фурикакэ  Комплектуется бесплатным набором для роллов (Соевый соус Лайт 35г., васаби 6г., имбирь 15г.). +1 набор за каждые 600 рублей в заказе",
//            "1.jpg", 6969, 32953, 130, "г", 342.1f, 7f, 15.2f, 44.3f, arrayListOf(1)))
//        currentProducts = products
//
//        allProducts.add(products)
//
//        products = ArrayList()
//        products.add(Product(19304061, 676168,
//            "Роллы калифорония", "Авторский ролл с трюфельным угрем, с начинкой из огурца, омлета и соуса спайси. Украшается соусом унаги и фурикакэ  Комплектуется бесплатным набором для роллов (Соевый соус Лайт 35г., васаби 6г., имбирь 15г.). +1 набор за каждые 600 рублей в заказе",
//            "1.jpg", 969696, 32953, 130, "г", 342.1f, 7f, 15.2f, 44.3f, arrayListOf(1)))
//        products.add(Product(19304062, 676168,
//            "Спайси унаги ролл 4шт", "Авторский ролл с трюфельным угрем, с начинкой из огурца, омлета и соуса спайси. Украшается соусом унаги и фурикакэ  Комплектуется бесплатным набором для роллов (Соевый соус Лайт 35г., васаби 6г., имбирь 15г.). +1 набор за каждые 600 рублей в заказе",
//            "1.jpg", 7322, 32953, 130, "г", 342.1f, 7f, 15.2f, 44.3f, arrayListOf(1)))
//        products.add(Product(19304063, 676168,
//            "Спайси унаги ролл 4шт", "Авторский ролл с трюфельным угрем, с начинкой из огурца, омлета и соуса спайси. Украшается соусом унаги и фурикакэ  Комплектуется бесплатным набором для роллов (Соевый соус Лайт 35г., васаби 6г., имбирь 15г.). +1 набор за каждые 600 рублей в заказе",
//            "1.jpg", 10923, 32953, 130, "г", 342.1f, 7f, 15.2f, 44.3f, arrayListOf(1)))
//        products.add(Product(19304063, 676168,
//            "Merry Christmas", "Авторский ролл с трюфельным угрем, с начинкой из огурца, омлета и соуса спайси. Украшается соусом унаги и фурикакэ  Комплектуется бесплатным набором для роллов (Соевый соус Лайт 35г., васаби 6г., имбирь 15г.). +1 набор за каждые 600 рублей в заказе",
//            "1.jpg", 10923, 32953, 130, "г", 342.1f, 7f, 15.2f, 44.3f, arrayListOf(1)))
//        allProducts.add(products)
//
//    }


    fun changeProducts(id: Int) { currentProducts = allProducts[id]!! }

    fun getProducts(): ArrayList<Product> { return currentProducts }

    fun getSize(): Int { return currentProducts.size }
}