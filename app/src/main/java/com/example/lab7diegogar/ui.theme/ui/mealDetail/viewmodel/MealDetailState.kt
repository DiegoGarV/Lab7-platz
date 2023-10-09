package com.example.lab7diegogar.ui.theme.ui.mealDetail.viewmodel

import com.example.lab7diegogar.ui.theme.networking.response.MealDC

data class MealDetailState(
    val loading: Boolean = false,
    val filtro: List<MealDC> = emptyList(),
    val error: String = ""
)
