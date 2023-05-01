package net.omar.gonzalez.meli.challenge

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import net.omar.gonzalez.meli.challenge.data.api.model.Resource
import net.omar.gonzalez.meli.challenge.repository.SearchRepository

class MainViewModel(val api: SearchRepository): ViewModel() {


    fun searchProducts(keyChain: String) = liveData {
        when(val response = api.search(keyChain)) {
            is Resource.Success -> {
                Log.d("Search",response.values.toString())
                emit(Resource.Success(response.values))
            }

            is Resource.Failure -> {
                emit(Resource.Failure(response.isNEtworkError, response.errorCode, response.errorBody))
            }
        }
    }
}