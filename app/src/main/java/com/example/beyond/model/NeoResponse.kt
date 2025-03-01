package com.example.beyond.model

data class NeoResponse(
    val near_earth_objects: Map<String, List<Neo>>  // A map of dates to lists of NEOs
)

data class Neo(
    val id: String,
    val name: String,  // Name of the Near-Earth Object
    val nasa_jpl_url: String,  // URL for more information about the NEO
    val absolute_magnitude_h: Double,  // Measure of the NEO's size
    val estimated_diameter: EstimatedDiameter  // Estimated size of the NEO
)

data class EstimatedDiameter(
    val kilometers: Diameters  // Estimated diameter in kilometers
)

data class Diameters(
    val estimated_diameter_max: Double  // Maximum diameter in kilometers
)
