package com.example.mealdbapi.ui.mealcategories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealdbapi.data.model.ingredients.MealIngredientsModel
import com.example.mealdbapi.data.model.mealcategories.MealcategoriesModel
import com.example.mealdbapi.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealcategoriesViewModel @Inject constructor(
    val repository: Repository
) : ViewModel() {

    val mealcategories = MutableLiveData<MealcategoriesModel>()

    fun getMealcategories() {
        viewModelScope.launch {
            val repository = repository.getMealcategories()
            mealcategories.postValue(repository)
        }
    }
}