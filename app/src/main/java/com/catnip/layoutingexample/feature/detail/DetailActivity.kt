package com.catnip.layoutingexample.feature.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.catnip.layoutingexample.model.Food
import com.catnip.layoutingexample.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            onBackPressed() // Kembali ke tata letak sebelumnya saat tombol "Back" ditekan
        }

        val food = intent.getParcelableExtra<Food>(EXTRAS_ITEM)
        food?.let { displayFoodDetails(it) }
    }

    private fun displayFoodDetails(food: Food) {
        binding.apply {
            tvNameFood.text = food.name
            tvPrice.text = food.price
            tvDetailsFood.text = food.detailfood
            tvLocation.text = food.location
            tvDetailLocation.text = food.detailLocation
            Glide.with(this@DetailActivity)
                .load(food.imagefoodPictUrl)
                .into(ivProvile)
            tvDetailLocation.setOnClickListener {
                openLocationUrl(food.locationPictUrl)
            }
        }
    }

    private fun openLocationUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

    companion object {
        const val EXTRAS_ITEM = "EXTRAS_ITEM"

    }
}
