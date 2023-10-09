package com.example.lab7diegogar.ui.theme.ui.mealDetail.repository

import com.example.lab7diegogar.ui.theme.networking.MealWebServ
import com.example.lab7diegogar.ui.theme.networking.response.MealsDetailDC

class MealDetailRepository(private val webServ: MealWebServ = MealWebServ()) {
    suspend fun getMealsDetails(): MealsDetailDC {
        return webServ.getMealsDetails()
    }
}