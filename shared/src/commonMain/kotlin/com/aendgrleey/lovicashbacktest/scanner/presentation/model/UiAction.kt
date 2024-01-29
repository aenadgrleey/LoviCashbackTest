package com.aendgrleey.lovicashbacktest.scanner.presentation.model

sealed interface UiAction {
    data object StartScanner : UiAction
}