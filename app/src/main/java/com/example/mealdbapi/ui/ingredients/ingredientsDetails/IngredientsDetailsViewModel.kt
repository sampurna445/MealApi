package com.example.mealdbapi.ui.ingredients.ingredientsDetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.mealdbapi.data.model.ingredientsDetails.IngredientsDetailsModel
import com.example.mealdbapi.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class IngredientsDetailsViewModel@Inject constructor(
    val repository: Repository
) : ViewModel() {
    val ingredientsDetails = MutableLiveData<IngredientsDetailsModel>()

    fun getIngredientsDetails(strIngredient: String) {
        viewModelScope.launch {
            val repository = repository.getIngredientsDetails(strIngredient)
            ingredientsDetails.postValue(repository)
        }
    }
}