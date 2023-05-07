package net.omar.gonzalez.meli.challenge.utils

import net.omar.gonzalez.meli.challenge.data.model.History

class HistoryMockCreator {

    companion object {
        fun createHistoryWithItemsResponse(): List<History> {
            return listOf(
                History("iphone 14 plus"),
                History("robotech toy"),
                History("teminator 2 pinball")
            )
        }
    }
}