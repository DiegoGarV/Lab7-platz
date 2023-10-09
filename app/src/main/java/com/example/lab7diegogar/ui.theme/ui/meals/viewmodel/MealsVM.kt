package com.example.lab7diegogar.ui.theme.ui.meals.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab7diegogar.ui.theme.networking.dtos.MealDto
import com.example.lab7diegogar.ui.theme.ui.meals.repository.MealsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MealsVM(private val repo: MealsRepository = MealsRepository()):ViewModel(){
    val MealsState: MutableState<List<MealDto>> = mutableStateOf(emptyList<MealDto>())

    init {
        viewModelScope.launch(Dispatchers.IO){
            val mealsDetails = getMeals()
            MealsState.value = mealsDetails
        }
    }

    private suspend fun getMeals(): List<MealDto>{
        return repo.getMeals().meals
    }
}
