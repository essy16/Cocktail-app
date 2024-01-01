package com.essycynthia.cocktailapp.ui.presentation.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.essycynthia.cocktailapp.domain.repository.CocktailRepository
import com.essycynthia.cocktailapp.domain.use_cases.SearchByIngredientCase
import com.essycynthia.cocktailapp.domain.use_cases.SearchByNameCase
import com.essycynthia.cocktailapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: CocktailRepository,
    private val searchByIngredientCase: SearchByIngredientCase,
    private val searchByNameCase: SearchByNameCase
) : ViewModel() {
    private val _state = MutableStateFlow(SearchState())
    val state: StateFlow<SearchState>
        get() = _state

    fun searchByName(cocktailName: String) {
        searchByNameCase(cocktailName).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = _state.value.copy(
                        isLoading = false,
                        cocktail = result.data ?: emptyList(),
                        error = result.message ?: "Unexpected error occurred")
                }

                is Resource.Error -> {
                    _state.value = _state.value.copy(
                        isLoading = false,
                        error = result.message ?: "Unexpected error occurred"
                    )
                }


                is Resource.Loading -> {
                    _state.value = _state.value.copy(
                        isLoading = true
                    )
                }

            }
        }.launchIn(viewModelScope)


    }
    fun searchByIngredient(ingredient: String) {
        searchByIngredientCase(ingredient).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = _state.value.copy(
                        isLoading = false,
                        cocktail = result.data ?: emptyList(),
                        error = result.message ?: "Unexpected error occurred")
                }

                is Resource.Error -> {
                    _state.value = _state.value.copy(
                        isLoading = false,
                        error = result.message ?: "Unexpected error occurred"
                    )
                }


                is Resource.Loading -> {
                    _state.value = _state.value.copy(
                        isLoading = true
                    )
                }

            }
        }.launchIn(viewModelScope)


    }
    fun search(query: String) {
        // Determine whether to search by name or ingredient based on your logic
        if (query.length < 6) {
            searchByIngredient(query)
        } else {
            searchByName(query)

        }
    }

}
