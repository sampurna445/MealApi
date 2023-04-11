package com.example.mealdbapi.ui.mealcategories.mealcategoriesDetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealdbapi.data.model.mealcategories.MealcategoriesModel
import com.example.mealdbapi.data.model.mealcategoriesDetails.MealcategoryDetailModel
import com.example.mealdbapi.data.repository.Repository
import com.example.mealdbapi.data.repository.RepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealcategoriesDetailsViewModel@Inject constructor(
    val repository: Repository
) : ViewModel() {
    val mealcategoriesDetails = MutableLiveData<MealcategoryDetailModel>()

    fun getMealcategoriesDetails(strCategory:String) {
        viewModelScope.launch {
            val repository = repository.getMealcategoriesDetails(strCategory)
            mealcategoriesDetails.postValue(repository)
        }
    }
}