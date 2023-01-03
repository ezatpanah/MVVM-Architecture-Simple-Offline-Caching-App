package com.ezatpanah.offlinecaching.response


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ezatpanah.offlinecaching.utils.Constants.RESTAURANT_TABLE

@Entity(tableName = RESTAURANT_TABLE)
data class RestaurantResponse(
    @PrimaryKey val name: String, // Golden Box
    val logo: String, // https://loremflickr.com/500/500/restaurant
    val address: String, // 9543 Freddie Ports, North Allenburgh, VA 70531
    val description: String, // Culver’s Restaurant was founded by the Culver family in 1984, which eventually branched out to more than 300 franchised restaurants all over the US. Culver’s is well-known for its ButterBurger, which made the restaurant extremely famous. They also have other items which include salads, sandwiches, desserts, etc.
    val type: String, // Desserts
)