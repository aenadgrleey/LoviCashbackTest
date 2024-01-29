package com.aendgrleey.lovicashbacktest.apiCall.presentation

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.aendgrleey.lovicashbacktest.apiCall.domain.GetRandomBeerUseCase
import com.aendgrleey.lovicashbacktest.apiCall.presentation.model.UiEvent
import com.aendgrleey.lovicashbacktest.apiCall.presentation.model.UiState
import com.aendgrleey.lovicashbacktest.apiCall.presentation.utils.PresentationDtoMapper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ApiCallScreenModel(
    private val getRandomBeer: GetRandomBeerUseCase,
    private val mapper: PresentationDtoMapper,
    private val closeScope: () -> Unit
) : ScreenModel {
    private val mUiState = MutableStateFlow<UiState>(UiState.PreloadingState)
    val uiState: StateFlow<UiState>
        get() = mUiState

    fun onUiEvent(uiEvent: UiEvent) {
        when (uiEvent) {
            UiEvent.OnLoadButtonClick -> {
                screenModelScope.launch {
                    mUiState.update { UiState.LoadingState }
                    getRandomBeer()
                        .onSuccess { beer ->
                            mapper.reset()
                            mUiState.update { mapper.map(beer) }
                        }
                        .onFailure {
                            println(it.stackTraceToString())
                            mUiState.update { UiState.ErrorState }
                        }
                }
            }
        }
    }

    override fun onDispose() {
        super.onDispose()
        closeScope()
    }
}