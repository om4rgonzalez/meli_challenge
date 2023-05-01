package net.omar.gonzalez.meli.challenge.data.api.model.response

data class Body(
    val accepts_mercadopago: Boolean,
    val attributes: List<net.omar.gonzalez.meli.challenge.data.api.model.response.Attribute>,
    val automatic_relist: Boolean,
    val available_quantity: Int,
    val base_price: Int,
    val buying_mode: String,
    val catalog_listing: Boolean,
    val catalog_product_id: String,
    val category_id: String,
    val channels: List<String>,
    val condition: String,
    val coverage_areas: List<Any>,
    val currency_id: String,
    val date_created: String,
    val deal_ids: List<Any>,
    val descriptions: List<Any>,
    val differential_pricing: Any,
    val domain_id: String,
    val health: Double,
    val id: String,
    val initial_quantity: Int,
    val international_delivery_mode: String,
    val last_updated: String,
    val listing_source: String,
    val listing_type_id: String,
    val location: net.omar.gonzalez.meli.challenge.data.api.model.response.Location,
    val non_mercado_pago_payment_methods: List<Any>,
    val official_store_id: Any,
    val original_price: Any,
    val parent_item_id: Any,
    val permalink: String,
    val pictures: List<net.omar.gonzalez.meli.challenge.data.api.model.response.Picture>,
    val price: Int,
    val sale_terms: List<net.omar.gonzalez.meli.challenge.data.api.model.response.SaleTerm>,
    val secure_thumbnail: String,
    val seller_address: net.omar.gonzalez.meli.challenge.data.api.model.response.SellerAddress,
    val seller_contact: Any,
    val seller_id: Int,
    val shipping: net.omar.gonzalez.meli.challenge.data.api.model.response.Shipping,
    val site_id: String,
    val sold_quantity: Int,
    val start_time: String,
    val status: String,
    val stop_time: String,
    val sub_status: List<Any>,
    val subtitle: Any,
    val tags: List<String>,
    val thumbnail: String,
    val thumbnail_id: String,
    val title: String,
    val variations: List<net.omar.gonzalez.meli.challenge.data.api.model.response.Variation>,
    val video_id: Any,
    val warnings: List<Any>,
    val warranty: String
)