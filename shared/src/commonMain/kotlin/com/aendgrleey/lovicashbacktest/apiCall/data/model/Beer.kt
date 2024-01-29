package com.aendgrleey.lovicashbacktest.apiCall.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Beer(
    @SerialName("id")
    val id: Int,

    @SerialName("name")
    val name: String,

    @SerialName("tagline")
    val tagline: String,

    @SerialName("first_brewed")
    val firstBrewed: String,

    @SerialName("description")
    val description: String,

    @SerialName("image_url")
    val imageUrl: String?
)
