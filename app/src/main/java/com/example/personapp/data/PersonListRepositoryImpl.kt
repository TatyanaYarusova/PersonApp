package com.example.personapp.data

import com.example.personapp.domain.Person
import com.example.personapp.domain.PersonListRepository

object PersonListRepositoryImpl: PersonListRepository {

    override fun getPerson(personId: Int): Person {
        TODO("Not yet implemented")
    }

    override fun getPersonList(): List<Person> {
        TODO("Not yet implemented")
    }
}