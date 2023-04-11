package com.example.mealdbapi.data.model.mealcategories


import com.google.gson.annotations.SerializedName

data class MealcategoriesModel(
    @SerializedName("meals")
    val meals: List<MealModel?>? = listOf()
):java.io.Serializable