package com.aendgrleey.lovicashbacktest.resources.presentation.platform

import androidx.compose.runtime.Composable
import com.aenadgrleey.resources.Res
import dev.icerock.moko.resources.compose.stringResource

object Greeting {
    private val platform: Platform by lazy { getPlatform() }
    @Composable
    fun greet(): String = stringResource(Res.strings.hello, platform.name)
}
