package com.example.mealdbapi.data.remote

import com.example.mealdbapi.data.model.areas.MealAreasModel
import com.example.mealdbapi.data.model.areasDetail.AreasDetailsModel
import com.example.mealdbapi.data.model.ingredients.MealIngredientsModel
import com.example.mealdbapi.data.model.ingredientsDetails.IngredientsDetailsModel
import com.example.mealdbapi.data.model.mealcategories.MealcategoriesModel
import com.example.mealdbapi.data.model.mealcategoriesDetails.MealcategoryDetailModel
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiRequest {
    @GET(ApiDetails.MEAL_CATEGORIES_ENDPOINT)
    suspend fun getMealcategories(): MealcategoriesModel

    @GET(ApiDetails.AREAS_ENDPOINT)
    suspend fun getMealAreas(): MealAreasModel

    @GET(ApiDetails.INGREDIENTS_ENDPOINT)
    suspend fun getMealIngredients(): MealIngredientsModel

    @GET(ApiDetails.DETAILS_ENDPOINT)
    suspend fun getMealcategoriesDetails(@Query("c") strCategory :String): MealcategoryDetailModel


    @GET(ApiDetails.DETAILS_ENDPOINT)
    suspend fun getAreasDetails(@Query("a") strArea :String): AreasDetailsModel

    @GET(ApiDetails.DETAILS_ENDPOINT)
    suspend fun getIngredientsDetails(@Query("i") strIngredient :String): IngredientsDetailsModel



}