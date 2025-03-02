package com.example.beyond

import android.os.Bundle
import android.content.Intent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.beyond.adapter.NeoAdapter
import com.example.beyond.databinding.ActivityNeoBinding
import com.example.beyond.viewmodel.NeoViewModel
import com.google.android.material.navigation.NavigationView

class NeoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNeoBinding
    private val viewModel: NeoViewModel by viewModels()
    private lateinit var adapter: NeoAdapter
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNeoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up Toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Enable sidebar menu button
        drawerLayout = findViewById(R.id.drawerLayout)
        toolbar.setNavigationOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        // Set up Navigation Drawer
        val navigationView = findViewById<NavigationView>(R.id.navigationView)
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_apod -> startActivity(Intent(this, ApodActivity::class.java))
                R.id.nav_mars -> startActivity(Intent(this, MarsActivity::class.java))
                R.id.nav_neo -> {} // Already in NEO Activity
                R.id.nav_about -> startActivity(Intent(this, AboutActivity::class.java))
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }

        // Set up RecyclerView
        adapter = NeoAdapter()
        binding.rvNeo.layoutManager = LinearLayoutManager(this)
        binding.rvNeo.adapter = adapter

        // Observe data
        viewModel.neoData.observe(this) { neoData ->
            val asteroids = neoData.near_earth_objects.values.flatten()
            adapter.submitList(asteroids)
        }

        // Fetch NEO Data
        viewModel.fetchNeoData("AjRhpWfHEPTpt7zHHFHXdxqGlUHEQFzanRYe9y9R", "2025-02-25", "2025-02-26")
    }
}
