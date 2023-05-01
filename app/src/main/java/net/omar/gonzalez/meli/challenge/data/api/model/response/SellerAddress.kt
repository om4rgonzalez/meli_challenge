package net.omar.gonzalez.meli.challenge.data.api.model.response

data class SellerAddress(
    val address_line: String,
    val city: net.omar.gonzalez.meli.challenge.data.api.model.response.City,
    val comment: String,
    val country: net.omar.gonzalez.meli.challenge.data.api.model.response.Country,
    val id: Any,
    val latitude: Any,
    val longitude: Any,
    val state: net.omar.gonzalez.meli.challenge.data.api.model.response.State,
    val zip_code: String
)