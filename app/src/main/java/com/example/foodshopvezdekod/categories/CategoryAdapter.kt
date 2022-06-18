package com.example.foodshopvezdekod.categories

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodshopvezdekod.MainActivity
import com.example.foodshopvezdekod.R
import org.w3c.dom.Text
import java.lang.Exception


class CategoryAdapter(private var categories: Categories, private val context: MainActivity,
                      private val manager: LinearLayoutManager) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
//class CategoryAdapter(private val dataSet: ArrayList<String>) :
//    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    val buttonCircleBackground: Int = R.drawable.button_circle_background
    private var currentPosition: Int = 0
    var categoriesMatching: HashMap<Int, Int> = HashMap()

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val categoryName: TextView = view.findViewById(R.id.recyclerLayoutTextView)

        init {
            // Define click listener for the ViewHolder's View.
            categoryName.setOnClickListener {
                // Do some work here
//                categoryName.setTextColor(getColor(R.color.primary))
                if (currentPosition != adapterPosition) {
//                    categoryName.background = getBtnCircle()
//                    categoryName.setTextColor(getColor(R.color.white))
//
//                    try {
//                        var oldView: TextView = manager.findViewByPosition(currentPosition)!!
//                            .findViewById(R.id.recyclerLayoutTextView)
//
//
//                        oldView.setBackgroundColor(getColor(R.color.transp))
//                        oldView.setTextColor(getColor(R.color.black))
//                    } catch (e: NullPointerException) { }

                    context.changeCategory(categoriesMatching.get(adapterPosition)!!)
                    currentPosition = adapterPosition
                }
            }

        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.categories_items, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
//        if (position == 0) {
//            viewHolder.categoryName.background = getBtnCircle()
//            viewHolder.categoryName.setTextColor(getColor(R.color.white))
//        }
//        viewHolder.categoryName.setSelected(currentPosition == position)
        viewHolder.itemView.setSelected(currentPosition == position)
        categoriesMatching.put(position, categories.getElByPos(position).id)

        viewHolder.categoryName.text = categories.getElByPos(position).name
    }


    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = categories.getSize()

    private fun getBtnCircle(): Drawable? { return ContextCompat.getDrawable(context, buttonCircleBackground) }

    private fun getColor(id: Int): Int { return ContextCompat.getColor(context, id) }
}

