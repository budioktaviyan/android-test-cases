package id.kotlin.shop.data.user

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import android.arch.persistence.room.RoomWarnings

@SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)
@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun create(user: User)

    @Query(value = "select * from User")
    fun findAll(): List<User>

    @Query(value = "select user_id from User where user_id=:id")
    fun findById(id: Long): User
}