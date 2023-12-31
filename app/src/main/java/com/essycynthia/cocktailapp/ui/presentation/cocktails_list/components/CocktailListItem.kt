package com.essycynthia.cocktailapp.ui.presentation.cocktails_list.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.essycynthia.cocktailapp.R
import com.essycynthia.cocktailapp.domain.model.Drink
import com.essycynthia.cocktailapp.ui.theme.PurpleWhite
import com.essycynthia.cocktailapp.ui.theme.appPurple
import com.essycynthia.cocktailapp.ui.theme.categoriesText
import com.essycynthia.cocktailapp.ui.theme.tertiaryPurple

@Composable
fun CocktailListItem(
    cocktail: Drink,
    onItemClick: (Drink) -> Unit
) {
    val brush = Brush.horizontalGradient(listOf(tertiaryPurple,PurpleWhite))
    Box(Modifier
        .background(Color.Transparent)
        .border(BorderStroke(1.dp, Color.Transparent))
        .clickable {
            onItemClick(cocktail)
        }
        .padding(20.dp)){
        Column (horizontalAlignment = Alignment.CenterHorizontally){
            Card(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                ),
                modifier = Modifier.size(width= 160.dp,height = 200.dp)
            ) {

                Box()

                {

                    AsyncImage(
                        model = cocktail.strDrinkThumb,
                        contentDescription = cocktail.strDrink,
                        contentScale = ContentScale.Crop
                    )

                    Icon(
                        Icons.Outlined.Favorite,
                        contentDescription = "liked",
                        modifier = Modifier.align(
                            Alignment.TopEnd
                        )
                    )

                }

            }
            Spacer(modifier = Modifier.height(8.dp))
            ElevatedCard(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                ),
                modifier = Modifier
                    .width(150.dp)
                    .height(20.dp),
            ) {
                Box (Modifier.background(brush)
                    .fillMaxSize()){
                    Text(
                        text = cocktail.strDrink,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color(0xFF800080),
                        textAlign = TextAlign.Center

                    )
                }
            }
        }
    }

}



