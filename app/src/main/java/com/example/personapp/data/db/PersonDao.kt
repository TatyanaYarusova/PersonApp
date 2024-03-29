package com.example.personapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface PersonDao {
    @Query("SELECT * FROM person_table")
    fun getPersonList(): LiveData<List<PersonDbModel>>
    @Query("SELECT COUNT(*) FROM person_table")
    fun getCountPerson(): Int

    @Query("SELECT * FROM person_table WHERE id == :ID LIMIT 1")
    fun getPerson(ID: Int): LiveData<PersonDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPersonList(personListDb: List<PersonDbModel> )


    @Query("DELETE FROM person_table WHERE id != -1 ")
    fun deletePersonList()
}