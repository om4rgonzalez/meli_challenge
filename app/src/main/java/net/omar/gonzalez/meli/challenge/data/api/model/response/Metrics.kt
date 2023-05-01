package net.omar.gonzalez.meli.challenge.data.api.model.response

data class Metrics(
    val cancellations: net.omar.gonzalez.meli.challenge.data.api.model.response.Cancellations,
    val claims: net.omar.gonzalez.meli.challenge.data.api.model.response.Claims,
    val delayed_handling_time: net.omar.gonzalez.meli.challenge.data.api.model.response.DelayedHandlingTime,
    val sales: net.omar.gonzalez.meli.challenge.data.api.model.response.Sales
)