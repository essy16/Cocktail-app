package com.essycynthia.cocktailapp.ui.presentation.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.essycynthia.cocktailapp.ui.presentation.Screen

@Composable
fun SearchScreen(
    viewModel: SearchViewModel = hiltViewModel(),
    navController: NavController
) {
    var searchText by remember { mutableStateOf("") }

    val state by viewModel.state.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        Row() {
            IconButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier
                    .size(50.dp)
            ) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
            }
        }
        SearchBar(
            hint = "Search for your desired cocktail...",
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)

        )
        {
            viewModel.search(it)

        }



        LazyColumn() {
            items(state.cocktail) {
                SearchItem(cocktail = it, onItemClick = {
                    navController.navigate(Screen.CocktailDetailScreen.route + "?id=${it.idDrink}")

                })

            }
        }
    }
}


@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    hint: String = "",
    onSearch: (String) -> Unit = {}
) {
    var text by remember { mutableStateOf("") }
    var isHintDisplayed by remember { mutableStateOf(hint != "") }

    Box(modifier = modifier) {
        BasicTextField(
            value = text,
            onValueChange = {
                text = it
                onSearch(it)
                // Update isHintDisplayed based on whether the text is empty or not
                isHintDisplayed = it.isEmpty()
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

