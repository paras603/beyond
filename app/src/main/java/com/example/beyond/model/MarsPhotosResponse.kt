package com.example.beyond.model

data class MarsPhotoResponse(
    val photos: List<MarsPhoto>
)

data class MarsPhoto(
    val id: Int,
    val img_src: String,  // Image URL
    val earth_date: String,  // Date when the photo was taken
    val rover: Rover,  // Rover details
    val camera: Camera   // Camera details
)

data class Rover(
    val name: String  // Rover name (e.g., Curiosity, Perseverance)
)

data class Camera(
    val full_name: String  // Full name of the camera (e.g., MastCam)
)