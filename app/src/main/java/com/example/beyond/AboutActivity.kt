package com.example.beyond

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.beyond.databinding.ActivityAboutBinding
import com.google.android.material.navigation.NavigationView

class AboutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAboutBinding
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up Toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Enable Sidebar Menu
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
                R.id.nav_neo -> startActivity(Intent(this, NeoActivity::class.java))
                R.id.nav_about -> {} // Already in About Activity
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }
}
