package com.example.lab7.ui.meals.repository

import com.example.lab7.networking.MealsWebService
import com.example.lab7.networking.response.MealsResponse

class MealsRepo(private val webServ: MealsWebService = MealsWebService()) {
    suspend fun getMeals(): MealsResponse {
        return webServ.getMeals()
    }
}