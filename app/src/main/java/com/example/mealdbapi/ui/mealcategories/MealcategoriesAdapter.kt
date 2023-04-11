package com.example.mealdbapi.ui.mealcategories

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mealdbapi.R
import com.example.mealdbapi.data.model.mealcategories.MealModel
import com.example.mealdbapi.data.model.mealcategories.MealcategoriesModel
import com.example.mealdbapi.databinding.ItemMealcategoriesBinding

class MealcategoriesAdapter(var mealcategories:  List<MealModel?>?) :
    RecyclerView.Adapter<MealcategoriesAdapter.ViewHolder>() {


    var onItemClick: ((MealModel) -> Unit)? = null

    class ViewHolder(val view: View) :RecyclerView.ViewHolder(view){
        val binding = ItemMealcategoriesBinding.bind(view)

        fun handleData(item: MealModel?) {
            binding.mealCategoryName.text = item?.strCategory


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealcategoriesAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mealcategories, parent, false)
        return MealcategoriesAdapter.ViewHolder(view)
    }

    override fun getItemCount(): Int = mealcategories?.size?: 0

      override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.handleData(mealcategories?.get(position))
          holder.itemView.setOnClickListener {
              mealcategories?.get(position)?.let {
                  onItemClick?.invoke(it)
              }
          }



      }

}
