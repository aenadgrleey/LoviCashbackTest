package com.aendgrleey.lovicashbacktest.app

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.aendgrleey.lovicashbacktest.apiCall.ApiCallScreen
import com.aendgrleey.lovicashbacktest.app.composables.BottomBar
import com.aendgrleey.lovicashbacktest.resources.ResourcesScreen
import com.aendgrleey.lovicashbacktest.scanner.ScannerScreen

@Composable
fun App() {
    TabNavigator(
        ApiCallScreen,
    ) { navigator ->
        Scaffold(
            bottomBar = {
                BottomBar(
                    current = navigator.current.options,
                    tabs = arrayOf(
                        ApiCallScreen.options to { navigator.current = ApiCallScreen },
                        ResourcesScreen.options to { navigator.current = ResourcesScreen },
                        ScannerScreen.options to { navigator.current = ScannerScreen }
                    )
                )
            }
        ) { Box(Modifier.padding(it)) { CurrentTab() } }
    }
}