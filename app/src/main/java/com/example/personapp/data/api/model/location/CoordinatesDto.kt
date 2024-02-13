package com.example.personapp.data.api.model.location

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CoordinatesDto (
    @SerializedName("latitude")
    @Expose
    val latitude: String,
    @SerializedName("longitude")
    @Expose
    val longitud: String
)
