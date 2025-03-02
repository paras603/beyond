package com.example.beyond

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.bumptech.glide.Glide
import com.example.beyond.databinding.ActivityApodBinding
import com.example.beyond.viewmodel.ApodViewModel
import com.google.android.material.navigation.NavigationView
import androidx.activity.viewModels

class ApodActivity : AppCompatActivity() {

    private lateinit var binding: ActivityApodBinding
    private lateinit var drawerLayout: DrawerLayout
    private val viewModel: ApodViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityApodBinding.inflate(layoutInflater)
        setContentView(binding.root)

        drawerLayout = findViewById(R.id.drawerLayout)
        val navigationView = findViewById<NavigationView>(R.id.navigationView)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)

        // Set up Toolbar as ActionBar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.baseline_menu_24)

        // Open drawer when clicking toolbar icon
        toolbar.setNavigationOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        // Handle menu item clicks
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_apod -> startActivity(Intent(this, ApodActivity::class.java))
                R.id.nav_mars -> startActivity(Intent(this, MarsActivity::class.java))
                R.id.nav_neo -> startActivity(Intent(this, NeoActivity::class.java))
                R.id.nav_about -> startActivity(Intent(this, AboutActivity::class.java))
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }

        // Observe and load APOD data
        viewModel.apodData.observe(this) { apod ->
            binding.tvTitle.text = apod.title
            binding.tvDescription.text = apod.explanation
            Glide.with(this).load(apod.url).into(binding.ivApod)
        }

        viewModel.fetchApod("AjRhpWfHEPTpt7zHHFHXdxqGlUHEQFzanRYe9y9R")
    }
}
