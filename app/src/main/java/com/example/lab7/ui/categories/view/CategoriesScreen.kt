package com.example.lab7.ui.categories.view

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.lab7.navigation.AppScreens
import com.example.lab7.ui.categories.viewmodel.CategoriesVM

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
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 70.dp, bottom = 10.dp)
        ){
            items(categories){category ->
                val categoria: String = category.strCategory
                val id: String = category.idCategory
                val desc: String = category.strCategoryDescription
                val imagen: String = category.strCategoryThumb

                Card(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                        .clickable {
                            navController.navigate(
                                AppScreens.MealDetailScreen.createRoute(
                                    categoria,
                                    id
                                )
                            ) {
                                launchSingleTop = true
                            }
                        }
                ){
                    Row(verticalAlignment = Alignment.CenterVertically){
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(imagen)
                                .transformations()
                                .size(350,350)
                                .build(),
                            contentDescription = null)

                        Column(modifier = Modifier.padding(6.dp)) {

                            Text(
                                text = categoria,
                                fontSize = 20.sp,
                                fontStyle = FontStyle.Italic,
                                overflow = TextOverflow.Ellipsis
                            )

                            Spacer(modifier = Modifier.height(6.dp))

                            Text(
                                text = desc,
                                fontSize = 15.sp,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }
                }
            }
        }
    }
}