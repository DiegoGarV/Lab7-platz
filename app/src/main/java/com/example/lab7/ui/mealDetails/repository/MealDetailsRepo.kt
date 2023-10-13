package com.example.lab7.ui.mealDetails.repository

import com.example.lab7.networking.MealsWebService
import com.example.lab7.networking.response.MealDetailResponse

class MealDetailsRepo (private val webServ: MealsWebService = MealsWebService()) {
    suspend fun getMealsDetails(): MealDetailResponse {
        return webServ.getMealsDetails()
    }
}