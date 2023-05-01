package net.omar.gonzalez.meli.challenge.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import net.omar.gonzalez.meli.challenge.data.database.entities.HistoryEntity
//import net.omar.gonzalez.meli.core.database.BaseDao

@Dao
interface HistoryDao {

    @Query("SELECT * FROM search_history ORDER BY id DESC")
    suspend fun gerAllOrderById(): List<HistoryEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHistory(item: HistoryEntity)
}