package com.essycynthia.cocktailapp.ui.presentation.cocktails_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.essycynthia.cocktailapp.R
import com.essycynthia.cocktailapp.ui.presentation.Screen
import com.essycynthia.cocktailapp.ui.presentation.cocktails_list.CocktailListViewModel
import com.essycynthia.cocktailapp.ui.presentation.cocktails_list.SearchBar
import com.essycynthia.cocktailapp.ui.theme.categoriesText
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: CocktailListViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState().value
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }
    val items = remember {
        mutableStateListOf<NavigationItem>(
            NavigationItem(
                title = "Home",
                selectedIcon = Icons.Filled.Person,
                unselectedIcon = Icons.Outlined.Person
            ) {

            },

            NavigationItem(
                title = "Search",
                selectedIcon = Icons.Filled.Search,
                unselectedIcon = Icons.Outlined.Search

            ) {

            },

            NavigationItem(
                title = "Favorites",
                selectedIcon = Icons.Filled.Favorite,
                unselectedIcon = Icons.Filled.FavoriteBorder
            ) {


            },

            )
    }

    ModalNavigationDrawer(

        drawerContent = {

            ModalDrawerSheet {

                Spacer(modifier = Modifier.height(16.dp))

                items.forEachIndexed { index, item ->
                    NavigationDrawerItem(
                        label = {
                            Text(text = item.title)
                        },
                        selected = index == selectedItemIndex,
                        onClick = {
                            item.clickable
                            selectedItemIndex = index
                            scope.launch {
                                drawerState.close()
                            }
                        },
                        icon = {
                            Icon(
                                imageVector = if (index == selectedItemIndex) {
                                    item.selectedIcon
                                } else item.unselectedIcon,
                                contentDescription = item.title
                            )
                        },
                        modifier = Modifier
                            .padding(NavigationDrawerItemDefaults.ItemPadding)
                    )
                }
            }

        },
        drawerState = drawerState
    ){ Column(modifier = Modifier.fillMaxSize()) {
        Column(Modifier.fillMaxWidth()) {
            Text(
                text = "Please choose ", fontFamily = FontFamily(Font(R.font.carme)),
                color = categoriesText
            )
            Text(
                text = "Your cocktail", fontFamily = FontFamily(Font(R.font.lalezar)),
                color = categoriesText, fontWeight = FontWeight.ExtraBold
            )
        }


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
        ) {
            Row {
                Text(
                    text = "Categories",
                    fontFamily = FontFamily(Font(R.font.carme)),
                    color = categoriesText
                )
            }
            LazyRow() {
                item() {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        ElevatedCard(
                            elevation = CardDefaults.cardElevation(
                                defaultElevation = 6.dp
                            ),
                            modifier = Modifier
                                .width(150.dp)
                                .height(100.dp)
                        ) {
                            Image(
                                painter = painterResource(R.drawable.whiskey_cocktails),
                                contentDescription = "Whiskey cocktails",
                                contentScale = ContentScale.Crop,

                                )

                        }

                        ElevatedCard(
                            elevation = CardDefaults.cardElevation(
                                defaultElevation = 6.dp
                            ),
                            modifier = Modifier
                                .width(140.dp)
                                .height(20.dp)


                        ) {
                            Text(
                                text = "Whiskey Cocktails",
                                fontFamily = FontFamily(Font(R.font.carme)),
                                modifier = Modifier.fillMaxWidth(),
                                color = categoriesText
                            )
                        }
                    }


                    Spacer(modifier = Modifier.width(10.dp))
                }

                item {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        ElevatedCard(
                            elevation = CardDefaults.cardElevation(
                                defaultElevation = 6.dp
                            ),
                            modifier = Modifier
                                .width(150.dp)
                                .height(100.dp)
                        ) {
                            Image(
                                painter = painterResource(R.drawable.rum_cocktails),
                                contentDescription = "Rum cocktails",
                                contentScale = ContentScale.Crop,

                                )
                        }
                        ElevatedCard(
                            elevation = CardDefaults.cardElevation(
                                defaultElevation = 6.dp
                            ),
                            modifier = Modifier
                                .width(120.dp)
                                .height(20.dp)
                        ) {
                            Text(
                                text = "Rum cocktails",
                                fontFamily = FontFamily(Font(R.font.carme)),
                                color = categoriesText
                            )
                        }
                    }

                    Spacer(modifier = Modifier.width(10.dp))
                }
                item {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        ElevatedCard(
                            elevation = CardDefaults.cardElevation(
                                defaultElevation = 6.dp
                            ),
                            modifier = Modifier
                                .width(150.dp)
                                .height(100.dp)
                        ) {
                            Image(
                                painter = painterResource(R.drawable.vodka_cocktails),
                                contentDescription = "Vodka cocktails",
                                contentScale = ContentScale.Crop,

                                )
                        }
                        ElevatedCard(
                            elevation = CardDefaults.cardElevation(
                                defaultElevation = 6.dp
                            ),
                            modifier = Modifier
                                .width(150.dp)
                                .height(20.dp)
                        ) {
                            Text(
                                text = "Vodka cocktails",
                                fontFamily = FontFamily(Font(R.font.carme)),
                                color = categoriesText
                            )
                        }
                    }

                    Spacer(modifier = Modifier.width(10.dp))
                }
                item {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        ElevatedCard(
                            elevation = CardDefaults.cardElevation(
                                defaultElevation = 6.dp
                            ),
                            modifier = Modifier
                                .width(150.dp)
                                .height(100.dp)
                        ) {
                            Image(
                                painter = painterResource(R.drawable.tequila_cocktails),
                                contentDescription = "Tequila cocktails",
                                contentScale = ContentScale.Crop,

                                )
                        }
                        ElevatedCard(
                            elevation = CardDefaults.cardElevation(
                                defaultElevation = 6.dp
                            ),
                            modifier = Modifier
                                .width(140.dp)
                                .height(20.dp)
                        ) {
                            Text(
                                text = "Tequila cocktails",
                                fontFamily = FontFamily(Font(R.font.carme)),
                                color = categoriesText
                            )
                        }
                    }

                }
            }

        }
        Spacer(modifier = Modifier.height(10.dp))
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            item {
                Text(
                    text = "Whiskey cocktails", color = categoriesText,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp, modifier = Modifier.padding(horizontal = 20.dp)
                )
                LazyRow {
                    items(state.whiskeyCocktails) { cocktail ->
                        CocktailListItem(cocktail = cocktail, onItemClick = {
                            navController.navigate(Screen.CocktailDetailScreen.route + "?id=${cocktail.idDrink}")
                        })
                    }
                }
            }
            item {
                Text(
                    text = "Tequila cocktails", color = categoriesText,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp, modifier = Modifier.padding(horizontal = 20.dp)
                )
                LazyRow {
                    items(state.tequilaCocktails) { cocktail ->
                        CocktailListItem(cocktail = cocktail, onItemClick = {
                            navController.navigate(Screen.CocktailDetailScreen.route + "?id=${cocktail.idDrink}")
                        })
                    }
                }
            }
            item {
                Text(
                    text = "Vodka cocktails", color = categoriesText,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp, modifier = Modifier.padding(horizontal = 20.dp)
                )
                LazyRow {
                    items(state.vodkaCocktails) { cocktail ->
                        CocktailListItem(cocktail = cocktail, onItemClick = {
                            navController.navigate(Screen.CocktailDetailScreen.route + "?id=${cocktail.idDrink}")
                        })
                    }
                }
            }
            item {
                Text(
                    text = "Gin cocktails", color = categoriesText,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp, modifier = Modifier.padding(horizontal = 20.dp)
                )
                LazyRow {
                    items(state.ginCocktails) { cocktail ->
                        CocktailListItem(cocktail = cocktail, onItemClick = {
                            navController.navigate(Screen.CocktailDetailScreen.route + "?id=${cocktail.idDrink}")
                        })
                    }
                }
            }
            item {
                Text(
                    text = "Rum cocktails", color = categoriesText,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp, modifier = Modifier.padding(horizontal = 20.dp)
                )
                LazyRow {
                    items(state.rumCocktails) { cocktail ->
                        CocktailListItem(cocktail = cocktail, onItemClick = {
                            navController.navigate(Screen.CocktailDetailScreen.route + "?id=${cocktail.idDrink}")
                        })
                    }
                }
            }
            item {
                Text(
                    text = "Brandy cocktails", color = categoriesText,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp, modifier = Modifier.padding(horizontal = 20.dp)
                )
                LazyRow {
                    items(state.brandyCocktails) { cocktail ->
                        CocktailListItem(cocktail = cocktail, onItemClick = {
                            navController.navigate(Screen.CocktailDetailScreen.route + "?id=${cocktail.idDrink}")
                        })
                    }
                }
            }

        }
    }}


}

data class NavigationItem(
    var title: String,
    var selectedIcon: ImageVector,
    var unselectedIcon: ImageVector,
    val clickable: () -> Unit

)

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
