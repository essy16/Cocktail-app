package com.essycynthia.cocktailapp.ui.presentation.cocktails_list.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.essycynthia.cocktailapp.domain.model.Drink

@Composable
fun CocktailListItem(
    cocktail: Drink,
    onItemClick: (Drink) -> Unit
) {

    Box(Modifier
        .background(Color.Transparent)
        .border (BorderStroke(1.dp, Color.Transparent))
        .wrapContentSize()
        .clickable {
            onItemClick(cocktail)
        }
        .padding(20.dp)){
        Column {
            Box()

            {

                AsyncImage(
                    model = cocktail.strDrinkThumb,
                    contentDescription = cocktail.strDrink,
                )

                Icon(
                    Icons.Outlined.Favorite,
                    contentDescription = "liked",
                    modifier = Modifier.align(
                        Alignment.TopEnd
                    )
                )

            }
            Text(
                text = cocktail.strDrink,
                style = MaterialTheme.typography.bodyMedium,


                )
        }
    }

}



