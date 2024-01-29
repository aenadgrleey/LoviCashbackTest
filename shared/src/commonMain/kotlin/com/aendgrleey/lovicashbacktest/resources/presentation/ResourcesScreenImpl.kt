package com.aendgrleey.lovicashbacktest.resources.presentation

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aendgrleey.lovicashbacktest.resources.presentation.composables.PlatformSpecificImage
import com.aendgrleey.lovicashbacktest.resources.presentation.composables.PlatformSpecificText

@Composable
fun ResourcesScreenImpl() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
            .border(1.dp, MaterialTheme.colorScheme.outline)
    ) {
        PlatformSpecificImage()
        PlatformSpecificText()
    }
}
