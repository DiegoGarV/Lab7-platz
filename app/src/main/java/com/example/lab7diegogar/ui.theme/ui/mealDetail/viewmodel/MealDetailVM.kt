package com.example.lab7diegogar.ui.theme.ui.mealDetail.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab7diegogar.ui.theme.networking.dtos.MealDetailDto
import com.example.lab7diegogar.ui.theme.ui.mealDetail.repository.MealDetailRepository
import com.example.lab7diegogar.ui.theme.ui.meals.repository.MealsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MealDetailVM(private val repo: MealDetailRepository = MealDetailRepository()):ViewModel(){
    val MealDetailState: MutableState<List<MealDetailDto>> = mutableStateOf(emptyList<MealDetailDto>())

    init {
        viewModelScope.launch(Dispatchers.IO){
            val meals = getMealDetail()
            MealDetailState.value = meals
        }
    }

    private suspend fun getMealDetail(): List<MealDetailDto>{
        return repo.getMealsDetails().meals
    }
}