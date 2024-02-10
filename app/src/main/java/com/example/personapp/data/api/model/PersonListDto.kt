package com.example.personapp.data.api.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PersonListDto(
    @SerializedName("results")
    @Expose
    val persons :List<PersonDto>
)
