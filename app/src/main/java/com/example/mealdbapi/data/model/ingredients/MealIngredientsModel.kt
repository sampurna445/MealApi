package com.example.mealdbapi.data.model.ingredients


import com.google.gson.annotations.SerializedName

data class MealIngredientsModel(
    @SerializedName("meals")
    val meals: List<MealModel?>? = listOf()
):java.io.Serializable