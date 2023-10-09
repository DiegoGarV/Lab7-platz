package com.example.lab7diegogar.ui.theme.ui.categories.viewmodel

import com.example.lab7diegogar.ui.theme.networking.dtos.CategoriesDto

data class CategoriesState(
    val loading: Boolean = false,
    val categories: List<CategoriesDto> = emptyList(),
    val error: String = ""
)
