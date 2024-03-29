package com.example.personapp.data.mapper

import com.example.personapp.data.api.model.PersonDto
import com.example.personapp.data.db.PersonDbModel
import com.example.personapp.domain.Person
import java.sql.Date
import java.text.SimpleDateFormat


class PersonMapper {
    var id = 0

    fun mapDtoToDbModel(dto: PersonDto) = PersonDbModel(
        id = id++,
        name = "${dto.name.first} ${dto.name.last}",
        img = dto.picture.large!!,
        addressCity =dto.location.city,
        addressStreet ="${dto.location.street.number.toString()} ${dto.location.street.name}",
        phone = dto.phone!!,
        dob = dto.dob.date,
        email = dto.email!!,
        latitude = dto.location.coordinates.latitude,
        longitud = dto.location.coordinates.longitud
    )

    fun mapDbToEntity(db: PersonDbModel?) = Person(
        id = db?.id ?: 0,
        name = db?.name.orEmpty(),
        img = db?.img.orEmpty(),
        addressCity = db?.addressCity.orEmpty(),
        addressStreet = db?.addressStreet.orEmpty(),
        dob = convertTimestampToTime(db?.dob) ?: "",
        phone = db?.phone.orEmpty(),
        email = db?.email.orEmpty(),
        longitud = db?.longitud.orEmpty(),
        latitude = db?.latitude.orEmpty()
    )

    private fun convertTimestampToTime(timestamp: String?): String {
        try {
            val sdf = SimpleDateFormat("MM/dd/yyyy")
            val netDate = if (timestamp.isNullOrEmpty()) {
                java.util.Date()
            } else {
                val timestampLong = timestamp.toLongOrNull() ?: 0L
                Date(timestampLong * 1000)
            }
            return sdf.format(netDate)
        } catch (e: Exception) {
            return e.toString()
        }
    }


}