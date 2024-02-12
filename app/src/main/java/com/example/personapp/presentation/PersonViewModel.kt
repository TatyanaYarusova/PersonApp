package com.example.personapp.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.personapp.data.PersonListRepositoryImpl
import com.example.personapp.domain.GetPersonListUseCase
import com.example.personapp.domain.GetPersonUseCase
import com.example.personapp.domain.LoadDataUseCase
import kotlinx.coroutines.launch


class PersonViewModel(application: Application) : AndroidViewModel(application) {

    private val repo = PersonListRepositoryImpl(application)

    private val getPersonListUseCase = GetPersonListUseCase(repo)
    private val getPersonUseCase = GetPersonUseCase(repo)
    private val loadDataUseCase = LoadDataUseCase(repo)

    val personList = getPersonListUseCase()

    fun getPersonInfo(personId: Int) = getPersonUseCase(personId)

    init {
        viewModelScope.launch {
            loadDataUseCase()
        }
    }

}