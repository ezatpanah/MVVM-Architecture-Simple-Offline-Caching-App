package com.ezatpanah.offlinecaching.api

import com.ezatpanah.offlinecaching.response.RestaurantResponse
import retrofit2.http.GET

interface ApiServices {

    //https://random-data-api.com/api/restaurant/random_restaurant?size=20

    @GET("restaurant/random_restaurant?size=20")
    suspend fun getRestaurants(): List<RestaurantResponse>


}