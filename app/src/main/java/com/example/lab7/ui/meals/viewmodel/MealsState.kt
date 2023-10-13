package com.example.lab7.ui.meals.viewmodel

import com.example.lab7.networking.response.MealsResponse

data class MealsState(
    val loading: Boolean = false,
    val meals: List<MealsResponse> = emptyList(),
    val error: String = ""
)
