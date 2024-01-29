package com.aendgrleey.lovicashbacktest.scanner.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.aenadgrleey.resources.Res
import com.aendgrleey.lovicashbacktest.scanner.presentation.model.UiEvent
import com.aendgrleey.lovicashbacktest.scanner.presentation.model.UiState
import dev.icerock.moko.resources.compose.stringResource

@Composable
fun ScannerScreenImpl(
    uiState: UiState,
    onUiEvent: (UiEvent) -> Unit
) {
    Column(
        Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = uiState.text,
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        )

        Spacer(Modifier.height(48.dp))

        FilledTonalButton(
            shape = RoundedCornerShape(10.dp),
            onClick = { onUiEvent.invoke(UiEvent.OnScanButtonClick) },
            contentPadding = PaddingValues(30.dp, 15.dp)
        ) {
            Text(
                text = stringResource(Res.strings.scan),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
        }
    }
}