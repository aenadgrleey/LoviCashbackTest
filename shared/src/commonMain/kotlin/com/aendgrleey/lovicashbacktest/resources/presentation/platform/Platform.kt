package com.aendgrleey.lovicashbacktest.resources.presentation.platform

sealed interface Platform {

    val name: String

    data class IOS(
        override val name: String
    ) : Platform

    data class Android(
        override val name: String
    ) : Platform

}

expect fun getPlatform(): Platform