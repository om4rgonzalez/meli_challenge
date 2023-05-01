package net.omar.gonzalez.meli.challenge.data.api.model.response

data class Variation(
    val attribute_combinations: List<net.omar.gonzalez.meli.challenge.data.api.model.response.AttributeCombination>,
    val available_quantity: Int,
    val catalog_product_id: String,
    val id: Long,
    val picture_ids: List<String>,
    val price: Int,
    val sale_terms: List<Any>,
    val sold_quantity: Int
)