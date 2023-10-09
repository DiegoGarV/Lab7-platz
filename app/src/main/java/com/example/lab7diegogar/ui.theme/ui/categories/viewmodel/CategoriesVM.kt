package com.example.lab7diegogar.ui.theme.ui.categories.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab7diegogar.ui.theme.networking.dtos.CategoryDto
import com.example.lab7diegogar.ui.theme.ui.categories.repository.CategoriesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CategoriesVM(private val repo: CategoriesRepository = CategoriesRepository()): ViewModel(){
    val categoriesState: MutableState<List<CategoryDto>> = mutableStateOf(emptyList<CategoryDto>())

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val meals = getCat()
            categoriesState.value = meals
        }
    }

    private suspend fun getCat(): List<CategoryDto> {
        return repo.getCategories().categories
    }
}
