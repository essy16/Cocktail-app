package com.essycynthia.cocktailapp.domain.use_cases

import com.essycynthia.cocktailapp.data.remote.dto.toDrink
import com.essycynthia.cocktailapp.domain.model.Drink
import com.essycynthia.cocktailapp.domain.repository.CocktailRepository
import com.essycynthia.cocktailapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetGinCocktailUseCase @Inject constructor(val repository: CocktailRepository) {
    operator fun invoke(): Flow<Resource<List<Drink>>> = flow {
        try {
            emit(Resource.Loading(null))
            val ginCocktails = repository.getGinCocktails().map { it.toDrink() }
            emit(Resource.Success(ginCocktails))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))

        }
    }
}