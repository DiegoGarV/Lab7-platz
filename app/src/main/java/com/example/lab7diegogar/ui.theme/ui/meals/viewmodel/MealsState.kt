package com.example.lab7diegogar.ui.theme.ui.meals.viewmodel

import com.example.lab7diegogar.ui.theme.networking.response.MealsDC

data class MealsState(
    val loading: Boolean = false,
    val meals: List<MealsDC> = emptyList(),
    val error: String = ""
)
