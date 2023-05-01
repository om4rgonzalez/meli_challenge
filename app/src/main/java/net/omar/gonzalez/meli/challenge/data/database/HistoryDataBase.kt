package net.omar.gonzalez.meli.challenge.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import net.omar.gonzalez.meli.challenge.data.database.dao.HistoryDao
import net.omar.gonzalez.meli.challenge.data.database.entities.HistoryEntity

@Database(entities = [HistoryEntity::class], version = 1)
abstract class HistoryDataBase: RoomDatabase() {

    abstract fun getHistoryDao(): HistoryDao

    companion object {
        @Volatile
        private var INSTANCE: HistoryDataBase? = null

        fun getDatabase(
            context: Context,
            dataBaseName: String
        ): HistoryDataBase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    HistoryDataBase::class.java,
                    dataBaseName
                )
                    // Wipes and rebuilds instead of migrating if no Migration object.
                    // Migration is not part of this codelab.
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}