package com.example.lab7diegogar.ui.theme.networking

import com.example.lab7diegogar.ui.theme.networking.response.CategoriesDC
import com.example.lab7diegogar.ui.theme.networking.response.MealsDC
import com.example.lab7diegogar.ui.theme.networking.response.MealsDetailDC
import retrofit2.http.GET

interface MealsApi {

    //Categorias
    @GET("categories.php")
    suspend fun getCategories(): CategoriesDC

    //Comidas filtradas
    @GET("filter.php?c=Seafood")
    suspend fun getMeals(): MealsDC


    //Receta de comida
    @GET("lookup.php?i=52944")
    suspend fun getMealDetail(): MealsDetailDC
}