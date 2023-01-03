package com.ezatpanah.offlinecaching.viewmodel

import androidx.lifecycle.*
import com.ezatpanah.offlinecaching.repository.RestaurantRepository
import com.ezatpanah.offlinecaching.response.RestaurantResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val restaurantRepository: RestaurantRepository) : ViewModel() {

    val restaurants = restaurantRepository.getRestaurants().asLiveData()

}