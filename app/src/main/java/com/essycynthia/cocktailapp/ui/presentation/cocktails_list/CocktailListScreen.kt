package com.essycynthia.cocktailapp.ui.presentation.cocktails_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.essycynthia.cocktailapp.ui.presentation.Screen
import com.essycynthia.cocktailapp.ui.presentation.cocktails_list.components.CocktailListItem

@Composable
fun CocktailListScreen(
    navController: NavController, viewModel: CocktailListViewModel = hiltViewModel()
) {
    val colorStops = arrayOf(
        0.0f to Color(0xFFcc3366),
        0.2f to Color(0xFFe4007c),
        0.4f to Color(0xFFfc0fc0),
        0.6f to Color(0xFFec3b83),
        0.8f to Color(0xFFcf3476),
        1.0f to Color(0xFFf49ac2)
    )
    val state = viewModel.state.value
    Column(
        Modifier
            .fillMaxSize()
            .background(Color(0xFFffe4e1))
        ) {
        Row(Modifier.fillMaxWidth()) {
            SearchBar(
                hint = "Search your desired cocktail...",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)

            ) {

            }

        }
//        LazyVerticalGrid(
//            GridCells.Fixed(2), modifier = Modifier.fillMaxSize()
//        ) {
//            items(state.cocktails) { cocktail ->
//                CocktailListItem(cocktail = cocktail, onItemClick = {
//                    navController.navigate(Screen.CocktailDetailScreen.route + "?id=${cocktail.idDrink}")
//                })
//
//
//            }
//        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth()

            )
        }
        if (state.isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
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