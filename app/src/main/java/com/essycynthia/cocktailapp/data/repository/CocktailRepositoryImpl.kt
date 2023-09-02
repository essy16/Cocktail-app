package com.essycynthia.cocktailapp.data.repository

import com.essycynthia.cocktailapp.data.remote.CocktailApi
import com.essycynthia.cocktailapp.data.remote.dto.DrinkDetailDto
import com.essycynthia.cocktailapp.data.remote.dto.DrinkDto
import com.essycynthia.cocktailapp.domain.repository.CocktailRepository
import javax.inject.Inject

class CocktailRepositoryImpl @Inject constructor(val api: CocktailApi) : CocktailRepository {
    override suspend fun getVodkaCocktails(): List<DrinkDto> {
        return api.getVodkaCocktails()
    }

    override suspend fun getTequilaCocktails(): List<DrinkDto> {
        return api.getTequilaCocktails()
    }

    override suspend fun getRumCocktails(): List<DrinkDto> {
        return api.getRumCocktails()
    }

    override suspend fun getGinCocktails(): List<DrinkDto> {
        return api.getGinCocktails()
    }

    override suspend fun getAlcoholicCocktails(): List<DrinkDto> {
        return api.getAlcoholicCocktails()
    }

    override suspend fun getNonAlcoholicCocktails(): List<DrinkDto> {
        return api.getNonAlcoholicCocktails()
    }

    override suspend fun getCocktailById(drinkId: String): DrinkDetailDto {
        return api.getCocktailById(drinkId)
    }

}