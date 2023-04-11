package com.example.mealdbapi.data.model.ingredients


import com.google.gson.annotations.SerializedName

data class MealModel(
    @SerializedName("idIngredient")
    val idIngredient: String? = "",
    @SerializedName("strDescription")
    val strDescription: String? = "",
    @SerializedName("strIngredient")
    val strIngredient: String? = "",
    @SerializedName("strType")
    val strType: String? = ""
):java.io.Serializable