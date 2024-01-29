package com.aendgrleey.lovicashbacktest.scanner

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.aenadgrleey.resources.Res
import com.aendgrleey.lovicashbacktest.scanner.presentation.ScannerScreenModel
import com.aendgrleey.lovicashbacktest.scanner.presentation.composables.ScannerScreenImpl
import com.aendgrleey.lovicashbacktest.scanner.presentation.model.UiAction
import com.aendgrleey.lovicashbacktest.scanner.presentation.model.UiEvent
import com.aendgrleey.lovicashbacktest.scanner.presentation.scanner.scannerLauncher
import dev.icerock.moko.resources.compose.painterResource
import dev.icerock.moko.resources.compose.stringResource

object ScannerScreen : Tab {
    override val options: TabOptions
        @Composable
        get() = TabOptions(
            3u,
            stringResource(Res.strings.scanner),
            painterResource(Res.images.scanner)
        )

    @Composable
    override fun Content() {
        val screenModel = getScreenModel<ScannerScreenModel>()
        val launcher = scannerLauncher(
            onCodeScanned = { screenModel.onUiEvent(UiEvent.OnCodeScanned(it)) },
            onDismiss = {}
        )
        LaunchedEffect(Unit) {
            screenModel.uiAction.collect {
                when (it) {
                    UiAction.StartScanner -> launcher.launchScanner()
                }
            }
        }
        val uiState by screenModel.uiState.collectAsState()
        ScannerScreenImpl(uiState, screenModel::onUiEvent)
    }
}