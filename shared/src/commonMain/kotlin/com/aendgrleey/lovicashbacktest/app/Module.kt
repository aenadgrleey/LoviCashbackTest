package com.aendgrleey.lovicashbacktest.app

import com.aendgrleey.lovicashbacktest.apiCall.di.apiCallModule
import com.aendgrleey.lovicashbacktest.core.network.coreModule
import com.aendgrleey.lovicashbacktest.scanner.di.scannerModule
import org.koin.dsl.module

val appModule = module {
    includes(coreModule, apiCallModule, scannerModule)
}