package com.example.mealdbapi.ui.areas

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealdbapi.data.model.areas.MealAreasModel
import com.example.mealdbapi.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AreasViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    val areas = MutableLiveData<MealAreasModel>()

    fun getMealAreas() {
        viewModelScope.launch {
            val repository = repository.getMealAreas()
            areas.postValue(repository)
        }
    }
}