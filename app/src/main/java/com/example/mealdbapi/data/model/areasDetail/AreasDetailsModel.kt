package com.example.mealdbapi.data.model.areasDetail


import com.google.gson.annotations.SerializedName

data class AreasDetailsModel(
    @SerializedName("meals")
    val meals: List<MealModel?>? = listOf()
)