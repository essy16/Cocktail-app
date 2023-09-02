package com.essycynthia.cocktailapp.data.remote.dto

import com.essycynthia.cocktailapp.domain.model.Drink
import com.essycynthia.cocktailapp.domain.model.DrinkDetail
import kotlinx.serialization.Serializable

@Serializable
data class DrinkDto(
    val idDrink: String,
    val strDrink: String,
    val strDrinkThumb: String
)
fun DrinkDto.toDrink() : Drink {
    return Drink(
        idDrink = idDrink,
        strDrink = strDrink,
        strDrinkThumb = strDrinkThumb
    )
}
