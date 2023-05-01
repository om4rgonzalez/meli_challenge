package net.omar.gonzalez.meli.challenge.data.api.model.response

data class Result(
    val accepts_mercadopago: Boolean,
    val address: Address,
    val attributes: List<Attribute>,
    val available_quantity: Int,
    val buying_mode: String,
    val catalog_listing: Boolean,
    val catalog_product_id: String,
    val category_id: String,
    val condition: String,
    val currency_id: String,
    val differential_pricing: DifferentialPricing,
    val discounts: Any,
    val domain_id: String,
    val id: String,
    val installments: Installments,
    val inventory_id: Any,
    val listing_type_id: String,
    val official_store_id: Any,
    val order_backend: Int,
    val original_price: Any,
    val permalink: String,
    val price: Double,
    val promotions: List<Any>,
    val sale_price: Any,
    val seller: net.omar.gonzalez.meli.challenge.data.api.model.response.Seller,
    val seller_address: net.omar.gonzalez.meli.challenge.data.api.model.response.SellerAddress,
    val shipping: net.omar.gonzalez.meli.challenge.data.api.model.response.Shipping,
    val site_id: String,
    val sold_quantity: Int,
    val stop_time: String,
    val tags: List<String>,
    val thumbnail: String,
    val thumbnail_id: String,
    val title: String,
    val use_thumbnail_id: Boolean,
    val variation_filters: List<String>,
    val variation_id: String,
    val variations_data: net.omar.gonzalez.meli.challenge.data.api.model.response.VariationsData,
    val winner_item_id: Any
)