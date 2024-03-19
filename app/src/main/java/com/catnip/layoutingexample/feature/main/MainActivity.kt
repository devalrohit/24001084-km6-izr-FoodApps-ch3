package com.catnip.layoutingexample.feature.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.ui.setupWithNavController
import androidx.navigation.findNavController
import com.catnip.layoutingexample.databinding.ActivityMainBinding
import com.catnip.layoutingexample.R

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setBottomNavigation()
    }
    private fun setBottomNavigation() {
        val navController = findNavController(R.id.main_nav_host)
        binding.btnMain.setupWithNavController(navController)
    }
}
