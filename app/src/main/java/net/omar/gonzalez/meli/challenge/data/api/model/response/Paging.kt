package net.omar.gonzalez.meli.challenge.data.api.model.response

data class Paging(
    val limit: Int,
    val offset: Int,
    val primary_results: Int,
    val total: Int
)