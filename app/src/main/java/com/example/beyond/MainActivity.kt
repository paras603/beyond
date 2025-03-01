package com.example.beyond

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.beyond.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Navigate to Astronomy Picture of the Day (APOD)
        binding.btnApod.setOnClickListener {
            startActivity(Intent(this, ApodActivity::class.java))
        }

        // Navigate to Mars Rover Photos
        binding.btnMars.setOnClickListener {
            startActivity(Intent(this, MarsActivity::class.java))
        }

        // Navigate to Near-Earth Objects (NEO) Tracker
        binding.btnNeo.setOnClickListener {
            startActivity(Intent(this, NeoActivity::class.java))
        }

        // Navigate to About Page
        binding.btnAbout.setOnClickListener {
            startActivity(Intent(this, AboutActivity::class.java))
        }
    }
}
