package com.example.personapp.data.api

import com.example.personapp.data.api.model.PersonListDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("https://randomuser.me/api/")
    suspend fun getPersonInfoList(
        @Query(QUERY_PARAM_RESULTS) countResults: Int = COUNT_RESULTS,
        @Query(QUERY_PARAM_INC) paramJson: String  = PARAM_JSON_INC
    ): PersonListDto

    companion object {
        private const val QUERY_PARAM_RESULTS = "results"
        private const val QUERY_PARAM_INC = "inc"


        private const val COUNT_RESULTS = 10
        private const val PARAM_JSON_INC = "name, dob, picture, email, location, phone"

    }
}