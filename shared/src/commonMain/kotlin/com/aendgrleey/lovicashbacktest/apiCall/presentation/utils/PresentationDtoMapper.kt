package com.aendgrleey.lovicashbacktest.apiCall.presentation.utils

import com.aendgrleey.lovicashbacktest.apiCall.domain.model.BeerDto
import com.aendgrleey.lovicashbacktest.apiCall.presentation.model.UiState

class PresentationDtoMapper {

    private var cachedId: Int? = null

    fun reset() {
        cachedId = null
    }

    fun map(input: BeerDto) = with(input) {
        cachedId = id
        UiState.NormalState(name, tagline, firstBrewed, description, imageUrl)
    }

    fun reverseMap(input: UiState.NormalState) = with(input) {
        BeerDto(
            id = cachedId
                ?: error("Tried to map in wrong mapper state"),
            name = name,
            tagline = tagline,
            firstBrewed = firstBrewed,
            description = description,
            imageUrl = imageUrl
        )
    }
}