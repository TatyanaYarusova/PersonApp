package com.example.personapp.data.mapper

import com.example.personapp.data.api.model.PersonDto
import com.example.personapp.data.api.model.PersonListDto
import com.example.personapp.data.db.PersonDbModel
import com.example.personapp.domain.Person

class PersonMapper {
    var id = 0

    fun mapDtoToDbModel(dto: PersonDto) = PersonDbModel(
        id = id++,
        name = "${dto.name.title} ${dto.name.first} ${dto.name.last}",
        img = dto.picture.large!!,
        address ="${dto.location.street.number.toString()} ${dto.location.street.name}",
        phone = dto.phone!!,
        email = dto.email!!
    )

    fun mapDbToEntity(db: PersonDbModel) = Person(
        id = db.id,
        name = db.name,
        img = db.img,
        address = db.address,
        phone = db.phone,
        email = db.email
    )


}