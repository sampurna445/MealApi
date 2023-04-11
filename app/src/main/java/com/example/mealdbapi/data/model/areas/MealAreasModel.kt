package com.example.mealdbapi.data.model.areas


import com.google.gson.annotations.SerializedName

data class MealAreasModel(
    @SerializedName("meals")
    val meals: List<MealModel?>? = listOf()
):java.io.Serializable