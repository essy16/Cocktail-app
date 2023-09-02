package com.essycynthia.cocktailapp.tests

import com.essycynthia.cocktailapp.data.remote.CocktailApi
import com.essycynthia.cocktailapp.data.remote.dto.DrinkDto
import com.essycynthia.cocktailapp.data.repository.CocktailRepositoryImpl
import com.essycynthia.cocktailapp.domain.repository.CocktailRepository
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class CocktailApiTesting {
    @Mock
    private lateinit var mockApi: CocktailApi
    private lateinit var repository: CocktailRepository

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        repository = CocktailRepositoryImpl(mockApi)
    }

    @Test
    fun `test getAlcoholicCocktails returns list of drinks`() = runBlocking {
        // Mocking the behavior of the api.getAlcoholicCocktails function
        val mockAlcoholicCocktails: List<DrinkDto>? = listOf(
            DrinkDto(
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
        )
        `when`(mockApi.getAlcoholicCocktails()).thenReturn(mockAlcoholicCocktails)

        val result = repository.getAlcoholicCocktails()

        // Verify that the result matches the mocked data
        assert(result == mockAlcoholicCocktails)

    }

}