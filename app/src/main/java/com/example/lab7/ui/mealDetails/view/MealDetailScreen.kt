package com.example.lab7.ui.mealDetails.view

import android.R
import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.lab7.navigation.AppScreens
import com.example.lab7.ui.mealDetails.viewmodel.MealDetailVM

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MealDetailScreen(
    navController: NavHostController,
    name: String?,
    id: String?
){
    val viewModel: MealDetailVM = viewModel()
    val filtro = viewModel.MealDetailState.value

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .statusBarsPadding(),
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
                ),
                navigationIcon = {
                    IconButton(onClick = { navController.navigate(route = AppScreens.CategoriesScreen.route) })
                    {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_menu_revert),
                            modifier = Modifier
                                .size(30.dp),
                            contentDescription = null
                        )
                    }
                },
                title = { Text(text = name.toString()) }
            )
        }
    ) {

        Column(modifier = Modifier.padding(top = 70.dp)) {
            id?.let {
                if(id=="8"){
                    LazyColumn{
                        items(filtro){filter->
                            val filtroId: String =  filter.idMeal
                            val imagen: String = filter.strMealThumb
                            val mealName: String = filter.strMeal

                            Card(
                                modifier = Modifier
                                    .padding(10.dp)
                                    .fillMaxWidth()
                                    .clickable {
                                        navController.navigate(
                                            AppScreens.MealsScreen.createRoute(
                                                filtroId,
                                                mealName
                                            )
                                        ) {
                                            launchSingleTop = true
                                        }
                                    }
                            ){
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ){
                                    AsyncImage(
                                        model = ImageRequest.Builder(LocalContext.current)
                                            .data(imagen)
                                            .transformations()
                                            .size(250,250)
                                            .build(),
                                        contentDescription = null)

                                    Text(
                                        text = mealName,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(10.dp),
                                        fontSize = 20.sp,
                                        fontStyle = FontStyle.Italic,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                }
                            }
                        }
                    }
                }
                else{
                    Text(
                        text = "Lo sentimos, no tenemos información sobre la comida en esta categoría.",
                        fontStyle = FontStyle.Italic,
                        fontSize = 30.sp,
                        modifier = Modifier.padding(10.dp),
                        lineHeight = (30.sp),
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}