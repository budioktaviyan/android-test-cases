package id.kotlin.shop.data.product

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun create(product: Product)

    @Query(value = "select * from Product")
    fun findAll(): List<Product>

    @Query(value = "select product_id from Product where product_id=:id")
    fun findById(id: Long): Product

    @Update
    fun update(product: Product)

    @Delete
    fun delete(product: Product)
}