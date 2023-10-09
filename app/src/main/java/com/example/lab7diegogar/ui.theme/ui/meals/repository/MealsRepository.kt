package com.example.lab7diegogar.ui.theme.ui.meals.repository

import com.example.lab7diegogar.ui.theme.networking.MealWebServ
import com.example.lab7diegogar.ui.theme.networking.response.MealsDC

class MealsRepository(private val webServ: MealWebServ = MealWebServ()) {
    suspend fun getMeals(): MealsDC {
        return webServ.getMeals()
    }
}