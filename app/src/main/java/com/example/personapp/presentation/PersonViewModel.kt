package com.example.personapp.presentation

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.example.personapp.data.api.ApiFactory
import com.example.personapp.data.db.DataBase
import com.example.personapp.data.mapper.PersonMapper
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers

class PersonViewModel(application: Application) : AndroidViewModel(application) {
    private val db = DataBase.getInstance(application)
    private val compositeDisposable = CompositeDisposable()
    private val mapper = PersonMapper()


    val personList = db.personDao().getPersonList()

    init {
        loadData()
    }

    private fun loadData() {
        val disposable = ApiFactory.apiService.getPersonInfo()
            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                db.personDao().insertPersonList(it.persons.map { mapper.mapDtoToDbModel(it) })
                Log.d("TEST_OF_LOADING_DATA", "Success: ${it.persons}")
            }, {
                Log.d("TEST_OF_LOADING_DATA", "Failure: ${it.message}")
            })
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}