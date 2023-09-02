package com.essycynthia.cocktailapp.ui.presentation.cocktails_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.essycynthia.cocktailapp.domain.model.Drink

@Composable
fun CocktailListItem(
    cocktail: Drink,
    onItemClick: (Drink) -> Unit
) {
    Box(Modifier
        .wrapContentSize()
        .clickable {
            onItemClick(cocktail)
        }
        .padding(20.dp))
    {
        Text(
            text = cocktail.strDrink,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.align(Center)

        )
        AsyncImage(
            model = cocktail.strDrinkThumb,
            contentDescription = cocktail.strDrink,
        )

        Icon(
            Icons.Outlined.Favorite, contentDescription = "liked", modifier = Modifier.align(
                Alignment.TopEnd
            )
        )

    }

}



