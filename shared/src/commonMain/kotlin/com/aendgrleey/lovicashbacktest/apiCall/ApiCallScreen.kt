package com.aendgrleey.lovicashbacktest.apiCall

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.aenadgrleey.resources.Res
import com.aendgrleey.lovicashbacktest.apiCall.presentation.ApiCallScreenImpl
import com.aendgrleey.lovicashbacktest.apiCall.presentation.ApiCallScreenModel
import dev.icerock.moko.resources.compose.painterResource
import dev.icerock.moko.resources.compose.stringResource

object ApiCallScreen : Tab {
    override val options: TabOptions
        @Composable
        get() = TabOptions(
            1u,
            stringResource(Res.strings.api_call),
            painterResource(Res.images.api)
        )

    @Composable
    override fun Content() {
        val screenModel = getScreenModel<ApiCallScreenModel>()
        ApiCallScreenImpl(screenModel)
    }
}