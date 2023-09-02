package com.essycynthia.cocktailapp.ui.presentation.cocktail_details.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.essycynthia.cocktailapp.domain.model.DrinkDetail

@Composable
fun CocktailDetails(
    cocktailDetails:DrinkDetail
) {
    Column() {

            Text(
                text = "INGREDIENTS",
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        Row(horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()) {
            Text(text = cocktailDetails.strIngredient1.toString())
            Text(text = cocktailDetails.strIngredient2.toString())
            Text(text = cocktailDetails.strIngredient3.toString())
        }
        Row(horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()) {
            Text(text = cocktailDetails.strIngredient4.toString())
            Text(text = cocktailDetails.strIngredient5.toString())
            Text(text = cocktailDetails.strIngredient6.toString())
        }
        Row(horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()) {
            Text(text = cocktailDetails.strIngredient7.toString())
            Text(text = cocktailDetails.strIngredient8.toString())
            Text(text = cocktailDetails.strIngredient9.toString())
        }
        Row(horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()) {
            Text(text = cocktailDetails.strIngredient10.toString())
            Text(text = cocktailDetails.strIngredient11.toString())
            Text(text = cocktailDetails.strIngredient12.toString())
        }
        Row(horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()) {
            Text(text = cocktailDetails.strIngredient13.toString())
            Text(text = cocktailDetails.strIngredient14.toString())
            Text(text = cocktailDetails.strIngredient15.toString())
        }
        Text(
            text = "INSTRUCTIONS",
            color = Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Text(text = cocktailDetails.strInstructions.toString())

    }
}