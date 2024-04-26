package com.example.personapp.kaspresso.screen

import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.screen.Screen
import com.example.personapp.R
import io.github.kakaocup.kakao.text.KTextView

object PersonInfoScreen: Screen<PersonInfoScreen>() {

    val image = KImageView { withId(R.id.imagePerson) }
    val name = KTextView { withId(R.id.nameInfoText) }
    val dob = KTextView { withId(R.id.dobText) }
    val addressCity = KTextView { withId(R.id.addressCityText) }
    val addressStreet = KTextView { withId(R.id.addressStreetText) }
    val mail = KTextView { withId(R.id.emailInfoText) }
    val phone = KTextView { withId(R.id.phoneInfoText) }

}