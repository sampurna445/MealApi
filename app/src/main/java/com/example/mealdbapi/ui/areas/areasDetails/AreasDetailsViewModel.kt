package com.example.mealdbapi.ui.areas.areasDetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealdbapi.data.model.areasDetail.AreasDetailsModel
import com.example.mealdbapi.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class AreasDetailsViewModel @Inject constructor(
    val repository: Repository
) : ViewModel() {
    val areasDetails = MutableLiveData<AreasDetailsModel>()

    fun getAreasDetails(strArea:String) {
        viewModelScope.launch {
            val repository = repository.getAreasDetails(strArea)
            areasDetails.postValue(repository)
        }
    }
}