package net.omar.gonzalez.meli.challenge.data.api.model.response

data class DelayedHandlingTime(
    val excluded: net.omar.gonzalez.meli.challenge.data.api.model.response.Excluded,
    val period: String,
    val rate: Double,
    val value: Int
)