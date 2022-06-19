package com.example.foodshopvezdekod.categories

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodshopvezdekod.MainActivity
import com.example.foodshopvezdekod.R


class CategoryAdapter(private var categories: Categories, private val context: MainActivity,
                      private val manager: LinearLayoutManager) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    val buttonCircleBackground: Int = R.drawable.button_circle_background
    private var currentPosition: Int = 0
    var categoriesMatching: HashMap<Int, Int> = HashMap()

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val categoryName: TextView = view.findViewById(R.id.recyclerLayoutTextView)

        init {
            categoryName.setOnClickListener {
                // Used To be a code to highlight selected category
                // but removed due to troubles with RecyclerView



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

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.categories_items, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

//        if (position == 0) {
//            viewHolder.categoryName.background = getBtnCircle()
//            viewHolder.categoryName.setTextColor(getColor(R.color.white))
//        }
//        viewHolder.categoryName.setSelected(currentPosition == position)
//        viewHolder.itemView.setSelected(currentPosition == position)
        categoriesMatching.put(position, categories.getElByPos(position).id)

        viewHolder.categoryName.text = categories.getElByPos(position).name
    }


    override fun getItemCount() = categories.getSize()

    private fun getBtnCircle(): Drawable? { return ContextCompat.getDrawable(context, buttonCircleBackground) }

    private fun getColor(id: Int): Int { return ContextCompat.getColor(context, id) }
}

