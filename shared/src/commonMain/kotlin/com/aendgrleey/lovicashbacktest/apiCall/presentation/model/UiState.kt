package com.aendgrleey.lovicashbacktest.apiCall.presentation.model

sealed interface UiState {
    data object PreloadingState : UiState
    data object LoadingState : UiState
    data object ErrorState : UiState
    data class NormalState(
        val name: String,
        val tagline: String,
        val firstBrewed: String,
        val description: String,
        val imageUrl: String
    ) : UiState
}
