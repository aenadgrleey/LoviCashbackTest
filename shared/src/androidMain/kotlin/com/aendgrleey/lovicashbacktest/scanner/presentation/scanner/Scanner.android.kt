package com.aendgrleey.lovicashbacktest.scanner.presentation.scanner

import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanOptions

@Composable
actual fun scannerLauncher(
    onCodeScanned: (String) -> Unit,
    onDismiss: () -> Unit
): ScannerLauncher {
    val launcher = rememberLauncherForActivityResult(ScanContract()) {
        when (it.contents) {
            null -> onDismiss()
            else -> onCodeScanned(it.contents)
        }
    }
    return object : ScannerLauncher {
        override suspend fun launchScanner() {
            val options = ScanOptions()
                .apply { setOrientationLocked(true) }
            launcher.launch(options)
        }
    }
}