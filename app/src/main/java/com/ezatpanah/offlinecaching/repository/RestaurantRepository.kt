package com.ezatpanah.offlinecaching.repository

import androidx.room.withTransaction
import com.ezatpanah.offlinecaching.api.ApiServices
import com.ezatpanah.offlinecaching.db.RestaurantDatabase
import com.ezatpanah.offlinecaching.utils.networkBoundResource
import kotlinx.coroutines.delay
import javax.inject.Inject

class RestaurantRepository @Inject constructor(
    private val apiServices: ApiServices,
    private val db: RestaurantDatabase,

    ) {

    private val restaurantDao = db.restaurantDao()

    fun getRestaurants() = networkBoundResource(
        query = {
            restaurantDao.getAllRestaurants()
        },
        fetch = {
            delay(2000)
            apiServices.getRestaurants()
        },
        saveFetchResult = { data ->
            db.withTransaction {
                restaurantDao.deleteAllRestaurants()
                restaurantDao.insertRestaurants(data)
            }

        }
    )
}