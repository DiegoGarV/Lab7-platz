package com.example.lab7diegog.ui.theme.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.lab7diegogar.ui.theme.navigation.AppSreens
import com.example.lab7diegogar.ui.theme.ui.categories.view.CategoriesScreen
import com.example.lab7diegogar.ui.theme.ui.mealDetail.view.MealDetailScreen
import com.example.lab7diegogar.ui.theme.ui.meals.view.MealsScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppSreens.CategoriesScreen.route){
        composable(route = AppSreens.CategoriesScreen.route){
            CategoriesScreen(navController = navController)
        }
        composable(
            route = AppSreens.MealsScreen.route,
            arguments = listOf(navArgument(name="idFilter"){
                type = NavType.StringType
            }
            )
        ){backStackEntry->
            val arguments = requireNotNull(backStackEntry.arguments)
            val idFilter = arguments.getString("idFilter")?:""

            MealsScreen(navController,idFilter)
        }
        composable(
            route = AppSreens.MealDetailScreen.route,
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
    }
}
