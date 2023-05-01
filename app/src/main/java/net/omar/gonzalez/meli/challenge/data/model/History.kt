package net.omar.gonzalez.meli.challenge.data.model

import net.omar.gonzalez.meli.challenge.data.database.entities.HistoryEntity

data class History(val searchKey: String)

fun HistoryEntity.toDomain() = History(searchKey)
