package com.essycynthia.cocktailapp.domain.repository

import com.essycynthia.cocktailapp.data.remote.dto.CockTailResponseDto
import com.essycynthia.cocktailapp.data.remote.dto.DrinkDetailDto
import com.essycynthia.cocktailapp.data.remote.dto.DrinkDto
import retrofit2.http.GET
import retrofit2.http.Query

interface CocktailRepository {
    suspend fun getVodkaCocktails(): List<DrinkDto>

    suspend fun getTequilaCocktails(): List<DrinkDto>
    suspend fun getWhiskeyCocktails(): List<DrinkDto>
    suspend fun getBrandyCocktails(): List<DrinkDto>

    suspend fun getRumCocktails(): List<DrinkDto>

    suspend fun getGinCocktails(): List<DrinkDto>

    suspend fun getAlcoholicCocktails(): List<DrinkDto>

    suspend fun getNonAlcoholicCocktails(): List<DrinkDto>

    suspend fun getCocktailById(drinkId: String): DrinkDetailDto

    suspend fun searchCocktailByIngredient(@Query("i") ingredient: String): CockTailResponseDto

    suspend fun searchCocktailByName(@Query("s") cocktailName: String): CockTailResponseDto
}