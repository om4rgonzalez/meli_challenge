package net.omar.gonzalez.meli.challenge.ui.productdetail

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import net.omar.gonzalez.meli.challenge.data.api.model.Resource
import net.omar.gonzalez.meli.challenge.repository.SearchRepository

class ProductDetailViewModel(
    val api: SearchRepository
): ViewModel() {

    fun getProductDetail(productId: String) = liveData {
        when(val response = api.getProductDetail(productId)) {
            is Resource.Success -> {
                emit(Resource.Success(response.values))
            }

            is Resource.Failure -> {
                Log.d("Search",response.errorBody.toString())
                emit(Resource.Failure(response.isNEtworkError, response.errorCode, response.errorBody))
            }
        }
    }

}