package com.example.lab7diegogar.ui.theme.ui.meals.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab7diegogar.ui.theme.networking.response.MealDC
import com.example.lab7diegogar.ui.theme.ui.meals.repository.MealsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MealsVM(private val repo: MealsRepository = MealsRepository()):ViewModel(){
    val MealsState: MutableState<List<MealDC>> = mutableStateOf(emptyList())

    init {
        viewModelScope.launch(Dispatchers.IO){
            val meals = getMeals()
            MealsState.value = meals
        }
    }

    private suspend fun getMeals(): List<MealDC>{
        return repo.getMeals().meals
    }
}
