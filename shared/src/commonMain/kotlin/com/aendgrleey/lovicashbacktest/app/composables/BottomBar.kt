package com.aendgrleey.lovicashbacktest.app.composables

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.aenadgrleey.resources.Res
import dev.icerock.moko.resources.compose.painterResource

@Composable
fun BottomBar(
    current: TabOptions,
    vararg tabs: Pair<TabOptions, () -> Unit>
) {
    BottomAppBar(
    ) {
        tabs.forEach {
            BottomBarButton(
                isSelected = current.index == it.first.index,
                painter = it.first.icon ?: painterResource(Res.images.no_image),
                text = it.first.title,
                onClick = it.second
            )
        }
    }
}

@Composable
fun RowScope.BottomBarButton(
    isSelected: Boolean,
    painter: Painter,
    text: String,
    onClick: () -> Unit
) {
    val containerColor by animateColorAsState(
        MaterialTheme.colorScheme.run {
            if (isSelected) tertiaryContainer else surface
        },
        label = "containerColor"
    )
    Box(
        modifier = Modifier.weight(1f),
        contentAlignment = Alignment.Center
    ) {
        FilledTonalButton(
            onClick = onClick,
            shape = RoundedCornerShape(14.dp),
            colors = ButtonDefaults.buttonColors(containerColor = containerColor),
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painter,
                    contentDescription = null,
                    modifier = Modifier.size(32.dp),
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface)
                )
                Text(
                    text = text,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}
