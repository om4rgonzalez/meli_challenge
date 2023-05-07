package net.omar.gonzalez.meli.challenge.data.api.model.response

data class SearchProductResponse(
    val available_filters: List<AvailableFilter>,
    val available_sorts: List<AvailableSort>,
    val country_default_time_zone: String,
    val filters: List<Filter>,
    val paging: Paging,
    val query: String,
    val results: List<Result>,
    val site_id: String,
    val sort: Sort
)