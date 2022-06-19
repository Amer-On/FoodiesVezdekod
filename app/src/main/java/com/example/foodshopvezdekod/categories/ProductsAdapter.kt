package com.example.foodshopvezdekod.categories

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodshopvezdekod.R


class ProductsAdapter(private val products: Products) :
    RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val linearLayout: LinearLayout
        val productNameText: TextView
        val buyProductButton: RelativeLayout
        val productWeight: TextView
        val productPrice: Button

        init {
            linearLayout = view.findViewById(R.id.product)
            productNameText = view.findViewById(R.id.product_name)
            buyProductButton = view.findViewById(R.id.buy_button)
            productWeight = view.findViewById(R.id.product_weight)
            productPrice = view.findViewById(R.id.product_price)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.cards_items, viewGroup, false)

        return ViewHolder(view)
    }


    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val prods = products.getProducts()

        viewHolder.productNameText.text = prods[position].name

        if (prods[position].measure > 0) {
            var meas: String =
                prods[position].measure.toString() + " " + prods[position].measure_unit
            viewHolder.productWeight.text = meas
        }
        viewHolder.productPrice.text = prods[position].price_current.toString()
    }

    override fun getItemCount() = products.getSize()

}

