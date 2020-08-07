package com.rsypj.restouts.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.rsypj.restouts.model.TransactionEntity

/**
 * Created by dhadotid on 18.52 | 07/08/20.
 * -> ✉ : yudhapurbajagad@gmail.com <-
 */

@Dao
interface TransactionDao {
    @Query("SELECT * FROM `Transaction`")
    fun getAll(): List<TransactionEntity>

    @Insert
    fun insertTransaction(transaction: TransactionEntity)

    @Delete
    fun deleteTransaction(transaction: TransactionEntity)
}