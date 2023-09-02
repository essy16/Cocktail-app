package com.essycynthia.cocktailapp.tests.use_cases

import com.essycynthia.cocktailapp.data.remote.dto.DrinkDto
import com.essycynthia.cocktailapp.domain.model.Drink
import com.essycynthia.cocktailapp.domain.repository.CocktailRepository
import com.essycynthia.cocktailapp.domain.use_cases.GetTequilaCocktailUseCase
import com.essycynthia.cocktailapp.tests.repository.FakeCocktailRepository
import com.essycynthia.cocktailapp.util.Resource
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class GetTequilaCocktailUseCaseTest {
    private lateinit var getTequilaCocktailUseCase: GetTequilaCocktailUseCase
    private lateinit var fakeCocktailRepository: FakeCocktailRepository
    val tequilaOne = DrinkDto(
        idDrink = "15423",
        strDrink = "110 in the shade",
        strDrinkAlternate = null,
        strTags = null,
        strVideo = null,
        strCategory = "Beer",
        strIBA = null,
        strAlcoholic = "Alcoholic",
        strGlass = "Beer Glass",
        strInstructions = "Drop shooter in glass. Fill with beer",
        strInstructionsES = null,
        strInstructionsDE = "Shooter tröpfchenweise in ein Glas geben. Mit Bier füllen.",
        strInstructionsFR = null,
        strInstructionsIT = "Riempi un bicchierino di tequila. Riempi un boccale di birra con la birra chiara. Metti il bicchierino nella birra e bevi velocemente.",
        languageInZhHans = null,
        languageInZhHant = null,
        strDrinkThumb = "https://www.thecocktaildb.com/images/media/drink/xxyywq1454511117.jpg",
        strIngredient1 = "Lager",
        strIngredient2 = "Tequila",
        strIngredient3 = null,
        strIngredient4 = null,
        strIngredient5 = null,
        strIngredient6 = null,
        strIngredient7 = null,
        strIngredient8 = null,
        strIngredient9 = null,
        strIngredient10 = null,
        strIngredient11 = null,
        strIngredient12 = null,
        strIngredient13 = null,
        strIngredient14 = null,
        strIngredient15 = null,
        strMeasure1 = "16 oz ",
        strMeasure2 = "1.5 oz ",
        strMeasure3 = null,
        strMeasure4 = null,
        strMeasure5 = null,
        strMeasure6 = null,
        strMeasure7 = null,
        strMeasure8 = null,
        strMeasure9 = null,
        strMeasure10 = null,
        strMeasure11 = null,
        strMeasure12 = null,
        strMeasure13 = null,
        strMeasure14 = null,
        strMeasure15 = null,
        strImageSource = null,
        strImageAttribution = null,
        strCreativeCommonsConfirmed = "No",
        dateModified = "2016-02-03 14:51:57"
    )
    val tequilaTwo = DrinkDto(
        idDrink = "15300",
        strDrink = "3-Mile Long Island Iced Tea",
        strDrinkAlternate = null,
        strTags = null,
        strVideo = null,
        strCategory = "Beer",
        strIBA = null,
        strAlcoholic = "Alcoholic",
        strGlass = "Collins Glass",
        strInstructions = "Fill 14oz glass with ice and alcohol. Fill 2\\/3 glass with cola and remainder with sweet & sour. Top with dash of bitters and lemon wedge.",
        strInstructionsES = null,
        strInstructionsDE = "F\\u00fcllen Sie ein 12 cl. Glas mit Eis und Alkohol. F\\u00fcllen Sie 2\\/3 des Glases mit Cola und den Rest mit S\\u00fc\\u00df-Sauer. Mit einem Schuss Bitter und Zitronenkeil garnieren.",
        strInstructionsFR = null,
        strInstructionsIT = "Riempi un bicchiere da almeno 400ml con ghiaccio e alcol. Riempire i restanti 2\\/3 di bicchiere di cola e il resto di bevanda sweet & sour. Completare con un pizzico di bitter e uno spicchio di limone.",
        languageInZhHans = null,
        languageInZhHant = null,
        strDrinkThumb = "https://www.thecocktaildb.com/images/media/drink/xxyywq1454511117.jpg",
        strIngredient1 = "Gin",
        strIngredient2 = "Light rum",
        strIngredient3 = "Tequila",
        strIngredient4 = "Triple sec",
        strIngredient5 = "Vodka",
        strIngredient6 = "Coca-Cola",
        strIngredient7 = "Sweet and sour",
        strIngredient8 = "Bitters",
        strIngredient9 = "Lemon",
        strIngredient10 = null,
        strIngredient11 = null,
        strIngredient12 = null,
        strIngredient13 = null,
        strIngredient14 = null,
        strIngredient15 = null,
        strMeasure1 = "1\\/2 oz",
        strMeasure2 = "1\\/2 oz",
        strMeasure3 = "1\\/2 oz",
        strMeasure4 = "1\\/2 oz",
        strMeasure5 = "1\\/2 oz",
        strMeasure6 = "1\\/2 oz",
        strMeasure7 = "1-2 dash",
        strMeasure8 = "1 wedge ",
        strMeasure9 = "Garnish with",
        strMeasure10 = null,
        strMeasure11 = null,
        strMeasure12 = null,
        strMeasure13 = null,
        strMeasure14 = null,
        strMeasure15 = null,
        strImageSource = null,
        strImageAttribution = null,
        strCreativeCommonsConfirmed = "No",
        dateModified = "2016-08-31 19:42:52"
    )

    @Before
    fun setUp() {
        fakeCocktailRepository = FakeCocktailRepository()
        getTequilaCocktailUseCase = GetTequilaCocktailUseCase(fakeCocktailRepository)

    }
    @Test
    fun `test GetTequilaCocktailUseCase emits success result with data`() = runBlocking {

        // Act
        val result = getTequilaCocktailUseCase().toList()

        // Assert

        val successResult = result[1] as Resource.Success
        assertTrue(successResult.data?.get(0) is Drink) // Make sure the converted data is of the expected type
        assertEquals(tequilaOne.strDrink, successResult.data?.get(0)?.strDrink ?: "")
    }

}