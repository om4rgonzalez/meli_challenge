package net.omar.gonzalez.meli.challenge.utils

import net.omar.gonzalez.meli.challenge.data.api.model.Resource
import net.omar.gonzalez.meli.challenge.data.api.model.response.Paging
import net.omar.gonzalez.meli.challenge.data.api.model.response.SearchProductResponse
import net.omar.gonzalez.meli.challenge.data.api.model.response.Sort

class SearchMockCreator {

    companion object {
        fun createSearchResponseMock(): SearchProductResponse =
            SearchProductResponse(
                available_filters = listOf(),
                available_sorts = listOf(),
                country_default_time_zone = "",
                filters = listOf(),
                paging = Paging(0,0,0,0),
                query = "",
                results = listOf(),
                site_id = "1",
                sort = Sort("","")
            )

        fun createSearchFailureResponseMock(): Resource.Failure =
            Resource.Failure(isNEtworkError = true, errorCode = 401)
    }
}