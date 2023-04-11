package com.example.mealdbapi.data.model.ingredientsDetails


import com.google.gson.annotations.SerializedName

data class IngredientsDetailsModel(
    @SerializedName("meals")
    val meals: List<MealModel?>? = listOf()
)