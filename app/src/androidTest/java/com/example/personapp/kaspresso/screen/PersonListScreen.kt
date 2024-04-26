package com.example.personapp.kaspresso.screen

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.screen.Screen
import org.hamcrest.Matcher
import com.example.personapp.R
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView


object PersonListScreen: Screen<PersonListScreen>() {

    val personListView = KRecyclerView(
        builder = { withId(R.id.rvPersonList) },
        itemTypeBuilder = { itemType(::PersonItem) }
    )

    val buttonUpdate = KButton { withId(R.id.buttonUpdate) }

    class PersonItem(parent: Matcher<View>): KRecyclerItem<PersonItem>(parent) {
        val image = KImageView(parent) { withId(R.id.imgPerson) }
        val name = KTextView(parent) { withId(R.id.nameText) }
        val address = KTextView(parent) { withId(R.id.addressText) }
        val mail = KTextView(parent) { withId(R.id.emailText) }
        val phone = KTextView(parent) { withId(R.id.phoneText) }
    }


}