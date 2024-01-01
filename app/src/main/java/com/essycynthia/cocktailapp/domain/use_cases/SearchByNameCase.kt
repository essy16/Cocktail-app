package com.essycynthia.cocktailapp.domain.use_cases

import com.essycynthia.cocktailapp.data.remote.dto.toDrink
import com.essycynthia.cocktailapp.domain.model.Drink
import com.essycynthia.cocktailapp.domain.repository.CocktailRepository
import com.essycynthia.cocktailapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import retrofit2.HttpException
import java.io.IOException

class SearchByNameCase @Inject constructor(private val repository: CocktailRepository) {
    operator fun invoke(cocktailName:String): Flow<Resource<List<Drink>>> = flow {
        try {
            emit(Resource.Loading())
            val book=repository.searchCocktailByName(cocktailName).drinks.map { it.toDrink() }
            emit(Resource.Success(book))

        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage?: "An unexpected error occurred"))

        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server.Check your Internet Connection"))

        }
    }
}