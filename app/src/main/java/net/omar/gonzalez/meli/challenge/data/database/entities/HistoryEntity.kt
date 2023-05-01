package net.omar.gonzalez.meli.challenge.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import net.omar.gonzalez.meli.challenge.data.model.History
//import net.omar.gonzalez.meli.core.database.BaseEntity

@Entity(tableName = "search_history")
data class HistoryEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id") val id: Int = 0,
    @ColumnInfo("search_key") val searchKey: String
    )

fun History.ToEntity() = HistoryEntity(searchKey = searchKey)
