package com.essycynthia.cocktailapp.ui.presentation.cocktail_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.essycynthia.cocktailapp.domain.use_cases.GetCocktailDetailsUseCase
import com.essycynthia.cocktailapp.ui.presentation.cocktails_list.CocktailsListState
import com.essycynthia.cocktailapp.util.Constants
import com.essycynthia.cocktailapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CocktailDetailsViewModel @Inject constructor(
    private val getCocktailDetailsUseCase: GetCocktailDetailsUseCase,
    savedStateHandle: SavedStateHandle
) :
    ViewModel() {
    private val _state = mutableStateOf(CocktailDetailsState())
    val state: State<CocktailDetailsState> = _state


    init {
        savedStateHandle.get<String>("id")?.let { cocktailId ->
            getCocktailDetails(cocktailId)
        }
    }

    private fun getCocktailDetails(cocktailId: String) {
        getCocktailDetailsUseCase(cocktailId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CocktailDetailsState(cocktails = result.data)
                }

                is Resource.Error -> {
                    _state.value =
                        CocktailDetailsState(
                            error = result.message ?: "An unexpected error occurred"
                        )

                }

                is Resource.Loading -> {
                    _state.value = CocktailDetailsState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}