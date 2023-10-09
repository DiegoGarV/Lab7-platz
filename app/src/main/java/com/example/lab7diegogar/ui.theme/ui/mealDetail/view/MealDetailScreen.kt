package com.example.lab7diegogar.ui.theme.ui.mealDetail.view

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.lab7diegogar.ui.theme.ui.mealDetail.viewmodel.MealDetailVM

@Composable
fun MealDetailScreen(
    navController: NavHostController,
    name: String?,
    id: String?
){
    val viewModel: MealDetailVM = viewModel()
    val filtro = viewModel.MealDetailState.value
}