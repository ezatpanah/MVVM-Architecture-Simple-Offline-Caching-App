package com.ezatpanah.offlinecaching.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ezatpanah.offlinecaching.response.RestaurantResponse

@Database(entities = [RestaurantResponse::class], version = 1)
abstract class RestaurantDatabase : RoomDatabase() {
    abstract fun restaurantDao() : RestaurantDao
}