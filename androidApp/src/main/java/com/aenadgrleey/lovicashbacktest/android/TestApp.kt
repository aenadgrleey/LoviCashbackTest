package com.aenadgrleey.lovicashbacktest.android

import android.app.Application
import android.content.Context
import com.aendgrleey.lovicashbacktest.apiCall.di.apiCallModule
import com.aendgrleey.lovicashbacktest.app.appModule
import com.aendgrleey.lovicashbacktest.core.network.coreModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TestApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@TestApp as Context)
            modules(appModule)
        }
    }
}