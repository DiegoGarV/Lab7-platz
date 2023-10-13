package com.example.lab7.ui.categories.repository

import com.example.lab7.networking.MealsWebService
import com.example.lab7.networking.response.CategoriesResponse

class CategoriesRepo (private val webServ: MealsWebService = MealsWebService()) {
    suspend fun getCategories(): CategoriesResponse {
        return webServ.getCategories()
    }
}