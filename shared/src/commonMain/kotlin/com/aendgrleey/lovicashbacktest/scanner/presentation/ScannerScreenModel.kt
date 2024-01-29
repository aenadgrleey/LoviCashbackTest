package com.aendgrleey.lovicashbacktest.scanner.presentation

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.aendgrleey.lovicashbacktest.scanner.presentation.model.UiAction
import com.aendgrleey.lovicashbacktest.scanner.presentation.model.UiEvent
import com.aendgrleey.lovicashbacktest.scanner.presentation.model.UiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ScannerScreenModel : ScreenModel {
    private val mUiState = MutableStateFlow(UiState("Nothing scanned yet!"))
    val uiState: StateFlow<UiState>
        get() = mUiState

    private val mUiAction: Channel<UiAction> = Channel(onBufferOverflow = BufferOverflow.SUSPEND)
    val uiAction: Flow<UiAction>
        get() = mUiAction.receiveAsFlow().flowOn(Dispatchers.Main.immediate)

    fun onUiEvent(uiEvent: UiEvent) {
        when(uiEvent) {
            is UiEvent.OnCodeScanned -> mUiState.update { it.copy(text = uiEvent.code) }
            UiEvent.OnScanButtonClick -> onUiAction(UiAction.StartScanner)
        }
    }

    private fun onUiAction(uiAction: UiAction) {
        screenModelScope.launch(Dispatchers.Main.immediate) { mUiAction.send(uiAction) }
    }

}