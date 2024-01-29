package com.aendgrleey.lovicashbacktest.resources.presentation.platform

import android.os.Build
import com.aendgrleey.lovicashbacktest.resources.presentation.platform.Platform

actual fun getPlatform(): Platform =
    Platform.Android("Android ${Build.VERSION.SDK_INT}")
