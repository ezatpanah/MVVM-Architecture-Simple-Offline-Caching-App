package com.ezatpanah.offlinecaching.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ezatpanah.offlinecaching.response.RestaurantResponse
import com.ezatpanah.offlinecaching.utils.Constants.RESTAURANT_TABLE
import kotlinx.coroutines.flow.Flow

@Dao
interface RestaurantDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRestaurants(restaurantResponse: List<RestaurantResponse>)

    @Query("DELETE FROM $RESTAURANT_TABLE")
    suspend fun deleteAllRestaurants()

    @Query("SELECT * FROM $RESTAURANT_TABLE")
    fun getAllRestaurants(): Flow<List<RestaurantResponse>>

}