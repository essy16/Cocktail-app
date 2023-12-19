package com.essycynthia.cocktailapp.ui.presentation.cocktails_list

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.essycynthia.cocktailapp.domain.use_cases.GetTequilaCocktailUseCase
import com.essycynthia.cocktailapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CocktailListViewModel @Inject constructor(
//    private val getAlcoholicCocktailUseCase: GetAlcoholicCocktailUseCase,
//    private val getNonAlcoholicCocktailUseCase: GetNonAlcoholicCocktailUseCase,
//    private val getVodkaCocktailUseCase: GetVodkaCocktailUseCase,
//    private val getRumCocktailUseCase: GetRumCocktailUseCase,
    private val getTequilaCocktailUseCase: GetTequilaCocktailUseCase,
//    private val getGinCocktailUseCase: GetGinCocktailUseCase,
) : ViewModel() {
    private val _state = mutableStateOf(CocktailsListState())
    val state: State<CocktailsListState> = _state
//    private val _searchText = MutableStateFlow("")
//    val searchText = _searchText.asStateFlow()
//    private val _isSearching = MutableStateFlow(false)
//    val isSearching = _isSearching.asStateFlow()


    init {
        getTequilaCocktails()
//        getAlcoholicCocktails()
//        getNonAlcoholicCocktails()
//        getRumCocktails()
//        getTequilaCocktails()
//        getGinCocktails()
//        getVodkaCocktails()
    }
    private fun getTequilaCocktails() {
        _state.value = CocktailsListState(isLoading = true)
        getTequilaCocktailUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CocktailsListState(cocktails = result.data ?: emptyList())
                    Log.d("TAG", "getTequilaCocktails:$_state ")
                }

                is Resource.Error -> {
                    _state.value =
                        CocktailsListState(error = result.message ?: "An unexpected error occurred")
                }

                is Resource.Loading -> {
                    _state.value = CocktailsListState(isLoading = true)
                }

                else -> {}
            }
        }.launchIn(viewModelScope)
    }


//    private fun getAlcoholicCocktails() {
//        getAlcoholicCocktailUseCase().onEach { result ->
//            when (result) {
//                is Resource.Success -> {
//                    _state.value = CocktailsListState(cocktails = result.data ?: emptyList())
//                }
//
//                is Resource.Error -> {
//                    _state.value =
//                        CocktailsListState(error = result.message ?: "An unexpected error occurred")
//
//                }
//
//                is Resource.Loading -> {
//                    _state.value = CocktailsListState(isLoading = true)
//                }
//            }
//        }.launchIn(viewModelScope)
//    }
//
//    private fun getNonAlcoholicCocktails() {
//        getNonAlcoholicCocktailUseCase().onEach { result ->
//            when (result) {
//                is Resource.Success -> {
//                    _state.value = CocktailsListState(cocktails = result.data ?: emptyList())
//                }
//
//                is Resource.Error -> {
//                    _state.value =
//                        CocktailsListState(error = result.message ?: "An unexpected error occurred")
//                }
//
//                is Resource.Loading -> {
//                    _state.value = CocktailsListState(isLoading = false)
//                }
//            }
//        }.launchIn(viewModelScope)
//    }
//
//    private fun getVodkaCocktails() {
//        getVodkaCocktailUseCase().onEach { result ->
//            when (result) {
//                is Resource.Success -> {
//                    _state.value = CocktailsListState(cocktails = result.data ?: emptyList())
//                }
//
//                is Resource.Error -> {
//                    _state.value =
//                        CocktailsListState(error = result.message ?: "An unexpected error occurred")
//                }
//
//                is Resource.Loading -> {
//                    _state.value = CocktailsListState(isLoading = false)
//                }
//            }
//        }.launchIn(viewModelScope)
//    }
//
//    private fun getGinCocktails() {
//        getGinCocktailUseCase().onEach { result ->
//            when (result) {
//                is Resource.Success -> {
//                    _state.value = CocktailsListState(cocktails = result.data ?: emptyList())
//                }
//
//                is Resource.Error -> {
//                    _state.value =
//                        CocktailsListState(error = result.message ?: "An unexpected error occurred")
//                }
//
//                is Resource.Loading -> {
//                    _state.value = CocktailsListState(isLoading = false)
//                }
//            }
//        }.launchIn(viewModelScope)
//    }
//
//    private fun getRumCocktails() {
//        getRumCocktailUseCase().onEach { result ->
//            when (result) {
//                is Resource.Success -> {
//                    _state.value = CocktailsListState(cocktails = result.data ?: emptyList())
//                }
//
//                is Resource.Error -> {
//                    _state.value =
//                        CocktailsListState(error = result.message ?: "An unexpected error occurred")
//                }
//
//                is Resource.Loading -> {
//                    _state.value = CocktailsListState(isLoading = false)
//                }
//            }
//        }.launchIn(viewModelScope)
//    }


    fun search() {

    }
}