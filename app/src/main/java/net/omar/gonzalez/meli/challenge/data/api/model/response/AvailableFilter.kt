package net.omar.gonzalez.meli.challenge.data.api.model.response

data class AvailableFilter(
    val id: String,
    val name: String,
    val type: String,
    val values: List<net.omar.gonzalez.meli.challenge.data.api.model.response.Value>
)