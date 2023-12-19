package com.essycynthia.cocktailapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.essycynthia.cocktailapp.ui.presentation.Screen
import com.essycynthia.cocktailapp.ui.presentation.Screen.CocktailListScreen.route
import com.essycynthia.cocktailapp.ui.presentation.cocktail_details.components.CocktailDetailsScreen
import com.essycynthia.cocktailapp.ui.presentation.cocktails_list.CocktailListScreen
import com.essycynthia.cocktailapp.ui.presentation.cocktails_list.components.HomeScreen
import com.essycynthia.cocktailapp.ui.theme.CocktailAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CocktailAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
//                    NavHost(navController = navController, startDestination = Screen.CocktailListScreen.route){
//                        composable(
//                            route = Screen.CocktailListScreen.route
//                        ){
//                            CocktailListScreen(navController = navController)
//                        }
//                        composable(
//                            route = Screen.CocktailDetailScreen.route + "?id={id}",
//                            arguments = listOf(
//                                navArgument("id"){
//                                    type = NavType.StringType
//                                }
//                            )
//                        ){
//                            CocktailDetailsScreen(navController = navController)
//                        }
//                    }
                    HomeScreen(navController = navController)
                }
            }
        }
    }
}

