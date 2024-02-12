package com.example.personapp.domain

class LoadDataUseCase (private val personListRepository: PersonListRepository) {
    suspend operator fun invoke() = personListRepository.loadDataUseCase()
}