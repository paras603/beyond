package com.example.beyond

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.beyond.adapter.MarsAdapter
import com.example.beyond.databinding.ActivityMarsBinding
import com.example.beyond.viewmodel.MarsViewModel

class MarsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMarsBinding
    private val viewModel: MarsViewModel by viewModels()
    private lateinit var adapter: MarsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMarsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = MarsAdapter()
        binding.rvMars.layoutManager = LinearLayoutManager(this)
        binding.rvMars.adapter = adapter

        viewModel.marsPhotos.observe(this) { marsData ->
            adapter.submitList(marsData.photos)
        }

        viewModel.fetchMarsPhotos("AjRhpWfHEPTpt7zHHFHXdxqGlUHEQFzanRYe9y9R", "2025-02-25")
    }
}
