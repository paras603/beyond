package com.example.beyond

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.beyond.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Add any dynamic content or functionality here if necessary
    }
}
