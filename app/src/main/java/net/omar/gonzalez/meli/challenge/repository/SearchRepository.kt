package net.omar.gonzalez.meli.challenge.repository

import net.omar.gonzalez.meli.challenge.data.api.service.search.MeliSearchApi
import net.omar.gonzalez.meli.core.network.RetrofitFactory

class SearchRepository: BaseRepository() {

    private val api: MeliSearchApi by lazy {
        RetrofitFactory.buildApi(MeliSearchApi::class.java)
    }

    suspend fun search(key: String) = safeApiCall {
        api.fetchProductList(key)
    }

    suspend fun getProductDetail(productId: String) = safeApiCall {
        api.getProductDetail(productId)
    }
}