package com.example.mealdbapi.ui.ingredients

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mealdbapi.R
import com.example.mealdbapi.data.model.ingredients.MealModel
import com.example.mealdbapi.databinding.ItemMealingredientsBinding
import com.example.mealdbapi.ui.areas.MealAreasAdapter

class MealIngredientsAdapter(var mealIngredients: List<MealModel?>?) :
    RecyclerView.Adapter<MealIngredientsAdapter.ViewHolder>() {

    var onItemClick: ((com.example.mealdbapi.data.model.ingredients.MealModel) -> Unit)? = null

    class ViewHolder(val view: View):RecyclerView.ViewHolder(view) {
        val binding = ItemMealingredientsBinding.bind(view)

        fun handleData(item: MealModel?) {
            binding.ingredientsId.text = item?.idIngredient
            binding.ingredientName.text = item?.strIngredient

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):MealIngredientsAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mealingredients, parent, false)
        return MealIngredientsAdapter.ViewHolder(view)
    }

    override fun getItemCount(): Int = mealIngredients?.size?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.handleData(mealIngredients?.get(position))

        holder.itemView.setOnClickListener {
            mealIngredients?.get(position)?.let {
                onItemClick?.invoke(it)
            }
        }

    }

}
