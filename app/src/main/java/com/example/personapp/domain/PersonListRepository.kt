package com.example.personapp.domain

import androidx.lifecycle.LiveData

interface PersonListRepository {
    fun getPersonList(): LiveData<List<Person>>

    fun getPerson(personId: Int): LiveData<Person>

    suspend fun loadDataUseCase()
}