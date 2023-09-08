package com.essycynthia.cocktailapp.data.repository

import com.essycynthia.cocktailapp.data.remote.CocktailApi
import com.essycynthia.cocktailapp.data.remote.dto.DrinkDetailDto
import com.essycynthia.cocktailapp.data.remote.dto.DrinkDto
import com.essycynthia.cocktailapp.domain.repository.CocktailRepository
import javax.inject.Inject

class CocktailRepositoryImpl @Inject constructor(val api: CocktailApi) : CocktailRepository {
    override suspend fun getVodkaCocktails(): List<DrinkDto> {
        return api.getVodkaCocktails().drinks
    }

    override suspend fun getTequilaCocktails(): List<DrinkDto> {
        return api.getTequilaCocktails().drinks
    }

    override suspend fun getRumCocktails(): List<DrinkDto> {
        return api.getRumCocktails().drinks
    }

    override suspend fun getGinCocktails(): List<DrinkDto> {
        return api.getGinCocktails().drinks
    }

    override suspend fun getAlcoholicCocktails(): List<DrinkDto> {
        return api.getAlcoholicCocktails().drinks
    }

    override suspend fun getNonAlcoholicCocktails(): List<DrinkDto> {
        return api.getNonAlcoholicCocktails().drinks
    }

    override suspend fun getCocktailById(drinkId: String): DrinkDetailDto {
        /**
         * There is only one object in the list hence index 0
         */
        return api.getCocktailById(drinkId).drinks[0]
    }
}
