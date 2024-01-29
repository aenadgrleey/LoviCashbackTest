package com.aendgrleey.lovicashbacktest.apiCall.data.utils

import com.aendgrleey.lovicashbacktest.apiCall.data.model.Beer
import com.aendgrleey.lovicashbacktest.apiCall.domain.model.BeerDto

class DataDtoMapper {
    fun map(input: Beer): BeerDto = with(input) {
        BeerDto(id, name, tagline, firstBrewed, description, imageUrl ?: "")
    }
}