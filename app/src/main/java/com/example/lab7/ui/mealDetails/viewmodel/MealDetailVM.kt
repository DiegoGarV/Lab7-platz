package com.example.lab7.ui.mealDetails.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab7.networking.response.Meal
import com.example.lab7.ui.mealDetails.repository.MealDetailsRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MealDetailVM(private val repo: MealDetailsRepo = MealDetailsRepo()): ViewModel(){
    val MealDetailState: MutableState<List<Meal>> = mutableStateOf(emptyList<Meal>())

    init {
        viewModelScope.launch(Dispatchers.IO){
            val meals = getMealDetail()
            MealDetailState.value = meals
        }
    }

    private suspend fun getMealDetail(): List<Meal>{
        return repo.getMealsDetails().meals
    }
}