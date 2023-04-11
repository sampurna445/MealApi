package com.example.mealdbapi.data.model.ingredientsDetails


import com.google.gson.annotations.SerializedName

data class MealModel(
    @SerializedName("idMeal")
    val idMeal: String? = "",
    @SerializedName("strMeal")
    val strMeal: String? = "",
    @SerializedName("strMealThumb")
    val strMealThumb: String? = ""
)