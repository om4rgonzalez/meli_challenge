package net.omar.gonzalez.meli.core.network

import com.google.gson.Gson
import net.omar.gonzalez.meli.core.CoreConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

abstract class RetrofitFactory {

    companion object {
        fun <Api> buildApi(
            api: Class<Api>
        ) : Api {
            return Retrofit.Builder()
                .baseUrl(CoreConfig.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(api)
        }
    }


}