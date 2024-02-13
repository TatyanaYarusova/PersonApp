package com.example.personapp.domain

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Person(
    val id: Int,
    val name: String,
    val dob: String,
    val img: String,
    val addressCity: String,
    val addressStreet: String,
    val latitude: String,
    val longitud: String,
    val phone: String,
    val email: String
)
