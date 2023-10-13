package com.example.lab7.ui.categories.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab7.networking.response.Category
import com.example.lab7.ui.categories.repository.CategoriesRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CategoriesVM(private val repo: CategoriesRepo = CategoriesRepo()): ViewModel(){
    val categoriesState: MutableState<List<Category>> = mutableStateOf(emptyList())

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val categories = getCat()
            categoriesState.value = categories
        }
    }

    private suspend fun getCat(): List<Category> {
        return repo.getCategories().categories
    }
}