package com.aendgrleey.lovicashbacktest.resources.presentation.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aenadgrleey.resources.Res
import com.aendgrleey.lovicashbacktest.resources.presentation.platform.Platform
import com.aendgrleey.lovicashbacktest.resources.presentation.platform.getPlatform
import dev.icerock.moko.resources.compose.painterResource

@Composable
fun ColumnScope.PlatformSpecificImage() {
    val platform = remember  { getPlatform() }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .weight(IMAGE_WEIGHT),
        contentAlignment = Alignment.TopCenter
    ) {
        Image(
            painter = painterResource(
                when (platform) {
                    is Platform.Android -> Res.images.android_logo
                    is Platform.IOS -> Res.images.apple_logo
                }
            ),
            contentDescription = "platform logo",
            modifier = Modifier.size(200.dp).padding(top = 16.dp),
            alignment = Alignment.TopCenter
        )
    }
}

private const val IMAGE_WEIGHT = 3f