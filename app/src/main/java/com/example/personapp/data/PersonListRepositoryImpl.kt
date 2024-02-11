package com.example.personapp.data

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.asFlow
import androidx.lifecycle.asLiveData
import com.example.personapp.data.api.ApiFactory
import com.example.personapp.data.db.DataBase
import com.example.personapp.data.mapper.PersonMapper
import com.example.personapp.domain.Person
import com.example.personapp.domain.PersonListRepository
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.flow.map

class PersonListRepositoryImpl(application: Application): PersonListRepository {

    private val personDao = DataBase.getInstance(application).personDao()
    private val mapper = PersonMapper()
    private val apiService = ApiFactory.apiService


    override fun getPerson(ID: Int): LiveData<Person> {
        return personDao.getPerson(ID).asFlow()
            .map { mapper.mapDbToEntity(it) }
            .asLiveData()
    }

    override fun getPersonList(): LiveData<List<Person>> {
        return personDao.getPersonList().asFlow()
            .map {
                it.map {
                    mapper.mapDbToEntity(it)
                }
            }
            .asLiveData()
    }


    override suspend fun loadDataUseCase() {
        val personInfoList = apiService.getPersonInfoList()
        val dbModelList = personInfoList.persons.map {
            mapper.mapDtoToDbModel(it)
        }
        personDao.insertPersonList(dbModelList)
    }
}