package net.omar.gonzalez.meli.core.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


//@Database(entities = [BaseDao::class], version = 1)
//abstract class DataBase(): RoomDatabase() {
//
//        abstract fun getDao(): BaseDao<BaseEntity>
//
//        companion object {
//                @Volatile
//                private var INSTANCE: DataBase? = null
//
//                fun getDatabase(
//                        context: Context,
//                        dataBaseName: String
//                ): DataBase {
//                        // if the INSTANCE is not null, then return it,
//                        // if it is, then create the database
//                        return INSTANCE ?: synchronized(this) {
//                                val instance = Room.databaseBuilder(
//                                        context.applicationContext,
//                                        DataBase::class.java,
//                                        dataBaseName
//                                )
//                                        // Wipes and rebuilds instead of migrating if no Migration object.
//                                        // Migration is not part of this codelab.
//                                        .fallbackToDestructiveMigration()
//                                        .build()
//                                INSTANCE = instance
//                                // return instance
//                                instance
//                        }
//                }
//        }
//}