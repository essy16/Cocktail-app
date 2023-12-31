package com.essycynthia.cocktailapp.ui.presentation.cocktails_list

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.essycynthia.cocktailapp.domain.use_cases.GetAlcoholicCocktailUseCase
import com.essycynthia.cocktailapp.domain.use_cases.GetBrandyCocktailUseCase
import com.essycynthia.cocktailapp.domain.use_cases.GetGinCocktailUseCase
import com.essycynthia.cocktailapp.domain.use_cases.GetNonAlcoholicCocktailUseCase
import com.essycynthia.cocktailapp.domain.use_cases.GetRumCocktailUseCase
import com.essycynthia.cocktailapp.domain.use_cases.GetTequilaCocktailUseCase
import com.essycynthia.cocktailapp.domain.use_cases.GetVodkaCocktailUseCase
import com.essycynthia.cocktailapp.domain.use_cases.GetWhiskeyCocktailUseCase
import com.essycynthia.cocktailapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class CocktailListViewModel @Inject constructor(
    private val getAlcoholicCocktailUseCase: GetAlcoholicCocktailUseCase,
    private val getNonAlcoholicCocktailUseCase: GetNonAlcoholicCocktailUseCase,
    private val getVodkaCocktailUseCase: GetVodkaCocktailUseCase,
    private val getRumCocktailUseCase: GetRumCocktailUseCase,
    private val getWhiskeyCocktailUseCase: GetWhiskeyCocktailUseCase,
    private val getBrandyCocktailUseCase: GetBrandyCocktailUseCase,
    private val getTequilaCocktailUseCase: GetTequilaCocktailUseCase,
    private val getGinCocktailUseCase: GetGinCocktailUseCase,
) : ViewModel() {
    private val _state = MutableStateFlow(CocktailsListState())
    val state: StateFlow<CocktailsListState>
        get() = _state

    init {
        getTequilaCocktails()
        getAlcoholicCocktails()
        getNonAlcoholicCocktails()
        getRumCocktails()
        getGinCocktails()
        getVodkaCocktails()
        getWhiskeyCocktails()
        getBrandyCocktails()
    }

    private fun getTequilaCocktails() {
        _state.value = CocktailsListState(isLoading = true)
        getTequilaCocktailUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.update { currentState ->
                        currentState.copy(
                            isLoading = false,
                            tequilaCocktails = result.data ?: emptyList()
                        )
                    }
                }
                is Resource.Error -> {
                    delay(20000)
                    _state.update {
                        it.copy(
                            isLoading = false,
                            error = result.message ?: "Unexpected error occurred"
                        )
                    }

                }

                is Resource.Loading -> {
                    _state.update {
                        it.copy(
                            isLoading = true
                        )
                    }
                }

                else -> {}
            }
        }.launchIn(viewModelScope)
    }

    private fun getWhiskeyCocktails() {
//        _state.value = CocktailsListState(isLoading = true)
        getWhiskeyCocktailUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.update { currentState ->
                        currentState.copy(
                            isLoading = false,
                            whiskeyCocktails = result.data ?: emptyList()
                        )
                    }
                }

                is Resource.Error -> {
                    delay(20000)
                    _state.update {
                        it.copy(
                            isLoading = false,
                            error = result.message ?: "Unexpected error occurred"
                        )
                    }

                }

                is Resource.Loading -> {
                    _state.update {
                        it.copy(
                            isLoading = true
                        )
                    }
                }

                else -> {}
            }
        }.launchIn(viewModelScope)
    }

    private fun getBrandyCocktails() {
        _state.value = CocktailsListState(isLoading = true)
        getBrandyCocktailUseCase().onEach { result ->
            when (result) {
                    is Resource.Success -> {
                        _state.update { currentState ->
                            currentState.copy(
                                isLoading = false,
                                brandyCocktails = result.data ?: emptyList()
                            )
                        }
                    }

                is Resource.Error -> {
                    delay(20000)
                    _state.update {
                        it.copy(
                            isLoading = false,
                            error = result.message ?: "Unexpected error occurred"
                        )
                    }

                }

                is Resource.Loading -> {
                    _state.update {
                        it.copy(
                            isLoading = true
                        )
                    }
                }

                else -> {}
            }
        }.launchIn(viewModelScope)
    }


    private fun getAlcoholicCocktails() {
        getAlcoholicCocktailUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.update { currentState ->
                        currentState.copy(
                            isLoading = false,
                            alcoholicCocktails = result.data ?: emptyList()
                        )
                    }
                }

                is Resource.Error -> {
                    delay(20000)
                    _state.update {
                        it.copy(
                            isLoading = false,
                            error = result.message ?: "Unexpected error occurred"
                        )
                    }

                }

                is Resource.Loading -> {
                    _state.update {
                        it.copy(
                            isLoading = true
                        )
                    }
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getNonAlcoholicCocktails() {
        getNonAlcoholicCocktailUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.update { currentState ->
                        currentState.copy(
                            isLoading = false,
                            nonAlcoholicCocktails = result.data ?: emptyList()
                        )
                    }
                }

                is Resource.Error -> {
                    delay(20000)
                    _state.update {
                        it.copy(
                            isLoading = false,
                            error = result.message ?: "Unexpected error occurred"
                        )
                    }

                }

                is Resource.Loading -> {
                    _state.update {
                        it.copy(
                            isLoading = true
                        )
                    }
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getVodkaCocktails() {
        getVodkaCocktailUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    Log.i("CocktailListViewModel", "Vodka Cocktails: ${result.data}")
                    _state.update { currentState ->
                        currentState.copy(
                            isLoading = false,
                            vodkaCocktails = result.data ?: emptyList()
                        )

                    }
                }

                is Resource.Error -> {
                    delay(20000)
                    _state.update {
                        it.copy(
                            isLoading = false,
                            error = result.message ?: "Unexpected error occurred"
                        )
                    }

                }

                is Resource.Loading -> {
                    _state.update {
                        it.copy(
                            isLoading = true
                        )
                    }
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getGinCocktails() {
        getGinCocktailUseCase().onEach { result ->
            Log.i("CocktailListViewModel", "Gin Cocktails: ${result.data}")
            when (result) {
                        is Resource.Success -> {
                    _state.update { currentState ->
                        currentState.copy(
                            isLoading = false,
                            ginCocktails = result.data ?: emptyList()
                        )
                    }
                }

                is Resource.Error -> {
                    delay(20000)
                    _state.update {
                        it.copy(
                            isLoading = false,
                            error = result.message ?: "Unexpected error occurred"
                        )
                    }

                }

                is Resource.Loading -> {
                    _state.update {
                        it.copy(
                            isLoading = true
                        )
                    }
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getRumCocktails() {
        getRumCocktailUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.update { currentState ->
                        currentState.copy(
                            isLoading = false,
                            rumCocktails = result.data ?: emptyList()
                        )
                    }
                }

                is Resource.Error -> {
                    delay(20000)
                    _state.update {
                        it.copy(
                            isLoading = false,
                            error = result.message ?: "Unexpected error occurred"
                        )
                    }

                }

                is Resource.Loading -> {
                    _state.update {
                        it.copy(
                            isLoading = true
                        )
                    }
                }
            }
        }.launchIn(viewModelScope)
    }


    fun search() {

    }
}