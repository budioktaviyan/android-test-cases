package id.kotlin.shop.data.user

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class User(@PrimaryKey(autoGenerate = true) @ColumnInfo(name = "user_id") val id: Long,
                @ColumnInfo(name = "username") val username: String?,
                @ColumnInfo(name = "password") val password: String?)