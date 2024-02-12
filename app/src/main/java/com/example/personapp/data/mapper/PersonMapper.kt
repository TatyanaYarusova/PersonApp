package com.example.personapp.data.mapper

import com.example.personapp.data.api.model.PersonDto
import com.example.personapp.data.api.model.PersonListDto
import com.example.personapp.data.db.PersonDbModel
import com.example.personapp.domain.Person
import java.sql.Date
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone

class PersonMapper {
    var id = 0

    fun mapDtoToDbModel(dto: PersonDto) = PersonDbModel(
        id = id++,
        name = "${dto.name.first} ${dto.name.last}",
        img = dto.picture.large!!,
        addressCity =dto.location.city.toString(),
        addressStreet ="${dto.location.street.number.toString()} ${dto.location.street.name}",
        phone = dto.phone!!,
        dob = dto.dob.date,
        email = dto.email!!
    )

    fun mapDbToEntity(db: PersonDbModel) = Person(
        id = db.id,
        name = db.name,
        img = db.img,
        addressCity = db.addressCity,
        addressStreet = db.addressStreet,
        dob = convertTimestampToTime(db.dob),
        phone = db.phone,
        email = db.email
    )

    private fun convertTimestampToTime(timestamp: String?): String {
        try {
            val sdf = SimpleDateFormat("MM/dd/yyyy")
            val netDate = if (timestamp.isNullOrEmpty()) {
                java.util.Date()
            } else {
                val timestampLong = timestamp?.toLongOrNull() ?: 0L
                Date(timestampLong * 1000)
            }
            return sdf.format(netDate)
        } catch (e: Exception) {
            return e.toString()
        }
    }


}