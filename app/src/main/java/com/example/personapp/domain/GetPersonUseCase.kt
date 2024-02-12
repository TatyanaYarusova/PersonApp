package com.example.personapp.domain

class GetPersonUseCase(private val personListRepository: PersonListRepository) {
    operator fun invoke(personId: Int) = personListRepository.getPerson(personId)
}