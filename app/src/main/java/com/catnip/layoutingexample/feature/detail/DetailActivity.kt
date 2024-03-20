package com.catnip.layoutingexample.feature.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.catnip.layoutingexample.model.Food
import com.catnip.layoutingexample.databinding.ActivityDetailBinding
import com.catnip.layoutingexample.databinding.LayoutDetailBannerBinding
import com.catnip.layoutingexample.databinding.LayoutDetailContentBinding
import com.catnip.layoutingexample.databinding.LayoutDetailFoodBinding
import com.catnip.layoutingexample.databinding.LayoutDetailLocationBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var bannerBinding: LayoutDetailBannerBinding
    private lateinit var contentBinding: LayoutDetailContentBinding
    private lateinit var foodBinding: LayoutDetailFoodBinding
    private lateinit var locationBinding: LayoutDetailLocationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        bannerBinding = binding.layoutDetailBanner
        contentBinding = binding.layoutDetailContent
        foodBinding = binding.layoutDetailFood
        locationBinding = binding.layoutDetailLocation
        setContentView(binding.root)

        bannerBinding.btnBack.setOnClickListener {
            onBackPressed()
        }

        val food = intent.getParcelableExtra<Food>(EXTRAS_ITEM)
        food?.let { displayFoodDetails(it) }
    }

    private fun displayFoodDetails(food: Food) {
        foodBinding.apply {
            tvNameFood.text = food.name
            tvPrice.text = food.price
            tvDetailsFood.text = food.detailfood
        }
        locationBinding.apply {
            tvLocation.text = food.location
            tvDetailLocation.text = food.detailLocation
            tvDetailLocation.setOnClickListener {
                openLocationUrl(food.locationPictUrl)
            }
        }
        bannerBinding.apply {
            Glide.with(this@DetailActivity)
                .load(food.imagefoodPictUrl)
                .into(ivProvile)}
    }


    private fun openLocationUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

    companion object {
        const val EXTRAS_ITEM = "EXTRAS_ITEM"
    }
}
