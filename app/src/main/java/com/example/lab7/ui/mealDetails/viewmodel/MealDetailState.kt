package com.example.lab7.ui.mealDetails.viewmodel

import com.example.lab7.networking.response.MealDetailResponse

data class MealDetailState(
    val loading: Boolean = false,
    val filtro: List<MealDetailResponse> = emptyList(),
    val error: String = ""
)

