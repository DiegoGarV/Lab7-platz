package com.example.lab7diegogar.ui.theme.ui.categories.viewmodel

import com.example.lab7diegogar.ui.theme.networking.response.CategoriesDC

data class CategoriesState(
    val loading: Boolean = false,
    val categories: List<CategoriesDC> = emptyList(),
    val error: String = ""
)
