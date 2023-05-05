package net.omar.gonzalez.meli.challenge.data.api.model

import okhttp3.ResponseBody

sealed class Resource<out T> {
    data class Success<out T>(val values: T): Resource<T>()
    data class Failure(
        val isNEtworkError: Boolean,
        val errorCode: Int?,
        val errorBody: ResponseBody?
    ) : Resource<Nothing>()
}
