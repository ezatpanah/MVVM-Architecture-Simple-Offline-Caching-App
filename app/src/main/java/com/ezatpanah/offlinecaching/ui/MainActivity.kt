package com.ezatpanah.offlinecaching.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.ezatpanah.offlinecaching.adapter.RestaurantAdapter
import com.ezatpanah.offlinecaching.databinding.ActivityMainBinding
import com.ezatpanah.offlinecaching.utils.DataStatus
import com.ezatpanah.offlinecaching.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    @Inject
    lateinit var restaurantAdapter: RestaurantAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {

            recyclerView.apply {
                adapter = restaurantAdapter
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
            viewModel.restaurants.observe(this@MainActivity) {
                restaurantAdapter.submitList(it.data)
                progressBar.isVisible = it is DataStatus.Loading && it.data.isNullOrEmpty()
                textViewError.isVisible = it is DataStatus.Loading && it.data.isNullOrEmpty()
                textViewError.text = it.error?.localizedMessage
            }
        }
    }
}