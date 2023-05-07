package net.omar.gonzalez.meli.challenge

import android.app.Application
import android.content.Context
import net.omar.gonzalez.meli.core.CoreConfig
import net.omar.gonzalez.meli.challenge.BuildConfig.BASE_URL
import net.omar.gonzalez.meli.challenge.data.database.HistoryDataBase


class MeliChallengeAplication : Application() {

    companion object {
        private fun initModules(applicationContext: Context) {
            CoreConfig.baseUrl = BASE_URL
            HistoryDataBase.initDataBase(applicationContext, "challenge_db")
        }
    }

    override fun onCreate() {
        super.onCreate()
        initModules(applicationContext)
    }
}