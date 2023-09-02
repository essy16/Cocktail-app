package com.essycynthia.cocktailapp.ui.presentation.cocktail_details

import com.essycynthia.cocktailapp.domain.model.Drink
import com.essycynthia.cocktailapp.domain.model.DrinkDetail

data class CocktailDetailsState (
    val isLoading:Boolean = false,
    val cocktails:DrinkDetail? = null,
    val  error:String = ""
)