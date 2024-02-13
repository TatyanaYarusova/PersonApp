package com.example.personapp.data.api.model.location

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LocationDto(
    @SerializedName("street")
    @Expose
    val street: StreetDto,

    @SerializedName("city")
    @Expose
    val city: String,

    @SerializedName("coordinates")
    @Expose
    val coordinates: CoordinatesDto
)
