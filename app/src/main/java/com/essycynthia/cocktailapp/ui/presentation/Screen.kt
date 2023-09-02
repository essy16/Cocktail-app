package com.essycynthia.cocktailapp.ui.presentation

sealed class Screen(val route:String){
    object CocktailListScreen : Screen("cocktail_list")
    object CocktailDetailScreen : Screen("cocktail_details")
}
