package net.omar.gonzalez.meli.challenge.data.api.model.response

data class SearchProductResponse(
    val available_filters: List<net.omar.gonzalez.meli.challenge.data.api.model.response.AvailableFilter>,
    val available_sorts: List<net.omar.gonzalez.meli.challenge.data.api.model.response.AvailableSort>,
    val country_default_time_zone: String,
    val filters: List<net.omar.gonzalez.meli.challenge.data.api.model.response.Filter>,
    val paging: net.omar.gonzalez.meli.challenge.data.api.model.response.Paging,
    val query: String,
    val results: List<net.omar.gonzalez.meli.challenge.data.api.model.response.Result>,
    val site_id: String,
    val sort: net.omar.gonzalez.meli.challenge.data.api.model.response.Sort
)