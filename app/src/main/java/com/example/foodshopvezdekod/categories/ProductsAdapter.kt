package com.example.foodshopvezdekod.categories

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodshopvezdekod.R


class ProductsAdapter(private val products: Products) :
    RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val linearLayout: LinearLayout
        val productNameText: TextView
        val buyProductButton: RelativeLayout
        val productWeight: TextView
//        val productPrice: TextView

        init {
            // Define click listener for the ViewHolder's View.
            linearLayout = view.findViewById(R.id.product)
            productNameText = view.findViewById(R.id.product_name)
            buyProductButton = view.findViewById(R.id.buy_button)
            productWeight = view.findViewById(R.id.product_weight)
//            productPrice = view.findViewById(R.id.product_price)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
//        val view = LayoutInflater.from(viewGroup.context)
//            .inflate(R.layout.cards_items, viewGroup, false)

        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.cards_items, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
//        viewHolder.itemId("productName").text = dataSet[position]
//        viewHolder.linearLayout.findViewById<TextView>(R.id.productName).text = dataSet[position]

        val prods = products.getProducts()

        viewHolder.productNameText.text = prods[position].name

        var meas: String = prods[position].measure.toString() + " " + prods[position].measure_unit
        viewHolder.productWeight.text = meas
//            prods[position]
//            "$prods[position].measure $prods[position].measureUnit"

//        viewHolder.textView.text = dataSet[position]
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = products.getSize()

}

