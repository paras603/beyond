package com.example.beyond.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.beyond.api.RetrofitInstance
import com.example.beyond.model.ApodResponse
import kotlinx.coroutines.launch

class ApodViewModel : ViewModel() {
    private val _apodData = MutableLiveData<ApodResponse>()
    val apodData: LiveData<ApodResponse> = _apodData

    fun fetchApod(apiKey: String, date: String? = null) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getApod(apiKey, date)
                _apodData.value = response
            } catch (e: Exception) {
                Log.e("APOD_ERROR", "Failed to fetch data", e)
            }
        }
    }
}
