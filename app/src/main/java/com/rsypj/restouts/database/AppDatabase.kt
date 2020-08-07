package com.rsypj.restouts.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rsypj.restouts.database.dao.TransactionDao
import com.rsypj.restouts.model.TransactionEntity

/**
 * Created by dhadotid on 19.06 | 07/08/20.
 * -> ✉ : yudhapurbajagad@gmail.com <-
 */

@Database(entities = [TransactionEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun transactionDao(): TransactionDao
}