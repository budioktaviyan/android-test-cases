package id.kotlin.shop.data.product

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.Date

@Entity
data class Product(@PrimaryKey(autoGenerate = true) @ColumnInfo(name = "product_id") val id: Long,
                   @ColumnInfo(name = "name") val name: String?,
                   @ColumnInfo(name = "quantity") val quantity: Long,
                   @ColumnInfo(name = "supplier") val supplier: String?,
                   @ColumnInfo(name = "date") val date: Date?,
                   @ColumnInfo(name = "notes") val notes: String?)