package com.example.personapp.data.db

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "person_table")
data class PersonDbModel(
    @PrimaryKey
    val id: Int = UNDEFINED_ID,

    val name: String,
    val img: String,
    val address: String,
    val phone: String,
    val email: String
) {
  companion object{
      const val  UNDEFINED_ID = -1
  }
}