package com.aendgrleey.lovicashbacktest.apiCall.presentation.model

sealed interface UiEvent {
    data object OnLoadButtonClick : UiEvent
}