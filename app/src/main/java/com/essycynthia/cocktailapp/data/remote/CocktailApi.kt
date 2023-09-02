package com.essycynthia.cocktailapp.data.remote

import com.essycynthia.cocktailapp.data.remote.dto.CockTailResponseDto
import com.essycynthia.cocktailapp.data.remote.dto.DrinkDetailDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CocktailApi {
    @GET("api/json/v1/1/filter.php?i=Vodka")
    suspend fun getVodkaCocktails(): CockTailResponseDto

    @GET("api/json/v1/1/filter.php?i=Tequila")
    suspend fun getTequilaCocktails(): CockTailResponseDto

    @GET("api/json/v1/1/filter.php?i=Rum")
    suspend fun getRumCocktails(): CockTailResponseDto

    @GET("api/json/v1/1/filter.php?i=Gin")
    suspend fun getGinCocktails(): CockTailResponseDto

    @GET("api/json/v1/1/filter.php?a=Alcoholic")
    suspend fun getAlcoholicCocktails(): CockTailResponseDto

    @GET("api/json/v1/1/filter.php?a=Non_Alcoholic")
    suspend fun getNonAlcoholicCocktails(): CockTailResponseDto

    @GET("api/json/v1/1/lookup.php?i={drinkId}")
    suspend fun getCocktailById(@Path("drinkId") drinkId: String): DrinkDetailDto
}
