package com.example.lab7diegogar.ui.theme.ui.mealDetail.repository

import com.example.lab7diegogar.ui.theme.networking.MealWebServ
import com.example.lab7diegogar.ui.theme.networking.dtos.MealsDetailsDto

class MealDetailRepository(private val webServ: MealWebServ = MealWebServ()) {
    suspend fun getMealsDetails(): MealsDetailsDto {
        return webServ.getMealsDetails()
    }
}