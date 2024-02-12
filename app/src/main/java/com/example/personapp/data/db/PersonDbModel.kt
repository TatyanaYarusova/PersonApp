package com.example.personapp.data.db

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.room.Entity
import androidx.room.PrimaryKey
import javax.annotation.processing.Generated

@Entity(tableName = "person_table")
data class PersonDbModel(
    @PrimaryKey
    val id: Int = UNDEFINED_ID ,
    val name: String,
    val dob: String,
    val img: String,
    val addressCity: String,
    val addressStreet: String,
    val phone: String,
    val email: String
) {
  companion object{
      const val  UNDEFINED_ID = -1
  }
}