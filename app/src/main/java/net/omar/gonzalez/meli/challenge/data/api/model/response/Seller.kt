package net.omar.gonzalez.meli.challenge.data.api.model.response

import com.google.gson.annotations.SerializedName

data class Seller(
    @SerializedName("_")
    val underscore : Boolean,
    val car_dealer: Boolean,
    val car_dealer_logo: String,
    val eshop: net.omar.gonzalez.meli.challenge.data.api.model.response.Eshop,
    val id: Int,
    val nickname: String,
    val permalink: String,
    val real_estate_agency: Boolean,
    val registration_date: String,
    val seller_reputation: net.omar.gonzalez.meli.challenge.data.api.model.response.SellerReputation,
    val tags: List<String>
)