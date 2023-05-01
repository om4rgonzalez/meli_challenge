package net.omar.gonzalez.meli.core.database

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.RawQuery
import androidx.sqlite.db.SimpleSQLiteQuery
import androidx.sqlite.db.SupportSQLiteQuery

//abstract class BaseDao<T : BaseEntity>(private val tableName: String) {
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    abstract fun insert(entity: T)
//
//    @RawQuery
//    protected abstract fun getEntitySync(query: SupportSQLiteQuery): List<T>?
//
//    open fun gerAllOrderById(): List<T>? {
//        return getEntitySync(SimpleSQLiteQuery("SELECT * FROM $tableName ORDER BY id;"))
//    }
//
//}