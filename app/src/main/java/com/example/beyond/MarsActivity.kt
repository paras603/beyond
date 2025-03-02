package com.example.beyond

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.beyond.adapter.MarsAdapter
import com.example.beyond.databinding.ActivityMarsBinding
import com.example.beyond.viewmodel.MarsViewModel
import com.google.android.material.navigation.NavigationView

class MarsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMarsBinding
    private val viewModel: MarsViewModel by viewModels()
    private lateinit var adapter: MarsAdapter
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMarsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up Toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Enable back navigation
        toolbar.setNavigationOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        // Set up Navigation Drawer
        drawerLayout = findViewById(R.id.drawerLayout)
        val navigationView = findViewById<NavigationView>(R.id.navigationView)

        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_apod -> startActivity(Intent(this, ApodActivity::class.java))
                R.id.nav_mars -> {} // Already in MarsActivity
                R.id.nav_neo -> startActivity(Intent(this, NeoActivity::class.java))
                R.id.nav_about -> startActivity(Intent(this, AboutActivity::class.java))
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }

        // Set up RecyclerView
        adapter = MarsAdapter()
        binding.rvMars.layoutManager = LinearLayoutManager(this)
        binding.rvMars.adapter = adapter

        // Observe data
        viewModel.marsPhotos.observe(this) { marsData ->
            adapter.submitList(marsData.photos)
        }

        // Fetch Mars Rover Photos
        viewModel.fetchMarsPhotos("AjRhpWfHEPTpt7zHHFHXdxqGlUHEQFzanRYe9y9R", "2025-02-25")
    }
}
