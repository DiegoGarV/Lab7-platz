package com.example.lab7diegogar.ui.theme.ui.meals.view

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.lab7diegogar.ui.theme.ui.meals.viewmodel.MealsVM

@Composable
fun MealsScreen(
    navController: NavHostController,
    id:String?
){
    val viewModel: MealsVM = viewModel()
    val search = viewModel.MealsState.value
}