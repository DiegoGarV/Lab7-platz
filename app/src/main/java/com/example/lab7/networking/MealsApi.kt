package com.example.lab7.networking.response

import retrofit2.http.GET

interface MealsApi {

    //Categorias
    @GET("categories.php")
    suspend fun getCategories(): CategoriesResponse

    //Comidas filtradas
    @GET("filter.php?c=Seafood")
    suspend fun getMealDetail(): MealDetailResponse

    //Receta de comida
    @GET("lookup.php?i=52944")
    suspend fun getMeals(): MealsResponse
}