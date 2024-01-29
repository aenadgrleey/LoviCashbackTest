package com.aendgrleey.lovicashbacktest.scanner.presentation.model

sealed interface UiEvent {
    data class OnCodeScanned(val code: String) : UiEvent
    data object OnScanButtonClick : UiEvent
}