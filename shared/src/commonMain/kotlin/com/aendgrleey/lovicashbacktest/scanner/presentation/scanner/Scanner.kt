package com.aendgrleey.lovicashbacktest.scanner.presentation.scanner

import androidx.compose.runtime.Composable

@Composable
expect fun scannerLauncher(
    onCodeScanned: (String) -> Unit,
    onDismiss: () -> Unit
) : ScannerLauncher

interface ScannerLauncher {
    // making it suspend to disable calling from composable function
    suspend fun launchScanner()
}