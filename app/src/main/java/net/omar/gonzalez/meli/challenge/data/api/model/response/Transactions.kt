package net.omar.gonzalez.meli.challenge.data.api.model.response

data class Transactions(
    val canceled: Int,
    val completed: Int,
    val period: String,
    val ratings: net.omar.gonzalez.meli.challenge.data.api.model.response.Ratings,
    val total: Int
)