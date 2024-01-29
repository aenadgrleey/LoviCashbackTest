package com.aendgrleey.lovicashbacktest.apiCall.presentation

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.aendgrleey.lovicashbacktest.apiCall.presentation.composables.ErrorState
import com.aendgrleey.lovicashbacktest.apiCall.presentation.composables.LoadingState
import com.aendgrleey.lovicashbacktest.apiCall.presentation.composables.NormalState
import com.aendgrleey.lovicashbacktest.apiCall.presentation.composables.PreloadingState
import com.aendgrleey.lovicashbacktest.apiCall.presentation.model.UiState

@Composable
fun ApiCallScreenImpl(screenModel: ApiCallScreenModel) {
    val uiState by screenModel.uiState.collectAsState()
    val onUiEvent = screenModel::onUiEvent
    AnimatedContent(
        targetState = uiState,
        modifier = Modifier.fillMaxSize()
    ) {
        when(it) {
            UiState.ErrorState -> ErrorState(onUiEvent)
            UiState.LoadingState -> LoadingState()
            is UiState.NormalState -> NormalState(it, onUiEvent)
            UiState.PreloadingState -> PreloadingState(onUiEvent)
        }
    }
}