package net.omar.gonzalez.meli.challenge.repository

import android.content.Context
import net.omar.gonzalez.meli.challenge.data.database.HistoryDataBase
import net.omar.gonzalez.meli.challenge.data.database.entities.ToEntity
import net.omar.gonzalez.meli.challenge.data.model.History
import net.omar.gonzalez.meli.challenge.data.model.toDomain

class HistoryRepository(
    context: Context
) {
    private val db = HistoryDataBase.getDatabase(context, "challenge_db").getHistoryDao()

    suspend fun getAll(): List<History> = db.gerAllOrderById()?.let { list ->
        list.map { it.toDomain() }
    } ?: listOf()

    suspend fun insert(key: History) {
        db.insertHistory(key.ToEntity())
    }
}