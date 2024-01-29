package com.aendgrleey.lovicashbacktest.apiCall.presentation.composables

import androidx.compose.foundation.Image
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.aenadgrleey.resources.Res
import com.aendgrleey.lovicashbacktest.apiCall.presentation.model.UiEvent
import com.aendgrleey.lovicashbacktest.apiCall.presentation.model.UiState
import dev.icerock.moko.resources.compose.painterResource
import dev.icerock.moko.resources.compose.stringResource
import io.kamel.core.getOrNull
import io.kamel.image.asyncPainterResource
import io.ktor.http.Url

@Composable
fun NormalState(
    uiState: UiState.NormalState,
    onUiEvent: (UiEvent) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        Text(text = uiState.name, style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(Res.strings.first_brewed, uiState.firstBrewed),
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = uiState.tagline, style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = asyncPainterResource(Url(uiState.imageUrl))
                .getOrNull()
                ?: painterResource(Res.images.no_image),
            contentDescription = "Beer image",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = uiState.description, style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.weight(1f))
        FilledTonalButton(
            shape = RoundedCornerShape(10.dp),
            onClick = { onUiEvent.invoke(UiEvent.OnLoadButtonClick) },
            contentPadding = PaddingValues(30.dp, 15.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(Res.strings.reload),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
        }
    }
}