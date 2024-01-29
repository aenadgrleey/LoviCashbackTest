package com.aendgrleey.lovicashbacktest.apiCall.di

import com.aendgrleey.lovicashbacktest.apiCall.ApiCallScreen
import com.aendgrleey.lovicashbacktest.apiCall.data.GetBeerApi
import com.aendgrleey.lovicashbacktest.apiCall.data.utils.DataDtoMapper
import com.aendgrleey.lovicashbacktest.apiCall.domain.GetRandomBeerUseCase
import com.aendgrleey.lovicashbacktest.apiCall.presentation.ApiCallScreenModel
import com.aendgrleey.lovicashbacktest.apiCall.presentation.utils.PresentationDtoMapper
import org.koin.dsl.module

val apiCallModule = module {
    scope<ApiCallScreenModel> {
        scoped { DataDtoMapper() }
        scoped { GetBeerApi(get(), get()) }
        factory { GetRandomBeerUseCase(get()) }
        scoped { PresentationDtoMapper() }
    }
    factory {
        val scope = getKoin().createScope<ApiCallScreenModel>()
        ApiCallScreenModel(scope.get(), scope.get()) { scope.close() }
    }
}