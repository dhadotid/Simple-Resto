package com.rsypj.restouts.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by dhadotid on 18.56 | 07/08/20.
 * -> ✉ : yudhapurbajagad@gmail.com <-
 */

@Entity(tableName = "Transaction")
data class TransactionEntity (
    @PrimaryKey val id: String,
    val name: String,
    val price: String,
    val description: String,
    val photo: String,
    val qty: Int
)