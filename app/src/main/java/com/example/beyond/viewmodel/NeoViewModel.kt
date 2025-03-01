package com.example.beyond.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.beyond.api.RetrofitInstance
import com.example.beyond.model.NeoResponse
import kotlinx.coroutines.launch

class NeoViewModel : ViewModel() {
    private val _neoData = MutableLiveData<NeoResponse>()
    val neoData: LiveData<NeoResponse> = _neoData

    fun fetchNeoData(apiKey: String, startDate: String, endDate: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getNeoFeed(apiKey, startDate, endDate)
                _neoData.value = response
            } catch (e: Exception) {
                Log.e("NEO_ERROR", "Failed to fetch data", e)
            }
        }
    }
}
