package com.example.lab7diegogar.ui.theme.navigation

sealed class AppSreens(val route: String){
    object CategoriesScreen: AppSreens("categories")
    object MealsScreen: AppSreens("filtro/{idFilter}"){
        fun createRoute(id: String) = "filtro/$id"
    }
    object MealDetailScreen: AppSreens("comida/{category}/{id}"){
        fun createRoute(category: String, id: String) = "comida/$category/$id"
    }
}
