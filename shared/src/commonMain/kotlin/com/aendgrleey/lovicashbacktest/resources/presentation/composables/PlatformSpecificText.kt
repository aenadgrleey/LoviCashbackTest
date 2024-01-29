package com.aendgrleey.lovicashbacktest.resources.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.aenadgrleey.resources.Res
import com.aendgrleey.lovicashbacktest.resources.presentation.platform.Greeting
import com.aendgrleey.lovicashbacktest.resources.presentation.platform.Platform
import com.aendgrleey.lovicashbacktest.resources.presentation.platform.getPlatform
import dev.icerock.moko.resources.compose.fontFamilyResource

@Composable
fun ColumnScope.PlatformSpecificText() {
    val platform = remember { getPlatform() }
    Box(
        Modifier
            .weight(TEXT_WEIGHT)
            .fillMaxWidth()
            .background(
                when (platform) {
                    is Platform.Android -> Color.Green
                    is Platform.IOS -> Color.Blue
                }
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = Greeting.greet(),
            style = MaterialTheme.typography.titleMedium,
            fontFamily = fontFamilyResource(Res.fonts.pretendard_medium),
            textAlign = TextAlign.Center,
        )
    }
}

private const val TEXT_WEIGHT = 1F
