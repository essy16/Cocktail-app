package com.essycynthia.cocktailapp.ui.presentation.cocktails_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.essycynthia.cocktailapp.R
import com.essycynthia.cocktailapp.ui.presentation.Screen
import com.essycynthia.cocktailapp.ui.presentation.cocktails_list.CocktailListViewModel
import com.essycynthia.cocktailapp.ui.presentation.cocktails_list.SearchBar

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: CocktailListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Column(modifier = Modifier.fillMaxSize()) {
        Row() {

        }
        Row(modifier = Modifier.width(150.dp)) {
            SearchBar() {

            }

        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
        ) {
            Row {
                Text(text = "Categories")
            }
            LazyRow() {
                item {
                    Column {
                        Image(
                            painter = painterResource(R.drawable.whiskey_cocktails),
                            contentDescription = "Whiskey cocktails",
                            modifier = Modifier
                                .width(150.dp)
                                .height(50.dp)
                        )
                        Text(text = "Whiskey")
                    }

                }
                item {
                    Column {
                        Image(
                            painter = painterResource(R.drawable.brandy_cocktails),
                            contentDescription = "Brandy cocktails",
                            modifier = Modifier
                                .width(150.dp)
                                .height(50.dp)
                        )
                        Text(text = "Brandy")
                    }

                }
                item {
                    Column {
                        Image(
                            painter = painterResource(R.drawable.rum_cocktails),
                            contentDescription = "Rum cocktails",
                            modifier = Modifier
                                .width(150.dp)
                                .height(50.dp)
                        )
                        Text(text = "Rum")
                    }

                }
                item {
                    Column {
                        Image(
                            painter = painterResource(R.drawable.vodka_cocktails),
                            contentDescription = "Vodka cocktails",
                            modifier = Modifier
                                .width(150.dp)
                                .height(50.dp)
                        )
                        Text(text = "Vodka")
                    }

                }
                item {
                    Column {
                        Image(
                            painter = painterResource(R.drawable.tequila_cocktails),
                            contentDescription = "Tequila cocktails",
                            modifier = Modifier
                                .width(150.dp)
                                .height(50.dp)
                        )
                        Text(text = "Tequila")
                    }

                }
            }

        }
        LazyColumn() {
            item {
                Text(text = "Whiskey")
                LazyRow {
                    items(state.cocktails) { cocktail ->
                        CocktailListItem(cocktail = cocktail, onItemClick = {
                            navController.navigate(Screen.CocktailDetailScreen.route + "?id=${cocktail.idDrink}")
                        })
                    }
                }
            }

        }
    }
}


@Composable
fun SearchBar(

    modifier: Modifier = Modifier, hint: String = "", onSearch: (String) -> Unit = {}
) {
    var text by remember {
        mutableStateOf("")
    }
    var isHintDisplayed by remember {
        mutableStateOf(hint != "")
    }

    Box(modifier = modifier) {
        BasicTextField(
            value = text,
            onValueChange = {
                text = it
                onSearch(it)
            },
            maxLines = 1,
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .shadow(5.dp, CircleShape)
                .background(Color.White, CircleShape)
                .padding(horizontal = 20.dp, vertical = 12.dp)

        )
        if (isHintDisplayed) {
            Text(
                text = hint,
                color = Color.LightGray,
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 12.dp)
            )
        }
    }
}
