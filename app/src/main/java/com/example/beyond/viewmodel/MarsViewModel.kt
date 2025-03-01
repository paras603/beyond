package com.example.beyond.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.beyond.api.RetrofitInstance
import com.example.beyond.model.MarsPhotoResponse
import kotlinx.coroutines.launch

class MarsViewModel : ViewModel() {
    private val _marsPhotos = MutableLiveData<MarsPhotoResponse>()
    val marsPhotos: LiveData<MarsPhotoResponse> = _marsPhotos

    fun fetchMarsPhotos(apiKey: String, earthDate: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getMarsPhotos(apiKey, earthDate)
                _marsPhotos.value = response
            } catch (e: Exception) {
                Log.e("MARS_ERROR", "Failed to fetch data", e)
            }
        }
    }
}
