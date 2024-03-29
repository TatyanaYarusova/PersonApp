package com.example.personapp.data.api.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class NameDto(

    @SerializedName("first")
    @Expose
    val first: String? = null,

    @SerializedName("last")
    @Expose
    val last: String? = null
)
