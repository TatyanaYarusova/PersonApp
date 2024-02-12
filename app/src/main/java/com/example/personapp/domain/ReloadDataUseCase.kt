package com.example.personapp.domain

class ReloadDataUseCase(private val personListRepository: PersonListRepository) {
    suspend operator fun invoke() = personListRepository.reloadDataUseCase()
}