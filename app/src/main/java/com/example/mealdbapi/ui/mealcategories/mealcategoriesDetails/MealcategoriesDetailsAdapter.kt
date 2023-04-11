package com.example.mealdbapi.ui.mealcategories.mealcategoriesDetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mealdbapi.R
import com.example.mealdbapi.data.model.mealcategoriesDetails.MealModel

import com.example.mealdbapi.databinding.ItemMealcategoriesDetailsBinding



class MealcategoriesDetailsAdapter(var mealCategoriesDetails: List<MealModel?>?) :
    RecyclerView.Adapter<MealcategoriesDetailsAdapter.ViewHolder>() {


    class ViewHolder(val view: View) :RecyclerView.ViewHolder(view){
        val binding = ItemMealcategoriesDetailsBinding.bind(view)

        fun handleData(item: MealModel?, function: (MealModel) -> Unit?){
            item?.let {
                Glide.with(view).load(it.strMealThumb).placeholder(R.drawable.ic_launcher_foreground)
                    .into(binding.avtarImg)
                binding.mealCategoryDetailId.text = item?.idMeal
                binding.mealCategoryDetailName.text = item?.strMeal

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealcategoriesDetailsAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mealcategories_details, parent, false)
        return MealcategoriesDetailsAdapter.ViewHolder(view)
    }

    override fun getItemCount(): Int = mealCategoriesDetails?.size?: 0


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.handleData(mealCategoriesDetails?.get(position)) { em: MealModel ->
        }
    }

}
