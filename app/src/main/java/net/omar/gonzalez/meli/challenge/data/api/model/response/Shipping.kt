package net.omar.gonzalez.meli.challenge.data.api.model.response

data class Shipping(
    val dimensions: Any? = "",
    val free_shipping: Boolean,
    val local_pick_up: Boolean? = false,
    val logistic_type: String,
    val mode: String,
    val promise: Any,
    val store_pick_up: Boolean,
    val tags: List<String>,
    val methods: List<Any>? = null
)
