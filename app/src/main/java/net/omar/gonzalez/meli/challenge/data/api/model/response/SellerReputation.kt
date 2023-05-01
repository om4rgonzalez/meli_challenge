package net.omar.gonzalez.meli.challenge.data.api.model.response

data class SellerReputation(
    val level_id: String,
    val metrics: net.omar.gonzalez.meli.challenge.data.api.model.response.Metrics,
    val power_seller_status: String,
    val transactions: net.omar.gonzalez.meli.challenge.data.api.model.response.Transactions
)