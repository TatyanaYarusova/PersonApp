package com.example.personapp.domain

class GetPersonUseCase(private val personListRepository: PersonListRepository) {
    fun getPerson(personId: Int): Person{
        return personListRepository.getPerson(personId)
    }
}