package com.example.mealdbapi.ui.areas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mealdbapi.R
import com.example.mealdbapi.data.model.areas.MealModel
import com.example.mealdbapi.databinding.ItemMealareasBinding

class MealAreasAdapter(var mealAreas: List<MealModel?>?) :
    RecyclerView.Adapter<MealAreasAdapter.ViewHolder>() {


    var onItemClick: ((MealModel) -> Unit)? = null

    class ViewHolder(val view: View) :RecyclerView.ViewHolder(view){
        val binding = ItemMealareasBinding.bind(view)

        fun handleData(item: com.example.mealdbapi.data.model.areas.MealModel?) {
            binding.mealAreaName.text = item?.strArea


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealAreasAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mealareas, parent, false)
        return MealAreasAdapter.ViewHolder(view)
    }

    override fun getItemCount(): Int  = mealAreas?.size?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.handleData(mealAreas?.get(position))
        holder.itemView.setOnClickListener {
            mealAreas?.get(position)?.let {
                onItemClick?.invoke(it)
            }
        }

    }

}
