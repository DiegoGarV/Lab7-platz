package com.example.lab7diegogar.ui.theme.networking

import com.example.lab7diegogar.ui.theme.networking.dtos.CategoriesDto
import com.example.lab7diegogar.ui.theme.networking.dtos.MealsDetailsDto
import com.example.lab7diegogar.ui.theme.networking.dtos.MealsDto
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MealWebServ{
    private var api: MealsApi

    init{
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api = retrofit.create(MealsApi::class.java)
    }

    suspend fun getCategories(): CategoriesDto{
        return api.getCategories()
    }

    suspend fun getMeals(): MealsDto {
        return api.getMeals()
    }

    suspend fun getMealsDetails(): MealsDetailsDto {
        return api.getMealDetail()
    }
}