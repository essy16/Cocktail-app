package com.essycynthia.cocktailapp.ui.presentation.search

import com.essycynthia.cocktailapp.domain.model.Drink

data class SearchState (
    val isLoading: Boolean = false,
    val cocktail: List<Drink> = emptyList(),
    val error: String = ""
)
