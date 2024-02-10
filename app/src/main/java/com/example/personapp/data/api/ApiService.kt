package com.example.personapp.data.api

import com.example.personapp.data.api.model.PersonListDto
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("https://randomuser.me/api/")
    fun getPersonInfo(
        @Query(QUERY_PARAM_RESULTS) countResults: Int = COUNT_RESULTS,
        @Query(QUERY_PARAM_INC) paramJson: String  = PARAM_JSON_INC
    ): Single<PersonListDto>

    companion object {
        private const val QUERY_PARAM_RESULTS = "results"
        private const val QUERY_PARAM_INC = "inc"


        private const val COUNT_RESULTS = 2
        private const val PARAM_JSON_INC = "name, picture, email, location, phone"

    }
}