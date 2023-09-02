package com.essycynthia.cocktailapp.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class CockTailResponseDto(
    val drinks: List<DrinkDto>,
)
