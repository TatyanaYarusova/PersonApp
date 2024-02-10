package com.example.personapp.data.api.model.location

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class StreetDto (
    @SerializedName("number")
    @Expose
    val number: Int? = null,

    @SerializedName("name")
    @Expose
    val name: String? = null
)
