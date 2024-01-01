package com.essycynthia.cocktailapp.ui.presentation

sealed class Screen(val route:String){
    object CocktailListScreen : Screen("cocktail_list")
    object HomeScreen : Screen("home")
    object FavoritesScreen : Screen("favorites")
    object SearchScreen : Screen("search")
    object CocktailDetailScreen : Screen("cocktail_details")
}
