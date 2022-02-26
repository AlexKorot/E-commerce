package com.ex_commerce

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.ex_commerce.model.Category
import com.ex_commerce.databinding.CategoryItemBinding


class CategoryAdapter (categoryList:ArrayList<Category>,context: Context): RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    var categoryListR=categoryList
    var contextR=context

    class CategoryViewHolder(item:View):RecyclerView.ViewHolder(item) {
        val binding = CategoryItemBinding.bind(item)
        fun bind(category: Category,context: Context) = with(binding) {
             val title =category.title
            categoryTitle.text = title
            val id = category.id

        itemView.setOnClickListener {

            (context as MainActivity).showCoursesByCategory(id)
        }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.category_item,parent,false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(categoryListR[position],contextR)

    }

    override fun getItemCount(): Int {
        return categoryListR.size
    }
  /*  public fun addCategory(category: Category){
        categoryList.add(category)
        notifyDataSetChanged()
    }
*/
}