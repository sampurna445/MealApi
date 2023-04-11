package com.example.mealdbapi.ui.ingredients

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealdbapi.data.model.areas.MealAreasModel
import com.example.mealdbapi.data.model.ingredients.MealIngredientsModel
import com.example.mealdbapi.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class IngredientsViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    val ingredients = MutableLiveData<MealIngredientsModel>()

    fun getMealIngredients() {
        viewModelScope.launch {
            val repository = repository.getMealIngredients()
            ingredients.postValue(repository)
        }
    }
}