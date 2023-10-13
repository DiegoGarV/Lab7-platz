package com.example.lab7.navigation

sealed class AppScreens(val route:String){
    object CategoriesScreen: AppScreens("categories")

    object MealDetailScreen: AppScreens("comida/{category}/{id}"){
        fun createRoute(category: String, id: String) = "comida/$category/$id"
    }

    object MealsScreen: AppScreens("filtro/{idFilter}/{mealName}"){
        fun createRoute(id: String,mealName: String) = "filtro/$id/$mealName"
    }
}
