package com.example.beyond

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.beyond.adapter.NeoAdapter
import com.example.beyond.databinding.ActivityNeoBinding
import com.example.beyond.viewmodel.NeoViewModel

class NeoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNeoBinding
    private val viewModel: NeoViewModel by viewModels()
    private lateinit var adapter: NeoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNeoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = NeoAdapter()
        binding.rvNeo.layoutManager = LinearLayoutManager(this)
        binding.rvNeo.adapter = adapter

        viewModel.neoData.observe(this) { neoData ->
            val asteroids = neoData.near_earth_objects.values.flatten()
            adapter.submitList(asteroids)
        }

        binding.neoToMain.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        viewModel.fetchNeoData("AjRhpWfHEPTpt7zHHFHXdxqGlUHEQFzanRYe9y9R", "2025-02-25", "2025-02-26")
    }
}
