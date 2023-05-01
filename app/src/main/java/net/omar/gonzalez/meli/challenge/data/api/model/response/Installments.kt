package net.omar.gonzalez.meli.challenge.data.api.model.response

data class Installments(
    val amount: Double,
    val currency_id: String,
    val quantity: Int,
    val rate: Double
)