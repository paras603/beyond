package com.example.beyond.api

import com.example.beyond.model.ApodResponse
import com.example.beyond.model.MarsPhotoResponse
import com.example.beyond.model.NeoResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NasaApiService {

    // Astronomy Picture of the Day (APOD)
    @GET("planetary/apod")
    suspend fun getApod(
        @Query("api_key") apiKey: String,
        @Query("date") date: String? = null // Optional date
    ): ApodResponse

    // Mars Rover Photos
    @GET("mars-photos/api/v1/rovers/curiosity/photos")
    suspend fun getMarsPhotos(
        @Query("api_key") apiKey: String,
        @Query("earth_date") earthDate: String
    ): MarsPhotoResponse

    // Near-Earth Object (NEO) Tracker
    @GET("neo/rest/v1/feed")
    suspend fun getNeoFeed(
        @Query("api_key") apiKey: String,
        @Query("start_date") startDate: String,
        @Query("end_date") endDate: String
    ): NeoResponse
}
