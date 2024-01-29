package com.aendgrleey.lovicashbacktest.apiCall.data

import com.aendgrleey.lovicashbacktest.apiCall.data.model.Beer
import com.aendgrleey.lovicashbacktest.apiCall.data.utils.DataDtoMapper
import com.aendgrleey.lovicashbacktest.apiCall.domain.model.BeerDto
import com.aendgrleey.lovicashbacktest.core.async.suspendRunCatching
import com.aendgrleey.lovicashbacktest.core.network.NetworkConstants
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class GetBeerApi(
    private val httpClient: HttpClient,
    private val mapper: DataDtoMapper
) {
    suspend fun getRandomBeer(): Result<BeerDto> = suspendRunCatching {
        mapper.map(
            httpClient
                .get(PATH_FOR_RANDOM)
                .body<List<Beer>>()
                .first()
        )
    }

    companion object {
        const val PATH_FOR_RANDOM = "${NetworkConstants.BASE_URL}/random"
    }
}