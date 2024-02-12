package com.example.personapp.domain

class GetPersonListUseCase(private val personListRepository: PersonListRepository) {
    operator fun invoke() = personListRepository.getPersonList()

}