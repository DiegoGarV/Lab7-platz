package com.example.lab7.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.lab7.ui.categories.view.CategoriesScreen
import com.example.lab7.ui.mealDetails.view.MealDetailScreen
import com.example.lab7.ui.meals.view.MealsScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.CategoriesScreen.route){
        composable(route = AppScreens.CategoriesScreen.route){
            CategoriesScreen(navController = navController)
        }
        composable(
            route = AppScreens.MealDetailScreen.route,
            arguments = listOf(navArgument(name="category"){
                type = NavType.StringType
            }
            )
        ){backStackEntry->
            val arguments = requireNotNull(backStackEntry.arguments)
            val categoryName = arguments.getString("category")?:""
            val idCategory = arguments.getString("id")?:""

            MealDetailScreen(navController,categoryName,idCategory)
        }
        composable(
            route = AppScreens.MealsScreen.route,
            arguments = listOf(navArgument(name="idFilter"){
                type = NavType.StringType
            }
            )
        ){backStackEntry->
            val arguments = requireNotNull(backStackEntry.arguments)
            val idFilter = arguments.getString("idFilter")?:""
            val mealName = arguments.getString("mealName")?:""

            MealsScreen(navController,idFilter,mealName)
        }
    }
}
