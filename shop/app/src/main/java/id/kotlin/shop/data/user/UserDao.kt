package id.kotlin.shop.data.user

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import android.arch.persistence.room.RoomWarnings
import io.reactivex.Flowable
import io.reactivex.Single

@SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)
@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.FAIL)
    fun create(user: User)

    @Query(value = "select * from User")
    fun findAll(): Flowable<List<User>>

    @Query(value = "select user_id from User where username=:username")
    fun findById(username: String): Single<User>
}