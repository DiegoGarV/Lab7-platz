package com.example.lab7diegogar.ui.theme.networking

import com.example.lab7diegogar.ui.theme.networking.response.CategoriesDC
import com.example.lab7diegogar.ui.theme.networking.response.MealsDC
import com.example.lab7diegogar.ui.theme.networking.response.MealsDetailDC
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

    suspend fun getCategories(): CategoriesDC {
        return api.getCategories()
    }

    suspend fun getMeals(): MealsDC {
        return api.getMeals()
    }

    suspend fun getMealsDetails(): MealsDetailDC {
        return api.getMealDetail()
    }
}