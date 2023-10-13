package com.example.lab7.ui.meals.view

import android.R
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.lab7.navigation.AppScreens
import com.example.lab7.ui.meals.viewmodel.MealsVM

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MealsScreen(
    navController: NavHostController,
    id:String?,
    name:String?
){
    val viewModel: MealsVM = viewModel()
    val meals = viewModel.MealsState.value

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
                    IconButton(onClick = { navController.navigate(AppScreens.MealDetailScreen.createRoute("Seafood", "8")) })
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
            id?.let{
                if(id=="52944"){
                    LazyColumn{
                        items(meals){meal->
                            val area: String = meal.strArea
                            val instrucciones: String = meal.strInstructions
                            val th: String = meal.strMealThumb
                            val video: String = meal.strYoutube

                            Column{
                                AsyncImage(
                                    model = ImageRequest.Builder(LocalContext.current)
                                        .data(th)
                                        .transformations()
                                        .size(500,500)
                                        .build(),
                                    modifier = Modifier.padding(start = 20.dp),
                                    contentDescription = null
                                )

                                Spacer(modifier = Modifier.height(6.dp))

                                addText("Area of Origin:",area)

                                Spacer(modifier = Modifier.height(6.dp))

                                Text(
                                    text = "Ingredients:",
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(10.dp),
                                    fontSize = 20.sp,
                                    textDecoration = TextDecoration.Underline,
                                    overflow = TextOverflow.Ellipsis
                                )

                                ingredientes(ingrediente = meal.strIngredient1, medida = meal.strMeasure1)
                                ingredientes(ingrediente = meal.strIngredient2, medida = meal.strMeasure2)
                                ingredientes(ingrediente = meal.strIngredient3, medida = meal.strMeasure3)
                                ingredientes(ingrediente = meal.strIngredient4, medida = meal.strMeasure4)
                                ingredientes(ingrediente = meal.strIngredient5, medida = meal.strMeasure5)
                                ingredientes(ingrediente = meal.strIngredient6, medida = meal.strMeasure6)
                                ingredientes(ingrediente = meal.strIngredient7, medida = meal.strMeasure7)
                                ingredientes(ingrediente = meal.strIngredient8, medida = meal.strMeasure8)
                                ingredientes(ingrediente = meal.strIngredient9, medida = meal.strMeasure9)
                                ingredientes(ingrediente = meal.strIngredient10, medida = meal.strMeasure10)
                                ingredientes(ingrediente = meal.strIngredient11, medida = meal.strMeasure11)
                                ingredientes(ingrediente = meal.strIngredient12, medida = meal.strMeasure12)
                                ingredientes(ingrediente = meal.strIngredient13, medida = meal.strMeasure13)
                                ingredientes(ingrediente = meal.strIngredient14, medida = meal.strMeasure14)
                                ingredientes(ingrediente = meal.strIngredient15, medida = meal.strMeasure15)
                                ingredientes(ingrediente = meal.strIngredient16, medida = meal.strMeasure16)
                                ingredientes(ingrediente = meal.strIngredient17, medida = meal.strMeasure17)

                                Spacer(modifier = Modifier.height(6.dp))

                                addText(title = "Tutorial", content = video)

                                Spacer(modifier = Modifier.height(6.dp))

                                addText(title = "Instructions:", content = instrucciones)
                            }
                        }
                    }
                }
                else{
                    Text(
                        text = "Lo sentimos, no tenemos información sobre la preparación de esta comida.",
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


@Composable
fun ingredientes(ingrediente: String, medida: String){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = ingrediente,
            modifier = Modifier
                .weight(1f)
                .wrapContentWidth(Alignment.Start),
            fontSize = 17.sp
        )

        Text(
            text = medida,
            modifier = Modifier
                .weight(1f)
                .wrapContentWidth(Alignment.End),
            fontSize = 17.sp
        )
    }
}

@Composable
fun addText(title:String, content:String){
    Text(
        text = title,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        fontSize = 20.sp,
        textDecoration = TextDecoration.Underline,
        overflow = TextOverflow.Ellipsis
    )
    Text(
        text = content,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        fontSize = 20.sp,
        overflow = TextOverflow.Ellipsis
    )
}