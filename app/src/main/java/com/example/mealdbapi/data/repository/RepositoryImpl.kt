package com.example.mealdbapi.data.repository

import com.example.mealdbapi.data.model.areas.MealAreasModel
import com.example.mealdbapi.data.model.areasDetail.AreasDetailsModel
import com.example.mealdbapi.data.model.ingredients.MealIngredientsModel
import com.example.mealdbapi.data.model.ingredientsDetails.IngredientsDetailsModel
import com.example.mealdbapi.data.model.mealcategories.MealModel
import com.example.mealdbapi.data.model.mealcategories.MealcategoriesModel
import com.example.mealdbapi.data.model.mealcategoriesDetails.MealcategoryDetailModel
import com.example.mealdbapi.data.remote.ApiRequest
import retrofit2.http.Query
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
val apiRequest: ApiRequest
):Repository {
    override suspend fun getMealcategories(): MealcategoriesModel = apiRequest.getMealcategories()
    override suspend fun getMealAreas(): MealAreasModel = apiRequest.getMealAreas()
    override suspend fun getMealIngredients(): MealIngredientsModel = apiRequest.getMealIngredients()

    override suspend fun getMealcategoriesDetails(@Query("c") strCategory :String):
            MealcategoryDetailModel = apiRequest.getMealcategoriesDetails(strCategory)


    override suspend fun getAreasDetails(@Query("a") strArea:String):
            AreasDetailsModel = apiRequest.getAreasDetails(strArea)

    override suspend fun getIngredientsDetails(@Query("i") strIngredient :String):
            IngredientsDetailsModel =apiRequest.getIngredientsDetails(strIngredient)

}