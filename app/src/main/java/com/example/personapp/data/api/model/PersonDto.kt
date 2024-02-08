package com.example.personapp.data.api.model

import com.example.personapp.data.api.model.location.LocationDto
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PersonDto(
    @SerializedName("name")
    @Expose
    val name: NameDto,

    @SerializedName("location")
    @Expose
    val location: LocationDto,

    @SerializedName("email")
    @Expose
    val email: String? = null,

    @SerializedName("phone")
    @Expose
    val phone: String? = null,

    @SerializedName("picture")
    @Expose
    val picture: PictureDto
)
