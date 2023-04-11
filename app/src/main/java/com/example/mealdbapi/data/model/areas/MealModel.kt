package com.example.mealdbapi.data.model.areas


import com.google.gson.annotations.SerializedName

data class MealModel(
    @SerializedName("strArea")
    val strArea: String? = ""
):java.io.Serializable