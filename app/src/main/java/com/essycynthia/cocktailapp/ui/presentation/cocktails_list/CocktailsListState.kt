package com.essycynthia.cocktailapp.ui.presentation.cocktails_list

import com.essycynthia.cocktailapp.domain.model.Drink

data class CocktailsListState(
    val isLoading: Boolean = false,
    val cocktails: List<Drink> = emptyList(),
    val error: String = ""
)