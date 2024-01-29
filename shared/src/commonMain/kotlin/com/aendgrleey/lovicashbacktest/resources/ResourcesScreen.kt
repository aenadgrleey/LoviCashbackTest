package com.aendgrleey.lovicashbacktest.resources

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.aenadgrleey.resources.Res
import com.aendgrleey.lovicashbacktest.resources.presentation.ResourcesScreenImpl
import dev.icerock.moko.resources.compose.painterResource
import dev.icerock.moko.resources.compose.stringResource

object ResourcesScreen : Tab {
    override val options: TabOptions
        @Composable
        get() = TabOptions(
            2u,
            stringResource(Res.strings.resources),
            painterResource(Res.images.resources)
        )

    @Composable
    override fun Content() = ResourcesScreenImpl()
}