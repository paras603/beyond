package com.example.beyond

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.beyond.databinding.ActivityApodBinding
import com.example.beyond.viewmodel.ApodViewModel

class ApodActivity : AppCompatActivity() {

    private lateinit var binding: ActivityApodBinding
    private val viewModel: ApodViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityApodBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.apodData.observe(this) { apod ->
            binding.tvTitle.text = apod.title
            binding.tvDescription.text = apod.explanation
            Glide.with(this).load(apod.url).into(binding.ivApod)
        }

        binding.backToMain.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        viewModel.fetchApod("AjRhpWfHEPTpt7zHHFHXdxqGlUHEQFzanRYe9y9R")
    }
}
