package com.example.personapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.personapp.data.api.model.PersonDto
import com.example.personapp.domain.Person

@Dao
interface PersonDao {
    @Query("SELECT * FROM person_table ORDER BY id ASC")
    fun getPersonList(): List<PersonDbModel>

    @Query("SELECT * FROM person_table WHERE id == :ID LIMIT 1")
    fun getPerson(ID: Int): Person

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPersonList(personList: List<PersonDto> )
}