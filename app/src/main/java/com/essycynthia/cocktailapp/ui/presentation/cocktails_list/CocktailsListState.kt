package com.essycynthia.cocktailapp.ui.presentation.cocktails_list

import com.essycynthia.cocktailapp.domain.model.Drink

data class CocktailsListState(
    val isLoading: Boolean = false,
    val tequilaCocktails: List<Drink> = emptyList(),
    val whiskeyCocktails: List<Drink> = emptyList(),
    val brandyCocktails: List<Drink> = emptyList(),
    val alcoholicCocktails: List<Drink> = emptyList(),
    val nonAlcoholicCocktails: List<Drink> = emptyList(),
    val vodkaCocktails: List<Drink> = emptyList(),
    val ginCocktails: List<Drink> = emptyList(),
    val rumCocktails: List<Drink> = emptyList(),
    val error: String = ""
)