package com.aendgrleey.lovicashbacktest.apiCall.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.aenadgrleey.resources.Res
import com.aendgrleey.lovicashbacktest.apiCall.presentation.model.UiEvent
import dev.icerock.moko.resources.compose.stringResource

@Composable
fun PreloadingState(
    onUiEvent: (UiEvent) -> Unit
) {
    Column(
        Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        FilledTonalButton(
            shape = RoundedCornerShape(10.dp),
            onClick = { onUiEvent.invoke(UiEvent.OnLoadButtonClick) },
            contentPadding = PaddingValues(30.dp, 15.dp)
        ) {
            Text(
                text = stringResource(Res.strings.load),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
        }
    }
}