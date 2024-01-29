package com.aendgrleey.lovicashbacktest.resources.presentation.platform

import platform.UIKit.UIDevice

actual fun getPlatform(): Platform =
    Platform.IOS(UIDevice.currentDevice.run { "${systemName()} $systemVersion" })
