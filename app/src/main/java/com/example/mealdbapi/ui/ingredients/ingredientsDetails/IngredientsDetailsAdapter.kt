package com.example.mealdbapi.ui.ingredients.ingredientsDetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mealdbapi.R
import com.example.mealdbapi.data.model.ingredientsDetails.MealModel

import com.example.mealdbapi.databinding.ItemMealingredientsDetailsBinding


class IngredientsDetailsAdapter(var ingredientsDetails: List<MealModel?>?) :
    RecyclerView.Adapter<IngredientsDetailsAdapter.ViewHolder>() {

    class ViewHolder(val view: View) :RecyclerView.ViewHolder(view){
        val binding = ItemMealingredientsDetailsBinding.bind(view)

        fun handleData(item: com.example.mealdbapi.data.model.ingredientsDetails.MealModel?,
                       function: (com.example.mealdbapi.data.model.ingredientsDetails.MealModel) -> Unit?){
            item?.let {
                Glide.with(view).load(it.strMealThumb).placeholder(R.drawable.ic_launcher_foreground)
                    .into(binding.mealIngredientsThumb)
                binding.mealIngredientsDetailId.text = item?.idMeal
                binding.mealIngredientsDetailName.text = item?.strMeal

            }
        }
    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientsDetailsAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mealingredients_details, parent, false)
        return IngredientsDetailsAdapter.ViewHolder(view)
    }

    override fun getItemCount(): Int = ingredientsDetails?.size?: 0


    override fun onBindViewHolder(holder: IngredientsDetailsAdapter.ViewHolder, position: Int) {
        holder.handleData(ingredientsDetails?.get(position))
        { em: com.example.mealdbapi.data.model.ingredientsDetails.MealModel ->
        }
    }

}
