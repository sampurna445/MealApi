package com.example.mealdbapi.ui.areas.areasDetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mealdbapi.R
import com.example.mealdbapi.data.model.areasDetail.MealModel
import com.example.mealdbapi.databinding.ItemMealareasDetailsBinding

import com.example.mealdbapi.ui.mealcategories.mealcategoriesDetails.MealcategoriesDetailsAdapter

class AreasDetailsAdapter(var areasDetails: List<MealModel?>?)
    : RecyclerView.Adapter<AreasDetailsAdapter.ViewHolder>() {


    class ViewHolder(val view: View) :RecyclerView.ViewHolder(view){
        val binding = ItemMealareasDetailsBinding.bind(view)

        fun handleData(item: com.example.mealdbapi.data.model.areasDetail.MealModel?,
                       function: (com.example.mealdbapi.data.model.areasDetail.MealModel) -> Unit?){
            item?.let {
                Glide.with(view).load(it.strMealThumb).placeholder(R.drawable.ic_launcher_foreground)
                    .into(binding.mealAreasThumb)
                binding.mealAreasDetailId.text = item?.idMeal
                binding.mealAreasDetailName.text = item?.strMeal

            }
        }
    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AreasDetailsAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mealareas_details, parent, false)
        return AreasDetailsAdapter.ViewHolder(view)
    }

    override fun getItemCount(): Int = areasDetails?.size?: 0


    override fun onBindViewHolder(holder: AreasDetailsAdapter.ViewHolder, position: Int) {
        holder.handleData(areasDetails?.get(position))
        { em: com.example.mealdbapi.data.model.areasDetail.MealModel ->
        }
    }

}

