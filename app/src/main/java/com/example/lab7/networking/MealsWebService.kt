package com.example.lab7.networking

import com.example.lab7.networking.response.CategoriesResponse
import com.example.lab7.networking.response.MealDetailResponse
import com.example.lab7.networking.response.MealsApi
import com.example.lab7.networking.response.MealsResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MealsWebService {
    private var api: MealsApi

    init{
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api = retrofit.create(MealsApi::class.java)
    }

    suspend fun getCategories(): CategoriesResponse {
        return api.getCategories()
    }

    suspend fun getMeals(): MealsResponse {
        return api.getMeals()
    }

    suspend fun getMealsDetails(): MealDetailResponse {
        return api.getMealDetail()
    }
}