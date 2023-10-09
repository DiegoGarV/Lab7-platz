package com.example.lab7diegogar.ui.theme.ui.categories.repository

import com.example.lab7diegogar.ui.theme.networking.MealWebServ
import com.example.lab7diegogar.ui.theme.networking.dtos.CategoriesDto

class CategoriesRepository(private val webServ: MealWebServ = MealWebServ()) {
    suspend fun getCategories(): CategoriesDto {
        return webServ.getCategories()
    }
}