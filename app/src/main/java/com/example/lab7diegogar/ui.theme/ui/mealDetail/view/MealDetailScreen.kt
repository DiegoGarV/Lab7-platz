package com.example.lab7diegogar.ui.theme.ui.mealDetail.view

import android.R
import android.annotation.SuppressLint
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.lab7diegogar.ui.theme.navigation.AppSreens
import com.example.lab7diegogar.ui.theme.ui.mealDetail.viewmodel.MealDetailVM

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
                    IconButton(onClick = { navController.navigate(route = AppSreens.CategoriesScreen.route) })
                    {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_menu_revert),
                            modifier = Modifier
                                .size(30.dp),
                            contentDescription = null
                        )
                    }
                },
                title = { Text(text = "Meals") }
            )
        }
    ) { innerPading -> 
        
        Column {
            id?.let {
                Text(
                    text = name.toString(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis
                )
                
                if(name=="Seafood"){
                    LazyColumn{
                        filtro?.let{
                            items(filtro){filter->
                                val filtroId: String =  filter.idMeal
                                val th: String = filter.strMealThumb

                                Card(
                                    modifier = Modifier
                                        .padding(10.dp)
                                        .fillMaxWidth()
                                        .clickable {
                                            navController.navigate(
                                                AppSreens.MealsScreen.createRoute(
                                                    filtroId
                                                )
                                            ) {
                                                launchSingleTop = true
                                            }
                                        }
                                ){
                                    Row(){
                                        AsyncImage(
                                            model = ImageRequest.Builder(LocalContext.current)
                                                .data(th)
                                                .transformations()
                                                .size(250,250)
                                                .build(),
                                            contentDescription = null)

                                        Column() {
                                            Text(
                                                text = name.toString(),
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
                    }
                }
                else{
                    Text(
                        text = "Lo sentimos, no tenemos información sobre la comida en esta categoría",
                        fontWeight = FontWeight.Bold,
                        fontSize = 50.sp,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}