package com.example.lab7diegogar.ui.theme.ui.meals.viewmodel

import com.example.lab7diegogar.ui.theme.networking.dtos.MealDetailDto

data class MealsState(
    val loading: Boolean = false,
    val meals: List<MealDetailDto> = emptyList(),
    val error: String = ""
)
