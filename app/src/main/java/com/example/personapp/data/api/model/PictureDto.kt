package com.example.personapp.data.api.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PictureDto(
    @SerializedName("large")
    @Expose
    val large: String? = null,

    @SerializedName("medium")
    @Expose
    val medium: String? = null,

    @SerializedName("thumbnail")
    @Expose
    val thumbnail: String? = null
)
