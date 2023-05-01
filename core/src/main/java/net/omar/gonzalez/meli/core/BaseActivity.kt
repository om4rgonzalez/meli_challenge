package net.omar.gonzalez.meli.core

import android.app.Application
import android.content.Context

class BaseActivity : Application() {

//    private val okHttpFactory: OkHttpFactory = OkHttpFactoryImpl()
//    private val retrofitFactory = RetrofitFactoryImpl()
//
//    override fun onCreate() {
//        super.onCreate()
//        CoreModule.init()
//        converter = GsonConverterFactory.create()
//        initModules(applicationContext)
//
//        if (BuildConfig.DEBUG)
//            Stetho.initializeWithDefaults(this)
//
//    }
//
//    private fun initModules(context: Context) {
//        CoreConfig.baseUrl = BuildConfig.BASE_URL
//        CoreConfig.versionName = BuildConfig.VERSION_NAME
//        okHttpClient = okHttpFactory.makeOkHttpClient(context, Constants.hostName, Constants.pinList)
//        retrofitFactory.initializateRetrofit(converter, okHttpClient)
//    }
}