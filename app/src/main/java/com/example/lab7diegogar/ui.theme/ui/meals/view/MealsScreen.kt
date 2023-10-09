package com.example.lab7diegogar.ui.theme.ui.meals.view

import android.R
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.lab7diegogar.ui.theme.navigation.AppSreens
import com.example.lab7diegogar.ui.theme.ui.meals.viewmodel.MealsVM

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MealsScreen(
    navController: NavHostController,
    id:String?
){
    val viewModel: MealsVM = viewModel()
    val search = viewModel.MealsState.value

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
                    IconButton(onClick = { navController.navigate(route = AppSreens.MealDetailScreen.route) })
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
        Column() {
            id?.let{
                if(id=="52944"){
                    LazyColumn(){
                        search?.let{
                            items(search){meal->
                                val nombre: String = meal.strMeal
                                val area: String = meal.strArea
                                val instrucciones: String = meal.strInstr


                                Column{
                                    Text(
                                        text = nombre,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(10.dp),
                                        fontSize = 30.sp,
                                        fontWeight = FontWeight.Bold,
                                        overflow = TextOverflow.Ellipsis
                                    )

                                    Spacer(modifier = Modifier.height(6.dp))

                                    Text(
                                        text = "Área: "+area,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(10.dp),
                                        fontSize = 20.sp,
                                        overflow = TextOverflow.Ellipsis
                                    )

                                    Spacer(modifier = Modifier.height(6.dp))

                                    Text(
                                        text = "Ingredientes: "+meal.strIngr1,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(10.dp),
                                        fontSize = 20.sp,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                    Text(
                                        text = meal.strIngr2,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(10.dp),
                                        fontSize = 20.sp,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                    Text(
                                        text = meal.strIngr3,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(10.dp),
                                        fontSize = 20.sp,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                    Text(
                                        text = meal.strIngr4,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(10.dp),
                                        fontSize = 20.sp,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                    Text(
                                        text = meal.strIngr5,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(10.dp),
                                        fontSize = 20.sp,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                    Text(
                                        text = meal.strIngr6,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(10.dp),
                                        fontSize = 20.sp,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                    Text(
                                        text = meal.strIngr7,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(10.dp),
                                        fontSize = 20.sp,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                    Text(
                                        text = meal.strIngr8,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(10.dp),
                                        fontSize = 20.sp,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                    Text(
                                        text = meal.strIngr9,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(10.dp),
                                        fontSize = 20.sp,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                    Text(
                                        text = meal.strIngr10,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(10.dp),
                                        fontSize = 20.sp,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                    Text(
                                        text = meal.strIngr11,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(10.dp),
                                        fontSize = 20.sp,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                    Text(
                                        text = meal.strIngr12,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(10.dp),
                                        fontSize = 20.sp,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                    Text(
                                        text = meal.strIngr13,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(10.dp),
                                        fontSize = 20.sp,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                    Text(
                                        text = meal.strIngr14,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(10.dp),
                                        fontSize = 20.sp,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                    Text(
                                        text = meal.strIngr15,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(10.dp),
                                        fontSize = 20.sp,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                    Text(
                                        text = meal.strIngr16,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(10.dp),
                                        fontSize = 20.sp,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                    Text(
                                        text = meal.strIngr17,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(10.dp),
                                        fontSize = 20.sp,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                    Text(
                                        text = meal.strIngr18,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(10.dp),
                                        fontSize = 20.sp,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                    Text(
                                        text = meal.strIngr19,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(10.dp),
                                        fontSize = 20.sp,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                    Text(
                                        text = meal.strIngr20,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(10.dp),
                                        fontSize = 20.sp,
                                        overflow = TextOverflow.Ellipsis
                                    )

                                    Spacer(modifier = Modifier.height(6.dp))

                                    Text(
                                        text = "Instrucciones: "+meal.strInstr,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(10.dp),
                                        fontSize = 20.sp,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}