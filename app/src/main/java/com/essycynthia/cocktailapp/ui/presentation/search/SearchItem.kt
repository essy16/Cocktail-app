package com.essycynthia.cocktailapp.ui.presentation.search

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.essycynthia.cocktailapp.domain.model.Drink

@Composable
fun SearchItem(
    cocktail: Drink,
    onItemClick: (Drink) -> Unit
) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .height(60.dp)
            .background(MaterialTheme.colorScheme.surface)
            .clickable { onItemClick(cocktail) }


    ) {
        Row {
            AsyncImage(
                model = cocktail.strDrinkThumb,
                contentDescription = cocktail.strDrink,
                modifier = Modifier.size(50.dp)
            )
            Spacer(Modifier.width(8.dp))
            Text(
                text = cocktail.strDrink,
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0xFF800080),
                textAlign = TextAlign.Center,
                fontSize = 20.sp

            )
        }

    }
}



