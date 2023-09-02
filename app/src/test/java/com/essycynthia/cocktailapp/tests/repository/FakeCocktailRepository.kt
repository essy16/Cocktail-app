package com.essycynthia.cocktailapp.tests.repository

import com.essycynthia.cocktailapp.data.remote.dto.DrinkDetailDto
import com.essycynthia.cocktailapp.data.remote.dto.DrinkDto
import com.essycynthia.cocktailapp.domain.repository.CocktailRepository

class FakeCocktailRepository
    : CocktailRepository {
    val tequilaOne = DrinkDto(
        idDrink = "15423",
        strDrink = "110 in the shade",

        strDrinkThumb = "https://www.thecocktaildb.com/images/media/drink/xxyywq1454511117.jpg"

    )
    val tequilaTwo = DrinkDto(
        idDrink = "15300",
        strDrink = "3-Mile Long Island Iced Tea",

        strDrinkThumb = "https://www.thecocktaildb.com/images/media/drink/xxyywq1454511117.jpg",


        )
    private val tequilaCocktails = mutableListOf<DrinkDto>(tequilaOne, tequilaTwo)
    override suspend fun getVodkaCocktails(): List<DrinkDto> {
        return emptyList()
    }

    override suspend fun getTequilaCocktails(): List<DrinkDto> {
        return tequilaCocktails
    }

    override suspend fun getRumCocktails(): List<DrinkDto> {
        return emptyList()
    }

    override suspend fun getGinCocktails(): List<DrinkDto> {
        return emptyList()
    }

    override suspend fun getAlcoholicCocktails(): List<DrinkDto> {
        return emptyList()
    }

    override suspend fun getNonAlcoholicCocktails(): List<DrinkDto> {
        return emptyList()
    }

    override suspend fun getCocktailById(drinkId: String): DrinkDetailDto {
        return DrinkDetailDto(
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null
        )
    }

}