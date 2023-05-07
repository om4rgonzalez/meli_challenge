package net.omar.gonzalez.meli.challenge.repository

import net.omar.gonzalez.meli.challenge.data.database.HistoryDataBase
import net.omar.gonzalez.meli.challenge.data.database.entities.ToEntity
import net.omar.gonzalez.meli.challenge.data.model.History
import net.omar.gonzalez.meli.challenge.data.model.toDomain

class HistoryRepository() {
    private val db = HistoryDataBase.getDatabase().getHistoryDao()

    suspend fun getAll(): List<History> = db.gerAllOrderById().map { it.toDomain() }
    suspend fun insert(key: History) {
        db.insertHistory(key.ToEntity())
    }
}