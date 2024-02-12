package com.example.personapp.data.api.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DobDto(
    @SerializedName("date")
    @Expose
    val date: String
)
