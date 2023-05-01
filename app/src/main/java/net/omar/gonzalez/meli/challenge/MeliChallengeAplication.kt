package net.omar.gonzalez.meli.challenge

import android.app.Application
import android.content.Context
import net.omar.gonzalez.meli.core.CoreConfig
import net.omar.gonzalez.meli.challenge.BuildConfig.BASE_URL


class MeliChallengeAplication : Application() {

    companion object {


//        @SuppressLint("StaticFieldLeak")
//        lateinit var remoteCommunicationModule: RemoteCommunicationModule
//            private set

        private fun initModules(applicationContext: Context) {
//            CoreConfig
            CoreConfig.baseUrl = BASE_URL
//            CoreConfig.versionName = VERSION_NAME
//            CoreConfig.requestDataProvider = RequestDataProviderImpl()
//            AnalyticsModule.init(
//                AnalyticsManagerImpl(applicationContext),
//                DynatraceSessionTrackerImpl()
//            )
//            remoteCommunicationModule = RemoteCommunicationModule(applicationContext)
//            LoggerModule.init(
//                RequestLoggerImpl(applicationContext),
//                TraceLoggerImpl(),
//                LoggerTypeFactoryImpl(
//                    CommonsApplication.sessionModule.sessionManager,
//                    applicationContext
//                )
//            )
        }
    }

    override fun onCreate() {
        super.onCreate()
//        LoginWrapper.init(applicationContext)
//        CommonsApplication.initModules(applicationContext)
        initModules(applicationContext)
//        remoteCommunicationModule.remoteConfigManager.init(R.xml.remote_config_defaults, object : RemoteConfigCallback {
//            override fun onErrorFetch(message: String?) {
//
//            }
//
//            override fun onSuccessFetch() {
//                LoggerConnectionManager.Enable(applicationContext)
//            }
//
//        })
//        remoteCommunicationModule.pushManager.setNotificationService(
//            applicationContext,
//            FCM_SERVICE
//        )
//        remoteCommunicationModule.pushManager.setButtons(applicationContext)
//        remoteCommunicationModule.pushManager.subscribeToFcmTopic(FCM_TOPIC)
//        Qualtrics.instance().initializeProject(QUALTRICS_BRAND_ID, QUALTRICS_PROJECT_ID, "", applicationContext)
    }
//
//    override fun onTerminate() {
//        super.onTerminate()
////        remoteCommunicationModule.pushManager.unsubscribeFromFcmTopic(FCM_TOPIC)
//    }
}