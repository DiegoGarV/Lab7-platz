package com.example.lab7diegogar.ui.theme.ui.categories.repository

import com.example.lab7diegogar.ui.theme.networking.MealWebServ
import com.example.lab7diegogar.ui.theme.networking.response.CategoriesDC

class CategoriesRepository(private val webServ: MealWebServ = MealWebServ()) {
    suspend fun getCategories(): CategoriesDC {
        return webServ.getCategories()
    }
}