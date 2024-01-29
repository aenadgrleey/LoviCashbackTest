package com.aenadgrleey.lovicashbacktest.apicall.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aenadgrleey.resources.Res
import com.aendgrleey.lovicashbacktest.apiCall.presentation.composables.PreloadingState
import com.aendgrleey.lovicashbacktest.app.composables.BottomBarButton
import dev.icerock.moko.resources.compose.painterResource
import dev.icerock.moko.resources.compose.stringResource

@Composable
private fun PreloadingStatePreview() {
    PreloadingState {

    }
}

@Preview
@Composable
private fun BottomBarButtonPreview() {
    Row {
        BottomBarButton(
            isSelected = true,
            painter = painterResource(Res.images.resources),
            text = stringResource(Res.strings.resources),
            onClick = {}
        )
    }
}

