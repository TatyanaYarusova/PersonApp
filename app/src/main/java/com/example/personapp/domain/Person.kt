package com.example.personapp.domain

data class Person(
    val id: Int,
    val name: String,
    val dob: String,
    val img: String,
    val addressCity: String,
    val addressStreet: String,
    val phone: String,
    val email: String
)
