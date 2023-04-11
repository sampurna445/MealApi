package com.example.mealdbapi.data.repository

import com.example.mealdbapi.data.model.areas.MealAreasModel
import com.example.mealdbapi.data.model.areasDetail.AreasDetailsModel
import com.example.mealdbapi.data.model.ingredients.MealIngredientsModel
import com.example.mealdbapi.data.model.ingredientsDetails.IngredientsDetailsModel
import com.example.mealdbapi.data.model.mealcategories.MealModel
import com.example.mealdbapi.data.model.mealcategories.MealcategoriesModel
import com.example.mealdbapi.data.model.mealcategoriesDetails.MealcategoryDetailModel
import retrofit2.http.Query


interface Repository {
    suspend fun getMealcategories(): MealcategoriesModel
    suspend fun getMealAreas(): MealAreasModel
    suspend fun getMealIngredients(): MealIngredientsModel
  suspend fun getMealcategoriesDetails(@Query("c") strCategory :String): MealcategoryDetailModel
    suspend fun getAreasDetails(@Query("a") strArea:String): AreasDetailsModel
    suspend fun getIngredientsDetails(@Query("i") strIngredient :String): IngredientsDetailsModel
}