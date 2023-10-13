package com.example.lab7.ui.meals.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab7.networking.response.MealX
import com.example.lab7.ui.meals.repository.MealsRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MealsVM(private val repo: MealsRepo = MealsRepo()): ViewModel(){
    val MealsState: MutableState<List<MealX>> = mutableStateOf(emptyList())

    init {
        viewModelScope.launch(Dispatchers.IO){
            val meals = getMeals()
            MealsState.value = meals
        }
    }

    private suspend fun getMeals(): List<MealX>{
        return repo.getMeals().meals
    }
}