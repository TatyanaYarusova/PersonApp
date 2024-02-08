package com.example.personapp.domain

class GetPersonListUseCase(private val personListRepository: PersonListRepository) {
    fun getPersonList(): List<Person>{
        return personListRepository.getPersonList()
    }
}