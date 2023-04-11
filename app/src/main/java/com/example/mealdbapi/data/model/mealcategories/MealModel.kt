package com.example.mealdbapi.data.model.mealcategories


import com.google.gson.annotations.SerializedName

data class MealModel(
    @SerializedName("strCategory")
    val strCategory: String? = ""
):java.io.Serializable