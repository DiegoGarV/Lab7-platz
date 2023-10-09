package com.example.lab7diegogar.ui.theme.ui.categories.view

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.lab7diegogar.ui.theme.navigation.AppSreens
import com.example.lab7diegogar.ui.theme.ui.categories.viewmodel.CategoriesVM

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoriesScreen(navController: NavController){
    val viewModel: CategoriesVM = viewModel()
    val categories = viewModel.categoriesState.value

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
                title = { Text(text = "Categories") }
            )
        }
    ) { innerPading ->
        LazyColumn(modifier = Modifier.fillMaxSize()){
            categories?.let{
                items(categories){category ->
                    val str: String = category.strCat
                    val id: String = category.idCat
                    val desc: String = category.strCatDesc
                    val thumb: String = category.strCatThumb

                    Card(
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth()
                            .clickable {
                                navController.navigate(
                                    AppSreens.MealDetailScreen.createRoute(
                                        str,
                                        id
                                    )
                                ) {
                                    launchSingleTop = true
                                }
                            }
                    ){
                        Row{
                            AsyncImage(
                                model = ImageRequest.Builder(LocalContext.current)
                                    .data(thumb)
                                    .transformations()
                                    .size(350,350)
                                    .build(),
                                contentDescription = null)

                            Column(modifier = Modifier.padding(6.dp)) {

                                Text(
                                    text = str,
                                    fontSize = 10.sp,
                                    fontStyle = FontStyle.Italic,
                                    overflow = TextOverflow.Ellipsis
                                )

                                Spacer(modifier = Modifier.height(6.dp))

                                Text(
                                    text = desc,
                                    fontSize = 8.sp,
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