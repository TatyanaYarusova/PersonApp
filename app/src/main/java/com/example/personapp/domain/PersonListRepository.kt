package com.example.personapp.domain

interface PersonListRepository {
    fun getPersonList(): List<Person>

    fun getPerson(personId: Int): Person
}