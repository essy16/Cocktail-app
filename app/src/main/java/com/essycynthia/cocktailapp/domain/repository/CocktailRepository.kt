package com.essycynthia.cocktailapp.domain.repository

import com.essycynthia.cocktailapp.data.remote.dto.DrinkDetailDto
import com.essycynthia.cocktailapp.data.remote.dto.DrinkDto

interface CocktailRepository {
    suspend fun getVodkaCocktails(): List<DrinkDto>

    suspend fun getTequilaCocktails(): List<DrinkDto>

    suspend fun getRumCocktails(): List<DrinkDto>

    suspend fun getGinCocktails(): List<DrinkDto>

    suspend fun getAlcoholicCocktails(): List<DrinkDto>

    suspend fun getNonAlcoholicCocktails(): List<DrinkDto>

    suspend fun getCocktailById(drinkId: String): DrinkDetailDto
}