package com.aendgrleey.lovicashbacktest.scanner.presentation.scanner

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import org.koin.compose.getKoin

@Composable
actual fun scannerLauncher(
    onCodeScanned: (String) -> Unit,
    onDismiss: () -> Unit
): ScannerLauncher {
    val factory = getKoin().get<ScannerFactory>()
    val nativeLauncher = remember { factory.create(ScannerCallback(onCodeScanned, onDismiss)) }
    return remember {
        object : ScannerLauncher {
            override suspend fun launchScanner() {
                nativeLauncher.launch()
            }
        }
    }
}

interface ScannerFactory {
    fun create(callback: ScannerCallback): IosScanner
}

interface ScannerCallback {
    fun onCodeScanned(code: String)
    fun onDismiss()

    companion object {

        operator fun invoke(
            onCodeScanned: (String) -> Unit,
            onDismiss: () -> Unit
        ) = object : ScannerCallback {
            override fun onCodeScanned(code: String) = onCodeScanned(code)
            override fun onDismiss() = onDismiss()

        }
    }
}

interface IosScanner {
    fun launch()
}