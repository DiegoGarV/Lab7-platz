package com.example.lab7diegogar.ui.theme.ui.mealDetail.viewmodel

import com.example.lab7diegogar.ui.theme.networking.dtos.MealDto

data class MealDetailState(
    val loading: Boolean = false,
    val filtro: List<MealDto> = emptyList(),
    val error: String = ""
)
