package net.omar.gonzalez.meli.challenge.data.api.model.response

data class SearchLocation(
    val city: net.omar.gonzalez.meli.challenge.data.api.model.response.City,
    val neighborhood: net.omar.gonzalez.meli.challenge.data.api.model.response.Neighborhood,
    val state: net.omar.gonzalez.meli.challenge.data.api.model.response.State
)