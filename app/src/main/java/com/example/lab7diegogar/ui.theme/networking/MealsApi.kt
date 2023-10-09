package com.example.lab7diegogar.ui.theme.networking

import com.example.lab7diegogar.ui.theme.networking.dtos.CategoriesDto
import com.example.lab7diegogar.ui.theme.networking.dtos.MealsDetailsDto
import com.example.lab7diegogar.ui.theme.networking.dtos.MealsDto
import retrofit2.http.GET

interface MealsApi {

    //Categorias
    @GET("categories.php")
    suspend fun getCategories(): CategoriesDto

    //Comidas filtradas
    @GET("filter.php?c=Seafood")
    suspend fun getMeals(): MealsDto


    //Receta de comida
    @GET("lookup.php?i=52944")
    suspend fun getMealDetail(): MealsDetailsDto
}