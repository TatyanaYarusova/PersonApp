package com.example.personapp.data

import android.app.Application
import android.view.animation.Transformation
import com.example.personapp.data.api.ApiFactory
import com.example.personapp.data.db.DataBase
import com.example.personapp.data.mapper.PersonMapper
import com.example.personapp.domain.Person
import com.example.personapp.domain.PersonListRepository

class PersonListRepositoryImpl(private val application: Application): PersonListRepository {

    private val personDao = DataBase.getInstance(application).personDao()
    private val mapper = PersonMapper()

    private val apiService = ApiFactory.apiService
    override fun getPerson(personId: Int): Person {
        return personDao.getPerson(personId)
    }

    override fun getPersonList(): List<Person> {
        return personDao.getPersonList().map {
                mapper.mapDbToEntity(it)
            }

    }

//    override fun loadDataUseCase() {

//        val personListDto = apiService.getPersonInfo()


//        if (personListDto.isSuccessful) {
//            weatherDAO.deleteWeatherNowTable()
//            weatherDAO.deleteWeatherDaysWeekTable()
//            weatherDAO.deleteWeatherHourTable()
//
//
//            val dbModelSevenList =
//                weatherSevenDto.body()?.days?.map { mapper.mapWeatherInfoSevenDaysDtoToDb(it) }
//            weatherDAO.insertWeatherSevenDayTable(dbModelSevenList)
//
//
//            val dbModelHourList =
//                weatherHourDto.body()?.days?.get(0)?.hours?.map {
//                    mapper.mapWeatherInfoHourDtoToDb(
//                        it
//                    )
//                }
//            weatherDAO.insertWeatherHourTable(dbModelHourList)
//
//            val dbModelNow =
//                mapper.mapWeatherInfoNowDtoToDb(
//                    weatherNowDto.body()!!, weatherNowDto.body()!!.currentConditions,
//                    weatherSevenDto.body()?.days?.get(0)?.tempmin ?: 0.0,
//                    weatherSevenDto.body()?.days?.get(0)?.tempmax ?: 0.0
//                )
//            weatherDAO.insertWeatherNowTable(dbModelNow)
//        }
//    }
}