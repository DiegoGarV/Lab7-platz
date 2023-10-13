package com.example.lab7.ui.categories.viewmodel

import com.example.lab7.networking.response.CategoriesResponse

data class CategoriesState(
    val loading: Boolean = false,
    val categories: List<CategoriesResponse> = emptyList(),
    val error: String = ""
)
