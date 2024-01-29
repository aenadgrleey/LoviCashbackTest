package com.aendgrleey.lovicashbacktest.apiCall.domain

import com.aendgrleey.lovicashbacktest.apiCall.data.GetBeerApi
import com.aendgrleey.lovicashbacktest.apiCall.domain.model.BeerDto

class GetRandomBeerUseCase(
    private val getBeerApi: GetBeerApi
) {
    suspend operator fun invoke(): Result<BeerDto> = getBeerApi.getRandomBeer()
}