package net.omar.gonzalez.meli.challenge.data.api.service.search

import net.omar.gonzalez.meli.challenge.data.api.model.response.Product
import net.omar.gonzalez.meli.challenge.data.api.model.response.ProductDetailResponse
import net.omar.gonzalez.meli.challenge.data.api.model.response.SearchProductResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MeliSearchApi {

    @GET("sites/MLA/search")
    suspend fun fetchProductList(@Query("q") keyChain: String): SearchProductResponse

    @GET("items/{itemId}")
    suspend fun getProductDetail(@Path("itemId") itemId: String): Product
}