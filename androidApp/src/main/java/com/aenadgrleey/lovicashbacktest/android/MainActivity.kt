package com.aenadgrleey.lovicashbacktest.android

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import com.aendgrleey.lovicashbacktest.app.App
import com.google.zxing.client.android.Intents
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanIntentResult
import com.journeyapps.barcodescanner.ScanOptions


class MainActivity : ComponentActivity() {
    private val barcodeLauncher = this.registerForActivityResult(ScanContract()) { result ->
        if (result.contents != null) {
            Toast
                .makeText(
                    this@MainActivity,
                    "Scanned: ${result.contents}",
                    Toast.LENGTH_LONG
                )
                .show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MyApplicationTheme { App() } }
    }
}
