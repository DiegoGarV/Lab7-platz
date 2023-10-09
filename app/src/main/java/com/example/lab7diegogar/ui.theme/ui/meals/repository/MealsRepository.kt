package com.example.lab7diegogar.ui.theme.ui.meals.repository

import com.example.lab7diegogar.ui.theme.networking.MealWebServ
import com.example.lab7diegogar.ui.theme.networking.dtos.MealsDto

class MealsRepository(private val webServ: MealWebServ = MealWebServ()) {
    suspend fun getMeals(): MealsDto {
        return webServ.getMeals()
    }
}