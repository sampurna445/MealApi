package com.example.mealdbapi.data.model.mealcategoriesDetails


import com.google.gson.annotations.SerializedName

data class MealcategoryDetailModel(
    @SerializedName("meals")
    val meals: List<MealModel?>? = listOf()
)